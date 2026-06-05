package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C03057u {
    public final long A00;
    public final long A01;
    public static final C03057u A04 = new C03057u(0, 0);
    public static final C03057u A02 = new C03057u(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final C03057u A06 = new C03057u(Long.MAX_VALUE, 0);
    public static final C03057u A05 = new C03057u(0, Long.MAX_VALUE);
    public static final C03057u A03 = A04;

    public C03057u(long j, long j2) {
        AbstractC02053y.A07(j >= 0);
        AbstractC02053y.A07(j2 >= 0);
        this.A01 = j;
        this.A00 = j2;
    }

    public final long A00(long minPositionUs, long j, long j2) {
        if (this.A01 == 0 && this.A00 == 0) {
            return minPositionUs;
        }
        long jA0V = C5C.A0V(minPositionUs, this.A01, Long.MIN_VALUE);
        long jA0S = C5C.A0S(minPositionUs, this.A00, Long.MAX_VALUE);
        boolean z = true;
        boolean z2 = jA0V <= j && j <= jA0S;
        if (jA0V > j2 || j2 > jA0S) {
            z = false;
        }
        if (z2 && z) {
            long jAbs = Math.abs(j - minPositionUs);
            long maxPositionUs = Math.abs(j2 - minPositionUs);
            if (jAbs <= maxPositionUs) {
                return j;
            }
            return j2;
        }
        if (z2) {
            return j;
        }
        if (z) {
            return j2;
        }
        return jA0V;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C03057u c03057u = (C03057u) obj;
        return this.A01 == c03057u.A01 && this.A00 == c03057u.A00;
    }

    public final int hashCode() {
        return (((int) this.A01) * 31) + ((int) this.A00);
    }
}
