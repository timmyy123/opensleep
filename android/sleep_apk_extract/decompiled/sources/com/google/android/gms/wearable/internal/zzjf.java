package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzjf extends zza {
    private BaseImplementation$ResultHolder zza;

    public zzjf(BaseImplementation$ResultHolder baseImplementation$ResultHolder) {
        this.zza = baseImplementation$ResultHolder;
    }

    public final void zzS(Object obj) {
        BaseImplementation$ResultHolder baseImplementation$ResultHolder = this.zza;
        if (baseImplementation$ResultHolder != null) {
            baseImplementation$ResultHolder.setResult(obj);
            this.zza = null;
        }
    }
}
