package app.opensleep.domain.sonar

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.util.Log
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ChirpProducer(val sampleRate: Int) {
    private var audioTrack: AudioTrack? = null
    private var executor: ExecutorService? = null
    private var isPlaying = false

    companion object {
        private const val TAG = "ChirpProducer"
        private const val BUFFER_SIZE_SAMPLES = 8192
    }

    @Synchronized
    fun play() {
        if (isPlaying) return
        isPlaying = true
        executor = Executors.newSingleThreadExecutor()
        executor?.submit {
            try {
                val minBufSize = AudioTrack.getMinBufferSize(
                    sampleRate,
                    AudioFormat.CHANNEL_OUT_MONO,
                    AudioFormat.ENCODING_PCM_16BIT
                )
                val trackBufSize = Math.max(minBufSize, sampleRate * 2)

                audioTrack = AudioTrack(
                    AudioManager.STREAM_MUSIC,
                    sampleRate,
                    AudioFormat.CHANNEL_OUT_MONO,
                    AudioFormat.ENCODING_PCM_16BIT,
                    trackBufSize,
                    AudioTrack.MODE_STREAM
                )

                audioTrack?.play()
                Log.d(TAG, "Ultrasound play loop started.")

                val chirp = ShortArray(BUFFER_SIZE_SAMPLES)
                val f0 = 18000.0
                val f1 = 22000.0
                val T = BUFFER_SIZE_SAMPLES.toDouble()
                val Fs = sampleRate.toDouble()
                for (t in 0 until BUFFER_SIZE_SAMPLES) {
                    val phase = (2.0 * Math.PI / Fs) * (f0 * t + ((f1 - f0) / (2.0 * T)) * t * t)
                    val window = Math.sin(Math.PI * t / T)
                    val sampleVal = Math.cos(phase) * window
                    chirp[t] = (32767.0 * sampleVal).toInt().toShort()
                }

                while (isPlaying) {
                    val track = audioTrack ?: break
                    if (track.playState == AudioTrack.PLAYSTATE_PLAYING) {
                        val written = track.write(chirp, 0, chirp.size)
                        if (written <= 0) {
                            Log.e(TAG, "AudioTrack write error: $written")
                            Thread.sleep(10)
                        }
                    } else {
                        Thread.sleep(10)
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error in playback thread: ${e.message}", e)
            } finally {
                runCatching {
                    audioTrack?.stop()
                    audioTrack?.release()
                }
                audioTrack = null
            }
        }
    }

    @Synchronized
    fun stop() {
        isPlaying = false
        executor?.shutdownNow()
        executor = null
        runCatching {
            audioTrack?.stop()
            audioTrack?.release()
        }
        audioTrack = null
        Log.d(TAG, "Ultrasound play loop stopped.")
    }
}
