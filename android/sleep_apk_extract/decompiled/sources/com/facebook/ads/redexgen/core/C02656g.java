package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6g, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C02656g extends AbstractC0721Oq {
    public static String[] A0E = {"vPMRmT88mgqFEke8ATcV4DjUXhfKSOnR", "vcxzG3inNeckkmEQerBRT2lbis8VS7m7", "eUyvpit7R4E8S", "81xoNnBskiL3NHuExK0jouL0xNUbAz24", "9rRUUXnOqMhF40SMgnak6Kzhg0roR6HI", "NGPySEd1uSK0pWi3", "38FqFi34P3eGFZ4PzNWUjtJ56H9UGtdy", "zzAANKTeXLAH5LLCmw3IQOJWh4jGOg5d"};
    public C4L A00;
    public boolean A01;
    public boolean A02;
    public final ViewGroup A03;
    public final C0827Sx A04;
    public final VA A05;
    public final C0458Ek A06;
    public final EA A07;
    public final E8 A08;
    public final C0431Dj A09;
    public final ViewOnClickListenerC0428Dg A0A;
    public final C0427Df A0B;
    public final AbstractC1365fo A0C;
    public final C1366fp A0D;

    public C02656g(C1421gi c1421gi, VA va, C0827Sx c0827Sx, VI vi, View.OnClickListener onClickListener, AbstractC1586jd abstractC1586jd) {
        super(c1421gi, onClickListener, vi, abstractC1586jd);
        this.A02 = false;
        this.A01 = false;
        this.A07 = new EA() { // from class: com.facebook.ads.redexgen.X.6p
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.core.UN
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C4K c4k) {
                if (C0871Up.A1T(((AbstractC0721Oq) this.A00).A08)) {
                    this.A00.A06.A0e(EnumC1308et.A02, 30);
                }
            }
        };
        this.A08 = new C02736o(this);
        this.A05 = va;
        this.A04 = c0827Sx;
        this.A0C = A00();
        this.A0D = A07();
        this.A03 = new FrameLayout(c1421gi);
        addView(this.A03, new RelativeLayout.LayoutParams(-1, -1));
        this.A06 = A01(vi);
        this.A0A = A04();
        this.A09 = A03();
        this.A0B = A06(vi);
        YB.A0K(this.A0B);
        A0F();
    }

    private C0720Op A00() {
        return new C0720Op(this);
    }

    private C0458Ek A01(VI vi) {
        C0458Ek c0458Ek = new C0458Ek(super.A08);
        YB.A0K(c0458Ek);
        c0458Ek.setFunnelLoggingHandler(vi);
        c0458Ek.getEventBus().A03(this.A07, this.A08);
        if (C0871Up.A1V(super.A08)) {
            c0458Ek.setVolume(0.0f);
        }
        if (!C0871Up.A1Q(super.A08)) {
            c0458Ek.setOnClickListener(new ViewOnClickListenerC0979Yy(this));
        }
        RelativeLayout.LayoutParams videoLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        videoLayoutParams.addRule(13);
        addView(c0458Ek, videoLayoutParams);
        return c0458Ek;
    }

    private C0431Dj A03() {
        C0431Dj c0431Dj = new C0431Dj(super.A08);
        c0431Dj.setTextColor(-1);
        YB.A0a(c0431Dj, false, 12);
        c0431Dj.setGravity(17);
        this.A06.A0f(c0431Dj);
        return c0431Dj;
    }

    private ViewOnClickListenerC0428Dg A04() {
        ViewOnClickListenerC0428Dg viewOnClickListenerC0428Dg = new ViewOnClickListenerC0428Dg(super.A08);
        this.A06.A0f(viewOnClickListenerC0428Dg);
        return viewOnClickListenerC0428Dg;
    }

    private C0427Df A06(VI vi) {
        C0427Df c0427Df = new C0427Df(super.A08, vi, true);
        c0427Df.setBackgroundPaintColor(855638016);
        this.A06.A0f(c0427Df);
        return c0427Df;
    }

    private C1366fp A07() {
        return new C1366fp(this, 50, true, new WeakReference(this.A0C), super.A08);
    }

    private void A08() {
        if (getVisibility() == 0 && this.A01 && hasWindowFocus()) {
            this.A0D.A0U();
            return;
        }
        if (super.A05 != null) {
            super.A05.A0P();
        }
        this.A0D.A0V();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0721Oq
    public final void A0D() {
        this.A0D.A0V();
        this.A06.getEventBus().A04(this.A07, this.A08);
        this.A06.A0W();
        if (super.A05 != null) {
            super.A05.A0O();
        }
        YB.A0J(this.A06);
        if (this.A00 != null) {
            C4L c4l = this.A00;
            if (A0E[1].charAt(6) != 'i') {
                throw new RuntimeException();
            }
            A0E[6] = "QSSPJpdXUUt8XbGqouva3DO5ILergMU2";
            c4l.A0p();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0721Oq
    public final void A0E() {
        super.A0E();
        this.A0B.A09();
        this.A02 = true;
        this.A0D.A0U();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0721Oq
    public final void A0F() {
        super.A0F();
        if (C0871Up.A1W(super.A08)) {
            YB.A0J(this.A0A);
            this.A0A.setLayoutParams(A0C(true, false));
            addView(this.A0A);
        }
        if (C0871Up.A1S(super.A08)) {
            YB.A0J(this.A09);
            this.A09.setLayoutParams(A0C(true, true));
            addView(this.A09);
        }
        if (C0871Up.A1U(super.A08)) {
            YB.A0J(this.A0B);
            this.A0B.setLayoutParams(A0C(false, false));
            addView(this.A0B);
        }
        C1012a5 c1012a5 = super.A04;
        if (A0E[6].charAt(23) != '5') {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[5] = "QWCSfSUWuFerXIpv";
        strArr[2] = "7tLHnRgEmKXMN";
        if (c1012a5 != null) {
            YB.A0J(super.A04);
            if (C0871Up.A1U(super.A08)) {
                super.A04.setLayoutParams(AbstractC0721Oq.A0A(this.A0B));
            } else {
                super.A04.setLayoutParams(AbstractC0721Oq.A0A(null));
            }
            addView(super.A04);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0721Oq
    public final boolean A0G() {
        return this.A06.A0l();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0721Oq
    public final boolean A0H() {
        if (getMeasuredWidth() <= 0 || this.A06.getMeasuredWidth() <= 0) {
            return true;
        }
        int measuredWidth = (int) (((double) (getMeasuredWidth() - this.A06.getMeasuredWidth())) / 2.0d);
        int i = AbstractC0721Oq.A0D;
        int widthGap = AbstractC0721Oq.A0C;
        return measuredWidth > i + (widthGap * 2);
    }

    public final C02656g A0I(String str, String str2, String str3, String str4, String str5) {
        this.A06.setVideoURI(this.A04.A0T(str2));
        this.A00 = new C4L(super.A08, this.A05, this.A06, str);
        if (str3 != null && !TextUtils.isEmpty(str3)) {
            new LM(this.A03, super.A08).A05(this.A03.getHeight(), this.A03.getWidth()).A06(new C0719Oo(this)).A07(str3);
        }
        if (str5 != null) {
            this.A0A.setPlayAccessibilityLabel(str4);
        }
        if (str5 != null) {
            this.A0A.setPauseAccessibilityLabel(str5);
        }
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0721Oq
    public int getMediaViewId() {
        return this.A06.getId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A01 = true;
        A08();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A01 = false;
        A08();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        A08();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        A08();
    }
}
