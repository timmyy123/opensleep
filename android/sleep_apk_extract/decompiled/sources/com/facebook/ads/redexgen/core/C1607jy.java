package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1607jy implements Z1 {
    public final /* synthetic */ AnonymousClass80 A00;
    public final /* synthetic */ AnonymousClass76 A01;

    public C1607jy(AnonymousClass80 anonymousClass80, AnonymousClass76 anonymousClass76) {
        this.A00 = anonymousClass80;
        this.A01 = anonymousClass76;
    }

    @Override // com.facebook.ads.redexgen.core.Z1
    public final void AEA() {
        this.A01.A0F().A4Q(this.A00.A03 != null);
        if (this.A00.A03 != null) {
            this.A00.A03.A03();
        }
    }
}
