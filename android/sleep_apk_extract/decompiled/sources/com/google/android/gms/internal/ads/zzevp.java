package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzevp implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzevp(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
    }

    public static zzevp zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzevp(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzevn(zzfoa.zzc(), ((zzdci) this.zza).zza(), ((zzcol) this.zzb).zzb());
    }
}
