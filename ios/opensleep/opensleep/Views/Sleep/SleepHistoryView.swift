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
    let yStart: Double // Hours since 6 PM of reference evening
    let yEnd: Double   // Hours since 6 PM of reference evening
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
                                            Label("delete_confirm", systemImage: "trash")
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
                        .scrollIndicators(.hidden)
                        
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
                            healthKit.markSessionAsDeleted(startDate: session.startDate)
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
            .task {
                let _ = await healthKit.requestAuthorization()
                let imported = await healthKit.syncSleepDataFromHealthKit(modelContext: modelContext)
                if imported > 0 {
                    print("Imported \(imported) sleep sessions from HealthKit.")
                }
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

    // MARK: - Apple Health Timeline Helpers

    private func getReferenceEvening(for startDate: Date) -> Date {
        let calendar = Calendar.current
        let comps = calendar.dateComponents([.year, .month, .day, .hour], from: startDate)
        
        // If user went to sleep between midnight and noon, use the previous calendar day
        let isAfterMidnight = (comps.hour ?? 0) < 12
        let referenceDay = isAfterMidnight ? calendar.date(byAdding: .day, value: -1, to: startDate)! : startDate
        
        var refComps = calendar.dateComponents([.year, .month, .day], from: referenceDay)
        refComps.hour = 18 // 6:00 PM
        refComps.minute = 0
        refComps.second = 0
        
        return calendar.date(from: refComps) ?? referenceDay
    }

    private func getHoursSinceReference(for date: Date, reference: Date) -> Double {
        let diff = date.timeIntervalSince(reference)
        return max(0.0, min(24.0, diff / 3600.0))
    }

    private func formatYAxisLabel(_ hours: Double) -> String {
        let calendar = Calendar.current
        var comps = DateComponents()
        comps.hour = 18 // 6:00 PM
        comps.minute = 0
        let baseDate = calendar.date(from: comps) ?? Date()
        let date = baseDate.addingTimeInterval(hours * 3600)
        
        let formatter = DateFormatter()
        formatter.dateFormat = "h a"
        return formatter.string(from: date).lowercased()
    }

    // MARK: - Sleep Timeline Aggregations

    private var chartData: [ChartStagePoint] {
        let completed = sessions.filter(\.isCompleted).sorted(by: { $0.startDate < $1.startDate })
        guard !completed.isEmpty else { return [] }
        
        let df = DateFormatter()
        
        switch selectedTab {
        case .day:
            let last7 = Array(completed.suffix(7))
            df.dateFormat = "E d"
            return makePoints(for: last7, formatter: df)
            
        case .week:
            let last14 = Array(completed.suffix(14))
            df.dateFormat = "E d"
            return makePoints(for: last14, formatter: df)
            
        case .month:
            let last30 = Array(completed.suffix(30))
            df.dateFormat = "d" // Just the day number
            return makePoints(for: last30, formatter: df)
            
        case .year:
            let last90 = Array(completed.suffix(90))
            df.dateFormat = "MMM" // Month name
            return makePoints(for: last90, formatter: df)
        }
    }

    private func makePoints(for selectedSessions: [SleepSession], formatter: DateFormatter) -> [ChartStagePoint] {
        var points: [ChartStagePoint] = []
        for session in selectedSessions {
            let label = formatter.string(from: session.startDate)
            let refEvening = getReferenceEvening(for: session.startDate)
            
            // Map stages
            let stages = session.stages
            for stage in stages {
                let yStart = getHoursSinceReference(for: stage.startDate, reference: refEvening)
                let yEnd = getHoursSinceReference(for: stage.endDate, reference: refEvening)
                
                // If it is within our 24h window
                if yEnd > yStart {
                    points.append(ChartStagePoint(
                        label: label,
                        stage: localizedString("stage_\(stage.type.rawValue)"),
                        yStart: yStart,
                        yEnd: yEnd,
                        type: stage.type
                    ))
                }
            }
        }
        return points
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
                            yStart: .value("Start Time", point.yStart),
                            yEnd: .value("End Time", point.yEnd),
                            width: .automatic
                        )
                        .foregroundStyle(by: .value("Stage", point.stage))
                        .cornerRadius(4)
                    }
                    .frame(height: 200)
                    .chartYScale(domain: 0...24)
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
                        AxisMarks(values: [0.0, 4.0, 8.0, 12.0, 16.0, 20.0, 24.0]) { value in
                            AxisGridLine(stroke: StrokeStyle(lineWidth: 1, dash: [2, 4]))
                                .foregroundStyle(Color.textTertiary.opacity(0.3))
                            AxisValueLabel {
                                if let val = value.as(Double.self) {
                                    Text(formatYAxisLabel(val))
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
                    sessionStartDate: session.startDate,
                    totalDuration: session.durationSeconds
                )

                SleepStageLegend(stageDurations: session.stageDurations)
            }
        }
    }
}
