import Foundation
import Combine
import CoreMotion
import BackgroundTasks
import SwiftData
import AVFoundation
import UIKit

/// Manages sleep tracking on iOS supporting both Sonar (Contactless) and
/// Accelerometer (Mattress) tracking modes, matching Sleep as Android.
class SleepTrackerService: ObservableObject {

    static let bgTaskId = "app.opensleep.sleepanalysis"
    private static let trackingModeKey = "tracking_sensor_mode"

    @MainActor @Published var isTracking = false
    @MainActor @Published var activeSession: SleepSession?
    @MainActor @Published var currentStage: SleepStageType = .light
    @MainActor @Published var trackingMode: TrackingSensorMode = .sonar

    private let motionManager = CMMotionManager()
    private let analyzer = SleepStageAnalyzer()
    private var modelContext: ModelContext?

    // Audio / Sonar components
    private var audioEngine: AVAudioEngine?
    private var audioSourceNode: AVAudioSourceNode?
    private var chirpProducer: ChirpProducer?
    private var fftSonar: FftSonarConsumer?
    private var activityAggregator: LowLevelActivityAggregator?
    private var lastSonarSampleTime = Date.distantPast
    private let audioRebuildQueue = DispatchQueue(label: "app.opensleep.audioRebuild", qos: .userInitiated)
    private var audioChunkBuffer: [Float] = []
    private let audioChunkLock = NSLock()
    private var isAudioDrainScheduled = false
    private let sonarAnalysisChunkSize = 4096
    private let minSonarInterval: TimeInterval = 0.5
    private var lastSonarEnqueueTime = Date.distantPast
    private let sonarOutputGain: Float = 0.08
    private let sonarSilenceMultiplier = 4

    private let analysisQueue = DispatchQueue(label: "app.opensleep.analysisQueue", qos: .userInitiated)
    private var motionOpQueue: OperationQueue?
    private var interruptionObserver: AnyObject?
    private var routeChangeObserver: AnyObject?

    // Awake tracking
    private var activeAwakeIntervalStart: Date?
    private var lastAwakeRecordTime: Date = Date.distantPast
    private var didEnterBackgroundObserver: AnyObject?
    private var willEnterForegroundObserver: AnyObject?

    // Timers
    private let sampleInterval: TimeInterval = 0.05 // ~20 Hz
    private var stageFlushTimer: DispatchSourceTimer?
    private var sonarPollTimer: DispatchSourceTimer?

    init() {
        if let savedMode = UserDefaults.standard.string(forKey: Self.trackingModeKey),
           let mode = TrackingSensorMode(rawValue: savedMode) {
            self.trackingMode = mode
        } else {
            self.trackingMode = .sonar
        }
        registerBackgroundTask()
    }

    @MainActor
    func setTrackingMode(_ mode: TrackingSensorMode) {
        self.trackingMode = mode
        UserDefaults.standard.set(mode.rawValue, forKey: Self.trackingModeKey)
    }

    @MainActor
    func configure(modelContext: ModelContext) {
        self.modelContext = modelContext

        let descriptor = FetchDescriptor<SleepSession>()
        if let sessions = try? modelContext.fetch(descriptor) {
            let orphaned = sessions.filter { $0.endDate == nil }
            if !orphaned.isEmpty {
                for session in orphaned {
                    print("[SleepTracker] Found orphaned active session: \(session.id). Closing it.")
                    session.endDate = Date()
                }
                try? modelContext.save()
            }
        }
    }

    /// Request required sensor permissions
    func requestPermissions() {
        AVAudioApplication.requestRecordPermission { granted in
            print("[SleepTracker] Microphone permission granted: \(granted)")
        }
        if !motionManager.isAccelerometerAvailable {
            print("[SleepTracker] WARNING: Accelerometer is not available on this device.")
        }
    }

