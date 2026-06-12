package app.opensleep.domain.sonar

import android.hardware.SensorEvent
import kotlin.math.abs

class AxisData(val x: Float, val y: Float, val z: Float) {
    constructor(event: SensorEvent) : this(event.values[0], event.values[1], event.values[2])
    
    fun getDiff(other: AxisData): Float {
        return abs(z - other.z) + abs(y - other.y) + abs(x - other.x)
    }
}

class AxisThresholdGuard(val window: Int, val threshold: Float) {
    private var lastData: AxisData? = null
    private val list = mutableListOf<Float>()

    fun getAvg(): Float {
        if (list.isEmpty()) return 0f
        return list.average().toFloat()
    }

    fun overThreshold(): Boolean {
        return getAvg() > threshold
    }

    @Synchronized
    fun update(event: SensorEvent) {
        val currentData = AxisData(event)
        val previous = lastData
        if (previous != null) {
            list.add(previous.getDiff(currentData))
            if (list.size > window) {
                list.removeAt(0)
            }
        }
        lastData = currentData
    }
}
