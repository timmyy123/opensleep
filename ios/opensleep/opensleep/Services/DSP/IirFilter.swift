import Foundation

class IirFilterCoefficients {
    var a: [Double] = []
    var b: [Double] = []
}

class IirFilter {
    private let a: [Double]
    private let b: [Double]
    private var buf1: [Double]
    private var buf2: [Double]
    private let n1: Int
    private let n2: Int

    init(coefficients: IirFilterCoefficients) {
        self.a = coefficients.a
        self.b = coefficients.b
        if a.isEmpty || b.isEmpty || a[0] != 1.0 {
            fatalError("Invalid coefficients.")
        }
        self.n1 = b.count - 1
        self.n2 = a.count - 1
        self.buf1 = [Double](repeating: 0.0, count: b.count)
        self.buf2 = [Double](repeating: 0.0, count: a.count)
    }

    func step(_ d: Double) -> Double {
        if n1 > 0 {
            for i in stride(from: n1, to: 0, by: -1) {
                buf1[i] = buf1[i - 1]
            }
        }
        buf1[0] = d

        var d2 = b[0] * buf1[0]
        if n1 > 0 {
            for i in 1...n1 {
                d2 += b[i] * buf1[i]
            }
        }

        if n2 > 0 {
            for i in 1...n2 {
                d2 -= a[i] * buf2[i]
            }
        }

        if n2 > 0 {
            for i in stride(from: n2, to: 1, by: -1) {
                buf2[i] = buf2[i - 1]
            }
            buf2[1] = d2
        }

        return d2
    }
}
