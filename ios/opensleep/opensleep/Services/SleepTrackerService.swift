import Foundation
import Combine
import CoreMotion
import BackgroundTasks
import SwiftData
import AVFoundation

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
    private var audioRecorder: AVAudioRecorder?
    private var audioMeterTimer: Timer?

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

        analyzer.clear()
        isTracking = true

        motionManager.accelerometerUpdateInterval = sampleInterval
        motionManager.startAccelerometerUpdates(to: .main) { [weak self] data, _ in
            guard let self, let data else { return }
            self.analyzer.addSample(
                timestamp: Date(),
                x: data.acceleration.x,
                y: data.acceleration.y,
                z: data.acceleration.z
            )
        }

        if motionManager.isGyroAvailable {
            motionManager.gyroUpdateInterval = sampleInterval
            motionManager.startGyroUpdates(to: .main) { [weak self] data, _ in
                guard let self, let data else { return }
                self.analyzer.addGyroSample(
                    timestamp: Date(),
                    x: data.rotationRate.x,
                    y: data.rotationRate.y,
                    z: data.rotationRate.z
                )
            }
        }

        startAudioMetering()
        scheduleBackgroundTask()

        // Flush stages every 5 minutes
        stageFlushTimer = Timer.scheduledTimer(withTimeInterval: 5 * 60, repeats: true) { [weak self] _ in
            Task { @MainActor in self?.flushStages() }
        }
    }

    @MainActor
    func stopTracking() {
        guard isTracking else { return }
        motionManager.stopAccelerometerUpdates()
        motionManager.stopGyroUpdates()
        stageFlushTimer?.invalidate()
        stageFlushTimer = nil
        stopAudioMetering()
        isTracking = false

        // Deactivate background audio session
        try? AVAudioSession.sharedInstance().setActive(false, options: .notifyOthersOnDeactivation)

        guard let session = activeSession else { return }
        session.endDate = Date()
        session.stages = analyzer.computeStages(sleepStart: session.startDate)
        try? modelContext?.save()

        // HealthKit sync happens in HealthKitManager on app level
    }

    @MainActor
    private func flushStages() {
        guard let session = activeSession else { return }
        session.stages = analyzer.computeStages(sleepStart: session.startDate)
        try? modelContext?.save()
        if isTracking {
            scheduleBackgroundTask()
        }
    }

    private func startAudioMetering() {
        let settings: [String: Any] = [
            AVFormatIDKey: Int(kAudioFormatAppleLossless),
            AVSampleRateKey: 8_000,
            AVNumberOfChannelsKey: 1,
            AVEncoderAudioQualityKey: AVAudioQuality.min.rawValue
        ]

        do {
            let recorder = try AVAudioRecorder(url: URL(fileURLWithPath: "/dev/null"), settings: settings)
            recorder.isMeteringEnabled = true
            recorder.record()
            audioRecorder = recorder

            audioMeterTimer?.invalidate()
            audioMeterTimer = Timer.scheduledTimer(withTimeInterval: 4, repeats: true) { [weak self] _ in
                guard let self, let recorder = self.audioRecorder else { return }
                recorder.updateMeters()
                let averagePower = Double(recorder.averagePower(forChannel: 0))
                let peakPower = Double(recorder.peakPower(forChannel: 0))
                self.analyzer.addAudioLevel(
                    timestamp: Date(),
                    levelDbfs: averagePower,
                    clipped: peakPower > -1
                )
            }
        } catch {
            print("Failed to start audio metering: \(error)")
        }
    }

    private func stopAudioMetering() {
        audioMeterTimer?.invalidate()
        audioMeterTimer = nil
        audioRecorder?.stop()
        audioRecorder = nil
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
