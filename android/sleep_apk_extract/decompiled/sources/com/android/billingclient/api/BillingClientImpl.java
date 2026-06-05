package com.android.billingclient.api;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.billingclient.ktx.BuildConfig;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.play_billing.zzan;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzev;
import com.google.android.gms.internal.play_billing.zzfb;
import com.google.android.gms.internal.play_billing.zzfm;
import com.google.android.gms.internal.play_billing.zzfn;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzkb;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzkg;
import com.google.android.gms.internal.play_billing.zzks;
import com.google.android.gms.internal.play_billing.zzku;
import com.google.android.gms.internal.play_billing.zzlv;
import com.google.android.gms.internal.play_billing.zzlx;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Predicate;
import org.json.JSONException;
import org.mp4parser.boxes.iso14496.part12.SubSampleInformationBox;

/* JADX INFO: loaded from: classes.dex */
class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private PendingPurchasesParams zzB;
    private boolean zzC;
    private ExecutorService zzD;
    private volatile zzev zzE;
    private final Long zzF;
    private final Object zza;
    private volatile int zzb;
    private final String zzc;
    private final Handler zzd;
    private volatile zzn zze;
    private Context zzf;
    private zzch zzg;
    private volatile zzan zzh;
    private volatile zzba zzi;
    private boolean zzj;
    private boolean zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    public BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzco zzcoVar, zzch zzchVar, ExecutorService executorService) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzF = lValueOf;
        this.zzc = zzaC();
        this.zzf = context.getApplicationContext();
        zzks zzksVarZzc = zzku.zzc();
        zzksVarZzc.zzo(zzaC());
        zzksVarZzc.zzn(this.zzf.getPackageName());
        zzksVarZzc.zzm(lValueOf.longValue());
        this.zzg = new zzcl(this.zzf, (zzku) zzksVarZzc.zzf());
        zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zze = new zzn(this.zzf, null, null, null, null, this.zzg);
        this.zzB = pendingPurchasesParams;
        this.zzf.getPackageName();
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, zzb zzbVar, String str, zzch zzchVar) {
        this.zzf = context.getApplicationContext();
        zzks zzksVarZzc = zzku.zzc();
        zzksVarZzc.zzo(str);
        zzksVarZzc.zzn(this.zzf.getPackageName());
        zzksVarZzc.zzm(this.zzF.longValue());
        if (zzchVar != null) {
            this.zzg = zzchVar;
        } else {
            this.zzg = new zzcl(this.zzf, (zzku) zzksVarZzc.zzf());
        }
        if (purchasesUpdatedListener == null) {
            zze.zzl("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zze = new zzn(this.zzf, purchasesUpdatedListener, null, zzbVar, null, this.zzg);
        this.zzB = pendingPurchasesParams;
        this.zzC = zzbVar != null;
        this.zzf.getPackageName();
    }

    public static Future zzE(Callable callable, long j, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzaf
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    zze.zzl("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            zze.zzm("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzaA() {
        int[] iArr = {0, 3};
        synchronized (this.zza) {
            for (int i = 0; i < 2; i++) {
                if (this.zzb == iArr[i]) {
                    return zzcj.zzm;
                }
            }
            return zzcj.zzk;
        }
    }

    private static String zzaC() {
        try {
            return (String) BuildConfig.class.getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return "7.1.1";
        }
    }

    private final synchronized ExecutorService zzaD() {
        try {
            if (this.zzD == null) {
                this.zzD = Executors.newFixedThreadPool(zze.zza, new zzas(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzD;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.android.billingclient.api.BillingClientImpl] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.android.billingclient.api.BillingClientImpl] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.StringBuilder] */
    private final void zzaE(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Throwable {
        ?? sb;
        zzan zzanVar;
        int iZza;
        String strZzh;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            sb = new StringBuilder("Consuming purchase with token: ");
            sb.append(purchaseToken);
            zze.zzk("BillingClient", sb.toString());
            synchronized (this.zza) {
                try {
                    try {
                        zzanVar = this.zzh;
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                } catch (DeadObjectException e) {
                    e = e;
                } catch (Exception e2) {
                    e = e2;
                    sb.zzaW(consumeResponseListener, purchaseToken, zzcj.zzk, 29, "Error consuming purchase!", e);
                    return;
                }
            }
            if (zzanVar == null) {
                zzaW(consumeResponseListener, purchaseToken, zzcj.zzm, 119, "Service has been reset to null.", null);
                return;
            }
            boolean z = this.zzo;
            Context context = this.zzf;
            if (z) {
                String packageName = context.getPackageName();
                boolean z2 = this.zzo;
                String str = this.zzc;
                long jLongValue = this.zzF.longValue();
                Bundle bundle = new Bundle();
                if (z2) {
                    zze.zzc(bundle, str, jLongValue);
                }
                Bundle bundleZze = zzanVar.zze(9, packageName, purchaseToken, bundle);
                iZza = bundleZze.getInt("RESPONSE_CODE");
                strZzh = zze.zzh(bundleZze, "BillingClient");
            } else {
                iZza = zzanVar.zza(3, context.getPackageName(), purchaseToken);
                strZzh = "";
            }
            BillingResult billingResultZza = zzcj.zza(iZza, strZzh);
            if (iZza == 0) {
                zze.zzk("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.onConsumeResponse(billingResultZza, purchaseToken);
                return;
            } else {
                zzaW(consumeResponseListener, purchaseToken, billingResultZza, 23, "Error consuming purchase with token. Response code: " + iZza, null);
                return;
            }
        } catch (DeadObjectException e3) {
            e = e3;
            sb = this;
        } catch (Exception e4) {
            e = e4;
            sb = this;
        }
        sb.zzaW(consumeResponseListener, purchaseToken, zzcj.zzm, 29, "Error consuming purchase!", e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaF(zzjz zzjzVar) {
        try {
            this.zzg.zzb(zzjzVar, this.zzl);
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzaG(zzkd zzkdVar) {
        try {
            this.zzg.zzd(zzkdVar, this.zzl);
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzaH(String str, final PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            BillingResult billingResult = zzcj.zzm;
            zzbe(2, 11, billingResult);
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(billingResult, null);
        } else if (zzE(new zzau(this, str, purchaseHistoryResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzal
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzak(purchaseHistoryResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 11, billingResultZzaA);
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(billingResultZzaA, null);
        }
    }

    private final void zzaI(String str, final PurchasesResponseListener purchasesResponseListener) {
        if (!isReady()) {
            BillingResult billingResult = zzcj.zzm;
            zzbe(2, 9, billingResult);
            purchasesResponseListener.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzco.zzl());
        } else {
            if (TextUtils.isEmpty(str)) {
                zze.zzl("BillingClient", "Please provide a valid product type.");
                BillingResult billingResult2 = zzcj.zzh;
                zzbe(50, 9, billingResult2);
                purchasesResponseListener.onQueryPurchasesResponse(billingResult2, com.google.android.gms.internal.play_billing.zzco.zzl());
                return;
            }
            if (zzE(new zzat(this, str, purchasesResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzac
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzal(purchasesResponseListener);
                }
            }, zzax(), zzaD()) == null) {
                BillingResult billingResultZzaA = zzaA();
                zzbe(25, 9, billingResultZzaA);
                purchasesResponseListener.onQueryPurchasesResponse(billingResultZzaA, com.google.android.gms.internal.play_billing.zzco.zzl());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaJ(int i) {
        synchronized (this.zza) {
            try {
                if (this.zzb == 3) {
                    return;
                }
                zze.zzk("BillingClient", "Setting clientState from " + zzaN(this.zzb) + " to " + zzaN(i));
                this.zzb = i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final synchronized void zzaK() {
        ExecutorService executorService = this.zzD;
        if (executorService != null) {
            executorService.shutdownNow();
            this.zzD = null;
            this.zzE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zzaL() {
        synchronized (this.zza) {
            if (this.zzi != null) {
                try {
                    this.zzf.unbindService(this.zzi);
                } catch (Throwable th) {
                    try {
                        zze.zzm("BillingClient", "There was an exception while unbinding service!", th);
                        this.zzh = null;
                        this.zzi = null;
                    } finally {
                        this.zzh = null;
                        this.zzi = null;
                    }
                }
            }
        }
    }

    private final boolean zzaM() {
        return this.zzw && this.zzB.isEnabledForPrepaidPlans();
    }

    private static final String zzaN(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "CLOSED" : "CONNECTED" : "CONNECTING" : "DISCONNECTED";
    }

    private final zzbk zzaP(BillingResult billingResult, int i, String str, Exception exc) {
        zze.zzm("BillingClient", str, exc);
        zzbf(i, 11, billingResult, zzcg.zza(exc));
        return new zzbk(billingResult, null);
    }

    private final zzcv zzaQ(int i, BillingResult billingResult, int i2, String str, Exception exc) {
        zzbf(i2, 9, billingResult, zzcg.zza(exc));
        zze.zzm("BillingClient", str, exc);
        return new zzcv(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzcv zzaR(String str, int i) {
        zzan zzanVar;
        BillingClientImpl billingClientImpl = this;
        zze.zzk("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle bundleZzd = zze.zzd(billingClientImpl.zzo, billingClientImpl.zzw, billingClientImpl.zzB.isEnabledForOneTimeProducts(), billingClientImpl.zzB.isEnabledForPrepaidPlans(), billingClientImpl.zzc, billingClientImpl.zzF.longValue());
        String string = null;
        do {
            try {
                synchronized (billingClientImpl.zza) {
                    zzanVar = billingClientImpl.zzh;
                }
                if (zzanVar == null) {
                    return billingClientImpl.zzaQ(9, zzcj.zzm, 119, "Service has been reset to null", null);
                }
                Bundle bundleZzj = billingClientImpl.zzo ? zzanVar.zzj(true != billingClientImpl.zzw ? 9 : 19, billingClientImpl.zzf.getPackageName(), str, string, bundleZzd) : zzanVar.zzi(3, billingClientImpl.zzf.getPackageName(), str, string);
                zzcx zzcxVarZza = zzcy.zza(bundleZzj, "BillingClient", "getPurchase()");
                BillingResult billingResultZza = zzcxVarZza.zza();
                if (billingResultZza != zzcj.zzl) {
                    return billingClientImpl.zzaQ(9, billingResultZza, zzcxVarZza.zzb(), "Purchase bundle invalid", null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzj.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z = false;
                for (int i2 = 0; i2 < stringArrayList2.size(); i2++) {
                    String str2 = stringArrayList2.get(i2);
                    String str3 = stringArrayList3.get(i2);
                    zze.zzk("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i2))));
                    try {
                        Purchase purchase = new Purchase(str2, str3);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            zze.zzl("BillingClient", "BUG: empty/null token!");
                            z = true;
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e) {
                        return zzaQ(9, zzcj.zzk, 51, "Got an exception trying to decode the purchase!", e);
                    }
                }
                billingClientImpl = this;
                if (z) {
                    billingClientImpl.zzbe(26, 9, zzcj.zzk);
                }
                string = bundleZzj.getString("INAPP_CONTINUATION_TOKEN");
                zze.zzk("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
            } catch (DeadObjectException e2) {
                return zzaQ(9, zzcj.zzm, 52, "Got exception trying to get purchases try to reconnect", e2);
            } catch (Exception e3) {
                return billingClientImpl.zzaQ(9, zzcj.zzk, 52, "Got exception trying to get purchases try to reconnect", e3);
            }
        } while (!TextUtils.isEmpty(string));
        return new zzcv(zzcj.zzl, arrayList);
    }

    private final zzdc zzaS(BillingResult billingResult, int i, String str, Exception exc) {
        zze.zzm("BillingClient", str, exc);
        zzbf(i, 8, billingResult, zzcg.zza(exc));
        return new zzdc(billingResult.getResponseCode(), billingResult.getDebugMessage(), null);
    }

    private final void zzaU(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, BillingResult billingResult, int i, Exception exc) {
        zze.zzm("BillingClient", "Error in acknowledge purchase!", exc);
        zzbf(i, 3, billingResult, zzcg.zza(exc));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    private final void zzaW(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, int i, String str2, Exception exc) {
        zze.zzm("BillingClient", str2, exc);
        zzbf(i, 4, billingResult, zzcg.zza(exc));
        consumeResponseListener.onConsumeResponse(billingResult, str);
    }

    public static /* bridge */ /* synthetic */ boolean zzaq(BillingClientImpl billingClientImpl) {
        boolean z;
        synchronized (billingClientImpl.zza) {
            z = true;
            if (billingClientImpl.zzb != 1) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzax() {
        return Looper.myLooper() == null ? this.zzd : new Handler(Looper.myLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzbk zzay(String str) {
        zzan zzanVar;
        zze.zzk("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle bundleZzd = zze.zzd(this.zzo, this.zzw, this.zzB.isEnabledForOneTimeProducts(), this.zzB.isEnabledForPrepaidPlans(), this.zzc, this.zzF.longValue());
        String string = null;
        while (this.zzm) {
            try {
                synchronized (this.zza) {
                    zzanVar = this.zzh;
                }
                if (zzanVar == null) {
                    return zzaP(zzcj.zzm, 119, "Service reset to null", null);
                }
                Bundle bundleZzh = zzanVar.zzh(6, this.zzf.getPackageName(), str, string, bundleZzd);
                zzcx zzcxVarZza = zzcy.zza(bundleZzh, "BillingClient", "getPurchaseHistory()");
                BillingResult billingResultZza = zzcxVarZza.zza();
                if (billingResultZza != zzcj.zzl) {
                    zzbe(zzcxVarZza.zzb(), 11, billingResultZza);
                    return new zzbk(billingResultZza, null);
                }
                ArrayList<String> stringArrayList = bundleZzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                boolean z = false;
                for (int i = 0; i < stringArrayList2.size(); i++) {
                    String str2 = stringArrayList2.get(i);
                    String str3 = stringArrayList3.get(i);
                    zze.zzk("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i))));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str2, str3);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            zze.zzl("BillingClient", "BUG: empty/null token!");
                            z = true;
                        }
                        arrayList.add(purchaseHistoryRecord);
                    } catch (JSONException e) {
                        return zzaP(zzcj.zzk, 51, "Got an exception trying to decode the purchase!", e);
                    }
                }
                if (z) {
                    zzbe(26, 11, zzcj.zzk);
                }
                string = bundleZzh.getString("INAPP_CONTINUATION_TOKEN");
                zze.zzk("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    return new zzbk(zzcj.zzl, arrayList);
                }
            } catch (DeadObjectException e2) {
                return zzaP(zzcj.zzm, 59, "Got exception trying to get purchase history", e2);
            } catch (Exception e3) {
                return zzaP(zzcj.zzk, 59, "Got exception trying to get purchase history", e3);
            }
        }
        zze.zzl("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzbk(zzcj.zzq, null);
    }

    private final BillingResult zzaz() {
        zze.zzk("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzkb zzkbVarZzc = zzkd.zzc();
        zzkbVarZzc.zzn(6);
        zzlv zzlvVarZzc = zzlx.zzc();
        zzlvVarZzc.zza(true);
        zzkbVarZzc.zzm(zzlvVarZzc);
        zzaG((zzkd) zzkbVarZzc.zzf());
        return zzcj.zzl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzba(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 25, billingResult, zzcg.zza(exc));
        externalOfferInformationDialogListener.onExternalOfferInformationDialogResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbc(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, BillingResult billingResult, int i, Exception exc) {
        zzbf(i, 16, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbe(int i, int i2, BillingResult billingResult) {
        try {
            zzaF(zzcg.zzb(i, i2, billingResult));
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbf(int i, int i2, BillingResult billingResult, String str) {
        try {
            zzaF(zzcg.zzc(i, i2, billingResult, str));
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbg(int i) {
        try {
            zzaG(zzcg.zzd(i));
        } catch (Throwable th) {
            zze.zzm("BillingClient", "Unable to log.", th);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            BillingResult billingResult = zzcj.zzm;
            zzbe(2, 3, billingResult);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
            return;
        }
        if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            zze.zzl("BillingClient", "Please provide a valid purchase token.");
            BillingResult billingResult2 = zzcj.zzj;
            zzbe(26, 3, billingResult2);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult2);
            return;
        }
        if (!this.zzo) {
            BillingResult billingResult3 = zzcj.zzb;
            zzbe(27, 3, billingResult3);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult3);
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzt
            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.zza.zzs(acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzab(acknowledgePurchaseResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 3, billingResultZzaA);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResultZzaA);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            BillingResult billingResult = zzcj.zzm;
            zzbe(2, 4, billingResult);
            consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
        } else if (zzE(new Callable() { // from class: com.android.billingclient.api.zzag
            @Override // java.util.concurrent.Callable
            public final Object call() throws Throwable {
                this.zza.zzt(consumeParams, consumeResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzah
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzad(consumeResponseListener, consumeParams);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 4, billingResultZzaA);
            consumeResponseListener.onConsumeResponse(billingResultZzaA, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        zzbg(12);
        synchronized (this.zza) {
            try {
            } finally {
            }
            if (this.zze != null) {
                this.zze.zzf();
                try {
                    zze.zzk("BillingClient", "Unbinding from service.");
                    zzaL();
                } catch (Throwable th) {
                    zze.zzm("BillingClient", "There was an exception while unbinding from the service while ending connection!", th);
                }
                try {
                    zzaK();
                } finally {
                    try {
                    } finally {
                    }
                }
            } else {
                zze.zzk("BillingClient", "Unbinding from service.");
                zzaL();
                zzaK();
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        boolean z;
        synchronized (this.zza) {
            try {
                z = false;
                if (this.zzb == 2 && this.zzh != null && this.zzi != null) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult launchBillingFlow(Activity activity, final BillingFlowParams billingFlowParams) {
        String str;
        String str2;
        Future futureZzE;
        int iZza;
        String string;
        int i;
        String str3;
        boolean z;
        String str4;
        List list;
        String str5;
        boolean z2;
        String str6;
        int i2;
        final int i3;
        List list2;
        String str7 = "proxyPackageVersion";
        if (this.zze == null || this.zze.zzd() == null) {
            BillingResult billingResult = zzcj.zzF;
            zzbe(12, 2, billingResult);
            return billingResult;
        }
        if (!isReady()) {
            BillingResult billingResult2 = zzcj.zzm;
            zzbe(2, 2, billingResult2);
            zzm(billingResult2);
            return billingResult2;
        }
        ArrayList<SkuDetails> arrayListZzg = billingFlowParams.zzg();
        List listZzh = billingFlowParams.zzh();
        SkuDetails skuDetails = (SkuDetails) com.google.android.gms.internal.play_billing.zzcx.zza(arrayListZzg, null);
        if (com.google.android.gms.internal.play_billing.zzcx.zza(listZzh, null) != null) {
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        skuDetails.getClass();
        List list3 = listZzh;
        final String sku = skuDetails.getSku();
        final String type = skuDetails.getType();
        String str8 = "BillingClient";
        if (type.equals(SubSampleInformationBox.TYPE) && !this.zzj) {
            zze.zzl("BillingClient", "Current client doesn't support subscriptions.");
            BillingResult billingResult3 = zzcj.zzo;
            zzbe(9, 2, billingResult3);
            zzm(billingResult3);
            return billingResult3;
        }
        if (billingFlowParams.zzq() && !this.zzm) {
            zze.zzl("BillingClient", "Current client doesn't support extra params for buy intent.");
            BillingResult billingResult4 = zzcj.zzi;
            zzbe(18, 2, billingResult4);
            zzm(billingResult4);
            return billingResult4;
        }
        if (arrayListZzg.size() > 1 && !this.zzt) {
            zze.zzl("BillingClient", "Current client doesn't support multi-item purchases.");
            BillingResult billingResult5 = zzcj.zzt;
            zzbe(19, 2, billingResult5);
            zzm(billingResult5);
            return billingResult5;
        }
        if (!list3.isEmpty() && !this.zzu) {
            zze.zzl("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            BillingResult billingResult6 = zzcj.zzv;
            zzbe(20, 2, billingResult6);
            zzm(billingResult6);
            return billingResult6;
        }
        BillingResult billingResultZzb = billingFlowParams.zzb();
        if (billingResultZzb != zzcj.zzl) {
            zzbe(120, 2, billingResultZzb);
            zzm(billingResultZzb);
            return billingResultZzb;
        }
        if (this.zzm) {
            boolean z3 = this.zzo;
            boolean z4 = this.zzw;
            boolean zIsEnabledForOneTimeProducts = this.zzB.isEnabledForOneTimeProducts();
            boolean zIsEnabledForPrepaidPlans = this.zzB.isEnabledForPrepaidPlans();
            boolean z5 = this.zzC;
            String str9 = this.zzc;
            long jLongValue = this.zzF.longValue();
            final String packageName = this.zzf.getPackageName();
            final Bundle bundle = new Bundle();
            zze.zzc(bundle, str9, jLongValue);
            if (billingFlowParams.zza() != 0) {
                bundle.putInt("prorationMode", billingFlowParams.zza());
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzc())) {
                bundle.putString("accountId", billingFlowParams.zzc());
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzd())) {
                bundle.putString("obfuscatedProfileId", billingFlowParams.zzd());
            }
            if (billingFlowParams.zzp()) {
                bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
            }
            if (!TextUtils.isEmpty(billingFlowParams.zze())) {
                bundle.putString("oldSkuPurchaseToken", billingFlowParams.zze());
            }
            if (TextUtils.isEmpty(null)) {
                str3 = null;
            } else {
                str3 = null;
                bundle.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzf())) {
                bundle.putString("originalExternalTransactionId", billingFlowParams.zzf());
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("paymentsPurchaseParams", str3);
            }
            if (z3 && zIsEnabledForOneTimeProducts) {
                z = true;
                bundle.putBoolean(InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, true);
            } else {
                z = true;
            }
            if (z4 && zIsEnabledForPrepaidPlans) {
                bundle.putBoolean("enablePendingPurchaseForSubscriptions", z);
            }
            if (z5) {
                bundle.putBoolean("enableAlternativeBilling", z);
            }
            if (billingFlowParams.zzh().stream().anyMatch(new Predicate() { // from class: com.google.android.gms.internal.play_billing.zza
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    if (obj == null) {
                        int i4 = zze.zza;
                        return false;
                    }
                    Events$$ExternalSyntheticBUOutline0.m();
                    return false;
                }
            })) {
                zzfm zzfmVarZza = zzfn.zza();
                zzfmVarZza.zza((Iterable) billingFlowParams.zzh().stream().filter(new Predicate() { // from class: com.google.android.gms.internal.play_billing.zzb
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        if (obj == null) {
                            int i4 = zze.zza;
                            return false;
                        }
                        Events$$ExternalSyntheticBUOutline0.m();
                        return false;
                    }
                }).map(new Function() { // from class: com.google.android.gms.internal.play_billing.zzc
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        if (obj != null) {
                            throw new ClassCastException();
                        }
                        int i4 = zze.zza;
                        throw null;
                    }
                }).collect(com.google.android.gms.internal.play_billing.zzco.zzo()));
                bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzfn) zzfmVarZza.zzf()).zzh());
            }
            if (arrayListZzg.isEmpty()) {
                str4 = "proxyPackageVersion";
                list = list3;
                str = "BUY_INTENT";
                str5 = "BillingClient";
                ArrayList<String> arrayList = new ArrayList<>(list.size() - 1);
                ArrayList<String> arrayList2 = new ArrayList<>(list.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<Integer> arrayList6 = new ArrayList<>();
                if (list.size() > 0) {
                    list.get(0).getClass();
                    Events$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                bundle.putIntegerArrayList("AUTO_PAY_BALANCE_THRESHOLD_LIST", arrayList6);
                if (!arrayList3.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList3);
                }
                if (!arrayList5.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (!arrayList.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList2);
                }
            } else {
                ArrayList<String> arrayList7 = new ArrayList<>();
                ArrayList<String> arrayList8 = new ArrayList<>();
                ArrayList<String> arrayList9 = new ArrayList<>();
                str = "BUY_INTENT";
                ArrayList<Integer> arrayList10 = new ArrayList<>();
                ArrayList<String> arrayList11 = new ArrayList<>();
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                boolean z9 = false;
                for (SkuDetails skuDetails2 : arrayListZzg) {
                    if (skuDetails2.zzf().isEmpty()) {
                        list2 = list3;
                    } else {
                        list2 = list3;
                        arrayList7.add(skuDetails2.zzf());
                    }
                    String strZzc = skuDetails2.zzc();
                    String str10 = str7;
                    String strZzb = skuDetails2.zzb();
                    int iZza2 = skuDetails2.zza();
                    String str11 = str8;
                    String strZze = skuDetails2.zze();
                    arrayList8.add(strZzc);
                    z6 |= !TextUtils.isEmpty(strZzc);
                    arrayList9.add(strZzb);
                    z7 |= !TextUtils.isEmpty(strZzb);
                    arrayList10.add(Integer.valueOf(iZza2));
                    z8 |= iZza2 != 0;
                    z9 |= !TextUtils.isEmpty(strZze);
                    arrayList11.add(strZze);
                    list3 = list2;
                    str7 = str10;
                    str8 = str11;
                }
                str4 = str7;
                list = list3;
                str5 = str8;
                if (!arrayList7.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList7);
                }
                if (z6) {
                    bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList8);
                }
                if (z7) {
                    bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList9);
                }
                if (z8) {
                    bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList10);
                }
                if (z9) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList11);
                }
                if (arrayListZzg.size() > 1) {
                    ArrayList<String> arrayList12 = new ArrayList<>(arrayListZzg.size() - 1);
                    ArrayList<String> arrayList13 = new ArrayList<>(arrayListZzg.size() - 1);
                    for (int i4 = 1; i4 < arrayListZzg.size(); i4++) {
                        arrayList12.add(((SkuDetails) arrayListZzg.get(i4)).getSku());
                        arrayList13.add(((SkuDetails) arrayListZzg.get(i4)).getType());
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList12);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList13);
                }
            }
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.zzr) {
                BillingResult billingResult7 = zzcj.zzu;
                zzbe(21, 2, billingResult7);
                zzm(billingResult7);
                return billingResult7;
            }
            if (TextUtils.isEmpty(skuDetails.zzd())) {
                z2 = false;
            } else {
                bundle.putString("skuPackageName", skuDetails.zzd());
                z2 = true;
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("accountName", null);
            }
            Intent intent = activity.getIntent();
            if (intent == null) {
                str2 = str5;
                zze.zzl(str2, "Activity's intent is null.");
            } else {
                str2 = str5;
                if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                    bundle.putString("proxyPackage", stringExtra);
                    try {
                        str6 = str4;
                        try {
                            bundle.putString(str6, this.zzf.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                        } catch (PackageManager.NameNotFoundException unused) {
                            bundle.putString(str6, "package not found");
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str6 = str4;
                    }
                }
            }
            if (this.zzu && !list.isEmpty()) {
                i2 = 17;
            } else if (this.zzs && z2) {
                i2 = 15;
            } else if (this.zzo) {
                i3 = 9;
                futureZzE = zzE(new Callable() { // from class: com.android.billingclient.api.zzar
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzd(i3, sku, type, billingFlowParams, bundle);
                    }
                }, 5000L, null, this.zzd, zzaD());
            } else {
                i2 = 6;
            }
            i3 = i2;
            futureZzE = zzE(new Callable() { // from class: com.android.billingclient.api.zzar
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzd(i3, sku, type, billingFlowParams, bundle);
                }
            }, 5000L, null, this.zzd, zzaD());
        } else {
            str = "BUY_INTENT";
            str2 = "BillingClient";
            futureZzE = zzE(new Callable() { // from class: com.android.billingclient.api.zzq
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zze(sku, type);
                }
            }, 5000L, null, this.zzd, zzaD());
        }
        try {
            if (futureZzE == null) {
                BillingResult billingResult8 = zzcj.zzd;
                zzbe(25, 2, billingResult8);
                zzm(billingResult8);
                return billingResult8;
            }
            Bundle bundle2 = (Bundle) futureZzE.get(5000L, TimeUnit.MILLISECONDS);
            int iZzb = zze.zzb(bundle2, str2);
            String strZzh = zze.zzh(bundle2, str2);
            if (iZzb == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                String str12 = str;
                intent2.putExtra(str12, (PendingIntent) bundle2.getParcelable(str12));
                activity.startActivity(intent2);
                return zzcj.zzl;
            }
            zze.zzl(str2, "Unable to buy item, Error response code: " + iZzb);
            BillingResult billingResultZza = zzcj.zza(iZzb, strZzh);
            if (bundle2 == null) {
                iZza = 1;
            } else {
                try {
                    Object obj = bundle2.get("LOG_REASON");
                    if (obj != null) {
                        if (obj instanceof Integer) {
                            iZza = zzkg.zza(((Integer) obj).intValue());
                        } else {
                            zze.zzl(str2, "Unexpected type for bundle log reason: " + obj.getClass().getName());
                        }
                    }
                } catch (Throwable th) {
                    zze.zzl(str2, "Failed to get log reason from bundle: ".concat(String.valueOf(th.getMessage())));
                }
                iZza = 1;
            }
            if (iZza == 1) {
                iZza = 23;
            }
            if (bundle2 == null) {
                i = 2;
                string = null;
            } else {
                try {
                    string = bundle2.getString("ADDITIONAL_LOG_DETAILS");
                    i = 2;
                } catch (Throwable th2) {
                    zze.zzl(str2, "Failed to get additional log details from bundle: ".concat(String.valueOf(th2.getMessage())));
                    i = 2;
                    string = null;
                }
            }
            zzbf(iZza, i, billingResultZza, string);
            zzm(billingResultZza);
            return billingResultZza;
        } catch (CancellationException e) {
            e = e;
            zze.zzm(str2, "Time out while launching billing flow. Try to reconnect", e);
            BillingResult billingResult9 = zzcj.zzn;
            zzbf(4, 2, billingResult9, zzcg.zza(e));
            zzm(billingResult9);
            return billingResult9;
        } catch (TimeoutException e2) {
            e = e2;
            zze.zzm(str2, "Time out while launching billing flow. Try to reconnect", e);
            BillingResult billingResult92 = zzcj.zzn;
            zzbf(4, 2, billingResult92, zzcg.zza(e));
            zzm(billingResult92);
            return billingResult92;
        } catch (Exception e3) {
            zze.zzm(str2, "Exception while launching billing flow. Try to reconnect", e3);
            BillingResult billingResult10 = zzcj.zzm;
            zzbf(5, 2, billingResult10, zzcg.zza(e3));
            zzm(billingResult10);
            return billingResult10;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzaH(queryPurchaseHistoryParams.zza(), purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        zzaI(queryPurchasesParams.zza(), purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            BillingResult billingResult = zzcj.zzm;
            zzbe(2, 8, billingResult);
            skuDetailsResponseListener.onSkuDetailsResponse(billingResult, null);
            return;
        }
        final String skuType = skuDetailsParams.getSkuType();
        final List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            zze.zzl("BillingClient", "Please fix the input params. SKU type can't be empty.");
            BillingResult billingResult2 = zzcj.zzg;
            zzbe(49, 8, billingResult2);
            skuDetailsResponseListener.onSkuDetailsResponse(billingResult2, null);
            return;
        }
        if (skusList == null) {
            zze.zzl("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            BillingResult billingResult3 = zzcj.zzf;
            zzbe(48, 8, billingResult3);
            skuDetailsResponseListener.onSkuDetailsResponse(billingResult3, null);
            return;
        }
        final String str = null;
        if (zzE(new Callable(skuType, skusList, str, skuDetailsResponseListener) { // from class: com.android.billingclient.api.zzz
            public final /* synthetic */ String zzb;
            public final /* synthetic */ List zzc;
            public final /* synthetic */ SkuDetailsResponseListener zzd;

            {
                this.zzd = skuDetailsResponseListener;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdc zzdcVarZzn = this.zza.zzn(this.zzb, this.zzc, null);
                this.zzd.onSkuDetailsResponse(zzcj.zza(zzdcVarZzn.zza(), zzdcVarZzn.zzb()), zzdcVarZzn.zzc());
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzab
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzam(skuDetailsResponseListener);
            }
        }, zzax(), zzaD()) == null) {
            BillingResult billingResultZzaA = zzaA();
            zzbe(25, 8, billingResultZzaA);
            skuDetailsResponseListener.onSkuDetailsResponse(billingResultZzaA, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(BillingClientStateListener billingClientStateListener) {
        BillingResult billingResultZzaz;
        BillingResult billingResult;
        synchronized (this.zza) {
            try {
                if (isReady()) {
                    billingResultZzaz = zzaz();
                } else {
                    if (this.zzb == 1) {
                        zze.zzl("BillingClient", "Client is already in the process of connecting to billing service.");
                        billingResult = zzcj.zze;
                        zzbe(37, 6, billingResult);
                    } else if (this.zzb == 3) {
                        zze.zzl("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                        billingResult = zzcj.zzm;
                        zzbe(38, 6, billingResult);
                    } else {
                        zzaJ(1);
                        zzaL();
                        zze.zzk("BillingClient", "Starting in-app billing setup.");
                        this.zzi = new zzba(this, billingClientStateListener, null);
                        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                        intent.setPackage("com.android.vending");
                        List<ResolveInfo> listQueryIntentServices = this.zzf.getPackageManager().queryIntentServices(intent, 0);
                        int i = 41;
                        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                            zzaJ(0);
                            zze.zzk("BillingClient", "Billing service unavailable on device.");
                            BillingResult billingResult2 = zzcj.zzc;
                            zzbe(i, 6, billingResult2);
                            billingResultZzaz = billingResult2;
                        } else {
                            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                            i = 40;
                            if (serviceInfo != null) {
                                String str = serviceInfo.packageName;
                                String str2 = serviceInfo.name;
                                if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                    zze.zzl("BillingClient", "The device doesn't have valid Play Store.");
                                } else {
                                    ComponentName componentName = new ComponentName(str, str2);
                                    Intent intent2 = new Intent(intent);
                                    intent2.setComponent(componentName);
                                    intent2.putExtra("playBillingLibraryVersion", this.zzc);
                                    synchronized (this.zza) {
                                        try {
                                            if (this.zzb == 2) {
                                                billingResultZzaz = zzaz();
                                            } else if (this.zzb != 1) {
                                                zze.zzl("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                                billingResult = zzcj.zzm;
                                                zzbe(117, 6, billingResult);
                                            } else {
                                                zzba zzbaVar = this.zzi;
                                                if (this.zzf.bindService(intent2, zzbaVar, 1)) {
                                                    zze.zzk("BillingClient", "Service was bonded successfully.");
                                                    billingResultZzaz = null;
                                                } else {
                                                    zze.zzl("BillingClient", "Connection to Billing service is blocked.");
                                                    i = 39;
                                                }
                                            }
                                        } finally {
                                        }
                                    }
                                }
                            } else {
                                zze.zzl("BillingClient", "The device doesn't have valid Play Store.");
                            }
                            zzaJ(0);
                            zze.zzk("BillingClient", "Billing service unavailable on device.");
                            BillingResult billingResult22 = zzcj.zzc;
                            zzbe(i, 6, billingResult22);
                            billingResultZzaz = billingResult22;
                        }
                    }
                    billingResultZzaz = billingResult;
                }
            } finally {
            }
        }
        if (billingResultZzaz != null) {
            billingClientStateListener.onBillingSetupFinished(billingResultZzaz);
        }
    }

    public final /* synthetic */ void zzab(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        BillingResult billingResult = zzcj.zzn;
        zzbe(24, 3, billingResult);
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    public final /* synthetic */ void zzac(BillingResult billingResult) {
        PurchasesUpdatedListener purchasesUpdatedListenerZzd = this.zze.zzd();
        zzn zznVar = this.zze;
        if (purchasesUpdatedListenerZzd != null) {
            zznVar.zzd().onPurchasesUpdated(billingResult, null);
        } else {
            zze.zzl("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    public final /* synthetic */ void zzad(ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        BillingResult billingResult = zzcj.zzn;
        zzbe(24, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
    }

    public final /* synthetic */ void zzak(PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        BillingResult billingResult = zzcj.zzn;
        zzbe(24, 11, billingResult);
        purchaseHistoryResponseListener.onPurchaseHistoryResponse(billingResult, null);
    }

    public final /* synthetic */ void zzal(PurchasesResponseListener purchasesResponseListener) {
        BillingResult billingResult = zzcj.zzn;
        zzbe(24, 9, billingResult);
        purchasesResponseListener.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzco.zzl());
    }

    public final /* synthetic */ void zzam(SkuDetailsResponseListener skuDetailsResponseListener) {
        BillingResult billingResult = zzcj.zzn;
        zzbe(24, 8, billingResult);
        skuDetailsResponseListener.onSkuDetailsResponse(billingResult, null);
    }

    public final /* synthetic */ Bundle zzd(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) {
        zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            return zzanVar == null ? zze.zzn(zzcj.zzm, 119) : zzanVar.zzg(i, this.zzf.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e) {
            return zze.zzo(zzcj.zzm, 5, zzcg.zza(e));
        } catch (Exception e2) {
            return zze.zzo(zzcj.zzk, 5, zzcg.zza(e2));
        }
    }

    public final /* synthetic */ Bundle zze(String str, String str2) {
        zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            return zzanVar == null ? zze.zzn(zzcj.zzm, 119) : zzanVar.zzf(3, this.zzf.getPackageName(), str, str2, null);
        } catch (DeadObjectException e) {
            return zze.zzo(zzcj.zzm, 5, zzcg.zza(e));
        } catch (Exception e2) {
            return zze.zzo(zzcj.zzk, 5, zzcg.zza(e2));
        }
    }

    public final zzch zzk() {
        return this.zzg;
    }

    public final BillingResult zzm(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zzd.post(new Runnable() { // from class: com.android.billingclient.api.zzp
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzac(billingResult);
            }
        });
        return billingResult;
    }

    public final zzdc zzn(String str, List list, String str2) {
        zzan zzanVar;
        Bundle bundleZzk;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i, i2 > size ? size : i2));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle.putString("playBillingLibraryVersion", this.zzc);
            try {
                synchronized (this.zza) {
                    zzanVar = this.zzh;
                }
                if (zzanVar == null) {
                    return zzaS(zzcj.zzm, 119, "Service has been reset to null.", null);
                }
                boolean z = this.zzp;
                Context context = this.zzf;
                if (z) {
                    String packageName = context.getPackageName();
                    int i3 = this.zzl;
                    boolean zIsEnabledForOneTimeProducts = this.zzB.isEnabledForOneTimeProducts();
                    boolean zZzaM = zzaM();
                    String str3 = this.zzc;
                    long jLongValue = this.zzF.longValue();
                    Bundle bundle2 = new Bundle();
                    if (i3 >= 9) {
                        zze.zzc(bundle2, str3, jLongValue);
                    }
                    if (i3 >= 9 && zIsEnabledForOneTimeProducts) {
                        bundle2.putBoolean(InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, true);
                    }
                    if (zZzaM) {
                        bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                    }
                    bundleZzk = zzanVar.zzl(10, packageName, str, bundle, bundle2);
                } else {
                    bundleZzk = zzanVar.zzk(3, context.getPackageName(), str, bundle);
                }
                if (bundleZzk == null) {
                    return zzaS(zzcj.zzC, 44, "querySkuDetailsAsync got null sku details list", null);
                }
                if (!bundleZzk.containsKey("DETAILS_LIST")) {
                    int iZzb = zze.zzb(bundleZzk, "BillingClient");
                    String strZzh = zze.zzh(bundleZzk, "BillingClient");
                    return iZzb != 0 ? zzaS(zzcj.zza(iZzb, strZzh), 23, FileInsert$$ExternalSyntheticOutline0.m(iZzb, "getSkuDetails() failed. Response code: "), null) : zzaS(zzcj.zza(6, strZzh), 45, "getSkuDetails() returned a bundle with neither an error nor a detail list.", null);
                }
                ArrayList<String> stringArrayList = bundleZzk.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return zzaS(zzcj.zzC, 46, "querySkuDetailsAsync got null response list", null);
                }
                for (int i4 = 0; i4 < stringArrayList.size(); i4++) {
                    try {
                        SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i4));
                        zze.zzk("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                        arrayList.add(skuDetails);
                    } catch (JSONException e) {
                        return zzaS(zzcj.zza(6, "Error trying to decode SkuDetails."), 47, "Got a JSON exception trying to decode SkuDetails.", e);
                    }
                }
                i = i2;
            } catch (DeadObjectException e2) {
                return zzaS(zzcj.zzm, 43, "querySkuDetailsAsync got a remote exception (try to reconnect).", e2);
            } catch (Exception e3) {
                return zzaS(zzcj.zzk, 43, "querySkuDetailsAsync got a remote exception (try to reconnect).", e3);
            }
        }
        return new zzdc(0, "", arrayList);
    }

    public final synchronized zzev zzp() {
        try {
            if (this.zzE == null) {
                this.zzE = zzfb.zza(zzaD());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzE;
    }

    public final /* synthetic */ Object zzs(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) {
        zzan zzanVar;
        try {
            synchronized (this.zza) {
                zzanVar = this.zzh;
            }
            if (zzanVar == null) {
                zzaU(acknowledgePurchaseResponseListener, zzcj.zzm, 119, null);
                return null;
            }
            String packageName = this.zzf.getPackageName();
            String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
            String str = this.zzc;
            long jLongValue = this.zzF.longValue();
            Bundle bundle = new Bundle();
            zze.zzc(bundle, str, jLongValue);
            Bundle bundleZzd = zzanVar.zzd(9, packageName, purchaseToken, bundle);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zza(zze.zzb(bundleZzd, "BillingClient"), zze.zzh(bundleZzd, "BillingClient")));
            return null;
        } catch (DeadObjectException e) {
            zzaU(acknowledgePurchaseResponseListener, zzcj.zzm, 28, e);
            return null;
        } catch (Exception e2) {
            zzaU(acknowledgePurchaseResponseListener, zzcj.zzk, 28, e2);
            return null;
        }
    }

    public final /* synthetic */ Object zzt(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Throwable {
        zzaE(consumeParams, consumeResponseListener);
        return null;
    }

    public BillingClientImpl(String str, Context context, zzch zzchVar, ExecutorService executorService) {
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzF = lValueOf;
        String strZzaC = zzaC();
        this.zzc = strZzaC;
        this.zzf = context.getApplicationContext();
        zzks zzksVarZzc = zzku.zzc();
        zzksVarZzc.zzo(strZzaC);
        zzksVarZzc.zzn(this.zzf.getPackageName());
        zzksVarZzc.zzm(lValueOf.longValue());
        this.zzg = new zzcl(this.zzf, (zzku) zzksVarZzc.zzf());
        this.zzf.getPackageName();
    }

    public BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzch zzchVar, ExecutorService executorService) {
        String strZzaC = zzaC();
        this.zza = new Object();
        this.zzb = 0;
        this.zzd = new Handler(Looper.getMainLooper());
        this.zzl = 0;
        this.zzF = Long.valueOf(new Random().nextLong());
        this.zzc = strZzaC;
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, null, strZzaC, null);
    }
}
