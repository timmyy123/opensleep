package com.facebook.ads.redexgen.core;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.h4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1443h4 implements S8 {
    public final /* synthetic */ ImageView A00;
    public final /* synthetic */ SA A01;
    public final /* synthetic */ UK A02;

    public C1443h4(SA sa, ImageView imageView, UK uk) {
        this.A01 = sa;
        this.A00 = imageView;
        this.A02 = uk;
    }

    @Override // com.facebook.ads.redexgen.core.S8
    public final void AE8(Drawable drawable) {
        UK.A0f(drawable, this.A00);
        this.A02.A1P(drawable);
    }
}
