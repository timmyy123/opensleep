package com.android.billingclient.api;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\nH\u0086@¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000eH\u0087@¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/android/billingclient/api/BillingClient;", "Lcom/android/billingclient/api/AcknowledgePurchaseParams;", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/android/billingclient/api/BillingResult;", "acknowledgePurchase", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/QueryPurchaseHistoryParams;", "Lcom/android/billingclient/api/PurchaseHistoryResult;", "queryPurchaseHistory", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchaseHistoryParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/QueryPurchasesParams;", "Lcom/android/billingclient/api/PurchasesResult;", InAppPurchaseConstants.METHOD_QUERY_PURCHASES_ASYNC, "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchasesParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/SkuDetailsParams;", "Lcom/android/billingclient/api/SkuDetailsResult;", "querySkuDetails", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/SkuDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class BillingClientKotlinKt {
    public static /* synthetic */ void $r8$lambda$9SKPFUMhNCJ3v0PMCwGqle8zR10(CompletableDeferred completableDeferred, BillingResult billingResult, List list) {
        completableDeferred.getClass();
        billingResult.getClass();
        completableDeferred.complete(new SkuDetailsResult(billingResult, list));
    }

    /* JADX INFO: renamed from: $r8$lambda$Iy_vpeZ_JH-NmajeE6ZBdUlqJKA, reason: not valid java name */
    public static /* synthetic */ void m253$r8$lambda$Iy_vpeZ_JHNmajeE6ZBdUlqJKA(CompletableDeferred completableDeferred, BillingResult billingResult, List list) {
        completableDeferred.getClass();
        billingResult.getClass();
        list.getClass();
        completableDeferred.complete(new PurchasesResult(billingResult, list));
    }

    /* JADX INFO: renamed from: $r8$lambda$Jmx2bDJUe-jQbQfqNR-Rv-qVuz0, reason: not valid java name */
    public static /* synthetic */ void m254$r8$lambda$Jmx2bDJUejQbQfqNRRvqVuz0(CompletableDeferred completableDeferred, BillingResult billingResult, List list) {
        completableDeferred.getClass();
        billingResult.getClass();
        completableDeferred.complete(new PurchaseHistoryResult(billingResult, list));
    }

    public static /* synthetic */ void $r8$lambda$mNiIov37EcRv6CLKJbxie9rmtK8(CompletableDeferred completableDeferred, BillingResult billingResult) {
        completableDeferred.getClass();
        billingResult.getClass();
        completableDeferred.complete(billingResult);
    }

    public static final Object acknowledgePurchase(BillingClient billingClient, AcknowledgePurchaseParams acknowledgePurchaseParams, Continuation<? super BillingResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.acknowledgePurchase(acknowledgePurchaseParams, new AcknowledgePurchaseResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda4
            @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
            public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                BillingClientKotlinKt.$r8$lambda$mNiIov37EcRv6CLKJbxie9rmtK8(completableDeferredCompletableDeferred$default, billingResult);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    public static final Object queryPurchaseHistory(BillingClient billingClient, QueryPurchaseHistoryParams queryPurchaseHistoryParams, Continuation<? super PurchaseHistoryResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryPurchaseHistoryAsync(queryPurchaseHistoryParams, new PurchaseHistoryResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda6
            @Override // com.android.billingclient.api.PurchaseHistoryResponseListener
            public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
                BillingClientKotlinKt.m254$r8$lambda$Jmx2bDJUejQbQfqNRRvqVuz0(completableDeferredCompletableDeferred$default, billingResult, list);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    public static final Object queryPurchasesAsync(BillingClient billingClient, QueryPurchasesParams queryPurchasesParams, Continuation<? super PurchasesResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryPurchasesAsync(queryPurchasesParams, new PurchasesResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda10
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                BillingClientKotlinKt.m253$r8$lambda$Iy_vpeZ_JHNmajeE6ZBdUlqJKA(completableDeferredCompletableDeferred$default, billingResult, list);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }

    public static final Object querySkuDetails(BillingClient billingClient, SkuDetailsParams skuDetailsParams, Continuation<? super SkuDetailsResult> continuation) {
        final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.querySkuDetailsAsync(skuDetailsParams, new SkuDetailsResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$$ExternalSyntheticLambda11
            @Override // com.android.billingclient.api.SkuDetailsResponseListener
            public final void onSkuDetailsResponse(BillingResult billingResult, List list) {
                BillingClientKotlinKt.$r8$lambda$9SKPFUMhNCJ3v0PMCwGqle8zR10(completableDeferredCompletableDeferred$default, billingResult, list);
            }
        });
        return completableDeferredCompletableDeferred$default.await(continuation);
    }
}
