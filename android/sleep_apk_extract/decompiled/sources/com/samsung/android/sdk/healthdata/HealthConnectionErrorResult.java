package com.samsung.android.sdk.healthdata;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class HealthConnectionErrorResult {
    private PackageManager a;
    private final int b;
    private final boolean c;

    public HealthConnectionErrorResult(int i, boolean z) {
        this.b = i;
        this.c = z;
    }

    private boolean a() {
        PackageManager packageManager = this.a;
        if (packageManager == null) {
            return false;
        }
        return packageManager.getPackageInfo("com.sec.android.app.samsungapps", 128).applicationInfo.enabled;
    }

    public final int getErrorCode() {
        return this.b;
    }

    public final boolean hasResolution() {
        int i = this.b;
        if (i == 6 || i == 9) {
            return true;
        }
        if (i != 2 && i != 4) {
            return false;
        }
        if (a()) {
            return this.c;
        }
        return true;
    }

    public final void resolve(Activity activity) {
        if (activity == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("The input argument is null");
            return;
        }
        if (activity.getBaseContext() == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("The input activity is wrong");
            return;
        }
        int i = this.b;
        if (i == 2 || i == 4) {
            if (hasResolution()) {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(a() ? "samsungapps://ProductDetail/com.sec.android.app.shealth" : "market://details?id=com.sec.android.app.shealth")));
            }
        } else if (i == 6) {
            activity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + HealthDataStore.getPlatformPackageName())));
        } else {
            if (i != 9) {
                return;
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(HealthDataStore.getPlatformPackageName());
            intent.addCategory("android.intent.category.LAUNCHER");
            activity.startActivity(intent);
        }
    }

    public final void setPackageManager(PackageManager packageManager) {
        this.a = packageManager;
    }
}
