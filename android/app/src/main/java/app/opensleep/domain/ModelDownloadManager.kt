package app.opensleep.domain

import android.content.Context
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.io.File
import java.io.RandomAccessFile
import java.net.HttpURLConnection
import java.net.URL

enum class ModelVariant(
    val displayName: String,
    val fileName: String,
    val sizeGB: Float,
    val downloadUrl: String
) {
    E2B(
        displayName = "Gemma 4 E2B (~2.41 GB)",
        fileName = "gemma-4-E2B-it.litertlm",
        sizeGB = 2.41f,
        downloadUrl = "https://huggingface.co/litert-community/gemma-4-E2B-it-litert-lm/resolve/a4a831c060880f3733135ad22f10e0e9f758f45d/gemma-4-E2B-it.litertlm"
    ),
    E4B(
        displayName = "Gemma 4 E4B (~3.41 GB)",
        fileName = "gemma-4-E4B-it.litertlm",
        sizeGB = 3.41f,
        downloadUrl = "https://huggingface.co/litert-community/gemma-4-E4B-it-litert-lm/resolve/65ce5ba80d8790d66ef11d82d7d079a06f3fef97/gemma-4-E4B-it.litertlm"
    )
}

data class DownloadStatus(
    val state: State,
    val progress: Float = 0f,
    val downloadedBytes: Long = 0L,
    val totalBytes: Long = 0L,
    val speedBytesPerSec: Double = 0.0
) {
    enum class State { IDLE, DOWNLOADING, PAUSED, DONE, FAILED }
}

class ModelDownloadManager(private val context: Context) {

    private val modelsDir: File
        get() = context.getExternalFilesDir(null) ?: context.filesDir

    private val sharedPrefs = context.getSharedPreferences("opensleep_settings", Context.MODE_PRIVATE)

    private val _activeVariant = MutableStateFlow<ModelVariant?>(
        sharedPrefs.getString("active_model_variant", null)?.let { name ->
            ModelVariant.entries.find { it.name == name }
        }
    )
    val activeVariant = _activeVariant.asStateFlow()

    fun setActiveVariant(variant: ModelVariant?) {
        if (variant != null) {
            sharedPrefs.edit().putString("active_model_variant", variant.name).apply()
        } else {
            sharedPrefs.edit().remove("active_model_variant").apply()
        }
        _activeVariant.value = variant
    }

    private val _useGpu = MutableStateFlow(
        sharedPrefs.getBoolean("use_gpu_in_chat", true)
    )
    val useGpu = _useGpu.asStateFlow()

    fun setUseGpu(value: Boolean) {
        sharedPrefs.edit().putBoolean("use_gpu_in_chat", value).apply()
        _useGpu.value = value
    }

    private val _contextWindowSizes = MutableStateFlow<Map<ModelVariant, Int>>(
        ModelVariant.entries.associateWith { variant ->
            sharedPrefs.getInt("context_window_size_${variant.name}", 4096)
        }
    )
    val contextWindowSizes = _contextWindowSizes.asStateFlow()

    fun setContextWindowSize(variant: ModelVariant, size: Int) {
        sharedPrefs.edit().putInt("context_window_size_${variant.name}", size).apply()
        _contextWindowSizes.value = _contextWindowSizes.value.toMutableMap().apply {
            put(variant, size)
        }
    }

    private val _downloadStatus = MutableStateFlow<Map<ModelVariant, DownloadStatus>>(
        ModelVariant.entries.associateWith {
            DownloadStatus(if (isModelDownloaded(it)) DownloadStatus.State.DONE else DownloadStatus.State.IDLE)
        }
    )
    val downloadStatus = _downloadStatus.asStateFlow()

    private val downloadJobs = mutableMapOf<ModelVariant, Job>()
    private val downloadScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    fun isModelDownloaded(variant: ModelVariant): Boolean =
        File(modelsDir, variant.fileName).exists()

    fun getModelPath(variant: ModelVariant): String =
        File(modelsDir, variant.fileName).absolutePath

