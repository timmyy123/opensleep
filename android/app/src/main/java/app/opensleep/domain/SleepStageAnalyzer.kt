package app.opensleep.domain

import app.opensleep.data.local.SleepStage
import app.opensleep.data.local.SleepStageType
import kotlin.math.abs
import kotlin.math.exp
import kotlin.math.ln
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

/**
 * Phone-only actigraphy analyzer.
 *
 * This is not PSG/EEG sleep staging. It is a device-local actigraphy pipeline
 * designed for a phone resting on the mattress: accelerometer movement,
 * gyroscope rotation, ambient audio level/events, artifact rejection, and
 * sleep-cycle priors are fused into confidence-ranked stage estimates.
 */
class SleepStageAnalyzer {

    companion object {
        private const val ANALYSIS_WINDOW_MS = 30 * 1000L
        private const val MIN_PARTIAL_WINDOW_MS = 15 * 1000L
        private const val REM_CYCLE_MS = 90 * 60 * 1000L
        private const val REM_WINDOW_MS = 22 * 60 * 1000L
        private const val MIN_ACCEL_SAMPLES_PER_WINDOW = 60
    }

    data class MotionSample(
        val timestampMs: Long,
        val accelMagnitude: Float
    )

    data class AudioSample(
        val timestampMs: Long,
        val levelDbfs: Float,
        val clipped: Boolean = false
    )

    data class AudioEvent(
        val timestampMs: Long,
        val eventName: String,
        val confidence: Float
    )

    private data class WindowFeatures(
        val startMs: Long,
        val endMs: Long,
        val movement: Float,
        val stillness: Float,
        val rotation: Float,
        val audioMean: Float,
        val audioEvents: Float,
        val artifact: Boolean,
        val elapsedMs: Long,
        val snoreCount: Int,
        val breathCount: Int,
        val rustleCount: Int,
        val gaspCount: Int,
        val wakeSoundCount: Int,
        val silenceCount: Int,
        val hasMlAudio: Boolean
    )

    private data class WindowPrediction(
        val startMs: Long,
        val endMs: Long,
        val type: SleepStageType,
        val confidence: Float,
        val artifact: Boolean
    )

    private val samples = mutableListOf<MotionSample>()
    private val gyroSamples = mutableListOf<Pair<Long, Float>>()
    private val audioSamples = mutableListOf<AudioSample>()
    private val audioEvents = mutableListOf<AudioEvent>()

    fun addSample(timestampMs: Long, x: Float, y: Float, z: Float) {
        val magnitude = sqrt(x * x + y * y + z * z)
        samples.add(MotionSample(timestampMs, magnitude))
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

        val predictions = mutableListOf<WindowPrediction>()
        val windowStart = sleepStartMs
        val windowEnd = samples.last().timestampMs

        var currentWindowStart = windowStart

        while (currentWindowStart < windowEnd) {
            val candidateEnd = min(currentWindowStart + ANALYSIS_WINDOW_MS, windowEnd)
            if (candidateEnd - currentWindowStart < MIN_PARTIAL_WINDOW_MS) break

            buildFeatures(currentWindowStart, candidateEnd, sleepStartMs)?.let { features ->
                predictions.add(predict(features))
            }

            currentWindowStart += ANALYSIS_WINDOW_MS
        }

        return smoothAndMerge(predictions)
    }

    fun clear() {
        samples.clear()
        gyroSamples.clear()
        audioSamples.clear()
        audioEvents.clear()
    }

