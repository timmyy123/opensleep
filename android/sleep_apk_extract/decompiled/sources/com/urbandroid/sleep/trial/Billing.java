package com.urbandroid.sleep.trial;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientKotlinKt;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.PurchaseHistoryResult;
import com.android.billingclient.api.PurchasesResult;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResult;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.ads.AdValue;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.Days;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.PreferencesUtils;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.domain.promo.PromoEvent;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.trial.Billing;
import com.urbandroid.sleep.trial.IBillingStatusListener;
import com.urbandroid.util.Experiments;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_concurrentKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.achartengine.chart.TimeChart;
import org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0005QRSTUB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\f\u0010\rJ \u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\f\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u0013\u0010\rJ$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u001b\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014H\u0086@¢\u0006\u0004\b\u001b\u0010\u0018J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014H\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0086@¢\u0006\u0004\b\u0013\u0010\u0018J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0013\u0010\u0011J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00142\u0006\u0010\u0010\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u001f\u0010 J \u0010\"\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\"\u0010\u0011J \u0010$\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b$\u0010\u0011J\u0014\u0010'\u001a\u00020&*\u00020%H\u0086@¢\u0006\u0004\b'\u0010(J\u0014\u0010*\u001a\u00020)*\u00020%H\u0086@¢\u0006\u0004\b*\u0010(J&\u0010\u0013\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010\u0010\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0013\u0010+J\u0019\u0010.\u001a\u0004\u0018\u00010-2\u0006\u0010,\u001a\u00020\u000eH\u0002¢\u0006\u0004\b.\u0010/J'\u00104\u001a\u0002032\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u00105J'\u00107\u001a\u0002032\u0006\u00106\u001a\u00020-2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000eH\u0002¢\u0006\u0004\b7\u00108R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00109R\u001a\u0010:\u001a\u00020\u000e8\u0016X\u0096D¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010?\u001a\u00020>8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0017\u0010G\u001a\u00020F8\u0006¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u001b\u0010P\u001a\u00020K8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O¨\u0006V"}, d2 = {"Lcom/urbandroid/sleep/trial/Billing;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "disconnect", "()V", "Lcom/urbandroid/sleep/trial/Billing$PurchaseType;", "purchaseType", "Lcom/urbandroid/sleep/trial/PurchaseResult;", "purchase", "(Lcom/urbandroid/sleep/trial/Billing$PurchaseType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "sku", "type", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/SkuDetailsResult;", "querySkuDetails", "", "purchaseTypes", "Lcom/urbandroid/sleep/trial/Billing$LoadedSkuDetail;", "resolveSkuDetails", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/SkuDetails;", "skus", "storeSkuDetails", "loadSkuDetails", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "queryPurchaseHistory", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skuPrefix", "consumeSku", "Lcom/urbandroid/sleep/trial/Billing$RefreshPurchaseState;", "refreshPurchaseState", "Lcom/android/billingclient/api/Purchase;", "Lcom/urbandroid/sleep/trial/ConsumeResult;", "consume", "(Lcom/android/billingclient/api/Purchase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/android/billingclient/api/BillingResult;", "acknowledge", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "encodedPublicKey", "Ljava/security/PublicKey;", "generatePublicKeyOrNull", "(Ljava/lang/String;)Ljava/security/PublicKey;", "base64PublicKey", "signedData", "signature", "", "verifyPurchase", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "publicKey", "verify", "(Ljava/security/PublicKey;Ljava/lang/String;Ljava/lang/String;)Z", "Landroid/app/Activity;", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getMutex", "()Lkotlinx/coroutines/sync/Mutex;", "Lcom/urbandroid/sleep/trial/Billing$PurchaseListener;", "purchaseUpdatedListener", "Lcom/urbandroid/sleep/trial/Billing$PurchaseListener;", "Lcom/android/billingclient/api/BillingClient;", "client", "Lcom/android/billingclient/api/BillingClient;", "getClient", "()Lcom/android/billingclient/api/BillingClient;", "Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs", "PurchaseType", "LoadedSkuDetail", "SafeResumeContinuation", "RefreshPurchaseState", "PurchaseListener", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Billing implements FeatureLogger {
    private final Activity activity;
    private final BillingClient client;
    private final Mutex mutex;

    /* JADX INFO: renamed from: prefs$delegate, reason: from kotlin metadata */
    private final Lazy prefs;
    private final PurchaseListener purchaseUpdatedListener;
    private final String tag;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/trial/Billing$LoadedSkuDetail;", "", "Lcom/android/billingclient/api/SkuDetails;", "detail", "", "cached", "<init>", "(Lcom/android/billingclient/api/SkuDetails;Z)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/android/billingclient/api/SkuDetails;", "getDetail", "()Lcom/android/billingclient/api/SkuDetails;", "Z", "getCached", "()Z", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LoadedSkuDetail {
        private final boolean cached;
        private final SkuDetails detail;

        public LoadedSkuDetail(SkuDetails skuDetails, boolean z) {
            skuDetails.getClass();
            this.detail = skuDetails;
            this.cached = z;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadedSkuDetail)) {
                return false;
            }
            LoadedSkuDetail loadedSkuDetail = (LoadedSkuDetail) other;
            return Intrinsics.areEqual(this.detail, loadedSkuDetail.detail) && this.cached == loadedSkuDetail.cached;
        }

        public final SkuDetails getDetail() {
            return this.detail;
        }

        public int hashCode() {
            return Boolean.hashCode(this.cached) + (this.detail.hashCode() * 31);
        }

        public String toString() {
            return "LoadedSkuDetail(detail=" + this.detail + ", cached=" + this.cached + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR8\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\t\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/trial/Billing$PurchaseListener;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "<init>", "()V", "Lcom/android/billingclient/api/BillingResult;", "billingResult", "", "Lcom/android/billingclient/api/Purchase;", "purchases", "", "onPurchasesUpdated", "(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V", "Lkotlin/Function2;", "listener", "Lkotlin/jvm/functions/Function2;", "getListener", "()Lkotlin/jvm/functions/Function2;", InAppPurchaseConstants.METHOD_SET_LISTENER, "(Lkotlin/jvm/functions/Function2;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PurchaseListener implements PurchasesUpdatedListener {
        private Function2<? super BillingResult, ? super Purchase, Unit> listener;

        @Override // com.android.billingclient.api.PurchasesUpdatedListener
        public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> purchases) {
            billingResult.getClass();
            Logger.logInfo("purchase update: " + BillingKt.pretty(billingResult), null);
            Function2<? super BillingResult, ? super Purchase, Unit> function2 = this.listener;
            if (function2 != null) {
                function2.invoke(billingResult, purchases != null ? (Purchase) CollectionsKt.firstOrNull((List) purchases) : null);
            }
        }

        public final void setListener(Function2<? super BillingResult, ? super Purchase, Unit> function2) {
            this.listener = function2;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0086\u0081\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, d2 = {"Lcom/urbandroid/sleep/trial/Billing$PurchaseType;", "", "pkg", "", "type", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getPkg", "()Ljava/lang/String;", "getType", "CLOUD_PREMIUM", "MONTHLY_143_SUBSCRIPTION", "MONTHLY_SUBSCRIPTION", "YEARLY_SUBSCRIPTION", "YEARLY_70_SUBSCRIPTION", "YEARLY_50_SUBSCRIPTION", "YEARLY_35_SUBSCRIPTION", "YEARLY_25_SUBSCRIPTION", "YEARLY_143_SUBSCRIPTION", "LIFETIME", "LIFETIME_70", "LIFETIME_50", "LIFETIME_35", "LIFETIME_143", "PROMO_SPECIAL", "STANDARD", "STANDARD_SUBSCRIPTION", "WAKE_UP_MOTIVATION_HIGH", "WAKE_UP_MOTIVATION_MEDIUM", "PROMO", "LONG_PROMO", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class PurchaseType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PurchaseType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String pkg;
        private final String type;
        public static final PurchaseType CLOUD_PREMIUM = new PurchaseType("CLOUD_PREMIUM", 0, "sleep.cloud.premium", SubSampleInformationBox.TYPE);
        public static final PurchaseType MONTHLY_143_SUBSCRIPTION = new PurchaseType("MONTHLY_143_SUBSCRIPTION", 1, "sleep.unlock.sub.m134", SubSampleInformationBox.TYPE);
        public static final PurchaseType MONTHLY_SUBSCRIPTION = new PurchaseType("MONTHLY_SUBSCRIPTION", 2, "sleep.unlock.sub.m", SubSampleInformationBox.TYPE);
        public static final PurchaseType YEARLY_SUBSCRIPTION = new PurchaseType("YEARLY_SUBSCRIPTION", 3, "sleep.unlock.sub.y", SubSampleInformationBox.TYPE);
        public static final PurchaseType YEARLY_70_SUBSCRIPTION = new PurchaseType("YEARLY_70_SUBSCRIPTION", 4, "sleep.unlock.sub.y30", SubSampleInformationBox.TYPE);
        public static final PurchaseType YEARLY_50_SUBSCRIPTION = new PurchaseType("YEARLY_50_SUBSCRIPTION", 5, "sleep.unlock.sub.y50", SubSampleInformationBox.TYPE);
        public static final PurchaseType YEARLY_35_SUBSCRIPTION = new PurchaseType("YEARLY_35_SUBSCRIPTION", 6, "sleep.unlock.sub.y35", SubSampleInformationBox.TYPE);
        public static final PurchaseType YEARLY_25_SUBSCRIPTION = new PurchaseType("YEARLY_25_SUBSCRIPTION", 7, "sleep.unlock.sub.y25", SubSampleInformationBox.TYPE);
        public static final PurchaseType YEARLY_143_SUBSCRIPTION = new PurchaseType("YEARLY_143_SUBSCRIPTION", 8, "sleep.unlock.sub.y143", SubSampleInformationBox.TYPE);
        public static final PurchaseType LIFETIME = new PurchaseType("LIFETIME", 9, "sleep.unlock.lt", "inapp");
        public static final PurchaseType LIFETIME_70 = new PurchaseType("LIFETIME_70", 10, "sleep.unlock.promo", "inapp");
        public static final PurchaseType LIFETIME_50 = new PurchaseType("LIFETIME_50", 11, "sleep.unlock.lt50", "inapp");
        public static final PurchaseType LIFETIME_35 = new PurchaseType("LIFETIME_35", 12, "sleep.unlock.lt35", "inapp");
        public static final PurchaseType LIFETIME_143 = new PurchaseType("LIFETIME_143", 13, "sleep.unlock.lt143", "inapp");
        public static final PurchaseType PROMO_SPECIAL = new PurchaseType("PROMO_SPECIAL", 14, "sleep.unlock.special", "inapp");
        public static final PurchaseType STANDARD = new PurchaseType("STANDARD", 15, "sleep.unlock", "inapp");
        public static final PurchaseType STANDARD_SUBSCRIPTION = new PurchaseType("STANDARD_SUBSCRIPTION", 16, "sleep.unlock.sub", SubSampleInformationBox.TYPE);
        public static final PurchaseType WAKE_UP_MOTIVATION_HIGH = new PurchaseType("WAKE_UP_MOTIVATION_HIGH", 17, "refundable_wakeup_motivation_2", "inapp");
        public static final PurchaseType WAKE_UP_MOTIVATION_MEDIUM = new PurchaseType("WAKE_UP_MOTIVATION_MEDIUM", 18, "refundable_wakeup_motivation_1", "inapp");
        public static final PurchaseType PROMO = new PurchaseType("PROMO", 19, "sleep.unlock.promo", "inapp");
        public static final PurchaseType LONG_PROMO = new PurchaseType("LONG_PROMO", 20, "sleep.unlock.promo", "inapp");

        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000e\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\u0006H\u0007J\b\u0010\u0010\u001a\u00020\u0006H\u0007J\b\u0010\u0011\u001a\u00020\u0006H\u0007J\b\u0010\u0012\u001a\u00020\u0006H\u0007J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00192\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u0006J\b\u0010%\u001a\u00020\fH\u0002J\b\u0010&\u001a\u00020\fH\u0002J\b\u0010'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002¨\u0006,"}, d2 = {"Lcom/urbandroid/sleep/trial/Billing$PurchaseType$Companion;", "", "<init>", "()V", "activeProducts", "", "Lcom/urbandroid/sleep/trial/Billing$PurchaseType;", "findOrNull", "sku", "", "detectYearly", "detectSalePercentage", "", "detectYearlySalePercentage", "detectFirstYearSalePercentage", "detectMonthly", "detectLifetime", "detectLifetimeBase", "detectYearlyBase", "getPriceAmountInBaseCurrency", "", "detail", "Lcom/android/billingclient/api/SkuDetails;", ShareDialog.WEB_SHARE_DIALOG, "", "Lcom/google/android/gms/ads/AdValue;", "getPriceAmount", "isEligibleForShortPromo", "", "isEligibleForLongPromo", "isEligibleForSuperPromo", "getPromoType", "getEligibleLifetimeProduct", "getEligibleLifetimeBaseProduct", "getEligibleYearlyBaseProduct", "getEligibleYearlyProduct", "getEligibleMonthlyProduct", "getLifetimeSalePromoPercentage", "getFirstYearSalePromoPercentage", "getYearlySalePromoPercentage", "getShortPromoTime", "", "getLongPromoTime", "getSuperPromoTime", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final int getFirstYearSalePromoPercentage() {
                String priceGroup = Experiments.getInstance().getPriceGroup();
                String promoType = getPromoType();
                int iHashCode = promoType.hashCode();
                if (iHashCode != 71437132) {
                    if (iHashCode != 1074537836) {
                        if (iHashCode == 1342536459 && promoType.equals("SUPER_PROMO")) {
                            return Intrinsics.areEqual(priceGroup, "HIGH") ? 65 : 75;
                        }
                    } else if (promoType.equals("LONG_PROMO")) {
                        if (Intrinsics.areEqual(priceGroup, "NORMAL")) {
                            return 65;
                        }
                        return Intrinsics.areEqual(priceGroup, "LOW") ? 75 : 50;
                    }
                } else if (promoType.equals("SHORT_PROMO")) {
                    if (Intrinsics.areEqual(priceGroup, "NORMAL")) {
                        return 50;
                    }
                    return Intrinsics.areEqual(priceGroup, "LOW") ? 65 : 30;
                }
                if (Intrinsics.areEqual(priceGroup, "LOW")) {
                    return 50;
                }
                return Intrinsics.areEqual(priceGroup, "NORMAL") ? 30 : 0;
            }

            private final int getLifetimeSalePromoPercentage() {
                String priceGroup = Experiments.getInstance().getPriceGroup();
                String promoType = getPromoType();
                int iHashCode = promoType.hashCode();
                if (iHashCode != 71437132) {
                    if (iHashCode != 1074537836) {
                        if (iHashCode == 1342536459 && promoType.equals("SUPER_PROMO")) {
                            return Intrinsics.areEqual(priceGroup, "HIGH") ? 65 : 75;
                        }
                    } else if (promoType.equals("LONG_PROMO")) {
                        if (Intrinsics.areEqual(priceGroup, "NORMAL")) {
                            return 65;
                        }
                        return Intrinsics.areEqual(priceGroup, "LOW") ? 75 : 50;
                    }
                } else if (promoType.equals("SHORT_PROMO")) {
                    if (Intrinsics.areEqual(priceGroup, "NORMAL")) {
                        return 50;
                    }
                    return Intrinsics.areEqual(priceGroup, "LOW") ? 65 : 30;
                }
                if (Intrinsics.areEqual(priceGroup, "NORMAL")) {
                    return 30;
                }
                return Intrinsics.areEqual(priceGroup, "LOW") ? 50 : 0;
            }

            private final long getLongPromoTime() {
                String priceGroup = Experiments.getInstance().getPriceGroup();
                if (Intrinsics.areEqual(priceGroup, "HIGH")) {
                    return 1209600000L;
                }
                return Intrinsics.areEqual(priceGroup, "LOW") ? 518400000L : 864000000L;
            }

            public static /* synthetic */ double getPriceAmountInBaseCurrency$default(Companion companion, SkuDetails skuDetails, float f, int i, Object obj) {
                if ((i & 2) != 0) {
                    f = 0.85f;
                }
                return companion.getPriceAmountInBaseCurrency(skuDetails, f);
            }

            private final String getPromoType() {
                return isEligibleForSuperPromo() ? "SUPER_PROMO" : isEligibleForLongPromo() ? "LONG_PROMO" : isEligibleForShortPromo() ? "SHORT_PROMO" : "NO_PROMO";
            }

            private final long getShortPromoTime() {
                String priceGroup = Experiments.getInstance().getPriceGroup();
                if (Intrinsics.areEqual(priceGroup, "HIGH")) {
                    return 345600000L;
                }
                return Intrinsics.areEqual(priceGroup, "LOW") ? 172800000L : 259200000L;
            }

            private final long getSuperPromoTime() {
                String priceGroup = Experiments.getInstance().getPriceGroup();
                if (Intrinsics.areEqual(priceGroup, "HIGH")) {
                    return 5184000000L;
                }
                return Intrinsics.areEqual(priceGroup, "LOW") ? 1209600000L : 2592000000L;
            }

            private final int getYearlySalePromoPercentage() {
                return (Intrinsics.areEqual(getPromoType(), "NO_PROMO") && Intrinsics.areEqual(Experiments.getInstance().getPriceGroup(), "HIGH")) ? 0 : 30;
            }

            private final boolean isEligibleForLongPromo() {
                PromoEvent nextPromo;
                TrialFilter trialFilter = TrialFilter.getInstance();
                if (Experiments.getInstance().isSegmentationHoldout() && trialFilter.isTrial()) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Long firstUsedTime = trialFilter.getFirstUsedTime();
                    firstUsedTime.getClass();
                    if (jCurrentTimeMillis - firstUsedTime.longValue() >= 1036800000) {
                        SharedApplicationContext.getSettings().getRecordsCount();
                    }
                }
                Companion companion = PurchaseType.INSTANCE;
                if (!companion.isEligibleForSuperPromo() && (nextPromo = SharedApplicationContext.getSettings().getNextPromo()) != null && nextPromo.getSale() > 30 && nextPromo.getInterval().isIn(System.currentTimeMillis())) {
                    return true;
                }
                if (!trialFilter.isTrial()) {
                    return false;
                }
                long longPromoTime = companion.getLongPromoTime();
                long superPromoTime = companion.getSuperPromoTime();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                Long firstUsedTime2 = trialFilter.getFirstUsedTime();
                firstUsedTime2.getClass();
                long jLongValue = jCurrentTimeMillis2 - firstUsedTime2.longValue();
                return longPromoTime <= jLongValue && jLongValue < superPromoTime && SharedApplicationContext.getSettings().getRecordsCount() >= 14;
            }

            private final boolean isEligibleForShortPromo() {
                PromoEvent nextPromo;
                TrialFilter trialFilter = TrialFilter.getInstance();
                if (Experiments.getInstance().isSegmentationHoldout() && trialFilter.isTrial()) {
                    System.currentTimeMillis();
                    Long firstUsedTime = trialFilter.getFirstUsedTime();
                    firstUsedTime.getClass();
                    firstUsedTime.longValue();
                }
                Companion companion = PurchaseType.INSTANCE;
                if (!companion.isEligibleForSuperPromo() && (nextPromo = SharedApplicationContext.getSettings().getNextPromo()) != null && nextPromo.getSale() <= 30 && nextPromo.getInterval().isIn(System.currentTimeMillis())) {
                    return true;
                }
                if (!trialFilter.isTrial()) {
                    return false;
                }
                long shortPromoTime = companion.getShortPromoTime();
                long longPromoTime = companion.getLongPromoTime();
                long jCurrentTimeMillis = System.currentTimeMillis();
                Long firstUsedTime2 = trialFilter.getFirstUsedTime();
                firstUsedTime2.getClass();
                long jLongValue = jCurrentTimeMillis - firstUsedTime2.longValue();
                return shortPromoTime <= jLongValue && jLongValue < longPromoTime;
            }

            private final boolean isEligibleForSuperPromo() {
                TrialFilter trialFilter = TrialFilter.getInstance();
                if (Experiments.getInstance().isSegmentationHoldout() || !trialFilter.isTrial()) {
                    return false;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                Long firstUsedTime = trialFilter.getFirstUsedTime();
                firstUsedTime.getClass();
                return jCurrentTimeMillis - firstUsedTime.longValue() >= PurchaseType.INSTANCE.getSuperPromoTime() || SharedApplicationContext.getSettings().getRecordsCount() >= 30;
            }

            public final List<PurchaseType> activeProducts() {
                return CollectionsKt.mutableListOf(PurchaseType.LIFETIME, PurchaseType.LIFETIME_70, PurchaseType.LIFETIME_50, PurchaseType.LIFETIME_35, PurchaseType.LIFETIME_143, PurchaseType.YEARLY_SUBSCRIPTION, PurchaseType.YEARLY_70_SUBSCRIPTION, PurchaseType.YEARLY_50_SUBSCRIPTION, PurchaseType.YEARLY_35_SUBSCRIPTION, PurchaseType.YEARLY_25_SUBSCRIPTION, PurchaseType.YEARLY_143_SUBSCRIPTION, PurchaseType.MONTHLY_143_SUBSCRIPTION, PurchaseType.MONTHLY_SUBSCRIPTION);
            }

            public final int detectFirstYearSalePercentage() {
                int firstYearSalePromoPercentage = getFirstYearSalePromoPercentage();
                zza$$ExternalSyntheticOutline0.m(firstYearSalePromoPercentage, "Billing: SALE year ");
                return firstYearSalePromoPercentage;
            }

            public final PurchaseType detectLifetime() {
                PurchaseType eligibleLifetimeProduct = getEligibleLifetimeProduct();
                Logger.logInfo("Billing: PRODUCT LT " + eligibleLifetimeProduct);
                return eligibleLifetimeProduct;
            }

            public final PurchaseType detectLifetimeBase() {
                return getEligibleLifetimeBaseProduct();
            }

            public final PurchaseType detectMonthly() {
                PurchaseType eligibleMonthlyProduct = getEligibleMonthlyProduct();
                Logger.logInfo("Billing: PRODUCT Monthly " + eligibleMonthlyProduct);
                return eligibleMonthlyProduct;
            }

            public final int detectSalePercentage() {
                int lifetimeSalePromoPercentage = getLifetimeSalePromoPercentage();
                zza$$ExternalSyntheticOutline0.m(lifetimeSalePromoPercentage, "Billing: SALE ");
                return lifetimeSalePromoPercentage;
            }

            public final PurchaseType detectYearly() {
                PurchaseType eligibleYearlyProduct = getEligibleYearlyProduct();
                Logger.logInfo("Billing: PRODUCT Yearly " + eligibleYearlyProduct);
                return eligibleYearlyProduct;
            }

            public final PurchaseType detectYearlyBase() {
                return getEligibleYearlyBaseProduct();
            }

            public final int detectYearlySalePercentage() {
                int yearlySalePromoPercentage = getYearlySalePromoPercentage();
                zza$$ExternalSyntheticOutline0.m(yearlySalePromoPercentage, "Billing: SALE year ");
                return yearlySalePromoPercentage;
            }

            public final PurchaseType findOrNull(String sku) {
                sku.getClass();
                for (PurchaseType purchaseType : PurchaseType.values()) {
                    if (Intrinsics.areEqual(purchaseType.getPkg(), sku)) {
                        return purchaseType;
                    }
                }
                return null;
            }

            public final PurchaseType getEligibleLifetimeBaseProduct() {
                return PurchaseType.LIFETIME_143;
            }

            public final PurchaseType getEligibleLifetimeProduct() {
                String priceGroup = Experiments.getInstance().getPriceGroup();
                String promoType = getPromoType();
                int iHashCode = promoType.hashCode();
                if (iHashCode != 71437132) {
                    if (iHashCode != 1074537836) {
                        if (iHashCode == 1342536459 && promoType.equals("SUPER_PROMO")) {
                            return Intrinsics.areEqual(priceGroup, "HIGH") ? PurchaseType.LIFETIME_50 : Intrinsics.areEqual(priceGroup, "LOW") ? PurchaseType.LIFETIME_35 : PurchaseType.LIFETIME_35;
                        }
                    } else if (promoType.equals("LONG_PROMO")) {
                        return Intrinsics.areEqual(priceGroup, "HIGH") ? PurchaseType.LIFETIME_70 : Intrinsics.areEqual(priceGroup, "LOW") ? PurchaseType.LIFETIME_35 : PurchaseType.LIFETIME_50;
                    }
                } else if (promoType.equals("SHORT_PROMO")) {
                    return Intrinsics.areEqual(priceGroup, "HIGH") ? PurchaseType.LIFETIME : Intrinsics.areEqual(priceGroup, "LOW") ? PurchaseType.LIFETIME_50 : PurchaseType.LIFETIME_70;
                }
                return Intrinsics.areEqual(priceGroup, "HIGH") ? PurchaseType.LIFETIME_143 : Intrinsics.areEqual(priceGroup, "LOW") ? PurchaseType.LIFETIME_70 : PurchaseType.LIFETIME;
            }

            public final PurchaseType getEligibleMonthlyProduct() {
                return Intrinsics.areEqual(getPromoType(), "NO_PROMO") ? Intrinsics.areEqual(Experiments.getInstance().getPriceGroup(), "HIGH") ? PurchaseType.MONTHLY_143_SUBSCRIPTION : PurchaseType.MONTHLY_SUBSCRIPTION : PurchaseType.MONTHLY_SUBSCRIPTION;
            }

            public final PurchaseType getEligibleYearlyBaseProduct() {
                return PurchaseType.YEARLY_143_SUBSCRIPTION;
            }

            public final PurchaseType getEligibleYearlyProduct() {
                String priceGroup = Experiments.getInstance().getPriceGroup();
                String promoType = getPromoType();
                int iHashCode = promoType.hashCode();
                if (iHashCode != 71437132) {
                    if (iHashCode != 1074537836) {
                        if (iHashCode == 1342536459 && promoType.equals("SUPER_PROMO")) {
                            return Intrinsics.areEqual(priceGroup, "HIGH") ? PurchaseType.YEARLY_50_SUBSCRIPTION : Intrinsics.areEqual(priceGroup, "LOW") ? PurchaseType.YEARLY_25_SUBSCRIPTION : PurchaseType.YEARLY_25_SUBSCRIPTION;
                        }
                    } else if (promoType.equals("LONG_PROMO")) {
                        return Intrinsics.areEqual(priceGroup, "HIGH") ? PurchaseType.YEARLY_70_SUBSCRIPTION : Intrinsics.areEqual(priceGroup, "LOW") ? PurchaseType.YEARLY_25_SUBSCRIPTION : PurchaseType.YEARLY_35_SUBSCRIPTION;
                    }
                } else if (promoType.equals("SHORT_PROMO")) {
                    return Intrinsics.areEqual(priceGroup, "HIGH") ? PurchaseType.YEARLY_SUBSCRIPTION : Intrinsics.areEqual(priceGroup, "LOW") ? PurchaseType.YEARLY_35_SUBSCRIPTION : PurchaseType.YEARLY_50_SUBSCRIPTION;
                }
                return Intrinsics.areEqual(priceGroup, "HIGH") ? PurchaseType.YEARLY_143_SUBSCRIPTION : Intrinsics.areEqual(priceGroup, "LOW") ? PurchaseType.YEARLY_50_SUBSCRIPTION : PurchaseType.YEARLY_70_SUBSCRIPTION;
            }

            public final double getPriceAmount(SkuDetails detail) {
                detail.getClass();
                return ((detail.getIntroductoryPriceAmountMicros() != 0 ? detail.getIntroductoryPriceAmountMicros() : detail.getPriceAmountMicros()) * 0.85d) / 1000000.0d;
            }

            public final double getPriceAmountInBaseCurrency(SkuDetails detail, float share) {
                detail.getClass();
                Double d = ExchangeRate.INSTANCE.getRates().get(detail.getPriceCurrencyCode());
                if (d != null) {
                    return ((d.doubleValue() * (detail.getIntroductoryPriceAmountMicros() != 0 ? detail.getIntroductoryPriceAmountMicros() : detail.getPriceAmountMicros())) * ((double) share)) / 1000000.0d;
                }
                return -1.0d;
            }

            private Companion() {
            }

            public static /* synthetic */ double getPriceAmountInBaseCurrency$default(Companion companion, AdValue adValue, float f, int i, Object obj) {
                if ((i & 2) != 0) {
                    f = 0.85f;
                }
                return companion.getPriceAmountInBaseCurrency(adValue, f);
            }

            public final double getPriceAmountInBaseCurrency(AdValue adValue) {
                adValue.getClass();
                return getPriceAmountInBaseCurrency$default(this, adValue, 0.0f, 2, (Object) null);
            }

            public final double getPriceAmountInBaseCurrency(SkuDetails skuDetails) {
                skuDetails.getClass();
                return getPriceAmountInBaseCurrency$default(this, skuDetails, 0.0f, 2, (Object) null);
            }

            public final double getPriceAmountInBaseCurrency(AdValue detail, float share) {
                detail.getClass();
                Double d = ExchangeRate.INSTANCE.getRates().get(detail.getCurrencyCode());
                if (d != null) {
                    return ((d.doubleValue() * detail.getValueMicros()) * ((double) share)) / 1000000.0d;
                }
                return -1.0d;
            }
        }

        private static final /* synthetic */ PurchaseType[] $values() {
            return new PurchaseType[]{CLOUD_PREMIUM, MONTHLY_143_SUBSCRIPTION, MONTHLY_SUBSCRIPTION, YEARLY_SUBSCRIPTION, YEARLY_70_SUBSCRIPTION, YEARLY_50_SUBSCRIPTION, YEARLY_35_SUBSCRIPTION, YEARLY_25_SUBSCRIPTION, YEARLY_143_SUBSCRIPTION, LIFETIME, LIFETIME_70, LIFETIME_50, LIFETIME_35, LIFETIME_143, PROMO_SPECIAL, STANDARD, STANDARD_SUBSCRIPTION, WAKE_UP_MOTIVATION_HIGH, WAKE_UP_MOTIVATION_MEDIUM, PROMO, LONG_PROMO};
        }

        static {
            PurchaseType[] purchaseTypeArr$values = $values();
            $VALUES = purchaseTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(purchaseTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private PurchaseType(String str, int i, String str2, String str3) {
            this.pkg = str2;
            this.type = str3;
        }

        public static final List<PurchaseType> activeProducts() {
            return INSTANCE.activeProducts();
        }

        public static final int detectFirstYearSalePercentage() {
            return INSTANCE.detectFirstYearSalePercentage();
        }

        public static final PurchaseType detectLifetime() {
            return INSTANCE.detectLifetime();
        }

        public static final PurchaseType detectLifetimeBase() {
            return INSTANCE.detectLifetimeBase();
        }

        public static final PurchaseType detectMonthly() {
            return INSTANCE.detectMonthly();
        }

        public static final int detectSalePercentage() {
            return INSTANCE.detectSalePercentage();
        }

        public static final PurchaseType detectYearly() {
            return INSTANCE.detectYearly();
        }

        public static final PurchaseType detectYearlyBase() {
            return INSTANCE.detectYearlyBase();
        }

        public static final int detectYearlySalePercentage() {
            return INSTANCE.detectYearlySalePercentage();
        }

        public static final double getPriceAmountInBaseCurrency(AdValue adValue) {
            return INSTANCE.getPriceAmountInBaseCurrency(adValue);
        }

        public static PurchaseType valueOf(String str) {
            return (PurchaseType) Enum.valueOf(PurchaseType.class, str);
        }

        public static PurchaseType[] values() {
            return (PurchaseType[]) $VALUES.clone();
        }

        public final String getPkg() {
            return this.pkg;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0080\u0004¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u00020\u000eX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/trial/Billing$SafeResumeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "resumed", "", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SafeResumeContinuation<T> implements Continuation<T> {
        private final Continuation<T> continuation;
        private boolean resumed;

        /* JADX WARN: Multi-variable type inference failed */
        public SafeResumeContinuation(Continuation<? super T> continuation) {
            continuation.getClass();
            this.continuation = continuation;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.continuation.getContext();
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
            if (this.resumed) {
                Logger.logWarning("already resumed", null);
            } else {
                this.resumed = true;
                this.continuation.resumeWith(result);
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$acknowledge$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing", f = "Billing.kt", l = {799}, m = "acknowledge", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Billing.this.acknowledge(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$acknowledge$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/android/billingclient/api/BillingResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing$acknowledge$2", f = "Billing.kt", l = {800}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BillingResult>, Object> {
        final /* synthetic */ AcknowledgePurchaseParams $acknowledgePurchaseParams;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AcknowledgePurchaseParams acknowledgePurchaseParams, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$acknowledgePurchaseParams = acknowledgePurchaseParams;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Billing.this.new AnonymousClass2(this.$acknowledgePurchaseParams, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BillingResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            BillingClient client = Billing.this.getClient();
            AcknowledgePurchaseParams acknowledgePurchaseParams = this.$acknowledgePurchaseParams;
            this.label = 1;
            Object objAcknowledgePurchase = BillingClientKotlinKt.acknowledgePurchase(client, acknowledgePurchaseParams, this);
            return objAcknowledgePurchase == coroutine_suspended ? coroutine_suspended : objAcknowledgePurchase;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$consume$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/trial/ConsumeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing$consume$2", f = "Billing.kt", l = {785}, m = "invokeSuspend", v = 2)
    public static final class C22142 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ConsumeResult>, Object> {
        final /* synthetic */ Purchase $this_consume;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ Billing this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22142(Purchase purchase, Billing billing, Continuation<? super C22142> continuation) {
            super(2, continuation);
            this.$this_consume = purchase;
            this.this$0 = billing;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C22142(this.$this_consume, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ConsumeResult> continuation) {
            return ((C22142) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            ConsumeParams consumeParamsBuild = ConsumeParams.newBuilder().setPurchaseToken(this.$this_consume.getPurchaseToken()).build();
            consumeParamsBuild.getClass();
            final Billing billing = this.this$0;
            final Purchase purchase = this.$this_consume;
            this.L$0 = consumeParamsBuild;
            this.L$1 = billing;
            this.L$2 = purchase;
            this.label = 1;
            final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
            billing.getClient().consumeAsync(consumeParamsBuild, new ConsumeResponseListener() { // from class: com.urbandroid.sleep.trial.Billing$consume$2$1$1
                @Override // com.android.billingclient.api.ConsumeResponseListener
                public final void onConsumeResponse(BillingResult billingResult, String str) {
                    billingResult.getClass();
                    str.getClass();
                    Billing billing2 = billing;
                    ArrayList<String> skus = purchase.getSkus();
                    skus.getClass();
                    String strJoinToString$default = CollectionsKt.joinToString$default(skus, null, null, null, new Function1<String, CharSequence>() { // from class: com.urbandroid.sleep.trial.Billing$consume$2$1$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final CharSequence invoke(String str2) {
                            return FileInsert$$ExternalSyntheticOutline0.m(" ", str2, " ");
                        }
                    }, 31);
                    String orderId = purchase.getOrderId();
                    String strPretty = BillingKt.pretty(billingResult);
                    StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("consume result: ", strJoinToString$default, " ", orderId, " - ");
                    sbM6m.append(strPretty);
                    String string = sbM6m.toString();
                    Logger.logInfo(Logger.defaultTag, billing2.getTag() + ": " + string, null);
                    Continuation<ConsumeResult> continuation = safeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m2357constructorimpl(new ConsumeResult(billingResult, str)));
                }
            });
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            return orThrow == coroutine_suspended ? coroutine_suspended : orThrow;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$consumeSku$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing$consumeSku$2", f = "Billing.kt", l = {1118, 669, 1136, 669}, m = "invokeSuspend", v = 2)
    public static final class C22152 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ String $skuPrefix;
        final /* synthetic */ String $type;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22152(String str, String str2, Continuation<? super C22152> continuation) {
            super(2, continuation);
            this.$type = str;
            this.$skuPrefix = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence invokeSuspend$lambda$0$1$0(String str) {
            return FileInsert$$ExternalSyntheticOutline0.m(" ", str, " ");
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Billing.this.new C22152(this.$type, this.$skuPrefix, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
            return ((C22152) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(6:0|2|(1:(4:(2:118|(1:(6:8|9|10|107|101|(3:103|(4:106|107|101|(4:108|78|111|112)(0))|105)(0))(2:13|14))(8:15|16|17|75|(1:77)(2:79|(3:81|82|83)(2:84|(6:86|(4:89|(2:91|121)(5:92|(3:95|(3:122|97|120)(1:99)|93)|123|91|121)|98|87)|119|100|101|(0)(0))(1:110)))|78|111|112))(7:18|115|19|20|64|58|(2:60|(2:62|105)(4:63|64|58|(4:65|33|68|69)(0)))(0))|12|113|114)(1:23))(3:24|(1:27)|105)|117|28|(5:30|(1:32)(2:36|(3:38|39|40)(2:41|(6:43|(4:46|(2:48|126)(5:49|(3:52|(3:128|54|125)(1:56)|50)|127|48|126)|55|44)|124|57|58|(0)(0))(1:67)))|33|68|69)(3:70|71|(2:73|105)(6:74|75|(0)(0)|78|111|112))) */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x01a5, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x01a6, code lost:
        
            r4 = null;
         */
        /* JADX WARN: Removed duplicated region for block: B:103:0x0452 A[Catch: all -> 0x01a5, TryCatch #1 {all -> 0x01a5, blocks: (B:101:0x044c, B:103:0x0452, B:108:0x0501, B:75:0x0353, B:77:0x035b, B:79:0x0391, B:81:0x03a8, B:84:0x03e4, B:86:0x03ea, B:87:0x03f5, B:89:0x03fb, B:92:0x0412, B:93:0x0416, B:95:0x041c, B:97:0x042f, B:100:0x0438, B:58:0x0260, B:60:0x0266, B:65:0x030c, B:28:0x0158, B:30:0x0162, B:32:0x016f, B:36:0x01a9, B:38:0x01c0, B:41:0x01fc, B:43:0x0202, B:44:0x020d, B:46:0x0213, B:49:0x022a, B:50:0x022e, B:52:0x0234, B:54:0x0247, B:57:0x0250, B:71:0x031c), top: B:117:0x0158 }] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0501 A[Catch: all -> 0x01a5, TRY_LEAVE, TryCatch #1 {all -> 0x01a5, blocks: (B:101:0x044c, B:103:0x0452, B:108:0x0501, B:75:0x0353, B:77:0x035b, B:79:0x0391, B:81:0x03a8, B:84:0x03e4, B:86:0x03ea, B:87:0x03f5, B:89:0x03fb, B:92:0x0412, B:93:0x0416, B:95:0x041c, B:97:0x042f, B:100:0x0438, B:58:0x0260, B:60:0x0266, B:65:0x030c, B:28:0x0158, B:30:0x0162, B:32:0x016f, B:36:0x01a9, B:38:0x01c0, B:41:0x01fc, B:43:0x0202, B:44:0x020d, B:46:0x0213, B:49:0x022a, B:50:0x022e, B:52:0x0234, B:54:0x0247, B:57:0x0250, B:71:0x031c), top: B:117:0x0158 }] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0266 A[Catch: all -> 0x01a5, TryCatch #1 {all -> 0x01a5, blocks: (B:101:0x044c, B:103:0x0452, B:108:0x0501, B:75:0x0353, B:77:0x035b, B:79:0x0391, B:81:0x03a8, B:84:0x03e4, B:86:0x03ea, B:87:0x03f5, B:89:0x03fb, B:92:0x0412, B:93:0x0416, B:95:0x041c, B:97:0x042f, B:100:0x0438, B:58:0x0260, B:60:0x0266, B:65:0x030c, B:28:0x0158, B:30:0x0162, B:32:0x016f, B:36:0x01a9, B:38:0x01c0, B:41:0x01fc, B:43:0x0202, B:44:0x020d, B:46:0x0213, B:49:0x022a, B:50:0x022e, B:52:0x0234, B:54:0x0247, B:57:0x0250, B:71:0x031c), top: B:117:0x0158 }] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x030c A[Catch: all -> 0x01a5, TRY_LEAVE, TryCatch #1 {all -> 0x01a5, blocks: (B:101:0x044c, B:103:0x0452, B:108:0x0501, B:75:0x0353, B:77:0x035b, B:79:0x0391, B:81:0x03a8, B:84:0x03e4, B:86:0x03ea, B:87:0x03f5, B:89:0x03fb, B:92:0x0412, B:93:0x0416, B:95:0x041c, B:97:0x042f, B:100:0x0438, B:58:0x0260, B:60:0x0266, B:65:0x030c, B:28:0x0158, B:30:0x0162, B:32:0x016f, B:36:0x01a9, B:38:0x01c0, B:41:0x01fc, B:43:0x0202, B:44:0x020d, B:46:0x0213, B:49:0x022a, B:50:0x022e, B:52:0x0234, B:54:0x0247, B:57:0x0250, B:71:0x031c), top: B:117:0x0158 }] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x035b A[Catch: all -> 0x01a5, TryCatch #1 {all -> 0x01a5, blocks: (B:101:0x044c, B:103:0x0452, B:108:0x0501, B:75:0x0353, B:77:0x035b, B:79:0x0391, B:81:0x03a8, B:84:0x03e4, B:86:0x03ea, B:87:0x03f5, B:89:0x03fb, B:92:0x0412, B:93:0x0416, B:95:0x041c, B:97:0x042f, B:100:0x0438, B:58:0x0260, B:60:0x0266, B:65:0x030c, B:28:0x0158, B:30:0x0162, B:32:0x016f, B:36:0x01a9, B:38:0x01c0, B:41:0x01fc, B:43:0x0202, B:44:0x020d, B:46:0x0213, B:49:0x022a, B:50:0x022e, B:52:0x0234, B:54:0x0247, B:57:0x0250, B:71:0x031c), top: B:117:0x0158 }] */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0391 A[Catch: all -> 0x01a5, TryCatch #1 {all -> 0x01a5, blocks: (B:101:0x044c, B:103:0x0452, B:108:0x0501, B:75:0x0353, B:77:0x035b, B:79:0x0391, B:81:0x03a8, B:84:0x03e4, B:86:0x03ea, B:87:0x03f5, B:89:0x03fb, B:92:0x0412, B:93:0x0416, B:95:0x041c, B:97:0x042f, B:100:0x0438, B:58:0x0260, B:60:0x0266, B:65:0x030c, B:28:0x0158, B:30:0x0162, B:32:0x016f, B:36:0x01a9, B:38:0x01c0, B:41:0x01fc, B:43:0x0202, B:44:0x020d, B:46:0x0213, B:49:0x022a, B:50:0x022e, B:52:0x0234, B:54:0x0247, B:57:0x0250, B:71:0x031c), top: B:117:0x0158 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x04f5 -> B:107:0x04fb). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0300 -> B:64:0x0308). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            String str;
            Billing billing;
            Billing billing2;
            String str2;
            Mutex mutex;
            int i;
            int i2;
            String str3;
            Object objWithTimeout;
            int i3;
            String str4;
            int i4;
            Object refreshPurchaseState;
            int i5;
            Iterator it;
            PurchasesResult purchasesResult;
            Billing billing3;
            Billing billing4;
            int i6;
            int i7;
            int i8;
            BillingResult billingResult;
            BillingResult billingResult2;
            BillingResult billingResult3;
            Object refreshPurchaseState2;
            Iterator it2;
            Billing billing5;
            BillingResult billingResult4;
            int i9;
            Iterable iterable;
            Billing billing6;
            int i10;
            BillingResult billingResult5;
            int i11;
            PurchasesResult purchasesResult2;
            int i12;
            int i13;
            int i14;
            Iterable iterable2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i15 = this.label;
            String str5 = "Consuming: ";
            if (i15 == 0) {
                ResultKt.throwOnFailure(obj);
                Billing billing7 = Billing.this;
                String strM = Fragment$$ExternalSyntheticOutline1.m("consumeSku: ", this.$type, " ", this.$skuPrefix);
                Logger.logDebug(Logger.defaultTag, billing7.getTag() + ": " + strM, null);
                Billing billing8 = Billing.this;
                String str6 = this.$type;
                str = this.$skuPrefix;
                Mutex mutex2 = billing8.getMutex();
                this.L$0 = billing8;
                this.L$1 = billing8;
                this.L$2 = str6;
                this.L$3 = str;
                this.L$4 = mutex2;
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 1;
                if (mutex2.lock(null, this) != coroutine_suspended) {
                    billing = billing8;
                    billing2 = billing;
                    str2 = str6;
                    mutex = mutex2;
                    i = 0;
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i15 != 1) {
                if (i15 != 2) {
                    try {
                        if (i15 == 3) {
                            i4 = this.I$2;
                            i2 = this.I$1;
                            i3 = this.I$0;
                            mutex = (Mutex) this.L$4;
                            str4 = (String) this.L$3;
                            str2 = (String) this.L$2;
                            billing = (Billing) this.L$1;
                            billing2 = (Billing) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            str3 = "Consuming: ";
                            objWithTimeout = obj;
                            billingResult3 = (BillingResult) objWithTimeout;
                            if (billingResult3.getResponseCode() == 0) {
                                String str7 = "consumeSku: connect failure " + BillingKt.pretty(billingResult3);
                                Logger.logDebug(Logger.defaultTag, billing.getTag() + ": " + str7, null);
                                refreshPurchaseState2 = new RefreshPurchaseState(IBillingStatusListener.Status.REFRESH_ERROR, null);
                            } else {
                                PurchasesResult purchasesResult3 = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$consumeSku$2$1$result$1(billing, str2, null), 1, null);
                                if (purchasesResult3.getZza().getResponseCode() != 0) {
                                    String str8 = "consumeSku failed: " + BillingKt.pretty(purchasesResult3.getZza());
                                    Logger.logWarning(Logger.defaultTag, billing.getTag() + ": " + str8, null);
                                    RefreshPurchaseState refreshPurchaseState3 = new RefreshPurchaseState(IBillingStatusListener.Status.REFRESH_ERROR, null, 2, false ? 1 : 0);
                                    mutex.unlock(null);
                                    return refreshPurchaseState3;
                                }
                                List<Purchase> purchasesList = purchasesResult3.getPurchasesList();
                                if (purchasesList != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (Object obj2 : purchasesList) {
                                        ArrayList<String> skus = ((Purchase) obj2).getSkus();
                                        skus.getClass();
                                        if (skus.isEmpty()) {
                                            i14 = i4;
                                        } else {
                                            for (String str9 : skus) {
                                                i14 = i4;
                                                str9.getClass();
                                                if (StringsKt.startsWith$default(str9, str4)) {
                                                    arrayList.add(obj2);
                                                    break;
                                                }
                                                i4 = i14;
                                            }
                                            i14 = i4;
                                        }
                                        i4 = i14;
                                    }
                                    int i16 = i4;
                                    Billing billing9 = billing2;
                                    it2 = arrayList.iterator();
                                    billing5 = billing9;
                                    billingResult4 = billingResult3;
                                    i9 = i3;
                                    iterable = arrayList;
                                    billing6 = billing;
                                    i10 = 0;
                                    billingResult5 = billingResult4;
                                    i11 = i2;
                                    purchasesResult2 = purchasesResult3;
                                    i12 = 0;
                                    i13 = i16;
                                    if (it2.hasNext()) {
                                    }
                                } else {
                                    refreshPurchaseState2 = null;
                                }
                            }
                            mutex.unlock(null);
                            return refreshPurchaseState2;
                        }
                        if (i15 != 4) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        int i17 = this.I$4;
                        i10 = this.I$3;
                        i13 = this.I$2;
                        i11 = this.I$1;
                        i9 = this.I$0;
                        billingResult5 = (BillingResult) this.L$9;
                        it2 = (Iterator) this.L$6;
                        iterable = (Iterable) this.L$5;
                        PurchasesResult purchasesResult4 = (PurchasesResult) this.L$4;
                        BillingResult billingResult6 = (BillingResult) this.L$3;
                        mutex = (Mutex) this.L$2;
                        billing6 = (Billing) this.L$1;
                        billing5 = (Billing) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        str3 = "Consuming: ";
                        PurchasesResult purchasesResult5 = purchasesResult4;
                        BillingResult billingResult7 = billingResult6;
                        i12 = i17;
                        purchasesResult2 = purchasesResult5;
                        billingResult4 = billingResult7;
                        if (it2.hasNext()) {
                            Object next = it2.next();
                            Billing billing10 = billing5;
                            Purchase purchase = (Purchase) next;
                            ArrayList<String> skus2 = purchase.getSkus();
                            skus2.getClass();
                            purchasesResult5 = purchasesResult2;
                            billingResult7 = billingResult4;
                            String strJoinToString$default = CollectionsKt.joinToString$default(skus2, null, null, null, new Billing$$ExternalSyntheticLambda1(1), 31);
                            StringBuilder sb = new StringBuilder();
                            BillingResult billingResult8 = billingResult5;
                            String str10 = str3;
                            sb.append(str10);
                            sb.append(strJoinToString$default);
                            String string = sb.toString();
                            String str11 = Logger.defaultTag;
                            str3 = str10;
                            StringBuilder sb2 = new StringBuilder();
                            Iterable iterable3 = iterable;
                            sb2.append(billing6.getTag());
                            sb2.append(": ");
                            sb2.append(string);
                            Logger.logInfo(str11, sb2.toString(), null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(billing10);
                            this.L$1 = billing6;
                            this.L$2 = mutex;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(billingResult7);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(purchasesResult5);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(iterable3);
                            this.L$6 = it2;
                            this.L$7 = SpillingKt.nullOutSpilledVariable(next);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(purchase);
                            this.L$9 = SpillingKt.nullOutSpilledVariable(billingResult8);
                            this.I$0 = i9;
                            this.I$1 = i11;
                            this.I$2 = i13;
                            this.I$3 = i10;
                            this.I$4 = i12;
                            this.I$5 = 0;
                            this.label = 4;
                            if (billing6.consume(purchase, this) != coroutine_suspended) {
                                billing5 = billing10;
                                billingResult5 = billingResult8;
                                iterable = iterable3;
                                purchasesResult2 = purchasesResult5;
                                billingResult4 = billingResult7;
                                if (it2.hasNext()) {
                                    refreshPurchaseState2 = Unit.INSTANCE;
                                    mutex.unlock(null);
                                    return refreshPurchaseState2;
                                }
                            }
                            return coroutine_suspended;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } else {
                    int i18 = this.I$4;
                    int i19 = this.I$3;
                    int i20 = this.I$2;
                    i5 = this.I$1;
                    int i21 = this.I$0;
                    it = (Iterator) this.L$6;
                    Iterable iterable4 = (Iterable) this.L$5;
                    purchasesResult = (PurchasesResult) this.L$4;
                    billingResult = (BillingResult) this.L$3;
                    Mutex mutex3 = (Mutex) this.L$2;
                    billing3 = (Billing) this.L$1;
                    billing4 = (Billing) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        i8 = i18;
                        i = i21;
                        mutex = mutex3;
                        i7 = i19;
                        i6 = i20;
                        String str12 = "Consuming: ";
                        Iterable iterable5 = iterable4;
                        str5 = str12;
                        iterable2 = iterable5;
                        if (it.hasNext()) {
                            Object next2 = it.next();
                            Billing billing11 = billing4;
                            Purchase purchase2 = (Purchase) next2;
                            ArrayList<String> skus3 = purchase2.getSkus();
                            skus3.getClass();
                            Iterable iterable6 = iterable2;
                            PurchasesResult purchasesResult6 = purchasesResult;
                            String str13 = str5 + CollectionsKt.joinToString$default(skus3, null, null, null, new Billing$$ExternalSyntheticLambda1(1), 31);
                            String str14 = Logger.defaultTag;
                            BillingResult billingResult9 = billingResult;
                            StringBuilder sb3 = new StringBuilder();
                            str12 = str5;
                            sb3.append(billing3.getTag());
                            sb3.append(": ");
                            sb3.append(str13);
                            Logger.logInfo(str14, sb3.toString(), null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(billing11);
                            this.L$1 = billing3;
                            this.L$2 = mutex;
                            this.L$3 = SpillingKt.nullOutSpilledVariable(billingResult9);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(purchasesResult6);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(iterable6);
                            this.L$6 = it;
                            this.L$7 = SpillingKt.nullOutSpilledVariable(next2);
                            this.L$8 = SpillingKt.nullOutSpilledVariable(purchase2);
                            this.I$0 = i;
                            this.I$1 = i5;
                            this.I$2 = i6;
                            this.I$3 = i7;
                            this.I$4 = i8;
                            this.I$5 = 0;
                            this.label = 2;
                            if (billing3.consume(purchase2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            billing4 = billing11;
                            billingResult = billingResult9;
                            iterable5 = iterable6;
                            purchasesResult = purchasesResult6;
                            str5 = str12;
                            iterable2 = iterable5;
                            if (it.hasNext()) {
                                refreshPurchaseState = Unit.INSTANCE;
                                mutex.unlock(null);
                                return refreshPurchaseState;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        mutex = mutex3;
                    }
                }
                Object obj3 = null;
                mutex.unlock(obj3);
                throw th;
            }
            int i22 = this.I$1;
            int i23 = this.I$0;
            Mutex mutex4 = (Mutex) this.L$4;
            String str15 = (String) this.L$3;
            String str16 = (String) this.L$2;
            Billing billing12 = (Billing) this.L$1;
            Billing billing13 = (Billing) this.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i22;
            i = i23;
            billing2 = billing13;
            billing = billing12;
            str2 = str16;
            mutex = mutex4;
            str = str15;
            if (!billing2.getClient().isReady()) {
                str3 = "Consuming: ";
                String str17 = str;
                long secondsInMillis = Utils.getSecondsInMillis(10);
                Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, billing2);
                this.L$0 = SpillingKt.nullOutSpilledVariable(billing2);
                this.L$1 = billing;
                this.L$2 = str2;
                this.L$3 = str17;
                this.L$4 = mutex;
                this.L$5 = SpillingKt.nullOutSpilledVariable(this);
                this.I$0 = i;
                this.I$1 = i2;
                this.I$2 = 0;
                this.J$0 = secondsInMillis;
                this.I$3 = 0;
                this.label = 3;
                objWithTimeout = TimeoutKt.withTimeout(secondsInMillis, billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1, this);
                if (objWithTimeout == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i3 = i;
                str4 = str17;
                i4 = 0;
                billingResult3 = (BillingResult) objWithTimeout;
                if (billingResult3.getResponseCode() == 0) {
                }
                mutex.unlock(null);
                return refreshPurchaseState2;
            }
            BillingResult billingResult10 = BillingKt.billingResult(0, "Connected");
            if (billingResult10.getResponseCode() != 0) {
                String str18 = "consumeSku: connect failure " + BillingKt.pretty(billingResult10);
                Logger.logDebug(Logger.defaultTag, billing.getTag() + ": " + str18, null);
                refreshPurchaseState = new RefreshPurchaseState(IBillingStatusListener.Status.REFRESH_ERROR, null);
            } else {
                PurchasesResult purchasesResult7 = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$consumeSku$2$1$result$1(billing, str2, null), 1, null);
                if (purchasesResult7.getZza().getResponseCode() != 0) {
                    String str19 = "consumeSku failed: " + BillingKt.pretty(purchasesResult7.getZza());
                    Logger.logWarning(Logger.defaultTag, billing.getTag() + ": " + str19, null);
                    RefreshPurchaseState refreshPurchaseState4 = new RefreshPurchaseState(IBillingStatusListener.Status.REFRESH_ERROR, null, 2, false ? 1 : 0);
                    mutex.unlock(null);
                    return refreshPurchaseState4;
                }
                List<Purchase> purchasesList2 = purchasesResult7.getPurchasesList();
                if (purchasesList2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj4 : purchasesList2) {
                        ArrayList<String> skus4 = ((Purchase) obj4).getSkus();
                        skus4.getClass();
                        if (skus4.isEmpty()) {
                            billingResult2 = billingResult10;
                        } else {
                            for (String str20 : skus4) {
                                billingResult2 = billingResult10;
                                str20.getClass();
                                if (StringsKt.startsWith$default(str20, str)) {
                                    arrayList2.add(obj4);
                                    break;
                                }
                                billingResult10 = billingResult2;
                            }
                            billingResult2 = billingResult10;
                        }
                        billingResult10 = billingResult2;
                    }
                    BillingResult billingResult11 = billingResult10;
                    i5 = i2;
                    it = arrayList2.iterator();
                    purchasesResult = purchasesResult7;
                    billing3 = billing;
                    billing4 = billing2;
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                    billingResult = billingResult11;
                    iterable2 = arrayList2;
                    if (it.hasNext()) {
                    }
                } else {
                    refreshPurchaseState = null;
                }
            }
            mutex.unlock(null);
            return refreshPurchaseState;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, (Continuation<Object>) continuation);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$loadSkuDetails$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing", f = "Billing.kt", l = {565}, m = "loadSkuDetails", v = 2)
    public static final class C22161 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C22161(Continuation<? super C22161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Billing.this.loadSkuDetails(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$loadSkuDetails$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/SkuDetails;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing$loadSkuDetails$2", f = "Billing.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class C22172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SkuDetails>>, Object> {
        int label;

        public C22172(Continuation<? super C22172> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Billing.this.new C22172(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends SkuDetails>> continuation) {
            return ((C22172) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            Billing billing = Billing.this;
            Logger.logInfo(Logger.defaultTag, billing.getTag() + ": sku loading ...", null);
            Set<String> stringSet = Billing.this.getPrefs().getStringSet("sku-details", null);
            if (stringSet == null) {
                return null;
            }
            Billing billing2 = Billing.this;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(stringSet, 10));
            for (String str : stringSet) {
                SkuDetails skuDetails = new SkuDetails(str);
                String strM = FileInsert$$ExternalSyntheticOutline0.m("sku loaded: \n", str);
                Logger.logInfo(Logger.defaultTag, billing2.getTag() + ": " + strM, null);
                arrayList.add(skuDetails);
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$purchase$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing", f = "Billing.kt", l = {1117, 506, 518, 1126, 506, 518}, m = "purchase", v = 2)
    public static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Billing.this.purchase(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$queryPurchaseHistory$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing$queryPurchaseHistory$2", f = "Billing.kt", l = {1117, 615, 1124, 615}, m = "invokeSuspend", v = 2)
    public static final class C22182 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PurchaseHistoryRecord>>, Object> {
        final /* synthetic */ String $type;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22182(String str, Continuation<? super C22182> continuation) {
            super(2, continuation);
            this.$type = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Billing.this.new C22182(this.$type, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PurchaseHistoryRecord>> continuation) {
            return ((C22182) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0139 A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:16:0x004e, B:48:0x0131, B:50:0x0139, B:51:0x013e), top: B:62:0x004e }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x013e A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #1 {all -> 0x0053, blocks: (B:16:0x004e, B:48:0x0131, B:50:0x0139, B:51:0x013e), top: B:62:0x004e }] */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Billing billing;
            Mutex mutex;
            Billing billing2;
            String str;
            int i;
            int i2;
            int i3;
            Mutex mutex2;
            String str2;
            Billing billing3;
            int i4;
            int i5;
            Mutex mutex3;
            List listEmptyList;
            BillingResult billingResult;
            Mutex mutex4;
            List listEmptyList2;
            ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i6 = this.label;
            try {
                try {
                    if (i6 == 0) {
                        ResultKt.throwOnFailure(obj);
                        billing = Billing.this;
                        String str3 = this.$type;
                        mutex = billing.getMutex();
                        this.L$0 = billing;
                        this.L$1 = billing;
                        this.L$2 = str3;
                        this.L$3 = mutex;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 1;
                        if (mutex.lock(null, this) != coroutine_suspended) {
                            billing2 = billing;
                            str = str3;
                            i = 0;
                            i2 = 0;
                        }
                        return coroutine_suspended;
                    }
                    if (i6 != 1) {
                        if (i6 == 2) {
                            mutex3 = (Mutex) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            listEmptyList = (List) obj;
                            mutex = mutex3;
                            mutex.unlock(null);
                            return listEmptyList;
                        }
                        if (i6 != 3) {
                            if (i6 != 4) {
                                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                                return null;
                            }
                            mutex4 = (Mutex) this.L$1;
                            ResultKt.throwOnFailure(obj);
                            listEmptyList2 = (List) obj;
                            mutex2 = mutex4;
                            mutex2.unlock(null);
                            return listEmptyList2;
                        }
                        i5 = this.I$2;
                        i4 = this.I$1;
                        i3 = this.I$0;
                        mutex2 = (Mutex) this.L$3;
                        str2 = (String) this.L$2;
                        billing3 = (Billing) this.L$1;
                        billing2 = (Billing) this.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            billingResult = (BillingResult) obj;
                            if (billingResult.getResponseCode() == 0) {
                                listEmptyList2 = CollectionsKt.emptyList();
                                mutex2.unlock(null);
                                return listEmptyList2;
                            }
                            CoroutineDispatcher io2 = Dispatchers.getIO();
                            Billing$queryPurchaseHistory$2$1$1 billing$queryPurchaseHistory$2$1$1 = new Billing$queryPurchaseHistory$2$1$1(billing3, str2, null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(billing2);
                            this.L$1 = mutex2;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(billingResult);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(billingResult);
                            this.L$4 = null;
                            this.I$0 = i3;
                            this.I$1 = i4;
                            this.I$2 = i5;
                            this.I$3 = 0;
                            this.label = 4;
                            obj = BuildersKt.withContext(io2, billing$queryPurchaseHistory$2$1$1, this);
                            if (obj != coroutine_suspended) {
                                mutex4 = mutex2;
                                listEmptyList2 = (List) obj;
                                mutex2 = mutex4;
                                mutex2.unlock(null);
                                return listEmptyList2;
                            }
                            return coroutine_suspended;
                        } catch (Throwable th) {
                            th = th;
                            coroutine_suspended = mutex2;
                            coroutine_suspended.unlock(null);
                            throw th;
                        }
                    }
                    i = this.I$1;
                    i2 = this.I$0;
                    mutex = (Mutex) this.L$3;
                    str = (String) this.L$2;
                    Billing billing4 = (Billing) this.L$1;
                    Billing billing5 = (Billing) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    billing = billing4;
                    billing2 = billing5;
                    if (billing2.getClient().isReady()) {
                        BillingResult billingResult2 = BillingKt.billingResult(0, "Connected");
                        if (billingResult2.getResponseCode() != 0) {
                            listEmptyList = CollectionsKt.emptyList();
                            mutex.unlock(null);
                            return listEmptyList;
                        }
                        CoroutineDispatcher io3 = Dispatchers.getIO();
                        Billing$queryPurchaseHistory$2$1$1 billing$queryPurchaseHistory$2$1$12 = new Billing$queryPurchaseHistory$2$1$1(billing, str, null);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(billing2);
                        this.L$1 = mutex;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(billingResult2);
                        this.L$3 = null;
                        this.I$0 = i2;
                        this.I$1 = i;
                        this.I$2 = 0;
                        this.I$3 = 0;
                        this.label = 2;
                        obj = BuildersKt.withContext(io3, billing$queryPurchaseHistory$2$1$12, this);
                        if (obj != coroutine_suspended) {
                            mutex3 = mutex;
                            listEmptyList = (List) obj;
                            mutex = mutex3;
                            mutex.unlock(null);
                            return listEmptyList;
                        }
                    } else {
                        long secondsInMillis = Utils.getSecondsInMillis(10);
                        Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, billing2);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(billing2);
                        this.L$1 = billing;
                        this.L$2 = str;
                        this.L$3 = mutex;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(this);
                        this.I$0 = i2;
                        this.I$1 = i;
                        this.I$2 = 0;
                        this.J$0 = secondsInMillis;
                        this.I$3 = 0;
                        this.label = 3;
                        Object objWithTimeout = TimeoutKt.withTimeout(secondsInMillis, billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1, this);
                        if (objWithTimeout != coroutine_suspended) {
                            i3 = i2;
                            mutex2 = mutex;
                            str2 = str;
                            billing3 = billing;
                            obj = objWithTimeout;
                            i4 = i;
                            i5 = 0;
                            billingResult = (BillingResult) obj;
                            if (billingResult.getResponseCode() == 0) {
                            }
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    coroutine_suspended = mutex;
                    coroutine_suspended.unlock(null);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$querySkuDetails$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing", f = "Billing.kt", l = {578}, m = "querySkuDetails", v = 2)
    public static final class C22192 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C22192(Continuation<? super C22192> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Billing.this.querySkuDetails((List<? extends PurchaseType>) null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$querySkuDetails$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/android/billingclient/api/SkuDetailsResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing$querySkuDetails$6", f = "Billing.kt", l = {587}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SkuDetailsResult>, Object> {
        final /* synthetic */ SkuDetailsParams.Builder $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(SkuDetailsParams.Builder builder, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$params = builder;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Billing.this.new AnonymousClass6(this.$params, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SkuDetailsResult> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            BillingClient client = Billing.this.getClient();
            SkuDetailsParams skuDetailsParamsBuild = this.$params.build();
            skuDetailsParamsBuild.getClass();
            this.label = 1;
            Object objQuerySkuDetails = BillingClientKotlinKt.querySkuDetails(client, skuDetailsParamsBuild, this);
            return objQuerySkuDetails == coroutine_suspended ? coroutine_suspended : objQuerySkuDetails;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$refreshPurchaseState$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/urbandroid/sleep/trial/Billing$RefreshPurchaseState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing$refreshPurchaseState$2", f = "Billing.kt", l = {1118, 688, 718, 728, 730, 742, 1170, 688, 718, 728, 730, 742}, m = "invokeSuspend", v = 2)
    public static final class C22202 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RefreshPurchaseState>, Object> {
        final /* synthetic */ String $skuPrefix;
        final /* synthetic */ String $type;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C22202(String str, String str2, Continuation<? super C22202> continuation) {
            super(2, continuation);
            this.$type = str;
            this.$skuPrefix = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence invokeSuspend$lambda$0$0$0(String str) {
            return FileInsert$$ExternalSyntheticOutline0.m$1(str, ",");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence invokeSuspend$lambda$0$2$0(String str) {
            return FileInsert$$ExternalSyntheticOutline0.m(" ", str, " ");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence invokeSuspend$lambda$0$5$0(String str) {
            return FileInsert$$ExternalSyntheticOutline0.m$1(str, ",");
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Billing.this.new C22202(this.$type, this.$skuPrefix, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RefreshPurchaseState> continuation) {
            return ((C22202) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 30, insn: 0x03ca: MOVE (r7 I:??[OBJECT, ARRAY]) = (r30 I:??[OBJECT, ARRAY]), block:B:43:0x03c8 */
        /* JADX WARN: Not initialized variable reg: 32, insn: 0x0113: MOVE (r7 I:??[OBJECT, ARRAY]) = (r32 I:??[OBJECT, ARRAY]), block:B:17:0x0111 */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0787  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x0826 A[Catch: all -> 0x0867, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:125:0x086a A[Catch: all -> 0x0761, TRY_ENTER, TryCatch #1 {all -> 0x0761, blocks: (B:78:0x06a7, B:80:0x06af, B:81:0x06b5, B:83:0x06bb, B:85:0x06ce, B:118:0x07f4, B:125:0x086a, B:127:0x0874, B:128:0x087f), top: B:461:0x06a7 }] */
        /* JADX WARN: Removed duplicated region for block: B:150:0x08fe A[Catch: all -> 0x09ae, TryCatch #5 {all -> 0x09ae, blocks: (B:148:0x08f8, B:150:0x08fe, B:157:0x09b2), top: B:467:0x08f8 }] */
        /* JADX WARN: Removed duplicated region for block: B:157:0x09b2 A[Catch: all -> 0x09ae, TRY_LEAVE, TryCatch #5 {all -> 0x09ae, blocks: (B:148:0x08f8, B:150:0x08fe, B:157:0x09b2), top: B:467:0x08f8 }] */
        /* JADX WARN: Removed duplicated region for block: B:162:0x09ce A[Catch: all -> 0x0867, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:166:0x09e3 A[Catch: all -> 0x0867, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:182:0x0a3f A[Catch: all -> 0x0867, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:211:0x0c3f A[Catch: all -> 0x0867, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:221:0x0cd3 A[Catch: all -> 0x0867, Exception -> 0x0d8e, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:246:0x0e23 A[Catch: all -> 0x0867, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:252:0x0e37 A[Catch: all -> 0x0867, TRY_LEAVE, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:255:0x0e44 A[Catch: all -> 0x0867, TRY_ENTER, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:263:0x0ed6  */
        /* JADX WARN: Removed duplicated region for block: B:270:0x0f2b A[Catch: all -> 0x0636, TryCatch #8 {all -> 0x0636, blocks: (B:268:0x0f23, B:270:0x0f2b, B:271:0x0f60, B:272:0x0f79, B:274:0x0f83, B:60:0x05e7, B:62:0x05f1, B:64:0x0600, B:69:0x063b, B:70:0x0654, B:72:0x065e, B:74:0x0679, B:264:0x0ee4), top: B:473:0x05e7 }] */
        /* JADX WARN: Removed duplicated region for block: B:271:0x0f60 A[Catch: all -> 0x0636, TRY_LEAVE, TryCatch #8 {all -> 0x0636, blocks: (B:268:0x0f23, B:270:0x0f2b, B:271:0x0f60, B:272:0x0f79, B:274:0x0f83, B:60:0x05e7, B:62:0x05f1, B:64:0x0600, B:69:0x063b, B:70:0x0654, B:72:0x065e, B:74:0x0679, B:264:0x0ee4), top: B:473:0x05e7 }] */
        /* JADX WARN: Removed duplicated region for block: B:280:0x0fd5 A[Catch: all -> 0x0867, Exception -> 0x1088, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:303:0x109e  */
        /* JADX WARN: Removed duplicated region for block: B:312:0x113a A[Catch: all -> 0x0867, TRY_LEAVE, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:315:0x117b A[Catch: all -> 0x0867, TRY_ENTER, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:339:0x120c A[Catch: all -> 0x0bd8, TryCatch #29 {all -> 0x0bd8, blocks: (B:411:0x1605, B:413:0x160d, B:414:0x1613, B:416:0x1619, B:417:0x16a5, B:419:0x16ab, B:421:0x16ba, B:427:0x16ce, B:428:0x16d0, B:433:0x16fc, B:437:0x1753, B:438:0x1759, B:440:0x175f, B:444:0x176f, B:446:0x1773, B:449:0x1780, B:451:0x17f6, B:454:0x1802, B:432:0x16f2, B:369:0x1360, B:371:0x1366, B:373:0x1376, B:375:0x138e, B:389:0x1459, B:399:0x1518, B:401:0x1572, B:403:0x157f, B:405:0x158d, B:406:0x15ab, B:434:0x171b, B:337:0x1206, B:339:0x120c, B:344:0x12cc, B:204:0x0b82), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:344:0x12cc A[Catch: all -> 0x0bd8, TRY_LEAVE, TryCatch #29 {all -> 0x0bd8, blocks: (B:411:0x1605, B:413:0x160d, B:414:0x1613, B:416:0x1619, B:417:0x16a5, B:419:0x16ab, B:421:0x16ba, B:427:0x16ce, B:428:0x16d0, B:433:0x16fc, B:437:0x1753, B:438:0x1759, B:440:0x175f, B:444:0x176f, B:446:0x1773, B:449:0x1780, B:451:0x17f6, B:454:0x1802, B:432:0x16f2, B:369:0x1360, B:371:0x1366, B:373:0x1376, B:375:0x138e, B:389:0x1459, B:399:0x1518, B:401:0x1572, B:403:0x157f, B:405:0x158d, B:406:0x15ab, B:434:0x171b, B:337:0x1206, B:339:0x120c, B:344:0x12cc, B:204:0x0b82), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:350:0x12f2 A[Catch: all -> 0x0867, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:354:0x1307 A[Catch: all -> 0x0867, TryCatch #2 {all -> 0x0867, blocks: (B:348:0x12ec, B:350:0x12f2, B:351:0x12f6, B:352:0x1301, B:354:0x1307, B:357:0x131e, B:358:0x1322, B:360:0x1328, B:362:0x133b, B:364:0x1342, B:367:0x134b, B:278:0x0fcd, B:280:0x0fd5, B:281:0x0fdb, B:283:0x0fe1, B:285:0x100d, B:287:0x101b, B:289:0x1022, B:291:0x1042, B:309:0x10ee, B:310:0x1100, B:312:0x113a, B:315:0x117b, B:317:0x1185, B:318:0x1190, B:320:0x1196, B:323:0x11b0, B:324:0x11b4, B:326:0x11ba, B:328:0x11cd, B:330:0x11d3, B:332:0x11df, B:335:0x11ea, B:302:0x1093, B:304:0x10a6, B:219:0x0ccb, B:221:0x0cd3, B:222:0x0cd9, B:224:0x0cdf, B:225:0x0d6d, B:227:0x0d73, B:229:0x0d82, B:235:0x0d96, B:236:0x0d98, B:239:0x0dc0, B:243:0x0e17, B:244:0x0e1d, B:246:0x0e23, B:250:0x0e33, B:252:0x0e37, B:255:0x0e44, B:257:0x0eba, B:260:0x0ec6, B:238:0x0db7, B:180:0x0a39, B:182:0x0a3f, B:184:0x0a4f, B:186:0x0a65, B:200:0x0b27, B:209:0x0be7, B:211:0x0c3f, B:213:0x0c4c, B:215:0x0c5a, B:216:0x0c78, B:240:0x0ddf, B:160:0x09c8, B:162:0x09ce, B:163:0x09d2, B:164:0x09dd, B:166:0x09e3, B:169:0x09fa, B:170:0x09fe, B:172:0x0a04, B:174:0x0a17, B:176:0x0a1e, B:179:0x0a27, B:116:0x07de, B:120:0x0826), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:371:0x1366 A[Catch: all -> 0x0bd8, TryCatch #29 {all -> 0x0bd8, blocks: (B:411:0x1605, B:413:0x160d, B:414:0x1613, B:416:0x1619, B:417:0x16a5, B:419:0x16ab, B:421:0x16ba, B:427:0x16ce, B:428:0x16d0, B:433:0x16fc, B:437:0x1753, B:438:0x1759, B:440:0x175f, B:444:0x176f, B:446:0x1773, B:449:0x1780, B:451:0x17f6, B:454:0x1802, B:432:0x16f2, B:369:0x1360, B:371:0x1366, B:373:0x1376, B:375:0x138e, B:389:0x1459, B:399:0x1518, B:401:0x1572, B:403:0x157f, B:405:0x158d, B:406:0x15ab, B:434:0x171b, B:337:0x1206, B:339:0x120c, B:344:0x12cc, B:204:0x0b82), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:401:0x1572 A[Catch: all -> 0x0bd8, TryCatch #29 {all -> 0x0bd8, blocks: (B:411:0x1605, B:413:0x160d, B:414:0x1613, B:416:0x1619, B:417:0x16a5, B:419:0x16ab, B:421:0x16ba, B:427:0x16ce, B:428:0x16d0, B:433:0x16fc, B:437:0x1753, B:438:0x1759, B:440:0x175f, B:444:0x176f, B:446:0x1773, B:449:0x1780, B:451:0x17f6, B:454:0x1802, B:432:0x16f2, B:369:0x1360, B:371:0x1366, B:373:0x1376, B:375:0x138e, B:389:0x1459, B:399:0x1518, B:401:0x1572, B:403:0x157f, B:405:0x158d, B:406:0x15ab, B:434:0x171b, B:337:0x1206, B:339:0x120c, B:344:0x12cc, B:204:0x0b82), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:413:0x160d A[Catch: all -> 0x0bd8, Exception -> 0x16c6, TryCatch #29 {all -> 0x0bd8, blocks: (B:411:0x1605, B:413:0x160d, B:414:0x1613, B:416:0x1619, B:417:0x16a5, B:419:0x16ab, B:421:0x16ba, B:427:0x16ce, B:428:0x16d0, B:433:0x16fc, B:437:0x1753, B:438:0x1759, B:440:0x175f, B:444:0x176f, B:446:0x1773, B:449:0x1780, B:451:0x17f6, B:454:0x1802, B:432:0x16f2, B:369:0x1360, B:371:0x1366, B:373:0x1376, B:375:0x138e, B:389:0x1459, B:399:0x1518, B:401:0x1572, B:403:0x157f, B:405:0x158d, B:406:0x15ab, B:434:0x171b, B:337:0x1206, B:339:0x120c, B:344:0x12cc, B:204:0x0b82), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:440:0x175f A[Catch: all -> 0x0bd8, TryCatch #29 {all -> 0x0bd8, blocks: (B:411:0x1605, B:413:0x160d, B:414:0x1613, B:416:0x1619, B:417:0x16a5, B:419:0x16ab, B:421:0x16ba, B:427:0x16ce, B:428:0x16d0, B:433:0x16fc, B:437:0x1753, B:438:0x1759, B:440:0x175f, B:444:0x176f, B:446:0x1773, B:449:0x1780, B:451:0x17f6, B:454:0x1802, B:432:0x16f2, B:369:0x1360, B:371:0x1366, B:373:0x1376, B:375:0x138e, B:389:0x1459, B:399:0x1518, B:401:0x1572, B:403:0x157f, B:405:0x158d, B:406:0x15ab, B:434:0x171b, B:337:0x1206, B:339:0x120c, B:344:0x12cc, B:204:0x0b82), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:446:0x1773 A[Catch: all -> 0x0bd8, TRY_LEAVE, TryCatch #29 {all -> 0x0bd8, blocks: (B:411:0x1605, B:413:0x160d, B:414:0x1613, B:416:0x1619, B:417:0x16a5, B:419:0x16ab, B:421:0x16ba, B:427:0x16ce, B:428:0x16d0, B:433:0x16fc, B:437:0x1753, B:438:0x1759, B:440:0x175f, B:444:0x176f, B:446:0x1773, B:449:0x1780, B:451:0x17f6, B:454:0x1802, B:432:0x16f2, B:369:0x1360, B:371:0x1366, B:373:0x1376, B:375:0x138e, B:389:0x1459, B:399:0x1518, B:401:0x1572, B:403:0x157f, B:405:0x158d, B:406:0x15ab, B:434:0x171b, B:337:0x1206, B:339:0x120c, B:344:0x12cc, B:204:0x0b82), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:449:0x1780 A[Catch: all -> 0x0bd8, TRY_ENTER, TryCatch #29 {all -> 0x0bd8, blocks: (B:411:0x1605, B:413:0x160d, B:414:0x1613, B:416:0x1619, B:417:0x16a5, B:419:0x16ab, B:421:0x16ba, B:427:0x16ce, B:428:0x16d0, B:433:0x16fc, B:437:0x1753, B:438:0x1759, B:440:0x175f, B:444:0x176f, B:446:0x1773, B:449:0x1780, B:451:0x17f6, B:454:0x1802, B:432:0x16f2, B:369:0x1360, B:371:0x1366, B:373:0x1376, B:375:0x138e, B:389:0x1459, B:399:0x1518, B:401:0x1572, B:403:0x157f, B:405:0x158d, B:406:0x15ab, B:434:0x171b, B:337:0x1206, B:339:0x120c, B:344:0x12cc, B:204:0x0b82), top: B:463:0x003d }] */
        /* JADX WARN: Removed duplicated region for block: B:519:0x176e A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:540:0x0e32 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x05f1 A[Catch: all -> 0x0636, TryCatch #8 {all -> 0x0636, blocks: (B:268:0x0f23, B:270:0x0f2b, B:271:0x0f60, B:272:0x0f79, B:274:0x0f83, B:60:0x05e7, B:62:0x05f1, B:64:0x0600, B:69:0x063b, B:70:0x0654, B:72:0x065e, B:74:0x0679, B:264:0x0ee4), top: B:473:0x05e7 }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x06af A[Catch: all -> 0x0761, Exception -> 0x0772, TryCatch #1 {all -> 0x0761, blocks: (B:78:0x06a7, B:80:0x06af, B:81:0x06b5, B:83:0x06bb, B:85:0x06ce, B:118:0x07f4, B:125:0x086a, B:127:0x0874, B:128:0x087f), top: B:461:0x06a7 }] */
        /* JADX WARN: Type inference failed for: r11v31 */
        /* JADX WARN: Type inference failed for: r11v58, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r11v61 */
        /* JADX WARN: Type inference failed for: r11v71 */
        /* JADX WARN: Type inference failed for: r11v72 */
        /* JADX WARN: Type inference failed for: r18v3 */
        /* JADX WARN: Type inference failed for: r18v4 */
        /* JADX WARN: Type inference failed for: r18v5 */
        /* JADX WARN: Type inference failed for: r36v1 */
        /* JADX WARN: Type inference failed for: r36v10 */
        /* JADX WARN: Type inference failed for: r36v11 */
        /* JADX WARN: Type inference failed for: r36v12 */
        /* JADX WARN: Type inference failed for: r36v14 */
        /* JADX WARN: Type inference failed for: r36v15 */
        /* JADX WARN: Type inference failed for: r36v2 */
        /* JADX WARN: Type inference failed for: r36v3 */
        /* JADX WARN: Type inference failed for: r36v5 */
        /* JADX WARN: Type inference failed for: r36v6 */
        /* JADX WARN: Type inference failed for: r36v7 */
        /* JADX WARN: Type inference failed for: r36v8 */
        /* JADX WARN: Type inference failed for: r36v9 */
        /* JADX WARN: Type inference failed for: r4v14 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r4v17 */
        /* JADX WARN: Type inference failed for: r4v19 */
        /* JADX WARN: Type inference failed for: r4v7 */
        /* JADX WARN: Type inference failed for: r4v8 */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v101 */
        /* JADX WARN: Type inference failed for: r7v11 */
        /* JADX WARN: Type inference failed for: r7v124 */
        /* JADX WARN: Type inference failed for: r7v125, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r7v126 */
        /* JADX WARN: Type inference failed for: r7v127, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r7v129, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r7v137 */
        /* JADX WARN: Type inference failed for: r7v16 */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v19, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v20 */
        /* JADX WARN: Type inference failed for: r7v205 */
        /* JADX WARN: Type inference failed for: r7v215 */
        /* JADX WARN: Type inference failed for: r7v24 */
        /* JADX WARN: Type inference failed for: r7v25 */
        /* JADX WARN: Type inference failed for: r7v252 */
        /* JADX WARN: Type inference failed for: r7v253 */
        /* JADX WARN: Type inference failed for: r7v26 */
        /* JADX WARN: Type inference failed for: r7v260 */
        /* JADX WARN: Type inference failed for: r7v261 */
        /* JADX WARN: Type inference failed for: r7v262 */
        /* JADX WARN: Type inference failed for: r7v263 */
        /* JADX WARN: Type inference failed for: r7v264 */
        /* JADX WARN: Type inference failed for: r7v265 */
        /* JADX WARN: Type inference failed for: r7v266 */
        /* JADX WARN: Type inference failed for: r7v267 */
        /* JADX WARN: Type inference failed for: r7v268 */
        /* JADX WARN: Type inference failed for: r7v269 */
        /* JADX WARN: Type inference failed for: r7v27 */
        /* JADX WARN: Type inference failed for: r7v270 */
        /* JADX WARN: Type inference failed for: r7v271 */
        /* JADX WARN: Type inference failed for: r7v272 */
        /* JADX WARN: Type inference failed for: r7v273 */
        /* JADX WARN: Type inference failed for: r7v274 */
        /* JADX WARN: Type inference failed for: r7v275 */
        /* JADX WARN: Type inference failed for: r7v28 */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v30 */
        /* JADX WARN: Type inference failed for: r7v31 */
        /* JADX WARN: Type inference failed for: r7v32 */
        /* JADX WARN: Type inference failed for: r7v38 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v41 */
        /* JADX WARN: Type inference failed for: r7v42 */
        /* JADX WARN: Type inference failed for: r7v43 */
        /* JADX WARN: Type inference failed for: r7v45 */
        /* JADX WARN: Type inference failed for: r7v46 */
        /* JADX WARN: Type inference failed for: r7v5, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v90 */
        /* JADX WARN: Type inference failed for: r7v93 */
        /* JADX WARN: Type inference failed for: r7v94, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r7v97 */
        /* JADX WARN: Type inference failed for: r8v123 */
        /* JADX WARN: Type inference failed for: r8v124 */
        /* JADX WARN: Type inference failed for: r8v17 */
        /* JADX WARN: Type inference failed for: r8v38, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v40 */
        /* JADX WARN: Type inference failed for: r8v45 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:153:0x09a6 -> B:154:0x09aa). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:194:0x0b09 -> B:210:0x0c32). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:203:0x0b75 -> B:204:0x0b82). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:209:0x0be7 -> B:210:0x0c32). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:342:0x12bb -> B:343:0x12c1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:383:0x1435 -> B:400:0x1565). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:393:0x14af -> B:483:0x14bf). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:399:0x1518 -> B:400:0x1565). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object obj2;
            Object obj3;
            ?? r7;
            Object obj4;
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            Billing billing;
            Billing billing2;
            int i;
            int i2;
            Mutex mutex;
            String str8;
            String str9;
            int i3;
            String str10;
            String str11;
            Billing billing3;
            String str12;
            Object obj5;
            String str13;
            String str14;
            String str15;
            Object objWithTimeout;
            Billing billing4;
            int i4;
            String str16;
            BillingResult billingResult;
            Billing billing5;
            Billing billing6;
            Billing billing7;
            int i5;
            int i6;
            ?? r72;
            int i7;
            String str17;
            BillingResult billingResult2;
            int i8;
            Billing billing8;
            ?? r73;
            int i9;
            Object objQueryPurchaseHistory;
            int i10;
            RefreshPurchaseState refreshPurchaseState;
            ?? r36;
            PurchasesResult purchasesResult;
            String str18;
            String str19;
            String str20;
            PurchasesResult purchasesResult2;
            Iterable iterable;
            int i11;
            Iterator it;
            Billing billing9;
            ?? r8;
            int i12;
            int i13;
            int i14;
            long j;
            PurchasesResult purchasesResult3;
            ?? r74;
            List<PurchaseHistoryRecord> purchaseHistoryRecordList;
            BillingResult billingResult3;
            String str21;
            String str22;
            StringBuilder sb;
            ?? r75;
            List<Purchase> purchasesList;
            Iterator it2;
            int i15;
            Iterable iterable2;
            String str23;
            PurchasesResult purchasesResult4;
            int i16;
            int i17;
            int i18;
            Iterator it3;
            int i19;
            long j2;
            Iterator it4;
            Iterable iterable3;
            ?? r82;
            int i20;
            Iterator it5;
            Iterable iterable4;
            List list;
            ?? r4;
            String str24;
            int i21;
            FeatureLogger featureLogger;
            String str25;
            Object obj6;
            Object objConsume;
            ?? r18;
            Object obj7;
            String str26;
            List list2;
            String str27;
            ?? r76;
            int i22;
            ?? r77;
            List list3;
            String str28;
            String str29;
            Object objQueryPurchaseHistory2;
            Iterable iterable5;
            String str30;
            Object obj8;
            Object objAcknowledge;
            Iterable iterable6;
            List list4;
            ?? r42;
            String str31;
            FeatureLogger featureLogger2;
            int i23;
            int i24;
            String str32;
            int i25;
            Iterator it6;
            ?? r78;
            List list5;
            Iterator it7;
            Object next;
            Purchase purchase;
            ?? r11;
            ?? r79;
            List list6;
            ?? r710;
            List list7;
            List<PurchaseHistoryRecord> purchaseHistoryRecordList2;
            Mutex mutex2;
            BillingResult billingResult4;
            String str33;
            String str34;
            BillingResult billingResult5;
            int i26;
            String str35;
            Mutex mutex3;
            Billing billing10;
            BillingResult billingResult6;
            int i27;
            String str36;
            Mutex mutex4;
            int i28;
            Object objQueryPurchaseHistory3;
            Mutex mutex5;
            BillingResult billingResult7;
            PurchasesResult purchasesResult5;
            PurchasesResult purchasesResult6;
            String str37;
            Object obj9;
            String str38;
            String str39;
            int i29;
            BillingResult billingResult8;
            Mutex mutex6;
            Iterable iterable7;
            int i30;
            int i31;
            long j3;
            int i32;
            Iterator it8;
            String str40;
            PurchasesResult purchasesResult7;
            Iterator it9;
            List<PurchaseHistoryRecord> purchaseHistoryRecordList3;
            int i33;
            long purchaseTime;
            StringBuilder sb2;
            Mutex mutex7;
            List<Purchase> purchasesList2;
            BillingResult billingResult9;
            BillingResult billingResult10;
            int i34;
            int i35;
            Iterable iterable8;
            Billing billing11;
            int i36;
            long j4;
            int i37;
            Mutex mutex8;
            Iterator it10;
            int i38;
            BillingResult billingResult11;
            String str41;
            int i39;
            Mutex mutex9;
            int i40;
            PurchasesResult purchasesResult8;
            BillingResult billingResult12;
            int i41;
            int i42;
            int i43;
            Iterator it11;
            String str42;
            String str43;
            List list8;
            BillingResult billingResult13;
            Mutex mutex10;
            String str44;
            FeatureLogger featureLogger3;
            Object objConsume2;
            Iterable iterable9;
            Mutex mutex11;
            BillingResult billingResult14;
            Object obj10;
            String str45;
            Mutex mutex12;
            List list9;
            String str46;
            List list10;
            String str47;
            String str48;
            Billing billing12;
            Object objQueryPurchaseHistory4;
            String str49;
            String str50;
            Object objAcknowledge2;
            Object obj11;
            String str51;
            int i44;
            Mutex mutex13;
            int i45;
            List list11;
            String str52;
            FeatureLogger featureLogger4;
            int i46;
            Iterable iterable10;
            Iterable iterable11;
            List list12;
            Mutex mutex14;
            Iterator it12;
            Object next2;
            Purchase purchase2;
            List list13;
            Mutex mutex15;
            List<PurchaseHistoryRecord> purchaseHistoryRecordList4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i47 = 10;
            int i48 = 4;
            String str53 = ": ";
            ?? r711 = ": queryPurchaseHistory before";
            try {
                try {
                    try {
                        try {
                            try {
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            obj2 = null;
                            r7 = r711;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = null;
                        r7 = obj4;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    obj2 = null;
                    r7 = obj3;
                }
            } catch (Throwable th5) {
                th = th5;
                r711 = "queryPurchaseHistory after";
            }
            switch (this.label) {
                case 0:
                    str = "already acked purchase ";
                    ResultKt.throwOnFailure(obj);
                    Billing billing13 = Billing.this;
                    str2 = "NOT acked, acking ";
                    str3 = "long time NOT acked, consuming ";
                    String strM = Fragment$$ExternalSyntheticOutline1.m("refreshPurchaseState: ", this.$type, " ", this.$skuPrefix);
                    Logger.logDebug(Logger.defaultTag, billing13.getTag() + ": " + strM, null);
                    Billing billing14 = Billing.this;
                    String str54 = this.$type;
                    String str55 = this.$skuPrefix;
                    Mutex mutex16 = billing14.getMutex();
                    this.L$0 = billing14;
                    this.L$1 = billing14;
                    this.L$2 = str54;
                    this.L$3 = str55;
                    this.L$4 = mutex16;
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                    if (mutex16.lock(null, this) != coroutine_suspended) {
                        str4 = " ";
                        str5 = str55;
                        str6 = "Purchase not valid any more, consuming: ";
                        str7 = str54;
                        billing = billing14;
                        billing2 = billing;
                        i = 0;
                        i2 = 0;
                        mutex = mutex16;
                        try {
                        } catch (Throwable th6) {
                            th = th6;
                            r711 = mutex;
                        }
                        if (billing2.getClient().isReady()) {
                            str8 = "queryPurchaseHistory after";
                            str9 = "refreshPurchaseState: connect failure ";
                            i3 = i;
                            str10 = "queryPurchaseHistory time ";
                            str11 = "refreshPurchaseState ";
                            billing3 = billing;
                            str12 = ": ";
                            obj5 = coroutine_suspended;
                            long secondsInMillis = Utils.getSecondsInMillis(10);
                            str13 = "refreshPurchaseState failed: ";
                            str14 = "queryPurchaseHistory refresh";
                            str15 = "queryPurchaseHistory history ";
                            Billing billing15 = billing2;
                            Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, billing15);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(billing15);
                            this.L$1 = billing3;
                            this.L$2 = str7;
                            this.L$3 = str5;
                            this.L$4 = mutex;
                            this.L$5 = SpillingKt.nullOutSpilledVariable(this);
                            this.I$0 = i3;
                            this.I$1 = i2;
                            this.I$2 = 0;
                            this.J$0 = secondsInMillis;
                            this.I$3 = 0;
                            this.label = 7;
                            objWithTimeout = TimeoutKt.withTimeout(secondsInMillis, billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1, this);
                            if (objWithTimeout == obj5) {
                                return obj5;
                            }
                            billing4 = billing15;
                            i4 = 0;
                            mutex2 = mutex;
                            billingResult4 = (BillingResult) objWithTimeout;
                            if (billingResult4.getResponseCode() == 0) {
                                String str56 = str9 + BillingKt.pretty(billingResult4);
                                Logger.logDebug(Logger.defaultTag, billing3.getTag() + str12 + str56, null);
                                refreshPurchaseState = new RefreshPurchaseState(IBillingStatusListener.Status.REFRESH_ERROR, null);
                                r11 = mutex2;
                                r11.unlock(null);
                                return refreshPurchaseState;
                            }
                            Logger.logDebug(Logger.defaultTag, billing3.getTag() + ": queryPurchaseHistory before", null);
                            try {
                            } catch (Exception e) {
                                e = e;
                                str33 = str10;
                                str34 = str15;
                                billingResult5 = billingResult4;
                                i26 = i4;
                                str35 = str5;
                                mutex3 = mutex2;
                                billing10 = billing3;
                                billingResult6 = billingResult5;
                                i27 = 0;
                            }
                            if (SharedApplicationContext.getSettings().isTimeToRefreshPurchases()) {
                                BillingClient client = billing3.getClient();
                                QueryPurchaseHistoryParams queryPurchaseHistoryParamsBuild = QueryPurchaseHistoryParams.newBuilder().setProductType(str7).build();
                                queryPurchaseHistoryParamsBuild.getClass();
                                this.L$0 = SpillingKt.nullOutSpilledVariable(billing4);
                                this.L$1 = billing3;
                                this.L$2 = str7;
                                this.L$3 = str5;
                                this.L$4 = mutex2;
                                this.L$5 = SpillingKt.nullOutSpilledVariable(billingResult4);
                                this.L$6 = SpillingKt.nullOutSpilledVariable(billingResult4);
                                this.I$0 = i3;
                                this.I$1 = i2;
                                this.I$2 = i4;
                                this.I$3 = 0;
                                this.label = 8;
                                objQueryPurchaseHistory3 = BillingClientKotlinKt.queryPurchaseHistory(client, queryPurchaseHistoryParamsBuild, this);
                                if (objQueryPurchaseHistory3 == obj5) {
                                    return obj5;
                                }
                                billingResult5 = billingResult4;
                                str35 = str5;
                                mutex5 = mutex2;
                                billing10 = billing3;
                                billingResult6 = billingResult5;
                                i27 = 0;
                                try {
                                    purchaseHistoryRecordList3 = ((PurchaseHistoryResult) objQueryPurchaseHistory3).getPurchaseHistoryRecordList();
                                    if (purchaseHistoryRecordList3 == null) {
                                        for (PurchaseHistoryRecord purchaseHistoryRecord : purchaseHistoryRecordList3) {
                                            List<String> products = purchaseHistoryRecord.getProducts();
                                            products.getClass();
                                            String strJoinToString$default = CollectionsKt.joinToString$default(products, null, null, null, new Billing$$ExternalSyntheticLambda1(2), 31);
                                            StringBuilder sb3 = new StringBuilder();
                                            str34 = str15;
                                            try {
                                                sb3.append(str34);
                                                sb3.append(strJoinToString$default);
                                                String string = sb3.toString();
                                                String str57 = Logger.defaultTag;
                                                i33 = i27;
                                                try {
                                                    StringBuilder sb4 = new StringBuilder();
                                                    i26 = i4;
                                                    try {
                                                        sb4.append(billing10.getTag());
                                                        sb4.append(str12);
                                                        sb4.append(string);
                                                        Logger.logDebug(str57, sb4.toString(), null);
                                                        purchaseTime = purchaseHistoryRecord.getPurchaseTime();
                                                        sb2 = new StringBuilder();
                                                        str33 = str10;
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        str33 = str10;
                                                        i27 = i33;
                                                        mutex3 = mutex5;
                                                        Logger.logSevere(Logger.defaultTag, billing10.getTag(), e);
                                                        BillingResult billingResult15 = billingResult5;
                                                        i28 = i27;
                                                        billingResult4 = billingResult15;
                                                        str36 = str35;
                                                        billing3 = billing10;
                                                        i4 = i26;
                                                        mutex4 = mutex3;
                                                        String str58 = Logger.defaultTag;
                                                        billingResult7 = billingResult4;
                                                        StringBuilder sb5 = new StringBuilder();
                                                        int i49 = i4;
                                                        sb5.append(billing3.getTag());
                                                        sb5.append(str12);
                                                        String str59 = str8;
                                                        sb5.append(str59);
                                                        int i50 = i3;
                                                        Logger.logDebug(str58, sb5.toString(), null);
                                                        purchasesResult5 = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing3, str7, null), 1, null);
                                                        if (purchasesResult5.getZza().getResponseCode() == 0) {
                                                        }
                                                    }
                                                    try {
                                                        sb2.append(str33);
                                                        sb2.append(purchaseTime);
                                                        String string2 = sb2.toString();
                                                        Logger.logDebug(Logger.defaultTag, billing10.getTag() + str12 + string2, null);
                                                        i27 = i33;
                                                        str10 = str33;
                                                        str15 = str34;
                                                        i4 = i26;
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        i27 = i33;
                                                        mutex3 = mutex5;
                                                        Logger.logSevere(Logger.defaultTag, billing10.getTag(), e);
                                                        BillingResult billingResult152 = billingResult5;
                                                        i28 = i27;
                                                        billingResult4 = billingResult152;
                                                        str36 = str35;
                                                        billing3 = billing10;
                                                        i4 = i26;
                                                        mutex4 = mutex3;
                                                        String str582 = Logger.defaultTag;
                                                        billingResult7 = billingResult4;
                                                        StringBuilder sb52 = new StringBuilder();
                                                        int i492 = i4;
                                                        sb52.append(billing3.getTag());
                                                        sb52.append(str12);
                                                        String str592 = str8;
                                                        sb52.append(str592);
                                                        int i502 = i3;
                                                        Logger.logDebug(str582, sb52.toString(), null);
                                                        purchasesResult5 = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing3, str7, null), 1, null);
                                                        if (purchasesResult5.getZza().getResponseCode() == 0) {
                                                        }
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    i26 = i4;
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                i26 = i4;
                                                str33 = str10;
                                                mutex3 = mutex5;
                                            }
                                            break;
                                        }
                                        i33 = i27;
                                        i26 = i4;
                                        str33 = str10;
                                        str34 = str15;
                                        Unit unit = Unit.INSTANCE;
                                    } else {
                                        i33 = i27;
                                        i26 = i4;
                                        str33 = str10;
                                        str34 = str15;
                                    }
                                    SharedApplicationContext.getSettings().setRefreshPurchasesTime();
                                    Logger.logDebug(Logger.defaultTag, billing10.getTag() + str12 + str14, null);
                                    billingResult4 = billingResult5;
                                    str36 = str35;
                                    billing3 = billing10;
                                    i4 = i26;
                                    i28 = i33;
                                    mutex4 = mutex5;
                                } catch (Exception e6) {
                                    e = e6;
                                    i26 = i4;
                                    str33 = str10;
                                    str34 = str15;
                                    mutex3 = mutex5;
                                }
                                String str5822 = Logger.defaultTag;
                                billingResult7 = billingResult4;
                                StringBuilder sb522 = new StringBuilder();
                                int i4922 = i4;
                                sb522.append(billing3.getTag());
                                sb522.append(str12);
                                String str5922 = str8;
                                sb522.append(str5922);
                                int i5022 = i3;
                                Logger.logDebug(str5822, sb522.toString(), null);
                                purchasesResult5 = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing3, str7, null), 1, null);
                                if (purchasesResult5.getZza().getResponseCode() == 0) {
                                    String str60 = str13 + BillingKt.pretty(purchasesResult5.getZza());
                                    Logger.logWarning(Logger.defaultTag, billing3.getTag() + str12 + str60, null);
                                    RefreshPurchaseState refreshPurchaseState2 = new RefreshPurchaseState(IBillingStatusListener.Status.REFRESH_ERROR, null, 2, false ? 1 : 0);
                                    mutex4.unlock(null);
                                    return refreshPurchaseState2;
                                }
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                List<Purchase> purchasesList3 = purchasesResult5.getPurchasesList();
                                if (purchasesList3 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    Iterator it13 = purchasesList3.iterator();
                                    while (it13.hasNext()) {
                                        PurchasesResult purchasesResult9 = purchasesResult5;
                                        Object next3 = it13.next();
                                        Purchase purchase3 = (Purchase) next3;
                                        ArrayList<String> skus = purchase3.getSkus();
                                        skus.getClass();
                                        if (skus.isEmpty()) {
                                            it9 = it13;
                                        } else {
                                            for (String str61 : skus) {
                                                it9 = it13;
                                                str61.getClass();
                                                if (!StringsKt.startsWith$default(str61, str36)) {
                                                    it13 = it9;
                                                } else if (purchase3.getPurchaseState() == 0 && (jCurrentTimeMillis - purchase3.getPurchaseTime()) / TimeChart.DAY >= 1) {
                                                    arrayList.add(next3);
                                                }
                                            }
                                            it9 = it13;
                                        }
                                        purchasesResult5 = purchasesResult9;
                                        it13 = it9;
                                    }
                                    PurchasesResult purchasesResult10 = purchasesResult5;
                                    Iterator it14 = arrayList.iterator();
                                    str37 = str5922;
                                    billingResult8 = billingResult6;
                                    mutex6 = mutex4;
                                    iterable7 = arrayList;
                                    str38 = str33;
                                    str39 = str34;
                                    i30 = i4922;
                                    i31 = i5022;
                                    j3 = jCurrentTimeMillis;
                                    i32 = 0;
                                    it8 = it14;
                                    str40 = str36;
                                    purchasesResult7 = purchasesResult10;
                                    if (it8.hasNext()) {
                                        Object next4 = it8.next();
                                        Object obj12 = obj5;
                                        Purchase purchase4 = (Purchase) next4;
                                        ArrayList<String> skus2 = purchase4.getSkus();
                                        skus2.getClass();
                                        long j5 = j3;
                                        String strJoinToString$default2 = CollectionsKt.joinToString$default(skus2, null, null, null, new Billing$$ExternalSyntheticLambda1(3), 31);
                                        StringBuilder sb6 = new StringBuilder();
                                        String str62 = str6;
                                        sb6.append(str62);
                                        sb6.append(strJoinToString$default2);
                                        String string3 = sb6.toString();
                                        String str63 = Logger.defaultTag;
                                        str6 = str62;
                                        StringBuilder sb7 = new StringBuilder();
                                        int i51 = i32;
                                        sb7.append(billing3.getTag());
                                        sb7.append(str12);
                                        sb7.append(string3);
                                        Logger.logInfo(str63, sb7.toString(), null);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(billing4);
                                        this.L$1 = billing3;
                                        this.L$2 = str7;
                                        this.L$3 = str40;
                                        this.L$4 = mutex6;
                                        this.L$5 = SpillingKt.nullOutSpilledVariable(billingResult7);
                                        this.L$6 = purchasesResult7;
                                        this.L$7 = SpillingKt.nullOutSpilledVariable(iterable7);
                                        this.L$8 = it8;
                                        this.L$9 = SpillingKt.nullOutSpilledVariable(next4);
                                        this.L$10 = SpillingKt.nullOutSpilledVariable(billingResult8);
                                        this.L$11 = SpillingKt.nullOutSpilledVariable(purchase4);
                                        this.I$0 = i31;
                                        this.I$1 = i2;
                                        this.I$2 = i30;
                                        this.I$3 = i28;
                                        this.I$4 = i51;
                                        this.I$5 = 0;
                                        j3 = j5;
                                        this.J$0 = j3;
                                        this.label = 9;
                                        str41 = str40;
                                        coroutine_suspended = obj12;
                                        if (billing3.consume(purchase4, this) != coroutine_suspended) {
                                            i39 = i31;
                                            mutex9 = mutex6;
                                            i40 = i51;
                                            purchasesResult8 = purchasesResult7;
                                            billingResult12 = billingResult7;
                                            billingResult7 = billingResult12;
                                            purchasesResult7 = purchasesResult8;
                                            i32 = i40;
                                            mutex6 = mutex9;
                                            i31 = i39;
                                            obj5 = coroutine_suspended;
                                            str40 = str41;
                                            if (it8.hasNext()) {
                                                String str64 = str40;
                                                obj9 = obj5;
                                                Unit unit2 = Unit.INSTANCE;
                                                purchasesResult6 = purchasesResult7;
                                                mutex7 = mutex6;
                                                i29 = i31;
                                                i4922 = i30;
                                                jCurrentTimeMillis = j3;
                                                billingResult6 = billingResult8;
                                                str36 = str64;
                                                BillingResult billingResult16 = billingResult7;
                                                purchasesList2 = purchasesResult6.getPurchasesList();
                                                if (purchasesList2 == null) {
                                                    purchasesList2 = CollectionsKt.emptyList();
                                                }
                                                ArrayList arrayList2 = new ArrayList();
                                                for (Object obj13 : purchasesList2) {
                                                    Purchase purchase5 = (Purchase) obj13;
                                                    ArrayList<String> skus3 = purchase5.getSkus();
                                                    skus3.getClass();
                                                    if (skus3.isEmpty()) {
                                                        billingResult11 = billingResult16;
                                                    } else {
                                                        for (String str65 : skus3) {
                                                            billingResult11 = billingResult16;
                                                            str65.getClass();
                                                            if (!StringsKt.startsWith$default(str65, str36)) {
                                                                billingResult16 = billingResult11;
                                                            } else if (purchase5.getPurchaseState() == 1) {
                                                                arrayList2.add(obj13);
                                                            }
                                                        }
                                                        billingResult11 = billingResult16;
                                                    }
                                                    billingResult16 = billingResult11;
                                                }
                                                billingResult9 = billingResult16;
                                                billingResult10 = billingResult6;
                                                i34 = i28;
                                                i35 = i2;
                                                iterable8 = arrayList2;
                                                billing11 = billing3;
                                                i36 = i4922;
                                                j4 = jCurrentTimeMillis;
                                                i37 = i29;
                                                mutex8 = mutex7;
                                                it10 = arrayList2.iterator();
                                                i38 = 0;
                                                list10 = arrayList2;
                                                if (it10.hasNext()) {
                                                    Object next5 = it10.next();
                                                    str44 = str12;
                                                    Purchase purchase6 = (Purchase) next5;
                                                    if (purchase6.isAcknowledged()) {
                                                        int i52 = i38;
                                                        Iterator it15 = it10;
                                                        str46 = str44;
                                                        Object obj14 = obj9;
                                                        str45 = str4;
                                                        String originalJson = purchase6.getOriginalJson();
                                                        obj10 = obj14;
                                                        StringBuilder sb8 = new StringBuilder();
                                                        long j6 = j4;
                                                        String str66 = str;
                                                        sb8.append(str66);
                                                        sb8.append(originalJson);
                                                        sb8.append(str45);
                                                        String string4 = sb8.toString();
                                                        String str67 = Logger.defaultTag;
                                                        StringBuilder sb9 = new StringBuilder();
                                                        str = str66;
                                                        sb9.append(billing11.getTag());
                                                        sb9.append(str46);
                                                        sb9.append(string4);
                                                        Logger.logDebug(str67, sb9.toString(), null);
                                                        PreferencesUtils.setUnlockAck(SharedApplicationContext.getInstance().getContext());
                                                        billingResult14 = billingResult9;
                                                        i38 = i52;
                                                        j4 = j6;
                                                        it11 = it15;
                                                        mutex12 = mutex8;
                                                        list9 = list10;
                                                        iterable10 = iterable8;
                                                        str12 = str46;
                                                        it10 = it11;
                                                        billingResult9 = billingResult14;
                                                        i47 = 10;
                                                        str4 = str45;
                                                        obj9 = obj10;
                                                        mutex8 = mutex12;
                                                        list10 = list9;
                                                        iterable8 = iterable10;
                                                        if (it10.hasNext()) {
                                                            Object obj15 = obj9;
                                                            str47 = str12;
                                                            long j7 = j4;
                                                            str48 = str4;
                                                            boolean zIsEmpty = list10.isEmpty();
                                                            mutex14 = mutex8;
                                                            list12 = list10;
                                                            if (zIsEmpty) {
                                                                if (!PreferencesUtils.hadEverUnlock(SharedApplicationContext.getInstance().getContext())) {
                                                                    String str68 = Logger.defaultTag;
                                                                    Logger.logDebug(str68, billing11.getTag() + str47 + ("refreshPurchaseState: not owned " + str36), null);
                                                                    RefreshPurchaseState refreshPurchaseState3 = new RefreshPurchaseState(IBillingStatusListener.Status.NOT_OWNED, str36);
                                                                    mutex8.unlock(null);
                                                                    return refreshPurchaseState3;
                                                                }
                                                                Logger.logDebug(Logger.defaultTag, billing11.getTag() + str47 + "queryPurchaseHistory before 2", null);
                                                                try {
                                                                    BillingClient client2 = billing11.getClient();
                                                                    QueryPurchaseHistoryParams queryPurchaseHistoryParamsBuild2 = QueryPurchaseHistoryParams.newBuilder().setProductType(str7).build();
                                                                    queryPurchaseHistoryParamsBuild2.getClass();
                                                                    this.L$0 = SpillingKt.nullOutSpilledVariable(billing4);
                                                                    this.L$1 = billing11;
                                                                    this.L$2 = str36;
                                                                    this.L$3 = mutex8;
                                                                    this.L$4 = SpillingKt.nullOutSpilledVariable(billingResult9);
                                                                    this.L$5 = SpillingKt.nullOutSpilledVariable(purchasesResult6);
                                                                    this.L$6 = list10;
                                                                    this.L$7 = SpillingKt.nullOutSpilledVariable(billingResult10);
                                                                    this.L$8 = null;
                                                                    this.L$9 = null;
                                                                    this.L$10 = null;
                                                                    this.L$11 = null;
                                                                    this.L$12 = null;
                                                                    this.L$13 = null;
                                                                    this.I$0 = i37;
                                                                    this.I$1 = i35;
                                                                    this.I$2 = i36;
                                                                    this.I$3 = i34;
                                                                    this.J$0 = j7;
                                                                    this.label = 12;
                                                                    objQueryPurchaseHistory4 = BillingClientKotlinKt.queryPurchaseHistory(client2, queryPurchaseHistoryParamsBuild2, this);
                                                                } catch (Exception e7) {
                                                                    e = e7;
                                                                    billing12 = billing11;
                                                                    Logger.logSevere(Logger.defaultTag, billing12.getTag(), e);
                                                                    mutex15 = mutex8;
                                                                    list13 = list10;
                                                                    billing11 = billing12;
                                                                    Logger.logDebug(Logger.defaultTag, billing11.getTag() + str47 + str37, null);
                                                                    mutex14 = mutex15;
                                                                    list12 = list13;
                                                                    it12 = list12.iterator();
                                                                    while (true) {
                                                                        if (it12.hasNext()) {
                                                                        }
                                                                    }
                                                                    purchase2 = (Purchase) next2;
                                                                    if (purchase2 != null) {
                                                                    }
                                                                }
                                                                if (objQueryPurchaseHistory4 == obj15) {
                                                                    return obj15;
                                                                }
                                                                billing12 = billing11;
                                                                mutex8 = mutex8;
                                                                list10 = list10;
                                                                try {
                                                                    purchaseHistoryRecordList4 = ((PurchaseHistoryResult) objQueryPurchaseHistory4).getPurchaseHistoryRecordList();
                                                                    if (purchaseHistoryRecordList4 != null) {
                                                                        for (PurchaseHistoryRecord purchaseHistoryRecord2 : purchaseHistoryRecordList4) {
                                                                            List<String> products2 = purchaseHistoryRecord2.getProducts();
                                                                            products2.getClass();
                                                                            String strJoinToString$default3 = CollectionsKt.joinToString$default(products2, null, null, null, new Billing$$ExternalSyntheticLambda1(4), 31);
                                                                            StringBuilder sb10 = new StringBuilder();
                                                                            String str69 = str39;
                                                                            sb10.append(str69);
                                                                            sb10.append(strJoinToString$default3);
                                                                            String string5 = sb10.toString();
                                                                            Logger.logDebug(Logger.defaultTag, billing12.getTag() + str47 + string5, null);
                                                                            long purchaseTime2 = purchaseHistoryRecord2.getPurchaseTime();
                                                                            StringBuilder sb11 = new StringBuilder();
                                                                            String str70 = str38;
                                                                            sb11.append(str70);
                                                                            sb11.append(purchaseTime2);
                                                                            String string6 = sb11.toString();
                                                                            Logger.logDebug(Logger.defaultTag, billing12.getTag() + str47 + string6, null);
                                                                            List<String> products3 = purchaseHistoryRecord2.getProducts();
                                                                            products3.getClass();
                                                                            for (String str71 : products3) {
                                                                                str71.getClass();
                                                                                if (StringsKt.startsWith$default(str71, str36)) {
                                                                                    RefreshPurchaseState refreshPurchaseState4 = new RefreshPurchaseState(IBillingStatusListener.Status.OWNED, str36);
                                                                                    mutex8.unlock(null);
                                                                                    return refreshPurchaseState4;
                                                                                }
                                                                            }
                                                                            str38 = str70;
                                                                            str39 = str69;
                                                                        }
                                                                        Unit unit3 = Unit.INSTANCE;
                                                                    }
                                                                    Logger.logDebug(Logger.defaultTag, billing12.getTag() + str47 + "queryPurchaseHistory refresh 3", null);
                                                                    mutex15 = mutex8;
                                                                    list13 = list10;
                                                                } catch (Exception e8) {
                                                                    e = e8;
                                                                    Logger.logSevere(Logger.defaultTag, billing12.getTag(), e);
                                                                    mutex15 = mutex8;
                                                                    list13 = list10;
                                                                }
                                                                billing11 = billing12;
                                                                Logger.logDebug(Logger.defaultTag, billing11.getTag() + str47 + str37, null);
                                                                mutex14 = mutex15;
                                                                list12 = list13;
                                                            }
                                                            it12 = list12.iterator();
                                                            while (true) {
                                                                if (it12.hasNext()) {
                                                                    next2 = null;
                                                                } else {
                                                                    next2 = it12.next();
                                                                    if (((Purchase) next2).getPurchaseState() == 1) {
                                                                    }
                                                                }
                                                            }
                                                            purchase2 = (Purchase) next2;
                                                            if (purchase2 != null) {
                                                                RefreshPurchaseState refreshPurchaseState5 = new RefreshPurchaseState(IBillingStatusListener.Status.NOT_OWNED, null, 2, false ? 1 : 0);
                                                                mutex14.unlock(null);
                                                                return refreshPurchaseState5;
                                                            }
                                                            ArrayList<String> skus4 = purchase2.getSkus();
                                                            skus4.getClass();
                                                            String str72 = (String) CollectionsKt.firstOrNull(CollectionsKt.filterNotNull(skus4));
                                                            String str73 = str11 + BillingKt.prettyState(purchase2.getPurchaseState()) + str48 + Utils.getPrettyDate(purchase2.getPurchaseTime()) + str48 + purchase2.getOriginalJson();
                                                            Logger.logInfo(Logger.defaultTag, billing11.getTag() + str47 + str73, null);
                                                            String signature = purchase2.getSignature();
                                                            signature.getClass();
                                                            String str74 = BillingKt.PK;
                                                            String originalJson2 = purchase2.getOriginalJson();
                                                            originalJson2.getClass();
                                                            if (!billing11.verifyPurchase(str74, originalJson2, signature)) {
                                                                RefreshPurchaseState refreshPurchaseState6 = new RefreshPurchaseState(IBillingStatusListener.Status.VERIFICATION_FAILED, str72);
                                                                mutex14.unlock(null);
                                                                return refreshPurchaseState6;
                                                            }
                                                            refreshPurchaseState = new RefreshPurchaseState(IBillingStatusListener.Status.OWNED, str72);
                                                            r11 = mutex14;
                                                            r11.unlock(null);
                                                            return refreshPurchaseState;
                                                        }
                                                    } else if (purchase6.getPurchaseTime() < System.currentTimeMillis() - Days.m959getMillisimpl(Utils.getDays(4))) {
                                                        Object obj16 = obj9;
                                                        this.L$0 = SpillingKt.nullOutSpilledVariable(billing4);
                                                        this.L$1 = billing11;
                                                        this.L$2 = str7;
                                                        this.L$3 = str36;
                                                        this.L$4 = mutex8;
                                                        this.L$5 = SpillingKt.nullOutSpilledVariable(billingResult9);
                                                        this.L$6 = SpillingKt.nullOutSpilledVariable(purchasesResult6);
                                                        this.L$7 = list10;
                                                        this.L$8 = SpillingKt.nullOutSpilledVariable(iterable8);
                                                        this.L$9 = it10;
                                                        this.L$10 = SpillingKt.nullOutSpilledVariable(next5);
                                                        this.L$11 = SpillingKt.nullOutSpilledVariable(purchase6);
                                                        this.L$12 = SpillingKt.nullOutSpilledVariable(billingResult10);
                                                        this.L$13 = billing11;
                                                        this.I$0 = i37;
                                                        this.I$1 = i35;
                                                        this.I$2 = i36;
                                                        this.I$3 = i34;
                                                        this.I$4 = i38;
                                                        this.I$5 = 0;
                                                        this.J$0 = j4;
                                                        this.label = i47;
                                                        objConsume2 = billing11.consume(purchase6, this);
                                                        coroutine_suspended = obj16;
                                                        if (objConsume2 != coroutine_suspended) {
                                                            str42 = str36;
                                                            i41 = i38;
                                                            it11 = it10;
                                                            i43 = i37;
                                                            list8 = list10;
                                                            str43 = str7;
                                                            billingResult13 = billingResult9;
                                                            i42 = i34;
                                                            featureLogger3 = billing11;
                                                            mutex10 = mutex8;
                                                            iterable9 = iterable8;
                                                            try {
                                                                try {
                                                                    String strPretty = BillingKt.pretty(((ConsumeResult) objConsume2).getBillingResult());
                                                                    StringBuilder sb12 = new StringBuilder();
                                                                    String str75 = str3;
                                                                    sb12.append(str75);
                                                                    sb12.append(strPretty);
                                                                    String str76 = str4;
                                                                    sb12.append(str76);
                                                                    String string7 = sb12.toString();
                                                                    BillingResult billingResult17 = billingResult13;
                                                                    String str77 = Logger.defaultTag;
                                                                    StringBuilder sb13 = new StringBuilder();
                                                                    sb13.append(featureLogger3.getTag());
                                                                    String str78 = str44;
                                                                    sb13.append(str78);
                                                                    sb13.append(string7);
                                                                    Logger.logInfo(str77, sb13.toString(), null);
                                                                    billingResult14 = billingResult17;
                                                                    i38 = i41;
                                                                    obj10 = coroutine_suspended;
                                                                    str45 = str76;
                                                                    str3 = str75;
                                                                    i37 = i43;
                                                                    mutex12 = mutex11;
                                                                    str36 = str42;
                                                                    list9 = list8;
                                                                    str46 = str78;
                                                                    i34 = i42;
                                                                    str7 = str43;
                                                                    iterable10 = iterable9;
                                                                    str12 = str46;
                                                                    it10 = it11;
                                                                    billingResult9 = billingResult14;
                                                                    i47 = 10;
                                                                    str4 = str45;
                                                                    obj9 = obj10;
                                                                    mutex8 = mutex12;
                                                                    list10 = list9;
                                                                    iterable8 = iterable10;
                                                                    if (it10.hasNext()) {
                                                                    }
                                                                } catch (Throwable th7) {
                                                                    th = th7;
                                                                    r711 = mutex11;
                                                                    obj2 = null;
                                                                    r7 = r711;
                                                                    r7.unlock(obj2);
                                                                    throw th;
                                                                }
                                                                mutex11 = mutex10;
                                                            } catch (Throwable th8) {
                                                                th = th8;
                                                                mutex11 = mutex10;
                                                            }
                                                        }
                                                    } else {
                                                        Object obj17 = obj9;
                                                        str49 = str4;
                                                        str50 = str44;
                                                        this.L$0 = SpillingKt.nullOutSpilledVariable(billing4);
                                                        this.L$1 = billing11;
                                                        this.L$2 = str7;
                                                        this.L$3 = str36;
                                                        this.L$4 = mutex8;
                                                        this.L$5 = SpillingKt.nullOutSpilledVariable(billingResult9);
                                                        this.L$6 = SpillingKt.nullOutSpilledVariable(purchasesResult6);
                                                        this.L$7 = list10;
                                                        this.L$8 = SpillingKt.nullOutSpilledVariable(iterable8);
                                                        this.L$9 = it10;
                                                        this.L$10 = SpillingKt.nullOutSpilledVariable(next5);
                                                        this.L$11 = SpillingKt.nullOutSpilledVariable(purchase6);
                                                        this.L$12 = SpillingKt.nullOutSpilledVariable(billingResult10);
                                                        this.L$13 = billing11;
                                                        this.I$0 = i37;
                                                        this.I$1 = i35;
                                                        this.I$2 = i36;
                                                        this.I$3 = i34;
                                                        this.I$4 = i38;
                                                        this.I$5 = 0;
                                                        this.J$0 = j4;
                                                        this.label = 11;
                                                        objAcknowledge2 = billing11.acknowledge(purchase6, this);
                                                        obj11 = obj17;
                                                        if (objAcknowledge2 == obj11) {
                                                            return obj11;
                                                        }
                                                        billingResult14 = billingResult9;
                                                        str51 = str36;
                                                        i44 = i38;
                                                        mutex13 = mutex8;
                                                        it11 = it10;
                                                        i45 = i37;
                                                        list11 = list10;
                                                        str52 = str7;
                                                        featureLogger4 = billing11;
                                                        i46 = i34;
                                                        iterable11 = iterable8;
                                                        try {
                                                            String strPretty2 = BillingKt.pretty((BillingResult) objAcknowledge2);
                                                            StringBuilder sb14 = new StringBuilder();
                                                            String str79 = str2;
                                                            sb14.append(str79);
                                                            sb14.append(strPretty2);
                                                            str45 = str49;
                                                            sb14.append(str45);
                                                            String string8 = sb14.toString();
                                                            String str80 = Logger.defaultTag;
                                                            StringBuilder sb15 = new StringBuilder();
                                                            sb15.append(featureLogger4.getTag());
                                                            String str81 = str50;
                                                            sb15.append(str81);
                                                            sb15.append(string8);
                                                            Logger.logInfo(str80, sb15.toString(), null);
                                                            str2 = str79;
                                                            list9 = list11;
                                                            obj10 = obj11;
                                                            i34 = i46;
                                                            i37 = i45;
                                                            mutex12 = mutex13;
                                                            str7 = str52;
                                                            str46 = str81;
                                                            i38 = i44;
                                                            str36 = str51;
                                                            iterable10 = iterable11;
                                                            str12 = str46;
                                                            it10 = it11;
                                                            billingResult9 = billingResult14;
                                                            i47 = 10;
                                                            str4 = str45;
                                                            obj9 = obj10;
                                                            mutex8 = mutex12;
                                                            list10 = list9;
                                                            iterable8 = iterable10;
                                                            if (it10.hasNext()) {
                                                            }
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                            r711 = mutex13;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    purchasesResult6 = purchasesResult5;
                                    str37 = str5922;
                                    obj9 = obj5;
                                    str38 = str33;
                                    str39 = str34;
                                    i29 = i5022;
                                    mutex7 = mutex4;
                                    BillingResult billingResult162 = billingResult7;
                                    purchasesList2 = purchasesResult6.getPurchasesList();
                                    if (purchasesList2 == null) {
                                    }
                                    ArrayList arrayList22 = new ArrayList();
                                    while (r6.hasNext()) {
                                    }
                                    billingResult9 = billingResult162;
                                    billingResult10 = billingResult6;
                                    i34 = i28;
                                    i35 = i2;
                                    iterable8 = arrayList22;
                                    billing11 = billing3;
                                    i36 = i4922;
                                    j4 = jCurrentTimeMillis;
                                    i37 = i29;
                                    mutex8 = mutex7;
                                    it10 = arrayList22.iterator();
                                    i38 = 0;
                                    list10 = arrayList22;
                                    if (it10.hasNext()) {
                                    }
                                }
                            } else {
                                str33 = str10;
                                str34 = str15;
                                str36 = str5;
                                mutex4 = mutex2;
                                i28 = 0;
                                billingResult6 = billingResult4;
                                String str58222 = Logger.defaultTag;
                                billingResult7 = billingResult4;
                                StringBuilder sb5222 = new StringBuilder();
                                int i49222 = i4;
                                sb5222.append(billing3.getTag());
                                sb5222.append(str12);
                                String str59222 = str8;
                                sb5222.append(str59222);
                                int i50222 = i3;
                                Logger.logDebug(str58222, sb5222.toString(), null);
                                purchasesResult5 = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing3, str7, null), 1, null);
                                if (purchasesResult5.getZza().getResponseCode() == 0) {
                                }
                            }
                            Logger.logSevere(Logger.defaultTag, billing10.getTag(), e);
                            BillingResult billingResult1522 = billingResult5;
                            i28 = i27;
                            billingResult4 = billingResult1522;
                            str36 = str35;
                            billing3 = billing10;
                            i4 = i26;
                            mutex4 = mutex3;
                            String str582222 = Logger.defaultTag;
                            billingResult7 = billingResult4;
                            StringBuilder sb52222 = new StringBuilder();
                            int i492222 = i4;
                            sb52222.append(billing3.getTag());
                            sb52222.append(str12);
                            String str592222 = str8;
                            sb52222.append(str592222);
                            int i502222 = i3;
                            Logger.logDebug(str582222, sb52222.toString(), null);
                            purchasesResult5 = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing3, str7, null), 1, null);
                            if (purchasesResult5.getZza().getResponseCode() == 0) {
                            }
                        } else {
                            str16 = "refreshPurchaseState failed: ";
                            billingResult = BillingKt.billingResult(0, "Connected");
                            if (billingResult.getResponseCode() != 0) {
                                String str82 = "refreshPurchaseState: connect failure " + BillingKt.pretty(billingResult);
                                Logger.logDebug(Logger.defaultTag, billing.getTag() + ": " + str82, null);
                                refreshPurchaseState = new RefreshPurchaseState(IBillingStatusListener.Status.REFRESH_ERROR, null);
                                r11 = mutex;
                                r11.unlock(null);
                                return refreshPurchaseState;
                            }
                            Logger.logDebug(Logger.defaultTag, billing.getTag() + ": queryPurchaseHistory before", null);
                            try {
                            } catch (Exception e9) {
                                e = e9;
                                billing5 = billing;
                            }
                            if (SharedApplicationContext.getSettings().isTimeToRefreshPurchases()) {
                                BillingClient client3 = billing.getClient();
                                QueryPurchaseHistoryParams queryPurchaseHistoryParamsBuild3 = QueryPurchaseHistoryParams.newBuilder().setProductType(str7).build();
                                queryPurchaseHistoryParamsBuild3.getClass();
                                this.L$0 = SpillingKt.nullOutSpilledVariable(billing2);
                                billing5 = billing;
                                try {
                                    this.L$1 = billing5;
                                    this.L$2 = str7;
                                    this.L$3 = str5;
                                    this.L$4 = mutex;
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(billingResult);
                                    this.I$0 = i;
                                    this.I$1 = i2;
                                    this.I$2 = 0;
                                    this.I$3 = 0;
                                    this.label = 2;
                                    objQueryPurchaseHistory = BillingClientKotlinKt.queryPurchaseHistory(client3, queryPurchaseHistoryParamsBuild3, this);
                                } catch (Exception e10) {
                                    e = e10;
                                    Billing billing16 = billing2;
                                    billing6 = billing5;
                                    billing7 = billing16;
                                    i5 = i;
                                    i6 = i2;
                                    r72 = mutex;
                                    i7 = 0;
                                    str17 = str5;
                                    billingResult2 = billingResult;
                                    i8 = 0;
                                }
                                if (objQueryPurchaseHistory != coroutine_suspended) {
                                    Billing billing17 = billing2;
                                    billing6 = billing5;
                                    billing7 = billing17;
                                    r711 = mutex;
                                    i10 = 0;
                                    str17 = str5;
                                    billingResult2 = billingResult;
                                    i8 = 0;
                                    try {
                                        try {
                                            purchaseHistoryRecordList = ((PurchaseHistoryResult) objQueryPurchaseHistory).getPurchaseHistoryRecordList();
                                            if (purchaseHistoryRecordList == null) {
                                                r711 = r711;
                                                for (PurchaseHistoryRecord purchaseHistoryRecord3 : purchaseHistoryRecordList) {
                                                    List<String> products4 = purchaseHistoryRecord3.getProducts();
                                                    products4.getClass();
                                                    List<String> list14 = products4;
                                                    billingResult3 = billingResult2;
                                                    try {
                                                        r36 = r711;
                                                    } catch (Exception e11) {
                                                        e = e11;
                                                        i7 = i10;
                                                        i5 = i;
                                                        billingResult2 = billingResult3;
                                                        r74 = r711;
                                                        i6 = i2;
                                                        r72 = r74;
                                                        Logger.logSevere(Logger.defaultTag, billing6.getTag(), e);
                                                        Billing billing18 = billing6;
                                                        billing2 = billing7;
                                                        billing8 = billing18;
                                                        i2 = i6;
                                                        i9 = i8;
                                                        i = i5;
                                                        billingResult = billingResult2;
                                                        str5 = str17;
                                                        r73 = r72;
                                                        Logger.logDebug(Logger.defaultTag, billing8.getTag() + ": queryPurchaseHistory after", null);
                                                        purchasesResult = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing8, str7, null), 1, null);
                                                        if (purchasesResult.getZza().getResponseCode() != 0) {
                                                        }
                                                    }
                                                    try {
                                                        try {
                                                            str21 = "queryPurchaseHistory history " + CollectionsKt.joinToString$default(list14, null, null, null, new Billing$$ExternalSyntheticLambda1(2), 31);
                                                            str22 = Logger.defaultTag;
                                                            i7 = i10;
                                                        } catch (Exception e12) {
                                                            e = e12;
                                                            i7 = i10;
                                                        }
                                                        try {
                                                            sb = new StringBuilder();
                                                            i5 = i;
                                                        } catch (Exception e13) {
                                                            e = e13;
                                                            i5 = i;
                                                            billingResult2 = billingResult3;
                                                            i6 = i2;
                                                            r72 = r36;
                                                            Logger.logSevere(Logger.defaultTag, billing6.getTag(), e);
                                                            Billing billing182 = billing6;
                                                            billing2 = billing7;
                                                            billing8 = billing182;
                                                            i2 = i6;
                                                            i9 = i8;
                                                            i = i5;
                                                            billingResult = billingResult2;
                                                            str5 = str17;
                                                            r73 = r72;
                                                            Logger.logDebug(Logger.defaultTag, billing8.getTag() + ": queryPurchaseHistory after", null);
                                                            purchasesResult = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing8, str7, null), 1, null);
                                                            if (purchasesResult.getZza().getResponseCode() != 0) {
                                                            }
                                                        }
                                                        try {
                                                            sb.append(billing6.getTag());
                                                            sb.append(": ");
                                                            sb.append(str21);
                                                            Logger.logDebug(str22, sb.toString(), null);
                                                            String str83 = "queryPurchaseHistory time " + purchaseHistoryRecord3.getPurchaseTime();
                                                            Logger.logDebug(Logger.defaultTag, billing6.getTag() + ": " + str83, null);
                                                            billingResult2 = billingResult3;
                                                            r711 = r36;
                                                            i10 = i7;
                                                            i = i5;
                                                        } catch (Exception e14) {
                                                            e = e14;
                                                            billingResult2 = billingResult3;
                                                            i6 = i2;
                                                            r72 = r36;
                                                            Logger.logSevere(Logger.defaultTag, billing6.getTag(), e);
                                                            Billing billing1822 = billing6;
                                                            billing2 = billing7;
                                                            billing8 = billing1822;
                                                            i2 = i6;
                                                            i9 = i8;
                                                            i = i5;
                                                            billingResult = billingResult2;
                                                            str5 = str17;
                                                            r73 = r72;
                                                            Logger.logDebug(Logger.defaultTag, billing8.getTag() + ": queryPurchaseHistory after", null);
                                                            purchasesResult = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing8, str7, null), 1, null);
                                                            if (purchasesResult.getZza().getResponseCode() != 0) {
                                                            }
                                                        }
                                                    } catch (Throwable th10) {
                                                        th = th10;
                                                        r711 = r36;
                                                    }
                                                    break;
                                                }
                                                billingResult3 = billingResult2;
                                                r36 = r711;
                                                i7 = i10;
                                                i5 = i;
                                                Unit unit4 = Unit.INSTANCE;
                                            } else {
                                                billingResult3 = billingResult2;
                                                r36 = r711;
                                                i7 = i10;
                                                i5 = i;
                                            }
                                            SharedApplicationContext.getSettings().setRefreshPurchasesTime();
                                            Logger.logDebug(Logger.defaultTag, billing6.getTag() + ": queryPurchaseHistory refresh", null);
                                            Billing billing19 = billing6;
                                            billing2 = billing7;
                                            billing8 = billing19;
                                            str5 = str17;
                                            i9 = i8;
                                            r73 = r36;
                                            i = i5;
                                            billingResult = billingResult3;
                                        } catch (Throwable th11) {
                                            th = th11;
                                        }
                                    } catch (Exception e15) {
                                        e = e15;
                                        i7 = i10;
                                        i5 = i;
                                        r74 = r711;
                                    }
                                    Logger.logDebug(Logger.defaultTag, billing8.getTag() + ": queryPurchaseHistory after", null);
                                    purchasesResult = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing8, str7, null), 1, null);
                                    if (purchasesResult.getZza().getResponseCode() != 0) {
                                        String str84 = str16 + BillingKt.pretty(purchasesResult.getZza());
                                        Logger.logWarning(Logger.defaultTag, billing8.getTag() + ": " + str84, null);
                                        RefreshPurchaseState refreshPurchaseState7 = new RefreshPurchaseState(IBillingStatusListener.Status.REFRESH_ERROR, null, 2, false ? 1 : 0);
                                        r73.unlock(null);
                                        return refreshPurchaseState7;
                                    }
                                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                                    List<Purchase> purchasesList4 = purchasesResult.getPurchasesList();
                                    if (purchasesList4 != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        r711 = r73;
                                        for (Object obj18 : purchasesList4) {
                                            ?? r362 = r711;
                                            Purchase purchase7 = (Purchase) obj18;
                                            ArrayList<String> skus5 = purchase7.getSkus();
                                            skus5.getClass();
                                            if (skus5.isEmpty()) {
                                                purchasesResult3 = purchasesResult;
                                            } else {
                                                for (String str85 : skus5) {
                                                    purchasesResult3 = purchasesResult;
                                                    str85.getClass();
                                                    if (!StringsKt.startsWith$default(str85, str5)) {
                                                        purchasesResult = purchasesResult3;
                                                    } else if (purchase7.getPurchaseState() == 0 && (jCurrentTimeMillis2 - purchase7.getPurchaseTime()) / TimeChart.DAY >= 1) {
                                                        arrayList3.add(obj18);
                                                    }
                                                }
                                                purchasesResult3 = purchasesResult;
                                            }
                                            purchasesResult = purchasesResult3;
                                            r711 = r362;
                                            break;
                                        }
                                        r36 = r711;
                                        PurchasesResult purchasesResult11 = purchasesResult;
                                        Iterator it16 = arrayList3.iterator();
                                        int i53 = i9;
                                        purchasesResult2 = purchasesResult11;
                                        iterable = arrayList3;
                                        i11 = i53;
                                        Billing billing20 = billing8;
                                        it = it16;
                                        billing9 = billing20;
                                        str18 = "queryPurchaseHistory history ";
                                        str19 = "queryPurchaseHistory after";
                                        str20 = "queryPurchaseHistory time ";
                                        r8 = r36;
                                        i12 = i7;
                                        i13 = 0;
                                        i14 = i2;
                                        j = jCurrentTimeMillis2;
                                        try {
                                            if (it.hasNext()) {
                                                Object next6 = it.next();
                                                Object obj19 = coroutine_suspended;
                                                Purchase purchase8 = (Purchase) next6;
                                                ArrayList<String> skus6 = purchase8.getSkus();
                                                skus6.getClass();
                                                long j8 = j;
                                                String strJoinToString$default4 = CollectionsKt.joinToString$default(skus6, null, null, null, new Billing$$ExternalSyntheticLambda1(3), 31);
                                                StringBuilder sb16 = new StringBuilder();
                                                String str86 = str6;
                                                sb16.append(str86);
                                                sb16.append(strJoinToString$default4);
                                                String string9 = sb16.toString();
                                                String str87 = Logger.defaultTag;
                                                str6 = str86;
                                                StringBuilder sb17 = new StringBuilder();
                                                int i54 = i13;
                                                sb17.append(billing9.getTag());
                                                sb17.append(": ");
                                                sb17.append(string9);
                                                Logger.logInfo(str87, sb17.toString(), null);
                                                this.L$0 = SpillingKt.nullOutSpilledVariable(billing2);
                                                this.L$1 = billing9;
                                                this.L$2 = str7;
                                                this.L$3 = str5;
                                                this.L$4 = r8;
                                                this.L$5 = SpillingKt.nullOutSpilledVariable(billingResult);
                                                this.L$6 = purchasesResult2;
                                                this.L$7 = SpillingKt.nullOutSpilledVariable(iterable);
                                                this.L$8 = it;
                                                this.L$9 = SpillingKt.nullOutSpilledVariable(next6);
                                                this.L$10 = SpillingKt.nullOutSpilledVariable(purchase8);
                                                this.I$0 = i;
                                                this.I$1 = i14;
                                                this.I$2 = i12;
                                                this.I$3 = i11;
                                                this.I$4 = i54;
                                                this.I$5 = 0;
                                                j = j8;
                                                this.J$0 = j;
                                                this.label = 3;
                                                Object objConsume3 = billing9.consume(purchase8, this);
                                                coroutine_suspended = obj19;
                                                if (objConsume3 != coroutine_suspended) {
                                                    iterable3 = iterable;
                                                    i13 = i54;
                                                    r82 = r8;
                                                    iterable = iterable3;
                                                    r8 = r82;
                                                    if (it.hasNext()) {
                                                        Unit unit5 = Unit.INSTANCE;
                                                        i7 = i12;
                                                        billing8 = billing9;
                                                        r75 = r8;
                                                        jCurrentTimeMillis2 = j;
                                                        i2 = i14;
                                                        purchasesResult = purchasesResult2;
                                                        i9 = i11;
                                                        purchasesList = purchasesResult.getPurchasesList();
                                                        if (purchasesList == null) {
                                                            purchasesList = CollectionsKt.emptyList();
                                                        }
                                                        ArrayList arrayList4 = new ArrayList();
                                                        it2 = purchasesList.iterator();
                                                        while (it2.hasNext()) {
                                                            Object next7 = it2.next();
                                                            Purchase purchase9 = (Purchase) next7;
                                                            ArrayList<String> skus7 = purchase9.getSkus();
                                                            skus7.getClass();
                                                            if (skus7.isEmpty()) {
                                                                it4 = it2;
                                                            } else {
                                                                for (String str88 : skus7) {
                                                                    it4 = it2;
                                                                    str88.getClass();
                                                                    if (!StringsKt.startsWith$default(str88, str5)) {
                                                                        it2 = it4;
                                                                    } else if (purchase9.getPurchaseState() == 1) {
                                                                        arrayList4.add(next7);
                                                                    }
                                                                }
                                                                it4 = it2;
                                                            }
                                                            it2 = it4;
                                                        }
                                                        i15 = i9;
                                                        iterable2 = arrayList4;
                                                        str23 = str5;
                                                        purchasesResult4 = purchasesResult;
                                                        i16 = i2;
                                                        i17 = i7;
                                                        i18 = 0;
                                                        it3 = arrayList4.iterator();
                                                        i19 = i;
                                                        j2 = jCurrentTimeMillis2;
                                                        list3 = arrayList4;
                                                        r77 = r75;
                                                        if (it3.hasNext()) {
                                                            Object next8 = it3.next();
                                                            str25 = str53;
                                                            Purchase purchase10 = (Purchase) next8;
                                                            if (purchase10.isAcknowledged()) {
                                                                Iterator it17 = it3;
                                                                i22 = i18;
                                                                str27 = str25;
                                                                Object obj20 = coroutine_suspended;
                                                                str26 = str4;
                                                                String originalJson3 = purchase10.getOriginalJson();
                                                                obj7 = obj20;
                                                                StringBuilder sb18 = new StringBuilder();
                                                                long j9 = j2;
                                                                String str89 = str;
                                                                sb18.append(str89);
                                                                sb18.append(originalJson3);
                                                                sb18.append(str26);
                                                                String string10 = sb18.toString();
                                                                String str90 = Logger.defaultTag;
                                                                StringBuilder sb19 = new StringBuilder();
                                                                str = str89;
                                                                sb19.append(billing8.getTag());
                                                                sb19.append(str27);
                                                                sb19.append(string10);
                                                                Logger.logDebug(str90, sb19.toString(), null);
                                                                PreferencesUtils.setUnlockAck(SharedApplicationContext.getInstance().getContext());
                                                                iterable5 = iterable2;
                                                                it3 = it17;
                                                                j2 = j9;
                                                                list2 = list3;
                                                                r76 = r77;
                                                                str4 = str26;
                                                                str53 = str27;
                                                                i18 = i22;
                                                                iterable2 = iterable5;
                                                                coroutine_suspended = obj7;
                                                                i48 = 4;
                                                                list3 = list2;
                                                                r77 = r76;
                                                                if (it3.hasNext()) {
                                                                    Object obj21 = coroutine_suspended;
                                                                    str28 = str53;
                                                                    str29 = str4;
                                                                    long j10 = j2;
                                                                    boolean zIsEmpty2 = list3.isEmpty();
                                                                    list5 = list3;
                                                                    r78 = r77;
                                                                    if (zIsEmpty2) {
                                                                        if (!PreferencesUtils.hadEverUnlock(SharedApplicationContext.getInstance().getContext())) {
                                                                            String str91 = Logger.defaultTag;
                                                                            Logger.logDebug(str91, billing8.getTag() + str28 + ("refreshPurchaseState: not owned " + str23), null);
                                                                            RefreshPurchaseState refreshPurchaseState8 = new RefreshPurchaseState(IBillingStatusListener.Status.NOT_OWNED, str23);
                                                                            r77.unlock(null);
                                                                            return refreshPurchaseState8;
                                                                        }
                                                                        Logger.logDebug(Logger.defaultTag, billing8.getTag() + str28 + "queryPurchaseHistory before 2", null);
                                                                        try {
                                                                            BillingClient client4 = billing8.getClient();
                                                                            QueryPurchaseHistoryParams queryPurchaseHistoryParamsBuild4 = QueryPurchaseHistoryParams.newBuilder().setProductType(str7).build();
                                                                            queryPurchaseHistoryParamsBuild4.getClass();
                                                                            this.L$0 = SpillingKt.nullOutSpilledVariable(billing2);
                                                                            this.L$1 = billing8;
                                                                            this.L$2 = str23;
                                                                            this.L$3 = r77;
                                                                            this.L$4 = SpillingKt.nullOutSpilledVariable(billingResult);
                                                                            this.L$5 = SpillingKt.nullOutSpilledVariable(purchasesResult4);
                                                                            this.L$6 = list3;
                                                                            this.L$7 = null;
                                                                            this.L$8 = null;
                                                                            this.L$9 = null;
                                                                            this.L$10 = null;
                                                                            this.L$11 = null;
                                                                            this.L$12 = null;
                                                                            this.I$0 = i19;
                                                                            this.I$1 = i16;
                                                                            this.I$2 = i17;
                                                                            this.I$3 = i15;
                                                                            this.J$0 = j10;
                                                                            this.label = 6;
                                                                            objQueryPurchaseHistory2 = BillingClientKotlinKt.queryPurchaseHistory(client4, queryPurchaseHistoryParamsBuild4, this);
                                                                            list7 = list3;
                                                                            r710 = r77;
                                                                            if (objQueryPurchaseHistory2 == obj21) {
                                                                                return obj21;
                                                                            }
                                                                            purchaseHistoryRecordList2 = ((PurchaseHistoryResult) objQueryPurchaseHistory2).getPurchaseHistoryRecordList();
                                                                            if (purchaseHistoryRecordList2 != null) {
                                                                                for (PurchaseHistoryRecord purchaseHistoryRecord4 : purchaseHistoryRecordList2) {
                                                                                    List<String> products5 = purchaseHistoryRecord4.getProducts();
                                                                                    products5.getClass();
                                                                                    String strJoinToString$default5 = CollectionsKt.joinToString$default(products5, null, null, null, new Billing$$ExternalSyntheticLambda1(4), 31);
                                                                                    StringBuilder sb20 = new StringBuilder();
                                                                                    String str92 = str18;
                                                                                    sb20.append(str92);
                                                                                    sb20.append(strJoinToString$default5);
                                                                                    String string11 = sb20.toString();
                                                                                    Logger.logDebug(Logger.defaultTag, billing8.getTag() + str28 + string11, null);
                                                                                    long purchaseTime3 = purchaseHistoryRecord4.getPurchaseTime();
                                                                                    StringBuilder sb21 = new StringBuilder();
                                                                                    String str93 = str20;
                                                                                    sb21.append(str93);
                                                                                    sb21.append(purchaseTime3);
                                                                                    String string12 = sb21.toString();
                                                                                    Logger.logDebug(Logger.defaultTag, billing8.getTag() + str28 + string12, null);
                                                                                    List<String> products6 = purchaseHistoryRecord4.getProducts();
                                                                                    products6.getClass();
                                                                                    for (String str94 : products6) {
                                                                                        str94.getClass();
                                                                                        if (StringsKt.startsWith$default(str94, str23)) {
                                                                                            RefreshPurchaseState refreshPurchaseState9 = new RefreshPurchaseState(IBillingStatusListener.Status.OWNED, str23);
                                                                                            r710.unlock(null);
                                                                                            return refreshPurchaseState9;
                                                                                        }
                                                                                    }
                                                                                    str20 = str93;
                                                                                    str18 = str92;
                                                                                }
                                                                                Unit unit6 = Unit.INSTANCE;
                                                                            }
                                                                            Logger.logDebug(Logger.defaultTag, billing8.getTag() + str28 + "queryPurchaseHistory refresh 3", null);
                                                                            list6 = list7;
                                                                            r79 = r710;
                                                                        } catch (Exception e16) {
                                                                            e = e16;
                                                                            Logger.logSevere(Logger.defaultTag, billing8.getTag(), e);
                                                                            list6 = list3;
                                                                            r79 = r77;
                                                                        }
                                                                        Logger.logDebug(Logger.defaultTag, billing8.getTag() + str28 + str19, null);
                                                                        list5 = list6;
                                                                        r78 = r79;
                                                                    }
                                                                    it7 = list5.iterator();
                                                                    while (true) {
                                                                        if (it7.hasNext()) {
                                                                            next = null;
                                                                        } else {
                                                                            next = it7.next();
                                                                            if (((Purchase) next).getPurchaseState() == 1) {
                                                                            }
                                                                        }
                                                                    }
                                                                    purchase = (Purchase) next;
                                                                    if (purchase != null) {
                                                                        RefreshPurchaseState refreshPurchaseState10 = new RefreshPurchaseState(IBillingStatusListener.Status.NOT_OWNED, null, 2, false ? 1 : 0);
                                                                        r78.unlock(null);
                                                                        return refreshPurchaseState10;
                                                                    }
                                                                    ArrayList<String> skus8 = purchase.getSkus();
                                                                    skus8.getClass();
                                                                    String str95 = (String) CollectionsKt.firstOrNull(CollectionsKt.filterNotNull(skus8));
                                                                    String str96 = "refreshPurchaseState " + BillingKt.prettyState(purchase.getPurchaseState()) + str29 + Utils.getPrettyDate(purchase.getPurchaseTime()) + str29 + purchase.getOriginalJson();
                                                                    Logger.logInfo(Logger.defaultTag, billing8.getTag() + str28 + str96, null);
                                                                    String signature2 = purchase.getSignature();
                                                                    signature2.getClass();
                                                                    String str97 = BillingKt.PK;
                                                                    String originalJson4 = purchase.getOriginalJson();
                                                                    originalJson4.getClass();
                                                                    if (!billing8.verifyPurchase(str97, originalJson4, signature2)) {
                                                                        RefreshPurchaseState refreshPurchaseState11 = new RefreshPurchaseState(IBillingStatusListener.Status.VERIFICATION_FAILED, str95);
                                                                        r78.unlock(null);
                                                                        return refreshPurchaseState11;
                                                                    }
                                                                    refreshPurchaseState = new RefreshPurchaseState(IBillingStatusListener.Status.OWNED, str95);
                                                                    r11 = r78;
                                                                    r11.unlock(null);
                                                                    return refreshPurchaseState;
                                                                }
                                                            } else if (purchase10.getPurchaseTime() < System.currentTimeMillis() - Days.m959getMillisimpl(Utils.getDays(i48))) {
                                                                Object obj22 = coroutine_suspended;
                                                                this.L$0 = SpillingKt.nullOutSpilledVariable(billing2);
                                                                this.L$1 = billing8;
                                                                this.L$2 = str7;
                                                                this.L$3 = str23;
                                                                this.L$4 = r77;
                                                                this.L$5 = SpillingKt.nullOutSpilledVariable(billingResult);
                                                                this.L$6 = SpillingKt.nullOutSpilledVariable(purchasesResult4);
                                                                this.L$7 = list3;
                                                                this.L$8 = SpillingKt.nullOutSpilledVariable(iterable2);
                                                                this.L$9 = it3;
                                                                this.L$10 = SpillingKt.nullOutSpilledVariable(next8);
                                                                this.L$11 = SpillingKt.nullOutSpilledVariable(purchase10);
                                                                this.L$12 = billing8;
                                                                this.I$0 = i19;
                                                                this.I$1 = i16;
                                                                this.I$2 = i17;
                                                                this.I$3 = i15;
                                                                this.I$4 = i18;
                                                                this.I$5 = 0;
                                                                this.J$0 = j2;
                                                                this.label = i48;
                                                                objConsume = billing8.consume(purchase10, this);
                                                                obj6 = obj22;
                                                                if (objConsume == obj6) {
                                                                    return obj6;
                                                                }
                                                                int i55 = i19;
                                                                str24 = str23;
                                                                i20 = i18;
                                                                it5 = it3;
                                                                i21 = i55;
                                                                iterable4 = iterable2;
                                                                list = list3;
                                                                r4 = r77;
                                                                featureLogger = billing8;
                                                                try {
                                                                    try {
                                                                        String strPretty3 = BillingKt.pretty(((ConsumeResult) objConsume).getBillingResult());
                                                                        String str98 = str24;
                                                                        StringBuilder sb22 = new StringBuilder();
                                                                        obj7 = obj6;
                                                                        String str99 = str3;
                                                                        sb22.append(str99);
                                                                        sb22.append(strPretty3);
                                                                        str26 = str4;
                                                                        sb22.append(str26);
                                                                        String string13 = sb22.toString();
                                                                        String str100 = Logger.defaultTag;
                                                                        int i56 = i21;
                                                                        StringBuilder sb23 = new StringBuilder();
                                                                        sb23.append(featureLogger.getTag());
                                                                        String str101 = str25;
                                                                        sb23.append(str101);
                                                                        sb23.append(string13);
                                                                        Logger.logInfo(str100, sb23.toString(), null);
                                                                        str3 = str99;
                                                                        it3 = it5;
                                                                        list2 = list;
                                                                        i19 = i56;
                                                                        str27 = str101;
                                                                        r76 = r18;
                                                                        i22 = i20;
                                                                        str23 = str98;
                                                                        iterable5 = iterable4;
                                                                        str4 = str26;
                                                                        str53 = str27;
                                                                        i18 = i22;
                                                                        iterable2 = iterable5;
                                                                        coroutine_suspended = obj7;
                                                                        i48 = 4;
                                                                        list3 = list2;
                                                                        r77 = r76;
                                                                        if (it3.hasNext()) {
                                                                        }
                                                                    } catch (Throwable th12) {
                                                                        th = th12;
                                                                        r711 = r18;
                                                                        obj2 = null;
                                                                        r7 = r711;
                                                                        r7.unlock(obj2);
                                                                        throw th;
                                                                    }
                                                                    r18 = r4;
                                                                } catch (Throwable th13) {
                                                                    th = th13;
                                                                    r18 = r4;
                                                                }
                                                            } else {
                                                                str30 = str25;
                                                                obj8 = coroutine_suspended;
                                                                this.L$0 = SpillingKt.nullOutSpilledVariable(billing2);
                                                                this.L$1 = billing8;
                                                                this.L$2 = str7;
                                                                this.L$3 = str23;
                                                                this.L$4 = r77;
                                                                this.L$5 = SpillingKt.nullOutSpilledVariable(billingResult);
                                                                this.L$6 = SpillingKt.nullOutSpilledVariable(purchasesResult4);
                                                                this.L$7 = list3;
                                                                this.L$8 = SpillingKt.nullOutSpilledVariable(iterable2);
                                                                this.L$9 = it3;
                                                                this.L$10 = SpillingKt.nullOutSpilledVariable(next8);
                                                                this.L$11 = SpillingKt.nullOutSpilledVariable(purchase10);
                                                                this.L$12 = billing8;
                                                                this.I$0 = i19;
                                                                this.I$1 = i16;
                                                                this.I$2 = i17;
                                                                this.I$3 = i15;
                                                                this.I$4 = i18;
                                                                this.I$5 = 0;
                                                                this.J$0 = j2;
                                                                this.label = 5;
                                                                objAcknowledge = billing8.acknowledge(purchase10, this);
                                                                if (objAcknowledge == obj8) {
                                                                    return obj8;
                                                                }
                                                                iterable6 = iterable2;
                                                                list4 = list3;
                                                                r42 = r77;
                                                                str31 = str7;
                                                                featureLogger2 = billing8;
                                                                i23 = i17;
                                                                i24 = i19;
                                                                str32 = str23;
                                                                i25 = i18;
                                                                it6 = it3;
                                                                String strPretty4 = BillingKt.pretty((BillingResult) objAcknowledge);
                                                                StringBuilder sb24 = new StringBuilder();
                                                                Iterator it18 = it6;
                                                                String str102 = str2;
                                                                sb24.append(str102);
                                                                sb24.append(strPretty4);
                                                                String str103 = str4;
                                                                sb24.append(str103);
                                                                String string14 = sb24.toString();
                                                                String str104 = Logger.defaultTag;
                                                                String str105 = str32;
                                                                StringBuilder sb25 = new StringBuilder();
                                                                sb25.append(featureLogger2.getTag());
                                                                String str106 = str30;
                                                                sb25.append(str106);
                                                                sb25.append(string14);
                                                                Logger.logInfo(str104, sb25.toString(), null);
                                                                i22 = i25;
                                                                str23 = str105;
                                                                it3 = it18;
                                                                obj7 = obj8;
                                                                str2 = str102;
                                                                i19 = i24;
                                                                str26 = str103;
                                                                str27 = str106;
                                                                i17 = i23;
                                                                str7 = str31;
                                                                r76 = r42;
                                                                list2 = list4;
                                                                iterable5 = iterable6;
                                                                str4 = str26;
                                                                str53 = str27;
                                                                i18 = i22;
                                                                iterable2 = iterable5;
                                                                coroutine_suspended = obj7;
                                                                i48 = 4;
                                                                list3 = list2;
                                                                r77 = r76;
                                                                if (it3.hasNext()) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (Throwable th14) {
                                            th = th14;
                                            r711 = r8;
                                        }
                                        obj2 = null;
                                        r7 = r711;
                                        r7.unlock(obj2);
                                        throw th;
                                    }
                                    str18 = "queryPurchaseHistory history ";
                                    str19 = "queryPurchaseHistory after";
                                    str20 = "queryPurchaseHistory time ";
                                    r75 = r73;
                                    purchasesList = purchasesResult.getPurchasesList();
                                    if (purchasesList == null) {
                                    }
                                    ArrayList arrayList42 = new ArrayList();
                                    it2 = purchasesList.iterator();
                                    while (it2.hasNext()) {
                                    }
                                    i15 = i9;
                                    iterable2 = arrayList42;
                                    str23 = str5;
                                    purchasesResult4 = purchasesResult;
                                    i16 = i2;
                                    i17 = i7;
                                    i18 = 0;
                                    it3 = arrayList42.iterator();
                                    i19 = i;
                                    j2 = jCurrentTimeMillis2;
                                    list3 = arrayList42;
                                    r77 = r75;
                                    if (it3.hasNext()) {
                                    }
                                }
                                break;
                            } else {
                                billing8 = billing;
                                r73 = mutex;
                                i9 = 0;
                                i7 = 0;
                                Logger.logDebug(Logger.defaultTag, billing8.getTag() + ": queryPurchaseHistory after", null);
                                purchasesResult = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing8, str7, null), 1, null);
                                if (purchasesResult.getZza().getResponseCode() != 0) {
                                }
                            }
                            Billing billing162 = billing2;
                            billing6 = billing5;
                            billing7 = billing162;
                            i5 = i;
                            i6 = i2;
                            r72 = mutex;
                            i7 = 0;
                            str17 = str5;
                            billingResult2 = billingResult;
                            i8 = 0;
                            Logger.logSevere(Logger.defaultTag, billing6.getTag(), e);
                            Billing billing18222 = billing6;
                            billing2 = billing7;
                            billing8 = billing18222;
                            i2 = i6;
                            i9 = i8;
                            i = i5;
                            billingResult = billingResult2;
                            str5 = str17;
                            r73 = r72;
                            Logger.logDebug(Logger.defaultTag, billing8.getTag() + ": queryPurchaseHistory after", null);
                            purchasesResult = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing8, str7, null), 1, null);
                            if (purchasesResult.getZza().getResponseCode() != 0) {
                            }
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    str = "already acked purchase ";
                    int i57 = this.I$1;
                    int i58 = this.I$0;
                    Mutex mutex17 = (Mutex) this.L$4;
                    String str107 = (String) this.L$3;
                    String str108 = (String) this.L$2;
                    Billing billing21 = (Billing) this.L$1;
                    Billing billing22 = (Billing) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str4 = " ";
                    str5 = str107;
                    str3 = "long time NOT acked, consuming ";
                    mutex = mutex17;
                    str6 = "Purchase not valid any more, consuming: ";
                    str7 = str108;
                    billing = billing21;
                    billing2 = billing22;
                    i = i58;
                    str2 = "NOT acked, acking ";
                    i2 = i57;
                    if (billing2.getClient().isReady()) {
                    }
                    break;
                case 2:
                    str = "already acked purchase ";
                    int i59 = this.I$3;
                    i10 = this.I$2;
                    i6 = this.I$1;
                    i8 = i59;
                    int i60 = this.I$0;
                    BillingResult billingResult18 = (BillingResult) this.L$5;
                    Mutex mutex18 = (Mutex) this.L$4;
                    String str109 = (String) this.L$3;
                    String str110 = (String) this.L$2;
                    billing6 = (Billing) this.L$1;
                    Billing billing23 = (Billing) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        str4 = " ";
                        billingResult2 = billingResult18;
                        str2 = "NOT acked, acking ";
                        i2 = i6;
                        i = i60;
                        r711 = mutex18;
                        str3 = "long time NOT acked, consuming ";
                        str17 = str109;
                        str6 = "Purchase not valid any more, consuming: ";
                        str7 = str110;
                        str16 = "refreshPurchaseState failed: ";
                        billing7 = billing23;
                        objQueryPurchaseHistory = obj;
                        purchaseHistoryRecordList = ((PurchaseHistoryResult) objQueryPurchaseHistory).getPurchaseHistoryRecordList();
                        if (purchaseHistoryRecordList == null) {
                        }
                        SharedApplicationContext.getSettings().setRefreshPurchasesTime();
                        Logger.logDebug(Logger.defaultTag, billing6.getTag() + ": queryPurchaseHistory refresh", null);
                        Billing billing192 = billing6;
                        billing2 = billing7;
                        billing8 = billing192;
                        str5 = str17;
                        i9 = i8;
                        r73 = r36;
                        i = i5;
                        billingResult = billingResult3;
                    } catch (Exception e17) {
                        e = e17;
                        str6 = "Purchase not valid any more, consuming: ";
                        str7 = str110;
                        str16 = "refreshPurchaseState failed: ";
                        billing7 = billing23;
                        i5 = i60;
                        i7 = i10;
                        r72 = mutex18;
                        str3 = "long time NOT acked, consuming ";
                        str17 = str109;
                        str4 = " ";
                        billingResult2 = billingResult18;
                        str2 = "NOT acked, acking ";
                    }
                    Logger.logDebug(Logger.defaultTag, billing8.getTag() + ": queryPurchaseHistory after", null);
                    purchasesResult = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing8, str7, null), 1, null);
                    if (purchasesResult.getZza().getResponseCode() != 0) {
                    }
                    break;
                case 3:
                    str = "already acked purchase ";
                    long j11 = this.J$0;
                    int i61 = this.I$4;
                    int i62 = this.I$3;
                    int i63 = this.I$2;
                    int i64 = this.I$1;
                    int i65 = this.I$0;
                    Iterator it19 = (Iterator) this.L$8;
                    iterable3 = (Iterable) this.L$7;
                    PurchasesResult purchasesResult12 = (PurchasesResult) this.L$6;
                    BillingResult billingResult19 = (BillingResult) this.L$5;
                    Mutex mutex19 = (Mutex) this.L$4;
                    String str111 = (String) this.L$3;
                    String str112 = (String) this.L$2;
                    Billing billing24 = (Billing) this.L$1;
                    Billing billing25 = (Billing) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str4 = " ";
                    str5 = str111;
                    billing2 = billing25;
                    billing9 = billing24;
                    str6 = "Purchase not valid any more, consuming: ";
                    str7 = str112;
                    str18 = "queryPurchaseHistory history ";
                    str19 = "queryPurchaseHistory after";
                    i12 = i63;
                    str20 = "queryPurchaseHistory time ";
                    i13 = i61;
                    it = it19;
                    i14 = i64;
                    purchasesResult2 = purchasesResult12;
                    r82 = mutex19;
                    i11 = i62;
                    str3 = "long time NOT acked, consuming ";
                    i = i65;
                    str2 = "NOT acked, acking ";
                    j = j11;
                    billingResult = billingResult19;
                    iterable = iterable3;
                    r8 = r82;
                    if (it.hasNext()) {
                    }
                    obj2 = null;
                    r7 = r711;
                    r7.unlock(obj2);
                    throw th;
                case 4:
                    str = "already acked purchase ";
                    long j12 = this.J$0;
                    i20 = this.I$4;
                    int i66 = this.I$3;
                    int i67 = this.I$2;
                    int i68 = this.I$1;
                    int i69 = this.I$0;
                    FeatureLogger featureLogger5 = (FeatureLogger) this.L$12;
                    it5 = (Iterator) this.L$9;
                    iterable4 = (Iterable) this.L$8;
                    list = (List) this.L$7;
                    PurchasesResult purchasesResult13 = (PurchasesResult) this.L$6;
                    BillingResult billingResult20 = (BillingResult) this.L$5;
                    Mutex mutex20 = (Mutex) this.L$4;
                    String str113 = (String) this.L$3;
                    String str114 = (String) this.L$2;
                    Billing billing26 = (Billing) this.L$1;
                    Billing billing27 = (Billing) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str18 = "queryPurchaseHistory history ";
                    str19 = "queryPurchaseHistory after";
                    str20 = "queryPurchaseHistory time ";
                    r4 = mutex20;
                    str24 = str113;
                    str4 = " ";
                    str3 = "long time NOT acked, consuming ";
                    i16 = i68;
                    i21 = i69;
                    billing8 = billing26;
                    billing2 = billing27;
                    i15 = i66;
                    i17 = i67;
                    featureLogger = featureLogger5;
                    str7 = str114;
                    str25 = ": ";
                    obj6 = coroutine_suspended;
                    objConsume = obj;
                    str2 = "NOT acked, acking ";
                    j2 = j12;
                    purchasesResult4 = purchasesResult13;
                    billingResult = billingResult20;
                    String strPretty32 = BillingKt.pretty(((ConsumeResult) objConsume).getBillingResult());
                    String str982 = str24;
                    StringBuilder sb222 = new StringBuilder();
                    obj7 = obj6;
                    String str992 = str3;
                    sb222.append(str992);
                    sb222.append(strPretty32);
                    str26 = str4;
                    sb222.append(str26);
                    String string132 = sb222.toString();
                    r18 = r4;
                    String str1002 = Logger.defaultTag;
                    int i562 = i21;
                    StringBuilder sb232 = new StringBuilder();
                    sb232.append(featureLogger.getTag());
                    String str1012 = str25;
                    sb232.append(str1012);
                    sb232.append(string132);
                    Logger.logInfo(str1002, sb232.toString(), null);
                    str3 = str992;
                    it3 = it5;
                    list2 = list;
                    i19 = i562;
                    str27 = str1012;
                    r76 = r18;
                    i22 = i20;
                    str23 = str982;
                    iterable5 = iterable4;
                    str4 = str26;
                    str53 = str27;
                    i18 = i22;
                    iterable2 = iterable5;
                    coroutine_suspended = obj7;
                    i48 = 4;
                    list3 = list2;
                    r77 = r76;
                    if (it3.hasNext()) {
                    }
                    break;
                case 5:
                    str = "already acked purchase ";
                    long j13 = this.J$0;
                    i25 = this.I$4;
                    int i70 = this.I$3;
                    i23 = this.I$2;
                    int i71 = this.I$1;
                    i24 = this.I$0;
                    FeatureLogger featureLogger6 = (FeatureLogger) this.L$12;
                    it6 = (Iterator) this.L$9;
                    iterable6 = (Iterable) this.L$8;
                    list4 = (List) this.L$7;
                    PurchasesResult purchasesResult14 = (PurchasesResult) this.L$6;
                    BillingResult billingResult21 = (BillingResult) this.L$5;
                    Mutex mutex21 = (Mutex) this.L$4;
                    String str115 = (String) this.L$3;
                    str31 = (String) this.L$2;
                    Billing billing28 = (Billing) this.L$1;
                    Billing billing29 = (Billing) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str18 = "queryPurchaseHistory history ";
                    str19 = "queryPurchaseHistory after";
                    str30 = ": ";
                    str20 = "queryPurchaseHistory time ";
                    r42 = mutex21;
                    str32 = str115;
                    obj8 = coroutine_suspended;
                    str4 = " ";
                    str3 = "long time NOT acked, consuming ";
                    i16 = i71;
                    billing8 = billing28;
                    objAcknowledge = obj;
                    billing2 = billing29;
                    i15 = i70;
                    featureLogger2 = featureLogger6;
                    str2 = "NOT acked, acking ";
                    j2 = j13;
                    purchasesResult4 = purchasesResult14;
                    billingResult = billingResult21;
                    String strPretty42 = BillingKt.pretty((BillingResult) objAcknowledge);
                    StringBuilder sb242 = new StringBuilder();
                    Iterator it182 = it6;
                    String str1022 = str2;
                    sb242.append(str1022);
                    sb242.append(strPretty42);
                    String str1032 = str4;
                    sb242.append(str1032);
                    String string142 = sb242.toString();
                    String str1042 = Logger.defaultTag;
                    String str1052 = str32;
                    StringBuilder sb252 = new StringBuilder();
                    sb252.append(featureLogger2.getTag());
                    String str1062 = str30;
                    sb252.append(str1062);
                    sb252.append(string142);
                    Logger.logInfo(str1042, sb252.toString(), null);
                    i22 = i25;
                    str23 = str1052;
                    it3 = it182;
                    obj7 = obj8;
                    str2 = str1022;
                    i19 = i24;
                    str26 = str1032;
                    str27 = str1062;
                    i17 = i23;
                    str7 = str31;
                    r76 = r42;
                    list2 = list4;
                    iterable5 = iterable6;
                    str4 = str26;
                    str53 = str27;
                    i18 = i22;
                    iterable2 = iterable5;
                    coroutine_suspended = obj7;
                    i48 = 4;
                    list3 = list2;
                    r77 = r76;
                    if (it3.hasNext()) {
                    }
                    break;
                case 6:
                    List list15 = (List) this.L$6;
                    r77 = (Mutex) this.L$3;
                    str23 = (String) this.L$2;
                    Billing billing30 = (Billing) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        objQueryPurchaseHistory2 = obj;
                        str18 = "queryPurchaseHistory history ";
                        str19 = "queryPurchaseHistory after";
                        billing8 = billing30;
                        str20 = "queryPurchaseHistory time ";
                        list7 = list15;
                        str29 = " ";
                        str28 = ": ";
                        r710 = r77;
                        purchaseHistoryRecordList2 = ((PurchaseHistoryResult) objQueryPurchaseHistory2).getPurchaseHistoryRecordList();
                        if (purchaseHistoryRecordList2 != null) {
                        }
                        Logger.logDebug(Logger.defaultTag, billing8.getTag() + str28 + "queryPurchaseHistory refresh 3", null);
                        list6 = list7;
                        r79 = r710;
                    } catch (Exception e18) {
                        e = e18;
                        str19 = "queryPurchaseHistory after";
                        billing8 = billing30;
                        list3 = list15;
                        str29 = " ";
                        str28 = ": ";
                        Logger.logSevere(Logger.defaultTag, billing8.getTag(), e);
                        list6 = list3;
                        r79 = r77;
                    }
                    Logger.logDebug(Logger.defaultTag, billing8.getTag() + str28 + str19, null);
                    list5 = list6;
                    r78 = r79;
                    it7 = list5.iterator();
                    while (true) {
                        if (it7.hasNext()) {
                        }
                    }
                    purchase = (Purchase) next;
                    if (purchase != null) {
                    }
                    break;
                case 7:
                    int i72 = this.I$2;
                    str = "already acked purchase ";
                    int i73 = this.I$1;
                    int i74 = this.I$0;
                    Mutex mutex22 = (Mutex) this.L$4;
                    String str116 = (String) this.L$3;
                    String str117 = (String) this.L$2;
                    Billing billing31 = (Billing) this.L$1;
                    Billing billing32 = (Billing) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        str2 = "NOT acked, acking ";
                        i2 = i73;
                        str13 = "refreshPurchaseState failed: ";
                        billing3 = billing31;
                        str15 = "queryPurchaseHistory history ";
                        str8 = "queryPurchaseHistory after";
                        billing4 = billing32;
                        str10 = "queryPurchaseHistory time ";
                        str11 = "refreshPurchaseState ";
                        i3 = i74;
                        i4 = i72;
                        str9 = "refreshPurchaseState: connect failure ";
                        str3 = "long time NOT acked, consuming ";
                        str14 = "queryPurchaseHistory refresh";
                        mutex2 = mutex22;
                        str4 = " ";
                        str12 = ": ";
                        str5 = str116;
                        obj5 = coroutine_suspended;
                        str6 = "Purchase not valid any more, consuming: ";
                        str7 = str117;
                        objWithTimeout = obj;
                        billingResult4 = (BillingResult) objWithTimeout;
                        if (billingResult4.getResponseCode() == 0) {
                        }
                    } catch (Throwable th15) {
                        th = th15;
                        obj2 = null;
                        r7 = mutex22;
                        break;
                    }
                    break;
                case 8:
                    int i75 = this.I$3;
                    int i76 = this.I$2;
                    int i77 = this.I$1;
                    int i78 = this.I$0;
                    BillingResult billingResult22 = (BillingResult) this.L$6;
                    BillingResult billingResult23 = (BillingResult) this.L$5;
                    Mutex mutex23 = (Mutex) this.L$4;
                    str35 = (String) this.L$3;
                    String str118 = (String) this.L$2;
                    billing10 = (Billing) this.L$1;
                    billing4 = (Billing) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        str2 = "NOT acked, acking ";
                        i2 = i77;
                        objQueryPurchaseHistory3 = obj;
                        str15 = "queryPurchaseHistory history ";
                        str8 = "queryPurchaseHistory after";
                        i3 = i78;
                        i4 = i76;
                        str10 = "queryPurchaseHistory time ";
                        str11 = "refreshPurchaseState ";
                        mutex5 = mutex23;
                        str12 = ": ";
                        str6 = "Purchase not valid any more, consuming: ";
                        str14 = "queryPurchaseHistory refresh";
                        str7 = str118;
                        obj5 = coroutine_suspended;
                        str13 = "refreshPurchaseState failed: ";
                        i27 = i75;
                        str = "already acked purchase ";
                        billingResult5 = billingResult23;
                        str4 = " ";
                        billingResult6 = billingResult22;
                        str3 = "long time NOT acked, consuming ";
                        purchaseHistoryRecordList3 = ((PurchaseHistoryResult) objQueryPurchaseHistory3).getPurchaseHistoryRecordList();
                        if (purchaseHistoryRecordList3 == null) {
                        }
                        SharedApplicationContext.getSettings().setRefreshPurchasesTime();
                        Logger.logDebug(Logger.defaultTag, billing10.getTag() + str12 + str14, null);
                        billingResult4 = billingResult5;
                        str36 = str35;
                        billing3 = billing10;
                        i4 = i26;
                        i28 = i33;
                        mutex4 = mutex5;
                    } catch (Exception e19) {
                        e = e19;
                        str2 = "NOT acked, acking ";
                        i2 = i77;
                        str8 = "queryPurchaseHistory after";
                        i3 = i78;
                        i26 = i76;
                        str33 = "queryPurchaseHistory time ";
                        str11 = "refreshPurchaseState ";
                        mutex3 = mutex23;
                        str34 = "queryPurchaseHistory history ";
                        str12 = ": ";
                        str6 = "Purchase not valid any more, consuming: ";
                        str7 = str118;
                        obj5 = coroutine_suspended;
                        str13 = "refreshPurchaseState failed: ";
                        i27 = i75;
                        str = "already acked purchase ";
                        billingResult5 = billingResult23;
                        str4 = " ";
                        billingResult6 = billingResult22;
                        str3 = "long time NOT acked, consuming ";
                    }
                    String str5822222 = Logger.defaultTag;
                    billingResult7 = billingResult4;
                    StringBuilder sb522222 = new StringBuilder();
                    int i4922222 = i4;
                    sb522222.append(billing3.getTag());
                    sb522222.append(str12);
                    String str5922222 = str8;
                    sb522222.append(str5922222);
                    int i5022222 = i3;
                    Logger.logDebug(str5822222, sb522222.toString(), null);
                    purchasesResult5 = (PurchasesResult) BuildersKt__Builders_concurrentKt.runBlockingK$default(null, new Billing$refreshPurchaseState$2$1$result$1(billing3, str7, null), 1, null);
                    if (purchasesResult5.getZza().getResponseCode() == 0) {
                    }
                    break;
                case 9:
                    long j14 = this.J$0;
                    int i79 = this.I$4;
                    int i80 = this.I$3;
                    int i81 = this.I$2;
                    int i82 = this.I$1;
                    int i83 = this.I$0;
                    BillingResult billingResult24 = (BillingResult) this.L$10;
                    Iterator it20 = (Iterator) this.L$8;
                    Iterable iterable12 = (Iterable) this.L$7;
                    PurchasesResult purchasesResult15 = (PurchasesResult) this.L$6;
                    BillingResult billingResult25 = (BillingResult) this.L$5;
                    Mutex mutex24 = (Mutex) this.L$4;
                    String str119 = (String) this.L$3;
                    String str120 = (String) this.L$2;
                    Billing billing33 = (Billing) this.L$1;
                    Billing billing34 = (Billing) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str12 = ": ";
                    i39 = i83;
                    str39 = "queryPurchaseHistory history ";
                    str37 = "queryPurchaseHistory after";
                    billing4 = billing34;
                    str38 = "queryPurchaseHistory time ";
                    str11 = "refreshPurchaseState ";
                    it8 = it20;
                    purchasesResult8 = purchasesResult15;
                    i40 = i79;
                    str = "already acked purchase ";
                    str3 = "long time NOT acked, consuming ";
                    i28 = i80;
                    i30 = i81;
                    j3 = j14;
                    billingResult8 = billingResult24;
                    iterable7 = iterable12;
                    billingResult12 = billingResult25;
                    billing3 = billing33;
                    str4 = " ";
                    str2 = "NOT acked, acking ";
                    i2 = i82;
                    mutex9 = mutex24;
                    str41 = str119;
                    str6 = "Purchase not valid any more, consuming: ";
                    str7 = str120;
                    billingResult7 = billingResult12;
                    purchasesResult7 = purchasesResult8;
                    i32 = i40;
                    mutex6 = mutex9;
                    i31 = i39;
                    obj5 = coroutine_suspended;
                    str40 = str41;
                    if (it8.hasNext()) {
                    }
                    break;
                case 10:
                    long j15 = this.J$0;
                    i41 = this.I$4;
                    i42 = this.I$3;
                    int i84 = this.I$2;
                    int i85 = this.I$1;
                    int i86 = this.I$0;
                    FeatureLogger featureLogger7 = (FeatureLogger) this.L$13;
                    i43 = i86;
                    BillingResult billingResult26 = (BillingResult) this.L$12;
                    it11 = (Iterator) this.L$9;
                    Iterable iterable13 = (Iterable) this.L$8;
                    List list16 = (List) this.L$7;
                    PurchasesResult purchasesResult16 = (PurchasesResult) this.L$6;
                    BillingResult billingResult27 = (BillingResult) this.L$5;
                    Mutex mutex25 = (Mutex) this.L$4;
                    str42 = (String) this.L$3;
                    str43 = (String) this.L$2;
                    Billing billing35 = (Billing) this.L$1;
                    Billing billing36 = (Billing) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str39 = "queryPurchaseHistory history ";
                    str37 = "queryPurchaseHistory after";
                    billing4 = billing36;
                    str38 = "queryPurchaseHistory time ";
                    str11 = "refreshPurchaseState ";
                    list8 = list16;
                    purchasesResult6 = purchasesResult16;
                    billingResult13 = billingResult27;
                    mutex10 = mutex25;
                    billing11 = billing35;
                    str4 = " ";
                    str44 = ": ";
                    featureLogger3 = featureLogger7;
                    str2 = "NOT acked, acking ";
                    str3 = "long time NOT acked, consuming ";
                    i36 = i84;
                    objConsume2 = obj;
                    str = "already acked purchase ";
                    i35 = i85;
                    j4 = j15;
                    billingResult10 = billingResult26;
                    iterable9 = iterable13;
                    String strPretty5 = BillingKt.pretty(((ConsumeResult) objConsume2).getBillingResult());
                    StringBuilder sb122 = new StringBuilder();
                    String str752 = str3;
                    sb122.append(str752);
                    sb122.append(strPretty5);
                    String str762 = str4;
                    sb122.append(str762);
                    String string72 = sb122.toString();
                    BillingResult billingResult172 = billingResult13;
                    String str772 = Logger.defaultTag;
                    mutex11 = mutex10;
                    StringBuilder sb132 = new StringBuilder();
                    sb132.append(featureLogger3.getTag());
                    String str782 = str44;
                    sb132.append(str782);
                    sb132.append(string72);
                    Logger.logInfo(str772, sb132.toString(), null);
                    billingResult14 = billingResult172;
                    i38 = i41;
                    obj10 = coroutine_suspended;
                    str45 = str762;
                    str3 = str752;
                    i37 = i43;
                    mutex12 = mutex11;
                    str36 = str42;
                    list9 = list8;
                    str46 = str782;
                    i34 = i42;
                    str7 = str43;
                    iterable10 = iterable9;
                    str12 = str46;
                    it10 = it11;
                    billingResult9 = billingResult14;
                    i47 = 10;
                    str4 = str45;
                    obj9 = obj10;
                    mutex8 = mutex12;
                    list10 = list9;
                    iterable8 = iterable10;
                    if (it10.hasNext()) {
                    }
                    break;
                case 11:
                    long j16 = this.J$0;
                    i44 = this.I$4;
                    i46 = this.I$3;
                    int i87 = this.I$2;
                    int i88 = this.I$1;
                    int i89 = this.I$0;
                    FeatureLogger featureLogger8 = (FeatureLogger) this.L$13;
                    i45 = i89;
                    BillingResult billingResult28 = (BillingResult) this.L$12;
                    it11 = (Iterator) this.L$9;
                    Iterable iterable14 = (Iterable) this.L$8;
                    List list17 = (List) this.L$7;
                    PurchasesResult purchasesResult17 = (PurchasesResult) this.L$6;
                    billingResult14 = (BillingResult) this.L$5;
                    mutex13 = (Mutex) this.L$4;
                    str51 = (String) this.L$3;
                    str52 = (String) this.L$2;
                    Billing billing37 = (Billing) this.L$1;
                    Billing billing38 = (Billing) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str39 = "queryPurchaseHistory history ";
                    str37 = "queryPurchaseHistory after";
                    str49 = " ";
                    str50 = ": ";
                    billing4 = billing38;
                    featureLogger4 = featureLogger8;
                    i36 = i87;
                    str38 = "queryPurchaseHistory time ";
                    str11 = "refreshPurchaseState ";
                    list11 = list17;
                    purchasesResult6 = purchasesResult17;
                    billing11 = billing37;
                    obj11 = coroutine_suspended;
                    str2 = "NOT acked, acking ";
                    str3 = "long time NOT acked, consuming ";
                    objAcknowledge2 = obj;
                    str = "already acked purchase ";
                    i35 = i88;
                    j4 = j16;
                    billingResult10 = billingResult28;
                    iterable11 = iterable14;
                    String strPretty22 = BillingKt.pretty((BillingResult) objAcknowledge2);
                    StringBuilder sb142 = new StringBuilder();
                    String str792 = str2;
                    sb142.append(str792);
                    sb142.append(strPretty22);
                    str45 = str49;
                    sb142.append(str45);
                    String string82 = sb142.toString();
                    String str802 = Logger.defaultTag;
                    StringBuilder sb152 = new StringBuilder();
                    sb152.append(featureLogger4.getTag());
                    String str812 = str50;
                    sb152.append(str812);
                    sb152.append(string82);
                    Logger.logInfo(str802, sb152.toString(), null);
                    str2 = str792;
                    list9 = list11;
                    obj10 = obj11;
                    i34 = i46;
                    i37 = i45;
                    mutex12 = mutex13;
                    str7 = str52;
                    str46 = str812;
                    i38 = i44;
                    str36 = str51;
                    iterable10 = iterable11;
                    str12 = str46;
                    it10 = it11;
                    billingResult9 = billingResult14;
                    i47 = 10;
                    str4 = str45;
                    obj9 = obj10;
                    mutex8 = mutex12;
                    list10 = list9;
                    iterable8 = iterable10;
                    if (it10.hasNext()) {
                    }
                    break;
                case 12:
                    List list18 = (List) this.L$6;
                    Mutex mutex26 = (Mutex) this.L$3;
                    str36 = (String) this.L$2;
                    billing12 = (Billing) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        objQueryPurchaseHistory4 = obj;
                        list10 = list18;
                        str39 = "queryPurchaseHistory history ";
                        str37 = "queryPurchaseHistory after";
                        str48 = " ";
                        mutex8 = mutex26;
                        str38 = "queryPurchaseHistory time ";
                        str11 = "refreshPurchaseState ";
                        str47 = ": ";
                        purchaseHistoryRecordList4 = ((PurchaseHistoryResult) objQueryPurchaseHistory4).getPurchaseHistoryRecordList();
                        if (purchaseHistoryRecordList4 != null) {
                        }
                        Logger.logDebug(Logger.defaultTag, billing12.getTag() + str47 + "queryPurchaseHistory refresh 3", null);
                        mutex15 = mutex8;
                        list13 = list10;
                    } catch (Exception e20) {
                        e = e20;
                        list10 = list18;
                        str37 = "queryPurchaseHistory after";
                        str48 = " ";
                        mutex8 = mutex26;
                        str11 = "refreshPurchaseState ";
                        str47 = ": ";
                        Logger.logSevere(Logger.defaultTag, billing12.getTag(), e);
                        mutex15 = mutex8;
                        list13 = list10;
                        billing11 = billing12;
                        Logger.logDebug(Logger.defaultTag, billing11.getTag() + str47 + str37, null);
                        mutex14 = mutex15;
                        list12 = list13;
                        it12 = list12.iterator();
                        while (true) {
                            if (it12.hasNext()) {
                            }
                        }
                        purchase2 = (Purchase) next2;
                        if (purchase2 != null) {
                        }
                    }
                    billing11 = billing12;
                    Logger.logDebug(Logger.defaultTag, billing11.getTag() + str47 + str37, null);
                    mutex14 = mutex15;
                    list12 = list13;
                    it12 = list12.iterator();
                    while (true) {
                        if (it12.hasNext()) {
                        }
                    }
                    purchase2 = (Purchase) next2;
                    if (purchase2 != null) {
                    }
                    break;
                default:
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$resolveSkuDetails$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing", f = "Billing.kt", l = {1117, 546, 548, 549, 1139, 546, 548, 549}, m = "resolveSkuDetails", v = 2)
    public static final class C22211 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C22211(Continuation<? super C22211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Billing.this.resolveSkuDetails(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.Billing$storeSkuDetails$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.Billing$storeSkuDetails$2", f = "Billing.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class C22222 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<SkuDetails> $skus;
        int label;
        final /* synthetic */ Billing this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C22222(List<? extends SkuDetails> list, Billing billing, Continuation<? super C22222> continuation) {
            super(2, continuation);
            this.$skus = list;
            this.this$0 = billing;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C22222(this.$skus, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22222) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            List<SkuDetails> list = this.$skus;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((SkuDetails) it.next()).getOriginalJson());
            }
            Set<String> set = CollectionsKt.toSet(arrayList);
            Billing billing = this.this$0;
            String str = Logger.defaultTag;
            Logger.logInfo(str, billing.getTag() + ": " + ("sku storing: \n" + set), null);
            this.this$0.getPrefs().edit().putStringSet("sku-details", set).apply();
            return Unit.INSTANCE;
        }
    }

    public Billing(Activity activity) {
        activity.getClass();
        this.activity = activity;
        this.tag = "INAPP";
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        PurchaseListener purchaseListener = new PurchaseListener();
        this.purchaseUpdatedListener = purchaseListener;
        BillingClient billingClientBuild = BillingClient.newBuilder(activity).setListener(purchaseListener).enablePendingPurchases().build();
        billingClientBuild.getClass();
        this.client = billingClientBuild;
        this.prefs = LazyKt.lazy(new Url$$ExternalSyntheticLambda0(this, 17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence acknowledge$lambda$0$0(String str) {
        return FileInsert$$ExternalSyntheticOutline0.m(" ", str, " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence acknowledge$lambda$1(String str) {
        return FileInsert$$ExternalSyntheticOutline0.m(" ", str, " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence acknowledge$lambda$2(String str) {
        return FileInsert$$ExternalSyntheticOutline0.m(" ", str, " ");
    }

    private final PublicKey generatePublicKeyOrNull(String encodedPublicKey) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(encodedPublicKey)));
        } catch (Exception e) {
            Logger.logWarning(Logger.defaultTag, this.getTag() + ": generatePublicKey failure", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences getPrefs() {
        Object value = this.prefs.getValue();
        value.getClass();
        return (SharedPreferences) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences prefs_delegate$lambda$0(Billing billing) {
        return billing.activity.getApplicationContext().getSharedPreferences("billing-prefs", 0);
    }

    private final boolean verify(PublicKey publicKey, String signedData, String signature) {
        try {
            Signature signature2 = Signature.getInstance("SHA1withRSA");
            signature2.initVerify(publicKey);
            byte[] bytes = signedData.getBytes(Charsets.UTF_8);
            bytes.getClass();
            signature2.update(bytes);
            if (signature2.verify(Base64.decode(signature))) {
                return true;
            }
            Logger.logInfo(Logger.defaultTag, getTag() + ": Signature verification failed.", null);
            return false;
        } catch (Exception e) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": Signature verification failed with exception", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean verifyPurchase(String base64PublicKey, String signedData, String signature) {
        if (signedData.length() == 0 || base64PublicKey.length() == 0) {
            Logger.logInfo(Logger.defaultTag, getTag() + ": No signed data or no public key.", null);
            return false;
        }
        if (signature.length() != 0) {
            PublicKey publicKeyGeneratePublicKeyOrNull = generatePublicKeyOrNull(base64PublicKey);
            if (publicKeyGeneratePublicKeyOrNull == null) {
                return false;
            }
            return verify(publicKeyGeneratePublicKeyOrNull, signedData, signature);
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": No signature.", null);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object acknowledge(Purchase purchase, Continuation<? super BillingResult> continuation) {
        AnonymousClass1 anonymousClass1;
        Purchase purchase2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        int i3 = 0;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            if (purchase.getPurchaseState() != 1) {
                ArrayList<String> skus = purchase.getSkus();
                skus.getClass();
                String strJoinToString$default = CollectionsKt.joinToString$default(skus, null, null, null, new Billing$$ExternalSyntheticLambda1(8), 31);
                String orderId = purchase.getOrderId();
                int purchaseState = purchase.getPurchaseState();
                StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("acknowledge: ", strJoinToString$default, " ", orderId, " - invalid purchase state - ");
                sbM6m.append(purchaseState);
                String string = sbM6m.toString();
                Logger.logWarning(Logger.defaultTag, getTag() + ": " + string, null);
                return BillingKt.billingResult(0, string);
            }
            if (purchase.isAcknowledged()) {
                PreferencesUtils.setUnlockAck(SharedApplicationContext.getInstance().getContext());
                ArrayList<String> skus2 = purchase.getSkus();
                skus2.getClass();
                String strM = FileInsert$$ExternalSyntheticOutline0.m("acknowledge: ", CollectionsKt.joinToString$default(skus2, null, null, null, new Billing$$ExternalSyntheticLambda1(7), 31), " ", purchase.getOrderId(), " already acknowledged");
                Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM, null);
                return BillingKt.billingResult(0, strM);
            }
            AcknowledgePurchaseParams acknowledgePurchaseParamsBuild = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build();
            acknowledgePurchaseParamsBuild.getClass();
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(acknowledgePurchaseParamsBuild, null);
            anonymousClass1.L$0 = purchase;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(acknowledgePurchaseParamsBuild);
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(io2, anonymousClass2, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            purchase2 = purchase;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            purchase2 = (Purchase) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        ArrayList<String> skus3 = purchase2.getSkus();
        skus3.getClass();
        String strJoinToString$default2 = CollectionsKt.joinToString$default(skus3, null, null, null, new Billing$$ExternalSyntheticLambda1(i3), 31);
        String orderId2 = purchase2.getOrderId();
        String strPretty = BillingKt.pretty((BillingResult) objWithContext);
        StringBuilder sbM6m2 = FileInsert$$ExternalSyntheticOutline0.m6m("acknowledge result: ", strJoinToString$default2, " ", orderId2, " - ");
        sbM6m2.append(strPretty);
        String string2 = sbM6m2.toString();
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + string2, null);
        PreferencesUtils.setUnlockAck(SharedApplicationContext.getInstance().getContext());
        return objWithContext;
    }

    public final Object consume(Purchase purchase, Continuation<? super ConsumeResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C22142(purchase, this, null), continuation);
    }

    public final Object consumeSku(String str, String str2, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C22152(str, str2, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public final void disconnect() {
        try {
            this.client.endConnection();
        } catch (Exception e) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": disconnect failure", e);
        }
    }

    public final BillingClient getClient() {
        return this.client;
    }

    public final Mutex getMutex() {
        return this.mutex;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadSkuDetails(Continuation<? super List<? extends SkuDetails>> continuation) {
        C22161 c22161;
        if (continuation instanceof C22161) {
            c22161 = (C22161) continuation;
            int i = c22161.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c22161.label = i - Integer.MIN_VALUE;
            } else {
                c22161 = new C22161(continuation);
            }
        }
        Object objWithContext = c22161.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c22161.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            C22172 c22172 = new C22172(null);
            c22161.label = 1;
            objWithContext = BuildersKt.withContext(io2, c22172, c22161);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objWithContext);
        }
        List list = (List) objWithContext;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03e5 A[Catch: all -> 0x0251, TRY_LEAVE, TryCatch #1 {all -> 0x0251, blocks: (B:98:0x03d7, B:100:0x03e5, B:103:0x0429, B:105:0x042f, B:108:0x0439, B:110:0x04a2, B:111:0x04ed, B:113:0x04f7, B:119:0x0503, B:89:0x0391, B:91:0x0399, B:94:0x03a2, B:58:0x01ff, B:60:0x020d, B:65:0x0255, B:67:0x025b, B:70:0x0265, B:72:0x02c8, B:73:0x0311, B:75:0x031b, B:81:0x0329), top: B:126:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0429 A[Catch: all -> 0x0251, TRY_ENTER, TryCatch #1 {all -> 0x0251, blocks: (B:98:0x03d7, B:100:0x03e5, B:103:0x0429, B:105:0x042f, B:108:0x0439, B:110:0x04a2, B:111:0x04ed, B:113:0x04f7, B:119:0x0503, B:89:0x0391, B:91:0x0399, B:94:0x03a2, B:58:0x01ff, B:60:0x020d, B:65:0x0255, B:67:0x025b, B:70:0x0265, B:72:0x02c8, B:73:0x0311, B:75:0x031b, B:81:0x0329), top: B:126:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b0 A[Catch: all -> 0x01c8, TryCatch #4 {all -> 0x01c8, blocks: (B:45:0x01a6, B:47:0x01b0, B:49:0x01bf, B:54:0x01cc, B:85:0x0355), top: B:131:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x020d A[Catch: all -> 0x0251, TRY_LEAVE, TryCatch #1 {all -> 0x0251, blocks: (B:98:0x03d7, B:100:0x03e5, B:103:0x0429, B:105:0x042f, B:108:0x0439, B:110:0x04a2, B:111:0x04ed, B:113:0x04f7, B:119:0x0503, B:89:0x0391, B:91:0x0399, B:94:0x03a2, B:58:0x01ff, B:60:0x020d, B:65:0x0255, B:67:0x025b, B:70:0x0265, B:72:0x02c8, B:73:0x0311, B:75:0x031b, B:81:0x0329), top: B:126:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0255 A[Catch: all -> 0x0251, TRY_ENTER, TryCatch #1 {all -> 0x0251, blocks: (B:98:0x03d7, B:100:0x03e5, B:103:0x0429, B:105:0x042f, B:108:0x0439, B:110:0x04a2, B:111:0x04ed, B:113:0x04f7, B:119:0x0503, B:89:0x0391, B:91:0x0399, B:94:0x03a2, B:58:0x01ff, B:60:0x020d, B:65:0x0255, B:67:0x025b, B:70:0x0265, B:72:0x02c8, B:73:0x0311, B:75:0x031b, B:81:0x0329), top: B:126:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0399 A[Catch: all -> 0x0251, TRY_LEAVE, TryCatch #1 {all -> 0x0251, blocks: (B:98:0x03d7, B:100:0x03e5, B:103:0x0429, B:105:0x042f, B:108:0x0439, B:110:0x04a2, B:111:0x04ed, B:113:0x04f7, B:119:0x0503, B:89:0x0391, B:91:0x0399, B:94:0x03a2, B:58:0x01ff, B:60:0x020d, B:65:0x0255, B:67:0x025b, B:70:0x0265, B:72:0x02c8, B:73:0x0311, B:75:0x031b, B:81:0x0329), top: B:126:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03a2 A[Catch: all -> 0x0251, TRY_ENTER, TryCatch #1 {all -> 0x0251, blocks: (B:98:0x03d7, B:100:0x03e5, B:103:0x0429, B:105:0x042f, B:108:0x0439, B:110:0x04a2, B:111:0x04ed, B:113:0x04f7, B:119:0x0503, B:89:0x0391, B:91:0x0399, B:94:0x03a2, B:58:0x01ff, B:60:0x020d, B:65:0x0255, B:67:0x025b, B:70:0x0265, B:72:0x02c8, B:73:0x0311, B:75:0x031b, B:81:0x0329), top: B:126:0x0031 }] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object purchase(String str, String str2, Continuation<? super PurchaseResult> continuation) {
        AnonymousClass3 anonymousClass3;
        ?? r3;
        Object obj;
        ?? r32;
        Mutex mutex;
        Billing billing;
        String str3;
        String str4;
        int i;
        int i2;
        String str5;
        String str6;
        String str7;
        Billing billing2;
        int i3;
        Mutex mutex2;
        Object obj2;
        int i4;
        Billing billing3;
        BillingResult billingResult;
        Object obj3;
        int i5;
        int i6;
        int i7;
        Mutex mutex3;
        int i8;
        SkuDetailsResult skuDetailsResult;
        SkuDetails skuDetails;
        Object orThrow;
        ?? r33;
        BillingResult billingResult2;
        BillingResult billingResult3;
        Object obj4;
        int i9;
        int i10;
        int i11;
        BillingResult billingResult4;
        SkuDetailsResult skuDetailsResult2;
        SkuDetails skuDetails2;
        Mutex mutex4;
        Object obj5;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i12 = anonymousClass3.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label = i12 - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        }
        Object orThrow2 = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r4 = anonymousClass3.label;
        try {
            switch (r4) {
                case 0:
                    ResultKt.throwOnFailure(orThrow2);
                    mutex = getMutex();
                    anonymousClass3.L$0 = str;
                    anonymousClass3.L$1 = str2;
                    anonymousClass3.L$2 = this;
                    anonymousClass3.L$3 = mutex;
                    anonymousClass3.I$0 = 0;
                    anonymousClass3.I$1 = 0;
                    anonymousClass3.label = 1;
                    if (mutex.lock(null, anonymousClass3) != coroutine_suspended) {
                        billing = this;
                        str3 = str;
                        str4 = str2;
                        i = 0;
                        i2 = 0;
                        try {
                            if (billing.getClient().isReady()) {
                                Billing billing4 = billing;
                                str5 = " not found";
                                long secondsInMillis = Utils.getSecondsInMillis(10);
                                str6 = "sku details for ";
                                str7 = " launchBillingFlow: ";
                                billing2 = billing4;
                                Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, billing2);
                                anonymousClass3.L$0 = str3;
                                anonymousClass3.L$1 = str4;
                                anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(billing2);
                                anonymousClass3.L$3 = mutex;
                                anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(anonymousClass3);
                                anonymousClass3.I$0 = i2;
                                anonymousClass3.I$1 = i;
                                anonymousClass3.I$2 = 0;
                                anonymousClass3.J$0 = secondsInMillis;
                                anonymousClass3.I$3 = 0;
                                anonymousClass3.label = 4;
                                Object objWithTimeout = TimeoutKt.withTimeout(secondsInMillis, billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1, anonymousClass3);
                                if (objWithTimeout != coroutine_suspended) {
                                    i3 = i;
                                    mutex2 = mutex;
                                    obj2 = objWithTimeout;
                                    i4 = 0;
                                    billingResult2 = (BillingResult) obj2;
                                    if (billingResult2.getResponseCode() == 0) {
                                        PurchaseResult purchaseResult = BillingKt.toPurchaseResult(billingResult2);
                                        mutex2.unlock(null);
                                        return purchaseResult;
                                    }
                                    anonymousClass3.L$0 = str3;
                                    anonymousClass3.L$1 = str4;
                                    anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(billing2);
                                    anonymousClass3.L$3 = mutex2;
                                    anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(billingResult2);
                                    anonymousClass3.L$5 = SpillingKt.nullOutSpilledVariable(billingResult2);
                                    anonymousClass3.I$0 = i2;
                                    anonymousClass3.I$1 = i3;
                                    anonymousClass3.I$2 = i4;
                                    anonymousClass3.I$3 = 0;
                                    anonymousClass3.label = 5;
                                    Object objQuerySkuDetails = querySkuDetails(str3, str4, anonymousClass3);
                                    if (objQuerySkuDetails != coroutine_suspended) {
                                        billingResult3 = billingResult2;
                                        obj4 = objQuerySkuDetails;
                                        i9 = 0;
                                        i10 = i3;
                                        i11 = i2;
                                        billingResult4 = billingResult3;
                                        skuDetailsResult2 = (SkuDetailsResult) obj4;
                                        if (skuDetailsResult2.getZza().getResponseCode() == 0) {
                                            String str8 = str3 + " " + str4 + " querySkuDetails: " + skuDetailsResult2.getZza();
                                            Logger.logSevere(Logger.defaultTag, getTag() + ": " + str8, null);
                                            PurchaseResult purchaseResult2 = BillingKt.toPurchaseResult(skuDetailsResult2.getZza());
                                            mutex2.unlock(null);
                                            return purchaseResult2;
                                        }
                                        List<SkuDetails> skuDetailsList = skuDetailsResult2.getSkuDetailsList();
                                        if (skuDetailsList != null && (skuDetails2 = (SkuDetails) CollectionsKt.firstOrNull((List) skuDetailsList)) != null) {
                                            BillingResult billingResult5 = billingResult4;
                                            BillingFlowParams billingFlowParamsBuild = BillingFlowParams.newBuilder().setSkuDetails(skuDetails2).build();
                                            billingFlowParamsBuild.getClass();
                                            anonymousClass3.L$0 = str3;
                                            anonymousClass3.L$1 = str4;
                                            anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(billing2);
                                            anonymousClass3.L$3 = mutex2;
                                            anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(billingResult3);
                                            anonymousClass3.L$5 = skuDetailsResult2;
                                            anonymousClass3.L$6 = SpillingKt.nullOutSpilledVariable(skuDetails2);
                                            anonymousClass3.L$7 = billingFlowParamsBuild;
                                            anonymousClass3.L$8 = anonymousClass3;
                                            anonymousClass3.L$9 = SpillingKt.nullOutSpilledVariable(billingResult5);
                                            anonymousClass3.I$0 = i11;
                                            anonymousClass3.I$1 = i10;
                                            anonymousClass3.I$2 = i4;
                                            anonymousClass3.I$3 = i9;
                                            anonymousClass3.label = 6;
                                            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(anonymousClass3));
                                            final SafeResumeContinuation safeResumeContinuation = new SafeResumeContinuation(safeContinuation);
                                            this.purchaseUpdatedListener.setListener(new Function2<BillingResult, Purchase, Unit>() { // from class: com.urbandroid.sleep.trial.Billing$purchase$4$1$1
                                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(BillingResult billingResult6, Purchase purchase) {
                                                    ArrayList<String> skus;
                                                    billingResult6.getClass();
                                                    Billing billing5 = this.this$0;
                                                    String strM = Fragment$$ExternalSyntheticOutline1.m("purchaseUpdatedListener: ", BillingKt.pretty(billingResult6), " sku: ", (purchase == null || (skus = purchase.getSkus()) == null) ? null : CollectionsKt.joinToString$default(skus, null, null, null, new Function1<String, CharSequence>() { // from class: com.urbandroid.sleep.trial.Billing$purchase$4$1$1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final CharSequence invoke(String str9) {
                                                            return FileInsert$$ExternalSyntheticOutline0.m(" ", str9, " ");
                                                        }
                                                    }, 31));
                                                    Logger.logInfo(Logger.defaultTag, billing5.getTag() + ": " + strM, null);
                                                    Billing.SafeResumeContinuation<PurchaseResult> safeResumeContinuation2 = safeResumeContinuation;
                                                    Result.Companion companion = Result.INSTANCE;
                                                    safeResumeContinuation2.resumeWith(Result.m2357constructorimpl(new PurchaseResult(billingResult6, purchase)));
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(BillingResult billingResult6, Purchase purchase) {
                                                    invoke2(billingResult6, purchase);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            BillingResult billingResultLaunchBillingFlow = this.client.launchBillingFlow(this.activity, billingFlowParamsBuild);
                                            billingResultLaunchBillingFlow.getClass();
                                            if (billingResultLaunchBillingFlow.getResponseCode() != 0) {
                                                String str9 = str3 + " " + str4 + str7 + BillingKt.pretty(billingResultLaunchBillingFlow);
                                                Logger.logSevere(Logger.defaultTag, getTag() + ": " + str9, null);
                                                Result.Companion companion = Result.INSTANCE;
                                                safeResumeContinuation.resumeWith(Result.m2357constructorimpl(BillingKt.toPurchaseResult(skuDetailsResult2.getZza())));
                                            }
                                            orThrow2 = safeContinuation.getOrThrow();
                                            if (orThrow2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                                DebugProbesKt.probeCoroutineSuspended(anonymousClass3);
                                            }
                                            if (orThrow2 != coroutine_suspended) {
                                                mutex4 = mutex2;
                                                obj5 = null;
                                                mutex4.unlock(obj5);
                                                return orThrow2;
                                            }
                                        }
                                        PurchaseResult purchaseResult3 = BillingKt.toPurchaseResult(BillingKt.billingResult(6, str6 + str3 + " " + str4 + str5));
                                        mutex2.unlock(null);
                                        return purchaseResult3;
                                    }
                                }
                            } else {
                                Billing billing5 = billing;
                                BillingResult billingResult6 = BillingKt.billingResult(0, "Connected");
                                if (billingResult6.getResponseCode() != 0) {
                                    PurchaseResult purchaseResult4 = BillingKt.toPurchaseResult(billingResult6);
                                    mutex.unlock(null);
                                    return purchaseResult4;
                                }
                                anonymousClass3.L$0 = str3;
                                anonymousClass3.L$1 = str4;
                                anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(billing5);
                                anonymousClass3.L$3 = mutex;
                                anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(billingResult6);
                                anonymousClass3.I$0 = i2;
                                anonymousClass3.I$1 = i;
                                anonymousClass3.I$2 = 0;
                                anonymousClass3.I$3 = 0;
                                anonymousClass3.label = 2;
                                Object objQuerySkuDetails2 = querySkuDetails(str3, str4, anonymousClass3);
                                if (objQuerySkuDetails2 != coroutine_suspended) {
                                    billing3 = billing5;
                                    billingResult = billingResult6;
                                    obj3 = objQuerySkuDetails2;
                                    i5 = 0;
                                    i6 = i2;
                                    i7 = i;
                                    mutex3 = mutex;
                                    i8 = 0;
                                    skuDetailsResult = (SkuDetailsResult) obj3;
                                    if (skuDetailsResult.getZza().getResponseCode() == 0) {
                                        String str10 = str3 + " " + str4 + " querySkuDetails: " + skuDetailsResult.getZza();
                                        Logger.logSevere(Logger.defaultTag, getTag() + ": " + str10, null);
                                        PurchaseResult purchaseResult5 = BillingKt.toPurchaseResult(skuDetailsResult.getZza());
                                        mutex3.unlock(null);
                                        return purchaseResult5;
                                    }
                                    List<SkuDetails> skuDetailsList2 = skuDetailsResult.getSkuDetailsList();
                                    if (skuDetailsList2 != null && (skuDetails = (SkuDetails) CollectionsKt.firstOrNull((List) skuDetailsList2)) != null) {
                                        BillingFlowParams billingFlowParamsBuild2 = BillingFlowParams.newBuilder().setSkuDetails(skuDetails).build();
                                        billingFlowParamsBuild2.getClass();
                                        anonymousClass3.L$0 = str3;
                                        anonymousClass3.L$1 = str4;
                                        anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(billing3);
                                        anonymousClass3.L$3 = mutex3;
                                        anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(billingResult);
                                        anonymousClass3.L$5 = skuDetailsResult;
                                        anonymousClass3.L$6 = SpillingKt.nullOutSpilledVariable(skuDetails);
                                        anonymousClass3.L$7 = billingFlowParamsBuild2;
                                        anonymousClass3.L$8 = anonymousClass3;
                                        anonymousClass3.I$0 = i6;
                                        anonymousClass3.I$1 = i7;
                                        anonymousClass3.I$2 = i5;
                                        anonymousClass3.I$3 = i8;
                                        anonymousClass3.label = 3;
                                        SafeContinuation safeContinuation2 = new SafeContinuation(IntrinsicsKt.intercepted(anonymousClass3));
                                        final SafeResumeContinuation safeResumeContinuation2 = new SafeResumeContinuation(safeContinuation2);
                                        this.purchaseUpdatedListener.setListener(new Function2<BillingResult, Purchase, Unit>() { // from class: com.urbandroid.sleep.trial.Billing$purchase$4$1$1
                                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(BillingResult billingResult62, Purchase purchase) {
                                                ArrayList<String> skus;
                                                billingResult62.getClass();
                                                Billing billing52 = this.this$0;
                                                String strM = Fragment$$ExternalSyntheticOutline1.m("purchaseUpdatedListener: ", BillingKt.pretty(billingResult62), " sku: ", (purchase == null || (skus = purchase.getSkus()) == null) ? null : CollectionsKt.joinToString$default(skus, null, null, null, new Function1<String, CharSequence>() { // from class: com.urbandroid.sleep.trial.Billing$purchase$4$1$1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final CharSequence invoke(String str92) {
                                                        return FileInsert$$ExternalSyntheticOutline0.m(" ", str92, " ");
                                                    }
                                                }, 31));
                                                Logger.logInfo(Logger.defaultTag, billing52.getTag() + ": " + strM, null);
                                                Billing.SafeResumeContinuation<PurchaseResult> safeResumeContinuation22 = safeResumeContinuation2;
                                                Result.Companion companion2 = Result.INSTANCE;
                                                safeResumeContinuation22.resumeWith(Result.m2357constructorimpl(new PurchaseResult(billingResult62, purchase)));
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(BillingResult billingResult62, Purchase purchase) {
                                                invoke2(billingResult62, purchase);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        BillingResult billingResultLaunchBillingFlow2 = this.client.launchBillingFlow(this.activity, billingFlowParamsBuild2);
                                        billingResultLaunchBillingFlow2.getClass();
                                        if (billingResultLaunchBillingFlow2.getResponseCode() != 0) {
                                            String str11 = str3 + " " + str4 + " launchBillingFlow: " + BillingKt.pretty(billingResultLaunchBillingFlow2);
                                            Logger.logSevere(Logger.defaultTag, getTag() + ": " + str11, null);
                                            Result.Companion companion2 = Result.INSTANCE;
                                            safeResumeContinuation2.resumeWith(Result.m2357constructorimpl(BillingKt.toPurchaseResult(skuDetailsResult.getZza())));
                                        }
                                        orThrow = safeContinuation2.getOrThrow();
                                        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                            DebugProbesKt.probeCoroutineSuspended(anonymousClass3);
                                        }
                                        if (orThrow != coroutine_suspended) {
                                            r33 = mutex3;
                                            r33.unlock(null);
                                            return orThrow;
                                        }
                                    }
                                    PurchaseResult purchaseResult6 = BillingKt.toPurchaseResult(BillingKt.billingResult(6, "sku details for " + str3 + " " + str4 + " not found"));
                                    mutex3.unlock(null);
                                    return purchaseResult6;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            r3 = mutex;
                            obj = null;
                            r32 = r3;
                            r32.unlock(obj);
                            throw th;
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    int i13 = anonymousClass3.I$1;
                    int i14 = anonymousClass3.I$0;
                    Mutex mutex5 = (Mutex) anonymousClass3.L$3;
                    Billing billing6 = (Billing) anonymousClass3.L$2;
                    str4 = (String) anonymousClass3.L$1;
                    str3 = (String) anonymousClass3.L$0;
                    ResultKt.throwOnFailure(orThrow2);
                    i = i13;
                    mutex = mutex5;
                    i2 = i14;
                    billing = billing6;
                    if (billing.getClient().isReady()) {
                    }
                    return coroutine_suspended;
                case 2:
                    int i15 = anonymousClass3.I$3;
                    int i16 = anonymousClass3.I$2;
                    int i17 = anonymousClass3.I$1;
                    int i18 = anonymousClass3.I$0;
                    BillingResult billingResult7 = (BillingResult) anonymousClass3.L$4;
                    Mutex mutex6 = (Mutex) anonymousClass3.L$3;
                    Billing billing7 = (Billing) anonymousClass3.L$2;
                    String str12 = (String) anonymousClass3.L$1;
                    String str13 = (String) anonymousClass3.L$0;
                    try {
                        ResultKt.throwOnFailure(orThrow2);
                        str4 = str12;
                        obj3 = orThrow2;
                        billingResult = billingResult7;
                        str3 = str13;
                        i8 = i15;
                        i6 = i18;
                        i7 = i17;
                        mutex3 = mutex6;
                        billing3 = billing7;
                        i5 = i16;
                        skuDetailsResult = (SkuDetailsResult) obj3;
                        if (skuDetailsResult.getZza().getResponseCode() == 0) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        r3 = mutex6;
                        obj = null;
                        r32 = r3;
                        r32.unlock(obj);
                        throw th;
                    }
                    break;
                case 3:
                    r3 = (Mutex) anonymousClass3.L$3;
                    try {
                        ResultKt.throwOnFailure(orThrow2);
                        orThrow = orThrow2;
                        r33 = r3;
                        r33.unlock(null);
                        return orThrow;
                    } catch (Throwable th3) {
                        th = th3;
                        obj = null;
                        r32 = r3;
                        r32.unlock(obj);
                        throw th;
                    }
                case 4:
                    int i19 = anonymousClass3.I$2;
                    int i20 = anonymousClass3.I$1;
                    i2 = anonymousClass3.I$0;
                    Mutex mutex7 = (Mutex) anonymousClass3.L$3;
                    Billing billing8 = (Billing) anonymousClass3.L$2;
                    String str14 = (String) anonymousClass3.L$1;
                    String str15 = (String) anonymousClass3.L$0;
                    try {
                        ResultKt.throwOnFailure(orThrow2);
                        str5 = " not found";
                        str7 = " launchBillingFlow: ";
                        i4 = i19;
                        i3 = i20;
                        mutex2 = mutex7;
                        str4 = str14;
                        obj2 = orThrow2;
                        str6 = "sku details for ";
                        billing2 = billing8;
                        str3 = str15;
                        billingResult2 = (BillingResult) obj2;
                        if (billingResult2.getResponseCode() == 0) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        r3 = mutex7;
                        obj = null;
                        r32 = r3;
                        r32.unlock(obj);
                        throw th;
                    }
                    break;
                case 5:
                    i9 = anonymousClass3.I$3;
                    int i21 = anonymousClass3.I$2;
                    int i22 = anonymousClass3.I$1;
                    int i23 = anonymousClass3.I$0;
                    billingResult4 = (BillingResult) anonymousClass3.L$5;
                    BillingResult billingResult8 = (BillingResult) anonymousClass3.L$4;
                    Mutex mutex8 = (Mutex) anonymousClass3.L$3;
                    Billing billing9 = (Billing) anonymousClass3.L$2;
                    String str16 = (String) anonymousClass3.L$1;
                    String str17 = (String) anonymousClass3.L$0;
                    try {
                        ResultKt.throwOnFailure(orThrow2);
                        billingResult3 = billingResult8;
                        str4 = str16;
                        str5 = " not found";
                        i4 = i21;
                        mutex2 = mutex8;
                        obj4 = orThrow2;
                        str6 = "sku details for ";
                        i10 = i22;
                        str3 = str17;
                        i11 = i23;
                        billing2 = billing9;
                        str7 = " launchBillingFlow: ";
                        skuDetailsResult2 = (SkuDetailsResult) obj4;
                        if (skuDetailsResult2.getZza().getResponseCode() == 0) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r3 = mutex8;
                        obj = null;
                        r32 = r3;
                        r32.unlock(obj);
                        throw th;
                    }
                    break;
                case 6:
                    Mutex mutex9 = (Mutex) anonymousClass3.L$3;
                    try {
                        ResultKt.throwOnFailure(orThrow2);
                        obj5 = null;
                        mutex4 = mutex9;
                        mutex4.unlock(obj5);
                        return orThrow2;
                    } catch (Throwable th6) {
                        th = th6;
                        obj = null;
                        r32 = mutex9;
                        r32.unlock(obj);
                        throw th;
                    }
                default:
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        } catch (Throwable th7) {
            th = th7;
            r3 = r4;
        }
    }

    public final Object queryPurchaseHistory(String str, Continuation<? super List<? extends PurchaseHistoryRecord>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C22182(str, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x012b -> B:32:0x012e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object querySkuDetails(List<? extends PurchaseType> list, Continuation<? super List<SkuDetailsResult>> continuation) {
        C22192 c22192;
        Collection collection;
        Map map;
        Map map2;
        int i;
        Iterator it;
        List<? extends PurchaseType> list2;
        int i2;
        if (continuation instanceof C22192) {
            c22192 = (C22192) continuation;
            int i3 = c22192.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c22192.label = i3 - Integer.MIN_VALUE;
            } else {
                c22192 = new C22192(continuation);
            }
        }
        Object obj = c22192.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c22192.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj2 : list) {
                String type = ((PurchaseType) obj2).getType();
                Object arrayList = linkedHashMap.get(type);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(type, arrayList);
                }
                ((List) arrayList).add(obj2);
            }
            ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
            Iterator it2 = linkedHashMap.entrySet().iterator();
            collection = arrayList2;
            map = linkedHashMap;
            map2 = map;
            i = 0;
            it = it2;
            list2 = list;
            i2 = 0;
            if (it.hasNext()) {
            }
        } else {
            if (i4 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = c22192.I$1;
            i2 = c22192.I$0;
            collection = (Collection) c22192.L$9;
            it = (Iterator) c22192.L$4;
            Collection collection2 = (Collection) c22192.L$3;
            map = (Map) c22192.L$2;
            map2 = (Map) c22192.L$1;
            List<? extends PurchaseType> list3 = (List) c22192.L$0;
            ResultKt.throwOnFailure(obj);
            collection.add((SkuDetailsResult) obj);
            collection = collection2;
            list2 = list3;
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                Iterator it3 = iterable.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(((PurchaseType) it3.next()).getPkg());
                }
                c22192.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                c22192.L$1 = SpillingKt.nullOutSpilledVariable(map2);
                c22192.L$2 = SpillingKt.nullOutSpilledVariable(map);
                c22192.L$3 = collection;
                c22192.L$4 = it;
                c22192.L$5 = SpillingKt.nullOutSpilledVariable(entry);
                c22192.L$6 = SpillingKt.nullOutSpilledVariable(entry);
                c22192.L$7 = SpillingKt.nullOutSpilledVariable(str);
                c22192.L$8 = SpillingKt.nullOutSpilledVariable(arrayList3);
                c22192.L$9 = collection;
                c22192.I$0 = i2;
                c22192.I$1 = i;
                c22192.I$2 = 0;
                c22192.label = 1;
                Object objQuerySkuDetails = querySkuDetails(arrayList3, str, c22192);
                if (objQuerySkuDetails == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list3 = list2;
                obj = objQuerySkuDetails;
                collection2 = collection;
                collection.add((SkuDetailsResult) obj);
                collection = collection2;
                list2 = list3;
                if (it.hasNext()) {
                    return (List) collection;
                }
            }
        }
    }

    public final Object refreshPurchaseState(String str, String str2, Continuation<? super RefreshPurchaseState> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C22202(str, str2, null), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02fb A[Catch: all -> 0x00bb, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x00bb, blocks: (B:26:0x00b2, B:100:0x02fb), top: B:159:0x00b2 }] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0303 A[Catch: all -> 0x0329, TRY_ENTER, TryCatch #4 {all -> 0x0329, blocks: (B:98:0x02f2, B:103:0x0303, B:104:0x0315, B:106:0x031b, B:110:0x032e, B:112:0x033d, B:131:0x03bf), top: B:156:0x02f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x037f A[Catch: all -> 0x0394, TryCatch #3 {all -> 0x0394, blocks: (B:139:0x0434, B:140:0x0445, B:142:0x044b, B:116:0x036e, B:117:0x0379, B:119:0x037f, B:121:0x0390, B:124:0x0396, B:125:0x03a5, B:127:0x03ab), top: B:152:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03ab A[Catch: all -> 0x0394, LOOP:2: B:125:0x03a5->B:127:0x03ab, LOOP_END, TRY_LEAVE, TryCatch #3 {all -> 0x0394, blocks: (B:139:0x0434, B:140:0x0445, B:142:0x044b, B:116:0x036e, B:117:0x0379, B:119:0x037f, B:121:0x0390, B:124:0x0396, B:125:0x03a5, B:127:0x03ab), top: B:152:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x044b A[Catch: all -> 0x0394, LOOP:0: B:140:0x0445->B:142:0x044b, LOOP_END, TRY_LEAVE, TryCatch #3 {all -> 0x0394, blocks: (B:139:0x0434, B:140:0x0445, B:142:0x044b, B:116:0x036e, B:117:0x0379, B:119:0x037f, B:121:0x0390, B:124:0x0396, B:125:0x03a5, B:127:0x03ab), top: B:152:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e9 A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:13:0x004c, B:23:0x0097, B:31:0x00d8, B:86:0x0290, B:87:0x02a1, B:89:0x02a7, B:39:0x0117, B:65:0x01d8, B:66:0x01e3, B:68:0x01e9, B:70:0x01fa, B:71:0x01fe, B:72:0x020d, B:74:0x0213), top: B:152:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0213 A[Catch: all -> 0x0051, LOOP:6: B:72:0x020d->B:74:0x0213, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:13:0x004c, B:23:0x0097, B:31:0x00d8, B:86:0x0290, B:87:0x02a1, B:89:0x02a7, B:39:0x0117, B:65:0x01d8, B:66:0x01e3, B:68:0x01e9, B:70:0x01fa, B:71:0x01fe, B:72:0x020d, B:74:0x0213), top: B:152:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02a7 A[Catch: all -> 0x0051, LOOP:4: B:87:0x02a1->B:89:0x02a7, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:13:0x004c, B:23:0x0097, B:31:0x00d8, B:86:0x0290, B:87:0x02a1, B:89:0x02a7, B:39:0x0117, B:65:0x01d8, B:66:0x01e3, B:68:0x01e9, B:70:0x01fa, B:71:0x01fe, B:72:0x020d, B:74:0x0213), top: B:152:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02ba  */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object resolveSkuDetails(List<? extends PurchaseType> list, Continuation<? super List<LoadedSkuDetail>> continuation) throws Throwable {
        C22211 c22211;
        Object obj;
        ?? r3;
        Object obj2;
        Mutex mutex;
        List<? extends PurchaseType> list2;
        Billing billing;
        int i;
        int i2;
        BillingResult billingResult;
        List<? extends PurchaseType> list3;
        int i3;
        List list4;
        Mutex mutex2;
        int i4;
        Mutex mutex3;
        List list5;
        Mutex mutex4;
        int i5;
        Billing billing2;
        int i6;
        List<? extends PurchaseType> list6;
        int i7;
        Iterator it;
        List details;
        List list7;
        Mutex mutex5;
        Iterator it2;
        BillingResult billingResult2;
        int i8;
        int i9;
        Mutex mutex6;
        int i10;
        List list8;
        BillingResult billingResult3;
        Mutex mutex7;
        List list9;
        Iterator it3;
        List details2;
        List list10;
        Mutex mutex8;
        Iterator it4;
        if (continuation instanceof C22211) {
            c22211 = (C22211) continuation;
            int i11 = c22211.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                c22211.label = i11 - Integer.MIN_VALUE;
            } else {
                c22211 = new C22211(continuation);
            }
        }
        Object objQuerySkuDetails = c22211.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                switch (c22211.label) {
                    case 0:
                        ResultKt.throwOnFailure(objQuerySkuDetails);
                        mutex = getMutex();
                        list2 = list;
                        c22211.L$0 = list2;
                        c22211.L$1 = this;
                        c22211.L$2 = mutex;
                        c22211.I$0 = 0;
                        c22211.I$1 = 0;
                        c22211.label = 1;
                        if (mutex.lock(null, c22211) != coroutine_suspended) {
                            billing = this;
                            i = 0;
                            i2 = 0;
                            try {
                                if (billing.getClient().isReady()) {
                                    long secondsInMillis = Utils.getSecondsInMillis(10);
                                    Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1 = new Billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1(null, billing);
                                    c22211.L$0 = list2;
                                    c22211.L$1 = SpillingKt.nullOutSpilledVariable(billing);
                                    c22211.L$2 = mutex;
                                    c22211.L$3 = SpillingKt.nullOutSpilledVariable(c22211);
                                    c22211.I$0 = i2;
                                    c22211.I$1 = i;
                                    c22211.I$2 = 0;
                                    c22211.J$0 = secondsInMillis;
                                    c22211.I$3 = 0;
                                    c22211.label = 5;
                                    Object objWithTimeout = TimeoutKt.withTimeout(secondsInMillis, billing$connect$lambda$0$$inlined$suspendCoroutineWithTimeout$1, c22211);
                                    if (objWithTimeout != coroutine_suspended) {
                                        mutex4 = mutex;
                                        objQuerySkuDetails = objWithTimeout;
                                        i5 = i2;
                                        billing2 = billing;
                                        i6 = i;
                                        list6 = list2;
                                        i7 = 0;
                                        try {
                                            billingResult2 = (BillingResult) objQuerySkuDetails;
                                            if (billingResult2.getResponseCode() == 0) {
                                                List listEmptyList = CollectionsKt.emptyList();
                                                mutex4.unlock(null);
                                                return listEmptyList;
                                            }
                                            List<? extends PurchaseType> list11 = list6;
                                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list11, 10));
                                            Iterator it5 = list11.iterator();
                                            while (it5.hasNext()) {
                                                arrayList.add(((PurchaseType) it5.next()).getPkg());
                                            }
                                            Context applicationContext = this.activity.getApplicationContext();
                                            applicationContext.getClass();
                                            if (ContextExtKt.hasConnectivity(applicationContext)) {
                                                c22211.L$0 = SpillingKt.nullOutSpilledVariable(list6);
                                                c22211.L$1 = SpillingKt.nullOutSpilledVariable(billing2);
                                                c22211.L$2 = mutex4;
                                                c22211.L$3 = SpillingKt.nullOutSpilledVariable(billingResult2);
                                                c22211.L$4 = SpillingKt.nullOutSpilledVariable(billingResult2);
                                                c22211.L$5 = SpillingKt.nullOutSpilledVariable(arrayList);
                                                c22211.I$0 = i5;
                                                c22211.I$1 = i6;
                                                c22211.I$2 = i7;
                                                c22211.I$3 = 0;
                                                c22211.label = 7;
                                                objQuerySkuDetails = querySkuDetails(list6, c22211);
                                                if (objQuerySkuDetails != coroutine_suspended) {
                                                    i8 = i7;
                                                    i9 = 0;
                                                    mutex6 = mutex4;
                                                    i10 = i5;
                                                    list8 = arrayList;
                                                    billingResult3 = billingResult2;
                                                    try {
                                                        details2 = BillingKt.toDetails((List) objQuerySkuDetails);
                                                        c22211.L$0 = SpillingKt.nullOutSpilledVariable(list6);
                                                        c22211.L$1 = SpillingKt.nullOutSpilledVariable(billing2);
                                                        c22211.L$2 = mutex6;
                                                        c22211.L$3 = SpillingKt.nullOutSpilledVariable(billingResult3);
                                                        c22211.L$4 = details2;
                                                        c22211.L$5 = SpillingKt.nullOutSpilledVariable(billingResult2);
                                                        c22211.L$6 = SpillingKt.nullOutSpilledVariable(list8);
                                                        c22211.I$0 = i10;
                                                        c22211.I$1 = i6;
                                                        c22211.I$2 = i8;
                                                        c22211.I$3 = i9;
                                                        c22211.label = 8;
                                                        if (storeSkuDetails(details2, c22211) != coroutine_suspended) {
                                                            list10 = details2;
                                                            mutex8 = mutex6;
                                                            List list12 = list10;
                                                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list12, 10));
                                                            it4 = list12.iterator();
                                                            while (it4.hasNext()) {
                                                                arrayList2.add(new LoadedSkuDetail((SkuDetails) it4.next(), false));
                                                            }
                                                            mutex8.unlock(null);
                                                            return arrayList2;
                                                        }
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        obj2 = mutex6;
                                                        obj = null;
                                                        r3 = obj2;
                                                        r3.unlock(obj);
                                                        throw th;
                                                    }
                                                }
                                            } else {
                                                c22211.L$0 = SpillingKt.nullOutSpilledVariable(list6);
                                                c22211.L$1 = SpillingKt.nullOutSpilledVariable(billing2);
                                                c22211.L$2 = mutex4;
                                                c22211.L$3 = SpillingKt.nullOutSpilledVariable(billingResult2);
                                                c22211.L$4 = SpillingKt.nullOutSpilledVariable(billingResult2);
                                                c22211.L$5 = arrayList;
                                                c22211.I$0 = i5;
                                                c22211.I$1 = i6;
                                                c22211.I$2 = i7;
                                                c22211.I$3 = 0;
                                                c22211.label = 6;
                                                objQuerySkuDetails = loadSkuDetails(c22211);
                                                if (objQuerySkuDetails != coroutine_suspended) {
                                                    mutex7 = mutex4;
                                                    list9 = arrayList;
                                                    ArrayList arrayList3 = new ArrayList();
                                                    for (Object obj3 : (Iterable) objQuerySkuDetails) {
                                                        if (list9.contains(((SkuDetails) obj3).getSku())) {
                                                            arrayList3.add(obj3);
                                                        }
                                                    }
                                                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                                                    it3 = arrayList3.iterator();
                                                    while (it3.hasNext()) {
                                                        arrayList4.add(new LoadedSkuDetail((SkuDetails) it3.next(), true));
                                                    }
                                                    mutex7.unlock(null);
                                                    return arrayList4;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            obj2 = mutex4;
                                            obj = null;
                                            r3 = obj2;
                                            r3.unlock(obj);
                                            throw th;
                                        }
                                    }
                                } else {
                                    try {
                                        billingResult = BillingKt.billingResult(0, "Connected");
                                        if (billingResult.getResponseCode() != 0) {
                                            List listEmptyList2 = CollectionsKt.emptyList();
                                            mutex.unlock(null);
                                            return listEmptyList2;
                                        }
                                        List<? extends PurchaseType> list13 = list2;
                                        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list13, 10));
                                        Iterator it6 = list13.iterator();
                                        while (it6.hasNext()) {
                                            arrayList5.add(((PurchaseType) it6.next()).getPkg());
                                        }
                                        Context applicationContext2 = this.activity.getApplicationContext();
                                        applicationContext2.getClass();
                                        if (ContextExtKt.hasConnectivity(applicationContext2)) {
                                            c22211.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                                            c22211.L$1 = SpillingKt.nullOutSpilledVariable(billing);
                                            c22211.L$2 = mutex;
                                            c22211.L$3 = SpillingKt.nullOutSpilledVariable(billingResult);
                                            c22211.L$4 = SpillingKt.nullOutSpilledVariable(arrayList5);
                                            c22211.I$0 = i2;
                                            c22211.I$1 = i;
                                            c22211.I$2 = 0;
                                            c22211.I$3 = 0;
                                            c22211.label = 3;
                                            Object objQuerySkuDetails2 = querySkuDetails(list2, c22211);
                                            if (objQuerySkuDetails2 != coroutine_suspended) {
                                                list3 = list2;
                                                i3 = 0;
                                                list4 = arrayList5;
                                                mutex2 = mutex;
                                                objQuerySkuDetails = objQuerySkuDetails2;
                                                i4 = 0;
                                                details = BillingKt.toDetails((List) objQuerySkuDetails);
                                                c22211.L$0 = SpillingKt.nullOutSpilledVariable(list3);
                                                c22211.L$1 = SpillingKt.nullOutSpilledVariable(billing);
                                                c22211.L$2 = mutex2;
                                                c22211.L$3 = SpillingKt.nullOutSpilledVariable(billingResult);
                                                c22211.L$4 = details;
                                                c22211.L$5 = SpillingKt.nullOutSpilledVariable(list4);
                                                c22211.I$0 = i2;
                                                c22211.I$1 = i;
                                                c22211.I$2 = i4;
                                                c22211.I$3 = i3;
                                                c22211.label = 4;
                                                if (storeSkuDetails(details, c22211) != coroutine_suspended) {
                                                    list7 = details;
                                                    mutex5 = mutex2;
                                                    List list14 = list7;
                                                    ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list14, 10));
                                                    it2 = list14.iterator();
                                                    while (it2.hasNext()) {
                                                        arrayList6.add(new LoadedSkuDetail((SkuDetails) it2.next(), false));
                                                    }
                                                    mutex5.unlock(null);
                                                    return arrayList6;
                                                }
                                            }
                                        } else {
                                            c22211.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                                            c22211.L$1 = SpillingKt.nullOutSpilledVariable(billing);
                                            c22211.L$2 = mutex;
                                            c22211.L$3 = SpillingKt.nullOutSpilledVariable(billingResult);
                                            c22211.L$4 = arrayList5;
                                            c22211.I$0 = i2;
                                            c22211.I$1 = i;
                                            c22211.I$2 = 0;
                                            c22211.I$3 = 0;
                                            c22211.label = 2;
                                            Object objLoadSkuDetails = loadSkuDetails(c22211);
                                            if (objLoadSkuDetails != coroutine_suspended) {
                                                mutex3 = mutex;
                                                objQuerySkuDetails = objLoadSkuDetails;
                                                list5 = arrayList5;
                                                ArrayList arrayList7 = new ArrayList();
                                                for (Object obj4 : (Iterable) objQuerySkuDetails) {
                                                    if (list5.contains(((SkuDetails) obj4).getSku())) {
                                                        arrayList7.add(obj4);
                                                    }
                                                }
                                                ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
                                                it = arrayList7.iterator();
                                                while (it.hasNext()) {
                                                    arrayList8.add(new LoadedSkuDetail((SkuDetails) it.next(), true));
                                                }
                                                mutex3.unlock(null);
                                                return arrayList8;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        coroutine_suspended = mutex;
                                        obj = null;
                                        r3 = coroutine_suspended;
                                        r3.unlock(obj);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                obj2 = mutex;
                                obj = null;
                                r3 = obj2;
                                r3.unlock(obj);
                                throw th;
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        int i12 = c22211.I$1;
                        int i13 = c22211.I$0;
                        Mutex mutex9 = (Mutex) c22211.L$2;
                        Billing billing3 = (Billing) c22211.L$1;
                        List<? extends PurchaseType> list15 = (List) c22211.L$0;
                        ResultKt.throwOnFailure(objQuerySkuDetails);
                        mutex = mutex9;
                        billing = billing3;
                        i2 = i13;
                        i = i12;
                        list2 = list15;
                        if (billing.getClient().isReady()) {
                        }
                        return coroutine_suspended;
                    case 2:
                        list5 = (List) c22211.L$4;
                        mutex3 = (Mutex) c22211.L$2;
                        ResultKt.throwOnFailure(objQuerySkuDetails);
                        ArrayList arrayList72 = new ArrayList();
                        while (r1.hasNext()) {
                        }
                        ArrayList arrayList82 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList72, 10));
                        it = arrayList72.iterator();
                        while (it.hasNext()) {
                        }
                        mutex3.unlock(null);
                        return arrayList82;
                    case 3:
                        i3 = c22211.I$3;
                        i4 = c22211.I$2;
                        i = c22211.I$1;
                        i2 = c22211.I$0;
                        list4 = (List) c22211.L$4;
                        billingResult = (BillingResult) c22211.L$3;
                        mutex2 = (Mutex) c22211.L$2;
                        billing = (Billing) c22211.L$1;
                        list3 = (List) c22211.L$0;
                        try {
                            ResultKt.throwOnFailure(objQuerySkuDetails);
                            details = BillingKt.toDetails((List) objQuerySkuDetails);
                            c22211.L$0 = SpillingKt.nullOutSpilledVariable(list3);
                            c22211.L$1 = SpillingKt.nullOutSpilledVariable(billing);
                            c22211.L$2 = mutex2;
                            c22211.L$3 = SpillingKt.nullOutSpilledVariable(billingResult);
                            c22211.L$4 = details;
                            c22211.L$5 = SpillingKt.nullOutSpilledVariable(list4);
                            c22211.I$0 = i2;
                            c22211.I$1 = i;
                            c22211.I$2 = i4;
                            c22211.I$3 = i3;
                            c22211.label = 4;
                            if (storeSkuDetails(details, c22211) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        } catch (Throwable th5) {
                            th = th5;
                            obj = null;
                            r3 = mutex2;
                            r3.unlock(obj);
                            throw th;
                        }
                    case 4:
                        list7 = (List) c22211.L$4;
                        mutex5 = (Mutex) c22211.L$2;
                        ResultKt.throwOnFailure(objQuerySkuDetails);
                        List list142 = list7;
                        ArrayList arrayList62 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list142, 10));
                        it2 = list142.iterator();
                        while (it2.hasNext()) {
                        }
                        mutex5.unlock(null);
                        return arrayList62;
                    case 5:
                        i7 = c22211.I$2;
                        int i14 = c22211.I$1;
                        int i15 = c22211.I$0;
                        mutex4 = (Mutex) c22211.L$2;
                        Billing billing4 = (Billing) c22211.L$1;
                        List<? extends PurchaseType> list16 = (List) c22211.L$0;
                        try {
                            ResultKt.throwOnFailure(objQuerySkuDetails);
                            billing2 = billing4;
                            i5 = i15;
                            i6 = i14;
                            list6 = list16;
                            billingResult2 = (BillingResult) objQuerySkuDetails;
                            if (billingResult2.getResponseCode() == 0) {
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            obj = null;
                            r3 = mutex4;
                            r3.unlock(obj);
                            throw th;
                        }
                        break;
                    case 6:
                        list9 = (List) c22211.L$5;
                        mutex7 = (Mutex) c22211.L$2;
                        ResultKt.throwOnFailure(objQuerySkuDetails);
                        ArrayList arrayList32 = new ArrayList();
                        while (r1.hasNext()) {
                        }
                        ArrayList arrayList42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList32, 10));
                        it3 = arrayList32.iterator();
                        while (it3.hasNext()) {
                        }
                        mutex7.unlock(null);
                        return arrayList42;
                    case 7:
                        i9 = c22211.I$3;
                        i8 = c22211.I$2;
                        i6 = c22211.I$1;
                        i10 = c22211.I$0;
                        list8 = (List) c22211.L$5;
                        billingResult2 = (BillingResult) c22211.L$4;
                        billingResult3 = (BillingResult) c22211.L$3;
                        mutex6 = (Mutex) c22211.L$2;
                        billing2 = (Billing) c22211.L$1;
                        list6 = (List) c22211.L$0;
                        try {
                            ResultKt.throwOnFailure(objQuerySkuDetails);
                            details2 = BillingKt.toDetails((List) objQuerySkuDetails);
                            c22211.L$0 = SpillingKt.nullOutSpilledVariable(list6);
                            c22211.L$1 = SpillingKt.nullOutSpilledVariable(billing2);
                            c22211.L$2 = mutex6;
                            c22211.L$3 = SpillingKt.nullOutSpilledVariable(billingResult3);
                            c22211.L$4 = details2;
                            c22211.L$5 = SpillingKt.nullOutSpilledVariable(billingResult2);
                            c22211.L$6 = SpillingKt.nullOutSpilledVariable(list8);
                            c22211.I$0 = i10;
                            c22211.I$1 = i6;
                            c22211.I$2 = i8;
                            c22211.I$3 = i9;
                            c22211.label = 8;
                            if (storeSkuDetails(details2, c22211) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        } catch (Throwable th7) {
                            th = th7;
                            obj = null;
                            r3 = mutex6;
                            r3.unlock(obj);
                            throw th;
                        }
                    case 8:
                        list10 = (List) c22211.L$4;
                        mutex8 = (Mutex) c22211.L$2;
                        ResultKt.throwOnFailure(objQuerySkuDetails);
                        List list122 = list10;
                        ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list122, 10));
                        it4 = list122.iterator();
                        while (it4.hasNext()) {
                        }
                        mutex8.unlock(null);
                        return arrayList22;
                    default:
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (Throwable th9) {
            th = th9;
            obj2 = coroutine_suspended;
        }
    }

    public final Object storeSkuDetails(List<? extends SkuDetails> list, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new C22222(list, this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/trial/Billing$RefreshPurchaseState;", "", "Lcom/urbandroid/sleep/trial/IBillingStatusListener$Status;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "", "sku", "<init>", "(Lcom/urbandroid/sleep/trial/IBillingStatusListener$Status;Ljava/lang/String;)V", "component1", "()Lcom/urbandroid/sleep/trial/IBillingStatusListener$Status;", "component2", "()Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/urbandroid/sleep/trial/IBillingStatusListener$Status;", "getStatus", "Ljava/lang/String;", "getSku", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class RefreshPurchaseState {
        private final String sku;
        private final IBillingStatusListener.Status status;

        public RefreshPurchaseState(IBillingStatusListener.Status status, String str) {
            status.getClass();
            this.status = status;
            this.sku = str;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final IBillingStatusListener.Status getStatus() {
            return this.status;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSku() {
            return this.sku;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RefreshPurchaseState)) {
                return false;
            }
            RefreshPurchaseState refreshPurchaseState = (RefreshPurchaseState) other;
            return this.status == refreshPurchaseState.status && Intrinsics.areEqual(this.sku, refreshPurchaseState.sku);
        }

        public int hashCode() {
            int iHashCode = this.status.hashCode() * 31;
            String str = this.sku;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "RefreshPurchaseState(status=" + this.status + ", sku=" + this.sku + ")";
        }

        public /* synthetic */ RefreshPurchaseState(IBillingStatusListener.Status status, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(status, (i & 2) != 0 ? null : str);
        }
    }

    public final Object querySkuDetails(PurchaseType purchaseType, Continuation<? super SkuDetailsResult> continuation) {
        return querySkuDetails(purchaseType.getPkg(), purchaseType.getType(), continuation);
    }

    private final Object querySkuDetails(List<String> list, String str, Continuation<? super SkuDetailsResult> continuation) {
        SkuDetailsParams.Builder type = SkuDetailsParams.newBuilder().setSkusList(list).setType(str);
        type.getClass();
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass6(type, null), continuation);
    }

    public final Object querySkuDetails(String str, String str2, Continuation<? super SkuDetailsResult> continuation) {
        return querySkuDetails(CollectionsKt.listOf(str), str2, continuation);
    }

    public final Object purchase(PurchaseType purchaseType, Continuation<? super PurchaseResult> continuation) {
        Object objPurchase = purchase(purchaseType.getPkg(), purchaseType.getType(), continuation);
        return objPurchase == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objPurchase : (PurchaseResult) objPurchase;
    }
}
