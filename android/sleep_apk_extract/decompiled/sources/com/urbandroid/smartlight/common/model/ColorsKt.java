package com.urbandroid.smartlight.common.model;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.model.Color;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\r¨\u0006\u000e"}, d2 = {"toRgb", "Lcom/urbandroid/smartlight/common/model/Color$Rgb;", "Lcom/urbandroid/smartlight/common/model/Color$Hsv;", "toTradfri", "Lcom/urbandroid/smartlight/common/model/Color$D65;", "Lcom/urbandroid/smartlight/common/model/Color$Brightness;", "Lcom/urbandroid/smartlight/common/model/Color$HsvCt;", "hsbToRgb", "", "hue", "", "saturation", "brightness", "Lcom/urbandroid/smartlight/common/model/Color$Hsb;", "smartlight_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorsKt {
    public static final int hsbToRgb(float f, float f2, float f3) {
        int i;
        int i2;
        int i3;
        if (f2 != 0.0f) {
            float fFloor = (f - ((float) Math.floor(f))) * 6.0f;
            float fFloor2 = fFloor - ((float) Math.floor(fFloor));
            float f4 = (1.0f - f2) * f3;
            float f5 = (1.0f - (f2 * fFloor2)) * f3;
            float f6 = (1.0f - ((1.0f - fFloor2) * f2)) * f3;
            int i4 = (int) fFloor;
            if (i4 == 0) {
                i = (int) ((f3 * 255.0f) + 0.5f);
                i2 = (int) ((f6 * 255.0f) + 0.5f);
            } else {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 == 3) {
                            i = (int) ((f4 * 255.0f) + 0.5f);
                            i2 = (int) ((f5 * 255.0f) + 0.5f);
                        } else if (i4 == 4) {
                            i = (int) ((f6 * 255.0f) + 0.5f);
                            i2 = (int) ((f4 * 255.0f) + 0.5f);
                        } else if (i4 != 5) {
                            i = 0;
                        } else {
                            i = (int) ((f3 * 255.0f) + 0.5f);
                            i2 = (int) ((f4 * 255.0f) + 0.5f);
                            i3 = (int) ((f5 * 255.0f) + 0.5f);
                        }
                        i3 = (int) ((f3 * 255.0f) + 0.5f);
                    } else {
                        i = (int) ((f4 * 255.0f) + 0.5f);
                        i2 = (int) ((f3 * 255.0f) + 0.5f);
                        i3 = (int) ((f6 * 255.0f) + 0.5f);
                    }
                    return (i << 16) | com.philips.lighting.hue.sdk.utilities.impl.Color.BLACK | (i2 << 8) | i3;
                }
                i = (int) ((f5 * 255.0f) + 0.5f);
                i2 = (int) ((f3 * 255.0f) + 0.5f);
            }
            i3 = (int) ((f4 * 255.0f) + 0.5f);
            return (i << 16) | com.philips.lighting.hue.sdk.utilities.impl.Color.BLACK | (i2 << 8) | i3;
        }
        i = (int) ((f3 * 255.0f) + 0.5f);
        i2 = i;
        i3 = i2;
        return (i << 16) | com.philips.lighting.hue.sdk.utilities.impl.Color.BLACK | (i2 << 8) | i3;
    }

    public static final Color.Rgb toRgb(Color.Hsv hsv) {
        double d;
        hsv.getClass();
        double saturation = ((double) hsv.getSaturation()) / 255.0d;
        double value = ((double) hsv.getValue()) / 255.0d;
        double d2 = saturation * value;
        double hue = (((double) hsv.getHue()) * 0.005493247882810712d) / 60.0d;
        double dAbs = (1.0d - Math.abs((hue % 2.0d) - 1.0d)) * d2;
        double d3 = 0.0d;
        if (hue < 0.0d || hue >= 1.0d) {
            if (hue >= 1.0d && hue < 2.0d) {
                d = 0.0d;
            } else {
                if (hue < 2.0d || hue >= 3.0d) {
                    if (hue >= 3.0d && hue < 4.0d) {
                        d3 = dAbs;
                        dAbs = 0.0d;
                    } else if (hue < 4.0d || hue >= 5.0d) {
                        d = dAbs;
                    }
                    d = d2;
                    double d4 = value - d2;
                    return new Color.Rgb((int) ((dAbs + d4) * 255.0d), (int) ((d3 + d4) * 255.0d), (int) ((d + d4) * 255.0d));
                }
                d = dAbs;
                dAbs = 0.0d;
            }
            d3 = d2;
            double d42 = value - d2;
            return new Color.Rgb((int) ((dAbs + d42) * 255.0d), (int) ((d3 + d42) * 255.0d), (int) ((d + d42) * 255.0d));
        }
        d = 0.0d;
        d3 = dAbs;
        dAbs = d2;
        double d422 = value - d2;
        return new Color.Rgb((int) ((dAbs + d422) * 255.0d), (int) ((d3 + d422) * 255.0d), (int) ((d + d422) * 255.0d));
    }

    public static final Color.D65 toTradfri(Color.Rgb rgb) {
        rgb.getClass();
        double red = rgb.getRed();
        double green = rgb.getGreen();
        double blue = rgb.getBlue();
        double dPow = red > 0.04045d ? Math.pow((red + 0.055d) / 1.055d, 2.4d) : red / 12.92d;
        double dPow2 = green > 0.04045d ? Math.pow((green + 0.055d) / 1.055d, 2.4d) : green / 12.92d;
        double dPow3 = blue > 0.04045d ? Math.pow((blue + 0.055d) / 1.055d, 2.4d) : blue / 12.92d;
        double d = (0.162028d * dPow3) + (0.154324d * dPow2) + (0.664511d * dPow);
        double d2 = (0.047685d * dPow3) + (0.668433d * dPow2) + (0.283881d * dPow);
        double d3 = d + d2 + (dPow3 * 0.986039d) + (dPow2 * 0.07231d) + (dPow * 8.8E-5d);
        return new Color.D65((int) (((d / d3) * 65535.0d) + 0.5d), (int) (((d2 / d3) * 65535.0d) + 0.5d), Integer.valueOf((int) ((((double) rgb.getBlue()) * 0.0722d) + (((double) rgb.getGreen()) * 0.7152d) + (((double) rgb.getRed()) * 0.2126d))));
    }

    public static final Color.Rgb toRgb(Color.HsvCt hsvCt) {
        double d;
        hsvCt.getClass();
        double saturation = ((double) hsvCt.getSaturation()) / 255.0d;
        double value = ((double) hsvCt.getValue()) / 255.0d;
        double d2 = saturation * value;
        double hue = (((double) hsvCt.getHue()) * 0.005493247882810712d) / 60.0d;
        double dAbs = (1.0d - Math.abs((hue % 2.0d) - 1.0d)) * d2;
        double d3 = 0.0d;
        if (hue < 0.0d || hue >= 1.0d) {
            if (hue >= 1.0d && hue < 2.0d) {
                d = 0.0d;
            } else {
                if (hue < 2.0d || hue >= 3.0d) {
                    if (hue >= 3.0d && hue < 4.0d) {
                        d3 = dAbs;
                        dAbs = 0.0d;
                    } else if (hue < 4.0d || hue >= 5.0d) {
                        d = dAbs;
                    }
                    d = d2;
                    double d4 = value - d2;
                    return new Color.Rgb((int) ((dAbs + d4) * 255.0d), (int) ((d3 + d4) * 255.0d), (int) ((d + d4) * 255.0d));
                }
                d = dAbs;
                dAbs = 0.0d;
            }
            d3 = d2;
            double d42 = value - d2;
            return new Color.Rgb((int) ((dAbs + d42) * 255.0d), (int) ((d3 + d42) * 255.0d), (int) ((d + d42) * 255.0d));
        }
        d = 0.0d;
        d3 = dAbs;
        dAbs = d2;
        double d422 = value - d2;
        return new Color.Rgb((int) ((dAbs + d422) * 255.0d), (int) ((d3 + d422) * 255.0d), (int) ((d + d422) * 255.0d));
    }

    public static final Color.Rgb toRgb(Color.Hsb hsb) {
        hsb.getClass();
        int iHsbToRgb = hsbToRgb(hsb.getHue() / 65535.0f, hsb.getSaturation() / 255.0f, hsb.getBrightness() / 255.0f);
        StringBuilder sb = new StringBuilder("setState ");
        sb.append(hsb.getHue());
        sb.append(" -> R ");
        int i = (iHsbToRgb >> 16) & PHIpAddressSearchManager.END_IP_SCAN;
        sb.append(i);
        sb.append(" G ");
        int i2 = (iHsbToRgb >> 8) & PHIpAddressSearchManager.END_IP_SCAN;
        sb.append(i2);
        sb.append(" B ");
        int i3 = iHsbToRgb & PHIpAddressSearchManager.END_IP_SCAN;
        sb.append(i3);
        Logger.logInfo(sb.toString(), null);
        return new Color.Rgb(i, i3, i2);
    }

    public static final Color.D65 toTradfri(Color.Brightness brightness) {
        brightness.getClass();
        return new Color.D65(-1, -1, Integer.valueOf(brightness.getBrightness()));
    }
}
