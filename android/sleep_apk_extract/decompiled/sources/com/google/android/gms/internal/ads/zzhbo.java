package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhbo extends zzhbx {
    public static zzhbo zzw(ListenableFuture listenableFuture) {
        return listenableFuture instanceof zzhbo ? (zzhbo) listenableFuture : new zzhbp(listenableFuture);
    }
}
