package app.opensleep.domain

import app.opensleep.data.local.SleepStage
import app.opensleep.data.local.SleepStageType
import kotlin.math.abs
import kotlin.math.exp
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Phone-only actigraphy + respiratory analyzer.
 *
 * 100% faithful port of Sleep as Android (com.urbandroid.sleep) decompiled logic:
 *
 *  ┌─ FloatRingBuffer          — exact circular buffer (snoring/feature/FloatRingBuffer.java)
 *  ├─ MovingQuantilePrecise    — 6-window percentile baseline (Moving.quantilePrecise)
 *  ├─ MovingQuantileScalable   — dual-heap O(log n) streaming quantile (Moving.quantileScalable)
 *  ├─ ActivityAggregatorAccel  — actigraph = abs(f − median6(f)), then HighActivity scoring
 *  ├─ HighActivity.NormalizedAmplitudeBased — normalize by 720-window median, score via log-power
 *  └─ RespiratoryDetectorV21   — removePeaks → FFT → quorum breath → apnea (SNR > 4.0)
 */
class SleepStageAnalyzer {

    // ──────────────────────────────────────────────────────────────
    //  FloatRingBuffer  (exact port of FloatRingBuffer.java)
    // ──────────────────────────────────────────────────────────────
    private class FloatRingBuffer(val maxSize: Int) {
        init { require(maxSize > 0) }
        private val values = FloatArray(maxSize)
        private var size = 0
        private var lastIndex = -1

        fun add(f: Float) {
            lastIndex++
            if (lastIndex >= maxSize) lastIndex = 0
            values[lastIndex] = f
            if (size < maxSize) size++
        }
        fun first(): Float {
            check(size > 0)
            return get(0)  // oldest element
        }
        fun last(): Float {
            check(size > 0); return values[lastIndex]
        }
        fun get(i: Int): Float {
            require(i in 0 until size) { "$i >= $size" }
            return values[(lastIndex - size + 1 + i + maxSize * 2) % maxSize]
        }
        fun size() = size
        fun isFull() = size == maxSize
        fun toArray(): FloatArray = FloatArray(size) { get(it) }
    }

    // ──────────────────────────────────────────────────────────────
    //  Moving.quantilePrecise(period=6, quantile=0.5)
    //  Used by ActivityAggregatorAccel for baseline.
    //  Uses Apache-commons-style linear-interpolation percentile.
    // ──────────────────────────────────────────────────────────────
    private class MovingQuantilePrecise(private val period: Int, private val quantile: Float) {
        private val history = FloatRingBuffer(period)

        fun apply(f: Float): Float {
            history.add(f)
            val arr = history.toArray().also { it.sort() }
            return percentile(arr, quantile * 100f)
        }

        // Apache Commons Math linear-interpolation percentile (used by ScienceUtil.percentile)
        private fun percentile(sorted: FloatArray, p: Float): Float {
            if (sorted.isEmpty()) return 0f
            if (sorted.size == 1) return sorted[0]
            val n = sorted.size
            val rank = (p / 100f) * (n + 1)  // C=1 variant used by Apache
            return when {
                rank < 1 -> sorted[0]
                rank >= n -> sorted[n - 1]
                else -> {
                    val lower = rank.toInt() - 1
                    val frac = rank - rank.toInt()
                    sorted[lower] + frac * (sorted[lower + 1] - sorted[lower])
                }
            }
        }
    }

    // ──────────────────────────────────────────────────────────────
    //  Moving.quantileScalable(period, quantile)
    //  Dual max-heap / min-heap O(log n) streaming quantile.
    //  period=720 for HighActivity (≈2h at 10s framerate).
    //  quantile=0.5 → median; 0.995 → near-max.
    // ──────────────────────────────────────────────────────────────
    private class MovingQuantileScalable(private val period: Int, private val quantile: Float) {
        // history size = period so we track exactly `period` oldest values for eviction
        private val history = FloatRingBuffer(period)
        // low = max-heap (stores values ≤ quantile boundary, negated for PriorityQueue)
        private val low = java.util.PriorityQueue<Float>(compareByDescending { it })
        // high = min-heap (stores values > quantile boundary)
        private val high = java.util.PriorityQueue<Float>()

        private fun peek(): Float = (if (low.isEmpty()) high else low).peek()!!
        private fun heapSize() = low.size + high.size

