package com.urbandroid.sleep.smartwatch.generic;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartwatch.BaseWatchAccelManager;
import com.urbandroid.sleep.smartwatch.IConnectivityCallback;
import com.urbandroid.sleep.smartwatch.IntentBasedConnectivityChecker;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchListener;
import java.util.Calendar;

/* JADX INFO: loaded from: classes5.dex */
public class GenericWatch implements SmartWatch {
    private static long startDisabledTill;
    private final BaseWatchAccelManager accelManager;
    private final Context context;
    private final boolean doHrMonitoring;
    private final boolean doOximeterMonitoring;
    private int currentBatchSize = 12;
    private boolean trackingStarted = false;
    private final Runnable restartApplication = new Runnable() { // from class: com.urbandroid.sleep.smartwatch.generic.GenericWatch.1
        @Override // java.lang.Runnable
        public void run() {
            GenericWatch.this.restartTracking();
            GenericWatch genericWatch = GenericWatch.this;
            genericWatch.setBatchSize(genericWatch.currentBatchSize);
        }
    };
    private final Handler handler = new Handler();

    public GenericWatch(Context context) {
        this.context = context;
        this.accelManager = new BaseWatchAccelManager(context);
        this.doHrMonitoring = new Settings(context).isHrWear();
        this.doOximeterMonitoring = new Settings(context).isOximeterWatch();
    }

    public static boolean isStartingDisabled() {
        long j = startDisabledTill;
        return j != 0 && j > System.currentTimeMillis();
    }

    public void asyncConnectionCheck(IConnectivityCallback iConnectivityCallback, long j) {
        new IntentBasedConnectivityChecker(this.context, iConnectivityCallback, this, "com.urbandroid.sleep.watch.CHECK_CONNECTED", "com.urbandroid.sleep.watch.CONFIRM_CONNECTED", j, 5000L);
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public String getPlatform() {
        String str;
        int i;
        if (TrialFilter.getInstance().isGear() && (TrialFilter.getInstance().isAddonSamsungNew() || TrialFilter.getInstance().isAddonSamsung())) {
            str = "SAMSUNG";
            i = 1;
        } else {
            str = "UNKNOWN";
            i = 0;
        }
        if (TrialFilter.getInstance().isAddonSony()) {
            i++;
            str = "SONY";
        }
        if (TrialFilter.getInstance().isMiBand()) {
            i++;
            str = "MIBAND";
        }
        if (TrialFilter.getInstance().isAddonGarmin()) {
            i++;
            str = "GARMIN";
        }
        return i > 1 ? "MULTIPLE" : str;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void hint(int i) {
        Logger.logInfo("GenericWatch: hint " + i);
        Intent intent = new Intent("com.urbandroid.sleep.watch.HINT");
        intent.putExtra("REPEAT", i);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, new Settings(this.context).getEligibleAddonPackages());
    }

    public boolean isTrackingStarted() {
        return this.trackingStarted;
    }

    public void onReceivedBatchSize(int i) {
        if (i != this.currentBatchSize) {
            StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i, "Received unexpected batch size (", ") -> restore to proper batch size (");
            sbM65m.append(this.currentBatchSize);
            sbM65m.append(").");
            Logger.logInfo(sbM65m.toString());
            setBatchSize(this.currentBatchSize);
        }
    }

    public void rescheduleRestart() {
        this.handler.removeCallbacks(this.restartApplication);
        this.handler.postDelayed(this.restartApplication, 240000L);
    }

    public void restartTracking() {
        Logger.logInfo("GenericWatch: restart tracking");
        Intent intent = new Intent("com.urbandroid.sleep.watch.START_TRACKING");
        if (this.doHrMonitoring) {
            intent.putExtra("DO_HR_MONITORING", true);
        }
        ContextExtKt.sendExplicitBroadcast(this.context, intent, new Settings(this.context).getEligibleAddonPackages());
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setBatchSize(int i) {
        zza$$ExternalSyntheticOutline0.m(i, "GenericWatch: batchSize ");
        this.currentBatchSize = i;
        Intent intent = new Intent("com.urbandroid.sleep.watch.SET_BATCH_SIZE");
        intent.putExtra("SIZE", i);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, new Settings(this.context).getEligibleAddonPackages());
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setSuspended(boolean z) {
        Logger.logInfo("GenericWatch: suspend " + z);
        Intent intent = new Intent("com.urbandroid.sleep.watch.SET_SUSPENDED");
        intent.putExtra("SUSPENDED", z);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, new Settings(this.context).getEligibleAddonPackages());
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startAlarm(int i) {
        Logger.logInfo("GenericWatch: start alarm ");
        Intent intent = new Intent("com.urbandroid.sleep.watch.START_ALARM");
        intent.addFlags(32);
        intent.putExtra("DELAY", i);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, new Settings(this.context).getEligibleAddonPackages());
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startTracking(SmartWatchListener smartWatchListener) {
        Logger.logInfo("GenericWatch: start tracking HR " + this.doHrMonitoring + " SPO2 " + this.doOximeterMonitoring);
        Intent intent = new Intent("com.urbandroid.sleep.watch.START_TRACKING");
        if (this.doHrMonitoring) {
            intent.putExtra("DO_HR_MONITORING", true);
        }
        if (this.doOximeterMonitoring) {
            intent.putExtra("DO_OXIMETER_MONITORING", true);
        }
        intent.addFlags(32);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, new Settings(this.context).getEligibleAddonPackages());
        rescheduleRestart();
        this.trackingStarted = true;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopAlarm() {
        Logger.logInfo("GenericWatch: stop alarm " + SleepService.isRunning());
        Intent intent = new Intent("com.urbandroid.sleep.watch.STOP_ALARM");
        intent.putExtra("tracking", SleepService.isRunning());
        ContextExtKt.sendExplicitBroadcast(this.context, intent, new Settings(this.context).getEligibleAddonPackages());
    }

    public void stopRestart() {
        this.handler.removeCallbacks(this.restartApplication);
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopTracking() {
        Logger.logInfo("GenericWatch: stop tracking ");
        this.handler.removeCallbacks(this.restartApplication);
        ContextExtKt.sendExplicitBroadcast(this.context, new Intent("com.urbandroid.sleep.watch.STOP_TRACKING"), new Settings(this.context).getEligibleAddonPackages());
        startDisabledTill = System.currentTimeMillis() + 5000;
        this.trackingStarted = false;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updateAlarm(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(10);
        if (i == 0) {
            i = 12;
        }
        if (new Settings(this.context).is24HourFormat()) {
            i = calendar.get(11);
        }
        int i2 = calendar.get(12);
        Intent intent = new Intent("com.urbandroid.sleep.watch.UPDATE_ALARM");
        intent.putExtra("HOUR", i);
        intent.putExtra("MINUTE", i2);
        intent.putExtra("TIMESTAMP", j);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, new Settings(this.context).getEligibleAddonPackages());
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updatePause(long j) {
        Intent intent = new Intent("com.urbandroid.sleep.watch.SET_PAUSE");
        intent.putExtra("TIMESTAMP", j);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, new Settings(this.context).getEligibleAddonPackages());
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public BaseWatchAccelManager getAccelManager() {
        return this.accelManager;
    }
}
