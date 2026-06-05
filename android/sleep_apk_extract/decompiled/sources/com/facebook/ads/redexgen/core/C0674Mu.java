package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0674Mu {
    public static byte[] A00;
    public static final String A01;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 9);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{44, 23, 24, 27, 21, 28, 89, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 22, 89, 9, 24, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, 28, 89, 19, 10, 22, 23, 89, 29, 24, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 24, 89, 16, 23, 89, 56, 29, 56, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 16, 22, 23, 63, 24, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 22, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 0, 87, 114, 119, 98, 119, 51, 50, 47, 53, 40, 57, 126, 97, 116, 127, 78, 125, 120, 127, 122, 49, 32, 51, 50, 40, 47, 38, 62, 47, 61, 61, 58, 38, 60, 33, 59, 41, 38, 42, 45, 54, 43, 60, 88, 95, 68, 89, 78, 116, 94, 89, 71, 116, 92, 78, 73, 116, 77, 74, 71, 71, 73, 74, 72, 64, 50, 52, 51, 35, 76, 83, 94, 95, 85, 101, 79, 72, 86};
    }

    static {
        A03();
        A01 = C0674Mu.class.getSimpleName();
    }

    public static AbstractC0673Mt A00(C1421gi c1421gi, VA va, String str, Uri uri, Map<String, String> extraData, C0685Ng c0685Ng) {
        return A01(c1421gi, va, str, uri, extraData, true, false, c0685Ng);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AbstractC0673Mt A01(final C1421gi c1421gi, final VA va, final String action, final Uri uri, final Map<String, String> map, final boolean z, boolean z2, C0685Ng c0685Ng) {
        byte b;
        if (uri == null || uri.getAuthority() == null) {
            return null;
        }
        String key = uri.getAuthority();
        String queryParameter = uri.getQueryParameter(A02(113, 9, 51));
        String queryParameter2 = uri.getQueryParameter(A02(45, 4, 31));
        if (queryParameter2 != null && !TextUtils.isEmpty(queryParameter2)) {
            try {
                JSONObject jSONObject = new JSONObject(queryParameter2);
                Iterator<String> dataIterator = jSONObject.keys();
                while (dataIterator.hasNext()) {
                    String next = dataIterator.next();
                    try {
                        map.put(next, jSONObject.getString(next));
                    } catch (JSONException e) {
                        e = e;
                        c1421gi.A08().ABC(A02(64, 7, 72), AbstractC0833Td.A23, new C0834Te(e));
                        Log.w(A01, A02(0, 45, 112), e);
                        final N0 n0A00 = N0.A00(va, ActivityUtils.A00());
                        switch (key.hashCode()) {
                            case -1458789996:
                                break;
                            case 109770977:
                                break;
                            case 1546100943:
                                break;
                        }
                        switch (b) {
                        }
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
        final N0 n0A002 = N0.A00(va, ActivityUtils.A00());
        switch (key.hashCode()) {
            case -1458789996:
                b = !key.equals(A02(71, 11, 71)) ? (byte) -1 : (byte) 2;
                break;
            case 109770977:
                if (key.equals(A02(82, 5, 80))) {
                    b = 0;
                    break;
                }
                break;
            case 1546100943:
                if (key.equals(A02(55, 9, 24))) {
                    b = 1;
                    break;
                }
                break;
        }
        switch (b) {
            case 0:
                if (queryParameter != null) {
                    return null;
                }
                return (!z2 || TextUtils.isEmpty(uri.getQueryParameter(A02(87, 22, 34)))) ? new AnonymousClass87(c1421gi, va, action, uri, map, n0A002, z, c0685Ng) : new AnonymousClass85(c1421gi, va, action, uri, map);
            case 1:
                if (A02(109, 4, 79).equals(uri.getQueryParameter(A02(49, 6, 85)))) {
                    return new AbstractC1625kH(c1421gi, va, action, uri, map, n0A002, z) { // from class: com.facebook.ads.redexgen.X.83
                        public static byte[] A02;
                        public static final String A03;
                        public final Uri A00;
                        public final Map<String, String> A01;

                        public static String A00(int i, int i2, int i3) {
                            byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
                            for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                                bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 108);
                            }
                            return new String(bArrCopyOfRange);
                        }

                        public static void A01() {
                            A02 = new byte[]{93, 122, 114, 119, 126, 127, 59, 111, 116, 59, 116, 107, 126, 117, 59, 119, 114, 117, 112, 59, 110, 105, 119, 33, 59, 67, 70, 65, 68};
                        }

                        static {
                            A01();
                            A03 = AnonymousClass83.class.getSimpleName();
                        }

                        {
                            this.A00 = uri;
                            this.A01 = map;
                        }

                        @Override // com.facebook.ads.redexgen.core.AbstractC1625kH
                        public final EnumC0670Mq A0H() {
                            EnumC0670Mq enumC0670MqA0M = EnumC0670Mq.A09;
                            if (((AbstractC1625kH) this).A03) {
                                enumC0670MqA0M = A0M();
                            }
                            A0J(this.A01, enumC0670MqA0M);
                            return enumC0670MqA0M;
                        }

                        public final EnumC0670Mq A0M() {
                            EnumC0670Mq enumC0670Mq = EnumC0670Mq.A09;
                            try {
                                X6.A0D(new X6(), ((AbstractC0673Mt) this).A01, XB.A00(this.A00.getQueryParameter(A00(25, 4, 67))), ((AbstractC0673Mt) this).A03);
                                return enumC0670Mq;
                            } catch (Exception unused) {
                                String str = A00(0, 25, 119) + this.A00.toString();
                                return EnumC0670Mq.A04;
                            }
                        }
                    };
                }
                return z2 ? new AnonymousClass85(c1421gi, va, action, uri, map) : new AbstractC1625kH(c1421gi, va, action, uri, map, n0A002, z) { // from class: com.facebook.ads.redexgen.X.84
                    public static byte[] A02;
                    public static String[] A03 = {"FXNBCWXiStej7hPExkUYAqHU7xYJWQz0", "1k", "9V456DvY4LqOh9I9hdT7Vdo5", "hY2FptqSd7XbZZsJCz2yOGxQcUuE9Eo6", "F2N3RsuOcTrAQaEUExDI4U65CqttWDRl", "hYiRMwjZqKFmNKhRfgQ6FfhFwFErfvFO", "BBwXtDWFWjLC6NycZYUWGAP3M0YJ", ""};
                    public static final String A04;
                    public final Uri A00;
                    public final Map<String, String> A01;

                    public static String A00(int i, int i2, int i3) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
                        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 84);
                        }
                        return new String(bArrCopyOfRange);
                    }

                    public static void A01() {
                        A02 = new byte[]{-100, -73, -65, -62, -69, -70, 118, -54, -59, 118, -59, -58, -69, -60, 118, -62, -65, -60, -63, 118, -53, -56, -62, -112, 118, -45, -48, -43, -46};
                        if (A03[3].charAt(0) == 'g') {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[4] = "n2WgzR0RMCkX50JDMRkryQ8YygezODnU";
                        strArr[5] = "Oz9myBlwI7NBoyftyrFAavzWMm25M0Ie";
                    }

                    static {
                        A01();
                        A04 = AnonymousClass84.class.getSimpleName();
                    }

                    {
                        this.A00 = uri;
                        this.A01 = map;
                    }

                    @Override // com.facebook.ads.redexgen.core.AbstractC1625kH
                    public final EnumC0670Mq A0H() {
                        EnumC0670Mq enumC0670MqA0M = EnumC0670Mq.A09;
                        if (((AbstractC1625kH) this).A03) {
                            enumC0670MqA0M = A0M();
                        }
                        if (!YB.A0i(((AbstractC0673Mt) this).A01, enumC0670MqA0M, this.A01)) {
                            A0J(this.A01, enumC0670MqA0M);
                        }
                        return enumC0670MqA0M;
                    }

                    public final EnumC0670Mq A0M() {
                        if (A0K(this.A00)) {
                            EnumC0670Mq actionOutcome = EnumC0670Mq.A0A;
                            return actionOutcome;
                        }
                        try {
                            EnumC0670Mq actionOutcome2 = X6.A06(new X6(), ((AbstractC0673Mt) this).A01, XB.A00(this.A00.getQueryParameter(A00(25, 4, 19))), ((AbstractC0673Mt) this).A03, this.A01);
                            return actionOutcome2;
                        } catch (Exception unused) {
                            String str = A00(0, 25, 2) + this.A00.toString();
                            EnumC0670Mq actionOutcome3 = EnumC0670Mq.A04;
                            return actionOutcome3;
                        }
                    }
                };
            case 2:
                return new C1624kG(c1421gi, va, action, uri, map);
            default:
                return new C1623kE(c1421gi, va, action, uri);
        }
    }

    public static boolean A04(String str) {
        return A02(82, 5, 80).equalsIgnoreCase(str) || A02(55, 9, 24).equalsIgnoreCase(str);
    }
}
