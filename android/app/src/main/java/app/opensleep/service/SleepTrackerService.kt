package app.opensleep.service

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import android.os.Build
import android.os.IBinder
import android.os.PowerManager
import android.os.SystemClock
import android.util.Log
import androidx.core.content.ContextCompat
import app.opensleep.MainActivity
import app.opensleep.R
import app.opensleep.data.local.SleepDatabase
import app.opensleep.data.repository.SleepRepository
import app.opensleep.domain.SleepStageAnalyzer
import app.opensleep.domain.TrackingSensorMode
import app.opensleep.domain.sonar.ChirpProducer
import app.opensleep.domain.sonar.FftSonarConsumer
import app.opensleep.domain.sonar.LowLevelActivityAggregator
import kotlinx.coroutines.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Foreground Service for phone-only sleep tracking.
 * Supports both Sonar (contactless ultrasound) and Accelerometer (mattress actigraphy) modes.
 * Collects 10-second epoch activity, monitors wakefulness, and persists complete 4-phase sleep sessions.
 */
class SleepTrackerService : Service(), SensorEventListener {

    companion object {
        private const val TAG = "SleepTrackerService"
        const val ACTION_START = "app.opensleep.START_TRACKING"
        const val ACTION_STOP = "app.opensleep.STOP_TRACKING"
        const val EXTRA_SESSION_ID = "session_id"
        private const val NOTIFICATION_ID = 1001
        private const val CHANNEL_ID = "sleep_tracking"
        // Sample at ~20 Hz (50,000 us) to conserve battery while capturing peak motion
        private const val SENSOR_DELAY_US = 50_000

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
    private var saveScope: CoroutineScope? = null
    private var isSaving = false
    private var isTracking = false

    private var trackingMode: TrackingSensorMode = TrackingSensorMode.SONAR
    private var chirpProducer: ChirpProducer? = null
    private var audioRecord: AudioRecord? = null
    private var sonarJob: Job? = null
    private var sonarPollJob: Job? = null
    private var lowLevelActivityAggregator: LowLevelActivityAggregator? = null

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "SleepTrackerService.onCreate() called.")
        isRunning = true
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val pm = getSystemService(POWER_SERVICE) as PowerManager
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "opensleep::tracking")
        repository = SleepRepository(SleepDatabase.getInstance(applicationContext).sleepSessionDao())
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand action=${intent?.action}")
        when (intent?.action) {
            ACTION_START -> {
                sessionId = intent.getStringExtra(EXTRA_SESSION_ID)
                startTracking()
            }
            ACTION_STOP -> {
                stopTracking()
            }
        }
        return START_REDELIVER_INTENT
    }

    private fun startTracking() {
        if (!isTracking) {
            analyzer.clear()
            isTracking = true
        }

        if (!wakeLock.isHeld) {
            wakeLock.acquire(12 * 60 * 60 * 1000L) // 12h max
        }

        val sharedPrefs = getSharedPreferences("opensleep_settings", Context.MODE_PRIVATE)
        val modeKey = sharedPrefs.getString("tracking_sensor_mode", TrackingSensorMode.SONAR.key)
        trackingMode = TrackingSensorMode.fromKey(modeKey)
        Log.d(TAG, "Starting tracking with mode=$trackingMode")

        val hasMicPermission = ContextCompat.checkSelfPermission(
            this, Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            var foregroundTypes =
                android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC or
                android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_HEALTH
            if (trackingMode == TrackingSensorMode.SONAR && hasMicPermission) {
                foregroundTypes = foregroundTypes or android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_MICROPHONE
            }
            startForeground(NOTIFICATION_ID, buildNotification(), foregroundTypes)
        } else {
            startForeground(NOTIFICATION_ID, buildNotification())
        }

        if (trackingMode == TrackingSensorMode.SONAR && hasMicPermission) {
            startSonarTracking()
        } else {
            if (trackingMode == TrackingSensorMode.SONAR && !hasMicPermission) {
                Log.w(TAG, "Sonar requested but RECORD_AUDIO not granted. Falling back to Accelerometer.")
            }
            startAccelerometerTracking()
        }

        // Periodic flush of stages to DB every 30 seconds
        flushJob?.cancel()
        flushJob = serviceScope.launch {
            val sid = sessionId ?: return@launch
            val startTime = repository.getSessionById(sid)?.startTimeMs ?: System.currentTimeMillis()
            while (isActive) {
                delay(30 * 1000L)
                val stages = analyzer.computeStages(startTime)
                if (stages.isNotEmpty()) {
                    repository.updateStages(sid, stages)
                }
            }
        }
    }

    private fun startSonarTracking() {
        val sampleRate = 44100
        val bufferSizeSamples = 8192

        // 1. Start Ultrasound Chirp (18 kHz -> 22 kHz)
        val producer = ChirpProducer(sampleRate)
        chirpProducer = producer
        producer.play()

        // 2. Setup Sonar consumer & low-level aggregator
        val fftConsumer = FftSonarConsumer(sampleRate)
        val aggregator = LowLevelActivityAggregator(sampleRate)
        lowLevelActivityAggregator = aggregator

        // 3. Start AudioRecord loop
        val minBufSize = AudioRecord.getMinBufferSize(
            sampleRate,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )
        val recordBufSize = maxOf(minBufSize, bufferSizeSamples * 2 * 4)

        try {
            val record = AudioRecord(
                MediaRecorder.AudioSource.MIC,
                sampleRate,
                AudioFormat.CHANNEL_IN_MONO,
                AudioFormat.ENCODING_PCM_16BIT,
                recordBufSize
            )
            if (record.state != AudioRecord.STATE_INITIALIZED) {
                Log.e(TAG, "AudioRecord failed to initialize. Falling back to Accelerometer.")
                record.release()
                producer.stop()
                chirpProducer = null
                startAccelerometerTracking()
                return
            }

            audioRecord = record
            record.startRecording()

            sonarJob = serviceScope.launch(Dispatchers.IO) {
                val shortBuffer = ShortArray(bufferSizeSamples)
                val floatBuffer = FloatArray(bufferSizeSamples)

                while (isActive && isTracking && record.recordingState == AudioRecord.RECORDSTATE_RECORDING) {
                    var readTotal = 0
                    while (readTotal < bufferSizeSamples && isActive && isTracking) {
                        val read = record.read(shortBuffer, readTotal, bufferSizeSamples - readTotal)
                        if (read > 0) {
                            readTotal += read
                        } else if (read < 0) {
                            Log.e(TAG, "AudioRecord.read returned error: $read")
                            break
                        }
                    }

                    if (readTotal == bufferSizeSamples) {
                        for (i in 0 until bufferSizeSamples) {
                            floatBuffer[i] = shortBuffer[i] / 32768.0f
                        }
                        val result = fftConsumer.processAndGetResult(floatBuffer)
                        aggregator.update(result.activity)
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error starting Sonar AudioRecord: ${e.message}", e)
            producer.stop()
            chirpProducer = null
            startAccelerometerTracking()
            return
        }

        // 4. 10-second sonar epoch aggregator timer
        sonarPollJob = serviceScope.launch {
            while (isActive && isTracking) {
                delay(10_000L)
                val act = aggregator.getAggregatedActivity()
                analyzer.addSonarSample(System.currentTimeMillis(), act)
            }
        }

        // 5. Supplementary accelerometer for gross movements
        val accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER, true)
            ?: sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        accel?.let { sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL, 10_000_000) }
    }

    private fun startAccelerometerTracking() {
        val accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER, true)
            ?: sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val maxReportLatencyUs = 10_000_000 // 10s batching latency
        accel?.let { sensorManager.registerListener(this, it, SENSOR_DELAY_US, maxReportLatencyUs) }
    }

    private fun stopTracking() {
        if (!isTracking || isSaving) return
        isTracking = false
        isSaving = true

        // Stop sensors & sonar
        sensorManager.unregisterListener(this)
        sonarJob?.cancel()
        sonarJob = null
        sonarPollJob?.cancel()
        sonarPollJob = null
        try {
            audioRecord?.stop()
            audioRecord?.release()
        } catch (e: Exception) {
            Log.w(TAG, "Error releasing AudioRecord: ${e.message}")
        }
        audioRecord = null
        chirpProducer?.stop()
        chirpProducer = null
        lowLevelActivityAggregator = null

        flushJob?.cancel()

        updateNotificationToSyncing()

        val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO + exceptionHandler)
        saveScope = scope
        scope.launch {
            try {
                val sid = sessionId ?: repository.getActiveSessionOneShot()?.id
                if (sid != null) {
                    val session = repository.getSessionById(sid)
                    if (session != null) {
                        val stages = analyzer.computeStages(session.startTimeMs)
                        repository.endSession(sid, stages)

                        val healthSync = app.opensleep.domain.HealthSyncManager(applicationContext)
                        if (healthSync.isAvailable() && healthSync.hasPermissions()) {
                            val updated = repository.getSessionById(sid)
                            if (updated != null && healthSync.writeSleepSession(updated)) {
                                repository.markSynced(sid)
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "Error finalizing sleep session: ${e.message}", e)
            } finally {
                delay(1000L)
                isSaving = false
                withContext(Dispatchers.Main) {
                    if (wakeLock.isHeld) wakeLock.release()
                    stopForeground(STOP_FOREGROUND_REMOVE)
                    stopSelf()
                }
            }
        }
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            val timestampMs = eventWallClockMs(event)
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            analyzer.addSample(timestampMs, x, y, z)
        }
    }

    private fun eventWallClockMs(event: SensorEvent): Long {
        val ageMs = (SystemClock.elapsedRealtimeNanos() - event.timestamp) / 1_000_000L
        return System.currentTimeMillis() - ageMs.coerceAtLeast(0L)
    }


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onTaskRemoved(rootIntent: Intent?) {
        val sid = sessionId
        if (sid != null && isTracking) {
            try {
                val latch = CountDownLatch(1)
                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val session = repository.getSessionById(sid)
                        if (session != null) {
                            val stages = analyzer.computeStages(session.startTimeMs)
                            repository.endSession(sid, stages)
                        }
                    } finally {
                        latch.countDown()
                    }
                }
                latch.await(5, TimeUnit.SECONDS)
            } catch (e: Exception) {
                Log.e(TAG, "Emergency flush failed: ${e.message}", e)
            }
        }
        super.onTaskRemoved(rootIntent)
    }

    override fun onDestroy() {
        isRunning = false
        sensorManager.unregisterListener(this)
        sonarJob?.cancel()
        sonarPollJob?.cancel()
        try {
            audioRecord?.stop()
            audioRecord?.release()
        } catch (_: Exception) {}
        chirpProducer?.stop()
        serviceScope.cancel()
        if (!isSaving && wakeLock.isHeld) {
            wakeLock.release()
        }
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

    private fun updateNotificationToSyncing() {
        val tapIntent = Intent(this, MainActivity::class.java)
        val tapPending = PendingIntent.getActivity(
            this, 0, tapIntent, PendingIntent.FLAG_IMMUTABLE
        )
        val notification = Notification.Builder(this, CHANNEL_ID)
            .setContentTitle(getString(R.string.notification_syncing_title))
            .setContentText(getString(R.string.notification_syncing_text))
            .setSmallIcon(android.R.drawable.stat_notify_sync)
            .setContentIntent(tapPending)
            .build()
        getSystemService(NotificationManager::class.java).notify(NOTIFICATION_ID, notification)
    }
}
