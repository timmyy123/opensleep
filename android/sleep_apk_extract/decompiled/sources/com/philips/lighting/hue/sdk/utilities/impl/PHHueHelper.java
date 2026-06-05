package com.philips.lighting.hue.sdk.utilities.impl;

/* JADX INFO: loaded from: classes4.dex */
public class PHHueHelper {
    public static final int BRIDGE_VERSION_1_0 = 1005215;
    public static final int BRIDGE_VERSION_1_1 = 1005825;
    public static final int BRIDGE_VERSION_1_1_1 = 1005948;
    public static final int BRIDGE_VERSION_1_1_2 = 1006390;
    public static final int BRIDGE_VERSION_1_1_2_1 = 1007920;
    public static final int BRIDGE_VERSION_1_1_2_2 = 1007986;
    public static final int BRIDGE_VERSION_1_2 = 1007000;

    public static String formatMacAddress(String str) {
        if (str == null) {
            return null;
        }
        String strReplace = str.replace(":", "");
        if (strReplace.length() != 12) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strReplace.substring(0, 2));
        stringBuffer.append(":");
        stringBuffer.append(strReplace.substring(2, 4));
        stringBuffer.append(":");
        stringBuffer.append(strReplace.substring(4, 6));
        stringBuffer.append(":");
        stringBuffer.append(strReplace.substring(6, 8));
        stringBuffer.append(":");
        stringBuffer.append(strReplace.substring(8, 10));
        stringBuffer.append(":");
        stringBuffer.append(strReplace.substring(10, 12));
        return stringBuffer.toString();
    }

    public static int getBridgeVersion(int i) {
        return i <= 1005215 ? BRIDGE_VERSION_1_0 : i < 1005825 ? BRIDGE_VERSION_1_1 : (i <= 1005948 || i == 1007920 || i == 1007986) ? BRIDGE_VERSION_1_1_1 : BRIDGE_VERSION_1_2;
    }

    public static String macAddressFromBridgeId(String str) {
        if (str == null) {
            return null;
        }
        return str.length() != 16 ? str : formatMacAddress(str.substring(0, 6).concat(str.substring(10)));
    }

    public static float precision(float f) {
        return Math.round(f * 10000.0f) / 10000.0f;
    }
}
