import SwiftUI
import StoreKit

struct PaywallView: View {
    @EnvironmentObject var storeKit: StoreKitManager
    @Environment(\.dismiss) private var dismiss
    
    var isModal: Bool = false
    
    var body: some View {
        ZStack {
            Color.navyDeep.ignoresSafeArea()
            
            // Ambient glowing background gradients
            VStack {
                Circle()
                    .fill(Color.indigoAccent.opacity(0.20))
                    .frame(width: 300, height: 300)
                    .blur(radius: 85)
                    .offset(x: -80, y: -80)
                Spacer()
                Circle()
                    .fill(Color.cyanAccent.opacity(0.14))
                    .frame(width: 280, height: 280)
                    .blur(radius: 75)
                    .offset(x: 80, y: 60)
            }
            .ignoresSafeArea()
            
            GeometryReader { geometry in
                ScrollView(showsIndicators: false) {
                    VStack(spacing: 16) {
                        // Modal dismiss header
                        if isModal {
                            HStack {
                                Spacer()
                                Button {
                                    dismiss()
                                } label: {
                                    Image(systemName: "xmark.circle.fill")
                                        .font(.system(size: 26))
                                        .foregroundStyle(Color.textSecondary)
                                }
                                .padding(.top, 12)
                                .padding(.trailing, 4)
                            }
                        } else {
                            Spacer().frame(height: 6)
                        }
                        
                        // Header
                        VStack(spacing: 10) {
                            ZStack {
                                Circle()
                                    .fill(
                                        LinearGradient(
                                            colors: [Color.indigoAccent.opacity(0.35), Color.cyanAccent.opacity(0.2)],
                                            startPoint: .topLeading,
                                            endPoint: .bottomTrailing
                                        )
                                    )
                                    .frame(width: 72, height: 72)
                                
                                Image(systemName: "sparkles")
                                    .font(.system(size: 34, weight: .semibold))
                                    .foregroundStyle(
                                        LinearGradient(
                                            colors: [Color.indigoLight, Color.cyanAccent],
                                            startPoint: .topLeading,
                                            endPoint: .bottomTrailing
                                        )
                                    )
                            }
                            .shadow(color: Color.indigoAccent.opacity(0.3), radius: 16, x: 0, y: 6)
                            
                            VStack(spacing: 6) {
                                Text("paywall_title")
                                    .font(.system(size: 26, weight: .bold))
                                    .foregroundStyle(Color.textPrimary)
                                    .multilineTextAlignment(.center)
                                
                                Text("paywall_subtitle")
                                    .font(AppTextStyle.bodySmall)
                                    .foregroundStyle(Color.textSecondary)
                                    .multilineTextAlignment(.center)
                                    .padding(.horizontal, 16)
                            }
                        }
                        .padding(.top, isModal ? 2 : 10)
                        
                        // Consolidated Features Card
                        GlassCard(padding: 16) {
                            VStack(spacing: 13) {
                                FeatureRowCompact(
                                    icon: "waveform.path.ecg",
                                    iconColor: Color.cyanAccent,
                                    titleKey: "paywall_feature1_title",
                                    descKey: "paywall_feature1_desc"
                                )
                                
                                Divider()
                                    .background(Color.indigoLight.opacity(0.15))
                                
                                FeatureRowCompact(
                                    icon: "cpu.fill",
                                    iconColor: Color.indigoLight,
                                    titleKey: "paywall_feature2_title",
                                    descKey: "paywall_feature2_desc"
                                )
                                
                                Divider()
                                    .background(Color.indigoLight.opacity(0.15))
                                
                                FeatureRowCompact(
                                    icon: "bubble.left.and.bubble.right.fill",
                                    iconColor: Color.greenAccent,
                                    titleKey: "paywall_feature3_title",
                                    descKey: "paywall_feature3_desc"
                                )
                                
                                Divider()
                                    .background(Color.indigoLight.opacity(0.15))
                                
                                FeatureRowCompact(
                                    icon: "lock.open.fill",
                                    iconColor: Color.amberAccent,
                                    titleKey: "paywall_feature4_title",
                                    descKey: "paywall_feature4_desc"
                                )
                            }
                        }
                        
                        // Lifetime Pricing Card
                        GlassCard(padding: 14) {
                            HStack(alignment: .center) {
                                VStack(alignment: .leading, spacing: 4) {
                                    HStack(spacing: 6) {
                                        Text("paywall_lifetime_badge")
                                            .font(.system(size: 11, weight: .bold))
                                            .padding(.horizontal, 8)
                                            .padding(.vertical, 3)
                                            .background(Color.indigoAccent.opacity(0.3))
                                            .foregroundStyle(Color.cyanAccent)
                                            .clipShape(Capsule())
                                        
                                        Text("paywall_one_time_badge")
                                            .font(.system(size: 11, weight: .semibold))
                                            .padding(.horizontal, 8)
                                            .padding(.vertical, 3)
                                            .background(Color.navyElevated)
                                            .foregroundStyle(Color.textSecondary)
                                            .clipShape(Capsule())
                                    }
                                    
                                    Text("paywall_no_subscription_note")
                                        .font(AppTextStyle.caption)
                                        .foregroundStyle(Color.textTertiary)
                                }
                                
                                Spacer()
                                
                                // Live store price fetched directly from App Store
                                if let product = storeKit.product {
                                    Text(product.displayPrice)
                                        .font(.system(size: 24, weight: .heavy))
                                        .foregroundStyle(Color.cyanAccent)
                                } else if storeKit.isLoadingProduct {
                                    ProgressView()
                                        .tint(Color.cyanAccent)
                                        .scaleEffect(0.85)
                                } else {
                                    Button {
                                        Task { await storeKit.loadProduct() }
                                    } label: {
                                        HStack(spacing: 4) {
                                            Image(systemName: "arrow.clockwise")
                                                .font(.system(size: 11))
                                            Text("paywall_fetching_price")
                                                .font(AppTextStyle.caption)
                                        }
                                        .foregroundStyle(Color.textSecondary)
                                    }
                                }
                            }
                        }
                        
                        // Error & Status feedback
                        if let error = storeKit.errorMessage {
                            Text(error)
                                .font(AppTextStyle.caption)
                                .foregroundStyle(Color.coralAccent)
                                .multilineTextAlignment(.center)
                                .padding(.horizontal, 12)
                        } else if let status = storeKit.statusMessage {
                            Text(status)
                                .font(AppTextStyle.caption)
                                .foregroundStyle(Color.greenAccent)
                                .multilineTextAlignment(.center)
                                .padding(.horizontal, 12)
                        }
                        
                        // Purchase CTA Button
                        Button {
                            Task {
                                let success = await storeKit.purchase()
                                if success && isModal {
                                    dismiss()
                                }
                            }
                        } label: {
                            HStack(spacing: 8) {
                                if storeKit.isPurchasing {
                                    ProgressView()
                                        .tint(.white)
                                } else {
                                    Image(systemName: "sparkles")
                                        .font(.system(size: 16, weight: .bold))
                                    
                                    if let price = storeKit.product?.displayPrice {
                                        Text(String(format: String(localized: "paywall_unlock_with_price"), price))
                                            .font(.system(size: 17, weight: .bold))
                                    } else {
                                        Text("paywall_unlock_button")
                                            .font(.system(size: 17, weight: .bold))
                                    }
                                }
                            }
                            .frame(maxWidth: .infinity)
                            .frame(height: 52)
                            .background(
                                LinearGradient(
                                    colors: [Color.indigoAccent, Color.cyanAccent.opacity(0.85)],
                                    startPoint: .leading,
                                    endPoint: .trailing
                                )
                            )
                            .foregroundStyle(.white)
                            .clipShape(RoundedRectangle(cornerRadius: 16))
                            .shadow(color: Color.indigoAccent.opacity(0.35), radius: 12, x: 0, y: 5)
                        }
                        .disabled(storeKit.isPurchasing)
                        
                        // Restore & Terms row
                        HStack(spacing: 8) {
                            Button {
                                Task {
                                    await storeKit.restorePurchases()
                                    if storeKit.isPremium && isModal {
                                        dismiss()
                                    }
                                }
                            } label: {
                                HStack(spacing: 4) {
                                    if storeKit.isRestoring {
                                        ProgressView()
                                            .tint(Color.textSecondary)
                                            .scaleEffect(0.7)
                                    }
                                    Text("paywall_restore_button")
                                        .font(AppTextStyle.caption)
                                        .foregroundStyle(Color.textSecondary)
                                }
                            }
                            .disabled(storeKit.isRestoring)
                            
                            Text("•")
                                .font(AppTextStyle.caption)
                                .foregroundStyle(Color.textTertiary)
                            
                            Text("paywall_terms_privacy")
                                .font(AppTextStyle.caption)
                                .foregroundStyle(Color.textTertiary)
                                .lineLimit(1)
                        }
                        .padding(.top, 2)
                        .padding(.bottom, isModal ? 16 : 28)
                    }
                    .padding(.horizontal, 20)
                    .frame(minHeight: geometry.size.height, alignment: .top)
                }
            }
        }
        .task {
            await storeKit.loadProduct()
        }
    }
}

private struct FeatureRowCompact: View {
    let icon: String
    let iconColor: Color
    let titleKey: LocalizedStringKey
    let descKey: LocalizedStringKey
    
    var body: some View {
        HStack(alignment: .center, spacing: 12) {
            ZStack {
                RoundedRectangle(cornerRadius: 10)
                    .fill(iconColor.opacity(0.15))
                    .frame(width: 36, height: 36)
                
                Image(systemName: icon)
                    .font(.system(size: 16, weight: .semibold))
                    .foregroundStyle(iconColor)
            }
            
            VStack(alignment: .leading, spacing: 2) {
                Text(titleKey)
                    .font(.system(size: 14, weight: .bold))
                    .foregroundStyle(Color.textPrimary)
                
                Text(descKey)
                    .font(AppTextStyle.caption)
                    .foregroundStyle(Color.textSecondary)
                    .lineSpacing(1.5)
            }
            
            Spacer(minLength: 0)
        }
    }
}
