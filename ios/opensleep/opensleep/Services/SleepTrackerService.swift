import Foundation
import Combine
import CoreMotion
import BackgroundTasks
import SwiftData
import AVFoundation
import Darwin

@_silgen_name("notify_register_check")
@discardableResult
func notify_register_check(_ name: UnsafePointer<CChar>, _ out_token: UnsafeMutablePointer<Int32>) -> UInt32

@_silgen_name("notify_get_state")
@discardableResult
func notify_get_state(_ token: Int32, _ state: UnsafeMutablePointer<UInt64>) -> UInt32


/// Manages sleep tracking: starts/stops CMMotionManager, runs stage analysis,
/// persists results to SwiftData via MainActor. Uses BGProcessingTask to
/// extend background runtime.
class SleepTrackerService: ObservableObject {

    static let bgTaskId = "app.opensleep.sleepanalysis"

    @MainActor @Published var isTracking = false
    @MainActor @Published var activeSession: SleepSession?

    private let motionManager = CMMotionManager()
    private let analyzer = SleepStageAnalyzer()
    private var modelContext: ModelContext?
    private let audioEngine = AVAudioEngine()
    private let analysisQueue = DispatchQueue(label: "tech.opensleep.analysisQueue", qos: .default)
    private var motionOpQueue: OperationQueue?
    private var interruptionObserver: AnyObject?

    // Phone usage awake detector and Sonar components
    private let phoneAwakeDetector = AwakeWhenUsingPhoneDetector()
    private var highActivityAwakeDetector: AwakeWhenHighActivity?
    private var activityBroadcasterTimer: DispatchSourceTimer?
    private var recentAccelMagnitudes: [Float] = []
    private let accelLock = NSLock()
    private let chirpProducer = ChirpProducer(sampleRate: 48000)
    private var watcherTimer: DispatchSourceTimer?
    private var activeAwakeIntervalStart: Date?
    private var lockStateToken: Int32 = 0

    // Sample at ~4 Hz
    private let sampleInterval: TimeInterval = 0.25
    private var stageFlushTimer: DispatchSourceTimer?
    private var audioWatchdogTimer: DispatchSourceTimer?

    init() {
        registerBackgroundTask()
    }

    @MainActor
    func configure(modelContext: ModelContext) {
        self.modelContext = modelContext
    }

    /// Explicitly request required microphone and motion permissions for tracking
    func requestPermissions() {
        // Request Microphone permission
        AVAudioApplication.requestRecordPermission { granted in
            print("Microphone permission granted: \(granted)")
        }

        // Request Motion permission by querying CMMotionActivityManager
        let activityManager = CMMotionActivityManager()
        let today = Date()
        activityManager.queryActivityStarting(from: today, to: today, to: .main) { _, _ in
            // Triggers the system "Motion & Fitness" dialog
        }
    }

