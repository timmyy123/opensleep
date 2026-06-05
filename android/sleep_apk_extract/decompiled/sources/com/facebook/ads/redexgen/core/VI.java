package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class VI {
    public static byte[] A02;
    public final VA A00;
    public final String A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 45);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-15, -13, -32, -14, -9, -18, -29};
    }

    public VI(String str, VA va) {
        this.A01 = str;
        this.A00 = va;
    }

    public static void A02(VH vh, Map<String, String> map, String str, VA va) {
        A03(vh.A03(), map, str, va);
    }

    public static void A03(String str, Map<String, String> map, String str2, VA va) {
        if (!VK.A0B(str2, str)) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(A00(0, 7, 81), str);
        va.ABF(str2, map);
    }

    public final void A04(VH vh, Map<String, String> data2) {
        A05(vh.A03(), data2);
    }

    public final void A05(String str, Map<String, String> data2) {
        A03(str, data2, this.A01, this.A00);
    }
}