        fun apply(f: Float): Float {
            // Evict oldest if window is full BEFORE adding the new value
            if (history.isFull()) {
                val oldest = history.first()
                if (!low.remove(oldest)) high.remove(oldest)
            }
            // Insert new value into the correct heap
            if (heapSize() == 0 || f <= peek()) low.add(f) else high.add(f)
            history.add(f)
            // Rebalance: low should hold exactly round(quantile * total) elements
            val target = Math.round(quantile * heapSize())
            while (low.isNotEmpty() && low.size > target) high.add(low.poll()!!)
            while (high.isNotEmpty() && low.size < target) low.add(high.poll()!!)
            return if (heapSize() == 0) 0f else peek()
        }
    }

    // ──────────────────────────────────────────────────────────────
    //  ActivityAggregatorAccel  (exact port)
    //  actigraph = abs(magnitude − movingMedian6(magnitude))
    //  then HighActivity normalization
    // ──────────────────────────────────────────────────────────────
    private class ActivityAggregatorAccel {
        // Moving.quantilePrecise(6, 0.5) — 6-sample rolling median baseline
        private val baseline = MovingQuantilePrecise(6, 0.5f)
        // HighActivity.normalizedAmplitudeBased(1.1) for phone accelerometer
        private val highActivity = HighActivityDetector(1.1f)

        data class Result(
            val rawActivity: Float,
            val actigraph: Float,
            val isSomeActivity: Boolean,
            val isHighActivity: Boolean
        )

        fun update(f: Float): Result {
            val actigraph = abs(f - baseline.apply(f))
            val ha = highActivity.update(actigraph)
            return Result(f, actigraph, ha.isSomeActivity, ha.isHighActivity)
        }
    }

    // ──────────────────────────────────────────────────────────────
    //  HighActivity.NormalizedAmplitudeBased  (exact port)
    //
    //  Sensitivity defaults used when no SharedPreferences present:
    //    someThreshold  = 3.0 * multiplier  (medium sensitivity)
    //    highThreshold  = 4.5 * multiplier
    //
    //  Normalization:
    //    normalized = abs(f) / median720(abs(f))
    //    amplitude  = max720(normalized)              ← near-max of normalized signal
    //    score      = (min(amplitude, normalized))^(1/log10(amplitude))
    //    isSome     = score > someThreshold
    //    isHigh     = score > highThreshold
    // ──────────────────────────────────────────────────────────────
    private class HighActivityDetector(multiplier: Float) {
        // Medium sensitivity defaults (mapDeepSleepSensitivity medium values)
        private val someThreshold = 3.0f * multiplier
        private val highThreshold = 4.5f * multiplier
        // period=720 ≈ 2 hours at 10s framerate
        private val median720 = MovingQuantileScalable(720, 0.5f)
        private val max720    = MovingQuantileScalable(720, 0.995f)
        private var callCount = 0

        data class Result(val isSomeActivity: Boolean, val isHighActivity: Boolean)
        private val RESULT_NONE = Result(false, false)

        fun update(f: Float): Result {
            callCount++
            return if (callCount >= 30) doUpdate(f) else RESULT_NONE
        }

        private fun doUpdate(f: Float): Result {
            val fAbs = abs(f)
            val med = median720.apply(fAbs)
            // Normalize: if median is 0 don't divide
            val normalized = if (med != 0f) fAbs / med else fAbs
            var amplitude = max720.apply(normalized)
            if (amplitude <= 1f) return RESULT_NONE
            // Warmup: first 360 calls clamp amplitude to at least 100
            if (callCount < 360) amplitude = max(100f, amplitude)
            val score = min(amplitude, normalized).toDouble()
                .pow(1.0 / log10(amplitude.toDouble()))
                .toFloat()
            return Result(score > someThreshold, score > highThreshold)
        }
    }

