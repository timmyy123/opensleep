package com.facebook.ads.redexgen.core;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class KU extends AbstractC1134c3 implements XQ {
    public static byte[] A05;
    public static final int A06;
    public final AbstractC1586jd A00;
    public final XS A01;
    public final InterfaceC0962Yh A02;
    public final C1161cU A03;
    public final C1258e4 A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{38, 42, 30, 36, 34};
    }

    static {
        A01();
        A06 = Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public KU(C1138c7 c1138c7, boolean z) {
        int id;
        int iA01;
        super(c1138c7, z);
        this.A02 = c1138c7.A0C();
        this.A00 = c1138c7.A05();
        this.A03 = new C1161cU(c1138c7.A06(), c1138c7.A02());
        this.A03.A01(getTitleDescContainer(), z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(AbstractC1134c3.A08, AbstractC1134c3.A08, AbstractC1134c3.A08, AbstractC1134c3.A08);
        getCtaButton().setLayoutParams(layoutParams);
        if (c1138c7.A0H()) {
            this.A04 = new C1258e4(c1138c7.A06());
            this.A04.setPageDetails(c1138c7.A05().A2C());
            YB.A0G(1007, this.A04);
            RelativeLayout.LayoutParams pageDetailsParams = new RelativeLayout.LayoutParams(-2, -2);
            pageDetailsParams.addRule(2, getCtaButton().getId());
            pageDetailsParams.setMargins(AbstractC1134c3.A08, AbstractC1134c3.A08 - (AbstractC1134c3.A08 / 2), AbstractC1134c3.A08, 0);
            this.A04.setLayoutParams(pageDetailsParams);
            id = this.A04.getId();
            iA01 = c1138c7.A01() - (AbstractC1134c3.A08 / 2);
        } else {
            id = getCtaButton().getId();
            iA01 = c1138c7.A01();
            this.A04 = null;
        }
        FrameLayout insideContainerLayout = new FrameLayout(c1138c7.A06());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(10);
        layoutParams2.addRule(2, id);
        layoutParams2.setMargins(0, iA01, 0, 0);
        insideContainerLayout.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.setMargins(AbstractC1134c3.A08, 0, AbstractC1134c3.A08, 0);
        insideContainerLayout.addView(this.A03, layoutParams3);
        addView(insideContainerLayout);
        if (this.A04 != null) {
            addView(this.A04);
        }
        addView(getCtaButton());
        getCtaButton().A0F(c1138c7.A05(), c1138c7.A0B());
        View viewA02 = c1138c7.A02();
        this.A01 = XS.A00(c1138c7.A06(), this.A00, this);
        XR xrA02 = this.A01.A02(this.A00);
        c1138c7.A06().A0H().A00(xrA02.A01);
        getCtaButton().setCreativeAsCtaLoggingHelper(this.A01);
        if (viewA02 != null && xrA02.A00) {
            viewA02.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.cD
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A1Q(view);
                }
            });
        } else if (viewA02 != null && C0871Up.A1J(getAdContextWrapper())) {
            AbstractC1081bC.A00(viewA02, C0871Up.A1K(getAdContextWrapper()), new ViewOnClickListenerC1145cE(this));
        }
        if (C0871Up.A17(c1138c7.A06())) {
            getTitleDescContainer().setCTAClickListener(getCtaButton());
            if (c1138c7.A0B() != null) {
                c1138c7.A0B().setCTAClickListener(getCtaButton());
            }
        }
        if (this.A04 != null && C0871Up.A18(c1138c7.A06())) {
            this.A04.setOnClickListener(getCtaButton());
        }
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
    public final void A1C() {
        super.A1C();
        this.A01.A03();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final void A1H(NR nr, String str, double d, Bundle bundle) {
        super.A1H(nr, str, d, bundle);
        if (d > 0.0d) {
            int mediaHeight = (int) (((double) (A06 - (AbstractC1134c3.A08 * 2))) / d);
            this.A03.A00(mediaHeight);
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1134c3
    public final boolean A1O() {
        return false;
    }

    public final /* synthetic */ void A1Q(View view) {
        getCtaButton().A0E(A00(0, 5, 103));
    }
}
