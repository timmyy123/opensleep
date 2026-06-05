package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class XP implements VM {
    public static byte[] A04;
    public static String[] A05 = {"HMqNF3eSIzlMBYXVNU3nP1NvWYo5", "x1o785RKTr7Jq0RcU0BPUyycJ3fBjUeE", "GBfmO3K", "Po", "VaaklUluHJvo1XkXnH3kavV5L6d7gpHG", "rG9SvJ3uZ6", "s9MPDvRc6n", "AU4sbnw7bsTTRuLyXll9UaPcK28fS"};
    public static final String A06;
    public ViewOnAttachStateChangeListenerC0933Xe A00;
    public C2030rN<C0878Uw, V1> A01;
    public final C1417ge A02;
    public final C0361Ao A03 = C0361Ao.A01();

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A05[1].length() == 18) {
                throw new RuntimeException();
            }
            A05[1] = "YaUcq3PJYQGMSsmKTTLasxzUL6lFeW7O";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 121);
            i4++;
        }
    }

    public static void A02() {
        A04 = new byte[]{79, 115, 126, 59, 118, 126, 127, 114, 122, 59, 120, 105, 126, 122, 111, 114, 109, 126, 59, 109, 114, 126, 108, 59, 114, 104, 59, 117, 110, 119, 119, 53, 121, 66, 94, 73, 75, 69, 95, 88, 73, 94, 69, 66, 75, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 77, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 66, 89, 64, 64, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 79, 94, 73, 77, 88, 69, 90, 73, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 90, 69, 73, 91, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 83, 108, 96, 114, 117, 106, 108, 107, 113, 65, 100, 113, 100, 37, 108, 118, 37, 107, 112, 105, 105, 36, 25, 15, 9, 5, 4, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 53, 9, 2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4, 4, 15, 6};
    }

    static {
        A02();
        A06 = XP.class.getSimpleName();
    }

    public XP(C1417ge c1417ge) {
        this.A02 = c1417ge;
    }

    private void A01() {
        this.A02.A08().ABC(A00(89, 14, 19), 3600, new C0834Te(A00(67, 22, 124)));
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void ADb() {
        if (this.A01 != null) {
            this.A01.A07.A00();
        } else {
            A01();
        }
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void AGc() {
        if (this.A01 != null) {
            this.A01.A07.A03();
        } else {
            A01();
        }
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void AKU(View view) {
        if (this.A01 == null) {
            this.A02.A08().ABC(A00(89, 14, 19), 3600, new C0834Te(A00(32, 35, 85)));
            return;
        }
        this.A03.A08(view);
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void AKn(View view, String str, boolean z) {
        AKo(view, str, z, false);
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void AKo(View view, String str, boolean z, boolean z2) {
        AKp(view, str, z, z2, false);
    }

    @Override // com.facebook.ads.redexgen.core.VM
    public final void AKp(View view, String str, boolean z, boolean z2, boolean z3) {
        if (view != null) {
            this.A00 = new ViewOnAttachStateChangeListenerC0933Xe(view, this.A02);
            this.A03.A0A(this.A00, view);
            if (z2) {
                this.A00.A04();
            }
            this.A01 = C2030rN.A00(new C0878Uw(this.A02, view, str, z, z3), new V1(), A06).A06(new C0934Xf(new XM())).A07();
            this.A03.A09(view, this.A01);
            return;
        }
        this.A02.A08().ABC(A00(89, 14, 19), 3600, new C0834Te(A00(0, 32, 98)));
    }
}
