package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Looper;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9n, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C03429n extends AbstractC1836nv implements DI {
    public long A00;
    public InterfaceC02525t A01;
    public InterfaceC1662ku<InterfaceExecutorC0475Fb> A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final int A06;
    public final AnonymousClass32 A07;
    public final C1970q7 A08;
    public final C5Y A09;
    public final A6 A0A;
    public final DC A0B;
    public final FF A0C;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ku != com.google.common.base.Supplier<com.facebook.ads.androidx.media3.exoplayer.util.ReleasableExecutor> */
    @MetaExoPlayerCustomization("Allow for passing a new drmSessionManager")
    public C03429n(C1970q7 c1970q7, C5Y c5y, DC dc, A6 a6, FF ff, int i, InterfaceC1662ku<InterfaceExecutorC0475Fb> interfaceC1662ku) {
        this.A07 = (AnonymousClass32) AbstractC02053y.A01(c1970q7.A03);
        this.A08 = c1970q7;
        this.A09 = c5y;
        this.A0B = dc;
        this.A0A = a6 == null ? A6.A00 : a6;
        this.A0C = ff;
        this.A06 = i;
        this.A04 = true;
        this.A00 = -9223372036854775807L;
        this.A02 = interfaceC1662ku;
    }

    private void A00() {
        final Timeline c03419m = new C03419m(this.A00, this.A05, false, this.A03, null, this.A08);
        if (this.A04) {
            Timeline timeline = new C9t(c03419m) { // from class: com.facebook.ads.redexgen.X.1e
                @Override // com.facebook.ads.redexgen.core.C9t, com.facebook.ads.androidx.media3.common.Timeline
                public final C1948pl A0I(int i, C1948pl c1948pl, boolean z) {
                    super.A0I(i, c1948pl, z);
                    c1948pl.A05 = true;
                    return c1948pl;
                }

                @Override // com.facebook.ads.redexgen.core.C9t, com.facebook.ads.androidx.media3.common.Timeline
                public final C1946pj A0L(int i, C1946pj c1946pj, long j) {
                    super.A0L(i, c1946pj, j);
                    c1946pj.A0F = true;
                    return c1946pj;
                }
            };
            c03419m = timeline;
        }
        A05(c03419m);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1836nv
    public final void A09() {
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1836nv
    public final void A0A(InterfaceC02525t interfaceC02525t) {
        this.A01 = interfaceC02525t;
        this.A0A.AH4();
        this.A0A.AJe((Looper) AbstractC02053y.A01(Looper.myLooper()), A00());
        A00();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0419Cx
    @MetaExoPlayerCustomization("PlayerId needs to be set")
    public final InterfaceC1830np A5W(C1829no c1829no, F0 f0, long j) {
        InterfaceExecutorC0475Fb interfaceExecutorC0475Fb;
        InterfaceC1917pF interfaceC1917pFA5I = this.A09.A5I();
        if (this.A01 != null) {
            interfaceC1917pFA5I.A43(this.A01);
        }
        Uri uri = this.A07.A00;
        DD ddA5X = this.A0B.A5X(C8O.A03);
        A6 a6 = this.A0A;
        A1 a1A01 = A01(c1829no);
        FF ff = this.A0C;
        D8 d8A02 = A02(c1829no);
        String str = this.A07.A04;
        int i = this.A06;
        if (this.A02 != null) {
            interfaceExecutorC0475Fb = this.A02.get();
        } else {
            interfaceExecutorC0475Fb = null;
        }
        return new C03449p(uri, interfaceC1917pFA5I, ddA5X, a6, a1A01, ff, d8A02, this, f0, str, i, interfaceExecutorC0475Fb);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0419Cx
    public final void ACT() {
    }

    @Override // com.facebook.ads.redexgen.core.DI
    public final void AG0(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.A00;
        }
        if (!this.A04 && this.A00 == j && this.A05 == z && this.A03 == z2) {
            return;
        }
        this.A00 = j;
        this.A05 = z;
        this.A03 = z2;
        this.A04 = false;
        A00();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0419Cx
    public final void AHk(InterfaceC1830np interfaceC1830np) {
        ((C03449p) interfaceC1830np).A0a();
    }
}
