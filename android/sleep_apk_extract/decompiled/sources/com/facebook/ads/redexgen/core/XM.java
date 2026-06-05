package com.facebook.ads.redexgen.core;

import android.graphics.Rect;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class XM {
    public static String[] A02 = {"P6MYZTOvDAaFen8GvswQ7TN6uAA4LWVv", "hYZBnkN7eg3Goj1fCi2fLRcc1xaBLP0T", "hgTfm2gsKyXruwHhjUk", "Xl5p6SNgJSz0NngEgDitAc249tQNQ8ta", "gXDmJbn0MXLGD1TV1woO3x4WUye", "irvXIfdrm7YhWQVUx8qen3XIyPBMomv3", "r42H5ZZ7hG", "IBnhtff"};
    public final Rect A00 = new Rect();
    public final Rect A01 = new Rect();

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    public static boolean A00(C2030rN<C0878Uw, V1> c2030rN) {
        if (c2030rN.A06.A05()) {
            return c2030rN.A07.A07();
        }
        if (!c2030rN.A06.A06()) {
            return true;
        }
        return c2030rN.A07.A06();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A01(C2030rN<C0878Uw, V1> c2030rN, InterfaceC2021rD interfaceC2021rD) {
        boolean z;
        float fA9X = -1.0f;
        try {
            fA9X = interfaceC2021rD.A9X(c2030rN);
        } catch (IllegalStateException unused) {
        }
        if (A02[6].length() == 7) {
            throw new RuntimeException();
        }
        A02[5] = "l0GJDJ6h98NWCV6pJLy8cxtVoo076bMe";
        if (fA9X > 0.0f && A00(c2030rN)) {
            return true;
        }
        if (c2030rN.A06.A00().getGlobalVisibleRect(this.A01) && this.A01.bottom - this.A01.top > 0 && A00(c2030rN)) {
            return true;
        }
        interfaceC2021rD.A9W(this.A00);
        if (A02[2].length() != 2) {
            A02[2] = "WH3ZGQ";
            interfaceC2021rD.A8D(c2030rN, this.A01);
            if (this.A00.bottom - this.A00.top > 0) {
                int i = this.A01.bottom;
                int i2 = this.A00.top;
                if (A02[7].length() != 7) {
                    throw new RuntimeException();
                }
                A02[1] = "8dStYXDidh9UFB7oEkGa7ohf6JNszk5F";
                z = i - i2 > 0;
            }
        } else {
            interfaceC2021rD.A8D(c2030rN, this.A01);
            if (this.A00.bottom - this.A00.top > 0) {
            }
        }
        return z && A00(c2030rN);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    public final void A02(C2030rN<C0878Uw, V1> c2030rN, InterfaceC2021rD interfaceC2021rD) {
        if (c2030rN.A07.A04() && A01(c2030rN, interfaceC2021rD)) {
            c2030rN.A07.A01();
            c2030rN.A06.A02().ABx(c2030rN.A06.A03(), c2030rN.A06.A04());
        }
        if (c2030rN.A07.A05() && C0871Up.A1l(c2030rN.A06.A01())) {
            c2030rN.A07.A02();
            c2030rN.A06.A02().ABL(c2030rN.A06.A03(), c2030rN.A06.A04());
        }
    }
}
