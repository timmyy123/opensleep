package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0510Gl implements InterfaceC0955Ya {
    public final /* synthetic */ AbstractC0508Gj A00;

    public C0510Gl(AbstractC0508Gj abstractC0508Gj) {
        this.A00 = abstractC0508Gj;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0955Ya
    public final void ACl(AbstractC0956Yb abstractC0956Yb) {
        if (abstractC0956Yb.getToolbarActionMode() == 8) {
            this.A00.A0g();
            return;
        }
        this.A00.A07.A04(VH.A07, null);
        if (this.A00.A0l()) {
            return;
        }
        this.A00.A05.A0F().AB0();
        this.A00.A0A.A4j(this.A00.A0B.A7w());
    }
}
