package com.facebook.ads.redexgen.core;

import android.util.Log;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class Y1 {
    public static byte[] A00;
    public static String[] A01 = {"kzsYhm9LKsU0BkYF5GBD4cHOfO5I2S", "FiiX6q", "juV27aOscABEXHLMFQmBucT", "1EXxaj", "f1sOyyKe81qkTfSynlEtElAllv4GRKo", "lzeqJRba", "GXB72S", "F9UQYukVDOEwI1lxcupNtKixpZh4OtVr"};
    public static final Y0 A02 = null;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{64, 75, 86, 3, 23, 8, 20, 21, 18, 16, 50, 61, 116, 39, 115, 53, 60, 33, 62, 50, 39, 115, 39, 58, 62, 54, 125};
    }

    static {
        A08();
    }

    public static long A00() {
        if (A02 != null) {
            return A02.A5n();
        }
        return System.currentTimeMillis();
    }

    public static long A01(long j) {
        return A02(j, System.currentTimeMillis());
    }

    public static long A02(long j, long j2) {
        if (j == -1) {
            return -1L;
        }
        return j2 - j;
    }

    public static String A03(double d) throws Exception {
        try {
            return String.format(Locale.US, A04(0, 4, 115), Double.valueOf(d));
        } catch (Exception e) {
            String simpleName = Y1.class.getSimpleName();
            if (A01[3].length() == 20) {
                Exception e2 = new RuntimeException();
                throw e2;
            }
            A01[0] = "ylDYykVZ0MQgZWbzvTC4Y0QCoTAruV";
            Log.e(simpleName, A04(9, 18, 69), e);
            return A04(4, 5, 48);
        }
    }

    public static String A05(long j) {
        return String.valueOf(A01(j));
    }

    @Deprecated
    public static String A06(long j) {
        return A03(j / 1000.0d);
    }

    public static String A07(long j) {
        return Long.toString(j);
    }
}
