package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfmh implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzfmh(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzfmh zza(zzind zzindVar, zzind zzindVar2) {
        return new zzfmh(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfmg(((zzcns) this.zza).zza(), ((zzcol) this.zzb).zzb());
    }
}
