import Foundation
import Accelerate

/**
 * Phone-only Sleep as Android actigraphy phase analyzer.
 *
 * 100% faithful Swift port of Sleep as Android (com.urbandroid.sleep) decompiled logic:
 *
 *  ┌─ FloatRingBuffer          — exact circular buffer (FloatRingBuffer.java)
 *  ├─ MovingQuantilePrecise    — 6-window percentile baseline (Moving.quantilePrecise)
 *  ├─ MovingQuantileScalable   — dual-heap O(log n) streaming quantile (Moving.quantileScalable)
 *  ├─ ActivityAggregatorAccel  — actigraph = abs(f − median6(f)), then HighActivity scoring
 *  ├─ HighActivityDetector     — normalize by 720-window median, score via log-power
 *  └─ DeepSleepDetectorV8 + RemDetectorV1 — 10s activity frames → deep/light/REM phase state
 */
class SleepStageAnalyzer {

    // ──────────────────────────────────────────────────────────────
    //  FloatRingBuffer  (exact port of FloatRingBuffer.java)
    // ──────────────────────────────────────────────────────────────
    private final class FloatRingBuffer {
        let maxSize: Int
        private var values: [Float]
        private var size = 0
        private var lastIndex = -1

        init(_ maxSize: Int) {
            precondition(maxSize > 0)
            self.maxSize = maxSize
            self.values = [Float](repeating: 0, count: maxSize)
        }

        func add(_ f: Float) {
            lastIndex += 1
            if lastIndex >= maxSize { lastIndex = 0 }
            values[lastIndex] = f
            if size < maxSize { size += 1 }
        }

        func get(_ i: Int) -> Float {
            precondition(i >= 0 && i < size)
            return values[(lastIndex - size + 1 + i + maxSize * 2) % maxSize]
        }

        func first() -> Float { get(0) }
        func last()  -> Float { precondition(size > 0); return values[lastIndex] }
        func count()  -> Int  { size }
        func isFull() -> Bool { size == maxSize }

        func toArray() -> [Float] { (0..<size).map { get($0) } }
    }

    // ──────────────────────────────────────────────────────────────
    //  Moving.quantilePrecise(period=6, quantile=0.5)
    //  6-window rolling median used as actigraphy baseline.
    // ──────────────────────────────────────────────────────────────
    private final class MovingQuantilePrecise {
        private let period: Int
        private let quantile: Float
        private let history: FloatRingBuffer
        init(_ period: Int, _ quantile: Float) {
            self.period = period; self.quantile = quantile
            self.history = FloatRingBuffer(period)
        }
        func apply(_ f: Float) -> Float {
            history.add(f)
            var sorted = history.toArray().sorted()
            return percentile(&sorted, p: quantile * 100)
        }
        // Apache Commons Math linear-interpolation percentile (C=1 variant)
        private func percentile(_ sorted: inout [Float], p: Float) -> Float {
            guard !sorted.isEmpty else { return 0 }
            if sorted.count == 1 { return sorted[0] }
            let n = sorted.count
            let rank = (p / 100) * Float(n + 1)
            if rank < 1 { return sorted[0] }
            if rank >= Float(n) { return sorted[n - 1] }
            let lower = Int(rank) - 1
            let frac = rank - Float(Int(rank))
            return sorted[lower] + frac * (sorted[lower + 1] - sorted[lower])
        }
    }

    // ──────────────────────────────────────────────────────────────
    //  Moving.quantileScalable(period, quantile)
    //  Dual max-heap/min-heap O(log n) streaming quantile.
    //  period=720 → ≈2 hours at 10s frame rate.
    // ──────────────────────────────────────────────────────────────
    private final class MovingQuantileScalable {
        private let period: Int
        private let quantile: Float
        // history size = period so we track exactly `period` oldest values for eviction
        private let history: FloatRingBuffer
        // low = max-heap simulated via negation (stores values ≤ boundary)
        private var low:  [Float] = []   // min-heap on -v, so top = max(low)
        // high = min-heap (stores values > boundary)
        private var high: [Float] = []   // min-heap

