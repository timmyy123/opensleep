package com.facebook.ads.redexgen.core;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1730m0 implements JY {
    public static byte[] A0C;
    public static String[] A0D = {"jRj2ugi7SPR", "MNKsBNeD8MF1tCUmeU2P5Nj3hkdjoOc", "XMkmXaTlrOCX5lXmL6kh3TwHyWbdiNoj", "CqZnv6WT0ufq4g7hl2oSYE9w8", "bGEXSwT2dmCwLmvORXS7whQ8v", "55313totkqX4mBMXvHmYF6PzdsDv8MD", "C0ywJUyDCeWGQi9DxnjwsD3coqyGffR", "BhHq3twmKlbS1H4hpApJBSGHB"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public final long A08;
    public final long A09;
    public final JX A0A;
    public final AbstractC0577Jb A0B;

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0C = new byte[]{-68, -35, -114, -35, -43, -43, -114, -34, -49, -43, -45, -114, -47, -49, -36, -114, -48, -45, -114, -44, -35, -29, -36, -46, -100};
    }

    static {
        A08();
    }

    public C1730m0(AbstractC0577Jb abstractC0577Jb, long j, long j2, long j3, long j4, boolean z) {
        AbstractC02053y.A07(j >= 0 && j2 > j);
        this.A0B = abstractC0577Jb;
        this.A09 = j;
        this.A08 = j2;
        if (j3 == j2 - j || z) {
            this.A07 = j4;
            this.A00 = 4;
        } else {
            this.A00 = 0;
        }
        this.A0A = new JX();
    }

    private long A00(InterfaceC1772ms interfaceC1772ms) throws IOException {
        if (this.A04 == this.A01) {
            return -1L;
        }
        long jA8n = interfaceC1772ms.A8n();
        if (!this.A0A.A04(interfaceC1772ms, this.A01)) {
            if (this.A04 != jA8n) {
                return this.A04;
            }
            throw new IOException(A07(0, 25, 27));
        }
        this.A0A.A05(interfaceC1772ms, false);
        interfaceC1772ms.AIl();
        long currentPosition = this.A06 - this.A0A.A05;
        int i = this.A0A.A01 + this.A0A.A00;
        if (0 <= currentPosition && currentPosition < 72000) {
            return -1L;
        }
        if (currentPosition >= 0) {
            this.A04 = interfaceC1772ms.A8n() + ((long) i);
            this.A05 = this.A0A.A05;
        } else {
            this.A01 = jA8n;
            JX jx = this.A0A;
            String[] strArr = A0D;
            if (strArr[0].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[3] = "rTnMeKP9Ntef56gYj2I82A9Og";
            strArr2[7] = "Ns8cmH2a0bzEbJPPC1zDKlbsv";
            this.A02 = jx.A05;
        }
        if (this.A01 - this.A04 < 100000) {
            this.A01 = this.A04;
            return this.A04;
        }
        long offset = ((long) i) * (currentPosition <= 0 ? 2L : 1L);
        long jA8n2 = interfaceC1772ms.A8n() - offset;
        long offset2 = this.A01;
        return C5C.A0T(jA8n2 + (((offset2 - this.A04) * currentPosition) / (this.A02 - this.A05)), this.A04, this.A01 - 1);
    }

    private final long A01(InterfaceC1772ms interfaceC1772ms) throws IOException {
        this.A0A.A02();
        if (this.A0A.A03(interfaceC1772ms)) {
            this.A0A.A05(interfaceC1772ms, false);
            interfaceC1772ms.AK3(this.A0A.A01 + this.A0A.A00);
            JX jx = this.A0A;
            String[] strArr = A0D;
            if (strArr[0].length() != strArr[1].length()) {
                String[] strArr2 = A0D;
                strArr2[3] = "I2mhjjmoE8ZJ2Dg0LzbNmT9WC";
                strArr2[7] = "IEpLWq2gVTEx0SVSUh2piystZ";
                long j = jx.A05;
                while ((this.A0A.A04 & 4) != 4 && this.A0A.A03(interfaceC1772ms) && interfaceC1772ms.A8n() < this.A08) {
                    if (this.A0A.A05(interfaceC1772ms, true)) {
                        JX jx2 = this.A0A;
                        String[] strArr3 = A0D;
                        if (strArr3[6].length() == strArr3[5].length()) {
                            A0D[2] = "1J9QEDZvjIULKx6bD2w0xEMzJBfvilpU";
                            if (HB.A02(interfaceC1772ms, jx2.A01 + this.A0A.A00)) {
                                j = this.A0A.A05;
                            }
                        }
                    }
                    return j;
                }
                return j;
            }
            throw new RuntimeException();
        }
        throw new EOFException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.JY
    /* JADX INFO: renamed from: A05, reason: merged with bridge method [inline-methods] */
    public final C1731m1 A5Z() {
        JV jv = null;
        if (this.A07 != 0) {
            return new C1731m1(this);
        }
        return null;
    }

    private void A09(InterfaceC1772ms interfaceC1772ms) throws IOException {
        while (true) {
            this.A0A.A03(interfaceC1772ms);
            this.A0A.A05(interfaceC1772ms, false);
            if (this.A0A.A05 > this.A06) {
                interfaceC1772ms.AIl();
                return;
            } else {
                interfaceC1772ms.AK3(this.A0A.A01 + this.A0A.A00);
                this.A04 = interfaceC1772ms.A8n();
                this.A05 = this.A0A.A05;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.JY
    public final long AHN(InterfaceC1772ms interfaceC1772ms) throws IOException {
        switch (this.A00) {
            case 0:
                this.A03 = interfaceC1772ms.A8n();
                this.A00 = 1;
                long j = this.A08 - 65307;
                if (j > this.A03) {
                    return j;
                }
            case 1:
                long lastPageSearchPosition = A01(interfaceC1772ms);
                this.A07 = lastPageSearchPosition;
                String[] strArr = A0D;
                if (strArr[6].length() != strArr[5].length()) {
                    A0D[4] = "Q";
                    this.A00 = 4;
                    return this.A03;
                }
                A0D[2] = "zPL0M1I0YHefEI7ePcrxVR039vnXiGQX";
                this.A00 = 4;
                return this.A03;
            case 2:
                long position = A00(interfaceC1772ms);
                if (A0D[2].charAt(28) == 'i') {
                    A0D[4] = "EIP7mTXqLgr9aPVawFNgKKAemnhenv";
                    if (position != -1) {
                        return position;
                    }
                    this.A00 = 3;
                    break;
                } else {
                    throw new RuntimeException();
                }
            case 3:
                A09(interfaceC1772ms);
                this.A00 = 4;
                return -(this.A05 + 2);
            case 4:
                return -1L;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.facebook.ads.redexgen.core.JY
    public final void AKC(long j) {
        this.A06 = C5C.A0T(j, 0L, this.A07 - 1);
        this.A00 = 2;
        this.A04 = this.A09;
        this.A01 = this.A08;
        this.A05 = 0L;
        this.A02 = this.A07;
    }
}
