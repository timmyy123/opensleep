package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.SystemClock;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class GP {
    public final Handler A00;
    public final GQ A01;

    public GP(Handler handler, GQ gq) {
        this.A00 = gq != null ? (Handler) AbstractC02053y.A01(handler) : null;
        this.A01 = gq;
    }

    public final void A00(final int i, final long j) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GL
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A02(i, j);
                }
            });
        }
    }

    public final void A01(final int i, final long j) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GC
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A03(i, j);
                }
            });
        }
    }

    public final /* synthetic */ void A02(int i, long j) {
        ((GQ) C5C.A0f(this.A01)).ADU(i, j);
    }

    public final /* synthetic */ void A03(int i, long j) {
        ((GQ) C5C.A0f(this.A01)).ADl(i, j);
    }

    @MetaExoPlayerCustomization("New event handler")
    public final void A04(int i, C1981qI c1981qI) {
        if (this.A01 != null) {
            this.A00.post(new GO(this, i, c1981qI));
        }
    }

    public final void A05(final C1981qI c1981qI, final C6L c6l) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GI
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A06(c1981qI, c6l);
                }
            });
        }
    }

    public final /* synthetic */ void A06(C1981qI c1981qI, C6L c6l) {
        ((GQ) C5C.A0f(this.A01)).AGU(c1981qI);
        ((GQ) C5C.A0f(this.A01)).AGV(c1981qI, c6l);
    }

    public final void A07(final C1934pW c1934pW) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GK
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A08(c1934pW);
                }
            });
        }
    }

    public final /* synthetic */ void A08(C1934pW c1934pW) {
        ((GQ) C5C.A0f(this.A01)).AGb(c1934pW);
    }

    public final void A09(final C6I c6i) {
        c6i.A02();
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GM
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0B(c6i);
                }
            });
        }
    }

    public final void A0A(final C6I c6i) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GG
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0C(c6i);
                }
            });
        }
    }

    public final /* synthetic */ void A0B(C6I c6i) {
        c6i.A02();
        ((GQ) C5C.A0f(this.A01)).AGO(c6i);
    }

    public final /* synthetic */ void A0C(C6I c6i) {
        ((GQ) C5C.A0f(this.A01)).AGP(c6i);
    }

    public final void A0D(final Object obj) {
        if (this.A00 != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GH
                @Override // java.lang.Runnable
                public final void run() {
                    this.A01.A0E(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final /* synthetic */ void A0E(Object obj, long j) {
        ((GQ) C5C.A0f(this.A01)).AFf(obj, j);
    }

    @MetaExoPlayerCustomization("New event handler")
    public final void A0F(final String str) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GJ
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
        }
    }

    public final void A0G(final String str, final long j, final long j2) {
        if (this.A00 != null) {
            this.A00.post(new Runnable() { // from class: com.facebook.ads.redexgen.X.GF
                @Override // java.lang.Runnable
                public final void run() {
                    this.A02.A0H(str, j, j2);
                }
            });
        }
    }

    public final /* synthetic */ void A0H(String str, long j, long j2) {
        ((GQ) C5C.A0f(this.A01)).AGN(str, j, j2);
    }
}
