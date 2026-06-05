package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0776Qx {
    public int A00;
    public int A01;
    public int A02;
    public int A03;

    private final C0776Qx A00(RK rk, int i) {
        View view = rk.A0H;
        this.A01 = view.getLeft();
        this.A03 = view.getTop();
        this.A02 = view.getRight();
        this.A00 = view.getBottom();
        return this;
    }

    public final C0776Qx A01(RK rk) {
        return A00(rk, 0);
    }
}
