package com.urbandroid.sleep.alarmclock;

import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.LoggingReceiver;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmStatusReceiver extends LoggingReceiver {
    public static boolean alarmIsRinging = false;

    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        GlobalInitializator.initializeIfRequired(context);
        if ("com.urbandroid.sleep.alarmclock.ALARM_ALERT_START_INTERNAL".equals(intent.getAction())) {
            Logger.logInfo("Alarm started");
            alarmIsRinging = true;
        } else {
            Logger.logInfo("Alarm done");
            alarmIsRinging = false;
        }
    }
}
