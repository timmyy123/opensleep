package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class WX extends UO<String> {
    public final /* synthetic */ V7 A00;
    public final /* synthetic */ WW A01;

    public WX(WW ww, V7 v7) {
        this.A01 = ww;
        this.A00 = v7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.UO
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A02(String str) {
        super.A02(str);
        if (this.A00.A0B()) {
            this.A01.A02.A62();
        } else {
            this.A01.A02.A61();
        }
    }

    @Override // com.facebook.ads.redexgen.core.UO
    public final void A01(int i, String str) {
        super.A01(i, str);
    }
}
