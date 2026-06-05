package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcp implements zzth {
    private final zztk zza;

    private zzcp(zztk zztkVar) {
        this.zza = zztkVar;
    }

    public static zzcp zza(zztk zztkVar) {
        return new zzcp(zztkVar);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zztm
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzco((Application) this.zza.zzb());
    }
}
