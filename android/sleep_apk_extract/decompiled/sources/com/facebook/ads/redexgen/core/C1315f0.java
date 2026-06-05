package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1315f0 implements InterfaceC0832Tc {
    public final T8 A00;

    public C1315f0(T8 t8) {
        this.A00 = t8;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0832Tc
    public final void A4I(Throwable th) {
        TX.A0E(th);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0832Tc
    public final void AA3(String str) {
        VL.A08(this.A00, str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0832Tc
    public final void AA4(String str) {
        VL.A09(this.A00, str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0832Tc
    public final void ABC(String str, int i, C0834Te c0834Te) {
        TX.A06(this.A00, str, i, c0834Te);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0832Tc
    public final void ABD(String str, int i, C0834Te c0834Te) {
        TX.A06(this.A00, str, i, c0834Te);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0832Tc
    public final void ABo(long j, long j2, long j3, long j4, int i, Exception exc) {
        AbstractC0838Ti.A03(this.A00, j, j2, j3, j4, i, exc);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0832Tc
    public final void ABz(String str, int i, C0834Te c0834Te) {
        TX.A07(this.A00, str, i, c0834Te);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0832Tc
    public final void ACA(String str, int i, C0834Te c0834Te) {
        TX.A08(this.A00, str, i, c0834Te);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0832Tc
    public final void ACP() {
        this.A00.A04().ACP();
    }
}
