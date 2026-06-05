package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.AdSettings;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.google.home.platform.traits.ValidationIssue;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class OX {
    public static byte[] A00;
    public static String[] A01 = {"alBbxktHBjENZciLxR6rw2zD", "0bEVAsoxw6W3iWGX6BxBwig2lvfARzA8", "5kBw8VexBy79GKA0j07dIkKJ", "062DxPuwmCK6gWRcItF5YTW3Hm4KDyy6", "ouexH0ba", "qAJVUQLE", "GBKgEyO20ouPxSasMb", "BGZyEH20hLZ9tDha5NwFDNnmUBWPcH0M"};

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[3].charAt(0) != strArr[1].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "tBRy7z9w";
            strArr2[4] = "5uJXeywj";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 69);
            i4++;
        }
    }

    public static void A07() {
        A00 = new byte[]{-32, -40, -36, -37, -40, -38, -2, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 8, 27, 1, 20, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 8, 5, -1, 5, 16, 27, 16, 1, 15, 16, 27, 9, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 0, 1, 27, 7, 1, 21, -66, -53, -53, -56, -37, -59, -49, -37, -62, -47, -54, -54, -63, -56, -37, -56, -53, -61, -61, -63, -64, -119, -106, -106, -109, -90, -112, -102, -90, -100, -107, -112, -101, -96, -56, -43, -43, -46, -27, -45, -49, -34, -53, -54, -27, -57, -37, -54, -49, -53, -44, -55, -53, -27, -47, -53, -33, -94, -81, -81, -84, -65, -78, -74, -65, -90, -95, -87, -84, -65, -81, -82, -65, -93, -95, -93, -88, -91, -65, -90, -95, -87, -84, -75, -78, -91, -65, -85, -91, -71, -40, -21, -28, -38, -30, -37, -11, -23, -37, -22, -22, -33, -28, -35, -23, -11, -31, -37, -17, -40, -43, -24, -43, -13, -28, -26, -29, -41, -39, -25, -25, -35, -30, -37, -13, -29, -28, -24, -35, -29, -30, -25, -13, -41, -29, -23, -30, -24, -26, -19, -13, -33, -39, -19, -64, -67, -48, -67, -37, -52, -50, -53, -65, -63, -49, -49, -59, -54, -61, -37, -53, -52, -48, -59, -53, -54, -49, -37, -57, -63, -43, -7, -10, 9, -10, 20, 5, 7, 4, -8, -6, 8, 8, -2, 3, -4, 20, 4, 5, 9, -2, 4, 3, 8, 20, 8, 9, -10, 9, -6, 20, 0, -6, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, -80, -79, -81, -68, -98, -95, -68, -94, -75, -83, -94, -81, -90, -94, -85, -96, -94, -68, -79, -74, -83, -94, -28, -27, -29, -16, -46, -43, -16, -38, -43, -16, -36, -42, -22, 16, 17, 15, 28, -2, 1, 28, 17, 2, 16, 17, 28, 17, 22, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 2, 28, 8, 2, 22, -86, -85, -87, -74, -103, -96, -101, -74, -89, -104, -80, -93, -90, -104, -101, -74, -94, -100, -80, -53, -52, -54, -41, -70, -52, -41, -52, -57, -61, -67, -58, -41, -67, -48, -52, -54, -71, -53, -74, -73, -75, -62, -91, -72, -79, -89, -81, -88, -62, -82, -88, -68, -8, -7, -9, 4, -24, -15, -18, -22, -13, -7, 4, -8, -23, -16, 4, -5, -22, -9, -8, -18, -12, -13, -104, -103, -105, -92, -118, -99, -103, -105, -122, -92, -115, -114, -109, -103, -104, -92, -112, -118, -98, -8, -7, -9, 4, -18, -13, -7, 4, -24, -26, -24, -19, -22, 4, -21, -15, -26, -20, -8, -6, -5, -7, 6, -12, -20, -21, -16, -24, -5, -16, -10, -11, 6, -21, -24, -5, -24, 6, -14, -20, 0, -39, -38, -40, -27, -45, -53, -54, -49, -57, -38, -49, -43, -44, -27, -39, -53, -40, -36, -49, -55, -53, -27, -47, -53, -33, -88, -87, -89, -76, -91, -95, -106, -104, -102, -94, -102, -93, -87, -76, -96, -102, -82};
    }

    static {
        A07();
    }

    public static Bundle A00(T8 t8) {
        Bundle bundle = new Bundle();
        A08(bundle, t8);
        String strA06 = A06(123, 19, 81);
        Bundle data2 = A01(t8);
        bundle.putBundle(strA06, data2);
        return bundle;
    }

    public static Bundle A01(T8 t8) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(A06(67, 23, 65), AdSettings.isMixedAudience());
        bundle.putBoolean(A06(6, 27, 119), AdInternalSettings.isExplicitTestMode());
        String adTypeString = AdSettings.getTestAdType().getAdTypeString();
        if (adTypeString != null) {
            bundle.putString(A06(272, 20, 120), adTypeString);
        }
        MultithreadedBundleWrapper multithreadedBundleWrapper = AdInternalSettings.sSettingsBundle;
        String adTypeString2 = A06(177, 27, 55);
        String[] stringArray = multithreadedBundleWrapper.getStringArray(adTypeString2);
        if (stringArray != null) {
            bundle.putStringArray(adTypeString2, stringArray);
        }
        MultithreadedBundleWrapper multithreadedBundleWrapper2 = AdInternalSettings.sSettingsBundle;
        String adTypeString3 = A06(142, 35, 79);
        Integer integer = multithreadedBundleWrapper2.getInteger(adTypeString3);
        if (integer != null) {
            bundle.putInt(adTypeString3, integer.intValue());
        }
        MultithreadedBundleWrapper multithreadedBundleWrapper3 = AdInternalSettings.sSettingsBundle;
        String adTypeString4 = A06(ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER, 33, 112);
        Integer integer2 = multithreadedBundleWrapper3.getInteger(adTypeString4);
        if (integer2 != null) {
            bundle.putInt(adTypeString4, integer2.intValue());
        }
        MultithreadedBundleWrapper multithreadedBundleWrapper4 = AdInternalSettings.sSettingsBundle;
        String adTypeString5 = A06(426, 25, 65);
        String string = multithreadedBundleWrapper4.getString(adTypeString5, null);
        if (string != null) {
            bundle.putString(adTypeString5, string);
        }
        bundle.putBoolean(A06(54, 13, 2), XY.A05(t8));
        return bundle;
    }

    public static Bundle A02(String str, C1531iY c1531iY) {
        Bundle bundle = new Bundle();
        A08(bundle, c1531iY.A05());
        bundle.putString(A06(451, 17, 16), c1531iY.A0A());
        bundle.putString(A06(259, 13, 76), str);
        bundle.putString(A06(292, 19, 18), c1531iY.A07());
        bundle.putString(A06(366, 19, 0), c1531iY.A08());
        bundle.putString(A06(404, 22, 98), c1531iY.A09());
        bundle.putString(A06(385, 19, 96), OT.A01(c1531iY.A0B()));
        RewardData rewardDataA03 = c1531iY.A03();
        if (rewardDataA03 != null) {
            OY.A00(bundle, rewardDataA03);
        }
        C1421gi c1421giA05 = c1531iY.A05();
        if (A01[7].charAt(1) != 'G') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "0oVBtG1RnxV7P3aL2rsTsgmpFLriyJEV";
        strArr[1] = "0Gc5rqVWsYOknMrZ8UJ0maJdrGSSYWXy";
        bundle.putBundle(A06(123, 19, 81), A01(c1421giA05));
        return bundle;
    }

    public static Bundle A03(String str, C1516iI c1516iI) {
        Bundle bundle = new Bundle();
        A08(bundle, c1516iI.A0B);
        bundle.putString(A06(451, 17, 16), c1516iI.A0D);
        bundle.putString(A06(259, 13, 76), str);
        bundle.putString(A06(292, 19, 18), c1516iI.A05);
        bundle.putString(A06(366, 19, 0), c1516iI.A06);
        bundle.putString(A06(404, 22, 98), c1516iI.A07);
        AdExperienceType adExperienceType = c1516iI.A02;
        if (adExperienceType != null) {
            bundle.putString(A06(237, 22, 24), OS.A02(adExperienceType));
        }
        bundle.putBoolean(A06(90, 33, 27), c1516iI.A08);
        RewardData rewardData = c1516iI.A03;
        if (rewardData != null) {
            OY.A00(bundle, rewardData);
        }
        bundle.putBundle(A06(123, 19, 81), A01(c1516iI.A0B));
        return bundle;
    }

    public static C1531iY A04(C1421gi c1421gi, Bundle bundle, String str) {
        String string = bundle.getString(A06(451, 17, 16));
        String placement = A06(292, 19, 18);
        String string2 = bundle.getString(placement);
        String placement2 = A06(366, 19, 0);
        String string3 = bundle.getString(placement2);
        String placement3 = A06(404, 22, 98);
        String sdkVersion = bundle.getString(placement3);
        String placement4 = A06(344, 22, 96);
        String string4 = bundle.getString(placement4);
        String placement5 = A06(123, 19, 81);
        Bundle bundle2 = bundle.getBundle(placement5);
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if (string == null) {
            string = A06(0, 0, 60);
        }
        C1531iY c1531iY = new C1531iY(c1421gi, null, string, new C1522iP(str, string4, bundle2));
        c1531iY.A0I(string3);
        c1531iY.A0H(string2);
        c1531iY.A0J(sdkVersion);
        String placement6 = A06(385, 19, 96);
        c1531iY.A0K(OT.A02(bundle.getString(placement6)));
        RewardData rewardDataA01 = OY.A01(bundle);
        if (rewardDataA01 != null) {
            c1531iY.A0F(rewardDataA01);
        }
        return c1531iY;
    }

    public static C1516iI A05(C1421gi c1421gi, Bundle bundle, String str) {
        String string = bundle.getString(A06(451, 17, 16));
        String rvPlacement = A06(292, 19, 18);
        String string2 = bundle.getString(rvPlacement);
        String rvPlacement2 = A06(90, 33, 27);
        boolean z = bundle.getBoolean(rvPlacement2);
        String rvPlacement3 = A06(366, 19, 0);
        String adExperienceType = bundle.getString(rvPlacement3);
        String rvPlacement4 = A06(404, 22, 98);
        String mediationData = bundle.getString(rvPlacement4);
        String rvPlacement5 = A06(237, 22, 24);
        String string3 = bundle.getString(rvPlacement5);
        String rvPlacement6 = A06(344, 22, 96);
        String string4 = bundle.getString(rvPlacement6);
        String rvPlacement7 = A06(123, 19, 81);
        Bundle bundle2 = bundle.getBundle(rvPlacement7);
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if (string == null) {
            string = A06(0, 0, 60);
        }
        C1516iI c1516iI = new C1516iI(c1421gi, string, null, new C1522iP(str, string4, bundle2));
        c1516iI.A06 = adExperienceType;
        c1516iI.A05 = string2;
        c1516iI.A08 = z;
        c1516iI.A02 = OS.A00(string3);
        c1516iI.A07 = mediationData;
        RewardData rewardDataA01 = OY.A01(bundle);
        if (rewardDataA01 != null) {
            c1516iI.A03 = rewardDataA01;
        }
        return c1516iI;
    }

    public static void A08(Bundle bundle, T8 t8) {
        bundle.putString(A06(344, 22, 96), A06(0, 6, 101));
        boolean zAAT = false;
        boolean isForcedFunnelLogging = t8 instanceof C1421gi;
        if (isForcedFunnelLogging) {
            zAAT = ((C1421gi) t8).A0F().AAT();
        }
        boolean isForcedFunnelLogging2 = TX.A0I(t8);
        bundle.putBoolean(A06(33, 21, 55), isForcedFunnelLogging2 || zAAT);
        bundle.putString(A06(330, 14, 30), t8.getPackageName());
        boolean isForcedFunnelLogging3 = AbstractC0874Us.A0G(t8);
        if (isForcedFunnelLogging3) {
            bundle.putString(A06(311, 19, 51), new C0817Sn().A03(t8));
        }
    }
}
