package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.UUID;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class JH {
    public static byte[] A00;
    public static String[] A01 = {"f", "wBzTr9isyWuzk0Was82fzP", "sjHXZ8xDB", "rmj8ZpQPq6N", "k0JnkexrU5JvppKLiAvWnmQe", "wOTrIZh22Rcriy8Kptm38zvp", "MO9vm10BV89BFpJ5cx5aSl", "G2cEiJ7mV"};

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 26);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {-68, -33, -33, -44, -83, -32, -37, -39, -63, -32, -43, -40, -20, 5, 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 7, 7, 6, 9, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -4, -5, -73, 7, 10, 10, -1, -73, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -4, 9, 10, 0, 6, 5, -47, -73};
        String[] strArr = A01;
        if (strArr[2].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[2] = "tjOAGVDnT";
        strArr2[7] = "ur6F1gHbb";
        A00 = bArr;
    }

    static {
        A03();
    }

    public static JG A00(byte[] bArr) {
        C02284v c02284v = new C02284v(bArr);
        if (c02284v.A0A() < 32) {
            return null;
        }
        c02284v.A0f(0);
        if (c02284v.A0C() != c02284v.A07() + 4 || c02284v.A0C() != 1886614376) {
            return null;
        }
        int dataSize = AbstractC0570Iu.A01(c02284v.A0C());
        if (dataSize > 1) {
            AbstractC02134g.A07(A01(0, 12, 82), A01(12, 26, 125) + dataSize);
            return null;
        }
        UUID uuid = new UUID(c02284v.A0P(), c02284v.A0P());
        if (dataSize == 1) {
            c02284v.A0g(c02284v.A0L() * 16);
        }
        int atomType = c02284v.A0L();
        String[] strArr = A01;
        if (strArr[2].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A01[6] = "Op4nBnIC0DPoqkcvuw04qL";
        if (atomType != c02284v.A07()) {
            return null;
        }
        byte[] bArr2 = new byte[atomType];
        c02284v.A0k(bArr2, 0, atomType);
        return new JG(uuid, dataSize, bArr2);
    }

    public static UUID A02(byte[] bArr) {
        JG parsedAtom = A00(bArr);
        if (parsedAtom != null) {
            return parsedAtom.A01;
        }
        return null;
    }
}
