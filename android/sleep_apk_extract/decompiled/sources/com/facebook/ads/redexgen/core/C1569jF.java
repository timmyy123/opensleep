package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1569jF implements SM {
    public final /* synthetic */ AbstractC1586jd A00;
    public final /* synthetic */ InterfaceC0698Nt A01;
    public final /* synthetic */ C0699Nu A02;
    public final /* synthetic */ C1421gi A03;
    public final /* synthetic */ boolean A04;

    public C1569jF(C0699Nu c0699Nu, C1421gi c1421gi, boolean z, AbstractC1586jd abstractC1586jd, InterfaceC0698Nt interfaceC0698Nt) {
        this.A02 = c0699Nu;
        this.A03 = c1421gi;
        this.A04 = z;
        this.A00 = abstractC1586jd;
        this.A01 = interfaceC0698Nt;
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACx() {
        if (C0871Up.A1q(this.A03) && this.A04) {
            this.A02.A02.add(AbstractC1206dD.A01(this.A03, this.A00, 1, new C1570jG(this)));
        } else {
            this.A01.ACp();
        }
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACy() {
        this.A01.ACo(AdError.CACHE_ERROR);
    }
}
