package com.facebook.ads.redexgen.core;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0604Kc extends AbstractC1134c3 implements XQ {
    public static String[] A0F = {"CRyUSCOowkTfoe8xXMA5e17hdMg", "WkFBEVgF0nyPchlhdBM9PAwmOGJ", "zSHiyACtWS1MQDlmmeiywmMfEBCYqg8r", "a6voQfhnzW62WB0803n3akdQXSWLA", "ESev22IS7ntvGAjOW6Y11JRWDyKuDF5b", "qYjSUGFL2zXSYltHWao95ysggj7pRI", "zEaDWfefMQybHYLhUDvoHIQpUffGUNEN", "lLaoJShXnQXOT6Cok4oNwdKWfBYo0"};
    public static final int A0G = (int) (XX.A02 * 80.0f);
    public float A00;
    public C1150cJ A01;
    public C1282eS A02;
    public boolean A03;
    public final Handler A04;
    public final View A05;
    public final RelativeLayout A06;
    public final RelativeLayout A07;
    public final AbstractC1586jd A08;
    public final AbstractC0956Yb A09;
    public final InterfaceC0962Yh A0A;
    public final LK A0B;
    public final AtomicBoolean A0C;
    public final boolean A0D;
    public final XS A0E;

    public C0604Kc(C1138c7 c1138c7) {
        super(c1138c7, true);
        this.A04 = new Handler(Looper.getMainLooper());
        this.A0D = false;
        this.A0C = new AtomicBoolean(false);
        this.A03 = true;
        this.A0A = c1138c7.A0C();
        this.A09 = c1138c7.A0B();
        this.A08 = c1138c7.A05();
        this.A0E = XS.A00(c1138c7.A06(), this.A08, this);
        this.A07 = new RelativeLayout(c1138c7.A06());
        this.A0B = A00(c1138c7, this.A08.A29(), this.A08.A0w());
        this.A06 = new RelativeLayout(c1138c7.A06());
        YB.A0K(this.A06);
        YB.A0K(this.A07);
        this.A05 = c1138c7.A02();
        A04();
        this.A07.addView(this.A06, new RelativeLayout.LayoutParams(-2, -2));
        addView(this.A07, new RelativeLayout.LayoutParams(-1, -1));
        AbstractC1122br.A00(c1138c7.A06(), this.A07, this.A08.A29().A0H().A08());
        this.A0B.setInfo(this.A08.A29().A0I(), this.A08.A29().A0J(), this.A08.A2E(), this.A08.A2C().A01(), null, null);
        A03();
        super.A07.A06().A0F().AKh(XL.A00(this.A00), getResources().getConfiguration().orientation, false, true, AbstractC0673Mt.A0C(super.A07.A04()));
    }

    private LK A00(C1138c7 c1138c7, NR nr, String str) {
        this.A00 = new C0827Sx(c1138c7.A06()).A0M(nr.A0H().A08());
        LK adDetailsView = new C1123bs(this.A00, str, c1138c7.A06(), getColors(), c1138c7.A05(), c1138c7.A0C(), getCtaButton(), A0G, false, c1138c7.A07(), c1138c7.A0F(), c1138c7.A0A(), c1138c7.A0E(), c1138c7.A08(), false).A03();
        if (c1138c7.A0G() != null) {
            adDetailsView.setChainedAdInfo(c1138c7.A0G());
        }
        return adDetailsView;
    }

    private void A01() {
        this.A01 = new C1150cJ(super.A07.A06(), this.A08, super.A07.A08(), this.A04, super.A07.A0C());
        this.A01.A0I(false);
        addView(this.A01.A0C(getCtaButton()));
    }

    private void A02() {
        YB.A0d(this.A0B);
        if (!this.A08.A29().A0K().A02().isEmpty()) {
            this.A02 = new C1282eS(super.A07.A06(), this.A08, this.A0A, getCtaButton(), this.A04, super.A07.A08());
            this.A02.A0f(false);
            addView(this.A02.A0W(), new RelativeLayout.LayoutParams(-1, -1));
            return;
        }
        A01();
    }

    private void A03() {
        YB.A0J(this.A0B);
        addView(this.A0B, new RelativeLayout.LayoutParams(-1, -1));
        this.A0B.setVisibility(0);
        A05(getResources().getConfiguration().orientation);
        this.A0B.A0u(getResources().getConfiguration().orientation);
        this.A0B.bringToFront();
    }

    private void A04() {
        if (this.A05 == null) {
            return;
        }
        this.A06.addView(this.A05, new RelativeLayout.LayoutParams(-2, -2));
        YB.A0K(this.A05);
        XR xrA02 = this.A0E.A02(this.A08);
        super.A07.A06().A0H().A00(xrA02.A01);
        getCtaButton().setCreativeAsCtaLoggingHelper(this.A0E);
        if (xrA02.A00) {
            this.A05.setOnClickListener(new ViewOnClickListenerC1126bv(this));
        } else {
            if (!C0871Up.A1J(getAdContextWrapper())) {
                return;
            }
            AbstractC1081bC.A00(this.A05, C0871Up.A1K(getAdContextWrapper()), new ViewOnClickListenerC1127bw(this));
        }
    }

    private void A05(int i) {
        A06(i);
        A07(i, this.A07, this.A06);
    }

    private void A06(int i) {
        if (this.A05 == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A05.getLayoutParams();
        layoutParams.removeRule(13);
        layoutParams.removeRule(10);
        layoutParams.removeRule(9);
        if (i == 1) {
            layoutParams.width = -1;
            layoutParams.height = -2;
            layoutParams.addRule(10);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
            if (XL.A05(this.A00)) {
                layoutParams.addRule(13);
            } else {
                layoutParams.addRule(9);
            }
        }
        this.A05.setLayoutParams(layoutParams);
    }

    private final void A07(int i, ViewGroup viewGroup, RelativeLayout relativeLayout) {
        if ((this.A0B instanceof C6V) || (this.A0B instanceof C6U)) {
            YB.A0J(this.A0B);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            if (getResources().getConfiguration().orientation == 2) {
                layoutParams.addRule(1, relativeLayout.getId());
                this.A0B.setLayoutParams(layoutParams);
                String[] strArr = A0F;
                if (strArr[0].length() != strArr[1].length()) {
                    throw new RuntimeException();
                }
                A0F[6] = "EmhBF28Af3az5oL74X7a9tytdWpdYPgl";
                viewGroup.addView(this.A0B);
            } else {
                addView(this.A0B, layoutParams);
            }
        }
        this.A0B.A0l(i);
        this.A0B.A0y(viewGroup, relativeLayout, i);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final boolean A0A() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final boolean A0B() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final EnumC0670Mq A1B(String str) {
        return this.A0B.getCTAButton().A0E(str);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final void A1C() {
        super.A1C();
        this.A04.removeCallbacksAndMessages(null);
        this.A0B.A0j();
        if (this.A02 != null) {
            this.A02.A0Y();
        }
        if (this.A01 != null) {
            this.A01.A0F();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final void A1H(NR nr, String str, double d, Bundle bundle) {
        super.A1H(nr, str, d, bundle);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final void A1L(boolean z) {
        super.A1L(z);
        this.A0B.A0m(z);
        if (this.A02 != null) {
            this.A02.A0e(z);
        }
        if (this.A01 != null) {
            this.A01.A0H(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final boolean A1M() {
        return this.A08.A29().A0V();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final boolean A1O() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final boolean A1P(boolean z) {
        if (this.A08.A29().A0V() && !this.A0C.get()) {
            A1Q();
            return true;
        }
        return false;
    }

    public final void A1Q() {
        this.A0C.set(true);
        YB.A0d(this.A06, this.A0B, this.A07);
        YB.A0L(this.A09);
        YB.A0W(this);
        A02();
        this.A03 = true;
        if (super.A07.A0D() != null) {
            super.A07.A0D().AFw(true);
            if (this.A09 != null && this.A08.A29().A0K().A00() > 0) {
                this.A03 = false;
                if (this.A08.A2P()) {
                    this.A09.setToolbarActionMode(8);
                } else {
                    this.A09.setToolbarActionMode(2);
                }
                new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1128bx(this), this.A08.A29().A0K().A00());
            }
        }
    }

    public final boolean A1R() {
        return this.A0C.get();
    }

    public final boolean A1S() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public int getCloseButtonStyle() {
        if (A1M() && !this.A0C.get()) {
            return 1;
        }
        return super.getCloseButtonStyle();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.A02 != null && this.A0C.get()) {
            this.A02.A0a(configuration.orientation);
            String[] strArr = A0F;
            if (strArr[0].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A0F[6] = "qGsvoGIijzM6smaTEa50KnvmYJop2SBn";
            return;
        }
        A05(configuration.orientation);
    }
}
