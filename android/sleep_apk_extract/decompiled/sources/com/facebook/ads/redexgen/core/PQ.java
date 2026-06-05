package com.facebook.ads.redexgen.core;

import android.R;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class PQ extends AbstractRunnableC0908Wc {
    public final /* synthetic */ AnimationAnimationListenerC0975Yu A00;

    public PQ(AnimationAnimationListenerC0975Yu animationAnimationListenerC0975Yu) {
        this.A00 = animationAnimationListenerC0975Yu;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        this.A00.A00.finish(3);
        this.A00.A00.A05().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
