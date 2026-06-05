package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public interface zzhcg extends ExecutorService, AutoCloseable {
    ListenableFuture zza(Runnable runnable);

    ListenableFuture zzc(Callable callable);
}
