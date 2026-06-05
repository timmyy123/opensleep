package com.urbandroid.common.error;

import com.urbandroid.common.version.ApplicationVersionInfo;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorApplicationInfo {
    private final String applicationName;
    private final ApplicationVersionInfo versionInfo;

    public ErrorApplicationInfo(String str, ApplicationVersionInfo applicationVersionInfo) {
        this.applicationName = str;
        this.versionInfo = applicationVersionInfo;
    }

    public String getApplicationName() {
        return this.applicationName;
    }

    public int getVersionCode() {
        return this.versionInfo.getVersionCode();
    }

    public String getVersionName() {
        return this.versionInfo.getVersionName();
    }
}
