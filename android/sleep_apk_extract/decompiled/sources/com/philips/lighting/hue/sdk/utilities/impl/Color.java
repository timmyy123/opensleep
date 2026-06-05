package com.philips.lighting.hue.sdk.utilities.impl;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.HashMap;
import java.util.Locale;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class Color {
    public static final int BLACK = -16777216;
    public static final int BLUE = -16776961;
    public static final int CYAN = -16711681;
    public static final int DKGRAY = -12303292;
    public static final int GRAY = -7829368;
    public static final int GREEN = -16711936;
    public static final int LTGRAY = -3355444;
    public static final int MAGENTA = -65281;
    public static final int RED = -65536;
    public static final int TRANSPARENT = 0;
    public static final int WHITE = -1;
    public static final int YELLOW = -256;
    private static final HashMap<String, Integer> sColorNameMap;

    static {
        HashMap<String, Integer> map = new HashMap<>();
        sColorNameMap = map;
        map.put("black", Integer.valueOf(BLACK));
        Integer numValueOf = Integer.valueOf(DKGRAY);
        map.put("darkgray", numValueOf);
        Integer numValueOf2 = Integer.valueOf(GRAY);
        map.put("gray", numValueOf2);
        Integer numValueOf3 = Integer.valueOf(LTGRAY);
        map.put("lightgray", numValueOf3);
        map.put("white", -1);
        map.put("red", Integer.valueOf(RED));
        map.put("green", Integer.valueOf(GREEN));
        map.put("blue", Integer.valueOf(BLUE));
        map.put("yellow", Integer.valueOf(YELLOW));
        map.put("cyan", Integer.valueOf(CYAN));
        map.put("magenta", Integer.valueOf(MAGENTA));
        map.put("aqua", 65535);
        map.put("fuchsia", 16711935);
        map.put("darkgrey", numValueOf);
        map.put("grey", numValueOf2);
        map.put("lightgrey", numValueOf3);
        map.put("lime", 65280);
        map.put("maroon", 8388608);
        map.put("navy", 128);
        map.put("olive", 8421376);
        map.put("purple", 8388736);
        map.put("silver", 12632256);
        map.put("teal", 32896);
    }

    public static int alpha(int i) {
        return i >>> 24;
    }

    public static int argb(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public static int blue(int i) {
        return i & PHIpAddressSearchManager.END_IP_SCAN;
    }

    public static float brightness(int i) {
        return Math.max(i & PHIpAddressSearchManager.END_IP_SCAN, Math.max((i >> 16) & PHIpAddressSearchManager.END_IP_SCAN, (i >> 8) & PHIpAddressSearchManager.END_IP_SCAN)) / 255.0f;
    }

    public static int green(int i) {
        return (i >> 8) & PHIpAddressSearchManager.END_IP_SCAN;
    }

    public static float hue(int i) {
        int i2 = (i >> 16) & PHIpAddressSearchManager.END_IP_SCAN;
        int i3 = (i >> 8) & PHIpAddressSearchManager.END_IP_SCAN;
        int i4 = i & PHIpAddressSearchManager.END_IP_SCAN;
        int iMax = Math.max(i4, Math.max(i2, i3));
        int iMin = Math.min(i4, Math.min(i2, i3));
        if (iMax == iMin) {
            return 0.0f;
        }
        float f = iMax - iMin;
        float f2 = (iMax - i2) / f;
        float f3 = (iMax - i3) / f;
        float f4 = (iMax - i4) / f;
        float f5 = (i2 == iMax ? f4 - f3 : i3 == iMax ? (f2 + 2.0f) - f4 : (f3 + 4.0f) - f2) / 6.0f;
        return f5 < 0.0f ? f5 + 1.0f : f5;
    }

    public static int parseColor(String str) {
        if (str.charAt(0) != '#') {
            Integer num = sColorNameMap.get(str.toLowerCase(Locale.US));
            if (num != null) {
                return num.intValue();
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Unknown color");
            return 0;
        }
        long j = Long.parseLong(str.substring(1), 16);
        if (str.length() == 7) {
            j |= -16777216;
        } else if (str.length() != 9) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Unknown color");
            return 0;
        }
        return (int) j;
    }

    public static int red(int i) {
        return (i >> 16) & PHIpAddressSearchManager.END_IP_SCAN;
    }

    public static int rgb(int i, int i2, int i3) {
        return (i << 16) | BLACK | (i2 << 8) | i3;
    }

    public static float saturation(int i) {
        int i2 = (i >> 16) & PHIpAddressSearchManager.END_IP_SCAN;
        int i3 = (i >> 8) & PHIpAddressSearchManager.END_IP_SCAN;
        int i4 = i & PHIpAddressSearchManager.END_IP_SCAN;
        int iMax = Math.max(i4, Math.max(i2, i3));
        if (iMax == Math.min(i4, Math.min(i2, i3))) {
            return 0.0f;
        }
        return (iMax - r3) / iMax;
    }
}