    @MainActor
    func startTracking() {
        print("[SleepTracker] startTracking() called. mode=\(trackingMode), isTracking=\(isTracking)")
        guard !isTracking else { return }

        // Create and persist new SleepSession
        let session = SleepSession(startDate: Date())
        modelContext?.insert(session)
        try? modelContext?.save()
        activeSession = session
        currentStage = .light
        print("[SleepTracker] Created new SleepSession: \(session.id)")

        analysisQueue.sync { [weak self] in
            self?.analyzer.clear()
            self?.activeAwakeIntervalStart = nil
            self?.lastAwakeRecordTime = Date.distantPast
            self?.audioChunkLock.lock()
            self?.audioChunkBuffer.removeAll()
            self?.isAudioDrainScheduled = false
            self?.lastSonarEnqueueTime = .distantPast
            self?.audioChunkLock.unlock()
        }
        isTracking = true

        let activeMode = self.trackingMode
        if activeMode == .sonar {
            startSonarTracking()
        } else {
            startAccelerometerTracking()
        }

        setupLifecycleObservers()

        // Periodic 30-second stage flush to SwiftData
        let flush = DispatchSource.makeTimerSource(queue: analysisQueue)
        flush.schedule(deadline: .now() + 30, repeating: 30)
        flush.setEventHandler { [weak self] in
            DispatchQueue.main.async { self?.flushStages() }
        }
        flush.resume()
        stageFlushTimer = flush

        scheduleBackgroundTask()
    }

    @MainActor
    func stopTracking() {
        print("[SleepTracker] stopTracking() called. isTracking=\(isTracking)")
        guard isTracking else { return }
        isTracking = false

        // Remove observers immediately so no further audio or lifecycle events fire
        removeLifecycleObservers()

        // Close awake state
        recordAwakeState(now: Date(), awake: false)

        // Stop motion sensors and timers
        motionManager.stopAccelerometerUpdates()
        motionOpQueue = nil
        stageFlushTimer?.cancel(); stageFlushTimer = nil
        sonarPollTimer?.cancel(); sonarPollTimer = nil

        // Clear audio buffer
        audioChunkLock.lock()
        audioChunkBuffer.removeAll()
        isAudioDrainScheduled = false
        audioChunkLock.unlock()

        // Teardown audio engine and deactivate session asynchronously on the rebuild queue
        audioRebuildQueue.async { [weak self] in
            self?.teardownAudioEngine()
        }

        guard let session = activeSession else { return }
        session.endDate = Date()
        let startDate = session.startDate
        let analyzer = self.analyzer
        let modelContext = self.modelContext

        print("[SleepTracker] Computing final 4-phase stages for session: \(session.id)")
        let stages = analyzer.computeStages(sleepStart: startDate)
        session.stages = stages
        try? modelContext?.save()
        print("[SleepTracker] Saved \(stages.count) final stages to session.")

        // Sync with HealthKit if available
        Task {
            let hk = HealthKitManager()
            if hk.isAvailable {
                _ = await hk.writeSleepSession(session)
            }
        }

        activeSession = nil
    }

    // MARK: - Accelerometer Mode

    private func startAccelerometerTracking() {
        guard motionManager.isAccelerometerAvailable else {
            print("[SleepTracker] Accelerometer not available.")
            return
        }

        // Start silent audio keep-alive so iOS keeps CMMotionManager alive in background
        setupAudioSession(category: .playback, mode: .default, options: [.mixWithOthers])
        startSilentAudioEngine()

        let queue = OperationQueue()
        queue.name = "app.opensleep.motionQueue"
        queue.maxConcurrentOperationCount = 1
        motionOpQueue = queue

        motionManager.accelerometerUpdateInterval = sampleInterval
        motionManager.startAccelerometerUpdates(to: queue) { [weak self] data, _ in
            guard let self, let data else { return }
            let x = data.acceleration.x * 9.80665
            let y = data.acceleration.y * 9.80665
            let z = data.acceleration.z * 9.80665

            self.analysisQueue.async {
                self.analyzer.addSample(timestamp: Date(), x: x, y: y, z: z)
                let liveStage = self.analyzer.currentStage
                DispatchQueue.main.async {
                    if self.currentStage != liveStage {
                        self.currentStage = liveStage
                    }
                }
            }
        }
    }

    // MARK: - Sonar Mode

