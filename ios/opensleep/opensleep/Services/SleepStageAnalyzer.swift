import Foundation
import CoreMotion

/**
 * Phone-only actigraphy analyzer.
 *
 * This is not PSG/EEG sleep staging. It is a device-local actigraphy pipeline
 * designed for a phone resting on the mattress: accelerometer movement,
 * gyroscope rotation, ambient audio level/events, artifact rejection, and
 * sleep-cycle priors are fused into confidence-ranked stage estimates.
 */
class SleepStageAnalyzer {

    private struct MotionSample {
        let timestamp: Date
        let accelMagnitude: Double
    }

    private struct GyroSample {
        let timestamp: Date
        let magnitude: Double
    }

    private struct AudioSample {
        let timestamp: Date
        let levelDbfs: Double
        let clipped: Bool
    }

    private struct WindowFeatures {
        let start: Date
        let end: Date
        let movement: Double
        let stillness: Double
        let rotation: Double
        let audioMean: Double
        let audioEvents: Double
        let artifact: Bool
        let elapsed: TimeInterval
    }

    private struct WindowPrediction {
        let start: Date
        let end: Date
        var type: SleepStageType
        let confidence: Double
        let artifact: Bool
    }

    private var samples: [MotionSample] = []
    private var gyroSamples: [GyroSample] = []
    private var audioSamples: [AudioSample] = []

    private let analysisWindowSec: TimeInterval = 5 * 60
    private let minPartialWindowSec: TimeInterval = 2 * 60
    private let remCycleSec: TimeInterval = 90 * 60
    private let remWindowSec: TimeInterval = 22 * 60
    private let minAccelSamplesPerWindow = 120

    func addSample(timestamp: Date, x: Double, y: Double, z: Double) {
        let magnitude = (x*x + y*y + z*z).squareRoot()
        samples.append(MotionSample(timestamp: timestamp, accelMagnitude: magnitude))
    }

    func addGyroSample(timestamp: Date, x: Double, y: Double, z: Double) {
        let magnitude = (x*x + y*y + z*z).squareRoot()
        gyroSamples.append(GyroSample(timestamp: timestamp, magnitude: magnitude))
    }

    func addAudioLevel(timestamp: Date, levelDbfs: Double, clipped: Bool = false) {
        audioSamples.append(AudioSample(timestamp: timestamp, levelDbfs: min(0, max(-90, levelDbfs)), clipped: clipped))
    }

    func computeStages(sleepStart: Date) -> [SleepStage] {
        guard samples.count >= 2 else { return [] }

        var predictions: [WindowPrediction] = []
        guard let last = samples.last?.timestamp else { return [] }

        var windowStart = sleepStart

        while windowStart < last {
            let windowEnd = minDate(windowStart.addingTimeInterval(analysisWindowSec), last)
            if windowEnd.timeIntervalSince(windowStart) < minPartialWindowSec { break }

            if let features = buildFeatures(start: windowStart, end: windowEnd, sleepStart: sleepStart) {
                predictions.append(predict(features))
            }

            windowStart = windowStart.addingTimeInterval(analysisWindowSec)
        }

        return smoothAndMerge(predictions)
    }

    func clear() {
        samples.removeAll()
        gyroSamples.removeAll()
        audioSamples.removeAll()
    }

    private func buildFeatures(start: Date, end: Date, sleepStart: Date) -> WindowFeatures? {
        let accelWindow = samples.filter { $0.timestamp >= start && $0.timestamp < end }
        guard accelWindow.count >= 2 else { return nil }

        let magnitudes = accelWindow.map(\.accelMagnitude)
        let deltas = zip(magnitudes.dropFirst(), magnitudes).map { abs($0 - $1) }
        let variance = computeVariance(magnitudes)
        let jerk = average(deltas)
        let range = (magnitudes.max() ?? 0) - (magnitudes.min() ?? 0)
        let stillRatio = Double(deltas.filter { $0 < 0.008 }.count) / Double(max(1, deltas.count))

        let gyroWindow = gyroSamples
            .filter { $0.timestamp >= start && $0.timestamp < end }
            .map(\.magnitude)
        let rotationMean = average(gyroWindow)

        let audioWindow = audioSamples.filter { $0.timestamp >= start && $0.timestamp < end }
        let audioMeanDb = audioWindow.isEmpty ? -65 : average(audioWindow.map(\.levelDbfs))
        let audioEvents = Double(audioWindow.filter { $0.levelDbfs > -38 || $0.clipped }.count) /
            Double(max(1, audioWindow.count))

        let movement = weightedIndex([
            normalizeLog(variance, low: 0.00002, high: 0.08) * 0.45,
            normalizeLog(jerk, low: 0.001, high: 0.06) * 0.30,
            normalizeLinear(range, low: 0.015, high: 0.45) * 0.15,
            (1 - stillRatio) * 0.10
        ])
        let rotation = normalizeLinear(rotationMean, low: 0.01, high: 0.85)
        let audioMean = normalizeLinear(audioMeanDb, low: -62, high: -30)
        let artifact = accelWindow.count < minAccelSamplesPerWindow ||
            range > 3.5 ||
            movement > 0.96 ||
            audioEvents > 0.75

        return WindowFeatures(
            start: start,
            end: end,
            movement: movement,
            stillness: 1 - movement,
            rotation: rotation,
            audioMean: audioMean,
            audioEvents: audioEvents,
            artifact: artifact,
            elapsed: start.timeIntervalSince(sleepStart)
        )
    }

