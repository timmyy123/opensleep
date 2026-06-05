package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C03489y extends AbstractC1866oQ {
    public static String[] A0C = {"kTOKNBh1Wp6avXYwKxrfNqHQCe6IowZb", "fsh7jTNUZTGCSew0VT63IO4tkQUYppyQ", "CGsUWOpaOXfE7pNtsFBesiWCOQ75lYHg", "3QzqyUj5HYGt0uXrFXWs5fdma44AOfyL", "C3DxIlHWWAPwLuHgY8W8WEDh6NP", "cCeo7h1kMT8v6dcJbz1RM5PEEOyjnS1I", "8Ip3ivaO", "u5WK46JzMVMnhOVxX0VDjJ353j7WObAc"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public boolean A05;
    public boolean A06;
    public byte[] A07;
    public byte[] A08;
    public final long A09;
    public final long A0A;
    public final short A0B;

    public C03489y() {
        this(150000L, 20000L, (short) 1024);
    }

    public C03489y(long j, long j2, short s) {
        AbstractC02053y.A07(j2 <= j);
        this.A09 = j;
        this.A0A = j2;
        this.A0B = s;
        this.A07 = C5C.A07;
        this.A08 = C5C.A07;
    }

    private int A00(long j) {
        return (int) ((((long) super.A05.A03) * j) / 1000000);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int A01(ByteBuffer byteBuffer) {
        for (int iLimit = byteBuffer.limit() - 2; iLimit >= i; iLimit -= 2) {
            int i = byteBuffer.getShort(iLimit);
            int iAbs = Math.abs(i);
            int i2 = this.A0B;
            if (iAbs > i2) {
                int i3 = this.A00;
                int i4 = this.A00;
                int i5 = i3 * (iLimit / i4);
                int i6 = this.A00;
                return i5 + i6;
            }
        }
        int i7 = byteBuffer.position();
        return i7;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int A02(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < i; iPosition += 2) {
            int i = byteBuffer.getShort(iPosition);
            int iAbs = Math.abs(i);
            int i2 = this.A0B;
            if (iAbs > i2) {
                int i3 = this.A00;
                int i4 = this.A00;
                return i3 * (iPosition / i4);
            }
        }
        int i5 = byteBuffer.limit();
        return i5;
    }

    private void A03(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        A00(iRemaining).put(byteBuffer).flip();
        if (iRemaining > 0) {
            this.A06 = true;
        }
    }

    private void A04(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int maybeSilenceBufferRemaining = A02(byteBuffer);
        int limit = byteBuffer.position();
        int maybeSilenceInputSize = maybeSilenceBufferRemaining - limit;
        int noisePosition = this.A07.length;
        int limit2 = this.A01;
        int noisePosition2 = noisePosition - limit2;
        if (maybeSilenceBufferRemaining < iLimit && maybeSilenceInputSize < noisePosition2) {
            byte[] bArr = this.A07;
            int maybeSilenceBufferRemaining2 = this.A01;
            int noisePosition3 = A0C[4].length();
            if (noisePosition3 == 0) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[2] = "id1mOky4Zsioh8kkFhZ0Iqg9uH7l7sht";
            strArr[7] = "uHcgX8Q5LBy4SketH3HUZ8MVXP73GzFI";
            A08(bArr, maybeSilenceBufferRemaining2);
            this.A01 = 0;
            this.A03 = 0;
            return;
        }
        int maybeSilenceInputSize2 = Math.min(maybeSilenceInputSize, noisePosition2);
        int limit3 = byteBuffer.position();
        byteBuffer.limit(limit3 + maybeSilenceInputSize2);
        byte[] bArr2 = this.A07;
        int limit4 = this.A01;
        byteBuffer.get(bArr2, limit4, maybeSilenceInputSize2);
        int limit5 = this.A01;
        this.A01 = limit5 + maybeSilenceInputSize2;
        int noisePosition4 = this.A01;
        int limit6 = this.A07.length;
        if (noisePosition4 == limit6) {
            if (this.A06) {
                byte[] bArr3 = this.A07;
                int limit7 = this.A02;
                A08(bArr3, limit7);
                long j = this.A04;
                int noisePosition5 = this.A01;
                int limit8 = this.A02;
                int noisePosition6 = noisePosition5 - (limit8 * 2);
                int limit9 = this.A00;
                this.A04 = j + ((long) (noisePosition6 / limit9));
            } else {
                long j2 = this.A04;
                int noisePosition7 = this.A01;
                int limit10 = this.A02;
                int noisePosition8 = noisePosition7 - limit10;
                int limit11 = this.A00;
                this.A04 = j2 + ((long) (noisePosition8 / limit11));
            }
            byte[] bArr4 = this.A07;
            int limit12 = this.A01;
            A07(byteBuffer, bArr4, limit12);
            this.A01 = 0;
            this.A03 = 2;
        }
        byteBuffer.limit(iLimit);
    }

    private void A05(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int limit = this.A07.length;
        byteBuffer.limit(Math.min(iLimit, iPosition + limit));
        int noiseLimit = A01(byteBuffer);
        int limit2 = byteBuffer.position();
        if (noiseLimit == limit2) {
            this.A03 = 1;
        } else {
            byteBuffer.limit(noiseLimit);
            A03(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    private void A06(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iA02 = A02(byteBuffer);
        byteBuffer.limit(iA02);
        long j = this.A04;
        int noisyPosition = byteBuffer.remaining();
        int limit = this.A00;
        this.A04 = j + ((long) (noisyPosition / limit));
        byte[] bArr = this.A08;
        int limit2 = this.A02;
        A07(byteBuffer, bArr, limit2);
        if (iA02 < iLimit) {
            byte[] bArr2 = this.A08;
            int limit3 = this.A02;
            A08(bArr2, limit3);
            this.A03 = 0;
            byteBuffer.limit(iLimit);
        }
    }

    private void A07(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int iMin = Math.min(byteBuffer.remaining(), this.A02);
        int i2 = this.A02 - iMin;
        System.arraycopy(bArr, i - i2, this.A08, 0, i2);
        int fromInputSize = byteBuffer.limit();
        byteBuffer.position(fromInputSize - iMin);
        byteBuffer.get(this.A08, i2, iMin);
    }

    private void A08(byte[] bArr, int i) {
        A00(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.A06 = true;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1866oQ
    public final C01893i A09(C01893i c01893i) throws C01903j {
        if (c01893i.A02 == 2) {
            return this.A05 ? c01893i : C01893i.A05;
        }
        throw new C01903j(c01893i);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1866oQ
    public final void A0A() {
        if (this.A05) {
            this.A00 = super.A05.A00;
            int iA00 = A00(this.A09) * this.A00;
            int maybeSilenceBufferSize = this.A07.length;
            if (maybeSilenceBufferSize != iA00) {
                this.A07 = new byte[iA00];
            }
            int iA002 = A00(this.A0A);
            int maybeSilenceBufferSize2 = this.A00;
            this.A02 = iA002 * maybeSilenceBufferSize2;
            int length = this.A08.length;
            int maybeSilenceBufferSize3 = this.A02;
            if (length != maybeSilenceBufferSize3) {
                int maybeSilenceBufferSize4 = this.A02;
                this.A08 = new byte[maybeSilenceBufferSize4];
            }
        }
        this.A03 = 0;
        this.A04 = 0L;
        this.A01 = 0;
        this.A06 = false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1866oQ
    public final void A0B() {
        if (this.A01 > 0) {
            A08(this.A07, this.A01);
        }
        boolean z = this.A06;
        if (A0C[0].charAt(10) == 'o') {
            throw new RuntimeException();
        }
        A0C[3] = "3PybTV2kdzhjV0AdFBUr0i874h0Ge15Q";
        if (!z) {
            this.A04 += (long) (this.A02 / this.A00);
        }
    }

    public final long A0C() {
        return this.A04;
    }

    public final void A0D(boolean z) {
        this.A05 = z;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1866oQ, com.facebook.ads.redexgen.core.InterfaceC01913k
    public final boolean AAL() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC01913k
    public final void AHH(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !A01()) {
            switch (this.A03) {
                case 0:
                    A05(byteBuffer);
                    break;
                case 1:
                    A04(byteBuffer);
                    break;
                case 2:
                    A06(byteBuffer);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }
}
