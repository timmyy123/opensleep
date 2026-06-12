package app.opensleep.domain.dsp

import kotlin.math.*

enum class FilterPassType {
    lowpass, highpass, bandpass, bandstop
}

enum class FilterCharacteristicsType {
    butterworth, chebyshev, bessel
}

object IirFilterDesignFisher {

    class PolesAndZeros(var poles: Array<Complex>, var zeros: Array<Complex>)

    class RationalFraction(var top: DoubleArray, var bottom: DoubleArray)

    fun design(
        filterPassType: FilterPassType,
        filterCharacteristicsType: FilterCharacteristicsType,
        order: Int,
        ripple: Double,
        fcf1: Double,
        fcf2: Double
    ): IirFilterCoefficients {
        val poles = getPoles(filterCharacteristicsType, order, ripple)
        val sToZMappingMethod = if (filterCharacteristicsType == FilterCharacteristicsType.bessel) {
            SToZMappingMethod.matchedZTransform
        } else {
            SToZMappingMethod.bilinearTransform
        }
        val sPlane = normalize(poles, filterPassType, fcf1, fcf2, sToZMappingMethod == SToZMappingMethod.bilinearTransform)
        val zPlane = mapSPlaneToZPlane(sPlane, sToZMappingMethod)
        val transferFunction = computeTransferFunction(zPlane)
        val gain = computeGain(transferFunction, filterPassType, fcf1, fcf2)
        val coefs = computeIirFilterCoefficients(transferFunction)
        coefs.b = divide(coefs.b, gain)
        return coefs
    }

    enum class SToZMappingMethod {
        bilinearTransform, matchedZTransform
    }

    private fun mapSPlaneToZPlane(polesAndZeros: PolesAndZeros, sToZMappingMethod: SToZMappingMethod): PolesAndZeros {
        return when (sToZMappingMethod) {
            SToZMappingMethod.bilinearTransform -> {
                val zPoles = doBilinearTransform(polesAndZeros.poles)
                val zZeros = extend(doBilinearTransform(polesAndZeros.zeros), polesAndZeros.poles.size, Complex(-1.0))
                PolesAndZeros(zPoles, zZeros)
            }
            SToZMappingMethod.matchedZTransform -> {
                PolesAndZeros(doMatchedZTransform(polesAndZeros.poles), doMatchedZTransform(polesAndZeros.zeros))
            }
        }
    }

    private fun doBilinearTransform(c: Complex): Complex {
        return c.add(2.0).div(Complex.sub(2.0, c))
    }

    private fun doBilinearTransform(arr: Array<Complex>): Array<Complex> {
        return Array(arr.size) { doBilinearTransform(arr[it]) }
    }

    private fun doMatchedZTransform(arr: Array<Complex>): Array<Complex> {
        return Array(arr.size) { arr[it].exp() }
    }

    private fun extend(arr: Array<Complex>, targetSize: Int, value: Complex): Array<Complex> {
        if (arr.size >= targetSize) return arr
        val result = Array(targetSize) { Complex.ZERO }
        for (i in arr.indices) {
            result[i] = arr[i]
        }
        for (i in arr.size until targetSize) {
            result[i] = value
        }
        return result
    }

    private fun getPoles(filterCharacteristicsType: FilterCharacteristicsType, order: Int, ripple: Double): Array<Complex> {
        return when (filterCharacteristicsType) {
            FilterCharacteristicsType.butterworth -> {
                Array(order) { i3 ->
                    val d2 = order.toDouble()
                    Complex.expj((((d2 / 2.0) + 0.5 + i3.toDouble()) * Math.PI) / d2)
                }
            }
            else -> throw UnsupportedOperationException("Filter characteristics type $filterCharacteristicsType not implemented.")
        }
    }

