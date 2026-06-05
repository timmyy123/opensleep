package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC1979qG {
    public static byte[] A00;
    public static String[] A01 = {"c6xksnT41HcsUKTJQNKQUUgPizIoQEq7", "WxNXiQtoIPtkZSOvfQD2WRgz0FRR9nHB", "0W3ozcXeUf0HHNgljiWCV2HF0oAsRQbi", "fgzW1UUUZ", "O0bR9ZeclLezQy3Qbc2ToHrC1rtck2lk", "lkeBgJo9Q0VPEUMwx37sMSkp8PGnIPOP", "djrdLhPsa8uKbU3eQglu3qx0uljp8azj", "xtpRaDH0t"};

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {37, 48, 100, 45, 42, 32, 33, 60, 100};
        String[] strArr = A01;
        if (strArr[7].length() != strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[1] = "M9elCsu2ZKCRxn57Vnxvtjkp0iclIc1e";
        strArr2[2] = "8jrrMw1RDLVSnYLZpZuKU5Zh0pORqyYH";
        A00 = bArr;
    }

    static {
        A02();
    }

    public static Object A00(@CheckForNull Object element, int index) {
        if (element != null) {
            return element;
        }
        throw new NullPointerException(A01(0, 9, 81) + index);
    }

    public static Object[] A03(Object... array) {
        A04(array, array.length);
        return array;
    }

    public static Object[] A04(Object[] array, int length) {
        for (int i = 0; i < length; i++) {
            A00(array[i], i);
        }
        return array;
    }

    public static <T> T[] A05(T[] tArr, int i) {
        return (T[]) AbstractC1984qN.A01(tArr, i);
    }
}
