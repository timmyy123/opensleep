package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class XL {
    public static byte[] A00;
    public static String[] A01 = {"qSiXKiq1IG9lqM50Z2Mb9O8Z2LWgBu", "r2U8xUOmaYVPqVNF7ipuwqUkClKOL9fI", "t2SmaoScOMFcI6wk6u94gycUTd7TrCEv", "g958mvzQCDN4laMR6tofpj9QKe8MWy18", "srt0ITOyv23HblPPEDvfXyJdFCTOXScH", "yBqqog3SgBsnKDzcKk1fPvagOkeR5j", "3gR", "V2iGxa"};

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{16, 23, 27, 24, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 5, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 27, 21, 26, 35, 32, 43, 44};
    }

    static {
        A02();
    }

    public static String A00(float f) {
        if (A03(f)) {
            return A01(10, 4, 69);
        }
        if (A05(f)) {
            return A01(0, 4, 126);
        }
        if (A04(f)) {
            return A01(4, 3, 96);
        }
        String strA01 = A01(7, 3, 112);
        String[] strArr = A01;
        if (strArr[0].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        A01[4] = "joCrsBqpJwLPerzsPAAgEpnRec6YcWpS";
        return strA01;
    }

    public static boolean A03(float f) {
        return f <= 0.7f;
    }

    public static boolean A04(float f) {
        return f == 1.0f;
    }

    public static boolean A05(float f) {
        return f >= 1.2f;
    }
}
