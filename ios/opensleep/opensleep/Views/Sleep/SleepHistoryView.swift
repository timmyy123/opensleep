import SwiftUI
import SwiftData

struct SleepHistoryView: View {
    @Query(sort: \SleepSession.startDate, order: .reverse) var sessions: [SleepSession]
    @Environment(\.modelContext) private var modelContext
    @EnvironmentObject private var healthKit: HealthKitManager
    @State private var selectedSession: SleepSession?
    @State private var sessionToDelete: SleepSession?

    var body: some View {
        NavigationStack {
            ZStack {
                Color.navyDeep.ignoresSafeArea()

                if sessions.filter(\.isCompleted).isEmpty {
                    VStack(spacing: 16) {
                        Image(systemName: "moon.zzz.fill")
                            .font(.system(size: 60))
                            .foregroundStyle(Color.indigoAccent.opacity(0.4))
                        Text("no_sessions")
                            .font(AppTextStyle.bodyLarge)
                            .foregroundStyle(Color.textTertiary)
                            .multilineTextAlignment(.center)
                    }
                } else {
                    ScrollView {
                        LazyVStack(spacing: 12) {
                            ForEach(sessions.filter(\.isCompleted)) { session in
                                SessionCard(session: session) {
                                    sessionToDelete = session
                                }
                                .onTapGesture { selectedSession = session }
                            }
                            Spacer(minLength: 80)
                        }
                        .padding(.horizontal, 16)
                        .padding(.top, 8)
                    }
                }
            }
            .navigationTitle("history_title")
            .navigationBarTitleDisplayMode(.large)
            .toolbarColorScheme(.dark, for: .navigationBar)
            .sheet(item: $selectedSession) { session in
                SleepDetailView(session: session)
            }
            .alert(Text("delete_session_title"), isPresented: Binding(
                get: { sessionToDelete != nil },
                set: { if !$0 { sessionToDelete = nil } }
            )) {
                Button("delete_confirm", role: .destructive) {
                    if let session = sessionToDelete {
                        Task {
                            let _ = await healthKit.deleteSleepSession(session)
                            modelContext.delete(session)
                            try? modelContext.save()
                        }
                    }
                    sessionToDelete = nil
                }
                Button("cancel", role: .cancel) {
                    sessionToDelete = nil
                }
            } message: {
                Text("delete_session_message")
            }
        }
    }
}


struct SessionCard: View {
    let session: SleepSession
    let onDelete: () -> Void

    private var durationText: String {
        let h = Int(session.durationSeconds / 3600)
        let m = Int((session.durationSeconds.truncatingRemainder(dividingBy: 3600)) / 60)
        return "\(h)h \(m)m"
    }

    var body: some View {
        GlassCard(padding: 16) {
            VStack(alignment: .leading, spacing: 12) {
                HStack {
                    VStack(alignment: .leading, spacing: 4) {
                        Text(session.startDate, format: .dateTime.weekday(.wide).month().day())
                            .font(AppTextStyle.bodyMedium)
                            .foregroundStyle(Color.textSecondary)
                        Text(durationText)
                            .font(.system(size: 28, weight: .semibold, design: .rounded))
                            .foregroundStyle(Color.textPrimary)
                    }
                    Spacer()
                    
                    HStack(spacing: 16) {
                        Button(action: onDelete) {
                            Image(systemName: "trash")
                                .font(.system(size: 18))
                                .foregroundStyle(Color.red.opacity(0.8))
                        }
                        
                        Image(systemName: "chevron.right")
                            .foregroundStyle(Color.textTertiary)
                    }
                }

                // Mini hypnogram
                SleepHypnogram(
                    stages: session.stages,
                    totalDuration: session.durationSeconds
                )

                SleepStageLegend(stageDurations: session.stageDurations)
            }
        }
    }
}
