package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ld, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1707ld implements InterfaceC0585Jj {
    public final long[] A00;
    public final C1931pT[] A01;

    public C1707ld(C1931pT[] c1931pTArr, long[] jArr) {
        this.A01 = c1931pTArr;
        this.A00 = jArr;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final List<C1931pT> A7X(long j) {
        int iA0L = C5C.A0L(this.A00, j, true, false);
        if (iA0L == -1 || this.A01[iA0L] == C1931pT.A0J) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.A01[iA0L]);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final long A83(int i) {
        boolean z = true;
        AbstractC02053y.A07(i >= 0);
        if (i >= this.A00.length) {
            z = false;
        }
        AbstractC02053y.A07(z);
        return this.A00[i];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final int A84() {
        return this.A00.length;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final int A8a(long j) {
        int iA0K = C5C.A0K(this.A00, j, false, false);
        int index = this.A00.length;
        if (iA0K < index) {
            return iA0K;
        }
        return -1;
    }
}
