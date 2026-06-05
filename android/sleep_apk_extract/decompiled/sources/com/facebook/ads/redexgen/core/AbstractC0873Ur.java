package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ur, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0873Ur {
    public static byte[] A00;
    public static String[] A01 = {"Z5CDeKIRbdSSRSQIrVuvkRGSoBqaj2vD", "vAYmZT8ASJMB3FzzuSGq4ydCUrxXwpoH", "w5gGutYUngeqRFsCKcvWOvxRavdUOOsS", "yOEODZsyHWLZAvoEgSYJGhZTBHDJn", "rt7Bq94iIT4vcXtoKSYLP1d4W6MwPUTJ", "NG6XHFEJ7LlyPEQHkLbosD3XyF7yGiUv", "J0QPPK8CgABCN6AkZrLHMYAzYl1dWHal", "XBXEBoD0FueyJiRlgHiLQagWcf9HuHXl"};

    public static String A0L(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0N() {
        A00 = new byte[]{80, 28, 62, 49, 120, 43, 127, 47, 62, 45, 44, 58, 127, 44, 62, 50, 47, 51, 54, 49, 56, 113, 52, 50, 23, 18, 18, 31, 2, 31, 25, 24, 23, 26, 41, 18, 19, 20, 3, 17, 41, 26, 25, 17, 17, 31, 24, 17, 41, 20, 26, 23, 21, 29, 41, 26, 31, 5, 2, 10, 15, 15, 2, 31, 2, 4, 5, 10, 7, 52, 15, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 9, 30, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 52, 7, 4, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 2, 5, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 52, 9, 7, 10, 8, 0, 52, 7, 2, 24, 31, 52, 27, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 25, 8, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 5, 31, 10, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 39, 34, 34, 47, 50, 47, 41, 40, 39, 42, 25, 34, 35, 36, 51, 33, 25, 42, 41, 33, 33, 47, 40, 33, 25, 53, 39, 43, 54, 42, 47, 40, 33, 25, 54, 35, 52, 37, 35, 40, 50, 39, 33, 35, 84, 81, 91, 66, 106, 84, 81, 81, 92, 65, 92, 90, 91, 84, 89, 106, 89, 90, 82, 82, 92, 91, 82, 106, 71, 80, 65, 71, 76, 106, 89, 92, 88, 92, 65, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 9, 3, 26, 50, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 9, 9, 4, 25, 4, 2, 3, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 1, 50, 1, 2, 10, 10, 4, 3, 10, 50, 24, 30, 8, 50, 25, 8, 0, 29, 50, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4, 1, 8, 50, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 2, 31, 50, 31, 8, 26, 31, 4, 25, 8, 112, 117, 127, 102, 78, 112, 127, 117, 99, 126, 120, 117, 78, 112, 125, 102, 112, 104, 98, 78, 125, 126, 118, 78, 114, 126, 99, 116, 78, 119, 100, 127, 127, 116, 125, 78, 116, 103, 116, 127, 101, 98, 70, 67, 73, 80, 120, 70, 73, 67, 85, 72, 78, 67, 120, 68, 70, 68, 79, 66, 120, 67, 66, 69, 82, 64, 120, 66, 81, 66, 73, 83, 84, 120, 84, 70, 74, 87, 75, 78, 73, 64, 120, 85, 70, 83, 66, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 9, 3, 26, 50, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 3, 9, 31, 2, 4, 9, 50, 9, 4, 30, 29, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 25, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 5, 8, 31, 50, 4, 3, 4, 25, 4, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 1, 50, 31, 8, 25, 31, 20, 50, 9, 8, 1, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 20, 50, 0, 30, 83, 86, 92, 69, 109, 83, 92, 86, 64, 93, 91, 86, 109, 86, 91, 65, 66, 83, 70, 81, 90, 87, 64, 109, 95, 83, 74, 109, 64, 87, 70, 64, 75, 109, 81, 93, 71, 92, 70, 48, 53, 63, 38, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 48, 63, 53, 35, 62, 56, 53, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 55, 36, 63, 63, 52, 61, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 53, 52, 51, 36, 54, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 52, 39, 52, 63, 37, 34, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 34, 48, 60, 33, 61, 56, 63, 54, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 35, 48, 37, 52, 68, 65, 75, 82, 122, 68, 75, 65, 87, 74, 76, 65, 122, 76, 85, 70, 122, 65, 64, 71, 80, 66, 122, 64, 83, 64, 75, 81, 86, 122, 86, 68, 72, 85, 73, 76, 75, 66, 122, 87, 68, 81, 64, 54, 51, 57, 32, 8, 54, 57, 51, 37, 56, 62, 51, 8, 59, 56, 52, 54, 59, 8, 52, 56, 34, 57, 35, 50, 37, 36, 8, 36, 54, 58, 39, 59, 62, 57, 48, 8, 37, 54, 35, 50, 77, 72, 66, 91, 115, 77, 66, 72, 94, 67, 69, 72, 115, 66, 77, 88, 69, 90, 73, 115, 90, 69, 73, 91, 77, 78, 69, 64, 69, 88, 85, 115, 68, 69, 95, 88, 67, 94, 85, 115, 95, 77, 65, 92, 64, 69, 66, 75, 115, 94, 77, 88, 73, 91, 94, 84, 77, 101, 91, 84, 94, 72, 85, 83, 94, 101, 84, 95, 78, 77, 85, 72, 81, 101, 94, 95, 88, 79, 93, 101, 95, 76, 95, 84, 78, 73, 101, 73, 91, 87, 74, 86, 83, 84, 93, 101, 72, 91, 78, 95, 76, 73, 67, 90, 114, 76, 67, 73, 95, 66, 68, 73, 114, 88, 94, 72, 114, 65, 66, 78, 76, 65, 114, 78, 66, 88, 67, 89, 72, 95, 94, 123, 126, 116, 109, 69, 126, 127, 120, 111, 125, 69, 118, 117, 125, 69, 124, 115, 118, 127, 69, 105, 115, 96, 127, 69, 118, 115, 119, 115, 110, 69, 120, 99, 110, 127, 105, 73, 76, 70, 95, 119, 76, 77, 74, 93, 79, 119, 68, 71, 79, 79, 65, 70, 79, 120, 125, 119, 110, 70, 125, 124, 123, 108, 126, 70, 117, 118, 126, 126, 112, 119, 126, 70, 124, 111, 124, 119, 109, 70, 117, 112, 116, 112, 109, 19, 22, 28, 5, 45, 30, 29, 21, 45, 19, 22, 22, 27, 6, 27, 29, 28, 19, 30, 45, 30, 29, 21, 21, 27, 28, 21, 45, 23, 4, 23, 28, 6, 1, 45, 30, 27, 31, 27, 6, 53, 48, 58, 35, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 56, 59, 51, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 53, 48, 48, 61, 32, 61, 59, 58, 53, 56, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 56, 59, 51, 51, 61, 58, 51, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 61, 58, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 57, 49, 57, 59, 38, 45, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 49, 34, 49, 58, 32, 39, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 56, 61, 57, 61, 32, 73, 76, 70, 95, 119, 68, 71, 79, 119, 73, 76, 76, 65, 92, 65, 71, 70, 73, 68, 119, 68, 71, 79, 79, 65, 70, 79, 119, 91, 77, 91, 91, 65, 71, 70, 119, 77, 94, 77, 70, 92, 91, 119, 73, 68, 95, 73, 81, 91, 48, 53, 63, 38, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 34, 52, 63, 53, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 48, 53, 53, 56, 37, 56, 62, 63, 48, 61, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 53, 52, 51, 36, 54, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 61, 62, 54, 54, 56, 63, 54, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 34, 37, 48, 50, 58, 37, 35, 48, 50, 52, 122, 127, 117, 108, 68, 104, 115, 116, 110, 119, 127, 68, 110, 104, 126, 68, 125, 114, 119, 126, 68, 121, 122, 104, 126, 127, 68, 105, 126, 120, 116, 105, 127, 68, 127, 122, 111, 122, 121, 122, 104, 126, 32, 37, 47, 54, 30, 52, 50, 36, 30, 50, 41, 46, 51, 53, 30, 36, 47, 55, 30, 37, 32, 53, 32, 30, 
        39, 46, 51, 30, 32, 37, 37, 40, 53, 40, 46, 47, 32, 45, 30, 45, 46, 38, 38, 40, 47, 38, 122, 124, 71, 124, 121, 108, 121, 71, 116, 119, 127, 127, 113, 118, 127, 71, 116, 113, 117, 113, 108, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 16, 23, 24, 23, 27, 26, 33, 18, 17, 25, 25, 23, 16, 25, 33, 26, 23, MqttWireMessage.MESSAGE_TYPE_PINGRESP, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 31, 10, 29, 22, 33, 23, 16, 10, 27, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 8, 31, 18, 33, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 27, 29, 17, 16, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 66, 89, 94, 81, 94, 82, 83, 104, 91, 88, 80, 80, 94, 89, 80, 104, 82, 65, 82, 89, 67, 104, 91, 94, 90, 94, 67, 3, 24, 31, 16, 31, 19, 18, 41, 26, 25, 17, 17, 31, 24, 17, 41, 31, 27, 27, 19, 18, 31, 23, 2, 19, 41, 18, 19, 26, 23, 15, 41, 27, 5, 102, 125, 122, 117, 122, 118, 119, 76, 127, 124, 116, 116, 122, 125, 116, 76, 97, 118, 103, 97, 106, 76, 127, 122, 126, 122, 103};
    }

    static {
        A0N();
    }

    public static int A00(Context context) {
        return C0871Up.A0V(context).A32(A0L(750, 40, 73), 10);
    }

    public static int A01(Context context) {
        return C0871Up.A0V(context).A32(A0L(790, 50, 111), 50);
    }

    public static int A02(Context context) {
        return C0871Up.A0V(context).A32(A0L(149, 35, 14), 1);
    }

    public static int A03(Context context) {
        return A0H(context, A0L(59, 46, 80), 0);
    }

    public static int A04(Context context) {
        return A0H(context, A0L(105, 44, 125), 0);
    }

    public static int A05(Context context) {
        return C0871Up.A0V(context).A32(A0L(1022, 21, 35), 10);
    }

    public static int A06(Context context) {
        return C0871Up.A0V(context).A32(A0L(275, 45, 28), 0);
    }

    public static int A07(Context context) {
        return C0871Up.A0V(context).A32(A0L(666, 36, 33), 10485760);
    }

    public static int A08(Context context) {
        return C0871Up.A0V(context).A32(A0L(720, 30, 34), 30);
    }

    public static int A09(Context context) {
        return C0871Up.A0V(context).A32(A0L(366, 39, 9), 5);
    }

    public static int A0A(Context context) {
        return C0871Up.A0V(context).A32(A0L(405, 46, 106), 0);
    }

    public static int A0B(Context context) {
        return C0871Up.A0V(context).A32(A0L(451, 43, 30), 0);
    }

    public static int A0C(Context context) {
        return C0871Up.A0V(context).A32(A0L(494, 41, 108), 0);
    }

    public static int A0D(Context context) {
        return C0871Up.A0V(context).A32(A0L(535, 53, 23), 0);
    }

    public static int A0E(Context context) {
        return C0871Up.A0V(context).A32(A0L(588, 47, 1), 0);
    }

    public static int A0F(Context context) {
        return C0871Up.A0V(context).A32(A0L(1084, 27, 12), 30);
    }

    public static int A0G(Context context) {
        return C0871Up.A0V(context).A32(A0L(1145, 27, 40), 20);
    }

    public static int A0H(Context context, String str, int i) {
        int iA32 = C0871Up.A0V(context).A32(str, i);
        if (iA32 >= 0 && iA32 < 101) {
            return iA32;
        }
        return i;
    }

    public static long A0I(Context context) {
        return C0871Up.A0V(context).A33(A0L(320, 46, 86), 2000L);
    }

    public static long A0J(Context context) {
        return ((long) C0871Up.A0V(context).A32(A0L(1043, 41, 69), 300)) * 1000;
    }

    public static long A0K(Context context) {
        return C0871Up.A0V(context).A33(A0L(1111, 34, 77), 500L);
    }

    public static HashMap<String, Integer> A0M(Context context) throws JSONException {
        String blackListString = C0871Up.A0V(context).A34(A0L(24, 35, 77), A0L(22, 2, 84));
        HashMap<String, Integer> map = new HashMap<>();
        JSONArray jSONArray = new JSONArray(blackListString);
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(strOptString)) {
                String strA0L = A0L(0, 1, 85);
                if (strOptString.contains(strA0L)) {
                    String[] strArrSplit = strOptString.split(strA0L);
                    String blackListString2 = strArrSplit[1];
                    try {
                        int i2 = Integer.parseInt(blackListString2);
                        String str = strArrSplit[0];
                        Integer numValueOf = Integer.valueOf(i2);
                        String[] strArr = A01;
                        if (strArr[1].charAt(19) == strArr[6].charAt(19)) {
                            throw new RuntimeException();
                        }
                        A01[2] = "wzhVBTrm4NHLde2dsMQb3id1wgsCAtfS";
                        map.put(str, numValueOf);
                    } catch (NumberFormatException unused) {
                        throw new JSONException(A0L(1, 21, 100));
                    }
                } else {
                    String[] strArr2 = A01;
                    if (strArr2[1].charAt(19) != strArr2[6].charAt(19)) {
                        String[] strArr3 = A01;
                        strArr3[5] = "lVwzbqekYbQANiPk50jGeH7RXXU9rAeI";
                        strArr3[7] = "4HLNgzBPZBjDavwa2VUT1a0cI7AwYTVO";
                        map.put(strOptString, -1);
                    } else {
                        map.put(strOptString, -1);
                    }
                }
            }
        }
        return map;
    }

    public static boolean A0O(Context context) {
        return C0871Up.A0V(context).A38(A0L(184, 49, 86), true);
    }

    public static boolean A0P(Context context) {
        return C0871Up.A0V(context).A38(A0L(702, 18, 19), false);
    }

    public static boolean A0Q(Context context) {
        return C0871Up.A0V(context).A38(A0L(840, 49, 19), true);
    }

    public static boolean A0R(Context context) {
        return C0871Up.A0V(context).A38(A0L(889, 45, 106), false);
    }

    public static boolean A0S(Context context) {
        return C0871Up.A0V(context).A38(A0L(233, 42, 42), true);
    }

    public static boolean A0T(Context context) {
        return C0871Up.A0V(context).A38(A0L(934, 42, 32), false);
    }

    public static boolean A0U(Context context) {
        return C0871Up.A0V(context).A38(A0L(635, 31, 22), false);
    }

    public static boolean A0V(Context context) {
        return C0871Up.A0V(context).A38(A0L(976, 46, 122), true);
    }
}
