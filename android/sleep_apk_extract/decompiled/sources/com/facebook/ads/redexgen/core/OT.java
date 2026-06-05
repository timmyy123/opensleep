package com.facebook.ads.redexgen.core;

import com.facebook.ads.CacheFlag;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class OT {
    public static byte[] A00;
    public static String[] A01 = {"pY9ZXifxArCVjHBuW1cFi0dQljuE9Tf0", "pWwXLaHMc2CIhW3XIuObF4bvoKv8BfMZ", "mjts0HvkPGtREm0amxRZnnNRJAuUZdvm", "abSMUJDaje8PZVdniKXVA7EheIgEU2Ky", "XlFlgNr5vQZ1tyGpSUziV1wK28nmqCDp", "l72ITgVAaer6oLi3ZuEszNZ4Tz579Dik", "01uixCM2ew1GUtPlkStbY4R3MiHKurQG", "OuIJxNEFpIwLjLPuYqUOL946mVcVFOoz"};
    public static final HashMap<String, CacheFlag> A02;
    public static final HashMap<CacheFlag, String> A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 91);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {-58, 10, 4, 16, 15, -34, -30, -42, -36, -38, -42, -41, -42, -51, -47, -54, -57, -54, -53, -45, -54, -45, -58, -63, -62, -52};
        if (A01[0].charAt(16) != 'W') {
            throw new RuntimeException();
        }
        A01[5] = "Bq2StgQbD5mLPjUE1dw95ch9p648bptk";
        A00 = bArr;
    }

    static {
        A03();
        A03 = new HashMap<>();
        A02 = new HashMap<>();
        A04(CacheFlag.NONE, A00(10, 4, 13));
        A04(CacheFlag.ICON, A00(1, 4, 70));
        A04(CacheFlag.IMAGE, A00(5, 5, 26));
        A04(CacheFlag.VIDEO, A00(21, 5, 2));
    }

    public static String A01(EnumSet<CacheFlag> cacheFlags) {
        if (cacheFlags == null) {
            if (A01[0].charAt(16) != 'W') {
                throw new RuntimeException();
            }
            A01[2] = "mQm3e3EDrMVtI1xQTgCv9nJkqidgOUz3";
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = cacheFlags.iterator();
        while (it.hasNext()) {
            String strA00 = A03.get((CacheFlag) it.next());
            if (strA00 == null) {
                strA00 = A00(14, 7, 1);
            }
            StringBuilder sbAppend = sb.append(strA00);
            String mappedValue = A00(0, 1, 63);
            if (A01[2].charAt(21) != 'n') {
                sbAppend.append(mappedValue);
            } else {
                A01[5] = "m2WAASCqguA1bRajQOE6ItOClvFsunSk";
                sbAppend.append(mappedValue);
            }
        }
        return sb.toString();
    }

    public static EnumSet<CacheFlag> A02(String str) {
        if (str == null) {
            return null;
        }
        EnumSet<CacheFlag> enumSetNoneOf = EnumSet.noneOf(CacheFlag.class);
        for (String str2 : str.split(A00(0, 1, 63))) {
            enumSetNoneOf.add(A02.get(str2));
        }
        return enumSetNoneOf;
    }

    public static void A04(CacheFlag cacheFlag, String str) {
        A03.put(cacheFlag, str);
        A02.put(str, cacheFlag);
    }
}
