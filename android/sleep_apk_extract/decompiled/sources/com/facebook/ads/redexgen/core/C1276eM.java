package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1276eM {
    public ViewOnClickListenerC0619Kr A00;
    public final NN A01;
    public final NY A02;
    public final C0682Nd A03;
    public final C0691Nm A04;
    public final C1421gi A05;
    public final VI A06;
    public static final int A09 = (int) (XX.A02 * 4.0f);
    public static final int A07 = (int) (XX.A02 * 72.0f);
    public static final int A08 = (int) (XX.A02 * 8.0f);

    public C1276eM(C1421gi c1421gi, VA va, AbstractC1586jd abstractC1586jd) {
        this.A05 = c1421gi;
        this.A06 = new VI(abstractC1586jd.A2E(), va);
        this.A01 = abstractC1586jd.A28();
        this.A02 = abstractC1586jd.A29().A0I();
        this.A04 = abstractC1586jd.A2C();
        this.A03 = abstractC1586jd.A29().A0K();
    }

    private View A00(ViewOnClickListenerC0619Kr viewOnClickListenerC0619Kr) {
        C1121bq c1121bq = new C1121bq(this.A05, this.A01.A01(), true, false, false);
        c1121bq.A04(this.A02.A0G(), this.A02.A04(), null, false, true);
        c1121bq.setAlignment(17);
        C1115bk c1115bk = new C1115bk(this.A05);
        YB.A0N(c1115bk, 0);
        c1115bk.setRadius(50);
        new LM(c1115bk, this.A05).A04().A07(this.A04.A01());
        LinearLayout linearLayout = new LinearLayout(this.A05);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(c1115bk, new LinearLayout.LayoutParams(A07, A07));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A08, 0, A08);
        linearLayout.addView(c1121bq, layoutParams);
        if (viewOnClickListenerC0619Kr != null) {
            YB.A0J(viewOnClickListenerC0619Kr);
            linearLayout.addView(viewOnClickListenerC0619Kr, layoutParams);
            viewOnClickListenerC0619Kr.setPadding(XV.A0Z, 0, XV.A0Z, 0);
            if (TextUtils.isEmpty(viewOnClickListenerC0619Kr.getText())) {
                YB.A0H(viewOnClickListenerC0619Kr);
            }
        }
        return linearLayout;
    }

    private C7M A01() {
        C7M c7m = new C7M(this.A05);
        c7m.setLayoutManager(new C1491hr(this.A05, 0, false));
        c7m.setAdapter(new FH(this.A05, this.A03.A02(), A09, this.A00));
        return c7m;
    }

    private final EnumC1275eL A02() {
        if (!this.A03.A02().isEmpty()) {
            return EnumC1275eL.A03;
        }
        return EnumC1275eL.A02;
    }

    public final Pair<EnumC1275eL, View> A03(ViewOnClickListenerC0619Kr viewOnClickListenerC0619Kr) {
        View viewA01;
        this.A00 = viewOnClickListenerC0619Kr;
        EnumC1275eL enumC1275eLA02 = A02();
        switch (enumC1275eLA02) {
            case A03:
                viewA01 = A01();
                break;
            default:
                viewA01 = A00(this.A00);
                break;
        }
        VK.A04(viewA01, this.A06, VH.A0S);
        return new Pair<>(enumC1275eLA02, viewA01);
    }
}
