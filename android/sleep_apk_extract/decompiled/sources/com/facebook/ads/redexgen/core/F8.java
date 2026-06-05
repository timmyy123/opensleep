package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class F8 implements InterfaceC1391gE {
    public final /* synthetic */ C1289ea A00;

    public F8(C1289ea c1289ea) {
        this.A00 = c1289ea;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1391gE
    public final void AHA() {
        if (this.A00.A02 != null) {
            this.A00.A02.A4j(this.A00.A03.A94());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1391gE
    public final void AHC(C1393gG c1393gG) {
        if (this.A00.A02 == null) {
            return;
        }
        if (c1393gG == null || !c1393gG.A00()) {
            this.A00.A01.A0F().ABv();
            this.A00.A02.A4j(this.A00.A03.A94());
        } else {
            this.A00.A01.A0F().ABw();
            this.A00.A02.A4j(this.A00.A03.A95());
        }
    }
}
