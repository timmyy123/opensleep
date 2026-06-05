package app.opensleep.domain

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Pure-Kotlin in-place real FFT.
 *
 * Mirrors JTransforms FloatFFT_1D.realForward() used internally by
 * com.urbandroid.sleep.sensor.respiration.v2.RespiratoryDetectorV21.
 *
 * Output layout (same as JTransforms real-forward):
 *   out[0]        = Re[0]   (DC)
 *   out[1]        = Re[n/2] (Nyquist)
 *   out[2k]       = Re[k]   for k=1..(n/2-1)
 *   out[2k+1]     = Im[k]   for k=1..(n/2-1)
 *
 * Only power-of-two sizes are supported.
 */
internal object UrbandroidFFT {

    /**
     * In-place real forward FFT.
     * @param a Float array of length N (must be power of two). Modified in-place.
     */
    fun realForward(a: FloatArray) {
        val n = a.size
        require(n > 0 && (n and (n - 1)) == 0) { "FFT size must be power of two, got $n" }
        if (n == 1) return

        // Create complex array of size 2n
        val complex = FloatArray(2 * n)
        for (i in 0 until n) {
            complex[2 * i] = a[i]
            complex[2 * i + 1] = 0f
        }

        // Run complex FFT on complex array
        complexFft(complex)

        // Pack back into `a` using JTransforms format
        a[0] = complex[0] // Re[0]
        a[1] = complex[2 * (n / 2)] // Re[n/2]
        for (k in 1 until n / 2) {
            a[2 * k] = complex[2 * k] // Re[k]
            a[2 * k + 1] = complex[2 * k + 1] // Im[k]
        }
    }

    private fun complexFft(a: FloatArray) {
        val n = a.size / 2
        if (n <= 1) return

        // Bit-reversal permutation
        var j = 0
        for (i in 0 until n) {
            if (i < j) {
                // Swap real
                var temp = a[2 * i]
                a[2 * i] = a[2 * j]
                a[2 * j] = temp
                // Swap imag
                temp = a[2 * i + 1]
                a[2 * i + 1] = a[2 * j + 1]
                a[2 * j + 1] = temp
            }
            var m = n shr 1
            while (m >= 1 && j >= m) {
                j -= m
                m = m shr 1
            }
            j += m
        }

        // Cooley-Tukey Decimation-in-Time
        var len = 2
        while (len <= n) {
            val halfLen = len / 2
            val angle = -2.0 * PI / len
            val wRe = cos(angle).toFloat()
            val wIm = sin(angle).toFloat()

            val step = len * 2
            var i = 0
            while (i < 2 * n) {
                var uRe = 1f
                var uIm = 0f
                for (k in 0 until halfLen) {
                    val evenIdx = i + 2 * k
                    val oddIdx = i + 2 * (k + halfLen)

                    val oddRe = a[oddIdx]
                    val oddIm = a[oddIdx + 1]

                    // t = u * odd
                    val tRe = uRe * oddRe - uIm * oddIm
                    val tIm = uRe * oddIm + uIm * oddRe

                    // odd = even - t
                    a[oddIdx] = a[evenIdx] - tRe
                    a[oddIdx + 1] = a[evenIdx + 1] - tIm

                    // even = even + t
                    a[evenIdx] = a[evenIdx] + tRe
                    a[evenIdx + 1] = a[evenIdx + 1] + tIm

                    // u = u * w
                    val nextURe = uRe * wRe - uIm * wIm
                    uIm = uRe * wIm + uIm * wRe
                    uRe = nextURe
                }
                i += step
            }
            len *= 2
        }
    }

    /**
     * Compute power spectrum from a real FFT result array.
     * @param fft Output of realForward (length N).
     * @return FloatArray of length N/2+1: energy[k] for frequency bin k.
     */
    fun powerSpectrum(fft: FloatArray): FloatArray {
        val n = fft.size
        val half = n / 2
        val out = FloatArray(half + 1)
        // DC
        out[0] = fft[0] * fft[0]
        // Nyquist (stored at index 1 in JTransforms convention; in our layout it's at n/2)
        out[half] = fft[1] * fft[1]
        for (k in 1 until half) {
            val re = fft[2 * k]
            val im = fft[2 * k + 1]
            out[k] = re * re + im * im
        }
        return out
    }

    /**
     * Returns the bin index of maximum energy within [freqFrom, freqTo] Hz,
     * given a sample rate.
     */
    fun maxEnergyBin(power: FloatArray, sampleRate: Float, freqFrom: Double, freqTo: Double): Int {
        val n = (power.size - 1) * 2  // original FFT size
        val binFrom = (freqFrom * n / sampleRate).toInt().coerceIn(0, power.size - 1)
        val binTo   = (freqTo   * n / sampleRate).toInt().coerceIn(0, power.size - 1)
        var maxBin = binFrom
        for (k in binFrom..binTo) {
            if (power[k] > power[maxBin]) maxBin = k
        }
        return maxBin
    }

    /**
     * Frequency in Hz for a given bin index.
     */
    fun binFrequency(bin: Int, fftSize: Int, sampleRate: Float): Double =
        bin.toDouble() * sampleRate / fftSize

    /**
     * Sum of energy in bins [freqFrom, freqTo] Hz.
     */
    fun energySum(power: FloatArray, sampleRate: Float, freqFrom: Double, freqTo: Double): Double {
        val n = (power.size - 1) * 2
        val binFrom = (freqFrom * n / sampleRate).toInt().coerceIn(0, power.size - 1)
        val binTo   = (freqTo   * n / sampleRate).toInt().coerceIn(0, power.size - 1)
        return (binFrom..binTo).sumOf { power[it].toDouble() }
    }

    /** Number of bins in [freqFrom, freqTo] Hz. */
    fun binCount(power: FloatArray, sampleRate: Float, freqFrom: Double, freqTo: Double): Int {
        val n = (power.size - 1) * 2
        val binFrom = (freqFrom * n / sampleRate).toInt().coerceIn(0, power.size - 1)
        val binTo   = (freqTo   * n / sampleRate).toInt().coerceIn(0, power.size - 1)
        return (binTo - binFrom + 1).coerceAtLeast(1)
    }

    /** Next power of two >= n */
    fun nextPow2(n: Int): Int {
        var p = 1
        while (p < n) p = p shl 1
        return p
    }

    /** Pad array to next power of two with zeros */
    fun padToPow2(data: FloatArray): FloatArray {
        val p = nextPow2(data.size)
        return if (p == data.size) data.copyOf() else data.copyOf(p)
    }
}
