import SwiftUI
import SwiftData
import Charts

enum ChartTab {
    case day, week, month, year
}

struct ChartStagePoint: Identifiable {
    let id = UUID()
    let label: String
    let stage: String // Localized display name
    let hours: Double
    let type: SleepStageType
}

struct SleepHistoryView: View {
    @Query(sort: \SleepSession.startDate, order: .reverse) var sessions: [SleepSession]
    @Environment(\.modelContext) private var modelContext
    @EnvironmentObject private var healthKit: HealthKitManager
    @State private var selectedSession: SleepSession?
    
    // Multi-select and delete state
    @State private var selectedTab: ChartTab = .day
    @State private var isMultiSelectActive = false
    @State private var selectedSessionIDs = Set<UUID>()
    @State private var sessionsToDelete: [SleepSession] = []
    @State private var showDeleteAlert = false
    @AppStorage("app_language") private var selectedLanguage = "en"

    private var languageBundle: Bundle {
        if let path = Bundle.main.path(forResource: selectedLanguage, ofType: "lproj"),
           let bundle = Bundle(path: path) {
            return bundle
        }
        return Bundle.main
    }

    private func localizedString(_ key: String) -> String {
        return languageBundle.localizedString(forKey: key, value: nil, table: nil)
    }

    var body: some View {
        NavigationStack {
            Group {
                if sessions.filter(\.isCompleted).isEmpty {
                    ScrollView {
                        VStack(spacing: 16) {
                            Spacer()
                                .frame(height: 120)
                            
                            Image(systemName: "moon.zzz.fill")
                                .font(.system(size: 60))
                                .foregroundStyle(Color.indigoAccent.opacity(0.4))
                            
                            Text("no_sessions")
                                .font(AppTextStyle.bodyLarge)
                                .foregroundStyle(Color.textTertiary)
                                .multilineTextAlignment(.center)
                        }
                        .frame(maxWidth: .infinity)
                        .padding(.horizontal, 24)
                    }
                    .scrollDisabled(true)
                    .background(Color.navyDeep.ignoresSafeArea())
                } else {
                    ZStack {
                        List {
                            // Breakdown Chart
                            breakdownChart()
                                .listRowSeparator(.hidden)
                                .listRowBackground(Color.clear)
                                .listRowInsets(EdgeInsets(top: 12, leading: 16, bottom: 8, trailing: 16))
                            
                            ForEach(sessions.filter(\.isCompleted)) { session in
                                HStack(spacing: 12) {
                                    if isMultiSelectActive {
                                        Image(systemName: selectedSessionIDs.contains(session.id) ? "checkmark.circle.fill" : "circle")
                                            .font(.system(size: 22))
                                            .foregroundStyle(selectedSessionIDs.contains(session.id) ? Color.indigoAccent : Color.textTertiary)
                                            .transition(.move(edge: .leading).combined(with: .opacity))
                                    }
                                    
                                    SessionCard(session: session)
                                }
                                .listRowSeparator(.hidden)
                                .listRowBackground(Color.clear)
                                .listRowInsets(EdgeInsets(top: 4, leading: 16, bottom: 8, trailing: 16))
                                .contentShape(Rectangle())
                                .onTapGesture {
                                    if isMultiSelectActive {
                                        toggleSelection(for: session.id)
                                    } else {
                                        selectedSession = session
                                    }
                                }
                                .swipeActions(edge: .trailing, allowsFullSwipe: true) {
                                    if !isMultiSelectActive {
                                        Button(role: .destructive) {
                                            sessionsToDelete = [session]
                                            showDeleteAlert = true
                                        } label: {
                                            Label("Delete", systemImage: "trash")
                                        }
                                    }
                                }
                            }
                            
                            // Bottom padding so content is not obscured by the multi-select bar
                            Spacer()
                                .frame(height: isMultiSelectActive ? 100 : 80)
                                .listRowSeparator(.hidden)
                                .listRowBackground(Color.clear)
                        }
                        .listStyle(.plain)
                        .scrollContentBackground(.hidden)
                        
                        if isMultiSelectActive {
                            multiSelectActionBar()
                        }
                    }
                    .background(Color.navyDeep.ignoresSafeArea())
                }
            }
            .navigationTitle("history_title")
            .navigationBarTitleDisplayMode(.large)
            .toolbarColorScheme(.dark, for: .navigationBar)
            .toolbar {
                ToolbarItem(placement: .topBarTrailing) {
                    if !sessions.filter(\.isCompleted).isEmpty {
                        Button {
                            withAnimation(.spring(response: 0.3, dampingFraction: 0.7)) {
                                isMultiSelectActive.toggle()
                                if !isMultiSelectActive {
                                    selectedSessionIDs.removeAll()
                                }
                            }
                        } label: {
                            Text(isMultiSelectActive ? LocalizedStringKey("cancel") : LocalizedStringKey("Select"))
                                .font(.system(size: 16, weight: .bold))
                                .foregroundStyle(Color.indigoLight)
                        }
                    }
                }
            }
            .sheet(item: $selectedSession) { session in
                SleepDetailView(session: session)
            }
            .alert(
                "delete_session_title",
                isPresented: $showDeleteAlert
            ) {
                Button("delete_confirm", role: .destructive) {
                    let targets = sessionsToDelete
                    Task {
                        for session in targets {
                            let _ = await healthKit.deleteSleepSession(session)
                            modelContext.delete(session)
                        }
                        try? modelContext.save()
                        
                        withAnimation {
                            isMultiSelectActive = false
                            selectedSessionIDs.removeAll()
                        }
                    }
                }
                Button("cancel", role: .cancel) {
                    sessionsToDelete.removeAll()
                }
            } message: {
                Text(sessionsToDelete.count > 1 
                     ? "This will permanently delete the \(sessionsToDelete.count) selected sleep sessions and their synced health data."
                     : "delete_session_message")
            }
        }
    }

