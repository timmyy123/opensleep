package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum SV {
    A04(A01(16, 5, 107)),
    A06(A01(27, 5, 1)),
    A05(A01(21, 6, 74));

    public static byte[] A01;
    public static String[] A02 = {"SZ4ZqaU4fFFh0E4YNccvZxVNy5", "RnD6qsfq2PJ4GIm1AYVwkdKueb87xF36", "J6AvcZe6YXfwvJXVFlguqZimD2oQ2oTO", "puNNDl5gPUEFWhcEtNEHLKZ21l2c7qHR", "lO566f8c3ZpTrsgNovf1GdP6EuJ1Ihz8", "rzZJHS6KiH5aslcybkMmKbRCqwolmQAz", "lMymBa1GAS6gSrjK2mQJROkXbE", "lIq0nKP0GwKiYNEJRhA9Zsqqg4xJtS7q"};
    public final String A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-70, -66, -78, -72, -74, 89, 77, 94, 87, 97, 92, -81, -94, -99, -98, -88, -34, -30, -42, -36, -38, -63, -75, -58, -65, -55, -60, -127, 116, 111, 112, 122};
    }

    static {
        A02();
    }

    SV(String str) {
        this.A00 = str;
    }

    public static SV A00(String str) {
        for (SV type : values()) {
            String[] strArr = A02;
            if (strArr[6].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[6] = "Aja9B1UEj6BzKn1INFFqcKK4Fe";
            strArr2[0] = "GwpKbwXfukeF7x0PFg8wIbfMxN";
            if (type.A00.equals(str)) {
                return type;
            }
        }
        return null;
    }
}
