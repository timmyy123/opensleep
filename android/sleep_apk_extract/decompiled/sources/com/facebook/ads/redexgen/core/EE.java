package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class EE implements InterfaceC1306er {
    public final View A00;
    public final C1421gi A01;

    public EE(C1421gi c1421gi, View view) {
        this.A01 = c1421gi;
        this.A00 = view;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1306er
    public final double A9V() {
        C1367fq result = C1366fp.A0E(this.A00, 0, this.A01);
        return result.A00();
    }
}
