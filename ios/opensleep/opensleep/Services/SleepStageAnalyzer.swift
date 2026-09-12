import Foundation

/**
 * High-level Sleep Stage Analyzer for phone-only tracking on iOS.
 * Connects 10-second accelerometer sampling to HypnogramEngine based on
 * Sleep as Android (com.urbandroid.sleep) reference logic.
 */
final class SleepStageAnalyzer {

    static let epochDuration: TimeInterval = HypnogramEngine.framerateSec // 10.0 seconds

    private let lock = NSLock()

    // 10-second epoch peak accumulator
    private var currentEpochStartDate: Date?
    private var currentEpochMaxMagnitude: Float = 0.0
    private var hasSampleInEpoch = false

    // Actigraphy history (10s actigraph values)
    private var rawActigraphHistory: [Float] = []

    // Real-time components
    private let activityAggregator = HypnogramEngine.ActivityAggregator()
    private let awakeDetector = HypnogramEngine.AwakeDetector()
    private let livePhaseDetector = HypnogramEngine.LivePhaseDetector()

    // Tracked awake intervals
    private var awakeIntervals: [(Date, Date)] = []

    private(set) var currentStage: SleepStageType = .light

    init() {}

    func clear() {
        lock.lock()
        defer { lock.unlock() }
        currentEpochStartDate = nil
        currentEpochMaxMagnitude = 0.0
        hasSampleInEpoch = false
        rawActigraphHistory.removeAll()
        awakeIntervals.removeAll()
        currentStage = .light
    }

    func addSample(timestamp: Date = Date(), x: Double, y: Double, z: Double) {
        addSample(timestamp: timestamp, x: Float(x), y: Float(y), z: Float(z))
    }

    func addSample(timestamp: Date = Date(), x: Float, y: Float, z: Float) {
        let magnitude = sqrt(x * x + y * y + z * z)

        lock.lock()
        defer { lock.unlock() }

        guard let start = currentEpochStartDate else {
            currentEpochStartDate = timestamp
            currentEpochMaxMagnitude = magnitude
            hasSampleInEpoch = true
            return
        }

        if timestamp.timeIntervalSince(start) >= Self.epochDuration {
            flushEpoch()
            currentEpochStartDate = timestamp
            currentEpochMaxMagnitude = magnitude
            hasSampleInEpoch = true
        } else {
            currentEpochMaxMagnitude = max(currentEpochMaxMagnitude, magnitude)
            hasSampleInEpoch = true
        }
    }

    private func flushEpoch() {
        let peak = hasSampleInEpoch ? currentEpochMaxMagnitude : 0.0
        hasSampleInEpoch = false
        currentEpochMaxMagnitude = 0.0

        let result = activityAggregator.update(peakMagnitude: peak)
        rawActigraphHistory.append(result.actigraph)

        let isAwake = awakeDetector.update(history: rawActigraphHistory)
        currentStage = isAwake ? .awake : livePhaseDetector.update(
            isHighActivity: result.isHighActivity,
            isSomeActivity: result.isSomeActivity
        )
    }

    func addAwakeInterval(start: Date, end: Date) {
        lock.lock()
        defer { lock.unlock() }
        if end > start {
            awakeIntervals.append((start, end))
        }
    }

    // Sonar high-activity detector matching ActivityAggregatorSonar.java (factor 1.0)
    private let sonarHighActivityDetector = HypnogramEngine.HighActivityDetector(factor: 1.0)

    // Compatibility no-ops for previous sensor calls
    func addGyroSample(timestamp: Date, x: Double, y: Double, z: Double) {}

    func addSonarSample(timestamp: Date = Date(), activity: Float) {
        lock.lock()
        defer { lock.unlock() }

        // In Sleep as Android (ActivityAggregatorSonar.java), Sonar activity directly acts as actigraph
        rawActigraphHistory.append(activity)

        let isAwake = awakeDetector.update(history: rawActigraphHistory)
        let (isSome, isHigh) = sonarHighActivityDetector.update(actigraph: activity)
        currentStage = isAwake ? .awake : livePhaseDetector.update(
            isHighActivity: isHigh,
            isSomeActivity: isSome
        )
    }

    func computeStages(sleepStart: Date) -> [SleepStage] {
        var (historyCopy, awakeCopy, endDate): ([Float], [(Date, Date)], Date) = ([], [], Date())

        lock.lock()
        if hasSampleInEpoch {
            flushEpoch()
        }
        let count = rawActigraphHistory.count
        let derivedEndDate = currentEpochStartDate?.addingTimeInterval(Self.epochDuration)
            ?? sleepStart.addingTimeInterval(Double(count) * Self.epochDuration)
        endDate = derivedEndDate
        historyCopy = rawActigraphHistory
        awakeCopy = awakeIntervals
        lock.unlock()

        print("[SleepStageAnalyzer] computeStages: start=\(sleepStart), end=\(endDate), epochs=\(historyCopy.count), awakeIntervals=\(awakeCopy.count)")

        if historyCopy.count < 12 || endDate <= sleepStart {
            print("[SleepStageAnalyzer] Recording too short for multi-phase hypnogram; returning light sleep")
            return [SleepStage(type: .light, startDate: sleepStart, endDate: max(endDate, sleepStart.addingTimeInterval(60)))]
        }

        // Detect sleep onset latency / initial awake period
        let initialAwake = awakeDetector.detectBeginningAwake(history: historyCopy, startDate: sleepStart)
        awakeCopy.append(contentsOf: initialAwake)

        let stages = HypnogramEngine.buildHypnogram(
            rawActigraphHistory: historyCopy,
            startDate: sleepStart,
            endDate: endDate,
            awakeIntervals: awakeCopy
        )

        print("[SleepStageAnalyzer] Hypnogram generated: \(stages.count) segments")
        for (idx, stage) in stages.enumerated() {
            print("[SleepStageAnalyzer]   Stage \(idx): \(stage.type) from \(stage.startDate) to \(stage.endDate) (\(stage.durationSeconds / 60.0) min)")
        }

        return stages
    }
}