    private func predict(_ features: WindowFeatures) -> WindowPrediction {
        if features.artifact {
            return WindowPrediction(start: features.start, end: features.end, type: .awake, confidence: 0.55, artifact: true)
        }

        let elapsedHours = features.elapsed / 3600
        let earlyNight = min(1, max(0, 1 - elapsedHours / 3))
        let lateNight = min(1, max(0, (elapsedHours - 3) / 4))
        let remCycle = remCycleAffinity(features.elapsed)
        let motionWake = max(features.movement, features.rotation)
        let sleepContinuity = features.elapsed < 10 * 60 ? 0.25 : 1.0

        let awakeScore = -0.9 + motionWake * 3.1 + features.audioEvents * 1.4 + features.audioMean * 0.45
        let deepScore = (-0.2 + features.stillness * 1.9 + earlyNight * 1.0 - remCycle * 0.55 -
            motionWake * 1.8 - lateNight * 0.8) * sleepContinuity
        var remScore = (-1.15 + features.stillness * 1.25 + remCycle * 1.7 + lateNight * 0.85 -
            motionWake * 1.1 - earlyNight * 0.35) * sleepContinuity
        let lightScore = 0.25 + features.stillness * 0.85 + motionWake * 0.45 - features.audioEvents * 0.3

        if features.elapsed < 45 * 60 {
            remScore -= 0.9
        }

        let scores: [(SleepStageType, Double)] = [
            (.awake, awakeScore),
            (.light, lightScore),
            (.deep, deepScore),
            (.rem, remScore)
        ]
        let ranked = scores.sorted { $0.1 > $1.1 }
        let confidence = softmaxConfidence(winner: ranked[0].1, scores: scores.map(\.1))

        return WindowPrediction(
            start: features.start,
            end: features.end,
            type: ranked[0].0,
            confidence: confidence,
            artifact: false
        )
    }

    private func smoothAndMerge(_ predictions: [WindowPrediction]) -> [SleepStage] {
        guard !predictions.isEmpty else { return [] }

        var smoothed = predictions
        for index in smoothed.indices {
            guard index > smoothed.startIndex, index < smoothed.index(before: smoothed.endIndex) else { continue }
            let previous = smoothed[smoothed.index(before: index)]
            let current = smoothed[index]
            let next = smoothed[smoothed.index(after: index)]
            if previous.type == next.type &&
                current.type != previous.type &&
                current.confidence < 0.60 &&
                !current.artifact {
                smoothed[index].type = previous.type
            }
        }

        var stages: [SleepStage] = []
        for prediction in smoothed {
            if let last = stages.last, last.type == prediction.type {
                stages[stages.count - 1] = SleepStage(
                    type: prediction.type,
                    startDate: last.startDate,
                    endDate: prediction.end
                )
            } else {
                stages.append(SleepStage(type: prediction.type, startDate: prediction.start, endDate: prediction.end))
            }
        }
        return stages
    }

    private func computeVariance(_ values: [Double]) -> Double {
        guard !values.isEmpty else { return 0 }
        let mean = values.reduce(0, +) / Double(values.count)
        return values.map { ($0 - mean) * ($0 - mean) }.reduce(0, +) / Double(values.count)
    }

    private func remCycleAffinity(_ elapsed: TimeInterval) -> Double {
        guard elapsed >= 45 * 60 else { return 0 }
        let modulo = elapsed.truncatingRemainder(dividingBy: remCycleSec)
        let distance = min(modulo, remCycleSec - modulo)
        return min(1, max(0, 1 - distance / remWindowSec))
    }

    private func normalizeLinear(_ value: Double, low: Double, high: Double) -> Double {
        min(1, max(0, (value - low) / (high - low)))
    }

    private func normalizeLog(_ value: Double, low: Double, high: Double) -> Double {
        let safeValue = max(value, low)
        return min(1, max(0, (log(safeValue) - log(low)) / (log(high) - log(low))))
    }

    private func weightedIndex(_ values: [Double]) -> Double {
        min(1, max(0, values.reduce(0, +)))
    }

    private func average(_ values: [Double]) -> Double {
        values.isEmpty ? 0 : values.reduce(0, +) / Double(values.count)
    }

    private func softmaxConfidence(winner: Double, scores: [Double]) -> Double {
        let maxScore = scores.max() ?? winner
        let expScores = scores.map { Foundation.exp($0 - maxScore) }
        let denominator = expScores.reduce(0, +)
        guard denominator > 0 else { return 0.25 }
        return min(0.98, max(0.25, Foundation.exp(winner - maxScore) / denominator))
    }

    private func minDate(_ lhs: Date, _ rhs: Date) -> Date {
        lhs < rhs ? lhs : rhs
    }
}
