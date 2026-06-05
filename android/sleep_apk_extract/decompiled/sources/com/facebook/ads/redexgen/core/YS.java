package com.facebook.ads.redexgen.core;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class YS {
    public static YS A02;
    public final C0744Pp A00;
    public final YU A01;

    public YS(C1421gi c1421gi, Executor executor, C0852Tw c0852Tw) {
        this.A01 = new YU(c1421gi);
        this.A00 = new C0744Pp(executor, c0852Tw, c1421gi);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(C1421gi c1421gi, Executor executor, C0852Tw c0852Tw) {
        if (!C0871Up.A1c(c1421gi)) {
            return;
        }
        if (A02 == null) {
            A02 = new YS(c1421gi, executor, c0852Tw);
            A02.A00();
        } else {
            A02.A02(c0852Tw);
        }
    }

    private void A02(C0852Tw c0852Tw) {
        this.A00.A07(c0852Tw);
    }
}
