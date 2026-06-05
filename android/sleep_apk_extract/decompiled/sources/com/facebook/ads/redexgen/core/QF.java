package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class QF implements InterfaceC0946Xr {
    public final C0945Xq A00;
    public final InterfaceC0946Xr A01;

    public QF(InterfaceC0946Xr interfaceC0946Xr, int i, int i2) {
        this.A01 = interfaceC0946Xr;
        this.A00 = new C0945Xq(i, i2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0946Xr
    public final void AH8(String str) {
        this.A00.A04(str);
        if (this.A00.A02() != null && AbstractC0948Xt.A08(this.A00)) {
            this.A01.AH8(this.A00.A02());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0946Xr
    public final void flush() {
        this.A00.A03();
        while (this.A00.A02() != null) {
            if (AbstractC0948Xt.A08(this.A00)) {
                this.A01.AH8(this.A00.A02());
            }
            this.A00.A03();
        }
    }
}
