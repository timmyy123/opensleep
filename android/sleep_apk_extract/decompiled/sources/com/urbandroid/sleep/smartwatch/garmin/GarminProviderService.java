package com.urbandroid.sleep.smartwatch.garmin;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.AppEventQueue$$ExternalSyntheticLambda1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartwatch.Wearable;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class GarminProviderService extends Service {
    public static Boolean RUNNING = Boolean.FALSE;
    private Handler handler;
    private HttpServer server;
    private QueueToWatch queueToWatch = QueueToWatch.getInstance();
    private CIQManager ciqManager = CIQManager.getInstance();
    private boolean serverRunning = false;
    private Runnable connectionTimeout = new AppEventQueue$$ExternalSyntheticLambda1(16);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0() {
        Logger.logInfo("Garmin: Connection timeout");
        ServiceRecoveryManager.getInstance().stopSelfAndDontScheduleRecovery("CONNECTIVITY_CHECK timeout");
    }

    private void startForeground() {
        Intent intent = new Intent(this, (Class<?>) GarminProviderService.class);
        intent.setAction("com.urbandroid.sleep.smartwatch.garmin.STOP_SELF");
        PendingIntent service = PendingIntent.getService(this, 150, intent, Notifications.getPendingIntentFlags());
        if (Build.VERSION.SDK_INT >= 26) {
            service = PendingIntent.getForegroundService(this, 150, intent, Notifications.getPendingIntentFlags());
        }
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(this, "sleepTrackingChannel").setContentIntent(service).setColor(getResources().getColor(R.color.tint_dark)).addAction(R.drawable.ic_action_stop, getResources().getString(R.string.stop), service).setContentText(getString(R.string.running));
        contentText.setSmallIcon(R.drawable.ic_action_watch);
        startForeground(1349, contentText.build());
    }

    private void startHttpServer() {
        if (this.serverRunning) {
            return;
        }
        this.serverRunning = true;
        HttpServer httpServer = new HttpServer(1765, this);
        this.server = httpServer;
        try {
            httpServer.start();
        } catch (IOException e) {
            Logger.logSevere("Garmin: : IOException when starting HttpServer", e);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (!new Settings(this).isWearableSelected(Wearable.ADDON_URBANDROID_GARMIN)) {
            stopSelf();
            return;
        }
        Logger.logDebug("Garmin: onCreate");
        GlobalInitializator.initializeIfRequired(this);
        ServiceRecoveryManager.getInstance().init(this);
        Utils.showUnrestrictedBatteryNeededNotificationIfNeeded(this);
        this.ciqManager.resetState();
        startHttpServer();
        this.handler = new Handler();
    }

    @Override // android.app.Service
    public void onDestroy() {
        QueueToWatch queueToWatch = this.queueToWatch;
        if (queueToWatch != null) {
            queueToWatch.logQueue("onDestroy");
            this.queueToWatch.cleanup();
        }
        HttpServer httpServer = this.server;
        if (httpServer != null) {
            httpServer.stop();
            this.serverRunning = false;
        }
        CIQManager cIQManager = this.ciqManager;
        if (cIQManager != null) {
            cIQManager.shutdown(this);
        }
        RUNNING = Boolean.FALSE;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        StringBuilder sb = new StringBuilder("Garmin: onStartCommand, intent ");
        sb.append((intent == null || intent.getAction() == null) ? "null" : intent.getAction());
        Logger.logDebug(sb.toString());
        startForeground();
        RUNNING = Boolean.TRUE;
        if (!new Settings(this).isWearableSelected(Wearable.ADDON_URBANDROID_GARMIN)) {
            Logger.logInfo("Garmin: STOP Garmin not configured ");
            stopSelf();
            return 2;
        }
        if (intent != null) {
            if ("com.urbandroid.sleep.smartwatch.garmin.STOP_SELF".equals(intent.getAction())) {
                Logger.logInfo("Garmin: ACTION_STOP_SELF Garmin not configured ");
                ServiceRecoveryManager.getInstance().stopSelfAndDontScheduleRecovery("STOP_SELF intent received");
                return 2;
            }
            boolean zEquals = "com.urbandroid.sleep.watch.CHECK_CONNECTED".equals(intent.getAction());
            Handler handler = this.handler;
            if (zEquals) {
                handler.removeCallbacks(this.connectionTimeout);
                this.handler.postDelayed(this.connectionTimeout, 120000L);
            } else {
                handler.removeCallbacks(this.connectionTimeout);
            }
        }
        try {
            this.ciqManager.init(this, intent);
            return 1;
        } catch (Exception e) {
            Logger.logSevere("Garmin: ", e);
            return 1;
        }
    }
}
