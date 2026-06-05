package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public final class zzar implements zzth {
    private final zztk zza;

    private zzar(zztk zztkVar) {
        this.zza = zztkVar;
    }

    public static zzar zza(zztk zztkVar) {
        return new zzar(zztkVar);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzaq((Application) this.zza.zzb());
    }
}
