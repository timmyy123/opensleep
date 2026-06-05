package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdvj implements zzbqi {
    private final zzddy zza;
    private final zzccb zzb;
    private final String zzc;
    private final String zzd;

    public zzdvj(zzddy zzddyVar, zzfkf zzfkfVar) {
        this.zza = zzddyVar;
        this.zzb = zzfkfVar.zzl;
        this.zzc = zzfkfVar.zzj;
        this.zzd = zzfkfVar.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zza() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    @ParametersAreNonnullByDefault
    public final void zzb(zzccb zzccbVar) {
        int i;
        String str;
        zzccb zzccbVar2 = this.zzb;
        if (zzccbVar2 != null) {
            zzccbVar = zzccbVar2;
        }
        if (zzccbVar != null) {
            str = zzccbVar.zza;
            i = zzccbVar.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zze(new zzcbm(str, i), this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zzc() {
        this.zza.zzf();
    }
}
