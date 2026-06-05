package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class K8 {
    public static byte[] A0B;
    public static String[] A0C = {"ytMqT9NHYtHO", "ayDrBXmYpST", "PlkLAMptHTEQbTP2JBx8IVhZrr1OLjmr", "bsyNsbAKTDWthILnLFbT9XBAfe1JwY0A", "7ooEejyrqYW6", "qPz9rN", "uQjyiEFGwynd0EfS97vi0PnYLnL7ypAQ", "fkOqnZo8h0umFuLkeHHFLjLqaxMuEadl"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final int A0A;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 69);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0B = new byte[]{-72, -114, -73, -70, -75, -87, -68, -126, -79, -68, -71, -73, -66, -67, -75, -66, -60, -49, -36, -39, -47, 0, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 16, 2, 3, 16, 17, 18, 23, 10, 3, -4, 5, 4, 10, 9, -1, 16, -5, -49, -38, -57, -46, -49, -55, -25, -38, -26, -34, -75, -69, -70, -78, -81, -76, -85, -87, -75, -78, -75, -69, -72, -26, -24, -33, -29, -41, -24, -17, -39, -27, -30, -27, -21, -24, -23, -22, -24, -33, -31, -37, -27, -21, -22, -52, -59, -69, -68, -55, -61, -64, -59, -68};
    }

    static {
        A02();
    }

    public K8(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.A06 = i;
        this.A00 = i2;
        this.A08 = i3;
        this.A07 = i4;
        this.A03 = i5;
        this.A01 = i6;
        this.A04 = i7;
        this.A0A = i8;
        this.A09 = i9;
        this.A02 = i10;
        this.A05 = i11;
    }

    public static K8 A00(String str) {
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int nameIndex = A01(1, 7, 3).length();
        String[] strArrSplit = TextUtils.split(str.substring(nameIndex), A01(0, 1, 71));
        int boldIndex = 0;
        while (true) {
            int nameIndex2 = strArrSplit.length;
            int fontSizeIndex = -1;
            if (boldIndex < nameIndex2) {
                String strA01 = AbstractC1616k7.A01(strArrSplit[boldIndex].trim());
                int nameIndex3 = strA01.hashCode();
                switch (nameIndex3) {
                    case -1178781136:
                        if (strA01.equals(A01(40, 6, 33))) {
                            fontSizeIndex = 6;
                        }
                        break;
                    case -1026963764:
                        if (strA01.equals(A01(85, 9, 18))) {
                            fontSizeIndex = 7;
                        }
                        break;
                    case -192095652:
                        if (strA01.equals(A01(76, 9, 49))) {
                            fontSizeIndex = 8;
                        }
                        break;
                    case -70925746:
                        if (strA01.equals(A01(63, 13, 49))) {
                            fontSizeIndex = 2;
                        }
                        break;
                    case 3029637:
                        if (strA01.equals(A01(17, 4, 40))) {
                            fontSizeIndex = 5;
                        }
                        break;
                    case 3373707:
                        if (strA01.equals(A01(46, 4, 52))) {
                            fontSizeIndex = 0;
                        }
                        break;
                    case 366554320:
                        String[] strArr = A0C;
                        String str2 = strArr[2];
                        String str3 = strArr[3];
                        int nameIndex4 = str2.charAt(26);
                        int alignmentIndex = str3.charAt(26);
                        if (nameIndex4 != alignmentIndex) {
                            throw new RuntimeException();
                        }
                        A0C[7] = "KkotiNXx90oMvgOaVjUCxZkwY6iD9aVw";
                        if (strA01.equals(A01(32, 8, 81))) {
                            fontSizeIndex = 4;
                        }
                        break;
                    case 767321349:
                        if (strA01.equals(A01(21, 11, 89))) {
                            fontSizeIndex = 9;
                        }
                        break;
                    case 1767875043:
                        if (strA01.equals(A01(8, 9, 11))) {
                            fontSizeIndex = 1;
                        }
                        break;
                    case 1988365454:
                        if (strA01.equals(A01(50, 13, 1))) {
                            fontSizeIndex = 3;
                        }
                        break;
                }
                switch (fontSizeIndex) {
                    case 0:
                        i = boldIndex;
                        break;
                    case 1:
                        i2 = boldIndex;
                        break;
                    case 2:
                        i3 = boldIndex;
                        break;
                    case 3:
                        i4 = boldIndex;
                        break;
                    case 4:
                        i5 = boldIndex;
                        break;
                    case 5:
                        i6 = boldIndex;
                        break;
                    case 6:
                        i7 = boldIndex;
                        break;
                    case 7:
                        i8 = boldIndex;
                        break;
                    case 8:
                        i9 = boldIndex;
                        break;
                    case 9:
                        i10 = boldIndex;
                        break;
                }
                boldIndex++;
            } else {
                if (i != -1) {
                    int nameIndex5 = strArrSplit.length;
                    return new K8(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, nameIndex5);
                }
                return null;
            }
        }
    }
}
