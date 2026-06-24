package app.opensleep.domain.sonar

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.core.content.ContextCompat

class AwakeWhenHighActivity(private val context: Context) {
    private val classifiers = mutableMapOf<String, AverageActivityOverThreshold>()
    private var lastAwakeDetected = 0L

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            if (intent == null) return
            val sensorType = intent.getStringExtra("action_raw_activity_sensor") ?: return
            val value = intent.getFloatExtra("action_raw_activity_data", 0f)

            // Ignore non-accelerometer/watch sensors (such as SONAR) to prevent noise from triggering false awake intervals
            if (sensorType != "PHONE_ACCEL" && sensorType != "SMARTWATCH" && sensorType != "BLE_ACCEL") {
                return
            }

            val classifier = classifiers.getOrPut(sensorType) {
                val threshold = if (sensorType == "SMARTWATCH" || sensorType == "BLE_ACCEL") {
                    2.5f
                } else {
                    1.5f
                }
                AverageActivityOverThreshold(threshold)
            }

            if (classifier.update(value)) {
                lastAwakeDetected = System.currentTimeMillis()
            }
        }
    }

    init {
        ContextCompat.registerReceiver(
            context,
            receiver,
            IntentFilter("action_raw_activity"),
            ContextCompat.RECEIVER_NOT_EXPORTED
        )
    }

    fun isAwake(): Boolean {
        return System.currentTimeMillis() - lastAwakeDetected < 60000
    }

    fun stop() {
        context.unregisterReceiver(receiver)
        classifiers.clear()
        lastAwakeDetected = 0L
    }
}
