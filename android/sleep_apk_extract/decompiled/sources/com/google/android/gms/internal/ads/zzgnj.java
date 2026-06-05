package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgnj implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzgnj(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzgnj zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzgnj(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzind zzindVar = this.zzc;
        zzind zzindVar2 = this.zzb;
        zzimo zzimoVarZzc = zzimt.zzc(this.zza);
        zzimo zzimoVarZzc2 = zzimt.zzc(zzindVar2);
        if (true == ((zzgdf) zzindVar.zzb()).zzu()) {
            zzimoVarZzc = zzimoVarZzc2;
        }
        zzgmw zzgmwVar = (zzgmw) zzimoVarZzc.zzb();
        zzinc.zzb(zzgmwVar);
        return zzgmwVar;
    }
}
