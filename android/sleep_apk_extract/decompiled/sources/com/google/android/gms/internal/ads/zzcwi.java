package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcwi implements zzimu {
    private final zzind zza;

    private zzcwi(zzcvs zzcvsVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcwi zza(zzcvs zzcvsVar, zzind zzindVar) {
        return new zzcwi(zzcvsVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        final zzdfs zzdfsVarZza = ((zzcxo) this.zza).zza();
        return new zzdkq(new zzdho() { // from class: com.google.android.gms.internal.ads.zzcvq
            @Override // com.google.android.gms.internal.ads.zzdho
            public final /* synthetic */ void zza() {
                zzdfsVarZza.zzc();
            }
        }, zzcfr.zzh);
    }
}
