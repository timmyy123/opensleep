package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeuh implements zzfck {
    private final Clock zza;
    private final zzfky zzb;
    private final long zzc;

    public zzeuh(Clock clock, zzfky zzfkyVar, long j) {
        this.zza = clock;
        this.zzb = zzfkyVar;
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return zzhbw.zza(new zzeui(this.zzb, this.zza.currentTimeMillis(), this.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 4;
    }
}
