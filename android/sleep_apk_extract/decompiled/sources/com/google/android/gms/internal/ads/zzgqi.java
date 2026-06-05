package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgqi implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzgqi(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzgqi zza(zzind zzindVar, zzind zzindVar2) {
        return new zzgqi(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzgqh((zzgcn) this.zza.zzb(), (zzgfh) this.zzb.zzb());
    }
}
