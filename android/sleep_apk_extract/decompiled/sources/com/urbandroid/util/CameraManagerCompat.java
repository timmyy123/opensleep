package com.urbandroid.util;

import android.hardware.camera2.CameraManager;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CameraManagerCompat {
    public static String[] getCameraIdList(CameraManager cameraManager) {
        try {
            return (String[]) cameraManager.getClass().getMethod("getCameraIdList", null).invoke(cameraManager, null);
        } catch (Exception e) {
            Logger.logSevere(e);
            return new String[0];
        }
    }

    public static void setTorchMode(CameraManager cameraManager, String str, boolean z) {
        try {
            cameraManager.getClass().getMethod("setTorchMode", String.class, Boolean.TYPE).invoke(cameraManager, str, Boolean.valueOf(z));
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }
}
