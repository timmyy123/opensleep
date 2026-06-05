package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class HF {
    public static String[] A00 = {"o6dy0jxWVFoVpdfIHLQ5kJFOMlq1Sn1Q", "79oj", "9g10QGOLUMPWkkbPiEKlPZ6GdmncXBXa", "6fmIgIVXmOYY3cUB7ZYAXnWSgE20TitB", "v6a7Yb3DANDL70kkwlzLnkI1heNzynkm", "eDdjZQkAYxVEYJ3d9Q78IvgSo191T7ve", "sHmXnPOOobIrXpWrquJBTDw1maWJKk3u", "k0vF7vRBeJQaOBXZ"};

    public static int A00(C02284v c02284v, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return c02284v.A0I() + 1;
            case 7:
                int iA0M = c02284v.A0M();
                String[] strArr = A00;
                if (strArr[6].charAt(23) != strArr[4].charAt(23)) {
                    throw new RuntimeException();
                }
                A00[7] = "hcXiJWofr5Txci555yuma5X";
                return iA0M + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static long A01(InterfaceC1772ms interfaceC1772ms, HJ hj) throws IOException {
        interfaceC1772ms.AIl();
        boolean z = true;
        interfaceC1772ms.A47(1);
        byte[] bArr = new byte[1];
        interfaceC1772ms.AGt(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z = false;
        }
        interfaceC1772ms.A47(2);
        int i = z ? 7 : 6;
        C02284v c02284v = new C02284v(i);
        c02284v.A0e(HB.A00(interfaceC1772ms, c02284v.A0l(), 0, i));
        interfaceC1772ms.AIl();
        HE he = new HE();
        boolean isBlockSizeVariable = A08(c02284v, hj, z, he);
        if (isBlockSizeVariable) {
            return he.A00;
        }
        throw C3K.A01(null, null);
    }

    public static boolean A02(int i, HJ hj) {
        if (i == 0) {
            return true;
        }
        int i2 = hj.A01;
        if (A00[7].length() == 8) {
            throw new RuntimeException();
        }
        A00[0] = "dnyA5Em4Vekc9hKZNMMqKWCBR5ivXppC";
        return i == i2;
    }

    public static boolean A03(int i, HJ hj) {
        if (i <= 7) {
            return i == hj.A02 - 1;
        }
        if (A00[3].charAt(10) != 'Y') {
            throw new RuntimeException();
        }
        A00[3] = "e0AkGTV6jhYRPjlSs9AVJSXBXenCNngQ";
        return i <= 10 && hj.A02 == 2;
    }

    public static boolean A04(C02284v c02284v, int i) {
        int iA0I = c02284v.A0I();
        int crc = c02284v.A09();
        return iA0I == C5C.A0J(c02284v.A0l(), i, crc + (-1), 0);
    }

    public static boolean A05(C02284v c02284v, HJ hj, int i) {
        int iA00 = A00(c02284v, i);
        if (iA00 != -1) {
            int blockSizeSamples = hj.A03;
            if (iA00 <= blockSizeSamples) {
                return true;
            }
        }
        return false;
    }

    public static boolean A06(C02284v c02284v, HJ hj, int i) {
        int sampleRate = hj.A07;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == hj.A08;
        }
        if (i == 12) {
            return c02284v.A0I() * 1000 == sampleRate;
        }
        if (i > 14) {
            return false;
        }
        int expectedSampleRate = c02284v.A0M();
        if (i == 14) {
            expectedSampleRate *= 10;
        }
        return expectedSampleRate == sampleRate;
    }

    public static boolean A07(C02284v c02284v, HJ hj, int i, HE he) {
        int iA09 = c02284v.A09();
        long jA0Q = c02284v.A0Q();
        long frameHeaderBytes = jA0Q >>> 16;
        if (frameHeaderBytes != i) {
            return false;
        }
        int blockSizeKey = (int) ((jA0Q >> 8) & 15);
        long frameHeaderBytes2 = jA0Q >> 1;
        int frameStartPosition = (int) (frameHeaderBytes2 & 7);
        return A03((int) ((jA0Q >> 4) & 15), hj) && A02(frameStartPosition, hj) && !(((jA0Q & 1) > 1L ? 1 : ((jA0Q & 1) == 1L ? 0 : -1)) == 0) && A08(c02284v, hj, (((jA0Q >>> 16) & 1) > 1L ? 1 : (((jA0Q >>> 16) & 1) == 1L ? 0 : -1)) == 0, he) && A05(c02284v, hj, (int) ((jA0Q >> 12) & 15)) && A06(c02284v, hj, blockSizeKey) && A04(c02284v, iA09);
    }

    public static boolean A08(C02284v c02284v, HJ hj, boolean z, HE he) {
        long utf8Value;
        try {
            long jA0S = c02284v.A0S();
            if (z) {
                utf8Value = jA0S;
            } else {
                long utf8Value2 = hj.A03;
                utf8Value = utf8Value2 * jA0S;
            }
            he.A00 = utf8Value;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean A09(InterfaceC1772ms interfaceC1772ms, HJ hj, int i, HE he) throws IOException {
        long jA8i = interfaceC1772ms.A8i();
        byte[] bArr = new byte[2];
        interfaceC1772ms.AGt(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            interfaceC1772ms.AIl();
            interfaceC1772ms.A47((int) (jA8i - interfaceC1772ms.A8n()));
            return false;
        }
        C02284v c02284v = new C02284v(16);
        System.arraycopy(bArr, 0, c02284v.A0l(), 0, 2);
        byte[] frameStartBytes = c02284v.A0l();
        c02284v.A0e(HB.A00(interfaceC1772ms, frameStartBytes, 2, 14));
        interfaceC1772ms.AIl();
        interfaceC1772ms.A47((int) (jA8i - interfaceC1772ms.A8n()));
        return A07(c02284v, hj, i, he);
    }
}
