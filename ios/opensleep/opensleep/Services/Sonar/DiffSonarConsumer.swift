import Foundation

class DiffSonarConsumer {
    let sampleRate: Int
    private var iirFilter: IirFilter?
    private var prevRecord: [Float]?

    init(sampleRate: Int) {
        self.sampleRate = sampleRate
        let coefs = IirFilterDesignFisher.design(
            filterPassType: .highpass,
            filterCharacteristicsType: .butterworth,
            order: 18,
            ripple: -1.0,
            fcf1: 17000.0 / Double(sampleRate),
            fcf2: -1.0
        )
        self.iirFilter = IirFilter(coefficients: coefs)
    }

    struct ConsumerResult {
        let signal: Double
        let activity: Float
    }

    func processAndGetResult(_ fArr: [Float]) -> ConsumerResult {
        var filtered = [Float](repeating: 0.0, count: fArr.count)
        if let filter = iirFilter {
            for i in 0..<fArr.count {
                filtered[i] = Float(filter.step(Double(fArr[i])))
            }
        } else {
            filtered = fArr
        }

        var fSum: Float = 0.0
        if let fArr2 = prevRecord, fArr2.count == filtered.count {
            for i in 0..<filtered.count {
                fSum += abs(filtered[i] - fArr2[i])
            }
        }

        var fSum2: Float = 0.0
        for v in filtered {
            fSum2 += abs(v)
        }

        prevRecord = filtered
        return ConsumerResult(signal: Double(fSum2), activity: fSum)
    }

    func reset() {
        prevRecord = nil
        let coefs = IirFilterDesignFisher.design(
            filterPassType: .highpass,
            filterCharacteristicsType: .butterworth,
            order: 18,
            ripple: -1.0,
            fcf1: 17000.0 / Double(sampleRate),
            fcf2: -1.0
        )
        self.iirFilter = IirFilter(coefficients: coefs)
    }
}
