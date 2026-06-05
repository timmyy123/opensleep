package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.util.Pair;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.home.platform.traits.ValidationIssue;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8R {
    public static byte[] A02;
    public static String[] A03 = {"n0jQ8SeFa80EBLo4BXhwXwPS4Wjubjck", "v64BeMF4Y1fRwWGkqW0btQJWsOcnPY4V", "TgQc", "Ri1mjPnDGJYW0mGh81XgbTSSpeaxgcJq", "RtYQoh190WxakJNXNOvGF0rP0AmdpNRb", "fbDVM5YfIDSRqB6n56hfMufsgfpcQx7k", "HNWTUdzo11zzvmCb4ifQA88FoSPuiiKn", "CiEa"};
    public static final C8R A04;
    public static final C8R A05;

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Prevent throwing when building the map")
    public static final AbstractC1873oX<Integer, Integer> A06;
    public final int A00;
    public final int[] A01;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 36);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        byte[] bArr = {5, 9, 90, 92, 89, 89, 70, 91, 93, 76, 77, 108, 71, 74, 70, 77, 64, 71, 78, 90, 20, 81, 125, 113, 106, 127, 126, 6, 50, 35, 46, 40, 4, 38, 55, 38, 37, 46, 43, 46, 51, 46, 34, 52, 28, 42, 38, 63, 4, 47, 38, 41, 41, 34, 43, 4, 40, 50, 41, 51, 122, 123, 74, 66, 76, 78, 74, 68, 52, 59, 49, 39, 58, 60, 49, 123, 56, 48, 49, 60, 52, 123, 52, 54, 33, 60, 58, 59, 123, 29, 17, 24, 28, 10, 20, 0, 17, 28, 26, 10, 5, 25, 0, 18, 30, 17, 27, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 16, 22, 27, 81, 18, 26, 27, 22, 30, 81, 26, 7, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 30, 81, 62, 42, 59, 54, 48, 32, 47, 51, 42, 56, 32, 44, 43, 62, 43, 58, 114, 125, 119, 97, 124, 122, 119, 61, 126, 118, 119, 122, 114, 61, 118, 107, 103, 97, 114, 61, 86, 93, 80, 92, 87, 90, 93, 84, 64, 17, 30, 20, 2, 31, 25, 20, 94, 29, 21, 20, 25, 17, 94, 21, 8, 4, 2, 17, 94, 61, 49, 40, 47, 51, 56, 49, 62, 62, 53, 60, 47, 51, 63, 37, 62, 36, 123, 102, 106, 123, 108, 112, 127, 114, 65, 109, 107, 108, 108, 113, 107, 112, 122, 65, 109, 113, 107, 112, 122, 65, 123, 112, 127, 124, 114, 123, 122, 117, 102, 116, 102};
        String[] strArr = A03;
        if (strArr[7].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[6] = "fFCHGQkYTOkakvUkxnOWQDFO0G2COwX4";
        strArr2[3] = "aKWONvT57JCa0OWG4uWHvxhg88ypYICi";
        A02 = bArr;
    }

    static {
        A06();
        A04 = new C8R(new int[]{2}, 8);
        A05 = new C8R(new int[]{2, 5, 6}, 8);
        A06 = new C1871oV().A05(5, 6).A05(17, 6).A05(7, 6).A05(18, 6).A05(6, 8).A05(8, 8).A05(14, 8).A07();
    }

    public C8R(int[] iArr, int i) {
        if (iArr != null) {
            this.A01 = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.A01);
        } else {
            this.A01 = new int[0];
        }
        this.A00 = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A00(int i) {
        if (C5C.A02 <= 28) {
            if (i == 7) {
                i = 8;
            } else if (i == 3) {
                i = 6;
            } else {
                if (A03[1].charAt(21) == '1') {
                    throw new RuntimeException();
                }
                String[] strArr = A03;
                strArr[6] = "n1qXVCZQxk2N8nhnGA5Su8h2HHCkXbDi";
                strArr[3] = "3IkXI2X5X2wTbaqU0wEl3DE4dRdq07f0";
                if (i != 4) {
                    if (A03[0].charAt(17) == 'h') {
                        throw new RuntimeException();
                    }
                    A03[1] = "tECYq4G9CXONPArggxwQRVOEprBCIxCW";
                    if (i == 5) {
                    }
                }
            }
        }
        if (C5C.A02 <= 26 && A05(237, 4, 55).equals(C5C.A03) && i == 1) {
            i = 2;
        }
        return C5C.A01(i);
    }

    public static int A01(int i, int i2) {
        if (C5C.A02 >= 29) {
            return C8Q.A00(i, i2);
        }
        Integer orDefault = A06.getOrDefault(Integer.valueOf(i), 0);
        if (A03[1].charAt(21) == '1') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[5] = "4LwyKZxV9xzADs3TG4HwkSSUmTpMdFHu";
        strArr[4] = "TU5gCkHzG3bOz42CgVjxZ9enmRnhlx9h";
        return ((Integer) AbstractC02053y.A01(orDefault)).intValue();
    }

    public static C8R A02(Context context) {
        Intent intent = context.registerReceiver(null, new IntentFilter(A05(68, 36, 113)));
        return A03(context, intent);
    }

    public static C8R A03(Context context, Intent intent) {
        if (A07() && Settings.Global.getInt(context.getContentResolver(), A05(ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER, 31, 58), 0) == 1) {
            return A05;
        }
        if (C5C.A02 >= 29 && (C5C.A18(context) || C5C.A17(context))) {
            return new C8R(C8Q.A01(), 8);
        }
        if (intent == null || intent.getIntExtra(A05(104, 36, 91), 0) == 0) {
            return A04;
        }
        return new C8R(intent.getIntArrayExtra(A05(140, 29, 55)), intent.getIntExtra(A05(169, 37, 84), 8));
    }

    public static boolean A07() {
        if (C5C.A02 >= 17) {
            if (A05(21, 6, 52).equals(C5C.A05) || A05(61, 6, 7).equals(C5C.A05)) {
                return true;
            }
        }
        return false;
    }

    public final int A08() {
        return this.A00;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<Integer, Integer> A09(C1981qI c1981qI) {
        int encoding;
        int channelCount;
        int iA03 = C3J.A03((String) AbstractC02053y.A01(c1981qI.A0W), c1981qI.A0R);
        if (!A06.containsKey(Integer.valueOf(iA03))) {
            return null;
        }
        if (iA03 == 18 && !A0A(18)) {
            iA03 = 6;
        } else if (iA03 == 8 && !A0A(8)) {
            iA03 = 7;
        }
        if (!A0A(iA03)) {
            return null;
        }
        int i = c1981qI.A06;
        String[] strArr = A03;
        String str = strArr[7];
        String str2 = strArr[2];
        int length = str.length();
        int encoding2 = str2.length();
        if (length != encoding2) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[6] = "4KpokJkqLEvhjIg40C82zBlUQNBiJ4Nh";
        strArr2[3] = "qYsciqDft0GPV223mm2sV4x00h8r6ql4";
        if (i == -1 || iA03 == 18) {
            int i2 = c1981qI.A0G;
            if (A03[1].charAt(21) != '1') {
                A03[0] = "PeibxLIDNQepcsKrVJzxdcnxdYsUjYYR";
                encoding = i2 != -1 ? c1981qI.A0G : 48000;
            } else {
                String[] strArr3 = A03;
                strArr3[6] = "BgZH8BuYmZ4E43z5yTU6VaJsu5Ivkzql";
                strArr3[3] = "qg4irZvxQMOGKPEC5vFhWWygbOBgLyYA";
                if (i2 != -1) {
                }
            }
            channelCount = A01(iA03, encoding);
        } else {
            channelCount = c1981qI.A06;
            int encoding3 = this.A00;
            if (channelCount > encoding3) {
                return null;
            }
        }
        int encoding4 = A00(channelCount);
        if (encoding4 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iA03), Integer.valueOf(encoding4));
    }

    public final boolean A0A(int i) {
        return Arrays.binarySearch(this.A01, i) >= 0;
    }

    public final boolean A0B(C1981qI c1981qI) {
        return A09(c1981qI) != null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8R)) {
            return false;
        }
        C8R c8r = (C8R) obj;
        return Arrays.equals(this.A01, c8r.A01) && this.A00 == c8r.A00;
    }

    public final int hashCode() {
        return this.A00 + (Arrays.hashCode(this.A01) * 31);
    }

    public final String toString() {
        return A05(27, 34, 99) + this.A00 + A05(0, 21, 13) + Arrays.toString(this.A01) + A05(67, 1, 61);
    }
}