    // ──────────────────────────────────────────────────────────────
    //  RespiratoryDetectorV21  (exact port)
    //  Receives raw accel magnitude arrays (one 30s window worth of samples)
    //  Outputs breath events and apnea flags via callbacks.
    // ──────────────────────────────────────────────────────────────
    private inner class RespiratoryDetectorV21(private val sampleRate: Float) {
        // Constants from constructor
        private val RESP_RATE_FROM = 8          // BPM min
        private val RESP_RATE_TO   = 20         // BPM max
        private val BREATH_HISTORY  = 10
        private val BREATH_QUORUM_1 = 6
        private val BREATH_QUORUM_2 = 6
        private val APNEA_HISTORY   = 20
        private val APNEA_BREATH_QUORUM = 15
        private val MAX_HISTORY = max(BREATH_HISTORY, APNEA_HISTORY)  // 20

        inner class BreathEvent(val timestamp: Long, val respRate: Int) {
            var isHighActivity = false
            var resolvedAsBreath = false
            var resolvedAsApnea = false
            fun isValidRespRate() = respRate > 0
        }

        private val history = mutableListOf<BreathEvent>()

        // Moving.avg(10) for SNR tracking
        private val avgSNR = MovingAvg(10)
        private var currentAvgSNR = 0f

        // Moving.min(5) for high-activity detection
        private val lowActivity = MovingMin(5)

        // Rolling buffers for removePeaks (10000 samples)
        private val medianBuffer = RollingFloatList(10_000)
        private val thresholdBuffer = RollingFloatList(10_000)

        private var firstCall = true
        private var expectedDataSize = 0

        // Callbacks
        val breathEvents = mutableListOf<Pair<Long, Int>>()   // (timestamp, respRate)
        val apneaEvents  = mutableListOf<Long>()

        fun detect(data: FloatArray, nowMs: Long) {
            val minRequired = (24 * sampleRate).toInt()
            if (data.size < minRequired) return
            if (firstCall) {
                expectedDataSize = data.size
                firstCall = false
            } else if (data.size != expectedDataSize) return
            doProcess(data, nowMs)
        }

        fun reset() {
            history.clear(); firstCall = true
            medianBuffer.clear(); thresholdBuffer.clear()
            breathEvents.clear(); apneaEvents.clear()
        }

        private fun doProcess(data: FloatArray, nowMs: Long) {
            val cleaned = removePeaks(data)
            val power = computePowerSpectrum(cleaned)

            val freqFrom = (RESP_RATE_FROM.toDouble() / 60.0) * 0.5   // lower edge Hz
            val freqTo   = (RESP_RATE_TO.toDouble()   / 60.0) * 4.0   // upper edge Hz

            val maxBin = UrbandroidFFT.maxEnergyBin(
                power.map { it }.toFloatArray(), sampleRate, freqFrom, freqTo
            )
            val fftSize = UrbandroidFFT.nextPow2(data.size)
            var respRate = (UrbandroidFFT.binFrequency(maxBin, fftSize, sampleRate) * 60.0).toInt()
            // Sub-harmonic correction (mirrors: if respRate > RESP_RATE_TO: respRate /= 2)
            if (respRate > RESP_RATE_TO) respRate /= 2
            val valid = respRate in RESP_RATE_FROM..RESP_RATE_TO

            val event = BreathEvent(nowMs, if (valid) respRate else 0)
            detectHighActivity(event, data)
            history.add(event)
            while (history.size > MAX_HISTORY) history.removeAt(0)

            detectBreath()

            // SNR = energy(maxBin) / mean_energy_in_band
            val snr = if (event.resolvedAsBreath) {
                val eSum = UrbandroidFFT.energySum(
                    power.map { it }.toFloatArray(), sampleRate, freqFrom, freqTo
                )
                val nBins = UrbandroidFFT.binCount(
                    power.map { it }.toFloatArray(), sampleRate, freqFrom, freqTo
                )
                val peakEnergy = power.getOrElse(maxBin) { 0f }.toDouble()
                if (eSum > 0) (peakEnergy / (eSum / nBins)).toFloat() else 2f
            } else 2f
            currentAvgSNR = avgSNR.apply(snr)

            detectApnea()
        }

        // Step 1 – removePeaks (exact port)
        private fun removePeaks(data: FloatArray): FloatArray {
            medianBuffer.addAll(data)
            val globalMedian = percentile50(medianBuffer.toFloatArray())
            val thresh = FloatArray(data.size) { globalMedian - data[it] }
            thresholdBuffer.addAll(thresh)
            val maxDev = max(1f, percentile50(thresholdBuffer.toFloatArray()))
            return FloatArray(data.size) { (data[it] - globalMedian).coerceIn(-maxDev, maxDev) }
        }

        // Step 2 – power spectrum
        private fun computePowerSpectrum(data: FloatArray): FloatArray {
            val padded = UrbandroidFFT.padToPow2(data)
            UrbandroidFFT.realForward(padded)
            return UrbandroidFFT.powerSpectrum(padded)
        }

        // Step 3 – detectHighActivity
        private fun detectHighActivity(event: BreathEvent, data: FloatArray) {
            val localMedian = percentile50(data)
            val sumDev = data.sumOf { abs(it - localMedian).toDouble() }.toFloat()
            event.isHighActivity = sumDev > lowActivity.apply(sumDev) * 1.75f
        }

        // Step 4 – detectBreath (quorum voting)
        private fun detectBreath() {
            if (history.size < BREATH_HISTORY) return
            val slice = history.takeLast(BREATH_HISTORY)
            val validRates = slice.filter { it.isValidRespRate() }.map { it.respRate.toFloat() }
            if (validRates.size < BREATH_QUORUM_1) return
            val medRate = percentile50(validRates.toFloatArray()).toInt()
            val inWindow = slice.filter { it.respRate in (medRate - 1)..(medRate + 1) }
            if (inWindow.size < BREATH_QUORUM_2) return
            for (e in inWindow) {
                if (!e.resolvedAsBreath) {
                    e.resolvedAsBreath = true
                    breathEvents.add(e.timestamp to e.respRate)
                }
            }
        }

        // Step 5 – detectApnea
        private fun detectApnea() {
            if (history.size < APNEA_HISTORY) return
            val window = history.takeLast(APNEA_HISTORY)
            // Indices from end: last[1]=window[last-1], last[2]=window[last-2] (0-indexed from end)
            val last1 = window[window.size - 2]  // second-to-last
            val last2 = window[window.size - 3]  // third-to-last
            if (!last1.resolvedAsBreath || last2.resolvedAsBreath || last2.isHighActivity) return
            val breathCount = window.count { it.resolvedAsBreath }
            if (breathCount > APNEA_BREATH_QUORUM && currentAvgSNR > 4f) {
                last2.resolvedAsApnea = true
                apneaEvents.add(last2.timestamp)
            }
        }

        // Sorted 50th percentile (used throughout)
        private fun percentile50(arr: FloatArray): Float {
            if (arr.isEmpty()) return 0f
            val sorted = arr.copyOf().also { it.sort() }
            val n = sorted.size
            return if (n % 2 == 1) sorted[n / 2]
            else (sorted[n / 2 - 1] + sorted[n / 2]) / 2f
        }
    }

