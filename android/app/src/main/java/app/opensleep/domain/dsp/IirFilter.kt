package app.opensleep.domain.dsp

class IirFilterCoefficients {
    var a: DoubleArray = DoubleArray(0)
    var b: DoubleArray = DoubleArray(0)
}

class IirFilter(coefficients: IirFilterCoefficients) {
    private val a: DoubleArray = coefficients.a
    private val b: DoubleArray = coefficients.b
    private val buf1: DoubleArray
    private val buf2: DoubleArray
    private val n1: Int
    private val n2: Int
    private var pos1: Int = 0
    private var pos2: Int = 0

    init {
        if (a.isEmpty() || b.isEmpty() || a[0] != 1.0) {
            throw IllegalArgumentException("Invalid coefficients.")
        }
        n1 = b.size - 1
        n2 = a.size - 1
        buf1 = DoubleArray(n1)
        buf2 = DoubleArray(n2)
    }

    fun step(d: Double): Double {
        var d2 = b[0] * d
        var i2 = 1
        while (i2 <= n1) {
            d2 += b[i2] * buf1[(pos1 + n1 - i2) % n1]
            i2++
        }
        var i4 = 1
        while (i4 <= n2) {
            d2 -= a[i4] * buf2[(pos2 + n2 - i4) % n2]
            i4++
        }
        if (n1 > 0) {
            buf1[pos1] = d
            pos1 = (pos1 + 1) % n1
        }
        if (n2 > 0) {
            buf2[pos2] = d2
            pos2 = (pos2 + 1) % n2
        }
        return d2
    }
}
