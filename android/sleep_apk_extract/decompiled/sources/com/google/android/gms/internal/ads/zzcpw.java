package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzcpw implements zzehq {
    private final zzefw zza;
    private final zzcox zzb;

    public zzcpw(zzcox zzcoxVar, zzcpu zzcpuVar, zzefw zzefwVar) {
        this.zzb = zzcoxVar;
        this.zza = zzefwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final zzefx zza() {
        zzcox zzcoxVar = this.zzb;
        return zzefy.zza(zzcns.zzd(zzcoxVar.zzI()), zzcoi.zzd(zzcoxVar.zzI()), this.zza, zzcah.zza());
    }
}
