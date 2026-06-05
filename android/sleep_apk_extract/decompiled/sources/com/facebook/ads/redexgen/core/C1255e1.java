package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.e1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1255e1 implements InterfaceC1370ft {
    public static byte[] A01;
    public final C1417ge A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{82, 39, 76, 72, 39, 90, 101, 101, 102, 39, 88, 101, 127, 126, 99, 100, 109, 39, 94, 101, 97, 111, 100, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 10, 28, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 84, 24, 30, 28, 23, MqttWireMessage.MESSAGE_TYPE_PINGRESP};
    }

    public C1255e1(C1417ge c1417ge) {
        this.A00 = c1417ge;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1370ft
    public final Map<String, String> A6g(boolean z) {
        HashMap map = new HashMap();
        if (!SZ.A00().A04()) {
            map.put(A00(0, 23, 64), UG.A00().A01(this.A00, true).A04());
        }
        map.put(A00(23, 10, 51), UJ.A06(new C0844To(this.A00), this.A00, z));
        return map;
    }
}
