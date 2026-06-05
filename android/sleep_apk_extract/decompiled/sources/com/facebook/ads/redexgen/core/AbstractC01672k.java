package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC01672k {
    public static byte[] A00;
    public static String[] A01 = {"sOrNj5Mdy4xi0kLPibyeSfiWQxOima4U", "xj48Y1LQ4ko", "eUY0SVXtYBJtN83XOuXTnKZfqvTHosXd", "paDpwp97WdTEiWCS91q7LcvTv3rNjzy2", "ATE3aiPBn3N", "z3W8kbtrqKRemiiFleAuTjlgcuTfL08m", "RcLeq9wITz99Drk9X88RRLyniy3v1DlZ", "ZhckCEJ2n6PA9tAuxk3fuT"};

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{49, 126, 126, 124, 102, 41, 43, 123, 4, 75, 73, 30, 124, 51, 54, 38, 33, 57, 118, 122, 101, 23, 88, 79, 80, 80, 29, 19, 24, 17, 90, 92, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 69, 79, 66, 64, 126, 54, 60, 38, 126, 58, 32, 53, 55, 113, 53, 47, 56, 118, 53, 106, 40, 0, 67, 26, 33, 98, 102, 107, 5, 70, 66, 79, 66, 90, 25, 31, 97, 34, 63, 124, 58, 121, 100, 32, 5, 70, 91, 78, 76, 34, 97, 124, 107, 58, 123, 115, 88, 25, 6, 3, 5, 102, 56, 59, 80, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 19, 24, 44, 118, 113, 78, 22, 20, 20, 82, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 29, 10, 81, 8, 30, 9, 26, 47, 118, 100, 99, 108, 57, 96, 114, 117, 97, 99, 99, 65, 109, 108, 118, 103, 108, 118, 47, 86, 123, 114, 103, 74, 91, 91, 71, 66, 72, 74, 95, 66, 68, 69, 4, 70, 91, 31, 18, 3, 3, 31, 26, 16, 18, 7, 26, 28, 29, 92, 4, 22, 17, 30, 54, 34, 51, 62, 56, 120, 100, 48, 39, 39, 86, 66, 83, 94, 88, 24, 86, 84, 4, 73, 93, 76, 65, 71, 7, 73, 75, 28, 2, 22, 7, 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 76, 2, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 17, 96, 116, 101, 104, 110, 46, 96, 108, 115, 44, 118, 99, 98, 118, 103, 106, 108, 44, 102, 98, 96, 48, 57, 45, 60, 49, 55, 119, 61, 57, 59, 107, 117, 50, 55, 59, 32, 52, 37, 40, 46, 110, 39, 45, 32, 34, 28, 8, 25, 20, 18, 82, 16, 20, 25, 20, 48, 36, 53, 56, 62, 126, 60, 33, 101, 85, 65, 80, 93, 91, 27, 89, 68, 81, 83, 34, 54, 39, 42, 44, 108, 44, 36, 36, 40, 60, 45, 32, 38, 102, 62, 40, 63, 117, 97, 112, 125, 123, 59, 99, 113, 118, 121, 56, 44, 61, 48, 54, 118, 33, 116, 52, 56, 45, 43, 54, 42, 50, 56, 84, 80, 92, 90, 88, 18, 87, 77, 88, 90, 69, 84, 73, 69, 30, 71, 69, 69, 36, 59, 54, 55, 61, 125, 63, 34, 96, 34, 32, 63, 50, 51, 57, 121, 59, 38, 100, 34, 55, 40, 37, 36, 46, 110, 44, 49, 117, 113, 110, 99, 98, 104, 40, 112, 98, 101, 106, 101, 122, 119, 118, 124, 60, 107, 62, 117, 127, 101, 104, 119, 122, 123, 113, 49, 102, 51, 115, 127, 106, 108, 113, 109, 117, 127, 50, 45, 32, 33, 43, 107, 60, 105, 41, 55, 50, 45, 32, 33, 43};
    }

    static {
        A04();
    }

    public static int A00(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        String filename = A03(4, 4, 104);
        if (!lastPathSegment.endsWith(filename)) {
            String filename2 = A03(29, 4, 31);
            if (!lastPathSegment.endsWith(filename2)) {
                String filename3 = A03(8, 4, 10);
                if (lastPathSegment.endsWith(filename3)) {
                    return 1;
                }
                String filename4 = A03(12, 5, 114);
                if (lastPathSegment.endsWith(filename4)) {
                    return 2;
                }
                String filename5 = A03(0, 4, 63);
                if (lastPathSegment.endsWith(filename5)) {
                    return 2;
                }
                String filename6 = A03(17, 4, 55);
                if (lastPathSegment.endsWith(filename6)) {
                    return 3;
                }
                String filename7 = A03(33, 5, 3);
                if (lastPathSegment.endsWith(filename7)) {
                    return 4;
                }
                String filename8 = A03(38, 4, 112);
                if (lastPathSegment.endsWith(filename8)) {
                    return 5;
                }
                String filename9 = A03(58, 4, 47);
                if (!lastPathSegment.endsWith(filename9)) {
                    String filename10 = A03(62, 5, 11);
                    if (!lastPathSegment.endsWith(filename10)) {
                        String filename11 = A03(98, 4, 94);
                        if (lastPathSegment.endsWith(filename11)) {
                            return 15;
                        }
                        int length = lastPathSegment.length();
                        String strA03 = A03(67, 3, 84);
                        if (!lastPathSegment.startsWith(strA03, length - (strA03.length() + 1))) {
                            String filename12 = A03(118, 5, 33);
                            if (lastPathSegment.endsWith(filename12)) {
                                return 6;
                            }
                            String filename13 = A03(70, 4, 111);
                            if (lastPathSegment.endsWith(filename13)) {
                                return 7;
                            }
                            String strA032 = A03(74, 4, 52);
                            if (!lastPathSegment.endsWith(strA032)) {
                                int length2 = lastPathSegment.length();
                                String strA033 = A03(55, 3, 14);
                                if (!lastPathSegment.startsWith(strA033, length2 - (strA033.length() + 1)) && !lastPathSegment.startsWith(strA032, lastPathSegment.length() - (strA032.length() + 1))) {
                                    int length3 = lastPathSegment.length();
                                    String strA034 = A03(25, 4, 94);
                                    if (lastPathSegment.startsWith(strA034, length3 - (strA034.length() + 1))) {
                                        return 8;
                                    }
                                    int length4 = lastPathSegment.length();
                                    String strA035 = A03(87, 3, 52);
                                    if (!lastPathSegment.startsWith(strA035, length4 - (strA035.length() + 1))) {
                                        String filename14 = A03(90, 5, 86);
                                        if (lastPathSegment.endsWith(filename14)) {
                                            return 9;
                                        }
                                        String filename15 = A03(95, 3, 104);
                                        if (!lastPathSegment.endsWith(filename15)) {
                                            String filename16 = A03(78, 5, 11);
                                            if (!lastPathSegment.endsWith(filename16)) {
                                                String filename17 = A03(83, 4, 44);
                                                if (!lastPathSegment.endsWith(filename17)) {
                                                    String filename18 = A03(51, 4, 120);
                                                    if (!lastPathSegment.endsWith(filename18)) {
                                                        String strA036 = A03(102, 3, 34);
                                                        if (lastPathSegment.endsWith(strA036) || lastPathSegment.startsWith(strA036, lastPathSegment.length() - (strA036.length() + 1))) {
                                                            return 11;
                                                        }
                                                        String filename19 = A03(109, 4, 92);
                                                        if (lastPathSegment.endsWith(filename19)) {
                                                            return 12;
                                                        }
                                                        String filename20 = A03(113, 5, 95);
                                                        if (lastPathSegment.endsWith(filename20)) {
                                                            return 12;
                                                        }
                                                        String filename21 = A03(105, 4, 64);
                                                        if (lastPathSegment.endsWith(filename21)) {
                                                            return 13;
                                                        }
                                                        String[] strArr = A01;
                                                        if (strArr[0].charAt(20) == strArr[5].charAt(20)) {
                                                            throw new RuntimeException();
                                                        }
                                                        String[] strArr2 = A01;
                                                        strArr2[2] = "SyPKArUiofAKtDYOeehIfh1mrOq04kE4";
                                                        strArr2[3] = "xM2ROt7CFYmp4WclnHzUErJdjCgsEFHY";
                                                        String filename22 = A03(123, 7, 55);
                                                        if (lastPathSegment.endsWith(filename22)) {
                                                            return 13;
                                                        }
                                                        String filename23 = A03(47, 4, 127);
                                                        if (lastPathSegment.endsWith(filename23)) {
                                                            return 14;
                                                        }
                                                        String filename24 = A03(42, 5, 112);
                                                        if (lastPathSegment.endsWith(filename24)) {
                                                            return 14;
                                                        }
                                                        String filename25 = A03(21, 4, 25);
                                                        if (!lastPathSegment.endsWith(filename25)) {
                                                            return -1;
                                                        }
                                                        return 16;
                                                    }
                                                }
                                            }
                                        }
                                        String[] strArr3 = A01;
                                        if (strArr3[0].charAt(20) != strArr3[5].charAt(20)) {
                                            String[] strArr4 = A01;
                                            strArr4[0] = "1wRaS2qHbg36RBVDXd8PcZR43XT5miNJ";
                                            strArr4[5] = "Vak8xJBIlxZA7GdMxsEEJaTmiAiwlk64";
                                            return 10;
                                        }
                                        String[] strArr5 = A01;
                                        strArr5[2] = "I1Nt4MatJPh6S3ZRGQ5jEYQUJm5selco";
                                        strArr5[3] = "WdisFFcNpT7R4JXqf39409YvWJDYYP5x";
                                        return 10;
                                    }
                                    return 9;
                                }
                                return 8;
                            }
                            return 8;
                        }
                        return 6;
                    }
                    return 15;
                }
                return 15;
            }
        }
        String[] strArr6 = A01;
        if (strArr6[2].charAt(16) == strArr6[3].charAt(16)) {
            throw new RuntimeException();
        }
        A01[7] = "O7R9Zztw2xxmA6l6DOopzc";
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0271 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0272 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0273 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0274 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0275 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0276 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0277 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0278 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0279 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x027a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x027b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x026c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x026d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x026e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x026f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0270 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d A[RETURN] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1095)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1120)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A01(java.lang.String r24) {
        /*
            Method dump skipped, instruction units count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC01672k.A01(java.lang.String):int");
    }

    public static int A02(Map<String, List<String>> responseHeaders) {
        List<String> list = responseHeaders.get(A03(130, 12, 34));
        return A01((list == null || list.isEmpty()) ? null : list.get(0));
    }
}
