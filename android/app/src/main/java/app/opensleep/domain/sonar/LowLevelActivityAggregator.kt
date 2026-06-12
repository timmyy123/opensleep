package app.opensleep.domain.sonar

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class LowLevelActivityAggregator(sampleRate: Int) {
    
    // Exact circular buffer matching Sleep as Android FloatRingBuffer
    private class FloatRingBuffer(val maxSize: Int) {
        init { require(maxSize > 0) }
        private val values = FloatArray(maxSize)
        private var size = 0
        private var lastIndex = -1

        fun add(f: Float) {
            lastIndex++
            if (lastIndex >= maxSize) lastIndex = 0
            values[lastIndex] = f
            if (size < maxSize) size++
        }
        fun first(): Float {
            check(size > 0)
            return get(0)
        }
        fun get(i: Int): Float {
            require(i in 0 until size) { "$i >= $size" }
            return values[(lastIndex - size + 1 + i + maxSize * 2) % maxSize]
        }
        fun size() = size
        fun isFull() = size == maxSize
        fun toArray(): FloatArray = FloatArray(size) { get(it) }
    }

    private class MovingMax(private val period: Int) {
        private val history = FloatRingBuffer(period)
        private val ordered = java.util.PriorityQueue<Float>(compareByDescending { it })

        fun apply(f: Float): Float {
            if (history.isFull()) {
                ordered.remove(history.first())
            }
            history.add(f)
            ordered.add(f)
            return ordered.peek() ?: f
        }
    }

    private class MovingQuantilePrecise(private val period: Int, private val quantile: Float) {
        private val history = FloatRingBuffer(period)

        fun apply(f: Float): Float {
            history.add(f)
            val arr = history.toArray().also { it.sort() }
            return percentile(arr, quantile * 100f)
        }

        private fun percentile(sorted: FloatArray, p: Float): Float {
            if (sorted.isEmpty()) return 0f
            if (sorted.size == 1) return sorted[0]
            val n = sorted.size
            val rank = (p / 100f) * (n + 1)
            return when {
                rank < 1 -> sorted[0]
                rank >= n -> sorted[n - 1]
                else -> {
                    val lower = rank.toInt() - 1
                    val frac = rank - rank.toInt()
                    sorted[lower] + frac * (sorted[lower + 1] - sorted[lower])
                }
            }
        }
    }

    private class MovingQuantileScalable(private val period: Int, private val quantile: Float) {
        private val history = FloatRingBuffer(period)
        private val low = java.util.PriorityQueue<Float>(compareByDescending { it })
        private val high = java.util.PriorityQueue<Float>()

        private fun peek(): Float = (if (low.isEmpty()) high else low).peek()!!
        private fun heapSize() = low.size + high.size

        fun apply(f: Float): Float {
            if (history.isFull()) {
                val oldest = history.first()
                if (!low.remove(oldest)) high.remove(oldest)
            }
            if (heapSize() == 0 || f <= peek()) low.add(f) else high.add(f)
            history.add(f)
            val target = Math.round(quantile * heapSize())
            while (low.isNotEmpty() && low.size > target) high.add(low.poll()!!)
            while (high.isNotEmpty() && low.size < target) low.add(high.poll()!!)
            return if (heapSize() == 0) f else peek()
        }
    }

    private val almostMax: MovingQuantileScalable
    private val baseline: MovingQuantilePrecise
    private val deviation: MovingQuantileScalable
    private val aggregation: MovingMax
    
    @Volatile
    private var aggregatedActivity = 0.0f
    @Volatile
    private var lastUpdate: Long = 0

    init {
        val f = sampleRate / 8192.0f
        val iMax = max(300.0f, 60.0f * f).toInt()
        almostMax = MovingQuantileScalable(iMax, 0.995f)
        
        val f2 = 10.0f * f
        val iMax2 = max(6.0f, f2).toInt()
        baseline = MovingQuantilePrecise(iMax2, 0.5f)
        
        val iMax3 = max(30.0f, f * 30.0f).toInt()
        deviation = MovingQuantileScalable(iMax3, 0.5f)
        
        val i2 = f2.toInt()
        aggregation = MovingMax(max(1, i2))
    }

    data class Result(val actigraph: Float, val isHighActivity: Boolean)

    fun getAggregatedActivity(): Float {
        if (System.currentTimeMillis() - lastUpdate > 10000) {
            return 0.0f
        }
        return aggregatedActivity
    }

    fun update(f: Float): Result {
        lastUpdate = System.currentTimeMillis()
        val fMin = min(almostMax.apply(f), f)
        val fAbs = abs(fMin - baseline.apply(fMin))
        val fApply = deviation.apply(fAbs)
        val f2 = if (fApply == 0.0f) 1.0f else fAbs / fApply
        aggregatedActivity = aggregation.apply(f2)
        return Result(f2, f2 > 24.0f)
    }
}
