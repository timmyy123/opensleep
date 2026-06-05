package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7C, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C7C extends C1450hB {
    public InterfaceC1293ee A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A08(NativeAdLayout nativeAdLayout, C1421gi c1421gi, NativeAd nativeAd, C0885Vd c0885Vd) {
        C1115bk c1115bk = new C1115bk(c1421gi);
        MediaView mediaView = new MediaView(c1421gi);
        AdOptionsView adOptionsView = new AdOptionsView(c1421gi, nativeAd, nativeAdLayout);
        c0885Vd.A09(adOptionsView, 28);
        this.A00 = new F2(c1421gi, nativeAd, c0885Vd, UK.A0L(nativeAd.getInternalNativeAd()).A1C(), c1115bk, mediaView, adOptionsView);
        YB.A0N(nativeAdLayout, c0885Vd.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, c1115bk, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.C0791Rm, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
