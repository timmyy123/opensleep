package app.opensleep.domain.sleep

import java.util.ArrayDeque
import java.util.Arrays

fun interface FloatFunction {
    fun apply(value: Float): Float
}

class FloatRingBuffer(val maxSize: Int) {
    init {
        require(maxSize > 0) { "maxSize must be > 0" }
    }

    private val values = FloatArray(maxSize)
    var size: Int = 0
        private set
    private var lastIndex: Int = -1

    fun add(f: Float) {
        lastIndex++
        if (lastIndex >= maxSize) {
            lastIndex = 0
        }
        values[lastIndex] = f
        if (size < maxSize) {
            size++
        }
    }

    fun get(i: Int): Float {
        if (i in 0 until size) {
            return values[(lastIndex - (size - 1 - i) + maxSize) % maxSize]
        }
        throw IndexOutOfBoundsException("$i not in 0 until $size")
    }

    fun first(): Float = get(0)
    fun last(): Float {
        if (size == 0) throw IndexOutOfBoundsException("Buffer is empty")
        return values[lastIndex]
    }

    fun isFull(): Boolean = size == maxSize

    fun toArray(): FloatArray {
        val result = FloatArray(size)
        for (i in 0 until size) {
            result[i] = get(i)
        }
        return result
    }
}

object Moving {
    val identity = FloatFunction { it }

    fun avg(period: Int): FloatFunction {
        if (period <= 1) return identity
        return object : FloatFunction {
            private val history = FloatRingBuffer(period)
            private var sum = 0.0f

            override fun apply(value: Float): Float {
                if (history.isFull()) {
                    sum -= history.first()
                }
                history.add(value)
                sum += value
                return sum / history.size
            }
        }
    }

    fun sum(period: Int): FloatFunction {
        if (period <= 1) return identity
        return object : FloatFunction {
            private val history = FloatRingBuffer(period)
            private var sum = 0.0f

            override fun apply(value: Float): Float {
                if (history.isFull()) {
                    sum -= history.first()
                }
                history.add(value)
                sum += value
                return sum
            }
        }
    }

    fun max(period: Int): FloatFunction {
        if (period <= 1) return identity
        return object : FloatFunction {
            // Monotonic deque of (value, index) for optimal O(1) sliding window max
            private val deque = ArrayDeque<Pair<Float, Long>>()
            private var currentIndex = 0L

            override fun apply(value: Float): Float {
                currentIndex++
                while (!deque.isEmpty() && deque.first.second <= currentIndex - period) {
                    deque.removeFirst()
                }
                while (!deque.isEmpty() && deque.last.first <= value) {
                    deque.removeLast()
                }
                deque.addLast(Pair(value, currentIndex))
                return deque.first.first
            }
        }
    }

    fun min(period: Int): FloatFunction {
        if (period <= 1) return identity
        return object : FloatFunction {
            private val deque = ArrayDeque<Pair<Float, Long>>()
            private var currentIndex = 0L

            override fun apply(value: Float): Float {
                currentIndex++
                while (!deque.isEmpty() && deque.first.second <= currentIndex - period) {
                    deque.removeFirst()
                }
                while (!deque.isEmpty() && deque.last.first >= value) {
                    deque.removeLast()
                }
                deque.addLast(Pair(value, currentIndex))
                return deque.first.first
            }
        }
    }

    fun quantilePrecise(period: Int, quantile: Float): FloatFunction {
        if (period <= 1) return identity
        return object : FloatFunction {
            private val history = FloatRingBuffer(period)
            private val percentile = Percentile()

            override fun apply(value: Float): Float {
                history.add(value)
                return percentile.evaluate(history.toArray(), quantile * 100.0f)
            }
        }
    }

    fun quantileScalable(period: Int, quantile: Float): FloatFunction {
        return quantilePrecise(period, quantile)
    }
}
