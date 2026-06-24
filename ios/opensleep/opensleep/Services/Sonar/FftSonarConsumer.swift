import Foundation

class FftSonarConsumer {
    let sampleRate: Int
    private var iirFilter: IirFilter?
    private var prevMags: [Float]?

    init(sampleRate: Int) {
        self.sampleRate = sampleRate
        let fcf1 = 17000.0 / Double(sampleRate)
        if fcf1 > 0.0 && fcf1 < 0.5 {
            let coefs = IirFilterDesignFisher.design(
                filterPassType: .highpass,
                filterCharacteristicsType: .butterworth,
                order: 18,
                ripple: -1.0,
                fcf1: fcf1,
                fcf2: -1.0
            )
            self.iirFilter = IirFilter(coefficients: coefs)
        } else {
            print("[SleepTracker] Warning: Invalid fcf1 (\(fcf1)) for sampleRate \(sampleRate). Sonar filter disabled.")
            self.iirFilter = nil
        }
    }

    struct ConsumerResult {
        let signal: Double
        let activity: Float
    }

    func processAndGetResult(_ fArr: [Float]) -> ConsumerResult {
        // High-pass Butterworth filter at 17,000 Hz (order 18)
        var filtered = [Float](repeating: 0.0, count: fArr.count)
        var signalSum = 0.0
        if let filter = iirFilter {
            for i in 0..<fArr.count {
                let fVal = Float(filter.step(Double(fArr[i])))
                filtered[i] = fVal
                signalSum += Double(abs(fVal))
            }
        } else {
            for i in 0..<fArr.count {
                filtered[i] = fArr[i]
                signalSum += Double(abs(fArr[i]))
            }
        }

        // Run Real FFT and compute power spectrum
        let power = UrbandroidFFT.powerSpectrum(filtered)

        // Extract magnitudes for bins between 20,000 Hz and 22,000 Hz
        let n = fArr.count
        let binFrom = max(0, Int(20000.0 * Double(n) / Double(sampleRate)))
        let binTo = min(power.count - 1, Int(22000.0 * Double(n) / Double(sampleRate)))

        var currentMags = [Float](repeating: 0.0, count: max(0, binTo - binFrom + 1))
        if binFrom <= binTo && currentMags.count > 0 {
            for k in binFrom...binTo {
                currentMags[k - binFrom] = sqrt(power[k])
            }
        }

        var activity: Float = 0.0
        if let prev = prevMags, prev.count == currentMags.count {
            for i in 0..<currentMags.count {
                activity += abs(currentMags[i] - prev[i])
            }
        }

        prevMags = currentMags
        return ConsumerResult(signal: signalSum, activity: activity)
    }

    func reset() {
        prevMags = nil
        let fcf1 = 17000.0 / Double(sampleRate)
        if fcf1 > 0.0 && fcf1 < 0.5 {
            let coefs = IirFilterDesignFisher.design(
                filterPassType: .highpass,
                filterCharacteristicsType: .butterworth,
                order: 18,
                ripple: -1.0,
                fcf1: fcf1,
                fcf2: -1.0
            )
            self.iirFilter = IirFilter(coefficients: coefs)
        } else {
            print("[SleepTracker] Warning: Invalid fcf1 (\(fcf1)) for sampleRate \(sampleRate). Sonar filter disabled.")
            self.iirFilter = nil
        }
    }
}