        init(_ period: Int, _ quantile: Float) {
            self.period = period; self.quantile = quantile
            self.history = FloatRingBuffer(period)
        }

        private func peekLow()  -> Float { -low[0] }   // root of max-heap
        private func peekHigh() -> Float {  high[0] }  // root of min-heap
        private func peek()     -> Float { low.isEmpty ? peekHigh() : peekLow() }
        private var heapSize: Int { low.count + high.count }

        func apply(_ f: Float) -> Float {
            // 1. Evict oldest BEFORE inserting new value
            if history.isFull() {
                let oldest = history.first()
                if !removeLow(oldest) { removeHigh(oldest) }
            }
            // 2. Insert into correct heap
            if heapSize == 0 || f <= peek() { insertLow(f) } else { insertHigh(f) }
            history.add(f)
            // 3. Rebalance to maintain quantile invariant
            let target = Int((quantile * Float(heapSize)).rounded())
            while !low.isEmpty  && low.count  > target { insertHigh(pollLow());  }
            while !high.isEmpty && low.count  < target { insertLow(pollHigh()); }
            return heapSize == 0 ? 0 : peek()
        }

        // ── Heap operations ──
        private func insertLow(_ v: Float)  { low.append(-v);  heapifyUp(&low,  low.count  - 1) }
        private func insertHigh(_ v: Float) { high.append(v);  heapifyUp(&high, high.count - 1) }

        private func pollLow() -> Float {
            let val = -low[0]; low[0] = low[low.count - 1]; low.removeLast()
            if !low.isEmpty { heapifyDown(&low, 0) }
            return val
        }
        private func pollHigh() -> Float {
            let val = high[0]; high[0] = high[high.count - 1]; high.removeLast()
            if !high.isEmpty { heapifyDown(&high, 0) }
            return val
        }

        @discardableResult
        private func removeLow(_ v: Float) -> Bool {
            guard let i = low.firstIndex(of: -v) else { return false }
            low[i] = low[low.count - 1]; low.removeLast()
            if i < low.count { heapifyDown(&low, i); heapifyUp(&low, i) }
            return true
        }
        @discardableResult
        private func removeHigh(_ v: Float) -> Bool {
            guard let i = high.firstIndex(of: v) else { return false }
            high[i] = high[high.count - 1]; high.removeLast()
            if i < high.count { heapifyDown(&high, i); heapifyUp(&high, i) }
            return true
        }

        private func heapifyUp(_ h: inout [Float], _ idx: Int) {
            var i = idx
            while i > 0 {
                let p = (i - 1) / 2
                if h[p] > h[i] { h.swapAt(p, i); i = p } else { break }
            }
        }
        private func heapifyDown(_ h: inout [Float], _ idx: Int) {
            var i = idx
            while true {
                var s = i
                let l = 2*i+1, r = 2*i+2
                if l < h.count && h[l] < h[s] { s = l }
                if r < h.count && h[r] < h[s] { s = r }
                if s == i { break }
                h.swapAt(i, s); i = s
            }
        }
    }

    // ──────────────────────────────────────────────────────────────
    //  ActivityAggregatorAccel  (exact port)
    //  actigraph = abs(magnitude − movingMedian6(magnitude))
    // ──────────────────────────────────────────────────────────────
    private struct AccelResult {
        let rawActivity: Float
        let actigraph: Float
        let isSomeActivity: Bool
        let isHighActivity: Bool

        var hasNoData: Bool { rawActivity < 0 }
    }

    private final class ActivityAggregatorAccel {
        private let baseline = MovingQuantilePrecise(6, 0.5)
        private let highActivity = HighActivityDetector(multiplier: 1.1)

        func update(_ f: Float) -> AccelResult {
            let actigraph = abs(f - baseline.apply(f))
            let ha = highActivity.update(actigraph)
            return AccelResult(rawActivity: f, actigraph: actigraph,
                               isSomeActivity: ha.isSome, isHighActivity: ha.isHigh)
        }
    }

