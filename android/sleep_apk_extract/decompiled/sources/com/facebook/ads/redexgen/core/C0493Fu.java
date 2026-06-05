package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0493Fu implements InterfaceC0789Rk {
    public final /* synthetic */ C0783Re A00;
    public final /* synthetic */ C4U A01;

    public C0493Fu(C4U c4u, C0783Re c0783Re) {
        this.A01 = c4u;
        this.A00 = c0783Re;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0789Rk
    public final boolean AAI() {
        if (!this.A01.A0i()) {
            if (this.A01.A0j()) {
                return true;
            }
            return this.A01.A0k();
        }
        this.A01.A0h(this.A00);
        return true;
    }
}
