import Foundation

class AwakeWhenHighActivity {
    private var classifiers: [String: AverageActivityOverThreshold] = [:]
    private var lastAwakeDetected: Date = Date.distantPast
    private let lock = NSLock()
    private var notificationObserver: Any?

    init() {
        notificationObserver = NotificationCenter.default.addObserver(
            forName: NSNotification.Name("action_raw_activity"),
            object: nil,
            queue: nil
        ) { [weak self] notification in
            self?.handleRawActivity(notification)
        }
    }

    private func handleRawActivity(_ notification: Notification) {
        lock.lock(); defer { lock.unlock() }
        guard let userInfo = notification.userInfo,
              let sensorType = userInfo["sensor"] as? String,
              let value = userInfo["data"] as? Float else { return }

        // Ignore non-accelerometer/watch sensors (such as SONAR) to prevent noise from triggering false awake intervals
        guard sensorType == "PHONE_ACCEL" || sensorType == "SMARTWATCH" || sensorType == "BLE_ACCEL" else {
            return
        }

        let classifier = classifiers[sensorType] ?? {
            let threshold: Float = (sensorType == "SMARTWATCH" || sensorType == "BLE_ACCEL") ? 2.5 : 1.5
            let newClassifier = AverageActivityOverThreshold(threshold: threshold)
            classifiers[sensorType] = newClassifier
            return newClassifier
        }()

        if classifier.update(activity: value) {
            lastAwakeDetected = Date()
        }
    }

    func isAwake() -> Bool {
        lock.lock(); defer { lock.unlock() }
        return Date().timeIntervalSince(lastAwakeDetected) < 60.0
    }

    func stop() {
        lock.lock(); defer { lock.unlock() }
        if let observer = notificationObserver {
            NotificationCenter.default.removeObserver(observer)
            notificationObserver = nil
        }
        classifiers.removeAll()
        lastAwakeDetected = Date.distantPast
    }

    deinit {
        if let observer = notificationObserver {
            NotificationCenter.default.removeObserver(observer)
        }
    }
}
