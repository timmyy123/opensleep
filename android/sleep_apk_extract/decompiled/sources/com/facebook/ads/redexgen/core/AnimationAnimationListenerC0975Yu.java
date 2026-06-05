package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.view.animation.Animation;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class AnimationAnimationListenerC0975Yu implements Animation.AnimationListener {
    public final /* synthetic */ C0783Re A00;
    public final /* synthetic */ PJ A01;
    public final /* synthetic */ PJ A02;

    public AnimationAnimationListenerC0975Yu(PJ pj, PJ pj2, C0783Re c0783Re) {
        this.A01 = pj;
        this.A02 = pj2;
        this.A00 = c0783Re;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.A01.A06 = false;
        YB.A0H(this.A02);
        new Handler().postDelayed(new PQ(this), 200L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
