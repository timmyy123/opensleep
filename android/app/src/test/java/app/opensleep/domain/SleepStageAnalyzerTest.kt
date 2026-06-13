package app.opensleep.domain

import app.opensleep.data.local.SleepStageType
import org.junit.Assert.assertTrue
import org.junit.Test

class SleepStageAnalyzerTest {

    @Test
    fun quietActigraphySettlesIntoDeepSleep() {
        val analyzer = SleepStageAnalyzer()
        val start = 1_000_000L

        addFrames(analyzer, start, frameCount = 60) { 1f }

        val stages = analyzer.computeStages(start)
        val types = stages.map { it.type }.toSet()

        assertTrue("Sleep as Android V8 phase detector should settle quiet frames into deep sleep", SleepStageType.DEEP in types)
        assertTrue("REM should not be produced from clock cycles alone", SleepStageType.REM !in types)
    }

    @Test
    fun deepToLightTimingCanEnterRemState() {
        val analyzer = SleepStageAnalyzer()
        val start = 2_000_000L

        addFrames(analyzer, start, frameCount = 180) { 1f }
        addFrames(analyzer, start + 180 * FRAME_MS, frameCount = 90) { frame ->
            if (frame % 2 == 0) 1f else 100f
        }

        val stages = analyzer.computeStages(start)

        assertTrue("REM should come from RemDetectorV1 deep-to-light timing, not a clock heuristic", stages.any { it.type == SleepStageType.REM })
    }

    @Test
    fun awakeIntervalsOverrideQuietActigraphy() {
        val analyzer = SleepStageAnalyzer()
        val start = 3_000_000L

        addFrames(analyzer, start, frameCount = 60) { 1f }
        analyzer.addAwakeInterval(start, start + 60 * FRAME_MS)

        val stages = analyzer.computeStages(start)
        val types = stages.map { it.type }.toSet()

        assertTrue("Known-awake time must not be classified as deep sleep", SleepStageType.DEEP !in types)
        assertTrue("Known-awake time should be preserved in history", SleepStageType.AWAKE in types)
    }

    private fun addFrames(
        analyzer: SleepStageAnalyzer,
        startMs: Long,
        frameCount: Int,
        rawMagnitudeForFrame: (Int) -> Float
    ) {
        repeat(frameCount) { frame ->
            val t = startMs + frame * FRAME_MS
            val z = rawMagnitudeForFrame(frame)
            analyzer.addSample(t, 0f, 0f, z)
        }
    }

    private companion object {
        private const val FRAME_MS = 10_000L
    }
}