    private func toggleSelection(for id: UUID) {
        if selectedSessionIDs.contains(id) {
            selectedSessionIDs.remove(id)
        } else {
            selectedSessionIDs.insert(id)
        }
    }

    // MARK: - Stacked Sleep Stage Aggregations

    private var chartData: [ChartStagePoint] {
        let completed = sessions.filter(\.isCompleted).sorted(by: { $0.startDate < $1.startDate })
        guard !completed.isEmpty else { return [] }
        
        switch selectedTab {
        case .day:
            let last7 = completed.suffix(7)
            let df = DateFormatter()
            df.dateFormat = "E d"
            var points: [ChartStagePoint] = []
            for session in last7 {
                let label = df.string(from: session.startDate)
                let stageDurations = session.stageDurations
                for type in SleepStageType.allCases {
                    let seconds = stageDurations[type] ?? 0.0
                    points.append(ChartStagePoint(
                        label: label,
                        stage: localizedString("stage_\(type.rawValue)"),
                        hours: seconds / 3600.0,
                        type: type
                    ))
                }
            }
            return points
            
        case .week:
            let calendar = Calendar.current
            let grouped = Dictionary(grouping: completed) { session -> Date in
                let comps = calendar.dateComponents([.yearForWeekOfYear, .weekOfYear], from: session.startDate)
                return calendar.date(from: comps) ?? session.startDate
            }
            let sortedWeeks = grouped.keys.sorted().suffix(4)
            let df = DateFormatter()
            df.dateFormat = "'W'w"
            var points: [ChartStagePoint] = []
            for weekDate in sortedWeeks {
                let sessionsInWeek = grouped[weekDate] ?? []
                let label = df.string(from: weekDate)
                
                for type in SleepStageType.allCases {
                    let totalSeconds = sessionsInWeek.reduce(0.0) { $0 + ($1.stageDurations[type] ?? 0.0) }
                    let avgHours = (totalSeconds / Double(sessionsInWeek.count)) / 3600.0
                    points.append(ChartStagePoint(
                        label: label,
                        stage: localizedString("stage_\(type.rawValue)"),
                        hours: avgHours,
                        type: type
                    ))
                }
            }
            return points
            
        case .month:
            let calendar = Calendar.current
            let grouped = Dictionary(grouping: completed) { session -> Date in
                let comps = calendar.dateComponents([.year, .month], from: session.startDate)
                return calendar.date(from: comps) ?? session.startDate
            }
            let sortedMonths = grouped.keys.sorted().suffix(6)
            let df = DateFormatter()
            df.dateFormat = "MMM"
            var points: [ChartStagePoint] = []
            for monthDate in sortedMonths {
                let sessionsInMonth = grouped[monthDate] ?? []
                let label = df.string(from: monthDate)
                
                for type in SleepStageType.allCases {
                    let totalSeconds = sessionsInMonth.reduce(0.0) { $0 + ($1.stageDurations[type] ?? 0.0) }
                    let avgHours = (totalSeconds / Double(sessionsInMonth.count)) / 3600.0
                    points.append(ChartStagePoint(
                        label: label,
                        stage: localizedString("stage_\(type.rawValue)"),
                        hours: avgHours,
                        type: type
                    ))
                }
            }
            return points
            
        case .year:
            let calendar = Calendar.current
            let grouped = Dictionary(grouping: completed) { session -> Date in
                let comps = calendar.dateComponents([.year], from: session.startDate)
                return calendar.date(from: comps) ?? session.startDate
            }
            let sortedYears = grouped.keys.sorted().suffix(3)
            let df = DateFormatter()
            df.dateFormat = "yyyy"
            var points: [ChartStagePoint] = []
            for yearDate in sortedYears {
                let sessionsInYear = grouped[yearDate] ?? []
                let label = df.string(from: yearDate)
                
                for type in SleepStageType.allCases {
                    let totalSeconds = sessionsInYear.reduce(0.0) { $0 + ($1.stageDurations[type] ?? 0.0) }
                    let avgHours = (totalSeconds / Double(sessionsInYear.count)) / 3600.0
                    points.append(ChartStagePoint(
                        label: label,
                        stage: localizedString("stage_\(type.rawValue)"),
                        hours: avgHours,
                        type: type
                    ))
                }
            }
            return points
        }
    }

