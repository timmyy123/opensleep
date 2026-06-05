package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0612Kk implements Comparable<C0612Kk> {
    public final int A00;
    public final C0603Kb A01;

    public C0612Kk(int i, C0603Kb c0603Kb) {
        this.A00 = i;
        this.A01 = c0603Kb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C0612Kk c0612Kk) {
        return Integer.compare(this.A00, c0612Kk.A00);
    }
}
