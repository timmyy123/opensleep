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

    private companion object {
        private const val FIVE_MINUTES = 5 * 60 * 1000L
    }
}
