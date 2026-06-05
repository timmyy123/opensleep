package com.facebook.ads.redexgen.core;

import android.os.Handler;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class XO {
    public float A00;
    public float A01;
    public long A02;
    public boolean A03;
    public boolean A04;
    public final Handler A05;
    public final XN A06;

    public XO(int i, float f, long j, Handler handler, XN xn) {
        this(i, xn, handler);
        this.A02 = j;
        this.A01 = f;
    }

    public XO(int i, XN xn) {
        this(i, xn, new Handler());
    }

    public XO(int i, XN xn, Handler handler) {
        this.A04 = false;
        this.A00 = i;
        this.A06 = xn;
        this.A05 = handler;
        this.A02 = 250L;
        this.A01 = 0.25f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        this.A00 -= this.A01;
        this.A06.AFV(this.A00);
        if (this.A00 <= 0.0f && !this.A03) {
            this.A03 = true;
            this.A06.ADS();
            this.A04 = false;
        }
    }

    public final boolean A04() {
        return this.A00 <= 0.0f;
    }

    public final boolean A05() {
        return this.A04;
    }

    public final boolean A06() {
        if (!A05()) {
            return false;
        }
        this.A04 = false;
        return true;
    }

    public final boolean A07() {
        if (A04() && !this.A03) {
            this.A03 = true;
            this.A06.ADS();
        }
        if (A04() || A05()) {
            return false;
        }
        this.A04 = true;
        this.A06.AFV(this.A00);
        this.A05.postDelayed(new C0758Qe(this), this.A02);
        return true;
    }
}
