package com.facebook.ads.redexgen.core;

import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class W4 implements VX {
    public final /* synthetic */ MediaViewVideoRendererApi A00;
    public final /* synthetic */ C0905Vz A01;

    public W4(C0905Vz c0905Vz, MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        this.A01 = c0905Vz;
        this.A00 = mediaViewVideoRendererApi;
    }

    @Override // com.facebook.ads.redexgen.core.VX
    public final void AJU() {
        this.A01.A00 = 1.0f;
        this.A00.setVolume(1.0f);
    }

    @Override // com.facebook.ads.redexgen.core.VX
    public final void AJZ(NativeAd nativeAd) {
        this.A01.A02 = nativeAd.getNativeOptions();
        this.A01.A0G();
        this.A01.A0H();
        this.A01.A0Q(UK.A0L(nativeAd.getInternalNativeAd()), new W0(UK.A0L(nativeAd.getInternalNativeAd())));
    }

    @Override // com.facebook.ads.redexgen.core.VX
    public final void AKY() {
        this.A01.A0J();
    }
}
