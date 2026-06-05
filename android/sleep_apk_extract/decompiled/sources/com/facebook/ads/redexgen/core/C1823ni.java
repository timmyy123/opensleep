package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ni, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1823ni implements InterfaceC0473Ez {
    public long A00;
    public long A01;
    public C1823ni A02;
    public C0472Ey A03;

    public C1823ni(long j, int i) {
        A02(j, i);
    }

    public final int A00(long j) {
        return ((int) (j - this.A01)) + this.A03.A00;
    }

    public final C1823ni A01() {
        this.A03 = null;
        C1823ni c1823ni = this.A02;
        this.A02 = null;
        return c1823ni;
    }

    public final void A02(long j, int i) {
        AbstractC02053y.A08(this.A03 == null);
        this.A01 = j;
        this.A00 = ((long) i) + j;
    }

    public final void A03(C0472Ey c0472Ey, C1823ni c1823ni) {
        this.A03 = c0472Ey;
        this.A02 = c1823ni;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0473Ez
    public final C0472Ey A6u() {
        return (C0472Ey) AbstractC02053y.A01(this.A03);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0473Ez
    public final C1823ni ACc() {
        if (this.A02 == null || this.A02.A03 == null) {
            return null;
        }
        return this.A02;
    }
}
