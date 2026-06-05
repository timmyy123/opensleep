package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class BA extends Exception {
    public static byte[] A05;
    public final B3 A00;
    public final BA A01;
    public final String A02;
    public final String A03;
    public final boolean A04;

    static {
        A05();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{0, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 49, 16, 22, 26, 17, 16, 7, 85, 28, 27, 28, 1, 85, 19, 20, 28, 25, 16, 17, 79, 85, 101, 68, 66, 78, 69, 68, 83, 1, 72, 79, 72, 85, 1, 71, 64, 72, 77, 68, 69, 27, 1, 122, 63, 78, 66, 29, 17, 19, 80, 24, 31, 29, 27, 28, 17, 17, 21, 80, 31, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 80, 31, 16, 26, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, 23, 26, 6, 80, 19, 27, 26, 23, 31, 77, 80, 27, 6, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 18, 31, 7, 27, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 80, 19, 27, 26, 23, 31, 29, 17, 26, 27, 29, 80, 51, 27, 26, 23, 31, 61, 17, 26, 27, 29, 44, 27, 16, 26, 27, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 27, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 33, 36, 47, 45, 21};
    }

    public BA(C1981qI c1981qI, Throwable th, boolean z, int i) {
        this(A03(23, 22, 80) + i + A03(45, 3, 19) + c1981qI, th, c1981qI.A0W, z, null, A02(i), null);
    }

    public BA(C1981qI c1981qI, Throwable th, boolean z, B3 b3) {
        this(A03(2, 21, 4) + b3.A03 + A03(0, 2, 93) + c1981qI, th, c1981qI.A0W, z, b3, C5C.A02 >= 21 ? A04(th) : null, null);
    }

    public BA(String str, Throwable th, String str2, boolean z, B3 b3, String str3, BA ba) {
        super(str, th);
        this.A03 = str2;
        this.A04 = z;
        this.A00 = b3;
        this.A02 = str3;
        this.A01 = ba;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BA A00(BA ba) {
        return new BA(getMessage(), getCause(), this.A03, this.A04, this.A00, this.A02, ba);
    }

    public static String A02(int i) {
        String strA03 = i < 0 ? A03(121, 4, 59) : A03(0, 0, 98);
        StringBuilder sb = new StringBuilder();
        String sign = A03(48, 73, 15);
        return sb.append(sign).append(strA03).append(Math.abs(i)).toString();
    }

    public static String A04(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
