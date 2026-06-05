package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes3.dex */
public final class zzczk implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzczk(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzczk zza(zzind zzindVar, zzind zzindVar2) {
        return new zzczk(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzczj((Clock) this.zza.zzb(), (zzcex) this.zzb.zzb());
    }
}
