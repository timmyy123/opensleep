package com.urbandroid.util;

import android.content.Context;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.Settings;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ColorUtil {
    public static int addAlpha(int i, int i2) {
        return Color.argb(i2, Color.red(i), Color.green(i), Color.blue(i));
    }

    public static int i(Context context, int i) {
        int graphColorTheme = new Settings(context).getGraphColorTheme();
        int resourceByName = ContextCompat.getColor(context, i) == ContextCompat.getColor(context, R.color.negative_ultra_light) ? R.color.negative_light : 0;
        if (graphColorTheme > 0) {
            try {
                switch (i) {
                    case R.color.actigraph /* 2131099678 */:
                        resourceByName = ResourceUtil.getResourceByName(context, "color", "actigraph_" + graphColorTheme);
                        break;
                    case R.color.average /* 2131099687 */:
                        resourceByName = ResourceUtil.getResourceByName(context, "color", "average_" + graphColorTheme);
                        break;
                    case R.color.awake /* 2131099693 */:
                        resourceByName = ResourceUtil.getResourceByName(context, "color", "awake_" + graphColorTheme);
                        break;
                    case R.color.deep_sleep /* 2131099816 */:
                        resourceByName = ResourceUtil.getResourceByName(context, "color", "deep_sleep_" + graphColorTheme);
                        break;
                    case R.color.light_sleep /* 2131099902 */:
                        resourceByName = ResourceUtil.getResourceByName(context, "color", "light_sleep_" + graphColorTheme);
                        break;
                    case R.color.negative_light /* 2131100754 */:
                        resourceByName = ResourceUtil.getResourceByName(context, "color", "negative_light_" + graphColorTheme);
                        break;
                    case R.color.positive /* 2131100770 */:
                        resourceByName = ResourceUtil.getResourceByName(context, "color", "positive_" + graphColorTheme);
                        break;
                    case R.color.positive_light /* 2131100781 */:
                        resourceByName = ResourceUtil.getResourceByName(context, "color", "positive_light_" + graphColorTheme);
                        break;
                    case R.color.tint /* 2131100894 */:
                        resourceByName = ResourceUtil.getResourceByName(context, "color", "tint_" + graphColorTheme);
                        break;
                    case R.color.tint_background /* 2131100901 */:
                        resourceByName = ResourceUtil.getResourceByName(context, "color", "tint_background_" + graphColorTheme);
                        break;
                    case R.color.tint_background_bedtime /* 2131100909 */:
                        resourceByName = ResourceUtil.getResourceByName(context, "color", "tint_background_" + graphColorTheme);
                        break;
                }
            } catch (Exception unused) {
            }
        }
        if (resourceByName == 0) {
            resourceByName = i;
        }
        try {
            return ContextCompat.getColor(context, resourceByName);
        } catch (Exception unused2) {
            return ContextCompat.getColor(context, i);
        }
    }

    public static int interpolate(float f, int i, int i2) {
        return ((((i >> 24) & PHIpAddressSearchManager.END_IP_SCAN) + ((int) ((((i2 >> 24) & PHIpAddressSearchManager.END_IP_SCAN) - r0) * f))) << 24) | ((((i >> 16) & PHIpAddressSearchManager.END_IP_SCAN) + ((int) ((((i2 >> 16) & PHIpAddressSearchManager.END_IP_SCAN) - r1) * f))) << 16) | ((((i >> 8) & PHIpAddressSearchManager.END_IP_SCAN) + ((int) ((((i2 >> 8) & PHIpAddressSearchManager.END_IP_SCAN) - r2) * f))) << 8) | ((i & PHIpAddressSearchManager.END_IP_SCAN) + ((int) (f * ((i2 & PHIpAddressSearchManager.END_IP_SCAN) - r7))));
    }
}
