package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0916Wk {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-19, -7, -9, -72, -16, -21, -19, -17, -20, -7, -7, -11, -72, -21, -18, -3, -72, -13, -8, -2, -17, -4, -8, -21, -10, -72, -21, -18, -3, -23, -3, -6, -23, -3, -2, -7, -4, -21, -15, -17};
    }

    public static SharedPreferences A00(T8 t8) {
        return t8.getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(0, 40, 89), t8), 0);
    }

    public final int A03(T8 t8, String str, int i) {
        return A00(t8).getInt(str, i);
    }

    public final String A04(T8 t8, String str, String str2) {
        return A00(t8).getString(str, str2);
    }

    public final void A05(T8 t8, String str, int i) {
        SharedPreferences btSP = A00(t8);
        btSP.edit().putInt(str, i).apply();
    }

    public final void A06(T8 t8, String str, String str2) {
        SharedPreferences btSP = A00(t8);
        btSP.edit().putString(str, str2).apply();
    }
}
