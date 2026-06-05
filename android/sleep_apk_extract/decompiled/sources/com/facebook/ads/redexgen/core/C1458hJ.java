package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1458hJ extends AbstractRunnableC0908Wc {
    public final /* synthetic */ C1457hI A00;
    public final /* synthetic */ AnonymousClass62 A01;

    public C1458hJ(C1457hI c1457hI, AnonymousClass62 anonymousClass62) {
        this.A00 = c1457hI;
        this.A01 = anonymousClass62;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        this.A01.setAdViewabilityChecker(this.A00.A02.A1G());
        this.A00.A02.A1o(true, true);
    }
}
