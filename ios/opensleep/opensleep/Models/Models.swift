import Foundation
import SwiftData
import SwiftUI

// MARK: - Sleep Stage

enum SleepStageType: String, Codable, CaseIterable {
    case awake = "awake"
    case light = "light"
    case deep = "deep"
    case rem = "rem"

    var displayName: LocalizedStringKey {
        switch self {
        case .awake: return "stage_awake"
        case .light: return "stage_light"
        case .deep:  return "stage_deep"
        case .rem:   return "stage_rem"
        }
    }
}

struct SleepStage: Codable, Identifiable {
    var id: UUID = UUID()
    var type: SleepStageType
    var startDate: Date
    var endDate: Date
    var durationSeconds: TimeInterval { endDate.timeIntervalSince(startDate) }
}

// MARK: - Sleep Session

@Model
class SleepSession {
    @Attribute(.unique) var id: UUID
    var startDate: Date
    var endDate: Date?
    var stagesData: Data  // Encoded [SleepStage]
    var syncedToHealthKit: Bool

    init(startDate: Date = Date()) {
        self.id = UUID()
        self.startDate = startDate
        self.endDate = nil
        self.stagesData = Data()
        self.syncedToHealthKit = false
    }

    var stages: [SleepStage] {
        get { (try? JSONDecoder().decode([SleepStage].self, from: stagesData)) ?? [] }
        set { stagesData = (try? JSONEncoder().encode(newValue)) ?? Data() }
    }

    var durationSeconds: TimeInterval {
        (endDate ?? Date()).timeIntervalSince(startDate)
    }

    var stageDurations: [SleepStageType: TimeInterval] {
        Dictionary(grouping: stages, by: \.type)
            .mapValues { stages in stages.reduce(0) { $0 + $1.durationSeconds } }
    }

    var isCompleted: Bool { endDate != nil }
}

// MARK: - Chat Message

enum ChatRole: String, Codable { case user, assistant }

@Model
class ChatMessage {
    @Attribute(.unique) var id: UUID
    var sessionId: String
    var role: ChatRole
    var content: String
    var timestamp: Date

    init(sessionId: String, role: ChatRole, content: String) {
        self.id = UUID()
        self.sessionId = sessionId
        self.role = role
        self.content = content
        self.timestamp = Date()
    }
}
