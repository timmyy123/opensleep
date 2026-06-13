import Foundation

class AxisData {
    let x: Double
    let y: Double
    let z: Double

    init(x: Double, y: Double, z: Double) {
        self.x = x
        self.y = y
        self.z = z
    }

    func getDiff(_ other: AxisData) -> Double {
        return abs(z - other.z) + abs(y - other.y) + abs(x - other.x)
    }
}

class AxisThresholdGuard {
    let window: Int
    let threshold: Double
    private var lastData: AxisData?
    private var list: [Double] = []
    private let lock = NSLock()

    init(window: Int, threshold: Double) {
        self.window = window
        self.threshold = threshold
    }

    func getAvg() -> Double {
        lock.lock(); defer { lock.unlock() }
        if list.isEmpty { return 0.0 }
        return list.reduce(0.0, +) / Double(list.count)
    }

    func overThreshold() -> Bool {
        return getAvg() > threshold
    }

    func update(x: Double, y: Double, z: Double) {
        lock.lock(); defer { lock.unlock() }
        let currentData = AxisData(x: x, y: y, z: z)
        if let previous = lastData {
            list.append(previous.getDiff(currentData))
            if list.count > window {
                list.removeFirst()
            }
        }
        lastData = currentData
    }
}

class AwakeWhenUsingPhoneDetector {
    private var axisThresholdGuard: AxisThresholdGuard?
    private let lock = NSLock()

    private var ts: Date?
    private var awakeOrientation = true
    private var awakeAcceleration = false

    func onScreenOn() {
        lock.lock(); defer { lock.unlock() }
        ts = Date()
        axisThresholdGuard = AxisThresholdGuard(window: 100, threshold: 0.075)
    }

    func onScreenOff() {
        lock.lock(); defer { lock.unlock() }
        ts = nil
        axisThresholdGuard = nil
        awakeOrientation = false
        awakeAcceleration = false
    }

    func isScreenOn() -> Bool {
        lock.lock(); defer { lock.unlock() }
        return ts != nil
    }

    func isAwake() -> Bool {
        lock.lock(); defer { lock.unlock() }
        // Sleep as Android's sensitivity 3 branch:
        // isScreenOn() && (awakeOrientation || sensitivity >= 3) && (awakeAcceleration || sensitivity >= 2)
        // -> screen-on is enough, even if the phone is lying flat.
        return ts != nil
    }

    func updateMotion(x: Double, y: Double, z: Double) {
        lock.lock(); defer { lock.unlock() }
        axisThresholdGuard?.update(x: x, y: y, z: z)
        if let guardObj = axisThresholdGuard {
            awakeAcceleration = guardObj.overThreshold()
        }
        
        let zVal = z
        let currentOrient = awakeOrientation
        if !currentOrient {
            if zVal > -8.8 && zVal < 8.8 {
                awakeOrientation = true
                return
            }
        } else {
            if zVal < -8.8 || zVal > 8.8 {
                awakeOrientation = false
            }
        }
    }
    
    func stop() {
        onScreenOff()
    }
}
