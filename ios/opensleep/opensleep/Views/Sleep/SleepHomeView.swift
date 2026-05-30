import SwiftUI
import SwiftData

struct SleepHomeView: View {
    @ObservedObject var tracker: SleepTrackerService
    @ObservedObject var healthKit: HealthKitManager

    @State private var elapsedSeconds: Int = 0
    @State private var timer: Timer?

    private var isSleeping: Bool { tracker.isTracking }

    var body: some View {
        ZStack {
            Color.navyDeep.ignoresSafeArea()

            ScrollView {
                VStack(spacing: 32) {
                    // Header
                    VStack(spacing: 6) {
                        Text("OpenSleep")
                            .font(.system(size: 28, weight: .bold, design: .rounded))
                            .foregroundStyle(Color.indigoLight)
                        Text(isSleeping ? "tracking_active" : "tracking_idle")
                            .font(AppTextStyle.bodyMedium)
                            .foregroundStyle(Color.textSecondary)
                    }
                    .padding(.top, 16)

                    // Main sleep button
                    SleepButton(isSleeping: isSleeping) {
                        if isSleeping { stopSleep() }
                        else { startSleep() }
                    }

                    // Elapsed timer
                    if isSleeping {
                        GlassCard {
                            VStack(spacing: 4) {
                                let h = elapsedSeconds / 3600
                                let m = (elapsedSeconds % 3600) / 60
                                let s = elapsedSeconds % 60
                                Text(String(format: "%02d:%02d:%02d", h, m, s))
                                    .font(.system(size: 48, weight: .light, design: .monospaced))
                                    .foregroundStyle(Color.indigoLight)
                                Text("time_asleep")
                                    .font(AppTextStyle.bodyMedium)
                                    .foregroundStyle(Color.textSecondary)
                            }
                            .frame(maxWidth: .infinity)
                        }
                        .padding(.horizontal, 16)
                    }

                    // Live stage ring
                    if let session = tracker.activeSession {
                        let durations = session.stageDurations
                        if durations.values.reduce(0, +) > 0 {
                            GlassCard {
                                VStack(alignment: .leading, spacing: 16) {
                                    Text("live_stages")
                                        .font(AppTextStyle.titleLarge)
                                        .foregroundStyle(Color.textPrimary)
                                    SleepRingChart(stageDurations: durations)
                                        .frame(width: 160, height: 160)
                                        .frame(maxWidth: .infinity)
                                    SleepStageLegend(stageDurations: durations)
                                }
                            }
                            .padding(.horizontal, 16)
                        }
                    }

                    Spacer(minLength: 32)
                }
            }
        }
        .onAppear { updateTimer() }
        .onDisappear { timer?.invalidate() }
    }

    private func startSleep() {
        Task {
            await healthKit.requestAuthorization()
        }
        tracker.startTracking()
        elapsedSeconds = 0
        updateTimer()
    }

    private func stopSleep() {
        tracker.stopTracking()
        timer?.invalidate()
        timer = nil

        // Write to HealthKit after stopping
        Task {
            if let session = tracker.activeSession {
                await healthKit.writeSleepSession(session)
            }
        }
    }

    private func updateTimer() {
        timer?.invalidate()
        guard isSleeping else { return }
        if let start = tracker.activeSession?.startDate {
            elapsedSeconds = Int(Date().timeIntervalSince(start))
        }
        timer = Timer.scheduledTimer(withTimeInterval: 1, repeats: true) { _ in
            Task { @MainActor in
                if let start = tracker.activeSession?.startDate {
                    elapsedSeconds = Int(Date().timeIntervalSince(start))
                }
            }
        }
    }
}

// MARK: - Sleep Button

struct SleepButton: View {
    let isSleeping: Bool
    let action: () -> Void

    @State private var pulseScale: CGFloat = 1.0

    var body: some View {
        ZStack {
            // Glow ring
            if isSleeping {
                Circle()
                    .fill(
                        RadialGradient(
                            colors: [Color.indigoAccent.opacity(0.4), .clear],
                            center: .center, startRadius: 0, endRadius: 100
                        )
                    )
                    .frame(width: 220, height: 220)
                    .scaleEffect(pulseScale)
                    .animation(
                        .easeInOut(duration: 2).repeatForever(autoreverses: true),
                        value: pulseScale
                    )
                    .onAppear { pulseScale = 1.15 }
                    .onDisappear { pulseScale = 1.0 }
            }

            Button(action: action) {
                ZStack {
                    Circle()
                        .fill(isSleeping
                              ? Color(red: 0.12, green: 0.11, blue: 0.29)
                              : Color.indigoAccent)
                        .frame(width: 160, height: 160)
                        .shadow(color: Color.indigoAccent.opacity(0.5), radius: isSleeping ? 20 : 8)

                    VStack(spacing: 8) {
                        Image(systemName: isSleeping ? "stop.fill" : "moon.fill")
                            .font(.system(size: 40, weight: .medium))
                            .foregroundStyle(.white)
                        Text(isSleeping ? "stop_sleep" : "start_sleep")
                            .font(AppTextStyle.labelLarge)
                            .foregroundStyle(.white)
                    }
                }
            }
            .buttonStyle(.plain)
            .scaleEffect(isSleeping ? pulseScale * 0.95 : 1.0)
        }
    }
}
