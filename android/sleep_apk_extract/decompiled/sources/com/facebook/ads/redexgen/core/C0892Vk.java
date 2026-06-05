package com.facebook.ads.redexgen.core;

import java.util.LinkedList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0892Vk {
    public final InterfaceC0890Vi A0B;
    public final boolean A0F;
    public final String A0C = C0892Vk.class.getSimpleName();
    public final int A07 = 101;
    public final int A0A = 102;
    public final int A08 = 103;
    public final int A03 = 104;
    public final int A09 = 105;
    public final int A02 = 106;
    public final int A04 = 107;
    public final int A05 = 108;
    public final int A06 = 109;
    public final int A01 = 110;
    public final boolean A0E = false;
    public long A00 = -1;
    public final List<C0891Vj> A0D = new LinkedList();

    public C0892Vk(T8 t8, InterfaceC0890Vi interfaceC0890Vi) {
        int nativeViewabilityHistorySamplingRate = AbstractC0873Ur.A0D(t8);
        if (nativeViewabilityHistorySamplingRate < 1) {
            this.A0F = false;
        } else {
            this.A0F = t8.A09().A00() < 1.0d / ((double) nativeViewabilityHistorySamplingRate);
        }
        this.A0B = interfaceC0890Vi;
    }

    private int A00() {
        return this.A0B.A7d();
    }

    private int A01() {
        if (this.A00 > 0) {
            return (int) (System.currentTimeMillis() - this.A00);
        }
        return -1;
    }

    private void A03(C0891Vj c0891Vj) {
        synchronized (this.A0D) {
            this.A0D.add(c0891Vj);
        }
    }

    public final void A04() {
        if (!this.A0F) {
            return;
        }
        A03(new C0891Vj(A01(), 110, A00(), null));
    }

    public final void A05() {
        if (!this.A0F) {
            return;
        }
        A03(new C0891Vj(A01(), 106, A00(), null));
    }

    public final void A06() {
        if (!this.A0F) {
            return;
        }
        A03(new C0891Vj(A01(), 104, A00(), null));
    }

    public final void A07() {
        if (!this.A0F) {
            return;
        }
        A03(new C0891Vj(A01(), 109, -1, null));
    }

    public final void A08() {
        if (!this.A0F) {
            return;
        }
        A03(new C0891Vj(A01(), 108, A00(), null));
    }

    public final void A09() {
        if (!this.A0F) {
            return;
        }
        this.A00 = System.currentTimeMillis();
        A03(new C0891Vj(0, 101, -1, null));
    }

    public final void A0A() {
        if (!this.A0F) {
            return;
        }
        A03(new C0891Vj(A01(), 105, A00(), null));
    }

    public final void A0B() {
        if (!this.A0F) {
            return;
        }
        A03(new C0891Vj(A01(), 102, A00(), null));
    }

    public final void A0C(T8 t8, String str) {
        if (!this.A0F) {
            return;
        }
        A03(new C0891Vj(A01(), 103, A00(), null));
        YG.A06.execute(new RunnableC0889Vh(this, str, t8));
    }
}
