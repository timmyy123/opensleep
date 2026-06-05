package com.google.android.play.core.install.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@Retention(RetentionPolicy.CLASS)
public @interface InstallStatus {
    public static final int CANCELED = 6;
    public static final int DOWNLOADED = 11;
    public static final int DOWNLOADING = 2;
    public static final int FAILED = 5;
    public static final int INSTALLED = 4;
    public static final int INSTALLING = 3;
    public static final int PENDING = 1;

    @Deprecated
    public static final int REQUIRES_UI_INTENT = 10;
    public static final int UNKNOWN = 0;
}
