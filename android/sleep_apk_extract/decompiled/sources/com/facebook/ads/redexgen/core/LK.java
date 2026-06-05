package com.facebook.ads.redexgen.core;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class LK extends AbstractC1084bF {
    public static byte[] A0c;
    public static String[] A0d = {"I67ZQjFrFoBoFyBDINMYweXdnGzWjrBB", "nht6bFtAgobmTyNcdDIU67iWeCPwsD4y", "CC", "mo2tEtHX5GxhbuvPRsbEGuKVkHRikNiM", "YFxZu97gZB0Y7sylrDsM9wWdV0Ra2Zhp", "a3e3iReWJRZsiYjOcmpSjngSmAGNHpnR", "bZqctpWVYtHdWFrvu7462EupjL9eUXJL", "SeUJXsHc50YCHkmPfJM6qpgcGH0p3S"};
    public static final int A0e;
    public static final int A0f;
    public static final int A0g;
    public static final int A0h;
    public static final int A0i;
    public static final int A0j;
    public static final int A0k;
    public static final int A0l;
    public static final int A0m;
    public static final int A0n;
    public static final int A0o;
    public AnimatorSet A00;
    public int A01;
    public int A02;
    public int A03;
    public TextView A04;
    public C1026aJ A05;
    public C1030aN A06;
    public DA A07;
    public final int A08;
    public final C0691Nm A09;
    public final C0711Og A0A;
    public final VI A0B;
    public final InterfaceC0962Yh A0C;
    public final Runnable A0D;
    public final Runnable A0E;
    public final String A0F;
    public final Handler A0G;
    public final ImageView A0H;
    public final ImageView A0I;
    public final ImageView A0J;
    public final LinearLayout A0K;
    public final LinearLayout A0L;
    public final RelativeLayout A0M;
    public final RelativeLayout A0N;
    public final RelativeLayout A0O;
    public final TextView A0P;
    public final TextView A0Q;
    public final AbstractC1586jd A0R;
    public final NY A0S;
    public final C0679Na A0T;
    public final C1421gi A0U;
    public final C1026aJ A0V;
    public final DZ A0W;
    public final Runnable A0X;
    public final AtomicBoolean A0Y;
    public final AtomicBoolean A0Z;
    public final boolean A0a;
    public final boolean A0b;

    public static String A0T(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0c, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0a() {
        A0c = new byte[]{58, 18, 4, 2, 18, 60, 108, 103, 106, 121, 125, 96, 97, 80, 122, 127, 29, 28, 10, 26, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 16, 9, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 16, 22, 23, 126, 116, 120, 121, 30, 2, 15, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 49, 6, 1, 2, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 28, 49, 26, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 22, 26, 96, 98, 127, 119, 98, 117, 99, 99, 79, 114, 113, 98, 99, 116, 102, 112, 99, 117, 116, 117, 78, 103, 120, 117, 116, 126, 98, 127, 98, 122, 115, 107, 109, 126, 113, 108, 115, 126, 107, 118, 112, 113, 70};
    }

    public abstract void A0u(int i);

    public abstract void A0y(ViewGroup viewGroup, RelativeLayout relativeLayout, int i);

    static {
        A0a();
        A0n = XV.A0M;
        A0g = XV.A0Q;
        A0k = XV.A0N;
        A0l = XV.A03;
        A0m = XV.A04;
        A0h = XV.A09;
        A0j = P3.A02(-1, 128);
        A0i = P3.A02(-1, 17);
        A0o = XV.A05;
        A0e = XV.A0L;
        A0f = XV.A0X;
    }

    public LK(C1421gi c1421gi, ViewOnClickListenerC0619Kr viewOnClickListenerC0619Kr, int i, boolean z, C0679Na c0679Na, boolean z2, String str, VA va, InterfaceC0962Yh interfaceC0962Yh, C1366fp c1366fp, Y2 y2, AbstractC1586jd abstractC1586jd, DZ dz, VI vi, boolean z3) {
        super(c1421gi, viewOnClickListenerC0619Kr, i, c0679Na, z2, str, va, interfaceC0962Yh, c1366fp, y2, abstractC1586jd.A2A(), abstractC1586jd.A1k(), abstractC1586jd.A13());
        this.A0Y = new AtomicBoolean(true);
        this.A0Z = new AtomicBoolean(false);
        this.A0X = new RunnableC1085bG(this);
        this.A0E = new RunnableC1086bH(this);
        this.A0D = new RunnableC1087bI(this);
        this.A0B = vi;
        this.A0R = abstractC1586jd;
        this.A0A = AbstractC0712Oh.A00(c1421gi.A02());
        this.A0C = interfaceC0962Yh;
        this.A0F = abstractC1586jd.A2E();
        this.A09 = abstractC1586jd.A2C();
        this.A0T = c0679Na;
        this.A0S = abstractC1586jd.A29().A0I();
        this.A0U = c1421gi;
        this.A0a = z;
        this.A0b = z3;
        this.A0G = new Handler(Looper.getMainLooper());
        this.A0H = new ImageView(this.A0U);
        this.A0I = new ImageView(this.A0U);
        YB.A0G(1104, this.A0H);
        YB.A0G(1105, this.A0I);
        this.A0V = AbstractC1031aO.A01(this.A0U, true, this.A0R, this.A0B, this.A0C, EnumC1029aM.A03, AbstractC1028aL.A00(this.A0R));
        YB.A0K(this.A0V);
        this.A01 = -1;
        this.A03 = Color.BLACK;
        this.A0O = A0O();
        this.A0M = A0M();
        this.A0N = A0N();
        A0V();
        A0U();
        this.A0L = new LinearLayout(this.A0U);
        this.A0L.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        YB.A0K(this.A0L);
        this.A0J = A0K();
        YB.A0K(this.A0J);
        if (this.A0b) {
            this.A0J.setVisibility(0);
            this.A0J.setOnClickListener(AbstractC1125bu.A03(super.A08, A0T(6, 10, 11)));
        } else {
            this.A0J.setVisibility(8);
        }
        if (super.A08.getParent() != null) {
            ((ViewGroup) super.A08.getParent()).removeView(super.A08);
        }
        this.A0Q = A0R();
        YB.A0K(this.A0Q);
        this.A0P = A0P();
        YB.A0K(this.A0P);
        this.A0W = A0S(dz);
        YB.A0K(this.A0W);
        if (this.A0R.A1i()) {
            this.A0W.setVisibility(8);
        }
        this.A0K = A0L();
        YB.A0G(1103, this.A0K);
        this.A0K.setOnClickListener(new ViewOnClickListenerC1088bJ(this));
        A0t(8);
        setUpAdReportingInitiateView(abstractC1586jd);
        setUpCreditLineV2(abstractC1586jd);
        this.A08 = this.A0R.A29().A0H().A03();
        if (this.A0R.A10().equals(A0T(60, 14, 21)) && !abstractC1586jd.A1h() && this.A08 > 0) {
            this.A04 = A0Q();
            YB.A0K(this.A04);
        }
        this.A0G.postDelayed(this.A0E, 2000L);
    }

    public static int A0I(int i) {
        if (P3.A01(i, -1) >= 4.5d) {
            return -1;
        }
        return Color.BLACK;
    }

    private ImageView A0K() {
        ImageView imageView = new ImageView(this.A0U);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A0h, A0h);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, 0, 0, XV.A0v);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageBitmap(YN.A01(YM.CHEVRON_UP));
        return imageView;
    }

    private LinearLayout A0L() {
        LinearLayout linearLayout = new LinearLayout(this.A0U);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.A0H.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.A0H.setImageBitmap(YN.A01(YM.AD_CHOICE_V2_COLLAPSE));
        linearLayout.addView(this.A0H);
        this.A0I.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.A0I.setImageBitmap(YN.A01(YM.AD_CHOICE_V2_EXPAND));
        linearLayout.addView(this.A0I);
        return linearLayout;
    }

    private RelativeLayout A0M() {
        RelativeLayout relativeLayout = new RelativeLayout(this.A0U);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        relativeLayout.setClipChildren(false);
        relativeLayout.setClipToPadding(false);
        YB.A0K(relativeLayout);
        return relativeLayout;
    }

    private RelativeLayout A0N() {
        RelativeLayout relativeLayout = new RelativeLayout(this.A0U);
        RelativeLayout.LayoutParams childLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        childLayoutParams.addRule(16);
        YB.A0K(relativeLayout);
        return relativeLayout;
    }

    private RelativeLayout A0O() {
        RelativeLayout relativeLayout = new RelativeLayout(this.A0U);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return relativeLayout;
    }

    private TextView A0P() {
        String strA0F;
        TextView textView = new TextView(this.A0U);
        if (this.A0b) {
            strA0F = this.A0S.A0G();
        } else {
            strA0F = this.A0S.A0F();
        }
        textView.setText(strA0F);
        textView.setTextColor(-1);
        textView.setMaxLines(4);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextAlignment(4);
        textView.setTypeface(Typeface.DEFAULT);
        textView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        return textView;
    }

    private TextView A0Q() {
        TextView textView = new TextView(this.A0U);
        textView.setTextColor(-855638017);
        textView.setMaxLines(1);
        textView.setTypeface(Typeface.DEFAULT);
        textView.setTextSize(14.0f);
        textView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        YB.A0K(textView);
        return textView;
    }

    private TextView A0R() {
        String strA0G;
        TextView textView = new TextView(this.A0U);
        if (this.A0b) {
            strA0G = this.A0S.A0F();
        } else {
            strA0G = this.A0S.A0G();
        }
        textView.setText(strA0G);
        textView.setTextColor(-1);
        textView.setMaxLines(2);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(30.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextAlignment(4);
        textView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        return textView;
    }

    private DZ A0S(DZ dz) {
        if (dz == null) {
            dz = new DZ(this.A0U, -1);
            dz.setVisibility(8);
        }
        dz.A08(A0j, A0i, true);
        dz.setPadding(0, 0, 0, 0);
        RelativeLayout.LayoutParams progressBarLayoutParams = new RelativeLayout.LayoutParams(-1, A0o);
        dz.setLayoutParams(progressBarLayoutParams);
        return dz;
    }

    private void A0U() {
        this.A02 = 30;
        super.A08.setIncludeFontPadding(false);
        super.A08.setTextSize(18.0f);
        super.A08.setTextColor(this.A03);
        super.A08.setOutlineProvider(null);
        YB.A0V(super.A08, YB.A06(this.A01, this.A02));
        super.A08.setLayoutParams(new RelativeLayout.LayoutParams(-2, A0g));
        YB.A0G(1001, super.A08);
    }

    private void A0V() {
        if (this.A0a) {
            super.A09.setFullCircleCorners(true);
        } else {
            super.A09.setRadius(15);
        }
        YB.A0N(super.A09, 0);
        super.A09.setLayoutParams(new RelativeLayout.LayoutParams(A0k, A0k));
        YB.A0K(super.A09);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0W() {
        if (this.A0B != null) {
            this.A0B.A04(VH.A0A, null);
        }
        if (this.A0A.A0O(this.A0U.A02(), true)) {
            this.A0C.AAo(this.A0F, this.A09);
        } else {
            if (TextUtils.isEmpty(this.A09.A00())) {
                return;
            }
            X6.A0O(new X6(), this.A0U, XB.A00(this.A09.A00()), this.A0F);
        }
    }

    private void A0X() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(XV.A0b, 0, 0, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        this.A0K.setLayoutParams(layoutParams);
    }

    private void A0Y() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.A0R.A2U()) {
            layoutParams.setMargins(0, 0, XV.A0e, XV.A0v);
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else {
            layoutParams.setMargins(XV.A0Z, 0, 0, 0);
            layoutParams.addRule(8, this.A0W.getId());
            layoutParams.addRule(1, this.A0W.getId());
        }
        this.A0V.setLayoutParams(layoutParams);
    }

    private void A0Z() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0o);
        layoutParams.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.42f);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.setMargins(0, 0, 0, XV.A0v);
        this.A0W.setLayoutParams(layoutParams);
    }

    private void A0b(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, XV.A0b, 0);
        if (i2 == 1) {
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(0, i);
        }
        layoutParams.addRule(12);
        if (A0d[7].length() == 1) {
            throw new RuntimeException();
        }
        A0d[2] = "Y5";
        this.A0K.setLayoutParams(layoutParams);
    }

    private void A0c(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.removeRule(7);
        layoutParams.removeRule(2);
        layoutParams.removeRule(12);
        layoutParams.removeRule(0);
        if (i2 == 1) {
            if (this.A0W.getVisibility() == 8) {
                layoutParams.setMargins(0, 0, XV.A0b, XV.A0v);
                layoutParams.addRule(12);
                layoutParams.addRule(11);
            } else {
                if (!this.A0R.A2U()) {
                    layoutParams.addRule(2, this.A0W.getId());
                    layoutParams.addRule(7, this.A0W.getId());
                } else {
                    layoutParams.addRule(12);
                    layoutParams.addRule(7, this.A0W.getId());
                }
                layoutParams.setMargins(0, 0, 0, XV.A0v);
            }
        } else {
            if (this.A0R.A2U()) {
                layoutParams.setMargins(0, 0, XV.A0b, XV.A0e);
            } else {
                layoutParams.setMargins(0, 0, XV.A0b, XV.A0v);
            }
            layoutParams.addRule(0, i);
            layoutParams.addRule(12);
        }
        this.A0V.setLayoutParams(layoutParams);
    }

    private void A0d(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0o);
        if (i2 == 1) {
            layoutParams.addRule(12);
            if (this.A0V.getVisibility() == 8) {
                int i3 = XV.A0b;
                if (A0d[7].length() == 1) {
                    throw new RuntimeException();
                }
                String[] strArr = A0d;
                strArr[5] = "Roeg9wJdjUPJmYqaO6ggHMpnVgOHkrNC";
                strArr[6] = "RHWeIYqanT4cUr8DVRS9N1g89bvSPiPo";
                layoutParams.setMargins(i3, 0, XV.A0v, XV.A0v);
                layoutParams.addRule(0, this.A0K.getId());
            } else if (this.A0R.A2U()) {
                layoutParams.setMargins(XV.A0b, 0, XV.A0b, XV.A0j);
            } else {
                layoutParams.setMargins(XV.A0b, 0, XV.A0b, XV.A0v);
            }
        } else {
            if (this.A0V.getVisibility() == 8) {
                layoutParams.setMargins(XV.A0b, 0, XV.A0b, XV.A0v);
                layoutParams.addRule(2, this.A0K.getId());
            } else {
                layoutParams.setMargins(XV.A0b, 0, XV.A0b, XV.A0o);
                layoutParams.addRule(2, this.A0V.getId());
            }
            layoutParams.addRule(0, i);
        }
        String[] strArr2 = A0d;
        if (strArr2[0].charAt(21) != strArr2[1].charAt(21)) {
            A0d[7] = "xA2Hf";
            layoutParams.addRule(14);
            this.A0W.setLayoutParams(layoutParams);
        } else {
            A0d[2] = "yZ";
            layoutParams.addRule(14);
            this.A0W.setLayoutParams(layoutParams);
        }
    }

    private void A0e(View view) {
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(XV.A0e, 0, 0, XV.A0v);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            view.setLayoutParams(layoutParams);
        }
    }

    private void A0f(View view, int i) {
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.removeRule(5);
            layoutParams.removeRule(12);
            layoutParams.removeRule(1);
            if (i != 1) {
                layoutParams.setMargins(0, 0, 0, XV.A0e);
                layoutParams.addRule(5, this.A0W.getId());
                layoutParams.addRule(12);
            } else if (this.A0W.getVisibility() == 8) {
                layoutParams.setMargins(0, XV.A0v, XV.A0b, 0);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            } else {
                layoutParams.setMargins(0, 0, 0, XV.A0v);
                layoutParams.addRule(12);
                layoutParams.addRule(5, this.A0W.getId());
            }
            view.setLayoutParams(layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1084bF
    public final void A0j() {
        this.A0G.removeCallbacksAndMessages(null);
        YB.A0d(this.A0O, this.A0N, super.A09, this.A0Q, super.A08, this.A0W, this.A04, this.A0P, this.A0K, this.A0V, this.A06, this.A05, this.A0J, this.A0M);
        removeAllViews();
        this.A0V.A0O();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1084bF
    public final void A0k() {
        super.A09.setOnClickListener(AbstractC1125bu.A03(super.A08, A0T(27, 4, 19)));
        this.A0Q.setOnClickListener(AbstractC1125bu.A03(super.A08, A0T(74, 5, 18)));
        this.A0P.setOnClickListener(AbstractC1125bu.A03(super.A08, A0T(16, 11, 125)));
        this.A0W.setOnClickListener(AbstractC1125bu.A03(super.A08, A0T(48, 12, 20)));
        if (this.A04 != null) {
            this.A04.setOnClickListener(AbstractC1125bu.A03(super.A08, A0T(31, 17, 106)));
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1084bF
    public void A0l(int i) {
        A0o();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1084bF
    public final void A0m(boolean z) {
        super.A0m(z);
        if (!z) {
            this.A0V.A0P();
        }
    }

    public final void A0n() {
        if (this.A04 != null) {
            this.A04.setVisibility(8);
        }
    }

    public final void A0o() {
        if (this.A00 != null) {
            this.A00.cancel();
            Handler handler = this.A0G;
            if (A0d[7].length() == 1) {
                throw new RuntimeException();
            }
            A0d[2] = "jq";
            handler.removeCallbacks(this.A0D);
        }
    }

    public final void A0p() {
        super.A08.setIncludeFontPadding(false);
        super.A08.setTextSize(18.0f);
        super.A08.setTextColor(this.A03);
        YB.A0V(super.A08, YB.A06(this.A01, this.A02));
        super.A08.A0D();
    }

    public final void A0q() {
        super.A08.A0D();
    }

    public final void A0r() {
        if (this.A00 != null) {
            int height = super.A08.getHeight();
            float f = height * 0.1f;
            String strA0T = A0T(79, 12, 27);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(super.A08, strA0T, -f, 0.0f);
            float bounceHeight = -f;
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(this.A0J, strA0T, bounceHeight, 0.0f);
            objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            animator1.setInterpolator(new LinearInterpolator());
            this.A00.playTogether(objectAnimatorOfFloat, animator1);
            this.A00.setDuration(600L);
            this.A00.start();
        }
    }

    public final void A0s(int i) {
        if (this.A04 != null) {
            int iMax = Math.max(0, this.A08 - i);
            if (iMax > 0) {
                String rewardMessage = this.A0R.A2D().A06().replace(A0T(0, 6, 101), String.valueOf(iMax));
                this.A04.setText(rewardMessage);
                return;
            }
            this.A04.setVisibility(8);
        }
    }

    public final void A0t(int i) {
        if (i == 0) {
            this.A0I.setVisibility(i);
            this.A0H.setVisibility(8);
        } else {
            this.A0I.setVisibility(i);
            this.A0H.setVisibility(0);
        }
    }

    public final void A0v(long j) {
        this.A00 = new AnimatorSet();
        this.A0G.postDelayed(this.A0D, j);
    }

    public final void A0w(View view, int i, float[] fArr) {
        RoundRectShape roundRectShape = new RoundRectShape(fArr, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable(roundRectShape);
        shapeDrawable.getPaint().setColor(i);
        view.setBackground(shapeDrawable);
    }

    public final void A0x(ViewGroup viewGroup, View view) {
        if (view != null) {
            viewGroup.addView(view);
        }
    }

    public final void A0z(ViewGroup viewGroup, boolean z, boolean z2, int i) {
        YB.A0d(this.A0K, this.A0V, this.A06, this.A0W, super.A09, this.A0Q, this.A0P, this.A04, this.A05);
        YB.A0J(this);
        int i2 = getResources().getConfiguration().orientation;
        if (z) {
            if (i2 == 2 && z2) {
                A0X();
                viewGroup.addView(this.A0K);
                A0Z();
                viewGroup.addView(this.A0W);
                A0Y();
                viewGroup.addView(this.A0V);
                A0e(this.A06);
                A0e(this.A05);
                A0x(viewGroup, this.A06);
                A0x(viewGroup, this.A05);
            } else {
                A0b(i, i2);
                viewGroup.addView(this.A0K);
                A0d(i, i2);
                viewGroup.addView(this.A0W);
                A0c(i, i2);
                viewGroup.addView(this.A0V);
                A0f(this.A06, i2);
                String[] strArr = A0d;
                String str = strArr[0];
                String str2 = strArr[1];
                int iCharAt = str.charAt(21);
                int orientation = str2.charAt(21);
                if (iCharAt == orientation) {
                    throw new RuntimeException();
                }
                A0d[3] = "nUr6kFdTvmItrv0H0Gc17HbHzXx4pqcd";
                A0f(this.A05, i2);
                A0x(viewGroup, this.A06);
                A0x(viewGroup, this.A05);
            }
            if (this.A04 != null) {
                RelativeLayout.LayoutParams placeHolderTextParam = new RelativeLayout.LayoutParams(-2, -2);
                int orientation2 = this.A0W.getId();
                placeHolderTextParam.addRule(2, orientation2);
                int orientation3 = this.A0W.getId();
                placeHolderTextParam.addRule(5, orientation3);
                int orientation4 = XV.A0v;
                placeHolderTextParam.setMargins(0, 0, 0, orientation4);
                this.A04.setLayoutParams(placeHolderTextParam);
                viewGroup.addView(this.A04);
                return;
            }
            return;
        }
        int orientation5 = A0o;
        this.A0W.setLayoutParams(new RelativeLayout.LayoutParams(-1, orientation5));
        if (this.A04 == null) {
            return;
        }
        this.A04.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    public final void A10(RelativeLayout relativeLayout) {
        if (this.A04 != null && this.A04.getVisibility() == 0) {
            relativeLayout.addView(this.A04);
        }
    }

    public final boolean A11() {
        if (this.A04 != null) {
            TextView textView = this.A04;
            if (A0d[2].length() != 2) {
                throw new RuntimeException();
            }
            A0d[7] = "y2tlX2w0t9Zmotlnwxz";
            if (textView.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public DZ getProgressBarAnimation() {
        return this.A0W;
    }

    public void setCTAClickListener(View.OnClickListener onClickListener) {
        super.A09.setOnClickListener(onClickListener);
        this.A0Q.setOnClickListener(onClickListener);
        this.A0P.setOnClickListener(onClickListener);
        this.A0W.setOnClickListener(onClickListener);
        if (this.A04 != null) {
            TextView textView = this.A04;
            String[] strArr = A0d;
            if (strArr[5].charAt(17) == strArr[6].charAt(17)) {
                throw new RuntimeException();
            }
            A0d[2] = "ZI";
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setChainedAdInfo(String str) {
        this.A04 = A0Q();
        YB.A0K(this.A04);
        this.A04.setText(str);
    }

    public void setPlaceHolderTextForRewardsConversion(String str) {
        if (this.A04 != null) {
            this.A04.setText(str);
            TextView textView = this.A04;
            if (A0d[2].length() != 2) {
                throw new RuntimeException();
            }
            String[] strArr = A0d;
            strArr[0] = "Pip5eIC199znlU0DxQZmRsWriqsU4m1j";
            strArr[1] = "8HZRpzu4lhTkjbLOeu664VtfGmtiQHTJ";
            textView.setOnClickListener(AbstractC1125bu.A03(super.A08, A0T(31, 17, 106)));
        }
    }

    private void setUpAdReportingInitiateView(AbstractC1586jd abstractC1586jd) {
        if (abstractC1586jd.A2Q() || abstractC1586jd.A2U()) {
            this.A0K.setVisibility(8);
            this.A0H.setVisibility(8);
            this.A0I.setVisibility(8);
            return;
        }
        this.A0V.setVisibility(8);
    }

    private void setUpCreditLineV2(AbstractC1586jd abstractC1586jd) {
        if (abstractC1586jd.A2W()) {
            this.A06 = AbstractC1031aO.A02(this.A0U, EnumC1029aM.A03, abstractC1586jd);
            YB.A0K(this.A06);
        } else {
            if (!abstractC1586jd.A2V()) {
                return;
            }
            this.A05 = AbstractC1031aO.A01(this.A0U, true, this.A0R, this.A0B, this.A0C, EnumC1029aM.A03, EnumC1032aP.A04);
            YB.A0K(this.A05);
        }
    }
}
