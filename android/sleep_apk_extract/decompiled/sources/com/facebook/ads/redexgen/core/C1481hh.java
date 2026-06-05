package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1481hh implements RN {
    public final /* synthetic */ R2 A00;

    public C1481hh(R2 r2) {
        this.A00 = r2;
    }

    @Override // com.facebook.ads.redexgen.core.RN
    public final View A7H(int i) {
        return this.A00.A0v(i);
    }

    @Override // com.facebook.ads.redexgen.core.RN
    public final int A7J(View view) {
        return this.A00.A0l(view) + ((R3) view.getLayoutParams()).bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.core.RN
    public final int A7K(View view) {
        return this.A00.A0q(view) - ((R3) view.getLayoutParams()).topMargin;
    }

    @Override // com.facebook.ads.redexgen.core.RN
    public final int A8g() {
        return this.A00.A0Z() - this.A00.A0f();
    }

    @Override // com.facebook.ads.redexgen.core.RN
    public final int A8h() {
        return this.A00.A0i();
    }
}
