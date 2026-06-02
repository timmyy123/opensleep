import Foundation
import HealthKit
import Combine
import SwiftData

class HealthKitManager: ObservableObject {

    private let store = HKHealthStore()

    static let writeTypes: Set<HKSampleType> = [
        HKObjectType.categoryType(forIdentifier: .sleepAnalysis)!
    ]
    static let readTypes: Set<HKObjectType> = [
        HKObjectType.categoryType(forIdentifier: .sleepAnalysis)!
    ]

    var isAvailable: Bool { HKHealthStore.isHealthDataAvailable() }

    func requestAuthorization() async -> Bool {
        guard isAvailable else { return false }
        do {
            try await store.requestAuthorization(toShare: Self.writeTypes, read: Self.readTypes)
            return true
        } catch {
            return false
        }
    }

    func writeSleepSession(_ session: SleepSession) async -> Bool {
        guard isAvailable else { return false }
        guard let endDate = session.endDate else { return false }

        var samples: [HKCategorySample] = []

        let stages = session.stages
        if stages.isEmpty {
            // Write a plain sleep record if no stage data yet
            let sleepType = HKObjectType.categoryType(forIdentifier: .sleepAnalysis)!
            samples.append(
                HKCategorySample(
                    type: sleepType,
                    value: HKCategoryValueSleepAnalysis.asleepUnspecified.rawValue,
                    start: session.startDate,
                    end: endDate
                )
            )
        } else {
            let sleepType = HKObjectType.categoryType(forIdentifier: .sleepAnalysis)!
            for stage in stages {
                let value = stage.type.healthKitValue
                samples.append(
                    HKCategorySample(
                        type: sleepType,
                        value: value.rawValue,
                        start: stage.startDate,
                        end: stage.endDate
                    )
                )
            }
        }

        do {
            try await store.save(samples)
            return true
        } catch {
            return false
        }
    }

    func deleteSleepSession(_ session: SleepSession) async -> Bool {
        guard isAvailable else { return false }
        guard let endDate = session.endDate else { return false }

        let sleepType = HKObjectType.categoryType(forIdentifier: .sleepAnalysis)!
        let predicate = HKQuery.predicateForSamples(withStart: session.startDate, end: endDate, options: [])

        do {
            let samples = try await withCheckedThrowingContinuation { (continuation: CheckedContinuation<[HKSample], Error>) in
                let query = HKSampleQuery(sampleType: sleepType, predicate: predicate, limit: HKObjectQueryNoLimit, sortDescriptors: nil) { _, results, error in
                    if let error = error {
                        continuation.resume(throwing: error)
                    } else {
                        continuation.resume(returning: results ?? [])
                    }
                }
                store.execute(query)
            }

            if !samples.isEmpty {
                try await store.delete(samples)
            }
            return true
        } catch {
            print("Failed to delete HealthKit sleep samples: \(error)")
            return false
        }
    }

    // Track deleted session start times to prevent re-importing from HealthKit
    private var deletedSessionStartTimes: [TimeInterval] {
        get {
            UserDefaults.standard.array(forKey: "deleted_session_start_times") as? [TimeInterval] ?? []
        }
        set {
            UserDefaults.standard.set(newValue, forKey: "deleted_session_start_times")
        }
    }

    func markSessionAsDeleted(startDate: Date) {
        var times = deletedSessionStartTimes
        let time = startDate.timeIntervalSince1970
        if !times.contains(time) {
            times.append(time)
            // Limit the list to last 100 deleted sessions to prevent size bloat
            if times.count > 100 {
                times.removeFirst(times.count - 100)
            }
            deletedSessionStartTimes = times
        }
    }

    func isSessionDeleted(startDate: Date) -> Bool {
        let sessionTime = startDate.timeIntervalSince1970
        return deletedSessionStartTimes.contains { deletedTime in
            abs(deletedTime - sessionTime) <= 3600
        }
    }

