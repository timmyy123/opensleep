package app.opensleep.domain.dsp

import kotlin.math.*

class Complex(private val re: Double, private val im: Double) {

    constructor(re: Double) : this(re, 0.0)

    fun re(): Double = re
    fun im(): Double = im

    fun abs(): Double = hypot(re, im)

    fun add(c: Complex): Complex = Complex(this.re + c.re, this.im + c.im)
    fun add(d: Double): Complex = Complex(this.re + d, this.im)

    fun sub(c: Complex): Complex = Complex(this.re - c.re, this.im - c.im)

    fun neg(): Complex = Complex(-re, -im)

    fun conj(): Complex = Complex(re, -im)

    fun mul(c: Complex): Complex = Complex(
        re * c.re - im * c.im,
        im * c.re + re * c.im
    )

    fun mul(d: Double): Complex = Complex(re * d, im * d)

    fun div(c: Complex): Complex {
        val d = c.re
        val d2 = c.im
        val d3 = d2 * d2 + d * d
        return Complex((im * d2 + re * d) / d3, (im * d - re * d2) / d3)
    }

    fun div(d: Double): Complex = Complex(re / d, im / d)

    fun sqr(): Complex = Complex(re * re - im * im, re * 2.0 * im)

    fun sqrt(): Complex {
        if (re == 0.0 && im == 0.0) {
            return Complex(0.0, 0.0)
        }
        val dAbs = abs()
        return Complex(
            kotlin.math.sqrt((re + dAbs) / 2.0),
            kotlin.math.sqrt((dAbs - re) / 2.0) * sign(im)
        )
    }

    fun exp(): Complex = fromPolar(exp(re), im)

    fun toDouble(eps: Double): Double {
        val dAbs = abs(im)
        if (dAbs <= eps || dAbs <= abs(re) * eps) {
            return re
        }
        throw RuntimeException("The imaginary part of the complex number is not neglectable small for the conversion to a real number. re=$re im=$im eps=$eps.")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Complex) return false
        return this.re == other.re && this.im == other.im
    }

    override fun hashCode(): Int {
        val jDoubleToLongBits = re.toBits()
        val jDoubleToLongBits2 = im.toBits()
        return ((jDoubleToLongBits xor (jDoubleToLongBits ushr 32)) xor jDoubleToLongBits2 xor (jDoubleToLongBits2 ushr 32)).toInt()
    }

    override fun toString(): String = "($re, $im)"

    companion object {
        val I = Complex(0.0, 1.0)
        val ZERO = Complex(0.0)
        val ONE = Complex(1.0)
        val TWO = Complex(2.0)
        val NaN = Complex(Double.NaN, Double.NaN)
        val INF = Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)

        fun expj(d: Double): Complex = Complex(cos(d), sin(d))

        fun fromPolar(r: Double, theta: Double): Complex = Complex(cos(theta) * r, sin(theta) * r)

        fun sub(d: Double, c: Complex): Complex = Complex(d - c.re, -c.im)

        fun div(d: Double, c: Complex): Complex {
            val d2 = c.re
            val d3 = c.im
            val d4 = d3 * d3 + d2 * d2
            return Complex((d2 * d) / d4, (-d * d3) / d4)
        }
    }
}
