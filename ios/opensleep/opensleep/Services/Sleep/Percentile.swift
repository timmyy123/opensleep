import Foundation

/// Port of com.urbandroid.util.Percentile from Sleep as Android.
/// Evaluates the p-th percentile of a collection or array of floats with linear interpolation.
final class Percentile {
    private var quantile: Float

    init(quantile: Float = 50.0) {
        self.quantile = quantile
        setQuantile(quantile)
    }

    func setQuantile(_ f: Float) {
        precondition(f >= 0.0 && f <= 100.0, "Illegal quantile value: \(f)")
        self.quantile = f
    }

    private func evaluateSorted(_ arr: [Float], _ f: Float) -> Float {
        let length = Float(arr.count)
        let f2 = ((length + 1.0) * f) / 100.0
        let fFloor = floor(f2)
        let i = Int(fFloor)
        let f3 = f2 - fFloor

        if f2 < 1.0 {
            return arr[0]
        }
        if f2 >= length {
            return arr[arr.count - 1]
        }
        let f4 = arr[i - 1]
        return ((arr[i] - f4) * f3) + f4
    }

    func evaluate(_ list: [Float], _ i: Int) -> Float {
        if i <= 0 || i > 100 { return 0.0 }
        if list.isEmpty { return .nan }
        if list.count == 1 { return list[0] }

        let sorted = list.sorted()
        return evaluateSorted(sorted, Float(i))
    }

    func evaluate(_ arr: [Float], from: Int, to: Int, _ f: Float) -> Float {
        let len = to - from
        if f <= 0.0 || f > 100.0 { return 0.0 }
        if len == 0 { return .nan }
        if len == 1 { return arr[from] }

        let slice = Array(arr[from..<to]).sorted()
        return evaluateSorted(slice, f)
    }

    func evaluate(_ arr: [Float], _ f: Float) -> Float {
        evaluate(arr, from: 0, to: arr.count, f)
    }
}
