package app.opensleep.domain.sleep

import app.opensleep.data.local.SleepStage
import app.opensleep.data.local.SleepStageType
import java.util.BitSet
import kotlin.math.abs
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Core phone-only sleep tracking & 4-phase hypnogram engine.
 * Faithfully re-implemented from Sleep as Android (com.urbandroid.sleep) reference logic:
 * - ActivityAggregatorAccel & HighActivity (real-time filtering)
 * - AwakeWhenHighActivityFrequency (real-time & initial awake detection)
 * - DeepSleepDetectorV8 & RemDetectorV2 (real-time phase monitoring)
 * - SleepRecordHypnogramKt & SleepRecordHealthSession (session 4-phase hypnogram generation)
 */
object HypnogramEngine {

    const val FRAMERATE_MS: Long = 10_000L // 10 seconds per raw epoch
    const val DEEP_SLEEP_THRESHOLD = 3.1f // Reference version >= 10008 threshold
    const val MIN_DEEP_SLEEP_MS = 15 * 60_000L // 15 minutes minimum deep sleep length
    const val MIN_REM_OCCURRENCE_DELAY_MS = 50 * 60_000L // REM only starts >= 50m after sleep onset

    enum class RawPhase {
        DEEP, LIGHT, REM, AWAKE, BROKEN
    }

    data class PhaseInterval(
        val fromMs: Long,
        val toMs: Long,
        val phase: RawPhase
    ) {
        val durationMs: Long get() = toMs - fromMs
    }

    // =========================================================================
    // Real-Time Component 1: ActivityAggregatorAccel
    // =========================================================================
    class ActivityAggregator {
        private val baseline = Moving.quantilePrecise(6, 0.5f) // 1-minute rolling median
        private val highActivityDetector = HighActivityDetector(1.1f)

        data class Result(
            val rawActivity: Float,
            val actigraph: Float,
            val isSomeActivity: Boolean,
            val isHighActivity: Boolean
        )

        fun update(peakMagnitude: Float): Result {
            val base = baseline.apply(peakMagnitude)
            val actigraph = abs(peakMagnitude - base)
            val haResult = highActivityDetector.update(actigraph)
            return Result(peakMagnitude, actigraph, haResult.first, haResult.second)
        }
    }

    // =========================================================================
    // Real-Time Component 2: HighActivityDetector
    // =========================================================================
    class HighActivityDetector(factor: Float = 1.1f) {
        private var callCount = 0
        private val someActivityThreshold = 2.5f * factor
        private val highActivityThreshold = 3.3f * factor
        private val median = Moving.quantileScalable(720, 0.5f)
        private val maximum = Moving.max(720)

        fun update(actigraph: Float): Pair<Boolean, Boolean> {
            callCount++
            if (callCount < 30) {
                return Pair(false, false)
            }
            var absVal = abs(actigraph)
            val medVal = median.apply(absVal)
            if (medVal != 0.0f) {
                absVal /= medVal
            }
            var maxVal = maximum.apply(absVal)
            if (maxVal <= 1.0f) {
                return Pair(false, false)
            }
            if (callCount < 360) {
                maxVal = maxVal.coerceAtLeast(100.0f)
            }
            val exponent = 1.0 / Math.log10(maxVal.toDouble())
            val score = min(maxVal, absVal).toDouble().pow(exponent).toFloat()
            return Pair(score > someActivityThreshold, score > highActivityThreshold)
        }
    }

    // =========================================================================
    // Real-Time Component 3: AwakeDetector
    // =========================================================================
    class AwakeDetector(val threshold: Float = 0.35f, val windowSize: Int = 30) {
        var isCurrentlyAwake: Boolean = false
            private set
        var beginningRecomputed: Boolean = false

