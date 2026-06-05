package com.google.android.gms.internal.measurement;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;

/* JADX INFO: loaded from: classes3.dex */
public final class zzpj {
    private final Function zza;
    private final ImmutableSet zzb = ImmutableSet.of();
    private boolean zzc = false;

    public zzpj(Function function) {
        this.zza = function;
    }

    public final zzpj zza() {
        this.zzc = true;
        return this;
    }

    public final zzph zzb() {
        return new zzpi(new zzon(this.zza, false, false, this.zzc, false, this.zzb), null);
    }
}
