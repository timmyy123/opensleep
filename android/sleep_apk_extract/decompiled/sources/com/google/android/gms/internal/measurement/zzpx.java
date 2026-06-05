package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzpx {
    public static void zza(final ListenableFuture listenableFuture) {
        listenableFuture.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzpw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    Futures.getDone(listenableFuture);
                } catch (ExecutionException e) {
                    zzrn.zzb().post(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzpv
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            throw new RuntimeException(e.getCause());
                        }
                    });
                }
            }
        }, MoreExecutors.directExecutor());
    }
}
