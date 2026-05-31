import SwiftUI

struct SettingsView: View {
    @ObservedObject var downloadManager: ModelDownloadManager
    @AppStorage("app_language") private var selectedLanguage = "en"
    @State private var showPrivacySheet = false

    let languages = [
        ("en", "English"),
        ("pt", "Português"),
        ("es", "Español"),
        ("de", "Deutsch"),
        ("fr", "Français"),
        ("it", "Italiano")
    ]

    var body: some View {
        ZStack {
            Color.navyDeep.ignoresSafeArea()
            ScrollView {
                VStack(alignment: .leading, spacing: 28) {
                    Text("menu_settings")
                        .font(.system(size: 28, weight: .bold))
                        .foregroundStyle(Color.indigoLight)
                        .padding(.top, 16)

                    // Language Section
                    VStack(alignment: .leading, spacing: 12) {
                        Text("section_language")
                            .font(AppTextStyle.titleLarge)
                            .foregroundStyle(Color.indigoLight)

                        GlassCard(padding: 12) {
                            Picker("section_language", selection: $selectedLanguage) {
                                ForEach(languages, id: \.0) { code, name in
                                    Text(name).tag(code)
                                }
                            }
                            .pickerStyle(.menu)
                            .tint(Color.indigoLight)
                        }
                    }

                    // Models Section
                    VStack(alignment: .leading, spacing: 12) {
                        Text("section_models")
                            .font(AppTextStyle.titleLarge)
                            .foregroundStyle(Color.indigoLight)

                        ForEach(ModelVariant.allCases) { variant in
                            let state = downloadManager.downloadStates[variant] ?? .idle
                            ModelDownloadCard(
                                variant: variant,
                                state: state,
                                downloadManager: downloadManager
                            )
                        }
                    }

                    // About & Resources Section
                    VStack(alignment: .leading, spacing: 12) {
                        Text("section_about")
                            .font(AppTextStyle.titleLarge)
                            .foregroundStyle(Color.indigoLight)

                        GlassCard(padding: 16) {
                            VStack(alignment: .leading, spacing: 16) {
                                Button {
                                    showPrivacySheet = true
                                } label: {
                                    HStack {
                                        Image(systemName: "hand.raised.fill")
                                            .foregroundStyle(Color.indigoLight)
                                        Text("privacy_tos")
                                            .font(AppTextStyle.bodyMedium)
                                            .foregroundStyle(Color.textPrimary)
                                        Spacer()
                                        Image(systemName: "chevron.right")
                                            .foregroundStyle(Color.textTertiary)
                                    }
                                }
                                
                                Divider()
                                    .background(Color.indigoLight.opacity(0.3))
                                
                                Link(destination: URL(string: "https://github.com/timmyy123/opensleep")!) {
                                    HStack {
                                        Image(systemName: "safari.fill")
                                            .foregroundStyle(Color.indigoLight)
                                        Text("github_repo")
                                            .font(AppTextStyle.bodyMedium)
                                            .foregroundStyle(Color.textPrimary)
                                        Spacer()
                                        Image(systemName: "link")
                                            .foregroundStyle(Color.textTertiary)
                                    }
                                }
                            }
                        }
                    }

                    Spacer().frame(height: 32)
                }
                .padding(.horizontal, 20)
            }
            .sheet(isPresented: $showPrivacySheet) {
                PrivacySheetView()
            }
        }
    }
}

struct ModelDownloadCard: View {
    let variant: ModelVariant
    let state: DownloadState
    @ObservedObject var downloadManager: ModelDownloadManager
    @State private var isExpanded = false

