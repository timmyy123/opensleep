package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.11, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AnonymousClass11 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{120, 122, 109, 112, 111, 112, 109, 96, 70, 118, 123, 115, 124, 122, 109, 70, 112, 125, 64, 66, 85, 72, 87, 72, 85, 88, 126, 87, 72, 68, 86, 126, 85, 88, 81, 68, 112, 117, 78, 125, 120, 98, 101, 116, 127, 116, 99, 78, 98, 116, 101, 73, 76, 119, 92, 81, 88, 77, 83, 65, 66, 87, 81, 70, 109, 64, 83, 70, 91, 93, 75, 73, 68, 68, 119, 65, 79, 70, 71, 90, 77, 76, 45, 38, 47, 39, 32, 43, 42, 31, 20, 29, 21, 18, 25, 24, 35, 29, 24, 35, 21, 18, 24, 25, 4, 112, 123, 114, 122, 125, 118, 119, 76, 99, 114, 97, 114, 126, 96, 76, 121, 96, 124, 125, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 16, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 32, 28, 16, 27, 26, 97, 118, 118, 107, 118, 91, 105, 97, 119, 119, 101, 99, 97, 113, 108, 119, 113, 100, 96, 125, 123, 122, 48, 57, 43, 7, 58, 49, 60, 30, 23, 5, 41, 21, 25, 24, 2, 4, 25, 26, 26, 19, 4, 93, 84, 70, 106, 89, 92, 70, 65, 80, 91, 80, 71, 99, 106, 120, 84, 124, 110, 105, 125, 98, 110, 124, 34, 42, 41, 20, 47, 34, 56, 42, 41, 39, 46, 47, 20, 41, 50, 20, 44, 32, 18, 31, 108, 118, 90, 108, 107, 115, 100, 105, 108, 97, 100, 113, 96, 97, 9, 19, 63, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 5, 6, 20, 63, 20, 15, 16, 63, 8, 1, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 6, 35, 57, 21, 58, 63, 40, 38, 35, 41, 56, 34, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 34, 33, 61, 56, 37, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 34, 50, 35, 52, 52, 63, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 55, 61, 48, 54, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 48, 53, 53, 52, 53, 47, 53, 25, 53, 51, 54, 54, 41, 52, 50, 35, 34, 25, 47, 40, 25, 39, 54, 54, 61, 50, 58, 88, 91, 85, 80, 107, 81, 76, 81, 87, 65, 64, 93, 91, 90, 107, 67, 85, 93, 64, 107, 64, 93, 89, 81, 107, 89, 71, 39, 36, 42, 47, 20, 63, 34, 38, 46, 20, 38, 56, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 0, 5, 8, 15, 6, 62, 0, 5, 0, 17, 21, 4, 19, 40, 36, 43, 44, 35, 32, 54, 49, 26, 40, 50, 26, 54, 48, 53, 53, 42, 55, 49, 75, 67, 66, 79, 71, 82, 79, 73, 72, 121, 73, 80, 67, 84, 74, 71, 95, 121, 85, 67, 82, 60, 52, 34, 34, 48, 54, 52, 16, 18, 25, 24, 5, 31, 55, 7, 27, 55, 27, 29, 24, 24, 7, 26, 28, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 22, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 1, 10, 16, 5, 16, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, 68, 88, 85, 87, 81, 89, 81, 90, 64, 107, 93, 80, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 23, 26, 24, 30, 22, 30, 21, 15, 36, 15, 2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 30, 24, 26, 7, 30, 1, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 26, 58, 45, 41, 59, 39, 38, 71, 80, 68, 64, 80, 70, 65, 106, 92, 81, 99, 116, 98, 100, 125, 101, 10, 17, 22, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 38, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 28, 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 21, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 94, 70, 68, 93, 114, 95, 72, 76, 94, 66, 67, 97, 125, 103, 96, 113, 119, 27, 24, 55, 27, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 55, 5, 31, 55, 7, 27, 55, 27, 29, 24, 24, 7, 26, 28, 95, 82, 91, 78, 127, 81, 21, 71, 88, 85, 84, 94, 23, 8, 4, 22, 62, 21, 24, 17, 4, 81, 78, 66, 80, 70, 69, 75, 66, 120, 85, 70, 83, 78, 72, 70, 89, 67, 89, 82, 89, 92, 89, 68, 73, 77, 84, 83, 101, 92, 91, 86, 73, 95, 101, 72, 95, 91, 73, 85, 84};
    }
}
