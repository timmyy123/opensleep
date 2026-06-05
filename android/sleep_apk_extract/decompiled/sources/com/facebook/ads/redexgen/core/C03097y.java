package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C03097y extends AbstractC1560j4 {
    public final /* synthetic */ C03077w A00;
    public final /* synthetic */ AbstractC1590jh A01;
    public final /* synthetic */ C02967l A02;
    public final /* synthetic */ boolean A03;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C03097y(C03077w c03077w, boolean z, boolean z2, C02967l c02967l, AbstractC1590jh abstractC1590jh) {
        super(z);
        this.A00 = c03077w;
        this.A03 = z2;
        this.A02 = c02967l;
        this.A01 = abstractC1590jh;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1560j4
    public final void A00() {
        this.A00.A01.AFp(this.A01, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1560j4
    public final void A01(boolean z) {
        if (!C0871Up.A1t(this.A00.A04) || !this.A03) {
            if (this.A00.A05 == WK.A0J) {
                this.A00.A04.A0F().AER();
            }
            this.A00.A0C.set(true);
            this.A00.A01.AFm(this.A01);
            return;
        }
        this.A00.A06 = AbstractC1206dD.A01(this.A00.A04, this.A02, 0, new C1599jq(this));
    }
}
