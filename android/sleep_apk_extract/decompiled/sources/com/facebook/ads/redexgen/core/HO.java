package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class HO {
    public static byte[] A00;
    public static String[] A01 = {"wNk4F48Tu3AG7Z4F7CEax", "Q3Xv5sIL2TDrtW8yXR3dvi", "vexXXyFX5NNV4ziL4Q5MBx4locsFR2tR", "qvuj1ZZFgqOZzW4yl3sJoBizwIu3mzuW", "F9U7Z4TBUsCQBus7nNJljVmhfAVgv4lP", "pwS", "B3rn9fTC63wAJDGOR1lgaZRSiOmdejRD", "uz6PPvsEvjCr7qg3UfeXn9kgEA7UaI0b"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;
    public static final int[] A05;
    public static final int[] A06;
    public static final int[] A07;
    public static final String[] A08;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 125);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{53, 73, 56, 61, 67, 3, 65, 68, 57, 59, -12, 8, -9, -4, 2, -62, 0, 3, -8, -6, -64, -33, -60, 47, 67, 50, 55, 61, -3, 59, 62, 51, 53, -5, 26, 0};
    }

    static {
        A05();
        A08 = new String[]{A04(10, 13, 22), A04(23, 13, 81), A04(0, 10, 87)};
        A07 = new int[]{44100, 48000, 32000};
        A02 = new int[]{32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
        A06 = new int[]{32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
        A03 = new int[]{32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
        A04 = new int[]{32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
        A05 = new int[]{8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};
    }

    public static int A00(int i) {
        int i2;
        int layer;
        int padding;
        int i3;
        int samplingRate;
        int version;
        if (!A06(i) || (i2 = (i >>> 19) & 3) == 1 || (layer = (i >>> 17) & 3) == 0 || (padding = (i >>> 12) & 15) == 0 || padding == 15 || (i3 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i4 = A07[i3];
        if (i2 == 2) {
            i4 /= 2;
        } else if (i2 == 0) {
            i4 /= 4;
        }
        int i5 = (i >>> 9) & 1;
        if (layer == 3) {
            if (i2 == 3) {
                int version2 = padding - 1;
                version = A02[version2];
            } else {
                int version3 = padding - 1;
                version = A06[version3];
            }
            return (((version * 12) / i4) + i5) * 4;
        }
        if (i2 == 3) {
            if (layer == 2) {
                int version4 = padding - 1;
                samplingRate = A03[version4];
            } else {
                int version5 = padding - 1;
                samplingRate = A04[version5];
            }
        } else {
            int[] iArr = A05;
            String[] strArr = A01;
            String str = strArr[0];
            String str2 = strArr[1];
            int samplingRate2 = str.length();
            int version6 = str2.length();
            if (samplingRate2 == version6) {
                throw new RuntimeException();
            }
            A01[5] = "31X";
            int version7 = padding - 1;
            samplingRate = iArr[version7];
        }
        if (i2 == 3) {
            int version8 = samplingRate * 144;
            return (version8 / i4) + i5;
        }
        int version9 = layer == 1 ? 72 : 144;
        return ((version9 * samplingRate) / i4) + i5;
    }

    public static int A01(int i) {
        int i2;
        int layer;
        if (!A06(i) || (i2 = (i >>> 19) & 3) == 1 || (layer = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i3 = (i >>> 12) & 15;
        int version = i >>> 10;
        int version2 = version & 3;
        if (i3 == 0 || i3 == 15 || version2 == 3) {
            return -1;
        }
        int version3 = A02(i2, layer);
        return version3;
    }

    public static int A02(int i, int i2) {
        switch (i2) {
            case 1:
                return i == 3 ? 1152 : 576;
            case 2:
                return 1152;
            case 3:
                return 384;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static boolean A06(int i) {
        return (i & (-2097152)) == -2097152;
    }

    public static /* synthetic */ int[] A0C() {
        int[] iArr = A04;
        if (A01[6].charAt(14) != 'G') {
            throw new RuntimeException();
        }
        A01[4] = "YpQ2FEpgCaHa1vzVK0UO04rJGRLP7Hel";
        return iArr;
    }
}
