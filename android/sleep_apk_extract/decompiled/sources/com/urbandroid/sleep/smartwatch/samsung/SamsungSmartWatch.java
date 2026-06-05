package com.urbandroid.sleep.smartwatch.samsung;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.sensor.extra.HrDataProducer;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartwatch.IConnectivityCallback;
import com.urbandroid.sleep.smartwatch.IntentBasedConnectivityChecker;
import com.urbandroid.sleep.smartwatch.SmartWatch;
import com.urbandroid.sleep.smartwatch.SmartWatchListener;
import java.util.Calendar;

/* JADX INFO: loaded from: classes5.dex */
public class SamsungSmartWatch implements SmartWatch {
    private static long startDisabledTill;
    private final SamsungAccelManager accelManager;
    private final Context context;
    private final boolean doHrMonitoring;
    private int currentBatchSize = 1;
    private final Runnable restartApplication = new Runnable() { // from class: com.urbandroid.sleep.smartwatch.samsung.SamsungSmartWatch.1
        @Override // java.lang.Runnable
        public void run() {
            SamsungSmartWatch.this.restartTracking();
            SamsungSmartWatch samsungSmartWatch = SamsungSmartWatch.this;
            samsungSmartWatch.setBatchSize(samsungSmartWatch.currentBatchSize);
        }
    };
    private final Handler handler = new Handler();

    public SamsungSmartWatch(Context context) {
        this.context = context;
        this.accelManager = new SamsungAccelManager(context);
        this.doHrMonitoring = new Settings(context).isHrWear();
    }

    public static boolean isStartingDisabled() {
        long j = startDisabledTill;
        return j != 0 && j > System.currentTimeMillis();
    }

    public void asyncConnectionCheck(IConnectivityCallback iConnectivityCallback, long j) {
        new IntentBasedConnectivityChecker(this.context, iConnectivityCallback, this, "com.urbandroid.sleep.samsung.CHECK_CONNECTED", "com.urbandroid.sleep.samsung.CONFIRM_CONNECTED", j, 5000L);
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public String getPlatform() {
        return "SAMSUNG";
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void hint(int i) {
        Intent intent = new Intent("com.urbandroid.sleep.samsung.HINT");
        intent.putExtra("LONG_ARG", i);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, "com.urbandroid.sleep.addon.samsung");
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

    public void pushHRData(float f) {
        Logger.logInfo("Samsung got HR data: " + f);
        HrDataProducer.produce(this.context, f, System.currentTimeMillis());
    }

    public void rescheduleRestart() {
        this.handler.removeCallbacks(this.restartApplication);
        this.handler.postDelayed(this.restartApplication, 240000L);
    }

    public void restartTracking() {
        Logger.logInfo("Initiating samsung restart.");
        Intent intent = new Intent("com.urbandroid.sleep.samsung.START_WATCH_APP");
        if (this.doHrMonitoring) {
            intent.putExtra("DO_HR_MONITORING", true);
        }
        ContextExtKt.sendExplicitBroadcast(this.context, intent, "com.urbandroid.sleep.addon.samsung");
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setBatchSize(int i) {
        this.currentBatchSize = i;
        Intent intent = new Intent("com.urbandroid.sleep.samsung.SET_BATCH_SIZE");
        intent.putExtra("LONG_ARG", i);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, "com.urbandroid.sleep.addon.samsung");
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void setSuspended(boolean z) {
        Intent intent = new Intent("com.urbandroid.sleep.samsung.SET_SUSPENDED");
        intent.putExtra("BOOL_ARG", z);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, "com.urbandroid.sleep.addon.samsung");
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startAlarm(int i) {
        Intent intent = new Intent("com.urbandroid.sleep.samsung.START_ALARM");
        intent.putExtra("INT_ARG", i);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, "com.urbandroid.sleep.addon.samsung");
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void startTracking(SmartWatchListener smartWatchListener) {
        Logger.logInfo("SamsungSmartWatch:startTracking. Hr monitoring: " + this.doHrMonitoring);
        Intent intent = new Intent("com.urbandroid.sleep.samsung.START_WATCH_APP");
        if (this.doHrMonitoring) {
            intent.putExtra("DO_HR_MONITORING", true);
        }
        ContextExtKt.sendExplicitBroadcast(this.context, intent, "com.urbandroid.sleep.addon.samsung");
        rescheduleRestart();
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopAlarm() {
        ContextExtKt.sendExplicitBroadcast(this.context, new Intent("com.urbandroid.sleep.samsung.STOP_ALARM"), "com.urbandroid.sleep.addon.samsung");
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void stopTracking() {
        this.handler.removeCallbacks(this.restartApplication);
        ContextExtKt.sendExplicitBroadcast(this.context, new Intent("com.urbandroid.sleep.samsung.STOP_WATCH_APP"), "com.urbandroid.sleep.addon.samsung");
        startDisabledTill = System.currentTimeMillis() + 5000;
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updateAlarm(long j) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(10);
        if (new Settings(this.context).is24HourFormat()) {
            i = calendar.get(11);
        }
        int i2 = calendar.get(12);
        Intent intent = new Intent("com.urbandroid.sleep.samsung.UPDATE_ALARM");
        intent.putExtra("HOUR", i);
        intent.putExtra("MINUTE", i2);
        intent.putExtra("TIMESTAMP", j);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, "com.urbandroid.sleep.addon.samsung");
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public void updatePause(long j) {
        Intent intent = new Intent("com.urbandroid.sleep.samsung.SET_PAUSE");
        intent.putExtra("LONG_ARG", j);
        ContextExtKt.sendExplicitBroadcast(this.context, intent, "com.urbandroid.sleep.addon.samsung");
    }

    @Override // com.urbandroid.sleep.smartwatch.SmartWatch
    public SamsungAccelManager getAccelManager() {
        return this.accelManager;
    }
}
