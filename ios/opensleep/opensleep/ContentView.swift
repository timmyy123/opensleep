import SwiftUI

struct ContentView: View {
    @EnvironmentObject var tracker: SleepTrackerService
    @EnvironmentObject var healthKit: HealthKitManager
    @EnvironmentObject var liteRt: LiteRtManager
    @EnvironmentObject var downloadManager: ModelDownloadManager
    @AppStorage("app_language") private var selectedLanguage = "en"

    var body: some View {
        TabView {
            SleepHomeView(tracker: tracker, healthKit: healthKit)
                .tabItem {
                    Label("tab_sleep", systemImage: "moon.fill")
                }

            SleepHistoryView()
                .tabItem {
                    Label("tab_history", systemImage: "chart.bar.fill")
                }

            AIChatView(liteRt: liteRt, downloadManager: downloadManager)
                .tabItem {
                    Label("tab_chat", systemImage: "sparkles")
                }

            SettingsView(downloadManager: downloadManager)
                .tabItem {
                    Label("menu_settings", systemImage: "gearshape.fill")
                }
        }
        .tint(Color.indigoAccent)
        .toolbarBackground(.ultraThinMaterial, for: .tabBar)
        .toolbarBackgroundVisibility(.visible, for: .tabBar)
        .environment(\.locale, Locale(identifier: selectedLanguage))
        .id(selectedLanguage)
    }
}
