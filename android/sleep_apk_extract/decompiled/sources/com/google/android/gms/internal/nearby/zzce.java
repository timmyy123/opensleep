package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
final class zzce extends zzfr {
    private final BaseImplementation$ResultHolder zza;

    public zzce(BaseImplementation$ResultHolder baseImplementation$ResultHolder) {
        this.zza = (BaseImplementation$ResultHolder) Preconditions.checkNotNull(baseImplementation$ResultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzfs
    public final void zzb(int i) {
        Status statusZzG = zzch.zzG(i);
        boolean zIsSuccess = statusZzG.isSuccess();
        BaseImplementation$ResultHolder baseImplementation$ResultHolder = this.zza;
        if (zIsSuccess) {
            baseImplementation$ResultHolder.setResult(statusZzG);
        } else {
            baseImplementation$ResultHolder.setFailedResult(statusZzG);
        }
    }
}
