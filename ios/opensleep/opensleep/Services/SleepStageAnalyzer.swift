import Foundation
import CoreMotion

/**
 * Identical algorithm to Android SleepStageAnalyzer.kt:
 * - Rolling 5-min windows of accelerometer magnitude variance
 * - DEEP < 0.004, LIGHT < 0.025, AWAKE >= 0.10, REM near 90-min cycle
 */
class SleepStageAnalyzer {

    private struct MotionSample {
        let timestamp: Date
        let magnitude: Double
    }

    private var samples: [MotionSample] = []

    private let analysisWindowSec: TimeInterval = 5 * 60
    private let deepThreshold: Double = 0.004
    private let lightThreshold: Double = 0.025
    private let awakeThreshold: Double = 0.10
    private let remCycleSec: TimeInterval = 90 * 60
    private let remWindowSec: TimeInterval = 20 * 60

    func addSample(timestamp: Date, x: Double, y: Double, z: Double) {
        let magnitude = (x*x + y*y + z*z).squareRoot()
        samples.append(MotionSample(timestamp: timestamp, magnitude: magnitude))
    }

    func computeStages(sleepStart: Date) -> [SleepStage] {
        guard samples.count >= 2 else { return [] }

        var stages: [SleepStage] = []
        guard let first = samples.first?.timestamp,
              let last = samples.last?.timestamp else { return [] }

        var windowStart = first
        var hadDeep = false

        while windowStart.addingTimeInterval(analysisWindowSec) <= last {
            let windowEnd = windowStart.addingTimeInterval(analysisWindowSec)
            let windowSamples = samples.filter { $0.timestamp >= windowStart && $0.timestamp < windowEnd }
            guard windowSamples.count >= 2 else {
                windowStart = windowEnd
                continue
            }

            let variance = computeVariance(windowSamples.map { $0.magnitude })
            let elapsed = windowStart.timeIntervalSince(sleepStart)

            let stageType: SleepStageType
            if variance < deepThreshold {
                hadDeep = true
                stageType = .deep
            } else if variance < lightThreshold {
                stageType = (hadDeep && isNearRemCycle(elapsed)) ? .rem : .light
            } else if variance >= awakeThreshold {
                stageType = .awake
            } else {
                stageType = .light
            }

            // Merge consecutive same-type
            if let last = stages.last, last.type == stageType {
                stages[stages.count - 1] = SleepStage(
                    type: stageType,
                    startDate: last.startDate,
                    endDate: windowEnd
                )
            } else {
                stages.append(SleepStage(type: stageType, startDate: windowStart, endDate: windowEnd))
            }

            windowStart = windowEnd
        }

        return stages
    }

    func clear() { samples.removeAll() }

    private func computeVariance(_ values: [Double]) -> Double {
        guard !values.isEmpty else { return 0 }
        let mean = values.reduce(0, +) / Double(values.count)
        return values.map { ($0 - mean) * ($0 - mean) }.reduce(0, +) / Double(values.count)
    }

    private func isNearRemCycle(_ elapsed: TimeInterval) -> Bool {
        guard elapsed >= remCycleSec else { return false }
        let modulo = elapsed.truncatingRemainder(dividingBy: remCycleSec)
        return modulo < remWindowSec || modulo > (remCycleSec - remWindowSec)
    }
}