    private fun normalize(
        complexArr: Array<Complex>,
        filterPassType: FilterPassType,
        fcf1: Double,
        fcf2: Double,
        bilinearTransform: Boolean
    ): PolesAndZeros {
        val length = complexArr.size
        val isBandPassOrStop = filterPassType == FilterPassType.bandpass || filterPassType == FilterPassType.bandstop
        if (fcf1 <= 0.0 || fcf1 >= 0.5) throw IllegalArgumentException("Invalid fcf1.")
        if (isBandPassOrStop && (fcf2 <= 0.0 || fcf2 >= 0.5)) throw IllegalArgumentException("Invalid fcf2.")

        var dTan = Math.tan(fcf1 * Math.PI) / Math.PI
        val dTan2 = if (isBandPassOrStop) Math.tan(fcf2 * Math.PI) / Math.PI else 0.0
        if (!bilinearTransform) {
            dTan = fcf1
        }
        val d3 = dTan * 2.0 * Math.PI
        val d4 = dTan2 * 2.0 * Math.PI

        return when (filterPassType) {
            FilterPassType.lowpass -> {
                PolesAndZeros(multiply(complexArr, d3), emptyArray())
            }
            FilterPassType.highpass -> {
                val p = Array(length) { i3 -> Complex.div(d3, complexArr[i3]) }
                PolesAndZeros(p, Array(length) { Complex.ZERO })
            }
            else -> throw UnsupportedOperationException("Filter pass type $filterPassType not implemented.")
        }
    }

    private fun computeTransferFunction(polesAndZeros: PolesAndZeros): RationalFraction {
        val top = expand(polesAndZeros.zeros)
        val bottom = expand(polesAndZeros.poles)
        return RationalFraction(
            toDouble(top, 1.0E-10),
            toDouble(bottom, 1.0E-10)
        )
    }

    private fun computeGain(rationalFraction: RationalFraction, filterPassType: FilterPassType, fcf1: Double, fcf2: Double): Double {
        return when (filterPassType) {
            FilterPassType.lowpass -> computeGainAt(rationalFraction, Complex.ONE)
            FilterPassType.highpass -> computeGainAt(rationalFraction, Complex(-1.0))
            else -> throw UnsupportedOperationException("Unsupported filter pass type.")
        }
    }

    private fun computeGainAt(rationalFraction: RationalFraction, complex: Complex): Double {
        return evaluate(rationalFraction, complex).abs()
    }

    private fun evaluate(rationalFraction: RationalFraction, complex: Complex): Complex {
        return evaluate(rationalFraction.top, complex).div(evaluate(rationalFraction.bottom, complex))
    }

    private fun evaluate(dArr: DoubleArray, complex: Complex): Complex {
        if (dArr.isEmpty()) return Complex.ZERO
        var complex2 = Complex(dArr[0])
        for (i in 1 until dArr.size) {
            complex2 = complex2.mul(complex).add(dArr[i])
        }
        return complex2
    }

    private fun expand(complexArr: Array<Complex>): Array<Complex> {
        val length = complexArr.size
        if (length == 0) return arrayOf(Complex.ONE)
        var complexArrMultiply = arrayOf(Complex.ONE, complexArr[0].neg())
        for (i in 1 until length) {
            complexArrMultiply = multiply(complexArrMultiply, arrayOf(Complex.ONE, complexArr[i].neg()))
        }
        return complexArrMultiply
    }

    private fun multiply(complexArr: Array<Complex>, complexArr2: Array<Complex>): Array<Complex> {
        val length = complexArr.size - 1
        val length2 = complexArr2.size - 1
        val i = length + length2
        val complexArr3 = Array(i + 1) { Complex.ZERO }
        for (i2 in 0..i) {
            var complexAdd = Complex.ZERO
            val iMin = min(length, i2)
            for (iMax in max(0, i2 - length2)..iMin) {
                complexAdd = complexAdd.add(complexArr[length - iMax].mul(complexArr2[length2 - i2 + iMax]))
            }
            complexArr3[i - i2] = complexAdd
        }
        return complexArr3
    }

    private fun computeIirFilterCoefficients(rationalFraction: RationalFraction): IirFilterCoefficients {
        val d = rationalFraction.bottom[0]
        val coefs = IirFilterCoefficients()
        coefs.a = divide(rationalFraction.bottom, d)
        coefs.a[0] = 1.0
        coefs.b = divide(rationalFraction.top, d)
        return coefs
    }

    private fun multiply(complexArr: Array<Complex>, d: Double): Array<Complex> {
        return Array(complexArr.size) { complexArr[it].mul(d) }
    }

    private fun toDouble(complexArr: Array<Complex>, eps: Double): DoubleArray {
        return DoubleArray(complexArr.size) { complexArr[it].toDouble(eps) }
    }

    private fun divide(dArr: DoubleArray, d: Double): DoubleArray {
        return DoubleArray(dArr.size) { dArr[it] / d }
    }
}
