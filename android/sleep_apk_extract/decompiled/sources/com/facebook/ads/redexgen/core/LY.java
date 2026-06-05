package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class LY {
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public boolean A04;

    public final LY A00(int i) {
        this.A00 = i;
        return this;
    }

    public final LY A01(int i) {
        this.A01 = i;
        return this;
    }

    public final LY A02(boolean z) {
        this.A02 = z;
        return this;
    }

    public final LY A03(boolean z) {
        this.A03 = z;
        return this;
    }

    public final LY A04(boolean z) {
        this.A04 = z;
        return this;
    }

    public final LZ A05() {
        return new LZ(this.A00, this.A02, this.A01, this.A03, this.A04);
    }
}
