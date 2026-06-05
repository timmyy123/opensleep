package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* JADX INFO: loaded from: classes3.dex */
public final class zzid {
    private final zzif zza = new zzif(null);

    public final zzid zza(zzfl zzflVar) {
        this.zza.zze = zzflVar;
        return this;
    }

    public final zzid zzc(DiscoveryOptions discoveryOptions) {
        this.zza.zzd = discoveryOptions;
        return this;
    }

    public final zzid zzd(zzfs zzfsVar) {
        this.zza.zza = zzfsVar;
        return this;
    }

    public final zzid zze(String str) {
        this.zza.zzb = str;
        return this;
    }

    public final zzif zzf() {
        return this.zza;
    }
}