    private func startSonarTracking() {
        setupAudioSession(category: .playAndRecord, mode: .measurement, options: [.mixWithOthers, .allowBluetoothHFP, .defaultToSpeaker])
        buildAndStartSonarEngine()

        // Also start low-frequency accelerometer as supplementary sensor
        if motionManager.isAccelerometerAvailable {
            let queue = OperationQueue()
            queue.name = "app.opensleep.motionQueue"
            queue.maxConcurrentOperationCount = 1
            motionOpQueue = queue
            motionManager.accelerometerUpdateInterval = 0.25
            motionManager.startAccelerometerUpdates(to: queue) { [weak self] data, _ in
                guard let self, let data else { return }
                let x = data.acceleration.x * 9.80665
                let y = data.acceleration.y * 9.80665
                let z = data.acceleration.z * 9.80665
                self.analysisQueue.async {
                    self.analyzer.addSample(timestamp: Date(), x: x, y: y, z: z)
                }
            }
        }

        // 10-second sonar epoch aggregator timer
        let pollTimer = DispatchSource.makeTimerSource(queue: analysisQueue)
        pollTimer.schedule(deadline: .now() + 10.0, repeating: 10.0)
        pollTimer.setEventHandler { [weak self] in
            guard let self else { return }
            let act = self.activityAggregator?.getAggregatedActivity() ?? 0.0
            let now = Date()
            self.analyzer.addSonarSample(timestamp: now, activity: act)
            let liveStage = self.analyzer.currentStage
            DispatchQueue.main.async {
                if self.currentStage != liveStage {
                    self.currentStage = liveStage
                }
            }
        }
        pollTimer.resume()
        sonarPollTimer = pollTimer
    }

    private func buildAndStartSonarEngine() {
        audioRebuildQueue.async { [weak self] in
            guard let self, self.isTracking else {
                print("[SleepTracker] Sonar engine build aborted: tracking inactive.")
                return
            }
            self.teardownAudioEngine()
            guard self.isTracking else { return }

            let engine = AVAudioEngine()
            self.audioEngine = engine

            let inputNode = engine.inputNode
            let recordingFormat = inputNode.outputFormat(forBus: 0)
            guard recordingFormat.sampleRate > 0 else {
                print("[SleepTracker] Invalid input format, skipping sonar engine start.")
                return
            }

            let actualRate = Int(recordingFormat.sampleRate)
            self.chirpProducer = ChirpProducer(sampleRate: actualRate)
            self.fftSonar = FftSonarConsumer(sampleRate: actualRate)
            self.activityAggregator = LowLevelActivityAggregator(sampleRate: actualRate)
            print("[SleepTracker] Sonar audio engine configured at \(actualRate) Hz")

            inputNode.installTap(onBus: 0, bufferSize: AVAudioFrameCount(self.sonarAnalysisChunkSize), format: recordingFormat) { [weak self] buffer, _ in
                guard let self, self.isTracking, let channelData = buffer.floatChannelData?[0] else { return }
                let now = Date()
                var shouldAnalyze = false
                self.audioChunkLock.lock()
                if now.timeIntervalSince(self.lastSonarEnqueueTime) >= self.minSonarInterval {
                    self.lastSonarEnqueueTime = now
                    shouldAnalyze = true
                }
                self.audioChunkLock.unlock()
                guard shouldAnalyze else { return }
                let frames = Array(UnsafeBufferPointer(start: channelData, count: Int(buffer.frameLength)))
                self.enqueueAudioFrames(frames)
            }

            // Ultrasound chirp playback node
            let chirpData = self.chirpProducer?.chirpData ?? []
            var chirpIndex = 0
            var pulseFrameIndex = 0
            let chirpFrameCount = chirpData.count
            let pulseCycleFrameCount = chirpFrameCount * (1 + self.sonarSilenceMultiplier)
            let gain = self.sonarOutputGain

            let sourceNode = AVAudioSourceNode { [weak self] (_, _, frameCount, audioBufferList) -> OSStatus in
                guard let self, self.isTracking else { return noErr }
                let abl = UnsafeMutableAudioBufferListPointer(audioBufferList)
                for buffer in abl {
                    if let ptr = buffer.mData?.assumingMemoryBound(to: Float.self) {
                        for frame in 0..<Int(frameCount) {
                            if pulseFrameIndex < chirpFrameCount && chirpFrameCount > 0 {
                                ptr[frame] = chirpData[chirpIndex] * gain
                                chirpIndex = (chirpIndex + 1) % chirpFrameCount
                            } else {
                                ptr[frame] = 0.0
                            }
                            pulseFrameIndex = (pulseFrameIndex + 1) % pulseCycleFrameCount
                        }
                    }
                }
                return noErr
            }
            self.audioSourceNode = sourceNode
            engine.attach(sourceNode)

            guard let playFormat = AVAudioFormat(standardFormatWithSampleRate: Double(actualRate), channels: 1) else { return }
            engine.connect(sourceNode, to: engine.mainMixerNode, format: playFormat)

            guard self.isTracking else {
                self.teardownAudioEngine()
                return
            }

            do {
                try AVAudioSession.sharedInstance().setActive(true)
                try engine.start()
                print("[SleepTracker] Sonar audio engine started successfully.")
            } catch {
                print("[SleepTracker] Failed to start sonar audio engine: \(error)")
                self.teardownAudioEngine()
            }
        }
    }

