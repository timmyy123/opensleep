package com.urbandroid.sleep;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;
import com.urbandroid.sleep.service.SharedApplicationContext;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class CaptchaAntiCheatingAccessibilityService extends AccessibilityService {
    private static CaptchaAntiCheatingAccessibilityService instance;
    private boolean hasGlobalHomeAction = true;

    public static CaptchaAntiCheatingAccessibilityService getInstance() {
        return instance;
    }

    private void goHome() {
        if (this.hasGlobalHomeAction) {
            performGlobalAction(2);
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        startActivity(intent);
    }

    public static boolean isAccessibilityEnabled(Context context) {
        zza$$ExternalSyntheticOutline0.m(new StringBuilder("Accessibility: enabled "), instance != null);
        return instance != null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent == null || !AlarmKlaxon.isRunning() || (accessibilityEvent.getEventType() & 32) == 0 || accessibilityEvent.getText() == null || accessibilityEvent.getText().isEmpty() || accessibilityEvent.getPackageName() == null) {
            return;
        }
        Logger.logInfo("Accessibility: " + accessibilityEvent.getEventType() + " text '" + accessibilityEvent.getText() + "' " + ((Object) accessibilityEvent.getPackageName()) + " " + accessibilityEvent.toString() + " windows " + getWindows().size() + " FS " + accessibilityEvent.isFullScreen());
        if ("com.android.systemui".equals(accessibilityEvent.getPackageName().toString()) && SharedApplicationContext.getSettings().isCaptchaNoEscape()) {
            Logger.logInfo("Accessibility: SYSTEM UI - hiding");
            goHome();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        instance = this;
        Logger.logInfo("SleepAsAndroid: Accessibility onCreate() ");
        if (Build.VERSION.SDK_INT >= 33) {
            for (AccessibilityNodeInfo.AccessibilityAction accessibilityAction : getSystemActions()) {
                if (accessibilityAction.getId() == 2) {
                    this.hasGlobalHomeAction = true;
                }
                Logger.logInfo("System action " + ((Object) accessibilityAction.getLabel()));
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger.logInfo("SleepAsAndroid: Accessibility onDestroy() ");
        instance = null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        Logger.logInfo("Accessibility: onInterrupt");
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        super.onServiceConnected();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