    @MainActor
    func startTracking() {
        guard !isTracking else { return }
        guard motionManager.isAccelerometerAvailable else { return }

        // Start AVAudioSession to keep app alive in background
        do {
            let audioSession = AVAudioSession.sharedInstance()
            try audioSession.setCategory(.playAndRecord, mode: .default, options: [.mixWithOthers, .defaultToSpeaker])
            try audioSession.setPreferredSampleRate(48000.0)
            try audioSession.setActive(true)
        } catch {
            print("Failed to configure background audio session: \(error)")
        }

        let session = SleepSession(startDate: Date())
        modelContext?.insert(session)
        try? modelContext?.save()
        activeSession = session

        analysisQueue.sync { [weak self] in
            self?.analyzer.clear()
            self?.activeAwakeIntervalStart = nil
        }
        isTracking = true

        let queue = OperationQueue()
        queue.name = "app.opensleep.motionQueue"
        queue.maxConcurrentOperationCount = 1
        motionOpQueue = queue

        motionManager.accelerometerUpdateInterval = sampleInterval
        motionManager.startAccelerometerUpdates(to: queue) { [weak self] data, _ in
            guard let self, let data else { return }
            
            // Feed to phone awake detector in units of m/s^2 (G * 9.80665)
            self.phoneAwakeDetector.updateMotion(
                x: data.acceleration.x * 9.80665,
                y: data.acceleration.y * 9.80665,
                z: data.acceleration.z * 9.80665
            )
            
            let x = Float(data.acceleration.x)
            let y = Float(data.acceleration.y)
            let z = Float(data.acceleration.z)
            let mag = sqrt(x*x + y*y + z*z)
            self.accelLock.lock()
            self.recentAccelMagnitudes.append(mag)
            self.accelLock.unlock()
            
            self.analysisQueue.async {
                let bootTime = Date(timeIntervalSinceNow: -ProcessInfo.processInfo.systemUptime)
                let sampleDate = bootTime.addingTimeInterval(data.timestamp)
                self.analyzer.addSample(
                    timestamp: sampleDate,
                    x: data.acceleration.x,
                    y: data.acceleration.y,
                    z: data.acceleration.z
                )
            }
        }

        if motionManager.isGyroAvailable {
            motionManager.gyroUpdateInterval = sampleInterval
            motionManager.startGyroUpdates(to: queue) { [weak self] data, _ in
                guard let self, let data else { return }
                self.analysisQueue.async {
                    let bootTime = Date(timeIntervalSinceNow: -ProcessInfo.processInfo.systemUptime)
                    let sampleDate = bootTime.addingTimeInterval(data.timestamp)
                    self.analyzer.addGyroSample(
                        timestamp: sampleDate,
                        x: data.rotationRate.x,
                        y: data.rotationRate.y,
                        z: data.rotationRate.z
                    )
                }
            }
        }

        interruptionObserver = NotificationCenter.default.addObserver(
            forName: AVAudioSession.interruptionNotification,
            object: nil,
            queue: .main
        ) { [weak self] notification in
            self?.handleAudioInterruption(notification)
        }
        
        registerLockStateObserver()
        startAudioMetering()
        scheduleBackgroundTask()

        highActivityAwakeDetector = AwakeWhenHighActivity()

        // 10-second activity broadcaster timer
        let broadcaster = DispatchSource.makeTimerSource(queue: analysisQueue)
        broadcaster.schedule(deadline: .now() + 10.0, repeating: 10.0)
        let accelAggregator = AccelActivityAggregator()
        broadcaster.setEventHandler { [weak self] in
            guard let self = self else { return }
            self.accelLock.lock()
            let magnitudes = self.recentAccelMagnitudes
            self.recentAccelMagnitudes.removeAll()
            self.accelLock.unlock()
            
            if !magnitudes.isEmpty {
                let maxMag = magnitudes.max() ?? 0.0
                let actigraph = accelAggregator.update(maxMag)
                print("iOS: Broadcaster posting raw accelerometer activity: \(actigraph) (samples count: \(magnitudes.count))")
                NotificationCenter.default.post(
                    name: NSNotification.Name("action_raw_activity"),
                    object: nil,
                    userInfo: ["sensor": "PHONE_ACCEL", "data": actigraph]
                )
            }
        }
        broadcaster.resume()
        activityBroadcasterTimer = broadcaster

        // 30-second awake watcher timer (DispatchSourceTimer fires in background)
        let watcher = DispatchSource.makeTimerSource(queue: analysisQueue)
        watcher.schedule(deadline: .now() + 30.0, repeating: 30.0)
        watcher.setEventHandler { [weak self] in
            guard let self = self else { return }
            let highActivityAwake = self.highActivityAwakeDetector?.isAwake() ?? false
            let now = Date()
            let awake = self.phoneAwakeDetector.isAwake() || highActivityAwake
            self.recordAwakeState(now: now, awake: awake, lookback: 30.0)
            if awake {
                print("iOS: Phone awake detected (phone or high activity); added awake interval.")
            }
        }
        watcher.resume()
        watcherTimer = watcher

        // Flush stages every 1 minute (DispatchSourceTimer fires in background)
        let flush = DispatchSource.makeTimerSource(queue: analysisQueue)
        flush.schedule(deadline: .now() + 60, repeating: 60)
        flush.setEventHandler { [weak self] in
            guard let self = self else { return }
            DispatchQueue.main.async {
                self.flushStages()
            }
        }
        flush.resume()
        stageFlushTimer = flush

        // Audio engine health watchdog — every 30s check if engine stopped and restart
        let watchdog = DispatchSource.makeTimerSource(queue: analysisQueue)
        watchdog.schedule(deadline: .now() + 30, repeating: 30)
        watchdog.setEventHandler { [weak self] in
            guard let self = self else { return }
            if !self.audioEngine.isRunning {
                print("iOS: Audio engine stopped unexpectedly. Restarting...")
                do {
                    try AVAudioSession.sharedInstance().setActive(true)
                    try self.audioEngine.start()
                    print("iOS: Audio engine restarted successfully.")
                } catch {
                    print("iOS: Failed to restart audio engine: \(error)")
                }
            }
        }
        watchdog.resume()
        audioWatchdogTimer = watchdog
    }

