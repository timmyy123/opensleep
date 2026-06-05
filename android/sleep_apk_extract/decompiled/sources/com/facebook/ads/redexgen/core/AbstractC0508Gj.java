package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0508Gj extends FrameLayout implements InterfaceC0963Yi {
    public static byte[] A0F;
    public static String[] A0G = {"TjJo4iSgng0vXhs45r72rqpPNY8skILr", "91ouIxxhnH3Z5", "W0nriFofCJUyd1UjJ1D34NnkecurTiQg", "io9DF8pP4zbnzlMZ0cU9ebyf5c8MGTpw", "GW5XhaY0JB8EDDs", "wmyPNYIHMh217", "CqbXOmo7iYNySqq5By1vz3nqMfrwlLlZ", "8HyCFF6UzaJGyjOzTS3wQDIkiaQQj"};
    public static final RelativeLayout.LayoutParams A0H;
    public boolean A00;
    public ViewGroup A01;
    public boolean A02;
    public final AbstractC1586jd A03;
    public final C0827Sx A04;
    public final C1421gi A05;
    public final VA A06;
    public final VI A07;
    public final Y2 A08;
    public final AbstractC0956Yb A09;
    public final InterfaceC0962Yh A0A;
    public final ZU A0B;
    public final C1366fp A0C;
    public final ViewOnSystemUiVisibilityChangeListenerC0952Xx A0D;
    public final AbstractC1365fo A0E;

    public static String A0Z(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 39);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0b() {
        A0F = new byte[]{-22, -19, -4, -23, -24};
    }

    public abstract void A0g();

    public abstract void A0h();

    public abstract void A0k(C0783Re c0783Re);

    public abstract boolean A0l();

    public abstract boolean A0m();

    static {
        A0b();
        A0H = new RelativeLayout.LayoutParams(-1, -1);
    }

    public AbstractC0508Gj(C1421gi c1421gi, ZU zu, VA va, AbstractC1586jd abstractC1586jd, C0827Sx c0827Sx, InterfaceC0962Yh interfaceC0962Yh) {
        super(c1421gi);
        this.A02 = false;
        this.A0E = new H8(this);
        this.A08 = new Y2();
        this.A00 = false;
        this.A05 = c1421gi;
        this.A0B = zu;
        this.A06 = va;
        this.A03 = abstractC1586jd;
        this.A04 = c0827Sx;
        this.A0A = interfaceC0962Yh;
        this.A07 = new VI(this.A03.A2E(), this.A06);
        this.A0C = new C1366fp(this, 1, new WeakReference(this.A0E), this.A05);
        this.A0C.A0W(this.A03.A0m());
        this.A0C.A0X(this.A03.A0n());
        this.A09 = A0Y();
        this.A0D = new ViewOnSystemUiVisibilityChangeListenerC0952Xx(this);
        this.A0D.A05(EnumC0951Xw.A02);
        if (!A0m() && Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
    }

    private AbstractC0956Yb A0Y() {
        AbstractC0956Yb abstractC0956YbA0c = A0c();
        abstractC0956YbA0c.setFullscreen(true);
        int iA04 = this.A03.A29().A0H().A04();
        abstractC0956YbA0c.setPageDetails(this.A03.A2C(), this.A03.A2E(), iA04, this.A03.A2D());
        abstractC0956YbA0c.A0D(this.A03.A28().A01(), ViewOnClickListenerC0619Kr.A05(this.A03));
        if (this.A03.A29().A0H().A02() == 0) {
            this.A02 = true;
            abstractC0956YbA0c.setToolbarActionMode(8);
        } else if (iA04 < 0 && this.A03.A29().A0S()) {
            abstractC0956YbA0c.setToolbarActionMode(4);
        }
        if (this.A03.A29().A0H().A02() >= 0) {
            abstractC0956YbA0c.setProgressSpinnerInvisible(true);
        }
        abstractC0956YbA0c.setToolbarListener(new C0510Gl(this));
        return abstractC0956YbA0c;
    }

    private void A0a() {
        if (this.A03.A29().A0W()) {
            C1244dq c1244dqA0F = new Cdo(this.A05, this.A03.A29().A0I(), this.A03.A2C()).A0A(this.A03.A28().A01()).A0F();
            VK.A04(c1244dqA0F, this.A07, VH.A0U);
            addView(c1244dqA0F, A0H);
            c1244dqA0F.A04(new C0523Gy(this));
            return;
        }
        A0h();
    }

    public AbstractC0956Yb A0c() {
        if (A0m()) {
            if (this.A03.A1W()) {
                return new C0735Pe(this.A05, getAppOpenAdVariant(), this.A03, 8, new C0514Gp(this));
            }
            return new PU(this.A05, this.A03, 1);
        }
        return new FullScreenAdToolbar(this.A05, this.A0A, this.A07, 1, this.A03.A22(), this.A03.A1s());
    }

    public void A0d() {
        Rect requestedMargins;
        if (!this.A03.A1W() || (requestedMargins = this.A09.getRequestedMargins()) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.A09.getLayoutParams();
        layoutParams.setMargins(requestedMargins.left, requestedMargins.top, requestedMargins.right, requestedMargins.bottom);
        this.A09.setLayoutParams(layoutParams);
    }

    public final void A0e() {
        if (!this.A00) {
            this.A0C.A0U();
            this.A00 = true;
        }
    }

    public final void A0f() {
        if (this.A09.getToolbarActionMode() == 8) {
            this.A09.setToolbarActionMode(2);
        }
        if (this.A03.A29().A0H().A07() != null) {
            this.A03.A29().A0H().A07().A0S(0);
        }
        this.A03.A2K(false);
        this.A03.A29().A0M(-1);
    }

    public final void A0i(int i, AbstractRunnableC0908Wc abstractRunnableC0908Wc, DZ dz) {
        new XO(i, new H0(this, i, dz, abstractRunnableC0908Wc)).A07();
    }

    public final void A0j(ViewGroup viewGroup) {
        if (this.A03.A1W() && getAppOpenAdVariant() == EnumC0961Yg.A08) {
            C1116bl c1116bl = new C1116bl(this.A05);
            c1116bl.setRadius(XV.A0v);
            c1116bl.addView(viewGroup, new ViewGroup.LayoutParams(-1, -1));
            this.A01 = c1116bl;
            return;
        }
        this.A01 = viewGroup;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0963Yi
    public final void AAu(Intent intent, Bundle bundle, C0783Re c0783Re) {
        this.A0A.A45(this, A0H);
        A0k(c0783Re);
        A0a();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0963Yi
    public final void AIv(Bundle bundle) {
    }

    private EnumC0961Yg getAppOpenAdVariant() {
        if (this.A03.A0v().equals(A0Z(0, 5, 93))) {
            return EnumC0961Yg.A08;
        }
        return EnumC0961Yg.A09;
    }

    public Integer getBackgroundColorForToolbar() {
        if (this.A03.A1W()) {
            return getAppOpenAdVariant().A03;
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0963Yi
    public String getCurrentClientToken() {
        return this.A03.A2E();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0963Yi
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!A0m() && Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
        A0d();
        if (A0G[6].charAt(4) == 'Z') {
            throw new RuntimeException();
        }
        A0G[3] = "kF6RESICu85JPno09mseATff07y9WxI4";
    }

    public void onDestroy() {
        this.A0D.A03();
        if (!TextUtils.isEmpty(this.A03.A2E())) {
            this.A06.AB7(this.A03.A2E(), new C1078b9().A03(this.A0C).A02(this.A08).A05());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A08.A06(this.A05, motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(InterfaceC0962Yh interfaceC0962Yh) {
    }

    public void setUpFullscreenMode(boolean z) {
        EnumC0951Xw enumC0951Xw;
        if (z) {
            enumC0951Xw = EnumC0951Xw.A03;
        } else {
            enumC0951Xw = EnumC0951Xw.A02;
        }
        this.A0D.A05(enumC0951Xw);
    }
}
