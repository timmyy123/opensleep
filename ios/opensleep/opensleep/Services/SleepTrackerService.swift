import Foundation
import Combine
import CoreMotion
import BackgroundTasks
import SwiftData
import AVFoundation
import UIKit


/// Manages sleep tracking: starts/stops CMMotionManager, runs stage analysis,
/// persists results to SwiftData via MainActor. Uses BGProcessingTask to
/// extend background runtime.
///
/// Audio route changes can alter AVAudioEngine's input format. Rebuild the engine
/// when that happens rather than leaving a tap installed with a stale format.
class SleepTrackerService: ObservableObject {

    static let bgTaskId = "app.opensleep.sleepanalysis"

    @MainActor @Published var isTracking = false
    @MainActor @Published var activeSession: SleepSession?

    private let motionManager = CMMotionManager()
    private let analyzer = SleepStageAnalyzer()
    private var modelContext: ModelContext?

    // Audio engine is recreated on every route change to avoid stale-format crashes
    private var audioEngine: AVAudioEngine?
    private var sourceNode: AVAudioSourceNode?
    private var chirpProducer = ChirpProducer(sampleRate: 48000)

    // Sonar processing state — recreated with correct sample rate on each engine build
    private var fftSonar = FftSonarConsumer(sampleRate: 48000)
    private var activityAggregator = LowLevelActivityAggregator(sampleRate: 48000)

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
    private var lastAwakeRecordTime: Date = Date.distantPast
    private var didEnterBackgroundObserver: AnyObject?
    private var willEnterForegroundObserver: AnyObject?

    // Sample at ~4 Hz
    private let sampleInterval: TimeInterval = 0.25
    private var stageFlushTimer: DispatchSourceTimer?


    private var lastSonarSampleTime = Date.distantPast
    private var isAudioRunning = false
    private let audioRebuildQueue = DispatchQueue(label: "tech.opensleep.audioRebuild", qos: .userInitiated)
    private var audioChunkBuffer: [Float] = []
    private let audioChunkLock = NSLock()
    private var isAudioDrainScheduled = false
    private var maxBufferedAudioSamples = 96_000
    private let sonarAnalysisChunkSize = 4_096
    private let minSonarAnalysisInterval: TimeInterval = 0.75
    private var lastAudioAnalysisEnqueueTime = Date.distantPast
    private let sonarOutputGain: Float = 0.08
    private let sonarPulseSilenceMultiplier = 5
    /// Tracks last poll time for background accelerometer fallback in drainAudioFrames.
    private var lastBackgroundAccelPollTime = Date.distantPast

    init() {
        registerBackgroundTask()
    }

    @MainActor
    func configure(modelContext: ModelContext) {
        self.modelContext = modelContext
        
        let descriptor = FetchDescriptor<SleepSession>()
        if let sessions = try? modelContext.fetch(descriptor) {
            let orphaned = sessions.filter { $0.endDate == nil }
            if !orphaned.isEmpty {
                for session in orphaned {
                    print("iOS: Found orphaned active session: \(session.id). Closing it.")
                    session.endDate = Date()
                }
                try? modelContext.save()
            }
        }
    }

    /// Explicitly request required microphone and motion permissions for tracking
    func requestPermissions() {
        AVAudioApplication.requestRecordPermission { granted in
            print("Microphone permission granted: \(granted)")
        }
    }

    private var accelSampleCount = 0
    private var gyroSampleCount = 0

    @MainActor
    func startTracking() {
        print("[SleepTracker] SleepTrackerService.startTracking() called. isTracking=\(isTracking)")
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
            try session.setCategory(.playAndRecord, mode: .measurement, options: [.mixWithOthers, .allowBluetoothHFP, .defaultToSpeaker])
            try session.setActive(true)
            print("[SleepTracker] AVAudioSession activated successfully.")
        } catch {
            print("[SleepTracker] iOS: Failed to configure audio session: \(error)")
        }

        let session = SleepSession(startDate: Date())
        modelContext?.insert(session)
        try? modelContext?.save()
        activeSession = session
        print("[SleepTracker] Created and inserted new SleepSession: \(session.id)")

        analysisQueue.sync { [weak self] in
            self?.analyzer.clear()
            self?.activeAwakeIntervalStart = nil
            self?.lastAwakeRecordTime = Date.distantPast
            self?.audioChunkLock.lock()
            self?.audioChunkBuffer.removeAll()
            self?.isAudioDrainScheduled = false
            self?.lastAudioAnalysisEnqueueTime = .distantPast
            self?.audioChunkLock.unlock()
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
            self.accelSampleCount += 1
            if self.accelSampleCount % 120 == 0 {
                print("[SleepTracker] iOS Accelerometer count=\(self.accelSampleCount), sample: x=\(x), y=\(y), z=\(z), mag=\(mag)")
            }
            self.analysisQueue.async {
                self.analyzer.addSample(timestamp: Date(), x: data.acceleration.x, y: data.acceleration.y, z: data.acceleration.z)
            }
        }

