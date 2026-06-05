package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes3.dex */
public final class zzczv implements zzdim, zzdef {
    private final Clock zza;
    private final zzczx zzb;
    private final zzfky zzc;
    private final String zzd;

    public zzczv(Clock clock, zzczx zzczxVar, zzfky zzfkyVar, String str) {
        this.zza = clock;
        this.zzb = zzczxVar;
        this.zzc = zzfkyVar;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdim
    public final void zza() {
        this.zzb.zzd(this.zzd, this.zza.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final void zzg() {
        Clock clock = this.zza;
        this.zzb.zze(this.zzc.zzg, this.zzd, clock.elapsedRealtime());
    }
}
