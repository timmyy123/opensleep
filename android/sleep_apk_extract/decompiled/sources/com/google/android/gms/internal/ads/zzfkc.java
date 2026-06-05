package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfkc extends zzcbr {
    private final zzfjs zza;
    private final zzfjj zzb;
    private final zzfkr zzc;
    private zzdvm zzd;
    private boolean zze = false;

    public zzfkc(zzfjs zzfjsVar, zzfjj zzfjjVar, zzfkr zzfkrVar) {
        this.zza = zzfjsVar;
        this.zzb = zzfjjVar;
        this.zzc = zzfkrVar;
    }

    private final synchronized boolean zzy() {
        zzdvm zzdvmVar = this.zzd;
        if (zzdvmVar != null) {
            if (!zzdvmVar.zze()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(com.google.android.gms.internal.ads.zzbiq.zzgy)).booleanValue() == false) goto L18;
     */
    @Override // com.google.android.gms.internal.ads.zzcbs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzb(zzcbw zzcbwVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        String str = zzcbwVar.zzb;
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgw);
        if (str2 != null && str != null) {
            try {
                if (!Pattern.matches(str2, str)) {
                }
            } catch (RuntimeException e) {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "NonagonUtil.isPatternMatched");
            }
            return;
        }
        if (zzy()) {
        }
        zzfjl zzfjlVar = new zzfjl(null);
        this.zzd = null;
        zzfjs zzfjsVar = this.zza;
        zzfjsVar.zzj(1);
        zzfjsVar.zza(zzcbwVar.zza, zzcbwVar.zzb, zzfjlVar, new zzfka(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzc() {
        zzp(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzd(zzcbv zzcbvVar) {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzb.zzn(zzcbvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final boolean zze() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzf() {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzg() {
        zzj(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzh() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzl().zza(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzl().zzb(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzb.zzk(null);
        if (this.zzd != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzd.zzl().zzc(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized String zzl() {
        zzdvm zzdvmVar = this.zzd;
        if (zzdvmVar == null || zzdvmVar.zzn() == null) {
            return null;
        }
        return zzdvmVar.zzn().zze();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzm(String str) {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzc.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzn(com.google.android.gms.ads.internal.client.zzby zzbyVar) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        zzfjj zzfjjVar = this.zzb;
        if (zzbyVar == null) {
            zzfjjVar.zzk(null);
        } else {
            zzfjjVar.zzk(new zzfkb(this, zzbyVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final Bundle zzo() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzdvm zzdvmVar = this.zzd;
        return zzdvmVar != null ? zzdvmVar.zzg() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzp(IObjectWrapper iObjectWrapper) {
        try {
            Preconditions.checkMainThread("showAd must be called on the main UI thread.");
            if (this.zzd != null) {
                Activity activity = null;
                if (iObjectWrapper != null) {
                    Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
                    if (objUnwrap instanceof Activity) {
                        activity = (Activity) objUnwrap;
                    }
                }
                this.zzd.zza(this.zze, activity);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzq(String str) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
        this.zzc.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzr(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zze = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final boolean zzs() {
        zzdvm zzdvmVar = this.zzd;
        return zzdvmVar != null && zzdvmVar.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized com.google.android.gms.ads.internal.client.zzdx zzt() {
        zzdvm zzdvmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhI)).booleanValue() && (zzdvmVar = this.zzd) != null) {
            return zzdvmVar.zzn();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzu(zzcbq zzcbqVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzb.zzq(zzcbqVar);
    }

    public final /* synthetic */ zzfkr zzv() {
        return this.zzc;
    }

    public final /* synthetic */ zzdvm zzw() {
        return this.zzd;
    }

    public final /* synthetic */ void zzx(zzdvm zzdvmVar) {
        this.zzd = zzdvmVar;
    }
}
