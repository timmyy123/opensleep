package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbgr {
    private com.google.android.gms.ads.internal.client.zzbu zza;
    private final Context zzb;
    private final String zzc;
    private final com.google.android.gms.ads.internal.client.zzeh zzd;
    private final AppOpenAd.AppOpenAdLoadCallback zze;
    private final zzbuy zzf = new zzbuy();
    private final com.google.android.gms.ads.internal.client.zzq zzg = com.google.android.gms.ads.internal.client.zzq.zza;

    public zzbgr(Context context, String str, com.google.android.gms.ads.internal.client.zzeh zzehVar, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzb = context;
        this.zzc = str;
        this.zzd = zzehVar;
        this.zze = appOpenAdLoadCallback;
    }

    public final void zza() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.google.android.gms.ads.internal.client.zzr zzrVarZzd = com.google.android.gms.ads.internal.client.zzr.zzd();
            com.google.android.gms.ads.internal.client.zzaw zzawVarZzb = com.google.android.gms.ads.internal.client.zzay.zzb();
            Context context = this.zzb;
            String str = this.zzc;
            com.google.android.gms.ads.internal.client.zzbu zzbuVarZza = zzawVarZzb.zza(context, zzrVarZzd, str, this.zzf);
            this.zza = zzbuVarZza;
            if (zzbuVarZza != null) {
                com.google.android.gms.ads.internal.client.zzeh zzehVar = this.zzd;
                zzehVar.zzp(jCurrentTimeMillis);
                this.zza.zzJ(new zzbge(this.zze, str));
                this.zza.zze(this.zzg.zza(context, zzehVar));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }
}
