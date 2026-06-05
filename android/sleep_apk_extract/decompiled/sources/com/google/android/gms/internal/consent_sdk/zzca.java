package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public final class zzca implements zzth {
    private final zztk zza;

    private zzca(zztk zztkVar) {
        this.zza = zztkVar;
    }

    public static zzca zza(zztk zztkVar) {
        return new zzca(zztkVar);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbz((Application) this.zza.zzb());
    }
}
