package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgjx implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;

    private zzgjx(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
    }

    public static zzgjx zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzgjx(zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzind zzindVar = this.zzd;
        zzind zzindVar2 = this.zzc;
        zzind zzindVar3 = this.zzb;
        zzimo zzimoVarZzc = zzimt.zzc(this.zza);
        zzimo zzimoVarZzc2 = zzimt.zzc(zzindVar3);
        zzimo zzimoVarZzc3 = zzimt.zzc(zzindVar2);
        zzgdf zzgdfVar = (zzgdf) zzindVar.zzb();
        return new zzgjw(zzimoVarZzc, zzimoVarZzc2, zzimoVarZzc3, zzgdfVar.zzk().zza(), zzgdfVar.zzk().zzd());
    }
}
