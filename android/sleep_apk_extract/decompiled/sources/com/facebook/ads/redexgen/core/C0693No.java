package com.facebook.ads.redexgen.core;

import androidx.appfunctions.AppFunctionException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.No, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0693No implements Serializable {
    public static byte[] A0Q = null;
    public static String[] A0R = {"ctorgdsQQ2U4B6CI8kOgnWnGWE5Hgfx0", "OfZzAcfvUxmyP", "hRr0xuGBslycC2aIRO91", "oYy00yp7m", "vkVvrMYFy", "Q6DpYSl0Gg7lXNb5sJ12E0KBmjRKKzYP", "aB5DzfiXC0YdMCjW8pZWdkroLLRV865X", ""};
    public static final EnumC0694Np A0S;
    public static final EnumC1082bD A0T;
    public static final long serialVersionUID = -5352540123250859603L;
    public int A00;
    public int A01;
    public String A02;
    public String A03;
    public String A04;
    public String A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public final int A09;
    public final int A0A;
    public final int A0B;
    public final int A0C;
    public final EnumC0694Np A0D;
    public final EnumC1082bD A0E;
    public final String A0F;
    public final String A0G;
    public final String A0H;
    public final String A0I;
    public final String A0J;
    public final String A0K;
    public final boolean A0L;
    public final boolean A0M;
    public final boolean A0N;
    public final boolean A0O;
    public final boolean A0P;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0Q, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0Q = new byte[]{70, 97, 124, 123, 110, 99, 99, 62, 29, 19, 22, 27, 28, 21, 82, 34, 30, 19, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 19, 16, 30, 23, 91, 103, 106, 114, 43, 88, 127, 100, 121, 110, 43, 124, 98, 103, 103, 43, 106, 126, 127, 100, 102, 106, 127, 98, 104, 106, 103, 103, 114, 43, 100, 123, 110, 101, 43, 98, 101, 43, 80, 120, 110, 104, 120, 86, 120, 2, 62, 51, 43, 51, 48, 62, 55, 114, 51, 54, 45, 26, 8, 30, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 27, 26, 27, 95, 47, 19, 30, 6, 93, 82, 87, 91, 80, 74, 97, 74, 81, 85, 91, 80, 122, 109, 21, 20, 29, 16, 8, 46, 18, 29, 24, 18, 26, 46, 5, 20, 9, 5, 58, 49, 62, 61, 51, 58, 0, 58, 49, 59, 0, 60, 62, 45, 59, 8, 3, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 15, 1, 8, 50, 4, 3, 25, 31, 2, 50, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 31, 9, 25, 27, 16, 27, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 23, 29, 33, 10, 27, 6, 10, 66, 69, 88, 95, 74, 69, 72, 78, 116, 66, 79, 107, 108, 118, 112, 109, 93, 97, 99, 112, 102, 93, 107, 97, 109, 108, 93, 119, 112, 110, 122, 96, 76, 99, 127, 114, 106, 114, 113, 127, 118, 76, 97, 118, 126, 124, 103, 118, 76, 117, 124, 97, 126, 114, 103, 23, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 33, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 18, 31, 7, 31, 28, 18, 27, 33, 8, 76, 33, 28, 31, 16, 16, 27, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 33, 17, 8, 27, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 18, 31, 7, 33, 29, 18, 23, 29, 21, 31, 28, 18, 27, 68, 94, 114, 93, 65, 76, 84, 76, 79, 65, 72, 114, 91, 31, 114, 79, 76, 67, 67, 72, 95, 114, 66, 91, 72, 95, 65, 76, 84, 114, 72, 67, 76, 79, 65, 72, 73, 118, 107, 112, 124, 119, 109, 120, 109, 112, 118, 119, 92, 64, 77, 85, 2, 75, 67, 67, 75, 64, 73, 2, 79, 67, 65, 83, 79, 66, 90, 66, 65, 79, 70, 124, 64, 87, 66, 124, 87, 70, 91, 87, 121, 101, 104, 112, 104, 107, 101, 108, 86, 109, 104, 125, 104, 23, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6, 30, 6, 5, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 2, 56, 2, 9, 3, 56, 4, 6, 21, 3, 56, 3, 2, 20, 4, 51, 47, 34, 58, 34, 33, 47, 38, 28, 42, 45, 55, 49, 44, 28, 32, 34, 49, 39, 28, 39, 38, 48, 32, 42, 54, 59, 35, 59, 56, 54, 63, 5, 52, 46, 62, 5, 46, 51, 55, 63, 55, 43, 38, 62, 38, 37, 43, 34, 24, 53, 34, 35, 34, 52, 46, 32, 41, 24, 34, 41, 38, 37, 43, 34, 35, 38, 58, 55, 47, 55, 52, 58, 51, 9, 37, 61, 63, 38, 38, 55, 52, 58, 51, 9, 37, 51, 53, 57, 56, 50, 37, 83, 79, 66, 90, 66, 65, 79, 70, 124, 85, 17, 124, 65, 66, 77, 77, 70, 81, 124, 76, 85, 70, 81, 79, 66, 90, 124, 71, 70, 79, 66, 90, 95, 93, 74, 76, 78, 76, 71, 70, 65, 72, 112, 66, 74, 91, 71, 64, 75, 110, 108, 123, 114, 113, 127, 122, 119, 112, 121, 65, 110, 114, 127, 103, 127, 124, 114, 123, 65, 125, 113, 112, 106, 123, 112, 106, 65, 123, 112, 127, 124, 114, 123, 122, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 27, 9, 31, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 26, 27, 26, 33, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 18, 31, 7, 33, 10, 27, 6, 10, 4, 28, 30, 7, 7, 22, 21, 27, 18, 40, 4, 18, 20, 24, 25, 19, 4, 25, 26, 6, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 25, 2, 53, 25, 9, 24, 15, 15, 4, 53, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 31, 24, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 30, 3, 5, 4, 42, 41, 53, 56, 42, 49, 6, 42, 58, 43, 60, 60, 55, 6, 45, 60, 33, 45, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 21, 8, 16, 18, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 26, 25, 23, 30, 36, 8, 30, 24, 20, 21, 31, 8, 9, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 21, 111, 112, 125, 124, 118, 70, 117, 124, 120, 125, 112, 119, 126, 70, 105, 117, 120, 96, 120, 123, 117, 124, 70, 124, 119, 120, 123, 117, 124, 125, 99, 124, 113, 112, 122, 74, 121, 112, 116, 113, 124, 123, 114, 74, 101, 121, 116, 108, 116, 119, 121, 112, 74, 96, 123, 102, 126, 124, 101, 101, 116, 119, 121, 112, 74, 97, 124, 120, 112, 102, 116, 115, 78, 103, 120, 116, 102, 78, 101, 120, 124, 116, 126, 100, 101, 78, 120, 127, 78, 124, 120, 125, 125, 120, 98, 116, 114, 126, 127, 117, 98};
    }

    static {
        A09();
        A0T = EnumC1082bD.A04;
        A0S = EnumC0694Np.A03;
    }

    public C0693No(String str, String str2, int i, String str3, String str4, EnumC1082bD enumC1082bD, int i2, boolean z, boolean z2, EnumC0694Np enumC0694Np, boolean z3, String str5, boolean z4, boolean z5, int i3, String str6, String str7, int i4, String str8, boolean z6, boolean z7, int i5, boolean z8, int i6, String str9) {
        if (z3) {
            this.A0I = UUID.randomUUID().toString();
            this.A0H = XB.A00(str).buildUpon().appendQueryParameter(A04(166, 11, 28), this.A0I).appendQueryParameter(A04(92, 12, 9), str5).build().toString();
        } else {
            this.A0H = str;
            this.A0I = null;
        }
        this.A0G = str2;
        this.A0A = i;
        this.A0J = str3;
        this.A0F = str4;
        this.A0E = enumC1082bD;
        this.A0C = i2;
        this.A0L = z;
        this.A06 = z2;
        this.A0D = enumC0694Np;
        this.A0M = z3;
        this.A08 = z4;
        this.A07 = z5;
        this.A01 = i3;
        this.A05 = str6;
        this.A04 = str7;
        this.A0B = i4;
        this.A0K = str8;
        this.A0P = z6;
        this.A0O = z7;
        this.A09 = i5;
        this.A0N = z8;
        this.A00 = i6;
        this.A03 = str9;
    }

    public static int A00(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A04(340, 13, 62));
        if (jSONObjectOptJSONObject != null) {
            String strA04 = A04(441, 26, 97);
            boolean zHas = jSONObjectOptJSONObject.has(strA04);
            if (A0R[7].length() == 9) {
                throw new RuntimeException();
            }
            A0R[1] = "DEIp";
            if (zHas) {
                return jSONObjectOptJSONObject.optInt(strA04);
            }
        }
        String strA042 = A04(569, 17, 64);
        if (jSONObject.has(strA042)) {
            return jSONObject.optInt(strA042);
        }
        if (A0R[7].length() == 9) {
            throw new RuntimeException();
        }
        A0R[1] = "AI76RAj";
        return jSONObject.optInt(A04(626, 19, 76), 0);
    }

    public static int A01(JSONObject jSONObject, JSONObject jSONObject2) {
        int playableSkippableTimeInSecs = jSONObject2.optInt(A04(399, 17, 109));
        int playableNTDTime = A00(jSONObject);
        if (playableSkippableTimeInSecs > 0 && playableSkippableTimeInSecs < playableNTDTime) {
            return playableNTDTime - playableSkippableTimeInSecs;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x015e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0693No A02(JSONObject jSONObject) {
        boolean z;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A04(340, 13, 62));
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        EnumC0694Np enumC0694NpA00 = EnumC0694Np.A00(jSONObjectOptJSONObject.optString(A04(499, 17, 24), A0S.name()));
        String precachingMethodStr = A04(648, 30, 46);
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean(precachingMethodStr, false);
        String precachingMethodStr2 = A04(645, 3, 75);
        String strOptString = jSONObjectOptJSONObject.optString(precachingMethodStr2);
        String precachingMethodStr3 = A04(177, 19, 53);
        String strOptString2 = jSONObjectOptJSONObject.optString(precachingMethodStr3);
        int iA00 = A00(jSONObject);
        String strA07 = A07(jSONObjectOptJSONObject);
        String strA05 = A05(jSONObjectOptJSONObject);
        EnumC1082bD enumC1082bDA03 = A03(jSONObjectOptJSONObject);
        int iOptInt = jSONObjectOptJSONObject.optInt(A04(717, 32, 38), DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT);
        if (!zOptBoolean) {
            String precachingMethodStr4 = A04(137, 17, 90);
            z = jSONObjectOptJSONObject.optBoolean(precachingMethodStr4, true);
        }
        String precachingMethodStr5 = A04(122, 15, 104);
        boolean zOptBoolean2 = jSONObjectOptJSONObject.optBoolean(precachingMethodStr5);
        String precachingMethodStr6 = A04(196, 25, 36);
        boolean zOptBoolean3 = jSONObjectOptJSONObject.optBoolean(precachingMethodStr6);
        String precachingMethodStr7 = A04(104, 2, 46);
        String strOptString3 = jSONObject.optString(precachingMethodStr7);
        String precachingMethodStr8 = A04(416, 25, 112);
        boolean zOptBoolean4 = jSONObjectOptJSONObject.optBoolean(precachingMethodStr8, false);
        String precachingMethodStr9 = A04(678, 39, 34);
        int iOptInt2 = jSONObjectOptJSONObject.optInt(precachingMethodStr9, 5);
        String strOptString4 = jSONObject.optString(A04(375, 24, 116), A04(68, 11, 101));
        String strOptString5 = jSONObject.optString(A04(353, 22, 80), A04(308, 15, 27));
        String precachingMethodStr10 = A04(586, 22, 93);
        int iOptInt3 = jSONObjectOptJSONObject.optInt(precachingMethodStr10, 2000);
        String strA08 = A08(jSONObjectOptJSONObject);
        String precachingMethodStr11 = A04(260, 37, 26);
        boolean zOptBoolean5 = jSONObjectOptJSONObject.optBoolean(precachingMethodStr11, true);
        String precachingMethodStr12 = A04(221, 39, 73);
        boolean zOptBoolean6 = jSONObjectOptJSONObject.optBoolean(precachingMethodStr12, true);
        String precachingMethodStr13 = A04(467, 32, 20);
        int iOptInt4 = jSONObjectOptJSONObject.optInt(precachingMethodStr13, AppFunctionException.ERROR_APP_UNKNOWN_ERROR);
        String precachingMethodStr14 = A04(516, 35, 41);
        boolean isVideoLeadingPlayableEnabled = jSONObjectOptJSONObject.optBoolean(precachingMethodStr14, true);
        return new C0693No(strOptString, strOptString2, iA00, strA07, strA05, enumC1082bDA03, iOptInt, z, zOptBoolean2, enumC0694NpA00, zOptBoolean3, strOptString3, zOptBoolean, zOptBoolean4, iOptInt2, strOptString4, strOptString5, iOptInt3, strA08, zOptBoolean5, zOptBoolean6, iOptInt4, isVideoLeadingPlayableEnabled, A01(jSONObject, jSONObjectOptJSONObject), A06(jSONObjectOptJSONObject));
    }

    public static EnumC1082bD A03(JSONObject jSONObject) {
        int orientation = jSONObject.optInt(A04(297, 11, 46), A0T.A04());
        return EnumC1082bD.A00(orientation);
    }

    public static String A05(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A04(154, 12, 73));
        String strA04 = A04(23, 45, 60);
        return jSONObjectOptJSONObject == null ? strA04 : jSONObjectOptJSONObject.optString(A04(106, 16, 70), strA04);
    }

    public static String A06(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(A04(323, 17, 20));
        return (strOptString == null || strOptString.isEmpty()) ? A04(0, 7, 56) : strOptString;
    }

    public static String A07(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(A04(154, 12, 73));
        String strA04 = A04(79, 13, 72);
        return jSONObjectOptJSONObject == null ? strA04 : jSONObjectOptJSONObject.optString(A04(551, 18, 73), strA04);
    }

    public static String A08(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(A04(608, 18, 110));
        return (strOptString == null || strOptString.isEmpty()) ? A04(7, 16, 69) : strOptString;
    }

    public final int A0A() {
        return this.A00;
    }

    public final int A0B() {
        return this.A09;
    }

    public final int A0C() {
        return this.A0A;
    }

    public final int A0D() {
        return this.A0B;
    }

    public final int A0E() {
        return this.A01;
    }

    public final int A0F() {
        return this.A0C;
    }

    public final EnumC0694Np A0G() {
        return this.A0D;
    }

    public final EnumC1082bD A0H() {
        return this.A0E;
    }

    public final String A0I() {
        return this.A02;
    }

    public final String A0J() {
        return this.A0F;
    }

    public final String A0K() {
        return this.A0G;
    }

    public final String A0L() {
        return this.A0H;
    }

    public final String A0M() {
        return this.A03;
    }

    public final String A0N() {
        return this.A04;
    }

    public final String A0O() {
        return this.A05;
    }

    public final String A0P() {
        return this.A0I;
    }

    public final String A0Q() {
        return this.A0J;
    }

    public final String A0R() {
        return this.A0K;
    }

    public final void A0S(int i) {
        this.A00 = i;
    }

    public final void A0T(String str) {
        this.A02 = str;
    }

    public final void A0U(boolean z) {
        this.A06 = z;
    }

    public final boolean A0V() {
        return this.A06;
    }

    public final boolean A0W() {
        return this.A0L;
    }

    public final boolean A0X() {
        return this.A07;
    }

    public final boolean A0Y() {
        return this.A0M;
    }

    public final boolean A0Z() {
        return this.A0O;
    }

    public final boolean A0a() {
        return this.A0P;
    }

    public final boolean A0b() {
        return this.A0N;
    }

    public final boolean A0c() {
        return this.A08;
    }
}
