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
import android.os.SystemClock
import android.util.Log
import androidx.core.content.ContextCompat
import app.opensleep.MainActivity
import app.opensleep.R
import app.opensleep.data.local.SleepDatabase
import app.opensleep.data.repository.SleepRepository
import app.opensleep.domain.SleepStageAnalyzer
import app.opensleep.domain.sonar.ChirpProducer
import app.opensleep.domain.sonar.DiffSonarConsumer
import app.opensleep.domain.sonar.LowLevelActivityAggregator
import app.opensleep.domain.sonar.AwakeWhenUsingPhoneDetector
import kotlinx.coroutines.*

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
        private const val AUDIO_SAMPLE_RATE = 48_000

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

    private lateinit var phoneAwakeDetector: AwakeWhenUsingPhoneDetector
    private val chirpProducer = ChirpProducer(AUDIO_SAMPLE_RATE)
    private var watcherJob: Job? = null

    private val screenReceiver = object : android.content.BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.action) {
                Intent.ACTION_SCREEN_ON -> phoneAwakeDetector.onScreenOn()
                Intent.ACTION_SCREEN_OFF -> phoneAwakeDetector.onScreenOff()
            }
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
        
        phoneAwakeDetector = AwakeWhenUsingPhoneDetector(sensorManager)
        if (pm.isInteractive) {
            phoneAwakeDetector.onScreenOn()
        } else {
            phoneAwakeDetector.onScreenOff()
        }
        val filter = android.content.IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_ON)
            addAction(Intent.ACTION_SCREEN_OFF)
        }
        registerReceiver(screenReceiver, filter)
        
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

        // Register wake-up accelerometer and gyroscope with 10-second hardware batching latency to prevent background suspend.
        val accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER, true)
            ?: sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE, true)
            ?: sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        
        val maxReportLatencyUs = 10_000_000 // 10 seconds report latency
        accel?.let { sensorManager.registerListener(this, it, SENSOR_DELAY_US, maxReportLatencyUs) }
        gyro?.let { sensorManager.registerListener(this, it, SENSOR_DELAY_US, maxReportLatencyUs) }
        Log.d(TAG, "Sensor listeners registered (wake-up and hardware batched).")
        startAudioMonitoring()

        // 30-second awake watcher timer
        watcherJob?.cancel()
        watcherJob = serviceScope.launch {
            while (isActive) {
                delay(30000L)
                if (phoneAwakeDetector.isAwake()) {
                    val now = System.currentTimeMillis()
                    analyzer.addAwakeInterval(now - 30000L, now)
                    Log.d(TAG, "Phone awake detected; added awake interval.")
                }
            }
        }

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
        watcherJob?.cancel()
        watcherJob = null
        phoneAwakeDetector.stop()
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
        val timestampMs = eventWallClockMs(event)
        when (event.sensor.type) {
            Sensor.TYPE_ACCELEROMETER -> {
                analyzer.addSample(
                    timestampMs,
                    event.values[0], event.values[1], event.values[2]
                )
            }
            Sensor.TYPE_GYROSCOPE -> {
                analyzer.addGyroSample(
                    timestampMs,
                    event.values[0], event.values[1], event.values[2]
                )
            }
        }
    }

    private fun eventWallClockMs(event: SensorEvent): Long {
        val ageMs = (SystemClock.elapsedRealtimeNanos() - event.timestamp) / 1_000_000L
        return System.currentTimeMillis() - ageMs.coerceAtLeast(0L)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onDestroy() {
        Log.d(TAG, "onDestroy() called. Setting isRunning to false.")
        isRunning = false
        sensorManager.unregisterListener(this)
        watcherJob?.cancel()
        watcherJob = null
        phoneAwakeDetector.stop()
        runCatching { unregisterReceiver(screenReceiver) }
        stopAudioMonitoring()
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

        val bufferSize = Math.max(minBuffer, 8192)
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

        val diffSonar = DiffSonarConsumer(AUDIO_SAMPLE_RATE)
        val aggregator = LowLevelActivityAggregator(AUDIO_SAMPLE_RATE)

        audioRecord = recorder
        chirpProducer.play()

        audioJob?.cancel()
        audioJob = serviceScope.launch {
            val readBuffer = ShortArray(2048)
            var lastSonarSampleTime = System.currentTimeMillis()

            try {
                recorder.startRecording()
                while (isActive) {
                    val read = recorder.read(readBuffer, 0, readBuffer.size)
                    if (read > 0) {
                        val floatArr = FloatArray(read) { readBuffer[it] / 32767.0f }
                        val consumerRes = diffSonar.processAndGetResult(floatArr)
                        aggregator.update(consumerRes.activity)

                        val now = System.currentTimeMillis()
                        if (now - lastSonarSampleTime >= 10000) {
                            val act = aggregator.getAggregatedActivity()
                            analyzer.addSonarSample(now, act)
                            lastSonarSampleTime = now
                        }
                    } else {
                        Log.w(TAG, "AudioRecord read error: $read. Retrying in 1s...")
                        delay(1000L)
                        if (recorder.recordingState != AudioRecord.RECORDSTATE_RECORDING) {
                            try {
                                recorder.startRecording()
                            } catch (e: Exception) {
                                Log.e(TAG, "Failed to restart recording: ${e.message}")
                            }
                        }
                    }
                    yield()
                }
            } catch (e: Exception) {
                Log.w(TAG, "Audio monitoring stopped: ${e.message}")
            } finally {
                runCatching { recorder.stop() }
                recorder.release()
                audioRecord = null
                chirpProducer.stop()
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
            chirpProducer.stop()
        }
    }
}
