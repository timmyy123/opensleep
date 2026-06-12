package app.opensleep.domain.sonar

import app.opensleep.domain.dsp.IirFilter
import app.opensleep.domain.dsp.IirFilterDesignFisher
import app.opensleep.domain.dsp.FilterPassType
import app.opensleep.domain.dsp.FilterCharacteristicsType
import kotlin.math.abs

class DiffSonarConsumer(val sampleRate: Int) {
    private var iirFilter: IirFilter? = null
    private var prevRecord: FloatArray? = null

    init {
        val coefs = IirFilterDesignFisher.design(
            FilterPassType.highpass,
            FilterCharacteristicsType.butterworth,
            18,
            -1.0,
            17000.0 / sampleRate,
            -1.0
        )
        iirFilter = IirFilter(coefs)
    }

    data class ConsumerResult(val signal: Double, val activity: Float)

    fun processAndGetResult(fArr: FloatArray): ConsumerResult {
        val filtered = FloatArray(fArr.size)
        val filter = iirFilter
        if (filter != null) {
            for (i in fArr.indices) {
                filtered[i] = filter.step(fArr[i].toDouble()).toFloat()
            }
        } else {
            System.arraycopy(fArr, 0, filtered, 0, fArr.size)
        }

        val fArr2 = prevRecord
        val fSum = if (fArr2 != null && fArr2.size == filtered.size) {
            var s = 0.0f
            for (i in filtered.indices) {
                s += abs(filtered[i] - fArr2[i])
            }
            s
        } else {
            0.0f
        }

        var fSum2 = 0.0f
        for (v in filtered) {
            fSum2 += abs(v)
        }

        prevRecord = filtered.copyOf()
        return ConsumerResult(fSum2.toDouble(), fSum)
    }

    fun reset() {
        prevRecord = null
        val coefs = IirFilterDesignFisher.design(
            FilterPassType.highpass,
            FilterCharacteristicsType.butterworth,
            18,
            -1.0,
            17000.0 / sampleRate,
            -1.0
        )
        iirFilter = IirFilter(coefs)
    }
}
