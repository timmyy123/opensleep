package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0655Mb implements XN {
    public final /* synthetic */ MW A00;

    public C0655Mb(MW mw) {
        this.A00 = mw;
    }

    public /* synthetic */ C0655Mb(MW mw, C0666Mm c0666Mm) {
        this(mw);
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void ADS() {
        this.A00.A0D();
        if (!this.A00.A0R.get()) {
            if (this.A00.A0T || !this.A00.A0D) {
                if (this.A00.A0H.A0V()) {
                    this.A00.A0U.setToolbarActionMode(1);
                    return;
                } else {
                    this.A00.A0U.setToolbarActionMode(0);
                    return;
                }
            }
            this.A00.A0U.setToolbarActionMode(0);
        }
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void AFV(float f) {
        if (this.A00.A0H.A0A() > 0 && f == this.A00.A0H.A0A()) {
            this.A00.A0U.setToolbarActionMode(8);
        }
    }
}
