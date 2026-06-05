package com.facebook.ads.redexgen.core;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.internal.Utility;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class B3 {
    public static byte[] A0B;
    public static String[] A0C = {"I9JaO4heFf5nDgSUvVeAxAeOAdbY1nhs", "PVSEhsxK0zpzpXeziFZITHKDYbLYMlXw", "qlK6yxEC", "9zKWhcki2UyQZLYGzaAyWcMw08QqvpbN", "JlMwKIWIzkUyHhMRK", "e8OveLjqyhc2hkEtyY01o7K", "DY1oAH7PrQgT6IVPSHYZAZf9F8l8uJ13", "bCAM9BCoFLqZyqtmC8leb"};
    public final MediaCodecInfo.CodecCapabilities A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final boolean A04;
    public final boolean A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 26);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0B = new byte[]{73, 29, 6, 73, 29, 17, 65, 77, 54, 46, 48, 2, 2, 4, 28, 20, 21, 60, 16, 9, 50, 25, 16, 31, 31, 20, 29, 48, 21, 27, 4, 2, 5, 28, 20, 31, 5, 75, 81, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 60, 60, 58, 34, 42, 43, 28, 58, 63, 63, 32, 61, 59, 111, 20, 19, 58, 49, 48, 41, 48, 127, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 29, 114, 7, 105, 111, 106, 98, 75, 64, 65, 88, 65, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 122, 108, 3, 118, 24, 30, 24, 86, 127, 116, 117, 108, 117, 58, 78, 88, 55, 66, 44, 43, 44, 52, 28, 29, 16, 24, 58, 22, 29, 28, 26, 48, 23, 31, 22, 28, 55, 42, 39, 33, 114, 99, 98, 126, 95, 99, 69, 64, 64, 95, 66, 68, 16, 107, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 0, 22, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 0, 105, 28, 17, 119, 32, 34, 55, 65, 42, 23, 22, 1, 0, 28, 65, 46, 57, 44, 65, 43, 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, 29, 31, 29, 8, 126, 21, 40, 41, 62, 63, 35, 126, 17, 6, 19, 126, 20, 53, 51, 63, 52, 53, 34, 126, 35, 53, 51, 37, 34, 53, 84, 86, 67, 53, 86, 90, 73, 77, 94, 87, 87, 53, 77, 82, 95, 94, 84, 53, 83, 76, 53, 88, 84, 95, 90, 44, 46, 47, 41, 95, 94, 88, 84, 95, 94, 73, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9, 28, 106, 9, 16, 15, 106, 18, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 0, 1, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 106, 0, 1, 7, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 0, 1, 22, 106, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 1, 18, 7, 16, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 110, 23, 113, 112, 115, 15, 102, 27, 96, 90, 95, 90, 75, 79, 82, 77, 94, 22, 75, 87, 90, 66, 89, 90, 88, 80, 29, 9, 24, 21, 19, 83, 79, 27, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 74, 94, 79, 66, 68, 4, 74, 72, 24, 110, 122, 107, 102, 96, 32, 110, 98, 125, 34, 120, 109, 44, 56, 41, 36, 34, 98, 40, 44, 46, 126, 7, 19, 2, 15, 9, 73, 0, 10, 7, 5, 127, 107, 122, 119, 113, 49, 121, 41, 47, 47, 51, 127, 114, 127, 105, 42, 62, 47, 34, 36, 100, 44, 124, 122, 122, 102, 38, 39, 42, 60, 24, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 29, 16, 22, 86, 30, 10, 20, 78, 90, 75, 70, 64, 0, 66, 95, 27, 78, 2, 67, 78, 91, 66, 85, 65, 80, 93, 91, 27, 89, 68, 81, 83, 79, 91, 74, 71, 65, 1, 65, 94, 91, 93, 84, 64, 81, 92, 90, 26, 71, 84, 66, 111, 123, 106, 103, 97, 33, 120, 97, 124, 108, 103, 125, 126, 115, 110, 121, 125, 112, 5, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 7, 8, 8, 3, 10, 37, 9, 19, 8, 18, 72, 7, 37, 7, 22, 21, 66, 73, 64, 79, 79, 68, 77, 98, 78, 84, 79, 85, 15, 66, 64, 81, 82, 55, 60, 53, 58, 58, 49, 56, 23, 59, 33, 58, 32, 122, 39, 33, 36, 36, 59, 38, 32, 120, 116, 53, 57, 50, 51, 53, 120, 59, 63, 59, 51, 118, 107, 103, 108, 109, 107, 38, 120, 122, 103, 110, 97, 100, 109, 68, 109, 126, 109, 100, 36, 40, 126, 114, 97, 127, 122, 125, 36, 42, 63, 124, 40, 87, 69, 70, 86, 77, 74, 69, 77, 95, 87, 82, 88, 87, 77, 86, 49, 35, 47, 50, 46, 39, 16, 35, 54, 39, 108, 35, 1, 35, 50, 49, 109, 127, 115, 110, 114, 123, 76, 127, 106, 123, 48, 125, 127, 110, 109, 2, 16, 28, 1, 29, 20, 35, 16, 5, 20, 95, 2, 4, 1, 1, 30, 3, 5, 93, 81, 1, 23, 17, 7, 0, 23, 95, 2, 30, 19, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 16, 19, 17, 25, 102, 124, 111, 112, 84, 123, 113, 71, 116, 97, 112, 59, 118, 116, 101, 102, 64, 90, 73, 86, 114, 93, 87, 97, 82, 71, 86, 29, 80, 92, 69, 86, 65, 31, 19, 108, 118, 101, 122, 94, 113, 123, 77, 126, 107, 122, 49, 109, 112, 107, 126, 107, 122, 123, 51, 63, 24, 2, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 42, 5, 15, 57, 10, 31, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 69, 24, 30, 27, 27, 4, 25, 31, 71, 75, 100, 126, 109, 114, 86, 121, 115, 69, 118, 99, 114, 57, 97, 84, 118, 103, 100, 4, 5, 30, 30, 21, 28, 21, 20, 93, 0, 28, 17, 9, 18, 17, 19, 27, 48, 47, 34, 35, 41, 105, 39, 48, 37, 114, 109, 96, 97, 107, 43, 96, 107, 104, 102, 125, 41, 114, 109, 119, 109, 107, 106, 21, 10, 7, 6, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 76, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6, 21, 0, 82, 77, 64, 65, 75, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 92, 9, 82, 74, 64, 10, 75, 74, 22, 10, 82, 84, 29, 92};
    }

    static {
        A04();
    }

    public B3(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.A03 = (String) AbstractC02053y.A01(str);
        this.A02 = str2;
        this.A01 = str3;
        this.A00 = codecCapabilities;
        this.A05 = z;
        this.A07 = z2;
        this.A09 = z3;
        this.A04 = z4;
        this.A08 = z5;
        this.A06 = z6;
        this.A0A = C3J.A0F(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A00(String str, String str2, int i) {
        int i2;
        if (i <= 1 && ((C5C.A02 < 26 || i <= 0) && !A03(386, 10, 46).equals(str2) && !A03(281, 10, 102).equals(str2) && !A03(300, 12, 21).equals(str2) && !A03(371, 15, 53).equals(str2) && !A03(415, 12, 20).equals(str2) && !A03(396, 10, 52).equals(str2))) {
            String strA03 = A03(406, 9, 47);
            String[] strArr = A0C;
            if (strArr[6].charAt(25) != strArr[3].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[7] = "P3L7eJR7rcEs8Hcud8b0q";
            strArr2[5] = "gztvffw6orscNCYhET6gtHo";
            if (!strA03.equals(str2) && !A03(322, 10, 124).equals(str2)) {
                if (A0C[0].charAt(21) != 'A') {
                    if (!A03(332, 15, 4).equals(str2)) {
                        if (!A03(347, 15, 81).equals(str2) && !A03(362, 9, 99).equals(str2)) {
                            if (A03(291, 9, 49).equals(str2)) {
                                i2 = 6;
                            } else if (A03(312, 10, 87).equals(str2)) {
                                i2 = 16;
                            } else {
                                i2 = 30;
                            }
                            AbstractC02134g.A07(A03(97, 14, 99), A03(10, 29, 107) + str + A03(6, 3, 119) + i + A03(0, 4, 115) + i2 + A03(260, 1, 72));
                            return i2;
                        }
                    }
                } else {
                    String[] strArr3 = A0C;
                    strArr3[6] = "8EyIo3AmLznCqcE1QD1Y0pSK088XgXR2";
                    strArr3[3] = "dhhtuZGj1yFwqgsK2BE3ZfBkQ801LDWI";
                    if (!A03(332, 15, 4).equals(str2)) {
                    }
                }
            }
        }
        return i;
    }

    public static Point A01(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int heightAlignment = videoCapabilities.getWidthAlignment();
        int widthAlignment = videoCapabilities.getHeightAlignment();
        return new Point(C5C.A05(i, heightAlignment) * heightAlignment, C5C.A05(i2, widthAlignment) * widthAlignment);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static B3 A02(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        if (!z4 && codecCapabilities != null) {
            boolean zA09 = A09(codecCapabilities);
            if (A0C[2].length() != 8) {
                throw new RuntimeException();
            }
            A0C[2] = "xqlBNWNY";
            if (zA09 && !A0J(str)) {
                z6 = true;
            }
        } else {
            z6 = false;
        }
        return new B3(str, str2, str3, codecCapabilities, z, z2, z3, z6, codecCapabilities != null && A0D(codecCapabilities), z5 || (codecCapabilities != null && A0B(codecCapabilities)));
    }

    private void A05(String str) {
        StringBuilder sbAppend = new StringBuilder().append(A03(39, 16, 85)).append(str);
        String strA03 = A03(261, 3, 33);
        AbstractC02134g.A04(A03(97, 14, 99), sbAppend.append(strA03).append(this.A03).append(A03(4, 2, 43)).append(this.A02).append(strA03).append(C5C.A04).append(A03(260, 1, 72)).toString());
    }

    private void A06(String str) {
        StringBuilder sbAppend = new StringBuilder().append(A03(119, 11, 42)).append(str);
        String strA03 = A03(261, 3, 33);
        AbstractC02134g.A04(A03(97, 14, 99), sbAppend.append(strA03).append(this.A03).append(A03(4, 2, 43)).append(this.A02).append(strA03).append(C5C.A04).append(A03(260, 1, 72)).toString());
    }

    public static boolean A07() {
        return C5C.A03.equals(A03(532, 7, 62)) || C5C.A03.equals(A03(427, 6, 6)) || C5C.A06.startsWith(A03(55, 14, 69)) || C5C.A06.startsWith(A03(69, 14, 52)) || C5C.A06.startsWith(A03(83, 14, 0));
    }

    public static boolean A09(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return C5C.A02 >= 19 && A0A(codecCapabilities);
    }

    public static boolean A0A(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(264, 17, 33));
    }

    public static boolean A0B(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return C5C.A02 >= 21 && A0C(codecCapabilities);
    }

    public static boolean A0C(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(598, 15, 104));
    }

    public static boolean A0D(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return C5C.A02 >= 21 && A0E(codecCapabilities);
    }

    public static boolean A0E(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(707, 17, 106));
    }

    public static boolean A0F(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point alignedSize = A01(videoCapabilities, i, i2);
        int i3 = alignedSize.x;
        int i4 = alignedSize.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D46258033: [FBLite][Video] Solve tasks T154141530 T154151746 gating the call for SDK >=21")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A0G(C1981qI c1981qI, boolean z) {
        Pair<Integer, Integer> pairA0B = C0373Ba.A0B(c1981qI);
        if (pairA0B == null) {
            return true;
        }
        Integer num = (Integer) pairA0B.first;
        String[] strArr = A0C;
        if (strArr[6].charAt(25) == strArr[3].charAt(25)) {
            A0C[2] = "XFIr8RM8";
            int iIntValue = num.intValue();
            int level = ((Integer) pairA0B.second).intValue();
            if (A03(733, 18, 30).equals(c1981qI.A0W)) {
                if (A03(724, 9, 92).equals(this.A02)) {
                    iIntValue = 8;
                    level = 0;
                } else if (A03(751, 10, 121).equals(this.A02)) {
                    iIntValue = 2;
                    level = 0;
                }
            }
            if (this.A0A) {
                if (A0V().length > 0) {
                    return true;
                }
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrA0V = A0V();
                if (C5C.A02 >= 21 && C5C.A02 <= 23) {
                    if (A03(761, 19, 62).equals(this.A02) && codecProfileLevelArrA0V.length == 0) {
                        codecProfileLevelArrA0V = A0M(this.A00);
                    }
                }
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrA0V) {
                    if (codecProfileLevel.profile == iIntValue) {
                        int i = codecProfileLevel.level;
                        if (A0C[0].charAt(21) == 'A') {
                            A0C[1] = "Tk1KZqXmKjuSsbjIU3mgahSyAhYoMHEk";
                            if (i >= level || !z) {
                                boolean zA0L = A0L(this.A02, iIntValue);
                                if (A0C[1].charAt(21) != 'k') {
                                    A0C[0] = "B6qJQnb2cEtex6AQnXMJ6AJyRiBsPuck";
                                    if (!zA0L) {
                                        return true;
                                    }
                                } else if (!zA0L) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                A06(A03(501, 20, 18) + c1981qI.A0R + A03(4, 2, 43) + this.A01);
                return false;
            }
            if (A0C[2].length() == 8) {
                A0C[4] = "U7uwaC6XnAT7ItuO5";
                if (iIntValue != 42) {
                    return true;
                }
                if (A0V().length > 0) {
                }
            }
        }
        throw new RuntimeException();
    }

    public static boolean A0H(String str) {
        return A03(396, 10, 52).equals(str);
    }

    public static boolean A0I(String str) {
        return C5C.A06.startsWith(A03(253, 7, 89)) && A03(191, 36, 1).equals(str);
    }

    public static boolean A0J(String str) {
        if (C5C.A02 <= 22) {
            if ((A03(130, 10, 94).equals(C5C.A06) || A03(111, 8, 72).equals(C5C.A06)) && (A03(140, 22, 117).equals(str) || A03(162, 29, 74).equals(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0K(String str) {
        if (A03(227, 26, 94).equals(str) && A03(527, 5, 83).equals(C5C.A03)) {
            return false;
        }
        return true;
    }

    public static boolean A0L(String str, int i) {
        if (A03(751, 10, 121).equals(str) && 2 == i) {
            if (A03(539, 8, 36).equals(C5C.A03) || A03(521, 6, 9).equals(C5C.A03)) {
                return true;
            }
        }
        return false;
    }

    public static MediaCodecInfo.CodecProfileLevel[] A0M(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int level;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue = 0;
        if (codecCapabilities != null && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
            Integer num = (Integer) videoCapabilities.getBitrateRange().getUpper();
            if (A0C[0].charAt(21) != 'A') {
                throw new RuntimeException();
            }
            A0C[0] = "QcEMGW7v0Yxqh7XLcQ4xIAQDDerowqhX";
            iIntValue = num.intValue();
        }
        if (iIntValue >= 180000000) {
            level = 1024;
        } else if (iIntValue >= 120000000) {
            level = 512;
        } else if (iIntValue >= 60000000) {
            level = 256;
        } else if (iIntValue >= 30000000) {
            level = 128;
        } else if (iIntValue >= 18000000) {
            level = 64;
        } else {
            if (A0C[0].charAt(21) != 'A') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[7] = "cnj1P9QIvdvvlmM3jq4NJ";
            strArr[5] = "0LKKsHUxH9Ew65kXLPhVQ5r";
            if (iIntValue >= 12000000) {
                level = 32;
            } else if (iIntValue >= 7200000) {
                level = 16;
            } else if (iIntValue >= 3600000) {
                level = 8;
            } else if (iIntValue >= 1800000) {
                level = 4;
            } else if (iIntValue >= 800000) {
                level = 2;
            } else {
                level = 1;
            }
        }
        MediaCodecInfo.CodecProfileLevel profileLevel = new MediaCodecInfo.CodecProfileLevel();
        profileLevel.profile = 1;
        profileLevel.level = level;
        return new MediaCodecInfo.CodecProfileLevel[]{profileLevel};
    }

    public final Point A0N(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (this.A00 == null || (videoCapabilities = this.A00.getVideoCapabilities()) == null) {
            return null;
        }
        return A01(videoCapabilities, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C6L A0O(C1981qI c1981qI, C1981qI c1981qI2) {
        int i = C5C.A1E(c1981qI.A0W, c1981qI2.A0W) ? 0 : 0 | 8;
        if (this.A0A) {
            int discardReasons = c1981qI.A0F;
            if (discardReasons != c1981qI2.A0F) {
                i |= 1024;
            }
            if (!this.A04) {
                int discardReasons2 = c1981qI.A0L;
                if (discardReasons2 == c1981qI2.A0L) {
                    int discardReasons3 = c1981qI.A0A;
                    if (discardReasons3 != c1981qI2.A0A) {
                        i |= 512;
                    }
                }
            }
            if (!C5C.A1E(c1981qI.A0N, c1981qI2.A0N)) {
                i |= 2048;
            }
            if (A0I(this.A03) && !c1981qI.A0A(c1981qI2)) {
                i |= 2;
            }
            if (i == 0) {
                String str = this.A03;
                int i2 = c1981qI.A0A(c1981qI2) ? 3 : 2;
                if (A0C[0].charAt(21) != 'A') {
                    throw new RuntimeException();
                }
                String[] strArr = A0C;
                strArr[7] = "2o9LDR7wht3djkkWSozFp";
                strArr[5] = "xzNY8imEyNfCiAqEOIotcML";
                return new C6L(str, c1981qI, c1981qI2, i2, 0);
            }
        } else {
            int discardReasons4 = c1981qI.A06;
            if (discardReasons4 != c1981qI2.A06) {
                i |= 4096;
            }
            int discardReasons5 = c1981qI.A0G;
            if (discardReasons5 != c1981qI2.A0G) {
                i |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
            }
            int discardReasons6 = c1981qI.A0C;
            if (discardReasons6 != c1981qI2.A0C) {
                i |= 16384;
            }
            if (i == 0 && A03(371, 15, 53).equals(this.A02)) {
                Pair<Integer, Integer> pairA0B = C0373Ba.A0B(c1981qI);
                Pair<Integer, Integer> pairA0B2 = C0373Ba.A0B(c1981qI2);
                if (pairA0B != null && pairA0B2 != null) {
                    int iIntValue = ((Integer) pairA0B.first).intValue();
                    int iIntValue2 = ((Integer) pairA0B2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new C6L(this.A03, c1981qI, c1981qI2, 3, 0);
                    }
                }
            }
            if (!c1981qI.A0A(c1981qI2)) {
                i |= 32;
            }
            if (A0H(this.A02)) {
                i |= 2;
            }
            if (i == 0) {
                return new C6L(this.A03, c1981qI, c1981qI2, 1, 0);
            }
        }
        return new C6L(this.A03, c1981qI, c1981qI2, 0, i);
    }

    public final boolean A0P(int i) {
        if (this.A00 == null) {
            A06(A03(451, 17, 59));
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.A00.getAudioCapabilities();
        if (audioCapabilities == null) {
            A06(A03(433, 18, 124));
            return false;
        }
        if (A00(this.A03, this.A02, audioCapabilities.getMaxInputChannelCount()) < i) {
            A06(A03(468, 22, 78) + i);
            return false;
        }
        return true;
    }

    public final boolean A0Q(int i) {
        if (this.A00 == null) {
            A06(A03(563, 15, 4));
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.A00.getAudioCapabilities();
        if (audioCapabilities == null) {
            A06(A03(547, 16, 88));
            return false;
        }
        if (!audioCapabilities.isSampleRateSupported(i)) {
            A06(A03(578, 20, 107) + i);
            return false;
        }
        return true;
    }

    public final boolean A0R(int i, int i2, double d) {
        if (this.A00 == null) {
            if (A0C[4].length() != 17) {
                throw new RuntimeException();
            }
            A0C[1] = "VtsIfpRARdWM2RcSD8UT7BsOJP98i2Mb";
            A06(A03(613, 16, 15));
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.A00.getVideoCapabilities();
        if (videoCapabilities == null) {
            A06(A03(690, 17, 13));
            return false;
        }
        int i3 = C5C.A02;
        String strA03 = A03(9, 1, 116);
        String strA032 = A03(780, 1, 62);
        if (i3 >= 29) {
            int iA00 = B1.A00(videoCapabilities, i, i2, d);
            if (iA00 == 2) {
                return true;
            }
            if (iA00 == 1) {
                A06(A03(629, 19, 41) + i + strA032 + i2 + strA03 + d);
                return false;
            }
        }
        if (!A0F(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !A0K(this.A03) || !A0F(videoCapabilities, i2, i, d)) {
                A06(A03(669, 21, 113) + i + strA032 + i2 + strA03 + d);
                return false;
            }
            A05(A03(648, 21, 5) + i + strA032 + i2 + strA03 + d);
        }
        return true;
    }

    @MetaExoPlayerCustomization(type = {"DEPRECATED_LOGIC"}, value = "D51676338: Control Renderer Support behavior")
    public final boolean A0S(C1981qI c1981qI) {
        String strA07;
        if (c1981qI.A0R == null || this.A02 == null || (strA07 = C3J.A07(c1981qI.A0R)) == null) {
            return true;
        }
        String codecMimeType = this.A02;
        if (!codecMimeType.equals(strA07)) {
            StringBuilder sb = new StringBuilder();
            String codecMimeType2 = A03(490, 11, 76);
            StringBuilder sbAppend = sb.append(codecMimeType2);
            String codecMimeType3 = c1981qI.A0R;
            StringBuilder sbAppend2 = sbAppend.append(codecMimeType3);
            String codecMimeType4 = A03(4, 2, 43);
            A06(sbAppend2.append(codecMimeType4).append(strA07).toString());
            return false;
        }
        return A0G(c1981qI, true);
    }

    public final boolean A0T(C1981qI c1981qI) {
        if (this.A0A) {
            boolean z = this.A04;
            if (A0C[1].charAt(21) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[7] = "p6ujkjtFWGTlktsjRzxuv";
            strArr[5] = "iao6hIdGkkUEjHJmkTON0Ul";
            return z;
        }
        Pair<Integer, Integer> profileLevel = C0373Ba.A0B(c1981qI);
        return profileLevel != null && ((Integer) profileLevel.first).intValue() == 42;
    }

    @Deprecated
    public final boolean A0U(C1981qI c1981qI, C1981qI c1981qI2, boolean z) {
        if (!z && c1981qI.A0N != null) {
            ColorInfo colorInfo = c1981qI2.A0N;
            String[] strArr = A0C;
            if (strArr[7].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A0C[2] = "CiueF8sE";
            if (colorInfo == null) {
                c1981qI2 = c1981qI2.A07().A0t(c1981qI.A0N).A14();
            }
        }
        int i = A0O(c1981qI, c1981qI2).A01;
        return i == 2 || i == 3;
    }

    public final MediaCodecInfo.CodecProfileLevel[] A0V() {
        if (this.A00 == null || this.A00.profileLevels == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (A0C[2].length() != 8) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[7] = "wYBsKMorArWFj72U1vIrO";
        strArr[5] = "2GYgXVRgmEsc3DaR9LQ86J2";
        return codecCapabilities.profileLevels;
    }

    public final String toString() {
        return this.A03;
    }
}