    @MainActor
    func stopTracking() {
        guard isTracking else { return }
        analysisQueue.sync {
            recordAwakeState(now: Date(), awake: false)
        }
        motionManager.stopAccelerometerUpdates()
        motionManager.stopGyroUpdates()
        motionOpQueue = nil
        stageFlushTimer?.cancel()
        stageFlushTimer = nil
        
        watcherTimer?.cancel()
        watcherTimer = nil
        activityBroadcasterTimer?.cancel()
        activityBroadcasterTimer = nil
        audioWatchdogTimer?.cancel()
        audioWatchdogTimer = nil
        phoneAwakeDetector.stop()
        highActivityAwakeDetector?.stop()
        highActivityAwakeDetector = nil
        activeAwakeIntervalStart = nil
        unregisterLockStateObserver()
        
        stopAudioMetering()
        isTracking = false

        if let observer = interruptionObserver {
            NotificationCenter.default.removeObserver(observer)
            interruptionObserver = nil
        }

        // Deactivate background audio session
        try? AVAudioSession.sharedInstance().setActive(false, options: .notifyOthersOnDeactivation)

        guard let session = activeSession else { return }
        session.endDate = Date()
        
        // Capture strong references to prevent deallocation during async save
        let startDate = session.startDate
        let analyzer = self.analyzer
        let modelContext = self.modelContext
        let activeSession = self.activeSession
        
        analysisQueue.async {
            let stages = analyzer.computeStages(sleepStart: startDate)
            DispatchQueue.main.async {
                if let active = activeSession {
                    active.stages = stages
                    try? modelContext?.save()
                    print("iOS: Saved \(stages.count) stages to session.")
                }
            }
        }
    }

    @MainActor
    private func flushStages() {
        guard let session = activeSession else { return }
        // Capture strong references
        let startDate = session.startDate
        let analyzer = self.analyzer
        let modelContext = self.modelContext
        let activeSession = self.activeSession
        
        analysisQueue.async {
            let stages = analyzer.computeStages(sleepStart: startDate)
            DispatchQueue.main.async {
                if let active = activeSession {
                    active.stages = stages
                    try? modelContext?.save()
                }
            }
        }
        if isTracking {
            scheduleBackgroundTask()
        }
    }

    private func startAudioMetering() {
        let inputNode = audioEngine.inputNode
        
        let recordingFormat = inputNode.outputFormat(forBus: 0)
        let inputSampleRate = Int(recordingFormat.sampleRate.rounded())
        guard inputSampleRate > 0 else {
            print("Failed to get valid input audio format")
            return
        }
        
        let diffSonar = DiffSonarConsumer(sampleRate: inputSampleRate)
        let aggregator = LowLevelActivityAggregator(sampleRate: inputSampleRate)
        var lastSonarSampleTime = Date()
        
        chirpProducer.play()
        
        inputNode.installTap(onBus: 0, bufferSize: 2048, format: recordingFormat) { [weak self] buffer, time in
            guard let self = self else { return }
            
            guard let channelData = buffer.floatChannelData?[0] else { return }
            let frameLength = Int(buffer.frameLength)
            let floatArr = Array(UnsafeBufferPointer(start: channelData, count: frameLength))
            
            let consumerRes = diffSonar.processAndGetResult(floatArr)
            let activityResult = aggregator.update(consumerRes.activity)
            if activityResult.isHighActivity {
                self.analysisQueue.async {
                    self.recordAwakeState(now: Date(), awake: true, lookback: 10.0)
                }
            }
            
            let now = Date()
            if now.timeIntervalSince(lastSonarSampleTime) >= 10.0 {
                let act = aggregator.getAggregatedActivity()
                self.analysisQueue.async {
                    self.analyzer.addSonarSample(timestamp: now, activity: act)
                }
                
                // Broadcast Sonar activity
                print("iOS: Broadcaster posting raw Sonar activity: \(act)")
                NotificationCenter.default.post(
                    name: NSNotification.Name("action_raw_activity"),
                    object: nil,
                    userInfo: ["sensor": "SONAR", "data": act]
                )
                
                lastSonarSampleTime = now
            }
        }
        
        do {
            try audioEngine.start()
        } catch {
            print("Failed to start AVAudioEngine: \(error)")
        }
    }

    private func stopAudioMetering() {
        audioEngine.inputNode.removeTap(onBus: 0)
        audioEngine.stop()
        chirpProducer.stop()
    }

