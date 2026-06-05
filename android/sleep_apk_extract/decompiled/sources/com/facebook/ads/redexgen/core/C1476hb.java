package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1476hb extends PL {
    public final PL A00 = new C1479he(this);
    public final C7M A01;

    public C1476hb(C7M c7m) {
        this.A01 = c7m;
    }

    @Override // com.facebook.ads.redexgen.core.PL
    public final void A07(View view, AccessibilityEvent accessibilityEvent) {
        super.A07(view, accessibilityEvent);
        accessibilityEvent.setClassName(C7M.class.getName());
        if ((view instanceof C7M) && !A0B()) {
            C7M c7m = (C7M) view;
            if (c7m.getLayoutManager() != null) {
                c7m.getLayoutManager().A1v(accessibilityEvent);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.PL
    public final void A08(View view, Q6 q6) {
        super.A08(view, q6);
        q6.A0O(C7M.class.getName());
        if (!A0B() && this.A01.getLayoutManager() != null) {
            this.A01.getLayoutManager().A1H(q6);
        }
    }

    @Override // com.facebook.ads.redexgen.core.PL
    public final boolean A09(View view, int i, Bundle bundle) {
        if (super.A09(view, i, bundle)) {
            return true;
        }
        if (!A0B() && this.A01.getLayoutManager() != null) {
            return this.A01.getLayoutManager().A1X(i, bundle);
        }
        return false;
    }

    public final PL A0A() {
        return this.A00;
    }

    public final boolean A0B() {
        return this.A01.A1r();
    }
}