        if motionManager.isGyroAvailable {
            motionManager.gyroUpdateInterval = sampleInterval
            motionManager.startGyroUpdates(to: queue) { [weak self] data, _ in
                guard let self, let data else { return }
                self.gyroSampleCount += 1
                if self.gyroSampleCount % 120 == 0 {
                    print("[SleepTracker] iOS Gyroscope count=\(self.gyroSampleCount), sample: x=\(data.rotationRate.x), y=\(data.rotationRate.y), z=\(data.rotationRate.z)")
                }
                self.analysisQueue.async {
                    self.analyzer.addGyroSample(timestamp: Date(), x: data.rotationRate.x, y: data.rotationRate.y, z: data.rotationRate.z)
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

        // Listen for audio route changes (headphones, Bluetooth, USB audio, etc.).
        // When the audio route changes the inputNode format changes — we MUST
        // tear down and rebuild the engine or it crashes with a stale-format exception.
        routeChangeObserver = NotificationCenter.default.addObserver(
            forName: AVAudioSession.routeChangeNotification,
            object: nil,
            queue: nil
        ) { [weak self] notification in
            self?.handleAudioRouteChange(notification)
        }

        // Register for UIApplication lifecycle notifications to detect screen lock/unlock
        didEnterBackgroundObserver = NotificationCenter.default.addObserver(
            forName: UIApplication.didEnterBackgroundNotification,
            object: nil,
            queue: nil
        ) { [weak self] _ in
            self?.phoneAwakeDetector.onScreenOff()
        }
        willEnterForegroundObserver = NotificationCenter.default.addObserver(
            forName: UIApplication.willEnterForegroundNotification,
            object: nil,
            queue: nil
        ) { [weak self] _ in
            self?.phoneAwakeDetector.onScreenOn()
        }
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

        // 5-minute stage flush to SwiftData (reduced from 1 minute to avoid watchdog timeout)
        let flush = DispatchSource.makeTimerSource(queue: analysisQueue)
        flush.schedule(deadline: .now() + 300, repeating: 300)
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
        print("[SleepTracker] SleepTrackerService.stopTracking() called. isTracking=\(isTracking)")
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

        if let obs = didEnterBackgroundObserver { NotificationCenter.default.removeObserver(obs); didEnterBackgroundObserver = nil }
        if let obs = willEnterForegroundObserver { NotificationCenter.default.removeObserver(obs); willEnterForegroundObserver = nil }

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
        let capturedSession = self.activeSession
        print("[SleepTracker] Computing final stages for session: \(session.id)")
        analysisQueue.async {
            do {
                let stages = analyzer.computeStages(sleepStart: startDate)
                DispatchQueue.main.async {
                    if let active = capturedSession {
                        active.stages = stages
                        try? modelContext?.save()
                        print("[SleepTracker] iOS: Saved \(stages.count) stages for stopped session.")
                    }
                    // Clear activeSession so the live stages card disappears
                    self.activeSession = nil
                }
            } catch {
                print("[SleepTracker] ERROR: Failed to compute final stages: \(error)")
                DispatchQueue.main.async {
                    self.activeSession = nil
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
                print("[SleepTracker] iOS: Invalid input format, skipping audio engine start.")
                return
            }

            // KEY FIX FOR REM: Recreate sonar components with the ACTUAL sample rate
            // from the current audio route. If we used hardcoded 48000 but iOS picked
            // 44100, the 20kHz chirp FFT bins would point at wrong frequencies →
            // sonar always detects zero movement → all frames = deepSleep → 0m REM.
            let actualRate = Int(recordingFormat.sampleRate)
            self.chirpProducer = ChirpProducer(sampleRate: actualRate)
            self.analysisQueue.sync {
                self.fftSonar = FftSonarConsumer(sampleRate: actualRate)
                self.activityAggregator = LowLevelActivityAggregator(sampleRate: actualRate)
                self.audioChunkLock.lock()
                self.audioChunkBuffer.removeAll(keepingCapacity: true)
                self.maxBufferedAudioSamples = actualRate
                self.lastAudioAnalysisEnqueueTime = .distantPast
                self.audioChunkLock.unlock()
            }
            print("[SleepTracker] iOS: Audio engine using sample rate \(actualRate) Hz")

            inputNode.installTap(onBus: 0, bufferSize: AVAudioFrameCount(self.sonarAnalysisChunkSize), format: recordingFormat) { [weak self] buffer, _ in
                guard let self = self else { return }
                guard let channelData = buffer.floatChannelData?[0] else { return }
                let now = Date()
                var shouldAnalyze = false
                self.audioChunkLock.lock()
                if now.timeIntervalSince(self.lastAudioAnalysisEnqueueTime) >= self.minSonarAnalysisInterval {
                    self.lastAudioAnalysisEnqueueTime = now
                    shouldAnalyze = true
                }
                self.audioChunkLock.unlock()
                guard shouldAnalyze else { return }
                let frames = Array(UnsafeBufferPointer(start: channelData, count: Int(buffer.frameLength)))
                self.enqueueAudioFrames(frames)
            }

            // Playback using AVAudioSourceNode on the same engine. The sonar pulse is
            // deliberately low-gain and duty-cycled; continuous full-scale ultrasound
            // is expensive and can push iOS into thermal/jetsam kills during long runs.
            let chirpData = self.chirpProducer.chirpData
            var chirpIndex = 0
            var pulseFrameIndex = 0
            let chirpFrameCount = chirpData.count
            let pulseCycleFrameCount = chirpFrameCount * (1 + self.sonarPulseSilenceMultiplier)
            let gain = self.sonarOutputGain
            let sourceNode = AVAudioSourceNode { (_, _, frameCount, audioBufferList) -> OSStatus in
                let abl = UnsafeMutableAudioBufferListPointer(audioBufferList)
                for buffer in abl {
                    if let ptr = buffer.mData?.assumingMemoryBound(to: Float.self) {
                        for frame in 0..<Int(frameCount) {
                            if pulseFrameIndex < chirpFrameCount {
                                ptr[frame] = chirpData[chirpIndex] * gain
                                chirpIndex = (chirpIndex + 1) % chirpFrameCount
                            } else {
                                ptr[frame] = 0
                            }
                            pulseFrameIndex = (pulseFrameIndex + 1) % pulseCycleFrameCount
                        }
                    }
                }
                return noErr
            }
            self.sourceNode = sourceNode
            engine.attach(sourceNode)

            guard let playFormat = AVAudioFormat(standardFormatWithSampleRate: Double(actualRate), channels: 1) else {
                print("[SleepTracker] Failed to create play format")
                return
            }
            engine.connect(sourceNode, to: engine.mainMixerNode, format: playFormat)

            do {
                try AVAudioSession.sharedInstance().setActive(true)
                try engine.start()
                self.isAudioRunning = true
                print("[SleepTracker] iOS: Audio engine started with format: \(recordingFormat)")
            } catch {
                print("[SleepTracker] iOS: Failed to start audio engine: \(error)")
                inputNode.removeTap(onBus: 0)
                if let node = self.sourceNode {
                    engine.detach(node)
                }
                self.sourceNode = nil
                self.audioEngine = nil
            }
        }
    }

    /// Tears down the current audio engine safely. Must be called before rebuilding.
    private func teardownAudioEngine() {
        if let engine = audioEngine {
            engine.inputNode.removeTap(onBus: 0)
            if let node = sourceNode {
                engine.detach(node)
            }
            engine.stop()
        }
        sourceNode = nil
        audioEngine = nil
        isAudioRunning = false
    }

    /// Adds microphone samples with backpressure. At most one drain closure can be
    /// queued, so slow FFT work cannot create an unbounded chain of retained arrays.
    private func enqueueAudioFrames(_ frames: [Float]) {
        var shouldScheduleDrain = false
        audioChunkLock.lock()
        audioChunkBuffer.append(contentsOf: frames)
        if audioChunkBuffer.count > maxBufferedAudioSamples {
            audioChunkBuffer.removeFirst(audioChunkBuffer.count - maxBufferedAudioSamples)
        }
        if !isAudioDrainScheduled {
            isAudioDrainScheduled = true
            shouldScheduleDrain = true
        }
        audioChunkLock.unlock()

        if shouldScheduleDrain {
            analysisQueue.async { [weak self] in self?.drainAudioFrames() }
        }
    }

    private func drainAudioFrames() {
        // Yield after a small batch so motion, awake-state, and persistence work on
        // the same serial queue cannot be starved by a continuous audio stream.
        for _ in 0..<4 {
            // ── Background accelerometer poll ─────────────────────────────────────────
            // iOS throttles CMMotionManager push-callbacks when the app is backgrounded,
            // often delivering far fewer samples than the requested 4 Hz. The audio
            // engine IS kept alive by AVAudioSession, so we piggyback here to collect
            // accelerometer data at ~4 Hz regardless of foreground/background state.
            let pollNow = Date()
            if pollNow.timeIntervalSince(lastBackgroundAccelPollTime) >= 0.25,
               let accelData = motionManager.accelerometerData {
                // Convert CMTimeInterval (seconds since boot) to wall-clock Date
                let bootOffset = ProcessInfo.processInfo.systemUptime - accelData.timestamp
                let accelDate = Date(timeIntervalSinceNow: -bootOffset)
                analyzer.addSample(
                    timestamp: accelDate,
                    x: accelData.acceleration.x,
                    y: accelData.acceleration.y,
                    z: accelData.acceleration.z
                )
                lastBackgroundAccelPollTime = pollNow
            }

            audioChunkLock.lock()
            guard audioChunkBuffer.count >= sonarAnalysisChunkSize else {
                isAudioDrainScheduled = false
                audioChunkLock.unlock()
                return
            }
            let chunk = Array(audioChunkBuffer.prefix(sonarAnalysisChunkSize))
            audioChunkBuffer.removeFirst(sonarAnalysisChunkSize)
            audioChunkLock.unlock()

            let consumerRes = fftSonar.processAndGetResult(chunk)
            let activityResult = activityAggregator.update(consumerRes.activity)
            if activityResult.isHighActivity {
                print("[SleepTracker] Sonar detected high activity (\(consumerRes.activity)) -> recording awake state.")
                recordAwakeState(now: Date(), awake: true, lookback: 10.0)
            }

            let now = Date()
            if now.timeIntervalSince(lastSonarSampleTime) >= 10.0 {
                let act = activityAggregator.getAggregatedActivity()
                print("[SleepTracker] Sonar sample added: activity=\(act) at \(now)")
                analyzer.addSonarSample(timestamp: now, activity: act)
                NotificationCenter.default.post(
                    name: NSNotification.Name("action_raw_activity"),
                    object: nil,
                    userInfo: ["sensor": "SONAR", "data": act]
                )
                lastSonarSampleTime = now
            }
        }

        analysisQueue.async { [weak self] in self?.drainAudioFrames() }
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

    /// Handles audio route changes such as headphones, Bluetooth, or USB audio.
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
        
        // Dispatch to background queue to avoid blocking main thread
        analysisQueue.async {
            do {
                let startTime = Date()
                let stages = analyzer.computeStages(sleepStart: startDate)
                let elapsed = Date().timeIntervalSince(startTime)
                
                // Log if computation took too long (>5 seconds is concerning)
                if elapsed > 5.0 {
                    print("[SleepTracker] WARNING: Stage computation took \(String(format: "%.2f", elapsed))s")
                }
                
                DispatchQueue.main.async {
                    if let active = activeSession {
                        active.stages = stages
                        try? modelContext?.save()
                    }
                }
            } catch {
                print("[SleepTracker] ERROR: Failed to compute stages: \(error)")
            }
        }
        if isTracking { scheduleBackgroundTask() }
    }

    // MARK: - Awake State Recording

    private func recordAwakeState(now: Date, awake: Bool, lookback: TimeInterval = 0) {
        print("[SleepTracker] recordAwakeState: now=\(now), awake=\(awake), lookback=\(lookback). Current activeAwakeIntervalStart=\(String(describing: activeAwakeIntervalStart))")
        if awake {
            // Debounce: only record awake state once per second max to avoid memory explosion
            let timeSinceLastRecord = now.timeIntervalSince(lastAwakeRecordTime)
            guard timeSinceLastRecord >= 1.0 else {
                return
            }
            lastAwakeRecordTime = now
            let start = activeAwakeIntervalStart ?? now.addingTimeInterval(-lookback)
            activeAwakeIntervalStart = start
            print("[SleepTracker]   Adding awake interval start=\(start), end=\(now)")
            analyzer.addAwakeInterval(start: start, end: now)
        } else {
            if let start = activeAwakeIntervalStart, now > start {
                print("[SleepTracker]   Closing awake interval: start=\(start), end=\(now)")
                analyzer.addAwakeInterval(start: start, end: now)
            }
            activeAwakeIntervalStart = nil
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
        print("[SleepTracker] handleBackgroundTask() called.")
        scheduleBackgroundTask()
        
        // Set expiration handler with 20 second buffer before OS kills us
        task.expirationHandler = { [weak self] in
            print("[SleepTracker] handleBackgroundTask expired, flushing stages...")
            Task { @MainActor in 
                self?.flushStages()
                task.setTaskCompleted(success: true) 
            }
        }
        
        // Perform stage flush with timeout
        Task { @MainActor in
            print("[SleepTracker] handleBackgroundTask: starting stage computation (timeout: 20s)")
            let startTime = Date()
            self.flushStages()
            let elapsed = Date().timeIntervalSince(startTime)
            print("[SleepTracker] handleBackgroundTask finished stage flushing in \(String(format: "%.2f", elapsed))s.")
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
        let median: Float = sorted.count % 2 == 1
            ? sorted[sorted.count / 2]
            : (sorted[sorted.count / 2 - 1] + sorted[sorted.count / 2]) / 2.0
        return abs(f - median)
    }
}
