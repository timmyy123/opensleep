package com.facebook.ads.redexgen.core;

import com.facebook.ads.MediaViewListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1453hE implements InterfaceC0976Yv {
    public final /* synthetic */ MediaViewListener A00;
    public final /* synthetic */ C1451hC A01;

    public C1453hE(C1451hC c1451hC, MediaViewListener mediaViewListener) {
        this.A01 = c1451hC;
        this.A00 = mediaViewListener;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0976Yv
    public final void ADQ() {
        this.A00.onComplete(this.A01.A07);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0976Yv
    public final void ADn() {
        this.A00.onEnterFullscreen(this.A01.A07);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0976Yv
    public final void ADt() {
        this.A00.onExitFullscreen(this.A01.A07);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0976Yv
    public final void AE1() {
        this.A00.onFullscreenBackground(this.A01.A07);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0976Yv
    public final void AE3() {
        this.A00.onFullscreenForeground(this.A01.A07);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0976Yv
    public final void AFC() {
        this.A00.onPlay(this.A01.A07);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0976Yv
    public final void AGe() {
        this.A00.onVolumeChange(this.A01.A07, this.A01.A09.getVolume());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0976Yv
    public final void onPause() {
        this.A00.onPause(this.A01.A07);
    }
}
