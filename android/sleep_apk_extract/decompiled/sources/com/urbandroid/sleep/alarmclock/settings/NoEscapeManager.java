package com.urbandroid.sleep.alarmclock.settings;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.CaptchaAntiCheatingAccessibilityService;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.SleepDeviceAdminReceiver;
import java.io.Serializable;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public class NoEscapeManager implements Serializable {
    private Activity activity;

    public NoEscapeManager(Activity activity) {
        this.activity = activity;
    }

    public boolean isAccessibilityEnabled() {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return CaptchaAntiCheatingAccessibilityService.isAccessibilityEnabled(this.activity);
    }

    public boolean isDeviceAdminEnabled() {
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) this.activity.getSystemService("device_policy");
        return devicePolicyManager != null && devicePolicyManager.isAdminActive(new ComponentName(this.activity, (Class<?>) SleepDeviceAdminReceiver.class));
    }

    public boolean isNoEscapeFullyConfigured() {
        Logger.logInfo("CAPCTHA: isNoEscapeFullyConfigured " + isAccessibilityEnabled() + " " + isDeviceAdminEnabled() + " " + isOverlayEnabled());
        return isAccessibilityEnabled() && isDeviceAdminEnabled() && isOverlayEnabled();
    }

    public boolean isOverlayEnabled() {
        return Settings.canDrawOverlays(this.activity);
    }

    public void showAccessibilityDialog(int i) {
        Logger.logInfo("DDC: showAccessibilityDialog()");
        Intent intent = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        this.activity.startActivityForResult(intent, i);
    }

    public void showDeviceAdminDialog(int i) {
        Logger.logInfo("DDC: showDeviceAdminDialog()");
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) this.activity.getSystemService("device_policy");
        ComponentName componentName = new ComponentName(this.activity, (Class<?>) SleepDeviceAdminReceiver.class);
        if (devicePolicyManager == null || devicePolicyManager.isAdminActive(componentName)) {
            return;
        }
        Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
        intent.putExtra("android.app.extra.DEVICE_ADMIN", componentName);
        intent.putExtra("android.app.extra.ADD_EXPLANATION", this.activity.getString(R.string.captcha_no_escape_justification));
        this.activity.startActivityForResult(intent, i);
    }

    public void showOverlayDialog(int i) {
        Logger.logInfo("DDC: showOverlayDialog()");
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + this.activity.getPackageName()));
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        this.activity.startActivity(intent);
    }
}
