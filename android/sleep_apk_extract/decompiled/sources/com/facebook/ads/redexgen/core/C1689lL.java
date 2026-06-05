package com.facebook.ads.redexgen.core;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1689lL implements InterfaceC0623Kv {
    public static byte[] A0B;
    public static String[] A0C = {"Sri33Nkjg2q1UfSTa8c1c4poMbcRpRLi", "09hX7cFAjusi8bmxYUkedKuhTIWBBFyj", "9Nq5ciBjH0E2wAdqO8kDicSSF4ASqfED", "QsWxT4gaPPGppGCvyiz5txfiFuAY8zGx", "IfMd", "WTVPPiGNk6qIrjWgxgkH9oFnGfUzUO7U", "kZSjpU6etDs1IBDvrqsQrqQjBcHBIo8z", "H6v3RmW3GvMpIK1G5kWvIHPLiCmsEM1C"};
    public static final float[] A0D;
    public long A00;
    public long A01;
    public InterfaceC0528Hd A02;
    public C0627Kz A03;
    public String A04;
    public boolean A05;
    public final C02284v A06;
    public final C0626Ky A07;
    public final L4 A08;
    public final LJ A09;
    public final boolean[] A0A;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 69);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0B = new byte[]{66, 56, 60, 57, 88, 111, 107, 110, 111, 120, 18, 53, 45, 58, 55, 50, 63, 123, 58, 40, 43, 62, 56, 47, 123, 41, 58, 47, 50, 52, 125, 90, 66, 85, 88, 93, 80, 20, 66, 91, 68, 107, 93, 90, 87, 70, 81, 89, 81, 90, 64, 107, 64, 93, 89, 81, 107, 70, 81, 71, 91, 88, 65, 64, 93, 91, 90, 77, 118, 112, 121, 118, 124, 116, 125, 124, 56, 110, 113, 124, 125, 119, 56, 119, 122, 114, 125, 123, 108, 56, 116, 121, 97, 125, 106, 56, 107, 112, 121, 104, 125, 45, 50, 63, 62, 52, 116, 54, 43, 111, 45, 118, 62, 40};
    }

    static {
        A02();
        A0D = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    }

    public C1689lL() {
        this(null);
    }

    public C1689lL(LJ lj) {
        this.A09 = lj;
        this.A0A = new boolean[4];
        this.A07 = new C0626Ky(128);
        this.A00 = -9223372036854775807L;
        if (lj != null) {
            this.A08 = new L4(178, 128);
            this.A06 = new C02284v();
        } else {
            this.A08 = null;
            this.A06 = null;
        }
    }

    public static C1981qI A00(C0626Ky c0626Ky, int i, String str) {
        float f;
        byte[] bArrCopyOf = Arrays.copyOf(c0626Ky.A02, c0626Ky.A00);
        C02274u c02274u = new C02274u(bArrCopyOf);
        c02274u.A0A(i);
        c02274u.A0A(4);
        c02274u.A07();
        c02274u.A09(8);
        if (c02274u.A0H()) {
            c02274u.A09(4);
            c02274u.A09(3);
        }
        int iA04 = c02274u.A04(4);
        String strA01 = A01(10, 20, 30);
        String strA012 = A01(0, 10, 79);
        if (iA04 == 15) {
            int iA042 = c02274u.A04(8);
            String[] strArr = A0C;
            if (strArr[1].charAt(10) != strArr[6].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[1] = "pNVnHJusVCsmPjFYzkWaaBxpUvIALZFH";
            strArr2[6] = "5W5bueKBkmsFSlOt61KpehVGJe26nslO";
            int iA043 = c02274u.A04(8);
            if (iA043 == 0) {
                AbstractC02134g.A07(strA012, strA01);
                f = 1.0f;
            } else {
                f = iA042 / iA043;
            }
        } else if (iA04 < A0D.length) {
            f = A0D[iA04];
        } else {
            AbstractC02134g.A07(strA012, strA01);
            f = 1.0f;
        }
        if (c02274u.A0H()) {
            c02274u.A09(2);
            c02274u.A09(1);
            boolean zA0H = c02274u.A0H();
            if (A0C[2].charAt(24) != 'F') {
                throw new RuntimeException();
            }
            String[] strArr3 = A0C;
            strArr3[1] = "a7iwuG0S7TsvBO2g0yc87XIFTOWCV0GN";
            strArr3[6] = "G4F0gcHQBssTN40k2zdU8kwKQEhYA5ZF";
            if (zA0H) {
                c02274u.A09(15);
                c02274u.A07();
                c02274u.A09(15);
                c02274u.A07();
                c02274u.A09(15);
                c02274u.A07();
                c02274u.A09(3);
                c02274u.A09(11);
                c02274u.A07();
                c02274u.A09(15);
                c02274u.A07();
            }
        }
        if (c02274u.A04(2) != 0) {
            AbstractC02134g.A07(strA012, A01(67, 34, 93));
        }
        c02274u.A07();
        int iA044 = c02274u.A04(16);
        c02274u.A07();
        if (c02274u.A0H()) {
            if (iA044 == 0) {
                AbstractC02134g.A07(strA012, A01(30, 37, 113));
            } else {
                int i2 = 0;
                for (int i3 = iA044 - 1; i3 > 0; i3 >>= 1) {
                    i2++;
                }
                c02274u.A09(i2);
            }
        }
        c02274u.A07();
        int videoObjectLayerWidth = c02274u.A04(13);
        c02274u.A07();
        int iA045 = c02274u.A04(13);
        c02274u.A07();
        c02274u.A07();
        return new C01722p().A0y(str).A11(A01(101, 13, 30)).A0r(videoObjectLayerWidth).A0f(iA045).A0Y(f).A12(Collections.singletonList(bArrCopyOf)).A14();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012e A[SYNTHETIC] */
    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A5A(C02284v c02284v) {
        AbstractC02053y.A02(this.A03);
        AbstractC02053y.A02(this.A02);
        int iA09 = c02284v.A09();
        int iA0A = c02284v.A0A();
        byte[] bArrA0l = c02284v.A0l();
        long j = this.A01;
        int offset = c02284v.A07();
        this.A01 = j + ((long) offset);
        InterfaceC0528Hd interfaceC0528Hd = this.A02;
        int offset2 = c02284v.A07();
        interfaceC0528Hd.AIr(c02284v, offset2);
        while (true) {
            int lengthToStartCode = HS.A04(bArrA0l, iA09, iA0A, this.A0A);
            if (lengthToStartCode == iA0A) {
                if (!this.A05) {
                    C0626Ky c0626Ky = this.A07;
                    int limit = A0C[7].charAt(0);
                    if (limit != 51) {
                        A0C[4] = "80MY";
                        c0626Ky.A03(bArrA0l, iA09, iA0A);
                    }
                }
                this.A03.A03(bArrA0l, iA09, iA0A);
                if (this.A08 != null) {
                    this.A08.A02(bArrA0l, iA09, iA0A);
                    return;
                }
                return;
            }
            int offset3 = lengthToStartCode + 3;
            int startCodeValue = c02284v.A0l()[offset3] & PHIpAddressSearchManager.END_IP_SCAN;
            int i = lengthToStartCode - iA09;
            if (!this.A05) {
                if (i > 0) {
                    this.A07.A03(bArrA0l, iA09, lengthToStartCode);
                }
                int limit2 = i < 0 ? -i : 0;
                if (this.A07.A04(startCodeValue, limit2)) {
                    InterfaceC0528Hd interfaceC0528Hd2 = this.A02;
                    C0626Ky c0626Ky2 = this.A07;
                    String[] strArr = A0C;
                    String str = strArr[1];
                    String str2 = strArr[6];
                    int limit3 = str.charAt(10);
                    int offset4 = str2.charAt(10);
                    if (limit3 != offset4) {
                        break;
                    }
                    String[] strArr2 = A0C;
                    strArr2[1] = "jCMcU5kX01siyiD9Xw2jZ38LNAQD3esf";
                    strArr2[6] = "NTL8nbB45bsjwa3rfW6th5wXRcuqzfwM";
                    int limit4 = this.A07.A01;
                    interfaceC0528Hd2.A6e(A00(c0626Ky2, limit4, (String) AbstractC02053y.A01(this.A04)));
                    this.A05 = true;
                    this.A03.A03(bArrA0l, iA09, lengthToStartCode);
                    if (this.A08 == null) {
                    }
                    int i2 = iA0A - lengthToStartCode;
                    this.A03.A02(this.A01 - ((long) i2), i2, this.A05);
                    this.A03.A01(startCodeValue, this.A00);
                    iA09 = lengthToStartCode + 3;
                }
            } else {
                this.A03.A03(bArrA0l, iA09, lengthToStartCode);
                if (this.A08 == null) {
                    int i3 = 0;
                    if (i > 0) {
                        L4 l4 = this.A08;
                        int limit5 = A0C[4].length();
                        if (limit5 != 4) {
                            break;
                        }
                        A0C[2] = "pGtfbhZ8gA4Y3zya71EFVTXhFPoVLYfI";
                        l4.A02(bArrA0l, iA09, lengthToStartCode);
                    } else {
                        i3 = -i;
                    }
                    if (this.A08.A04(i3)) {
                        byte[] bArr = this.A08.A01;
                        int offset5 = this.A08.A00;
                        ((C02284v) C5C.A0f(this.A06)).A0j(this.A08.A01, HS.A02(bArr, offset5));
                        ((LJ) C5C.A0f(this.A09)).A02(this.A00, this.A06);
                    }
                    if (startCodeValue == 178) {
                        int offset6 = lengthToStartCode + 2;
                        if (c02284v.A0l()[offset6] == 1) {
                            this.A08.A01(startCodeValue);
                        }
                    }
                }
                int i22 = iA0A - lengthToStartCode;
                this.A03.A02(this.A01 - ((long) i22), i22, this.A05);
                this.A03.A01(startCodeValue, this.A00);
                iA09 = lengthToStartCode + 3;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A04 = lg.A04();
        this.A02 = ha.AKS(lg.A03(), 2);
        this.A03 = new C0627Kz(this.A02);
        if (this.A09 != null) {
            this.A09.A03(ha, lg);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void AGp() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void AGq(long j, int i) {
        if (j != -9223372036854775807L) {
            this.A00 = j;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void AJ5() {
        HS.A0H(this.A0A);
        this.A07.A02();
        if (this.A03 != null) {
            this.A03.A00();
        }
        if (this.A08 != null) {
            this.A08.A00();
        }
        if (A0C[4].length() != 4) {
            throw new RuntimeException();
        }
        A0C[2] = "KHBnxT5PT6gCJIZCrRbgphkbFp7MF5Ts";
        this.A01 = 0L;
        this.A00 = -9223372036854775807L;
    }
}
