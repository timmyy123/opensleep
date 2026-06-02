import Foundation
import Combine

#if canImport(LiteRTLM)
import LiteRTLM
#endif

enum LiteRtState: Equatable {
    case unloaded
    case loading
    case ready
    case error(String)
}

#if canImport(LiteRTLM)
// Using real LiteRT-LM framework implementation
class LiteRtManager: ObservableObject {

    @MainActor @Published var state: LiteRtState = .unloaded

    private var engine: Engine?
    private var currentPath: String?

    @MainActor
    func loadModel(at path: String, contextSize: Int) async {
        if currentPath == path, state == .ready { return }

        state = .loading
        engine = nil

        do {
            ExperimentalFlags.optIntoExperimentalAPIs()
            ExperimentalFlags.enableSpeculativeDecoding = true

            let config = try EngineConfig(
                modelPath: path,
                backend: .gpu,
                visionBackend: nil,
                audioBackend: nil,
                maxNumTokens: contextSize
            )
            let e = Engine(engineConfig: config)
            try await e.initialize()
            engine = e
            currentPath = path
            state = .ready
        } catch {
            state = .error(error.localizedDescription)
        }
    }

    @MainActor
    func sendMessage(
        history: [(role: ChatRole, content: String)],
        newMessage: String,
        systemPrompt: String
    ) -> AsyncStream<String> {
        AsyncStream { continuation in
            Task {
                guard let engine else {
                    continuation.finish()
                    return
                }
                do {
                    var initialMessages = [Message]()
                    for (role, content) in history.dropLast() {
                        let msgRole: Role = (role == .user) ? .user : .model
                        initialMessages.append(Message(content, role: msgRole))
                    }
                    let sysMsg = systemPrompt.isEmpty ? nil : Message(systemPrompt, role: .system)
                    let convConfig = ConversationConfig(systemMessage: sysMsg, initialMessages: initialMessages)
                    let conversation = try await engine.createConversation(with: convConfig)

                    let stream = try await conversation.sendMessageStream(Message(newMessage))
                    for try await chunk in stream {
                        continuation.yield(chunk.toString)
                    }
                    continuation.finish()
                } catch {
                    continuation.yield("[Error: \(error.localizedDescription)]")
                    continuation.finish()
                }
            }
        }
    }

    @MainActor
    func isLoaded() -> Bool { state == .ready }

    @MainActor
    func unload() {
        engine = nil
        currentPath = nil
        state = .unloaded
    }
}
#else
// Graceful fallback mock if SPM dependency is not yet added in Xcode
class LiteRtManager: ObservableObject {

    @MainActor @Published var state: LiteRtState = .unloaded
    private var currentPath: String?

    @MainActor
    func loadModel(at path: String, contextSize: Int) async {
        if currentPath == path, state == .ready { return }
        state = .loading
        try? await Task.sleep(nanoseconds: 1_000_000_000) // simulated load time
        currentPath = path
        state = .ready
    }

    @MainActor
    func sendMessage(
        history: [(role: ChatRole, content: String)],
        newMessage: String,
        systemPrompt: String
    ) -> AsyncStream<String> {
        AsyncStream { continuation in
            Task {
                try? await Task.sleep(nanoseconds: 500_000_000)
                let sampleChunks = [
                    "Isso é uma simulação de resposta porque a dependência do framework LiteRT-LM ainda não foi adicionada no Xcode.\n\n",
                    "Por favor, siga estas etapas para adicionar o pacote real:\n",
                    "1. No Xcode, selecione **File > Add Package Dependencies...**\n",
                    "2. Insira a URL: `https://github.com/google-ai-edge/LiteRT-LM`\n",
                    "3. Selecione o produto **LiteRTLM** e adicione-o ao seu target **opensleep**."
                ]
                for chunk in sampleChunks {
                    continuation.yield(chunk)
                    try? await Task.sleep(nanoseconds: 100_000_000)
                }
                continuation.finish()
            }
        }
    }

    @MainActor
    func isLoaded() -> Bool { state == .ready }
    @MainActor
    func unload() {
        currentPath = nil
        state = .unloaded
    }
}
#endif
