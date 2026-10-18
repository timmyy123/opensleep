import UIKit

enum DeviceKind {
    /// True only on iPhone Duo. Its two displays have native sizes no other iPhone or iPad uses:
    /// outer 1398×2034 and inner 2007×2853 (either orientation). Duo-specific layout tweaks key off
    /// this so every other device keeps its original layout.
    static let isIPhoneDuo: Bool = {
        let duoSizes: Set<[Int]> = [[1398, 2034], [2007, 2853]]
        let screens = UIApplication.shared.connectedScenes
            .compactMap { ($0 as? UIWindowScene)?.screen }
        let candidates = screens.isEmpty ? [UIScreen.main] : screens
        return candidates.contains { screen in
            let b = screen.nativeBounds
            let dims = [Int(b.width.rounded()), Int(b.height.rounded())].sorted()
            return duoSizes.contains(dims)
        }
    }()
}
