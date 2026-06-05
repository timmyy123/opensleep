package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ke, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0606Ke implements InterfaceC1077b8 {
    public final WeakReference<C6M> A00;

    public C0606Ke(C6M c6m) {
        this.A00 = new WeakReference<>(c6m);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1077b8
    public final void AE7(C1076b7 c1076b7) {
        C6M c6m = this.A00.get();
        if (c6m != null) {
            c6m.A04 = c1076b7.A00() != null;
            c6m.A02();
        }
    }
}
