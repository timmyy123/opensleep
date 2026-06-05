package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.do, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class Cdo {
    public String A02;
    public String A03;
    public String A04;
    public final NY A06;
    public final C0691Nm A07;
    public final C1421gi A08;
    public C0679Na A01 = C0679Na.A01(null);
    public int A00 = 1000;
    public boolean A05 = false;

    public Cdo(C1421gi c1421gi, NY ny, C0691Nm c0691Nm) {
        this.A08 = c1421gi;
        this.A06 = ny;
        this.A07 = c0691Nm;
    }

    public final Cdo A09(int i) {
        this.A00 = i;
        return this;
    }

    public final Cdo A0A(C0679Na c0679Na) {
        this.A01 = c0679Na;
        return this;
    }

    public final Cdo A0B(String str) {
        this.A04 = str;
        return this;
    }

    public final Cdo A0C(String str) {
        this.A02 = str;
        return this;
    }

    public final Cdo A0D(String str) {
        this.A03 = str;
        return this;
    }

    public final Cdo A0E(boolean z) {
        this.A05 = z;
        return this;
    }

    public final C1244dq A0F() {
        return new C1244dq(this, null);
    }
}
