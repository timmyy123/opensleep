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
///
/// ROOT CAUSE OF "KILLED WHEN PLUGGED IN":
/// When a charger is connected, iOS fires AVAudioSession.routeChangeNotification.
/// AVAudioEngine's inputNode outputFormat changes to match the new hardware
/// (sample rate may change). The existing tap installed at the old format causes
/// an NSException that kills the process. Fix: listen for routeChangeNotification
/// and fully tear down / rebuild the audio engine when this happens.
class SleepTrackerService: ObservableObject {

    static let bgTaskId = "app.opensleep.sleepanalysis"

    @MainActor @Published var isTracking = false
    @MainActor @Published var activeSession: SleepSession?

    private let motionManager = CMMotionManager()
    private let analyzer = SleepStageAnalyzer()
    private var modelContext: ModelContext?

    // Audio engine is recreated on every route change to avoid stale-format crashes
    private var audioEngine: AVAudioEngine?
    private let chirpProducer = ChirpProducer(sampleRate: 48000)

    private let analysisQueue = DispatchQueue(label: "tech.opensleep.analysisQueue", qos: .default)
    private var motionOpQueue: OperationQueue?
    private var interruptionObserver: AnyObject?
    private var routeChangeObserver: AnyObject?  // KEY FIX: observe route changes

    // Phone usage awake detector and Sonar components
    private let phoneAwakeDetector = AwakeWhenUsingPhoneDetector()
    private var highActivityAwakeDetector: AwakeWhenHighActivity?
    private var activityBroadcasterTimer: DispatchSourceTimer?
    private var recentAccelMagnitudes: [Float] = []
    private let accelLock = NSLock()
    private var watcherTimer: DispatchSourceTimer?
    private var activeAwakeIntervalStart: Date?
    private var lockStateToken: Int32 = 0

    // Sample at ~4 Hz
    private let sampleInterval: TimeInterval = 0.25
    private var stageFlushTimer: DispatchSourceTimer?

    // Sonar processing state — persists across engine rebuilds
    private let diffSonar = DiffSonarConsumer(sampleRate: 48000)
    private let activityAggregator = LowLevelActivityAggregator(sampleRate: 48000)
    private var lastSonarSampleTime = Date.distantPast
    private var isAudioRunning = false
    private let audioRebuildQueue = DispatchQueue(label: "tech.opensleep.audioRebuild", qos: .userInitiated)

    init() {
        registerBackgroundTask()
    }

    @MainActor
    func configure(modelContext: ModelContext) {
        self.modelContext = modelContext
    }

    /// Explicitly request required microphone and motion permissions for tracking
    func requestPermissions() {
        AVAudioApplication.requestRecordPermission { granted in
            print("Microphone permission granted: \(granted)")
        }
        let activityManager = CMMotionActivityManager()
        let today = Date()
        activityManager.queryActivityStarting(from: today, to: today, to: .main) { _, _ in }
    }

    @MainActor
    func startTracking() {
        guard !isTracking else { return }
        guard motionManager.isAccelerometerAvailable else { return }

        // Configure AVAudioSession.
        // .playAndRecord keeps the app alive in background with microphone access.
        // .mixWithOthers: don't kill user's music.
        // .allowBluetooth: avoid routing fights if BT device connected.
        // NOTE: do NOT set preferredSampleRate — let the system pick the route's
        // native rate. Forcing a rate is what causes crashes on route changes.
        do {
            let session = AVAudioSession.sharedInstance()
            try session.setCategory(.playAndRecord, mode: .default, options: [.mixWithOthers, .allowBluetooth, .defaultToSpeaker])
            try session.setActive(true)
        } catch {
            print("iOS: Failed to configure audio session: \(error)")
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
                self.analyzer.addSample(timestamp: sampleDate, x: data.acceleration.x, y: data.acceleration.y, z: data.acceleration.z)
            }
        }

        if motionManager.isGyroAvailable {
            motionManager.gyroUpdateInterval = sampleInterval
            motionManager.startGyroUpdates(to: queue) { [weak self] data, _ in
                guard let self, let data else { return }
                self.analysisQueue.async {
                    let bootTime = Date(timeIntervalSinceNow: -ProcessInfo.processInfo.systemUptime)
                    let sampleDate = bootTime.addingTimeInterval(data.timestamp)
                    self.analyzer.addGyroSample(timestamp: sampleDate, x: data.rotationRate.x, y: data.rotationRate.y, z: data.rotationRate.z)
                }
            }
        }

        // Listen for audio interruptions (phone calls, Siri, etc.)
        interruptionObserver = NotificationCenter.default.addObserver(
            forName: AVAudioSession.interruptionNotification,
            object: nil,
            queue: nil
        ) { [weak self] notification in
            self?.handleAudioInterruption(notification)
        }

