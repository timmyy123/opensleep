package com.urbandroid.sleep.gui;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MathUtils {
    public static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static float lerp(float f, float f2, float f3) {
        return FileInsert$$ExternalSyntheticOutline0.m(f2, f, f3, f);
    }

    public static float lerpInv(float f, float f2, float f3) {
        if (f != f2) {
            return (f3 - f) / (f2 - f);
        }
        return 0.0f;
    }

    public static float lerpInvSat(float f, float f2, float f3) {
        return saturate(lerpInv(f, f2, f3));
    }

    public static float saturate(float f) {
        return constrain(f, 0.0f, 1.0f);
    }
}
