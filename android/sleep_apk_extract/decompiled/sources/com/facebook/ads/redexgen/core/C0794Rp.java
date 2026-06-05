package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0794Rp {
    public static String[] A00 = {"9O", "28H1kjICyCSP", "QKFmg3qmSW84YfLR5DXewrEtWZ47Hzy", "P", "Em", "YyES7HR0UsWs", "rGxFrAuyTsOha0QpVFZkpdTTHXBTZM0k", "CeAnScf1I32vhT13KQ6XZJy"};

    public static InterfaceC0647Lt A00(Context context, TA ta) {
        return A01(context, ta, null);
    }

    public static InterfaceC0647Lt A01(Context context, TA ta, String str) {
        C1417ge sdkContext = A09(context);
        InterfaceC0651Lx interfaceC0651LxA8C = ta.A8C(sdkContext);
        if (interfaceC0651LxA8C != null) {
            return str != null ? interfaceC0651LxA8C.ACN(str) : interfaceC0651LxA8C.ACM();
        }
        return new C1641kX();
    }

    public static C1421gi A02(Activity activity) {
        return new C1421gi(activity, (TA) A0A(), A00(activity, A0A()));
    }

    public static C1421gi A03(Context context) {
        return new C1421gi(context, A0A(), new C1641kX());
    }

    public static C1421gi A04(Context context) {
        if (C0871Up.A0w(context)) {
            return new C1421gi(context, A0A(), A00(context, A0A()));
        }
        C1421gi c1421giA03 = A03(context);
        if (A00[2].length() == 11) {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[3] = "B";
        strArr[7] = "J1bgC2YpAkuTguvKBul5HQJ";
        return c1421giA03;
    }

    public static C1421gi A05(Context context, String str) {
        InterfaceC0647Lt interfaceC0647LtA01 = A01(context, A0A(), str);
        interfaceC0647LtA01.AJT(1000);
        return new C1421gi(context, A0A(), interfaceC0647LtA01);
    }

    public static C1421gi A06(Context context, String str) {
        return new C1421gi(context, A0A(), A01(context, A0A(), str));
    }

    public static C1421gi A07(Context context, String str) {
        return new C1421gi(context, A0A(), A01(context, A0A(), str));
    }

    public static AnonymousClass76 A08(Context context) {
        return new AnonymousClass76(context, A0A(), A0A().A8C(A09(context)));
    }

    public static C1417ge A09(Context context) {
        return new C1417ge(context, A0A());
    }

    public static synchronized ZR A0A() {
        return ZR.A02();
    }
}
