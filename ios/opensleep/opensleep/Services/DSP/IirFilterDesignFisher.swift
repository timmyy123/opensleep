import Foundation

enum FilterPassType {
    case lowpass, highpass, bandpass, bandstop
}

enum FilterCharacteristicsType {
    case butterworth, chebyshev, bessel
}

class IirFilterDesignFisher {

    class PolesAndZeros {
        var poles: [Complex]
        var zeros: [Complex]
        init(poles: [Complex], zeros: [Complex]) {
            self.poles = poles
            self.zeros = zeros
        }
    }

    class RationalFraction {
        var top: [Double]
        var bottom: [Double]
        init(top: [Double], bottom: [Double]) {
            self.top = top
            self.bottom = bottom
        }
    }

    static func design(
        filterPassType: FilterPassType,
        filterCharacteristicsType: FilterCharacteristicsType,
        order: Int,
        ripple: Double,
        fcf1: Double,
        fcf2: Double
    ) -> IirFilterCoefficients {
        let poles = getPoles(filterCharacteristicsType, order, ripple)
        let sToZMappingMethod: SToZMappingMethod = (filterCharacteristicsType == .bessel) ? .matchedZTransform : .bilinearTransform
        let sPlane = normalize(poles, filterPassType, fcf1, fcf2, sToZMappingMethod == .bilinearTransform)
        let zPlane = mapSPlaneToZPlane(sPlane, sToZMappingMethod)
        let transferFunction = computeTransferFunction(zPlane)
        let gain = computeGain(transferFunction, filterPassType, fcf1, fcf2)
        let coefs = computeIirFilterCoefficients(transferFunction)
        coefs.b = divide(coefs.b, gain)
        return coefs
    }

    enum SToZMappingMethod {
        case bilinearTransform, matchedZTransform
    }

    private static func mapSPlaneToZPlane(_ polesAndZeros: PolesAndZeros, _ sToZMappingMethod: SToZMappingMethod) -> PolesAndZeros {
        switch sToZMappingMethod {
        case .bilinearTransform:
            let zPoles = doBilinearTransform(polesAndZeros.poles)
            let zZeros = extend(doBilinearTransform(polesAndZeros.zeros), polesAndZeros.poles.count, Complex(re: -1.0))
            return PolesAndZeros(poles: zPoles, zeros: zZeros)
        case .matchedZTransform:
            return PolesAndZeros(poles: doMatchedZTransform(polesAndZeros.poles), zeros: doMatchedZTransform(polesAndZeros.zeros))
        }
    }

    private static func doBilinearTransform(_ c: Complex) -> Complex {
        return c.add(2.0).div(Complex.sub(2.0, c))
    }

    private static func doBilinearTransform(_ arr: [Complex]) -> [Complex] {
        return arr.map { doBilinearTransform($0) }
    }

    private static func doMatchedZTransform(_ arr: [Complex]) -> [Complex] {
        return arr.map { $0.exp() }
    }

    private static func extend(_ arr: [Complex], _ targetSize: Int, _ value: Complex) -> [Complex] {
        if arr.count >= targetSize { return arr }
        var result = arr
        while result.count < targetSize {
            result.append(value)
        }
        return result
    }

    private static func getPoles(_ filterCharacteristicsType: FilterCharacteristicsType, _ order: Int, _ ripple: Double) -> [Complex] {
        switch filterCharacteristicsType {
        case .butterworth:
            return (0..<order).map { i3 in
                let d2 = Double(order)
                return Complex.expj((((d2 / 2.0) + 0.5 + Double(i3)) * Double.pi) / d2)
            }
        default:
            fatalError("Filter characteristics type \(filterCharacteristicsType) not implemented.")
        }
    }

