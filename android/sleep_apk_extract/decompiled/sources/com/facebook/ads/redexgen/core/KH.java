package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class KH extends AbstractRunnableC0908Wc {
    public final /* synthetic */ KE A00;

    public KH(KE ke) {
        this.A00 = ke;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        if (!this.A00.A0Y) {
            YB.A0F(1000, this.A00.A0K);
        }
        this.A00.postDelayed(this, 2000L);
    }
}
