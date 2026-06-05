package com.urbandroid.sleep.persistence;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.FixedJobIntentService;
import androidx.core.app.JobIntentService;
import androidx.core.content.FileProvider;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.settings.MiscSettingsActivity;
import com.urbandroid.sleep.service.NotificationService;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.SleepPermissionCompat;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class SilentExportService extends FixedJobIntentService {
    public static Uri getFileProviderUri(Context context) {
        File file = new File(Export.getExportZipFilePath(context));
        if (file.exists()) {
            return FileProvider.getUriForFile(context, "com.urbandroid.sleep.fileprovider", file);
        }
        return null;
    }

    public static void grantPermissionToBackup(Context context) {
        Uri fileProviderUri = getFileProviderUri(context);
        if (fileProviderUri != null) {
            context.grantUriPermission("com.urbandroid.sleep.addon.port", fileProviderUri, 1);
        }
    }

    private void performBackup() {
        Logger.logInfo("SilentExportService: performBackup()");
        try {
            new Export().exportData(this, null, true);
        } catch (Exception e) {
            if (Build.VERSION.SDK_INT < 33) {
                SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
                if (!sleepPermissionCompat.isPermissionGranted(this, "android.permission.WRITE_EXTERNAL_STORAGE") || !sleepPermissionCompat.isPermissionGranted(this, "android.permission.READ_EXTERNAL_STORAGE")) {
                    Logger.logInfo("Permissions: no STORAGE permission");
                    new NotificationService(this).notification(R.string.backup, getResources().getString(R.string.export_failed) + " " + getResources().getString(R.string.no_permission), 1, PendingIntentBuilder.get(this, 1, new Intent(this, (Class<?>) MiscSettingsActivity.class), 0).getActivity());
                }
            }
            Logger.logSevere(e);
        }
        Logger.logInfo("SilentExportService: SYNC performBackup() done");
    }

    public static void sendSyncIntent(Context context) {
        grantPermissionToBackup(context);
        Intent intent = new Intent("com.urbandroid.sleep.REQUEST_SYNC_EXTERNAL");
        intent.putExtra("android.intent.extra.STREAM", getFileProviderUri(context));
        intent.putExtra("TS", TrialFilter.getCloudTimestamp(context));
        intent.addFlags(1);
        ContextExtKt.sendExplicitBroadcast(context, intent, "com.urbandroid.sleep.addon.port");
    }

    public static void start(Context context) {
        if (new Settings(context).isBackupLocal() || TrialFilter.getInstance().isAddonImport()) {
            Logger.logInfo("SilentExportService: SYNC enqueue job");
            JobIntentService.enqueueWork(context, (Class<?>) SilentExportService.class, 1011, new Intent());
        } else {
            Logger.logInfo("SilentExportService: SYNC Sending broadcast to backup service");
            sendSyncIntent(context);
        }
    }

    @Override // androidx.core.app.JobIntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(Intent intent) {
        GlobalInitializator.initializeIfRequired(this);
        Logger.logInfo("SilentExportService: SYNC Starting backup service");
        performBackup();
        Logger.logInfo("SYNC Sending broadcast to backup service");
        sendSyncIntent(getApplicationContext());
    }
}
