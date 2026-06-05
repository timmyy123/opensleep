package com.facebook.ads.redexgen.core;

import android.util.Base64;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.flac.PictureFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.vorbis.VorbisComment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0535Hk {
    public static byte[] A00;
    public static String[] A01 = {"AQUfun8uWtpAPz6T54JXA8DVdz19i7cg", "A9xQ060X7I53O0IPhfx7pChTdPn89BVs", "HA6OUY8aFXslM4giueBriDg2S", "9RrkKnX7ioGd8UIKmUAG7ayOJ1mW6fCZ", "mjtW7HF4JFIVQBQAuWhSkP1cuiqQ", "mMlJtFouJ3Md3SAWQWV0HJ1iYftjtiDS", "", "7UUPgjEseHhf3IW21ENlLsXr9tr9mert"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 16 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C0534Hj A06(C02284v c02284v) throws C3K {
        A0C(1, c02284v, false);
        int iA0F = c02284v.A0F();
        int iA0I = c02284v.A0I();
        int iA0F2 = c02284v.A0F();
        int iA0E = c02284v.A0E();
        if (iA0E <= 0) {
            iA0E = -1;
        }
        int iA0E2 = c02284v.A0E();
        if (iA0E2 <= 0) {
            iA0E2 = -1;
        }
        int iA0E3 = c02284v.A0E();
        if (iA0E3 <= 0) {
            iA0E3 = -1;
            String[] strArr = A01;
            if (strArr[6].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "";
            strArr2[4] = "hx6vx8O5nOwfxHxHuzSsxOXMbdPf";
        }
        int iA0I2 = c02284v.A0I();
        return new C0534Hj(iA0F, iA0I, iA0F2, iA0E, iA0E2, iA0E3, (int) Math.pow(2.0d, iA0I2 & 15), (int) Math.pow(2.0d, (iA0I2 & 240) >> 4), (c02284v.A0I() & 1) > 0, Arrays.copyOf(c02284v.A0l(), c02284v.A0A()));
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 110);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{107, 25, 62, 54, 51, 58, 59, 127, 43, 48, 127, 47, 62, 45, 44, 58, 127, 9, 48, 45, 61, 54, 44, 127, 60, 48, 50, 50, 58, 49, 43, 101, 127, 40, 15, 7, 2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, 78, 26, 1, 78, 30, 15, 28, 29, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 78, 24, 1, 28, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 7, 29, 78, 30, 7, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 26, 27, 28, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 118, 126, 111, 122, 127, 122, 111, 122, 100, 121, 119, 116, 120, 112, 100, 107, 114, 120, 111, 110, 105, 126, 62, 7, 26, 10, 1, 27, 61, 28, 1, 4, 58, 39, 47, 58, 60, 43, 58, 59, 127, 60, 55, 62, 45, 62, 60, 43, 58, 45, 44, 127, 120, 41, 48, 45, 61, 54, 44, 120, 64, 93, 85, 64, 70, 81, 64, 65, 5, 70, 74, 65, 64, 5, 71, 74, 74, 78, 5, 81, 74, 5, 86, 81, 68, 87, 81, 5, 82, 76, 81, 77, 5, 126, 21, 93, 16, 19, 9, 5, 21, 93, 17, 22, 9, 5, 21, 93, 17, 23, 120, 5, 68, 81, 5, 62, 35, 43, 62, 56, 47, 62, 63, 123, 51, 62, 58, 63, 62, 41, 123, 47, 34, 43, 62, 123, 107, 97, 98, 98, 127, 45, 121, 116, 125, 104, 45, 106, 127, 104, 108, 121, 104, 127, 45, 121, 101, 108, 99, 45, 60, 45, 99, 98, 121, 45, 105, 104, 110, 98, 105, 108, 111, 97, 104, 55, 45, 97, 117, 102, 106, 110, 105, 96, 39, 101, 110, 115, 39, 102, 97, 115, 98, 117, 39, 106, 104, 99, 98, 116, 39, 105, 104, 115, 39, 116, 98, 115, 39, 102, 116, 39, 98, 127, 119, 98, 100, 115, 98, 99, 38, 50, 33, 45, 41, 46, 39, 96, 34, 41, 52, 96, 37, 56, 48, 37, 35, 52, 37, 36, 96, 52, 47, 96, 34, 37, 96, 51, 37, 52, 2, 1, 1, 5, 27, 30, 78, 26, 23, 30, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 78, 9, 28, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 15, 26, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 28, 78, 26, 6, 15, 0, 78, 92, 78, 0, 1, 26, 78, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 1, 10, 15, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 84, 78, 56, 52, 37, 37, 60, 59, 50, 117, 33, 44, 37, 48, 117, 58, 33, 61, 48, 39, 117, 33, 61, 52, 59, 117, 101, 117, 59, 58, 33, 117, 38, 32, 37, 37, 58, 39, 33, 48, 49, 111, 117, 108, 112, 125, 127, 121, 116, 115, 112, 120, 121, 110, 60, 115, 122, 60, 104, 117, 113, 121, 60, 120, 115, 113, 125, 117, 114, 60, 104, 110, 125, 114, 111, 122, 115, 110, 113, 111, 60, 114, 115, 104, 60, 102, 121, 110, 115, 121, 120, 60, 115, 105, 104, 64, 87, 65, 91, 86, 71, 87, 102, 75, 66, 87, 18, 85, 64, 87, 83, 70, 87, 64, 18, 70, 90, 83, 92, 18, 0, 18, 91, 65, 18, 92, 93, 70, 18, 86, 87, 81, 93, 86, 83, 80, 94, 87, 93, 70, 9, 91, 76, 90, 76, 91, 95, 76, 77, 9, 75, 64, 93, 90, 9, 68, 92, 90, 93, 9, 75, 76, 9, 83, 76, 91, 70, 9, 72, 79, 93, 76, 91, 9, 68, 72, 89, 89, 64, 71, 78, 9, 74, 70, 92, 89, 69, 64, 71, 78, 9, 90, 93, 76, 89, 90, 16, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 68, 23, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 22, 16, 68, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 1, 5, 0, 1, 22, 94, 68};
    }

    static {
        A08();
    }

    public static int A00(int i) {
        int val = 0;
        while (i > 0) {
            val++;
            i >>>= 1;
        }
        return val;
    }

    public static long A01(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    public static Metadata A02(List<String> list) {
        List<String> vorbisComments = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] strArrA1P = C5C.A1P(str, A07(0, 1, 56));
            int length = strArrA1P.length;
            String strA07 = A07(85, 10, 6);
            if (length != 2) {
                AbstractC02134g.A07(strA07, A07(1, 32, 49) + str);
            } else {
                String[] strArr = A01;
                String str2 = strArr[6];
                String str3 = strArr[4];
                int i2 = str2.length();
                if (i2 == str3.length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[6] = "";
                strArr2[4] = "IFt3u6Tbn0k1mtPtGSJYRwNJh6dv";
                if (strArrA1P[0].equals(A07(63, 22, 85))) {
                    try {
                        vorbisComments.add(PictureFrame.A00(new C02284v(Base64.decode(strArrA1P[1], 0))));
                    } catch (RuntimeException e) {
                        AbstractC02134g.A0A(strA07, A07(33, 30, 0), e);
                    }
                } else {
                    vorbisComments.add(new VorbisComment(strArrA1P[0], strArrA1P[1]));
                }
            }
        }
        if (vorbisComments.isEmpty()) {
            return null;
        }
        return new Metadata(vorbisComments);
    }

    /* JADX WARN: Incorrect condition in loop: B:25:0x009f */
    /* JADX WARN: Incorrect condition in loop: B:8:0x0026 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0531Hg A03(C0530Hf c0530Hf) throws C3K {
        long jA01;
        if (c0530Hf.A02(24) == 5653314) {
            int iA02 = c0530Hf.A02(16);
            int lookupType = c0530Hf.A02(24);
            long[] jArr = new long[lookupType];
            boolean zA04 = c0530Hf.A04();
            if (!zA04) {
                boolean zA042 = c0530Hf.A04();
                for (int i = 0; i < entries; i++) {
                    if (zA042) {
                        if (c0530Hf.A04()) {
                            int entries = c0530Hf.A02(5);
                            jArr[i] = entries + 1;
                        } else {
                            String[] strArr = A01;
                            String str = strArr[7];
                            String str2 = strArr[0];
                            int dimensions = str.charAt(2);
                            int entries2 = str2.charAt(2);
                            if (dimensions != entries2) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A01;
                            strArr2[7] = "HkUiXrMYXoP7dmmSwm7TlUKenEWhRSa7";
                            strArr2[0] = "g3UzzRsN8l9NwZbA9Pl4zDU4WOGu2UFV";
                            jArr[i] = 0;
                        }
                    } else {
                        int i2 = c0530Hf.A02(5);
                        String[] strArr3 = A01;
                        String str3 = strArr3[6];
                        String str4 = strArr3[4];
                        int dimensions2 = str3.length();
                        int entries3 = str4.length();
                        if (dimensions2 != entries3) {
                            String[] strArr4 = A01;
                            strArr4[3] = "YIXxF7uzVQ2KRDIuTFnKuNVMBeAy43Wm";
                            strArr4[1] = "ZNrvF1xji8SwPYIxx9WGKrLEtje0Ya68";
                            jArr[i] = i2 + 1;
                        } else {
                            A01[2] = "PN1PQj6gHBTdVMYKSOEyBSZrD";
                            jArr[i] = i2 + 1;
                        }
                    }
                }
            } else {
                int i3 = c0530Hf.A02(5);
                int i4 = i3 + 1;
                int i5 = 0;
                while (i5 < entries) {
                    int entries4 = lookupType - i5;
                    int iA022 = c0530Hf.A02(A00(entries4));
                    for (int length = 0; length < iA022; length++) {
                        int entries5 = jArr.length;
                        if (i5 < entries5) {
                            jArr[i5] = i4;
                            i5++;
                        }
                    }
                    i4++;
                }
            }
            int iA023 = c0530Hf.A02(4);
            if (iA023 <= 2) {
                if (iA023 == 1 || iA023 == 2) {
                    c0530Hf.A03(32);
                    c0530Hf.A03(32);
                    int iA024 = c0530Hf.A02(4) + 1;
                    c0530Hf.A03(1);
                    if (iA023 == 1) {
                        if (iA02 == 0) {
                            jA01 = 0;
                        } else {
                            long j = lookupType;
                            String[] strArr5 = A01;
                            String str5 = strArr5[3];
                            String str6 = strArr5[1];
                            int dimensions3 = str5.charAt(14);
                            int entries6 = str6.charAt(14);
                            if (dimensions3 != entries6) {
                                throw new RuntimeException();
                            }
                            A01[5] = "D9mmqqJmTqnxQ2dihdU3MUH7YK6oq28f";
                            jA01 = A01(j, iA02);
                        }
                    } else {
                        jA01 = ((long) lookupType) * ((long) iA02);
                    }
                    int entries7 = (int) (((long) iA024) * jA01);
                    c0530Hf.A03(entries7);
                }
                return new C0531Hg(iA02, lookupType, jArr, iA023, zA04);
            }
            throw C3K.A01(A07(313, 42, 0) + iA023, null);
        }
        throw C3K.A01(A07(123, 55, 75) + c0530Hf.A01(), null);
    }

    public static C0532Hh A04(C02284v c02284v) throws C3K {
        return A05(c02284v, true, true);
    }

    /* JADX WARN: Incorrect condition in loop: B:6:0x0025 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0532Hh A05(C02284v c02284v, boolean z, boolean z2) throws C3K {
        if (z) {
            A0C(3, c02284v, false);
        }
        int length = (int) c02284v.A0O();
        String strA0W = c02284v.A0W(length);
        int length2 = strA0W.length();
        int i = 7 + 4 + length2;
        long jA0O = c02284v.A0O();
        int length3 = (int) jA0O;
        String[] comments = new String[length3];
        int i2 = i + 4;
        int i3 = 0;
        while (commentListLen < jA0O) {
            long commentListLen = c02284v.A0O();
            int length4 = (int) commentListLen;
            comments[i3] = c02284v.A0W(length4);
            int length5 = comments[i3].length();
            i2 = i2 + 4 + length5;
            i3++;
        }
        if (z2) {
            int length6 = c02284v.A0I();
            if ((length6 & 1) == 0) {
                String vendor = A07(283, 30, 46);
                throw C3K.A01(vendor, null);
            }
        }
        return new C0532Hh(strA0W, comments, i2 + 1);
    }

    public static void A09(int i, C0530Hf c0530Hf) throws C3K {
        int i2;
        int iA02 = c0530Hf.A02(6) + 1;
        for (int i3 = 0; i3 < iA02; i3++) {
            int iA022 = c0530Hf.A02(16);
            if (iA022 != 0) {
                AbstractC02134g.A05(A07(85, 10, 6), A07(355, 41, 59) + iA022);
            } else {
                if (c0530Hf.A04()) {
                    int iA023 = c0530Hf.A02(4);
                    String[] strArr = A01;
                    String str = strArr[7];
                    String str2 = strArr[0];
                    int iCharAt = str.charAt(2);
                    int mappingsCount = str2.charAt(2);
                    if (iCharAt != mappingsCount) {
                        throw new RuntimeException();
                    }
                    A01[5] = "MSIFAaOSOQQOpmu0PO7aKrLsJb3QFagu";
                    i2 = iA023 + 1;
                } else {
                    i2 = 1;
                }
                if (c0530Hf.A04()) {
                    int i4 = c0530Hf.A02(8);
                    int i5 = i4 + 1;
                    for (int i6 = 0; i6 < i5; i6++) {
                        int mappingsCount2 = i - 1;
                        c0530Hf.A03(A00(mappingsCount2));
                        int mappingsCount3 = i - 1;
                        c0530Hf.A03(A00(mappingsCount3));
                    }
                }
                int mappingsCount4 = c0530Hf.A02(2);
                if (mappingsCount4 == 0) {
                    if (i2 > 1) {
                        for (int mappingsCount5 = 0; mappingsCount5 < i; mappingsCount5++) {
                            c0530Hf.A03(4);
                        }
                    }
                    for (int i7 = 0; i7 < i2; i7++) {
                        c0530Hf.A03(8);
                        String[] strArr2 = A01;
                        String str3 = strArr2[6];
                        String str4 = strArr2[4];
                        int length = str3.length();
                        int mappingsCount6 = str4.length();
                        if (length == mappingsCount6) {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A01;
                        strArr3[3] = "W7H2tgam7pgMqyIqKZRQoufJib3tzvKG";
                        strArr3[1] = "g3J7gwvZXejdWYIpZtqDt0lnx57dRd6J";
                        c0530Hf.A03(8);
                        c0530Hf.A03(8);
                    }
                } else {
                    throw C3K.A01(A07(491, 58, 71), null);
                }
            }
        }
    }

    public static void A0A(C0530Hf c0530Hf) throws C3K {
        int iA02 = c0530Hf.A02(6) + 1;
        for (int i = 0; i < iA02; i++) {
            int iA022 = c0530Hf.A02(16);
            switch (iA022) {
                case 0:
                    c0530Hf.A03(8);
                    c0530Hf.A03(16);
                    c0530Hf.A03(16);
                    String[] strArr = A01;
                    String str = strArr[6];
                    String str2 = strArr[4];
                    int floorCount = str.length();
                    if (floorCount == str2.length()) {
                        throw new RuntimeException();
                    }
                    A01[2] = "puZWVQ2pTjmoQkTRd3XFOd7V6";
                    c0530Hf.A03(6);
                    c0530Hf.A03(8);
                    int iA023 = c0530Hf.A02(4) + 1;
                    for (int floorCount2 = 0; floorCount2 < iA023; floorCount2++) {
                        c0530Hf.A03(8);
                    }
                    break;
                    break;
                case 1:
                    int j = c0530Hf.A02(5);
                    int i2 = -1;
                    int[] partitionClassList = new int[j];
                    for (int floorCount3 = 0; floorCount3 < j; floorCount3++) {
                        partitionClassList[floorCount3] = c0530Hf.A02(4);
                        if (partitionClassList[floorCount3] > i2) {
                            i2 = partitionClassList[floorCount3];
                        }
                    }
                    int[] iArr = new int[i2 + 1];
                    for (int j2 = 0; j2 < iArr.length; j2++) {
                        iArr[j2] = c0530Hf.A02(3) + 1;
                        int iA024 = c0530Hf.A02(2);
                        if (iA024 > 0) {
                            c0530Hf.A03(8);
                        }
                        for (int floorCount4 = 0; floorCount4 < (1 << iA024); floorCount4++) {
                            c0530Hf.A03(8);
                        }
                    }
                    c0530Hf.A03(2);
                    int k = c0530Hf.A02(4);
                    int j3 = 0;
                    int rangeBits = 0;
                    for (int count = 0; count < j; count++) {
                        int idx = partitionClassList[count];
                        String[] strArr2 = A01;
                        String str3 = strArr2[7];
                        String str4 = strArr2[0];
                        int floorCount5 = str3.charAt(2);
                        if (floorCount5 != str4.charAt(2)) {
                            throw new RuntimeException();
                        }
                        A01[5] = "4gRGDU2vGyXCYhT5FVmyq5RWvUvygEh7";
                        j3 += iArr[idx];
                        while (rangeBits < j3) {
                            c0530Hf.A03(k);
                            rangeBits++;
                        }
                    }
                    break;
                default:
                    throw C3K.A01(A07(199, 41, 99) + iA022, null);
            }
        }
    }

    public static void A0B(C0530Hf c0530Hf) throws C3K {
        int iA02 = c0530Hf.A02(6) + 1;
        for (int i = 0; i < iA02; i++) {
            int residueCount = c0530Hf.A02(16);
            if (residueCount <= 2) {
                c0530Hf.A03(24);
                c0530Hf.A03(24);
                c0530Hf.A03(24);
                int iA022 = c0530Hf.A02(6) + 1;
                c0530Hf.A03(8);
                int[] iArr = new int[iA022];
                for (int i2 = 0; i2 < iA022; i2++) {
                    int residueCount2 = 0;
                    int iA023 = c0530Hf.A02(3);
                    if (c0530Hf.A04()) {
                        String[] strArr = A01;
                        String str = strArr[7];
                        String str2 = strArr[0];
                        int residueCount3 = str.charAt(2);
                        if (residueCount3 != str2.charAt(2)) {
                            throw new RuntimeException();
                        }
                        A01[5] = "QebxPehykfYMwUhUEUOD533arJF7pEEp";
                        residueCount2 = c0530Hf.A02(5);
                    }
                    iArr[i2] = (residueCount2 * 8) + iA023;
                }
                for (int i3 = 0; i3 < iA022; i3++) {
                    for (int i4 = 0; i4 < 8; i4++) {
                        int residueCount4 = iArr[i3];
                        if ((residueCount4 & (1 << i4)) != 0) {
                            c0530Hf.A03(8);
                        }
                    }
                }
            } else {
                throw C3K.A01(A07(448, 43, 92), null);
            }
        }
    }

    public static boolean A0C(int i, C02284v c02284v, boolean z) throws C3K {
        if (c02284v.A07() < 7) {
            if (z) {
                return false;
            }
            throw C3K.A01(A07(549, 18, 10) + c02284v.A07(), null);
        }
        if (c02284v.A0I() != i) {
            if (z) {
                return false;
            }
            throw C3K.A01(A07(178, 21, 53) + Integer.toHexString(i), null);
        }
        if (c02284v.A0I() != 118 || c02284v.A0I() != 111 || c02284v.A0I() != 114 || c02284v.A0I() != 98 || c02284v.A0I() != 105 || c02284v.A0I() != 115) {
            if (z) {
                return false;
            }
            throw C3K.A01(A07(95, 28, 49), null);
        }
        return true;
    }

    public static C0533Hi[] A0D(C02284v c02284v, int i) throws C3K {
        A0C(5, c02284v, false);
        int iA0I = c02284v.A0I() + 1;
        C0530Hf c0530Hf = new C0530Hf(c02284v.A0l());
        int numberOfBooks = c02284v.A09();
        c0530Hf.A03(numberOfBooks * 8);
        for (int numberOfBooks2 = 0; numberOfBooks2 < iA0I; numberOfBooks2++) {
            A03(c0530Hf);
        }
        int numberOfBooks3 = c0530Hf.A02(6);
        int timeCount = numberOfBooks3 + 1;
        for (int i2 = 0; i2 < timeCount; i2++) {
            int numberOfBooks4 = c0530Hf.A02(16);
            if (numberOfBooks4 != 0) {
                throw C3K.A01(A07(396, 52, 114), null);
            }
        }
        A0A(c0530Hf);
        A0B(c0530Hf);
        A09(i, c0530Hf);
        C0533Hi[] c0533HiArrA0E = A0E(c0530Hf);
        if (c0530Hf.A04()) {
            return c0533HiArrA0E;
        }
        throw C3K.A01(A07(240, 43, 105), null);
    }

    public static C0533Hi[] A0E(C0530Hf c0530Hf) {
        int iA02 = c0530Hf.A02(6) + 1;
        C0533Hi[] c0533HiArr = new C0533Hi[iA02];
        for (int windowType = 0; windowType < iA02; windowType++) {
            boolean zA04 = c0530Hf.A04();
            int iA022 = c0530Hf.A02(16);
            int i = c0530Hf.A02(16);
            c0533HiArr[windowType] = new C0533Hi(zA04, iA022, i, c0530Hf.A02(8));
        }
        return c0533HiArr;
    }
}
