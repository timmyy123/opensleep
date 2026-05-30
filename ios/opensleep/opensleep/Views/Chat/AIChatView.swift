import SwiftUI
import SwiftData

struct AIChatView: View {
    @ObservedObject var liteRt: LiteRtManager
    @ObservedObject var downloadManager: ModelDownloadManager
    @Query(sort: \SleepSession.startDate, order: .reverse) private var sessions: [SleepSession]
    @Query(sort: \ChatMessage.timestamp, order: .forward) private var allMessages: [ChatMessage]

    @State private var inputText = ""
    @State private var streamingText = ""
    @State private var isGenerating = false
    @State private var scrollProxy: ScrollViewProxy?

    private let chatSessionId: String = {
        let fmt = DateFormatter()
        fmt.dateFormat = "yyyy-MM-dd"
        return fmt.string(from: Date())
    }()

    @Environment(\.modelContext) private var modelContext

    private var messages: [ChatMessage] {
        allMessages.filter { $0.sessionId == chatSessionId }
    }

    var body: some View {
        ZStack {
            Color.navyDeep.ignoresSafeArea()
            VStack(spacing: 0) {
                // Header
                chatHeader

                // Removed model picker

                // Messages
                ScrollViewReader { proxy in
                    ScrollView {
                        LazyVStack(spacing: 8) {
                            ForEach(messages) { msg in
                                ChatBubbleView(message: msg)
                                    .id(msg.id)
                            }
                            if !streamingText.isEmpty {
                                ChatBubbleView(isUser: false, text: streamingText, isStreaming: true)
                                    .id("streaming")
                            }
                            if isGenerating && streamingText.isEmpty {
                                HStack(spacing: 8) {
                                    ProgressView()
                                        .progressViewStyle(.circular)
                                        .tint(Color.indigoAccent)
                                        .scaleEffect(0.7)
                                    Text(liteRt.state == .loading ? LocalizedStringKey("chat_loading") : LocalizedStringKey("chat_thinking"))
                                        .font(AppTextStyle.bodyMedium)
                                        .foregroundStyle(Color.textSecondary)
                                    Spacer()
                                }
                                .padding(.horizontal, 16)
                                .id("thinking")
                            }
                            Color.clear.frame(height: 8).id("bottom")
                        }
                        .padding(.horizontal, 12)
                        .padding(.top, 8)
                        .contentShape(Rectangle())
                        .onTapGesture {
                            UIApplication.shared.sendAction(#selector(UIResponder.resignFirstResponder), to: nil, from: nil, for: nil)
                        }
                    }
                    .scrollDismissesKeyboard(.interactively)
                    .onChange(of: messages.count) { _, _ in
                        withAnimation { proxy.scrollTo("bottom") }
                    }
                    .onChange(of: streamingText) { _, _ in
                        proxy.scrollTo("streaming", anchor: .bottom)
                    }
                }

                // Input bar
                inputBar
            }
            .animation(.spring(response: 0.4, dampingFraction: 0.8), value: liteRt.state)
        }
    }

    private var chatHeader: some View {
        HStack(spacing: 12) {
            ZStack {
                Circle()
                    .fill(LinearGradient(colors: [.purpleGlow, .indigoAccent],
                                        startPoint: .topLeading, endPoint: .bottomTrailing))
                    .frame(width: 36, height: 36)
                Image(systemName: "sparkles")
                    .font(.system(size: 18))
                    .foregroundStyle(.white)
            }
            VStack(alignment: .leading, spacing: 2) {
                Text("ai_chat_title")
                    .font(.system(size: 18, weight: .bold))
                    .foregroundStyle(Color.textPrimary)
                Group {
                    if liteRt.state == .ready {
                        Text(downloadManager.downloadStates.first(where: { $0.value == .done })?.key.displayName ?? "")
                            .foregroundStyle(Color.cyanAccent)
                    } else {
                        Text("no_model_loaded")
                            .foregroundStyle(Color.textSecondary)
                    }
                }
                .font(AppTextStyle.labelSmall)
            }
            Spacer()
        }
        .padding(.horizontal, 16)
        .padding(.vertical, 12)
    }



    private var inputBar: some View {
        HStack(alignment: .bottom, spacing: 8) {
            TextField("chat_placeholder", text: $inputText, axis: .vertical)
                .lineLimit(1...4)
                .padding(12)
                .background(Color.surfaceVariant)
                .clipShape(RoundedRectangle(cornerRadius: 20, style: .continuous))
                .foregroundStyle(Color.textPrimary)
                .tint(Color.indigoAccent)

            Button {
                sendMessage()
            } label: {
                Image(systemName: "arrow.up")
                    .font(.system(size: 18, weight: .semibold))
                    .foregroundStyle(.white)
                    .frame(width: 44, height: 44)
                    .background(inputText.isBlank ? Color.surfaceVariant : Color.indigoAccent)
                    .clipShape(Circle())
            }
            .disabled(inputText.isBlank || isGenerating)
        }
        .padding(.horizontal, 12)
        .padding(.vertical, 8)
        .background(Color.navyDeep)
    }

    private func sendMessage() {
        let text = inputText.trimmingCharacters(in: .whitespacesAndNewlines)
        guard !text.isEmpty, !isGenerating else { return }

        let variantToLoad = downloadManager.activeVariant ?? ModelVariant.allCases.first(where: { downloadManager.isDownloaded($0) })
        guard let variant = variantToLoad else { return }

        inputText = ""

        let userMsg = ChatMessage(sessionId: chatSessionId, role: .user, content: text)
        modelContext.insert(userMsg)
        try? modelContext.save()

        isGenerating = true
        streamingText = ""

        Task {
            if liteRt.state != .ready {
                let contextSize = downloadManager.contextWindowSizes[variant] ?? 4096
                await liteRt.loadModel(at: downloadManager.modelPath(variant), contextSize: contextSize)
                if case .error = liteRt.state {
                    isGenerating = false
                    return
                }
            }

            let systemPrompt = buildSystemPrompt()
            let history = messages.dropLast().map { (role: $0.role, content: $0.content) }

            var response = ""
            let stream = liteRt.sendMessage(
                history: history,
                newMessage: text,
                systemPrompt: systemPrompt
            )
            for await chunk in stream {
                streamingText += chunk
                response = streamingText
            }

            if !response.isEmpty {
                let assistantMsg = ChatMessage(sessionId: chatSessionId, role: .assistant, content: response)
                modelContext.insert(assistantMsg)
                try? modelContext.save()
            }
            streamingText = ""
            isGenerating = false
        }
    }

    private func buildSystemPrompt() -> String {
        let recentSessions = Array(sessions.filter(\.isCompleted).prefix(3))
        let sleepContext: String
        if recentSessions.isEmpty {
            sleepContext = "The user has no recorded sleep data yet."
        } else {
            var ctx = "User's recent sleep data:\n"
            let fmt = DateFormatter()
            fmt.dateFormat = "EEE, MMM d"
            for s in recentSessions {
                let h = Int(s.durationSeconds / 3600)
                let m = Int((s.durationSeconds.truncatingRemainder(dividingBy: 3600)) / 60)
                let durations = s.stageDurations
                ctx += "- \(fmt.string(from: s.startDate)): \(h)h \(m)m total | "
                ctx += "Deep: \(Int((durations[.deep] ?? 0) / 60))m | "
                ctx += "REM: \(Int((durations[.rem] ?? 0) / 60))m | "
                ctx += "Light: \(Int((durations[.light] ?? 0) / 60))m | "
                ctx += "Awake: \(Int((durations[.awake] ?? 0) / 60))m\n"
            }
            sleepContext = ctx
        }

        let dateStr = Date().formatted(date: .complete, time: .omitted)
        return """
You are a knowledgeable, empathetic sleep coach assistant built into the OpenSleep app.
You help users understand and improve their sleep based on their actual tracked data.
Keep responses concise and practical. Today: \(dateStr)

\(sleepContext)
"""
    }
}

// MARK: - Chat Bubble

struct ChatBubbleView: View {
    var message: ChatMessage? = nil
    var isUser: Bool = true
    var text: String = ""
    var isStreaming: Bool = false

    private var content: String { message?.content ?? text }
    private var isUserMsg: Bool { message != nil ? message!.role == .user : isUser }

    var body: some View {
        HStack {
            if isUserMsg {
                Spacer(minLength: 60)
                Text(content)
                    .font(AppTextStyle.bodyLarge)
                    .foregroundStyle(Color.textPrimary)
                    .padding(.horizontal, 16)
                    .padding(.vertical, 10)
                    .background(Color.indigoAccent.opacity(0.85))
                    .clipShape(RoundedRectangle(cornerRadius: 20, style: .continuous))
            } else {
                Text(isStreaming ? "\(content)▌" : content)
                    .font(AppTextStyle.bodyLarge)
                    .foregroundStyle(Color.textPrimary)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding(.vertical, 8)
                    .lineSpacing(4)
            }
        }
    }
}



// MARK: - Helpers

extension String {
    var isBlank: Bool { trimmingCharacters(in: .whitespacesAndNewlines).isEmpty }
}
