package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0521Gw {
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public final long A05;
    public final long A06;
    public final long A07;

    public C0521Gw(long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        this.A06 = j;
        this.A07 = j2;
        this.A03 = j3;
        this.A01 = j4;
        this.A02 = j5;
        this.A00 = j6;
        this.A05 = j7;
        this.A04 = A05(j2, j3, j4, j5, j6, j7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A00() {
        return this.A00;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A01() {
        return this.A02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A02() {
        return this.A04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A03() {
        return this.A06;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A04() {
        return this.A07;
    }

    public static long A05(long j, long j2, long j3, long bytesToSkip, long confidenceInterval, long j4) {
        if (bytesToSkip + 1 >= confidenceInterval || j2 + 1 >= j3) {
            return bytesToSkip;
        }
        long j5 = (long) ((j - j2) * ((confidenceInterval - bytesToSkip) / (j3 - j2)));
        return C5C.A0T(((bytesToSkip + j5) - j4) - (j5 / 20), bytesToSkip, confidenceInterval - 1);
    }

    private void A0B() {
        this.A04 = A05(this.A07, this.A03, this.A01, this.A02, this.A00, this.A05);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(long j, long j2) {
        this.A01 = j;
        this.A00 = j2;
        A0B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(long j, long j2) {
        this.A03 = j;
        this.A02 = j2;
        A0B();
    }
}
