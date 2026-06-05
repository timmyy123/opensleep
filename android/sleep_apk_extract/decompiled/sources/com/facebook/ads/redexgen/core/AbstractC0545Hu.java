package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0545Hu {
    public final InterfaceC0528Hd A00;

    public abstract boolean A0B(C02284v c02284v) throws C3K;

    public abstract boolean A0C(C02284v c02284v, long j) throws C3K;

    public AbstractC0545Hu(InterfaceC0528Hd interfaceC0528Hd) {
        this.A00 = interfaceC0528Hd;
    }

    public final boolean A00(C02284v c02284v, long j) throws C3K {
        return A0B(c02284v) && A0C(c02284v, j);
    }
}
