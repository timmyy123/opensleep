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

                val sArr = ShortArray(1024)
                var sampleIndex = 0L

                while (isPlaying) {
                    val track = audioTrack ?: break
                    if (track.playState == AudioTrack.PLAYSTATE_PLAYING) {
                        for (i in sArr.indices) {
                            val angle = sampleIndex * 2.0 * Math.PI * 20000.0 / sampleRate
                            sArr[i] = (32767.0 * Math.cos(angle)).toInt().toShort()
                            sampleIndex++
                        }
                        val written = track.write(sArr, 0, sArr.size)
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
