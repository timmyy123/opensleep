package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class H0 implements XN {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractRunnableC0908Wc A01;
    public final /* synthetic */ AbstractC0508Gj A02;
    public final /* synthetic */ DZ A03;

    public H0(AbstractC0508Gj abstractC0508Gj, int i, DZ dz, AbstractRunnableC0908Wc abstractRunnableC0908Wc) {
        this.A02 = abstractC0508Gj;
        this.A00 = i;
        this.A03 = dz;
        this.A01 = abstractRunnableC0908Wc;
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void ADS() throws Throwable {
        this.A01.run();
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void AFV(float f) {
        this.A02.A09.setProgress(100.0f * (1.0f - (f / this.A00)));
        if (this.A03 != null) {
            DZ dz = this.A03;
            float percentage = this.A00;
            dz.A07((int) ((percentage - f) * 1000.0f));
        }
    }
}
