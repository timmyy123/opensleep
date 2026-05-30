import SwiftUI

// MARK: - Color Palette (matches Android exactly)

extension Color {
    static let navyDeep     = Color(red: 0.02, green: 0.04, blue: 0.10)
    static let navyMid      = Color(red: 0.05, green: 0.11, blue: 0.24)
    static let indigoAccent = Color(red: 0.36, green: 0.42, blue: 0.98)
    static let indigoLight  = Color(red: 0.51, green: 0.55, blue: 0.97)
    static let purpleGlow   = Color(red: 0.49, green: 0.23, blue: 0.93)
    static let cyanAccent   = Color(red: 0.13, green: 0.83, blue: 0.93)
    static let glassWhite   = Color.white.opacity(0.10)
    static let textPrimary  = Color(red: 0.95, green: 0.96, blue: 0.98)
    static let textSecondary = Color(red: 0.58, green: 0.64, blue: 0.72)
    static let textTertiary  = Color(red: 0.28, green: 0.34, blue: 0.42)
    static let surfaceContainer = Color(red: 0.06, green: 0.09, blue: 0.16)
    static let surfaceVariant   = Color(red: 0.12, green: 0.16, blue: 0.23)

    // Stage colors
    static let stageAwake = Color(red: 0.94, green: 0.27, blue: 0.27)
    static let stageLight = Color(red: 0.38, green: 0.65, blue: 0.98)
    static let stageDeep  = Color(red: 0.23, green: 0.51, blue: 0.96)
    static let stageREM   = Color(red: 0.66, green: 0.33, blue: 0.97)

    static func forStage(_ type: SleepStageType) -> Color {
        switch type {
        case .awake: return .stageAwake
        case .light: return .stageLight
        case .deep:  return .stageDeep
        case .rem:   return .stageREM
        }
    }
}

// MARK: - Typography Helpers

struct AppTextStyle {
    static let displayLarge = Font.system(size: 48, weight: .light, design: .rounded)
    static let headlineLarge = Font.system(size: 32, weight: .semibold, design: .rounded)
    static let headlineMedium = Font.system(size: 28, weight: .semibold)
    static let titleLarge = Font.system(size: 22, weight: .medium)
    static let bodyLarge = Font.system(size: 16, weight: .regular)
    static let bodyMedium = Font.system(size: 14, weight: .regular)
    static let labelLarge = Font.system(size: 14, weight: .medium)
    static let labelSmall = Font.system(size: 11, weight: .medium)
}
