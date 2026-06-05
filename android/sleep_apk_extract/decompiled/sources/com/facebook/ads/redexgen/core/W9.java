package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class W9 {
    public static boolean A00;
    public static byte[] A01;
    public static final Map<String, Long> A02;
    public static final Map<String, Long> A03;
    public static final Map<String, String> A04;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A01 = new byte[]{96, 54, 127, 96, 54, 127, 96, 33, 127, 96, 33, 127, 96, 33, 82, 92, 4, 92, 0, 87, 85, 85, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 45, 55, 48, 57, 126, 50, 63, 45, 42, 126, 63, 58, 126, 44, 59, 45, 46, 49, 48, 45, 59, 65, 67, 82, 106, 71, 85, 82, 116, 67, 85, 86, 73, 72, 85, 67};
    }

    static {
        A04();
        A03 = new ConcurrentHashMap();
        A02 = new ConcurrentHashMap();
        A04 = new ConcurrentHashMap();
        A00 = false;
    }

    public static long A00(String str, EnumC0896Vq enumC0896Vq) {
        if (A03.containsKey(str)) {
            return A03.get(str).longValue();
        }
        switch (enumC0896Vq) {
            case A0E:
            case A0F:
            case A0G:
            case A0D:
                return 15000L;
            default:
                return -1000L;
        }
    }

    public static String A02(WA wa) {
        AbstractC0904Vy.A05(A01(44, 15, 126), A01(22, 22, 6), A01(14, 8, 61));
        return A04.get(A03(wa));
    }

    public static String A03(WA wa) {
        return String.format(Locale.US, A01(0, 14, 29), wa.A09(), wa.A07(), Integer.valueOf(wa.A08() == null ? 0 : wa.A08().A00()), Integer.valueOf(wa.A08() == null ? 0 : wa.A08().A01()), Integer.valueOf(wa.A04()));
    }

    public static void A05(long j, WA wa) {
        A03.put(A03(wa), Long.valueOf(j));
    }

    public static void A06(WA wa) {
        A02.put(A03(wa), Long.valueOf(System.currentTimeMillis()));
    }

    public static void A07(String str, WA wa) {
        A04.put(A03(wa), str);
    }

    public static boolean A08(WA wa) {
        if (A00) {
            return false;
        }
        String strA03 = A03(wa);
        if (A02.containsKey(strA03)) {
            return System.currentTimeMillis() - A02.get(strA03).longValue() < A00(strA03, wa.A07());
        }
        return false;
    }
}
