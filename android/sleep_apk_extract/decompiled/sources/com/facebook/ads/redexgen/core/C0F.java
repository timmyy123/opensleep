package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0F, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes.dex */
public final class C0F {
    public static byte[] A00;
    public static String[] A01 = {"1DQLZ1rq4NIZGDZ", "M27x7uLXr8W8z6FBpz", "QiRVHYZbaaQy04eLnAf", "IUWbXisoiWRubDZ2DWGyYlgf", "7fZtGPTC8N131cwHLDb", "WH1t2xD2R2zn", "HR89Gzy0Q3G", "ZYvoohNn3qjMZ9YFxZuTTpCr"};
    public static final /* synthetic */ C0F[] A02;
    public static final C0F A03;
    public static final C0F A04;
    public static final C0F A05;
    public static final C0F A06;
    public static final C0F A07;
    public static final C0F A08;
    public static final C0F A09;
    public static final C0F A0A;
    public static final C0F A0B;
    public static final C0F A0C;
    public static final C0F A0D;
    public static final C0F A0E;
    public static final C0F A0F;
    public static final C0F A0G;
    public static final C0F A0H;
    public static final C0F A0I;
    public static final C0F A0J;
    public static final C0F A0K;
    public static final C0F A0L;
    public static final C0F A0M;
    public static final C0F A0N;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{1, 18, 18, 1, 25, 17, 30, 30, 27, 20, 16, 29, -84, -61, -66, -81, -13, -8, -15, 2, 10, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9, 18, 7, 24, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, -100, -89, -83, -102, -92, -99, -65, -52, -52, -55, -52, -14, 5, -14, -16, 2, 1, -18, -17, -7, -14, -63, -57, -54, -68, -49, -17, -12, -6, 2, 7, MqttWireMessage.MESSAGE_TYPE_PINGRESP, -2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -2, -4, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 2, 8, 7, -66, -63, -64, -71, 19, 20, 19, 10, 16, 23, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 28, 33, 21, 18, 31, -32, -47, -45, -37, -47, -41, -43, -70, -81, -74, -71, -69, -36, -31, -40, -51, -34, -55, -38, 35, 28, 23, 29, 28, 19, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 6, 1, 25, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 6, 5, 3, 20, 6};
    }

    static {
        A01();
        A04 = new C0F(A00(5, 7, 126), 0);
        A05 = new C0F(A00(12, 4, 25), 1);
        A0J = new C0F(A00(93, 5, 22), 2);
        A0C = new C0F(A00(54, 3, 85), 3);
        A0E = new C0F(A00(69, 4, 33), 4);
        A06 = new C0F(A00(16, 4, 95), 5);
        A0B = new C0F(A00(49, 5, 42), 6);
        A08 = new C0F(A00(28, 6, 7), 7);
        A0M = new C0F(A00(110, 4, 108), 8);
        A0F = new C0F(A00(73, 4, 116), 9);
        A0G = new C0F(A00(77, 4, 113), 10);
        A03 = new C0F(A00(0, 5, 111), 11);
        A07 = new C0F(A00(20, 8, 117), 12);
        A09 = new C0F(A00(34, 5, 41), 13);
        A0K = new C0F(A00(98, 7, 55), 14);
        A0N = new C0F(A00(114, 8, 113), 15);
        A0I = new C0F(A00(86, 7, 63), 16);
        A0A = new C0F(A00(39, 10, 92), 17);
        A0H = new C0F(A00(81, 5, 124), 18);
        A0L = new C0F(A00(105, 5, 125), 19);
        A0D = new C0F(A00(57, 12, 104), 20);
        A02 = A02();
    }

    public C0F(String str, int i) {
    }

    public static /* synthetic */ C0F[] A02() {
        C0F[] c0fArr = new C0F[21];
        c0fArr[0] = A04;
        c0fArr[1] = A05;
        c0fArr[2] = A0J;
        c0fArr[3] = A0C;
        c0fArr[4] = A0E;
        c0fArr[5] = A06;
        c0fArr[6] = A0B;
        c0fArr[7] = A08;
        c0fArr[8] = A0M;
        c0fArr[9] = A0F;
        c0fArr[10] = A0G;
        c0fArr[11] = A03;
        c0fArr[12] = A07;
        c0fArr[13] = A09;
        c0fArr[14] = A0K;
        c0fArr[15] = A0N;
        c0fArr[16] = A0I;
        c0fArr[17] = A0A;
        C0F c0f = A0H;
        String[] strArr = A01;
        if (strArr[2].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        A01[0] = "Hgmq0BxEPxBnQrs";
        c0fArr[18] = c0f;
        c0fArr[19] = A0L;
        c0fArr[20] = A0D;
        return c0fArr;
    }

    public static C0F valueOf(String str) {
        return (C0F) Enum.valueOf(C0F.class, str);
    }

    public static C0F[] values() {
        return (C0F[]) A02.clone();
    }
}
