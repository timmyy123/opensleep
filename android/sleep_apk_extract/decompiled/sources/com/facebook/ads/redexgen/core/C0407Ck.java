package com.facebook.ads.redexgen.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ck, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0407Ck implements InterfaceC1388gB {
    public static byte[] A01;
    public final boolean A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{75, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 48, 28, 29, 7, 22, 29, 7, 73, 83, 42, 29, 27, 29, 17, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 29, 88, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, 20, 66, 88, 30, 57, 44, 57, 56, 62, 119, 109};
    }

    public C0407Ck(boolean z) {
        this.A00 = z;
    }

    private void A02(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                for (String header : map.get(str)) {
                    String str2 = str + A00(1, 1, 74) + header;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1388gB
    public final boolean AAZ() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1388gB
    public final void ABt(HttpURLConnection httpURLConnection, Object obj) throws IOException {
        String str = httpURLConnection.getRequestMethod() + A00(0, 1, 21) + httpURLConnection.getURL().toString();
        if (obj instanceof String) {
            String str2 = A00(2, 9, 13) + ((String) obj);
        }
        A02(httpURLConnection.getRequestProperties());
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1388gB
    public final void ABu(InterfaceC1371fu interfaceC1371fu) {
        if (interfaceC1371fu != null) {
            String str = A00(11, 13, 6) + interfaceC1371fu.getUrl();
            String str2 = A00(24, 8, 51) + interfaceC1371fu.A9C();
            A02(interfaceC1371fu.A8E());
        }
    }
}