    // ──────────────────────────────────────────────────────────────
    //  Helper stat functions
    // ──────────────────────────────────────────────────────────────

    private class MovingAvg(private val period: Int) {
        // Buffer holds period+1 so we can read both first() and last() when full
        private val buf = FloatRingBuffer(period + 1)
        private var sum = 0f
        fun apply(f: Float): Float {
            if (buf.isFull()) {
                // Evict oldest from sum before adding new
                sum -= buf.first()
            }
            buf.add(f)
            sum += f
            // When not yet full buf.size() is the actual count; divide by that
            val n = if (buf.size() <= period) buf.size() else period
            return if (n == 0) f else sum / n
        }
    }

    private class MovingMin(private val period: Int) {
        private val buf = FloatRingBuffer(period)
        private val heap = java.util.PriorityQueue<Float>()
        fun apply(f: Float): Float {
            if (buf.isFull()) heap.remove(buf.first())
            buf.add(f); heap.add(f)
            return heap.peek()!!
        }
    }

    /** Append-only rolling list capped at maxSize (drops oldest). */
    private class RollingFloatList(private val maxSize: Int) {
        private val data = ArrayDeque<Float>(maxSize)
        fun addAll(arr: FloatArray) { arr.forEach { add(it) } }
        fun add(f: Float) { data.addLast(f); if (data.size > maxSize) data.removeFirst() }
        fun toFloatArray() = data.toFloatArray()
        fun clear() = data.clear()
    }

    // ──────────────────────────────────────────────────────────────
    //  Public data types
    // ──────────────────────────────────────────────────────────────

    data class MotionSample(val timestampMs: Long, val x: Float, val y: Float, val z: Float) {
        val magnitude get() = sqrt(x * x + y * y + z * z)
    }

    data class AudioSample(val timestampMs: Long, val levelDbfs: Float, val clipped: Boolean = false)

