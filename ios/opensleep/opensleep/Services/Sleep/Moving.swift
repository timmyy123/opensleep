import Foundation

/// Circular ring buffer for Float values matching FloatRingBuffer.java
final class FloatRingBuffer {
    let maxSize: Int
    private var values: [Float]
    private(set) var size: Int = 0
    private var lastIndex: Int = -1

    init(maxSize: Int) {
        precondition(maxSize > 0, "maxSize must be > 0")
        self.maxSize = maxSize
        self.values = [Float](repeating: 0.0, count: maxSize)
    }

    func add(_ f: Float) {
        lastIndex += 1
        if lastIndex >= maxSize {
            lastIndex = 0
        }
        values[lastIndex] = f
        if size < maxSize {
            size += 1
        }
    }

    func get(_ i: Int) -> Float {
        if i >= 0 && i < size {
            let idx = (lastIndex - (size - 1 - i) + maxSize) % maxSize
            return values[idx]
        }
        fatalError("Index \(i) out of bounds for size \(size)")
    }

    func first() -> Float {
        get(0)
    }

    func last() -> Float {
        guard size > 0 else { fatalError("Buffer is empty") }
        return values[lastIndex]
    }

    var isFull: BooleanLiteralType {
        size == maxSize
    }

    func toArray() -> [Float] {
        var result = [Float](repeating: 0.0, count: size)
        for i in 0..<size {
            result[i] = get(i)
        }
        return result
    }
}

/// Sliding window functions matching com.urbandroid.sleep.snoring.feature.Moving
enum Moving {

    static func avg(period: Int) -> (Float) -> Float {
        guard period > 1 else { return { $0 } }
        let history = FloatRingBuffer(maxSize: period)
        var sum: Float = 0.0

        return { value in
            if history.isFull {
                sum -= history.first()
            }
            history.add(value)
            sum += value
            return sum / Float(history.size)
        }
    }

    static func sum(period: Int) -> (Float) -> Float {
        guard period > 1 else { return { $0 } }
        let history = FloatRingBuffer(maxSize: period)
        var sum: Float = 0.0

        return { value in
            if history.isFull {
                sum -= history.first()
            }
            history.add(value)
            sum += value
            return sum
        }
    }

    static func max(period: Int) -> (Float) -> Float {
        guard period > 1 else { return { $0 } }
        var deque: [(val: Float, idx: Int64)] = []
        var currentIndex: Int64 = 0

        return { value in
            currentIndex += 1
            while !deque.isEmpty && deque.first!.idx <= currentIndex - Int64(period) {
                deque.removeFirst()
            }
            while !deque.isEmpty && deque.last!.val <= value {
                deque.removeLast()
            }
            deque.append((val: value, idx: currentIndex))
            return deque.first!.val
        }
    }

    static func min(period: Int) -> (Float) -> Float {
        guard period > 1 else { return { $0 } }
        var deque: [(val: Float, idx: Int64)] = []
        var currentIndex: Int64 = 0

        return { value in
            currentIndex += 1
            while !deque.isEmpty && deque.first!.idx <= currentIndex - Int64(period) {
                deque.removeFirst()
            }
            while !deque.isEmpty && deque.last!.val >= value {
                deque.removeLast()
            }
            deque.append((val: value, idx: currentIndex))
            return deque.first!.val
        }
    }

    static func quantilePrecise(period: Int, quantile: Float) -> (Float) -> Float {
        guard period > 1 else { return { $0 } }
        let history = FloatRingBuffer(maxSize: period)
        let percentile = Percentile()

        return { value in
            history.add(value)
            return percentile.evaluate(history.toArray(), quantile * 100.0)
        }
    }

    static func quantileScalable(period: Int, quantile: Float) -> (Float) -> Float {
        quantilePrecise(period: period, quantile: quantile)
    }
}