        // KEY FIX: Listen for route changes (charger plug-in/out, headphones, etc.)
        // When the audio route changes the inputNode format changes — we MUST
        // tear down and rebuild the engine or it crashes with a stale-format exception.
        routeChangeObserver = NotificationCenter.default.addObserver(
            forName: AVAudioSession.routeChangeNotification,
            object: nil,
            queue: nil
        ) { [weak self] notification in
            self?.handleAudioRouteChange(notification)
        }

        registerLockStateObserver()
        highActivityAwakeDetector = AwakeWhenHighActivity()

        // 10-second accelerometer activity broadcaster
        let broadcaster = DispatchSource.makeTimerSource(queue: analysisQueue)
        broadcaster.schedule(deadline: .now() + 10.0, repeating: 10.0)
        let accelAggregator = AccelActivityAggregator()
        broadcaster.setEventHandler { [weak self] in
            guard let self else { return }
            self.accelLock.lock()
            let magnitudes = self.recentAccelMagnitudes
            self.recentAccelMagnitudes.removeAll()
            self.accelLock.unlock()
            if !magnitudes.isEmpty {
                let maxMag = magnitudes.max() ?? 0.0
                let actigraph = accelAggregator.update(maxMag)
                NotificationCenter.default.post(
                    name: NSNotification.Name("action_raw_activity"),
                    object: nil,
                    userInfo: ["sensor": "PHONE_ACCEL", "data": actigraph]
                )
            }
        }
        broadcaster.resume()
        activityBroadcasterTimer = broadcaster

        // 30-second awake watcher
        let watcher = DispatchSource.makeTimerSource(queue: analysisQueue)
        watcher.schedule(deadline: .now() + 30.0, repeating: 30.0)
        watcher.setEventHandler { [weak self] in
            guard let self else { return }
            let highActivityAwake = self.highActivityAwakeDetector?.isAwake() ?? false
            let now = Date()
            let awake = self.phoneAwakeDetector.isAwake() || highActivityAwake
            self.recordAwakeState(now: now, awake: awake, lookback: 30.0)
            if awake { print("iOS: Awake detected.") }
        }
        watcher.resume()
        watcherTimer = watcher

        // 1-minute stage flush to SwiftData
        let flush = DispatchSource.makeTimerSource(queue: analysisQueue)
        flush.schedule(deadline: .now() + 60, repeating: 60)
        flush.setEventHandler { [weak self] in
            DispatchQueue.main.async { self?.flushStages() }
        }
        flush.resume()
        stageFlushTimer = flush

