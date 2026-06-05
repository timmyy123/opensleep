package com.facebook.ads.redexgen.core;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1170cd extends FrameLayout {
    public final int A00;
    public final RelativeLayout A01;
    public final ViewOnClickListenerC0619Kr A02;
    public static final int A05 = (int) (XX.A02 * 36.0f);
    public static final int A06 = (int) (XX.A02 * 36.0f);
    public static final int A03 = (int) (XX.A02 * 23.0f);
    public static final int A04 = (int) (XX.A02 * 3.0f);
    public static final int A07 = (int) (XX.A02 * 4.0f);

    public C1170cd(C1421gi c1421gi, ViewOnClickListenerC0619Kr viewOnClickListenerC0619Kr, AbstractC1586jd abstractC1586jd, VA va, InterfaceC0962Yh interfaceC0962Yh, C1366fp c1366fp, Y2 y2, C0679Na c0679Na, InterfaceC1099bU interfaceC1099bU) {
        super(c1421gi);
        this.A00 = c0679Na.A09(true);
        this.A01 = new RelativeLayout(c1421gi);
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        this.A01.setClickable(false);
        A01(c1421gi, abstractC1586jd.A29().A0J().A04());
        if (viewOnClickListenerC0619Kr == null) {
            this.A02 = new ViewOnClickListenerC0619Kr(c1421gi, abstractC1586jd.A0w(), (C0679Na) null, va, interfaceC0962Yh, c1366fp, y2, abstractC1586jd.A2A());
        } else {
            this.A02 = viewOnClickListenerC0619Kr;
        }
        A03();
        this.A02.setCta(abstractC1586jd.A29().A0J(), abstractC1586jd.A2E(), new HashMap(), interfaceC1099bU);
        this.A02.setIsInAppBrowser(true);
        FrameLayout.LayoutParams ctaButtonParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.A02, ctaButtonParams);
    }

    private void A00(C1421gi c1421gi, View view) {
        ImageView imageView = new ImageView(c1421gi);
        imageView.setImageBitmap(YN.A01(YM.MINIMIZE_ARROW));
        imageView.setRotation(180.0f);
        imageView.setClickable(false);
        imageView.setColorFilter(this.A00);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A03, A03);
        imageView.setPadding(A04, A04, A04, A04);
        layoutParams.addRule(2, view.getId());
        layoutParams.addRule(14);
        this.A01.addView(imageView, layoutParams);
    }

    private void A01(C1421gi c1421gi, String str) {
        Button button = new Button(c1421gi);
        YB.A0K(button);
        button.setPadding(A06, 0, A06, 0);
        button.setText(str.toUpperCase(Locale.getDefault()));
        button.setTextSize(14.0f);
        button.setTypeface(Typeface.defaultFromStyle(1));
        YB.A0Q(button, this.A00, A07);
        button.setTextColor(Color.BLACK);
        RelativeLayout.LayoutParams ctaParams = new RelativeLayout.LayoutParams(-2, A05);
        ctaParams.addRule(12);
        ctaParams.addRule(14);
        this.A01.addView(button, ctaParams);
        A00(c1421gi, button);
    }

    public final EnumC0670Mq A02(String str) {
        return this.A02.A0E(str);
    }

    public final void A03() {
        this.A02.setBackgroundColor(0);
        this.A02.setTextColor(0);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.A02.performClick();
    }

    public void setAutoClickTime(AbstractC1586jd abstractC1586jd, AbstractC0956Yb abstractC0956Yb) {
        this.A02.A0F(abstractC1586jd, abstractC0956Yb);
    }

    public void setCta(C0681Nc c0681Nc, String str, HashMap<String, String> extras, InterfaceC1099bU interfaceC1099bU) {
        this.A02.setCta(c0681Nc, str, extras, interfaceC1099bU);
    }
}
