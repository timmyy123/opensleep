package com.urbandroid.sleep.service;

import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.view.SurfaceHolder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.util.CameraManagerCompat;
import com.urbandroid.util.SleepPermissionCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class FlashlightServiceAndroidM implements IFlashlightService {
    private Context context;
    private boolean lightOn = false;

    public FlashlightServiceAndroidM(Context context) {
        this.context = context;
    }

    @Override // com.urbandroid.sleep.service.IFlashlightService
    public boolean isTurnedOn() {
        return this.lightOn;
    }

    @Override // com.urbandroid.sleep.service.IFlashlightService
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Logger.logInfo("Flashlight: surfaceCreated");
        if (SleepPermissionCompat.INSTANCE.isPermissionGranted(this.context, "android.permission.CAMERA")) {
            return;
        }
        Logger.logWarning("No permission to use flaslight");
    }

    @Override // com.urbandroid.sleep.service.IFlashlightService
    public void surfaceDestroyed() {
    }

    @Override // com.urbandroid.sleep.service.IFlashlightService
    public void turnOff() {
        Logger.logInfo("Flashlight: turn off");
        if (SleepPermissionCompat.INSTANCE.isPermissionGranted(this.context, "android.permission.CAMERA")) {
            CameraManager cameraManager = (CameraManager) this.context.getSystemService("camera");
            try {
                String[] cameraIdList = CameraManagerCompat.getCameraIdList(cameraManager);
                if (cameraIdList != null) {
                    Arrays.sort(cameraIdList);
                    for (String str : cameraIdList) {
                        this.lightOn = false;
                        try {
                            Logger.logInfo("Flashlight: Turn off " + str);
                            CameraManagerCompat.setTorchMode(cameraManager, str, false);
                            return;
                        } catch (Exception e) {
                            Logger.logSevere(e);
                        }
                    }
                }
            } catch (Exception e2) {
                Logger.logSevere(e2);
            }
        }
    }

    @Override // com.urbandroid.sleep.service.IFlashlightService
    public void turnOn() {
        Logger.logInfo("Flashlight: turn on");
        if (SleepPermissionCompat.INSTANCE.isPermissionGranted(this.context, "android.permission.CAMERA")) {
            CameraManager cameraManager = (CameraManager) this.context.getSystemService("camera");
            try {
                String[] cameraIdList = CameraManagerCompat.getCameraIdList(cameraManager);
                if (cameraIdList != null) {
                    Arrays.sort(cameraIdList);
                    for (String str : cameraIdList) {
                        Logger.logInfo("Flashlight: id " + str);
                        try {
                            Logger.logInfo("Flashlight: Turn on " + str);
                            CameraManagerCompat.setTorchMode(cameraManager, str, true);
                            return;
                        } catch (Exception e) {
                            Logger.logSevere(e);
                            this.lightOn = true;
                        }
                    }
                }
            } catch (Exception e2) {
                Logger.logSevere(e2);
            }
        }
    }
}