    private fun buildFeatures(startMs: Long, endMs: Long, sleepStartMs: Long): WindowFeatures? {
        val accelWindow = samples.filter { it.timestampMs >= startMs && it.timestampMs < endMs }
        val audioWindow = audioSamples.filter { it.timestampMs >= startMs && it.timestampMs < endMs }
        val audioMeanDb = audioWindow.map { it.levelDbfs }.averageOrDefault(-65f)
        val audioEventsCount = audioWindow.count { it.levelDbfs > -38f || it.clipped }
            .toFloat() / max(1, audioWindow.size)
        val audioMean = normalizeLinear(audioMeanDb, -62f, -30f)

        val windowEvents = audioEvents.filter { it.timestampMs >= startMs && it.timestampMs < endMs }
        val hasMlAudio = windowEvents.isNotEmpty()
        
        val snoreCount = windowEvents.count { it.eventName == "snoring" || it.eventName == "snort" }
        val breathCount = windowEvents.count { it.eventName == "breathing" }
        val rustleCount = windowEvents.count { it.eventName == "rustle" }
        val gaspCount = windowEvents.count { it.eventName == "gasp" || it.eventName == "sigh" || it.eventName == "cough" }
        val wakeSoundCount = windowEvents.count { it.eventName == "speech" || it.eventName == "laughter" }
        val silenceCount = windowEvents.count { it.eventName == "silence" }

        if (accelWindow.size < 2) {
            // Synthesize a still feature window if motion updates were suspended/throttled by the OS (Doze mode)
            return WindowFeatures(
                startMs = startMs,
                endMs = endMs,
                movement = 0.0f,
                stillness = 1.0f,
                rotation = 0.0f,
                audioMean = audioMean,
                audioEvents = audioEventsCount,
                artifact = false, // Background throttling is normal sleep behavior, not a movement artifact
                elapsedMs = startMs - sleepStartMs,
                snoreCount = 0,
                breathCount = 0,
                rustleCount = 0,
                gaspCount = 0,
                wakeSoundCount = 0,
                silenceCount = 0,
                hasMlAudio = false
            )
        }

        val magnitudes = accelWindow.map { it.accelMagnitude }
        val deltas = magnitudes.zipWithNext { a, b -> abs(b - a) }
        val variance = computeVariance(magnitudes)
        val jerk = deltas.averageOrZero()
        val range = magnitudes.maxOrNull()!! - magnitudes.minOrNull()!!
        val stillRatio = deltas.count { it < 0.008f }.toFloat() / max(1, deltas.size)

        val gyroWindow = gyroSamples.filter { it.first >= startMs && it.first < endMs }.map { it.second }
        val rotationMean = gyroWindow.averageOrZero()

        val movement = weightedIndex(
            normalizeLog(variance, 0.00002f, 0.08f) * 0.45f,
            normalizeLog(jerk.toFloat(), 0.001f, 0.06f) * 0.30f,
            normalizeLinear(range, 0.015f, 0.45f) * 0.15f,
            (1f - stillRatio) * 0.10f
        )
        val rotation = normalizeLinear(rotationMean.toFloat(), 0.01f, 0.85f)
        val artifact = accelWindow.size < MIN_ACCEL_SAMPLES_PER_WINDOW ||
            range > 3.5f ||
            movement > 0.96f ||
            audioEventsCount > 0.75f

        return WindowFeatures(
            startMs = startMs,
            endMs = endMs,
            movement = movement,
            stillness = 1f - movement,
            rotation = rotation,
            audioMean = audioMean,
            audioEvents = audioEventsCount,
            artifact = artifact,
            elapsedMs = startMs - sleepStartMs,
            snoreCount = snoreCount,
            breathCount = breathCount,
            rustleCount = rustleCount,
            gaspCount = gaspCount,
            wakeSoundCount = wakeSoundCount,
            silenceCount = silenceCount,
            hasMlAudio = hasMlAudio
        )
    }

    private fun predict(features: WindowFeatures): WindowPrediction {
        if (features.artifact) {
            return WindowPrediction(
                features.startMs,
                features.endMs,
                SleepStageType.AWAKE,
                0.55f,
                artifact = true
            )
        }

        if (features.hasMlAudio) {
            // 4-Stage Decision Logic Matrix based on pre-trained ML classifications and movement
            val stage = when {
                // High / Shaking Movement (Tossing & turning) + Any Sound (Rustling, breathing, or talking)
                features.movement >= 0.08f && (features.rustleCount > 0 || features.breathCount > 0 || 
                        features.wakeSoundCount > 0 || features.snoreCount > 0 || features.gaspCount > 0) -> {
                    SleepStageType.AWAKE
                }
                
                // Micro-Movements (Slight mattress shifts) + Rustling, Snoring, or Sighs
                (features.movement > 0.01f && features.movement < 0.08f) && 
                        (features.rustleCount > 0 || features.snoreCount > 0 || features.gaspCount > 0 || features.silenceCount > 0) -> {
                    SleepStageType.LIGHT
                }
                
                // Absolute 100% Stillness + Highly Rhythmic, Constant Breathing / Deep Silence
                features.movement <= 0.01f && (features.breathCount >= 3 || features.silenceCount >= 5) && 
                        features.gaspCount == 0 && features.rustleCount == 0 && features.wakeSoundCount == 0 -> {
                    SleepStageType.DEEP
                }
                
                // Absolute 100% Stillness (Muscle Paralysis) + Irregular, Fragmented Breathing / Sudden Gasps
                features.movement <= 0.01f && (features.gaspCount > 0 || (features.breathCount > 0 && features.breathCount < 3)) -> {
                    SleepStageType.REM
                }
                
                // Fallback within ML mode if no specific clinical rule is hit directly
                else -> {
                    if (features.movement >= 0.08f) SleepStageType.AWAKE
                    else if (features.movement > 0.01f) SleepStageType.LIGHT
                    else if (features.breathCount > 0) SleepStageType.DEEP
                    else SleepStageType.LIGHT
                }
            }
            return WindowPrediction(
                features.startMs,
                features.endMs,
                stage,
                0.85f,
                artifact = false
            )
        }

        // Fallback to pure mathematical actigraphy if YAMNet ML events are missing
        val elapsedHours = features.elapsedMs / 3_600_000f
        val earlyNight = (1f - (elapsedHours / 3f)).coerceIn(0f, 1f)
        val lateNight = ((elapsedHours - 3f) / 4f).coerceIn(0f, 1f)
        val remCycle = remCycleAffinity(features.elapsedMs)
        val motionWake = max(features.movement, features.rotation)
        val sleepContinuity = if (features.elapsedMs < 10 * 60 * 1000L) 0.25f else 1f

        val awakeScore =
            -0.9f + motionWake * 3.1f + features.audioEvents * 1.4f + features.audioMean * 0.45f
        val deepScore =
            -0.2f + features.stillness * 1.9f + earlyNight * 1.0f - remCycle * 0.55f -
                motionWake * 1.8f - lateNight * 0.8f
        val remScore =
            -1.15f + features.stillness * 1.25f + remCycle * 1.7f + lateNight * 0.85f -
                motionWake * 1.1f - earlyNight * 0.35f
        val lightScore =
            0.25f + features.stillness * 0.85f + motionWake * 0.45f -
                features.audioEvents * 0.3f

        val scores = mutableMapOf(
            SleepStageType.AWAKE to awakeScore,
            SleepStageType.LIGHT to lightScore,
            SleepStageType.DEEP to deepScore * sleepContinuity,
            SleepStageType.REM to remScore * sleepContinuity
        )

        if (features.elapsedMs < 45 * 60 * 1000L) {
            scores[SleepStageType.REM] = scores.getValue(SleepStageType.REM) - 0.9f
        }

        val ranked = scores.entries.sortedByDescending { it.value }
        val confidence = softmaxConfidence(ranked[0].value, ranked.map { it.value })

        return WindowPrediction(
            features.startMs,
            features.endMs,
            ranked[0].key,
            confidence,
            artifact = false
        )
    }

