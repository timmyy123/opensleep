package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcvg extends zzbgi {
    private final zzcvf zza;
    private final com.google.android.gms.ads.internal.client.zzbu zzb;
    private final zzfge zzc;
    private boolean zzd;
    private final zzdzl zze;

    public zzcvg(zzcvf zzcvfVar, com.google.android.gms.ads.internal.client.zzbu zzbuVar, zzfge zzfgeVar, zzdzl zzdzlVar) {
        this.zza = zzcvfVar;
        this.zzb = zzbuVar;
        this.zzc = zzfgeVar;
        this.zze = zzdzlVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbp)).booleanValue() && Build.VERSION.SDK_INT >= 35) {
            this.zzd = true;
        } else {
            this.zzd = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbs)).booleanValue();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final com.google.android.gms.ads.internal.client.zzbu zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzf(IObjectWrapper iObjectWrapper, zzbgq zzbgqVar) {
        try {
            this.zzc.zzp(zzbgqVar);
            this.zza.zzb((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzbgqVar, this.zzd);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final com.google.android.gms.ads.internal.client.zzdx zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhI)).booleanValue()) {
            return this.zza.zzn();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzh(boolean z) {
        this.zzd = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzi(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        if (this.zzc != null) {
            try {
                if (!zzdqVar.zzf()) {
                    this.zze.zzb();
                }
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Error in making CSI ping for reporting paid event callback", e);
            }
            this.zzc.zzr(zzdqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final String zzj() {
        try {
            return this.zzb.zzu();
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final long zzk() {
        zzcvf zzcvfVar = this.zza;
        if (zzcvfVar == null || zzcvfVar.zzo() == null) {
            return 0L;
        }
        return zzcvfVar.zzo().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzl(long j) {
        zzcvf zzcvfVar = this.zza;
        if (zzcvfVar == null || zzcvfVar.zzo() == null) {
            return;
        }
        zzcvfVar.zzo().zzb(j);
    }
}
