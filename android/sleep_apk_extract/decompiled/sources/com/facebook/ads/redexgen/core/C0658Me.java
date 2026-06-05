package com.facebook.ads.redexgen.core;

import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Me, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0658Me {
    public static String[] A0A = {"Zahrr4TzPnlvzL1ryUDBJHiLrNQrc0do", "gdtiLcJnOI63VIDKC4FZh", "mcKRdr7QIVfArpWMDov87T9yp6nn6XkX", "hh9PATM4XXQMpkTMp0yEe4VjsJayobMb", "DHsdxhl2jOmdOKqNSGjxb8rQV1nmB92A", "YMP8jok2HwiV", "9", "S"};
    public long A00;
    public long A01;
    public long A02;
    public final C02415i A03;
    public final MP A04;
    public final C8B A05;
    public final InterfaceC0657Md A06;
    public final String A07;
    public final byte[] A08;
    public volatile boolean A09;

    public C0658Me(C8B c8b, C02415i c02415i, byte[] bArr, InterfaceC0657Md interfaceC0657Md) {
        this.A05 = c8b;
        this.A04 = c8b.A0E();
        this.A03 = c02415i;
        this.A08 = bArr == null ? new byte[131072] : bArr;
        this.A06 = interfaceC0657Md;
        this.A07 = c8b.A0F().A4l(c02415i);
        this.A02 = c02415i.A04;
    }

    private long A00() {
        if (this.A01 == -1) {
            return -1L;
        }
        return this.A01 - this.A03.A04;
    }

    private long A01(long j, long j2) throws Throwable {
        boolean z = j + j2 == this.A01 || j2 == -1;
        long jAGi = -1;
        boolean z2 = false;
        if (j2 != -1) {
            try {
                jAGi = this.A05.AGi(this.A03.A04().A04(j).A03(j2).A09());
                z2 = true;
            } catch (IOException unused) {
                AbstractC02365d.A00(this.A05);
            }
        }
        if (!z2) {
            A02();
            try {
                jAGi = this.A05.AGi(this.A03.A04().A04(j).A03(-1L).A09());
            } catch (IOException e) {
                AbstractC02365d.A00(this.A05);
                throw e;
            }
        }
        int bytesRead = 0;
        if (A0A[3].charAt(20) != 'e') {
            throw new RuntimeException();
        }
        A0A[0] = "hZR9VwpKkwuUXqoAcu0MC0lnjZxabJfZ";
        if (z && jAGi != -1) {
            try {
                A04(j + jAGi);
            } catch (IOException e2) {
                AbstractC02365d.A00(this.A05);
                throw e2;
            }
        }
        int i = 0;
        while (i != -1) {
            A02();
            i = this.A05.read(this.A08, 0, this.A08.length);
            if (i != -1) {
                A03(i);
                bytesRead += i;
            }
        }
        if (z) {
            A04(((long) bytesRead) + j);
        }
        this.A05.close();
        long j3 = bytesRead;
        String[] strArr = A0A;
        if (strArr[5].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[5] = "HblyszVHSCLV";
        strArr2[7] = "g";
        return j3;
    }

    private void A02() throws InterruptedIOException {
        if (!this.A09) {
        } else {
            throw new InterruptedIOException();
        }
    }

    private void A03(long j) {
        this.A00 += j;
        if (this.A06 != null) {
            this.A06.AFX(A00(), this.A00, j);
        }
    }

    private void A04(long j) {
        if (this.A01 == j) {
            return;
        }
        this.A01 = j;
        if (this.A06 != null) {
            this.A06.AFX(A00(), this.A00, 0L);
        }
    }

    public final void A05() throws IOException {
        long nextRequestLength;
        A02();
        this.A00 = this.A04.A7B(this.A07, this.A03.A04, this.A03.A03);
        if (this.A03.A03 != -1) {
            this.A01 = this.A03.A04 + this.A03.A03;
        } else {
            long jA00 = AbstractC0663Mj.A00(this.A04.A7S(this.A07));
            if (A0A[3].charAt(20) == 'e') {
                String[] strArr = A0A;
                strArr[4] = "d2NeaqM7PiJwxNK1Ah3bQ5GZkUsby9uw";
                strArr[2] = "tLvOBlFvjcFhEySGIYecGT7qbHBlIMmD";
                if (jA00 == -1) {
                    jA00 = -1;
                }
                this.A01 = jA00;
            }
            throw new RuntimeException();
        }
        if (this.A06 != null) {
            this.A06.AFX(A00(), this.A00, 0L);
        }
        while (true) {
            long j = this.A01;
            if (A0A[6].length() == 13) {
                break;
            }
            A0A[1] = "NGuGGBYtFkRF3XmDWlB70";
            if (j == -1 || this.A02 < this.A01) {
                A02();
                if (this.A01 == -1) {
                    nextRequestLength = Long.MAX_VALUE;
                } else {
                    long nextRequestLength2 = this.A01;
                    long blockLength = this.A02;
                    nextRequestLength = nextRequestLength2 - blockLength;
                }
                long jA7C = this.A04.A7C(this.A07, this.A02, nextRequestLength);
                if (jA7C > 0) {
                    long blockLength2 = this.A02;
                    this.A02 = blockLength2 + jA7C;
                } else {
                    long nextRequestLength3 = -jA7C;
                    if (nextRequestLength3 == Long.MAX_VALUE) {
                        nextRequestLength3 = -1;
                    }
                    long j2 = this.A02;
                    long blockLength3 = this.A02;
                    this.A02 = j2 + A01(blockLength3, nextRequestLength3);
                }
            } else {
                return;
            }
        }
    }

    public final void A06() {
        this.A09 = true;
    }
}