    // ──────────────────────────────────────────────────────────────
    //  HighActivity.NormalizedAmplitudeBased  (exact port)
    //  medium sensitivity defaults:
    //    someThreshold = 3.0 × multiplier
    //    highThreshold = 4.5 × multiplier
    // ──────────────────────────────────────────────────────────────
    private final class HighActivityDetector {
        private let someThreshold: Float
        private let highThreshold: Float
        private let median720 = MovingQuantileScalable(720, 0.5)
        private let max720    = MovingQuantileScalable(720, 0.995)
        private var callCount = 0

        struct HAResult { let isSome: Bool; let isHigh: Bool }
        private static let none = HAResult(isSome: false, isHigh: false)

        init(multiplier: Float) {
            someThreshold = 3.0 * multiplier
            highThreshold = 4.5 * multiplier
        }

        func update(_ f: Float) -> HAResult {
            callCount += 1
            guard callCount >= 30 else { return Self.none }
            let fAbs = abs(f)
            let med  = median720.apply(fAbs)
            let normalized = med != 0 ? fAbs / med : fAbs
            var amplitude  = max720.apply(normalized)
            guard amplitude > 1 else { return Self.none }
            if callCount < 360 { amplitude = max(100, amplitude) }
            let score = Float(pow(Double(min(amplitude, normalized)),
                                  1.0 / log10(Double(amplitude))))
            return HAResult(isSome: score > someThreshold, isHigh: score > highThreshold)
        }
    }

    private final class MovingSum {
        private let period: Int
        private let buf: FloatRingBuffer
        private var sum: Float = 0

        init(_ period: Int) {
            self.period = period
            self.buf = FloatRingBuffer(period)
        }

        func apply(_ f: Float) -> Float {
            if buf.isFull() { sum -= buf.first() }
            buf.add(f)
            sum += f
            return sum
        }
    }

    private enum SleepPhase {
        case deepSleep
        case lightSleep
        case unknown
    }

    private final class RemDetectorV1 {
        enum Status { case initState, deep, light, rem }

        private(set) var status: Status = .initState
        private var deepStart: Date = .distantPast
        private var lightStart: Date = .distantPast

        func handleAwake() {
            reset()
        }

        func handleDeepSleep(now: Date) {
            switch status {
            case .initState:
                deepStart = now.addingTimeInterval(-minutes(5))
                status = .deep
            case .deep:
                break
            default:
                reset()
            }
        }

        func handleLightSleep(now: Date) {
            switch status {
            case .deep:
                if now.timeIntervalSince(deepStart) <= minutes(15) {
                    reset()
                } else {
                    lightStart = now
                    status = .light
                }
            case .light:
                if now.timeIntervalSince(lightStart) > minutes(10) {
                    status = .rem
                }
            case .rem:
                if now.timeIntervalSince(lightStart) > minutes(20) {
                    reset()
                }
            default:
                reset()
            }
        }

        private func reset() {
            status = .initState
        }

        private func minutes(_ value: Int) -> TimeInterval {
            TimeInterval(value * 60)
        }
    }

    private final class MissingDataGuard {
        private let missingDataCount5min = MovingSum(30)
        private let missingDataCount10min = MovingSum(60)
        private(set) var lastDataMissing = false
        private var missingDataRatio5min: Float = 0
        private var missingDataRatio10min: Float = 0

        var ratio5min: Float { missingDataRatio5min }

        func update(_ result: AccelResult) {
            lastDataMissing = result.hasNoData
            let missing: Float = lastDataMissing ? 1 : 0
            missingDataRatio5min = missingDataCount5min.apply(missing) / 30
            missingDataRatio10min = missingDataCount10min.apply(missing) / 60
        }
    }

    private final class DeepSleepDetectorV8 {
        private let deepSleepIndicator = DeepSleepIndicator(isSmartWatch: false)
        private let sleepPhaseBroadcast = SleepPhaseBroadcast(isAwake: { false })

