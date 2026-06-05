package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0543Hs extends AbstractRunnableC0908Wc {
    public final /* synthetic */ C5F A00;

    public C0543Hs(C5F c5f) {
        this.A00 = c5f;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        YB.A0F(1000, this.A00.A0H);
        this.A00.postDelayed(this, 2000L);
    }
}
