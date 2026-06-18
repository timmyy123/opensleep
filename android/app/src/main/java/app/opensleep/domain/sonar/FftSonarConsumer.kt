package app.opensleep.domain.sonar

import app.opensleep.domain.UrbandroidFFT
import app.opensleep.domain.dsp.IirFilter
import app.opensleep.domain.dsp.IirFilterDesignFisher
import app.opensleep.domain.dsp.FilterPassType
import app.opensleep.domain.dsp.FilterCharacteristicsType
import kotlin.math.abs
import kotlin.math.sqrt

class FftSonarConsumer(val sampleRate: Int) {
    private var iirFilter: IirFilter? = null
    private var prevMags: FloatArray? = null

    init {
        reset()
    }

    data class ConsumerResult(val signal: Double, val activity: Float)

    fun processAndGetResult(fArr: FloatArray): ConsumerResult {
        // High-pass Butterworth filter at 17,000 Hz (order 18)
        val filtered = FloatArray(fArr.size)
        val filter = iirFilter
        var signalSum = 0.0
        if (filter != null) {
            for (i in fArr.indices) {
                val fVal = filter.step(fArr[i].toDouble()).toFloat()
                filtered[i] = fVal
                signalSum += abs(fVal)
            }
        } else {
            for (i in fArr.indices) {
                filtered[i] = fArr[i]
                signalSum += abs(fArr[i])
            }
        }

        // Run Real FFT
        val fftData = filtered.copyOf()
        UrbandroidFFT.realForward(fftData)

        // Bins for 20 kHz to 22 kHz
        val binFrom = (20000.0 * fArr.size / sampleRate).toInt().coerceIn(0, fArr.size / 2 - 1)
        val binTo = (22000.0 * fArr.size / sampleRate).toInt().coerceIn(0, fArr.size / 2 - 1)

        val currentMags = FloatArray(binTo - binFrom + 1)
        for (k in binFrom..binTo) {
            // In JTransforms layout, for k in 1..(n/2-1):
            // Re[k] is at 2*k, Im[k] is at 2*k+1
            val re = fftData[2 * k]
            val im = fftData[2 * k + 1]
            currentMags[k - binFrom] = sqrt(re * re + im * im)
        }

        var activity = 0.0f
        val prev = prevMags
        if (prev != null && prev.size == currentMags.size) {
            for (i in currentMags.indices) {
                activity += abs(currentMags[i] - prev[i])
            }
        }

        prevMags = currentMags
        return ConsumerResult(signalSum, activity)
    }

    fun reset() {
        prevMags = null
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