    private fun smoothAndMerge(predictions: List<WindowPrediction>): List<SleepStage> {
        if (predictions.isEmpty()) return emptyList()

        val smoothed = predictions.mapIndexed { index, current ->
            val previous = predictions.getOrNull(index - 1)
            val next = predictions.getOrNull(index + 1)
            if (
                previous != null &&
                next != null &&
                previous.type == next.type &&
                current.type != previous.type &&
                current.confidence < 0.60f &&
                !current.artifact
            ) {
                current.copy(type = previous.type)
            } else {
                current
            }
        }

        return smoothed.fold(mutableListOf()) { stages, prediction ->
            if (stages.isNotEmpty() && stages.last().type == prediction.type) {
                val last = stages.removeAt(stages.lastIndex)
                stages.add(last.copy(endMs = prediction.endMs))
            } else {
                stages.add(SleepStage(prediction.type, prediction.startMs, prediction.endMs))
            }
            stages
        }
    }

    private fun computeVariance(values: List<Float>): Float {
        if (values.isEmpty()) return 0f
        val mean = values.average().toFloat()
        return values.map { (it - mean) * (it - mean) }.average().toFloat()
    }

    private fun remCycleAffinity(elapsedMs: Long): Float {
        if (elapsedMs < 45 * 60 * 1000L) return 0f
        val modulo = elapsedMs % REM_CYCLE_MS
        val distance = min(modulo, REM_CYCLE_MS - modulo).toFloat()
        return (1f - distance / REM_WINDOW_MS).coerceIn(0f, 1f)
    }

    private fun normalizeLinear(value: Float, low: Float, high: Float): Float =
        ((value - low) / (high - low)).coerceIn(0f, 1f)

    private fun normalizeLog(value: Float, low: Float, high: Float): Float {
        val safeValue = max(value, low)
        return ((ln(safeValue) - ln(low)) / (ln(high) - ln(low))).coerceIn(0f, 1f)
    }

    private fun weightedIndex(vararg values: Float): Float = values.sum().coerceIn(0f, 1f)

    private fun List<Float>.averageOrZero(): Double = if (isEmpty()) 0.0 else average()

    private fun List<Float>.averageOrDefault(default: Float): Float =
        if (isEmpty()) default else average().toFloat()

    private fun softmaxConfidence(winner: Float, scores: List<Float>): Float {
        val maxScore = scores.maxOrNull() ?: winner
        val expScores = scores.map { exp((it - maxScore).toDouble()) }
        val denominator = expScores.sum().takeIf { it > 0.0 } ?: return 0.25f
        return (exp((winner - maxScore).toDouble()) / denominator).toFloat().coerceIn(0.25f, 0.98f)
    }
}
