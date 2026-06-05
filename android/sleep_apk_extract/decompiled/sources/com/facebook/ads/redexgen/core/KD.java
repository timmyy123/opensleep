package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class KD extends AbstractC1134c3 {
    public RelativeLayout A00;
    public RelativeLayout A01;
    public InterfaceC1251dx A02;
    public C0468Eu A03;
    public C0458Ek A04;
    public C4L A05;
    public final LinearLayout A06;
    public final LinearLayout A07;
    public final LinearLayout A08;
    public final LinearLayout A09;
    public final RelativeLayout A0A;
    public final C1421gi A0B;
    public final C1138c7 A0C;
    public final EA A0D;
    public final E2 A0E;
    public static String[] A0F = {"dHduAtxHUODsuZJhGBZCL", "yuyhTKr6448pVSOhbbO3QanDkg1Btrke", "", "Gtku4tEVnL9u23uc2EIXKUUStEslbjmu", "uz", "Ug", "s4BqeuLW7FPjKDKoSZG73iWJUNxNcWet", "kGKRi0uYqdf74JFz2mP0bKfaoGbNkKkY"};
    public static final int A0V = (int) (XX.A02 * 24.0f);
    public static final int A0U = (int) (XX.A02 * 8.0f);
    public static final int A0N = (int) (XX.A02 * 1.0f);
    public static final int A0O = XV.A0f;
    public static final int A0T = XV.A0i;
    public static final int A0I = XV.A0s;
    public static final int A0W = XV.A0v;
    public static final int A0J = XV.A0b;
    public static final int A0L = XV.A0b;
    public static final int A0K = XV.A0v;
    public static final int A0M = XV.A0v;
    public static final int A0P = (int) (XX.A02 * 12.0f);
    public static final int A0H = (int) (XX.A02 * 40.0f);
    public static final int A0S = XV.A0b;
    public static final int A0R = XV.A0f;
    public static final int A0Q = (int) (XX.A02 * 16.0f);
    public static final int A0G = (int) (XX.A02 * 6.0f);

    public KD(C1138c7 c1138c7) {
        super(c1138c7, false);
        this.A0E = new E2() { // from class: com.facebook.ads.redexgen.X.6G
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(E3 e3) {
                if (this.A00.A02 == null) {
                    return;
                }
                this.A00.A02.AKE();
            }
        };
        this.A0D = new EA() { // from class: com.facebook.ads.redexgen.X.6F
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C4K c4k) {
                this.A00.A04.A0e(EnumC1308et.A02, 20);
            }
        };
        this.A0B = c1138c7.A06();
        this.A0C = c1138c7;
        this.A06 = new LinearLayout(this.A0B);
        this.A09 = new LinearLayout(this.A0B);
        this.A0A = new RelativeLayout(this.A0B);
        this.A08 = new LinearLayout(this.A0B);
        this.A07 = new LinearLayout(this.A0B);
        A08();
    }

    private LinearLayout A00() {
        LinearLayout linearLayout = new LinearLayout(this.A0B);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        linearLayout.setWeightSum(3.0f);
        linearLayout.setPadding(A0U, A0U, A0U, A0U);
        String strA0C = this.A0C.A05().A29().A0I().A0C();
        String strA01 = this.A0C.A05().A29().A0I().A01();
        String strA05 = this.A0C.A05().A29().A0I().A05();
        if (!TextUtils.isEmpty(strA0C)) {
            YM ym = YM.RATINGS;
            AbstractC1586jd abstractC1586jdA05 = this.A0C.A05();
            String[] strArr = A0F;
            if (strArr[4].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A0F[2] = "";
            LinearLayout videoMetaDataLayout = A01(ym, abstractC1586jdA05.A29().A0I().A0C());
            linearLayout.addView(videoMetaDataLayout);
        }
        if (!TextUtils.isEmpty(strA05)) {
            LinearLayout videoMetaDataLayout2 = A01(YM.APP_DOWNLOAD_ICON, this.A0C.A05().A29().A0I().A05());
            linearLayout.addView(videoMetaDataLayout2);
        }
        if (!TextUtils.isEmpty(strA01)) {
            LinearLayout videoMetaDataLayout3 = A01(YM.APP_SIZE_ICON, this.A0C.A05().A29().A0I().A01());
            linearLayout.addView(videoMetaDataLayout3);
        }
        layoutParams.addRule(12);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(1);
        return linearLayout;
    }

    private LinearLayout A01(YM ym, String str) {
        LinearLayout linearLayout = new LinearLayout(this.A0B);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, A0V);
        layoutParams.weight = 1.0f;
        linearLayout.setGravity(17);
        layoutParams.setMargins(A0T, A0T, A0T, A0T);
        linearLayout.setLayoutParams(layoutParams);
        YB.A0V(linearLayout, YB.A06(Integer.MIN_VALUE, A0Q));
        C1109be c1109be = new C1109be(this.A0C.A06(), 0, -1, ym);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(A0P, A0P);
        layoutParams2.gravity = 16;
        c1109be.setLayoutParams(layoutParams2);
        linearLayout.addView(c1109be);
        TextView textView = new TextView(this.A0B);
        textView.setText(str);
        textView.setTextColor(-1);
        YB.A0a(textView, false, 12);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        layoutParams3.setMargins(A0W, 0, 0, 0);
        textView.setLayoutParams(layoutParams3);
        linearLayout.addView(textView);
        return linearLayout;
    }

    private final RelativeLayout A02(String str, int i, YM ym) {
        RelativeLayout relativeLayout = new RelativeLayout(this.A0B);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0H);
        relativeLayout.setPadding(A0J, 0, A0J, 0);
        YB.A0V(relativeLayout, YB.A06(i, A0G));
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(this.A0B);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(9);
        textView.setText(str);
        textView.setTextColor(-1);
        YB.A0a(textView, true, 15);
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        C1109be iconView = new C1109be(this.A0C.A06(), 0, -1, ym);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(A0P, A0P);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(0, A0I, 0, 0);
        iconView.setLayoutParams(layoutParams3);
        relativeLayout.addView(iconView);
        return relativeLayout;
    }

    private TextView A03(String str, boolean z, int i, int i2, int i3) {
        TextView textView = new TextView(this.A0B);
        textView.setText(str);
        textView.setTextColor(i2);
        YB.A0a(textView, z, i);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(A0K, 0, A0K, i3);
        textView.setGravity(1);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private C0458Ek A05() {
        C0458Ek c0458Ek = new C0458Ek(this.A0C.A06());
        YB.A0V(c0458Ek, YB.A06(436207616, A0Q));
        c0458Ek.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.A05 = new C4L(this.A0B, getAdEventManager(), c0458Ek, this.A0C.A05().A2E(), 0, 0, true, null, null);
        if (C0871Up.A20(this.A0B)) {
            this.A03 = new C0468Eu(this.A0B, getAdEventManager(), c0458Ek, this.A0C.A05().A2E(), false, this.A05, null);
        } else {
            this.A03 = null;
        }
        return c0458Ek;
    }

    private void A07() {
        this.A00 = A02(this.A0C.A05().A16(), -14977820, YM.RIGHT_ARROW_ICON);
        this.A01 = A02(this.A0C.A05().A19(), -13816531, YM.SKIP_ARROW);
        View divider = getDivider();
        LinearLayout linearLayout = this.A09;
        View divider2 = this.A00;
        linearLayout.addView(divider2);
        this.A09.addView(divider);
        LinearLayout linearLayout2 = this.A09;
        View divider3 = this.A01;
        linearLayout2.addView(divider3);
        this.A00.setOnClickListener(new ViewOnClickListenerC1162cV(this));
        this.A01.setOnClickListener(new ViewOnClickListenerC1163cW(this));
    }

    private void A08() {
        new VI(this.A0C.A05().A2E(), getAdEventManager()).A04(VH.A0f, null);
        AbstractC1122br.A00(this.A0C.A06(), this, this.A0C.A05().A29().A0H().A08());
        int iA00 = this.A0C.A00();
        this.A09.setOrientation(1);
        A09();
        A0A(iA00);
        addView(this.A06);
        A0B(iA00);
        RelativeLayout relativeLayout = this.A0A;
        int orientation = A0Q;
        YB.A0V(relativeLayout, YB.A06(436207616, orientation));
        A0C(iA00);
        this.A04 = A05();
        this.A0A.addView(this.A04);
        this.A0A.addView(A00());
        this.A06.addView(this.A0A);
        A07();
        this.A06.addView(this.A09);
        this.A04.setVideoURI(this.A0C.A05().A29().A0H().A09());
        this.A04.A0e(EnumC1308et.A02, 20);
        this.A04.getEventBus().A03(this.A0E, this.A0D);
    }

    private void A09() {
        this.A08.setOrientation(1);
        this.A07.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        this.A08.setLayoutParams(layoutParams);
        layoutParams.weight = 1.0f;
        A0D(this.A08);
        A0D(this.A07);
        this.A06.addView(this.A08);
        this.A09.addView(this.A07);
    }

    private void A0A(int i) {
        int height;
        int width;
        this.A06.setOrientation(i == 1 ? 1 : 0);
        if (this.A0B.A0E() == null || this.A0B.A0E().getWindowManager() == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.A0B.A0E().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int marginHorizontal = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i == 1) {
            height = marginHorizontal / 6;
            width = i2 / 8;
            this.A06.setWeightSum(6.0f);
        } else {
            height = marginHorizontal / 8;
            width = i2 / 6;
            this.A06.setWeightSum(2.0f);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(height, width, height, width);
        layoutParams.addRule(14);
        this.A06.setLayoutParams(layoutParams);
        setRewardDescContainerVisibility(i);
    }

    private void A0B(int i) {
        LinearLayout.LayoutParams layoutParams;
        if (i == 1) {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.setMargins(0, A0S, 0, 0);
            layoutParams.weight = 2.0f;
            this.A09.setGravity(0);
        } else {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.setMargins(A0R, 0, 0, 0);
            layoutParams.weight = 1.0f;
            this.A09.setGravity(16);
        }
        this.A09.setLayoutParams(layoutParams);
    }

    private void A0C(int i) {
        LinearLayout.LayoutParams layoutParams;
        if (i == 1) {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        } else {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        }
        layoutParams.weight = i == 1 ? 3.0f : 1.0f;
        this.A0A.setLayoutParams(layoutParams);
    }

    private void A0D(LinearLayout linearLayout) {
        TextView summaryView = A03(this.A0C.A05().A18(), true, 24, -657931, A0M);
        TextView titleView = A03(this.A0C.A05().A17(), false, 15, -1, A0L);
        linearLayout.addView(summaryView);
        linearLayout.addView(titleView);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final EnumC0670Mq A1B(String str) {
        return EnumC0670Mq.A09;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final void A1C() {
        super.A1C();
        if (this.A03 != null) {
            this.A03.A07();
        }
        if (this.A05 != null) {
            this.A05.A0p();
        }
        this.A04.getEventBus().A04(this.A0E, this.A0D);
        this.A00 = null;
        this.A01 = null;
        this.A02 = null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final boolean A1O() {
        return true;
    }

    public final void A1Q(C4L c4l) {
        if (this.A05 != null) {
            this.A05.A0o(c4l);
        }
    }

    private View getDivider() {
        View view = new View(this.A0B);
        view.setBackgroundColor(-10131605);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0N);
        layoutParams.setMargins(0, A0O, 0, A0O);
        view.setLayoutParams(layoutParams);
        return view;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        A0A(configuration.orientation);
        A0B(configuration.orientation);
        A0C(configuration.orientation);
        requestLayout();
    }

    private void setRewardDescContainerVisibility(int i) {
        if (i == 1) {
            this.A08.setVisibility(0);
            this.A07.setVisibility(8);
        } else {
            this.A08.setVisibility(8);
            this.A07.setVisibility(0);
        }
    }

    public void setVideoAdViewListener(InterfaceC1251dx interfaceC1251dx) {
        this.A02 = interfaceC1251dx;
    }
}
