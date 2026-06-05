package com.urbandroid.common.emulator;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EmulatorDetector {
    private static Boolean isEmulator = Boolean.FALSE;

    public static boolean isEmulator(Context context) {
        return isEmulator.booleanValue();
    }
}
