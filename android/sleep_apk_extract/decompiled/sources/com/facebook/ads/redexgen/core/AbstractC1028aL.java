package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1028aL {
    public static String[] A00 = {"JDSePW2HSG4YeS6gtlV", "82T2GFaLeV3aTbLMJos0KxEKOb8V", "eQCDfbwHDs1I63LCwtRfVvk7aOq68Yi1", "mKAtiPzaErPw2g5AsekgNJUywNJKgzbn", "W6CrCk7jl5WmpSSnHELA9a4ylCy3ZwGN", "yC8I8b2mmbmFe3RpkHIpYdmwx30s8PcH", "t7vLS6XVWI7z", "7V80TKFhnzYK6cwmq9Eavbn4uXT7"};

    public static EnumC1032aP A00(AbstractC1586jd abstractC1586jd) {
        if (abstractC1586jd.A2U()) {
            EnumC1032aP enumC1032aP = EnumC1032aP.A02;
            if (A00[3].charAt(31) != 'n') {
                throw new RuntimeException();
            }
            A00[0] = "myUXVCGo2IYKrTscb4wiG";
            return enumC1032aP;
        }
        return EnumC1032aP.A03;
    }

    public static void A01(C1421gi c1421gi, EnumC1029aM enumC1029aM) {
        c1421gi.A0F().AAz(enumC1029aM.name().toLowerCase(Locale.US));
    }

    public static void A02(C1421gi c1421gi, EnumC1029aM enumC1029aM) {
        c1421gi.A0F().AB9(enumC1029aM.name().toLowerCase(Locale.US));
    }

    public static void A03(C1421gi c1421gi, EnumC1029aM enumC1029aM) {
        c1421gi.A0F().AC7(enumC1029aM.name().toLowerCase(Locale.US));
    }

    public static void A04(C1421gi c1421gi, EnumC1029aM enumC1029aM) {
        A01(c1421gi, enumC1029aM);
    }

    public static void A05(C1421gi c1421gi, EnumC1029aM enumC1029aM) {
        A02(c1421gi, enumC1029aM);
    }

    public static void A06(C1421gi c1421gi, EnumC1029aM enumC1029aM) {
        A03(c1421gi, enumC1029aM);
    }

    public static void A07(VI vi, C1421gi c1421gi, InterfaceC0962Yh interfaceC0962Yh, AbstractC1586jd abstractC1586jd, EnumC1029aM enumC1029aM) {
        if (vi != null) {
            vi.A04(VH.A0A, null);
        }
        if (abstractC1586jd.A2Q()) {
            c1421gi.A0F().AB8(enumC1029aM.name().toLowerCase(Locale.US));
        }
        if (abstractC1586jd.A2U()) {
            c1421gi.A0F().AAy(enumC1029aM.name().toLowerCase(Locale.US));
        }
        C0711Og c0711OgA00 = AbstractC0712Oh.A00(c1421gi.A02());
        C1417ge c1417geA02 = c1421gi.A02();
        if (A00[6].length() != 12) {
            throw new RuntimeException();
        }
        A00[0] = "Fh7";
        if (c0711OgA00.A0O(c1417geA02, true)) {
            if (interfaceC0962Yh != null) {
                interfaceC0962Yh.AAo(abstractC1586jd.A2E(), abstractC1586jd.A2C());
            }
        } else {
            if (TextUtils.isEmpty(abstractC1586jd.A2C().A00())) {
                return;
            }
            X6.A0O(new X6(), c1421gi, XB.A00(abstractC1586jd.A2C().A00()), abstractC1586jd.A2E());
        }
    }
}