    var body: some View {
        GlassCard(padding: 16) {
            VStack(alignment: .leading, spacing: 12) {
                HStack(alignment: .top) {
                    VStack(alignment: .leading, spacing: 4) {
                        Text(variant.displayName)
                            .font(.system(size: 16, weight: .bold))
                            .foregroundStyle(Color.textPrimary)
                        Text(String(format: "Size: %.1f GB", variant.sizeGB))
                            .font(AppTextStyle.bodyMedium)
                            .foregroundStyle(Color.textSecondary)
                    }
                    Spacer()

                    // Action buttons
                    switch state {
                    case .idle:
                        Button {
                            downloadManager.downloadModel(variant)
                        } label: {
                            Text("download_model")
                                .font(.system(size: 14, weight: .semibold))
                                .foregroundStyle(.white)
                                .padding(.horizontal, 16)
                                .padding(.vertical, 8)
                                .background(Color.indigoAccent)
                                .clipShape(RoundedRectangle(cornerRadius: 12))
                        }
                    case .downloading:
                        HStack(spacing: 12) {
                            Button {
                                downloadManager.pauseModelDownload(variant)
                            } label: {
                                Image(systemName: "pause.fill")
                                    .font(.system(size: 16, weight: .bold))
                                    .foregroundStyle(Color.indigoLight)
                            }
                            Button {
                                downloadManager.cancelModelDownload(variant)
                            } label: {
                                Image(systemName: "xmark")
                                    .font(.system(size: 16, weight: .bold))
                                    .foregroundStyle(.red)
                            }
                        }
                    case .paused:
                        HStack(spacing: 12) {
                            Button {
                                downloadManager.downloadModel(variant)
                            } label: {
                                Image(systemName: "play.fill")
                                    .font(.system(size: 16, weight: .bold))
                                    .foregroundStyle(Color.indigoLight)
                            }
                            Button {
                                downloadManager.cancelModelDownload(variant)
                            } label: {
                                Image(systemName: "xmark")
                                    .font(.system(size: 16, weight: .bold))
                                    .foregroundStyle(.red)
                            }
                        }
                    case .done:
                        HStack(spacing: 12) {
                            if downloadManager.activeVariant == variant {
                                Text("active_model")
                                    .font(.system(size: 14, weight: .bold))
                                    .foregroundStyle(Color.indigoLight)
                            } else {
                                Button {
                                    downloadManager.activeVariant = variant
                                } label: {
                                    Text("Select")
                                        .font(.system(size: 14, weight: .semibold))
                                        .foregroundStyle(Color.textPrimary)
                                        .padding(.horizontal, 16)
                                        .padding(.vertical, 8)
                                        .background(Color.indigoAccent)
                                        .clipShape(RoundedRectangle(cornerRadius: 12))
                                }
                            }
                            Button {
                                downloadManager.deleteModel(variant)
                            } label: {
                                Image(systemName: "trash.fill")
                                    .font(.system(size: 16))
                                    .foregroundStyle(.red)
                            }
                            Image(systemName: isExpanded ? "chevron.up" : "chevron.down")
                                .font(.system(size: 14, weight: .bold))
                                .foregroundStyle(Color.indigoLight)
                        }
                    case .failed(_):
                        HStack(spacing: 8) {
                            Text("Retry")
                                .font(.system(size: 12, weight: .bold))
                                .foregroundStyle(.red)
                            Button {
                                downloadManager.downloadModel(variant)
                            } label: {
                                Image(systemName: "arrow.clockwise")
                                    .font(.system(size: 16))
                                    .foregroundStyle(.red)
                            }
                        }
                    }
                }

                // Progress panel
                if case .downloading(let progress, let speed, let downloaded, let total) = state {
                    VStack(alignment: .leading, spacing: 8) {
                        ProgressView(value: progress)
                            .tint(Color.indigoLight)
                            .background(Color.glassWhite)
                        HStack {
                            Text("\(formatSize(downloaded)) / \(formatSize(total))")
                                .font(AppTextStyle.labelSmall)
                                .foregroundStyle(Color.textSecondary)
                            Spacer()
                            Text(formatSpeed(speed))
                                .font(AppTextStyle.labelSmall.weight(.bold))
                                .foregroundStyle(Color.indigoLight)
                        }
                    }
                } else if case .paused(let progress, let downloaded, let total) = state {
                    VStack(alignment: .leading, spacing: 8) {
                        ProgressView(value: progress)
                            .tint(Color.textSecondary)
                            .background(Color.glassWhite)
                        HStack {
                            Text("\(formatSize(downloaded)) / \(formatSize(total))")
                                .font(AppTextStyle.labelSmall)
                                .foregroundStyle(Color.textSecondary)
                            Spacer()
                            Text("Paused")
                                .font(AppTextStyle.labelSmall.weight(.bold))
                                .foregroundStyle(Color.textSecondary)
                        }
                    }
                } else if state == .done {
                    HStack(spacing: 6) {
                        Image(systemName: "checkmark.circle.fill")
                            .font(.system(size: 14))
                            .foregroundStyle(Color.indigoLight)
                        Text("ready_to_use")
                            .font(AppTextStyle.labelSmall)
                            .foregroundStyle(Color.indigoLight)
                    }
                    
                    if isExpanded {
                        Divider()
                            .background(Color.indigoLight.opacity(0.3))
                            .padding(.vertical, 8)
                            
                        VStack(alignment: .leading, spacing: 12) {
                            Text("setting_context_size")
                                .font(.system(size: 16, weight: .semibold))
                                .foregroundStyle(Color.indigoLight)
                                
                            let contextSize = downloadManager.contextWindowSizes[variant] ?? 4096
                            Text("\(contextSize) tokens")
                                .font(AppTextStyle.bodyMedium)
                                .foregroundStyle(Color.textPrimary)

                            Slider(
                                value: Binding(
                                    get: { Double(contextSize) },
                                    set: { downloadManager.setContextWindowSize(Int($0), for: variant) }
                                ),
                                in: 2048...8192,
                                step: 1024
                            )
                            .tint(Color.indigoLight)
                        }
                    }
                }
            }
        }
        .onTapGesture {
            if state == .done {
                withAnimation(.spring(response: 0.3, dampingFraction: 0.7)) {
                    isExpanded.toggle()
                }
            }
        }
    }

