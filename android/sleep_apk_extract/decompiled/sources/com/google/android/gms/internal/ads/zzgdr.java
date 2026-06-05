package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
final class zzgdr implements zzggj {
    final zzind zza;
    final zzind zzb;
    final zzind zzc;
    final zzind zzd;
    final zzind zze;
    private final zzgdl zzf;
    private final zzgdr zzg = this;

    public zzgdr(zzgdl zzgdlVar) {
        this.zzf = zzgdlVar;
        zzind zzindVarZza = zzimt.zza(zzggm.zza());
        this.zza = zzindVarZza;
        zzind zzindVarZza2 = zzimt.zza(zzghw.zza(zzgdlVar.zza, zzgdlVar.zzc, zzgdlVar.zzG, zzindVarZza, zzgdlVar.zzJ, zzgdlVar.zzu, zzgdlVar.zzj, zzghz.zza()));
        this.zzb = zzindVarZza2;
        zzind zzindVarZza3 = zzimt.zza(zzggr.zza());
        this.zzc = zzindVarZza3;
        zzgdq zzgdqVar = new zzgdq(this);
        this.zzd = zzgdqVar;
        this.zze = zzimt.zza(zzggk.zza(zzgdlVar.zzc, zzindVarZza2, zzgdlVar.zzG, zzgdlVar.zzF, zzindVarZza3, zzgdqVar, zzgdlVar.zzj));
    }

    @Override // com.google.android.gms.internal.ads.zzggj
    public final zzgfr zza() {
        return (zzgfr) this.zze.zzb();
    }

    public final /* synthetic */ zzgdl zzb() {
        return this.zzf;
    }

    public final /* synthetic */ zzgdr zzc() {
        return this.zzg;
    }
}
