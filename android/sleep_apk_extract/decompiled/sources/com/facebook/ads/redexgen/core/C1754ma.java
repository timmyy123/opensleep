package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ma, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1754ma extends AbstractC0545Hu {
    public static byte[] A06;
    public static String[] A07 = {"k0wYTkKie1JHeFYg", "DKl7H6qsoN4MQmGVFxhVfc9YoKR", "eOp5RF4DxMr8YboQGZKTl4GQk1b", "2gSlciuhxyUpZq2z", "EzoVAngWIMXE2t797gVmsxYwwugMTqE8", "YSwU3mnkrzPmwh4w8hA9Gpc9iPzLacTq", "wmfh6", "T9R7fvqNl5WyvyD6SUGUJNeU84vDYmq7"};
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final C02284v A04;
    public final C02284v A05;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{68, 123, 118, 119, 125, 50, 116, 125, 96, 127, 115, 102, 50, 124, 125, 102, 50, 97, 103, 98, 98, 125, 96, 102, 119, 118, 40, 50, 43, 52, 57, 56, 50, 114, 60, 43, 62};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.AbstractC0545Hu
    public final boolean A0C(C02284v c02284v, long j) throws C3K {
        int iA0I = c02284v.A0I();
        long jA0D = j + (((long) c02284v.A0D()) * 1000);
        if (iA0I == 0 && !this.A02) {
            C02284v c02284v2 = new C02284v(new byte[c02284v.A07()]);
            c02284v.A0k(c02284v2.A0l(), 0, c02284v.A07());
            C0520Gv c0520GvA00 = C0520Gv.A00(c02284v2);
            this.A01 = c0520GvA00.A02;
            super.A00.A6e(new C01722p().A11(A00(28, 9, 29)).A0w(c0520GvA00.A04).A0r(c0520GvA00.A03).A0f(c0520GvA00.A01).A0Y(c0520GvA00.A00).A12(c0520GvA00.A05).A14());
            this.A02 = true;
            return false;
        }
        if (iA0I != 1 || !this.A02) {
            return false;
        }
        int i = this.A00;
        if (A07[1].length() != 27) {
            throw new RuntimeException();
        }
        A07[5] = "ywa4QqUhdtSZ68DIQ13xWUOznnvwilgI";
        boolean z = i == 1;
        if (A07[2].length() == 28) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[6] = "IIAwH";
        strArr[0] = "qu1M6PwQ9kLePSP6";
        if (!this.A03 && !z) {
            return false;
        }
        byte[] bArrA0l = this.A04.A0l();
        bArrA0l[0] = 0;
        bArrA0l[1] = 0;
        bArrA0l[2] = 0;
        int i2 = 4 - this.A01;
        int i3 = 0;
        while (c02284v.A07() > 0) {
            c02284v.A0k(this.A04.A0l(), i2, this.A01);
            this.A04.A0f(0);
            int iA0L = this.A04.A0L();
            this.A05.A0f(0);
            super.A00.AIr(this.A05, 4);
            super.A00.AIr(c02284v, iA0L);
            i3 = i3 + 4 + iA0L;
        }
        super.A00.AIu(jA0D, z ? 1 : 0, i3, 0, null);
        this.A03 = true;
        return true;
    }

    static {
        A01();
    }

    public C1754ma(InterfaceC0528Hd interfaceC0528Hd) {
        super(interfaceC0528Hd);
        this.A05 = new C02284v(HS.A03);
        this.A04 = new C02284v(4);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0545Hu
    public final boolean A0B(C02284v c02284v) throws C1755mb {
        int iA0I = c02284v.A0I();
        int header = iA0I >> 4;
        int frameType = header & 15;
        int i = iA0I & 15;
        if (i == 7) {
            this.A00 = frameType;
            return frameType != 5;
        }
        throw new C1755mb(A00(0, 28, 82) + i);
    }
}
