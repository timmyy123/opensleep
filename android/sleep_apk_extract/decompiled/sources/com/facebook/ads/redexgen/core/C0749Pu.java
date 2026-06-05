package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0749Pu implements Comparator<View> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(View view, View view2) {
        C0743Po c0743Po = (C0743Po) view.getLayoutParams();
        C0743Po c0743Po2 = (C0743Po) view2.getLayoutParams();
        if (c0743Po.A05 != c0743Po2.A05) {
            return c0743Po.A05 ? 1 : -1;
        }
        return c0743Po.A02 - c0743Po2.A02;
    }
}
