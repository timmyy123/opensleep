package com.facebook.ads.redexgen.core;

import android.media.MediaFormat;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1892oq implements G2, GR, InterfaceC02877c {
    public static byte[] A04;
    public static String[] A05 = {"s2pX1dUuV9yMGkOQMpNHWy9uhNawnk9Y", "g94kU4b", "NzGTwCFJguijRpsE4vnu2khyHl2vzHxI", "mcwg2", "3H7kdFWigyqN00XNlLPoaD6s2Om", "arwBjFb", "zwCIEju4cqvLZ8D4reT2LOc82uEYQHt6", "4voNbHG588W1rePZ0VIdJriIAfqG9T"};
    public G2 A00;
    public G2 A01;
    public GR A02;
    public GR A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{2, 0, 17, 51, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 1, 0, 10, 35, 23, 4, 8, 0, 40, 0, 17, 4, 1, 4, 17, 4, 41, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 22, 17, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 0, 23};
    }

    static {
        A01();
    }

    public C1892oq() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC02877c
    public final void A9i(int i, Object obj) {
        switch (i) {
            case 7:
                this.A01 = (G2) obj;
                return;
            case 8:
                this.A02 = (GR) obj;
                return;
            case 10000:
                if (0 == 0) {
                    this.A00 = null;
                    this.A03 = null;
                    return;
                }
                throw new NullPointerException(A00(0, 29, 100));
            default:
                return;
        }
    }

    @Override // com.facebook.ads.redexgen.core.G2
    public final void AGS(long j, long j2, C1981qI c1981qI, MediaFormat mediaFormat) {
        if (this.A00 != null) {
            G2 g2 = this.A00;
            if (A05[0].charAt(20) != 'W') {
                throw new RuntimeException();
            }
            A05[4] = "rCzQpO90p93bI0FQ7tWj9IORt31";
            g2.AGS(j, j2, c1981qI, mediaFormat);
        }
        if (this.A01 != null) {
            this.A01.AGS(j, j2, c1981qI, mediaFormat);
        }
    }
}
