package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ir, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1547ir {
    A09(A00(173, 7, 111)),
    A07(A00(145, 11, 71)),
    A0A(A00(180, 16, 94)),
    A06(A00(129, 16, 114)),
    A08(A00(156, 17, 64)),
    A05(A00(120, 9, 118)),
    A04(A00(98, 22, 15));

    public static byte[] A01;
    public static String[] A02 = {"3irfHjb1xBggEOYppIC20CVGO", "PvTwVw4l1egAAUgNiEJHpQxcY", "Z83jj4f2UJi7iIzCa97fW954cYyfIvRS", "Pn3ECjM654pG8xNfJs7iPR6nvOfTtg4S", "rnvCizUmlaJkbQ0LWt7EGYvIVwvlRHSU", "Y4v1TwA3VTqRjFpvhM1P5mrv4yN1Kb1i", "iJ3TP1yTdydKb8xTTpNjz5p9ilImmlzt", "3Fyn3bOdC3lEL0zKVakbNgp9AIkAOPYu"};
    public final String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] ^ i3;
            String[] strArr = A02;
            if (strArr[4].charAt(18) != strArr[3].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[4] = "9Fh1XlTwmrAkPSBsBt7sR6HEZ4z1EPMB";
            strArr2[3] = "w0XpqxyBnVeSACOsJ07N96wKg89kpHEO";
            bArrCopyOfRange[i4] = (byte) (i5 ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{71, 80, 67, 67, 64, 87, 90, 71, 64, 73, 74, 82, 90, 81, 77, 87, 64, 86, 77, 74, 73, 65, 25, 16, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 28, 26, 0, 26, 17, 27, 33, 32, 48, 32, 58, 59, 63, 58, 59, 48, 45, 58, 41, 41, 42, 61, 103, 124, 101, 101, 118, 111, 102, 123, 100, 104, 125, 79, 73, 78, 90, 93, 95, 89, 67, 82, 83, 72, 67, 78, 89, 93, 88, 69, 2, 25, 28, 25, 24, 0, 25, 127, 105, 97, 124, 97, 102, 111, 119, 110, 103, 122, 119, 99, 109, 113, 123, 86, 65, 82, 82, 81, 70, 107, 86, 81, 88, 91, 67, 107, 64, 92, 70, 81, 71, 92, 91, 88, 80, 43, 34, 63, 46, 40, 18, 40, 35, 41, 39, 38, 22, 38, 60, 61, 57, 60, 61, 22, 43, 60, 47, 47, 44, 59, 18, 9, 16, 16, 35, 26, 19, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 17, 29, 8, 8, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 9, 29, 26, 24, 30, 36, 21, 20, 15, 36, 9, 30, 26, 31, 2, 33, 58, 63, 58, 59, 35, 58, 18, 4, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 2, 58, 3, 10, 23, 58, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 0, 28, 22};
    }

    static {
        A01();
    }

    EnumC1547ir(String str) {
        this.A00 = str;
    }
}
