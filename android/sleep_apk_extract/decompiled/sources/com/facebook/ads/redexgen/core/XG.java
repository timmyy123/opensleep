package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdSize;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class XG {
    public static byte[] A00;
    public static String[] A01 = {"NoYeCqw0NuwsBVSvR8aiyPnoj7", "APA6ODPEmALJh8xHCjcwQdd6vsoZzjc", "og2YXunKDp8EqsbnYhzdu6qR", "YLuKSEsrRIdzXIjkloLmDmBrtZDR6KFi", "8qSAHAaIpnwwIsCvL7AfoFTJYv1h46H2", "PXVMr", "05SrQOor", "5yYP5"};
    public static final Map<EnumC0895Vp, EnumC0896Vq> A02;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{104, 74, 69, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 95, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 72, 89, 78, 74, 95, 78, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 106, 79, 120, 66, 81, 78, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 94, 88, 66, 69, 76, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 95, 67, 66, 88, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 92, 66, 79, 95, 67, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 74, 69, 79, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 67, 78, 66, 76, 67, 95, 5, 50, 9, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 9, 8, 16, 9, 71, 38, 3, 52, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 29, 2, 71, 19, 30, 23, 2, 73};
    }

    static {
        A07();
        A02 = new HashMap();
        A02.put(EnumC0895Vp.A09, EnumC0896Vq.A0D);
        A02.put(EnumC0895Vp.A07, EnumC0896Vq.A0F);
        A02.put(EnumC0895Vp.A06, EnumC0896Vq.A0E);
    }

    public static AdSize A00(EnumC0895Vp enumC0895Vp) {
        return AdSize.fromWidthAndHeight(enumC0895Vp.A04(), enumC0895Vp.A03());
    }

    public static AdSize A01(EnumC0896Vq enumC0896Vq) {
        for (Map.Entry<EnumC0895Vp, EnumC0896Vq> entry : A02.entrySet()) {
            if (entry.getValue() == enumC0896Vq) {
                EnumC0895Vp key = entry.getKey();
                if (A01[3].charAt(31) == 'z') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[5] = "vUJqh";
                strArr[7] = "m1G2X";
                return A00(key);
            }
        }
        return AdSize.BANNER_320_50;
    }

    public static EnumC0895Vp A02(int i) {
        switch (i) {
            case 4:
                return EnumC0895Vp.A05;
            case 5:
                return EnumC0895Vp.A06;
            case 6:
                return EnumC0895Vp.A07;
            case 7:
                return EnumC0895Vp.A09;
            case 100:
                return EnumC0895Vp.A08;
            default:
                throw new IllegalArgumentException(A06(48, 20, 117));
        }
    }

    public static EnumC0895Vp A03(int i, int i2) {
        if (EnumC0895Vp.A08.A03() == i2 && EnumC0895Vp.A08.A04() == i) {
            return EnumC0895Vp.A08;
        }
        if (EnumC0895Vp.A05.A03() == i2) {
            int iA04 = EnumC0895Vp.A05.A04();
            String[] strArr = A01;
            if (strArr[5].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A01[3] = "mZi1y4qoTe3Eq90wST2K5ufjmqQARasa";
            if (iA04 == i) {
                return EnumC0895Vp.A05;
            }
        }
        if (EnumC0895Vp.A06.A03() == i2 && EnumC0895Vp.A06.A04() == i) {
            return EnumC0895Vp.A06;
        }
        if (EnumC0895Vp.A07.A03() == i2 && EnumC0895Vp.A07.A04() == i) {
            return EnumC0895Vp.A07;
        }
        if (EnumC0895Vp.A09.A03() == i2) {
            EnumC0895Vp enumC0895Vp = EnumC0895Vp.A09;
            String[] strArr2 = A01;
            if (strArr2[6].length() == strArr2[0].length()) {
                throw new RuntimeException();
            }
            A01[3] = "Hv8n5Vk5MDnKIrkb6r8Yx0AFcMxyPOg2";
            if (enumC0895Vp.A04() == i) {
                return EnumC0895Vp.A09;
            }
        }
        throw new IllegalArgumentException(A06(0, 48, 57));
    }

    public static EnumC0895Vp A04(AdSize adSize) {
        return A03(adSize.getWidth(), adSize.getHeight());
    }

    public static EnumC0896Vq A05(EnumC0895Vp enumC0895Vp) {
        EnumC0896Vq adTemplate = A02.get(enumC0895Vp);
        if (adTemplate == null) {
            return EnumC0896Vq.A0G;
        }
        return adTemplate;
    }
}
