package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1643kZ implements InterfaceC0651Lx {
    public final InterfaceC0648Lu A00;

    public C1643kZ(InterfaceC0648Lu interfaceC0648Lu) {
        this.A00 = interfaceC0648Lu;
    }

    public final InterfaceC0648Lu A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0651Lx
    public final C8J ACL() {
        return new C8J(this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0651Lx
    public final C1647kd ACM() {
        return new C1647kd(this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0651Lx
    public final C1647kd ACN(String str) {
        return new C1647kd(this, str);
    }
}
