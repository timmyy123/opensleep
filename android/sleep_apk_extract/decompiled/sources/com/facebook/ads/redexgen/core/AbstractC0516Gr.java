package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.DrmInitData;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0516Gr {
    public static byte[] A00;
    public static String[] A01 = {"Jtf4c9GAOgAJpDK2mVqEjBHHHDeO7jol", "kDsThcfbWymyo7SA47OqEnjsA64Naf4x", "cJoAWc4I2qPJ3tdp2oEUxn8HL8nWEytb", "qFOfekTrSk46i", "58lsU6cH4CrpheTwcdx0E4dGrWTfnMIv", "Xoqjc4jVEqoArq5wHw2izr92BVYhns54", "K2bZ7AvhLOnhV8b3rnKBJIfNWJInr7Ql", "H1rRYQzsJBGjD"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;
    public static final int[] A05;
    public static final int[] A06;
    public static final int[] A07;

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A00 = new byte[]{100, 112, 97, 108, 106, 42, 100, 102, 54, 107, 127, 110, 99, 101, 37, 111, 107, 105, 57, 39, 51, 34, 47, 41, 105, 35, 39, 37, 117, 107, 44, 41, 37};
    }

    static {
        A0B();
        A03 = new int[]{1, 2, 3, 6};
        A05 = new int[]{48000, 44100, 32000};
        A06 = new int[]{24000, 22050, 16000};
        A04 = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
        A02 = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
        A07 = new int[]{69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};
    }

    public static int A00(int i, int i2) {
        int sampleRate = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int halfFrmsizecod = A05.length;
        if (i >= halfFrmsizecod || i2 < 0) {
            return -1;
        }
        int halfFrmsizecod2 = A07.length;
        if (sampleRate >= halfFrmsizecod2) {
            return -1;
        }
        int i3 = A05[i];
        if (i3 == 44100) {
            int halfFrmsizecod3 = i2 % 2;
            return (A07[sampleRate] + halfFrmsizecod3) * 2;
        }
        int i4 = A02[sampleRate];
        String[] strArr = A01;
        String str = strArr[5];
        String str2 = strArr[0];
        int sampleRate2 = str.charAt(4);
        int halfFrmsizecod4 = str2.charAt(4);
        if (sampleRate2 != halfFrmsizecod4) {
            throw new RuntimeException();
        }
        A01[2] = "CpIhzBdts1JRjCy6aRe02MLhvkoBTutu";
        if (i3 == 32000) {
            int halfFrmsizecod5 = i4 * 6;
            return halfFrmsizecod5;
        }
        int halfFrmsizecod6 = i4 * 4;
        return halfFrmsizecod6;
    }

    public static int A01(int i, int i2, int i3) {
        return (i * i2) / (i3 * 32);
    }

    public static int A02(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int startIndex = byteBuffer.limit();
        int i = startIndex - 10;
        for (int i2 = iPosition; i2 <= i; i2++) {
            int startIndex2 = i2 + 4;
            int endIndex = C5C.A0F(byteBuffer, startIndex2) & (-2);
            if (endIndex == -126718022) {
                return i2 - iPosition;
            }
        }
        return -1;
    }

    public static int A03(ByteBuffer byteBuffer) {
        boolean isEac3 = ((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10;
        if (isEac3) {
            int numblkscod = ((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3;
            return A03[numblkscod] * 256;
        }
        return 1536;
    }

    public static int A04(ByteBuffer byteBuffer, int i) {
        boolean z = (byteBuffer.get((byteBuffer.position() + i) + 7) & 255) == 187;
        int iPosition = byteBuffer.position() + i;
        if (A01[2].charAt(30) != 't') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[7] = "2LNqrJlwnzIqb";
        strArr[3] = "f1x5AMhp2hTyk";
        return 40 << ((byteBuffer.get(iPosition + (z ? 9 : 8)) >> 4) & 7);
    }

    public static int A05(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        boolean isEac3 = ((bArr[5] & 248) >> 3) > 10;
        if (isEac3) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        int fscod = (bArr[4] & 192) >> 6;
        return A00(fscod, bArr[4] & 63);
    }

    public static int A06(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            return 40 << ((bArr[(bArr[7] & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
        }
        return 0;
    }

    public static C1981qI A07(C02284v c02284v, String str, String str2, DrmInitData drmInitData) {
        C02274u c02274u = new C02274u();
        c02274u.A0C(c02284v);
        int fscod = c02274u.A04(2);
        int constantBitrate = A05[fscod];
        c02274u.A09(8);
        int i = A04[c02274u.A04(3)];
        if (c02274u.A04(1) != 0) {
            i++;
        }
        int fscod2 = c02274u.A04(5);
        int halfFrmsizecod = A02[fscod2] * 1000;
        c02274u.A06();
        c02284v.A0f(c02274u.A02());
        return new C01722p().A0y(str).A11(A0A(0, 9, 4)).A0b(i).A0m(constantBitrate).A0u(drmInitData).A10(str2).A0a(halfFrmsizecod).A0j(halfFrmsizecod).A14();
    }

    public static C1981qI A08(C02284v c02284v, String str, String str2, DrmInitData drmInitData) {
        C02274u c02274u = new C02274u();
        c02274u.A0C(c02284v);
        int fscod = c02274u.A04(13) * 1000;
        c02274u.A09(3);
        int peakBitrate = c02274u.A04(2);
        int sampleRate = A05[peakBitrate];
        c02274u.A09(10);
        int channelCount = A04[c02274u.A04(3)];
        if (c02274u.A04(1) != 0) {
            channelCount++;
        }
        c02274u.A09(3);
        int iA04 = c02274u.A04(4);
        c02274u.A09(1);
        String[] strArr = A01;
        String str3 = strArr[5];
        String str4 = strArr[0];
        int peakBitrate2 = str3.charAt(4);
        if (peakBitrate2 != str4.charAt(4)) {
            throw new RuntimeException();
        }
        A01[6] = "mDbBoGQY4vpPxfXnFDb06caCJn7GdJsS";
        if (iA04 > 0) {
            c02274u.A0A(6);
            if (c02274u.A04(1) != 0) {
                channelCount += 2;
            }
            c02274u.A09(1);
        }
        String strA0A = A0A(9, 10, 11);
        int peakBitrate3 = c02274u.A01();
        if (peakBitrate3 > 7) {
            c02274u.A09(7);
            if (c02274u.A04(1) != 0) {
                strA0A = A0A(19, 14, 71);
            }
        }
        c02274u.A06();
        c02284v.A0f(c02274u.A02());
        return new C01722p().A0y(str).A11(strA0A).A0b(channelCount).A0m(sampleRate).A0u(drmInitData).A10(str2).A0j(fscod).A14();
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0515Gq A09(C02274u c02274u) {
        String strA0A;
        int iA01;
        int iA00;
        int i;
        int i2;
        int i3;
        int i4;
        int iA04;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int iA03 = c02274u.A03();
        c02274u.A09(40);
        boolean z = c02274u.A04(5) > 10;
        c02274u.A08(iA03);
        int i12 = -1;
        if (z) {
            c02274u.A09(16);
            switch (c02274u.A04(2)) {
                case 0:
                    i12 = 0;
                    break;
                case 1:
                    i12 = 1;
                    break;
                case 2:
                    i12 = 2;
                    break;
                default:
                    i12 = -1;
                    break;
            }
            c02274u.A09(3);
            iA00 = (c02274u.A04(11) + 1) * 2;
            int iA042 = c02274u.A04(2);
            if (iA042 == 3) {
                iA04 = 3;
                i2 = A06[c02274u.A04(2)];
                i5 = 6;
            } else {
                iA04 = c02274u.A04(2);
                i5 = A03[iA04];
                i2 = A05[iA042];
            }
            i3 = i5 * 256;
            iA01 = A01(iA00, i2, i5);
            int iA043 = c02274u.A04(3);
            boolean zA0H = c02274u.A0H();
            i4 = A04[iA043] + (zA0H ? 1 : 0);
            c02274u.A09(10);
            if (c02274u.A0H()) {
                c02274u.A09(8);
            }
            if (iA043 == 0) {
                c02274u.A09(5);
                if (c02274u.A0H()) {
                    c02274u.A09(8);
                }
            }
            if (i12 == 1 && c02274u.A0H()) {
                if (A01[6].charAt(2) == 'b') {
                    A01[2] = "EFtXQuggqvCecn8xtkL0dgnIAj4EDltD";
                    c02274u.A09(16);
                }
                throw new RuntimeException();
            }
            if (c02274u.A0H()) {
                if (iA043 > 2) {
                    c02274u.A09(2);
                }
                if ((iA043 & 1) != 0 && iA043 > 2) {
                    i9 = 6;
                    c02274u.A09(6);
                } else {
                    i9 = 6;
                }
                int i13 = iA043 & 4;
                if (A01[6].charAt(2) != 'b') {
                    if (i13 != 0) {
                        c02274u.A09(i9);
                    }
                    if (zA0H && c02274u.A0H()) {
                        c02274u.A09(5);
                    }
                    if (i12 == 0) {
                        if (c02274u.A0H()) {
                            i10 = 6;
                            c02274u.A09(6);
                        } else {
                            i10 = 6;
                        }
                        if (iA043 == 0 && c02274u.A0H()) {
                            c02274u.A09(i10);
                        }
                        if (c02274u.A0H()) {
                            c02274u.A09(i10);
                        }
                        int iA044 = c02274u.A04(2);
                        if (iA044 == 1) {
                            c02274u.A09(5);
                        } else if (iA044 == 2) {
                            c02274u.A09(12);
                        } else if (iA044 == 3) {
                            int iA045 = c02274u.A04(5);
                            if (c02274u.A0H()) {
                                c02274u.A09(5);
                                if (c02274u.A0H()) {
                                    i11 = 4;
                                    c02274u.A09(4);
                                } else {
                                    i11 = 4;
                                }
                                boolean zA0H2 = c02274u.A0H();
                                if (A01[1].charAt(12) != 'o') {
                                    A01[4] = "PWQ2PfTArLXSbAuYPJT5x4iA7pnZIJ5J";
                                    if (zA0H2) {
                                        c02274u.A09(i11);
                                    }
                                    if (c02274u.A0H()) {
                                        c02274u.A09(i11);
                                    }
                                    if (c02274u.A0H()) {
                                        c02274u.A09(i11);
                                    }
                                    if (c02274u.A0H()) {
                                        c02274u.A09(i11);
                                    }
                                    if (c02274u.A0H()) {
                                        c02274u.A09(i11);
                                    }
                                    if (c02274u.A0H()) {
                                        c02274u.A09(i11);
                                    }
                                    if (c02274u.A0H()) {
                                        if (c02274u.A0H()) {
                                            c02274u.A09(i11);
                                        }
                                        if (c02274u.A0H()) {
                                            c02274u.A09(i11);
                                        }
                                    }
                                } else {
                                    String[] strArr = A01;
                                    strArr[7] = "3piylhlPW6ECi";
                                    strArr[3] = "2ld3o4GemUbvA";
                                    if (zA0H2) {
                                    }
                                    if (c02274u.A0H()) {
                                    }
                                    if (c02274u.A0H()) {
                                    }
                                    if (c02274u.A0H()) {
                                    }
                                    if (c02274u.A0H()) {
                                    }
                                    if (c02274u.A0H()) {
                                    }
                                    if (c02274u.A0H()) {
                                    }
                                }
                            }
                            if (c02274u.A0H()) {
                                c02274u.A09(5);
                                if (c02274u.A0H()) {
                                    c02274u.A09(7);
                                    boolean zA0H3 = c02274u.A0H();
                                    if (A01[1].charAt(12) != 'o') {
                                        throw new RuntimeException();
                                    }
                                    A01[6] = "rSblh4R2S5jwen1kap7KA3ClbKLn4xCa";
                                    if (zA0H3) {
                                        c02274u.A09(8);
                                    }
                                }
                            }
                            c02274u.A09((iA045 + 2) * 8);
                            c02274u.A06();
                        }
                        if (A01[4].length() != 32) {
                            String[] strArr2 = A01;
                            strArr2[5] = "CT6fc8NDwAee95wvc4i3U0G4PwptFgbR";
                            strArr2[0] = "cOprcaH4V9QUBwGl6SpW2PXD2gkWJWIT";
                            if (iA043 < 2) {
                                if (c02274u.A0H()) {
                                    c02274u.A09(14);
                                }
                                if (iA043 == 0 && c02274u.A0H()) {
                                    c02274u.A09(14);
                                }
                            }
                            if (c02274u.A0H()) {
                                if (iA04 == 0) {
                                    c02274u.A09(5);
                                } else {
                                    for (int i14 = 0; i14 < i5; i14++) {
                                        if (c02274u.A0H()) {
                                            c02274u.A09(5);
                                        }
                                    }
                                }
                            }
                        } else {
                            A01[2] = "TfLNzHkYjjGfwBXQwG7FQ44lMKhqfIt5";
                            if (iA043 < 2) {
                            }
                            if (c02274u.A0H()) {
                            }
                        }
                    }
                } else {
                    A01[2] = "n86rU7cJyKu1PGdXCxu3oQra88IC0cti";
                    if (i13 != 0) {
                    }
                    if (zA0H) {
                        c02274u.A09(5);
                    }
                    if (i12 == 0) {
                    }
                }
            }
            if (c02274u.A0H()) {
                c02274u.A09(5);
                if (iA043 == 2) {
                    c02274u.A09(4);
                }
                if (iA043 >= 6) {
                    c02274u.A09(2);
                }
                if (c02274u.A0H()) {
                    i8 = 8;
                    c02274u.A09(8);
                } else {
                    i8 = 8;
                }
                if (iA043 == 0) {
                    boolean zA0H4 = c02274u.A0H();
                    String[] strArr3 = A01;
                    if (strArr3[7].length() == strArr3[3].length()) {
                        String[] strArr4 = A01;
                        strArr4[5] = "YsaJcRTRbu2uSs1yKbmR882rDeXrY1Vp";
                        strArr4[0] = "pJsPcDksUtPyGih90nhVsOa0zw9Rh9Kw";
                        if (zA0H4) {
                            c02274u.A09(i8);
                        }
                    }
                    throw new RuntimeException();
                }
                i6 = 3;
                if (iA042 < 3) {
                    c02274u.A07();
                }
            } else {
                i6 = 3;
            }
            if (i12 == 0 && iA04 != i6) {
                c02274u.A07();
            }
            if (i12 == 2) {
                if (iA04 == i6 || c02274u.A0H()) {
                    i7 = 6;
                    c02274u.A09(6);
                } else {
                    i7 = 6;
                }
            } else {
                i7 = 6;
            }
            strA0A = A0A(9, 10, 11);
            if (c02274u.A0H() && c02274u.A04(i7) == 1 && c02274u.A04(8) == 1) {
                strA0A = A0A(19, 14, 71);
            }
        } else {
            strA0A = A0A(0, 9, 4);
            c02274u.A09(32);
            int iA046 = c02274u.A04(2);
            if (iA046 == 3) {
                strA0A = null;
            }
            int iA047 = c02274u.A04(6);
            iA01 = A02[iA047 / 2] * 1000;
            iA00 = A00(iA046, iA047);
            c02274u.A09(8);
            int iA048 = c02274u.A04(3);
            if ((iA048 & 1) != 0 && iA048 != 1) {
                i = 2;
                c02274u.A09(2);
            } else {
                i = 2;
            }
            if ((iA048 & 4) != 0) {
                c02274u.A09(i);
            }
            if (iA048 == i) {
                c02274u.A09(i);
            }
            i2 = iA046 < A05.length ? A05[iA046] : -1;
            i3 = 1536;
            i4 = A04[iA048] + (c02274u.A0H() ? 1 : 0);
        }
        return new C0515Gq(strA0A, i12, i4, i2, iA00, i3, iA01);
    }
}