    private func enqueueAudioFrames(_ frames: [Float]) {
        var shouldSchedule = false
        audioChunkLock.lock()
        audioChunkBuffer.append(contentsOf: frames)
        if audioChunkBuffer.count > 96000 {
            audioChunkBuffer.removeFirst(audioChunkBuffer.count - 96000)
        }
        if !isAudioDrainScheduled {
            isAudioDrainScheduled = true
            shouldSchedule = true
        }
        audioChunkLock.unlock()

        if shouldSchedule {
            analysisQueue.async { [weak self] in self?.drainAudioFrames() }
        }
    }

    private func drainAudioFrames() {
        audioChunkLock.lock()
        guard audioChunkBuffer.count >= sonarAnalysisChunkSize else {
            isAudioDrainScheduled = false
            audioChunkLock.unlock()
            return
        }
        let chunk = Array(audioChunkBuffer.prefix(sonarAnalysisChunkSize))
        audioChunkBuffer.removeFirst(sonarAnalysisChunkSize)
        audioChunkLock.unlock()

        if let consumerRes = fftSonar?.processAndGetResult(chunk) {
            let res = activityAggregator?.update(consumerRes.activity)
            if res?.isHighActivity == true {
                recordAwakeState(now: Date(), awake: true, lookback: 10.0)
            }
        }

        analysisQueue.async { [weak self] in self?.drainAudioFrames() }
    }

    // MARK: - Silent Audio (Accelerometer Background Keep-Alive)

    private func startSilentAudioEngine() {
        audioRebuildQueue.async { [weak self] in
            guard let self, self.isTracking else {
                return
            }
            self.teardownAudioEngine()
            guard self.isTracking else { return }

            let engine = AVAudioEngine()
            self.audioEngine = engine

            let sourceNode = AVAudioSourceNode { [weak self] (_, _, frameCount, audioBufferList) -> OSStatus in
                guard let self, self.isTracking else { return noErr }
                let abl = UnsafeMutableAudioBufferListPointer(audioBufferList)
                for buffer in abl {
                    if let ptr = buffer.mData?.assumingMemoryBound(to: Float.self) {
                        for frame in 0..<Int(frameCount) { ptr[frame] = 0.0 }
                    }
                }
                return noErr
            }
            self.audioSourceNode = sourceNode
            engine.attach(sourceNode)

            let format = AVAudioFormat(standardFormatWithSampleRate: 44100, channels: 1)!
            engine.connect(sourceNode, to: engine.mainMixerNode, format: format)

            guard self.isTracking else {
                self.teardownAudioEngine()
                return
            }

            do {
                try AVAudioSession.sharedInstance().setActive(true)
                try engine.start()
                print("[SleepTracker] Silent keep-alive audio engine started.")
            } catch {
                print("[SleepTracker] Failed to start silent audio: \(error)")
                self.teardownAudioEngine()
            }
        }
    }

    private func setupAudioSession(category: AVAudioSession.Category, mode: AVAudioSession.Mode, options: AVAudioSession.CategoryOptions) {
        do {
            let session = AVAudioSession.sharedInstance()
            try session.setCategory(category, mode: mode, options: options)
            try session.setActive(true)
        } catch {
            print("[SleepTracker] Failed to configure AVAudioSession: \(error)")
        }

        // Clean up any existing session observers before adding new ones
        if let obs = interruptionObserver { NotificationCenter.default.removeObserver(obs); interruptionObserver = nil }
        if let obs = routeChangeObserver { NotificationCenter.default.removeObserver(obs); routeChangeObserver = nil }

        interruptionObserver = NotificationCenter.default.addObserver(
            forName: AVAudioSession.interruptionNotification,
            object: nil,
            queue: nil
        ) { [weak self] notification in
            self?.handleAudioInterruption(notification)
        }

        routeChangeObserver = NotificationCenter.default.addObserver(
            forName: AVAudioSession.routeChangeNotification,
            object: nil,
            queue: nil
        ) { [weak self] notification in
            self?.handleAudioRouteChange(notification)
        }
    }

