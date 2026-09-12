import Foundation

/// Port of com.urbandroid.sleep.domain.AdaptiveNormalizationFilter from Sleep as Android.
enum AdaptiveNormalizationFilter {

    final class ANFResult {
        let input: [Float]
        let output: [Float]
        let median: Double
        let max: Double
        let exponent: Double

        init(input: [Float], output: [Float], median: Double, max: Double, exponent: Double) {
            self.input = input
            self.output = output
            self.median = median
            self.max = max
            self.exponent = exponent
        }

        func aggregateOutput(_ i: Int) -> [Float] {
            let length = output.count
            guard length > 0 else { return [] }
            let maxFunc = Moving.max(period: i)
            let iCeil = Int(ceil(Double(length) / Double(i)))
            var result = [Float](repeating: 0.0, count: iCeil)
            var lastApply: Float = 0.0

            for i2 in 0..<length {
                lastApply = maxFunc(output[i2])
                if i2 % i == i - 1 {
                    result[i2 / i] = lastApply
                }
            }
            result[iCeil - 1] = lastApply
            return result
        }

        func getHighActivityFlags(threshold: Float) -> IndexSet {
            var indexSet = IndexSet()
            for (idx, val) in output.enumerated() {
                if val > threshold {
                    indexSet.insert(idx)
                }
            }
            return indexSet
        }

        func getHighActivityFlagsFloat(threshold: Float) -> [Float] {
            output.map { $0 > threshold ? 1.0 : 0.0 }
        }
    }

    private static func getNoiseAmplitudeEstimate(_ arr: [Float], _ excluded: IndexSet) -> Float {
        var list: [Float] = []
        list.reserveCapacity(arr.count)
        for i in 0..<arr.count {
            if arr[i] >= 0.0 && !excluded.contains(i) {
                list.append(arr[i])
            }
        }
        guard list.count >= 3 else { return 0.0 }

        let percentile = Percentile()
        let e50 = percentile.evaluate(list, 50)
        if e50 > 0.0 { return e50 }
        let e70 = percentile.evaluate(list, 70)
        if e70 > 0.0 { return e70 }
        let e90 = percentile.evaluate(list, 90)
        if e90 > 0.0 { return e90 }
        let e95 = percentile.evaluate(list, 95)
        if e95 > 0.0 { return e95 }
        return 0.0
    }

    private static func getConservativeUpperBound(_ arr: [Float], _ excluded: IndexSet) -> Float {
        var copy = arr
        for idx in excluded {
            if idx < copy.count {
                copy[idx] = 1.0
            }
        }
        let q: Float = arr.count < 1000 ? 99.7 : (arr.count < 2500 ? 99.8 : 99.9)
        return Percentile().evaluate(copy, q)
    }

    static func normalizeAmplitudes(_ arr: [Float], excluded: IndexSet = IndexSet()) -> ANFResult {
        let length = arr.count
        guard length > 0 else {
            return ANFResult(input: arr, output: arr, median: 0.0, max: 0.0, exponent: 1.0)
        }

        var copy = arr
        let noiseEstimate = getNoiseAmplitudeEstimate(arr, excluded)
        if noiseEstimate == 0.0 {
            return ANFResult(input: arr, output: copy, median: 0.0, max: 0.0, exponent: 1.0)
        }

        for i in 0..<length {
            if copy[i] >= 0.0 {
                copy[i] /= noiseEstimate
            }
        }

        let upperBound = getConservativeUpperBound(copy, excluded)
        if upperBound <= 1.0 {
            return ANFResult(input: arr, output: copy, median: Double(noiseEstimate), max: 0.0, exponent: 1.0)
        }

        let dUpperBound = Double(upperBound)
        let exponent = 1.0 / log10(dUpperBound)
        for i in 0..<length {
            let v = copy[i]
            if v >= 0.0 {
                let clamped = min(upperBound, v)
                copy[i] = Float(pow(Double(clamped), exponent))
            }
        }

        return ANFResult(input: arr, output: copy, median: Double(noiseEstimate), max: dUpperBound, exponent: exponent)
    }
}