        fun update(history: List<Float>): Boolean {
            if (history.size < windowSize) return false
            val floatArray = FloatArray(history.size) { history[it] }
            val flags = AdaptiveNormalizationFilter.normalizeAmplitudes(floatArray).getHighActivityFlagsFloat(3.0f)

            var sum = 0.0f
            val start = flags.size - windowSize
            for (i in start until flags.size) {
                sum += flags[i]
            }
            val avg = sum / windowSize
            val awake = avg >= threshold
            isCurrentlyAwake = awake
            return awake
        }

        fun detectBeginningAwake(history: List<Float>, startMs: Long): List<Pair<Long, Long>> {
            if (history.size < windowSize) return emptyList()
            val floatArray = FloatArray(history.size) { history[it] }
            val flags = AdaptiveNormalizationFilter.normalizeAmplitudes(floatArray).getHighActivityFlagsFloat(3.0f)

            val intervals = mutableListOf<Pair<Long, Long>>()
            val sumFilter = Moving.sum(windowSize)
            val awakeMask = BooleanArray(flags.size)
            for (i in flags.indices) {
                awakeMask[i] = sumFilter.apply(flags[i]) >= threshold * windowSize
            }

            var inAwake = false
            var awakeStartMs = startMs
            for (i in awakeMask.indices) {
                val epochTime = startMs + (i * FRAMERATE_MS)
                if (awakeMask[i] && !inAwake) {
                    inAwake = true
                    awakeStartMs = epochTime
                } else if (!awakeMask[i] && inAwake) {
                    inAwake = false
                    intervals.add(Pair(awakeStartMs, epochTime))
                }
            }
            if (inAwake) {
                intervals.add(Pair(awakeStartMs, startMs + flags.size * FRAMERATE_MS))
            }
            return intervals
        }
    }

    // =========================================================================
    // Real-Time Component 4: Real-Time Phase Indicator (DeepSleepDetectorV8)
    // =========================================================================
    class LivePhaseDetector(private val smartWakeupSensitivityChecks: Int = 3) {
        private val highActivityCountShort = Moving.sum(6) // 1 min window
        private val someActivityCountLong = Moving.sum(30) // 5 min window
        private var pointsCount = 0

        fun update(isHighActivity: Boolean, isSomeActivity: Boolean): SleepStageType {
            val highCount = highActivityCountShort.apply(if (isHighActivity) 1.0f else 0.0f)
            val someCount = someActivityCountLong.apply(if (isSomeActivity) 1.0f else 0.0f)
            pointsCount++

            if (pointsCount < 12) {
                return SleepStageType.LIGHT
            }
            val isDeep = highCount.roundToInt() < 1 || someCount.roundToInt() < smartWakeupSensitivityChecks
            return if (isDeep) SleepStageType.DEEP else SleepStageType.LIGHT
        }
    }

    // =========================================================================
    // Post-Processing: Hypnogram & 4-Phase Reconstruction
    // =========================================================================

