package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0635Lh extends AbstractRunnableC0908Wc {
    public final WeakReference<C1366fp> A00;

    public C0635Lh(C1366fp c1366fp) {
        this.A00 = new WeakReference<>(c1366fp);
    }

    public C0635Lh(WeakReference<C1366fp> weakReference) {
        this.A00 = weakReference;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        C1366fp viewabilityChecker = this.A00.get();
        if (viewabilityChecker != null) {
            viewabilityChecker.A0U();
        }
    }
}
