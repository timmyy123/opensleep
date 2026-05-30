import Foundation
import HealthKit
import Combine

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
