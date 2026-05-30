import SwiftUI
import SwiftData

struct SleepHistoryView: View {
    @Query(sort: \SleepSession.startDate, order: .reverse) var sessions: [SleepSession]
    @Environment(\.modelContext) private var modelContext
    @State private var selectedSession: SleepSession?

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
                                SessionCard(session: session)
                                    .onTapGesture { selectedSession = session }
                                    .contextMenu {
                                        Button(role: .destructive) {
                                            modelContext.delete(session)
                                            try? modelContext.save()
                                        } label: {
                                            Label("Delete", systemImage: "trash")
                                        }
                                    }
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
        }
    }
}

struct SessionCard: View {
    let session: SleepSession

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
                    Image(systemName: "chevron.right")
                        .foregroundStyle(Color.textTertiary)
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
