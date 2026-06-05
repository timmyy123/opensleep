package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class R9 {
    public SparseArray<R8> A00 = new SparseArray<>();
    public int A01 = 0;

    private final long A00(long j, long j2) {
        if (j == 0) {
            return j2;
        }
        return ((j / 4) * 3) + (j2 / 4);
    }

    private R8 A01(int i) {
        R8 r8 = this.A00.get(i);
        if (r8 == null) {
            R8 r82 = new R8();
            this.A00.put(i, r82);
            return r82;
        }
        return r8;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void A02() {
        for (int i = 0; i < i; i++) {
            this.A00.valueAt(i).A03.clear();
        }
    }

    public final RK A03(int i) {
        R8 r8 = this.A00.get(i);
        if (r8 != null && !r8.A03.isEmpty()) {
            return r8.A03.remove(r1.size() - 1);
        }
        return null;
    }

    public final void A04() {
        this.A01--;
    }

    public final void A05(int i, long j) {
        R8 r8A01 = A01(i);
        r8A01.A01 = A00(r8A01.A01, j);
    }

    public final void A06(int i, long j) {
        R8 r8A01 = A01(i);
        r8A01.A02 = A00(r8A01.A02, j);
    }

    public final void A07(AbstractC0769Qq abstractC0769Qq) {
        this.A01++;
    }

    public final void A08(AbstractC0769Qq abstractC0769Qq, AbstractC0769Qq abstractC0769Qq2, boolean z) {
        if (abstractC0769Qq != null) {
            A04();
        }
        if (!z && this.A01 == 0) {
            A02();
        }
        if (abstractC0769Qq2 != null) {
            A07(abstractC0769Qq2);
        }
    }

    public final void A09(RK rk) {
        int iA0N = rk.A0N();
        ArrayList<RK> arrayList = A01(iA0N).A03;
        int i = this.A00.get(iA0N).A00;
        int viewType = arrayList.size();
        if (i <= viewType) {
            return;
        }
        rk.A0W();
        arrayList.add(rk);
    }

    public final boolean A0A(int i, long j, long j2) {
        long j3 = A01(i).A01;
        return j3 == 0 || j + j3 < j2;
    }

    public final boolean A0B(int i, long j, long j2) {
        long j3 = A01(i).A02;
        return j3 == 0 || j + j3 < j2;
    }
}
