package app.opensleep.domain.sonar

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class AwakeWhenUsingPhoneDetector(private val sensorManager: SensorManager) : SensorEventListener {
    private val accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    private var axisThresholdGuard: AxisThresholdGuard? = null
    
    @Volatile private var ts: Long = -1L
    @Volatile private var awakeOrientation = true
    @Volatile private var awakeAcceleration = false
    
    fun onScreenOn() {
        ts = System.currentTimeMillis()
        accelSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
        // sensitivity >= 2 (medium) threshold is 0.075f.
        axisThresholdGuard = AxisThresholdGuard(100, 0.075f)
    }
    
    fun onScreenOff() {
        ts = -1L
        stopSensor()
        axisThresholdGuard = null
    }
    
    private fun stopSensor() {
        accelSensor?.let {
            sensorManager.unregisterListener(this, it)
        }
        awakeOrientation = false
        awakeAcceleration = false
    }
    
    fun isScreenOn(): Boolean {
        return ts != -1L
    }
    
    fun isAwake(): Boolean {
        // Sleep as Android's sensitivity 3 branch:
        // isScreenOn && (awakeOrientation || sensitivity >= 3) && (awakeAcceleration || sensitivity >= 2)
        // -> screen-on is enough, even if the phone is lying flat.
        val sensitivity = 3
        val orientOk = awakeOrientation || (sensitivity >= 3)
        val accelOk = awakeAcceleration || (sensitivity >= 2)
        return isScreenOn() && orientOk && accelOk
    }
    
    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return
        val guard = axisThresholdGuard
        if (guard != null) {
            guard.update(event)
            awakeAcceleration = guard.overThreshold()
        }
        val zVal = event.values[2]
        val currentOrient = awakeOrientation
        if (!currentOrient) {
            if (zVal > -8.8f && zVal < 8.8f) {
                awakeOrientation = true
                return
            }
        } else {
            if (zVal < -8.8f || zVal > 8.8f) {
                awakeOrientation = false
            }
        }
    }
    
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    
    fun stop() {
        stopSensor()
    }
}
