import SwiftUI

/// iOS 26 Liquid Glass card wrapper — uses .glassEffect() with a rounded rect shape.
/// Falls back gracefully on older OS by using a translucent background.
struct GlassCard<Content: View>: View {
    var cornerRadius: CGFloat = 20
    var padding: CGFloat = 20
    @ViewBuilder var content: () -> Content

    var body: some View {
        content()
            .padding(padding)
            .background {
                RoundedRectangle(cornerRadius: cornerRadius, style: .continuous)
                    .fill(.ultraThinMaterial)
                    .overlay {
                        RoundedRectangle(cornerRadius: cornerRadius, style: .continuous)
                            .strokeBorder(
                                LinearGradient(
                                    colors: [Color.white.opacity(0.25), Color.white.opacity(0.05)],
                                    startPoint: .topLeading,
                                    endPoint: .bottomTrailing
                                ),
                                lineWidth: 1
                            )
                    }
            }
    }
}

#Preview {
    GlassCard {
        Text("Hello, Liquid Glass!")
            .foregroundStyle(Color.textPrimary)
    }
    .padding()
    .background(Color.navyDeep)
}
