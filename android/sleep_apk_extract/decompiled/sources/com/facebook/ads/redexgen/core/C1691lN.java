package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1691lN implements InterfaceC0623Kv {
    public static byte[] A06;
    public int A00;
    public int A01;
    public long A02 = -9223372036854775807L;
    public boolean A03;
    public final List<LC> A04;
    public final InterfaceC0528Hd[] A05;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{1, 16, 16, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 9, 3, 1, 20, 9, 15, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -49, 4, 22, 2, 19, 21, 2, 19};
    }

    public C1691lN(List<LC> list) {
        this.A04 = list;
        this.A05 = new InterfaceC0528Hd[list.size()];
    }

    private boolean A02(C02284v c02284v, int i) {
        if (c02284v.A07() == 0) {
            return false;
        }
        if (c02284v.A0I() != i) {
            this.A03 = false;
        }
        this.A00--;
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void A5A(C02284v c02284v) {
        if (this.A03) {
            if (this.A00 == 2 && !A02(c02284v, 32)) {
                return;
            }
            if (this.A00 == 1 && !A02(c02284v, 0)) {
                return;
            }
            int iA09 = c02284v.A09();
            int iA07 = c02284v.A07();
            for (InterfaceC0528Hd interfaceC0528Hd : this.A05) {
                c02284v.A0f(iA09);
                interfaceC0528Hd.AIr(c02284v, iA07);
            }
            int dataPosition = this.A01;
            this.A01 = dataPosition + iA07;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A5c(HA ha, LG lg) {
        for (int i = 0; i < i; i++) {
            LC lc = this.A04.get(i);
            lg.A05();
            InterfaceC0528Hd interfaceC0528HdAKS = ha.AKS(lg.A03(), 3);
            interfaceC0528HdAKS.A6e(new C01722p().A0y(lg.A04()).A11(A00(0, 19, 111)).A12(Collections.singletonList(lc.A02)).A10(lc.A01).A14());
            this.A05[i] = interfaceC0528HdAKS;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void AGp() {
        if (this.A03) {
            if (this.A02 != -9223372036854775807L) {
                for (InterfaceC0528Hd interfaceC0528Hd : this.A05) {
                    interfaceC0528Hd.AIu(this.A02, 1, this.A01, 0, null);
                }
            }
            this.A03 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void AGq(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.A03 = true;
        if (j != -9223372036854775807L) {
            this.A02 = j;
        }
        this.A01 = 0;
        this.A00 = 2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0623Kv
    public final void AJ5() {
        this.A03 = false;
        this.A02 = -9223372036854775807L;
    }
}
