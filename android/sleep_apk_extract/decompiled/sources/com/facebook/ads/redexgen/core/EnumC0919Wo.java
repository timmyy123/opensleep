package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC0919Wo {
    A05(0),
    A0D(1),
    A08(2),
    A0B(3),
    A09(4),
    A0C(5),
    A04(6),
    A0A(7),
    A06(8),
    A07(9);

    public static byte[] A01;
    public static String[] A02 = {"qsBFV4QzyJZ", "Un3rqFVsxSBnmkCaaN3XKlbCw4AYbFqb", "uS", "DU", "tTGntKCVfgII9xqsGpGrv4L0WmyWUOUj", "KWr2MioisOT1RP6pbxaLpNmtsO5qpX4q", "QPqS7MAagvQqYe50TQs3IlpOEHW3O171", "i9UHFEeYKrwiWF3GKw7x6guqyhTqAOKO"};
    public int A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A02[4].charAt(8) == 'p') {
                throw new RuntimeException();
            }
            A02[4] = "bTRLSoLZMuaOSwXtpMMGEunxdgwN2gpY";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            int i5 = (bArrCopyOfRange[i4] - i3) - 94;
            String[] strArr = A02;
            if (strArr[2].length() != strArr[0].length()) {
                String[] strArr2 = A02;
                strArr2[6] = "ZL8DSguYajuR1eoXw1hG2lJW2j5bJdo3";
                strArr2[1] = "JhAlZD5OxJYpmdx1a1lzSlrIDQC8pEtq";
                bArrCopyOfRange[i4] = (byte) i5;
                i4++;
            } else {
                bArrCopyOfRange[i4] = (byte) i5;
                i4++;
            }
        }
    }

    public static void A01() {
        A01 = new byte[]{-46, -38, -35, -31, -26, -20, -50, -48, -31, -42, -29, -42, -31, -42, -46, -32, -20, -33, -46, -45, -39, -46, -48, -31, -42, -36, -37, -36, -38, -29, -38, -25, -34, -40, -12, -38, -25, -25, -28, -25, 6, -5, 15, 8, -3, 2, -1, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 25, 0, 9, 15, 8, -2, 25, -5, 10, 3, -20, -21, 2, -9, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4, -7, -2, -5, 8, 21, -4, 5, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4, -6, 21, 8, -5, -4, 2, -5, -7, 10, -1, 5, 4, -2, -1, 15, -15, -13, 4, -7, 6, -7, 4, 9, 15, 3, -11, 2, 6, -7, -13, -11, -6, -5, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -8, -19, 1, -6, -17, -12, -15, -2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -14, -5, 1, -6, -16, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -19, -4, -11, -34, -35, -61, -60, -44, -63, -74, -54, -61, -72, -67, -70, -57, -44, -69, -60, -54, -61, -71, -44, -57, -70, -69, -63, -70, -72, -55, -66, -60, -61, -1, 0, 16, 3, 6, -1, -1, -6, -1, -8, 16, 5, -14, 4, -4, 4, -50, -43, -52, -52, -33, -63, -61, -44, -55, -42, -55, -44, -55, -59, -45, -33, -46, -59, -58, -52, -59, -61, -44, -55, -49, -50, 16, 23, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 33, 5, 17, 16, 22, 7, 26, 22};
    }

    static {
        A01();
    }

    EnumC0919Wo(int i) {
        this.A00 = i;
    }
}