    @Synchronized
    fun downloadModel(variant: ModelVariant) {
        val currentStatus = _downloadStatus.value[variant] ?: DownloadStatus(DownloadStatus.State.IDLE)
        if (currentStatus.state == DownloadStatus.State.DOWNLOADING || currentStatus.state == DownloadStatus.State.DONE) return

        val job = downloadScope.launch {
            val destFile = File(modelsDir, variant.fileName)
            val tmpFile = File(modelsDir, "${variant.fileName}.tmp")

            if (destFile.exists()) {
                updateStatus(variant, DownloadStatus(DownloadStatus.State.DONE, 1.0f))
                return@launch
            }

            var downloadedBytes = if (tmpFile.exists()) tmpFile.length() else 0L
            var totalBytes = currentStatus.totalBytes

            updateStatus(variant, DownloadStatus(
                state = DownloadStatus.State.DOWNLOADING,
                progress = if (totalBytes > 0) downloadedBytes.toFloat() / totalBytes else 0f,
                downloadedBytes = downloadedBytes,
                totalBytes = totalBytes
            ))

            var connection: HttpURLConnection? = null
            try {
                val url = URL(variant.downloadUrl)
                connection = url.openConnection() as HttpURLConnection
                connection.connectTimeout = 15000
                connection.readTimeout = 15000

                if (downloadedBytes > 0) {
                    connection.setRequestProperty("Range", "bytes=$downloadedBytes-")
                }

                connection.connect()

                val responseCode = connection.responseCode
                val isResumed = responseCode == HttpURLConnection.HTTP_PARTIAL

                if (!isResumed) {
                    downloadedBytes = 0L
                    tmpFile.delete()
                }

                if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_PARTIAL) {
                    val contentLength = connection.contentLengthLong
                    if (!isResumed) {
                        totalBytes = contentLength
                    } else if (totalBytes <= 0L) {
                        totalBytes = downloadedBytes + contentLength
                    }

                    val inputStream = connection.inputStream
                    val randomAccessFile = RandomAccessFile(tmpFile, "rw")
                    randomAccessFile.seek(downloadedBytes)

                    val buffer = ByteArray(64 * 1024)
                    var bytesRead: Int
                    var bytesReadInWindow = 0L
                    var lastUpdateTime = System.currentTimeMillis()

                    while (isActive) {
                        bytesRead = inputStream.read(buffer)
                        if (bytesRead == -1) break

                        randomAccessFile.write(buffer, 0, bytesRead)
                        downloadedBytes += bytesRead
                        bytesReadInWindow += bytesRead

                        val now = System.currentTimeMillis()
                        val elapsed = now - lastUpdateTime
                        if (elapsed >= 500) {
                            val speed = if (elapsed > 0) (bytesReadInWindow.toDouble() / elapsed) * 1000.0 else 0.0
                            val progress = if (totalBytes > 0) downloadedBytes.toFloat() / totalBytes else 0f

                            updateStatus(variant, DownloadStatus(
                                state = DownloadStatus.State.DOWNLOADING,
                                progress = progress,
                                downloadedBytes = downloadedBytes,
                                totalBytes = totalBytes,
                                speedBytesPerSec = speed
                            ))

                            bytesReadInWindow = 0L
                            lastUpdateTime = now
                        }
                    }

                    randomAccessFile.close()
                    inputStream.close()

                    if (isActive) {
                        tmpFile.renameTo(destFile)
                        updateStatus(variant, DownloadStatus(DownloadStatus.State.DONE, 1.0f, totalBytes, totalBytes))
                    } else {
                        updateStatus(variant, DownloadStatus(
                            state = DownloadStatus.State.PAUSED,
                            progress = if (totalBytes > 0) downloadedBytes.toFloat() / totalBytes else 0f,
                            downloadedBytes = downloadedBytes,
                            totalBytes = totalBytes
                        ))
                    }
                } else {
                    updateStatus(variant, DownloadStatus(
                        state = DownloadStatus.State.FAILED,
                        downloadedBytes = downloadedBytes,
                        totalBytes = totalBytes
                    ))
                }
            } catch (e: Exception) {
                if (isActive) {
                    updateStatus(variant, DownloadStatus(
                        state = DownloadStatus.State.FAILED,
                        downloadedBytes = downloadedBytes,
                        totalBytes = totalBytes
                    ))
                }
            } finally {
                connection?.disconnect()
            }
        }

        downloadJobs[variant] = job
    }

    @Synchronized
    fun pauseModelDownload(variant: ModelVariant) {
        val job = downloadJobs[variant]
        if (job != null && job.isActive) {
            job.cancel()
        }
        val current = _downloadStatus.value[variant]
        if (current != null && current.state == DownloadStatus.State.DOWNLOADING) {
            updateStatus(variant, current.copy(state = DownloadStatus.State.PAUSED, speedBytesPerSec = 0.0))
        }
    }

    @Synchronized
    fun cancelModelDownload(variant: ModelVariant) {
        val job = downloadJobs[variant]
        job?.cancel()
        downloadJobs.remove(variant)

        File(modelsDir, "${variant.fileName}.tmp").delete()
        File(modelsDir, variant.fileName).delete()

        updateStatus(variant, DownloadStatus(DownloadStatus.State.IDLE))
    }

    fun deleteModel(variant: ModelVariant) {
        cancelModelDownload(variant)
    }

    private fun updateStatus(variant: ModelVariant, status: DownloadStatus) {
        _downloadStatus.value = _downloadStatus.value.toMutableMap().apply {
            put(variant, status)
        }
    }
}
