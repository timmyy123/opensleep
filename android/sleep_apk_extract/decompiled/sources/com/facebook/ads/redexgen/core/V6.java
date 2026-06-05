package com.facebook.ads.redexgen.core;

import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class V6 {
    public double A00;
    public VC A01;
    public VD A02;
    public String A03;
    public String A04;
    public Map<String, String> A05;
    public boolean A06;

    public final V6 A00(double d) {
        this.A00 = d;
        return this;
    }

    public final V6 A01(VC vc) {
        this.A01 = vc;
        return this;
    }

    public final V6 A02(VD vd) {
        this.A02 = vd;
        return this;
    }

    public final V6 A03(String str) {
        this.A03 = str;
        return this;
    }

    public final V6 A04(String str) {
        this.A04 = str;
        return this;
    }

    public final V6 A05(Map<String, String> mData) {
        this.A05 = mData;
        return this;
    }

    public final V6 A06(boolean z) {
        this.A06 = z;
        return this;
    }

    public final V7 A07(T8 t8) {
        return new V7(t8, this.A04, this.A00, this.A03, this.A05, this.A01, this.A02, this.A06);
    }
}
