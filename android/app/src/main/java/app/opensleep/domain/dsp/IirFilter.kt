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

    init {
        if (a.isEmpty() || b.isEmpty() || a[0] != 1.0) {
            throw IllegalArgumentException("Invalid coefficients.")
        }
        n1 = b.size - 1
        n2 = a.size - 1
        buf1 = DoubleArray(b.size)
        buf2 = DoubleArray(a.size)
    }

    fun step(d: Double): Double {
        if (n1 > 0) {
            System.arraycopy(buf1, 0, buf1, 1, n1)
        }
        buf1[0] = d

        var d2 = b[0] * buf1[0]
        var i = 1
        while (i <= n1) {
            d2 += b[i] * buf1[i]
            i++
        }

        var j = 1
        while (j <= n2) {
            d2 -= a[j] * buf2[j]
            j++
        }

        if (n2 > 0) {
            System.arraycopy(buf2, 1, buf2, 2, n2 - 1)
            buf2[1] = d2
        }

        return d2
    }
}
