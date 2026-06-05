package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class L9 {
    public static byte[] A02;
    public final List<C1981qI> A00;
    public final InterfaceC0528Hd[] A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 29);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{119, -100, -92, -113, -102, -105, -110, 78, -111, -102, -99, -95, -109, -110, 78, -111, -113, -98, -94, -105, -99, -100, 78, -101, -105, -101, -109, 78, -94, -89, -98, -109, 78, -98, -96, -99, -92, -105, -110, -109, -110, 104, 78, -123, -108, -108, -112, -115, -121, -123, -104, -115, -109, -110, 83, -121, -119, -123, 81, 90, 84, 92, -49, -34, -34, -38, -41, -47, -49, -30, -41, -35, -36, -99, -47, -45, -49, -101, -91, -98, -90};
    }

    public L9(List<C1981qI> list) {
        this.A00 = list;
        this.A01 = new InterfaceC0528Hd[list.size()];
    }

    public final void A02(long j, C02284v c02284v) {
        H3.A03(j, c02284v, this.A01);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A03(HA ha, LG lg) {
        for (int i = 0; i < i; i++) {
            lg.A05();
            InterfaceC0528Hd interfaceC0528HdAKS = ha.AKS(lg.A03(), 3);
            C1981qI c1981qI = this.A00.get(i);
            String str = c1981qI.A0W;
            AbstractC02053y.A09(A00(43, 19, 7).equals(str) || A00(62, 19, 81).equals(str), A00(0, 43, 17) + str);
            C01722p c01722pA11 = new C01722p().A0y(c1981qI.A0T != null ? c1981qI.A0T : lg.A04()).A11(str);
            int i2 = c1981qI.A0H;
            C01722p c01722pA10 = c01722pA11.A0n(i2).A10(c1981qI.A0V);
            int i3 = c1981qI.A03;
            interfaceC0528HdAKS.A6e(c01722pA10.A0Z(i3).A12(c1981qI.A0X).A14());
            this.A01[i] = interfaceC0528HdAKS;
        }
    }
}
