import Foundation

/// Core phone-only sleep tracking & 4-phase hypnogram engine.
/// Faithfully ported from Sleep as Android (com.urbandroid.sleep) reference logic.
enum HypnogramEngine {

    static let framerateSec: TimeInterval = 10.0 // 10s per raw epoch
    static let deepSleepThreshold: Float = 3.1
    static let minDeepSleepSec: TimeInterval = 15.0 * 60.0 // 15 minutes
    static let minRemDelaySec: TimeInterval = 50.0 * 60.0 // REM only occurs >= 50m

    enum RawPhase {
        case deep, light, rem, awake, broken
    }

    struct PhaseInterval {
        let startDate: Date
        let endDate: Date
        let phase: RawPhase

        var duration: TimeInterval {
            endDate.timeIntervalSince(startDate)
        }
    }

    // =========================================================================
    // Real-Time Component 1: ActivityAggregator
    // =========================================================================
    final class ActivityAggregator {
        private let baseline = Moving.quantilePrecise(period: 6, quantile: 0.5)
        private let highActivityDetector = HighActivityDetector(factor: 1.1)

        struct Result {
            let rawActivity: Float
            let actigraph: Float
            let isSomeActivity: BooleanLiteralType
            let isHighActivity: BooleanLiteralType
        }

        init() {}

        func update(peakMagnitude: Float) -> Result {
            let base = baseline(peakMagnitude)
            let actigraph = abs(peakMagnitude - base)
            let (isSome, isHigh) = highActivityDetector.update(actigraph: actigraph)
            return Result(rawActivity: peakMagnitude, actigraph: actigraph, isSomeActivity: isSome, isHighActivity: isHigh)
        }
    }

    // =========================================================================
    // Real-Time Component 2: HighActivityDetector
    // =========================================================================
    final class HighActivityDetector {
        private var callCount = 0
        private let someActivityThreshold: Float
        private let highActivityThreshold: Float
        private let median = Moving.quantileScalable(period: 720, quantile: 0.5)
        private let maximum = Moving.max(period: 720)

        init(factor: Float = 1.1) {
            self.someActivityThreshold = 2.5 * factor
            self.highActivityThreshold = 3.3 * factor
        }

        func update(actigraph: Float) -> (isSome: Bool, isHigh: Bool) {
            callCount += 1
            if callCount < 30 {
                return (false, false)
            }
            var absVal = abs(actigraph)
            let medVal = median(absVal)
            if medVal != 0.0 {
                absVal /= medVal
            }
            var maxVal = maximum(absVal)
            if maxVal <= 1.0 {
                return (false, false)
            }
            if callCount < 360 {
                maxVal = max(100.0, maxVal)
            }
            let exponent = 1.0 / log10(Double(maxVal))
            let score = Float(pow(Double(min(maxVal, absVal)), exponent))
            return (score > someActivityThreshold, score > highActivityThreshold)
        }
    }

    // =========================================================================
    // Real-Time Component 3: AwakeDetector
    // =========================================================================
    final class AwakeDetector {
        let threshold: Float
        let windowSize: Int
        private(set) var isCurrentlyAwake: Bool = false

        init(threshold: Float = 0.35, windowSize: Int = 30) {
            self.threshold = threshold
            self.windowSize = windowSize
        }

        func update(history: [Float]) -> Bool {
            guard history.count >= windowSize else { return false }
            let anfResult = AdaptiveNormalizationFilter.normalizeAmplitudes(history)
            let flags = anfResult.getHighActivityFlagsFloat(threshold: 3.0)

            var sum: Float = 0.0
            let start = flags.count - windowSize
            for i in start..<flags.count {
                sum += flags[i]
            }
            let avg = sum / Float(windowSize)
            let awake = avg >= threshold
            isCurrentlyAwake = awake
            return awake
        }

        func detectBeginningAwake(history: [Float], startDate: Date) -> [(Date, Date)] {
            guard history.count >= windowSize else { return [] }
            let anfResult = AdaptiveNormalizationFilter.normalizeAmplitudes(history)
            let flags = anfResult.getHighActivityFlagsFloat(threshold: 3.0)

            var intervals: [(Date, Date)] = []
            let sumFilter = Moving.sum(period: windowSize)
            var awakeMask = [Bool](repeating: false, count: flags.count)
            for i in 0..<flags.count {
                awakeMask[i] = sumFilter(flags[i]) >= (threshold * Float(windowSize))
            }

            var inAwake = false
            var awakeStart = startDate
            for i in 0..<awakeMask.count {
                let epochTime = startDate.addingTimeInterval(Double(i) * framerateSec)
                if awakeMask[i] && !inAwake {
                    inAwake = true
                    awakeStart = epochTime
                } else if !awakeMask[i] && inAwake {
                    inAwake = false
                    intervals.append((awakeStart, epochTime))
                }
            }
            if inAwake {
                intervals.append((awakeStart, startDate.addingTimeInterval(Double(flags.count) * framerateSec)))
            }
            return intervals
        }
    }

