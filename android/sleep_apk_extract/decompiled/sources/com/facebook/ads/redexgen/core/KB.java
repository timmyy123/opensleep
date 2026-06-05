package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class KB extends AbstractC1134c3 {
    public static byte[] A0W;
    public static String[] A0X = {"UQ7TFs74lcUdZuEisIQQex1S2hJkyBQJ", "myvpLMPCiy1Db21mRiA", "GFipZK8NVLufipAPgP", "AfraUSEhnPTRS4j1c1sVruXnc5XHPJ9d", "a5o2PCnXzYQrRDOC9DPzRLQmHH", "zC9Q5dVrf3DuizGN", "cBKGhAcqgckkizLMVTE8MrLSp3snJrYL", "vsEAc6f0BLlcSapFKHSSbJlGpIzpiVSU"};
    public static final int A0Y;
    public int A00;
    public int A01;
    public ImageView A02;
    public ImageView A03;
    public LinearLayout A04;
    public C0711Og A05;
    public C1026aJ A06;
    public C1030aN A07;
    public InterfaceC1251dx A08;
    public C0468Eu A09;
    public C4L A0A;
    public final Handler A0B;
    public final ImageView A0C;
    public final RelativeLayout A0D;
    public final RelativeLayout A0E;
    public final RelativeLayout A0F;
    public final RelativeLayout A0G;
    public final RelativeLayout A0H;
    public final TextView A0I;
    public final TextView A0J;
    public final TextView A0K;
    public final TextView A0L;
    public final TextView A0M;
    public final C1421gi A0N;
    public final VI A0O;
    public final C1115bk A0P;
    public final C1117bm A0Q;
    public final C1138c7 A0R;
    public final C0458Ek A0S;
    public final EA A0T;
    public final E2 A0U;
    public final Runnable A0V;

    public static String A0J(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0W, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 105);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0R() {
        A0W = new byte[]{-24, 26, 41, 60, 49, 54, 47, -77, -68, -65, -12};
    }

    static {
        A0R();
        A0Y = (int) (XX.A02 * 16.0f);
    }

    public KB(C1138c7 c1138c7) {
        super(c1138c7, false);
        this.A0B = new Handler(Looper.getMainLooper());
        this.A0U = new E2() { // from class: com.facebook.ads.redexgen.X.6E
            public static String[] A01 = {"1XAudPm5bNoLpQjIPSZWPFOeb", "KPQovwGp6PfJEyzo2xgnSN1gmGV3wBfO", "MSOuoVglH1pxZtUt86IkEaCPI", "Ahn71CuWf", "XCR0a8v2bJ8TOqmTegoErV6kR", "kQ55lQ8tRAtObxY9GvDk6DQ4l", "65Z7gaQiVm7Q6XjyGmw2uvR6b", "4ArQv5JqOif9H4kcX07xj56lI8DuBc1Y"};

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(E3 e3) {
                if (this.A00.A08 != null) {
                    KB kb = this.A00;
                    if (A01[3].length() != 9) {
                        throw new RuntimeException();
                    }
                    A01[3] = "L2P2qOlVB";
                    kb.A08.AKE();
                }
            }
        };
        this.A0T = new EA() { // from class: com.facebook.ads.redexgen.X.6D
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C4K c4k) {
                this.A00.A0S.A0e(EnumC1308et.A02, 20);
            }
        };
        this.A0V = new RunnableC1164cX(this);
        this.A0N = c1138c7.A06();
        this.A0R = c1138c7;
        this.A0O = new VI(this.A0R.A05().A2E(), getAdEventManager());
        this.A0O.A04(VH.A0f, null);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.A00 = displayMetrics.heightPixels;
        this.A01 = displayMetrics.widthPixels;
        this.A0S = A0G();
        YB.A0K(this.A0S);
        this.A0S.setVideoURI(this.A0R.A05().A29().A0H().A09());
        this.A0S.A0e(EnumC1308et.A02, 20);
        this.A0S.getEventBus().A03(this.A0U, this.A0T);
        this.A0G = A06();
        YB.A0K(this.A0G);
        A0L();
        A0M();
        this.A0P = A0D();
        YB.A0K(this.A0P);
        this.A0L = A0B();
        YB.A0K(this.A0L);
        this.A0Q = A0E();
        YB.A0K(this.A0Q);
        this.A0J = A09();
        YB.A0K(this.A0J);
        this.A0C = A01();
        YB.A0K(this.A0C);
        this.A0I = A08();
        YB.A0K(this.A0I);
        this.A0E = A05();
        YB.A0K(this.A0E);
        this.A0D = A04();
        YB.A0K(this.A0D);
        this.A0K = A0A();
        YB.A0K(this.A0K);
        this.A0M = A0C();
        YB.A0K(this.A0M);
        this.A0H = A07(getWatchAdCtaText(), 654311423);
        YB.A0K(this.A0H);
        this.A0F = A07(this.A0R.A05().A1A(), -16226561);
        YB.A0K(this.A0F);
        AbstractC1122br.A00(this.A0R.A06(), this, this.A0R.A05().A29().A0H().A08());
        int i = getResources().getConfiguration().orientation;
        A0h(i);
        addView(this.A0S);
        A0S(i);
        A0K();
    }

    private ImageView A01() {
        ImageView imageView = new ImageView(this.A0N);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        imageView.setImageBitmap(YN.A01(YM.DOWNLOAD_ICON));
        return imageView;
    }

    private LinearLayout A03() {
        this.A02 = new ImageView(this.A0N);
        this.A03 = new ImageView(this.A0N);
        LinearLayout linearLayout = new LinearLayout(this.A0N);
        this.A02.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.A02.setImageBitmap(YN.A01(YM.AD_CHOICE_V2_COLLAPSE));
        linearLayout.addView(this.A02);
        this.A03.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.A03.setImageBitmap(YN.A01(YM.AD_CHOICE_V2_EXPAND));
        linearLayout.addView(this.A03);
        RelativeLayout.LayoutParams adReportingLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        adReportingLayoutParams.addRule(12);
        adReportingLayoutParams.addRule(11);
        linearLayout.setLayoutParams(adReportingLayoutParams);
        return linearLayout;
    }

    private RelativeLayout A04() {
        RelativeLayout relativeLayout = new RelativeLayout(this.A0N);
        relativeLayout.addView(this.A0L);
        if (this.A0R.A05().A1p()) {
            relativeLayout.addView(this.A0Q);
            relativeLayout.addView(this.A0J);
        } else {
            RelativeLayout relativeLayout2 = this.A0E;
            String[] strArr = A0X;
            if (strArr[2].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0X;
            strArr2[2] = "DGMgcqNKmRBhEzUZj1";
            strArr2[4] = "QbI2wW46F5loixSEU5hnRqKbb5";
            relativeLayout.addView(relativeLayout2);
        }
        return relativeLayout;
    }

    private RelativeLayout A05() {
        RelativeLayout relativeLayout = new RelativeLayout(this.A0N.A02());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        relativeLayout.addView(this.A0C);
        relativeLayout.addView(this.A0I);
        return relativeLayout;
    }

    private RelativeLayout A06() {
        RelativeLayout relativeLayout = new RelativeLayout(this.A0N.A02());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        return relativeLayout;
    }

    private RelativeLayout A07(String str, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(this.A0N);
        relativeLayout.setPadding(XV.A0b, XV.A0b, XV.A0b, XV.A0b);
        YB.A0V(relativeLayout, YB.A06(i, 30));
        relativeLayout.setGravity(16);
        TextView textView = new TextView(this.A0N);
        RelativeLayout.LayoutParams contentTextViewParams = new RelativeLayout.LayoutParams(-2, -2);
        contentTextViewParams.addRule(14);
        textView.setText(str);
        textView.setTextColor(-1);
        YB.A0a(textView, true, 14);
        textView.setLayoutParams(contentTextViewParams);
        relativeLayout.addView(textView);
        return relativeLayout;
    }

    private TextView A08() {
        TextView textView = new TextView(this.A0N);
        textView.setText(this.A0R.A05().A29().A0I().A01());
        textView.setTextColor(-2130706433);
        textView.setMaxLines(1);
        textView.setTypeface(Typeface.DEFAULT);
        textView.setTextSize(12.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    private TextView A09() {
        TextView textView = new TextView(this.A0N);
        textView.setText(getRatingText());
        textView.setTextColor(-2130706433);
        textView.setMaxLines(1);
        textView.setTypeface(Typeface.DEFAULT);
        textView.setTextSize(12.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextAlignment(4);
        return textView;
    }

    private TextView A0A() {
        TextView textView = new TextView(this.A0N);
        textView.setText(String.format(Locale.US, this.A0R.A05().A1B(), this.A0R.A05().A29().A0I().A0G()));
        textView.setTextColor(-1);
        textView.setMaxLines(3);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(24.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextAlignment(4);
        return textView;
    }

    private TextView A0B() {
        TextView textView = new TextView(this.A0N);
        textView.setText(this.A0R.A05().A29().A0I().A0G());
        textView.setTextColor(-1);
        textView.setMaxLines(2);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(18.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    private TextView A0C() {
        TextView textView = new TextView(this.A0N);
        textView.setText(getWatchAdCtaText());
        textView.setTextColor(-1);
        textView.setMaxLines(1);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(14.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextAlignment(4);
        return textView;
    }

    private C1115bk A0D() {
        C1115bk c1115bk = new C1115bk(this.A0N);
        YB.A0N(c1115bk, 0);
        int i = (int) (this.A00 * 0.13f);
        new LM(c1115bk, this.A0N).A05(i, i).A07(this.A0R.A05().A2C().A01());
        return c1115bk;
    }

    private C1117bm A0E() {
        C1117bm c1117bm = new C1117bm(this.A0N, A0Y, 5, 0, -1);
        c1117bm.setRating(getRating());
        return c1117bm;
    }

    private C0458Ek A0G() {
        C0458Ek c0458Ek = new C0458Ek(this.A0R.A06());
        this.A0A = new C4L(this.A0N, getAdEventManager(), c0458Ek, this.A0R.A05().A2E(), 0, 0, true, null, null);
        if (C0871Up.A20(this.A0N)) {
            this.A09 = new C0468Eu(this.A0N, getAdEventManager(), c0458Ek, this.A0R.A05().A2E(), false, this.A0A, null);
        } else {
            String[] strArr = A0X;
            if (strArr[2].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0X;
            strArr2[2] = "hx8qxgvoIW6xceGAWf";
            strArr2[4] = "wYZsMrXjcXuhFUuKsEl8E0dQOo";
            this.A09 = null;
        }
        c0458Ek.setRoundedCornerVideoView(44.0f);
        return c0458Ek;
    }

    private void A0K() {
        this.A0F.setOnClickListener(new ViewOnClickListenerC1166cZ(this));
        if (this.A0R.A05().A1p()) {
            this.A0M.setOnClickListener(new ViewOnClickListenerC1167ca(this));
        } else {
            this.A0H.setOnClickListener(new ViewOnClickListenerC1168cb(this));
        }
    }

    private void A0L() {
        if (this.A0R.A05().A2M()) {
            this.A06 = A00(this.A0N, this.A0R.A05(), this.A0O, EnumC1029aM.A06, this.A0R.A0C());
            YB.A0K(this.A06);
        } else {
            if (!this.A0R.A05().A1p()) {
                return;
            }
            this.A05 = AbstractC0712Oh.A00(this.A0N.A02());
            this.A04 = A03();
            YB.A0K(this.A04);
            A0O();
        }
    }

    private void A0M() {
        if (this.A0R.A05().A2W()) {
            this.A07 = A01(this.A0N, EnumC1029aM.A06);
            YB.A0K(this.A07);
        }
    }

    private void A0N() {
        if (this.A0R.A05().A1p() && getRating() == 0.0f) {
            this.A0D.setVisibility(8);
            this.A0J.setVisibility(8);
            this.A0Q.setVisibility(8);
        }
        if (this.A0R.A05().A1q() && TextUtils.isEmpty(this.A0R.A05().A29().A0I().A01())) {
            this.A0D.setVisibility(8);
            this.A0E.setVisibility(8);
        }
        this.A0D.setVisibility(0);
    }

    private void A0O() {
        if (this.A04 != null) {
            this.A04.setOnClickListener(new ViewOnClickListenerC1165cY(this));
        }
        A0T(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0P() {
        this.A0O.A04(VH.A0A, null);
        C0691Nm c0691NmA2C = this.A0R.A05().A2C();
        if (this.A05 != null && this.A05.A0O(this.A0N.A02(), true)) {
            this.A0R.A0C().AAo(this.A0R.A05().A2E(), c0691NmA2C);
        } else {
            if (TextUtils.isEmpty(c0691NmA2C.A00())) {
                return;
            }
            X6.A0O(new X6(), this.A0N, XB.A00(c0691NmA2C.A00()), this.A0R.A05().A2E());
        }
    }

    private void A0Q() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, this.A0C.getId());
        layoutParams.setMargins(XV.A0d, 0, 0, 0);
        layoutParams.addRule(15);
        this.A0I.setLayoutParams(layoutParams);
    }

    private void A0S(int i) {
        if (i == 1) {
            addView(this.A0P);
            addView(this.A0D);
            addView(this.A0K);
            addView(this.A0F);
            if (this.A0R.A05().A1p()) {
                addView(this.A0M);
                if (this.A04 != null) {
                    addView(this.A04);
                }
            } else {
                addView(this.A0H);
            }
        } else {
            this.A0G.addView(this.A0P);
            this.A0G.addView(this.A0D);
            this.A0G.addView(this.A0K);
            this.A0G.addView(this.A0F);
            if (this.A0R.A05().A1p()) {
                this.A0G.addView(this.A0M);
                if (this.A04 != null) {
                    addView(this.A04);
                }
            } else {
                this.A0G.addView(this.A0H);
            }
            addView(this.A0G);
        }
        if (this.A06 != null && this.A0R.A05().A2M()) {
            addView(this.A06);
            String[] strArr = A0X;
            if (strArr[6].charAt(9) != strArr[0].charAt(9)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0X;
            strArr2[6] = "keLlcznYvctfEvjur1LzpEy2BPaBqrBv";
            strArr2[0] = "SZjrRhAKecjSc6vp3MPbWHckPYKJoG5j";
            if (this.A04 != null) {
                this.A04.setVisibility(8);
            }
        }
        if (this.A07 != null && this.A0R.A05().A2W()) {
            addView(this.A07);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0T(int i) {
        if (this.A03 == null || this.A02 == null) {
            return;
        }
        if (i == 0) {
            this.A03.setVisibility(i);
            this.A02.setVisibility(8);
        } else {
            this.A03.setVisibility(i);
            this.A02.setVisibility(0);
        }
    }

    private void A0U(int i) {
        int rightMargin;
        if (this.A04 == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A04.getLayoutParams();
        if (i == 1) {
            rightMargin = XV.A0n;
        } else {
            rightMargin = (int) (this.A01 * 0.1f);
        }
        layoutParams.setMargins(0, 0, rightMargin, 0);
        this.A04.setLayoutParams(layoutParams);
    }

    private void A0V(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i == 1) {
            if (this.A0R.A05().A1p()) {
                layoutParams.addRule(3, this.A0P.getId());
            } else {
                layoutParams.addRule(3, this.A0S.getId());
            }
            layoutParams.setMargins(0, XV.A0b, 0, 0);
            layoutParams.addRule(14);
        } else {
            layoutParams.addRule(1, this.A0P.getId());
            layoutParams.setMargins(XV.A0b, 0, 0, 0);
        }
        this.A0D.setLayoutParams(layoutParams);
        A0N();
    }

    private void A0W(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.A0L.getId());
        layoutParams.setMargins(0, XV.A0o, 0, 0);
        if (i == 1) {
            layoutParams.addRule(14);
        }
        this.A0E.setLayoutParams(layoutParams);
    }

    private void A0X(int i) {
        if (this.A07 == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int i2 = XV.A0b;
        if (i == 1) {
            i2 = XV.A0n;
        }
        int leftMargin = XV.A0b;
        layoutParams.setMargins(i2, 0, 0, leftMargin);
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        this.A07.setLayoutParams(layoutParams);
    }

    private void A0Y(int i) {
        if (this.A06 == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int i2 = XV.A0b;
        if (i == 1) {
            i2 = XV.A0n;
        }
        if (this.A0R.A05().A2U()) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.setMargins(i2, XV.A0r, 0, 0);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.setMargins(i2, 0, 0, XV.A0b);
        }
        this.A06.setLayoutParams(layoutParams);
    }

    private void A0Z(int i) {
        int i2;
        if (i == 1) {
            i2 = (int) (this.A00 * 0.13f);
            if (this.A0R.A05().A1q()) {
                C1115bk c1115bk = this.A0P;
                String[] strArr = A0X;
                if (strArr[5].length() == strArr[1].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0X;
                strArr2[6] = "T7WF8ct6Ecp3fFl6k8FlzT3xp8EZwOPe";
                strArr2[0] = "49nlYj8CnceEqKl67yYD9azFmPqqLBPu";
                c1115bk.setVisibility(8);
            } else {
                this.A0P.setRadius(30);
            }
        } else {
            i2 = (int) (this.A01 * 0.08f);
            this.A0P.setRadius(18);
            this.A0P.setVisibility(0);
        }
        int i3 = 0;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        if (i == 1) {
            i3 = (-i2) / 2;
            layoutParams.addRule(14);
            layoutParams.addRule(3, this.A0S.getId());
        }
        layoutParams.setMargins(0, i3, 0, 0);
        this.A0P.setLayoutParams(layoutParams);
    }

    private void A0a(int i) {
        int topMargin;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.A0L.getId());
        if (i == 1) {
            topMargin = XV.A0v;
            layoutParams.addRule(14);
        } else {
            topMargin = XV.A0o;
        }
        layoutParams.setMargins(0, topMargin, 0, 0);
        this.A0Q.setLayoutParams(layoutParams);
        this.A0Q.setItemSpacing(XV.A0v);
    }

    private void A0b(int i) {
        int i2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.A0Q.getId());
        if (i == 1) {
            i2 = XV.A0v;
        } else {
            i2 = XV.A0o;
        }
        layoutParams.setMargins(0, i2, 0, 0);
        if (i == 1) {
            layoutParams.addRule(14);
        }
        this.A0J.setLayoutParams(layoutParams);
    }

    private void A0c(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        if (i == 1) {
            layoutParams.addRule(3, this.A0D.getId());
            layoutParams.setMargins(XV.A0q, XV.A0b, XV.A0q, 0);
        } else {
            layoutParams.addRule(3, this.A0P.getId());
            layoutParams.setMargins(0, XV.A0e, 0, 0);
        }
        this.A0K.setLayoutParams(layoutParams);
    }

    private void A0d(int i) {
        if (i == 2) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams.addRule(15);
            if (!XL.A05((float) this.A0R.A05().A0k())) {
                layoutParams.addRule(6, this.A0S.getId());
            } else {
                this.A0G.setGravity(17);
            }
            layoutParams.setMargins(0, 0, (int) (this.A01 * 0.1f), 0);
            layoutParams.addRule(13);
            layoutParams.addRule(1, this.A0S.getId());
            this.A0G.setLayoutParams(layoutParams);
        }
    }

    private void A0e(int i) {
        View view;
        int i2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i == 1) {
            if (this.A0R.A05().A1p()) {
                view = this.A0M;
                i2 = XV.A0e;
            } else {
                view = this.A0H;
                i2 = XV.A0v;
            }
            layoutParams.setMargins(XV.A0n, 0, XV.A0n, i2);
            layoutParams.addRule(2, view.getId());
        } else {
            int topMargin = XV.A0k;
            if (this.A0R.A05().A2M()) {
                topMargin = XV.A0f;
            }
            layoutParams.setMargins(0, topMargin, 0, 0);
            int topMargin2 = this.A0K.getId();
            layoutParams.addRule(3, topMargin2);
        }
        this.A0F.setLayoutParams(layoutParams);
    }

    private void A0f(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i == 1) {
            this.A0L.setTextAlignment(4);
            layoutParams.setMargins(XV.A0p, 0, XV.A0p, 0);
        } else {
            this.A0L.setTextAlignment(5);
        }
        this.A0L.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0g(int i) {
        int i2;
        RelativeLayout.LayoutParams layoutParams;
        int rightMargin;
        double dA0k = this.A0R.A05().A0k();
        int i3 = 0;
        int topMargin = 0;
        int i4 = 0;
        if (i == 1) {
            if (XL.A05((float) dA0k)) {
                rightMargin = (int) (this.A00 * 0.2f);
                String[] strArr = A0X;
                if (strArr[6].charAt(9) == strArr[0].charAt(9)) {
                    String[] strArr2 = A0X;
                    strArr2[2] = "r4F6E4irn5aDyLCCoL";
                    strArr2[4] = "HLlNT1vJDSE83AAt2A8wGZErAg";
                    i4 = rightMargin;
                }
                throw new RuntimeException();
            }
            if (XL.A04((float) dA0k)) {
                i4 = (int) (this.A00 * 0.1f);
                rightMargin = (int) (this.A00 * 0.3f);
            } else {
                i4 = (int) (this.A00 * 0.1f);
                float f = this.A00;
                String[] strArr3 = A0X;
                if (strArr3[6].charAt(9) != strArr3[0].charAt(9)) {
                    String[] strArr4 = A0X;
                    strArr4[7] = "VrmCvLPumx9qmsQ5AqX8D26sv2xEwmDs";
                    strArr4[3] = "M5pl3CqSLX5dAxkk9LSq9NmEjnkhG5Xr";
                    rightMargin = (int) (f * 0.4f);
                } else {
                    String[] strArr5 = A0X;
                    strArr5[5] = "itXi3sFkhsJNNNlf";
                    strArr5[1] = "UwAjH2H8fcKmgRPVcHr";
                    rightMargin = (int) (f * 0.4f);
                }
            }
            layoutParams = new RelativeLayout.LayoutParams(-2, rightMargin);
            layoutParams.setMargins(i3, i4, topMargin, 0);
            if (i != 2) {
                layoutParams.addRule(15);
            } else {
                layoutParams.addRule(14);
            }
            this.A0S.setLayoutParams(layoutParams);
        }
        if (XL.A03((float) dA0k)) {
            i3 = (int) (this.A01 * 0.2f);
            topMargin = (int) (this.A01 * 0.1f);
            i2 = (int) (this.A01 * 0.15f);
        } else {
            boolean zA05 = XL.A05((float) dA0k);
            String[] strArr6 = A0X;
            if (strArr6[7].charAt(31) != strArr6[3].charAt(31)) {
                String[] strArr7 = A0X;
                strArr7[7] = "ZplkNnpiZffIY1LttQt1XVs2T7MKHARy";
                strArr7[3] = "uFxfhHDbtwTjfaa8IDnniTCsCIFPOnZP";
                if (zA05) {
                    topMargin = (int) (this.A01 * 0.1f);
                    i3 = topMargin;
                    i2 = (int) (this.A01 * 0.32f);
                } else if (XL.A04((float) dA0k)) {
                    i3 = (int) (this.A01 * 0.15f);
                    topMargin = (int) (this.A01 * 0.1f);
                    i2 = (int) (this.A01 * 0.27f);
                } else {
                    i3 = (int) (this.A01 * 0.15f);
                    topMargin = (int) (this.A01 * 0.1f);
                    i2 = (int) (this.A01 * 0.215f);
                }
            }
            throw new RuntimeException();
        }
        layoutParams = new RelativeLayout.LayoutParams(i2, -2);
        layoutParams.setMargins(i3, i4, topMargin, 0);
        if (i != 2) {
        }
        this.A0S.setLayoutParams(layoutParams);
    }

    private void A0h(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.A00 = displayMetrics.heightPixels;
        this.A01 = displayMetrics.widthPixels;
        A0d(i);
        A0g(i);
        A0Z(i);
        A0f(i);
        A0b(i);
        A0Q();
        A0W(i);
        A0a(i);
        A0V(i);
        A0c(i);
        if (this.A0R.A05().A1p()) {
            A0j(i);
            String[] strArr = A0X;
            if (strArr[5].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0X;
            strArr2[7] = "aYm4mmhUzY2q09M7FsCiyOSpkxFbKaZW";
            strArr2[3] = "02gWjTBSQrtOfJ7daRHeBoWCiPeJp89r";
            A0U(i);
        } else {
            A0i(i);
        }
        A0Y(i);
        String[] strArr3 = A0X;
        if (strArr3[5].length() != strArr3[1].length()) {
            String[] strArr4 = A0X;
            strArr4[2] = "tL7wIN5OEPzS4IRzlt";
            strArr4[4] = "pnOaA9DlQTYkC3KVcwnBrIvrHl";
            A0X(i);
            A0e(i);
            return;
        }
        String[] strArr5 = A0X;
        strArr5[6] = "MDf5St22kcgabUjosByBKwB24Lkknw12";
        strArr5[0] = "UByTvfFM4cGo3K13JgxsnaHo1RTqGnlv";
        A0X(i);
        A0e(i);
    }

    private void A0i(int i) {
        int i2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (i == 1) {
            if (this.A0R.A05().A2M() && this.A06 != null) {
                if (this.A0R.A05().A2W() && this.A07 != null) {
                    layoutParams.addRule(2, this.A07.getId());
                    i2 = XV.A0b;
                } else if (this.A0R.A05().A2U()) {
                    layoutParams.addRule(12);
                    i2 = XV.A0k;
                } else {
                    layoutParams.addRule(2, this.A06.getId());
                    i2 = XV.A0b;
                }
            } else {
                layoutParams.addRule(12);
                i2 = XV.A0q;
            }
            int bottomMargin = XV.A0n;
            layoutParams.setMargins(bottomMargin, 0, XV.A0n, i2);
        } else {
            layoutParams.addRule(3, this.A0F.getId());
            layoutParams.setMargins(0, XV.A0v, 0, 0);
        }
        RelativeLayout relativeLayout = this.A0H;
        String[] strArr = A0X;
        if (strArr[2].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0X;
        strArr2[2] = "xJXeUykDDwk7QxqpMI";
        strArr2[4] = "KNHMaHGzFmfIejDiEBJDCMbgtc";
        relativeLayout.setLayoutParams(layoutParams);
    }

    private void A0j(int i) {
        int i2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i == 1) {
            if (this.A0R.A05().A2M() && this.A06 != null) {
                if (this.A0R.A05().A2W() && this.A07 != null) {
                    layoutParams.addRule(2, this.A07.getId());
                    i2 = XV.A0b;
                } else if (this.A0R.A05().A2U()) {
                    layoutParams.addRule(12);
                    i2 = XV.A0m;
                } else {
                    layoutParams.addRule(2, this.A06.getId());
                    i2 = XV.A0b;
                }
            } else {
                layoutParams.addRule(12);
                i2 = XV.A0q;
            }
            layoutParams.setMargins(0, 0, 0, i2);
            layoutParams.addRule(14);
        } else {
            layoutParams.setMargins(0, XV.A0b, 0, 0);
            layoutParams.addRule(3, this.A0F.getId());
            layoutParams.addRule(14);
        }
        this.A0M.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final EnumC0670Mq A1B(String str) {
        return EnumC0670Mq.A09;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final void A1C() {
        super.A1C();
        if (this.A09 != null) {
            this.A09.A07();
        }
        C4L c4l = this.A0A;
        String[] strArr = A0X;
        if (strArr[2].length() == strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0X;
        strArr2[6] = "tdEFFGfq1cVEZpxqy9rgZPT1BZ8plSyJ";
        strArr2[0] = "YynlqIxuvciXAw4AWnNfF7pWFOOJrehC";
        if (c4l != null) {
            this.A0A.A0p();
        }
        this.A0B.removeCallbacksAndMessages(null);
        this.A0S.getEventBus().A04(this.A0U, this.A0T);
        this.A08 = null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final boolean A1O() {
        return true;
    }

    public final void A1Q(C4L c4l) {
        if (this.A0A != null) {
            this.A0A.A0o(c4l);
        }
    }

    private float getRating() {
        try {
            float rating = Float.parseFloat(this.A0R.A05().A29().A0I().A0C());
            return rating;
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    private String getRatingText() {
        StringBuilder sbAppend = new StringBuilder().append(String.format(Locale.US, A0J(7, 4, 37), Float.valueOf(getRating())));
        String ratingText = A0J(0, 7, 95);
        return sbAppend.append(ratingText).toString();
    }

    private String getWatchAdCtaText() {
        return String.format(Locale.US, this.A0R.A05().A1C(), Integer.valueOf(this.A0R.A05().A29().A0H().A03()));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        YB.A0d(this.A0P, this.A0D, this.A0K, this.A0F, this.A0H, this.A0M, this.A04, this.A06, this.A07, this.A0G);
        A0h(configuration.orientation);
        A0S(configuration.orientation);
    }

    public void setVideoAdViewListener(InterfaceC1251dx interfaceC1251dx) {
        this.A08 = interfaceC1251dx;
    }
}
