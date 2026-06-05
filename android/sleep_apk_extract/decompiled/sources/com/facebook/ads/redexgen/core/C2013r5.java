package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.r5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2013r5 {
    public static C2013r5 A03;
    public static InterfaceC2036rX A04;
    public static byte[] A05;
    public static String[] A06 = {"5DKKU3xZINN65fryyoBt5QQPLIMTkohn", "LFzimA69beWaSFXyztzupLxdNfHOQ", "XSuolM5aqTyza3oApgyv2R2QmsMDCJc3", "zWK24MgLV", "4", "qJClZMWv8", "0fmkfxUqb1vnRdlz6H0UDHtVT1WIbpOa", "oRXxD"};
    public final ViewpointQeConfig A00;
    public final ViewpointRegistry A01;
    public final C2023rF A02;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A06[4].length() == 19) {
                throw new RuntimeException();
            }
            A06[6] = "At1Zr1oMV19x7NxsOWFoG9shzyjt72Ks";
            bArrCopyOfRange[i4] = (byte) ((b - i3) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{-89, -74, -87, -91, -72, -87};
    }

    static {
        A03();
        A03 = null;
        A04 = null;
    }

    public C2013r5(ViewpointQeConfig viewpointQeConfig, AbstractC2028rL abstractC2028rL, C2023rF c2023rF, ViewpointRegistry viewpointRegistry) {
        this.A00 = viewpointQeConfig;
        this.A01 = viewpointRegistry;
        this.A02 = c2023rF;
        abstractC2028rL.A03(new C0358Aj(c2023rF));
    }

    public static ScanDelayController A00(int i) {
        if (0 == 0) {
            return null;
        }
        throw new NullPointerException(A02(0, 6, 61));
    }

    public static C2013r5 A01(ViewpointQeConfig viewpointQeConfig, AbstractC2028rL abstractC2028rL, InterfaceC2033rQ interfaceC2033rQ, InterfaceC0359Al interfaceC0359Al, ViewpointAutoOcclusion viewpointAutoOcclusion) {
        C2013r5 c2013r5 = A03;
        if (c2013r5 != null) {
            return c2013r5;
        }
        ViewpointRegistry viewpointRegistry = new ViewpointRegistry(viewpointQeConfig);
        CK ck = CK.A00;
        Handler handler = new Handler(Looper.getMainLooper());
        A00(100);
        return new C2013r5(viewpointQeConfig, abstractC2028rL, new C2023rF(viewpointQeConfig, interfaceC2033rQ, ck, interfaceC0359Al, viewpointRegistry, viewpointAutoOcclusion, handler, null), viewpointRegistry);
    }

    public final void A04(InterfaceC2027rK interfaceC2027rK) {
        this.A02.A0H(interfaceC2027rK);
    }

    public final void A05(InterfaceC2025rI interfaceC2025rI) {
        this.A02.A0I(interfaceC2025rI);
    }

    public final void A06(DspViewableNode dspViewableNode) {
        A07(dspViewableNode, null);
    }

    public final void A07(DspViewableNode dspViewableNode, C2034rU c2034rU) {
        if (this.A00.A00 && c2034rU != null) {
            this.A01.A06(dspViewableNode, c2034rU);
        } else {
            this.A01.A05(dspViewableNode);
        }
    }

    public final void A08(DspViewableNode dspViewableNode, C2034rU c2034rU, C2030rN c2030rN) {
        if (this.A00.A00 && c2034rU != null) {
            this.A01.A07(dspViewableNode, c2034rU, c2030rN);
        } else {
            this.A01.A08(dspViewableNode, c2030rN);
        }
    }

    public final void A09(DspViewableNode dspViewableNode, C2030rN c2030rN) {
        A08(dspViewableNode, null, c2030rN);
    }
}
