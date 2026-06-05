package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class EN extends UN<E3> {
    public final /* synthetic */ C4L A00;

    public EN(C4L c4l) {
        this.A00 = c4l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.UN
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(E3 e3) {
        if (!this.A00.A02) {
            this.A00.A02 = true;
        } else {
            this.A00.A0d();
        }
    }

    @Override // com.facebook.ads.redexgen.core.UN
    public final Class<E3> A01() {
        return E3.class;
    }
}
