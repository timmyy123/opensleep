package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.q7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1970q7 implements AnonymousClass24 {
    public final C1975qC A00;

    @Deprecated
    public final AW A01;
    public final C1973qA A02;
    public final AnonymousClass32 A03;

    @Deprecated
    public final C1972q9 A04;
    public final C1965q2 A05;
    public final String A06;
    public static String[] A07 = {"wAM8vtdO0lmHfSdh0aX8JSKdnwpCp9D2", "", "J6SB4ddL0FfEeVIHYuGnUGetWM2QRdUO", "0HTq7SjPEUFdYYph8tikUta3pLjb69Rn", "wGA6vSFg01QHk42FD2L8p637KRkqAXcn", "9eG6h6QaFREs2gWO0", "Z5vutuZNVsi2rK7c87KXUNl8wBJYnGEL", "V2BGt2aUfGoyLxnwwGFsOMeTNor3H3xe"};
    public static final C1970q7 A09 = new C01772u().A05();
    public static final AnonymousClass23<C1970q7> A08 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.qE
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C1970q7.A00(bundle);
        }
    };

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 8 out of bounds for length 8
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C1970q7 A00(Bundle bundle) {
        String str = (String) AbstractC02053y.A01(bundle.getString(A02(0), ""));
        Bundle bundle2 = bundle.getBundle(A02(1));
        C1973qA c1973qA = bundle2 == null ? C1973qA.A07 : (C1973qA) C1973qA.A06.A6f(bundle2);
        Bundle bundle3 = bundle.getBundle(A02(2));
        C1965q2 c1965q2 = bundle3 == null ? C1965q2.A0Z : (C1965q2) C1965q2.A0Y.A6f(bundle3);
        Bundle bundle4 = bundle.getBundle(A02(3));
        return new C1970q7(str, bundle4 == null ? AW.A00 : (AW) C1975qC.A05.A6f(bundle4), null, c1973qA, c1965q2);
    }

    public C1970q7(String str, AW aw, C1972q9 c1972q9, C1973qA c1973qA, C1965q2 c1965q2) {
        this.A06 = str;
        this.A03 = c1972q9;
        this.A04 = c1972q9;
        this.A02 = c1973qA;
        this.A05 = c1965q2;
        this.A00 = aw;
        this.A01 = aw;
    }

    public static String A02(int i) {
        return Integer.toString(i, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1970q7)) {
            return false;
        }
        C1970q7 c1970q7 = (C1970q7) obj;
        if (C5C.A1E(this.A06, c1970q7.A06)) {
            C1975qC c1975qC = this.A00;
            C1975qC c1975qC2 = c1970q7.A00;
            String[] strArr = A07;
            if (strArr[7].charAt(22) != strArr[2].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[7] = "WE1TlvFnuMEFfhCqOSZQGPel0cAOxnij";
            strArr2[2] = "QIjSvgjDyRqWUwkha5pDZVewjWBdao8T";
            if (c1975qC.equals(c1975qC2) && C5C.A1E(this.A03, c1970q7.A03) && C5C.A1E(this.A02, c1970q7.A02) && C5C.A1E(this.A05, c1970q7.A05)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A06.hashCode();
        int i = result * 31;
        int result2 = this.A03 != null ? this.A03.hashCode() : 0;
        int iHashCode = (((i + result2) * 31) + this.A02.hashCode()) * 31;
        C1975qC c1975qC = this.A00;
        String[] strArr = A07;
        String str = strArr[4];
        String str2 = strArr[3];
        int iCharAt = str.charAt(31);
        int result3 = str2.charAt(31);
        if (iCharAt != result3) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[7] = "oKnJE1KY80M0C2djBAWfSHeSjkObNKTB";
        strArr2[2] = "bdrBBUaZbF1SVnsIGw0ZL6eMFfyDgZAn";
        int result4 = c1975qC.hashCode();
        return ((iHashCode + result4) * 31) + this.A05.hashCode();
    }
}
