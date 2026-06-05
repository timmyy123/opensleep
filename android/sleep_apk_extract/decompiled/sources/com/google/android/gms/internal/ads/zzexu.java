package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes3.dex */
public final class zzexu implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzexu(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzexu zza(zzind zzindVar, zzind zzindVar2) {
        return new zzexu(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfke((Clock) this.zza.zzb(), (zzdzl) this.zzb.zzb());
    }
}
