package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0E, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes.dex */
public enum C0E {
    A07,
    A0A,
    A0F,
    A04,
    A0E,
    A0D,
    A0G,
    A03,
    A0B,
    A05,
    A08,
    A0H,
    A06,
    A09,
    A0C,
    A02;

    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 2);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{116, 121, 121, 35, 47, 46, 51, 52, 50, 53, 35, 52, 47, 50, 63, 50, 37, 51, 53, 44, 52, 117, 104, 115, 117, 96, 100, 121, 127, 126, 111, 96, 113, 98, 113, 125, 117, 100, 117, 98, 123, 102, 110, 114, 119, 125, 119, 106, 97, 114, 113, 105, 123, 108, 97, 124, 113, 107, 112, 122, 122, 103, 111, 115, 118, 124, 118, 107, 96, 106, 111, 111, 122, 109, 96, 125, 112, 106, 113, 123, 4, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 7, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 6, 5, 1, 28, 0, 5, 15, 5, 24, 19, 0, 3, 27, 9, 30, 19, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 3, 25, 2, 8, 27, 31, 2, 30, 27, 17, 27, 6, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 7, 2, 2, 23, 0, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 16, 29, 7, 28, 22, 85, 86, 90, 88, 85, 70, 79, 88, 75, 80, 88, 91, 85, 92, 51, 48, 40, 58, 45, 32, 61, 48, 42, 49, 59, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 16, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 1, 22, 19, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 23, 1, 90, 75, 88, 75, 71, 79, 94, 79, 88, 4, 19, 21, 19, 31, 0, 19, 4, 49, 38, 48, 44, 54, 49, 32, 38, 60, 53, 34, 49, 42, 34, 33, 47, 38, 30, 9, 24, 25, 30, 2, 54, 51, 51, 38, 49, 60, 33, 44, 54, 45, 39};
    }
}
