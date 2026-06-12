import Foundation

class Complex: Equatable, Hashable {
    let re: Double
    let im: Double

    init(re: Double, im: Double) {
        self.re = re
        self.im = im
    }

    convenience init(re: Double) {
        self.init(re: re, im: 0.0)
    }

    func abs() -> Double { hypot(re, im) }

    func add(_ c: Complex) -> Complex { Complex(re: re + c.re, im: im + c.im) }
    func add(_ d: Double) -> Complex { Complex(re: re + d, im: im) }

    func sub(_ c: Complex) -> Complex { Complex(re: re - c.re, im: im - c.im) }

    func neg() -> Complex { Complex(re: -re, im: -im) }

    func conj() -> Complex { Complex(re: re, im: -im) }

    func mul(_ c: Complex) -> Complex {
        Complex(
            re: re * c.re - im * c.im,
            im: im * c.re + re * c.im
        )
    }

    func mul(_ d: Double) -> Complex { Complex(re: re * d, im: im * d) }

    func div(_ c: Complex) -> Complex {
        let d = c.re
        let d2 = c.im
        let d3 = d2 * d2 + d * d
        return Complex(re: (im * d2 + re * d) / d3, im: (im * d - re * d2) / d3)
    }

    func div(_ d: Double) -> Complex { Complex(re: re / d, im: im / d) }

    func sqr() -> Complex { Complex(re: re * re - im * im, im: re * 2.0 * im) }

    func sqrt() -> Complex {
        if re == 0.0 && im == 0.0 {
            return Complex(re: 0.0, im: 0.0)
        }
        let dAbs = abs()
        let signIm = im >= 0 ? 1.0 : -1.0
        return Complex(
            re: Foundation.sqrt((re + dAbs) / 2.0),
            im: Foundation.sqrt((dAbs - re) / 2.0) * signIm
        )
    }

    func exp() -> Complex { Complex.fromPolar(r: Foundation.exp(re), theta: im) }

    func toDouble(eps: Double) -> Double {
        let dAbs = Swift.abs(im)
        if dAbs <= eps || dAbs <= Swift.abs(re) * eps {
            return re
        }
        fatalError("The imaginary part of the complex number is not neglectable small for the conversion to a real number. re=\(re) im=\(im) eps=\(eps).")
    }

    static func == (lhs: Complex, rhs: Complex) -> Bool {
        lhs.re == rhs.re && lhs.im == rhs.im
    }

    func hash(into hasher: inout Hasher) {
        hasher.combine(re)
        hasher.combine(im)
    }

    var description: String { "(\(re), \(im))" }

    static let I = Complex(re: 0.0, im: 1.0)
    static let ZERO = Complex(re: 0.0)
    static let ONE = Complex(re: 1.0)
    static let TWO = Complex(re: 2.0)
    static let NaN = Complex(re: Double.nan, im: Double.nan)
    static let INF = Complex(re: Double.infinity, im: Double.infinity)

    static func expj(_ d: Double) -> Complex { Complex(re: cos(d), im: sin(d)) }

    static func fromPolar(r: Double, theta: Double) -> Complex { Complex(re: cos(theta) * r, im: sin(theta) * r) }

    static func sub(_ d: Double, _ c: Complex) -> Complex { Complex(re: d - c.re, im: -c.im) }

    static func div(_ d: Double, _ c: Complex) -> Complex {
        let d2 = c.re
        let d3 = c.im
        let d4 = d3 * d3 + d2 * d2
        return Complex(re: (d2 * d) / d4, im: (-d * d3) / d4)
    }
}
