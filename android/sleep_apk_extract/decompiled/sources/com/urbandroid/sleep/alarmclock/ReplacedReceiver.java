package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.SleepRecordTemporaryPersister;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.Experiments;

/* JADX INFO: loaded from: classes4.dex */
public class ReplacedReceiver extends LoggingReceiver {
    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Settings settings;
        int currentAlarm;
        super.onReceive(context, intent);
        String action = intent.getAction();
        if (action != null) {
            if ("android.intent.action.PACKAGE_REPLACED".equals(action) || "android.intent.action.MY_PACKAGE_REPLACED".equals(action)) {
                if (!"android.intent.action.MY_PACKAGE_REPLACED".equals(action) || Experiments.getInstance().isBackgroundLimitationApi26()) {
                    if ("android.intent.action.PACKAGE_REPLACED".equals(action) && (intent.getData() == null || intent.getData().getSchemeSpecificPart() == null || !intent.getData().getSchemeSpecificPart().equals(context.getPackageName()))) {
                        return;
                    }
                    new Settings(context).setSleepTimeSuggestionScheduledNotificationTime(-1L);
                    GlobalInitializator.initializeIfRequired(context);
                    Logger.logInfo("Package replaced");
                    Alarms.setNextAlert(context);
                    SleepRecord lastSleepRecord = SharedApplicationContext.getInstance().getSleepRecordRepository().getLastSleepRecord();
                    SleepRecord lastTemporaryRecord = SleepRecordTemporaryPersister.getLastTemporaryRecord();
                    if (lastTemporaryRecord != null && lastSleepRecord != null && !lastSleepRecord.isFinished() && lastSleepRecord.getFrom() != null && lastTemporaryRecord.getFrom() != null && lastSleepRecord.getFrom().getTime() == lastTemporaryRecord.getFrom().getTime() && System.currentTimeMillis() - lastTemporaryRecord.getFrom().getTime() < 43200000) {
                        Logger.logInfo("Recovering record on replace: " + lastTemporaryRecord.getFrom());
                        Parcel parcelObtain = Parcel.obtain();
                        lastTemporaryRecord.writeToParcel(parcelObtain, 0);
                        parcelObtain.setDataPosition(0);
                        Intent intent2 = new Intent();
                        intent2.putExtra("SleepRecord", parcelObtain.marshall());
                        StartTrackReceiver.restartFromIntent(context, intent2);
                    }
                    if (!Experiments.getInstance().isReplaceRestarting() || (currentAlarm = (settings = new Settings(context)).getCurrentAlarm()) <= -1) {
                        return;
                    }
                    long currentAlarmTime = settings.getCurrentAlarmTime();
                    boolean z = currentAlarmTime == 0 || System.currentTimeMillis() - currentAlarmTime > ((long) (settings.getAlarmTimeout() * 1000)) || System.currentTimeMillis() < currentAlarmTime;
                    if (z) {
                        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("Replace: Alarm on reboot too old or just weird.. Alarm time: ", " Now: ", currentAlarmTime);
                        sbM.append(System.currentTimeMillis());
                        Logger.logInfo(sbM.toString());
                        settings.setCurrentAlarm(-1, 0L);
                    }
                    Alarm alarm = Alarms.getAlarm(context.getContentResolver(), currentAlarm);
                    if (alarm == null || z) {
                        return;
                    }
                    Logger.logInfo("Firing alarm on package replaced: " + Alarm.toDebugString(alarm));
                    Intent intent3 = new Intent("com.urbandroid.sleep.alarmclock.ALARM_ALERT");
                    intent3.putExtra("intent.extra.alarm_raw", alarm.serializeToArray());
                    ContextExtKt.sendExplicitBroadcast(context, intent3);
                }
            }
        }
    }
}
