import Foundation

class AverageActivityOverThreshold {
    private var callCount = 0
    private var lastResult = false
    private var looksLikeMilliG = false
    private let threshold: Float
    private let averageActivity = MovingAvg(30)
    private let lock = NSLock()

    init(threshold: Float) {
        self.threshold = threshold
    }

    func update(activity: Float) -> Bool {
        lock.lock(); defer { lock.unlock() }
        callCount += 1
        if activity > 150.0 && !looksLikeMilliG {
            looksLikeMilliG = true
        }
        let currentThreshold = (looksLikeMilliG ? 100.0 : 1.0) * Float(threshold)
        let avg = averageActivity.apply(activity)
        let result = callCount >= 30 && avg > currentThreshold
        if result != lastResult {
            lastResult = result
        }
        return result
    }

    private final class FloatRingBuffer {
        let maxSize: Int
        private var values: [Float]
        private var size = 0
        private var lastIndex = -1

        init(_ maxSize: Int) {
            precondition(maxSize > 0)
            self.maxSize = maxSize
            self.values = [Float](repeating: 0, count: maxSize)
        }

        func add(_ f: Float) {
            lastIndex += 1
            if lastIndex >= maxSize { lastIndex = 0 }
            values[lastIndex] = f
            if size < maxSize { size += 1 }
        }

        func get(_ i: Int) -> Float {
            precondition(i >= 0 && i < size)
            return values[(lastIndex - size + 1 + i + maxSize * 2) % maxSize]
        }

        func first() -> Float { get(0) }
        func last() -> Float { get(size - 1) }
        func count()  -> Int  { size }
    }

    private final class MovingAvg {
        private let period: Int
        private let history: FloatRingBuffer
        private var sum: Float = 0.0

        init(_ period: Int) {
            self.period = period
            self.history = FloatRingBuffer(period + 1)
        }

        func apply(_ f: Float) -> Float {
            history.add(f)
            if history.count() <= period {
                sum += f
                return sum / Float(history.count())
            }
            sum = sum - history.first() + history.last()
            return sum / Float(history.count() - 1)
        }
    }
}
