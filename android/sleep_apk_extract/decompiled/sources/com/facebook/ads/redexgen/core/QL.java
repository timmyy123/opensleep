package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class QL implements InterfaceC0946Xr {
    public int A00;
    public final InterfaceC0946Xr A01;
    public final InterfaceC0946Xr A02;

    public QL(InterfaceC0946Xr interfaceC0946Xr, int i, InterfaceC0946Xr interfaceC0946Xr2) {
        this.A01 = interfaceC0946Xr;
        this.A00 = i;
        this.A02 = interfaceC0946Xr2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0946Xr
    public final void AH8(String str) {
        if (this.A00 > 0) {
            this.A01.AH8(str);
            this.A01.flush();
            this.A00--;
            return;
        }
        this.A02.AH8(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0946Xr
    public final void flush() {
        this.A02.flush();
    }
}
