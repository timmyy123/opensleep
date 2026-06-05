package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class O5 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 77, 81, 72, 73, 93, 90, 64, 81, 70, 71, 64, 93, 64, 93, 85, 88};
    }

    public static void A02(C1421gi c1421gi, AbstractC1586jd abstractC1586jd, boolean z, O3 o3) {
        if (!C0871Up.A2E(c1421gi)) {
            C0827Sx c0827Sx = new C0827Sx(c1421gi);
            C0693No c0693NoA07 = abstractC1586jd.A29().A0H().A07();
            c0827Sx.A0e(new VI(abstractC1586jd.A2E(), c1421gi.A0A()));
            if (c0693NoA07 == null) {
                o3.AFF(AdError.CACHE_ERROR);
                return;
            }
            if (c0693NoA07.A0Y()) {
                o3.AFG();
                return;
            }
            C0823St c0823St = new C0823St(c0693NoA07.A0L(), abstractC1586jd.A1D(), abstractC1586jd.A10());
            c0823St.A04 = true;
            c0823St.A03 = A00(0, 5, 86);
            switch (O2.A00[c0693NoA07.A0G().ordinal()]) {
                case 1:
                case 2:
                    c0827Sx.A0Y(c0823St);
                    break;
            }
            c0827Sx.A0c(new C0825Sv(abstractC1586jd.A2C().A01(), -1, -1, abstractC1586jd.A1D(), abstractC1586jd.A10()));
            c0827Sx.A0c(new C0825Sv(c0693NoA07.A0K(), -1, -1, abstractC1586jd.A1D(), abstractC1586jd.A10()));
            O0.A00(abstractC1586jd, c0827Sx, A00(5, 12, 71));
            c0827Sx.A0X(new C1564jA(c1421gi, o3, c0827Sx, c0693NoA07, z), new C0820Sq(abstractC1586jd.A1D(), abstractC1586jd.A10()));
            return;
        }
        o3.AFG();
    }
}
