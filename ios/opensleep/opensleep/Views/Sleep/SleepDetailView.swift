import SwiftUI

struct SleepDetailView: View {
    let session: SleepSession
    @Environment(\.dismiss) var dismiss

    private var durationText: String {
        let h = Int(session.durationSeconds / 3600)
        let m = Int((session.durationSeconds.truncatingRemainder(dividingBy: 3600)) / 60)
        return "\(h)h \(m)m"
    }

    var body: some View {
        ZStack {
            Color.navyDeep.ignoresSafeArea()

            ScrollView {
                VStack(spacing: 20) {
                    // Header bar
                    HStack {
                        Text(session.startDate, format: .dateTime.weekday(.wide).month(.wide).day())
                            .font(.system(size: 20, weight: .semibold))
                            .foregroundStyle(Color.textPrimary)
                        Spacer()
                        Button { dismiss() } label: {
                            Image(systemName: "xmark.circle.fill")
                                .font(.system(size: 24))
                                .foregroundStyle(Color.textSecondary)
                        }
                    }
                    .padding(.horizontal, 20)
                    .padding(.top, 24)

                    // Summary strip
                    GlassCard(padding: 20) {
                        HStack {
                            StatPill(
                                label: "bedtime",
                                value: session.startDate.formatted(date: .omitted, time: .shortened)
                            )
                            Divider().background(Color.textTertiary).frame(height: 40)
                            StatPill(
                                label: "wake_up",
                                value: (session.endDate ?? Date()).formatted(date: .omitted, time: .shortened)
                            )
                            Divider().background(Color.textTertiary).frame(height: 40)
                            StatPill(label: "duration", value: durationText)
                        }
                    }
                    .padding(.horizontal, 16)

                    // Donut ring
                    GlassCard {
                        VStack(spacing: 16) {
                            Text("sleep_stages")
                                .font(AppTextStyle.titleLarge)
                                .foregroundStyle(Color.textPrimary)
                                .frame(maxWidth: .infinity, alignment: .leading)

                            SleepRingChart(stageDurations: session.stageDurations)
                                .frame(width: 200, height: 200)
                                .frame(maxWidth: .infinity)

                            SleepStageLegend(stageDurations: session.stageDurations)
                        }
                    }
                    .padding(.horizontal, 16)

                    // Hypnogram
                    GlassCard {
                        VStack(alignment: .leading, spacing: 12) {
                            Text("sleep_pattern")
                                .font(AppTextStyle.titleLarge)
                                .foregroundStyle(Color.textPrimary)
                            Text("hypnogram_legend")
                                .font(AppTextStyle.labelSmall)
                                .foregroundStyle(Color.textTertiary)

                            SleepHypnogram(
                                stages: session.stages,
                                totalDuration: session.durationSeconds
                            )
                        }
                    }
                    .padding(.horizontal, 16)

                    Spacer(minLength: 32)
                }
            }
        }
    }
}

private struct StatPill: View {
    let label: LocalizedStringKey
    let value: String
    var body: some View {
        VStack(spacing: 4) {
            Text(label)
                .font(AppTextStyle.labelSmall)
                .foregroundStyle(Color.textSecondary)
            Text(value)
                .font(.system(size: 16, weight: .semibold))
                .foregroundStyle(Color.textPrimary)
        }
        .frame(maxWidth: .infinity)
    }
}
