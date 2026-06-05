package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzehc implements zzhbe {
    static final /* synthetic */ zzehc zza = new zzehc();

    private /* synthetic */ zzehc() {
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        Throwable cause = (ExecutionException) obj;
        if (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return zzhbw.zzc(cause);
    }
}
