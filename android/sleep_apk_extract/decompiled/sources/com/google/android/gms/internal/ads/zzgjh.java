package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgjh implements zzimu {
    private final zzind zza;

    private zzgjh(zzgjg zzgjgVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgjh zza(zzgjg zzgjgVar, zzind zzindVar) {
        return new zzgjh(zzgjgVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgfr zzgfrVarZza = ((zzggi) this.zza.zzb()).zza().zza();
        zzinc.zzb(zzgfrVarZza);
        return zzgfrVarZza;
    }
}
