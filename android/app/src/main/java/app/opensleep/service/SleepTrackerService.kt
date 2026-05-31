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
import app.opensleep.MainActivity
import app.opensleep.R
import app.opensleep.data.local.SleepDatabase
import app.opensleep.data.repository.SleepRepository
import app.opensleep.domain.SleepStageAnalyzer
import kotlinx.coroutines.*

class SleepTrackerService : Service(), SensorEventListener {

    companion object {
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
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val pm = getSystemService(POWER_SERVICE) as PowerManager
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "opensleep::tracking")
        repository = SleepRepository(SleepDatabase.getInstance(applicationContext).sleepSessionDao())
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_START -> {
                sessionId = intent.getStringExtra(EXTRA_SESSION_ID)
                startTracking()
            }
            ACTION_STOP -> stopTracking()
        }
        return START_NOT_STICKY
    }

    private fun startTracking() {
        if (!wakeLock.isHeld) wakeLock.acquire(12 * 60 * 60 * 1000L) // 12h max
        startForeground(NOTIFICATION_ID, buildNotification())

        val accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val gyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        accel?.let { sensorManager.registerListener(this, it, SENSOR_DELAY_US) }
        gyro?.let { sensorManager.registerListener(this, it, SENSOR_DELAY_US) }

        // Periodically flush stages to DB every 5 minutes
        serviceScope.launch {
            val sid = sessionId ?: return@launch
            val startTime = System.currentTimeMillis()
            while (isActive) {
                delay(5 * 60 * 1000L)
                val stages = analyzer.computeStages(startTime)
                repository.updateStages(sid, stages)
            }
        }
    }

    private fun stopTracking() {
        sensorManager.unregisterListener(this)
        serviceScope.launch {
            val sid = sessionId ?: repository.getActiveSessionOneShot()?.id
            if (sid != null) {
                val startTime = repository.getSessionById(sid)?.startTimeMs ?: System.currentTimeMillis()
                val stages = analyzer.computeStages(startTime)
                repository.endSession(sid, stages)
            }
        }
        if (wakeLock.isHeld) wakeLock.release()
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()
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
