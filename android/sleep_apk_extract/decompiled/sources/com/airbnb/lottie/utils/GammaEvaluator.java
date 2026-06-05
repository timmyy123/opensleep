package com.airbnb.lottie.utils;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class GammaEvaluator {
    private static float EOCF_sRGB(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float OECF_sRGB(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f, int i, int i2) {
        if (i == i2 || f <= 0.0f) {
            return i;
        }
        if (f >= 1.0f) {
            return i2;
        }
        float f2 = ((i >> 24) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        float f3 = ((i >> 16) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        float f4 = ((i >> 8) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        float f5 = ((i2 >> 24) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        float f6 = ((i2 >> 16) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        float f7 = ((i2 >> 8) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        float fEOCF_sRGB = EOCF_sRGB(f3);
        float fEOCF_sRGB2 = EOCF_sRGB(f4);
        float fEOCF_sRGB3 = EOCF_sRGB((i & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f);
        float fEOCF_sRGB4 = EOCF_sRGB(f6);
        float fEOCF_sRGB5 = EOCF_sRGB(f7);
        float fEOCF_sRGB6 = EOCF_sRGB((i2 & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f);
        float fM = FileInsert$$ExternalSyntheticOutline0.m(f5, f2, f, f2);
        float fM2 = FileInsert$$ExternalSyntheticOutline0.m(fEOCF_sRGB4, fEOCF_sRGB, f, fEOCF_sRGB);
        float fM3 = FileInsert$$ExternalSyntheticOutline0.m(fEOCF_sRGB5, fEOCF_sRGB2, f, fEOCF_sRGB2);
        float fM4 = FileInsert$$ExternalSyntheticOutline0.m(fEOCF_sRGB6, fEOCF_sRGB3, f, fEOCF_sRGB3);
        float fOECF_sRGB = OECF_sRGB(fM2) * 255.0f;
        float fOECF_sRGB2 = OECF_sRGB(fM3) * 255.0f;
        return Math.round(OECF_sRGB(fM4) * 255.0f) | (Math.round(fOECF_sRGB) << 16) | (Math.round(fM * 255.0f) << 24) | (Math.round(fOECF_sRGB2) << 8);
    }
}