        var sleepPhase: SleepPhase { deepSleepIndicator.sleepPhase }
        var remStatus: RemDetectorV1.Status { sleepPhaseBroadcast.remStatus }

        func update(timestamp: Date, result: AccelResult) {
            sleepPhaseBroadcast.update(now: timestamp, result: result)
            deepSleepIndicator.update(result)
        }

        private final class DeepSleepIndicator {
            private let isSmartWatch: Bool
            private var missingDataGuard = MissingDataGuard()
            private var highActivityCountShortWindow: MovingSum
            private var someActivityCountLongWindow = MovingSum(30)
            private var pointsCount = 0
            private(set) var sleepPhase: SleepPhase = .unknown

            init(isSmartWatch: Bool) {
                self.isSmartWatch = isSmartWatch
                self.highActivityCountShortWindow = MovingSum(isSmartWatch ? 12 : 6)
            }

            func update(_ result: AccelResult) {
                missingDataGuard.update(result)
                if missingDataGuard.ratio5min > 0.9 {
                    reset()
                    return
                }
                if missingDataGuard.lastDataMissing { return }

                let highActivity = highActivityCountShortWindow.apply(result.isHighActivity ? 1 : 0)
                let someActivity = someActivityCountLongWindow.apply(result.isSomeActivity ? 1 : 0)
                pointsCount += 1
                if pointsCount < 12 {
                    sleepPhase = .unknown
                } else if highActivity.rounded() < 1 ||
                            someActivity.rounded() < Float(smartWakeupSensitivityChecks) {
                    sleepPhase = .deepSleep
                } else {
                    sleepPhase = .lightSleep
                }
            }

            private func reset() {
                missingDataGuard = MissingDataGuard()
                highActivityCountShortWindow = MovingSum(isSmartWatch ? 12 : 6)
                someActivityCountLongWindow = MovingSum(30)
                sleepPhase = .unknown
                pointsCount = 0
            }
        }

        private final class SleepPhaseBroadcast {
            private let isAwake: () -> Bool
            private var deepSleepFrom: Date?
            private var deepSleepReported = false
            private var lastAwake: Date = .distantPast
            private let missingDataGuard = MissingDataGuard()
            private let someActivityCount = MovingSum(30)
            private let highActivityCount = MovingSum(30)
            private let remDetector = RemDetectorV1()

            init(isAwake: @escaping () -> Bool) {
                self.isAwake = isAwake
            }

            var remStatus: RemDetectorV1.Status { remDetector.status }

            func update(now: Date, result: AccelResult) {
                missingDataGuard.update(result)
                if missingDataGuard.lastDataMissing { return }

                let someActivity = Int(someActivityCount.apply(result.isSomeActivity ? 1 : 0).rounded())
                let highActivity = Int(highActivityCount.apply(result.isHighActivity ? 1 : 0).rounded())

                if highActivity < 1 || someActivity < smartWakeupSensitivityChecks {
                    if deepSleepFrom == nil { deepSleepFrom = now }
                    if let deepSleepFrom, now.timeIntervalSince(deepSleepFrom) > minutes(5) {
                        deepSleepReported = true
                        remDetector.handleDeepSleep(now: now)
                    }
                } else {
                    deepSleepFrom = nil
                    if deepSleepReported { deepSleepReported = false }
                    remDetector.handleLightSleep(now: now)
                }

                if isAwake() { lastAwake = now }
                if now.timeIntervalSince(lastAwake) < minutes(3) {
                    remDetector.handleAwake()
                }
            }

            private func minutes(_ value: Int) -> TimeInterval {
                TimeInterval(value * 60)
            }
        }
    }

    private static let smartWakeupSensitivityChecks = 3