    data class AudioEvent(val timestampMs: Long, val eventName: String, val confidence: Float)

    // ──────────────────────────────────────────────────────────────
    //  Internal window types
    // ──────────────────────────────────────────────────────────────

    private data class WindowFeatures(
        val startMs: Long,
        val endMs: Long,
        // ActivityAggregatorAccel results
        val actigraphMean: Float,
        val actigraphMax: Float,
        val isSomeActivity: Boolean,
        val isHighActivity: Boolean,
        // Respiratory
        val breathCountInWindow: Int,
        val apneaInWindow: Boolean,
        val respiratoryRhythm: Float,   // 0..1, from quorum scoring
        // Audio ML events
        val snoreCount: Int,
        val gaspCount: Int,
        val wakeSoundCount: Int,
        val silenceCount: Int,
        val rustleCount: Int,
        val hasMlAudio: Boolean,
        // Raw audio
        val audioMean: Float,
        val audioEventsRatio: Float,
        // Timing
        val elapsedMs: Long,
        val artifact: Boolean
    )

    private data class WindowPrediction(
        val startMs: Long, val endMs: Long,
        val type: SleepStageType,
        val confidence: Float,
        val artifact: Boolean
    )

    // ──────────────────────────────────────────────────────────────
    //  Sensor data stores
    // ──────────────────────────────────────────────────────────────

    private val samples      = mutableListOf<MotionSample>()
    private val gyroSamples  = mutableListOf<Pair<Long, Float>>()
    private val audioSamples = mutableListOf<AudioSample>()
    private val audioEvents  = mutableListOf<AudioEvent>()

    // One aggregator that runs per-sample continuously (mirrors SleepService flow)
    private val accelAggregator = ActivityAggregatorAccel()
    private val accelResults    = mutableListOf<Pair<Long, ActivityAggregatorAccel.Result>>()

    // Respiratory detector — sampleRate will be set on first window
    private var respiratoryDetector: RespiratoryDetectorV21? = null
    private var detectedSampleRate = 50f  // default Hz; recalculated from actual data

    companion object {
        private const val ANALYSIS_WINDOW_MS    = 30 * 1000L
        private const val MIN_PARTIAL_WINDOW_MS = 15 * 1000L
        private const val REM_CYCLE_MS          = 90 * 60 * 1000L
        private const val REM_WINDOW_MS         = 22 * 60 * 1000L
        private const val MIN_ACCEL_SAMPLES     = 60
    }

    // ──────────────────────────────────────────────────────────────
    //  Public API
    // ──────────────────────────────────────────────────────────────

    fun addSample(timestampMs: Long, x: Float, y: Float, z: Float) {
        val s = MotionSample(timestampMs, x, y, z)
        samples.add(s)
        // Feed into the continuous aggregator (mirrors SleepService real-time pipeline)
        val result = accelAggregator.update(s.magnitude)
        accelResults.add(timestampMs to result)
    }

    fun addGyroSample(timestampMs: Long, x: Float, y: Float, z: Float) {
        val magnitude = sqrt(x * x + y * y + z * z)
        gyroSamples.add(timestampMs to magnitude)
    }

    fun addAudioLevel(timestampMs: Long, levelDbfs: Float, clipped: Boolean = false) {
        audioSamples.add(AudioSample(timestampMs, levelDbfs.coerceIn(-90f, 0f), clipped))
    }

    fun addAudioEvent(timestampMs: Long, eventName: String, confidence: Float) {
        audioEvents.add(AudioEvent(timestampMs, eventName, confidence))
    }

    fun computeStages(sleepStartMs: Long): List<SleepStage> {
        if (samples.size < 2) return emptyList()

        // Estimate sample rate from actual data
        estimateSampleRate()

        val predictions = mutableListOf<WindowPrediction>()
        val windowEnd = samples.last().timestampMs
        var windowStart = sleepStartMs

        // Re-run respiratory detector over all windows sequentially
        val respDetector = getOrCreateRespiratoryDetector()

        while (windowStart < windowEnd) {
            val candidateEnd = min(windowStart + ANALYSIS_WINDOW_MS, windowEnd)
            if (candidateEnd - windowStart < MIN_PARTIAL_WINDOW_MS) break

            buildFeatures(windowStart, candidateEnd, sleepStartMs, respDetector)?.let {
                predictions.add(predict(it))
            }
            windowStart += ANALYSIS_WINDOW_MS
        }

        return smoothAndMerge(predictions)
    }

