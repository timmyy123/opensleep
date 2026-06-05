package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfwd {
    private static UiModeManager zza;

    public static void zza(Context context) {
        if (context != null) {
            zza = (UiModeManager) context.getSystemService("uimode");
        }
    }

    public static zzfuq zzb() {
        UiModeManager uiModeManager = zza;
        if (uiModeManager == null) {
            return zzfuq.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        return currentModeType != 1 ? currentModeType != 4 ? zzfuq.OTHER : zzfuq.CTV : zzfuq.MOBILE;
    }
}