    // ──────────────────────────────────────────────────────────────
    //  RespiratoryDetectorV21  (exact port)
    // ──────────────────────────────────────────────────────────────
    private final class RespiratoryDetectorV21 {
        private let sampleRate: Float
        // Constants from constructor
        private let RESP_RATE_FROM  = 8
        private let RESP_RATE_TO    = 20
        private let BREATH_HISTORY  = 10
        private let BREATH_QUORUM_1 = 6
        private let BREATH_QUORUM_2 = 6
        private let APNEA_HISTORY   = 20
        private let APNEA_QUORUM    = 15
        private var maxHistory: Int { max(BREATH_HISTORY, APNEA_HISTORY) }

        final class BreathEvent {
            let timestamp: Date
            let respRate: Int
            var isHighActivity  = false
            var resolvedAsBreath = false
            var resolvedAsApnea  = false
            init(_ ts: Date, _ rate: Int) { timestamp = ts; respRate = rate }
            var isValidRespRate: Bool { respRate > 0 }
        }

        private var history: [BreathEvent] = []
        private let avgSNR    = MovingAvg(10)
        private let lowActivity = MovingMin(5)
        private var currentAvgSNR: Float = 0
        private var medianBuffer   = RollingFloatList(maxSize: 10_000)
        private var thresholdBuffer = RollingFloatList(maxSize: 10_000)
        private var firstCall = true
        private var expectedDataSize = 0

        var breathEvents: [(Date, Int)] = []
        var apneaEvents:  [Date]        = []

        init(sampleRate: Float) { self.sampleRate = sampleRate }

        func detect(_ data: [Float], at now: Date) {
            let minRequired = Int(24 * sampleRate)
            guard data.count >= minRequired else { return }
            if firstCall { expectedDataSize = data.count; firstCall = false }
            else if data.count != expectedDataSize { return }
            doProcess(data, now: now)
        }

        func reset() {
            history.removeAll(); firstCall = true
            medianBuffer.clear(); thresholdBuffer.clear()
            breathEvents.removeAll(); apneaEvents.removeAll()
        }

        private func doProcess(_ data: [Float], now: Date) {
            let cleaned = removePeaks(data)
            let padded  = UrbandroidFFT.padToPow2(cleaned)
            let power   = UrbandroidFFT.powerSpectrum(padded)

            let freqFrom = Double(RESP_RATE_FROM) / 60.0 * 0.5
            let freqTo   = Double(RESP_RATE_TO)   / 60.0 * 4.0
            let fftSize  = UrbandroidFFT.nextPow2(data.count)

            let maxBin = UrbandroidFFT.maxEnergyBin(power, sampleRate: sampleRate,
                                                    freqFrom: freqFrom, freqTo: freqTo)
            var respRate = Int((UrbandroidFFT.binFrequency(maxBin, fftSize: fftSize,
                                                           sampleRate: sampleRate) * 60).rounded())
            if respRate > RESP_RATE_TO { respRate /= 2 }
            let valid = RESP_RATE_FROM <= respRate && respRate <= RESP_RATE_TO

            let event = BreathEvent(now, valid ? respRate : 0)
            detectHighActivity(event, data: data)
            history.append(event)
            while history.count > maxHistory { history.removeFirst() }
            detectBreath()

            let snr: Float
            if event.resolvedAsBreath {
                let eSum  = UrbandroidFFT.energySum(power, sampleRate: sampleRate,
                                                    freqFrom: freqFrom, freqTo: freqTo)
                let nBins = UrbandroidFFT.binCount(power, sampleRate: sampleRate,
                                                   freqFrom: freqFrom, freqTo: freqTo)
                let peak  = Double(power[maxBin])
                snr = eSum > 0 ? Float(peak / (eSum / Double(nBins))) : 2
            } else {
                snr = 2
            }
            currentAvgSNR = avgSNR.apply(snr)
            detectApnea()
        }

        // Step 1 – removePeaks
        private func removePeaks(_ data: [Float]) -> [Float] {
            medianBuffer.addAll(data)
            let globalMedian = percentile50(medianBuffer.toArray())
            let thresh = data.map { globalMedian - $0 }
            thresholdBuffer.addAll(thresh)
            let maxDev = max(1, percentile50(thresholdBuffer.toArray()))
            return data.map { min(max($0 - globalMedian, -maxDev), maxDev) }
        }

