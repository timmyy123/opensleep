package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class HN {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public String A06;

    public final boolean A00(int i) {
        int i2;
        int i3;
        int padding;
        int bitrateIndex;
        int version;
        int version2;
        if (!HO.A06(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (padding = (i >>> 12) & 15) == 0 || padding == 15 || (bitrateIndex = (i >>> 10) & 3) == 3) {
            return false;
        }
        this.A05 = i2;
        int version3 = 3 - i3;
        this.A06 = HO.A08[version3];
        int version4 = HO.A07[bitrateIndex];
        this.A03 = version4;
        if (i2 == 2) {
            int version5 = this.A03;
            this.A03 = version5 / 2;
        } else if (i2 == 0) {
            int version6 = this.A03;
            this.A03 = version6 / 4;
        }
        int samplingRateIndex = (i >>> 9) & 1;
        int version7 = HO.A02(i2, i3);
        this.A04 = version7;
        if (i3 == 3) {
            if (i2 == 3) {
                int version8 = padding - 1;
                version2 = HO.A02[version8];
            } else {
                int version9 = padding - 1;
                version2 = HO.A06[version9];
            }
            this.A00 = version2;
            int version10 = this.A00;
            int i4 = version10 * 12;
            int version11 = this.A03;
            this.A02 = ((i4 / version11) + samplingRateIndex) * 4;
        } else {
            if (i2 == 3) {
                if (i3 != 2) {
                    int version12 = padding - 1;
                    version = HO.A0C()[version12];
                } else {
                    int version13 = padding - 1;
                    version = HO.A03[version13];
                }
                this.A00 = version;
                int version14 = this.A00;
                int i5 = version14 * 144;
                int version15 = this.A03;
                this.A02 = (i5 / version15) + samplingRateIndex;
            } else {
                int version16 = padding - 1;
                this.A00 = HO.A05[version16];
                int bitrateIndex2 = i3 == 1 ? 72 : 144;
                int version17 = this.A00;
                int bitrateIndex3 = bitrateIndex2 * version17;
                int version18 = this.A03;
                this.A02 = (bitrateIndex3 / version18) + samplingRateIndex;
            }
        }
        int version19 = i >> 6;
        this.A01 = (version19 & 3) == 3 ? 1 : 2;
        return true;
    }
}
