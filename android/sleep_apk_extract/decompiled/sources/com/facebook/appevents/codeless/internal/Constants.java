package com.facebook.appevents.codeless.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/appevents/codeless/internal/Constants;", "", "()V", "APP_INDEXING", "", "APP_INDEXING_ENABLED", "APP_INDEXING_SCHEDULE_INTERVAL_MS", "", "BUTTON_SAMPLING", "DEVICE_SESSION_ID", "EVENT_MAPPING_PATH_TYPE_KEY", "EXTINFO", "IS_CODELESS_EVENT_KEY", "MAX_TREE_DEPTH", "PATH_TYPE_ABSOLUTE", "PATH_TYPE_RELATIVE", "PLATFORM", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Constants {
    public static final String APP_INDEXING = "app_indexing";
    public static final String APP_INDEXING_ENABLED = "is_app_indexing_enabled";
    public static final int APP_INDEXING_SCHEDULE_INTERVAL_MS = 1000;
    public static final String BUTTON_SAMPLING = "button_sampling";
    public static final String DEVICE_SESSION_ID = "device_session_id";
    public static final String EVENT_MAPPING_PATH_TYPE_KEY = "path_type";
    public static final String EXTINFO = "extinfo";
    public static final Constants INSTANCE = new Constants();
    public static final String IS_CODELESS_EVENT_KEY = "_is_fb_codeless";
    public static final int MAX_TREE_DEPTH = 25;
    public static final String PATH_TYPE_ABSOLUTE = "absolute";
    public static final String PATH_TYPE_RELATIVE = "relative";
    public static final String PLATFORM = "android";

    private Constants() {
    }
}
