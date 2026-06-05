package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class K6 extends AbstractRunnableC0908Wc {
    public final /* synthetic */ C0584Ji A00;
    public final /* synthetic */ boolean A01;

    public K6(C0584Ji c0584Ji, boolean z) {
        this.A00 = c0584Ji;
        this.A01 = z;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        AbstractC0956Yb abstractC0956YbA0B = this.A00.A0b.A0B();
        if (abstractC0956YbA0B == null) {
            return;
        }
        abstractC0956YbA0B.setPageDetailsVisible((this.A01 || abstractC0956YbA0B.A0E()) ? false : true);
        abstractC0956YbA0B.setToolbarActionMode(this.A00.getCloseButtonStyle());
    }
}
