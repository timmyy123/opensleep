package com.facebook.ads.redexgen.core;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C02836y implements InterfaceC0851Tv {
    public NativeAdBase A00;
    public NativeAdListener A01;

    public C02836y(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        this.A01 = nativeAdListener;
        this.A00 = nativeAdBase;
    }

    @Override // com.facebook.ads.redexgen.core.VP
    public final void ACm() {
        WT.A00(new C0846Tq(this));
    }

    @Override // com.facebook.ads.redexgen.core.VP
    public final void ACq() {
        WT.A00(new C0847Tr(this));
    }

    @Override // com.facebook.ads.redexgen.core.VP
    public final void ADp(C0893Vm c0893Vm) {
        WT.A00(new C0849Tt(this, c0893Vm));
    }

    @Override // com.facebook.ads.redexgen.core.VP
    public final void AEl() {
        WT.A00(new C0845Tp(this));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0851Tv
    public final void AEq() {
        WT.A00(new C0848Ts(this));
    }
}
