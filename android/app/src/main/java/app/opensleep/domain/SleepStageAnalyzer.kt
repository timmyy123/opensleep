package app.opensleep.domain

import app.opensleep.data.local.SleepStage
import app.opensleep.data.local.SleepStageType
import kotlin.math.abs
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Phone-only Sleep as Android actigraphy phase analyzer.
 *
 * 100% faithful port of Sleep as Android (com.urbandroid.sleep) decompiled logic:
 *
 *  ┌─ FloatRingBuffer          — exact circular buffer (snoring/feature/FloatRingBuffer.java)
 *  ├─ MovingQuantilePrecise    — 6-window percentile baseline (Moving.quantilePrecise)
 *  ├─ MovingQuantileScalable   — dual-heap O(log n) streaming quantile (Moving.quantileScalable)
 *  ├─ ActivityAggregatorAccel  — actigraph = abs(f − median6(f)), then HighActivity scoring
 *  ├─ HighActivity.NormalizedAmplitudeBased — normalize by 720-window median, score via log-power
 *  └─ DeepSleepDetectorV8 + RemDetectorV1 — 10s activity frames → deep/light/REM phase state
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
        private val history = FloatRingBuffer(period + 1)
        private val low = java.util.PriorityQueue<Float>(compareByDescending { it })
        private val high = java.util.PriorityQueue<Float>()

        private fun isEmpty(): Boolean = size() == 0
        private fun peek(): Float = (if (low.isEmpty()) high else low).peek()!!
        private fun size(): Int = low.size + high.size

        fun apply(f: Float): Float {
            if (isEmpty() || f <= peek()) {
                low.add(f)
            } else {
                high.add(f)
            }
            history.add(f)
            if (history.isFull()) {
                val oldest = history.first()
                if (!low.remove(oldest)) {
                    high.remove(oldest)
                }
            }
            val target = Math.round(quantile * size())
            while (low.isNotEmpty() && low.size > target) {
                high.add(low.poll()!!)
            }
            while (high.isNotEmpty() && low.size < target) {
                low.add(high.poll()!!)
            }
            return peek()
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
        ) {
            fun hasNoData(): Boolean = rawActivity < 0f
        }

        fun update(f: Float): Result {
            val actigraph = abs(f - baseline.apply(f))
            val ha = highActivity.update(actigraph)
            return Result(f, actigraph, ha.isSomeActivity, ha.isHighActivity)
        }
    }

    // Sleep as Android uses ActivityAggregatorSonar for the sonar accel manager:
    // raw sonar activity goes through HighActivity.normalizedAmplitudeBased(1.0),
    // and the result is stored directly as raw/actigraph without the accel median6
    // baseline pass.
    private class ActivityAggregatorSonar {
        private val highActivity = HighActivityDetector(1.0f)

        fun update(f: Float): ActivityAggregatorAccel.Result {
            val ha = highActivity.update(f)
            return ActivityAggregatorAccel.Result(
                rawActivity = f,
                actigraph = f,
                isSomeActivity = ha.isSomeActivity,
                isHighActivity = ha.isHighActivity
            )
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
            if (amplitude <= 1f) {
                if (callCount % 100 == 0) {
                    android.util.Log.d("SleepTracker", "HighActivityDetector: callCount=$callCount, fAbs=$fAbs, med=$med, normalized=$normalized, amplitude=$amplitude <= 1 -> RESULT_NONE")
                }
                return RESULT_NONE
            }
            // Warmup: first 360 calls clamp amplitude to at least 100
            if (callCount < 360) amplitude = max(100f, amplitude)
            val score = min(amplitude, normalized).toDouble()
                .pow(1.0 / log10(amplitude.toDouble()))
                .toFloat()
            val res = Result(score > someThreshold, score > highThreshold)
            if (res.isSomeActivity || res.isHighActivity || callCount % 100 == 0) {
                android.util.Log.d("SleepTracker", "HighActivityDetector: callCount=$callCount, fAbs=$fAbs, med=$med, normalized=$normalized, amplitude=$amplitude, score=$score. Thresholds: some=$someThreshold, high=$highThreshold -> Result: isSome=${res.isSomeActivity}, isHigh=${res.isHighActivity}")
            }
            return res
        }
    }

    private class MovingSum(private val period: Int) {
        private val history = FloatRingBuffer(period + 1)
        private var prevResult = 0f

        fun apply(f: Float): Float {
            history.add(f)
            val size = history.size()
            val fLast = if (size <= period) {
                history.last() + prevResult
            } else {
                (history.last() + prevResult) - history.first()
            }
            prevResult = fLast
            return fLast
        }
    }

    private enum class SleepPhase {
        DEEP_SLEEP,
        LIGHT_SLEEP,
        UNKNOWN
    }

    private class RemDetectorV1 {
        enum class Status { INIT, DEEP, LIGHT, REM }

        var status: Status = Status.INIT
            private set
        private var deepStart = 0L
        private var lightStart = 0L

        private fun reset() {
            val oldStatus = status
            if (oldStatus != Status.INIT) {
                android.util.Log.d("SleepTracker", "RemDetectorV1: reset status $oldStatus -> INIT")
                status = Status.INIT
            }
        }

        fun handleAwake() {
            android.util.Log.d("SleepTracker", "RemDetectorV1: handleAwake() called, resetting")
            reset()
        }

        fun handleDeepSleep(nowMs: Long) {
            android.util.Log.d("SleepTracker", "RemDetectorV1: handleDeepSleep(nowMs=$nowMs) called. Current status: $status")
            when (status) {
                Status.INIT -> {
                    deepStart = nowMs - minutes(5)
                    status = Status.DEEP
                    android.util.Log.d("SleepTracker", "RemDetectorV1: status INIT -> DEEP. deepStart set to $deepStart")
                }
                Status.DEEP -> Unit
                else -> {
                    android.util.Log.d("SleepTracker", "RemDetectorV1: handleDeepSleep in status $status -> resetting")
                    reset()
                }
            }
        }

        fun handleLightSleep(nowMs: Long) {
            android.util.Log.d("SleepTracker", "RemDetectorV1: handleLightSleep(nowMs=$nowMs) called. Current status: $status")
            when (status) {
                Status.DEEP -> {
                    val diffMin = (nowMs - deepStart) / 60000.0
                    android.util.Log.d("SleepTracker", "RemDetectorV1: DEEP -> LIGHT check. diff: $diffMin min (threshold: 15 min)")
                    if (nowMs - deepStart <= minutes(15)) {
                        android.util.Log.d("SleepTracker", "RemDetectorV1: diff <= 15 min -> resetting")
                        reset()
                    } else {
                        lightStart = nowMs
                        status = Status.LIGHT
                        android.util.Log.d("SleepTracker", "RemDetectorV1: status DEEP -> LIGHT. lightStart set to $lightStart")
                    }
                }
                Status.LIGHT -> {
                    val diffMin = (nowMs - lightStart) / 60000.0
                    android.util.Log.d("SleepTracker", "RemDetectorV1: LIGHT -> REM check. diff: $diffMin min (threshold: 10 min)")
                    if (nowMs - lightStart > minutes(10)) {
                        status = Status.REM
                        android.util.Log.d("SleepTracker", "RemDetectorV1: status LIGHT -> REM")
                    }
                }
                Status.REM -> {
                    val diffMin = (nowMs - lightStart) / 60000.0
                    android.util.Log.d("SleepTracker", "RemDetectorV1: REM -> INIT check. diff: $diffMin min (threshold: 20 min)")
                    if (nowMs - lightStart > minutes(20)) {
                        android.util.Log.d("SleepTracker", "RemDetectorV1: diff > 20 min -> resetting")
                        reset()
                    }
                }
                else -> {
                    android.util.Log.d("SleepTracker", "RemDetectorV1: handleLightSleep in status $status -> resetting")
                    reset()
                }
            }
        }

        private fun minutes(value: Int): Long = value * 60_000L
    }

    private class MissingDataGuard {
        private val missingDataCount5min = MovingSum(30)
        private val missingDataCount10min = MovingSum(60)
        private var missingDataRatio5min = 0f
        private var missingDataRatio10min = 0f
        var lastDataMissing = false
            private set

        fun getMissingDataRatio5min(): Float = missingDataRatio5min

        fun update(result: ActivityAggregatorAccel.Result) {
            lastDataMissing = result.hasNoData()
            val missing = if (lastDataMissing) 1f else 0f
            missingDataRatio5min = missingDataCount5min.apply(missing) / 30f
            missingDataRatio10min = missingDataCount10min.apply(missing) / 60f
        }
    }

    private class DeepSleepDetectorV8(
        private val isSmartWatch: Boolean = false,
        private val isAwake: () -> Boolean = { false }
    ) {
        private val deepSleepIndicator = DeepSleepIndicator(isSmartWatch)
        private val sleepPhaseBroadcast = SleepPhaseBroadcast(isAwake)

        val sleepPhase: SleepPhase
            get() = deepSleepIndicator.sleepPhase
        val remStatus: RemDetectorV1.Status
            get() = sleepPhaseBroadcast.remStatus

        fun update(timestampMs: Long, result: ActivityAggregatorAccel.Result) {
            sleepPhaseBroadcast.update(timestampMs, result)
            deepSleepIndicator.update(result)
            android.util.Log.d("SleepTracker", "DeepSleepDetectorV8.update: time=$timestampMs, sleepPhase=${sleepPhase}, remStatus=${remStatus}")
        }

        private class DeepSleepIndicator(private val isSmartWatch: Boolean) {
            private var missingDataGuard = MissingDataGuard()
            private var highActivityCountShortWindow = MovingSum(if (isSmartWatch) 12 else 6)
            private var someActivityCountLongWindow = MovingSum(30)
            private var pointsCount = 0
            var sleepPhase = SleepPhase.UNKNOWN
                private set

            fun update(result: ActivityAggregatorAccel.Result) {
                missingDataGuard.update(result)
                if (missingDataGuard.getMissingDataRatio5min() > 0.9f) {
                    android.util.Log.d("SleepTracker", "DeepSleepIndicator: reset due to too much missing data (>90%)")
                    reset()
                    return
                }
                if (missingDataGuard.lastDataMissing) {
                    android.util.Log.d("SleepTracker", "DeepSleepIndicator: skip update due to missing data")
                    return
                }

                val highActivity = highActivityCountShortWindow.apply(if (result.isHighActivity) 1f else 0f)
                val someActivity = someActivityCountLongWindow.apply(if (result.isSomeActivity) 1f else 0f)
                pointsCount += 1
                val oldPhase = sleepPhase
                sleepPhase = if (pointsCount < 12) {
                    SleepPhase.UNKNOWN
                } else if (Math.round(highActivity) < 1 || Math.round(someActivity) < SMART_WAKEUP_SENSITIVITY_CHECKS) {
                    SleepPhase.DEEP_SLEEP
                } else {
                    SleepPhase.LIGHT_SLEEP
                }
                android.util.Log.d("SleepTracker", "DeepSleepIndicator update: points=$pointsCount, highActivitySum=$highActivity, someActivitySum=$someActivity. Phase: $oldPhase -> $sleepPhase (result: isHigh=${result.isHighActivity}, isSome=${result.isSomeActivity})")
            }

            private fun reset() {
                missingDataGuard = MissingDataGuard()
                highActivityCountShortWindow = MovingSum(if (isSmartWatch) 12 else 6)
                someActivityCountLongWindow = MovingSum(30)
                sleepPhase = SleepPhase.UNKNOWN
                pointsCount = 0
            }
        }

        private class SleepPhaseBroadcast(private val isAwake: () -> Boolean) {
            private var deepSleepFrom = -1L
            private var deepSleepReported = false
            private var lastAwake = 0L
            private val missingDataGuard = MissingDataGuard()
            private val someActivityCount = MovingSum(30)
            private val highActivityCount = MovingSum(30)
            private val remDetector = RemDetectorV1()

            val remStatus: RemDetectorV1.Status
                get() = remDetector.status

            fun update(nowMs: Long, result: ActivityAggregatorAccel.Result) {
                missingDataGuard.update(result)
                if (missingDataGuard.lastDataMissing) {
                    android.util.Log.d("SleepTracker", "SleepPhaseBroadcast: skip update due to missing data")
                    return
                }

                val someActivity = Math.round(someActivityCount.apply(if (result.isSomeActivity) 1f else 0f))
                val highActivity = Math.round(highActivityCount.apply(if (result.isHighActivity) 1f else 0f))

                val oldDeepSleepFrom = deepSleepFrom
                val oldDeepSleepReported = deepSleepReported
                if (highActivity < 1 || someActivity < SMART_WAKEUP_SENSITIVITY_CHECKS) {
                    if (deepSleepFrom == -1L) deepSleepFrom = nowMs
                    if (deepSleepFrom > 0 && nowMs - deepSleepFrom > minutes(5)) {
                        deepSleepReported = true
                        remDetector.handleDeepSleep(nowMs)
                    }
                } else {
                    deepSleepFrom = -1L
                    if (deepSleepReported) deepSleepReported = false
                    remDetector.handleLightSleep(nowMs)
                }

                val awakeState = isAwake()
                if (awakeState) lastAwake = nowMs
                val timeSinceLastAwake = nowMs - lastAwake
                if (timeSinceLastAwake < minutes(3)) {
                    remDetector.handleAwake()
                }

                android.util.Log.d("SleepTracker", "SleepPhaseBroadcast update: highActivity=$highActivity, someActivity=$someActivity. deepSleepFrom: $oldDeepSleepFrom -> $deepSleepFrom, deepSleepReported: $oldDeepSleepReported -> $deepSleepReported, isAwake=$awakeState, timeSinceLastAwake=${timeSinceLastAwake/1000}s. REM Status: ${remDetector.status}")
            }

            private fun minutes(value: Int): Long = value * 60_000L
        }

        private companion object {
            private const val SMART_WAKEUP_SENSITIVITY_CHECKS = 3
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
        private val history = FloatRingBuffer(period + 1)
        private var sum = 0f

        fun apply(f: Float): Float {
            history.add(f)
            if (history.size() <= period) {
                sum += f
                return sum / history.size()
            }
            val fFirst = (sum - history.first()) + history.last()
            sum = fFirst
            return fFirst / (history.size() - 1)
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

    // ──────────────────────────────────────────────────────────────
    //  Sensor data stores
    // ──────────────────────────────────────────────────────────────

    private val samples      = mutableListOf<MotionSample>()
    private val gyroSamples  = mutableListOf<Pair<Long, Float>>()
    private val sonarSamples = mutableListOf<Pair<Long, Float>>()
    private val awakeIntervals = mutableListOf<Pair<Long, Long>>()

    companion object {
        private const val FRAME_MS = 10 * 1000L
    }

    // ──────────────────────────────────────────────────────────────
    //  Public API
    // ──────────────────────────────────────────────────────────────

    fun addSample(timestampMs: Long, x: Float, y: Float, z: Float) {
        samples.add(MotionSample(timestampMs, x, y, z))
    }

    fun addGyroSample(timestampMs: Long, x: Float, y: Float, z: Float) {
        val magnitude = sqrt(x * x + y * y + z * z)
        gyroSamples.add(timestampMs to magnitude)
    }

    fun addSonarSample(timestampMs: Long, activity: Float) {
        sonarSamples.add(timestampMs to activity)
    }

    fun addAwakeInterval(startMs: Long, endMs: Long) {
        awakeIntervals.add(startMs to endMs)
    }

    fun addAudioLevel(timestampMs: Long, levelDbfs: Float, clipped: Boolean = false) {
        // Sleep as Android's extracted phase detector does not use audio events
        // for deep/light/REM phase classification.
    }

    fun addAudioEvent(timestampMs: Long, eventName: String, confidence: Float) {
        // Intentionally ignored; see addAudioLevel.
    }

    fun computeStages(sleepStartMs: Long): List<SleepStage> {
        android.util.Log.d("SleepTracker", "SleepStageAnalyzer.computeStages(sleepStartMs=$sleepStartMs) started. samples=${samples.size}, sonarSamples=${sonarSamples.size}, awakeIntervals=${awakeIntervals.size}")
        if (samples.size < 2 && sonarSamples.isEmpty()) {
            android.util.Log.d("SleepTracker", "SleepStageAnalyzer.computeStages: returning empty list because not enough samples")
            return emptyList()
        }

        val frames = buildActivityFrames(sleepStartMs)
        android.util.Log.d("SleepTracker", "SleepStageAnalyzer.computeStages: buildActivityFrames returned ${frames.size} frames")
        if (frames.isEmpty()) return emptyList()

        var detectorTimestampMs = sleepStartMs
        val detector = DeepSleepDetectorV8(isSmartWatch = false) {
            isAwakeAt(detectorTimestampMs)
        }
        val stages = mutableListOf<SleepStage>()

        frames.forEachIndexed { index, frame ->
            detectorTimestampMs = frame.startMs
            detector.update(frame.startMs, frame.result)
            val awake = isAwakeAt(frame.startMs)
            val type = if (awake) {
                SleepStageType.AWAKE
            } else {
                when {
                    detector.remStatus == RemDetectorV1.Status.REM -> SleepStageType.REM
                    detector.sleepPhase == SleepPhase.DEEP_SLEEP -> SleepStageType.DEEP
                    detector.sleepPhase == SleepPhase.LIGHT_SLEEP -> SleepStageType.LIGHT
                    else -> null
                }
            }
            android.util.Log.d("SleepTracker", "Frame $index: [${frame.startMs} - ${frame.endMs}] raw=${frame.result.rawActivity}, actigraph=${frame.result.actigraph}, isSome=${frame.result.isSomeActivity}, isHigh=${frame.result.isHighActivity}, awake=$awake -> Stage: $type (remStatus=${detector.remStatus}, sleepPhase=${detector.sleepPhase})")
            if (type != null) appendStage(stages, type, frame.startMs, frame.endMs)
        }

        val finalStages = overlayAwakeIntervals(stages, sleepStartMs, frames.last().endMs)
        android.util.Log.d("SleepTracker", "SleepStageAnalyzer.computeStages completed. Result: ${finalStages.size} stages")
        finalStages.forEachIndexed { index, stage ->
            android.util.Log.d("SleepTracker", "  Stage $index: ${stage.type} from ${stage.startMs} to ${stage.endMs} (duration: ${(stage.endMs - stage.startMs)/60000.0} min)")
        }
        return finalStages
    }

    fun clear() {
        samples.clear()
        gyroSamples.clear()
        sonarSamples.clear()
        awakeIntervals.clear()
    }

    private data class ActivityFrame(
        val startMs: Long,
        val endMs: Long,
        val result: ActivityAggregatorAccel.Result
    )

    private fun buildActivityFrames(sleepStartMs: Long): List<ActivityFrame> {
        val hasSonar = sonarSamples.isNotEmpty()
        val hasAccel = samples.size >= 2
        android.util.Log.d("SleepTracker", "buildActivityFrames: sleepStartMs=$sleepStartMs, hasSonar=$hasSonar (${sonarSamples.size} samples), hasAccel=$hasAccel (${samples.size} samples)")
        if (!hasSonar && !hasAccel) return emptyList()

        val sortedSonar = if (hasSonar) sonarSamples.sortedBy { it.first } else emptyList()
        val sortedAccel = if (hasAccel) samples.sortedBy { it.timestampMs } else emptyList()

        val sonarEndMs  = sortedSonar.lastOrNull()?.first ?: Long.MIN_VALUE
        val accelEndMs  = sortedAccel.lastOrNull()?.timestampMs ?: Long.MIN_VALUE
        val sessionEndMs = maxOf(sonarEndMs, accelEndMs)
        android.util.Log.d("SleepTracker", "buildActivityFrames: sessionEndMs=$sessionEndMs. Total duration to process: ${(sessionEndMs - sleepStartMs)/60000.0} min")

        val accelAggregator = ActivityAggregatorAccel()
        val sonarAggregator = ActivityAggregatorSonar()
        var previousSample: MotionSample? = null
        val frames = mutableListOf<ActivityFrame>()
        var frameStartMs = sleepStartMs

        // Two-pointer indices — advance monotonically through sorted arrays O(N+M)
        // instead of the old per-frame .filter which was O(N×M).
        var sonarIdx = 0
        var accelIdx = 0

        while (frameStartMs + FRAME_MS <= sessionEndMs) {
            val frameEndMs = frameStartMs + FRAME_MS

            // ── Sonar result — two-pointer O(N+M) ────────────────────────────────────
            // Sleep as Android uses ActivityAggregatorSonar here: do not run sonar
            // through ActivityAggregatorAccel's median6 baseline, but do run it through
            // HighActivity.normalizedAmplitudeBased(1.0).
            val sonarResult: ActivityAggregatorAccel.Result? = if (hasSonar) {
                // Advance main pointer past samples that belong to earlier frames
                while (sonarIdx < sortedSonar.size && sortedSonar[sonarIdx].first < frameStartMs) sonarIdx++
                // Scan ahead with a local index to collect this frame's max activity
                var maxSonar: Float? = null
                var si = sonarIdx
                while (si < sortedSonar.size && sortedSonar[si].first < frameEndMs) {
                    val v = sortedSonar[si].second
                    if (maxSonar == null || v > maxSonar) maxSonar = v
                    si++
                }
                maxSonar?.let { sonarAggregator.update(it) }
            } else null

            // ── Accel result — two-pointer O(N+M) ─────────────────────────────────────
            val accelResult: ActivityAggregatorAccel.Result? = if (hasAccel) {
                while (accelIdx < sortedAccel.size && sortedAccel[accelIdx].timestampMs < frameStartMs) accelIdx++
                var maxRawChange = 0f
                var hasData = false
                var ai = accelIdx
                while (ai < sortedAccel.size && sortedAccel[ai].timestampMs < frameEndMs) {
                    val sample = sortedAccel[ai]
                    val rawChange = if (previousSample == null) 0f else sample.magnitude
                    if (rawChange > maxRawChange) maxRawChange = rawChange
                    previousSample = sample
                    hasData = true
                    ai++
                }
                if (hasData) accelAggregator.update(maxRawChange) else null
            } else null

            // ── Combine: take the result showing more activity ────────────────────────
            val result = when {
                sonarResult != null && accelResult != null -> ActivityAggregatorAccel.Result(
                    rawActivity    = maxOf(sonarResult.rawActivity,  accelResult.rawActivity),
                    actigraph      = maxOf(sonarResult.actigraph,    accelResult.actigraph),
                    isSomeActivity = sonarResult.isSomeActivity || accelResult.isSomeActivity,
                    isHighActivity = sonarResult.isHighActivity || accelResult.isHighActivity
                )
                sonarResult != null -> sonarResult
                accelResult != null -> accelResult
                else -> ActivityAggregatorAccel.Result(-0.001f, -0.001f, false, false)
            }

            frames.add(ActivityFrame(frameStartMs, frameEndMs, result))
            frameStartMs = frameEndMs
        }
        android.util.Log.d("SleepTracker", "buildActivityFrames: built ${frames.size} frames")
        return frames
    }

    private fun appendStage(
        stages: MutableList<SleepStage>,
        type: SleepStageType,
        startMs: Long,
        endMs: Long
    ) {
        val last = stages.lastOrNull()
        if (last != null && last.type == type && last.endMs == startMs) {
            stages[stages.lastIndex] = last.copy(endMs = endMs)
        } else {
            stages.add(SleepStage(type, startMs, endMs))
        }
    }

    private fun isAwakeAt(timestampMs: Long): Boolean {
        return awakeIntervals.any { timestampMs >= it.first && timestampMs < it.second }
    }

    private fun overlayAwakeIntervals(
        stages: List<SleepStage>,
        sessionStartMs: Long,
        sessionEndMs: Long
    ): List<SleepStage> {
        if (awakeIntervals.isEmpty()) return stages

        val sortedIntervals = awakeIntervals
            .mapNotNull { interval ->
                val start = maxOf(interval.first, sessionStartMs)
                val end = minOf(interval.second, sessionEndMs)
                if (end > start) start to end else null
            }
            .sortedBy { it.first }
        if (sortedIntervals.isEmpty()) return stages

        val mergedIntervals = mutableListOf<Pair<Long, Long>>()
        for (interval in sortedIntervals) {
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(interval)
            } else {
                val last = mergedIntervals.last()
                if (interval.first <= last.second + 1000) {
                    mergedIntervals[mergedIntervals.lastIndex] = last.first to maxOf(last.second, interval.second)
                } else {
                    mergedIntervals.add(interval)
                }
            }
        }

        var currentStages = stages
        for (awake in mergedIntervals) {
            val nextStages = mutableListOf<SleepStage>()
            for (stage in currentStages) {
                if (stage.endMs <= awake.first || stage.startMs >= awake.second) {
                    nextStages.add(stage)
                } else {
                    if (stage.startMs < awake.first) {
                        nextStages.add(SleepStage(stage.type, stage.startMs, awake.first))
                    }
                    if (stage.endMs > awake.second) {
                        nextStages.add(SleepStage(stage.type, awake.second, stage.endMs))
                    }
                }
            }
            nextStages.add(SleepStage(SleepStageType.AWAKE, awake.first, awake.second))
            currentStages = nextStages.sortedBy { it.startMs }
        }

        val finalStages = mutableListOf<SleepStage>()
        for (stage in currentStages) {
            val last = finalStages.lastOrNull()
            if (last != null && last.type == stage.type && last.endMs == stage.startMs) {
                finalStages[finalStages.lastIndex] = SleepStage(last.type, last.startMs, stage.endMs)
            } else {
                finalStages.add(stage)
            }
        }
        return finalStages
    }
}
