package com.facebook.ads.redexgen.core;

import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ZC extends LinearLayout {
    public static final int A03 = (int) (XX.A02 * 10.0f);
    public static final int A04 = (int) (XX.A02 * 24.0f);
    public final ImageView A00;
    public final C0711Og A01;
    public final C1421gi A02;

    public ZC(C1421gi c1421gi) {
        super(c1421gi);
        this.A02 = c1421gi;
        this.A01 = AbstractC0712Oh.A00(c1421gi.A02());
        this.A00 = new ImageView(c1421gi);
        A02();
    }

    private void A02() {
        A03(this.A00, YM.REDESIGN_INFO_ICON);
        setPadding(A03, A03 / 3, A03, A03 / 3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A04, A04);
        layoutParams.gravity = 16;
        addView(this.A00, layoutParams);
    }

    public static void A03(ImageView imageView, YM ym) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(YN.A01(ym));
        imageView.setColorFilter(-1);
    }

    public void setAdDetails(C0691Nm c0691Nm, String str, VI vi, InterfaceC0962Yh interfaceC0962Yh) {
        setOnClickListener(new ZB(this, vi, interfaceC0962Yh, str, c0691Nm));
    }

    public void setIconColors(int i) {
        this.A00.setColorFilter(i);
    }
}
