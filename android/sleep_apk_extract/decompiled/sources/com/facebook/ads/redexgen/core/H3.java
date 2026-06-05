package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class H3 {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-65, -31, -35, -47, -16, -27, -24, -36, -12, -14, -7, -7, -14, -9, -16, -87, -5, -18, -10, -22, -14, -9, -19, -18, -5, -87, -8, -17, -87, -10, -22, -11, -17, -8, -5, -10, -18, -19, -87, -36, -50, -46, -87, -41, -54, -43, -87, -2, -9, -14, -3, -73};
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A00(C02284v c02284v) {
        int i = 0;
        while (value != 0) {
            int b = c02284v.A0I();
            i += b;
            if (b != 255) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A03(long j, C02284v c02284v, InterfaceC0528Hd[] interfaceC0528HdArr) {
        while (true) {
            if (c02284v.A07() > 1) {
                int iA00 = A00(c02284v);
                int iA002 = A00(c02284v);
                int iA09 = c02284v.A09() + iA002;
                if (iA002 != -1) {
                    int payloadType = c02284v.A07();
                    if (iA002 > payloadType) {
                        AbstractC02134g.A07(A01(0, 7, 3), A01(7, 45, 16));
                        iA09 = c02284v.A0A();
                    } else if (iA00 == 4 && iA002 >= 8) {
                        int userIdentifier = c02284v.A0I();
                        int providerCode = c02284v.A0M();
                        int countryCode = 0;
                        if (providerCode == 49) {
                            countryCode = c02284v.A0C();
                        }
                        int iA0I = c02284v.A0I();
                        if (providerCode == 47) {
                            c02284v.A0g(1);
                        }
                        int i = (userIdentifier == 181 && (providerCode == 49 || providerCode == 47) && iA0I == 3) ? 1 : 0;
                        if (providerCode == 49) {
                            int userDataTypeCode = countryCode != 1195456820 ? 0 : 1;
                            i &= userDataTypeCode;
                        }
                        if (i != 0) {
                            A04(j, c02284v, interfaceC0528HdArr);
                        }
                    }
                }
                c02284v.A0f(iA09);
            } else {
                return;
            }
        }
    }

    public static void A04(long j, C02284v c02284v, InterfaceC0528Hd[] interfaceC0528HdArr) {
        int firstByte = c02284v.A0I();
        if (!((firstByte & 64) != 0)) {
            return;
        }
        c02284v.A0g(1);
        int i = (firstByte & 31) * 3;
        int iA09 = c02284v.A09();
        for (InterfaceC0528Hd interfaceC0528Hd : interfaceC0528HdArr) {
            c02284v.A0f(iA09);
            interfaceC0528Hd.AIr(c02284v, i);
            if (j != -9223372036854775807L) {
                interfaceC0528Hd.AIu(j, 1, i, 0, null);
            }
        }
    }
}