    func syncSleepDataFromHealthKit(modelContext: ModelContext) async -> Int {
        guard isAvailable else { return 0 }
        
        let sleepType = HKObjectType.categoryType(forIdentifier: .sleepAnalysis)!
        
        // Fetch last 730 days of data
        let calendar = Calendar.current
        guard let startDate = calendar.date(byAdding: .day, value: -730, to: Date()) else { return 0 }
        let predicate = HKQuery.predicateForSamples(withStart: startDate, end: Date(), options: [.strictStartDate])
        
        do {
            let samples = try await withCheckedThrowingContinuation { (continuation: CheckedContinuation<[HKSample], Error>) in
                let sortDescriptor = NSSortDescriptor(key: HKSampleSortIdentifierStartDate, ascending: true)
                let query = HKSampleQuery(sampleType: sleepType, predicate: predicate, limit: HKObjectQueryNoLimit, sortDescriptors: [sortDescriptor]) { _, results, error in
                    if let error = error {
                        continuation.resume(throwing: error)
                    } else {
                        continuation.resume(returning: results ?? [])
                    }
                }
                store.execute(query)
            }
            
            guard !samples.isEmpty else { return 0 }
            
            // Group samples into sessions. If samples are within 1.5 hours of each other, they belong to the same session.
            var sessions: [[HKCategorySample]] = []
            var currentSession: [HKCategorySample] = []
            
            for sample in samples {
                guard let catSample = sample as? HKCategorySample else { continue }
                if currentSession.isEmpty {
                    currentSession.append(catSample)
                } else {
                    let lastSample = currentSession.last!
                    let timeGap = catSample.startDate.timeIntervalSince(lastSample.endDate)
                    if timeGap <= 1.5 * 3600 {
                        currentSession.append(catSample)
                    } else {
                        sessions.append(currentSession)
                        currentSession = [catSample]
                    }
                }
            }
            if !currentSession.isEmpty {
                sessions.append(currentSession)
            }
            
            // Pre-fetch existing sessions in memory to avoid #Predicate compiler macro limitations with Date comparisons
            let descriptor = FetchDescriptor<SleepSession>()
            let existing = (try? modelContext.fetch(descriptor)) ?? []
            
            // Import sessions
            var importCount = 0
            for sessionSamples in sessions {
                guard let first = sessionSamples.first, let last = sessionSamples.last else { continue }
                let sessionStart = first.startDate
                let sessionEnd = last.endDate
                
                let isDuplicate = existing.contains { s in
                    abs(s.startDate.timeIntervalSince(sessionStart)) <= 3600
                }
                
                let isDeleted = isSessionDeleted(startDate: sessionStart)
                
                if !isDuplicate && !isDeleted {
                    // Create new session
                    let newSession = SleepSession(startDate: sessionStart)
                    newSession.endDate = sessionEnd
                    newSession.syncedToHealthKit = true // Since it came from HealthKit!
                    
                    // Map stages
                    var stages: [SleepStage] = []
                    
                    // Check if specific sleep stages (awake, core, deep, rem) are present
                    let hasSpecificStages = sessionSamples.contains { sample in
                        let val = sample.value
                        return val == HKCategoryValueSleepAnalysis.asleepCore.rawValue ||
                               val == HKCategoryValueSleepAnalysis.asleepDeep.rawValue ||
                               val == HKCategoryValueSleepAnalysis.asleepREM.rawValue ||
                               val == HKCategoryValueSleepAnalysis.awake.rawValue
                    }
                    
                    for sample in sessionSamples {
                        guard let analysisValue = HKCategoryValueSleepAnalysis(rawValue: sample.value) else { continue }
                        
                        // Always exclude inBed from stages since it represents overall bed duration, not a stage
                        if analysisValue == .inBed {
                            continue
                        }
                        
                        // If specific stages are present, exclude generic asleep samples to avoid double-counting
                        if hasSpecificStages && analysisValue == .asleep {
                            continue
                        }
                        
                        let type: SleepStageType
                        switch analysisValue {
                        case .awake:
                            type = .awake
                        case .asleepDeep:
                            type = .deep
                        case .asleepREM:
                            type = .rem
                        default:
                            type = .light // asleepCore, asleep, etc.
                        }
                        stages.append(SleepStage(type: type, startDate: sample.startDate, endDate: sample.endDate))
                    }
                    newSession.stages = stages
                    
                    modelContext.insert(newSession)
                    importCount += 1
                }
            }
            
            if importCount > 0 {
                try? modelContext.save()
            }
            return importCount
        } catch {
            print("Failed to sync from HealthKit: \(error)")
            return 0
        }
    }
}

extension SleepStageType {
    var healthKitValue: HKCategoryValueSleepAnalysis {
        switch self {
        case .awake: return .awake
        case .light: return .asleepCore
        case .deep:  return .asleepDeep
        case .rem:   return .asleepREM
        }
    }
}
