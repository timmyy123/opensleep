package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1975qC implements AnonymousClass24 {
    public final long A00;
    public final long A01;
    public final boolean A02;
    public final boolean A03;
    public final boolean A04;
    public static final C1975qC A06 = new C01782v().A0A();
    public static final AnonymousClass23<AW> A05 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.qD
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return new C01782v().A06(bundle.getLong(C1975qC.A01(0), 0L)).A05(bundle.getLong(C1975qC.A01(1), Long.MIN_VALUE)).A08(bundle.getBoolean(C1975qC.A01(2), false)).A07(bundle.getBoolean(C1975qC.A01(3), false)).A09(bundle.getBoolean(C1975qC.A01(4), false)).A0B();
        }
    };

    public C1975qC(C01782v c01782v) {
        this.A01 = c01782v.A01;
        this.A00 = c01782v.A00;
        this.A03 = c01782v.A03;
        this.A02 = c01782v.A02;
        this.A04 = c01782v.A04;
    }

    public static String A01(int i) {
        return Integer.toString(i, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1975qC)) {
            return false;
        }
        C1975qC c1975qC = (C1975qC) obj;
        return this.A01 == c1975qC.A01 && this.A00 == c1975qC.A00 && this.A03 == c1975qC.A03 && this.A02 == c1975qC.A02 && this.A04 == c1975qC.A04;
    }

    public final int hashCode() {
        return (((((((((int) (this.A01 ^ (this.A01 >>> 32))) * 31) + ((int) (this.A00 ^ (this.A00 >>> 32)))) * 31) + (this.A03 ? 1 : 0)) * 31) + (this.A02 ? 1 : 0)) * 31) + (this.A04 ? 1 : 0);
    }
}
