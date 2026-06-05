package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcds {
    private final Clock zza;
    private final zzcdq zzb;

    public zzcds(Clock clock, zzcdq zzcdqVar) {
        this.zza = clock;
        this.zzb = zzcdqVar;
    }

    public static zzcds zza(Context context) {
        return zzcea.zzb(context).zza();
    }

    public final void zzb() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzc(com.google.android.gms.ads.internal.client.zzfr zzfrVar) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd(int i, long j) {
        this.zzb.zza(i, j);
    }
}
