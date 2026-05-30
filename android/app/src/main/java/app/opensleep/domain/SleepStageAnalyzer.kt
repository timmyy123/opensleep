package app.opensleep.domain

import app.opensleep.data.local.SleepStage
import app.opensleep.data.local.SleepStageType
import kotlin.math.sqrt

/**
 * Motion-based sleep stage analyzer using a rolling-window variance approach.
 *
 * Algorithm:
 *  - Samples are (timestamp, magnitude) pairs from the accelerometer.
 *  - Every ANALYSIS_WINDOW_MS (5 minutes), compute variance of acceleration magnitudes.
 *  - Map variance → stage using empirically tuned thresholds:
 *      variance < DEEP_THRESHOLD    → DEEP
 *      variance < LIGHT_THRESHOLD   → LIGHT
 *      variance < AWAKE_THRESHOLD   → REM (estimated — low motion, post-deep cycle)
 *      variance >= AWAKE_THRESHOLD  → AWAKE
 *  - REM detection: after the first confirmed DEEP segment, subsequent LIGHT segments
 *    near 90-minute cycle boundaries are classified as REM.
 */
class SleepStageAnalyzer {

    companion object {
        private const val ANALYSIS_WINDOW_MS = 5 * 60 * 1000L      // 5 min
        private const val DEEP_THRESHOLD = 0.004f                    // very still
        private const val LIGHT_THRESHOLD = 0.025f                   // minor movement
        private const val AWAKE_THRESHOLD = 0.10f                    // significant movement
        private const val REM_CYCLE_MS = 90 * 60 * 1000L            // ~90 min
        private const val REM_WINDOW_MS = 20 * 60 * 1000L           // ±20 min around cycle
    }

    data class MotionSample(val timestampMs: Long, val magnitude: Float)

    private val samples = mutableListOf<MotionSample>()

    fun addSample(timestampMs: Long, x: Float, y: Float, z: Float) {
        val magnitude = sqrt(x * x + y * y + z * z)
        samples.add(MotionSample(timestampMs, magnitude))
    }

    fun computeStages(sleepStartMs: Long): List<SleepStage> {
        if (samples.size < 2) return emptyList()

        val stages = mutableListOf<SleepStage>()
        val windowStart = samples.first().timestampMs
        val windowEnd = samples.last().timestampMs

        var currentWindowStart = windowStart
        var hadDeep = false

        while (currentWindowStart + ANALYSIS_WINDOW_MS <= windowEnd) {
            val windowEndMs = currentWindowStart + ANALYSIS_WINDOW_MS
            val windowSamples = samples.filter {
                it.timestampMs >= currentWindowStart && it.timestampMs < windowEndMs
            }

            if (windowSamples.size < 2) {
                currentWindowStart = windowEndMs
                continue
            }

            val variance = computeVariance(windowSamples.map { it.magnitude })
            val elapsedSinceStart = currentWindowStart - sleepStartMs

            val stageType = when {
                variance < DEEP_THRESHOLD -> {
                    hadDeep = true
                    SleepStageType.DEEP
                }
                variance < LIGHT_THRESHOLD -> {
                    if (hadDeep && isNearRemCycle(elapsedSinceStart)) {
                        SleepStageType.REM
                    } else {
                        SleepStageType.LIGHT
                    }
                }
                variance >= AWAKE_THRESHOLD -> SleepStageType.AWAKE
                else -> SleepStageType.LIGHT
            }

            // Merge consecutive same-type segments
            if (stages.isNotEmpty() && stages.last().type == stageType) {
                val last = stages.removeLast()
                stages.add(last.copy(endMs = windowEndMs))
            } else {
                stages.add(SleepStage(stageType, currentWindowStart, windowEndMs))
            }

            currentWindowStart = windowEndMs
        }

        return stages
    }

    fun clear() = samples.clear()

    private fun computeVariance(values: List<Float>): Float {
        if (values.isEmpty()) return 0f
        val mean = values.average().toFloat()
        return values.map { (it - mean) * (it - mean) }.average().toFloat()
    }

    private fun isNearRemCycle(elapsedMs: Long): Boolean {
        if (elapsedMs < REM_CYCLE_MS) return false
        val modulo = elapsedMs % REM_CYCLE_MS
        return modulo < REM_WINDOW_MS || modulo > (REM_CYCLE_MS - REM_WINDOW_MS)
    }
}