    /**
     * Reconstructs the complete 4-phase hypnogram for the recorded sleep session.
     */
    fun buildHypnogram(
        rawActigraphHistory: List<Float>,
        sessionStartMs: Long,
        sessionEndMs: Long,
        awakeIntervals: List<Pair<Long, Long>>
    ): List<SleepStage> {
        val size = rawActigraphHistory.size
        if (size < 12 || sessionEndMs <= sessionStartMs) {
            // Fallback for extremely short recordings (< 2 minutes)
            return listOf(SleepStage(SleepStageType.LIGHT, sessionStartMs, sessionEndMs))
        }

        // 1. Excluded indices bitset (e.g. awake intervals)
        val excludedIndices = BitSet()
        val totalDurationMs = sessionEndMs - sessionStartMs
        for (awake in awakeIntervals) {
            val fromIdx = ((awake.first - sessionStartMs) / FRAMERATE_MS).toInt().coerceIn(0, size - 1)
            val toIdx = ((awake.second - sessionStartMs) / FRAMERATE_MS).toInt().coerceIn(0, size - 1)
            if (fromIdx <= toIdx) {
                excludedIndices.set(fromIdx, toIdx + 1)
            }
        }
        // Exclude first min(size/5, 60) points for sleep onset unless heavily excluded
        excludedIndices.set(0, min(size / 5, 60))
        if (excludedIndices.cardinality() > size * 0.66) {
            excludedIndices.clear()
        }

        // 2. Adaptive Normalization Filter (ANF)
        val floatArray = FloatArray(size) { rawActigraphHistory[it] }
        val anfResult = AdaptiveNormalizationFilter.normalizeAmplitudes(floatArray, excludedIndices)
        val highActivityBitSet = anfResult.getHighActivityFlags(2.5f)

        // 3. Aggregation factor
        val aggregationFactor = when {
            size < 90 -> 3     // 30s points
            size < 360 -> 6    // 60s (1 min) points
            else -> 30         // 300s (5 min) points
        }
        val aggregatedHistory = anfResult.aggregateOutput(aggregationFactor)
        val millisPerPoint = aggregationFactor * FRAMERATE_MS

        // 4. High Activity Frequency
        val highActivityFreq = computeHighActivityFrequency(highActivityBitSet, aggregatedHistory.size, aggregationFactor)

        // 5. Activity segment classification (DEEP / LIGHT / BROKEN)
        val rawIntervals = classifyActivitySegments(
            aggregatedHistory,
            highActivityFreq,
            sessionStartMs,
            sessionEndMs,
            millisPerPoint,
            aggregationFactor
        )

        // 6. Deep Sleep Post-Processing (convert DEEP < 15 min to LIGHT; merge LIGHT)
        val postProcessedDeep = postProcessDeepIntervals(rawIntervals)

        // 7. REM Detection (following DEEP >= 10 min and LIGHT >= 15 min after 50 min)
        val remIntervals = detectREM(postProcessedDeep, sessionStartMs)

        // 8. Awake Overlap Resolution
        val mergedAwake = mergeIntervals(awakeIntervals, maxGapMs = 5 * 60_000L)
        val clearedRem = clearRemAtAwake(remIntervals, mergedAwake)

        // 9. Non-overlapping Segment Normalization: AWAKE > REM > LIGHT > DEEP
        return normalizeToFourPhases(
            sessionStartMs,
            sessionEndMs,
            baseSegments = postProcessedDeep,
            remSegments = clearedRem,
            awakeSegments = mergedAwake
        )
    }

    private fun computeHighActivityFrequency(bitSet: BitSet, targetSize: Int, aggregation: Int): FloatArray {
        val totalPoints = targetSize * aggregation
        val flags = FloatArray(totalPoints)
        val maxBit = min(bitSet.length(), totalPoints)
        for (i in 0 until maxBit) {
            if (bitSet.get(i)) {
                flags[i] = 1.0f
            }
        }
        // Moving average with window 'aggregation' followed by decimation
        val smoothed = FloatArray(totalPoints)
        val avgFilter = Moving.avg(aggregation)
        for (i in 0 until totalPoints) {
            smoothed[i] = avgFilter.apply(flags[i])
        }
        val decimated = FloatArray(targetSize)
        for (i in 0 until targetSize) {
            decimated[i] = smoothed[i * aggregation]
        }
        return decimated
    }

    private fun classifyActivitySegments(
        history: FloatArray,
        haFreq: FloatArray,
        sessionStartMs: Long,
        sessionEndMs: Long,
        millisPerPoint: Long,
        aggregation: Int
    ): List<PhaseInterval> {
        val count = history.size
        val fMin = min(3.0f / aggregation.toFloat(), 0.1f)
        val phases = Array(count) { RawPhase.LIGHT }

        for (i in 0 until count) {
            val v = history[i]
            if (v < 0.0f) {
                phases[i] = RawPhase.BROKEN
            } else if (v < DEEP_SLEEP_THRESHOLD) {
                phases[i] = RawPhase.DEEP
            } else {
                val freq = if (i < haFreq.size) haFreq[i] else 0.0f
                if (freq <= 0.0f || freq >= fMin) {
                    phases[i] = RawPhase.LIGHT
                } else {
                    phases[i] = RawPhase.DEEP
                }
            }
        }

        // Group into contiguous intervals
        val intervals = mutableListOf<PhaseInterval>()
        if (count == 0) return intervals

        var currentPhase = phases[0]
        var segStart = sessionStartMs
        for (i in 1 until count) {
            if (phases[i] != currentPhase) {
                val segEnd = sessionStartMs + (i * millisPerPoint)
                intervals.add(PhaseInterval(segStart, segEnd, currentPhase))
                currentPhase = phases[i]
                segStart = segEnd
            }
        }
        intervals.add(PhaseInterval(segStart, sessionEndMs, currentPhase))
        return intervals
    }

