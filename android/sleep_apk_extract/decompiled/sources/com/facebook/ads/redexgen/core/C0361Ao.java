package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ao, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0361Ao implements SharedViewpointManager {
    public static boolean A07;
    public static byte[] A08;
    public InterfaceC2037rY A00;
    public InterfaceC2025rI A01;
    public C2013r5 A02;
    public final InterfaceC2026rJ A04;
    public final ViewpointQeConfig A05;
    public final LinkedHashMap<Integer, Runnable> A06 = new LinkedHashMap<>();
    public final InterfaceC2025rI A03 = new C0362Ap(this);

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A08 = new byte[]{-28};
    }

    static {
        A04();
        A07 = false;
    }

    public C0361Ao(ViewpointQeConfig viewpointQeConfig, InterfaceC2037rY interfaceC2037rY, InterfaceC2026rJ interfaceC2026rJ) {
        this.A05 = viewpointQeConfig;
        this.A00 = interfaceC2037rY;
        this.A04 = interfaceC2026rJ;
    }

    public static C0361Ao A01() {
        return new C0361Ao(new ViewpointQeConfig(), new C0364Ar(), null);
    }

    private void A05(AbstractC2028rL abstractC2028rL, InterfaceC2033rQ interfaceC2033rQ, InterfaceC0359Al interfaceC0359Al, ViewpointAutoOcclusion viewpointAutoOcclusion) {
        this.A02 = C2013r5.A01(this.A05, abstractC2028rL, interfaceC2033rQ, interfaceC0359Al, viewpointAutoOcclusion);
        if (0 != 0) {
            this.A02.A04(null);
        }
        this.A02.A05(this.A03);
    }

    private void A06(DspViewableNode dspViewableNode, C2034rU c2034rU) {
        C2013r5 c2013r5 = this.A02;
        if (c2013r5 != null && dspViewableNode != null) {
            if (this.A05.A00 && c2034rU != null) {
                c2013r5.A07(dspViewableNode, c2034rU);
            } else {
                c2013r5.A06(dspViewableNode);
            }
        }
    }

    private void A07(DspViewableNode dspViewableNode, C2034rU c2034rU, C2030rN c2030rN) {
        C2013r5 c2013r5 = this.A02;
        if (c2013r5 != null && dspViewableNode != null && c2030rN != null) {
            if (this.A05.A00 && c2034rU != null) {
                c2030rN.A02 = dspViewableNode.hashCode() + A02(0, 1, 27) + c2030rN.A08 + c2034rU;
                c2013r5.A08(dspViewableNode, c2034rU, c2030rN);
            } else {
                c2013r5.A09(dspViewableNode, c2030rN);
            }
        }
    }

    public final void A08(View view) {
        A06(view != null ? ViewpointViewNode.A00(view) : null, null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<?, ?> */
    public final void A09(View view, C2030rN<?, ?> c2030rN) {
        A07(view != null ? ViewpointViewNode.A00(view) : null, null, c2030rN);
    }

    public final void A0A(AbstractC2028rL abstractC2028rL, View view) {
        if (abstractC2028rL != null && view != null) {
            A05(abstractC2028rL, new C0363Aq(view, this.A00), new C01531u(null), null);
        }
    }
}
