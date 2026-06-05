package com.facebook.ads.redexgen.core;

import android.util.Log;
import com.google.home.platform.traits.ValidationIssue;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class YK implements V8 {
    public static byte[] A02;
    public static String[] A03 = {"nSyQhtMfpq2jNqGGNPt5NI90oeOfe1", "vvfyUHTPPgzLU9ZJhsHsRroWK12HyjVH", "qslzdaLavUZ6hWrKlj1Zt3UP1k3mmB4y", "NIvb6IKYOgsNqkR8AWNkoYQGWWwuN", "c4tQ8NQ91n2uUc9nTvHWxfXCnHLpYFgI", "tMmd9elNu7YQkbRY7XCik1QBLE", "7gl4a25pOcE06E3aPI2wtSqogJ", "FAOoLRBR29CEN05oKXcOTgWFdOs"};
    public static final String A04;
    public C1417ge A00;
    public ZD A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{60, 122, 115, 110, 60, 121, 106, 121, 114, 104, 85, 120, 60, 87, 4, 2, 20, 20, 18, 4, 4, 17, 2, 27, 27, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 89, 18, 47, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 7, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 31, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 75, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 29, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 5, 31, 24, 75, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 19, 8, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 75, 25, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 31, 25, 18, 75, 7, 2, 6, 2, 31, 69, 75, 40, 4, 30, 5, 31, 81, 75, 44, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3, 6, 15, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 74, 30, 5, 74, 26, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 24, 25, 15, 74, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 4, 74, 15, 28, 15, 4, 30, 74, 3, 4, 74, 15, 28, 15, 4, 30, 25, 74, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 24, 24, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 19, 74, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 5, 24, 74, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 3, 25, 26, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 30, 9, 2, 74, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3, 6, 31, 24, 15, 68, 88, 127, 119, 114, 123, 122, 62, 106, 113, 62, 110, 127, 108, 109, 123, 62, 127, 112, 62, 123, 104, 123, 112, 106, 62, 119, 112, 62, 123, 104, 123, 112, 106, 109, 62, 114, 119, 109, 106, 62, 105, 118, 123, 112, 62, 110, 108, 123, 110, 127, 108, 119, 112, 121, 62, 122, 119, 109, 110, 127, 106, 125, 118, 62, 110, 127, 103, 114, 113, 127, 122, 48, 26, 44, 59, 63, 44, 59, 105, 57, 59, 38, 42, 44, 58, 58, 44, 45, 105, 44, 63, 44, 39, 61, 0, 45, 105, 20, 34, 53, 49, 34, 53, 103, 53, 34, 51, 50, 53, 41, 34, 35, 103, 41, 40, 41, 106, 53, 34, 51, 53, 62, 38, 37, 43, 34, 103, 34, 53, 53, 40, 53, 103, 36, 40, 35, 34, 103, 109, 91, 76, 72, 91, 76, 30, 76, 91, 74, 75, 76, 80, 91, 90, 30, 76, 91, 74, 76, 71, 95, 92, 82, 91, 30, 91, 76, 76, 81, 76, 30, 93, 81, 90, 91, 30, 25, 34, 45, 46, 32, 41, 108, 56, 35, 108, 60, 45, 62, 63, 41, 108, 63, 41, 62, 58, 41, 62, 108, 62, 41, 63, 60, 35, 34, 63, 41, 108, 45, 56, 108, 60, 35, 63, 37, 56, 37, 35, 34, 108, 29, 17, 26, 27, 94, 77, 94, 85, 79, 72, 7, 4, 0, 21, 20, 19, 4, 76, 2, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 15, 7, 8, 6, 76, 4, 23, 4, 15, 21, 76, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, 6, 8, 2, 39, 36, 32, 53, 52, 51, 36, 30, 34, 46, 47, 39, 40, 38, 23, 26, 116, 99, 101, 105, 116, 98, 89, 98, 103, 114, 103, 100, 103, 117, 99, 73, 82, 86, 88, 83, 22, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 9, 7, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 61, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 6, 74, 81, 85, 91, 80, 77};
    }

    static {
        A01();
        A04 = YK.class.getSimpleName();
    }

    public YK(C1417ge c1417ge, ZD zd) {
        this.A00 = c1417ge;
        this.A01 = zd;
    }

    private void A02(Set<String> eventsToRetry, Set<String> eventsToDelete) {
        int iA0B = this.A01.A0B(AbstractC0873Ur.A0G(this.A00), eventsToRetry, eventsToDelete);
        if (iA0B > 0) {
            this.A00.A08().ABC(A00(405, 15, 38), AbstractC0833Td.A10, new C0834Te(A00(28, 44, 75) + iA0B));
        }
    }

    @Override // com.facebook.ads.redexgen.core.V8
    public final JSONObject A5L() {
        int iA08;
        JSONArray jSONArrayA04;
        int iA0F = AbstractC0873Ur.A0F(this.A00);
        List<JSONObject> listA0C = this.A01.A0C(iA0F);
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : listA0C) {
            try {
                String strOptString = jSONObject2.optString(A00(420, 5, 29));
                String string = UUID.randomUUID().toString();
                jSONObject.put(string, strOptString);
                jSONObject2.put(A00(425, 8, 66), string);
            } catch (JSONException e) {
                if (this.A00.A05().AAO()) {
                    Log.e(A04, A00(134, 72, 62), e);
                }
            }
        }
        JSONArray jSONArray = new JSONArray((Collection) listA0C);
        if (AbstractC0873Ur.A0P(this.A00) && (jSONArrayA04 = C0835Tf.A04(this.A00, (iA08 = AbstractC0873Ur.A08(this.A00)))) != null) {
            int eventLimit = jSONArrayA04.length();
            if (eventLimit > 0) {
                jSONArray = WV.A02(this.A00, jSONArrayA04, jSONArray, iA0F + iA08);
            }
        }
        JSONObject jSONObject3 = null;
        try {
            int eventLimit2 = jSONArray.length();
            if (eventLimit2 > 0) {
                jSONObject3 = new JSONObject();
                int eventLimit3 = jSONObject.length();
                if (eventLimit3 > 0) {
                    jSONObject3.put(A00(433, 6, 30), jSONObject);
                }
                jSONObject3.put(A00(357, 6, 27), jSONArray);
            }
            return jSONObject3;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.facebook.ads.redexgen.core.V8
    public final boolean AAb() {
        return this.A01.A0A() > 0;
    }

    @Override // com.facebook.ads.redexgen.core.V8
    public final void ACu() {
        C0835Tf.A0F(this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.V8
    public final void ADe(JSONArray jSONArray) {
        int length = jSONArray.length();
        HashSet hashSet = new HashSet(length);
        for (int i = 0; i < length; i++) {
            try {
                JSONObject eventJson = jSONArray.getJSONObject(i);
                String string = eventJson.getString(A00(ValidationIssue.TOO_MANY_OPERATIONS_FIELD_NUMBER, 2, 94));
                if (C0835Tf.A0I(string)) {
                    C0835Tf.A0B(this.A00, string);
                } else {
                    hashSet.add(string);
                }
            } catch (JSONException e) {
                if (this.A00.A05().AAO()) {
                    String eventId = A04;
                    String strA00 = A00(72, 62, 74);
                    if (A03[2].charAt(27) != 'm') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A03;
                    strArr[6] = "wUavWABsdMwqX86gv8aQq4NsYa";
                    strArr[5] = "TgLwFV200Sew2OuM724xEw99Fl";
                    Log.e(eventId, strA00, e);
                } else {
                    continue;
                }
            }
        }
        A02(hashSet, new HashSet());
    }

    @Override // com.facebook.ads.redexgen.core.V8
    public final boolean ADf(JSONArray jSONArray) {
        String strA00 = A00(27, 1, 28);
        boolean z = true;
        boolean zA0P = AbstractC0873Ur.A0P(this.A00);
        Set<String> eventsToDelete = new HashSet<>();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(A00(ValidationIssue.TOO_MANY_OPERATIONS_FIELD_NUMBER, 2, 94));
                if (A00(363, 26, 65).equals(string)) {
                    C0871Up.A0V(this.A00).A36(jSONObject.getString(A00(389, 14, 97)));
                    this.A00.A04().ACP();
                } else {
                    int i2 = jSONObject.getInt(A00(353, 4, 94));
                    if (i2 == 1) {
                        if (this.A00.A05().AAO()) {
                            String str = A00(ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER, 25, 105) + string + A00(13, 14, 87);
                        }
                        if (zA0P) {
                            C0835Tf.A0D(string);
                        }
                        eventsToDelete.add(string);
                    } else {
                        String strA002 = A00(0, 13, 60);
                        if (i2 >= 1000 && i2 < 2000) {
                            if (this.A00.A05().AAO()) {
                                Log.e(A04, A00(272, 37, 30) + i2 + strA002 + string + strA00);
                            }
                            if (C0835Tf.A0I(string)) {
                                C0835Tf.A0B(this.A00, string);
                            } else {
                                hashSet.add(string);
                            }
                            z = false;
                        } else if (i2 >= 2000 && i2 < 3000) {
                            if (this.A00.A05().AAO()) {
                                Log.e(A04, A00(231, 41, 103) + i2 + strA002 + string + strA00);
                            }
                            eventsToDelete.add(string);
                            if (zA0P) {
                                C0835Tf.A0D(string);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (this.A00.A05().AAO()) {
                    String eventId = A04;
                    Log.e(eventId, A00(309, 44, 108) + i + strA00, e);
                }
                z = false;
            }
        }
        A02(hashSet, eventsToDelete);
        return z;
    }

    @Override // com.facebook.ads.redexgen.core.V8
    public final void AFZ() {
        this.A01.A51();
        C0835Tf.A07(this.A00);
    }
}
