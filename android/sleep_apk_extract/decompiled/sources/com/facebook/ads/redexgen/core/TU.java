package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class TU implements Runnable {
    public final /* synthetic */ RuntimeException A00;

    public TU(RuntimeException runtimeException) {
        this.A00 = runtimeException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        throw this.A00;
    }
}