    private func teardownAudioEngine() {
        if let engine = audioEngine {
            if engine.isRunning {
                engine.stop()
            }
            if trackingMode == .sonar {
                engine.inputNode.removeTap(onBus: 0)
            }
            if let node = audioSourceNode {
                engine.disconnectNodeOutput(node)
                engine.detach(node)
            }
            engine.reset()
        }
        audioSourceNode = nil
        audioEngine = nil
        chirpProducer = nil
        fftSonar = nil
        activityAggregator = nil

        do {
            try AVAudioSession.sharedInstance().setActive(false, options: .notifyOthersOnDeactivation)
        } catch {
            print("[SleepTracker] Deactivating AVAudioSession: \(error)")
        }
    }

    private func handleAudioInterruption(_ notification: Notification) {
        guard let userInfo = notification.userInfo,
              let typeValue = userInfo[AVAudioSessionInterruptionTypeKey] as? UInt,
              let type = AVAudioSession.InterruptionType(rawValue: typeValue) else { return }

        if type == .ended {
            if let optionsValue = userInfo[AVAudioSessionInterruptionOptionKey] as? UInt {
                let options = AVAudioSession.InterruptionOptions(rawValue: optionsValue)
                if options.contains(.shouldResume) {
                    DispatchQueue.main.async { [weak self] in
                        guard let self, self.isTracking else { return }
                        if self.trackingMode == .sonar {
                            self.buildAndStartSonarEngine()
                        } else {
                            self.startSilentAudioEngine()
                        }
                    }
                }
            }
        }
    }

    private func handleAudioRouteChange(_ notification: Notification) {
        guard let userInfo = notification.userInfo,
              let reasonValue = userInfo[AVAudioSessionRouteChangeReasonKey] as? UInt,
              let reason = AVAudioSession.RouteChangeReason(rawValue: reasonValue) else { return }

        // Only handle hardware device changes (e.g. headphones plugged or unplugged)
        // Never handle categoryChange or routeConfigurationChange which we trigger ourselves
        guard reason == .newDeviceAvailable || reason == .oldDeviceUnavailable else { return }

        audioRebuildQueue.async { [weak self] in
            guard let self, self.isTracking else { return }
            if self.trackingMode == .sonar {
                self.buildAndStartSonarEngine()
            } else {
                self.startSilentAudioEngine()
            }
        }
    }

    // MARK: - Lifecycle & Observers

    private func setupLifecycleObservers() {
        willEnterForegroundObserver = NotificationCenter.default.addObserver(
            forName: UIApplication.willEnterForegroundNotification,
            object: nil,
            queue: nil
        ) { [weak self] _ in
            self?.analysisQueue.async {
                self?.recordAwakeState(now: Date(), awake: true)
            }
        }

        didEnterBackgroundObserver = NotificationCenter.default.addObserver(
            forName: UIApplication.didEnterBackgroundNotification,
            object: nil,
            queue: nil
        ) { [weak self] _ in
            self?.analysisQueue.async {
                self?.recordAwakeState(now: Date(), awake: false)
            }
        }
    }

    private func removeLifecycleObservers() {
        if let obs = didEnterBackgroundObserver { NotificationCenter.default.removeObserver(obs); didEnterBackgroundObserver = nil }
        if let obs = willEnterForegroundObserver { NotificationCenter.default.removeObserver(obs); willEnterForegroundObserver = nil }
        if let obs = interruptionObserver { NotificationCenter.default.removeObserver(obs); interruptionObserver = nil }
        if let obs = routeChangeObserver { NotificationCenter.default.removeObserver(obs); routeChangeObserver = nil }
    }

    // MARK: - Stage Flushing & Awake

    @MainActor
    private func flushStages() {
        guard let session = activeSession else { return }
        let startDate = session.startDate
        let analyzer = self.analyzer
        let modelContext = self.modelContext
        let capturedSession = self.activeSession

        analysisQueue.async {
            let stages = analyzer.computeStages(sleepStart: startDate)
            DispatchQueue.main.async {
                if let active = capturedSession {
                    active.stages = stages
                    try? modelContext?.save()
                }
            }
        }
        if isTracking { scheduleBackgroundTask() }
    }

    private func recordAwakeState(now: Date, awake: Bool, lookback: TimeInterval = 0) {
        if awake {
            let timeSinceLast = now.timeIntervalSince(lastAwakeRecordTime)
            guard timeSinceLast >= 1.0 else { return }
            lastAwakeRecordTime = now
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
