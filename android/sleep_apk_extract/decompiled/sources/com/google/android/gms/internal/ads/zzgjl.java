package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgjl implements zzimu {
    private final zzind zza;

    private zzgjl(zzgjk zzgjkVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgjl zza(zzgjk zzgjkVar, zzind zzindVar) {
        return new zzgjl(zzgjkVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgfr zzgfrVarZza = ((zzgjo) this.zza.zzb()).zza().zza();
        zzinc.zzb(zzgfrVarZza);
        return zzgfrVarZza;
    }
}
