package app.opensleep.viewmodel

import android.app.Activity
import androidx.lifecycle.ViewModel
import app.opensleep.domain.BillingManager
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class BillingViewModel(
    private val billingManager: BillingManager
) : ViewModel() {

    val isPremium: StateFlow<Boolean> = billingManager.isPremium
    val formattedPrice: StateFlow<String?> = billingManager.formattedPrice
    val isLoading: StateFlow<Boolean> = billingManager.isLoading
    val isRestoring: StateFlow<Boolean> = billingManager.isRestoring
    val userMessage: SharedFlow<String> = billingManager.userMessage

    fun launchPurchaseFlow(activity: Activity): Boolean {
        return billingManager.launchBillingFlow(activity)
    }

    fun restorePurchases() {
        billingManager.restorePurchases()
    }

    fun refreshPrice() {
        billingManager.startConnection()
    }
}
