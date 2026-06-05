import Foundation
import Accelerate

/**
 * Real FFT using Apple vDSP — mirrors JTransforms FloatFFT_1D.realForward()
 * used by RespiratoryDetectorV21 in com.urbandroid.sleep.
 *
 * Power spectrum output: energy[k] for bins k = 0 .. N/2.
 */
enum UrbandroidFFT {

    /// Real forward FFT. Input must be power-of-two length.
    /// Returns power spectrum as [Float] of length n/2 + 1.
    static func powerSpectrum(_ input: [Float]) -> [Float] {
        let n = input.count
        precondition(n > 0 && (n & (n - 1)) == 0, "FFT size must be power of two")
        let log2n = vDSP_Length(log2(Float(n)))
        guard let setup = vDSP_create_fftsetup(log2n, FFTRadix(kFFTRadix2)) else { return [] }
        defer { vDSP_destroy_fftsetup(setup) }

        var realP = [Float](input)
        var imagP = [Float](repeating: 0, count: n)
        var result = [Float](repeating: 0, count: n / 2 + 1)

        realP.withUnsafeMutableBufferPointer { rBuf in
            imagP.withUnsafeMutableBufferPointer { iBuf in
                var split = DSPSplitComplex(realp: rBuf.baseAddress!, imagp: iBuf.baseAddress!)
                // Pack real signal into split-complex (vDSP real FFT expects n/2 complex)
                let halfN = n / 2
                var halfIn = [Float](input)
                halfIn.withUnsafeMutableBufferPointer { hBuf in
                    hBuf.baseAddress!.withMemoryRebound(to: DSPComplex.self, capacity: halfN) { cPtr in
                        var splitHalf = DSPSplitComplex(realp: rBuf.baseAddress!, imagp: iBuf.baseAddress!)
                        vDSP_ctoz(cPtr, 2, &splitHalf, 1, vDSP_Length(halfN))
                    }
                }
                vDSP_fft_zrip(setup, &split, 1, log2n, FFTDirection(FFT_FORWARD))
                // Extract power spectrum
                // DC: Re[0]^2
                result[0] = rBuf[0] * rBuf[0]
                // Nyquist: Im[0] (stored in imagp[0] after realForward)
                result[halfN] = iBuf[0] * iBuf[0]
                var scale: Float = 1.0
                vDSP_vsmul(rBuf.baseAddress!, 1, &scale, rBuf.baseAddress!, 1, vDSP_Length(halfN))
                for k in 1 ..< halfN {
                    result[k] = rBuf[k] * rBuf[k] + iBuf[k] * iBuf[k]
                }
            }
        }
        return result
    }

    /// Bin index of maximum energy in [freqFrom, freqTo] Hz.
    static func maxEnergyBin(_ power: [Float], sampleRate: Float, freqFrom: Double, freqTo: Double) -> Int {
        let n = (power.count - 1) * 2
        let binFrom = max(0, Int(freqFrom * Double(n) / Double(sampleRate)))
        let binTo   = min(power.count - 1, Int(freqTo * Double(n) / Double(sampleRate)))
        guard binFrom <= binTo else { return 0 }
        return (binFrom...binTo).max(by: { power[$0] < power[$1] }) ?? binFrom
    }

    /// Frequency in Hz for a given bin.
    static func binFrequency(_ bin: Int, fftSize: Int, sampleRate: Float) -> Double {
        Double(bin) * Double(sampleRate) / Double(fftSize)
    }

    /// Sum of energy in [freqFrom, freqTo] Hz.
    static func energySum(_ power: [Float], sampleRate: Float, freqFrom: Double, freqTo: Double) -> Double {
        let n = (power.count - 1) * 2
        let binFrom = max(0, Int(freqFrom * Double(n) / Double(sampleRate)))
        let binTo   = min(power.count - 1, Int(freqTo * Double(n) / Double(sampleRate)))
        guard binFrom <= binTo else { return 0 }
        return (binFrom...binTo).reduce(0.0) { $0 + Double(power[$1]) }
    }

    /// Number of bins in [freqFrom, freqTo] Hz.
    static func binCount(_ power: [Float], sampleRate: Float, freqFrom: Double, freqTo: Double) -> Int {
        let n = (power.count - 1) * 2
        let binFrom = max(0, Int(freqFrom * Double(n) / Double(sampleRate)))
        let binTo   = min(power.count - 1, Int(freqTo * Double(n) / Double(sampleRate)))
        return max(1, binTo - binFrom + 1)
    }

    /// Next power of two >= n.
    static func nextPow2(_ n: Int) -> Int {
        var p = 1; while p < n { p <<= 1 }; return p
    }

    /// Pad to next power of two with zeros.
    static func padToPow2(_ data: [Float]) -> [Float] {
        let p = nextPow2(data.count)
        return p == data.count ? data : data + [Float](repeating: 0, count: p - data.count)
    }
}
