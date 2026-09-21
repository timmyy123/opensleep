import SwiftUI
import SwiftData

@main
struct opensleepApp: App {
    let container: ModelContainer
    @StateObject private var tracker = SleepTrackerService()
    @StateObject private var healthKit = HealthKitManager()
    @StateObject private var liteRt = LiteRtManager()
    @StateObject private var downloadManager = ModelDownloadManager()
    @StateObject private var storeKit = StoreKitManager.shared

    init() {
        do {
            container = try ModelContainer(for: SleepSession.self, ChatMessage.self)
        } catch {
            fatalError("Failed to create ModelContainer: \(error)")
        }

        // Configure transparent navigation bar globally to prevent solid separate header background
        let appearance = UINavigationBarAppearance()
        appearance.configureWithTransparentBackground()
        appearance.backgroundColor = .clear
        appearance.shadowColor = .clear
        UINavigationBar.appearance().standardAppearance = appearance
        UINavigationBar.appearance().scrollEdgeAppearance = appearance
        UINavigationBar.appearance().compactAppearance = appearance
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
                .modelContainer(container)
                .environmentObject(tracker)
                .environmentObject(healthKit)
                .environmentObject(liteRt)
                .environmentObject(downloadManager)
                .environmentObject(storeKit)
                .preferredColorScheme(.dark)
                .onAppear {
                    tracker.configure(modelContext: container.mainContext)
                    tracker.requestPermissions()
                    Task {
                        await healthKit.requestAuthorization()
                    }
                }
        }
    }
}