    private func recordAwakeState(now: Date, awake: Bool, lookback: TimeInterval = 0) {
        if awake {
            let start = activeAwakeIntervalStart ?? now.addingTimeInterval(-lookback)
            activeAwakeIntervalStart = start
            analyzer.addAwakeInterval(start: start, end: now)
        } else {
            if let start = activeAwakeIntervalStart, now > start {
                analyzer.addAwakeInterval(start: start, end: now)
            }
            activeAwakeIntervalStart = nil
        }
    }

    private func handleAudioInterruption(_ notification: Notification) {
        guard let userInfo = notification.userInfo,
              let typeValue = userInfo[AVAudioSessionInterruptionTypeKey] as? UInt,
              let type = AVAudioSession.InterruptionType(rawValue: typeValue) else {
            return
        }
        
        if type == .began {
            print("Audio session interruption began. Stopping audio engine.")
        } else if type == .ended {
            print("Audio session interruption ended. Attempting to resume.")
            if let optionsValue = userInfo[AVAudioSessionInterruptionOptionKey] as? UInt {
                let options = AVAudioSession.InterruptionOptions(rawValue: optionsValue)
                if options.contains(.shouldResume) {
                    do {
                        try AVAudioSession.sharedInstance().setActive(true)
                        if !self.audioEngine.isRunning {
                            try self.audioEngine.start()
                            print("Audio engine restarted successfully after interruption.")
                        }
                    } catch {
                        print("Failed to restart audio engine after interruption: \(error)")
                    }
                }
            }
        }
    }

    // MARK: - Screen Lock State Darwin Observer

    private func registerLockStateObserver() {
        let name = "com.apple.springboard.lockstate" as CFString
        let center = CFNotificationCenterGetDarwinNotifyCenter()
        
        notify_register_check("com.apple.springboard.lockstate", &lockStateToken)
        
        CFNotificationCenterAddObserver(
            center,
            Unmanaged.passUnretained(self).toOpaque(),
            { (_, observer, _, _, _) in
                if let observer = observer {
                    let service = Unmanaged<SleepTrackerService>.fromOpaque(observer).takeUnretainedValue()
                    service.updateLockState()
                }
            },
            name,
            nil,
            .deliverImmediately
        )
        updateLockState()
    }

    private func unregisterLockStateObserver() {
        let center = CFNotificationCenterGetDarwinNotifyCenter()
        CFNotificationCenterRemoveObserver(
            center,
            Unmanaged.passUnretained(self).toOpaque(),
            CFNotificationName("com.apple.springboard.lockstate" as CFString),
            nil
        )
    }

    private func updateLockState() {
        var state: UInt64 = 0
        notify_get_state(lockStateToken, &state)
        let isLocked = (state != 0)
        if isLocked {
            phoneAwakeDetector.onScreenOff()
        } else {
            phoneAwakeDetector.onScreenOn()
        }
    }

    // MARK: - Background Tasks

    private func registerBackgroundTask() {
        BGTaskScheduler.shared.register(forTaskWithIdentifier: Self.bgTaskId, using: nil) { [weak self] task in
            self?.handleBackgroundTask(task)
        }
    }

    private func scheduleBackgroundTask() {
        let request = BGProcessingTaskRequest(identifier: Self.bgTaskId)
        request.requiresNetworkConnectivity = false
        request.requiresExternalPower = false
        request.earliestBeginDate = Date(timeIntervalSinceNow: 15 * 60)
        try? BGTaskScheduler.shared.submit(request)
    }

    private func handleBackgroundTask(_ task: BGTask) {
        scheduleBackgroundTask()
        task.expirationHandler = { [weak self] in
            Task { @MainActor in
                self?.flushStages()
                task.setTaskCompleted(success: true)
            }
        }
        Task { @MainActor in
            self.flushStages()
            task.setTaskCompleted(success: true)
        }
    }
}

class AccelActivityAggregator {
    private var baselineBuffer: [Float] = []
    private var baselineIndex = 0

    func update(_ f: Float) -> Float {
        if baselineBuffer.count < 6 {
            baselineBuffer.append(f)
        } else {
            baselineBuffer[baselineIndex] = f
            baselineIndex = (baselineIndex + 1) % 6
        }
        let sorted = baselineBuffer.sorted()
        let median: Float
        if sorted.count % 2 == 1 {
            median = sorted[sorted.count / 2]
        } else {
            median = (sorted[sorted.count / 2 - 1] + sorted[sorted.count / 2]) / 2.0
        }
        return abs(f - median)
    }
}
