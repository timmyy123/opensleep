package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class M7 implements InterfaceC1060ar {
    public final /* synthetic */ M6 A00;

    public M7(M6 m6) {
        this.A00 = m6;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1060ar
    public final void ADB(boolean z) {
        this.A00.A0D(z);
        if (this.A00.A0B && this.A00.A00 != null) {
            this.A00.A00.setEnabled(z);
            this.A00.A00.setAlpha(z ? 1.0f : 0.3f);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1060ar
    public final void ADx(boolean z) {
        this.A00.A0D(z);
        if (this.A00.A0B && this.A00.A02 != null) {
            this.A00.A02.setEnabled(z);
            this.A00.A02.setAlpha(z ? 1.0f : 0.3f);
        }
    }
}
