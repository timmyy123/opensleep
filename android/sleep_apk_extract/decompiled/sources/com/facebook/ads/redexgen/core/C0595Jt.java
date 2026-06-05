package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0595Jt implements InterfaceC1099bU {
    public final /* synthetic */ C0584Ji A00;

    public C0595Jt(C0584Ji c0584Ji) {
        this.A00 = c0584Ji;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1099bU
    public final void ADY() {
        this.A00.A0Y.A04(VH.A0J, null);
        if (this.A00.A0W != null) {
            this.A00.A0m(((AnonymousClass85) this.A00.A0W).A0M().toString());
        }
        if (this.A00.A0b.A0D() != null) {
            this.A00.A0b.A0D().ACQ();
        }
        if (this.A00.A09 != null) {
            this.A00.A09.A0B();
            this.A00.A09 = null;
        }
        this.A00.A0q(true);
    }
}
