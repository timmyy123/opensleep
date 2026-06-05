package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum JS {
    A03,
    A04;

    public static byte[] A00;
    public static String[] A01 = {"AGSeLGKSRVWHjwpJcBbRLkJfLT8WtSj5", "H7iAoy9xUjOjDwkyYn3gaRvOJ1nIBHLJ", "EVfEuZVSowgq13ZnxgimNyesiv2WPjJR", "wEMBUpOgjO3FJGZSz1OinbfqqxPYLP66", "CBkqendLt6fx", "OD9b4WhLx6uMipDOtSe029KXVXZlCbYX", "5yVEyiRs1KvMosNbPykruqGUah2O3DeM", "pqSqJaa9ICEXDKYBpEheNdvD5WKufuNj"};

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] - i3) - 61;
            String[] strArr = A01;
            if (strArr[1].charAt(13) != strArr[0].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "ai0karKAJoeNx7Xk9C6gfqHAQPI6uXke";
            strArr2[7] = "u7OYJqR0ngtg88afXXFiWDXiPlKyUSBE";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-34, -35, -44, -73, -70, -78};
    }

    static {
        A01();
    }
}