    private fun postProcessDeepIntervals(intervals: List<PhaseInterval>): List<PhaseInterval> {
        val converted = intervals.map { interval ->
            if (interval.phase == RawPhase.DEEP && interval.durationMs < MIN_DEEP_SLEEP_MS) {
                PhaseInterval(interval.fromMs, interval.toMs, RawPhase.LIGHT)
            } else {
                interval
            }
        }

        // Merge adjacent LIGHT intervals
        val merged = mutableListOf<PhaseInterval>()
        for (interval in converted) {
            if (merged.isNotEmpty() && merged.last().phase == RawPhase.LIGHT && interval.phase == RawPhase.LIGHT) {
                val prev = merged.removeAt(merged.size - 1)
                merged.add(PhaseInterval(prev.fromMs, interval.toMs, RawPhase.LIGHT))
            } else {
                merged.add(interval)
            }
        }
        return merged
    }

    private fun detectREM(intervals: List<PhaseInterval>, sessionStartMs: Long): List<PhaseInterval> {
        val remList = mutableListOf<PhaseInterval>()
        val minDeepDuration = 10 * 60_000L
        val minLightDuration = 15 * 60_000L
        val remDelay = 10 * 60_000L
        val fiveMinutes = 5 * 60_000L
        val maxRemDuration = 50 * 60_000L

        for (i in 1 until intervals.size) {
            val prev = intervals[i - 1]
            val curr = intervals[i]

            if (prev.phase == RawPhase.DEEP && prev.durationMs >= minDeepDuration) {
                if (curr.phase == RawPhase.LIGHT && curr.durationMs >= minLightDuration) {
                    val remStart = curr.fromMs + remDelay
                    val remAvailable = curr.durationMs - remDelay
                    val halfInterval = (((remAvailable / fiveMinutes) + 1) / 2) * fiveMinutes
                    val remDuration = min(remAvailable, min(maxRemDuration, halfInterval.coerceAtLeast(fiveMinutes)))
                    val remEnd = remStart + remDuration

                    val allowedStart = sessionStartMs + MIN_REM_OCCURRENCE_DELAY_MS
                    if (allowedStart <= remStart) {
                        remList.add(PhaseInterval(remStart, remEnd, RawPhase.REM))
                    } else if (remEnd - allowedStart >= fiveMinutes) {
                        remList.add(PhaseInterval(allowedStart, remEnd, RawPhase.REM))
                    }
                }
            }
        }
        return remList
    }

    private fun mergeIntervals(intervals: List<Pair<Long, Long>>, maxGapMs: Long): List<Pair<Long, Long>> {
        if (intervals.isEmpty()) return emptyList()
        val sorted = intervals.sortedBy { it.first }
        val merged = mutableListOf<Pair<Long, Long>>()
        var current = sorted[0]

        for (i in 1 until sorted.size) {
            val next = sorted[i]
            if (next.first <= current.second + maxGapMs) {
                current = Pair(current.first, maxOf(current.second, next.second))
            } else {
                merged.add(current)
                current = next
            }
        }
        merged.add(current)
        return merged
    }