    fun clear() {
        samples.clear(); gyroSamples.clear()
        audioSamples.clear(); audioEvents.clear()
        accelResults.clear()
        respiratoryDetector = null
    }

    // ──────────────────────────────────────────────────────────────
    //  Internal pipeline
    // ──────────────────────────────────────────────────────────────

    private fun estimateSampleRate() {
        if (samples.size < 10) return
        val recent = samples.takeLast(min(200, samples.size))
        val diffs = recent.zipWithNext { a, b -> (b.timestampMs - a.timestampMs).toFloat() }
        val avgMs = diffs.average().toFloat()
        if (avgMs > 0) detectedSampleRate = 1000f / avgMs
    }

    private fun getOrCreateRespiratoryDetector(): RespiratoryDetectorV21 {
        val det = respiratoryDetector
        return if (det != null) {
            det.reset(); det
        } else {
            RespiratoryDetectorV21(detectedSampleRate).also { respiratoryDetector = it }
        }
    }

    private fun buildFeatures(
        startMs: Long, endMs: Long, sleepStartMs: Long,
        respDetector: RespiratoryDetectorV21
    ): WindowFeatures? {

        val accelWindow = samples.filter { it.timestampMs in startMs until endMs }
        val audioWindow = audioSamples.filter { it.timestampMs in startMs until endMs }
        val windowEvts  = audioEvents.filter { it.timestampMs in startMs until endMs }
        val accelResultWindow = accelResults.filter { it.first in startMs until endMs }

        // ── Audio ML event counts ──────────────────────────────
        val hasMlAudio    = windowEvts.isNotEmpty()
        val snoreCount    = windowEvts.count { it.eventName == "snoring" || it.eventName == "snort" }
        val breathCount   = windowEvts.count { it.eventName == "breathing" }
        val rustleCount   = windowEvts.count { it.eventName == "rustle" }
        val gaspCount     = windowEvts.count { it.eventName in listOf("gasp","sigh","cough") }
        val wakeCount     = windowEvts.count { it.eventName == "speech" || it.eventName == "laughter" }
        val silenceCount  = windowEvts.count { it.eventName == "silence" }

        // Raw audio
        val audioMeanDb  = if (audioWindow.isEmpty()) -65f
                           else audioWindow.map { it.levelDbfs }.average().toFloat()
        val audioEvRatio = audioWindow.count { it.levelDbfs > -38f || it.clipped }.toFloat() /
                           max(1, audioWindow.size)
        val audioMean    = normalizeLinear(audioMeanDb, -62f, -30f)

        // ── ActivityAggregatorAccel results for this window ────
        val actigraphs = accelResultWindow.map { it.second.actigraph }
        val actigraphMean = if (actigraphs.isEmpty()) 0f else actigraphs.average().toFloat()
        val actigraphMax  = actigraphs.maxOrNull() ?: 0f
        val isSomeActivity = accelResultWindow.any { it.second.isSomeActivity }
        val isHighActivity = accelResultWindow.any { it.second.isHighActivity }

        // Artifact: too few samples, extreme range, or extreme audio ratio
        val magnitudes = accelWindow.map { it.magnitude }
        val range = (magnitudes.maxOrNull() ?: 0f) - (magnitudes.minOrNull() ?: 0f)
        val artifact = accelWindow.size < MIN_ACCEL_SAMPLES ||
                       range > 3.5f ||
                       isHighActivity ||
                       audioEvRatio > 0.75f

        // ── RespiratoryDetectorV21 for this window ─────────────
        val respBreathsBefore = respDetector.breathEvents.size
        val respApneaBefore   = respDetector.apneaEvents.size
        val minRequiredRespSamples = (24 * detectedSampleRate).toInt()
        if (accelWindow.size >= minRequiredRespSamples) {
            val rawData = accelWindow.map { it.magnitude }.toFloatArray()
            respDetector.detect(rawData, endMs)
        }
        val newBreaths = respDetector.breathEvents.drop(respBreathsBefore)
        val newApnea   = respDetector.apneaEvents.drop(respApneaBefore)
        val breathCountInWindow = newBreaths.size + breathCount   // combine FFT + ML events
        val apneaInWindow = newApnea.isNotEmpty()

        // Respiratory rhythm quality: quorum fraction of FFT breath events
        // (mirrors how RespiratoryDetectorV21 marks events resolvedAsBreath)
        val respiratoryRhythm = if (newBreaths.isEmpty() && breathCount == 0) 0f
                                else (newBreaths.size.toFloat() / max(1, newBreaths.size + gaspCount))
                                    .coerceIn(0f, 1f)

        // Synthesize still window when phone was throttled (Doze mode)
        if (accelWindow.size < 2) {
            return WindowFeatures(
                startMs, endMs,
                actigraphMean = 0f, actigraphMax = 0f,
                isSomeActivity = false, isHighActivity = false,
                breathCountInWindow = breathCountInWindow,
                apneaInWindow = apneaInWindow,
                respiratoryRhythm = respiratoryRhythm,
                snoreCount = 0, gaspCount = 0, wakeSoundCount = 0,
                silenceCount = 0, rustleCount = 0, hasMlAudio = false,
                audioMean = audioMean, audioEventsRatio = audioEvRatio,
                elapsedMs = startMs - sleepStartMs,
                artifact = false
            )
        }

        return WindowFeatures(
            startMs, endMs,
            actigraphMean, actigraphMax,
            isSomeActivity, isHighActivity,
            breathCountInWindow, apneaInWindow, respiratoryRhythm,
            snoreCount, gaspCount, wakeCount, silenceCount, rustleCount,
            hasMlAudio, audioMean, audioEvRatio,
            elapsedMs = startMs - sleepStartMs,
            artifact
        )
    }

