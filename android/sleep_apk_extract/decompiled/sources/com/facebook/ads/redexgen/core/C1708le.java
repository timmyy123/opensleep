package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.le, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1708le implements InterfaceC0585Jj {
    public static String[] A02 = {"HEj97KvUnOVi99GyCemBfj1IlRVMCYKa", "bKpF78P6yplIZiN4oLHJNmT5FnU1SEKu", "7Sc49g8U0pFUCwWrHEqt4gm3cHokAbZL", "cD1aak7SOkYBFQ5WYMuE6fCzYSMr5rzP", "nFSB3U7GisPQJq8UC8oIR6SGnDGaOjWF", "F8IIvOctPHFdHQL4x7ywQ6I9IFbldSVz", "cjwMlxT4uAsHz8zserTiMsrkd8r9G7hR", "hk7t5bmYHUtAqM49rcYSiap2RmT4cwS9"};
    public final List<Long> A00;
    public final List<List<C1931pT>> A01;

    public C1708le(List<List<C1931pT>> list, List<Long> cueTimesUs) {
        this.A01 = list;
        this.A00 = cueTimesUs;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final List<C1931pT> A7X(long j) {
        int iA0H = C5C.A0H(this.A00, Long.valueOf(j), true, false);
        if (iA0H == -1) {
            return Collections.emptyList();
        }
        List<C1931pT> list = this.A01.get(iA0H);
        if (A02[7].charAt(14) == 'Q') {
            throw new RuntimeException();
        }
        A02[7] = "T22AU4Idz2xqABMljk02WspyVqHPQCmG";
        return list;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final long A83(int i) {
        boolean z = true;
        AbstractC02053y.A07(i >= 0);
        if (i >= this.A00.size()) {
            z = false;
        }
        AbstractC02053y.A07(z);
        return this.A00.get(i).longValue();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final int A84() {
        return this.A00.size();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0585Jj
    public final int A8a(long j) {
        int iA0G = C5C.A0G(this.A00, Long.valueOf(j), false, false);
        int index = this.A00.size();
        if (iA0G < index) {
            return iA0G;
        }
        return -1;
    }
}
