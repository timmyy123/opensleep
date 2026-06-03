package app.opensleep.domain

import app.opensleep.data.local.SleepStageType
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.math.sin

class SleepStageAnalyzerTest {

    @Test
    fun quietNightProducesDeepAndCycleBasedRem() {
        val analyzer = SleepStageAnalyzer()
        val start = 1_000_000L

        repeat(40) { window ->
            val amplitude = if (window < 4) 0.002f else 0.006f
            addWindow(analyzer, start + window * FIVE_MINUTES, amplitude)
        }

        val stages = analyzer.computeStages(start)
        val types = stages.map { it.type }.toSet()

        assertTrue("Expected phone-on-mattress quiet sleep to include deep sleep", SleepStageType.DEEP in types)
        assertTrue("Expected later quiet cycle windows to include REM estimates", SleepStageType.REM in types)
    }

    @Test
    fun sustainedMovementIsClassifiedAwake() {
        val analyzer = SleepStageAnalyzer()
        val start = 2_000_000L

        repeat(6) { window ->
            addWindow(analyzer, start + window * FIVE_MINUTES, amplitude = 0.45f, gyro = 1.2f)
        }

        val stages = analyzer.computeStages(start)

        assertTrue(stages.isNotEmpty())
        assertTrue(stages.all { it.type == SleepStageType.AWAKE })
    }

    @Test
    fun loudAudioEventsBiasTowardAwake() {
        val analyzer = SleepStageAnalyzer()
        val start = 3_000_000L

        repeat(3) { window ->
            addWindow(analyzer, start + window * FIVE_MINUTES, amplitude = 0.003f, audioDbfs = -24f)
        }

        val stages = analyzer.computeStages(start)

        assertTrue(stages.isNotEmpty())
        assertTrue(stages.any { it.type == SleepStageType.AWAKE })
    }

    @Test
    fun decisionMatrixClassification() {
        val analyzer = SleepStageAnalyzer()
        val start = 4_000_000L

        // 1. High movement (amplitude = 0.25f) + Speech -> WAKE
        analyzer.clear()
        addWindowWithEvent(analyzer, start, amplitude = 0.25f, event = "speech", eventCount = 5)
        analyzer.addSample(start + 30_000L, 0.1f, 0f, 1f)
        var stages = analyzer.computeStages(start)
        assertTrue("High movement + Speech should be WAKE, was: ${stages.map { it.type }}", stages.any { it.type == SleepStageType.AWAKE })

        // 2. Stillness (amplitude = 0.001f) + Rhythmic Breathing -> DEEP
        analyzer.clear()
        addWindowWithEvent(analyzer, start, amplitude = 0.001f, event = "breathing", eventCount = 4)
        analyzer.addSample(start + 30_000L, 0.001f, 0f, 1f)
        stages = analyzer.computeStages(start)
        assertTrue("Stillness + Breathing should be DEEP, was: ${stages.map { it.type }}", stages.any { it.type == SleepStageType.DEEP })

        // 3. Stillness (amplitude = 0.001f) + Gasps -> REM
        analyzer.clear()
        addWindowWithEvent(analyzer, start, amplitude = 0.001f, event = "gasp", eventCount = 1)
        analyzer.addSample(start + 30_000L, 0.001f, 0f, 1f)
        stages = analyzer.computeStages(start)
        assertTrue("Stillness + Gasp should be REM, was: ${stages.map { it.type }}", stages.any { it.type == SleepStageType.REM })

        // 4. Micro-movements (amplitude = 0.03f) + Snoring -> LIGHT
        analyzer.clear()
        addWindowWithEvent(analyzer, start, amplitude = 0.03f, event = "snoring", eventCount = 2)
        analyzer.addSample(start + 30_000L, 0.03f, 0f, 1f)
        stages = analyzer.computeStages(start)
        assertTrue("Micro-movements + Snoring should be LIGHT, was: ${stages.map { it.type }}", stages.any { it.type == SleepStageType.LIGHT })
    }

    private fun addWindow(
        analyzer: SleepStageAnalyzer,
        startMs: Long,
        amplitude: Float,
        gyro: Float = 0.02f,
        audioDbfs: Float = -65f
    ) {
        var t = startMs
        while (t < startMs + FIVE_MINUTES) {
            val phase = ((t - startMs) / 1_000f)
            val offset = sin(phase).toFloat() * amplitude
            analyzer.addSample(t, offset, 0f, 1f)
            analyzer.addGyroSample(t, gyro * 0.2f, gyro * 0.3f, gyro)
            if ((t - startMs) % 30_000L == 0L) {
                analyzer.addAudioLevel(t, audioDbfs)
            }
            t += 1_000L
        }
    }

    private fun addWindowWithEvent(
        analyzer: SleepStageAnalyzer,
        startMs: Long,
        amplitude: Float,
        event: String,
        eventCount: Int = 1
    ) {
        var t = startMs
        val windowDuration = 30_000L
        while (t < startMs + windowDuration) {
            val phase = ((t - startMs) / 1_000f)
            val offset = sin(phase).toFloat() * amplitude
            analyzer.addSample(t, offset, 0f, 1f)
            analyzer.addGyroSample(t, 0.01f, 0.01f, 0.02f)
            t += 1_000L
        }
        val step = windowDuration / (eventCount + 1)
        for (i in 1..eventCount) {
            analyzer.addAudioEvent(startMs + i * step, event, 0.9f)
        }
    }

    private companion object {
        private const val FIVE_MINUTES = 5 * 60 * 1000L
    }
}
