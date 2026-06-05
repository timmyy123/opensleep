package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class LO {
    public final int A00;
    public final long A01;

    public LO(int i, long j) {
        this.A00 = i;
        this.A01 = j;
    }

    public static LO A00(InterfaceC1772ms interfaceC1772ms, C02284v c02284v) throws IOException {
        interfaceC1772ms.AGt(c02284v.A0l(), 0, 8);
        c02284v.A0f(0);
        int iA0C = c02284v.A0C();
        long size = c02284v.A0O();
        return new LO(iA0C, size);
    }
}
