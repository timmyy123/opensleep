package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class V1 {
    public static String[] A04 = {"VndfGBIDInq1AmGKWEXIYtH", "X1ufgR44W1Z84U", "n", "", "za8Aa", "xjBfTCMiG1bFh7NB9hwMlLVXQHNbTqdl", "vkDSrNK7CnANJUjGZxXcCXY", "njWPP"};
    public EnumC0880Uy A01 = EnumC0880Uy.A03;
    public EnumC0881Uz A02 = EnumC0881Uz.A06;
    public V0 A03 = V0.A02;
    public EnumC0879Ux A00 = EnumC0879Ux.A02;

    public final void A00() {
        this.A00 = EnumC0879Ux.A03;
    }

    public final void A01() {
        this.A02 = EnumC0881Uz.A04;
    }

    public final void A02() {
        this.A02 = EnumC0881Uz.A05;
    }

    public final void A03() {
        this.A03 = V0.A03;
    }

    public final boolean A04() {
        if (this.A02 != EnumC0881Uz.A06) {
            EnumC0881Uz enumC0881Uz = this.A02;
            String[] strArr = A04;
            if (strArr[6].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[6] = "r152EQyYeE04Ovy9QYMfnLx";
            strArr2[0] = "I6yTYbMajK96Zgvn6mn7gLC";
            if (enumC0881Uz != EnumC0881Uz.A02 && this.A02 != EnumC0881Uz.A05) {
                return false;
            }
        }
        return true;
    }

    public final boolean A05() {
        return this.A02 == EnumC0881Uz.A06 || this.A02 == EnumC0881Uz.A02;
    }

    public final boolean A06() {
        return this.A03 == V0.A03;
    }

    public final boolean A07() {
        return this.A00 == EnumC0879Ux.A03;
    }
}
