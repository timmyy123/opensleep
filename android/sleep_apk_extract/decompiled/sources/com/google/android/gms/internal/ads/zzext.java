package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes3.dex */
public final class zzext implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzext(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.zza = zzindVar2;
        this.zzb = zzindVar4;
    }

    public static zzext zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzext(zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzewy(zzfaf.zzc(), ((Long) zzbkf.zzf.zze()).longValue(), (Clock) this.zza.zzb(), zzfoa.zzc(), (zzdzl) this.zzb.zzb());
    }
}
