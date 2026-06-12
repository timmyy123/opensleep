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
    private var pos1: Int = 0
    private var pos2: Int = 0

    init(coefficients: IirFilterCoefficients) {
        self.a = coefficients.a
        self.b = coefficients.b
        if a.isEmpty || b.isEmpty || a[0] != 1.0 {
            fatalError("Invalid coefficients.")
        }
        self.n1 = b.count - 1
        self.n2 = a.count - 1
        self.buf1 = [Double](repeating: 0.0, count: n1)
        self.buf2 = [Double](repeating: 0.0, count: n2)
    }

    func step(_ d: Double) -> Double {
        var d2 = b[0] * d
        if n1 > 0 {
            for i2 in 1...n1 {
                d2 += b[i2] * buf1[(pos1 + n1 - i2) % n1]
            }
        }
        if n2 > 0 {
            for i4 in 1...n2 {
                d2 -= a[i4] * buf2[(pos2 + n2 - i4) % n2]
            }
        }
        if n1 > 0 {
            buf1[pos1] = d
            pos1 = (pos1 + 1) % n1
        }
        if n2 > 0 {
            buf2[pos2] = d2
            pos2 = (pos2 + 1) % n2
        }
        return d2
    }
}
