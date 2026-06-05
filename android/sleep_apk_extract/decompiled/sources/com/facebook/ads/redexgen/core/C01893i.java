package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C01893i {
    public static byte[] A04;
    public static final C01893i A05;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-23, -35, 32, 37, 30, 43, 43, 34, 41, 0, 44, 50, 43, 49, -6, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 2, 71, 80, 69, 81, 70, 75, 80, 73, 31, -33, 19, 2, 7, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -28, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 16, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -1, 18, -7, 17, -1, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 10, 3, -16, -1, 18, 3, -37};
    }

    static {
        A01();
        A05 = new C01893i(-1, -1, -1);
    }

    public C01893i(int i, int i2, int i3) {
        int iA06;
        this.A03 = i;
        this.A01 = i2;
        this.A02 = i3;
        if (C5C.A15(i3)) {
            iA06 = C5C.A06(i3, i2);
        } else {
            iA06 = -1;
        }
        this.A00 = iA06;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C01893i)) {
            return false;
        }
        C01893i c01893i = (C01893i) obj;
        return this.A03 == c01893i.A03 && this.A01 == c01893i.A01 && this.A02 == c01893i.A02;
    }

    public final int hashCode() {
        return CB.A00(Integer.valueOf(this.A03), Integer.valueOf(this.A01), Integer.valueOf(this.A02));
    }

    public final String toString() {
        return A00(26, 23, 59) + this.A03 + A00(0, 15, 90) + this.A01 + A00(15, 11, 127) + this.A02 + ']';
    }
}
