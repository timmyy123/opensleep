import Foundation
import StoreKit
import SwiftUI
import Combine

@MainActor
final class StoreKitManager: ObservableObject {
    static let shared = StoreKitManager()
    
    // Product identifier for one-time Lifetime Unlock
    static let lifetimeProductID = "opensleep_lifetime_premium"
    
    @Published var isPremium: Bool = false
    @Published var product: Product? = nil
    @Published var isLoadingProduct: Bool = false
    @Published var isPurchasing: Bool = false
    @Published var isRestoring: Bool = false
    @Published var statusMessage: String? = nil
    @Published var errorMessage: String? = nil
    
    @AppStorage("opensleep_is_premium_lifetime") private var cachedIsPremium: Bool = false
    
    private var transactionListenerTask: Task<Void, Never>? = nil
    
    init() {
        // Fast optimistic initial state from local cache
        self.isPremium = cachedIsPremium
        
        // Start background transaction listener for real-time StoreKit updates
        transactionListenerTask = listenForTransactions()
        
        // Check current entitlements and load product details
        Task {
            await updatePurchasedStatus()
            await loadProduct()
        }
    }
    
    deinit {
        transactionListenerTask?.cancel()
    }
    
    /// Loads the product details from the App Store to fetch the live localized price
    func loadProduct() async {
        isLoadingProduct = true
        defer { isLoadingProduct = false }
        
        do {
            let products = try await Product.products(for: [Self.lifetimeProductID])
            if let found = products.first {
                self.product = found
            }
        } catch {
            print("[StoreKitManager] Failed to load product: \(error.localizedDescription)")
        }
    }
    
    /// Purchases the Lifetime Unlock non-consumable product
    func purchase() async -> Bool {
        if self.product == nil {
            await loadProduct()
        }
        guard let product = self.product else {
            self.errorMessage = "Unable to connect to the App Store. Please try again."
            return false
        }
        
        isPurchasing = true
        errorMessage = nil
        defer { isPurchasing = false }
        
        do {
            let result = try await product.purchase()
            switch result {
            case .success(let verification):
                let transaction = try checkVerified(verification)
                await transaction.finish()
                await updatePurchasedStatus()
                return true
                
            case .userCancelled:
                return false
                
            case .pending:
                self.statusMessage = "Purchase is pending approval."
                return false
                
            @unknown default:
                return false
            }
        } catch {
            self.errorMessage = error.localizedDescription
            return false
        }
    }
    
    /// Restores purchases by syncing with the App Store and re-evaluating active entitlements
    func restorePurchases() async {
        isRestoring = true
        errorMessage = nil
        statusMessage = nil
        defer { isRestoring = false }
        
        do {
            try await AppStore.sync()
            await updatePurchasedStatus()
            if isPremium {
                statusMessage = "Purchases restored successfully!"
            } else {
                statusMessage = "No previous purchases found."
            }
        } catch {
            errorMessage = error.localizedDescription
        }
    }
    
    /// Checks all current entitlements to automatically restore purchases across devices / app reinstalls
    func updatePurchasedStatus() async {
        var hasLifetimeAccess = false
        
        for await result in Transaction.currentEntitlements {
            if case .verified(let transaction) = result {
                if transaction.productID == Self.lifetimeProductID && transaction.revocationDate == nil {
                    hasLifetimeAccess = true
                    break
                }
            }
        }
        
        self.isPremium = hasLifetimeAccess
        self.cachedIsPremium = hasLifetimeAccess
    }
    
    /// Listens for external transaction updates (e.g. Family Sharing, outside device purchases, approvals)
    private func listenForTransactions() -> Task<Void, Never> {
        Task.detached(priority: .background) { [weak self] in
            for await result in Transaction.updates {
                do {
                    let transaction = try self?.checkVerified(result)
                    if let transaction {
                        await transaction.finish()
                        await self?.updatePurchasedStatus()
                    }
                } catch {
                    print("[StoreKitManager] Transaction update verification failed: \(error)")
                }
            }
        }
    }
    
    nonisolated private func checkVerified<T>(_ result: VerificationResult<T>) throws -> T {
        switch result {
        case .unverified(_, let error):
            throw error
        case .verified(let safe):
            return safe
        }
    }
}
