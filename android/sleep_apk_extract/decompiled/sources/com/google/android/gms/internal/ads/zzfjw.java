package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfjw extends zzcch {
    private final zzfjs zza;
    private final zzfjj zzb;
    private final String zzc;
    private final zzfkr zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private final zzbap zzg;
    private final zzdzl zzh;
    private zzdvm zzi;
    private boolean zzj;

    public zzfjw(String str, zzfjs zzfjsVar, Context context, zzfjj zzfjjVar, zzfkr zzfkrVar, VersionInfoParcel versionInfoParcel, zzbap zzbapVar, zzdzl zzdzlVar) {
        this.zzc = str;
        this.zza = zzfjsVar;
        this.zzb = zzfjjVar;
        this.zzd = zzfkrVar;
        this.zze = context;
        this.zzf = versionInfoParcel;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbp)).booleanValue() || Build.VERSION.SDK_INT < 35) {
            this.zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbo)).booleanValue();
        } else {
            this.zzj = true;
        }
        this.zzg = zzbapVar;
        this.zzh = zzdzlVar;
    }

    private final synchronized void zzy(com.google.android.gms.ads.internal.client.zzm zzmVar, zzccp zzccpVar, int i) {
        try {
            if (!zzmVar.zzb()) {
                boolean z = false;
                if (((Boolean) zzbko.zzk.zze()).booleanValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmD)).booleanValue()) {
                        z = true;
                    }
                }
                if (this.zzf.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmE)).intValue() || !z) {
                    Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
                }
            }
            zzfjj zzfjjVar = this.zzb;
            zzfjjVar.zzh(zzccpVar);
            com.google.android.gms.ads.internal.zzt.zzc();
            if (com.google.android.gms.ads.internal.util.zzs.zzK(this.zze) && zzmVar.zzs == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to load the ad because app ID is missing.");
                zzfjjVar.zzdJ(zzfma.zzd(4, null, null));
            } else {
                if (this.zzi != null) {
                    return;
                }
                zzfjl zzfjlVar = new zzfjl(null);
                zzfjs zzfjsVar = this.zza;
                zzfjsVar.zzj(i);
                zzfjsVar.zza(zzmVar, this.zzc, zzfjlVar, new zzfjv(this));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzb(IObjectWrapper iObjectWrapper) {
        zzk(iObjectWrapper, this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzc(com.google.android.gms.ads.internal.client.zzm zzmVar, zzccp zzccpVar) {
        zzy(zzmVar, zzccpVar, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzd(com.google.android.gms.ads.internal.client.zzm zzmVar, zzccp zzccpVar) {
        zzy(zzmVar, zzccpVar, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zze(zzccl zzcclVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzi(zzcclVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzf(com.google.android.gms.ads.internal.client.zzdn zzdnVar) {
        zzfjj zzfjjVar = this.zzb;
        if (zzdnVar == null) {
            zzfjjVar.zzk(null);
        } else {
            zzfjjVar.zzk(new zzfju(this, zzdnVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final Bundle zzg() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdvm zzdvmVar = this.zzi;
        return zzdvmVar != null ? zzdvmVar.zzg() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzh(zzccw zzccwVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzfkr zzfkrVar = this.zzd;
        zzfkrVar.zza = zzccwVar.zza;
        zzfkrVar.zzb = zzccwVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final boolean zzi() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdvm zzdvmVar = this.zzi;
        return (zzdvmVar == null || zzdvmVar.zzb()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized String zzj() {
        zzdvm zzdvmVar = this.zzi;
        if (zzdvmVar == null || zzdvmVar.zzn() == null) {
            return null;
        }
        return zzdvmVar.zzn().zze();
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzk(IObjectWrapper iObjectWrapper, boolean z) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzi == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Rewarded can not be shown before loaded");
            this.zzb.zzj(zzfma.zzd(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdG)).booleanValue()) {
                this.zzg.zzb().zzi(new Throwable().getStackTrace());
            }
            this.zzi.zza(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final zzccf zzl() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdvm zzdvmVar = this.zzi;
        if (zzdvmVar != null) {
            return zzdvmVar.zzc();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final com.google.android.gms.ads.internal.client.zzdx zzm() {
        zzdvm zzdvmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhI)).booleanValue() && (zzdvmVar = this.zzi) != null) {
            return zzdvmVar.zzn();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final String zzn() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzo(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdqVar.zzf()) {
                this.zzh.zzb();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzb.zzl(zzdqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzp(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzj = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized long zzq() {
        zzdvm zzdvmVar = this.zzi;
        if (zzdvmVar == null || zzdvmVar.zzo() == null) {
            return 0L;
        }
        return zzdvmVar.zzo().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzr(long j) {
        zzdvm zzdvmVar = this.zzi;
        if (zzdvmVar == null || zzdvmVar.zzo() == null) {
            return;
        }
        zzdvmVar.zzo().zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzs(zzccq zzccqVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzp(zzccqVar);
    }

    public final void zzu(zzfsy zzfsyVar) {
        this.zzb.zzo(zzfsyVar);
    }

    public final /* synthetic */ zzfkr zzv() {
        return this.zzd;
    }

    public final /* synthetic */ zzdvm zzw() {
        return this.zzi;
    }

    public final /* synthetic */ void zzx(zzdvm zzdvmVar) {
        this.zzi = zzdvmVar;
    }
}
