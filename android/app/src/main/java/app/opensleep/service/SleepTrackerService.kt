package app.opensleep.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.IBinder
import android.os.PowerManager
import android.util.Log
import app.opensleep.MainActivity
import app.opensleep.R
import app.opensleep.data.local.SleepDatabase
import app.opensleep.data.repository.SleepRepository
import app.opensleep.domain.SleepStageAnalyzer
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
    }

    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private lateinit var sensorManager: SensorManager
    private lateinit var wakeLock: PowerManager.WakeLock
    private val analyzer = SleepStageAnalyzer()
    private var sessionId: String? = null
    private lateinit var repository: SleepRepository

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate() called.")
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val pm = getSystemService(POWER_SERVICE) as PowerManager
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "opensleep::tracking")
        repository = SleepRepository(SleepDatabase.getInstance(applicationContext).sleepSessionDao())
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand() intent Action: ${intent?.action}")
        when (intent?.action) {
            ACTION_START -> {
                sessionId = intent.getStringExtra(EXTRA_SESSION_ID)
                Log.d(TAG, "Starting tracking for session: $sessionId")
                startTracking()
            }
            ACTION_STOP -> {
                Log.d(TAG, "Stopping tracking command received.")
                stopTracking()
            }
        }
        return START_NOT_STICKY
    }

    private fun startTracking() {
        Log.d(TAG, "startTracking() entering.")
        if (!wakeLock.isHeld) {
            wakeLock.acquire(12 * 60 * 60 * 1000L) // 12h max
            Log.d(TAG, "WakeLock acquired.")
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            startForeground(
                NOTIFICATION_ID,
                buildNotification(),
                android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC or
                android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_HEALTH
            )
        } else {
            startForeground(NOTIFICATION_ID, buildNotification())
        }

        val accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        accel?.let { sensorManager.registerListener(this, it, SENSOR_DELAY_US) }
        gyro?.let { sensorManager.registerListener(this, it, SENSOR_DELAY_US) }
        Log.d(TAG, "Sensor listeners registered.")

        // Periodically flush stages to DB every 5 minutes
        serviceScope.launch {
            val sid = sessionId ?: return@launch
            val startTime = System.currentTimeMillis()
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
        Log.d(TAG, "stopTracking() called. Unregistering sensor listener...")
        sensorManager.unregisterListener(this)
        
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
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            analyzer.addSample(
                System.currentTimeMillis(),
                event.values[0], event.values[1], event.values[2]
            )
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    override fun onDestroy() {
        sensorManager.unregisterListener(this)
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
}
