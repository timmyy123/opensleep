package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0512Gn {
    public static byte[] A00;
    public static String[] A01 = {"jnpQs", "68vQr4mYnLI0oxp3WZBPcyc6w04l8sdO", "1OtBqA6VhuQLpqBNtIteBoMpw2BUtlZT", "iBOJpCpDP8DiwQrVeW3OV9Em66L9h1f8", "Xaj0HtPMuTBdCp8NFbjtiHIpdpZCFdAK", "i4DAEtymK6yFJNiO2QALezQZgNrDh5qR", "4Bsy9O0lknqqP9xR2TNdH0U1zi1weR0A", "FgP5ewPOxCae6ADOyhugLxvte5BfjSLb"};
    public static final int[] A02;
    public static final int[] A03;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{-10, -10, -8, -43, 29, 26, 22, 25, 26, 39, -43, 30, 35, 40, 42, 27, 27, 30, 24, 30, 26, 35, 41, -43, 25, 22, 41, 22, -13, -13, -11, -46, 26, 23, 19, 22, 23, 36, -46, 41, 36, 33, 32, 25, -46, 5, 19, 31, 34, 30, 27, 32, 25, -46, -8, 36, 23, 35, 39, 23, 32, 21, 43, -46, -5, 32, 22, 23, 42, 5, 37, 39, 25, 56, 45, 48, 16, 41, 32, 51, 43, 32, 30, 47, 32, 31, -37, 33, 45, 28, 40, 32, 7, 32, 41, 34, 47, 35, 1, 39, 28, 34, -37, -8, -37, -20, -8, 17, 22, 24, 19, 19, 18, 21, 23, 8, 7, -61, 4, 24, 7, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 18, -61, 18, 5, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 8, 6, 23, -61, 23, 28, 19, 8, -35, -61, 68, 93, 98, 100, 95, 95, 94, 97, 99, 84, 83, 15, 84, 95, 50, 94, 93, 85, 88, 86, 41, 15, -19, -16, -76, -31, -82, -76, -80, -82};
    }

    static {
        A05();
        A03 = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
        A02 = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    }

    public static int A00(C02274u c02274u) {
        int iA04 = c02274u.A04(5);
        if (iA04 == 31) {
            int audioObjectType = c02274u.A04(6);
            return audioObjectType + 32;
        }
        return iA04;
    }

    public static int A01(C02274u c02274u) throws C3K {
        int iA04 = c02274u.A04(4);
        if (iA04 == 15) {
            int iA01 = c02274u.A01();
            if (A01[0].length() != 5) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "q0W1UZuAU1h4xSNvnmv6o4fLVDdZ81si";
            strArr[4] = "TmcMI11py7mWue9QV51Oyh4sKPsH3Jhr";
            if (iA01 >= 24) {
                int frequencyIndex = c02274u.A04(24);
                return frequencyIndex;
            }
            throw C3K.A01(A04(0, 28, 60), null);
        }
        if (iA04 < 13) {
            int frequencyIndex2 = A03[iA04];
            return frequencyIndex2;
        }
        throw C3K.A01(A04(28, 41, 57), null);
    }

    public static C0511Gm A02(C02274u c02274u, boolean z) throws C3K {
        int iA00 = A00(c02274u);
        int iA01 = A01(c02274u);
        int iA04 = c02274u.A04(4);
        String str = A04(159, 8, 7) + iA00;
        if (iA00 == 5 || iA00 == 29) {
            iA01 = A01(c02274u);
            iA00 = A00(c02274u);
            if (iA00 == 22) {
                iA04 = c02274u.A04(4);
            }
        }
        if (z) {
            switch (iA00) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    A06(c02274u, iA00, iA04);
                    int sampleRateHz = A01[0].length();
                    if (sampleRateHz != 5) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[6] = "3cbQZ4WWsbXwvX2zvxOiUlmwqxsyxREi";
                    strArr[3] = "nPAxNfqqgI9TB5NmScWQIj27S1nluV3e";
                    switch (iA00) {
                        case 17:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            int iA042 = c02274u.A04(2);
                            if (iA042 == 2 || iA042 == 3) {
                                throw C3K.A00(A04(137, 22, 118) + iA042);
                            }
                    }
                    break;
                case 5:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 18:
                default:
                    throw C3K.A00(A04(106, 31, 42) + iA00);
            }
        }
        int channelCount = A02[iA04];
        if (channelCount != -1) {
            return new C0511Gm(iA01, channelCount, str);
        }
        throw C3K.A01(null, null);
    }

    public static C0511Gm A03(byte[] bArr) throws C3K {
        return A02(new C02274u(bArr), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A06(C02274u c02274u, int i, int i2) {
        boolean frameLengthFlag = c02274u.A0H();
        if (frameLengthFlag) {
            AbstractC02134g.A07(A04(69, 7, 75), A04(76, 30, 66));
        }
        boolean frameLengthFlag2 = c02274u.A0H();
        if (!frameLengthFlag2) {
            boolean zA0H = c02274u.A0H();
            if (i2 == 0) {
                if (i == 6 || i == 20) {
                    c02274u.A09(3);
                }
                if (zA0H) {
                    if (i == 22) {
                        c02274u.A09(16);
                    }
                    if (i == 17 || i == 19 || i == 20 || i == 23) {
                        c02274u.A09(3);
                    }
                    String[] strArr = A01;
                    if (strArr[1].charAt(21) != strArr[4].charAt(21)) {
                        String[] strArr2 = A01;
                        strArr2[6] = "QrL8Tr8yy4gY8AXmFxmkTTkkR7JmfqMW";
                        strArr2[3] = "IjkFi7C6bNI16jdHGSbHtjLd4dsdDQNH";
                        c02274u.A09(1);
                        return;
                    }
                } else {
                    return;
                }
            } else {
                throw new UnsupportedOperationException();
            }
        } else if (A01[5].charAt(15) != 's') {
            String[] strArr3 = A01;
            strArr3[7] = "v2arTuVBFpHRdd6zD5uQKVaL6J866891";
            strArr3[2] = "F7KamgaQFU4osqLd0R7CHRmLJ4QhMqsw";
            c02274u.A09(14);
            boolean zA0H2 = c02274u.A0H();
            if (i2 == 0) {
            }
        }
        throw new RuntimeException();
    }

    public static byte[] A07(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }
}