        // Step 3 – detectHighActivity
        private func detectHighActivity(_ event: BreathEvent, data: [Float]) {
            let localMedian = percentile50(data)
            let sumDev = data.reduce(0) { $0 + abs($1 - localMedian) }
            event.isHighActivity = sumDev > lowActivity.apply(sumDev) * 1.75
        }

        // Step 4 – detectBreath (quorum)
        private func detectBreath() {
            guard history.count >= BREATH_HISTORY else { return }
            let slice = Array(history.suffix(BREATH_HISTORY))
            let validRates = slice.filter { $0.isValidRespRate }.map { Float($0.respRate) }
            guard validRates.count >= BREATH_QUORUM_1 else { return }
            let medRate = Int(percentile50(validRates).rounded())
            let inWindow = slice.filter { abs($0.respRate - medRate) <= 1 }
            guard inWindow.count >= BREATH_QUORUM_2 else { return }
            for e in inWindow where !e.resolvedAsBreath {
                e.resolvedAsBreath = true
                breathEvents.append((e.timestamp, e.respRate))
            }
        }

        // Step 5 – detectApnea
        private func detectApnea() {
            guard history.count >= APNEA_HISTORY else { return }
            let window = Array(history.suffix(APNEA_HISTORY))
            let last1 = window[window.count - 2]
            let last2 = window[window.count - 3]
            guard last1.resolvedAsBreath && !last2.resolvedAsBreath && !last2.isHighActivity else { return }
            let breathCount = window.filter { $0.resolvedAsBreath }.count
            if breathCount > APNEA_QUORUM && currentAvgSNR > 4.0 {
                last2.resolvedAsApnea = true
                apneaEvents.append(last2.timestamp)
            }
        }

        private func percentile50(_ arr: [Float]) -> Float {
            guard !arr.isEmpty else { return 0 }
            var sorted = arr.sorted()
            let n = sorted.count
            return n % 2 == 1 ? sorted[n / 2] : (sorted[n / 2 - 1] + sorted[n / 2]) / 2
        }
    }

    // ──────────────────────────────────────────────────────────────
    //  Stat helpers
    // ──────────────────────────────────────────────────────────────

    private final class MovingAvg {
        private let period: Int
        private let buf: FloatRingBuffer
        private var sum: Float = 0
        init(_ period: Int) { self.period = period; buf = FloatRingBuffer(period + 1) }
        func apply(_ f: Float) -> Float {
            if buf.isFull() { sum -= buf.first() }
            buf.add(f)
            sum += f
            let n = min(buf.count(), period)
            return n == 0 ? f : sum / Float(n)
        }
    }

    private final class MovingMin {
        private let period: Int
        private let buf: FloatRingBuffer
        private var heap: [Float] = []
        init(_ period: Int) { self.period = period; buf = FloatRingBuffer(period) }
        func apply(_ f: Float) -> Float {
            if buf.isFull() {
                if let idx = heap.firstIndex(of: buf.first()) {
                    heap.remove(at: idx)
                }
            }
            buf.add(f)
            heap.append(f); heap.sort()
            return heap.first ?? f
        }
    }

    private final class RollingFloatList {
        let maxSize: Int
        private var data: [Float] = []
        init(maxSize: Int) { self.maxSize = maxSize }
        func addAll(_ arr: [Float]) { arr.forEach { data.append($0); if data.count > maxSize { data.removeFirst() } } }
        func toArray() -> [Float] { data }
        func clear() { data.removeAll() }
    }

    // ──────────────────────────────────────────────────────────────
    //  Public data types
    // ──────────────────────────────────────────────────────────────

    // ──────────────────────────────────────────────────────────────
    //  State
    // ──────────────────────────────────────────────────────────────

    private struct MotionSample {
        let timestamp: Date
        let x, y, z: Double
        var magnitude: Double { (x*x + y*y + z*z).squareRoot() }
    }

