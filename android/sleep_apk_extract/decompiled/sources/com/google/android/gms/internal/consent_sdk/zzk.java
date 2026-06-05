package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzk implements zzth {
    private final zztk zza;
    private final zztk zzb;
    private final zztk zzc;
    private final zztk zzd;

    private zzk(zztk zztkVar, zztk zztkVar2, zztk zztkVar3, zztk zztkVar4) {
        this.zza = zztkVar;
        this.zzb = zztkVar2;
        this.zzc = zztkVar3;
        this.zzd = zztkVar4;
    }

    public static zzk zza(zztk zztkVar, zztk zztkVar2, zztk zztkVar3, zztk zztkVar4) {
        return new zzk(zztkVar, zztkVar2, zztkVar3, zztkVar4);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzj((zzaq) this.zza.zzb(), ((zzx) this.zzb).zzb(), (zzbq) this.zzc.zzb(), (zzcr) this.zzd.zzb());
    }
}
