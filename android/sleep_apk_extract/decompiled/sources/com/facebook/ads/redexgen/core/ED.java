package com.facebook.ads.redexgen.core;

import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class ED extends RelativeLayout implements InterfaceC1309eu {
    public C0458Ek A00;

    public ED(C1421gi c1421gi) {
        super(c1421gi);
    }

    public ED(C1421gi c1421gi, AttributeSet attributeSet, int i) {
        super(c1421gi, attributeSet, i);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(params);
    }

    public void A07() {
    }

    public void A08() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1309eu
    public final void AAv(C0458Ek c0458Ek) {
        this.A00 = c0458Ek;
        A07();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1309eu
    public final void AKV(C0458Ek c0458Ek) {
        A08();
        this.A00 = null;
    }

    public C0458Ek getVideoView() {
        return this.A00;
    }
}
