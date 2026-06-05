package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class BX extends Exception {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{52, 19, 27, 30, 23, 22, 82, 6, 29, 82, 3, 7, 23, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 82, 7, 28, 22, 23, 0, 30, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 27, 28, 21, 82, 31, 23, 22, 27, 19, 82, 17, 29, 22, 23, 17, 1};
    }

    public BX(Throwable th) {
        super(A00(0, 39, 35), th);
    }
}
