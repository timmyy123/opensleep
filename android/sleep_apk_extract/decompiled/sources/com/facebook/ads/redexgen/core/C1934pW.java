package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1934pW implements AnonymousClass24 {
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public static String[] A04 = {"W5WZRfo3traFBsuJqUeacov", "AOz8vYfc0kUMyRrWtsrS4pOQsYE8BP6P", "ocEUeDJ9UZl7Q6o8h21wMsDJowBHj84j", "pkgO1YjXdbsvKDgws3J49uWJB6yyqkG7", "vCvp8tg1JPxrxhdMnot9YI84PFBkssaD", "Dazl9IXOnyCH5QLsvPseWpscLh5D5M0t", "ZYJ1zYUUdaXBOvkE2t6KLICz8MhT9p2M", "ySOVjFSAiUWhoASiDo2jZct"};
    public static final C1934pW A06 = new C1934pW(0, 0);
    public static final String A0A = C5C.A0h(0);
    public static final String A07 = C5C.A0h(1);
    public static final String A09 = C5C.A0h(2);
    public static final String A08 = C5C.A0h(3);
    public static final AnonymousClass23<C1934pW> A05 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pX
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C1934pW.A00(bundle);
        }
    };

    public C1934pW(int i, int i2) {
        this(i, i2, 0, 1.0f);
    }

    public C1934pW(int i, int i2, int i3, float f) {
        this.A03 = i;
        this.A01 = i2;
        this.A02 = i3;
        this.A00 = f;
    }

    public static /* synthetic */ C1934pW A00(Bundle bundle) {
        int i = bundle.getInt(A0A, 0);
        int i2 = bundle.getInt(A07, 0);
        int height = bundle.getInt(A09, 0);
        return new C1934pW(i, i2, height, bundle.getFloat(A08, 1.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        boolean z = obj instanceof C1934pW;
        String[] strArr = A04;
        if (strArr[4].charAt(6) == strArr[2].charAt(6)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[4] = "xwJKUsQcskzDCgeEWIG9ozPdTsTzWcW9";
        strArr2[2] = "cRblKPLDWf1oyG1RJoVr7n5QNKGN7idl";
        if (!z) {
            return false;
        }
        C1934pW c1934pW = (C1934pW) obj;
        return this.A03 == c1934pW.A03 && this.A01 == c1934pW.A01 && this.A02 == c1934pW.A02 && this.A00 == c1934pW.A00;
    }

    public final int hashCode() {
        int result = this.A03;
        int result2 = ((((7 * 31) + result) * 31) + this.A01) * 31;
        int result3 = this.A02;
        return ((result2 + result3) * 31) + Float.floatToRawIntBits(this.A00);
    }
}
