package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class GB extends FrameLayout implements InterfaceC0963Yi {
    public static String[] A0F = {"", "W4Q5rze9OaCj8zYeEqMqJDKHVn1jlwCj", "tfMK6ikBUwqELtuMuu5Kubqydzlt1dTF", "vHKgDETdn9HfwlFLESHxJfcBT5o8ovHI", "7Mubz7OjQQHbSYG", "T8sk6PPloyPWHv5iczs8jf8QHRZ1ZSou", "3ZCO1Nznw11DnI4nXgj4IK6CNfFIYy0N", "YX"};
    public static final RelativeLayout.LayoutParams A0G = new RelativeLayout.LayoutParams(-1, -1);
    public C0783Re A00;
    public InterfaceC0963Yi A01;
    public Intent A02;
    public Bundle A03;
    public InterfaceC0963Yi A04;
    public final AbstractC1586jd A05;
    public final AbstractC1586jd A06;
    public final C0693No A07;
    public final C1421gi A08;
    public final VA A09;
    public final WK A0A;
    public final ViewOnSystemUiVisibilityChangeListenerC0952Xx A0B;
    public final InterfaceC0962Yh A0C;
    public final ZU A0D;
    public final boolean A0E;

    public GB(C1421gi c1421gi, VA va, AbstractC1586jd abstractC1586jd, AbstractC1586jd abstractC1586jd2, InterfaceC0962Yh interfaceC0962Yh, C0783Re c0783Re, WK wk) {
        super(c1421gi);
        this.A08 = c1421gi;
        this.A09 = va;
        this.A06 = abstractC1586jd;
        this.A05 = abstractC1586jd2;
        this.A07 = this.A05.A29().A0H().A07();
        this.A0C = interfaceC0962Yh;
        this.A0B = new ViewOnSystemUiVisibilityChangeListenerC0952Xx(this);
        this.A0B.A05(EnumC0951Xw.A02);
        this.A0A = wk;
        if (this.A0A == WK.A0J) {
            this.A0D = new MG();
        } else {
            this.A0D = new MH();
        }
        boolean z = false;
        if (this.A07 != null) {
            if (this.A07.A0b() && this.A05.A1n()) {
                z = true;
            }
            this.A0E = z;
            return;
        }
        this.A0E = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InterfaceC0963Yi A05(ZU zu, C0693No c0693No, Boolean bool) {
        if (bool.booleanValue()) {
            return new MW(this.A08, this.A09, this.A0C, this.A05, c0693No, this.A05.A1G(), zu);
        }
        return new NO(this.A08, this.A09, this.A0C, this.A05, this.A05.A1G(), zu, true);
    }

    private C4V A0A() {
        if (this.A07 != null) {
            this.A06.A1R(this.A07.A0X());
            this.A06.A1S(this.A07.A0c());
        }
        C4V c4v = new C4V(this.A08, this.A0D, this.A09, this.A06, new C0827Sx(this.A08), this.A0C);
        c4v.setVideoLeadingPlayableAdListener(new GD(this));
        return c4v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B() {
        if (this.A04 != null) {
            this.A04.onDestroy();
            if (this.A04 instanceof View) {
                ((View) this.A04).setVisibility(8);
                removeView((View) this.A04);
            }
        }
    }

    private final void A0C(Intent intent, Bundle bundle, C0783Re c0783Re) {
        this.A04 = A0A();
        this.A04.AAu(intent, bundle, c0783Re);
        if (this.A0E && this.A07 != null) {
            this.A01 = A05(this.A0D, this.A07, Boolean.valueOf(this.A05.A1n()));
            this.A01.AAu(intent, bundle, c0783Re);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0963Yi
    public final void AAu(Intent intent, Bundle bundle, C0783Re c0783Re) {
        this.A02 = intent;
        this.A03 = bundle;
        this.A00 = c0783Re;
        this.A0C.A45(this, A0G);
        A0C(intent, bundle, c0783Re);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0963Yi
    public final void AFA(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0963Yi
    public final void AFi(boolean z) {
        if (this.A04 instanceof MW) {
            InterfaceC0963Yi interfaceC0963Yi = this.A04;
            String[] strArr = A0F;
            if (strArr[0].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[0] = "";
            strArr2[4] = "sBQPYruyJOWbMZu";
            interfaceC0963Yi.AFi(z);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0963Yi
    public final void AIv(Bundle bundle) {
    }

    public InterfaceC0963Yi getContentView() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0963Yi
    public String getCurrentClientToken() {
        return this.A06.A2E();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0963Yi
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.A04 != null) {
            this.A04.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.A04 instanceof MW) {
            ((MW) this.A04).onConfigurationChanged(configuration);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0963Yi
    public final void onDestroy() {
    }

    public void setListener(InterfaceC0962Yh interfaceC0962Yh) {
    }
}