        scheduleBackgroundTask()
        buildAndStartAudioEngine()
    }

    @MainActor
    func stopTracking() {
        guard isTracking else { return }
        analysisQueue.sync { recordAwakeState(now: Date(), awake: false) }
        motionManager.stopAccelerometerUpdates()
        motionManager.stopGyroUpdates()
        motionOpQueue = nil
        stageFlushTimer?.cancel(); stageFlushTimer = nil
        watcherTimer?.cancel(); watcherTimer = nil
        activityBroadcasterTimer?.cancel(); activityBroadcasterTimer = nil
        phoneAwakeDetector.stop()
        highActivityAwakeDetector?.stop(); highActivityAwakeDetector = nil
        activeAwakeIntervalStart = nil
        unregisterLockStateObserver()

        teardownAudioEngine()
        isTracking = false

        if let obs = interruptionObserver { NotificationCenter.default.removeObserver(obs); interruptionObserver = nil }
        if let obs = routeChangeObserver { NotificationCenter.default.removeObserver(obs); routeChangeObserver = nil }

        try? AVAudioSession.sharedInstance().setActive(false, options: .notifyOthersOnDeactivation)

        guard let session = activeSession else { return }
        session.endDate = Date()
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
                    print("iOS: Saved \(stages.count) stages.")
                }
            }
        }
    }

    // MARK: - Audio Engine (Build / Teardown / Rebuild)

    /// Builds a fresh AVAudioEngine, installs the Sonar input tap, and starts playback.
    /// Called on first start and every time the audio route changes.
    private func buildAndStartAudioEngine() {
        // Always run on dedicated queue to avoid re-entrant rebuilds
        audioRebuildQueue.async { [weak self] in
            guard let self else { return }
            self.teardownAudioEngine()

            let engine = AVAudioEngine()
            self.audioEngine = engine

            let inputNode = engine.inputNode
            // Re-query the format AFTER assigning the engine — this is the native
            // format for the currently active route. Using a stale cached format
            // is what causes the crash when the charger is plugged in.
            let recordingFormat = inputNode.outputFormat(forBus: 0)
            guard recordingFormat.sampleRate > 0 else {
                print("iOS: Invalid input format, skipping audio engine start.")
                return
            }

            inputNode.installTap(onBus: 0, bufferSize: 4096, format: recordingFormat) { [weak self] buffer, _ in
                guard let self else { return }
                guard let channelData = buffer.floatChannelData?[0] else { return }
                let frameLength = Int(buffer.frameLength)
                let floatArr = Array(UnsafeBufferPointer(start: channelData, count: frameLength))

                let consumerRes = self.diffSonar.processAndGetResult(floatArr)
                let activityResult = self.activityAggregator.update(consumerRes.activity)
                if activityResult.isHighActivity {
                    self.analysisQueue.async {
                        self.recordAwakeState(now: Date(), awake: true, lookback: 10.0)
                    }
                }

                let now = Date()
                if now.timeIntervalSince(self.lastSonarSampleTime) >= 10.0 {
                    let act = self.activityAggregator.getAggregatedActivity()
                    self.analysisQueue.async {
                        self.analyzer.addSonarSample(timestamp: now, activity: act)
                    }
                    NotificationCenter.default.post(
                        name: NSNotification.Name("action_raw_activity"),
                        object: nil,
                        userInfo: ["sensor": "SONAR", "data": act]
                    )
                    self.lastSonarSampleTime = now
                }
            }

            do {
                try AVAudioSession.sharedInstance().setActive(true)
                try engine.start()
                self.isAudioRunning = true
                self.chirpProducer.play()
                print("iOS: Audio engine started with format: \(recordingFormat)")
            } catch {
                print("iOS: Failed to start audio engine: \(error)")
                inputNode.removeTap(onBus: 0)
                self.audioEngine = nil
            }
        }
    }

    /// Tears down the current audio engine safely. Must be called before rebuilding.
    private func teardownAudioEngine() {
        chirpProducer.stop()
        if let engine = audioEngine {
            engine.inputNode.removeTap(onBus: 0)
            engine.stop()
        }
        audioEngine = nil
        isAudioRunning = false
    }

    // MARK: - Audio Session Notifications

    /// Handles interruptions (phone call, Siri, alarm, etc.)
    private func handleAudioInterruption(_ notification: Notification) {
        guard let userInfo = notification.userInfo,
              let typeValue = userInfo[AVAudioSessionInterruptionTypeKey] as? UInt,
              let type = AVAudioSession.InterruptionType(rawValue: typeValue) else { return }

        if type == .began {
            print("iOS: Audio interruption began — stopping engine.")
            audioRebuildQueue.async { [weak self] in self?.teardownAudioEngine() }
        } else if type == .ended {
            if let optionsValue = userInfo[AVAudioSessionInterruptionOptionKey] as? UInt {
                let options = AVAudioSession.InterruptionOptions(rawValue: optionsValue)
                if options.contains(.shouldResume) {
                    print("iOS: Audio interruption ended — rebuilding engine.")
                    buildAndStartAudioEngine()
                }
            }
        }
    }

    /// Handles route changes: charger plugged in/out, headphones, Bluetooth.
    /// This is the ROOT CAUSE fix for "app killed when phone plugged in".
    /// The charger triggers a route change → inputNode format changes →
    /// stale tap format causes NSException → iOS kills the app.
    private func handleAudioRouteChange(_ notification: Notification) {
        guard let userInfo = notification.userInfo,
              let reasonValue = userInfo[AVAudioSessionRouteChangeReasonKey] as? UInt,
              let reason = AVAudioSession.RouteChangeReason(rawValue: reasonValue) else { return }

        switch reason {
        case .newDeviceAvailable, .oldDeviceUnavailable, .categoryChange, .override:
            print("iOS: Audio route changed (reason: \(reason.rawValue)) — rebuilding engine.")
            // Small delay to let the system finish route reconfiguration before we attach
            audioRebuildQueue.asyncAfter(deadline: .now() + 0.5) { [weak self] in
                guard let self, self.isTracking else { return }
                self.buildAndStartAudioEngine()
            }
        default:
            break
        }
    }

    // MARK: - Stage Flushing

    @MainActor
    private func flushStages() {
        guard let session = activeSession else { return }
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
        if isTracking { scheduleBackgroundTask() }
    }

    // MARK: - Awake State Recording

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
                    Unmanaged<SleepTrackerService>.fromOpaque(observer).takeUnretainedValue().updateLockState()
                }
            },
            name, nil, .deliverImmediately
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
        if state != 0 { phoneAwakeDetector.onScreenOff() } else { phoneAwakeDetector.onScreenOn() }
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
            Task { @MainActor in self?.flushStages(); task.setTaskCompleted(success: true) }
        }
        Task { @MainActor in self.flushStages(); task.setTaskCompleted(success: true) }
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
        let median: Float = sorted.count % 2 == 1
            ? sorted[sorted.count / 2]
            : (sorted[sorted.count / 2 - 1] + sorted[sorted.count / 2]) / 2.0
        return abs(f - median)
    }
}
