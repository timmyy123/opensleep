package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0514Gp implements InterfaceC0960Yf {
    public final /* synthetic */ AbstractC0508Gj A00;

    public C0514Gp(AbstractC0508Gj abstractC0508Gj) {
        this.A00 = abstractC0508Gj;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0960Yf
    public final void AEZ(int i) {
        this.A00.A0d();
        if (this.A00.A01 != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = i;
            this.A00.A01.setLayoutParams(layoutParams);
        }
    }
}
