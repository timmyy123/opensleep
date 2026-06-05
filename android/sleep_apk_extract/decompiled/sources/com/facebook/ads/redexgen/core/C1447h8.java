package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.h8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1447h8 extends WP {
    public final /* synthetic */ C1444h5 A00;
    public final /* synthetic */ C0893Vm A01;

    public C1447h8(C1444h5 c1444h5, C0893Vm c0893Vm) {
        this.A00 = c1444h5;
        this.A01 = c0893Vm;
    }

    @Override // com.facebook.ads.redexgen.core.WP
    public final void A01() {
        if (this.A00.A01.A00() != null) {
            this.A00.A01.A00().onAdError(XE.A00(this.A01));
        }
    }
}
