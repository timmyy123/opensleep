package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
final class zzak implements zzaz {
    final zztk zza;
    final zztk zzb;
    final zztk zzc;
    final zztk zzd;
    final zztk zze;
    private final zzah zzf;

    public zzak(zzah zzahVar, zzbs zzbsVar) {
        this.zzf = zzahVar;
        zztk zztkVarZza = zztg.zza(zzca.zza(zzahVar.zza));
        this.zza = zztkVarZza;
        zzth zzthVarZza = zzti.zza(zzbsVar);
        this.zzb = zzthVarZza;
        zztf zztfVar = new zztf();
        this.zzc = zztfVar;
        zztk zztkVar = zzahVar.zza;
        zzav zzavVar = zzau.zza;
        zzax zzaxVar = zzaw.zza;
        zztk zztkVar2 = zzahVar.zzg;
        zztk zztkVar3 = zzahVar.zzj;
        zztk zztkVar4 = zzahVar.zzb;
        zzce zzceVarZzc = zzce.zzc(zztkVar, zztkVarZza, zzavVar, zzaxVar, zztkVar2, zztkVar3, zztfVar, zztkVar4);
        this.zzd = zzceVarZzc;
        zzby zzbyVarZzc = zzby.zzc(zztkVarZza, zzavVar, zzceVarZzc);
        this.zze = zzbyVarZzc;
        zztf.zza(zztfVar, zztg.zza(zzbf.zza(zztkVar, zzahVar.zzc, zztkVarZza, zztkVar4, zzthVarZza, zzbyVarZzc, zzahVar.zzl)));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzaz
    public final zzbe zza() {
        return (zzbe) this.zzc.zzb();
    }
}