    @ViewBuilder
    private func breakdownChart() -> some View {
        GlassCard(padding: 16) {
            VStack(alignment: .leading, spacing: 16) {
                // Tab Selector
                HStack(spacing: 0) {
                    chartTabButton(tab: .day, label: "chart_day")
                    chartTabButton(tab: .week, label: "chart_week")
                    chartTabButton(tab: .month, label: "chart_month")
                    chartTabButton(tab: .year, label: "chart_year")
                }
                .background(Color.navyDeep.opacity(0.6))
                .clipShape(RoundedRectangle(cornerRadius: 12))
                .padding(.bottom, 8)
                
                // Stacked Swift Chart
                let data = chartData
                if data.isEmpty {
                    Text("no_sessions")
                        .font(AppTextStyle.bodyMedium)
                        .foregroundStyle(Color.textSecondary)
                        .frame(maxWidth: .infinity, minHeight: 180)
                } else {
                    Chart(data) { point in
                        BarMark(
                            x: .value("Period", point.label),
                            y: .value("Hours", point.hours)
                        )
                        .foregroundStyle(by: .value("Stage", point.stage))
                        .cornerRadius(4)
                    }
                    .frame(height: 180)
                    .chartForegroundStyleScale([
                        localizedString("stage_awake"): Color.stageAwake,
                        localizedString("stage_light"): Color.stageLight,
                        localizedString("stage_deep"): Color.stageDeep,
                        localizedString("stage_rem"): Color.stageREM
                    ])
                    .chartXAxis {
                        AxisMarks(values: .automatic) { _ in
                            AxisValueLabel()
                                .foregroundStyle(Color.textSecondary)
                        }
                    }
                    .chartYAxis {
                        AxisMarks(values: .automatic) { value in
                            AxisGridLine(stroke: StrokeStyle(lineWidth: 1, dash: [2, 4]))
                                .foregroundStyle(Color.textTertiary.opacity(0.3))
                            AxisValueLabel {
                                if let val = value.as(Double.self) {
                                    Text(String(format: "%.1fh", val))
                                }
                            }
                            .foregroundStyle(Color.textSecondary)
                        }
                    }
                }
            }
        }
    }
    
    @ViewBuilder
    private func chartTabButton(tab: ChartTab, label: String) -> some View {
        Button {
            withAnimation(.spring(response: 0.3, dampingFraction: 0.7)) {
                self.selectedTab = tab
            }
        } label: {
            Text(LocalizedStringKey(label))
                .font(.system(size: 14, weight: selectedTab == tab ? .bold : .medium))
                .foregroundStyle(selectedTab == tab ? Color.textPrimary : Color.textSecondary)
                .frame(maxWidth: .infinity)
                .padding(.vertical, 8)
                .background(selectedTab == tab ? Color.indigoAccent.opacity(0.6) : Color.clear)
                .clipShape(RoundedRectangle(cornerRadius: 12))
        }
        .buttonStyle(.borderless)
    }

    @ViewBuilder
    private func multiSelectActionBar() -> some View {
        VStack {
            Spacer()
            GlassCard(padding: 16) {
                HStack {
                    Text("\(selectedSessionIDs.count) Selected")
                        .font(AppTextStyle.bodyLarge.weight(.semibold))
                        .foregroundStyle(Color.textPrimary)
                    
                    Spacer()
                    
                    Button {
                        let toDelete = sessions.filter { selectedSessionIDs.contains($0.id) }
                        if !toDelete.isEmpty {
                            sessionsToDelete = toDelete
                            showDeleteAlert = true
                        }
                    } label: {
                        Text("delete_confirm")
                            .font(.system(size: 16, weight: .bold))
                            .foregroundStyle(.white)
                            .padding(.horizontal, 24)
                            .padding(.vertical, 10)
                            .background(selectedSessionIDs.isEmpty ? Color.textTertiary.opacity(0.3) : Color.red)
                            .clipShape(RoundedRectangle(cornerRadius: 12))
                    }
                    .disabled(selectedSessionIDs.isEmpty)
                }
            }
            .padding(.horizontal, 16)
            .padding(.bottom, 12)
            .transition(.move(edge: .bottom).combined(with: .opacity))
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
