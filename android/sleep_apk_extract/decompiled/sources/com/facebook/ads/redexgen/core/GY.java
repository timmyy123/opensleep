package com.facebook.ads.redexgen.core;

import android.view.animation.Animation;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class GY extends YA {
    public final /* synthetic */ GX A00;

    public GY(GX gx) {
        this.A00 = gx;
    }

    @Override // com.facebook.ads.redexgen.core.YA, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        YB.A0H(this.A00.A01);
        this.A00.A00.AEL();
    }
}
