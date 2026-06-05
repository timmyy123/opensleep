package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class RP {
    public RM A00 = new RM();
    public final RN A01;

    public RP(RN rn) {
        this.A01 = rn;
    }

    public final View A00(int i, int i2, int i3, int i4) {
        int iA8h = this.A01.A8h();
        int next = this.A01.A8g();
        int childEnd = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewA7H = this.A01.A7H(i);
            int iA7K = this.A01.A7K(viewA7H);
            int i5 = this.A01.A7J(viewA7H);
            this.A00.A03(iA8h, next, iA7K, i5);
            if (i3 != 0) {
                this.A00.A01();
                this.A00.A02(i3);
                if (this.A00.A04()) {
                    return viewA7H;
                }
            }
            if (i4 != 0) {
                this.A00.A01();
                this.A00.A02(i4);
                if (this.A00.A04()) {
                    view = viewA7H;
                }
            }
            i += childEnd;
        }
        return view;
    }
}
