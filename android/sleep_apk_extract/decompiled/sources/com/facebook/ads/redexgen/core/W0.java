package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class W0 implements VV {
    public WeakReference<UK> A00;

    public W0(UK uk) {
        this.A00 = new WeakReference<>(uk);
    }

    @Override // com.facebook.ads.redexgen.core.VV
    public final void AFB(boolean z) {
        if (this.A00.get() != null) {
            this.A00.get().A1o(z, false);
        }
    }
}
