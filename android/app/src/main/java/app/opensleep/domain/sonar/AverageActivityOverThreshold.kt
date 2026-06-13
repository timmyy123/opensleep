package app.opensleep.domain.sonar

class AverageActivityOverThreshold(private val threshold: Float) {
    private var callCount = 0
    private var lastResult = false
    private var looksLikeMilliG = false
    private val averageActivity = MovingAvg(30)

    fun update(activity: Float): Boolean {
        callCount++
        if (activity > 150f && !looksLikeMilliG) {
            looksLikeMilliG = true
        }
        val currentThreshold = (if (looksLikeMilliG) 100f else 1f) * threshold
        val avg = averageActivity.apply(activity)
        val result = callCount >= 30 && avg > currentThreshold
        if (result != lastResult) {
            lastResult = result
        }
        return result
    }

    private class MovingAvg(private val period: Int) {
        private val history = FloatRingBuffer(period + 1)
        private var sum = 0f

        fun apply(f: Float): Float {
            history.add(f)
            if (history.size() <= period) {
                sum += f
                return sum / history.size()
            }
            sum = sum - history.first() + history.last()
            return sum / (history.size() - 1)
        }
    }

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
        fun last(): Float {
            check(size > 0)
            return get(size - 1)
        }
        fun get(i: Int): Float {
            require(i in 0 until size) { "$i >= $size" }
            return values[(lastIndex - size + 1 + i + maxSize * 2) % maxSize]
        }
        fun size() = size
    }
}
