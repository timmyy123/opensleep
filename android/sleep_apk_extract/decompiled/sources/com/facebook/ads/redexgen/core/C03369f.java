package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.internal.NativeProtocol;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9f, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C03369f implements InterfaceC1772ms {
    public static String[] A07 = {"YlHQuKLayYbpqzx9FSV6CQrLdQj96AeM", "S4RZcb4lBSGk97kEvSl91HaEV0P4", "uVSfNf", "Coq", "aQ2CxhcvUBulJYKynnVyQo", "flTysjHMhLtcJrzUbSTnFz15x2mZl", "8oFgaOvQgeQ1BxQlutu1jILF1QVjJ1FW", "wjWZdP"};
    public int A00;
    public int A01;
    public long A02;
    public byte[] A03;
    public final long A04;
    public final InterfaceC1917pF A05;
    public final byte[] A06;

    public C03369f(InterfaceC1917pF interfaceC1917pF, long j, long j2) {
        this(interfaceC1917pF, j, j2, false);
    }

    public C03369f(InterfaceC1917pF interfaceC1917pF, long j, long j2, boolean z) {
        this.A05 = interfaceC1917pF;
        this.A02 = j;
        this.A04 = j2;
        this.A03 = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
        this.A06 = new byte[4096];
    }

    private int A00(int i) {
        int bytesSkipped = Math.min(this.A00, i);
        A05(bytesSkipped);
        return bytesSkipped;
    }

    private int A01(byte[] bArr, int i, int i2) {
        if (this.A00 == 0) {
            return 0;
        }
        int iMin = Math.min(this.A00, i2);
        System.arraycopy(this.A03, 0, bArr, i, iMin);
        A05(iMin);
        return iMin;
    }

    private int A02(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (!Thread.interrupted()) {
            int i4 = this.A05.read(bArr, i + i3, i2 - i3);
            if (i4 == -1) {
                if (i3 == 0 && z) {
                    return -1;
                }
                throw new EOFException();
            }
            return i3 + i4;
        }
        throw new InterruptedIOException();
    }

    private void A03(int i) {
        if (i != -1) {
            this.A02 += (long) i;
        }
    }

    private void A04(int i) {
        int i2 = this.A01 + i;
        int requiredLength = this.A03.length;
        if (i2 > requiredLength) {
            int requiredLength2 = this.A03.length;
            int requiredLength3 = 524288 + i2;
            int newPeekCapacity = C5C.A07(requiredLength2 * 2, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i2, requiredLength3);
            this.A03 = Arrays.copyOf(this.A03, newPeekCapacity);
        }
    }

    private void A05(int i) {
        this.A00 -= i;
        this.A01 = 0;
        byte[] bArr = this.A03;
        if (this.A00 < this.A03.length - 524288) {
            bArr = new byte[this.A00 + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
        }
        byte[] bArr2 = this.A03;
        int i2 = this.A00;
        if (A07[3].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[7] = "U6HOVF";
        strArr[2] = "FLrwJS";
        System.arraycopy(bArr2, i, bArr, 0, i2);
        this.A03 = bArr;
    }

    public final boolean A06(int i, boolean z) throws IOException {
        int iA00 = A00(i);
        while (true) {
            String[] strArr = A07;
            String str = strArr[1];
            String str2 = strArr[5];
            int length = str.length();
            int bytesSkipped = str2.length();
            if (length == bytesSkipped) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[7] = "VT2oIT";
            strArr2[2] = "AHKvNZ";
            if (iA00 >= i || iA00 == -1) {
                break;
            }
            int bytesSkipped2 = this.A06.length;
            iA00 = A02(this.A06, -iA00, Math.min(i, bytesSkipped2 + iA00), iA00, z);
        }
        A03(iA00);
        return iA00 != -1;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final void A47(int i) throws IOException {
        A48(i, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
    
        throw new java.lang.RuntimeException();
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A48(int i, boolean z) throws IOException {
        A04(i);
        int iA02 = this.A00 - this.A01;
        while (true) {
            if (iA02 < i) {
                iA02 = A02(this.A03, this.A01, i, iA02, z);
                if (iA02 == -1) {
                    String[] strArr = A07;
                    String str = strArr[6];
                    String str2 = strArr[0];
                    int iCharAt = str.charAt(25);
                    int bytesPeeked = str2.charAt(25);
                    if (iCharAt == bytesPeeked) {
                        String[] strArr2 = A07;
                        strArr2[1] = "U9yRyStfgEDvt0OpJggQJXPRXL9S";
                        strArr2[5] = "yvkfr8ZSlHssIeYh6rwGG04GsxspU";
                        return false;
                    }
                } else {
                    int bytesPeeked2 = this.A01;
                    this.A00 = bytesPeeked2 + iA02;
                }
            } else {
                int bytesPeeked3 = this.A01;
                this.A01 = bytesPeeked3 + i;
                String[] strArr3 = A07;
                String str3 = strArr3[1];
                String str4 = strArr3[5];
                int length = str3.length();
                int bytesPeeked4 = str4.length();
                if (length != bytesPeeked4) {
                    A07[3] = "05c";
                    return true;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final long A8O() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final long A8i() {
        return this.A02 + ((long) this.A01);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final long A8n() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final Uri A9P() {
        return this.A05.A9P();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final int AGs(byte[] bArr, int i, int i2) throws IOException {
        int iMin;
        A04(i2);
        int bytesPeeked = this.A00 - this.A01;
        if (bytesPeeked == 0) {
            iMin = A02(this.A03, this.A01, i2, 0, true);
            if (iMin == -1) {
                return -1;
            }
            int peekBufferRemainingBytes = this.A00;
            this.A00 = peekBufferRemainingBytes + iMin;
        } else {
            iMin = Math.min(i2, bytesPeeked);
        }
        byte[] bArr2 = this.A03;
        int peekBufferRemainingBytes2 = this.A01;
        System.arraycopy(bArr2, peekBufferRemainingBytes2, bArr, i, iMin);
        int peekBufferRemainingBytes3 = this.A01;
        this.A01 = peekBufferRemainingBytes3 + iMin;
        return iMin;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final void AGt(byte[] bArr, int i, int i2) throws IOException {
        AGu(bArr, i, i2, false);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final boolean AGu(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (!A48(i2, z)) {
            return false;
        }
        System.arraycopy(this.A03, this.A01 - i2, bArr, i, i2);
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final boolean AHR(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int iA01 = A01(bArr, i, i2);
        while (iA01 < i2 && iA01 != -1) {
            iA01 = A02(bArr, i, i2, iA01, z);
        }
        A03(iA01);
        return iA01 != -1;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final void AIl() {
        this.A01 = 0;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final int AK0(int i) throws IOException {
        int iA00 = A00(i);
        if (iA00 == 0) {
            byte[] bArr = this.A06;
            int bytesSkipped = this.A06.length;
            iA00 = A02(bArr, 0, Math.min(i, bytesSkipped), 0, true);
        }
        A03(iA00);
        String[] strArr = A07;
        String str = strArr[7];
        String str2 = strArr[2];
        int length = str.length();
        int bytesSkipped2 = str2.length();
        if (length != bytesSkipped2) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[6] = "4muWdj2u5Q3eId9F7O7O9kyn7QS9F70y";
        strArr2[0] = "MQBZi4ACHP4vbg8D4iuKjBQaYQ9ASuUs";
        return iA00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final void AK3(int i) throws IOException {
        A06(i, false);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms, com.facebook.ads.redexgen.core.InterfaceC01612c
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int bytesRead = A01(bArr, i, i2);
        if (bytesRead == 0) {
            bytesRead = A02(bArr, i, i2, 0, true);
        }
        A03(bytesRead);
        return bytesRead;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1772ms
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        AHR(bArr, i, i2, false);
    }
}
