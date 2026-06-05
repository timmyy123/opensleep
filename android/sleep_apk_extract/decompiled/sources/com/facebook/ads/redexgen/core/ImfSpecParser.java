package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.j9, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/ImfSpecParser;", "", "<init>", "()V", "parseImfSpec", "", "Lcom/facebook/video/heroplayer/exocustom/ImfDataTrack;", "imfInlineSpec", "", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImfSpecParser {
    public static byte[] A00;
    public static final ImfSpecParser A01;

    static {
        A02();
        A01 = new ImfSpecParser();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 122);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{23, 29, 26, 45, 26, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 30, 32, 38, 30, 39, 45, 44, 8, 5, 24, 5, -8, 22, 5, 7, 15, 61, 70, 60, 44, 65, 69, 61, 72, 76, 69, 40, 77, 75, 72, 77, 68, 50, 79, 68, 66, 15, 2, 9, -2, 17, 6, 19, 2, -27, 2, 6, 4, 5, 17, 47, 34, 41, 30, 49, 38, 51, 34, 20, 38, 33, 49, 37, 98, 85, 92, 81, 100, 89, 102, 85, 72, 41, 28, 35, 24, 43, 32, 45, 28, 16, 15, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, -2, 17, 6, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -31, 2, 4, 15, 2, 2, 16, 58, 44, 46, 52, 44, 53, 59, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 40, 59, 40, 17, 58, 54, 53, 108, 109, 90, 107, 109, 77, 98, 102, 94, 23, 24, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 7, 15, 9, 22, -27, 23, 23, 9, 24, -19, 8, 20, 21, 10, 4, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 6, 19, -11, 26, 17, 6, 104, 93, 97, 89, 70, 85, 98, 91, 89, 106, 95, 99, 91, 76, 87, 98, 107, 91, 105, 103, 86, 88, 96, 56, 100, 98, 101, 100, 104, 94, 105, 94, 100, 99, 104, 48, 46, 29, 31, 39, 0, 29, 48, 29, 6, 47, 43, 42, -12, -14, -31, -29, -21, -50, -31, -19, -27};
    }

    @JvmStatic
    public static final List<ImfDataTrack> A01(String str) throws JSONException {
        C1995qY.A09(str, A00(29, 13, 101));
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONObject(str).getJSONObject(A00(169, 17, 123)).getJSONArray(A00(0, 1, 105));
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject imfTrack = jSONArray.getJSONObject(i).getJSONObject(A00(13, 9, 42));
            String string = imfTrack.getString(A00(199, 9, 6));
            JSONObject jSONObject = new JSONObject(imfTrack.getString(A00(186, 13, 66)));
            String string2 = jSONObject.getString(A00(140, 11, 39));
            String string3 = jSONObject.getString(A00(126, 14, 42));
            C1995qY.A06(string2);
            C1995qY.A06(string3);
            C1563j7 c1563j7 = new C1563j7(string2, string3);
            JSONArray jSONArray2 = imfTrack.getJSONArray(A00(1, 12, 63));
            int length2 = jSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                JSONObject dataTrack = jSONArray2.getJSONObject(i2);
                String strA00 = A00(151, 9, 122);
                JSONObject jSONObject2 = dataTrack.getJSONObject(strA00).getJSONObject(A00(117, 9, 127));
                String strA002 = A00(160, 9, 124);
                long j = jSONObject2.getLong(strA002);
                long j2 = dataTrack.getJSONObject(strA00).getJSONObject(A00(22, 7, 94)).getLong(strA002);
                JSONObject jSONObject3 = new JSONObject(dataTrack.getString(A00(102, 15, 77)));
                C1995qY.A06(string);
                arrayList.add(new ImfDataTrack(string, j, j2, c1563j7, new C1562j6(jSONObject3.getDouble(A00(69, 9, 118)), jSONObject3.getDouble(A00(78, 9, 61)), jSONObject3.getDouble(A00(56, 13, 67)), jSONObject3.getDouble(A00(42, 14, 35)), jSONObject3.getDouble(A00(87, 15, 35)))));
            }
        }
        return arrayList;
    }
}
