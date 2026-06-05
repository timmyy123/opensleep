package com.urbandroid.sleep.alarmclock;

import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.LoggingReceiver;

/* JADX INFO: loaded from: classes4.dex */
public class AlarmModificationReceiver extends LoggingReceiver {
    @Override // com.urbandroid.common.LoggingReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        GlobalInitializator.initializeIfRequired(context);
        String stringExtra = intent.getStringExtra("alarm_label");
        int intExtra = intent.getIntExtra("alarm_id", -1);
        if (stringExtra == null && intExtra == -1) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("alarm_enabled", true);
        Alarm alarmByLabel = stringExtra != null ? Alarms.getAlarmByLabel(context.getContentResolver(), stringExtra, !booleanExtra) : null;
        if (alarmByLabel == null && intExtra != -1) {
            alarmByLabel = Alarms.getAlarm(context.getContentResolver(), intExtra);
        }
        if (alarmByLabel != null && intent.hasExtra("alarm_enabled")) {
            alarmByLabel.enabled = booleanExtra;
            Alarms.setAlarm(context, alarmByLabel);
        }
    }
}