    // ──────────────────────────────────────────────────────────────
    //  predict() — 4-stage classification
    //
    //  Priority order (matches Urban Android's logic seen in SleepService):
    //   1. Artifact / high-activity → AWAKE
    //   2. ML audio events present → rule-based ML matrix
    //   3. Actigraphy-only fallback → linear score model
    // ──────────────────────────────────────────────────────────────
    private fun predict(f: WindowFeatures): WindowPrediction {

        if (f.artifact || f.isHighActivity) {
            return WindowPrediction(f.startMs, f.endMs, SleepStageType.AWAKE, 0.55f, true)
        }

        if (f.hasMlAudio) {
            // ── ML path: Urban Android 4-stage matrix ─────────────
            val actigraphNorm = normalizeLog(f.actigraphMean, 0.00001f, 0.06f)
            val movement = actigraphNorm  // normalized actigraph IS the movement signal

            val stage = when {
                // Large movement + any sound → AWAKE
                movement >= 0.08f &&
                    (f.rustleCount > 0 || f.breathCountInWindow > 0 ||
                     f.wakeSoundCount > 0 || f.snoreCount > 0 || f.gaspCount > 0) ->
                    SleepStageType.AWAKE

                // Micro-movement + rustle/snore/gasp → LIGHT
                movement in 0.01f..0.08f &&
                    (f.rustleCount > 0 || f.snoreCount > 0 || f.gaspCount > 0 || f.silenceCount > 0) ->
                    SleepStageType.LIGHT

                // Apnea suspected + still → REM (muscle atonia + breath disruption)
                f.apneaInWindow && movement <= 0.01f ->
                    SleepStageType.REM

                // Absolute stillness + high rhythmic breathing → DEEP
                movement <= 0.01f &&
                    (f.respiratoryRhythm >= 0.6f || f.breathCountInWindow >= 3 || f.silenceCount >= 5) &&
                    f.gaspCount == 0 && f.rustleCount == 0 && f.wakeSoundCount == 0 ->
                    SleepStageType.DEEP

                // Absolute stillness + irregular breath or gasps → REM
                movement <= 0.01f &&
                    (f.gaspCount > 0 ||
                    (f.breathCountInWindow in 1..2) ||
                    (f.respiratoryRhythm in 0.1f..0.5f)) ->
                    SleepStageType.REM

                // Fallback
                else -> when {
                    movement >= 0.08f -> SleepStageType.AWAKE
                    movement > 0.01f  -> SleepStageType.LIGHT
                    f.respiratoryRhythm >= 0.5f || f.breathCountInWindow > 0 -> SleepStageType.DEEP
                    else -> SleepStageType.LIGHT
                }
            }
            return WindowPrediction(f.startMs, f.endMs, stage, 0.85f, false)
        }

        // ── Actigraphy-only path ───────────────────────────────────
        // Uses normalized actigraph deviation (Urban Android style) as primary motion signal.
        val elapsedHours    = f.elapsedMs / 3_600_000f
        val earlyNight      = (1f - (elapsedHours / 3f)).coerceIn(0f, 1f)
        val lateNight       = ((elapsedHours - 3f) / 4f).coerceIn(0f, 1f)
        val remCycle        = remCycleAffinity(f.elapsedMs)
        val actigraphNorm   = normalizeLog(f.actigraphMean, 0.00001f, 0.06f)
        val isSome          = if (f.isSomeActivity) 1f else 0f
        // Combine: actigraph norm weighted highest, then isSomeActivity, then audio
        val motionWake      = (actigraphNorm * 0.7f + isSome * 0.3f).coerceIn(0f, 1f)
        val stillness       = 1f - motionWake
        val sleepContinuity = if (f.elapsedMs < 10 * 60 * 1000L) 0.25f else 1f

        val awakeScore = -0.9f + motionWake * 3.1f + f.audioEventsRatio * 1.4f + f.audioMean * 0.45f
        val deepScore  = (-0.2f + stillness * 1.9f + earlyNight * 1.0f - remCycle * 0.55f -
                          motionWake * 1.8f - lateNight * 0.8f) * sleepContinuity
        val remScore   = (-1.15f + stillness * 1.25f + remCycle * 1.7f + lateNight * 0.85f -
                          motionWake * 1.1f - earlyNight * 0.35f) * sleepContinuity -
                          (if (f.elapsedMs < 45 * 60 * 1000L) 0.9f else 0f)
        val lightScore = 0.25f + stillness * 0.85f + motionWake * 0.45f - f.audioEventsRatio * 0.3f

        val scores = mapOf(
            SleepStageType.AWAKE to awakeScore,
            SleepStageType.LIGHT to lightScore,
            SleepStageType.DEEP  to deepScore,
            SleepStageType.REM   to remScore
        )
        val ranked = scores.entries.sortedByDescending { it.value }
        val conf   = softmaxConfidence(ranked[0].value, ranked.map { it.value })
        return WindowPrediction(f.startMs, f.endMs, ranked[0].key, conf, false)
    }

