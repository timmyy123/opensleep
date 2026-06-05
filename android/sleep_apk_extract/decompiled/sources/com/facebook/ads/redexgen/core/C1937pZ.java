package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1937pZ implements AnonymousClass24 {
    public final int A00;
    public final C1944pg A01;
    public final boolean A02;
    public final int[] A03;
    public final boolean[] A04;
    public static final String A07 = C5C.A0h(0);
    public static final String A09 = C5C.A0h(1);
    public static final String A08 = C5C.A0h(3);
    public static final String A06 = C5C.A0h(4);
    public static final AnonymousClass23<C1937pZ> A05 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pa
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C1937pZ.A00(bundle);
        }
    };

    public C1937pZ(C1944pg c1944pg, boolean z, int[] iArr, boolean[] zArr) {
        this.A00 = c1944pg.A01;
        boolean z2 = false;
        AbstractC02053y.A07(this.A00 == iArr.length && this.A00 == zArr.length);
        this.A01 = c1944pg;
        if (z && this.A00 > 1) {
            z2 = true;
        }
        this.A02 = z2;
        this.A03 = (int[]) iArr.clone();
        this.A04 = (boolean[]) zArr.clone();
    }

    public static /* synthetic */ C1937pZ A00(Bundle bundle) {
        C1944pg c1944pg = (C1944pg) C1944pg.A06.A6f((Bundle) AbstractC02053y.A01(bundle.getBundle(A07)));
        int[] iArr = (int[]) AbstractC1644ka.A00(bundle.getIntArray(A09), new int[c1944pg.A01]);
        boolean[] selected = (boolean[]) AbstractC1644ka.A00(bundle.getBooleanArray(A08), new boolean[c1944pg.A01]);
        return new C1937pZ(c1944pg, bundle.getBoolean(A06, false), iArr, selected);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1937pZ c1937pZ = (C1937pZ) obj;
        if (this.A02 == c1937pZ.A02 && this.A01.equals(c1937pZ.A01) && Arrays.equals(this.A03, c1937pZ.A03) && Arrays.equals(this.A04, c1937pZ.A04)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.A01.hashCode() * 31) + (this.A02 ? 1 : 0)) * 31) + Arrays.hashCode(this.A03)) * 31) + Arrays.hashCode(this.A04);
    }
}
