package com.facebook.ads.redexgen.core;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.Arrays;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class EnumC1210dH {
    public static byte[] A01;
    public static String[] A02 = {"7eCrAZGCjapRaLUbK9QRGJs0olrSOuKs", "ySZlw7xE2mJZGUobjeP0sD0O3cTwGa8X", "XGkq56ugg4rIrrrN3BI0SeRXJOu8cnXg", "EhbVD2npYjMN4Lpqgy2TDazDwa0P1ZFY", "GxzPigdu3bGRa23YdvFpU3mIsN0rCQhK", "nJ0CacvfsZFNuLFGVLMdvF7ct8TNyFNR", "5gEoeYtHKqdKxvGOrBFQEkCXLQc4JGvi", "KvAzUjsGuu6UHJoTOmt3i913MHVvWe2E"};
    public static final /* synthetic */ EnumC1210dH[] A03;
    public static final EnumC1210dH A04;
    public static final EnumC1210dH A05;
    public static final EnumC1210dH A06;
    public static final EnumC1210dH A07;
    public static final EnumC1210dH A08;
    public static final EnumC1210dH A09;
    public static final EnumC1210dH A0A;
    public static final EnumC1210dH A0B;
    public static final EnumC1210dH A0C;
    public static final EnumC1210dH A0D;
    public static final EnumC1210dH A0E;
    public static final EnumC1210dH A0F;
    public static final EnumC1210dH A0G;
    public static final EnumC1210dH A0H;
    public static final EnumC1210dH A0I;
    public static final EnumC1210dH A0J;
    public static final EnumC1210dH A0K;
    public static final EnumC1210dH A0L;
    public static final EnumC1210dH A0M;
    public static final EnumC1210dH A0N;
    public static final EnumC1210dH A0O;
    public static final EnumC1210dH A0P;
    public static final EnumC1210dH A0Q;
    public final String A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-78, -69, -66, -62, -76, -50, -79, -63, -66, -58, -62, -76, -63, 126, 127, 124, -113, -127, -89, -84, -74, -92, -91, -81, -88, -62, -91, -92, -90, -82, -62, -91, -72, -73, -73, -78, -79, -77, -68, -81, -80, -70, -77, -51, -80, -81, -79, -71, -51, -80, -61, -62, -62, -67, -68, -112, -99, -99, -102, -99, -121, -106, -115, -115, -108, -124, -109, -122, -122, -113, -99, -84, -91, -91, -100, -93, 119, 112, 125, 115, 123, 116, -114, 114, -125, 112, -106, -113, -100, -110, -102, -109, -83, -108, -112, -96, -92, -72, -71, -76, -75, -49, -58, -71, -76, -75, -65, -79, -75, -72, -70, -83, -69, -69, -79, -73, -74, -56, -67, -47, -54, -65, -60, -37, -67, -64, -37, -50, -63, -52, -53, -50, -48, -59, -54, -61, -126, -123, 125, -79, -71, -72, -87, -61, -70, -83, -88, -87, -77, -105, -114, -96, -88, -113, -98, -105, -105, -114, -107, -58, -57, -68, -59, -42, -61, -64, -59, -62, 91, 76, 96, 94, 80, 106, 97, 84, 79, 80, 90, -47, -51, -62, -38, -32, -41, -54, -59, -58, -48, -50, -63, -67, -64, -37, -49, -48, -50, -59, -54, -61, -68, -81, -63, -85, -68, -82, -55, -83, -71, -73, -70, -74, -81, -66, -81, -78, -86, -88, -81, -66, -75, -88, -93, -92, -82, -109, -116, -119, -116, -115, -107, -116, 118, 113, 104, 115, 100, 126, 114, 115, 113, 104, 109, 102, 109, 118, 121, 125, 111, 105, 108, 124, 121, -127, 125, 111, 124, -77, -76, -79, -60, -74, -65, -60, -50, -68, -67, -57, -64, -70, -67, -68, -66, -58, -70, -67, -48, -49, -49, -54, -55, -80, -71, -84, -83, -73, -80, -86, -83, -84, -82, -74, -86, -83, -64, -65, -65, -70, -71, -47, -34, -34, -37, -34, 118, -123, 126, 126, 117, 124, -95, -102, -89, -99, -91, -98, -104, -100, -83, -102, 118, 111, 124, 114, 122, 115, 109, 116, 112, -128, -124, -49, -48, -53, -52, -58, -35, -48, -53, -52, -42, -67, -63, -60, -58, -71, -57, -57, -67, -61, -62, -68, -79, -59, -66, -77, -72, -81, -79, -76, -81, -62, -75, -64, -65, -62, -60, -71, -66, -73, -81, -74, -68, -65, -57, -99, -96, -104, -17, -9, -10, -25, -31, -8, -21, -26, -25, -15, -42, -51, -33, -57, -50, -35, -42, -42, -51, -44, -26, -25, -36, -27, -42, -29, -32, -27, -30, -113, -128, -108, -110, -124, 126, -107, -120, -125, -124, -114, -55, -59, -70, -46, -72, -49, -62, -67, -66, -56, -55, -53, -66, -52, -66, -57, -51, -72, -65, -50, -59, -59, -52, -68, -53, -66, -66, -57, -44, -57, -61, -58, -63, -43, -42, -44, -53, -48, -55, -101, -114, -96, -118, -101, -115, -120, -116, -104, -106, -103, -107, -114, -99, -114, -53, -61, -63, -56, -73, -50, -63, -68, -67, -57, -124, 127, 118, -127, 114, 108, -128, -127, 127, 118, 123, 116};
    }

    static {
        A02();
        A0B = new EnumC1210dH(A01(76, 10, 43), 0, A01(310, 10, 53));
        A0F = new EnumC1210dH(A01(117, 19, 120), 1, A01(351, 24, 76));
        A04 = new EnumC1210dH(A01(0, 13, 107), 2, A01(244, 13, 6));
        A07 = new EnumC1210dH(A01(37, 18, 106), 3, A01(281, 18, 71));
        A06 = new EnumC1210dH(A01(18, 19, 95), 4, A01(262, 19, 87));
        A0E = new EnumC1210dH(A01(107, 10, 100), 5, A01(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 10, 80));
        A0G = new EnumC1210dH(A01(136, 3, 50), 6, A01(375, 3, 45));
        A05 = new EnumC1210dH(A01(13, 5, 54), 7, A01(257, 5, 75));
        A0A = new EnumC1210dH(A01(70, 6, 83), 8, A01(304, 6, 12));
        A0I = new EnumC1210dH(A01(149, 10, 69), 9, A01(388, 10, 100));
        A0N = new EnumC1210dH(A01(200, 15, 102), 10, A01(457, 15, 37));
        A08 = new EnumC1210dH(A01(55, 5, 71), 11, A01(299, 5, 104));
        A0H = new EnumC1210dH(A01(139, 10, 96), 12, A01(378, 10, 126));
        A0D = new EnumC1210dH(A01(97, 10, 108), 13, A01(331, 10, 99));
        A0O = new EnumC1210dH(A01(215, 10, 91), 14, A01(472, 10, 84));
        A0L = new EnumC1210dH(A01(179, 10, 125), 15, A01(418, 10, 85));
        A0K = new EnumC1210dH(A01(168, 11, 7), 16, A01(407, 11, 27));
        A0Q = new EnumC1210dH(A01(232, 12, 27), 17, A01(482, 12, 9));
        A0M = new EnumC1210dH(A01(189, 11, 120), 18, A01(446, 11, 94));
        A0C = new EnumC1210dH(A01(86, 11, 74), 19, A01(320, 11, 10));
        A09 = new EnumC1210dH(A01(60, 10, 61), 20, A01(428, 18, 85));
        A0J = new EnumC1210dH(A01(159, 9, 115), 21, A01(398, 9, 115));
        A0P = new EnumC1210dH(A01(225, 7, 58), 22, A01(0, 0, 60));
        A03 = A03();
    }

    public EnumC1210dH(String str, int i, String str2) {
        this.A00 = str2;
    }

    public static EnumC1210dH A00(String str) {
        for (EnumC1210dH enumC1210dH : values()) {
            if (enumC1210dH.A00.equalsIgnoreCase(str)) {
                return enumC1210dH;
            }
        }
        EnumC1210dH enumC1210dH2 = A0P;
        String[] strArr = A02;
        if (strArr[5].charAt(11) != strArr[3].charAt(11)) {
            throw new RuntimeException();
        }
        A02[1] = "FXbZWXffVyaneTw3kEwIh8dxCOHwnV6P";
        return enumC1210dH2;
    }

    public static /* synthetic */ EnumC1210dH[] A03() {
        EnumC1210dH[] enumC1210dHArr = new EnumC1210dH[23];
        enumC1210dHArr[0] = A0B;
        String[] strArr = A02;
        if (strArr[0].charAt(12) != strArr[4].charAt(12)) {
            throw new RuntimeException();
        }
        A02[6] = "5YohDqwhZisgRi0et8gjdsLiIOixczu5";
        enumC1210dHArr[1] = A0F;
        enumC1210dHArr[2] = A04;
        enumC1210dHArr[3] = A07;
        enumC1210dHArr[4] = A06;
        enumC1210dHArr[5] = A0E;
        enumC1210dHArr[6] = A0G;
        enumC1210dHArr[7] = A05;
        enumC1210dHArr[8] = A0A;
        enumC1210dHArr[9] = A0I;
        enumC1210dHArr[10] = A0N;
        enumC1210dHArr[11] = A08;
        enumC1210dHArr[12] = A0H;
        enumC1210dHArr[13] = A0D;
        enumC1210dHArr[14] = A0O;
        enumC1210dHArr[15] = A0L;
        enumC1210dHArr[16] = A0K;
        enumC1210dHArr[17] = A0Q;
        enumC1210dHArr[18] = A0M;
        enumC1210dHArr[19] = A0C;
        enumC1210dHArr[20] = A09;
        enumC1210dHArr[21] = A0J;
        enumC1210dHArr[22] = A0P;
        return enumC1210dHArr;
    }

    public static EnumC1210dH valueOf(String str) {
        return (EnumC1210dH) Enum.valueOf(EnumC1210dH.class, str);
    }

    public static EnumC1210dH[] values() {
        return (EnumC1210dH[]) A03.clone();
    }
}