    private fun smoothAndMerge(predictions: List<WindowPrediction>): List<SleepStage> {
        if (predictions.isEmpty()) return emptyList()
        val smoothed = predictions.mapIndexed { i, cur ->
            val prev = predictions.getOrNull(i - 1)
            val next = predictions.getOrNull(i + 1)
            if (prev != null && next != null &&
                prev.type == next.type &&
                cur.type != prev.type &&
                cur.confidence < 0.60f && !cur.artifact)
                cur.copy(type = prev.type)
            else cur
        }
        return smoothed.fold(mutableListOf()) { stages, p ->
            if (stages.isNotEmpty() && stages.last().type == p.type) {
                val last = stages.removeAt(stages.lastIndex)
                stages.add(last.copy(endMs = p.endMs))
            } else {
                stages.add(SleepStage(p.type, p.startMs, p.endMs))
            }
            stages
        }
    }

    private fun remCycleAffinity(elapsedMs: Long): Float {
        if (elapsedMs < 45 * 60 * 1000L) return 0f
        val modulo   = elapsedMs % REM_CYCLE_MS
        val distance = min(modulo, REM_CYCLE_MS - modulo).toFloat()
        return (1f - distance / REM_WINDOW_MS).coerceIn(0f, 1f)
    }

    private fun normalizeLinear(v: Float, low: Float, high: Float) = ((v - low) / (high - low)).coerceIn(0f, 1f)
    private fun normalizeLog(v: Float, low: Float, high: Float): Float {
        val sv = max(v, low)
        return ((ln(sv) - ln(low)) / (ln(high) - ln(low))).coerceIn(0f, 1f)
    }
    private fun softmaxConfidence(winner: Float, scores: List<Float>): Float {
        val mx = scores.maxOrNull() ?: winner
        val exps = scores.map { exp((it - mx).toDouble()) }
        val denom = exps.sum().takeIf { it > 0.0 } ?: return 0.25f
        return (exp((winner - mx).toDouble()) / denom).toFloat().coerceIn(0.25f, 0.98f)
    }
}
