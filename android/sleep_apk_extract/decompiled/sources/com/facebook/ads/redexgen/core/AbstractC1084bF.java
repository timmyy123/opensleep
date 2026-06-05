package com.facebook.ads.redexgen.core;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1084bF extends LinearLayout {
    public static byte[] A0A;
    public static final LinearLayout.LayoutParams A0B;
    public LinearLayout A00;
    public TextView A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final View.OnClickListener A05;
    public final RelativeLayout A06;
    public final C1421gi A07;
    public final ViewOnClickListenerC0619Kr A08;
    public final C1115bk A09;

    public static String A0h(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 11);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0i() {
        A0A = new byte[]{-96, -93, -93, -92, -77, -96, -88, -85, -78};
    }

    public abstract void A0l(int i);

    static {
        A0i();
        A0B = new LinearLayout.LayoutParams(-2, -2);
    }

    public AbstractC1084bF(C1421gi c1421gi, ViewOnClickListenerC0619Kr viewOnClickListenerC0619Kr, int i, C0679Na c0679Na, boolean z, String str, VA va, InterfaceC0962Yh interfaceC0962Yh, C1366fp c1366fp, Y2 y2, C0685Ng c0685Ng, boolean z2, String str2) {
        super(c1421gi);
        this.A02 = A0h(0, 0, 37);
        YB.A0K(this);
        this.A07 = c1421gi;
        this.A04 = i;
        this.A03 = z2;
        this.A02 = str2;
        this.A09 = new C1115bk(c1421gi);
        YB.A0N(this.A09, 0);
        YB.A0K(this.A09);
        if (z2) {
            this.A00 = new LinearLayout(c1421gi);
            this.A01 = new TextView(c1421gi);
            YB.A0K(this.A01);
        }
        if (viewOnClickListenerC0619Kr == null) {
            this.A08 = new ViewOnClickListenerC0619Kr(c1421gi, str, c0679Na, z, va, interfaceC0962Yh, c1366fp, y2, c0685Ng);
        } else {
            this.A08 = viewOnClickListenerC0619Kr;
        }
        YB.A0G(1001, this.A08);
        this.A05 = AbstractC1125bu.A03(this.A08, A0h(0, 9, 52));
        this.A06 = new RelativeLayout(c1421gi);
        this.A06.setLayoutParams(A0B);
        YB.A0K(this.A06);
    }

    public void A0j() {
    }

    public void A0k() {
        this.A09.setOnClickListener(this.A05);
    }

    public void A0m(boolean z) {
    }

    public final ViewOnClickListenerC0619Kr getCTAButton() {
        return this.A08;
    }

    public View getExpandableLayout() {
        return null;
    }

    public final ImageView getIconView() {
        return this.A09;
    }

    public void setInfo(NY ny, C0681Nc c0681Nc, String str, String str2, InterfaceC0936Xh interfaceC0936Xh, InterfaceC1099bU interfaceC1099bU) {
        this.A08.setCta(c0681Nc, str, new HashMap(), interfaceC0936Xh, interfaceC1099bU);
        new LM(this.A09, this.A07).A05(this.A04, this.A04).A07(str2);
    }

    public void setTitleMaxLines(int i) {
    }
}
