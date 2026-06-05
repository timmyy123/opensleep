package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.Collections;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1759mf extends AbstractC0545Hu {
    public static byte[] A03;
    public static String[] A04 = {"lB4dHhjpy3abWZhQq1wH5EBAR", "ZuPpDuw", "FbPLOQU", "", "U7rP1AfGJoZ3goBfYNThYKT2IP", "TmhX3SF8er8D0wPa9QxyxNkwR", "Alay8YZwXgHUhbAemAZh94CmGu", "aeAWKwor"};
    public static final int[] A05;
    public int A00;
    public boolean A01;
    public boolean A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 29);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        String[] strArr = A04;
        if (strArr[6].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[6] = "jv2UBL9GlnQlzNWQDlysyfO0pU";
        strArr2[4] = "rlPmYvRzpLfwn1KnxKXQ0LEEGB";
        A03 = new byte[]{-37, 15, -2, 3, 9, -70, 0, 9, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 7, -5, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -70, 8, 9, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -70, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 15, 10, 10, 9, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -1, -2, -44, -70, -33, -13, -30, -25, -19, -83, -27, -75, -81, -81, -85, -33, -22, -33, -11, -88, -68, -85, -80, -74, 118, -82, 126, 120, 120, 116, -76, -77, -88, -66, 126, -110, -127, -122, -116, 76, -118, -115, 81, 126, 74, -119, 126, -111, -118, -72, -52, -69, -64, -58, -122, -60, -57, -68, -66};
    }

    static {
        A01();
        A05 = new int[]{5512, 11025, 22050, 44100};
    }

    public C1759mf(InterfaceC0528Hd interfaceC0528Hd) {
        super(interfaceC0528Hd);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0545Hu
    public final boolean A0B(C02284v c02284v) throws C1755mb {
        if (!this.A02) {
            int iA0I = c02284v.A0I();
            int header = iA0I >> 4;
            this.A00 = header & 15;
            if (this.A00 == 2) {
                int header2 = iA0I >> 2;
                super.A00.A6e(new C01722p().A11(A00(73, 10, 58)).A0b(1).A0m(A05[header2 & 3]).A14());
                this.A01 = true;
            } else if (this.A00 == 7 || this.A00 == 8) {
                super.A00.A6e(new C01722p().A11(this.A00 == 7 ? A00(28, 15, 97) : A00(43, 15, 42)).A0b(1).A0m(8000).A14());
                this.A01 = true;
            } else if (this.A00 != 10) {
                throw new C1755mb(A00(0, 28, 125) + this.A00);
            }
            this.A02 = true;
        } else {
            c02284v.A0g(1);
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0545Hu
    public final boolean A0C(C02284v c02284v, long j) throws C3K {
        if (this.A00 == 2) {
            int iA07 = c02284v.A07();
            super.A00.AIr(c02284v, iA07);
            super.A00.AIu(j, 1, iA07, 0, null);
            return true;
        }
        int iA0I = c02284v.A0I();
        if (iA0I == 0 && !this.A01) {
            int packetType = c02284v.A07();
            byte[] bArr = new byte[packetType];
            int packetType2 = bArr.length;
            c02284v.A0k(bArr, 0, packetType2);
            C0511Gm c0511GmA03 = AbstractC0512Gn.A03(bArr);
            C01722p c01722pA0w = new C01722p().A11(A00(58, 15, 0)).A0w(c0511GmA03.A02);
            int packetType3 = c0511GmA03.A00;
            C01722p c01722pA0b = c01722pA0w.A0b(packetType3);
            int packetType4 = c0511GmA03.A01;
            super.A00.A6e(c01722pA0b.A0m(packetType4).A12(Collections.singletonList(bArr)).A14());
            this.A01 = true;
            return false;
        }
        if (this.A00 == 10 && iA0I != 1) {
            return false;
        }
        int iA072 = c02284v.A07();
        super.A00.AIr(c02284v, iA072);
        super.A00.AIu(j, 1, iA072, 0, null);
        return true;
    }
}
