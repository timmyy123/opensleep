package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class EC extends UL {
    public float A00;
    public long A01;
    public long A02;
    public long A03;

    public EC(long j, long j2, long j3, float f) {
        this.A03 = j;
        this.A01 = j2;
        this.A02 = j3;
        this.A00 = f;
    }

    public final float A00() {
        return this.A00;
    }

    public final long A01() {
        return this.A01;
    }

    public final long A02() {
        return this.A02;
    }

    public final long A03() {
        return this.A03;
    }
}
