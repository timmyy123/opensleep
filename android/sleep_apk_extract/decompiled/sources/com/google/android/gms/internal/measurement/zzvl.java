package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes3.dex */
final class zzvl extends AbstractFuture {
    private final int zza;

    public zzvl(int i) {
        this.zza = i;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final boolean setFuture(ListenableFuture listenableFuture) {
        return super.setFuture(listenableFuture);
    }

    public final /* synthetic */ int zza() {
        return this.zza;
    }
}
