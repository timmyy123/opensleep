package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class SX {
    public final long A00;
    public final SW A01;
    public final String A02;
    public final boolean A03;

    public SX(String str, boolean z, SW sw) {
        this(str, z, sw, System.currentTimeMillis());
    }

    public SX(String str, boolean z, SW sw, long j) {
        this.A02 = str;
        this.A03 = z;
        this.A01 = sw;
        this.A00 = j;
    }

    public static SX A00() {
        return new SX("", true, SW.A05, -1L);
    }

    public final long A01() {
        return this.A00;
    }

    public final SW A02() {
        return this.A01;
    }

    public final String A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A03;
    }
}
