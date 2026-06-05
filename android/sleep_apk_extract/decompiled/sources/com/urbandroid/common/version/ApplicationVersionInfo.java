package com.urbandroid.common.version;

/* JADX INFO: loaded from: classes4.dex */
public class ApplicationVersionInfo {
    private final int versionCode;
    private final String versionName;

    public ApplicationVersionInfo(int i, String str) {
        this.versionCode = i;
        this.versionName = str;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public String toString() {
        return "Version code: " + this.versionCode + " Name: " + this.versionName;
    }
}
