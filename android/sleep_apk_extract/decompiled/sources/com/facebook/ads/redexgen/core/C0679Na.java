package com.facebook.ads.redexgen.core;

import android.graphics.Color;
import java.io.Serializable;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Na, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0679Na implements Serializable {
    public static byte[] A0A = null;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final long serialVersionUID = 8946536326456653736L;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 68);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0A = new byte[]{110, 125, 126, 125, -126, 125, -111, 121, -118, -72, -118, -68, -117, -116, -77, -55, -64, -55, -60, -55, -13, -113, -46, -94, -46, -93, -46, -91, -128, -61, -61, -111, -115, -107, -115, -61, -61, -64, -62, -62, -60, -51, -45, -66, -62, -50, -53, -50, -47, 24, 29, 21, 25, 37, 34, 37, 40, 22, 35, 24, 45, 19, 23, 35, 32, 35, 38, 27, 44, 25, 23, 27, 39, 36, 39, 42, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 31, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 10, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 26, 23, 26, 29, 10, 26, 33, 16, 29, 10, 24, 16, 15, 20, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, 34, 15, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 18, 39, 28, 15, 27, 23, 17, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 17, 29, 26, 29, 32, -16, 1, -18, -20, 1, -14, 5, 1, -20, -16, -4, -7, -4, -1, 32, 49, 30, 28, 49, 34, 53, 49, 28, 32, 44, 41, 44, 47, 28, 44, 51, 34, 47, 28, 42, 34, 33, 38, 30, 28, 30, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 29, 18, 29, 21, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 8, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 24, 21, 24, 27, 41, 30, 41, 33, 26, 20, 24, 36, 33, 36, 39};
    }

    static {
        A03();
        A0B = Color.parseColor(A02(14, 7, 76));
        A0C = Color.parseColor(A02(7, 7, 18));
        A0D = Color.parseColor(A02(21, 7, 40));
        String strA02 = A02(28, 9, 25);
        A0E = Color.parseColor(strA02);
        A0F = Color.parseColor(A02(0, 7, 7));
        A0G = Color.parseColor(strA02);
    }

    public C0679Na(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.A00 = i;
        this.A01 = i2;
        this.A02 = i3;
        this.A03 = i4;
        this.A04 = i5;
        this.A05 = i6;
        this.A07 = i7;
        this.A08 = i8;
        this.A09 = i9;
        this.A06 = i10;
    }

    public static int A00(JSONObject jSONObject, String str, int i) {
        if (jSONObject != null && jSONObject.has(str)) {
            return Color.parseColor(jSONObject.optString(str));
        }
        return i;
    }

    public static C0679Na A01(JSONObject jSONObject) {
        return new C0679Na(A00(jSONObject, A02(37, 12, 27), A0B), A00(jSONObject, A02(57, 10, 112), A0C), A00(jSONObject, A02(152, 14, 101), com.philips.lighting.hue.sdk.utilities.impl.Color.BLACK), A00(jSONObject, A02(49, 8, 114), A0D), A00(jSONObject, A02(67, 9, 116), A0E), A00(jSONObject, A02(76, 20, 103), -1), A00(jSONObject, A02(113, 14, 73), -1), A00(jSONObject, A02(127, 25, 121), A0G), A00(jSONObject, A02(166, 11, 113), com.philips.lighting.hue.sdk.utilities.impl.Color.BLACK), A00(jSONObject, A02(96, 17, 106), A0E));
    }

    public final int A04() {
        return this.A06;
    }

    public final int A05(boolean z) {
        if (z) {
            return -1;
        }
        return this.A00;
    }

    public final int A06(boolean z) {
        if (z) {
            return -1;
        }
        return this.A01;
    }

    public final int A07(boolean z) {
        if (z) {
            return -1;
        }
        return this.A02;
    }

    public final int A08(boolean z) {
        return z ? A0F : this.A03;
    }

    public final int A09(boolean z) {
        return z ? this.A05 : this.A04;
    }

    public final int A0A(boolean z) {
        return z ? this.A08 : this.A07;
    }

    public final int A0B(boolean z) {
        if (z) {
            return -1;
        }
        return this.A09;
    }
}
