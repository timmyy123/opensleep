package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7B, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C7B {
    public static String[] A09 = {"l8GJg6rn6Adlh4Gn59Q00x9wdhAA1N0G", "0FGDNpmqvJaXrYVndUjcoHzlqa3GYTQ7", "pt3TgghkXaQKZolppIJBnXlroi4GAQrs", "P8nJgAgzZ7eq", "wLbaX9M9C92K8ml85Wq6oszj2MSO2FBr", "4xgaQCpVjfBlN1x0xTmHAa8kZRn587ql", "M0TEQVmq9EtHtFdZcG0N3gydxvjz8wFn", "euj9JK69WhhaD3Qn5aJyq4d8RK326seE"};
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final C1829no A04;
    public final boolean A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Must be removed when ExoPlayerImpl V1 is deprecated")
    public C7B(C1829no c1829no, long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.A04 = c1829no;
        this.A03 = j;
        this.A01 = j2;
        this.A02 = j3;
        this.A00 = j4;
        this.A07 = z;
        this.A05 = z2;
        this.A06 = false;
        this.A08 = false;
    }

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Disable Assertions for now as the ones related to isFollowedByTransitionToSameStream & isLastInTimelineWindow are not applicable toExoPlayerImpl v1")
    public C7B(C1829no c1829no, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.A04 = c1829no;
        this.A03 = j;
        this.A02 = j2;
        this.A01 = j3;
        this.A00 = j4;
        this.A06 = z;
        this.A07 = z2;
        this.A08 = z3;
        this.A05 = z4;
    }

    public final C7B A00(long j) {
        if (j == this.A03) {
            return this;
        }
        return new C7B(this.A04, j, this.A02, this.A01, this.A00, this.A06, this.A07, this.A08, this.A05);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (A09[3].length() != 12) {
            throw new RuntimeException();
        }
        String[] strArr = A09;
        strArr[4] = "HM7USyyxbNbQcjlq9QdgoHVXlCbIu8Ew";
        strArr[2] = "UF1UQefl0hgIUKl2LSKBHKtCQ7NwZYWH";
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C7B c7b = (C7B) obj;
        long j = this.A03;
        long j2 = c7b.A03;
        if (A09[7].charAt(5) == 'L') {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[4] = "KvLnIvA0WshqvFl6QUZ6X2AQHuQtnix5";
        strArr2[2] = "A4NouHfcMNJ0mAlCwa4zmzIsOHoRuHy2";
        if (j == j2) {
            long j3 = this.A02;
            long j4 = c7b.A02;
            String[] strArr3 = A09;
            if (strArr3[4].charAt(14) == strArr3[2].charAt(14)) {
                A09[3] = "0MuUGctUC2lW";
                if (j3 == j4) {
                }
            } else if (j3 == j4) {
                long j5 = this.A01;
                long j6 = c7b.A01;
                if (A09[7].charAt(5) != 'L') {
                    String[] strArr4 = A09;
                    strArr4[5] = "UcOdoWHat5DlQCa8pGaoiSJ6mIGk23xs";
                    strArr4[0] = "TWHZ8fLSue4lPY4c06l29BkldFDhe1WB";
                    if (j5 == j6) {
                        if (this.A00 == c7b.A00 && this.A06 == c7b.A06 && this.A07 == c7b.A07 && this.A08 == c7b.A08 && this.A05 == c7b.A05 && C5C.A1E(this.A04, c7b.A04)) {
                            return true;
                        }
                    }
                } else if (j5 == j6) {
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((17 * 31) + this.A04.hashCode()) * 31) + ((int) this.A03)) * 31) + ((int) this.A02)) * 31) + ((int) this.A01)) * 31) + ((int) this.A00)) * 31) + (this.A06 ? 1 : 0)) * 31) + (this.A07 ? 1 : 0)) * 31) + (this.A08 ? 1 : 0)) * 31) + (this.A05 ? 1 : 0);
    }
}
