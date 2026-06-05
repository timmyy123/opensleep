package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class zzus implements zzth {
    final /* synthetic */ zzut zza;

    public /* synthetic */ zzus(zzut zzutVar, byte[] bArr) {
        Objects.requireNonNull(zzutVar);
        this.zza = zzutVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzth
    public final ListenableFuture zza(final AsyncFunction asyncFunction, final Executor executor) {
        return zzuy.zza(Futures.transformAsync(Futures.nonCancellationPropagating(this.zza.zzg().zza()), zzxa.zzc(new AsyncFunction() { // from class: com.google.android.gms.internal.measurement.zzur
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.zza.zza.zzf().zzb(asyncFunction, executor, null);
            }
        }), MoreExecutors.directExecutor()));
    }
}
