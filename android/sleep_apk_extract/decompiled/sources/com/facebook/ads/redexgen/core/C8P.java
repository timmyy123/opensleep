package com.facebook.ads.redexgen.core;

import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class C8P extends AbstractC1901oz implements InterfaceC0585Jj {
    public long A00;
    public InterfaceC0585Jj A01;

    @Override // com.facebook.ads.redexgen.core.AbstractC1901oz
    public abstract void A0B();

    @Override // com.facebook.ads.redexgen.core.AbstractC02535u
    public final void A0A() {
        super.A0A();
        this.A01 = null;
    }

    public final void A0C(long j, InterfaceC0585Jj interfaceC0585Jj, long j2) {
        super.A01 = j;
        this.A01 = interfaceC0585Jj;
        if (j2 == Long.MAX_VALUE) {
            j2 = super.A01;
        }
        this.A00 = j2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final List<C1931pT> A7X(long j) {
        return ((InterfaceC0585Jj) AbstractC02053y.A01(this.A01)).A7X(j - this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final long A83(int i) {
        return ((InterfaceC0585Jj) AbstractC02053y.A01(this.A01)).A83(i) + this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final int A84() {
        return ((InterfaceC0585Jj) AbstractC02053y.A01(this.A01)).A84();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final int A8a(long j) {
        return ((InterfaceC0585Jj) AbstractC02053y.A01(this.A01)).A8a(j - this.A00);
    }
}
