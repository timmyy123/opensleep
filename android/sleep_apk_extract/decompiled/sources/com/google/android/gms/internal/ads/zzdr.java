package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzdr {
    private static final Pattern zza = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern zzb = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern zzc = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map zzd;

    static {
        HashMap map = new HashMap();
        zzd = map;
        zzba$$ExternalSyntheticOutline0.m(-984833, map, "aliceblue", -332841, "antiquewhite");
        Integer numValueOf = Integer.valueOf(Color.CYAN);
        map.put("aqua", numValueOf);
        map.put("aquamarine", -8388652);
        zzba$$ExternalSyntheticOutline0.m(-983041, map, "azure", -657956, "beige");
        zzba$$ExternalSyntheticOutline0.m(-6972, map, "bisque", Color.BLACK, "black");
        zzba$$ExternalSyntheticOutline0.m(-5171, map, "blanchedalmond", Color.BLUE, "blue");
        zzba$$ExternalSyntheticOutline0.m(-7722014, map, "blueviolet", -5952982, "brown");
        zzba$$ExternalSyntheticOutline0.m(-2180985, map, "burlywood", -10510688, "cadetblue");
        zzba$$ExternalSyntheticOutline0.m(-8388864, map, "chartreuse", -2987746, "chocolate");
        zzba$$ExternalSyntheticOutline0.m(-32944, map, "coral", -10185235, "cornflowerblue");
        zzba$$ExternalSyntheticOutline0.m(-1828, map, "cornsilk", -2354116, "crimson");
        map.put("cyan", numValueOf);
        map.put("darkblue", -16777077);
        zzba$$ExternalSyntheticOutline0.m(-16741493, map, "darkcyan", -4684277, "darkgoldenrod");
        map.put("darkgray", -5658199);
        map.put("darkgreen", -16751616);
        map.put("darkgrey", -5658199);
        map.put("darkkhaki", -4343957);
        zzba$$ExternalSyntheticOutline0.m(-7667573, map, "darkmagenta", -11179217, "darkolivegreen");
        zzba$$ExternalSyntheticOutline0.m(-29696, map, "darkorange", -6737204, "darkorchid");
        zzba$$ExternalSyntheticOutline0.m(-7667712, map, "darkred", -1468806, "darksalmon");
        zzba$$ExternalSyntheticOutline0.m(-7357297, map, "darkseagreen", -12042869, "darkslateblue");
        map.put("darkslategray", -13676721);
        map.put("darkslategrey", -13676721);
        map.put("darkturquoise", -16724271);
        map.put("darkviolet", -7077677);
        zzba$$ExternalSyntheticOutline0.m(-60269, map, "deeppink", -16728065, "deepskyblue");
        map.put("dimgray", -9868951);
        map.put("dimgrey", -9868951);
        map.put("dodgerblue", -14774017);
        map.put("firebrick", -5103070);
        zzba$$ExternalSyntheticOutline0.m(-1296, map, "floralwhite", -14513374, "forestgreen");
        Integer numValueOf2 = Integer.valueOf(Color.MAGENTA);
        map.put("fuchsia", numValueOf2);
        map.put("gainsboro", -2302756);
        zzba$$ExternalSyntheticOutline0.m(-460545, map, "ghostwhite", -10496, "gold");
        map.put("goldenrod", -2448096);
        map.put("gray", -8355712);
        zzba$$ExternalSyntheticOutline0.m(-16744448, map, "green", -5374161, "greenyellow");
        map.put("grey", -8355712);
        map.put("honeydew", -983056);
        zzba$$ExternalSyntheticOutline0.m(-38476, map, "hotpink", -3318692, "indianred");
        zzba$$ExternalSyntheticOutline0.m(-11861886, map, "indigo", -16, "ivory");
        zzba$$ExternalSyntheticOutline0.m(-989556, map, "khaki", -1644806, "lavender");
        zzba$$ExternalSyntheticOutline0.m(-3851, map, "lavenderblush", -8586240, "lawngreen");
        zzba$$ExternalSyntheticOutline0.m(-1331, map, "lemonchiffon", -5383962, "lightblue");
        zzba$$ExternalSyntheticOutline0.m(-1015680, map, "lightcoral", -2031617, "lightcyan");
        map.put("lightgoldenrodyellow", -329006);
        map.put("lightgray", -2894893);
        map.put("lightgreen", -7278960);
        map.put("lightgrey", -2894893);
        zzba$$ExternalSyntheticOutline0.m(-18751, map, "lightpink", -24454, "lightsalmon");
        zzba$$ExternalSyntheticOutline0.m(-14634326, map, "lightseagreen", -7876870, "lightskyblue");
        map.put("lightslategray", -8943463);
        map.put("lightslategrey", -8943463);
        map.put("lightsteelblue", -5192482);
        map.put("lightyellow", -32);
        zzba$$ExternalSyntheticOutline0.m(Color.GREEN, map, "lime", -13447886, "limegreen");
        map.put("linen", -331546);
        map.put("magenta", numValueOf2);
        zzba$$ExternalSyntheticOutline0.m(-8388608, map, "maroon", -10039894, "mediumaquamarine");
        zzba$$ExternalSyntheticOutline0.m(-16777011, map, "mediumblue", -4565549, "mediumorchid");
        zzba$$ExternalSyntheticOutline0.m(-7114533, map, "mediumpurple", -12799119, "mediumseagreen");
        zzba$$ExternalSyntheticOutline0.m(-8689426, map, "mediumslateblue", -16713062, "mediumspringgreen");
        zzba$$ExternalSyntheticOutline0.m(-12004916, map, "mediumturquoise", -3730043, "mediumvioletred");
        zzba$$ExternalSyntheticOutline0.m(-15132304, map, "midnightblue", -655366, "mintcream");
        zzba$$ExternalSyntheticOutline0.m(-6943, map, "mistyrose", -6987, "moccasin");
        zzba$$ExternalSyntheticOutline0.m(-8531, map, "navajowhite", -16777088, "navy");
        zzba$$ExternalSyntheticOutline0.m(-133658, map, "oldlace", -8355840, "olive");
        zzba$$ExternalSyntheticOutline0.m(-9728477, map, "olivedrab", -23296, "orange");
        zzba$$ExternalSyntheticOutline0.m(-47872, map, "orangered", -2461482, "orchid");
        zzba$$ExternalSyntheticOutline0.m(-1120086, map, "palegoldenrod", -6751336, "palegreen");
        zzba$$ExternalSyntheticOutline0.m(-5247250, map, "paleturquoise", -2396013, "palevioletred");
        zzba$$ExternalSyntheticOutline0.m(-4139, map, "papayawhip", -9543, "peachpuff");
        zzba$$ExternalSyntheticOutline0.m(-3308225, map, "peru", -16181, "pink");
        zzba$$ExternalSyntheticOutline0.m(-2252579, map, "plum", -5185306, "powderblue");
        zzba$$ExternalSyntheticOutline0.m(-8388480, map, "purple", -10079335, "rebeccapurple");
        zzba$$ExternalSyntheticOutline0.m(Color.RED, map, "red", -4419697, "rosybrown");
        zzba$$ExternalSyntheticOutline0.m(-12490271, map, "royalblue", -7650029, "saddlebrown");
        zzba$$ExternalSyntheticOutline0.m(-360334, map, "salmon", -744352, "sandybrown");
        zzba$$ExternalSyntheticOutline0.m(-13726889, map, "seagreen", -2578, "seashell");
        zzba$$ExternalSyntheticOutline0.m(-6270419, map, "sienna", -4144960, "silver");
        zzba$$ExternalSyntheticOutline0.m(-7876885, map, "skyblue", -9807155, "slateblue");
        map.put("slategray", -9404272);
        map.put("slategrey", -9404272);
        map.put("snow", -1286);
        map.put("springgreen", -16711809);
        zzba$$ExternalSyntheticOutline0.m(-12156236, map, "steelblue", -2968436, "tan");
        zzba$$ExternalSyntheticOutline0.m(-16744320, map, "teal", -2572328, "thistle");
        zzba$$ExternalSyntheticOutline0.m(-40121, map, "tomato", 0, "transparent");
        zzba$$ExternalSyntheticOutline0.m(-12525360, map, "turquoise", -1146130, "violet");
        zzba$$ExternalSyntheticOutline0.m(-663885, map, "wheat", -1, "white");
        zzba$$ExternalSyntheticOutline0.m(-657931, map, "whitesmoke", Color.YELLOW, "yellow");
        map.put("yellowgreen", -6632142);
    }

    public static int zza(String str) {
        return zzc(str, false);
    }

    public static int zzb(String str) {
        return zzc(str, true);
    }

    private static int zzc(String str, boolean z) {
        int i;
        zzgtj.zza(!TextUtils.isEmpty(str));
        String strReplace = str.replace(" ", "");
        if (strReplace.charAt(0) == '#') {
            int i2 = (int) Long.parseLong(strReplace.substring(1), 16);
            if (strReplace.length() == 7) {
                return (-16777216) | i2;
            }
            if (strReplace.length() == 9) {
                return ((i2 & PHIpAddressSearchManager.END_IP_SCAN) << 24) | (i2 >>> 8);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            return 0;
        }
        if (strReplace.startsWith("rgba")) {
            Matcher matcher = (z ? zzc : zzb).matcher(strReplace);
            if (matcher.matches()) {
                if (z) {
                    String strGroup = matcher.group(4);
                    strGroup.getClass();
                    i = (int) (Float.parseFloat(strGroup) * 255.0f);
                } else {
                    String strGroup2 = matcher.group(4);
                    strGroup2.getClass();
                    i = Integer.parseInt(strGroup2, 10);
                }
                String strGroup3 = matcher.group(1);
                strGroup3.getClass();
                int i3 = Integer.parseInt(strGroup3, 10);
                String strGroup4 = matcher.group(2);
                strGroup4.getClass();
                int i4 = Integer.parseInt(strGroup4, 10);
                String strGroup5 = matcher.group(3);
                strGroup5.getClass();
                return android.graphics.Color.argb(i, i3, i4, Integer.parseInt(strGroup5, 10));
            }
        } else if (strReplace.startsWith("rgb")) {
            Matcher matcher2 = zza.matcher(strReplace);
            if (matcher2.matches()) {
                String strGroup6 = matcher2.group(1);
                strGroup6.getClass();
                int i5 = Integer.parseInt(strGroup6, 10);
                String strGroup7 = matcher2.group(2);
                strGroup7.getClass();
                int i6 = Integer.parseInt(strGroup7, 10);
                String strGroup8 = matcher2.group(3);
                strGroup8.getClass();
                return android.graphics.Color.rgb(i5, i6, Integer.parseInt(strGroup8, 10));
            }
        } else {
            Integer num = (Integer) zzd.get(zzgss.zza(strReplace));
            if (num != null) {
                return num.intValue();
            }
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3();
        return 0;
    }
}
