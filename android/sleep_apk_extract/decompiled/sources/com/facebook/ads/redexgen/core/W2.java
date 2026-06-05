package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class W2 implements InterfaceC1077b8 {
    public final /* synthetic */ C0905Vz A00;

    public W2(C0905Vz c0905Vz) {
        this.A00 = c0905Vz;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1077b8
    public final void AE7(C1076b7 c1076b7) {
        this.A00.A0G.set(c1076b7.A00() != null);
        if (this.A00.A0H.get() && this.A00.A05 != null) {
            this.A00.A05.AFB(c1076b7.A00() != null);
        }
    }
}
