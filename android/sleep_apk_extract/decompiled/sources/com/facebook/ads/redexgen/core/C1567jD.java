package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1567jD implements InterfaceC0819Sp {
    public final /* synthetic */ AbstractC1586jd A00;
    public final /* synthetic */ InterfaceC0698Nt A01;
    public final /* synthetic */ C0699Nu A02;
    public final /* synthetic */ C1421gi A03;
    public final /* synthetic */ boolean A04;

    public C1567jD(C0699Nu c0699Nu, C1421gi c1421gi, boolean z, AbstractC1586jd abstractC1586jd, InterfaceC0698Nt interfaceC0698Nt) {
        this.A02 = c0699Nu;
        this.A03 = c1421gi;
        this.A04 = z;
        this.A00 = abstractC1586jd;
        this.A01 = interfaceC0698Nt;
    }

    private void A00(boolean z) {
        if (z) {
            if (C0871Up.A1q(this.A03) && this.A04) {
                this.A02.A02.add(AbstractC1206dD.A01(this.A03, this.A00, 1, new C1568jE(this)));
                return;
            } else {
                this.A01.ACp();
                return;
            }
        }
        this.A01.ACo(AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0819Sp
    public final void ADL() {
        A00(false);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0819Sp
    public final void ADT() {
        A00(true);
    }
}
