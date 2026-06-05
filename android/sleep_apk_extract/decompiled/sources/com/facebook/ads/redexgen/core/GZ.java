package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class GZ extends AbstractRunnableC0908Wc {
    public final /* synthetic */ C02304x A00;

    public GZ(C02304x c02304x) {
        this.A00 = c02304x;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        if (this.A00.A00 != null && this.A00.A00.A1N()) {
            ((AbstractC0508Gj) this.A00).A02 = true;
            this.A00.A09.setToolbarActionMode(8);
        }
    }
}
