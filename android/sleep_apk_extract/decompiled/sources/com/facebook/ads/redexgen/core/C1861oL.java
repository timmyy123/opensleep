package com.facebook.ads.redexgen.core;

import java.math.RoundingMode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1861oL implements C9F {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;

    public C1861oL(C9Q c9q) {
        this.A02 = c9q.A02;
        this.A01 = c9q.A01;
        this.A05 = c9q.A05;
        this.A04 = c9q.A04;
        this.A03 = c9q.A03;
        this.A00 = c9q.A00;
    }

    public static int A00(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return 63750;
        }
    }

    private final int A01(int i) {
        int iA00 = A00(i);
        int maxByteRate = this.A03;
        return AbstractC0365As.A02((((long) maxByteRate) * ((long) iA00)) / 1000000);
    }

    private final int A02(int i, int i2) {
        int bufferSizeUs;
        int i3 = this.A04;
        if (i == 5) {
            int bufferSizeUs2 = this.A00;
            i3 *= bufferSizeUs2;
        }
        if (i2 != -1) {
            bufferSizeUs = AbstractC0746Pr.A00(i2, 8, RoundingMode.CEILING);
        } else {
            bufferSizeUs = A00(i);
        }
        return AbstractC0365As.A02((((long) i3) * ((long) bufferSizeUs)) / 1000000);
    }

    public static int A03(int i, int i2, int i3) {
        return AbstractC0365As.A02(((((long) i) * ((long) i2)) * ((long) i3)) / 1000000);
    }

    private final int A04(int i, int i2, int i3) {
        int maxAppBufferSize = this.A05 * i;
        int targetBufferSize = this.A02;
        int minAppBufferSize = A03(targetBufferSize, i2, i3);
        int targetBufferSize2 = this.A01;
        return C5C.A07(maxAppBufferSize, minAppBufferSize, A03(targetBufferSize2, i2, i3));
    }

    private final int A05(int i, int i2, int i3, int i4, int i5, int i6) {
        switch (i3) {
            case 0:
                return A04(i, i5, i4);
            case 1:
                return A01(i2);
            case 2:
                return A02(i2, i6);
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // com.facebook.ads.redexgen.core.C9F
    public final int A75(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        int bufferSize = A05(i, i2, i3, i4, i5, i6);
        return (((Math.max(i, (int) (((double) bufferSize) * d)) + i4) - 1) / i4) * i4;
    }
}
