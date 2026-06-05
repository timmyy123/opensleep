package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C01662j extends Q9<C1366fp> implements T4 {
    public C1421gi A00;
    public boolean A01;

    public C01662j(C1366fp c1366fp, C1421gi c1421gi) {
        super(c1366fp);
        this.A00 = c1421gi;
        this.A01 = false;
    }

    private void A00(int i) {
        if (!this.A01) {
            this.A00.A0F().A3v(i);
        }
        this.A01 = true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC0908Wc
    public final void A07() {
        C1366fp c1366fpA08 = A08();
        int iIntValue = 0;
        if (c1366fpA08 == null) {
            A00(0);
            return;
        }
        View view = c1366fpA08.A0C;
        AbstractC1365fo abstractC1365fo = (AbstractC1365fo) c1366fpA08.A0E.get();
        int i = 1;
        boolean z = view == null;
        if (!z && abstractC1365fo != null) {
            C1367fq c1367fqA0E = C1366fp.A0E(view, c1366fpA08.A0A, this.A00);
            if (c1367fqA0E.A04()) {
                C1366fp.A05(c1366fpA08);
            } else {
                c1366fpA08.A00 = 0;
            }
            boolean z2 = c1366fpA08.A00 > c1366fpA08.A09;
            boolean wasViewable = c1366fpA08.A05 != null && c1366fpA08.A05.A04();
            if (z2 || !c1367fqA0E.A04()) {
                c1366fpA08.A05 = c1367fqA0E;
            }
            String strValueOf = String.valueOf(c1367fqA0E.A01());
            synchronized (c1366fpA08) {
                if (c1366fpA08.A06.containsKey(strValueOf)) {
                    iIntValue = ((Integer) c1366fpA08.A06.get(strValueOf)).intValue();
                }
                c1366fpA08.A06.put(strValueOf, Integer.valueOf(iIntValue + 1));
            }
            if (z2 && !wasViewable) {
                this.A01 = true;
                c1366fpA08.A03 = System.currentTimeMillis();
                if (c1366fpA08.A07) {
                    this.A00.A0F().A3w();
                }
                abstractC1365fo.A03();
                if (BuildConfigApi.isDebug() && AdInternalSettings.isVisibleAnimation()) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(500L);
                    view.startAnimation(alphaAnimation);
                }
                if (!c1366fpA08.A0F) {
                    return;
                }
            } else if (!z2 && wasViewable) {
                this.A01 = true;
                if (c1366fpA08.A07) {
                    this.A00.A0F().A3S(c1367fqA0E.A02());
                }
                abstractC1365fo.A00();
            } else {
                abstractC1365fo.A02();
                if (!this.A01 && c1366fpA08.A07) {
                    this.A00.A0F().A3u(c1367fqA0E.A02());
                }
                this.A01 = true;
            }
            if (!c1366fpA08.A08 && c1366fpA08.A04 != null) {
                c1366fpA08.A0B.postDelayed(c1366fpA08.A04, c1366fpA08.A02);
                return;
            }
            return;
        }
        if (c1366fpA08.A07) {
            if (!z) {
                i = 2;
            }
            A00(i);
        }
    }

    @Override // com.facebook.ads.redexgen.core.T4
    public final C1421gi A6m() {
        return this.A00;
    }
}
