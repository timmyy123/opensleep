package com.facebook.ads.redexgen.core;

import java.io.IOException;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AM extends C1907p5 {
    public static byte[] A00;
    public static String[] A01 = {"IiHFHpE70aCOc94efxOlf2iC0Ng8zMr5", "b3mzaytlZJgoRVhs4UINeaUr6S0G0E41", "6IHqdrhMw9UxFnoc7iMNxZeDC0DTO0yB", "go0dTVggBQ2s7heaJCrnqGQgIh6JhPx1", "bkC24C7HhnNqTiNutYzB4zMXotuBenI", "te5qRCwogDd297VgLok2fv8nwYFOdDR1", "xjDDw5bsf4CogqtV7hhNk6k9HWMs2JIA", "oLDdWjUmHvVvISH87gP40QDZoo9t6EZz"};

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A01[0].charAt(11) != 'O') {
                throw new RuntimeException();
            }
            A01[2] = "31sOmOCDO5yq31NNiMqquOfpDH8J50WI";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 39);
            i4++;
        }
    }

    public static void A02() {
        A00 = new byte[]{96, 79, 70, 66, 81, 87, 70, 91, 87, 3, 107, 119, 119, 115, 3, 87, 81, 66, 69, 69, 74, 64, 3, 77, 76, 87, 3, 83, 70, 81, 78, 74, 87, 87, 70, 71, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 3, 112, 70, 70, 3, 75, 87, 87, 83, 80, 25, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 71, 70, 85, 70, 79, 76, 83, 70, 81, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 66, 77, 71, 81, 76, 74, 71, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 64, 76, 78, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 68, 86, 74, 71, 70, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 87, 76, 83, 74, 64, 80, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 78, 70, 71, 74, 66, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 74, 80, 80, 86, 70, 80, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 64, 79, 70, 66, 81, 87, 70, 91, 87, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 77, 76, 87, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 83, 70, 81, 78, 74, 87, 87, 70, 71};
    }

    static {
        A02();
    }

    public AM(IOException iOException, C02415i c02415i) {
        super(A01(0, 121, 4), iOException, c02415i, 2007, 1);
    }
}
