package com.facebook.ads.redexgen.core;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class JW {
    public static String[] A05 = {"woqNFTEJ1xTDdkI437bHtamdu4tXteqY", "wF9EC05jEy4IHYIwxnPCGFJPaq3oRF", "mvXHGyDRnyfaH7rDUTrxLU", "Y3pxu", "rdrAFFFqCGKv06lfALLqqSpp4fott15M", "y1UafG2XcmxkBa1SOf4hmBpigeNmapwO", "We1qkMSr6SX3sfWhtZ2XCBlgLjoOgFnd", "pWnGwQQvfY"};
    public int A01;
    public boolean A02;
    public final JX A04 = new JX();
    public final C02284v A03 = new C02284v(new byte[65025], 0);
    public int A00 = -1;

    /* JADX WARN: Incorrect condition in loop: B:4:0x000b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int A00(int i) {
        this.A01 = 0;
        int i2 = 0;
        while (i < size) {
            int[] iArr = this.A04.A09;
            int i3 = this.A01;
            int size = i3 + 1;
            this.A01 = size;
            int segmentLength = iArr[i3 + i];
            i2 += segmentLength;
            if (segmentLength != 255) {
                break;
            }
        }
        return i2;
    }

    public final C02284v A01() {
        return this.A03;
    }

    public final JX A02() {
        return this.A04;
    }

    public final void A03() {
        this.A04.A02();
        this.A03.A0d(0);
        this.A00 = -1;
        this.A02 = false;
    }

    public final void A04() {
        if (this.A03.A0l().length == 65025) {
            return;
        }
        this.A03.A0j(Arrays.copyOf(this.A03.A0l(), Math.max(65025, this.A03.A0A())), this.A03.A0A());
    }

    public final boolean A05(InterfaceC1772ms interfaceC1772ms) throws IOException {
        AbstractC02053y.A08(interfaceC1772ms != null);
        if (this.A02) {
            this.A02 = false;
            this.A03.A0d(0);
        }
        while (!this.A02) {
            int i = this.A00;
            if (A05[2].length() == 22) {
                String[] strArr = A05;
                strArr[4] = "11LtUWwuTljX7vpVMDmw91gP9qyXcF1F";
                strArr[5] = "domIksdZFoGV1iSe2ioqlJ00HNTdFQYJ";
                if (i < 0) {
                    if (!this.A04.A03(interfaceC1772ms) || !this.A04.A05(interfaceC1772ms, true)) {
                        return false;
                    }
                    int bytesToSkip = 0;
                    int iA00 = this.A04.A01;
                    if ((this.A04.A04 & 1) == 1) {
                        int iA0A = this.A03.A0A();
                        String[] strArr2 = A05;
                        if (strArr2[6].charAt(23) == strArr2[0].charAt(23)) {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A05;
                        strArr3[6] = "Y9zvOFuJw9CJ8t2sOsvBkpDySrHa8OsK";
                        strArr3[0] = "XKYFbcbdBuLAcpGhFvzSCFSZpxBENLjQ";
                        if (iA0A == 0) {
                            iA00 += A00(0);
                            bytesToSkip = 0 + this.A01;
                        }
                    }
                    if (!HB.A02(interfaceC1772ms, iA00)) {
                        return false;
                    }
                    this.A00 = bytesToSkip;
                }
                int bytesToSkip2 = this.A00;
                String[] strArr4 = A05;
                if (strArr4[4].charAt(26) != strArr4[5].charAt(26)) {
                    A05[2] = "D5kSzmFKF6oS1B0XjjhMyT";
                    int iA002 = A00(bytesToSkip2);
                    int bytesToSkip3 = this.A00;
                    int segmentIndex = bytesToSkip3 + this.A01;
                    if (iA002 > 0) {
                        this.A03.A0c(this.A03.A0A() + iA002);
                        if (!HB.A03(interfaceC1772ms, this.A03.A0l(), this.A03.A0A(), iA002)) {
                            return false;
                        }
                        this.A03.A0e(this.A03.A0A() + iA002);
                        int i2 = this.A04.A09[segmentIndex - 1];
                        if (A05[2].length() == 22) {
                            String[] strArr5 = A05;
                            strArr5[7] = "zAFVDFtFmf";
                            strArr5[3] = "FIDx8";
                            this.A02 = i2 != 255;
                        }
                    }
                    if (segmentIndex == this.A04.A02) {
                        segmentIndex = -1;
                    }
                    this.A00 = segmentIndex;
                }
            }
            throw new RuntimeException();
        }
        return true;
    }
}
