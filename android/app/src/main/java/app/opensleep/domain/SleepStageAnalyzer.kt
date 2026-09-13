package app.opensleep.domain

import android.util.Log
import app.opensleep.data.local.SleepStage
import app.opensleep.data.local.SleepStageType
import app.opensleep.domain.sleep.HypnogramEngine
import kotlin.math.max
import kotlin.math.sqrt

/**
 * High-level Sleep Stage Analyzer for phone-only tracking.
 * Connects 10-second accelerometer sampling to HypnogramEngine based on
 * Sleep as Android (com.urbandroid.sleep) reference logic.
 */
class SleepStageAnalyzer {

    companion object {
        private const val TAG = "SleepStageAnalyzer"
        const val EPOCH_MS = HypnogramEngine.FRAMERATE_MS // 10,000 ms = 10s
    }

    private val lock = Any()

    // 10-second epoch peak accumulator
    private var currentEpochStartMs: Long = 0L
    private var currentEpochMaxMagnitude: Float = 0.0f
    private var hasSampleInEpoch = false

    // Actigraphy history (10s actigraph values)
    private val rawActigraphHistory = mutableListOf<Float>()

    // Real-time components
    private val activityAggregator = HypnogramEngine.ActivityAggregator()
    private val awakeDetector = HypnogramEngine.AwakeDetector()
    private val highActivityAwakeDetector = HypnogramEngine.HighActivityAwakeDetector()
    private val livePhaseDetector = HypnogramEngine.LivePhaseDetector()

    // Tracked awake intervals
    private val awakeIntervals = mutableListOf<Pair<Long, Long>>()

    @Volatile
    var currentStage: SleepStageType = SleepStageType.LIGHT
        private set

    fun clear() {
        synchronized(lock) {
            currentEpochStartMs = 0L
            currentEpochMaxMagnitude = 0.0f
            hasSampleInEpoch = false
            rawActigraphHistory.clear()
            awakeIntervals.clear()
            highActivityAwakeDetector.reset()
            currentStage = SleepStageType.LIGHT
        }
    }

    fun addSample(timestampMs: Long, x: Float, y: Float, z: Float) {
        val magnitude = sqrt(x * x + y * y + z * z)

        synchronized(lock) {
            if (currentEpochStartMs == 0L) {
                currentEpochStartMs = timestampMs
            }

            if (timestampMs - currentEpochStartMs >= EPOCH_MS) {
                // Flush the completed 10-second epoch
                flushEpoch(currentEpochStartMs + EPOCH_MS)
                currentEpochStartMs = timestampMs
                currentEpochMaxMagnitude = magnitude
                hasSampleInEpoch = true
            } else {
                currentEpochMaxMagnitude = max(currentEpochMaxMagnitude, magnitude)
                hasSampleInEpoch = true
            }
        }
    }

    private fun flushEpoch(epochEndMs: Long) {
        val peak = if (hasSampleInEpoch) currentEpochMaxMagnitude else 0.0f
        hasSampleInEpoch = false
        currentEpochMaxMagnitude = 0.0f
        val epochStartMs = epochEndMs - EPOCH_MS

        val result = activityAggregator.update(peak)
        rawActigraphHistory.add(result.actigraph)

        val isHighActAwake = highActivityAwakeDetector.update(result.actigraph, result.isHighActivity, epochEndMs)
        val isAnfAwake = awakeDetector.update(rawActigraphHistory)
        val isAwake = isHighActAwake || isAnfAwake

        if (isAwake) {
            currentStage = SleepStageType.AWAKE
            addAwakeInterval(epochStartMs, epochEndMs)
        } else {
            currentStage = livePhaseDetector.update(result.isHighActivity, result.isSomeActivity)
        }
    }

    fun addAwakeInterval(startMs: Long, endMs: Long) {
        synchronized(lock) {
            if (endMs > startMs) {
                awakeIntervals.add(startMs to endMs)
            }
        }
    }

    private val sonarHighActivityDetector = HypnogramEngine.HighActivityDetector(1.0f)

    fun addGyroSample(timestampMs: Long, x: Float, y: Float, z: Float) {
        // Ignored for phone-only accelerometer actigraphy
    }

    fun addSonarSample(timestampMs: Long, activity: Float) {
        synchronized(lock) {
            rawActigraphHistory.add(activity)
            val haResult = sonarHighActivityDetector.update(activity)
            val isHighActAwake = highActivityAwakeDetector.update(activity, haResult.second, timestampMs)
            val isAnfAwake = awakeDetector.update(rawActigraphHistory)
            val isAwake = isHighActAwake || isAnfAwake

            if (isAwake) {
                currentStage = SleepStageType.AWAKE
                addAwakeInterval(timestampMs - EPOCH_MS, timestampMs)
            } else {
                currentStage = livePhaseDetector.update(haResult.second, haResult.first)
            }
        }
    }

    fun addAudioLevel(timestampMs: Long, levelDbfs: Float, clipped: Boolean = false) {
        // Ignored
    }

    fun addAudioEvent(timestampMs: Long, eventName: String, confidence: Float) {
        // Ignored
    }

    fun computeStages(sleepStartMs: Long): List<SleepStage> {
        val (historyCopy, awakeCopy, endMs) = synchronized(lock) {
            // Flush any remaining active epoch
            if (hasSampleInEpoch) {
                flushEpoch(System.currentTimeMillis())
            }
            val endTime = if (currentEpochStartMs > sleepStartMs) {
                currentEpochStartMs + EPOCH_MS
            } else {
                sleepStartMs + (rawActigraphHistory.size * EPOCH_MS)
            }
            Triple(ArrayList(rawActigraphHistory), ArrayList(awakeIntervals), endTime)
        }

        Log.d(TAG, "computeStages: startMs=$sleepStartMs, endMs=$endMs, epochs=${historyCopy.size}, awakeIntervals=${awakeCopy.size}")

        if (historyCopy.size < 12 || endMs <= sleepStartMs) {
            val avg = if (historyCopy.isNotEmpty()) historyCopy.average().toFloat() else 0f
            val stageType = if (avg >= 0.3f || awakeCopy.isNotEmpty()) SleepStageType.AWAKE else SleepStageType.LIGHT
            Log.d(TAG, "Short recording (< 2 min); returning $stageType (avg activity=$avg)")
            return listOf(SleepStage(stageType, sleepStartMs, endMs.coerceAtLeast(sleepStartMs + 1000L)))
        }

        // detectBeginningAwake for ANF-based awake onset if long recording
        val initialAwake = awakeDetector.detectBeginningAwake(historyCopy, sleepStartMs)
        awakeCopy.addAll(initialAwake)

        val stages = HypnogramEngine.buildHypnogram(
            rawActigraphHistory = historyCopy,
            sessionStartMs = sleepStartMs,
            sessionEndMs = endMs,
            awakeIntervals = awakeCopy
        )

        Log.d(TAG, "Hypnogram generated: ${stages.size} segments")
        stages.forEachIndexed { idx, stage ->
            Log.d(TAG, "  Stage $idx: ${stage.type} from ${stage.startMs} to ${stage.endMs} (${(stage.endMs - stage.startMs) / 60000.0} min)")
        }

        return stages
    }
}
