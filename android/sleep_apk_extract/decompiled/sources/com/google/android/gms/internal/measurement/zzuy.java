package com.google.android.gms.internal.measurement;

import com.google.common.base.Functions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzuy {
    public static ListenableFuture zza(ListenableFuture listenableFuture) {
        return Futures.transform(listenableFuture, Functions.constant(null), MoreExecutors.directExecutor());
    }
}