    private func formatSpeed(_ bytesPerSec: Double) -> String {
        if bytesPerSec >= 1024 * 1024 {
            return String(format: "%.1f MB/s", bytesPerSec / (1024 * 1024))
        } else if bytesPerSec >= 1024 {
            return String(format: "%.1f KB/s", bytesPerSec / 1024)
        } else {
            return String(format: "%.0f B/s", bytesPerSec)
        }
    }

    private func formatSize(_ bytes: Int64) -> String {
        let kb = Double(bytes) / 1024.0
        let mb = kb / 1024.0
        let gb = mb / 1024.0
        if gb >= 0.1 {
            return String(format: "%.2f GB", gb)
        } else if mb >= 0.1 {
            return String(format: "%.1f MB", mb)
        } else {
            return String(format: "%.1f KB", kb)
        }
    }
}

struct PrivacySheetView: View {
    @Environment(\.dismiss) private var dismiss

    var body: some View {
        ZStack {
            Color.navyDeep.ignoresSafeArea()
            
            VStack(spacing: 0) {
                // Handle bar
                Capsule()
                    .fill(Color.textTertiary.opacity(0.5))
                    .frame(width: 36, height: 5)
                    .padding(.top, 12)
                    .padding(.bottom, 20)
                
                ScrollView {
                    VStack(alignment: .leading, spacing: 20) {
                        Text("privacy_title")
                            .font(.system(size: 28, weight: .bold))
                            .foregroundStyle(Color.indigoLight)
                        
                        Text("privacy_body")
                            .font(AppTextStyle.bodyMedium)
                            .foregroundStyle(Color.textPrimary)
                            .lineSpacing(6)
                        
                        Spacer(minLength: 24)
                        
                        Button {
                            dismiss()
                        } label: {
                            Text("cancel") // cancel is localized to "Cancelar"/"Done" which fits close button perfectly
                                .font(.system(size: 16, weight: .semibold))
                                .foregroundStyle(.white)
                                .frame(maxWidth: .infinity)
                                .padding()
                                .background(Color.indigoAccent)
                                .clipShape(RoundedRectangle(cornerRadius: 16))
                        }
                    }
                    .padding(.horizontal, 24)
                    .padding(.bottom, 32)
                }
            }
        }
    }
}
