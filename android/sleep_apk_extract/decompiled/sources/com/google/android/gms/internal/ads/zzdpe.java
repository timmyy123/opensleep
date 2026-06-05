package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzdpe implements zzhbt {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdpo zzb;

    public zzdpe(zzdpo zzdpoVar, String str, boolean z) {
        Objects.requireNonNull(zzdpoVar);
        this.zzb = zzdpoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgs)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdpo zzdpoVar = this.zzb;
        zzdpoVar.zzZ().zzo((zzcku) obj);
        String str = this.zza;
        zzcfw zzcfwVarZzY = zzdpoVar.zzZ().zzY();
        zzeln zzelnVarZzL = zzdpoVar.zzL(str, true);
        if (zzelnVarZzL != null && zzcfwVarZzY != null) {
            zzcfwVarZzY.zzc(zzelnVarZzL);
        } else if (zzcfwVarZzY != null) {
            zzcfwVarZzY.cancel(false);
        }
    }
}
