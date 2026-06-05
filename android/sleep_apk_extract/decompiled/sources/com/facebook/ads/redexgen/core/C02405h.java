package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C02405h extends AbstractC0560Ij {
    public static String[] A09 = {"48gXxVXafINQx", "X9eHMFtmNxkudREV2ga0mL63IUwpVFyn", "fDHVKSg", "BJ3S", "6p1nQLD", "GwvdfXoW7Tkcgx6xI32", "XjSW5yJHqMwpzXQP1hTrWYHuzeodWOV3", "mLwcnNPCnn6Mi"};
    public static final RelativeLayout.LayoutParams A0A = new RelativeLayout.LayoutParams(-1, -1);
    public XO A00;
    public AbstractC1134c3 A01;
    public DZ A02;
    public final int A03;
    public final ImageView A04;
    public final VI A05;
    public final AbstractC0956Yb A06;
    public final InterfaceC1241dm A07;
    public final AtomicBoolean A08;

    public C02405h(C1421gi c1421gi, ZU zu, int i, VA va, AbstractC1586jd abstractC1586jd, InterfaceC0962Yh interfaceC0962Yh, AbstractC0956Yb abstractC0956Yb, VI vi, boolean z, boolean z2, InterfaceC1241dm interfaceC1241dm, int i2, int i3) {
        super(c1421gi, zu, va, abstractC1586jd, i, z, z2, interfaceC0962Yh, i3);
        this.A08 = new AtomicBoolean(false);
        this.A03 = i2;
        this.A07 = interfaceC1241dm;
        this.A04 = new ImageView(getContext());
        this.A06 = abstractC0956Yb;
        this.A05 = vi;
        if (abstractC1586jd.A1c()) {
            this.A02 = new DZ(c1421gi, this.A03);
        }
        this.A04.setScaleType(ImageView.ScaleType.CENTER);
        this.A04.setAdjustViewBounds(true);
        new LM(this.A04, c1421gi).A05(abstractC1586jd.A29().A0H().A00(), abstractC1586jd.A29().A0H().A01()).A06(new C0558Ih(this)).A07(abstractC1586jd.A29().A0H().A08());
        A08(c1421gi.getResources().getConfiguration().orientation);
    }

    private AbstractC1134c3 A02(int i) {
        if (this.A04.getParent() != null) {
            YB.A0J(this.A04);
        }
        boolean z = i != 2;
        C1137c6 c1137c6 = new C1137c6(super.A07, super.A08, this.A0B, super.A06, this.A04, this.A0D, this.A0A);
        C1137c6 interstitialLayoutParamsBuilder = c1137c6.A0J(this.A06.getToolbarHeight());
        interstitialLayoutParamsBuilder.A0P(this.A06).A0I(i).A0T(z).A0S(super.A00).A0M(this.A05);
        if (this.A02 != null) {
            c1137c6.A0R(this.A02);
        }
        c1137c6.A0L(C0674Mu.A00(super.A07, super.A08, "", XB.A00(super.A06.A29().A0J().A05()), new HashMap(), super.A06.A2A()));
        c1137c6.A0Q(this.A07);
        return AbstractC1135c4.A00(c1137c6.A0U(), null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        if (this.A08.get()) {
            A1F();
        }
    }

    private void A08(int i) {
        YB.A0J(this.A01);
        this.A01 = A02(i);
        if (this.A01 instanceof KE) {
            ((KE) this.A01).setChildChainedAd(true);
        } else if (this.A01 instanceof C0584Ji) {
            AbstractC1134c3 abstractC1134c3 = this.A01;
            String[] strArr = A09;
            if (strArr[1].charAt(0) != strArr[6].charAt(0)) {
                throw new RuntimeException();
            }
            A09[5] = "Sp2NSSouatJBlog5Q54";
            ((C0584Ji) abstractC1134c3).setChildChainedAd(true);
        }
        addView(this.A01, 0, A0A);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij
    public final EnumC0670Mq A1D(String str) {
        return this.A01.A1B(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij
    public final void A1E() {
        if (C0871Up.A1z(super.A07)) {
            super.A07.A0B().AKU(this.A04);
        }
        if (this.A01 != null) {
            this.A01.A1C();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij
    public final void A1G() {
        if (this.A01 instanceof C0604Kc) {
            AbstractC1134c3 abstractC1134c3 = this.A01;
            String[] strArr = A09;
            if (strArr[7].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            A09[3] = "fHRV";
            ((C0604Kc) abstractC1134c3).A1Q();
            return;
        }
        if (this.A01 instanceof C0584Ji) {
            ((C0584Ji) this.A01).A1Q(false);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij
    public final void A1H() {
        int iA02 = super.A06.A29().A0H().A02();
        int secondsForNextCta = this.A03;
        if (secondsForNextCta > 0) {
            this.A00 = new XO(this.A03, 100.0f, 100L, new Handler(Looper.getMainLooper()), new C0556If(this));
            this.A00.A07();
            if (iA02 >= 0) {
                this.A06.setProgressSpinnerInvisible(true);
            }
            if (iA02 != 0) {
                int secondsForNextCta2 = this.A03;
                if (iA02 < secondsForNextCta2) {
                    if (iA02 <= 0) {
                        return;
                    }
                    new XO(iA02, new C0554Id(this)).A07();
                    return;
                }
            }
            this.A06.setToolbarActionMode(8);
            return;
        }
        this.A07.AFw(false);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij
    public final void A1I(boolean z) {
        this.A01.setChainedWatchAndBrowseSkippableStatus(z);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij
    public final void A1J(boolean z) {
        if (this.A00 != null && this.A00.A05()) {
            this.A00.A06();
        }
        if (this.A01 != null) {
            this.A01.A1L(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij
    public final void A1K(boolean z) {
        if (this.A00 != null && !this.A00.A04()) {
            this.A00.A07();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij
    public final boolean A1L() {
        if (this.A01.A1M()) {
            if (!(this.A01 instanceof C0604Kc) || ((C0604Kc) this.A01).A1R()) {
                return (this.A01 instanceof C0584Ji) && !((C0584Ji) this.A01).A1S();
            }
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij
    public final boolean A1M() {
        if (this.A01 instanceof C0604Kc) {
            return ((C0604Kc) this.A01).A1R();
        }
        boolean z = this.A01 instanceof C0584Ji;
        String[] strArr = A09;
        if (strArr[1].charAt(0) != strArr[6].charAt(0)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[2] = "VUX6Wbk";
        strArr2[4] = "Kq1l7t9";
        if (z) {
            return ((C0584Ji) this.A01).A1S();
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij
    public final boolean A1N() {
        if (this.A01 instanceof C0604Kc) {
            return ((C0604Kc) this.A01).A1S();
        }
        if (this.A01 instanceof C0584Ji) {
            return ((C0584Ji) this.A01).A1T();
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij
    public C1239dk getFullScreenAdStyle() {
        C0679Na colors = this.A01.getColors();
        return new C1239dk(this.A01.A1O(), C1239dk.A07, colors, ViewOnClickListenerC0619Kr.A05(super.A06), colors.A08(this.A01.A1O() || (this.A01 instanceof AbstractC0602Ka)), null);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0560Ij, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.A01 instanceof C0604Kc) {
            this.A01.onConfigurationChanged(configuration);
        } else if (!super.A06.A29().A0T()) {
            A08(configuration.orientation);
        }
    }
}
