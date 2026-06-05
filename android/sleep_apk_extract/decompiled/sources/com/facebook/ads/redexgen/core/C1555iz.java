package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1555iz extends AbstractRunnableC0908Wc {
    public final /* synthetic */ C1608jz A00;
    public final /* synthetic */ O8 A01;
    public final /* synthetic */ C02947j A02;

    public C1555iz(C02947j c02947j, O8 o8, C1608jz c1608jz) {
        this.A02 = c02947j;
        this.A01 = o8;
        this.A00 = c1608jz;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        this.A02.A0T(this.A01);
        this.A02.A0Q(this.A00);
        this.A02.A00 = null;
        C0893Vm c0893VmA00 = C0893Vm.A00(AdErrorType.INTERSTITIAL_AD_TIMEOUT);
        this.A02.A0B.A0F().A5g(c0893VmA00.A03().getErrorCode(), c0893VmA00.A04());
        this.A02.A07.A0G(c0893VmA00);
    }
}
