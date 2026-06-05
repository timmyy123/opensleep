package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0613Kl extends AbstractRunnableC0908Wc {
    public final /* synthetic */ AbstractC1106bb A00;

    public C0613Kl(AbstractC1106bb abstractC1106bb) {
        this.A00 = abstractC1106bb;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        this.A00.setPressed(false);
        this.A00.postOnAnimationDelayed(this.A00.A09, this.A00.A08);
    }
}
