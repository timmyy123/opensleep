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

    // Sample at ~4 Hz
    private let sampleInterval: TimeInterval = 0.25
    private var stageFlushTimer: Timer?

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

        // Flush stages every 5 minutes
        stageFlushTimer = Timer.scheduledTimer(withTimeInterval: 5 * 60, repeats: true) { [weak self] _ in
            Task { @MainActor in self?.flushStages() }
        }
    }

    @MainActor
    func stopTracking() {
        guard isTracking else { return }
        motionManager.stopAccelerometerUpdates()
        stageFlushTimer?.invalidate()
        stageFlushTimer = nil
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
    }
}
