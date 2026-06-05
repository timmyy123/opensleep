package com.facebook.ads.redexgen.core;

import java.io.Serializable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ns, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0697Ns implements Serializable {
    public static final long serialVersionUID = 42;
    public final int A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final String A04;
    public final String A05;
    public final String A06;
    public final String A07;
    public final String A08;
    public final String A09;

    public C0697Ns(C0696Nr c0696Nr) {
        this.A06 = c0696Nr.A06;
        this.A09 = c0696Nr.A09;
        this.A08 = c0696Nr.A08;
        this.A07 = c0696Nr.A07;
        this.A04 = c0696Nr.A04;
        this.A03 = c0696Nr.A03;
        this.A05 = c0696Nr.A05;
        this.A00 = c0696Nr.A00;
        this.A02 = c0696Nr.A02;
        this.A01 = c0696Nr.A01;
    }

    public final int A00() {
        return this.A00;
    }

    public final String A01() {
        return this.A01;
    }

    public final String A02() {
        return this.A02;
    }

    public final String A03() {
        return this.A03 != null ? this.A03 : "";
    }

    public final String A04() {
        return this.A04 != null ? this.A04 : "";
    }

    public final String A05() {
        return this.A05;
    }

    public final String A06() {
        return this.A06;
    }

    public final String A07() {
        return this.A07 != null ? this.A07 : "";
    }

    public final String A08() {
        return this.A08 != null ? this.A08 : "";
    }
}
