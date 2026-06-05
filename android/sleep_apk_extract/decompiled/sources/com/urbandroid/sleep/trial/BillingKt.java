package com.urbandroid.sleep.trial;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsResult;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\t¢\u0006\u0004\b\n\u0010\u000b\u001a\u0013\u0010\f\u001a\u00020\u0000*\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u000e\u001a\u00020\u0000*\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\r\u001a\u001d\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0019*\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a8\u0010%\u001a\u00020\"*\u00020\u001e2\"\u0010$\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!\u0012\u0006\u0012\u0004\u0018\u00010#0\u001fH\u0086@¢\u0006\u0004\b%\u0010&\u001a\u001b\u0010(\u001a\u00020\"*\u00020\u001e2\u0006\u0010'\u001a\u00020\u0000H\u0000¢\u0006\u0004\b(\u0010)\"\u0014\u0010*\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006,"}, d2 = {"", "getChar", "()Ljava/lang/String;", "", "getNum", "()I", "", "getSpecialChar", "()C", "Lcom/android/billingclient/api/BillingResult;", "pretty", "(Lcom/android/billingclient/api/BillingResult;)Ljava/lang/String;", "prettyCode", "(I)Ljava/lang/String;", "prettyState", "code", "message", "billingResult", "(ILjava/lang/String;)Lcom/android/billingclient/api/BillingResult;", "Lcom/urbandroid/sleep/trial/PurchaseResult;", "toPurchaseResult", "(Lcom/android/billingclient/api/BillingResult;)Lcom/urbandroid/sleep/trial/PurchaseResult;", "", "isOk", "(Lcom/android/billingclient/api/BillingResult;)Z", "", "Lcom/android/billingclient/api/SkuDetailsResult;", "Lcom/android/billingclient/api/SkuDetails;", "toDetails", "(Ljava/util/List;)Ljava/util/List;", "Landroid/app/Activity;", "Lkotlin/Function2;", "Lcom/urbandroid/sleep/trial/Billing;", "Lkotlin/coroutines/Continuation;", "", "", "flow", "billingFlow", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sku", "showPurchaseThanks", "(Landroid/app/Activity;Ljava/lang/String;)V", "PK", "Ljava/lang/String;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class BillingKt {
    private static final String PK;

    /* JADX INFO: renamed from: com.urbandroid.sleep.trial.BillingKt$billingFlow$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.trial.BillingKt", f = "Billing.kt", l = {924}, m = "billingFlow", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BillingKt.billingFlow(null, null, this);
        }
    }

    static {
        String str = getChar();
        String str2 = getChar();
        String str3 = getChar();
        int num = getNum();
        char specialChar = getSpecialChar();
        char specialChar2 = getSpecialChar();
        char specialChar3 = getSpecialChar();
        int num2 = getNum();
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("M", str, str2, "B", str3);
        sbM6m.append("jANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkyvasanLiE1buKoKygV9OurtT1qJWNyzXzEKoqR");
        sbM6m.append(num);
        sbM6m.append("6lip1aE9hKGLCF9JXECeWDh4RrgVJ0j0gASmqu/XqBuiNB1Mk16XL3QqTjOD9RAw8JCocdwYPYXCetdA0R3EbIGRHq4vY9Jq+0oarMhGB8bCDHr2ZsEOBEL3qFsoFcTgpBWKvc8GyalDsEL8sm0hA5njkkgbnRim7b7leLiKhnai");
        sbM6m.append(specialChar);
        sbM6m.append("ZVdoXy1yf8Tb8qVVS1E9pCOUwAXb");
        sbM6m.append(specialChar2);
        sbM6m.append("qPq2drbTTt4bPax");
        sbM6m.append(specialChar3);
        PK = zzba$$ExternalSyntheticOutline0.m(sbM6m, "7xYTTzbBCtcwzN5b5KDuOFMoxAEZFpwtNUsaSCB2lu4emW412aVszGdWcaFdfRj5gmXVmrLLjB5x", num2, "SMGci5wIDAQAB");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object billingFlow(Activity activity, Function2<? super Billing, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Billing billing;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Billing billing2 = new Billing(activity);
            try {
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(activity);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(function2);
                anonymousClass1.L$2 = billing2;
                anonymousClass1.label = 1;
                if (function2.invoke(billing2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                billing = billing2;
            } catch (Throwable th) {
                th = th;
                billing = billing2;
                throw th;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            billing = (Billing) anonymousClass1.L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                try {
                    throw th;
                } finally {
                    billing.disconnect();
                }
            }
        }
        return Unit.INSTANCE;
    }

    public static final BillingResult billingResult(int i, String str) {
        str.getClass();
        BillingResult billingResultBuild = BillingResult.newBuilder().setResponseCode(i).setDebugMessage(str).build();
        billingResultBuild.getClass();
        return billingResultBuild;
    }

    private static final String getChar() {
        return "I";
    }

    private static final int getNum() {
        return 3;
    }

    private static final char getSpecialChar() {
        return '/';
    }

    private static final boolean isOk(BillingResult billingResult) {
        return billingResult.getResponseCode() == 0;
    }

    public static final String pretty(BillingResult billingResult) {
        billingResult.getClass();
        String strPrettyCode = prettyCode(billingResult.getResponseCode());
        String debugMessage = billingResult.getDebugMessage();
        if (debugMessage == null) {
            debugMessage = "";
        }
        return FileInsert$$ExternalSyntheticOutline0.m$1(strPrettyCode, " ", debugMessage);
    }

    private static final String prettyCode(int i) {
        String str;
        switch (i) {
            case -3:
                str = "SERVICE_TIMEOUT";
                break;
            case -2:
                str = "FEATURE_NOT_SUPPORTED";
                break;
            case -1:
                str = "SERVICE_DISCONNECTED";
                break;
            case 0:
                str = "OK";
                break;
            case 1:
                str = "USER_CANCELED";
                break;
            case 2:
                str = "SERVICE_UNAVAILABLE";
                break;
            case 3:
                str = "BILLING_UNAVAILABLE";
                break;
            case 4:
                str = "ITEM_UNAVAILABLE";
                break;
            case 5:
                str = "DEVELOPER_ERROR";
                break;
            case 6:
                str = "ERROR";
                break;
            case 7:
                str = "ITEM_ALREADY_OWNED";
                break;
            case 8:
                str = "ITEM_NOT_OWNED";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        return str + "[" + i + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String prettyState(int i) {
        return (i != 0 ? i != 1 ? i != 2 ? "UNKNOWN" : "PENDING" : "PURCHASED" : "UNSPECIFIED_STATE") + "[" + i + "]";
    }

    public static final void showPurchaseThanks(Activity activity, String str) {
        activity.getClass();
        str.getClass();
        if (StringsKt.startsWith$default(str, "sleep.unlock") || StringsKt.startsWith$default(str, "sleep.cloud")) {
            activity.showDialog(53);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<SkuDetails> toDetails(List<SkuDetailsResult> list) {
        List<SkuDetails> listEmptyList;
        ArrayList arrayList = new ArrayList();
        for (SkuDetailsResult skuDetailsResult : list) {
            if (isOk(skuDetailsResult.getZza())) {
                listEmptyList = skuDetailsResult.getSkuDetailsList();
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
            } else {
                Logger.logWarning("resolveSkuDetails failure: " + pretty(skuDetailsResult.getZza()), null);
                listEmptyList = CollectionsKt.emptyList();
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, listEmptyList);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final PurchaseResult toPurchaseResult(BillingResult billingResult) {
        return new PurchaseResult(billingResult, null, 2, 0 == true ? 1 : 0);
    }
}
