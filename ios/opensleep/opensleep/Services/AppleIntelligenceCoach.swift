import Foundation
import Combine
import FoundationModels

enum AppleIntelligenceAvailability: Equatable {
    case available
    case notEnabled
    case modelNotReady
    case unsupported
}

/// Sleep coach backend that runs on Apple's built-in on-device Foundation Model.
class AppleIntelligenceCoach: ObservableObject {

    @MainActor @Published private(set) var availability: AppleIntelligenceAvailability = .unsupported

    /// Apple's on-device model has a fixed context window.
    static let contextSize = 4096

    init() {
        Task { @MainActor [weak self] in
            self?.refreshAvailability()
        }
    }

    /// The user can turn Apple Intelligence on/off or the model can finish downloading at any time,
    /// so re-check whenever a screen that depends on it appears.
    @MainActor
    func refreshAvailability() {
        switch SystemLanguageModel.default.availability {
        case .available:
            availability = .available
        case .unavailable(.appleIntelligenceNotEnabled):
            availability = .notEnabled
        case .unavailable(.modelNotReady):
            availability = .modelNotReady
        case .unavailable:
            availability = .unsupported
        }
    }

    /// True when the device supports Apple Intelligence, even if it is turned off or still downloading.
    @MainActor
    var isSupportedDevice: Bool { availability != .unsupported }

    @MainActor
    var isAvailable: Bool { availability == .available }

    @MainActor
    func sendMessage(
        history: [(role: ChatRole, content: String)],
        newMessage: String,
        systemPrompt: String
    ) -> AsyncStream<String> {
        AsyncStream { continuation in
            Task {
                var entries: [Transcript.Entry] = []
                if !systemPrompt.isEmpty {
                    entries.append(.instructions(Transcript.Instructions(
                        segments: [.text(Transcript.TextSegment(content: systemPrompt))],
                        toolDefinitions: []
                    )))
                }
                for (role, content) in history {
                    let segment = Transcript.Segment.text(Transcript.TextSegment(content: content))
                    switch role {
                    case .user:
                        entries.append(.prompt(Transcript.Prompt(segments: [segment])))
                    case .assistant:
                        entries.append(.response(Transcript.Response(assetIDs: [], segments: [segment])))
                    }
                }
                let session = LanguageModelSession(transcript: Transcript(entries: entries))

                do {
                    // Snapshots are cumulative; forward only the newly generated text.
                    var emitted = ""
                    for try await snapshot in session.streamResponse(to: newMessage) {
                        let text = snapshot.content
                        if text.hasPrefix(emitted) {
                            let delta = String(text.dropFirst(emitted.count))
                            if !delta.isEmpty { continuation.yield(delta) }
                        }
                        emitted = text
                    }
                    continuation.finish()
                } catch {
                    continuation.yield("[Error: \(error.localizedDescription)]")
                    continuation.finish()
                }
            }
        }
    }
}
