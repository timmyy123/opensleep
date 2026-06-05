package com.facebook.ads.redexgen.core;

import android.os.Bundle;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AX extends AbstractC1956pt {
    public final boolean A00;
    public final boolean A01;
    public static final String A04 = C5C.A0h(1);
    public static final String A03 = C5C.A0h(2);
    public static final AnonymousClass23<AX> A02 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.qH
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return AX.A00(bundle);
        }
    };

    public AX() {
        this.A01 = false;
        this.A00 = false;
    }

    public AX(boolean z) {
        this.A01 = true;
        this.A00 = z;
    }

    public static AX A00(Bundle bundle) {
        boolean isRated = bundle.getInt(AbstractC1956pt.A02, -1) == 0;
        AbstractC02053y.A07(isRated);
        boolean isRated2 = bundle.getBoolean(A04, false);
        if (isRated2) {
            return new AX(bundle.getBoolean(A03, false));
        }
        return new AX();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AX)) {
            return false;
        }
        AX ax = (AX) obj;
        return this.A00 == ax.A00 && this.A01 == ax.A01;
    }

    public final int hashCode() {
        return CB.A00(Boolean.valueOf(this.A01), Boolean.valueOf(this.A00));
    }
}
