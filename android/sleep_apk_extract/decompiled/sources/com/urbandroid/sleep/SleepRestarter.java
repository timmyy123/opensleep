package com.urbandroid.sleep;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordChangeListener;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class SleepRestarter implements SleepRecordChangeListener {
    private static int RESCHEDULE_AFTER = 6;
    private final Context context;
    private int dataAddedCounter = RESCHEDULE_AFTER;
    private SleepRecord monitoredRecord;
    private boolean restartingEnabled;

    public SleepRestarter(Context context, boolean z) {
        this.context = context;
        this.restartingEnabled = z;
    }

    private void scheduleGraphRecovery(SleepRecord sleepRecord) {
        if (this.restartingEnabled) {
            if (!SharedApplicationContext.getInstance().getLockManager().shouldBeInStandByMode()) {
                scheduleWakeupWithRestart(this.context, sleepRecord, 300L);
            } else {
                Logger.logInfo("Restarter: Do not schedule restarting for stand-by tracking.");
                unscheduleRestarting();
            }
        }
    }

    private void scheduleWakeupWithRestart(Context context, SleepRecord sleepRecord, long j) {
        long jCurrentTimeMillis = (j * 1000) + System.currentTimeMillis();
        if (sleepRecord.getLastestTo() != null && sleepRecord.getLastestTo().getTime() - 60000 < jCurrentTimeMillis) {
            Logger.logInfo("Restarter: Ignoring wake-up scheduling, record time is: " + sleepRecord.getLastestTo());
            unscheduleRestarting();
            return;
        }
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Parcel parcelObtain = Parcel.obtain();
        sleepRecord.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        Intent intent = new Intent("com.urbandroid.sleep.alarmclock.START_SLEEP_TRACK");
        intent.putExtra("SleepRecord", parcelObtain.marshall());
        PendingIntent explicitBroadcast = PendingIntentBuilder.get(context, 1, intent, 134217728).getExplicitBroadcast();
        Logger.logDebug("Restarter: Scheduling restarter in " + new Date(jCurrentTimeMillis));
        new Settings(context).setNextSleepTrackingRestartTimestamp(jCurrentTimeMillis);
        if (Environment.isMOrGreater()) {
            alarmManager.setAndAllowWhileIdle(0, jCurrentTimeMillis, explicitBroadcast);
        } else {
            alarmManager.set(0, jCurrentTimeMillis, explicitBroadcast);
        }
        Logger.logDebug("Restarter: Broadcasting schedule restart");
        Intent intent2 = new Intent("com.urbandroid.sleep.SCHEDULE_RESTART");
        intent2.putExtra("SleepRecord", parcelObtain.marshall());
        if (Environment.isHoneycombOrGreater()) {
            intent2.addFlags(32);
        }
        ContextExtKt.sendExplicitBroadcast(context, intent2, "com.urbandroid.sleep.full.key");
    }

    private void unscheduleRestarting() {
        Alarms.removeSleepTrackStartIntent(this.context);
        new Settings(this.context).resetNextSleepTrackingRestartTimestamp();
        Intent intent = new Intent("com.urbandroid.sleep.UNSCHEDULE_RESTART");
        if (Environment.isHoneycombOrGreater()) {
            intent.addFlags(32);
        }
        ContextExtKt.sendExplicitBroadcast(this.context, intent, "com.urbandroid.sleep.full.key");
    }

    public void disableRestarting() {
        Logger.logDebug("Restarter: Disabling restarting. Record: " + this.monitoredRecord);
        SleepRecord sleepRecord = this.monitoredRecord;
        if (sleepRecord != null) {
            sleepRecord.removeListener(this);
            this.monitoredRecord = null;
        }
        this.restartingEnabled = false;
        unscheduleRestarting();
    }

    public void enableRestarting(SleepRecord sleepRecord) {
        Logger.logDebug("Restarter: Enabling restarting. Record: " + sleepRecord);
        if (sleepRecord != null && sleepRecord.isFinished()) {
            Logger.logDebug("Restarter: Will NOT schedule restarting, sleep tracking is already.");
            this.restartingEnabled = false;
            return;
        }
        SleepRecord sleepRecord2 = this.monitoredRecord;
        if (sleepRecord2 != null) {
            sleepRecord2.removeListener(this);
        }
        this.restartingEnabled = true;
        this.monitoredRecord = sleepRecord;
        if (sleepRecord != null) {
            sleepRecord.addListener(this);
        }
    }

    @Override // com.urbandroid.sleep.domain.SleepRecordChangeListener
    public void onDataAdded(SleepRecord sleepRecord) {
        int i = this.dataAddedCounter;
        if (i < RESCHEDULE_AFTER) {
            this.dataAddedCounter = i + 1;
        } else {
            scheduleGraphRecovery(sleepRecord);
            this.dataAddedCounter = 0;
        }
    }
}
