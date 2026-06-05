package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import android.os.Build;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1546iq {

    @Nullable
    public static Boolean A00;
    public static byte[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 125);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{106, 77, 69, 64, 73, 72, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 88, 67, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 75, 73, 88, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 65, 73, 72, 69, 77, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 111, 67, 72, 73, 79, 7, 42, 61, 32, 10, 55, 32, 26, 59, 38, 35, 97, 114, 121, 115, 120, 101, 57, 100, 114, 116, 58, 118, 126, 113, 101, 116, 58, 99, 101, 118, 121, 100, 113, 114, 101, 58, 101, 114, 102, 98, 114, 100, 99, 57, 97, 118, 123, 98, 114, 65, 94, 83, 82, 88, 24, 86, 65, 84};
    }

    static {
        A01();
        A00 = null;
    }

    public static boolean A02() {
        if (A00 != null) {
            return A00.booleanValue();
        }
        A00 = false;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(A00(75, 9, 74));
                Iterator<String> it = mediaCodecCreateDecoderByType.getSupportedVendorParameters().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String param = it.next();
                    if (param.equals(A00(36, 39, 106))) {
                        A00 = true;
                        break;
                    }
                }
                mediaCodecCreateDecoderByType.release();
            }
        } catch (IOException e) {
            String param2 = A00(25, 11, 50);
            AbstractC1478hd.A02(param2, A00(0, 25, 81), e);
        }
        return A00.booleanValue();
    }

    public static boolean A03(int i, int i2) {
        if (i >= 480 && i2 >= 480 && i <= 3840 && i2 <= 2160) {
            return true;
        }
        return false;
    }
}