    private var samples:      [MotionSample]     = []
    private var gyroSamples:  [(Date, Double)]   = []
    private let frameInterval: TimeInterval = 10

    // ──────────────────────────────────────────────────────────────
    //  Public API
    // ──────────────────────────────────────────────────────────────

    func addSample(timestamp: Date, x: Double, y: Double, z: Double) {
        let gravity: Double = 9.80665
        let s = MotionSample(timestamp: timestamp, x: x * gravity, y: y * gravity, z: z * gravity)
        samples.append(s)
    }

    func addGyroSample(timestamp: Date, x: Double, y: Double, z: Double) {
        gyroSamples.append((timestamp, (x*x + y*y + z*z).squareRoot()))
    }

    func addAudioLevel(timestamp: Date, levelDbfs: Double, clipped: Bool = false) {
        // Sleep as Android's extracted phase detector does not use audio events
        // for deep/light/REM phase classification.
    }

    func addAudioEvent(timestamp: Date, eventName: String, confidence: Double) {
        // Intentionally ignored; see addAudioLevel.
    }

    func computeStages(sleepStart: Date) -> [SleepStage] {
        guard samples.count >= 2 else { return [] }

        let frames = buildActivityFrames(sleepStart: sleepStart)
        guard !frames.isEmpty else { return [] }

        let detector = DeepSleepDetectorV8()
        var stages: [SleepStage] = []

        for frame in frames {
            detector.update(timestamp: frame.startDate, result: frame.result)
            let type: SleepStageType?
            if detector.remStatus == .rem {
                type = .rem
            } else {
                switch detector.sleepPhase {
                case .deepSleep: type = .deep
                case .lightSleep: type = .light
                case .unknown: type = nil
                }
            }
            if let type {
                appendStage(&stages, type: type, startDate: frame.startDate, endDate: frame.endDate)
            }
        }

        return stages
    }

    func clear() {
        samples.removeAll(); gyroSamples.removeAll()
    }

    private struct ActivityFrame {
        let startDate: Date
        let endDate: Date
        let result: AccelResult
    }

    private func buildActivityFrames(sleepStart: Date) -> [ActivityFrame] {
        let sortedSamples = samples.sorted { $0.timestamp < $1.timestamp }
        guard let sessionEnd = sortedSamples.last?.timestamp else { return [] }

        let aggregator = ActivityAggregatorAccel()
        var frames: [ActivityFrame] = []
        var previousSample: MotionSample?
        var frameStart = sleepStart

        while frameStart.addingTimeInterval(frameInterval) <= sessionEnd {
            let frameEnd = frameStart.addingTimeInterval(frameInterval)
            let frameSamples = sortedSamples.filter { $0.timestamp >= frameStart && $0.timestamp < frameEnd }
            var maxRawChange: Float = 0

            for sample in frameSamples {
                let rawChange: Float = previousSample == nil ? 0 : Float(sample.magnitude)
                if rawChange > maxRawChange { maxRawChange = rawChange }
                previousSample = sample
            }

            let result = frameSamples.isEmpty
                ? AccelResult(rawActivity: -0.001, actigraph: -0.001, isSomeActivity: false, isHighActivity: false)
                : aggregator.update(maxRawChange)
            frames.append(ActivityFrame(startDate: frameStart, endDate: frameEnd, result: result))
            frameStart = frameEnd
        }

        return frames
    }

    private func appendStage(
        _ stages: inout [SleepStage],
        type: SleepStageType,
        startDate: Date,
        endDate: Date
    ) {
        if let last = stages.last,
           last.type == type,
           last.endDate == startDate {
            stages[stages.count - 1] = SleepStage(type: type, startDate: last.startDate, endDate: endDate)
        } else {
            stages.append(SleepStage(type: type, startDate: startDate, endDate: endDate))
        }
    }

}

// MARK: - Comparable clamped helper
extension Comparable {
    func clamped(to range: ClosedRange<Self>) -> Self {
        min(max(self, range.lowerBound), range.upperBound)
    }
}
