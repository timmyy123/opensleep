package com.facebook.ads.redexgen.core;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class DL {
    public static String[] A07 = {"1TUPUvqjuckMieKxy618dXqeho2I2nXO", "1tw", "Rv8BHxt03y9lIrpcW4kHhbfWsqmFKBVK", "r8Px", "D2vXeeTjlCXB4Odv", "hN", "uuD40", "TpLNmCJV5wG1YwTXf3toM93vl9iWeWk7"};
    public long A00;
    public C1823ni A01;
    public C1823ni A02;
    public C1823ni A03;
    public final int A04;
    public final C02284v A05 = new C02284v(32);
    public final F0 A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1823ni A04(C1823ni c1823ni, C1902p0 c1902p0, DN dn, C02284v c02284v) {
        int iA0M;
        long j = dn.A01;
        c02284v.A0d(1);
        C1823ni c1823niA03 = A03(c1823ni, j, c02284v.A0l(), 1);
        long j2 = j + 1;
        byte b = c02284v.A0l()[0];
        boolean z = (b & 128) != 0;
        int i = b & 127;
        C02585z c02585z = c1902p0.A05;
        if (c02585z.A04 == null) {
            c02585z.A04 = new byte[16];
        } else {
            Arrays.fill(c02585z.A04, (byte) 0);
        }
        C1823ni c1823niA032 = A03(c1823niA03, j2, c02585z.A04, i);
        long j3 = j2 + ((long) i);
        if (z) {
            c02284v.A0d(2);
            c1823niA032 = A03(c1823niA032, j3, c02284v.A0l(), 2);
            j3 += 2;
            iA0M = c02284v.A0M();
        } else {
            iA0M = 1;
            if (A07[7].charAt(5) == 'i') {
                throw new RuntimeException();
            }
            A07[7] = "Hpyz1f8ALnZx1iP9R6alck8MxH3P54oK";
        }
        int[] iArr = c02585z.A06;
        if (iArr == null || iArr.length < iA0M) {
            iArr = new int[iA0M];
        }
        int[] iArr2 = c02585z.A07;
        if (iArr2 == null || iArr2.length < iA0M) {
            iArr2 = new int[iA0M];
        }
        if (z) {
            int i2 = iA0M * 6;
            c02284v.A0d(i2);
            c1823niA032 = A03(c1823niA032, j3, c02284v.A0l(), i2);
            j3 += (long) i2;
            c02284v.A0f(0);
            for (int i3 = 0; i3 < iA0M; i3++) {
                iArr[i3] = c02284v.A0M();
                iArr2[i3] = c02284v.A0L();
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = dn.A00 - ((int) (j3 - dn.A01));
        }
        C0526Hb c0526Hb = (C0526Hb) C5C.A0f(dn.A02);
        c02585z.A02(iA0M, iArr, iArr2, c0526Hb.A03, c02585z.A04, c0526Hb.A01, c0526Hb.A02, c0526Hb.A00);
        int i4 = (int) (j3 - dn.A01);
        dn.A01 += (long) i4;
        if (A07[0].charAt(1) == 'T') {
            A07[0] = "nTpP9ibfF3cbwjVbkTA4UIhNPpZui5fl";
            dn.A00 -= i4;
            return c1823niA032;
        }
        String[] strArr = A07;
        strArr[3] = "b8i1";
        strArr[6] = "bRWrT";
        dn.A00 -= i4;
        return c1823niA032;
    }

    public DL(F0 f0) {
        this.A06 = f0;
        this.A04 = f0.A8I();
        this.A01 = new C1823ni(0L, this.A04);
        this.A02 = this.A01;
        this.A03 = this.A01;
    }

    private int A00(int i) {
        if (this.A03.A03 == null) {
            this.A03.A03(this.A06.A49(), new C1823ni(this.A03.A00, this.A04));
        }
        return Math.min(i, (int) (this.A03.A00 - this.A00));
    }

    public static C1823ni A01(C1823ni c1823ni, long j) {
        while (j >= c1823ni.A00) {
            c1823ni = c1823ni.A02;
        }
        return c1823ni;
    }

    public static C1823ni A02(C1823ni c1823ni, long j, ByteBuffer byteBuffer, int i) {
        C1823ni c1823niA01 = A01(c1823ni, j);
        while (i > 0) {
            int remaining = (int) (c1823niA01.A00 - j);
            int iMin = Math.min(i, remaining);
            byte[] bArr = c1823niA01.A03.A01;
            int remaining2 = c1823niA01.A00(j);
            byteBuffer.put(bArr, remaining2, iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == c1823niA01.A00) {
                c1823niA01 = c1823niA01.A02;
            }
        }
        return c1823niA01;
    }

    public static C1823ni A03(C1823ni c1823ni, long j, byte[] bArr, int i) {
        C1823ni c1823niA01 = A01(c1823ni, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (c1823niA01.A00 - j));
            byte[] bArr2 = c1823niA01.A03.A01;
            int toCopy = c1823niA01.A00(j);
            int remaining = i - i2;
            System.arraycopy(bArr2, toCopy, bArr, remaining, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == c1823niA01.A00) {
                c1823niA01 = c1823niA01.A02;
            }
        }
        return c1823niA01;
    }

    public static C1823ni A05(C1823ni c1823ni, C1902p0 c1902p0, DN dn, C02284v c02284v) {
        if (c1902p0.A0E()) {
            c1823ni = A04(c1823ni, c1902p0, dn, c02284v);
        }
        if (c1902p0.A03()) {
            c02284v.A0d(4);
            C1823ni c1823niA03 = A03(c1823ni, dn.A01, c02284v.A0l(), 4);
            int iA0L = c02284v.A0L();
            dn.A01 += 4;
            dn.A00 -= 4;
            c1902p0.A0C(iA0L);
            C1823ni c1823niA02 = A02(c1823niA03, dn.A01, c1902p0.A02, iA0L);
            dn.A01 += (long) iA0L;
            dn.A00 -= iA0L;
            c1902p0.A0D(dn.A00);
            return A02(c1823niA02, dn.A01, c1902p0.A03, dn.A00);
        }
        c1902p0.A0C(dn.A00);
        return A02(c1823ni, dn.A01, c1902p0.A02, dn.A00);
    }

    private void A06(int i) {
        this.A00 += (long) i;
        if (this.A00 == this.A03.A00) {
            this.A03 = this.A03.A02;
        }
    }

    private void A07(C1823ni c1823ni) {
        if (c1823ni.A03 == null) {
            return;
        }
        this.A06.AHe(c1823ni);
        c1823ni.A01();
    }

    public final int A08(InterfaceC01612c interfaceC01612c, int i, boolean z) throws IOException {
        int i2 = interfaceC01612c.read(this.A03.A03.A01, this.A03.A00(this.A00), A00(i));
        if (i2 == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        A06(i2);
        return i2;
    }

    public final long A09() {
        return this.A00;
    }

    public final void A0A() {
        A07(this.A01);
        this.A01.A02(0L, this.A04);
        this.A02 = this.A01;
        this.A03 = this.A01;
        this.A00 = 0L;
        this.A06.AKT();
    }

    public final void A0B() {
        this.A02 = this.A01;
    }

    public final void A0C(long j) {
        if (j == -1) {
            return;
        }
        while (j >= this.A01.A00) {
            this.A06.AHd(this.A01.A03);
            this.A01 = this.A01.A01();
        }
        long j2 = this.A02.A01;
        long j3 = this.A01.A01;
        String[] strArr = A07;
        if (strArr[3].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[3] = "kTcq";
        strArr2[6] = "Dj6YZ";
        if (j2 < j3) {
            this.A02 = this.A01;
        }
    }

    public final void A0D(C02284v c02284v, int i) {
        while (i > 0) {
            int iA00 = A00(i);
            byte[] bArr = this.A03.A03.A01;
            int bytesAppended = this.A03.A00(this.A00);
            c02284v.A0k(bArr, bytesAppended, iA00);
            i -= iA00;
            A06(iA00);
        }
    }

    public final void A0E(C1902p0 c1902p0, DN dn) {
        A05(this.A02, c1902p0, dn, this.A05);
    }

    public final void A0F(C1902p0 c1902p0, DN dn) {
        this.A02 = A05(this.A02, c1902p0, dn, this.A05);
    }
}
