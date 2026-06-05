package com.google.android.gms.internal.consent_sdk;

import com.google.home.Home$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zztf implements zzth {
    private zztk zza;

    public static void zza(zztk zztkVar, zztk zztkVar2) {
        zztf zztfVar = (zztf) zztkVar;
        if (zztfVar.zza == null) {
            zztfVar.zza = zztkVar2;
        } else {
            Home$$ExternalSyntheticBUOutline0.m$2();
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm
    public final Object zzb() {
        zztk zztkVar = this.zza;
        if (zztkVar != null) {
            return zztkVar.zzb();
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
        return null;
    }
}
