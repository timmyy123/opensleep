package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ep, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0463Ep extends AbstractRunnableC0908Wc {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C0458Ek A02;

    public C0463Ep(C0458Ek c0458Ek, int i, int i2) {
        this.A02 = c0458Ek;
        this.A00 = i;
        this.A01 = i2;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        this.A02.A0C.A02(new C0446Dy(this.A00, this.A01));
    }
}
