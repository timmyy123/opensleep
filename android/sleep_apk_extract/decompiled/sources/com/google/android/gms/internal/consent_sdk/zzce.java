package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public final class zzce implements zzth {
    private final zztk zza;
    private final zztk zzb;
    private final zztk zzc;
    private final zztk zzd;
    private final zztk zze;
    private final zztk zzf;

    private zzce(zztk zztkVar, zztk zztkVar2, zztk zztkVar3, zztk zztkVar4, zztk zztkVar5, zztk zztkVar6, zztk zztkVar7, zztk zztkVar8) {
        this.zza = zztkVar;
        this.zzb = zztkVar2;
        this.zzc = zztkVar5;
        this.zzd = zztkVar6;
        this.zze = zztkVar7;
        this.zzf = zztkVar8;
    }

    public static zzce zzc(zztk zztkVar, zztk zztkVar2, zztk zztkVar3, zztk zztkVar4, zztk zztkVar5, zztk zztkVar6, zztk zztkVar7, zztk zztkVar8) {
        return new zzce(zztkVar, zztkVar2, zztkVar3, zztkVar4, zztkVar5, zztkVar6, zztkVar7, zztkVar8);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcd zzb() {
        return new zzcd((Application) this.zza.zzb(), (zzbz) this.zzb.zzb(), zzav.zza(), zzax.zza(), (zze) this.zzc.zzb(), ((zzap) this.zzd).zzb(), (zzbe) this.zze.zzb(), (zzaq) this.zzf.zzb());
    }
}
