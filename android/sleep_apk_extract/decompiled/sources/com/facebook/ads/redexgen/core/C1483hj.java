package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1483hj implements RN {
    public final /* synthetic */ R2 A00;

    public C1483hj(R2 r2) {
        this.A00 = r2;
    }

    @Override // com.facebook.ads.redexgen.core.RN
    public final View A7H(int i) {
        return this.A00.A0v(i);
    }

    @Override // com.facebook.ads.redexgen.core.RN
    public final int A7J(View view) {
        return this.A00.A0p(view) + ((R3) view.getLayoutParams()).rightMargin;
    }

    @Override // com.facebook.ads.redexgen.core.RN
    public final int A7K(View view) {
        return this.A00.A0m(view) - ((R3) view.getLayoutParams()).leftMargin;
    }

    @Override // com.facebook.ads.redexgen.core.RN
    public final int A8g() {
        return this.A00.A0j() - this.A00.A0h();
    }

    @Override // com.facebook.ads.redexgen.core.RN
    public final int A8h() {
        return this.A00.A0g();
    }
}
