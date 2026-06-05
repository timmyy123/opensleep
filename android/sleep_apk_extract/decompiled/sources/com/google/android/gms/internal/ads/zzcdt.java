package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcdt implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcdt(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzcdt zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzcdt(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcds zzb() {
        return new zzcds((Clock) this.zza.zzb(), (zzcdq) this.zzb.zzb());
    }
}
