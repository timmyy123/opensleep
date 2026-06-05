package com.urbandroid.sleep;

import android.app.Application;
import android.os.Build;
import android.util.Log;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.util.ThemeUtil;

/* JADX INFO: loaded from: classes4.dex */
public class SleepApplication extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        if (!getApplicationContext().getFilesDir().canRead()) {
            Log.i("SleepAsAndroidDB", "DB: Not initializing application, as we are in direct boot ");
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationsKt.createChannels(this);
            }
        } catch (Exception unused) {
            Log.i("SleepAsAndroidDB", "Cannot create notification channels");
        }
        try {
            if (!Logger.isInitialized()) {
                Logger.setFiltersEnabled(true);
                Logger.initialize(getApplicationContext(), "SleepAsAndroid", 1, 1, new Logger.LogConfig[0]);
            }
            TrialFilter.getInstance().initialize(getApplicationContext());
            if (TrialFilter.getInstance().isTrial()) {
                Logger.logInfo("SleepApplication init MAIN");
            }
            Logger.logInfo("SleepApplication init");
            ThemeUtil.setTheme(this);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }
}
