package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0n, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0n extends C0q {
    @Override // com.facebook.ads.redexgen.core.C0737Pg
    public final C0752Py A07(View view, C0752Py c0752Py) {
        WindowInsets result = (WindowInsets) C0752Py.A01(c0752Py);
        WindowInsets unwrapped = view.dispatchApplyWindowInsets(result);
        if (unwrapped != result) {
            result = new WindowInsets(unwrapped);
        }
        return C0752Py.A00(result);
    }

    @Override // com.facebook.ads.redexgen.core.C0737Pg
    public final C0752Py A08(View view, C0752Py c0752Py) {
        WindowInsets result = (WindowInsets) C0752Py.A01(c0752Py);
        WindowInsets unwrapped = view.onApplyWindowInsets(result);
        if (unwrapped != result) {
            result = new WindowInsets(unwrapped);
        }
        return C0752Py.A00(result);
    }

    @Override // com.facebook.ads.redexgen.core.C0737Pg
    public final void A0A(View view) {
        view.stopNestedScroll();
    }

    @Override // com.facebook.ads.redexgen.core.C0737Pg
    public final void A0E(View view, PR pr) {
        if (pr == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC0736Pf(this, pr));
        }
    }
}
