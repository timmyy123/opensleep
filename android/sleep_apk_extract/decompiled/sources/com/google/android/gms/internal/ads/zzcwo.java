package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcwo implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzcwo(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzcwo zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzcwo(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcwn zzb() {
        return new zzcwn(((zzcwj) this.zza).zza(), (zzdzl) this.zzb.zzb(), ((zzcyk) this.zzc).zza());
    }
}
