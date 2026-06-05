package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6m, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C02716m {
    public static String[] A04 = {"8qiLNNQ5vyMVHTnGSRqIYH7vmKWFglWA", "MmZLlpUmCeAJmbrnsvUlOeosT2b4trAw", "F6OhdvzD3alSBTyOt6RaJoXj3nzaYsfx", "Xx287Yna8TF6bT1u1Go86DeoE2qCPeph", "3UZ5i1ilvbC05GJFJQV3kBZois6ux7zX", "EjY6nrBNo27Sp872cFf6GtSg6OGn5", "mF6jYE7WEwd2TxTTRWKuDem5zACYSEbg", "YtiRIUv5IVo7m2JEFXkoL0U8gRnX79g8"};
    public int A00;
    public int A01;
    public C7Z A02;
    public boolean A03;

    public C02716m() {
    }

    public final void A03(int i) {
        this.A01 += i;
    }

    public final void A04(int i) {
        if (this.A03 && this.A00 != 4) {
            AbstractC02053y.A07(i == 4);
        } else {
            this.A03 = true;
            this.A00 = i;
        }
    }

    public final void A05(C7Z c7z) {
        this.A02 = c7z;
        this.A01 = 0;
        this.A03 = false;
    }

    public final boolean A06(C7Z c7z) {
        if (c7z == this.A02) {
            int i = this.A01;
            if (A04[5].length() != 29) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[3] = "a8XkvjAywsklqJZ77zbAyDpR6RKD2BNQ";
            strArr[2] = "VuupfHWuP4U2DCcYrL3QbObgg99PbZin";
            if (i <= 0 && !this.A03) {
                return false;
            }
        }
        return true;
    }
}
