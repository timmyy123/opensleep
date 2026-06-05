package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1769mp implements HY {
    public static String[] A02 = {"1Tt6ltc55g", "ops4n6D0RsDIbcNK2iFIW7Ay7S5Nano", "QFUbJLsUaFmSVLdjzr36RpAXorrqi07i", "7FxugF0ZmqBQk4dAnarwpNTfiaTe1g6g", "N3T7HRrxqFzk5rl0dpC6S3h47ocLp3rK", "Rq3uRmlvLOcLbWX3oXceNMTvaDTByq6j", "8TmLuftHICqYkzwVWbIwZIwFPzZSJxQj", "4hmJxBFNQAJLWam3xj85pvhcrB85xjeQ"};
    public final long A00;
    public final HJ A01;

    public C1769mp(HJ hj, long j) {
        this.A01 = hj;
        this.A00 = j;
    }

    private HZ A00(long j, long j2) {
        return new HZ((1000000 * j) / ((long) this.A01.A07), this.A00 + j2);
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A01.A06();
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j) {
        long j2;
        AbstractC02053y.A02(this.A01.A0A);
        long[] jArr = this.A01.A0A.A01;
        long[] jArr2 = this.A01.A0A.A00;
        int iA0L = C5C.A0L(jArr, this.A01.A07(j), true, false);
        long j3 = 0;
        if (iA0L == -1) {
            j2 = 0;
        } else {
            j2 = jArr[iA0L];
        }
        if (iA0L != -1) {
            j3 = jArr2[iA0L];
        }
        HZ hzA00 = A00(j2, j3);
        if (hzA00.A01 != j) {
            int length = jArr.length - 1;
            String[] strArr = A02;
            if (strArr[3].charAt(19) != strArr[6].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "o5tsTNyqew751hc5myqwVOdw8F1gICkG";
            strArr2[6] = "VidtQTuToVY7NImzxnJwSrK8bx75lEQY";
            if (iA0L != length) {
                HZ secondSeekPoint = A00(jArr[iA0L + 1], jArr2[iA0L + 1]);
                return new HX(hzA00, secondSeekPoint);
            }
        }
        return new HX(hzA00);
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return true;
    }
}
