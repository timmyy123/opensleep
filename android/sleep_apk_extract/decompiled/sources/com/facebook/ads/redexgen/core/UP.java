package com.facebook.ads.redexgen.core;

import android.database.Cursor;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class UP {
    public static byte[] A00;
    public static String[] A01 = {"DnTt6XIWuAOQU1Yv6ovRwSY", "69qI84ufJ2UhBtkQx2IBHzZ", "lNRa3H", "2y2Uq0vrRuc5d5uHsu4hqSSezWuXbHLJ", "zUBzfUPcj8uIEo8tGSc", "tyrfQSxRYtG07uuggB4oX54vdLL3Tqsi", "aO8Ix6JCuD3GiDZZv02FTTQkozyjIQFp", "pMzofq8cn4xP4Da44trMpLQAQtlXLUTp"};

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        String[] strArr = A01;
        if (strArr[1].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        A01[4] = "";
        A00 = new byte[]{3, 20, 18, 30, 3, 21, 46, 21, 16, 5, 16, 19, 16, 2, 20};
    }

    static {
        A03();
    }

    public static UR A00(C1417ge c1417ge) {
        try {
            return new ZD(c1417ge);
        } catch (IOException e) {
            c1417ge.A08().ABC(A02(0, 15, 104), AbstractC0833Td.A2K, new C0834Te(e));
            return new ZG();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.71] */
    public static AnonymousClass71 A01(C1417ge c1417ge) {
        return new ZH(c1417ge) { // from class: com.facebook.ads.redexgen.X.71
            public static byte[] A03;
            public static String[] A04 = {"u3ex4KQMIW041lf", "3AptpGjhH", "gmUldlaQs1iDW8SjyulR1SveXx4W0WHx", "1qDQcvNZxrP96rda7KCur1LyuVNWU8kp", "CAWPS90lsy", "t8qLCZBFlDEhGKoHyGYF6SljofbMSV", "olmaGtOYwcY5nta5it0d5AQEWYClhN", "QuuHkAQHaV7iF"};
            public boolean A00 = true;
            public final C1417ge A01;
            public final TH A02;

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 64);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A04() {
                A03 = new byte[]{-37, -7, 6, -65, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -72, -4, -3, 4, -3, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -3, -72, -7, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_PINGREQ, -3, 5, 8, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -72, -3, 16, -5, -3, -3, -4, -3, -4, -72, -3, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -3, 6, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, -58, -87, -84, -66, -79, -84, -1, 18, 18, 3, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 18, 8, 5, 24, 5, -75, -80, -33, -47, -33, -33, -43, -37, -38, -53, -43, -48, -51, -65, -51, -51, -61, -55, -56, -71, -50, -61, -57, -65, 18, 7, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 3, 3, -2, -6, -12, -3, -18, -8, -13, -18, -13, -22, -33};
            }

            static {
                A04();
            }

            {
                this.A01 = c1417ge;
                this.A02 = new TH(c1417ge);
            }

            private JSONArray A01(Cursor cursor) throws JSONException {
                JSONArray jSONArray = new JSONArray();
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(A00(54, 2, 12), cursor.getString(C1369fs.A04.A00));
                    jSONObject.put(A00(82, 8, 79), cursor.getString(C1369fs.A09.A00));
                    jSONObject.put(A00(90, 4, 58), cursor.getString(C1369fs.A0A.A00));
                    jSONObject.put(A00(78, 4, 94), Y1.A03(cursor.getDouble(C1369fs.A08.A00)));
                    jSONObject.put(A00(66, 12, 26), Y1.A03(cursor.getDouble(C1369fs.A07.A00)));
                    jSONObject.put(A00(56, 10, 44), cursor.getString(C1369fs.A06.A00));
                    String string = cursor.getString(C1369fs.A03.A00);
                    jSONObject.put(A00(50, 4, 100), string != null ? new JSONObject(string) : new JSONObject());
                    jSONObject.put(A00(43, 7, 94), cursor.getString(C1369fs.A02.A00));
                    jSONObject.put(A00(38, 5, 8), this.A01.A04().A8N());
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }

            private JSONArray A02(Cursor cursor) throws JSONException {
                JSONArray jSONArray = new JSONArray();
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(A00(54, 2, 12), cursor.getString(2));
                    jSONObject.put(A00(82, 8, 79), cursor.getString(0));
                    jSONObject.put(A00(90, 4, 58), cursor.getString(4));
                    jSONObject.put(A00(78, 4, 94), Y1.A03(cursor.getDouble(5)));
                    jSONObject.put(A00(66, 12, 26), Y1.A03(cursor.getDouble(6)));
                    jSONObject.put(A00(56, 10, 44), cursor.getString(7));
                    String string = cursor.getString(8);
                    jSONObject.put(A00(50, 4, 100), string != null ? new JSONObject(string) : new JSONObject());
                    jSONObject.put(A00(43, 7, 94), cursor.getString(9));
                    jSONObject.put(A00(38, 5, 8), this.A01.A04().A8N());
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }

            public static JSONObject A03(Cursor cursor) throws JSONException {
                JSONObject jSONObject = new JSONObject();
                while (cursor.moveToNext()) {
                    jSONObject.put(cursor.getString(C1362fl.A03.A00), cursor.getString(C1362fl.A02.A00));
                }
                return jSONObject;
            }

            @Override // com.facebook.ads.redexgen.core.UQ
            public final int A50(int i) {
                int iA08 = 0;
                if (i > -1) {
                    try {
                        iA08 = this.A02.A08(i);
                    } catch (Exception e) {
                        if (this.A01.A05().AAO()) {
                            Log.e(ZH.A00, A00(0, 38, 88), e);
                        }
                    }
                }
                this.A02.A0I();
                if (this.A00) {
                    this.A02.A0J();
                }
                return iA08;
            }

            @Override // com.facebook.ads.redexgen.core.UR
            public final void A51() {
                this.A02.A0H();
            }

            @Override // com.facebook.ads.redexgen.core.UQ
            public final boolean A5q(String str) {
                return this.A02.A0K(str);
            }

            @Override // com.facebook.ads.redexgen.core.UQ
            public final JSONArray A6s() {
                Cursor cursorA0A = null;
                try {
                    cursorA0A = this.A02.A0A();
                    JSONArray jSONArrayA01 = null;
                    if (cursorA0A.getCount() > 0) {
                        jSONArrayA01 = A01(cursorA0A);
                    }
                    if (cursorA0A != null) {
                        cursorA0A.close();
                    }
                    return jSONArrayA01;
                } catch (JSONException unused) {
                    if (cursorA0A != null) {
                        cursorA0A.close();
                        return null;
                    }
                    return null;
                } catch (Throwable th) {
                    if (cursorA0A != null) {
                        cursorA0A.close();
                    }
                    throw th;
                }
            }

            @Override // com.facebook.ads.redexgen.core.UQ
            public final JSONObject A6t() {
                Cursor cursorA0B = null;
                try {
                    cursorA0B = this.A02.A0B();
                    JSONObject jSONObjectA03 = null;
                    if (cursorA0B.getCount() > 0) {
                        jSONObjectA03 = A03(cursorA0B);
                    }
                    if (cursorA0B != null) {
                        cursorA0B.close();
                    }
                    return jSONObjectA03;
                } catch (JSONException unused) {
                    if (cursorA0B != null) {
                        cursorA0B.close();
                        return null;
                    }
                    return null;
                } catch (Throwable th) {
                    if (cursorA0B != null) {
                        cursorA0B.close();
                    }
                    throw th;
                }
            }

            @Override // com.facebook.ads.redexgen.core.UQ
            public final int A82() {
                Cursor cursorA09 = null;
                try {
                    cursorA09 = this.A02.A09();
                    return cursorA09.moveToFirst() ? cursorA09.getInt(0) : 0;
                } finally {
                    if (cursorA09 != null) {
                        cursorA09.close();
                    }
                }
            }

            @Override // com.facebook.ads.redexgen.core.UQ
            public final String A85(String str) {
                String string = null;
                Cursor cursorA0D = this.A02.A0D(str);
                if (cursorA0D != null) {
                    boolean zMoveToNext = cursorA0D.moveToNext();
                    String[] strArr = A04;
                    String str2 = strArr[4];
                    String eventType = strArr[0];
                    if (str2.length() == eventType.length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A04;
                    strArr2[4] = "rCLG4kGmKo";
                    strArr2[0] = "2rihfjjJxsL3teC";
                    if (zMoveToNext && cursorA0D.getCount() > 0) {
                        String eventType2 = C1369fs.A0A.A01;
                        string = cursorA0D.getString(cursorA0D.getColumnIndex(eventType2));
                    }
                    cursorA0D.close();
                }
                return string;
            }

            @Override // com.facebook.ads.redexgen.core.UQ
            public final Pair<JSONObject, JSONArray> A9I(int i) {
                Cursor cursorA0C = null;
                try {
                    try {
                        cursorA0C = this.A02.A0C(i);
                        JSONArray events = null;
                        JSONObject tokens = null;
                        if (cursorA0C.getCount() > 0) {
                            tokens = A03(cursorA0C);
                            events = A02(cursorA0C);
                        }
                        Pair<JSONObject, JSONArray> pair = new Pair<>(tokens, events);
                        if (cursorA0C != null) {
                            cursorA0C.close();
                        }
                        return pair;
                    } catch (JSONException unused) {
                        Pair<JSONObject, JSONArray> pair2 = new Pair<>(null, null);
                        if (cursorA0C != null) {
                            cursorA0C.close();
                        }
                        return pair2;
                    }
                } catch (Throwable th) {
                    if (cursorA0C != null) {
                        cursorA0C.close();
                    }
                    throw th;
                }
            }

            @Override // com.facebook.ads.redexgen.core.UQ
            public final boolean AA5(String str) {
                return this.A02.A0L(str);
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.UO != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<java.lang.String> */
            @Override // com.facebook.ads.redexgen.core.UR
            public final void AL6(V7 v7, UO<String> uo) {
                this.A02.A0G(v7.A08(), v7.A05().A00, v7.A06().toString(), v7.A04(), v7.A03(), v7.A07(), v7.A09(), uo);
            }
        };
    }
}
