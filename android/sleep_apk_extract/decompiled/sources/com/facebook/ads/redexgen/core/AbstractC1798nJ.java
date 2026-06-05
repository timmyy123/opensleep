package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC1798nJ {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 87);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{96, 35, 33, 46, 46, 47, 52, 96, 34, 37, 96, 46, 37, 39, 33, 52, 41, 54, 37, 96, 34, 53, 52, 96, 55, 33, 51, 122, 96, 43, 120, 99, 122, 122, 0, 1, 78, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 15, 2, 2, 29, 78, 26, 1, 78, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 22, 26, 70, 71, 78, 29, 7, 0, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 78, 26, 6, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 78, 2, 15, 29, 26, 78, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 15, 2, 2, 78, 26, 1, 78, 28, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3, 1, 24, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 70, 71, 10, 17, 8, 8, 68, 15, 1, 29, 68, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, 68, 1, 10, 16, 22, 29, 94, 68, 10, 17, 8, 8, 89, 31, 4, 29, 29, 81, 7, 16, 29, 4, 20, 81, 24, 31, 81, 20, 31, 5, 3, 8, 75, 81};
    }

    public static int A00(int value, String name) {
        if (value >= 0) {
            return value;
        }
        throw new IllegalArgumentException(name + A01(0, 29, 23) + value);
    }

    public static void A03(Object key, Object value) {
        if (key != null) {
            if (value != null) {
                return;
            } else {
                throw new NullPointerException(A01(108, 21, 38) + key + A01(29, 5, 65));
            }
        }
        throw new NullPointerException(A01(84, 24, 51) + value);
    }

    public static void A04(boolean canRemove) {
        AbstractC1651ki.A0F(canRemove, A01(34, 50, 57));
    }
}