    // =========================================================================
    // Real-Time Component 4: LivePhaseDetector
    // =========================================================================
    final class LivePhaseDetector {
        private let smartWakeupChecks: Int
        private let highActivityShort = Moving.sum(period: 6) // 1 min
        private let someActivityLong = Moving.sum(period: 30) // 5 min
        private var pointsCount = 0

        init(smartWakeupChecks: Int = 3) {
            self.smartWakeupChecks = smartWakeupChecks
        }

        func update(isHighActivity: Bool, isSomeActivity: Bool) -> SleepStageType {
            let highCount = highActivityShort(isHighActivity ? 1.0 : 0.0)
            let someCount = someActivityLong(isSomeActivity ? 1.0 : 0.0)
            pointsCount += 1

            if pointsCount < 12 {
                return .light
            }
            let isDeep = Int(round(highCount)) < 1 || Int(round(someCount)) < smartWakeupChecks
            return isDeep ? .deep : .light
        }
    }

    // =========================================================================
    // Post-Processing: Hypnogram & 4-Phase Reconstruction
    // =========================================================================

    static func buildHypnogram(
        rawActigraphHistory: [Float],
        startDate: Date,
        endDate: Date,
        awakeIntervals: [(Date, Date)]
    ) -> [SleepStage] {
        let size = rawActigraphHistory.count
        guard size >= 12 && endDate > startDate else {
            return [SleepStage(type: .light, startDate: startDate, endDate: max(endDate, startDate.addingTimeInterval(60)))]
        }

        // 1. Excluded indices
        var excluded = IndexSet()
        for awake in awakeIntervals {
            let fromIdx = Int(awake.0.timeIntervalSince(startDate) / framerateSec).clamped(to: 0...(size - 1))
            let toIdx = Int(awake.1.timeIntervalSince(startDate) / framerateSec).clamped(to: 0...(size - 1))
            if fromIdx <= toIdx {
                excluded.insert(integersIn: fromIdx...toIdx)
            }
        }
        let initExcludeCount = min(size / 5, 60)
        excluded.insert(integersIn: 0..<initExcludeCount)
        if excluded.count > Int(Double(size) * 0.66) {
            excluded.removeAll()
        }

        // 2. Adaptive Normalization Filter
        let anfResult = AdaptiveNormalizationFilter.normalizeAmplitudes(rawActigraphHistory, excluded: excluded)
        let highActivityFlags = anfResult.getHighActivityFlags(threshold: 2.5)

        // 3. Aggregation factor
        let aggregation = size < 90 ? 3 : (size < 360 ? 6 : 30)
        let aggregatedHistory = anfResult.aggregateOutput(aggregation)
        let epochSec = Double(aggregation) * framerateSec

        // 4. High Activity Frequency
        let highActivityFreq = computeHighActivityFrequency(
            flags: highActivityFlags,
            targetSize: aggregatedHistory.count,
            aggregation: aggregation
        )

        // 5. Activity segment classification
        let rawIntervals = classifyActivitySegments(
            history: aggregatedHistory,
            haFreq: highActivityFreq,
            startDate: startDate,
            endDate: endDate,
            epochSec: epochSec,
            aggregation: aggregation
        )

        // 6. Deep sleep post-processing (convert < 15 min to light, merge light)
        let postProcessedDeep = postProcessDeepIntervals(rawIntervals)

        // 7. REM detection (following deep >= 10m and light >= 15m after 50m)
        let remIntervals = detectREM(intervals: postProcessedDeep, sessionStart: startDate)

        // 8. Awake Overlap Resolution
        let mergedAwake = mergeIntervals(awakeIntervals, maxGapSec: 5.0 * 60.0)
        let clearedRem = clearRemAtAwake(remIntervals: remIntervals, awakeIntervals: mergedAwake)

        // 9. Non-overlapping Segment Normalization: AWAKE > REM > LIGHT > DEEP
        return normalizeToFourPhases(
            startDate: startDate,
            endDate: endDate,
            baseSegments: postProcessedDeep,
            remSegments: clearedRem,
            awakeSegments: mergedAwake
        )
    }

