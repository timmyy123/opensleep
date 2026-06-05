import Foundation
import Accelerate

/**
 * Phone-only actigraphy + respiratory analyzer.
 *
 * 100% faithful Swift port of Sleep as Android (com.urbandroid.sleep) decompiled logic:
 *
 *  ┌─ FloatRingBuffer          — exact circular buffer (FloatRingBuffer.java)
 *  ├─ MovingQuantilePrecise    — 6-window percentile baseline (Moving.quantilePrecise)
 *  ├─ MovingQuantileScalable   — dual-heap O(log n) streaming quantile (Moving.quantileScalable)
 *  ├─ ActivityAggregatorAccel  — actigraph = abs(f − median6(f)), then HighActivity scoring
 *  ├─ HighActivityDetector     — normalize by 720-window median, score via log-power
 *  └─ RespiratoryDetectorV21   — removePeaks → FFT → quorum breath → apnea (SNR > 4.0)
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
            guard data.count >= 240 else { return }
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
            if buf.isFull() { heap.removeAll { $0 == buf.first() } ; _ = heap.first }
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

    struct AudioEvent {
        let timestamp: Date
        let eventName: String
        let confidence: Double
    }

    private struct AudioSampleItem {
        let timestamp: Date
        let levelDbfs: Double
        let clipped: Bool
    }

    private struct WindowFeatures {
        let startDate: Date
        let endDate: Date
        let actigraphMean: Float
        let actigraphMax: Float
        let isSomeActivity: Bool
        let isHighActivity: Bool
        let breathCountInWindow: Int
        let apneaInWindow: Bool
        let respiratoryRhythm: Float
        let snoreCount: Int
        let gaspCount: Int
        let wakeSoundCount: Int
        let silenceCount: Int
        let rustleCount: Int
        let hasMlAudio: Bool
        let audioMean: Double
        let audioEventsRatio: Double
        let elapsed: TimeInterval
        let artifact: Bool
    }

    private struct WindowPrediction {
        let startDate: Date
        let endDate: Date
        var type: SleepStageType
        let confidence: Double
        let artifact: Bool
    }

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
    private var audioSamples: [AudioSampleItem]  = []
    private var audioEvents:  [AudioEvent]       = []

    private let accelAggregator = ActivityAggregatorAccel()
    private var accelResults:   [(Date, AccelResult)] = []

    private var respiratoryDetector: RespiratoryDetectorV21?
    private var detectedSampleRate: Float = 50

    private let analysisWindowSec: TimeInterval = 30
    private let minPartialWindowSec: TimeInterval = 15
    private let remCycleSec: TimeInterval = 90 * 60
    private let remWindowSec: TimeInterval = 22 * 60
    private let minAccelSamples = 60

    // ──────────────────────────────────────────────────────────────
    //  Public API
    // ──────────────────────────────────────────────────────────────

    func addSample(timestamp: Date, x: Double, y: Double, z: Double) {
        let s = MotionSample(timestamp: timestamp, x: x, y: y, z: z)
        samples.append(s)
        let result = accelAggregator.update(Float(s.magnitude))
        accelResults.append((timestamp, result))
    }

    func addGyroSample(timestamp: Date, x: Double, y: Double, z: Double) {
        gyroSamples.append((timestamp, (x*x + y*y + z*z).squareRoot()))
    }

    func addAudioLevel(timestamp: Date, levelDbfs: Double, clipped: Bool = false) {
        audioSamples.append(AudioSampleItem(timestamp: timestamp,
                                            levelDbfs: min(0, max(-90, levelDbfs)),
                                            clipped: clipped))
    }

    func addAudioEvent(timestamp: Date, eventName: String, confidence: Double) {
        audioEvents.append(AudioEvent(timestamp: timestamp, eventName: eventName, confidence: confidence))
    }

    func computeStages(sleepStart: Date) -> [SleepStage] {
        guard samples.count >= 2, let last = samples.last?.timestamp else { return [] }

        estimateSampleRate()
        let respDetector = getOrCreateRespiratoryDetector()

        var predictions: [WindowPrediction] = []
        var windowStart = sleepStart

        while windowStart < last {
            let windowEnd = min(windowStart.addingTimeInterval(analysisWindowSec), last)
            guard windowEnd.timeIntervalSince(windowStart) >= minPartialWindowSec else { break }
            if let features = buildFeatures(start: windowStart, end: windowEnd,
                                            sleepStart: sleepStart, respDetector: respDetector) {
                predictions.append(predict(features))
            }
            windowStart = windowStart.addingTimeInterval(analysisWindowSec)
        }
        return smoothAndMerge(predictions)
    }

    func clear() {
        samples.removeAll(); gyroSamples.removeAll()
        audioSamples.removeAll(); audioEvents.removeAll()
        accelResults.removeAll(); respiratoryDetector = nil
    }

    // ──────────────────────────────────────────────────────────────
    //  Internal pipeline
    // ──────────────────────────────────────────────────────────────

    private func estimateSampleRate() {
        guard samples.count >= 10 else { return }
        let recent = Array(samples.suffix(min(200, samples.count)))
        let diffs = zip(recent.dropFirst(), recent).map { Float($0.timestamp.timeIntervalSince($1.timestamp)) }
        let avgInterval = diffs.reduce(0, +) / Float(diffs.count)
        if avgInterval > 0 { detectedSampleRate = 1 / avgInterval }
    }

    private func getOrCreateRespiratoryDetector() -> RespiratoryDetectorV21 {
        if let det = respiratoryDetector { det.reset(); return det }
        let det = RespiratoryDetectorV21(sampleRate: detectedSampleRate)
        respiratoryDetector = det
        return det
    }

    private func buildFeatures(start: Date, end: Date,
                                sleepStart: Date,
                                respDetector: RespiratoryDetectorV21) -> WindowFeatures? {

        let accelWindow  = samples.filter { $0.timestamp >= start && $0.timestamp < end }
        let audioWindow  = audioSamples.filter { $0.timestamp >= start && $0.timestamp < end }
        let windowEvts   = audioEvents.filter { $0.timestamp >= start && $0.timestamp < end }
        let accelResWin  = accelResults.filter { $0.0 >= start && $0.0 < end }

        // Audio ML event counts
        let hasMlAudio   = !windowEvts.isEmpty
        let snoreCount   = windowEvts.filter { $0.eventName == "snoring" || $0.eventName == "snort" }.count
        let breathCount  = windowEvts.filter { $0.eventName == "breathing" }.count
        let rustleCount  = windowEvts.filter { $0.eventName == "rustle" }.count
        let gaspCount    = windowEvts.filter { $0.eventName == "gasp" || $0.eventName == "sigh" || $0.eventName == "cough" }.count
        let wakeCount    = windowEvts.filter { $0.eventName == "speech" || $0.eventName == "laughter" }.count
        let silenceCount = windowEvts.filter { $0.eventName == "silence" }.count

        let audioMeanDb  = audioWindow.isEmpty ? -65.0 : audioWindow.map { $0.levelDbfs }.reduce(0,+) / Double(audioWindow.count)
        let audioEvRatio = Double(audioWindow.filter { $0.levelDbfs > -38 || $0.clipped }.count) / Double(max(1, audioWindow.count))
        let audioMean    = normalizeLinear(audioMeanDb, low: -62, high: -30)

        // ActivityAggregatorAccel results
        let actigraphs      = accelResWin.map { $0.1.actigraph }
        let actigraphMean   = actigraphs.isEmpty ? 0 : actigraphs.reduce(0,+) / Float(actigraphs.count)
        let actigraphMax    = actigraphs.max() ?? 0
        let isSomeActivity  = accelResWin.contains { $0.1.isSomeActivity }
        let isHighActivity  = accelResWin.contains { $0.1.isHighActivity }

        let magnitudes = accelWindow.map { Float($0.magnitude) }
        let range = (magnitudes.max() ?? 0) - (magnitudes.min() ?? 0)
        let artifact = accelWindow.count < minAccelSamples || range > 3.5 ||
                       isHighActivity || audioEvRatio > 0.75

        // RespiratoryDetectorV21
        let breathsBefore = respDetector.breathEvents.count
        let apneaBefore   = respDetector.apneaEvents.count
        if accelWindow.count >= 240 {
            let rawData = accelWindow.map { Float($0.magnitude) }
            respDetector.detect(rawData, at: end)
        }
        let newBreaths = respDetector.breathEvents.dropFirst(breathsBefore)
        let newApnea   = respDetector.apneaEvents.dropFirst(apneaBefore)
        let breathCountInWindow = newBreaths.count + breathCount
        let apneaInWindow = !newApnea.isEmpty

        let respiratoryRhythm = Float((newBreaths.isEmpty && breathCount == 0) ? 0 :
            Double(newBreaths.count) / Double(max(1, newBreaths.count + gaspCount))).clamped(to: 0...1)

        if accelWindow.count < 2 {
            return WindowFeatures(
                startDate: start, endDate: end,
                actigraphMean: 0, actigraphMax: 0,
                isSomeActivity: false, isHighActivity: false,
                breathCountInWindow: breathCountInWindow,
                apneaInWindow: apneaInWindow,
                respiratoryRhythm: respiratoryRhythm,
                snoreCount: 0, gaspCount: 0, wakeSoundCount: 0,
                silenceCount: 0, rustleCount: 0, hasMlAudio: false,
                audioMean: audioMean, audioEventsRatio: audioEvRatio,
                elapsed: start.timeIntervalSince(sleepStart), artifact: false
            )
        }

        return WindowFeatures(
            startDate: start, endDate: end,
            actigraphMean: actigraphMean, actigraphMax: actigraphMax,
            isSomeActivity: isSomeActivity, isHighActivity: isHighActivity,
            breathCountInWindow: breathCountInWindow, apneaInWindow: apneaInWindow,
            respiratoryRhythm: respiratoryRhythm,
            snoreCount: snoreCount, gaspCount: gaspCount, wakeSoundCount: wakeCount,
            silenceCount: silenceCount, rustleCount: rustleCount,
            hasMlAudio: hasMlAudio, audioMean: audioMean, audioEventsRatio: audioEvRatio,
            elapsed: start.timeIntervalSince(sleepStart), artifact: artifact
        )
    }

    private func predict(_ f: WindowFeatures) -> WindowPrediction {
        if f.artifact || f.isHighActivity {
            return WindowPrediction(startDate: f.startDate, endDate: f.endDate,
                                    type: .awake, confidence: 0.55, artifact: true)
        }

        if f.hasMlAudio {
            let actigraphNorm = normalizeLog(Double(f.actigraphMean), low: 0.00001, high: 0.06)
            let movement = actigraphNorm

            let stage: SleepStageType
            if movement >= 0.08 && (f.rustleCount > 0 || f.breathCountInWindow > 0 ||
                f.wakeSoundCount > 0 || f.snoreCount > 0 || f.gaspCount > 0) {
                stage = .awake
            } else if movement > 0.01 && movement < 0.08 &&
                (f.rustleCount > 0 || f.snoreCount > 0 || f.gaspCount > 0 || f.silenceCount > 0) {
                stage = .light
            } else if f.apneaInWindow && movement <= 0.01 {
                stage = .rem
            } else if movement <= 0.01 &&
                (Double(f.respiratoryRhythm) >= 0.6 || f.breathCountInWindow >= 3 || f.silenceCount >= 5) &&
                f.gaspCount == 0 && f.rustleCount == 0 && f.wakeSoundCount == 0 {
                stage = .deep
            } else if movement <= 0.01 &&
                (f.gaspCount > 0 || (1...2).contains(f.breathCountInWindow) ||
                 (0.1...0.5).contains(Double(f.respiratoryRhythm))) {
                stage = .rem
            } else {
                if movement >= 0.08 { stage = .awake }
                else if movement > 0.01 { stage = .light }
                else if Double(f.respiratoryRhythm) >= 0.5 || f.breathCountInWindow > 0 { stage = .deep }
                else { stage = .light }
            }
            return WindowPrediction(startDate: f.startDate, endDate: f.endDate,
                                    type: stage, confidence: 0.85, artifact: false)
        }

        // Actigraphy-only fallback
        let elapsedHours  = f.elapsed / 3600
        let earlyNight    = min(1, max(0, 1 - elapsedHours / 3))
        let lateNight     = min(1, max(0, (elapsedHours - 3) / 4))
        let remCycle      = remCycleAffinity(f.elapsed)
        let actigraphNorm = normalizeLog(Double(f.actigraphMean), low: 0.00001, high: 0.06)
        let isSome        = f.isSomeActivity ? 1.0 : 0.0
        let motionWake    = min(1, actigraphNorm * 0.7 + isSome * 0.3)
        let stillness     = 1 - motionWake
        let sleepCont     = f.elapsed < 10 * 60 ? 0.25 : 1.0

        let awakeScore = -0.9 + motionWake * 3.1 + f.audioEventsRatio * 1.4 + f.audioMean * 0.45
        let deepScore  = (-0.2 + stillness * 1.9 + earlyNight * 1.0 - remCycle * 0.55 -
                          motionWake * 1.8 - lateNight * 0.8) * sleepCont
        var remScore   = (-1.15 + stillness * 1.25 + remCycle * 1.7 + lateNight * 0.85 -
                          motionWake * 1.1 - earlyNight * 0.35) * sleepCont
        if f.elapsed < 45 * 60 { remScore -= 0.9 }
        let lightScore = 0.25 + stillness * 0.85 + motionWake * 0.45 - f.audioEventsRatio * 0.3

        let scores: [(SleepStageType, Double)] = [(.awake, awakeScore), (.light, lightScore),
                                                   (.deep, deepScore),  (.rem, remScore)]
        let ranked = scores.sorted { $0.1 > $1.1 }
        let conf   = softmaxConfidence(winner: ranked[0].1, scores: scores.map { $0.1 })
        return WindowPrediction(startDate: f.startDate, endDate: f.endDate,
                                type: ranked[0].0, confidence: conf, artifact: false)
    }

    private func smoothAndMerge(_ predictions: [WindowPrediction]) -> [SleepStage] {
        guard !predictions.isEmpty else { return [] }
        var smoothed = predictions
        for i in smoothed.indices {
            guard i > smoothed.startIndex, i < smoothed.index(before: smoothed.endIndex) else { continue }
            let prev = smoothed[smoothed.index(before: i)]
            let cur  = smoothed[i]
            let next = smoothed[smoothed.index(after: i)]
            if prev.type == next.type && cur.type != prev.type &&
               cur.confidence < 0.60 && !cur.artifact {
                smoothed[i].type = prev.type
            }
        }
        var stages: [SleepStage] = []
        for p in smoothed {
            if let last = stages.last, last.type == p.type {
                stages[stages.count - 1] = SleepStage(type: p.type,
                    startDate: last.startDate, endDate: p.endDate)
            } else {
                stages.append(SleepStage(type: p.type, startDate: p.startDate, endDate: p.endDate))
            }
        }
        return stages
    }

    private func remCycleAffinity(_ elapsed: TimeInterval) -> Double {
        guard elapsed >= 45 * 60 else { return 0 }
        let modulo   = elapsed.truncatingRemainder(dividingBy: remCycleSec)
        let distance = min(modulo, remCycleSec - modulo)
        return min(1, max(0, 1 - distance / remWindowSec))
    }

    private func normalizeLinear(_ v: Double, low: Double, high: Double) -> Double {
        min(1, max(0, (v - low) / (high - low)))
    }

    private func normalizeLog(_ v: Double, low: Double, high: Double) -> Double {
        let sv = max(v, low)
        return min(1, max(0, (log(sv) - log(low)) / (log(high) - log(low))))
    }

    private func softmaxConfidence(winner: Double, scores: [Double]) -> Double {
        let mx = scores.max() ?? winner
        let exps = scores.map { Foundation.exp($0 - mx) }
        let denom = exps.reduce(0, +)
        guard denom > 0 else { return 0.25 }
        return min(0.98, max(0.25, Foundation.exp(winner - mx) / denom))
    }
}

// MARK: - Comparable clamped helper
extension Comparable {
    func clamped(to range: ClosedRange<Self>) -> Self {
        min(max(self, range.lowerBound), range.upperBound)
    }
}
