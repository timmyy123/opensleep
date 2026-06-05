package com.facebook.ads.redexgen.core;

import com.facebook.ads.CacheFlag;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C02947j extends AbstractC1556j0 {
    public C02947j(C1421gi c1421gi, O7 o7) {
        super(c1421gi, o7);
    }

    private C1554iy A00(Runnable runnable) {
        return new C1554iy(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1556j0
    public final NQ A0I() {
        C1608jz successfullyLoadedAdapter = (C1608jz) this.A01;
        if (successfullyLoadedAdapter != null) {
            return successfullyLoadedAdapter.A09();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1556j0
    public final void A0P() {
        C1608jz interstitialAdapter = (C1608jz) this.A01;
        interstitialAdapter.A0B();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1556j0
    public final void A0R(N1 n1, C0852Tw c0852Tw, C0850Tu c0850Tu, O8 o8) {
        C1608jz c1608jz = (C1608jz) n1;
        C1555iz c1555iz = new C1555iz(this, o8, c1608jz);
        A0H().postDelayed(c1555iz, c0852Tw.A05().A05());
        EnumSet<CacheFlag> enumSet = this.A08.A0B;
        if (enumSet == null) {
            enumSet = CacheFlag.ALL;
        }
        c1608jz.A0A(this.A0B, A00(c1555iz), o8, enumSet, this.A08.A04, this.A08.A05, this.A08.A02);
    }
}
