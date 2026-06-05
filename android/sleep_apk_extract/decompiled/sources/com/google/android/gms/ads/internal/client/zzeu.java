package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus$State;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbry;
import com.google.android.gms.internal.ads.zzbuy;
import com.urbandroid.common.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeu {
    public static final Set zza = new HashSet(Arrays.asList(AdFormat.APP_OPEN_AD, AdFormat.INTERSTITIAL, AdFormat.REWARDED));
    private static zzeu zze;
    private zzem zzb;
    private zzey zzc;
    private zzel zzd;
    private zzcy zzl;
    private final Object zzf = new Object();
    private final Object zzg = new Object();
    private boolean zzi = false;
    private boolean zzj = false;
    private final Object zzk = new Object();
    private RequestConfiguration zzn = new RequestConfiguration.Builder().build();
    private final ArrayList zzh = new ArrayList();

    private zzeu() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InitializationStatus zzB(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbrp zzbrpVar = (zzbrp) it.next();
            map.put(zzbrpVar.zza, new zzbrx(zzbrpVar.zzb ? AdapterStatus$State.READY : AdapterStatus$State.NOT_READY, zzbrpVar.zzd, zzbrpVar.zzc));
        }
        return new zzbry(map);
    }

    private final void zzC(RequestConfiguration requestConfiguration) {
        zzcy zzcyVar = this.zzl;
        if (zzcyVar == null) {
            return;
        }
        try {
            zzcyVar.zzr(new zzfr(requestConfiguration));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to set request configuration parcel.", e);
        }
    }

    private final void zzD(Context context) {
        if (this.zzl == null) {
            this.zzl = (zzcy) new zzat(zzay.zzb(), context).zzd(context, false);
        }
    }

    private final void zzE(String str) {
        zzcy zzcyVar = this.zzl;
        if (zzcyVar == null) {
            return;
        }
        try {
            zzcyVar.zze();
            this.zzl.zzj(null, ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("MobileAdsSettingManager initialization failed", e);
        }
    }

    public static zzeu zzb() {
        zzeu zzeuVar;
        synchronized (zzeu.class) {
            try {
                if (zze == null) {
                    zze = new zzeu();
                }
                zzeuVar = zze;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzeuVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2 A[Catch: all -> 0x004e, TryCatch #1 {all -> 0x004e, RemoteException -> 0x0051, blocks: (B:26:0x0034, B:28:0x003b, B:33:0x0053, B:35:0x005c, B:40:0x006f, B:42:0x0080, B:44:0x0092, B:51:0x00d5, B:52:0x00ea, B:45:0x00a2, B:47:0x00b0, B:49:0x00c2, B:50:0x00cd, B:37:0x0064, B:39:0x006a), top: B:60:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cd A[Catch: all -> 0x004e, TryCatch #1 {all -> 0x004e, RemoteException -> 0x0051, blocks: (B:26:0x0034, B:28:0x003b, B:33:0x0053, B:35:0x005c, B:40:0x006f, B:42:0x0080, B:44:0x0092, B:51:0x00d5, B:52:0x00ea, B:45:0x00a2, B:47:0x00b0, B:49:0x00c2, B:50:0x00cd, B:37:0x0064, B:39:0x006a), top: B:60:0x0034 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzc(Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.zzf) {
            try {
                if (this.zzi) {
                    if (onInitializationCompleteListener != null) {
                        this.zzh.add(onInitializationCompleteListener);
                    }
                    return;
                }
                if (this.zzj) {
                    if (onInitializationCompleteListener != null) {
                        zzl();
                        Logger.logInfo("ADMOB: initialized");
                    }
                    return;
                }
                this.zzi = true;
                if (onInitializationCompleteListener != null) {
                    this.zzh.add(onInitializationCompleteListener);
                }
                if (context == null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Context cannot be null.");
                    return;
                }
                synchronized (this.zzk) {
                    byte[] bArr = null;
                    Object[] objArr = 0;
                    Object[] objArr2 = 0;
                    try {
                        zzD(context);
                        zzcy zzcyVar = this.zzl;
                        if (zzcyVar != null) {
                            zzcyVar.zzp(new zzet(this, bArr));
                            this.zzl.zzo(new zzbuy());
                        }
                        if (this.zzn.getTagForChildDirectedTreatment() != -1 || this.zzn.getTagForUnderAgeOfConsent() != -1) {
                            zzC(this.zzn);
                        }
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("MobileAdsSettingManager initialization failed", e);
                    } finally {
                    }
                    zzbiq.zza(context);
                    if (((Boolean) zzbko.zza.zze()).booleanValue()) {
                        if (((Boolean) zzba.zzc().zzd(zzbiq.zzmC)).booleanValue()) {
                            com.google.android.gms.ads.internal.util.client.zzo.zzd("Initializing on bg thread");
                            ThreadPoolExecutor threadPoolExecutor = com.google.android.gms.ads.internal.util.client.zzb.zza;
                            final Object[] objArr3 = objArr2 == true ? 1 : 0;
                            threadPoolExecutor.execute(new Runnable(objArr3) { // from class: com.google.android.gms.ads.internal.client.zzer
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zzt(null);
                                }
                            });
                        } else if (((Boolean) zzbko.zzb.zze()).booleanValue()) {
                            if (((Boolean) zzba.zzc().zzd(zzbiq.zzmC)).booleanValue()) {
                                ExecutorService executorService = com.google.android.gms.ads.internal.util.client.zzb.zzb;
                                final Object[] objArr4 = objArr == true ? 1 : 0;
                                executorService.execute(new Runnable(objArr4) { // from class: com.google.android.gms.ads.internal.client.zzep
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzu(null);
                                    }
                                });
                            } else {
                                com.google.android.gms.ads.internal.util.client.zzo.zzd("Initializing on calling thread");
                                zzE(null);
                            }
                        }
                    }
                    this.zzb = new zzem(context);
                    this.zzc = new zzey(context);
                    this.zzd = new zzel(context);
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0028 A[Catch: all -> 0x0019, TryCatch #1 {, blocks: (B:9:0x0011, B:11:0x0015, B:17:0x0021, B:19:0x0028, B:20:0x002d, B:22:0x0031, B:23:0x0036, B:25:0x003a, B:26:0x003f, B:16:0x001c), top: B:35:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0031 A[Catch: all -> 0x0019, TryCatch #1 {, blocks: (B:9:0x0011, B:11:0x0015, B:17:0x0021, B:19:0x0028, B:20:0x002d, B:22:0x0031, B:23:0x0036, B:25:0x003a, B:26:0x003f, B:16:0x001c), top: B:35:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003a A[Catch: all -> 0x0019, TryCatch #1 {, blocks: (B:9:0x0011, B:11:0x0015, B:17:0x0021, B:19:0x0028, B:20:0x002d, B:22:0x0031, B:23:0x0036, B:25:0x003a, B:26:0x003f, B:16:0x001c), top: B:35:0x0011, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd() {
        zzem zzemVar;
        zzey zzeyVar;
        zzel zzelVar;
        zzcy zzcyVar;
        synchronized (this.zzf) {
            this.zzj = false;
            this.zzi = false;
            this.zzh.clear();
        }
        synchronized (this.zzk) {
            try {
                zzcyVar = this.zzl;
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to stop the SDK.", e);
            }
            if (zzcyVar != null) {
                zzcyVar.zzw();
                this.zzl = null;
                zzemVar = this.zzb;
                if (zzemVar != null) {
                    zzemVar.zzg();
                    this.zzb = null;
                }
                zzeyVar = this.zzc;
                if (zzeyVar != null) {
                    zzeyVar.zzg();
                    this.zzc = null;
                }
                zzelVar = this.zzd;
                if (zzelVar != null) {
                    zzelVar.zzg();
                    this.zzd = null;
                }
            } else {
                this.zzl = null;
                zzemVar = this.zzb;
                if (zzemVar != null) {
                }
                zzeyVar = this.zzc;
                if (zzeyVar != null) {
                }
                zzelVar = this.zzd;
                if (zzelVar != null) {
                }
            }
        }
    }

    public final InitializationStatus zzl() {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzeq
                };
            }
            try {
                return zzB(zzcyVar.zzq());
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Unable to get Initialization status.");
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzeq
                };
            }
        }
    }

    public final RequestConfiguration zzp() {
        return this.zzn;
    }

    public final void zzq(RequestConfiguration requestConfiguration) {
        Preconditions.checkArgument(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        synchronized (this.zzk) {
            try {
                RequestConfiguration requestConfiguration2 = this.zzn;
                this.zzn = requestConfiguration;
                if (this.zzl == null) {
                    return;
                }
                if (requestConfiguration2.getTagForChildDirectedTreatment() != requestConfiguration.getTagForChildDirectedTreatment() || requestConfiguration2.getTagForUnderAgeOfConsent() != requestConfiguration.getTagForUnderAgeOfConsent()) {
                    zzC(requestConfiguration);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzs(String str) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to setting the plugin.");
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return;
            }
            try {
                zzcyVar.zzv(str);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to set plugin.", e);
            }
        }
    }

    public final /* synthetic */ void zzt(String str) {
        synchronized (this.zzk) {
            zzE(null);
        }
    }

    public final /* synthetic */ void zzu(String str) {
        synchronized (this.zzk) {
            zzE(null);
        }
    }

    public final /* synthetic */ Object zzw() {
        return this.zzf;
    }

    public final /* synthetic */ ArrayList zzx() {
        return this.zzh;
    }

    public final /* synthetic */ void zzy(boolean z) {
        this.zzi = false;
    }

    public final /* synthetic */ void zzz(boolean z) {
        this.zzj = true;
    }
}
