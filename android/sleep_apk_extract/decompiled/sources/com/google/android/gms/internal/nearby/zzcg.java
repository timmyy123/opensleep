package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
final class zzcg extends zzfu {
    private final BaseImplementation$ResultHolder zza;

    public zzcg(BaseImplementation$ResultHolder baseImplementation$ResultHolder) {
        this.zza = (BaseImplementation$ResultHolder) Preconditions.checkNotNull(baseImplementation$ResultHolder);
    }

    @Override // com.google.android.gms.internal.nearby.zzfv
    public final void zzb(zzgv zzgvVar) {
        Status statusZzG = zzch.zzG(zzgvVar.zza());
        boolean zIsSuccess = statusZzG.isSuccess();
        BaseImplementation$ResultHolder baseImplementation$ResultHolder = this.zza;
        if (zIsSuccess) {
            baseImplementation$ResultHolder.setResult(new zzcf(statusZzG, zzgvVar.zzb()));
        } else {
            baseImplementation$ResultHolder.setFailedResult(statusZzG);
        }
    }
}
