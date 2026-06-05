package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ez, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public enum EnumC1314ez {
    A06(A00(425, 41, 32)),
    A07(A00(466, 56, 45)),
    A08(A00(522, 44, 8)),
    A09(A00(566, 37, 46)),
    A04(A00(302, 40, 20)),
    A0A(A00(342, 45, 95)),
    A05(A00(387, 38, 88)),
    A0C(A00(655, 53, 88)),
    A0B(A00(603, 52, 29)),
    A03(A00(252, 50, 121));

    public static byte[] A01;
    public String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 123);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{123, 102, 113, 99, 117, 102, 112, 113, 112, 107, 98, 125, 112, 113, 123, 107, 117, 119, 96, 125, 98, 125, 96, 109, 107, 112, 113, 103, 96, 102, 123, 109, 113, 112, 45, 58, 40, 62, 45, 59, 58, 59, 32, 41, 54, 59, 58, 48, 32, 62, 59, 32, 60, 51, 54, 60, 52, 78, 89, 75, 93, 78, 88, 89, 88, 67, 74, 85, 88, 89, 83, 67, 95, 80, 83, 79, 89, 88, 51, 36, 54, 32, 51, 37, 36, 37, 62, 55, 40, 37, 36, 46, 62, 34, 46, 44, 49, 45, 36, 53, 36, 15, 24, 10, 28, 15, 25, 24, 25, 2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 20, 25, 24, 18, 2, 30, 18, 16, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 17, 24, 9, 24, 2, 10, 20, 9, 21, 18, 8, 9, 2, 15, 24, 10, 28, 15, 25, 3, 20, 6, 16, 3, 21, 20, 21, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 7, 24, 21, 20, 30, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 20, 31, 21, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 16, 18, 5, 24, 7, 24, 5, 8, 86, 65, 83, 69, 86, 64, 65, 64, 91, 82, 77, 64, 65, 75, 91, 65, 86, 86, 75, 86, 87, 64, 82, 68, 87, 65, 64, 65, 90, 83, 76, 65, 64, 74, 90, 76, 72, 85, 87, 64, 86, 86, 76, 74, 75, 72, 95, 77, 91, 72, 94, 69, 73, 95, 72, 76, 95, 72, 69, 92, 91, 83, 86, 95, 94, 99, 116, 102, 112, 99, 117, 110, 98, 116, 99, 103, 116, 99, 110, 98, 100, 114, 114, 116, 98, 98, 97, 109, 111, 44, 100, 99, 97, 103, 96, 109, 109, 105, 44, 99, 102, 113, 44, 112, 103, 117, 99, 112, 102, 103, 102, 93, 116, 107, 102, 103, 109, 44, 99, 97, 118, 107, 116, 107, 118, 123, 93, 102, 103, 113, 118, 112, 109, 123, 103, 102, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, 2, 65, 9, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 10, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 0, 0, 4, 65, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 28, 65, 29, 10, 24, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 29, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 48, 25, 6, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, 0, 65, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 48, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 3, 6, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 4, 71, 75, 73, 10, 66, 69, 71, 65, 70, 75, 75, 79, 10, 69, 64, 87, 10, 86, 65, 83, 69, 86, 64, 65, 64, 123, 82, 77, 64, 65, 75, 10, 69, 64, 123, 77, 73, 84, 86, 65, 87, 87, 77, 75, 74, 64, 76, 78, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 69, 66, 64, 70, 65, 76, 76, 72, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 66, 71, 80, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 81, 70, 84, 66, 81, 71, 70, 71, 124, 85, 74, 71, 70, 76, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 64, 79, 76, 80, 70, 71, 56, 52, 54, 117, 61, 58, 56, 62, 57, 52, 52, 48, 117, 58, 63, 40, 117, 41, 62, 44, 58, 41, 63, 62, 63, 4, 45, 50, 63, 62, 52, 117, 56, 52, 54, 43, 55, 62, 47, 62, 63, 53, 57, 59, 120, 48, 55, 53, 51, 52, 57, 57, 61, 120, 55, 50, 37, 120, 36, 51, 33, 55, 36, 50, 51, 50, 9, 32, 63, 50, 51, 57, 120, 53, 57, 59, 38, 58, 51, 34, 51, 50, 120, 33, 63, 34, 62, 57, 35, 34, 120, 36, 51, 33, 55, 36, 50, 16, 28, 30, 93, 21, 18, 16, 22, 17, 28, 28, 24, 93, 18, 23, 0, 93, 1, 22, 4, 18, 1, 23, 22, 23, 44, 5, 26, 23, 22, 28, 93, 22, 29, 23, 44, 18, 16, 7, 26, 5, 26, 7, 10, 54, 58, 56, 123, 51, 52, 54, 48, 55, 58, 58, 62, 123, 52, 49, 38, 123, 39, 48, 34, 52, 39, 49, 48, 49, 10, 35, 60, 49, 48, 58, 123, 48, 39, 39, 58, 39, 5, 9, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 72, 0, 7, 5, 3, 4, 9, 9, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 72, 7, 2, 21, 72, 20, 3, 17, 7, 20, 2, 3, 2, 57, 16, 15, 2, 3, 9, 72, 21, 3, 20, 16, 3, 20, 57, 20, 3, 17, 7, 20, 2, 57, 0, 7, 15, 10, 3, 2, 64, 76, 78, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 69, 66, 64, 70, 65, 76, 76, 72, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 66, 71, 80, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 81, 70, 84, 66, 81, 71, 70, 71, 124, 85, 74, 71, 70, 76, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 80, 70, 81, 85, 70, 81, 124, 81, 70, 84, 66, 81, 71, 124, 80, 86, 64, 64, 70, 80, 80};
    }

    static {
        A01();
    }

    EnumC1314ez(String str) {
        this.A00 = str;
    }

    public final String A03() {
        return this.A00;
    }

    public final String A04(String str) {
        return this.A00 + A00(0, 1, 58) + str;
    }
}
