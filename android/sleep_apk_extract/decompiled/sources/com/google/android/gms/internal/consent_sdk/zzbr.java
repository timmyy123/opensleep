package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbr implements zzth {
    private final zztk zza;

    private zzbr(zztk zztkVar, zztk zztkVar2) {
        this.zza = zztkVar;
    }

    public static zzbr zza(zztk zztkVar, zztk zztkVar2) {
        return new zzbr(zztkVar, zztkVar2);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbq(this.zza, zzax.zza());
    }
}
