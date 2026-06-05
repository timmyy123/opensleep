package androidx.health.platform.client.impl.permission.foregroundstate;

import android.app.ActivityManager;

/* JADX INFO: loaded from: classes3.dex */
public final class ForegroundStateChecker {
    private ForegroundStateChecker() {
    }

    public static boolean isInForeground() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        int i = runningAppProcessInfo.importance;
        return i == 100 || i == 125 || i == 200;
    }
}
