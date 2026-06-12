import Foundation

class LowLevelActivityAggregator {

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
        func count()  -> Int  { size }
        func isFull() -> Bool { size == maxSize }

        func toArray() -> [Float] { (0..<size).map { get($0) } }
    }

    private final class MovingMax {
        private let period: Int
        private let history: FloatRingBuffer
        private var ordered: [Float] = []

        init(_ period: Int) {
            self.period = period
            self.history = FloatRingBuffer(period)
        }

        func apply(_ f: Float) -> Float {
            if history.isFull() {
                if let idx = ordered.firstIndex(of: history.first()) {
                    ordered.remove(at: idx)
                }
            }
            history.add(f)
            ordered.append(f)
            ordered.sort()
            return ordered.last ?? f
        }
    }

    private final class MovingQuantilePrecise {
        private let period: Int
        private let quantile: Float
        private let history: FloatRingBuffer

        init(_ period: Int, _ quantile: Float) {
            self.period = period
            self.quantile = quantile
            self.history = FloatRingBuffer(period)
        }

        func apply(_ f: Float) -> Float {
            history.add(f)
            var sorted = history.toArray().sorted()
            return percentile(&sorted, p: quantile * 100)
        }

        private func percentile(_ sorted: inout [Float], p: Float) -> Float {
            guard !sorted.isEmpty else { return 0 }
            if sorted.count == 1 { return sorted[0] }
            let n = sorted.count
            let rank = (p / 100) * Float(n + 1)
            if rank < 1 { return sorted[0] }
            if rank >= Float(n) { return sorted[n - 1] }
            let lower = Int(rank) - 1
            let frac = rank - Float(Int(rank))
            return sorted[lower] + frac * (sorted[lower + 1] - sorted[lower])
        }
    }

    private final class MovingQuantileScalable {
        private let period: Int
        private let quantile: Float
        private let history: FloatRingBuffer
        private var low: [Float] = []
        private var high: [Float] = []

        init(_ period: Int, _ quantile: Float) {
            self.period = period
            self.quantile = quantile
            self.history = FloatRingBuffer(period)
        }

        private func peekLow()  -> Float { -low[0] }
        private func peekHigh() -> Float {  high[0] }
        private func peek()     -> Float { low.isEmpty ? peekHigh() : peekLow() }
        private var heapSize: Int { low.count + high.count }

        func apply(_ f: Float) -> Float {
            if history.isFull() {
                let oldest = history.first()
                if !removeLow(oldest) { removeHigh(oldest) }
            }
            if heapSize == 0 || f <= peek() { insertLow(f) } else { insertHigh(f) }
            history.add(f)
            let target = Int((quantile * Float(heapSize)).rounded())
            while !low.isEmpty  && low.count  > target { insertHigh(pollLow()) }
            while !high.isEmpty && low.count  < target { insertLow(pollHigh()) }
            return heapSize == 0 ? f : peek()
        }

        private func insertLow(_ v: Float)  { low.append(-v);  heapifyUp(&low,  low.count  - 1) }
        private func insertHigh(_ v: Float) { high.append(v);  heapifyUp(&high, high.count - 1) }

        private func pollLow() -> Float {
            let val = -low[0]; low[0] = low[low.count - 1]; low.removeLast()
            if !low.isEmpty { heapifyDown(&low, 0) }
            return val
        }
        private func pollHigh() -> Float {
            let val = high[0]; high[0] = high[high.count - 1]; high.removeLast()
            if !high.isEmpty { heapifyDown(&high, 0) }
            return val
        }

        private func removeLow(_ v: Float) -> Bool {
            guard let i = low.firstIndex(of: -v) else { return false }
            low[i] = low[low.count - 1]; low.removeLast()
            if i < low.count { heapifyDown(&low, i); heapifyUp(&low, i) }
            return true
        }
        private func removeHigh(_ v: Float) -> Bool {
            guard let i = high.firstIndex(of: v) else { return false }
            high[i] = high[high.count - 1]; high.removeLast()
            if i < high.count { heapifyDown(&high, i); heapifyUp(&high, i) }
            return true
        }

        private func heapifyUp(_ h: inout [Float], _ idx: Int) {
            var i = idx
            while i > 0 {
                let p = (i - 1) / 2
                if h[p] > h[i] { h.swapAt(p, i); i = p } else { break }
            }
        }
        private func heapifyDown(_ h: inout [Float], _ idx: Int) {
            var i = idx
            while true {
                var s = i
                let l = 2*i+1, r = 2*i+2
                if l < h.count && h[l] < h[s] { s = l }
                if r < h.count && h[r] < h[s] { s = r }
                if s == i { break }
                h.swapAt(i, s); i = s
            }
        }
    }

    private let almostMax: MovingQuantileScalable
    private let baseline: MovingQuantilePrecise
    private let deviation: MovingQuantileScalable
    private let aggregation: MovingMax

    private let lock = NSLock()
    private var aggregatedActivity: Float = 0.0
    private var lastUpdate: Date = Date.distantPast

    init(sampleRate: Int) {
        let f = Float(sampleRate) / 8192.0
        let iMax = Int(max(300.0, 60.0 * f))
        almostMax = MovingQuantileScalable(iMax, 0.995)

        let f2 = 10.0 * f
        let iMax2 = Int(max(6.0, f2))
        baseline = MovingQuantilePrecise(iMax2, 0.5)

        let iMax3 = Int(max(30.0, f * 30.0))
        deviation = MovingQuantileScalable(iMax3, 0.5)

        let i2 = Int(f2)
        aggregation = MovingMax(max(1, i2))
    }

    struct Result {
        let actigraph: Float
        let isHighActivity: Bool
    }

    func getAggregatedActivity() -> Float {
        lock.lock(); defer { lock.unlock() }
        if Date().timeIntervalSince(lastUpdate) > 10.0 {
            return 0.0
        }
        return aggregatedActivity
    }

    func update(_ f: Float) -> Result {
        lock.lock(); defer { lock.unlock() }
        lastUpdate = Date()
        let fMin = min(almostMax.apply(f), f)
        let fAbs = abs(fMin - baseline.apply(fMin))
        let fApply = deviation.apply(fAbs)
        let f2 = (fApply == 0.0) ? 1.0 : fAbs / fApply
        aggregatedActivity = aggregation.apply(f2)
        return Result(actigraph: f2, isHighActivity: f2 > 24.0)
    }
}
