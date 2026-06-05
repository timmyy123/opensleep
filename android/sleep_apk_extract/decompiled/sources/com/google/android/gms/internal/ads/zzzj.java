package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzzj implements zzzc {
    private final zzzc zza;
    private final long zzb;

    public zzzj(zzzc zzzcVar, long j) {
        this.zza = zzzcVar;
        this.zzb = j;
    }

    public final zzzc zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zzc() {
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zzd(zzlw zzlwVar, zziv zzivVar, int i) {
        int iZzd = this.zza.zzd(zzlwVar, zzivVar, i);
        if (iZzd != -4) {
            return iZzd;
        }
        zzivVar.zze += this.zzb;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zze(long j) {
        return this.zza.zze(j - this.zzb);
    }
}