    private static func computeHighActivityFrequency(flags: IndexSet, targetSize: Int, aggregation: Int) -> [Float] {
        let totalPoints = targetSize * aggregation
        var fArr = [Float](repeating: 0.0, count: totalPoints)
        for idx in flags where idx < totalPoints {
            fArr[idx] = 1.0
        }
        let avgFunc = Moving.avg(period: aggregation)
        var smoothed = [Float](repeating: 0.0, count: totalPoints)
        for i in 0..<totalPoints {
            smoothed[i] = avgFunc(fArr[i])
        }
        var decimated = [Float](repeating: 0.0, count: targetSize)
        for i in 0..<targetSize {
            decimated[i] = smoothed[i * aggregation]
        }
        return decimated
    }

    private static func classifyActivitySegments(
        history: [Float],
        haFreq: [Float],
        startDate: Date,
        endDate: Date,
        epochSec: TimeInterval,
        aggregation: Int
    ) -> [PhaseInterval] {
        let count = history.count
        guard count > 0 else { return [] }
        let fMin = min(3.0 / Float(aggregation), 0.1)
        var phases = [RawPhase](repeating: .light, count: count)

        for i in 0..<count {
            let v = history[i]
            if v < 0.0 {
                phases[i] = .broken
            } else if v < deepSleepThreshold {
                phases[i] = .deep
            } else {
                let freq = i < haFreq.count ? haFreq[i] : 0.0
                if freq <= 0.0 || freq >= fMin {
                    phases[i] = .light
                } else {
                    phases[i] = .deep
                }
            }
        }

        var intervals: [PhaseInterval] = []
        var currentPhase = phases[0]
        var segStart = startDate

        for i in 1..<count {
            if phases[i] != currentPhase {
                let segEnd = startDate.addingTimeInterval(Double(i) * epochSec)
                intervals.append(PhaseInterval(startDate: segStart, endDate: segEnd, phase: currentPhase))
                currentPhase = phases[i]
                segStart = segEnd
            }
        }
        intervals.append(PhaseInterval(startDate: segStart, endDate: endDate, phase: currentPhase))
        return intervals
    }

    private static func postProcessDeepIntervals(_ intervals: [PhaseInterval]) -> [PhaseInterval] {
        let converted = intervals.map { interval -> PhaseInterval in
            if interval.phase == .deep && interval.duration < minDeepSleepSec {
                return PhaseInterval(startDate: interval.startDate, endDate: interval.endDate, phase: .light)
            }
            return interval
        }

        var merged: [PhaseInterval] = []
        for interval in converted {
            if let last = merged.last, last.phase == .light && interval.phase == .light {
                _ = merged.removeLast()
                merged.append(PhaseInterval(startDate: last.startDate, endDate: interval.endDate, phase: .light))
            } else {
                merged.append(interval)
            }
        }
        return merged
    }

    private static func detectREM(intervals: [PhaseInterval], sessionStart: Date) -> [PhaseInterval] {
        var remList: [PhaseInterval] = []
        let minDeep = 10.0 * 60.0
        let minLight = 15.0 * 60.0
        let remDelay = 10.0 * 60.0
        let fiveMin = 5.0 * 60.0
        let maxRem = 50.0 * 60.0

        for i in 1..<intervals.count {
            let prev = intervals[i - 1]
            let curr = intervals[i]

            if prev.phase == .deep && prev.duration >= minDeep {
                if curr.phase == .light && curr.duration >= minLight {
                    let remStart = curr.startDate.addingTimeInterval(remDelay)
                    let remAvailable = curr.duration - remDelay
                    let halfInterval = Double((Int(remAvailable / fiveMin) + 1) / 2) * fiveMin
                    let remDuration = min(remAvailable, min(maxRem, max(fiveMin, halfInterval)))
                    let remEnd = remStart.addingTimeInterval(remDuration)

                    let allowedStart = sessionStart.addingTimeInterval(minRemDelaySec)
                    if allowedStart <= remStart {
                        remList.append(PhaseInterval(startDate: remStart, endDate: remEnd, phase: .rem))
                    } else if remEnd.timeIntervalSince(allowedStart) >= fiveMin {
                        remList.append(PhaseInterval(startDate: allowedStart, endDate: remEnd, phase: .rem))
                    }
                }
            }
        }
        return remList
    }

