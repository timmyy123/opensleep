package com.facebook.ads.redexgen.core;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class LA {
    public static byte[] A09;
    public static String[] A0A = {"YKrx4tQL3HFlbX0m6cI7YSMmMtJDnVWt", "EhNKRydGslBNjHwz4Qke8RkUgCBaonuc", "lVt1vjccWtobRJMyEDSjQomkweVugX5V", "X5vaF2wJa8umjlLI", "q53FR06vPOBUDZ08SG0Q3HmIsvEwqM01", "eDYPuZuNQVkkkUOb40HZTr2GxKWyUyQ4", "7DZ3geXrHcZNODb56yin0lXQD6ovjT1O", "oKDHpDD8v386AT9biWd"};
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final int A06;
    public final AnonymousClass53 A08 = new AnonymousClass53(0);
    public long A01 = -9223372036854775807L;
    public long A02 = -9223372036854775807L;
    public long A00 = -9223372036854775807L;
    public final C02284v A07 = new C02284v();

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A09 = new byte[]{-89, -103, -50, -20, -30, -25, -32, -103, -51, -62, -58, -66, -40, -50, -57, -52, -66, -51, -103, -30, -25, -20, -19, -34, -38, -35, -89, -119, -82, -74, -95, -84, -87, -92, 96, -92, -75, -78, -95, -76, -87, -81, -82, 122, 96, -95, -64, -111, -62, -65, -82, -63, -74, -68, -69, -97, -78, -82, -79, -78, -65};
    }

    static {
        A06();
    }

    public LA(int i) {
        this.A06 = i;
    }

    private int A00(InterfaceC1772ms interfaceC1772ms) {
        this.A07.A0i(C5C.A07);
        this.A03 = true;
        interfaceC1772ms.AIl();
        return 0;
    }

    private int A01(InterfaceC1772ms interfaceC1772ms, HV hv, int i) throws IOException {
        int iMin = (int) Math.min(this.A06, interfaceC1772ms.A8O());
        if (interfaceC1772ms.A8n() != 0) {
            hv.A00 = 0;
            return 1;
        }
        this.A07.A0d(iMin);
        interfaceC1772ms.AIl();
        interfaceC1772ms.AGt(this.A07.A0l(), 0, iMin);
        this.A01 = A03(this.A07, i);
        this.A04 = true;
        return 0;
    }

    private int A02(InterfaceC1772ms interfaceC1772ms, HV hv, int i) throws IOException {
        long inputLength = interfaceC1772ms.A8O();
        int iMin = (int) Math.min(this.A06, inputLength);
        long inputLength2 = inputLength - ((long) iMin);
        if (interfaceC1772ms.A8n() != inputLength2) {
            hv.A00 = inputLength2;
            return 1;
        }
        this.A07.A0d(iMin);
        interfaceC1772ms.AIl();
        interfaceC1772ms.AGt(this.A07.A0l(), 0, iMin);
        this.A02 = A04(this.A07, i);
        this.A05 = true;
        return 0;
    }

    private long A03(C02284v c02284v, int i) {
        int iA0A = c02284v.A0A();
        for (int iA09 = c02284v.A09(); iA09 < iA0A; iA09++) {
            int searchEndPosition = c02284v.A0l()[iA09];
            if (searchEndPosition == 71) {
                long jA01 = LI.A01(c02284v, iA09, i);
                if (jA01 != -9223372036854775807L) {
                    return jA01;
                }
            }
        }
        return -9223372036854775807L;
    }

    private long A04(C02284v c02284v, int i) {
        int iA09 = c02284v.A09();
        int iA0A = c02284v.A0A();
        for (int i2 = iA0A - 188; i2 >= iA09; i2--) {
            if (LI.A03(c02284v.A0l(), iA09, iA0A, i2)) {
                long jA01 = LI.A01(c02284v, i2, i);
                if (jA01 != -9223372036854775807L) {
                    return jA01;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final int A07(InterfaceC1772ms interfaceC1772ms, HV hv, int i) throws IOException {
        if (i <= 0) {
            return A00(interfaceC1772ms);
        }
        if (!this.A05) {
            return A02(interfaceC1772ms, hv, i);
        }
        if (this.A02 == -9223372036854775807L) {
            return A00(interfaceC1772ms);
        }
        if (!this.A04) {
            int iA01 = A01(interfaceC1772ms, hv, i);
            if (A0A[0].charAt(2) == 'O') {
                throw new RuntimeException();
            }
            A0A[0] = "U4EwafF7WjzJM20D4nSEnM6oLnkPTMDI";
            return iA01;
        }
        if (this.A01 == -9223372036854775807L) {
            return A00(interfaceC1772ms);
        }
        this.A00 = this.A08.A06(this.A02) - this.A08.A06(this.A01);
        if (this.A00 < 0) {
            AbstractC02134g.A07(A05(45, 16, 60), A05(27, 18, 47) + this.A00 + A05(0, 27, 104));
            this.A00 = -9223372036854775807L;
        }
        return A00(interfaceC1772ms);
    }

    public final long A08() {
        return this.A00;
    }

    public final AnonymousClass53 A09() {
        return this.A08;
    }

    public final boolean A0A() {
        return this.A03;
    }
}
