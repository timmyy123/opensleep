package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1238dj extends RelativeLayout {
    public ViewOnClickListenerC0619Kr A00;
    public final View.OnClickListener A01;
    public final NY A02;
    public final C0691Nm A03;
    public final C1421gi A04;
    public final C1115bk A05;
    public final C1121bq A06;
    public final String A07;
    public static final int A0B = (int) (XX.A02 * 2.0f);
    public static final int A0F = (int) (XX.A02 * 16.0f);
    public static final int A0D = (int) (XX.A02 * 20.0f);
    public static final int A0E = (int) (XX.A02 * 13.0f);
    public static final int A08 = (int) (XX.A02 * 72.0f);
    public static final int A0C = (int) (XX.A02 * 8.0f);
    public static final int A0A = (int) (XX.A02 * 24.0f);
    public static final int A09 = (int) (XX.A02 * 16.0f);

    public C1238dj(C1421gi c1421gi, C0691Nm c0691Nm, NY ny, ViewOnClickListenerC0619Kr viewOnClickListenerC0619Kr, String str, View.OnClickListener onClickListener) {
        super(c1421gi);
        this.A04 = c1421gi;
        this.A03 = c0691Nm;
        this.A02 = ny;
        this.A00 = viewOnClickListenerC0619Kr;
        this.A07 = str;
        this.A01 = onClickListener;
        this.A05 = new C1115bk(this.A04);
        this.A06 = new C1121bq(this.A04, C0679Na.A01(null), true, false, true);
        A00();
    }

    private void A00() {
        AbstractC1122br.A00(this.A04, this, this.A03.A01());
        ImageView imageView = new ImageView(this.A04);
        imageView.setImageBitmap(YN.A01(YM.REDESIGN_CLOSE_ICON));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A0A, A0A);
        imageView.setColorFilter(-1);
        layoutParams.addRule(11);
        layoutParams.setMargins(A09, A09, A09, A09);
        imageView.setLayoutParams(layoutParams);
        addView(imageView);
        imageView.setOnClickListener(this.A01);
        LinearLayout layout = new LinearLayout(this.A04);
        layout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        layout.setGravity(17);
        layout.setOrientation(1);
        ImageView closeImageView = this.A05;
        YB.A0N(closeImageView, 0);
        this.A05.setRadius(A0B);
        new LM(this.A05, this.A04).A04().A07(this.A03.A01());
        this.A06.A04(this.A02.A0G(), this.A03.A03(), null, false, true);
        this.A06.setAlignment(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, A0F, 0, A0F);
        this.A06.getDescriptionTextView().setText(this.A07);
        layout.addView(this.A05, new LinearLayout.LayoutParams(A08, A08));
        layout.addView(this.A06, layoutParams2);
        if (this.A00 != null) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            this.A00.setPadding(A0D, A0E, A0D, A0E);
            this.A00.setLayoutParams(layoutParams3);
            YB.A0V(this.A00, YB.A06(-16738826, A0C));
            this.A00.setStateListAnimator(null);
            YB.A0Z(this.A00);
            layout.addView(this.A00);
        }
        addView(layout);
    }
}
