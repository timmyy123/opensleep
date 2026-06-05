package com.facebook.ads.redexgen.core;

import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.TransitionSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ME extends AbstractC0984Zd {
    public static String[] A03 = {"ps9u6Kn8p", "fRCCllxRFm9XYnsS5Nz0CDYYbd8rz98F", "veZY5LUK4HkumILqtvhVtf9OT9QK1Jmh", "8c6Edyt19YE2bwpDp37rWBgdyfN4I4si", "Dgwj6SSLqT", "biYcUlACC5CMDg3zbjwwDR7mq5XP76DA", "rp5V5gFYHfFnaijOqqdMDMWavMrEx7HP", "ycj43TNZcka4uMSCxDz6fuqQ2r9gi3g6"};
    public static final int A04 = (int) (XX.A02 * 8.0f);
    public final RelativeLayout A00;
    public final C0711Og A01;
    public final C1421gi A02;

    public ME(C1421gi c1421gi, VA va, String str, C0691Nm c0691Nm, InterfaceC0963Yi interfaceC0963Yi, InterfaceC0962Yh interfaceC0962Yh) {
        super(c1421gi, va, str, c0691Nm, interfaceC0963Yi, interfaceC0962Yh);
        this.A02 = c1421gi;
        this.A01 = AbstractC0712Oh.A00(c1421gi.A02());
        this.A00 = new RelativeLayout(getContext());
        addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        YB.A0N(this.A00, -1728053248);
        if (C0871Up.A2b(c1421gi)) {
            this.A00.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Zi
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A0T(view);
                }
            });
        }
    }

    public static RelativeLayout.LayoutParams A00(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, z ? -1 : -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    private void A01() {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new ChangeBounds()).addTransition(new Explode());
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0984Zd
    public final void A0O() {
        C0715Ok c0715OkA0A = this.A01.A0A();
        C0999Zs c0999Zs = new C0999Zs(this.A02);
        c0999Zs.setInfo(YM.HIDE_AD, this.A01.A0H(), this.A01.A0G());
        c0999Zs.setOnClickListener(new ViewOnClickListenerC0990Zj(this));
        C0715Ok c0715OkA0B = this.A01.A0B();
        C0999Zs c0999Zs2 = new C0999Zs(this.A02);
        c0999Zs2.setInfo(YM.REPORT_AD, this.A01.A0L(), this.A01.A0K());
        c0999Zs2.setOnClickListener(new ViewOnClickListenerC0991Zk(this));
        C0999Zs c0999Zs3 = new C0999Zs(this.A02);
        c0999Zs3.setInfo(YM.AD_CHOICES_ICON, this.A01.A0M(), "");
        c0999Zs3.setOnClickListener(new ViewOnClickListenerC0992Zl(this));
        LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(A04 * 2, A04, A04 * 2, A04);
        YB.A0N(linearLayout, -1);
        if (!c0715OkA0A.A05().isEmpty()) {
            linearLayout.addView(c0999Zs, itemParams);
        }
        if (!c0715OkA0B.A05().isEmpty()) {
            linearLayout.addView(c0999Zs2, itemParams);
        }
        linearLayout.addView(c0999Zs3, itemParams);
        A01();
        this.A00.removeAllViews();
        this.A00.addView(linearLayout, A00(false));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0984Zd
    public final void A0P() {
        this.A00.removeAllViews();
        YB.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0984Zd
    public final void A0Q(C0715Ok c0715Ok, EnumC0713Oi enumC0713Oi) {
        String strA0E;
        int i;
        String strA01;
        if (enumC0713Oi == EnumC0713Oi.A05) {
            return;
        }
        boolean z = enumC0713Oi == EnumC0713Oi.A06;
        C0981Za c0981Za = new C0981Za(this.A02, this.A0D);
        if (z) {
            C0711Og c0711Og = this.A01;
            if (A03[4].length() != 10) {
                throw new RuntimeException();
            }
            A03[6] = "KfE81dulHFmzGO7NxqDM7oaE1pV2dKkX";
            strA0E = c0711Og.A0F();
        } else {
            strA0E = this.A01.A0E();
        }
        C0981Za c0981ZaA0D = c0981Za.A0H(strA0E).A0G(this.A01.A0D()).A0E(c0715Ok.A04()).A0D(z ? YM.REPORT_AD : YM.HIDE_AD);
        if (z) {
            i = -552389;
        } else {
            i = -13272859;
        }
        C0981Za c0981ZaA0C = c0981ZaA0D.A0C(i);
        if (this.A0C != null) {
            C0691Nm c0691Nm = this.A0C;
            if (A03[1].charAt(11) != 'X') {
                strA01 = c0691Nm.A01();
            } else {
                A03[0] = "vLdx3pZGf";
                strA01 = c0691Nm.A01();
            }
        } else {
            strA01 = "";
        }
        C0982Zb adHiddenView = c0981ZaA0C.A0F(strA01).A0L();
        YB.A0N(adHiddenView, -1);
        YB.A0W(this);
        this.A00.removeAllViews();
        this.A00.addView(adHiddenView, A00(true));
        super.A0Q(c0715Ok, enumC0713Oi);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0984Zd
    public final void A0R(C0715Ok c0715Ok, EnumC0713Oi enumC0713Oi) {
        String strA0H;
        boolean z = enumC0713Oi == EnumC0713Oi.A06;
        C1421gi c1421gi = this.A02;
        InterfaceC0986Zf interfaceC0986Zf = this.A0D;
        if (z) {
            strA0H = this.A01.A0L();
        } else {
            strA0H = this.A01.A0H();
        }
        C1002Zv c1002Zv = new C1002Zv(c1421gi, c0715Ok, interfaceC0986Zf, strA0H, z ? YM.REPORT_AD : YM.HIDE_AD);
        c1002Zv.setClickable(true);
        YB.A0N(c1002Zv, -1);
        c1002Zv.setPadding(A04 * 2, A04, A04 * 2, A04);
        A01();
        this.A00.removeAllViews();
        RelativeLayout relativeLayout = this.A00;
        String[] strArr = A03;
        if (strArr[3].charAt(9) == strArr[5].charAt(9)) {
            throw new RuntimeException();
        }
        A03[1] = "OoQvJ70CiRWXlhIiWSDPNsGTFrOY4nX1";
        relativeLayout.addView(c1002Zv, A00(false));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0984Zd
    public final boolean A0S() {
        return false;
    }

    public final /* synthetic */ void A0T(View view) {
        this.A0D.A54();
    }
}
