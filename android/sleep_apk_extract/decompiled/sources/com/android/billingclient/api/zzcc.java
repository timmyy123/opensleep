package com.android.billingclient.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzel;
import com.google.android.gms.internal.play_billing.zzeu;
import com.google.android.gms.internal.play_billing.zzew;
import com.google.android.gms.internal.play_billing.zzfb;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzkd;
import com.google.android.gms.internal.play_billing.zzr;
import com.google.android.gms.internal.play_billing.zzv;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
final class zzcc extends BillingClientImpl {
    private final Context zza;
    private volatile int zzb;
    private volatile com.google.android.gms.internal.play_billing.zzav zzc;
    private volatile zzca zzd;
    private volatile zzew zze;

    public zzcc(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzco zzcoVar, zzch zzchVar, ExecutorService executorService) {
        super(null, pendingPurchasesParams, context, null, null, null);
        this.zzb = 0;
        this.zza = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int zzaL(zzeu zzeuVar) {
        try {
            return ((Integer) zzeuVar.get(28500L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException e) {
            this.zzaS(114, 28, zzcj.zzG);
            zze.zzm("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", e);
            return 0;
        } catch (Exception e2) {
            if (e2 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            this.zzaS(107, 28, zzcj.zzG);
            zze.zzm("BillingClientTesting", "An error occurred while retrieving billing override.", e2);
            return 0;
        }
    }

    private final synchronized zzew zzaM() {
        try {
            if (this.zze == null) {
                this.zze = zzfb.zzb(Executors.newSingleThreadScheduledExecutor());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zze;
    }

    private final synchronized void zzaN() {
        zzaT(27);
        try {
            try {
                zzcb zzcbVar = null;
                if (this.zzd != null && this.zzc != null) {
                    zze.zzk("BillingClientTesting", "Unbinding from Billing Override Service.");
                    this.zza.unbindService(this.zzd);
                    this.zzd = new zzca(this, zzcbVar);
                }
                this.zzc = null;
                if (this.zze != null) {
                    this.zze.shutdownNow();
                    this.zze = null;
                }
            } catch (RuntimeException e) {
                zze.zzm("BillingClientTesting", "There was an exception while ending Billing Override Service connection!", e);
            }
            this.zzb = 3;
        } catch (Throwable th) {
            this.zzb = 3;
            throw th;
        }
    }

    private final synchronized void zzaO() {
        if (zzaG()) {
            zze.zzk("BillingClientTesting", "Billing Override Service connection is valid. No need to re-initialize.");
            zzaT(26);
            return;
        }
        int i = 1;
        if (this.zzb == 1) {
            zze.zzl("BillingClientTesting", "Client is already in the process of connecting to Billing Override Service.");
            return;
        }
        if (this.zzb == 3) {
            zze.zzl("BillingClientTesting", "Billing Override Service Client was already closed and can't be reused. Please create another instance.");
            zzaS(38, 26, zzcj.zza(-1, "Billing Override Service connection is disconnected."));
            return;
        }
        this.zzb = 1;
        zze.zzk("BillingClientTesting", "Starting Billing Override Service setup.");
        this.zzd = new zzca(this, null);
        Intent intent = new Intent("com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND");
        intent.setPackage("com.google.android.apps.play.billingtestcompanion");
        List<ResolveInfo> listQueryIntentServices = this.zza.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            i = 41;
        } else {
            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!Objects.equals(str, "com.google.android.apps.play.billingtestcompanion") || str2 == null) {
                    zze.zzl("BillingClientTesting", "The device doesn't have valid Play Billing Lab.");
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    if (this.zza.bindService(intent2, this.zzd, 1)) {
                        zze.zzk("BillingClientTesting", "Billing Override Service was bonded successfully.");
                        return;
                    }
                    zze.zzl("BillingClientTesting", "Connection to Billing Override Service is blocked.");
                }
                i = 39;
            }
        }
        this.zzb = 0;
        zze.zzk("BillingClientTesting", "Billing Override Service unavailable on device.");
        zzaS(i, 26, zzcj.zza(2, "Billing Override Service unavailable on device."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzaP(int i) {
        return i > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzaQ(int i, int i2) {
        BillingResult billingResultZza = zzcj.zza(i2, "Billing override value was set by a license tester.");
        zzaS(105, i, billingResultZza);
        return billingResultZza;
    }

    private final zzeu zzaR(int i) {
        if (zzaG()) {
            return zzv.zza(new zzbs(this, i));
        }
        zze.zzl("BillingClientTesting", "Billing Override Service is not ready.");
        zzaS(106, 28, zzcj.zza(-1, "Billing Override Service connection is disconnected."));
        return zzel.zza(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaS(int i, int i2, BillingResult billingResult) {
        zzjz zzjzVarZzb = zzcg.zzb(i, i2, billingResult);
        Objects.requireNonNull(zzjzVarZzb, "ApiFailure should not be null");
        zzk().zza(zzjzVarZzb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaT(int i) {
        zzkd zzkdVarZzd = zzcg.zzd(i);
        Objects.requireNonNull(zzkdVarZzd, "ApiSuccess should not be null");
        zzk().zzc(zzkdVarZzd);
    }

    private final void zzaU(int i, Consumer consumer, Runnable runnable) {
        zzel.zzc(zzel.zzb(zzaR(i), 28500L, TimeUnit.MILLISECONDS, zzaM()), new zzby(this, i, consumer, runnable), zzp());
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        Objects.requireNonNull(acknowledgePurchaseResponseListener);
        zzaU(3, new Consumer() { // from class: com.android.billingclient.api.zzbv
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse((BillingResult) obj);
            }
        }, new Runnable() { // from class: com.android.billingclient.api.zzbw
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaA(acknowledgePurchaseParams, acknowledgePurchaseResponseListener);
            }
        });
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        zzaU(4, new Consumer() { // from class: com.android.billingclient.api.zzbq
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                consumeResponseListener.onConsumeResponse((BillingResult) obj, consumeParams.getPurchaseToken());
            }
        }, new Runnable() { // from class: com.android.billingclient.api.zzbr
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaB(consumeParams, consumeResponseListener);
            }
        });
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void endConnection() {
        zzaN();
        super.endConnection();
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final BillingResult launchBillingFlow(final Activity activity, final BillingFlowParams billingFlowParams) {
        Consumer consumer = new Consumer() { // from class: com.android.billingclient.api.zzbx
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.zza.zzaC((BillingResult) obj);
            }
        };
        Callable callable = new Callable() { // from class: com.android.billingclient.api.zzbo
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzax(activity, billingFlowParams);
            }
        };
        int iZzaL = zzaL(zzaR(2));
        if (zzaP(iZzaL)) {
            BillingResult billingResultZzaQ = zzaQ(2, iZzaL);
            consumer.accept(billingResultZzaQ);
            return billingResultZzaQ;
        }
        try {
            return (BillingResult) callable.call();
        } catch (Exception e) {
            BillingResult billingResult = zzcj.zzk;
            zzaS(115, 2, billingResult);
            zze.zzm("BillingClientTesting", "An internal error occurred.", e);
            return billingResult;
        }
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void querySkuDetailsAsync(final SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        zzaU(8, new Consumer() { // from class: com.android.billingclient.api.zzbt
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                skuDetailsResponseListener.onSkuDetailsResponse((BillingResult) obj, null);
            }
        }, new Runnable() { // from class: com.android.billingclient.api.zzbu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaE(skuDetailsParams, skuDetailsResponseListener);
            }
        });
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void startConnection(BillingClientStateListener billingClientStateListener) {
        zzaO();
        super.startConnection(billingClientStateListener);
    }

    public final /* synthetic */ void zzaA(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        super.acknowledgePurchase(acknowledgePurchaseParams, acknowledgePurchaseResponseListener);
    }

    public final /* synthetic */ void zzaB(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        super.consumeAsync(consumeParams, consumeResponseListener);
    }

    public final /* synthetic */ void zzaC(BillingResult billingResult) {
        zzm(billingResult);
    }

    public final /* synthetic */ void zzaE(SkuDetailsParams skuDetailsParams, SkuDetailsResponseListener skuDetailsResponseListener) {
        super.querySkuDetailsAsync(skuDetailsParams, skuDetailsResponseListener);
    }

    public final synchronized boolean zzaG() {
        if (this.zzb == 2 && this.zzc != null) {
            if (this.zzd != null) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Object zzaI(int i, zzr zzrVar) {
        String str;
        try {
            if (this.zzc == null) {
                throw null;
            }
            com.google.android.gms.internal.play_billing.zzav zzavVar = this.zzc;
            String packageName = this.zza.getPackageName();
            switch (i) {
                case 2:
                    str = "LAUNCH_BILLING_FLOW";
                    break;
                case 3:
                    str = "ACKNOWLEDGE_PURCHASE";
                    break;
                case 4:
                    str = "CONSUME_ASYNC";
                    break;
                case 5:
                    str = "IS_FEATURE_SUPPORTED";
                    break;
                case 6:
                    str = "START_CONNECTION";
                    break;
                case 7:
                    str = "QUERY_PRODUCT_DETAILS_ASYNC";
                    break;
                default:
                    str = "QUERY_SKU_DETAILS_ASYNC";
                    break;
            }
            zzavVar.zza(packageName, str, new zzbz(zzrVar));
            return "billingOverrideService.getBillingOverride";
        } catch (Exception e) {
            zzaS(107, 28, zzcj.zzG);
            zze.zzm("BillingClientTesting", "An error occurred while retrieving billing override.", e);
            zzrVar.zzb(0);
            return "billingOverrideService.getBillingOverride";
        }
    }

    public final /* synthetic */ BillingResult zzax(Activity activity, BillingFlowParams billingFlowParams) {
        return super.launchBillingFlow(activity, billingFlowParams);
    }

    public zzcc(String str, Context context, zzch zzchVar, ExecutorService executorService) {
        super(null, context, null, null);
        this.zzb = 0;
        this.zza = context;
    }

    public zzcc(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzch zzchVar, ExecutorService executorService) {
        super(null, pendingPurchasesParams, context, purchasesUpdatedListener, null, null, null);
        this.zzb = 0;
        this.zza = context;
    }
}
