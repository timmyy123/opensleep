package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.it, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1549it extends AbstractRunnableC0908Wc {
    public final /* synthetic */ C03077w A00;
    public final /* synthetic */ O8 A01;
    public final /* synthetic */ C02857a A02;

    public C1549it(C02857a c02857a, O8 o8, C03077w c03077w) {
        this.A02 = c02857a;
        this.A01 = o8;
        this.A00 = c03077w;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        this.A02.A0T(this.A01);
        this.A02.A0Q(this.A00);
        this.A02.A00 = null;
        AdErrorType adErrorType = AdErrorType.RV_AD_TIMEOUT;
        this.A02.A0B.A0F().A5g(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
        this.A02.A07.A0G(new C0893Vm(adErrorType, ""));
    }
}
