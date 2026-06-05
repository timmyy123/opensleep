package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1285eV extends LinearLayout {
    public int A00;
    public int A01;
    public int A02;
    public TextView A03;
    public TextView A04;
    public final int A05;

    public C1285eV(Context context) {
        super(context);
        this.A01 = 30;
        this.A02 = 45;
        this.A00 = 8;
        A00();
        this.A05 = (int) XX.A02;
        A01();
    }

    private void A00() {
        setOrientation(1);
        setGravity(17);
        this.A04 = new TextView(getContext());
        this.A04.setTextSize(17.0f);
        this.A04.setTextColor(-1);
        this.A04.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, this.A00, 0, 0);
        this.A04.setLayoutParams(layoutParams);
        addView(this.A04);
        this.A03 = new TextView(getContext());
        this.A03.setTextSize(11.0f);
        LinearLayout.LayoutParams subtitleParams = new LinearLayout.LayoutParams(-2, -2);
        subtitleParams.setMargins(0, 0, 0, 0);
        this.A03.setLayoutParams(subtitleParams);
        addView(this.A03);
    }

    private void A01() {
        this.A01 *= this.A05;
        this.A02 *= this.A05;
        this.A00 *= this.A05;
    }

    public final C1285eV A02(C1104bZ c1104bZ) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.A01, this.A01);
        layoutParams.setMargins(this.A02, 0, this.A02, 0);
        c1104bZ.setLayoutParams(layoutParams);
        addView(c1104bZ, 0);
        return this;
    }

    public final C1285eV A03(String str) {
        this.A03.setText(str);
        return this;
    }

    public final C1285eV A04(String str) {
        this.A04.setText(str);
        return this;
    }
}
