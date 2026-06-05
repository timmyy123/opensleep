package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbf implements zzth {
    private final zztk zza;
    private final zztk zzb;
    private final zztk zzc;
    private final zztk zzd;
    private final zztk zze;
    private final zztk zzf;
    private final zztk zzg;

    private zzbf(zztk zztkVar, zztk zztkVar2, zztk zztkVar3, zztk zztkVar4, zztk zztkVar5, zztk zztkVar6, zztk zztkVar7) {
        this.zza = zztkVar;
        this.zzb = zztkVar2;
        this.zzc = zztkVar3;
        this.zzd = zztkVar4;
        this.zze = zztkVar5;
        this.zzf = zztkVar6;
        this.zzg = zztkVar7;
    }

    public static zzbf zza(zztk zztkVar, zztk zztkVar2, zztk zztkVar3, zztk zztkVar4, zztk zztkVar5, zztk zztkVar6, zztk zztkVar7) {
        return new zzbf(zztkVar, zztkVar2, zztkVar3, zztkVar4, zztkVar5, zztkVar6, zztkVar7);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbe((Application) this.zza.zzb(), (zzad) this.zzb.zzb(), (zzbz) this.zzc.zzb(), (zzaq) this.zzd.zzb(), (zzbs) this.zze.zzb(), this.zzf, (zzcr) this.zzg.zzb());
    }
}
