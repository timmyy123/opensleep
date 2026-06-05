package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdExperienceType;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class OS {
    public static byte[] A00;
    public static String[] A01 = {"eCm2h", "Nf7MRRwZDvE8y93FmZbCxZ1qYSmL5", "hLhdl", "QFLrF4Ks", "BOssa91vTI1SLJXUpFqc70oF1BItrBHL", "FqkYvgsNMANULI15i6yaohJxBf4", "miT1Gr55rzSuK5J6MchCspbbNM8vv", "VeGA9hanV"};

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] ^ i3) ^ 8;
            String[] strArr = A01;
            if (strArr[0].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            A01[4] = "4uOWgwLt9zl0NDLT0ztu7wfG2sM7UGLh";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {99, 102, 93, 103, 122, 114, 103, 112, 107, 103, 108, 97, 103, 93, 97, 109, 108, 100, 107, 101, 93, 107, 108, 118, 103, 112, 113, 118, 107, 118, 107, 99, 110, 32, 37, 30, 36, 57, 49, 36, 51, 40, 36, 47, 34, 36, 30, 34, 46, 47, 39, 40, 38, 30, 51, 36, 54, 32, 51, 37, 36, 37, 30, 40, 47, 53, 36, 51, 50, 53, 40, 53, 40, 32, 45};
        String[] strArr = A01;
        if (strArr[0].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[6] = "XJhKJAm65tduHMV7V8mUfKCv645Q9";
        strArr2[5] = "xNMnL7L41pq7X174jFC3Kxd5REO";
        A00 = bArr;
    }

    static {
        A03();
    }

    public static AdExperienceType A00(String str) {
        if (str == null) {
            return null;
        }
        if (A01(0, 33, 10).equals(str)) {
            AdExperienceType adExperienceType = AdExperienceType.AD_EXPERIENCE_TYPE_INTERSTITIAL;
            String[] strArr = A01;
            if (strArr[0].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "tWHbMLY0jEAGlYHbcSqJBIrBc18go";
            strArr2[5] = "4H5Z0LJ7wdDYVvSZnKKEqH9oXzt";
            return adExperienceType;
        }
        if (A01(33, 42, 73).equals(str)) {
            return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL;
        }
        return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED;
    }

    public static String A02(AdExperienceType adExperienceType) {
        return adExperienceType.getAdExperienceType();
    }
}
