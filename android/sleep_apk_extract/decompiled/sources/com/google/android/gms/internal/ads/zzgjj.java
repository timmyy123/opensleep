package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgjj implements zzimu {
    private final zzind zza;

    private zzgjj(zzgji zzgjiVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgjj zza(zzgji zzgjiVar, zzind zzindVar) {
        return new zzgjj(zzgjiVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgfr zzgfrVarZza = ((zzgjm) this.zza.zzb()).zza().zza();
        zzinc.zzb(zzgfrVarZza);
        return zzgfrVarZza;
    }
}
