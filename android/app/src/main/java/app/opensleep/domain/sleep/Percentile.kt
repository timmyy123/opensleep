package app.opensleep.domain.sleep

import java.util.Arrays

/**
 * Port of com.urbandroid.util.Percentile from Sleep as Android.
 * Evaluates the p-th percentile of a collection or array of floats with linear interpolation.
 */
class Percentile(private var quantile: Float = 50.0f) {

    init {
        setQuantile(quantile)
    }

    fun setQuantile(f: Float) {
        require(f in 0.0f..100.0f) { "Illegal quantile value: $f" }
        this.quantile = f
    }

    private fun evaluateSorted(fArr: FloatArray, f: Float): Float {
        val length = fArr.size
        val f2 = ((length + 1.0f) * f) / 100.0f
        val fFloor = Math.floor(f2.toDouble()).toFloat()
        val i = fFloor.toInt()
        val f3 = f2 - fFloor
        if (f2 < 1.0f) {
            return fArr[0]
        }
        if (f2 >= length) {
            return fArr[length - 1]
        }
        val f4 = fArr[i - 1]
        return ((fArr[i] - f4) * f3) + f4
    }

    fun evaluate(list: List<Float>, i: Int): Float {
        if (i <= 0 || i > 100) return 0.0f
        if (list.isEmpty()) return Float.NaN
        if (list.size == 1) return list[0]

        val fArr = FloatArray(list.size)
        for (idx in list.indices) {
            fArr[idx] = list[idx]
        }
        Arrays.sort(fArr)
        return evaluateSorted(fArr, i.toFloat())
    }

    fun evaluate(fArr: FloatArray, fromIndex: Int, toIndex: Int, f: Float): Float {
        val len = toIndex - fromIndex
        if (f <= 0.0f || f > 100.0f) return 0.0f
        if (len == 0) return Float.NaN
        if (len == 1) return fArr[fromIndex]

        val copy = FloatArray(len)
        System.arraycopy(fArr, fromIndex, copy, 0, len)
        Arrays.sort(copy)
        return evaluateSorted(copy, f)
    }

    fun evaluate(fArr: FloatArray, f: Float): Float {
        return evaluate(fArr, 0, fArr.size, f)
    }
}
