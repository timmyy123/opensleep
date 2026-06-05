package com.urbandroid.common.version;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: loaded from: classes4.dex */
public class ApplicationVersionExtractor {
    public ApplicationVersionInfo getCurrentVersion(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = new PackageInfo();
            packageInfo.versionName = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            packageInfo.versionCode = 0;
        }
        return new ApplicationVersionInfo(packageInfo.versionCode, packageInfo.versionName);
    }

    public ApplicationVersionInfo getCurrentVersion(Context context) {
        return getCurrentVersion(context, context.getPackageName());
    }
}
