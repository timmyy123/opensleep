package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1794nF extends AbstractC0455Eh<C1794nF> {
    public static String[] A0H = {"VuHjt8oOpq8N7C214wGoSA1AvoAEOrJ7", "uFvhlxS5lUy9ksGg6O4Xt3y9x", "z2gekC5V6p56SAeTbAO0jRL35", "AJl44cd0wjf7yp80NhOEfrZac9uQkeAm", "fvb2kSFN69PWkoJ4Ln26XpHSuOzso8Xv", "xYIwGH1EqCgaa9qjZOqbWgZcWwFFG4Ev", "iW7gA0b6LPVcA0KpSRoleRmfzjbkINez", "mxsnKoNumrVzSuMZZmY48wO5LDc3OokM"};
    public final int A00;
    public final int A01;
    public final int A02;

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D56211926, support language flag in video track")
    public final int A03;

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D56211926, support language flag in video track")
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final C03399i A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;
    public final boolean A0D;
    public final boolean A0E;
    public final boolean A0F;
    public final boolean A0G;

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D56211926, support language flag in video track")
    public C1794nF(int i, C1944pg c1944pg, int i2, C03399i c03399i, int i3, String str, int i4, boolean z) {
        int requiredAdaptiveSupport;
        super(i, c1944pg, i2);
        this.A09 = c03399i;
        if (c03399i.A07) {
            requiredAdaptiveSupport = 24;
        } else {
            requiredAdaptiveSupport = 16;
        }
        this.A0A = c03399i.A06 && (i4 & requiredAdaptiveSupport) != 0;
        this.A0C = z && (super.A02.A0L == -1 || super.A02.A0L <= ((C1940pc) c03399i).A06) && ((super.A02.A0A == -1 || super.A02.A0A <= ((C1940pc) c03399i).A05) && ((super.A02.A01 == -1.0f || super.A02.A01 <= ((float) ((C1940pc) c03399i).A04)) && (super.A02.A05 == -1 || super.A02.A05 <= ((C1940pc) c03399i).A03)));
        this.A0D = z && (super.A02.A0L == -1 || super.A02.A0L >= ((C1940pc) c03399i).A0A) && ((super.A02.A0A == -1 || super.A02.A0A >= ((C1940pc) c03399i).A09) && ((super.A02.A01 == -1.0f || super.A02.A01 >= ((float) ((C1940pc) c03399i).A08)) && (super.A02.A05 == -1 || super.A02.A05 >= ((C1940pc) c03399i).A07)));
        this.A0E = C03389h.A0S(i3, false);
        int bestLanguageIndex = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        while (true) {
            if (i6 >= c03399i.A0L.size()) {
                break;
            }
            int iA02 = C03389h.A02(super.A02, c03399i.A0L.get(i6), false);
            if (iA02 > 0) {
                i5 = i6;
                bestLanguageIndex = iA02;
                break;
            }
            i6++;
        }
        this.A03 = i5;
        this.A04 = bestLanguageIndex;
        this.A00 = super.A02.A05;
        this.A02 = super.A02.A06();
        this.A06 = C03389h.A00(super.A02.A0E, ((C1940pc) c03399i).A0D);
        this.A0B = super.A02.A0E == 0 || (super.A02.A0E & 1) != 0;
        this.A07 = C03389h.A02(super.A02, str, C03389h.A0K(str) == null);
        int i7 = Integer.MAX_VALUE;
        int i8 = 0;
        while (true) {
            if (i8 < c03399i.A0M.size()) {
                if (super.A02.A0W != null && super.A02.A0W.equals(c03399i.A0M.get(i8))) {
                    i7 = i8;
                    break;
                }
                i8++;
            } else {
                break;
            }
        }
        this.A05 = i7;
        this.A0G = AbstractC02937i.A02(i3) == 128;
        this.A0F = AbstractC02937i.A04(i3) == 64;
        this.A01 = C03389h.A07(super.A02.A0W);
        this.A08 = A00(i3, requiredAdaptiveSupport);
    }

    private int A00(int i, int i2) {
        if ((super.A02.A0E & 16384) != 0 || !C03389h.A0S(i, this.A09.A0B)) {
            return 0;
        }
        if (!this.A0C && !this.A09.A0C) {
            return 0;
        }
        if (C03389h.A0S(i, false) && this.A0D && this.A0C && super.A02.A05 != -1 && !this.A09.A0N && !this.A09.A0O && (i & i2) != 0) {
            return 2;
        }
        return 1;
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D56211926, support language flag in video track")
    public static int A01(C1794nF c1794nF, C1794nF c1794nF2) {
        AbstractC1833ns abstractC1833nsA09 = AbstractC1833ns.A01().A09(c1794nF.A0E, c1794nF2.A0E).A08(Integer.valueOf(c1794nF.A03), Integer.valueOf(c1794nF2.A03), AbstractC1983qK.A03().A06()).A06(c1794nF.A04, c1794nF2.A04).A06(c1794nF.A06, c1794nF2.A06).A09(c1794nF.A0B, c1794nF2.A0B).A06(c1794nF.A07, c1794nF2.A07).A09(c1794nF.A0C, c1794nF2.A0C).A09(c1794nF.A0D, c1794nF2.A0D).A08(Integer.valueOf(c1794nF.A05), Integer.valueOf(c1794nF2.A05), AbstractC1983qK.A03().A06()).A09(c1794nF.A0G, c1794nF2.A0G).A09(c1794nF.A0F, c1794nF2.A0F);
        if (c1794nF.A0G && c1794nF.A0F) {
            int i = c1794nF.A01;
            int i2 = c1794nF2.A01;
            if (A0H[4].charAt(7) == 'c') {
                throw new RuntimeException();
            }
            A0H[4] = "L7q4oO3o2NLjefqLZehpujqtxzeKbA5O";
            abstractC1833nsA09 = abstractC1833nsA09.A06(i, i2);
        }
        int iA05 = abstractC1833nsA09.A05();
        if (A0H[7].charAt(14) != 'M') {
            return iA05;
        }
        A0H[0] = "TVm4CsN40i91TfwfawYUT3UYECpWhhhJ";
        return iA05;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qK != com.google.common.collect.Ordering<java.lang.Integer> */
    public static int A02(C1794nF c1794nF, C1794nF c1794nF2) {
        AbstractC1983qK abstractC1983qKA06;
        AbstractC1983qK abstractC1983qKA062 = (c1794nF.A0C && c1794nF.A0E) ? C03389h.A09 : C03389h.A09.A06();
        AbstractC1833ns abstractC1833nsA01 = AbstractC1833ns.A01();
        Integer numValueOf = Integer.valueOf(c1794nF.A00);
        Integer numValueOf2 = Integer.valueOf(c1794nF2.A00);
        boolean z = c1794nF.A09.A0O;
        String[] strArr = A0H;
        if (strArr[6].charAt(5) == strArr[5].charAt(5)) {
            throw new RuntimeException();
        }
        A0H[4] = "07GlML0JAKsk4TXVd5GQtUxHkz6E2kCF";
        if (z) {
            abstractC1983qKA06 = C03389h.A09.A06();
        } else {
            abstractC1983qKA06 = C03389h.A0A;
        }
        return abstractC1833nsA01.A08(numValueOf, numValueOf2, abstractC1983qKA06).A08(Integer.valueOf(c1794nF.A02), Integer.valueOf(c1794nF2.A02), abstractC1983qKA062).A08(Integer.valueOf(c1794nF.A00), Integer.valueOf(c1794nF2.A00), abstractC1983qKA062).A05();
    }

    public static int A05(List<C1794nF> list, List<C1794nF> list2) {
        return AbstractC1833ns.A01().A08((C1794nF) Collections.max(list, new Comparator() { // from class: com.facebook.ads.redexgen.X.Ei
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C1794nF.A01((C1794nF) obj, (C1794nF) obj2);
            }
        }), (C1794nF) Collections.max(list2, new Comparator() { // from class: com.facebook.ads.redexgen.X.Ei
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C1794nF.A01((C1794nF) obj, (C1794nF) obj2);
            }
        }), new Comparator() { // from class: com.facebook.ads.redexgen.X.Ei
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C1794nF.A01((C1794nF) obj, (C1794nF) obj2);
            }
        }).A06(list.size(), list2.size()).A08((C1794nF) Collections.max(list, new Comparator() { // from class: com.facebook.ads.redexgen.X.Ej
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C1794nF.A02((C1794nF) obj, (C1794nF) obj2);
            }
        }), (C1794nF) Collections.max(list2, new Comparator() { // from class: com.facebook.ads.redexgen.X.Ej
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C1794nF.A02((C1794nF) obj, (C1794nF) obj2);
            }
        }), new Comparator() { // from class: com.facebook.ads.redexgen.X.Ej
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C1794nF.A02((C1794nF) obj, (C1794nF) obj2);
            }
        }).A05();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.google.common.collect.ImmutableList$Builder<com.facebook.ads.androidx.media3.exoplayer.trackselection.DefaultTrackSelector$VideoTrackInfo> */
    public static BP<C1794nF> A06(int pixelCount, C1944pg c1944pg, C03399i c03399i, int[] iArr, String str, int i) {
        int iA03 = C03389h.A03(c1944pg, ((C1940pc) c03399i).A0F, ((C1940pc) c03399i).A0E, c03399i.A0Q);
        C2K c2kA01 = BP.A01();
        int i2 = 0;
        while (true) {
            int i3 = c1944pg.A01;
            String[] strArr = A0H;
            if (strArr[1].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0H;
            strArr2[6] = "2BgCu4KRvJ20zb7ljNDccj45OL5WeAVY";
            strArr2[5] = "2mW0v3SSZTDHEKi4uYotr9FneqRXRzcE";
            if (i2 < i3) {
                int iA06 = c1944pg.A08(i2).A06();
                c2kA01.A04(new C1794nF(pixelCount, c1944pg, i2, c03399i, iArr[i2], str, i, iA03 == Integer.MAX_VALUE || (iA06 != -1 && iA06 <= iA03)));
                i2++;
            } else {
                return c2kA01.A05();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC0455Eh
    /* JADX INFO: renamed from: A07, reason: merged with bridge method [inline-methods] */
    public final boolean A09(C1794nF c1794nF) {
        if (this.A0A || C5C.A1E(super.A02.A0W, ((AbstractC0455Eh) c1794nF).A02.A0W)) {
            if (!this.A09.A05) {
                if (this.A0G == c1794nF.A0G) {
                    boolean z = this.A0F;
                    if (A0H[7].charAt(14) != 'M') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0H;
                    strArr[1] = "O482IHGDjbokfcz29RQKjL9l7";
                    strArr[2] = "cI8rqKrS6U71hTMAagWNF9taj";
                    if (z == c1794nF.A0F) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0455Eh
    public final int A08() {
        return this.A08;
    }
}
