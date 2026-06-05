package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0821Sr extends AbstractRunnableC0908Wc {
    public final /* synthetic */ long A00;
    public final /* synthetic */ WA A01;
    public final /* synthetic */ WD A02;
    public final /* synthetic */ String A03;

    public C0821Sr(WD wd, String str, long j, WA wa) {
        this.A02 = wd;
        this.A03 = str;
        this.A00 = j;
        this.A01 = wa;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        this.A02.A0N(this.A03, this.A00, this.A01);
    }
}
