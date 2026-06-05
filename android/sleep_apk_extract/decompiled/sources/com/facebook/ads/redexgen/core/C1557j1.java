package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.j1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1557j1 extends AbstractRunnableC0908Wc {
    public final /* synthetic */ AbstractC1556j0 A00;
    public final /* synthetic */ C0893Vm A01;

    public C1557j1(AbstractC1556j0 abstractC1556j0, C0893Vm c0893Vm) {
        this.A00 = abstractC1556j0;
        this.A01 = c0893Vm;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        this.A00.A0B.A0F().A5g(this.A01.A03().getErrorCode(), this.A01.A04());
        if (this.A00.A07 != null) {
            this.A00.A07.A0G(this.A01);
        }
    }
}
