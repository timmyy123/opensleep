import Foundation
import Combine
import CoreMotion
import BackgroundTasks
import SwiftData
import AVFoundation
import SoundAnalysis

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
    private var streamAnalyzer: SNAudioStreamAnalyzer?
    private var resultsObserver: ResultsObserver?
    private let analysisQueue = DispatchQueue(label: "tech.opensleep.analysisQueue", qos: .default)
    private var lastAudioLevelTime: Date = Date.distantPast
    private var motionOpQueue: OperationQueue?
    private var interruptionObserver: AnyObject?

    // Sample at ~4 Hz
    private let sampleInterval: TimeInterval = 0.25
    private var stageFlushTimer: Timer?

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
            try audioSession.setActive(true)
        } catch {
            print("Failed to configure background audio session: \(error)")
        }

        let session = SleepSession(startDate: Date())
        modelContext?.insert(session)
        try? modelContext?.save()
        activeSession = session

        analysisQueue.async { [weak self] in
            self?.analyzer.clear()
        }
        isTracking = true

        let queue = OperationQueue()
        queue.name = "app.opensleep.motionQueue"
        queue.maxConcurrentOperationCount = 1
        motionOpQueue = queue

        motionManager.accelerometerUpdateInterval = sampleInterval
        motionManager.startAccelerometerUpdates(to: queue) { [weak self] data, _ in
            guard let self, let data else { return }
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

        resultsObserver = ResultsObserver { [weak self] identifier, confidence in
            guard let self = self else { return }
            if confidence > 0.15, let event = self.mapIdentifierToEvent(identifier) {
                self.analysisQueue.async {
                    self.analyzer.addAudioEvent(timestamp: Date(), eventName: event, confidence: confidence)
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
        
        startAudioMetering()
        scheduleBackgroundTask()

        // Flush stages every 5 minutes
        stageFlushTimer = Timer.scheduledTimer(withTimeInterval: 5 * 60, repeats: true) { [weak self] _ in
            guard let self = self else { return }
            Task { @MainActor in
                self.flushStages()
            }
        }
    }

    @MainActor
    func stopTracking() {
        guard isTracking else { return }
        motionManager.stopAccelerometerUpdates()
        motionManager.stopGyroUpdates()
        motionOpQueue = nil
        stageFlushTimer?.invalidate()
        stageFlushTimer = nil
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
        
        let startDate = session.startDate
        analysisQueue.async { [weak self] in
            guard let self = self else { return }
            let stages = self.analyzer.computeStages(sleepStart: startDate)
            DispatchQueue.main.async {
                if let active = self.activeSession {
                    active.stages = stages
                    try? self.modelContext?.save()
                }
            }
        }
    }

    @MainActor
    private func flushStages() {
        guard let session = activeSession else { return }
        let startDate = session.startDate
        analysisQueue.async { [weak self] in
            guard let self = self else { return }
            let stages = self.analyzer.computeStages(sleepStart: startDate)
            DispatchQueue.main.async {
                if let active = self.activeSession {
                    active.stages = stages
                    try? self.modelContext?.save()
                }
            }
        }
        if isTracking {
            scheduleBackgroundTask()
        }
    }

    private func mapIdentifierToEvent(_ identifier: String) -> String? {
        let lower = identifier.lowercased()
        if lower.contains("speech") || lower.contains("talk") || lower.contains("whisper") || lower.contains("convers") {
            return "speech"
        }
        if lower.contains("laughter") || lower.contains("giggle") || lower.contains("chuckle") {
            return "laughter"
        }
        if lower.contains("sigh") {
            return "sigh"
        }
        if lower.contains("breathing") {
            return "breathing"
        }
        if lower.contains("snore") || lower.contains("snoring") {
            return "snoring"
        }
        if lower.contains("gasp") {
            return "gasp"
        }
        if lower.contains("snort") {
            return "snort"
        }
        if lower.contains("cough") || lower.contains("throat_clearing") || lower.contains("throat clearing") {
            return "cough"
        }
        if lower.contains("rustl") {
            return "rustle"
        }
        if lower.contains("silence") || lower.contains("quiet") {
            return "silence"
        }
        return nil
    }

    private func startAudioMetering() {
        let inputNode = audioEngine.inputNode
        let inputFormat = inputNode.inputFormat(forBus: 0)
        
        streamAnalyzer = SNAudioStreamAnalyzer(format: inputFormat)
        
        do {
            let request = try SNClassifySoundRequest(classifierIdentifier: .version1)
            try streamAnalyzer?.add(request, withObserver: resultsObserver!)
        } catch {
            print("Failed to add SoundAnalysis request: \(error)")
        }
        
        inputNode.installTap(onBus: 0, bufferSize: 8192, format: inputFormat) { [weak self] buffer, time in
            guard let self = self else { return }
            
            // 1. Calculate RMS and DBFS for fallback
            if let channelData = buffer.floatChannelData?[0] {
                let frameLength = UInt32(buffer.frameLength)
                var sumSquares: Float = 0.0
                var clipped = false
                for i in 0..<Int(frameLength) {
                    let sample = channelData[i]
                    sumSquares += sample * sample
                    if abs(sample) > 0.98 {
                        clipped = true
                    }
                }
                let rms = sqrt(sumSquares / Float(frameLength))
                let dbfs = 20.0 * log10(max(0.000001, rms))
                
                let now = Date()
                if now.timeIntervalSince(self.lastAudioLevelTime) >= 4 {
                    self.lastAudioLevelTime = now
                    self.analysisQueue.async {
                        self.analyzer.addAudioLevel(timestamp: now, levelDbfs: Double(dbfs), clipped: clipped)
                    }
                }
            }
            
            // 2. Feed buffer to SNAudioStreamAnalyzer
            self.analysisQueue.async {
                self.streamAnalyzer?.analyze(buffer, atAudioFramePosition: time.sampleTime)
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
        streamAnalyzer = nil
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

class ResultsObserver: NSObject, SNResultsObserving {
    private let onEvent: (String, Double) -> Void

    init(onEvent: @escaping (String, Double) -> Void) {
        self.onEvent = onEvent
    }

    func request(_ request: SNRequest, didProduce result: SNResult) {
        guard let classificationResult = result as? SNClassificationResult,
              let topResult = classificationResult.classifications.first else { return }
        onEvent(topResult.identifier, topResult.confidence)
    }

    func request(_ request: SNRequest, didFailWithError error: Error) {
        print("Sound analysis request failed: \(error)")
    }
}
