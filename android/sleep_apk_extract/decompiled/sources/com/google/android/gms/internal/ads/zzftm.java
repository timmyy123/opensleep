package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzftm {
    private final Object zza;
    private final long zzb;
    private final Clock zzc;
    private final long zzd;
    private final double zze;
    private final int zzf;

    public zzftm(Object obj, Clock clock, double d, int i) {
        if (clock == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Clock cannot be null.");
            throw null;
        }
        this.zza = obj;
        this.zzc = clock;
        this.zzb = clock.currentTimeMillis();
        this.zzd = Math.min(Math.max(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzaa)).longValue() * 1000, 10000L), 21600000L);
        this.zze = d;
        this.zzf = i;
    }

    public final Object zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return this.zzc.currentTimeMillis() >= this.zzb + this.zzd;
    }

    public final long zzc() {
        return this.zzd - (this.zzc.currentTimeMillis() - this.zzb);
    }

    public final long zzd() {
        return this.zzb;
    }

    public final double zze() {
        return this.zze;
    }

    public final int zzf() {
        return this.zzf;
    }
}
