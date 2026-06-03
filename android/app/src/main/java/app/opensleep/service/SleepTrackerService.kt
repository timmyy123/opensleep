package app.opensleep.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.IBinder
import android.os.PowerManager
import android.util.Log
import androidx.core.content.ContextCompat
import app.opensleep.MainActivity
import app.opensleep.R
import app.opensleep.data.local.SleepDatabase
import app.opensleep.data.repository.SleepRepository
import app.opensleep.domain.SleepStageAnalyzer
import kotlinx.coroutines.*
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.channels.FileChannel
import kotlin.math.log10
import kotlin.math.sqrt

class SleepTrackerService : Service(), SensorEventListener {

    companion object {
        private const val TAG = "SleepTrackerService"
        const val ACTION_START = "app.opensleep.START_TRACKING"
        const val ACTION_STOP = "app.opensleep.STOP_TRACKING"
        const val EXTRA_SESSION_ID = "session_id"
        private const val NOTIFICATION_ID = 1001
        private const val CHANNEL_ID = "sleep_tracking"
        // Sample at 4 Hz (250 ms delay)
        private const val SENSOR_DELAY_US = 250_000
        private const val AUDIO_SAMPLE_RATE = 16_000

        @Volatile
        var isRunning = false
            private set
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Uncaught exception in SleepTrackerService coroutine: ${throwable.message}", throwable)
    }
    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO + exceptionHandler)
    private lateinit var sensorManager: SensorManager
    private lateinit var wakeLock: PowerManager.WakeLock
    private val analyzer = SleepStageAnalyzer()
    private var sessionId: String? = null
    private lateinit var repository: SleepRepository
    private var flushJob: Job? = null
    private var audioJob: Job? = null
    private var audioRecord: AudioRecord? = null
    private var tflite: Interpreter? = null

    private fun mapIndexToEvent(index: Int): String? {
        return when (index) {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 -> "speech"
            13, 14, 15, 16, 17, 18 -> "laughter"
            23 -> "sigh"
            36 -> "breathing"
            38 -> "snoring"
            39 -> "gasp"
            41 -> "snort"
            42, 43 -> "cough"
            484 -> "rustle"
            497 -> "silence"
            else -> null
        }
    }

    private fun loadModelFile(): java.nio.MappedByteBuffer? {
        return try {
            val fileDescriptor = assets.openFd("yamnet.tflite")
            val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
            val fileChannel = inputStream.channel
            val startOffset = fileDescriptor.startOffset
            val declaredLength = fileDescriptor.declaredLength
            fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to map model file: ${e.message}", e)
            null
        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate() called.")
        isRunning = true
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val pm = getSystemService(POWER_SERVICE) as PowerManager
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "opensleep::tracking")
        repository = SleepRepository(SleepDatabase.getInstance(applicationContext).sleepSessionDao())
        createNotificationChannel()
    }

    private var isTracking = false

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val isSystemRestart = (flags and START_FLAG_REDELIVERY) != 0
        Log.d(TAG, "onStartCommand() intent Action: ${intent?.action}, flags: $flags, isSystemRestart: $isSystemRestart")
        when (intent?.action) {
            ACTION_START -> {
                sessionId = intent.getStringExtra(EXTRA_SESSION_ID)
                Log.d(TAG, "Starting tracking for session: $sessionId")
                startTracking(isSystemRestart)
            }
            ACTION_STOP -> {
                Log.d(TAG, "Stopping tracking command received.")
                stopTracking()
            }
        }
        return START_REDELIVER_INTENT
    }

    private fun startTracking(isSystemRestart: Boolean) {
        Log.d(TAG, "startTracking() entering. isTracking: $isTracking, isSystemRestart: $isSystemRestart")
        if (!isTracking) {
            analyzer.clear()
            isTracking = true
        }
        if (tflite == null) {
            val modelBuffer = loadModelFile()
            if (modelBuffer != null) {
                try {
                    tflite = Interpreter(modelBuffer)
                    Log.i(TAG, "YAMNet TFLite interpreter initialized successfully.")
                } catch (e: Exception) {
                    Log.e(TAG, "Failed to initialize YAMNet interpreter: ${e.message}", e)
                }
            }
        }
        if (!wakeLock.isHeld) {
            wakeLock.acquire(12 * 60 * 60 * 1000L) // 12h max
            Log.d(TAG, "WakeLock acquired.")
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            val foregroundTypes =
                android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC or
                android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_HEALTH or
                if (
                    ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_MICROPHONE
                } else {
                    0
                }
            startForeground(
                NOTIFICATION_ID,
                buildNotification(),
                foregroundTypes
            )
        } else {
            startForeground(NOTIFICATION_ID, buildNotification())
        }

        val accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        accel?.let { sensorManager.registerListener(this, it, SENSOR_DELAY_US) }
        gyro?.let { sensorManager.registerListener(this, it, SENSOR_DELAY_US) }
        Log.d(TAG, "Sensor listeners registered.")
        startAudioMonitoring()

        // Periodically flush stages to DB every 5 minutes
        flushJob?.cancel()
        flushJob = serviceScope.launch {
            val sid = sessionId ?: return@launch
            val startTime = repository.getSessionById(sid)?.startTimeMs ?: System.currentTimeMillis()
            while (isActive) {
                delay(5 * 60 * 1000L)
                Log.d(TAG, "Performing periodic 5-minute database flush...")
                val stages = analyzer.computeStages(startTime)
                repository.updateStages(sid, stages)
                Log.d(TAG, "Periodic database flush complete.")
            }
        }
    }

    private fun stopTracking() {
        Log.d(TAG, "stopTracking() called. isTracking: $isTracking. Unregistering sensor listener...")
        if (!isTracking) {
            Log.d(TAG, "Service was not actively tracking. Skipping redundant stop.")
            return
        }
        isTracking = false
        sensorManager.unregisterListener(this)
        flushJob?.cancel()
        stopAudioMonitoring()
        
        Log.d(TAG, "Showing user-noticeable syncing notification...")
        updateNotificationToSyncing()

        serviceScope.launch {
            try {
                Log.d(TAG, "Coroutine started. Resolving session ID...")
                val sid = sessionId ?: repository.getActiveSessionOneShot()?.id
                Log.d(TAG, "Resolved session ID: $sid")
                if (sid != null) {
                    val session = repository.getSessionById(sid)
                    Log.d(TAG, "Retrieved session from database: $session")
                    if (session != null) {
                        val startTime = session.startTimeMs
                        Log.d(TAG, "Computing stages for session starting at $startTime...")
                        val stages = analyzer.computeStages(startTime)
                        Log.d(TAG, "Computed stages: ${stages.size} stages found.")
                        
                        Log.d(TAG, "Ending session in repository...")
                        repository.endSession(sid, stages)
                        Log.d(TAG, "Session ended in repository.")
                        
                        Log.d(TAG, "Initializing HealthSyncManager for sync...")
                        val healthSync = app.opensleep.domain.HealthSyncManager(applicationContext)
                        val isAvailable = healthSync.isAvailable()
                        val hasPermissions = healthSync.hasPermissions()
                        Log.d(TAG, "HealthSyncManager availability: $isAvailable, permissions: $hasPermissions")
                        
                        if (isAvailable && hasPermissions) {
                            val updatedSession = repository.getSessionById(sid)
                            Log.d(TAG, "Retrieved updated session for Health Connect: $updatedSession")
                            if (updatedSession != null) {
                                Log.d(TAG, "Writing sleep session to Health Connect...")
                                val success = healthSync.writeSleepSession(updatedSession)
                                Log.d(TAG, "Health Connect write result: $success")
                                if (success) {
                                    repository.markSynced(sid)
                                    Log.d(TAG, "Session marked as synced in repository.")
                                }
                            }
                        } else {
                            Log.d(TAG, "Skipping Health Connect sync because Health Connect is not available or permissions are missing.")
                        }
                    } else {
                        Log.w(TAG, "No session found in database for session ID: $sid")
                    }
                } else {
                    Log.w(TAG, "Could not resolve active session ID to stop.")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error during sleep session finalization & sync: ${e.message}", e)
            } finally {
                // Add a small artificial delay of 1.5 seconds so the user can visually witness the "Syncing..." status
                Log.d(TAG, "Finalizing service stop tracking...")
                delay(1500L)
                withContext(Dispatchers.Main) {
                    Log.d(TAG, "Terminating foreground service...")
                    if (wakeLock.isHeld) wakeLock.release()
                    stopForeground(STOP_FOREGROUND_REMOVE)
                    stopSelf()
                    Log.d(TAG, "Service stopped.")
                }
            }
        }
    }

    private fun updateNotificationToSyncing() {
        Log.d(TAG, "updateNotificationToSyncing() executing.")
        val tapIntent = Intent(this, MainActivity::class.java)
        val tapPending = PendingIntent.getActivity(
            this, 0, tapIntent, PendingIntent.FLAG_IMMUTABLE
        )
        val notification = Notification.Builder(this, CHANNEL_ID)
            .setContentTitle(getString(R.string.notification_syncing_title))
            .setContentText(getString(R.string.notification_syncing_text))
            .setSmallIcon(android.R.drawable.stat_notify_sync)
            .setContentIntent(tapPending)
            .setOngoing(true)
            .build()
        
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, notification)
        Log.d(TAG, "updateNotificationToSyncing() finished and posted notification.")
    }

    override fun onSensorChanged(event: SensorEvent) {
        when (event.sensor.type) {
            Sensor.TYPE_ACCELEROMETER -> {
                analyzer.addSample(
                    System.currentTimeMillis(),
                    event.values[0], event.values[1], event.values[2]
                )
            }
            Sensor.TYPE_GYROSCOPE -> {
                analyzer.addGyroSample(
                    System.currentTimeMillis(),
                    event.values[0], event.values[1], event.values[2]
                )
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onDestroy() {
        Log.d(TAG, "onDestroy() called. Setting isRunning to false.")
        isRunning = false
        sensorManager.unregisterListener(this)
        stopAudioMonitoring()
        tflite?.close()
        tflite = null
        serviceScope.cancel()
        if (wakeLock.isHeld) wakeLock.release()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            getString(R.string.notification_channel_name),
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = getString(R.string.notification_channel_desc)
            setShowBadge(false)
        }
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
    }

    private fun buildNotification(): Notification {
        val tapIntent = Intent(this, MainActivity::class.java)
        val tapPending = PendingIntent.getActivity(
            this, 0, tapIntent, PendingIntent.FLAG_IMMUTABLE
        )
        val stopIntent = Intent(this, SleepTrackerService::class.java).apply {
            action = ACTION_STOP
        }
        val stopPending = PendingIntent.getService(
            this, 1, stopIntent, PendingIntent.FLAG_IMMUTABLE
        )

        return Notification.Builder(this, CHANNEL_ID)
            .setContentTitle(getString(R.string.notification_tracking_title))
            .setContentText(getString(R.string.notification_tracking_text))
            .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
            .setContentIntent(tapPending)
            .setOngoing(true)
            .addAction(
                Notification.Action.Builder(
                    null,
                    getString(R.string.stop_sleep),
                    stopPending
                ).build()
            )
            .build()
    }

    @Suppress("MissingPermission")
    private fun startAudioMonitoring() {
        if (
            ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            Log.w(TAG, "Audio monitoring skipped; RECORD_AUDIO permission is missing.")
            return
        }

        val minBuffer = AudioRecord.getMinBufferSize(
            AUDIO_SAMPLE_RATE,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )
        if (minBuffer <= 0) {
            Log.w(TAG, "Audio monitoring skipped; invalid minimum buffer size: $minBuffer")
            return
        }

        val bufferSize = minBuffer * 2
        val recorder = AudioRecord(
            MediaRecorder.AudioSource.UNPROCESSED,
            AUDIO_SAMPLE_RATE,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize
        ).takeIf { it.state == AudioRecord.STATE_INITIALIZED } ?: AudioRecord(
            MediaRecorder.AudioSource.MIC,
            AUDIO_SAMPLE_RATE,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize
        )

        if (recorder.state != AudioRecord.STATE_INITIALIZED) {
            recorder.release()
            Log.w(TAG, "Audio monitoring skipped; AudioRecord failed to initialize.")
            return
        }

        audioRecord = recorder
        audioJob?.cancel()
        audioJob = serviceScope.launch {
            val readBuffer = ShortArray(1024)
            val yamnetInputSize = 15600
            val audioWindow = FloatArray(yamnetInputSize)
            
            var dbfsSum = 0.0
            var dbfsCount = 0
            var windowClipped = false
            var samplesForDbfs = 0
            var samplesSinceLastInference = 0

            try {
                recorder.startRecording()
                while (isActive) {
                    val read = recorder.read(readBuffer, 0, readBuffer.size)
                    if (read > 0) {
                        // 1. Calculate short-term RMS for DBFS fallback
                        var sumSquares = 0.0
                        var blockClipped = false
                        for (i in 0 until read) {
                            val sample = readBuffer[i].toDouble()
                            sumSquares += sample * sample
                            blockClipped = blockClipped || kotlin.math.abs(readBuffer[i].toInt()) > 32_000
                        }
                        val rms = sqrt(sumSquares / read) / Short.MAX_VALUE.toDouble()
                        val dbfs = (20.0 * log10(rms.coerceAtLeast(0.000_001))).toFloat()
                        
                        dbfsSum += dbfs
                        dbfsCount++
                        windowClipped = windowClipped || blockClipped
                        
                        // 2. Slide new samples into audioWindow
                        if (read < yamnetInputSize) {
                            System.arraycopy(audioWindow, read, audioWindow, 0, yamnetInputSize - read)
                            for (i in 0 until read) {
                                audioWindow[yamnetInputSize - read + i] = readBuffer[i] / 32768.0f
                            }
                        } else {
                            for (i in 0 until yamnetInputSize) {
                                audioWindow[i] = readBuffer[read - yamnetInputSize + i] / 32768.0f
                            }
                        }
                        
                        samplesForDbfs += read
                        samplesSinceLastInference += read
                        
                        // Call addAudioLevel every 4 seconds (64,000 samples at 16kHz)
                        if (samplesForDbfs >= AUDIO_SAMPLE_RATE * 4) {
                            val avgDbfs = if (dbfsCount > 0) (dbfsSum / dbfsCount).toFloat() else -65f
                            analyzer.addAudioLevel(System.currentTimeMillis(), avgDbfs, windowClipped)
                            dbfsSum = 0.0
                            dbfsCount = 0
                            windowClipped = false
                            samplesForDbfs = 0
                        }
                        
                        // Run YAMNet inference every 1 second (16,000 samples)
                        if (samplesSinceLastInference >= AUDIO_SAMPLE_RATE) {
                            samplesSinceLastInference = 0
                            
                            tflite?.let { interpreter ->
                                val output = Array(1) { FloatArray(521) }
                                interpreter.run(audioWindow, output)
                                
                                val scores = output[0]
                                var maxVal = -1f
                                var maxIdx = -1
                                for (i in scores.indices) {
                                    if (scores[i] > maxVal) {
                                        maxVal = scores[i]
                                        maxIdx = i
                                    }
                                }
                                if (maxIdx != -1 && maxVal > 0.15f) {
                                    val eventName = mapIndexToEvent(maxIdx)
                                    if (eventName != null) {
                                        analyzer.addAudioEvent(System.currentTimeMillis(), eventName, maxVal)
                                    }
                                }
                            }
                        }
                    } else if (read == AudioRecord.ERROR_INVALID_OPERATION || read == AudioRecord.ERROR_BAD_VALUE) {
                        Log.e(TAG, "Error reading AudioRecord data: $read")
                        break
                    }
                    yield()
                }
            } catch (e: Exception) {
                Log.w(TAG, "Audio monitoring stopped: ${e.message}")
            } finally {
                runCatching { recorder.stop() }
                recorder.release()
                audioRecord = null
            }
        }
    }

    private fun stopAudioMonitoring() {
        val job = audioJob
        audioJob = null
        val rec = audioRecord
        audioRecord = null
        
        serviceScope.launch {
            job?.cancel()
            runCatching { rec?.stop() }
        }
    }
}
