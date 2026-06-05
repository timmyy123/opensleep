package com.google.android.material.animation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.animation.TypeEvaluator;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes4.dex */
public class ArgbEvaluatorCompat implements TypeEvaluator<Integer> {
    private static final ArgbEvaluatorCompat instance = new ArgbEvaluatorCompat();

    public static ArgbEvaluatorCompat getInstance() {
        return instance;
    }

    @Override // android.animation.TypeEvaluator
    public Integer evaluate(float f, Integer num, Integer num2) {
        int iIntValue = num.intValue();
        float f2 = ((iIntValue >> 24) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        float f3 = ((iIntValue >> 16) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        float f4 = ((iIntValue >> 8) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        int iIntValue2 = num2.intValue();
        float f5 = ((iIntValue2 >> 24) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        float f6 = ((iIntValue2 >> 16) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        float f7 = ((iIntValue2 >> 8) & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f;
        float fPow = (float) Math.pow(f3, 2.2d);
        float fPow2 = (float) Math.pow(f4, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(f6, 2.2d);
        float fPow5 = (float) Math.pow(f7, 2.2d);
        float fPow6 = (float) Math.pow((iIntValue2 & PHIpAddressSearchManager.END_IP_SCAN) / 255.0f, 2.2d);
        float fM = FileInsert$$ExternalSyntheticOutline0.m(f5, f2, f, f2);
        float fM2 = FileInsert$$ExternalSyntheticOutline0.m(fPow4, fPow, f, fPow);
        float fM3 = FileInsert$$ExternalSyntheticOutline0.m(fPow5, fPow2, f, fPow2);
        float fM4 = FileInsert$$ExternalSyntheticOutline0.m(fPow6, fPow3, f, fPow3);
        float fPow7 = ((float) Math.pow(fM2, 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(fM3, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(fM4, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(fM * 255.0f) << 24) | (Math.round(fPow8) << 8));
    }
}
