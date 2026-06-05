package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8V, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8V implements InterfaceC1745mF {
    public static byte[] A04;
    public final long A00;
    public final long A01;
    public final long[] A02;
    public final long[] A03;

    static {
        A02();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C8V A00(long j, long j2, HN hn, C02284v c02284v) {
        int iA0I;
        long j3 = j2;
        c02284v.A0g(10);
        int iA0C = c02284v.A0C();
        if (iA0C <= 0) {
            return null;
        }
        int i = hn.A03;
        long jA0U = C5C.A0U(iA0C, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, i);
        int iA0M = c02284v.A0M();
        int iA0M2 = c02284v.A0M();
        int iA0M3 = c02284v.A0M();
        c02284v.A0g(2);
        long j4 = j3 + ((long) hn.A02);
        long[] jArr = new long[iA0M];
        long[] jArr2 = new long[iA0M];
        for (int i2 = 0; i2 < iA0M; i2++) {
            jArr[i2] = (((long) i2) * jA0U) / ((long) iA0M);
            jArr2[i2] = Math.max(j3, j4);
            switch (iA0M3) {
                case 1:
                    iA0I = c02284v.A0I();
                    break;
                case 2:
                    iA0I = c02284v.A0M();
                    break;
                case 3:
                    iA0I = c02284v.A0K();
                    break;
                case 4:
                    iA0I = c02284v.A0L();
                    break;
                default:
                    return null;
            }
            j3 += ((long) iA0I) * ((long) iA0M2);
        }
        if (j != -1 && j != j3) {
            AbstractC02134g.A07(A01(27, 10, 89), A01(2, 25, 50) + j + A01(0, 2, 80) + j3);
        }
        return new C8V(jArr, jArr2, jA0U, j3);
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 43);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-89, -101, -77, -97, -81, -90, 125, -63, -66, -47, -66, 125, -48, -58, -41, -62, 125, -54, -58, -48, -54, -66, -47, -64, -59, -105, 125, -38, -26, -10, -19, -41, -23, -23, -17, -23, -10};
    }

    public C8V(long[] jArr, long[] jArr2, long j, long j2) {
        this.A03 = jArr;
        this.A02 = jArr2;
        this.A01 = j;
        this.A00 = j2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1745mF
    public final long A7j() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j) {
        int iA0L = C5C.A0L(this.A03, j, true, true);
        HZ hz = new HZ(this.A03[iA0L], this.A02[iA0L]);
        if (hz.A01 < j) {
            int tableIndex = this.A03.length;
            if (iA0L != tableIndex - 1) {
                int tableIndex2 = iA0L + 1;
                long j2 = this.A03[tableIndex2];
                int tableIndex3 = iA0L + 1;
                HZ nextSeekPoint = new HZ(j2, this.A02[tableIndex3]);
                return new HX(hz, nextSeekPoint);
            }
        }
        return new HX(hz);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1745mF
    public final long A9H(long j) {
        return this.A03[C5C.A0L(this.A02, j, true, true)];
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return true;
    }
}
