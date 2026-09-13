package app.opensleep.domain

import android.app.Activity
import android.content.Context
import android.util.Log
import com.android.billingclient.api.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class BillingManager(
    private val context: Context,
    private val coroutineScope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
) : PurchasesUpdatedListener, BillingClientStateListener {

    companion object {
        const val TAG = "BillingManager"
        const val LIFETIME_PRODUCT_ID = "opensleep_lifetime_premium"
        private const val PREFS_NAME = "opensleep_billing_prefs"
        private const val KEY_IS_PREMIUM = "is_premium_lifetime"
    }

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private val _isPremium = MutableStateFlow(prefs.getBoolean(KEY_IS_PREMIUM, false))
    val isPremium: StateFlow<Boolean> = _isPremium.asStateFlow()

    private val _productDetails = MutableStateFlow<ProductDetails?>(null)
    val productDetails: StateFlow<ProductDetails?> = _productDetails.asStateFlow()

    private val _formattedPrice = MutableStateFlow<String?>(null)
    val formattedPrice: StateFlow<String?> = _formattedPrice.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _isRestoring = MutableStateFlow(false)
    val isRestoring: StateFlow<Boolean> = _isRestoring.asStateFlow()

    private val _userMessage = MutableSharedFlow<String>()
    val userMessage: SharedFlow<String> = _userMessage.asSharedFlow()

    private var billingClient: BillingClient = BillingClient.newBuilder(context)
        .setListener(this)
        .enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build())
        .build()

    init {
        startConnection()
    }

    fun startConnection() {
        if (!billingClient.isReady) {
            billingClient.startConnection(this)
        }
    }

    override fun onBillingSetupFinished(billingResult: BillingResult) {
        if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
            Log.d(TAG, "Billing service connected.")
            coroutineScope.launch {
                queryProductDetails()
                queryActivePurchases()
            }
        } else {
            Log.w(TAG, "Billing setup failed: ${billingResult.debugMessage}")
        }
    }

    override fun onBillingServiceDisconnected() {
        Log.w(TAG, "Billing service disconnected. Retrying connection...")
        // Reconnect after brief backoff
        coroutineScope.launch {
            delay(2000)
            startConnection()
        }
    }

    /**
     * Query live product information (especially localized live price) from the Play Store
     */
    suspend fun queryProductDetails() = withContext(Dispatchers.IO) {
        val productList = listOf(
            QueryProductDetailsParams.Product.newBuilder()
                .setProductId(LIFETIME_PRODUCT_ID)
                .setProductType(BillingClient.ProductType.INAPP)
                .build()
        )

        val params = QueryProductDetailsParams.newBuilder()
            .setProductList(productList)
            .build()

        billingClient.queryProductDetailsAsync(params) { billingResult, productDetailsList ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                val details = productDetailsList.firstOrNull { it.productId == LIFETIME_PRODUCT_ID }
                _productDetails.value = details
                val price = details?.oneTimePurchaseOfferDetails?.formattedPrice
                _formattedPrice.value = price
                Log.d(TAG, "Product details loaded. Live price: $price")
            } else {
                Log.w(TAG, "Failed to query product details: ${billingResult.debugMessage}")
            }
        }
    }

    /**
     * Auto-restores any existing purchase on startup or account switch across devices.
     */
    suspend fun queryActivePurchases() = withContext(Dispatchers.IO) {
        val params = QueryPurchasesParams.newBuilder()
            .setProductType(BillingClient.ProductType.INAPP)
            .build()

        billingClient.queryPurchasesAsync(params) { billingResult, purchasesList ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                var hasAccess = false
                for (purchase in purchasesList) {
                    if (purchase.products.contains(LIFETIME_PRODUCT_ID) &&
                        purchase.purchaseState == Purchase.PurchaseState.PURCHASED
                    ) {
                        hasAccess = true
                        handleAcknowledge(purchase)
                        break
                    }
                }
                setPremiumStatus(hasAccess)
            } else {
                Log.w(TAG, "Failed to query purchases: ${billingResult.debugMessage}")
            }
        }
    }

    /**
     * Manually triggers restore purchases when requested by the user.
     */
    fun restorePurchases() {
        coroutineScope.launch {
            _isRestoring.value = true
            try {
                val params = QueryPurchasesParams.newBuilder()
                    .setProductType(BillingClient.ProductType.INAPP)
                    .build()

                billingClient.queryPurchasesAsync(params) { billingResult, purchasesList ->
                    _isRestoring.value = false
                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                        val purchased = purchasesList.any {
                            it.products.contains(LIFETIME_PRODUCT_ID) &&
                                    it.purchaseState == Purchase.PurchaseState.PURCHASED
                        }
                        setPremiumStatus(purchased)
                        coroutineScope.launch {
                            if (purchased) {
                                _userMessage.emit("Purchases restored successfully!")
                            } else {
                                _userMessage.emit("No active purchases found.")
                            }
                        }
                    } else {
                        coroutineScope.launch {
                            _userMessage.emit(billingResult.debugMessage.ifBlank { "Failed to restore purchases." })
                        }
                    }
                }
            } catch (t: Throwable) {
                _isRestoring.value = false
                _userMessage.emit(t.localizedMessage ?: "Restore failed")
            }
        }
    }

    /**
     * Launches the native Google Play purchase flow.
     */
    fun launchBillingFlow(activity: Activity): Boolean {
        val details = _productDetails.value
        if (details == null) {
            coroutineScope.launch {
                _userMessage.emit("Loading Google Play details… please retry.")
                queryProductDetails()
            }
            return false
        }

        val productDetailsParams = BillingFlowParams.ProductDetailsParams.newBuilder()
            .setProductDetails(details)
            .build()

        val billingFlowParams = BillingFlowParams.newBuilder()
            .setProductDetailsParamsList(listOf(productDetailsParams))
            .build()

        val result = billingClient.launchBillingFlow(activity, billingFlowParams)
        return result.responseCode == BillingClient.BillingResponseCode.OK
    }

    override fun onPurchasesUpdated(billingResult: BillingResult, purchases: List<Purchase>?) {
        when (billingResult.responseCode) {
            BillingClient.BillingResponseCode.OK -> {
                purchases?.forEach { purchase ->
                    if (purchase.products.contains(LIFETIME_PRODUCT_ID) &&
                        purchase.purchaseState == Purchase.PurchaseState.PURCHASED
                    ) {
                        handleAcknowledge(purchase)
                        setPremiumStatus(true)
                    }
                }
            }
            BillingClient.BillingResponseCode.USER_CANCELED -> {
                Log.d(TAG, "User canceled billing flow.")
            }
            else -> {
                Log.w(TAG, "Purchase failed: ${billingResult.debugMessage}")
                coroutineScope.launch {
                    _userMessage.emit(billingResult.debugMessage.ifBlank { "Purchase could not be completed." })
                }
            }
        }
    }

    private fun handleAcknowledge(purchase: Purchase) {
        if (!purchase.isAcknowledged) {
            val params = AcknowledgePurchaseParams.newBuilder()
                .setPurchaseToken(purchase.purchaseToken)
                .build()
            billingClient.acknowledgePurchase(params) { result ->
                if (result.responseCode == BillingClient.BillingResponseCode.OK) {
                    Log.d(TAG, "Purchase acknowledged successfully.")
                }
            }
        }
    }

    private fun setPremiumStatus(isPurchased: Boolean) {
        _isPremium.value = isPurchased
        prefs.edit().putBoolean(KEY_IS_PREMIUM, isPurchased).apply()
    }

    fun endConnection() {
        if (billingClient.isReady) {
            billingClient.endConnection()
        }
    }
}
