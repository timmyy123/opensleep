package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1489hp extends AbstractC0765Qm {
    public C1489hp(R2 r2) {
        super(r2, null);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A06() {
        return this.A02.A0j();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A07() {
        return this.A02.A0j() - this.A02.A0h();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A08() {
        return this.A02.A0h();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A09() {
        return this.A02.A0k();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A0A() {
        return this.A02.A0g();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A0B() {
        return (this.A02.A0j() - this.A02.A0g()) - this.A02.A0h();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A0C(View view) {
        return this.A02.A0p(view) + ((R3) view.getLayoutParams()).rightMargin;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A0D(View view) {
        R3 r3 = (R3) view.getLayoutParams();
        return this.A02.A0o(view) + r3.leftMargin + r3.rightMargin;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A0E(View view) {
        R3 r3 = (R3) view.getLayoutParams();
        return this.A02.A0n(view) + r3.topMargin + r3.bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A0F(View view) {
        return this.A02.A0m(view) - ((R3) view.getLayoutParams()).leftMargin;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A0G(View view) {
        this.A02.A1G(view, true, this.A01);
        return this.A01.right;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final int A0H(View view) {
        this.A02.A1G(view, true, this.A01);
        return this.A01.left;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0765Qm
    public final void A0J(int i) {
        this.A02.A11(i);
    }
}
