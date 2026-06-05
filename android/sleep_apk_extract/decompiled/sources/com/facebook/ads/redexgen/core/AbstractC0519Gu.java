package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0519Gu {
    public static byte[] A00;
    public static String[] A01 = {"xbfghvjfzJvhku5N8OELiq204nVuVPFf", "QHdNkhaNqF6P8ZoHbM5E7ac9pSEOFT0I", "gTrjGkh7SJSYjcOCOWWCub6Uckq9Yltj", "B1r", "bt5fTN19iCcMkB3LBJCDNqZ6iO4ZjItL", "3vLSrbB7SQdOWYeFWsx", "mXdQOoT87saNovPMynKxKkWZ", "FMZbalTyTizDclIiFtsmYNu0onhdvCq9"};
    public static final int[] A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0518Gt A04(C02274u c02274u) {
        int iA04 = c02274u.A04(16);
        int iA042 = c02274u.A04(16);
        int i = 0 + 2 + 2;
        if (iA042 == 65535) {
            iA042 = c02274u.A04(24);
            i += 3;
        }
        int i2 = iA042 + i;
        if (iA04 == 44097) {
            i2 += 2;
        }
        int iA043 = c02274u.A04(2);
        if (iA043 == 3) {
            iA043 += A00(c02274u, 2);
            String[] strArr = A01;
            if (strArr[1].charAt(27) != strArr[4].charAt(27)) {
                A01[3] = "JeV";
                int iA044 = c02274u.A04(10);
                if (c02274u.A0H() && c02274u.A04(3) > 0) {
                    c02274u.A09(2);
                }
                boolean zA0H = c02274u.A0H();
                if (A01[5].length() != 0) {
                    A01[7] = "lwIINFZkQEgov7IcPWK4ANnqSDhXt22f";
                    int i3 = zA0H ? 48000 : 44100;
                    int iA045 = c02274u.A04(4);
                    int i4 = 0;
                    if (i3 != 44100 || iA045 != 13) {
                        if (i3 == 48000 && iA045 < A02.length) {
                            i4 = A02[iA045];
                            switch (iA044 % 5) {
                                case 1:
                                case 3:
                                    if (iA045 == 3 || iA045 == 8) {
                                        i4++;
                                    }
                                    break;
                                case 2:
                                    if (iA045 == 8 || iA045 == 11) {
                                        i4++;
                                    }
                                    break;
                                case 4:
                                    if (iA045 == 3 || iA045 == 8 || iA045 == 11) {
                                        i4++;
                                    }
                                    break;
                            }
                        }
                    } else {
                        i4 = A02[iA045];
                    }
                    return new C0518Gt(iA043, 2, i3, i2, i4);
                }
            }
        } else {
            int iA0442 = c02274u.A04(10);
            if (c02274u.A0H()) {
                c02274u.A09(2);
            }
            boolean zA0H2 = c02274u.A0H();
            if (A01[5].length() != 0) {
            }
        }
        throw new RuntimeException();
    }

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A01[7].charAt(26) == 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "ZZS15YLfqnGzRKQmbGGBAS62S7daT6Pr";
            strArr[0] = "wbQ3s0ZhLtikxP7PtpYOpvXFjSSpaatC";
            bArrCopyOfRange[i4] = (byte) ((b - i3) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{-121, -101, -118, -113, -107, 85, -121, -119, 90};
    }

    static {
        A06();
        A02 = new int[]{AdError.CACHE_ERROR_CODE, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};
    }

    public static int A00(C02274u c02274u, int i) {
        int i2 = 0;
        while (true) {
            int value = c02274u.A04(i);
            int i3 = i2 + value;
            if (!c02274u.A0H()) {
                return i3;
            }
            i2 = (i3 + 1) << i;
        }
    }

    public static int A01(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return A04(new C02274u(bArr)).A03;
    }

    public static int A02(byte[] bArr, int i) {
        if (bArr.length < 7) {
            return -1;
        }
        int headerSize = bArr[2];
        int i2 = (headerSize & PHIpAddressSearchManager.END_IP_SCAN) << 8;
        int headerSize2 = bArr[3];
        int i3 = i2 | (headerSize2 & PHIpAddressSearchManager.END_IP_SCAN);
        int frameSize = 2 + 2;
        if (i3 == 65535) {
            int headerSize3 = bArr[4];
            int i4 = (headerSize3 & PHIpAddressSearchManager.END_IP_SCAN) << 16;
            int headerSize4 = bArr[5];
            int i5 = i4 | ((headerSize4 & PHIpAddressSearchManager.END_IP_SCAN) << 8);
            int headerSize5 = bArr[6];
            i3 = i5 | (headerSize5 & PHIpAddressSearchManager.END_IP_SCAN);
            frameSize += 3;
        }
        if (i == 44097) {
            frameSize += 2;
        }
        int i6 = i3 + frameSize;
        String[] strArr = A01;
        String str = strArr[1];
        String str2 = strArr[4];
        int iCharAt = str.charAt(27);
        int headerSize6 = str2.charAt(27);
        if (iCharAt == headerSize6) {
            throw new RuntimeException();
        }
        A01[7] = "5dLepgbvmcODZNjBgadRz1gh8sb0vEN9";
        return i6;
    }

    public static C1981qI A03(C02284v c02284v, String str, String str2, DrmInitData drmInitData) {
        c02284v.A0g(1);
        return new C01722p().A0y(str).A11(A05(0, 9, 31)).A0b(2).A0m(((c02284v.A0I() & 32) >> 5) == 1 ? 48000 : 44100).A0u(drmInitData).A10(str2).A14();
    }

    public static void A07(int i, C02284v c02284v) {
        c02284v.A0d(7);
        byte[] bArrA0l = c02284v.A0l();
        bArrA0l[0] = -84;
        bArrA0l[1] = 64;
        bArrA0l[2] = -1;
        bArrA0l[3] = -1;
        bArrA0l[4] = (byte) ((i >> 16) & PHIpAddressSearchManager.END_IP_SCAN);
        bArrA0l[5] = (byte) ((i >> 8) & PHIpAddressSearchManager.END_IP_SCAN);
        bArrA0l[6] = (byte) (i & PHIpAddressSearchManager.END_IP_SCAN);
    }
}
