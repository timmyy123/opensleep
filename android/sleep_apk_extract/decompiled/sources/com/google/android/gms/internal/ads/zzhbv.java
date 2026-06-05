package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhbv {
    private final boolean zza;
    private final zzgwm zzb;

    public /* synthetic */ zzhbv(boolean z, zzgwm zzgwmVar, byte[] bArr) {
        this.zza = z;
        this.zzb = zzgwmVar;
    }

    public final ListenableFuture zza(Callable callable, Executor executor) {
        return new zzhbk(this.zzb, this.zza, executor, callable);
    }
}