    private static func normalize(
        _ complexArr: [Complex],
        _ filterPassType: FilterPassType,
        _ fcf1: Double,
        _ fcf2: Double,
        _ bilinearTransform: Bool
    ) -> PolesAndZeros {
        let length = complexArr.count
        let isBandPassOrStop = filterPassType == .bandpass || filterPassType == .bandstop
        if fcf1 <= 0.0 || fcf1 >= 0.5 { fatalError("Invalid fcf1.") }
        if isBandPassOrStop && (fcf2 <= 0.0 || fcf2 >= 0.5) { fatalError("Invalid fcf2.") }

        var dTan = tan(fcf1 * Double.pi) / Double.pi
        let dTan2 = isBandPassOrStop ? tan(fcf2 * Double.pi) / Double.pi : 0.0
        if !bilinearTransform {
            dTan = fcf1
        }
        let d3 = dTan * 2.0 * Double.pi
        let d4 = dTan2 * 2.0 * Double.pi

        switch filterPassType {
        case .lowpass:
            return PolesAndZeros(poles: multiply(complexArr, d3), zeros: [])
        case .highpass:
            let p = (0..<length).map { Complex.div(d3, complexArr[$0]) }
            return PolesAndZeros(poles: p, zeros: [Complex](repeating: Complex.ZERO, count: length))
        default:
            fatalError("Filter pass type \(filterPassType) not implemented.")
        }
    }

    private static func computeTransferFunction(_ polesAndZeros: PolesAndZeros) -> RationalFraction {
        let top = expand(polesAndZeros.zeros)
        let bottom = expand(polesAndZeros.poles)
        return RationalFraction(
            top: toDouble(top, 1.0E-10),
            bottom: toDouble(bottom, 1.0E-10)
        )
    }

    private static func computeGain(_ rationalFraction: RationalFraction, _ filterPassType: FilterPassType, _ fcf1: Double, _ fcf2: Double) -> Double {
        switch filterPassType {
        case .lowpass:
            return computeGainAt(rationalFraction, Complex.ONE)
        case .highpass:
            return computeGainAt(rationalFraction, Complex(re: -1.0))
        default:
            fatalError("Unsupported filter pass type.")
        }
    }

    private static func computeGainAt(_ rationalFraction: RationalFraction, _ complex: Complex) -> Double {
        return evaluate(rationalFraction, complex).abs()
    }

    private static func evaluate(_ rationalFraction: RationalFraction, _ complex: Complex) -> Complex {
        return evaluate(rationalFraction.top, complex).div(evaluate(rationalFraction.bottom, complex))
    }

    private static func evaluate(_ dArr: [Double], _ complex: Complex) -> Complex {
        if dArr.isEmpty { return Complex.ZERO }
        var complex2 = Complex(re: dArr[0])
        for i in 1..<dArr.count {
            complex2 = complex2.mul(complex).add(dArr[i])
        }
        return complex2
    }

    private static func expand(_ complexArr: [Complex]) -> [Complex] {
        let length = complexArr.count
        if length == 0 { return [Complex.ONE] }
        var complexArrMultiply = [Complex.ONE, complexArr[0].neg()]
        for i in 1..<length {
            complexArrMultiply = multiply(complexArrMultiply, [Complex.ONE, complexArr[i].neg()])
        }
        return complexArrMultiply
    }

    private static func multiply(_ complexArr: [Complex], _ complexArr2: [Complex]) -> [Complex] {
        let length = complexArr.count - 1
        let length2 = complexArr2.count - 1
        let i = length + length2
        var complexArr3 = [Complex](repeating: Complex.ZERO, count: i + 1)
        for i2 in 0...i {
            var complexAdd = Complex.ZERO
            let iMin = min(length, i2)
            for iMax in max(0, i2 - length2)...iMin {
                complexAdd = complexAdd.add(complexArr[length - iMax].mul(complexArr2[length2 - i2 + iMax]))
            }
            complexArr3[i - i2] = complexAdd
        }
        return complexArr3
    }

    private static func computeIirFilterCoefficients(_ rationalFraction: RationalFraction) -> IirFilterCoefficients {
        let d = rationalFraction.bottom[0]
        let coefs = IirFilterCoefficients()
        coefs.a = divide(rationalFraction.bottom, d)
        coefs.a[0] = 1.0
        coefs.b = divide(rationalFraction.top, d)
        return coefs
    }

    private static func multiply(_ complexArr: [Complex], _ d: Double) -> [Complex] {
        return complexArr.map { $0.mul(d) }
    }

    private static func toDouble(_ complexArr: [Complex], _ eps: Double) -> [Double] {
        return complexArr.map { $0.toDouble(eps: eps) }
    }

    private static func divide(_ dArr: [Double], _ d: Double) -> [Double] {
        return dArr.map { $0 / d }
    }
}
