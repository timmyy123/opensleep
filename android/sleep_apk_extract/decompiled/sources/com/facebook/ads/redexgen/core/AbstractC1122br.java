package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.br, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1122br {
    public static final int A00 = YB.A00();

    public static void A00(C1421gi c1421gi, ViewGroup viewGroup, String str) {
        new LM(viewGroup, c1421gi).A07(str);
        View view = new View(c1421gi);
        view.setId(A00);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        YB.A0U(view, c1421gi);
        viewGroup.addView(view, 0);
    }
}
