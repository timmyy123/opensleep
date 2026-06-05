package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.p8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1910p8 implements C5Y {
    public final InterfaceC02525t A00;

    public C1910p8() {
        this(null);
    }

    public C1910p8(InterfaceC02525t interfaceC02525t) {
        this.A00 = interfaceC02525t;
    }

    @Override // com.facebook.ads.redexgen.core.C5Y
    public final InterfaceC1917pF A5I() {
        C01421j c01421j = new C01421j();
        if (this.A00 != null) {
            c01421j.A43(this.A00);
        }
        return c01421j;
    }
}
