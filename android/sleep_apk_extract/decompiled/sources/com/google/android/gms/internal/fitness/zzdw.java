package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdw extends zzby {
    private final BaseImplementation$ResultHolder zza;

    public zzdw(BaseImplementation$ResultHolder baseImplementation$ResultHolder) {
        this.zza = baseImplementation$ResultHolder;
    }

    @Override // com.google.android.gms.internal.fitness.zzbz
    public final void zzb(Status status) {
        this.zza.setResult(status);
    }
}