    private static func mergeIntervals(_ intervals: [(Date, Date)], maxGapSec: TimeInterval) -> [(Date, Date)] {
        guard !intervals.isEmpty else { return [] }
        let sorted = intervals.sorted { $0.0 < $1.0 }
        var merged: [(Date, Date)] = []
        var current = sorted[0]

        for i in 1..<sorted.count {
            let next = sorted[i]
            if next.0.timeIntervalSince(current.1) <= maxGapSec {
                current = (current.0, max(current.1, next.1))
            } else {
                merged.append(current)
            }
        }
        merged.append(current)
        return merged
    }

    private static func clearRemAtAwake(remIntervals: [PhaseInterval], awakeIntervals: [(Date, Date)]) -> [PhaseInterval] {
        let fiveMin = 5.0 * 60.0
        var currentRem = remIntervals

        for awake in awakeIntervals {
            var updated: [PhaseInterval] = []
            for rem in currentRem {
                if rem.endDate <= awake.0 || rem.startDate >= awake.1 {
                    updated.append(rem)
                } else {
                    if rem.startDate < awake.0 && awake.0.timeIntervalSince(rem.startDate) >= fiveMin {
                        updated.append(PhaseInterval(startDate: rem.startDate, endDate: awake.0, phase: .rem))
                    }
                    if rem.endDate > awake.1 && rem.endDate.timeIntervalSince(awake.1) >= fiveMin {
                        updated.append(PhaseInterval(startDate: awake.1, endDate: rem.endDate, phase: .rem))
                    }
                }
            }
            currentRem = updated
        }
        return currentRem
    }

    private static func normalizeToFourPhases(
        startDate: Date,
        endDate: Date,
        baseSegments: [PhaseInterval],
        remSegments: [PhaseInterval],
        awakeSegments: [(Date, Date)]
    ) -> [SleepStage] {
        var boundaries: Set<Date> = [startDate, endDate]
        for b in baseSegments {
            boundaries.insert(b.startDate.clamped(min: startDate, max: endDate))
            boundaries.insert(b.endDate.clamped(min: startDate, max: endDate))
        }
        for r in remSegments {
            boundaries.insert(r.startDate.clamped(min: startDate, max: endDate))
            boundaries.insert(r.endDate.clamped(min: startDate, max: endDate))
        }
        for a in awakeSegments {
            boundaries.insert(a.0.clamped(min: startDate, max: endDate))
            boundaries.insert(a.1.clamped(min: startDate, max: endDate))
        }

        let sortedPoints = boundaries.sorted()
        var stages: [SleepStage] = []

        for i in 0..<(sortedPoints.count - 1) {
            let segStart = sortedPoints[i]
            let segEnd = sortedPoints[i + 1]
            guard segEnd > segStart else { continue }
            let mid = Date(timeIntervalSinceReferenceDate: (segStart.timeIntervalSinceReferenceDate + segEnd.timeIntervalSinceReferenceDate) / 2.0)

            // Hierarchy 1: AWAKE
            if awakeSegments.contains(where: { $0.0 <= mid && mid < $0.1 }) {
                stages.append(SleepStage(type: .awake, startDate: segStart, endDate: segEnd))
                continue
            }

            // Hierarchy 2: REM
            if remSegments.contains(where: { $0.startDate <= mid && mid < $0.endDate }) {
                stages.append(SleepStage(type: .rem, startDate: segStart, endDate: segEnd))
                continue
            }

            // Hierarchy 3 & 4: Base DEEP / LIGHT
            let base = baseSegments.first { $0.startDate <= mid && mid < $0.endDate }
            let stageType: SleepStageType = (base?.phase == .deep) ? .deep : .light
            stages.append(SleepStage(type: stageType, startDate: segStart, endDate: segEnd))
        }

        // Collapse adjacent identical stages
        var collapsed: [SleepStage] = []
        for stage in stages {
            if let last = collapsed.last, last.type == stage.type {
                _ = collapsed.removeLast()
                collapsed.append(SleepStage(type: last.type, startDate: last.startDate, endDate: stage.endDate))
            } else {
                collapsed.append(stage)
            }
        }
        return collapsed
    }
}

private extension Comparable {
    func clamped(to range: ClosedRange<Self>) -> Self {
        min(max(self, range.lowerBound), range.upperBound)
    }

    func clamped(min minVal: Self, max maxVal: Self) -> Self {
        Swift.min(Swift.max(self, minVal), maxVal)
    }
}
