package app.opensleep.domain.sleep

import java.util.Arrays
import java.util.BitSet

/**
 * Port of com.urbandroid.sleep.domain.AdaptiveNormalizationFilter from Sleep as Android.
 */
object AdaptiveNormalizationFilter {

    class ANFResult(
        val input: FloatArray,
        val output: FloatArray,
        val median: Double,
        val max: Double,
        val exponent: Double
    ) {
        fun aggregateOutput(i: Int): FloatArray {
            val length = this.output.size
            if (length == 0) return FloatArray(0)
            val floatFunctionMax = Moving.max(i)
            val iCeil = Math.ceil(length.toDouble() / i.toDouble()).toInt()
            val fArr = FloatArray(iCeil)
            var fApply = 0.0f
            for (i2 in 0 until length) {
                fApply = floatFunctionMax.apply(this.output[i2])
                if (i2 % i == i - 1) {
                    fArr[i2 / i] = fApply
                }
            }
            fArr[iCeil - 1] = fApply
            return fArr
        }

        fun getHighActivityFlags(threshold: Float): BitSet {
            val bitSet = BitSet()
            for (idx in output.indices) {
                if (output[idx] > threshold) {
                    bitSet.set(idx)
                }
            }
            return bitSet
        }

        fun getHighActivityFlagsFloat(threshold: Float): FloatArray {
            val fArr = FloatArray(output.size)
            for (idx in output.indices) {
                if (output[idx] > threshold) {
                    fArr[idx] = 1.0f
                }
            }
            return fArr
        }
    }

    private fun getNoiseAmplitudeEstimate(fArr: FloatArray, bitSet: BitSet): Float {
        val list = ArrayList<Float>(fArr.size)
        for (i in fArr.indices) {
            if (fArr[i] >= 0.0f && !bitSet.get(i)) {
                list.add(fArr[i])
            }
        }
        if (list.size < 3) return 0.0f

        val percentile = Percentile()
        val e50 = percentile.evaluate(list, 50)
        if (e50 > 0.0f) return e50
        val e70 = percentile.evaluate(list, 70)
        if (e70 > 0.0f) return e70
        val e90 = percentile.evaluate(list, 90)
        if (e90 > 0.0f) return e90
        val e95 = percentile.evaluate(list, 95)
        if (e95 > 0.0f) return e95
        return 0.0f
    }

    private fun getConservativeUpperBound(fArr: FloatArray, bitSet: BitSet): Float {
        val length = fArr.size
        val copy = Arrays.copyOf(fArr, length)
        var i = 0
        while (true) {
            val nextSet = bitSet.nextSetBit(i)
            if (nextSet < 0) break
            if (nextSet < length) {
                copy[nextSet] = 1.0f
            }
            i = nextSet + 1
        }
        val q = if (length < 1000) 99.7f else if (length < 2500) 99.8f else 99.9f
        return Percentile().evaluate(copy, q)
    }

    fun normalizeAmplitudes(fArr: FloatArray, bitSet: BitSet = BitSet()): ANFResult {
        val length = fArr.size
        val copy = Arrays.copyOf(fArr, length)
        val noiseEstimate = getNoiseAmplitudeEstimate(fArr, bitSet)
        if (noiseEstimate == 0.0f) {
            return ANFResult(fArr, copy, 0.0, 0.0, 1.0)
        }

        for (i in 0 until length) {
            if (copy[i] >= 0.0f) {
                copy[i] /= noiseEstimate
            }
        }

        val upperBound = getConservativeUpperBound(copy, bitSet)
        if (upperBound <= 1.0f) {
            return ANFResult(fArr, copy, noiseEstimate.toDouble(), 0.0, 1.0)
        }

        val dUpperBound = upperBound.toDouble()
        val exponent = 1.0 / Math.log10(dUpperBound)
        for (i in 0 until length) {
            val v = copy[i]
            if (v >= 0.0f) {
                val clamped = Math.min(upperBound, v)
                copy[i] = Math.pow(clamped.toDouble(), exponent).toFloat()
            }
        }

        return ANFResult(fArr, copy, noiseEstimate.toDouble(), dUpperBound, exponent)
    }
}
