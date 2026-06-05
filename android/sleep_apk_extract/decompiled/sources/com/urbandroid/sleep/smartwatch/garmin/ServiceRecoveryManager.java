package com.urbandroid.sleep.smartwatch.garmin;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.AlarmManagerCompat;
import com.urbandroid.common.logging.Logger;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class ServiceRecoveryManager {
    private Service service;
    private static final ServiceRecoveryManager ourInstance = new ServiceRecoveryManager();
    private static final long TIME_TO_RECOVER = 300000;

    private ServiceRecoveryManager() {
    }

    private void cancelRecovery(Service service) {
        AlarmManager alarmManager = (AlarmManager) service.getSystemService("alarm");
        Logger.logDebug("ServiceRecoveryManager: Canceling restart intent");
        alarmManager.cancel(getRecoveryIntent(service));
    }

    public static ServiceRecoveryManager getInstance() {
        return ourInstance;
    }

    private PendingIntent getRecoveryIntent(Service service) {
        Intent intent = new Intent(service, (Class<?>) GarminProviderService.class);
        intent.setAction("com.urbandroid.sleep.smartwatch.garmin.RESTART_SELF");
        intent.setPackage(service.getPackageName());
        return Build.VERSION.SDK_INT >= 26 ? PendingIntent.getForegroundService(service.getApplicationContext(), 0, intent, Notifications.getPendingIntentFlags()) : PendingIntent.getService(service.getApplicationContext(), 0, intent, Notifications.getPendingIntentFlags());
    }

    private void stopSelfAndDontScheduleRecovery(Service service, String str) {
        Logger.logDebug("ServiceRecoveryManager: stopSelfAndDontScheduleRecovery, reason: " + str);
        QueueToWatch.getInstance().emptyQueue();
        cancelRecovery(service);
        service.stopSelf();
    }

    private void stopSelfAndScheduleRecovery(Service service, String str) {
        Logger.logDebug("ServiceRecoveryManager: stopSelfAndScheduleRecovery, reason: " + str);
        service.stopSelf();
        PendingIntent recoveryIntent = getRecoveryIntent(service);
        AlarmManager alarmManager = (AlarmManager) service.getSystemService("alarm");
        alarmManager.cancel(recoveryIntent);
        long jCurrentTimeMillis = System.currentTimeMillis() + TIME_TO_RECOVER;
        AlarmManagerCompat.setExactAndAllowWhileIdle(alarmManager, 0, jCurrentTimeMillis, recoveryIntent);
        Logger.logInfo("ServiceRecoveryManager: recovery alarm scheduled for " + new Date(jCurrentTimeMillis));
    }

    public void init(Service service) {
        this.service = service;
    }

    public void stopSelfAndDontScheduleRecovery(String str) {
        stopSelfAndDontScheduleRecovery(this.service, str);
    }

    public void stopSelfAndScheduleRecovery(String str) {
        stopSelfAndScheduleRecovery(this.service, str);
    }
}
