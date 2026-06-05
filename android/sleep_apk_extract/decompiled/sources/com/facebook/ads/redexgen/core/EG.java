package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class EG extends AbstractC0708Od {
    public final /* synthetic */ EF A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EG(EF ef, double d, double d2, double d3, boolean z) {
        super(d, d2, d3, z);
        this.A00 = ef;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0708Od
    public final void A00(boolean z, boolean z2, C0710Of c0710Of) {
        if ((!C0871Up.A0z(this.A00.A0D) || !this.A00.A0A) && z2) {
            this.A00.A0A = true;
            this.A00.A0R(this.A00.A0J, this.A00.A0J(EnumC1299ek.A0B));
        }
    }
}
