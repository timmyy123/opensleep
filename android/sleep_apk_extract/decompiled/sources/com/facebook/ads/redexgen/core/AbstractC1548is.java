package com.facebook.ads.redexgen.core;

import android.media.MediaFormat;
import java.util.Arrays;
import java.util.Random;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.is, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1548is {
    public static String A00;
    public static String A01;
    public static byte[] A02;
    public static final Random A03;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{39, 0, 8, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 4, 5, 65, 21, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 65, 19, 4, 21, 19, 8, 4, 23, 4, 65, 44, 4, 5, 8, 0, 39, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 19, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, 21, 73, 100, 115, 110, 68, 121, 110, 84, 117, 104, 109, 9, 43, 54, 33, 32, 116, 10, 45, 56, 45, 44, 42, 126, 72, 89, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 108, 100, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 107, 127, 110, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 124, 107, 105, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 65, 72, 91, 72, 65, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 89, 66, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 8, 73, 59, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 28, 72, 41, 33, 72, 46, 58, 43, 72, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 25, 29, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 27, 28, 72, 28, 7, 72, 89, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 58, 43, 127, 30, 22, 127, 25, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 28, 127, 41, 54, 59, 58, 48, 127, 59, 42, 45, 62, 43, 54, 48, 49, 127, 43, 48, 127, 122, 59, 37, 40, 36, 42, 37, 57, 19, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 10, 2, 8, 18, 19, 56, 19, 21, 30, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 9, 0, 56, 19, 8, 56, 1, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 9, 3, 56, 20, 2, 0, 10, 2, 9, 19, 56, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 9, 56, 8, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 15, 28, 23, 29, 22, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 87, 10, 28, 26, 84, 24, 16, 31, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 26, 84, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 24, 23, 10, 31, 28, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 84, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 28, 8, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 28, 10, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 87, 15, 24, 21, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 28, 112, 99, 104, 98, 105, 116, 40, 117, 99, 101, 43, 103, 111, 96, 116, 101, 43, 112, 111, 98, 99, 105, 43, 98, 115, 116, 103, 114, 111, 105, 104, 40, 112, 103, 106, 115, 99, 78, 93, 86, 92, 87, 74, 22, 75, 93, 91, 21, 89, 81, 94, 74, 91, 21, 78, 81, 92, 93, 87, 21, 73, 94, 92, 21, 84, 93, 78, 93, 84, 22, 78, 89, 84, 77, 93, 89, 71, 74, 90, 70};
    }

    static {
        A02();
        A00 = A01(41, 12, 83);
        A01 = A01(139, 37, 109);
        A03 = new Random();
    }

    public static int A00(int i, int i2) {
        if (i2 != 0) {
            return (int) ((Math.pow(2.0d, i - 1) * ((double) i2) * 1000.0d) + ((double) A03.nextInt(2000)));
        }
        return (int) Math.min((((long) (i - 1)) * 1000) + 500, 5000L);
    }

    public static void A03(C1577jQ c1577jQ, MediaFormat mediaFormat) {
        String strA01 = A01(0, 30, 107);
        String strA012 = A01(30, 11, 11);
        if (!c1577jQ.A01) {
            return;
        }
        try {
            if (C1546iq.A02()) {
                if (c1577jQ.A0P && !C1546iq.A03(mediaFormat.getInteger(A01(290, 5, 36)), mediaFormat.getInteger(A01(133, 6, 71)))) {
                    return;
                }
                long j = c1577jQ.A00;
                if (j > 0) {
                    mediaFormat.setLong(A01(215, 37, 12), j);
                    AbstractC1478hd.A01(strA012, A01(102, 31, 85), Long.valueOf(j));
                }
                mediaFormat.setInteger(A01(252, 38, 50), c1577jQ.A02);
                AbstractC1478hd.A01(strA012, A01(53, 26, 39), Integer.valueOf(c1577jQ.A02));
                mediaFormat.setInteger(A01(176, 39, 115), 1);
                AbstractC1478hd.A00(strA012, A01(79, 23, 98));
            }
        } catch (ClassCastException e) {
            AbstractC1478hd.A02(strA012, strA01, e);
        } catch (NullPointerException e2) {
            AbstractC1478hd.A02(strA012, strA01, e2);
        }
    }

    public static boolean A04(C1577jQ c1577jQ, int i, int i2, int i3, int i4) {
        if (c1577jQ.A01 && c1577jQ.A0P && C1546iq.A03(i, i2) != C1546iq.A03(i3, i4)) {
            return true;
        }
        return false;
    }
}
