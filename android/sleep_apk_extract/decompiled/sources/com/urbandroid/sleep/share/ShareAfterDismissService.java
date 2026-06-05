package com.urbandroid.sleep.share;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepLockManager;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.graph.SleepGraphImageGenerator;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ShareAfterDismissService extends WaitForConnectivityService {
    public static String KEY_COMMENT = "sharing_comment";
    public static String KEY_IMG = "sharing_img";

    public static void share(Context context, SleepRecord sleepRecord, boolean z) {
        Logger.logInfo("Starting sharing service " + SharedApplicationContext.getInstance().getShareService().isConnected(context) + " " + sleepRecord);
        if ((z || SharedApplicationContext.getSettings().isAutoSharingEnabled()) && SharedApplicationContext.getInstance().getShareService().isConnected(context) && !TrialFilter.getInstance().isHideSleepAnalysis(sleepRecord)) {
            Intent intent = new Intent(context, (Class<?>) ShareAfterDismissService.class);
            intent.putExtra(KEY_IMG, SleepGraphImageGenerator.generateSleepGraph(context, sleepRecord, SharedApplicationContext.getSettings().isPublicComment()));
            intent.putExtra(KEY_COMMENT, (Serializable) sleepRecord);
            ContextExtKt.startForegroundServiceWithLog(context, intent);
        }
    }

    public static void shareExplicit(Context context, SleepRecord sleepRecord) {
        share(context, sleepRecord, true);
    }

    @Override // com.urbandroid.sleep.share.WaitForConnectivityService
    public int getNotificationIcon() {
        return Environment.isIcsOrGreater() ? R.drawable.ic_cloud_upload : R.drawable.notification_icon_compat;
    }

    @Override // com.urbandroid.sleep.share.WaitForConnectivityService
    public String getNotificationProgressMessage() {
        return getResources().getString(R.string.share_service_notification);
    }

    @Override // com.urbandroid.sleep.share.WaitForConnectivityService
    public String getNotificationTitleMessage() {
        return getString(R.string.app_name);
    }

    @Override // com.urbandroid.sleep.share.WaitForConnectivityService
    public String getNotificationWaitingMessage() {
        return getResources().getString(R.string.share_service_notification);
    }

    @Override // com.urbandroid.sleep.share.WaitForConnectivityService
    public void performWork(Intent intent) {
        if (intent == null) {
            Logger.logSevere("Intent is null");
            stopSelf();
            return;
        }
        final PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, SleepLockManager.getWakeLockTag(getApplicationContext(), "Auto-sharing"));
        int i = Environment.isIcsOrGreater() ? 180000 : 45000;
        zza$$ExternalSyntheticOutline0.m(i, "Sharing - acquire wake lock ");
        wakeLockNewWakeLock.acquire(i);
        SharedApplicationContext.getInstance().getShareService().publishImageAndCommentIt(this, intent.getByteArrayExtra(KEY_IMG), intent.getSerializableExtra(KEY_COMMENT), new NotificationHandler(this) { // from class: com.urbandroid.sleep.share.ShareAfterDismissService.1
            @Override // com.urbandroid.sleep.share.IHandler
            public void onFinished() {
                try {
                    if (Environment.isIcsOrGreater() && wakeLockNewWakeLock.isHeld()) {
                        Logger.logInfo("Sharing wake lock release");
                        wakeLockNewWakeLock.release();
                    }
                } catch (Throwable th) {
                    Logger.logSevere("Cannot release wake lock", th);
                }
                ShareAfterDismissService.this.stopSelf();
            }
        });
    }

    public static void share(Context context, SleepRecord sleepRecord) {
        share(context, sleepRecord, false);
    }
}