    private fun clearRemAtAwake(remIntervals: List<PhaseInterval>, awakeIntervals: List<Pair<Long, Long>>): List<PhaseInterval> {
        val fiveMinutes = 5 * 60_000L
        var currentRem = remIntervals

        for (awake in awakeIntervals) {
            val updated = mutableListOf<PhaseInterval>()
            for (rem in currentRem) {
                // If no overlap, keep
                if (rem.toMs <= awake.first || rem.fromMs >= awake.second) {
                    updated.add(rem)
                } else {
                    // Overlap: split or trim
                    if (rem.fromMs < awake.first && awake.first - rem.fromMs >= fiveMinutes) {
                        updated.add(PhaseInterval(rem.fromMs, awake.first, RawPhase.REM))
                    }
                    if (rem.toMs > awake.second && rem.toMs - awake.second >= fiveMinutes) {
                        updated.add(PhaseInterval(awake.second, rem.toMs, RawPhase.REM))
                    }
                }
            }
            currentRem = updated
        }
        return currentRem
    }

    /**
     * Resolves hierarchy: AWAKE > REM > LIGHT / DEEP into a clean contiguous list of SleepStage.
     */
    private fun normalizeToFourPhases(
        sessionStartMs: Long,
        sessionEndMs: Long,
        baseSegments: List<PhaseInterval>,
        remSegments: List<PhaseInterval>,
        awakeSegments: List<Pair<Long, Long>>
    ): List<SleepStage> {
        // Build timeline of events/transitions
        val boundaries = mutableSetOf<Long>()
        boundaries.add(sessionStartMs)
        boundaries.add(sessionEndMs)

        for (b in baseSegments) {
            boundaries.add(b.fromMs.coerceIn(sessionStartMs, sessionEndMs))
            boundaries.add(b.toMs.coerceIn(sessionStartMs, sessionEndMs))
        }
        for (r in remSegments) {
            boundaries.add(r.fromMs.coerceIn(sessionStartMs, sessionEndMs))
            boundaries.add(r.toMs.coerceIn(sessionStartMs, sessionEndMs))
        }
        for (a in awakeSegments) {
            boundaries.add(a.first.coerceIn(sessionStartMs, sessionEndMs))
            boundaries.add(a.second.coerceIn(sessionStartMs, sessionEndMs))
        }

        val sortedPoints = boundaries.sorted()
        val stages = mutableListOf<SleepStage>()

        for (i in 0 until sortedPoints.size - 1) {
            val segStart = sortedPoints[i]
            val segEnd = sortedPoints[i + 1]
            if (segEnd <= segStart) continue
            val mid = (segStart + segEnd) / 2

            // Hierarchy 1: AWAKE
            val isAwake = awakeSegments.any { it.first <= mid && mid < it.second }
            if (isAwake) {
                stages.add(SleepStage(SleepStageType.AWAKE, segStart, segEnd))
                continue
            }

            // Hierarchy 2: REM
            val isRem = remSegments.any { it.fromMs <= mid && mid < it.toMs }
            if (isRem) {
                stages.add(SleepStage(SleepStageType.REM, segStart, segEnd))
                continue
            }

            // Hierarchy 3 & 4: Base DEEP / LIGHT
            val base = baseSegments.firstOrNull { it.fromMs <= mid && mid < it.toMs }
            val stageType = when (base?.phase) {
                RawPhase.DEEP -> SleepStageType.DEEP
                RawPhase.BROKEN -> SleepStageType.AWAKE
                else -> SleepStageType.LIGHT
            }
            stages.add(SleepStage(stageType, segStart, segEnd))
        }

        // Merge adjacent segments with the same stage
        val collapsed = mutableListOf<SleepStage>()
        for (stage in stages) {
            if (collapsed.isNotEmpty() && collapsed.last().type == stage.type) {
                val prev = collapsed.removeAt(collapsed.size - 1)
                collapsed.add(SleepStage(prev.type, prev.startMs, stage.endMs))
            } else {
                collapsed.add(stage)
            }
        }
        return collapsed
    }
}
