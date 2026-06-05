package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ec, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0450Ec implements Comparable<C0450Ec> {
    public final boolean A00;
    public final boolean A01;

    public C0450Ec(C1981qI c1981qI, int i) {
        this.A00 = (c1981qI.A0H & 1) != 0;
        this.A01 = C03389h.A0S(i, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0450Ec c0450Ec) {
        return AbstractC1833ns.A01().A09(this.A01, c0450Ec.A01).A09(this.A00, c0450Ec.A00).A05();
    }
}
