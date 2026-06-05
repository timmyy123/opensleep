package io.github.zeroone3010.yahueapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class XAndYAndBrightness {
    final int brightness;
    final float x;
    final float y;

    public XAndYAndBrightness(float f, float f2, int i) {
        this.x = f;
        this.y = f2;
        this.brightness = i;
    }

    public static double gammaCorrection(float f) {
        return f > 0.04045f ? Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d) : f / 12.92f;
    }

    public static XAndYAndBrightness rgbToXy(Color color) {
        float red = color.getRed();
        float green = color.getGreen();
        float blue = color.getBlue();
        double dGammaCorrection = gammaCorrection(red);
        double dGammaCorrection2 = gammaCorrection(green);
        double dGammaCorrection3 = gammaCorrection(blue);
        double d = (0.1620279997587204d * dGammaCorrection3) + (0.1543239951133728d * dGammaCorrection2) + (0.6645110249519348d * dGammaCorrection);
        double d2 = (0.04768500104546547d * dGammaCorrection3) + (0.6684330105781555d * dGammaCorrection2) + (0.2838810086250305d * dGammaCorrection);
        double d3 = dGammaCorrection3 * 0.9860389828681946d;
        double d4 = d + d2 + d3 + (dGammaCorrection2 * 0.07231000065803528d) + (dGammaCorrection * 8.800000068731606E-5d);
        return new XAndYAndBrightness((float) (d / d4), (float) (d2 / d4), (int) (d2 * 255.0d));
    }

    public int getBrightness() {
        return this.brightness;
    }

    public int getBrightnessMax100() {
        return (int) ((((double) this.brightness) / 255.0d) * 100.0d);
    }

    public float getX() {
        return this.x;
    }

    public List<Float> getXY() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(this.x));
        arrayList.add(Float.valueOf(this.y));
        return arrayList;
    }

    public float getY() {
        return this.y;
    }

    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }
}
