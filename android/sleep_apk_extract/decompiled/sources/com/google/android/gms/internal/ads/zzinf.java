package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzinf {
    private final List zza;
    private final List zzb;

    public /* synthetic */ zzinf(int i, int i2, zzine zzineVar) {
        this.zza = zzimr.zza(i);
        this.zzb = zzimr.zza(i2);
    }

    public final zzinf zza(zzind zzindVar) {
        this.zza.add(zzindVar);
        return this;
    }

    public final zzinf zzb(zzind zzindVar) {
        this.zzb.add(zzindVar);
        return this;
    }

    public final zzing zzc() {
        return new zzing(this.zza, this.zzb, null);
    }
}
