package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1768mo implements HY {
    public final long A00;
    public final boolean A01;
    public final long[] A02;
    public final long[] A03;

    public C1768mo(long[] jArr, long[] jArr2, long j) {
        AbstractC02053y.A07(jArr.length == jArr2.length);
        int length = jArr2.length;
        this.A01 = length > 0;
        if (this.A01 && jArr2[0] > 0) {
            int length2 = length + 1;
            this.A02 = new long[length2];
            int length3 = length + 1;
            this.A03 = new long[length3];
            System.arraycopy(jArr, 0, this.A02, 1, length);
            System.arraycopy(jArr2, 0, this.A03, 1, length);
        } else {
            this.A02 = jArr;
            this.A03 = jArr2;
        }
        this.A00 = j;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j) {
        if (!this.A01) {
            return new HX(HZ.A04);
        }
        int iA0L = C5C.A0L(this.A03, j, true, true);
        HZ hz = new HZ(this.A03[iA0L], this.A02[iA0L]);
        if (hz.A01 != j) {
            int targetIndex = this.A03.length;
            if (iA0L != targetIndex - 1) {
                int targetIndex2 = iA0L + 1;
                long j2 = this.A03[targetIndex2];
                int targetIndex3 = iA0L + 1;
                HZ rightSeekPoint = new HZ(j2, this.A02[targetIndex3]);
                return new HX(hz, rightSeekPoint);
            }
        }
        return new HX(hz);
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return this.A01;
    }
}
