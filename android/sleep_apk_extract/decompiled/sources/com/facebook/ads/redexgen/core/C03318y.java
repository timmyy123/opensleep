package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C03318y extends Exception {
    public static byte[] A03;
    public final int A00;
    public final C1981qI A01;
    public final boolean A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-26, 26, 9, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 20, -7, 23, 6, 8, 16, -59, 28, 23, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 25, 10, -59, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 17, 10, 9, -33, -59};
    }

    public C03318y(int i, C1981qI c1981qI, boolean z) {
        super(A00(0, 25, 91) + i);
        this.A02 = z;
        this.A00 = i;
        this.A01 = c1981qI;
    }
}
