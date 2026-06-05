package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1012a5 extends LinearLayout {
    public final Bitmap A00;

    public C1012a5(C1421gi c1421gi, EnumC1029aM enumC1029aM) {
        super(c1421gi);
        this.A00 = YN.A01(YM.AD_CHOICE_ICON);
        c1421gi.A0F().AAz(enumC1029aM.name().toLowerCase(Locale.US));
        A00();
        setAdChoiceIcon(c1421gi);
    }

    private void A00() {
        setOrientation(0);
        setPadding(XV.A0I, XV.A0I, XV.A0I, XV.A0I);
        setClipToPadding(false);
        setGravity(17);
        YB.A0N(this, -859190839);
        YB.A0E(XV.A0C, this);
    }

    private void setAdChoiceIcon(C1421gi c1421gi) {
        ImageView imageView = new ImageView(c1421gi);
        YB.A0K(imageView);
        imageView.setImageBitmap(this.A00);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setAdjustViewBounds(true);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, XV.A0U));
        addView(imageView);
    }
}
