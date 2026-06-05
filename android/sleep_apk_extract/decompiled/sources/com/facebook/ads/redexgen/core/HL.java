package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class HL {
    public static byte[] A09;
    public static String[] A0A = {"EsB1Svc2O0r", "neXgiGAVZF2hPSW", "e5UrGC6TzR", "xWVfqfZ1XD25z1nFBwMIBfHnywy3RQhb", "m9mgew9TdIxun9z0pjAF4NJPGlbJBstI", "nE", "RVA0jPrNpk", "4CgUEtTVWe3Kq65nNHH5xBV3YKPxdnIZ"};
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final String A07;
    public final List<byte[]> A08;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static HL A00(C02284v c02284v) throws C3K {
        try {
            c02284v.A0g(21);
            int iA0I = c02284v.A0I() & 3;
            int iA0I2 = c02284v.A0I();
            int i = 0;
            int iA09 = c02284v.A09();
            for (int i2 = 0; i2 < iA0I2; i2++) {
                c02284v.A0g(1);
                int iA0M = c02284v.A0M();
                for (int i3 = 0; i3 < iA0M; i3++) {
                    int iA0M2 = c02284v.A0M();
                    i += iA0M2 + 4;
                    c02284v.A0g(iA0M2);
                }
            }
            c02284v.A0f(iA09);
            byte[] bArr = new byte[i];
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            float f = 1.0f;
            String strA03 = null;
            for (int i10 = 0; i10 < iA0I2; i10++) {
                int iA0I3 = c02284v.A0I() & 63;
                int iA0M3 = c02284v.A0M();
                for (int i11 = 0; i11 < iA0M3; i11++) {
                    int iA0M4 = c02284v.A0M();
                    System.arraycopy(HS.A03, 0, bArr, i4, HS.A03.length);
                    int length = i4 + HS.A03.length;
                    System.arraycopy(c02284v.A0l(), c02284v.A09(), bArr, length, iA0M4);
                    if (iA0I3 == 33 && i11 == 0) {
                        HP hpA05 = HS.A05(bArr, length, length + iA0M4);
                        i5 = hpA05.A0A;
                        i6 = hpA05.A08;
                        i7 = hpA05.A02;
                        i8 = hpA05.A01;
                        i9 = hpA05.A03;
                        f = hpA05.A00;
                        strA03 = AnonymousClass46.A03(hpA05.A07, hpA05.A0B, hpA05.A06, hpA05.A05, hpA05.A0C, hpA05.A04);
                    }
                    i4 = length + iA0M4;
                    c02284v.A0g(iA0M4);
                }
            }
            return new HL(i == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iA0I + 1, i5, i6, f, strA03, i7, i8, i9);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw C3K.A01(A01(0, 25, 126), e);
        }
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0A[5].length() == 29) {
                throw new RuntimeException();
            }
            A0A[5] = "YyBlh7kREcvGfk8zeLahZrRMr2fR36";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 68);
            i4++;
        }
    }

    public static void A02() {
        A09 = new byte[]{127, 72, 72, 85, 72, 26, 74, 91, 72, 73, 83, 84, 93, 26, 114, 127, 108, 121, 26, 89, 85, 84, 92, 83, 93};
    }

    static {
        A02();
    }

    public HL(List<byte[]> initializationData, int i, int i2, int i3, float f, String str, int i4, int i5, int i6) {
        this.A08 = initializationData;
        this.A05 = i;
        this.A06 = i2;
        this.A04 = i3;
        this.A00 = f;
        this.A07 = str;
        this.A02 = i4;
        this.A01 = i5;
        this.A03 = i6;
    }
}
