package com.google.android.gms.internal.ads;

import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgsm {
    private final Mutex zza = MutexKt.Mutex$default(false, 1, null);

    public final Mutex zza() {
        return this.zza;
    }
}
