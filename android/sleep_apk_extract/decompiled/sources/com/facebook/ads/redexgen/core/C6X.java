package com.facebook.ads.redexgen.core;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6X, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C6X extends C0497Fy {
    public static String[] A00 = {"f1NrkMLFHAOxAk1WYXb4ZQBI9BQGMxNf", "ieQbYkP9qXWhodiL", "FasCpRA2RHhykdlBGUblwYUAQMGKU0mS", "sjzKgK2sh59qhJK5Sm5NCXrbKyy", "73hXtYSYooo4yypUFlMlXcqu25ITYI9G", "jFG3gQjXUuH0GALbmhZbm14pHMTfeDNL", "AB4YZhA3BNaHUCHwFjy4bae76Yz8EFa9", "dMMrkYyDXzmdfTW8HhUzXkOm8W"};

    public C6X(C1J c1j, int i, List<C1259e5> list, C1366fp c1366fp, Bundle bundle) {
        super(c1j, i, list, c1366fp, bundle);
        c1j.A1h(this);
        this.A03 = new M2(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00() {
        int iA25 = this.A0C.A25();
        if (this.A05 == null || iA25 == -1) {
            return;
        }
        int curPos = this.A05.size();
        if (iA25 < curPos - 1) {
            int i = iA25 + 1;
            if (A00[2].charAt(8) != 'R') {
                throw new RuntimeException();
            }
            A00[2] = "QoZYEwWSRtnMYn7R6MgH1oBp1kGEXSrp";
            A0U(i);
        }
    }

    private void A01(int i) {
        int visibleItem = this.A0C.A26();
        int lastVisibleItem = this.A0C.A27();
        int firstVisibleItem = this.A0C.A25();
        if (firstVisibleItem != visibleItem) {
            A0S(visibleItem);
        }
        if (firstVisibleItem != lastVisibleItem) {
            A0S(lastVisibleItem);
        }
        A0T(firstVisibleItem);
        A0V(visibleItem, lastVisibleItem, i);
    }

    @Override // com.facebook.ads.redexgen.core.C0497Fy, com.facebook.ads.redexgen.core.R7
    public final void A0L(C7M c7m, int i) {
    }

    @Override // com.facebook.ads.redexgen.core.C0497Fy, com.facebook.ads.redexgen.core.R7
    public final void A0M(C7M c7m, int i, int i2) {
        if (this.A0C.A25() != -1) {
            AbstractC0582Jg curCard = (AbstractC0582Jg) this.A0C.A1o(this.A0C.A25());
            if (curCard != null && curCard.A1V() && !curCard.A1U()) {
                curCard.A1S();
            }
            A01(i);
        }
    }

    @Override // com.facebook.ads.redexgen.core.C0497Fy
    public final void A0X(View view, boolean z) {
        view.setAlpha(z ? 1.0f : 0.8f);
    }

    @Override // com.facebook.ads.redexgen.core.C0497Fy
    public final void A0Z(AbstractC0582Jg abstractC0582Jg, boolean z) {
        A0X(abstractC0582Jg, z);
        if (!z && abstractC0582Jg.A1U()) {
            abstractC0582Jg.A1R();
        }
    }

    @Override // com.facebook.ads.redexgen.core.C0497Fy
    public final boolean A0a(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.75f;
    }

    public final C1366fp A0b() {
        return this.A04;
    }

    public final void A0c(C1366fp c1366fp) {
        this.A04 = c1366fp;
    }

    public final void A0d(List<C1259e5> list) {
        this.A05 = list;
    }
}
