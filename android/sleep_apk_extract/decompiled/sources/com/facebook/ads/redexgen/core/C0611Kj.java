package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0611Kj {
    public static byte[] A04;
    public static String[] A05 = {"Tlnn5cKjLaIjRpnStB3TtMXpCr", "3ektkjDKhO", "UADsPGxQMgbdHUVZTw2T7TudB6ybNpUs", "wMkteQxfp4DsqI2DXiVAWfh1RT3", "vTGkM2prP14EX1TDx6P9XqiD0Fmww", "sal8paYv5RRrD9uY6TWNX8GISo", "qTpYd1bjPJIA7eigqjtgMToqdlzi", "UsOSpCey7qyyyJdYXs2GK2q4qSEth0kx"};
    public final int A00;
    public final String A01;
    public final String A02;
    public final Set<String> A03;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{2, 73, 59};
        if (A05[2].charAt(0) == 'K') {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[6] = "WMYi1W8Xbtf0WzjxHgJrZE6ARrtq";
        strArr[1] = "r4jVis15Qe";
    }

    static {
        A03();
    }

    public C0611Kj(String str, int i, String str2, Set<String> classes) {
        this.A00 = i;
        this.A01 = str;
        this.A02 = str2;
        this.A03 = classes;
    }

    public static C0611Kj A00() {
        Set setEmptySet = Collections.emptySet();
        String strA02 = A02(0, 0, 5);
        return new C0611Kj(strA02, 0, strA02, setEmptySet);
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x0039 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0611Kj A01(String str, int i) {
        String strTrim;
        String strTrim2 = str.trim();
        AbstractC02053y.A07(!strTrim2.isEmpty());
        int iIndexOf = strTrim2.indexOf(A02(0, 1, 24));
        if (iIndexOf == -1) {
            strTrim = A02(0, 0, 5);
        } else {
            strTrim = strTrim2.substring(iIndexOf).trim();
            strTrim2 = strTrim2.substring(0, iIndexOf);
        }
        String[] strArrA1O = C5C.A1O(strTrim2, A02(1, 2, 47));
        String str2 = strArrA1O[0];
        HashSet hashSet = new HashSet();
        for (int i2 = 1; i2 < voiceStartIndex; i2++) {
            hashSet.add(strArrA1O[i2]);
        }
        return new C0611Kj(str2, i, strTrim, hashSet);
    }
}
