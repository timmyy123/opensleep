package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.NativeAdLayoutApi;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1450hB extends C0791Rm implements NativeAdLayoutApi {
    public View A02;
    public NativeAdLayout A03;
    public ZX A04;
    public int A01 = 0;
    public int A00 = 0;
    public boolean A06 = false;
    public boolean A05 = false;

    public final void A02() {
        YB.A0W(this.A03);
        this.A03.removeView(this.A04);
        this.A04 = null;
    }

    public final void A03() {
        YB.A0W(this.A03);
        this.A03.removeView(this.A02);
        this.A02 = null;
    }

    public final void A04(ZX zx) {
        this.A04 = zx;
        this.A04.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        YB.A0W(this.A03);
        this.A03.addView(this.A04);
    }

    public final void A05(AbstractC0984Zd abstractC0984Zd) {
        this.A02 = abstractC0984Zd;
        abstractC0984Zd.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        YB.A0W(this.A03);
        this.A03.addView(this.A02);
    }

    public final boolean A06() {
        return this.A05;
    }

    public final boolean A07() {
        return this.A06;
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void initialize(NativeAdLayout nativeAdLayout) {
        this.A03 = nativeAdLayout;
    }

    @Override // com.facebook.ads.redexgen.core.C0791Rm, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.A00 > 0 && this.A03.getMeasuredWidth() > this.A00) {
            setMeasuredDimension(this.A00, this.A03.getMeasuredHeight());
        } else {
            if (this.A03.getMeasuredWidth() >= this.A01) {
                return;
            }
            setMeasuredDimension(this.A01, this.A03.getMeasuredHeight());
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void setMaxWidth(int i) {
        this.A00 = i;
        this.A05 = true;
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void setMinWidth(int i) {
        this.A01 = i;
        this.A06 = true;
    }
}
