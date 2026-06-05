package com.urbandroid.sleep.service.google.calendar.alarm;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.core.app.NotificationManagerCompat;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;

/* JADX INFO: loaded from: classes5.dex */
public class RevertActivity extends BaseActivity {
    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final Context applicationContext = getApplicationContext();
        GlobalInitializator.initializeIfRequired(applicationContext);
        final int intExtra = getIntent().getIntExtra("alarm_id", -1);
        int intExtra2 = getIntent().getIntExtra("notification_id", -1);
        zza$$ExternalSyntheticOutline0.m(intExtra, intExtra2, "RevertReceiver: alarm ", " notification-id ");
        if (intExtra > -1) {
            final Alarm alarm = Alarms.getAlarm(applicationContext.getContentResolver(), intExtra);
            if (alarm != null) {
                new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.service.google.calendar.alarm.RevertActivity.1
                    @Override // android.os.AsyncTask
                    public Void doInBackground(Void... voidArr) {
                        if ("com.urbandroid.sleep.ACTION_REVERT_CALENDAR_SKIP_NEXT".equals(RevertActivity.this.getIntent().getAction())) {
                            zza$$ExternalSyntheticOutline0.m(new StringBuilder("RevertReceiver: skip "), intExtra);
                            if (alarm.getDaysOfWeek() == null || !alarm.getDaysOfWeek().isRepeatSet()) {
                                Alarms.enableAlarm(applicationContext, intExtra, true);
                                return null;
                            }
                            Alarms.setSkipNext(applicationContext, alarm, false);
                            return null;
                        }
                        if (!"com.urbandroid.sleep.ACTION_REVERT_CALENDAR_OFFSET".equals(RevertActivity.this.getIntent().getAction())) {
                            return null;
                        }
                        Logger.logInfo("RevertReceiver: reset offset " + intExtra + " ...");
                        Alarms.addOffset(RevertActivity.this.getApplicationContext(), alarm, 0);
                        Alarms.setAlarm(applicationContext, alarm);
                        return null;
                    }
                }.execute(new Void[0]);
            } else {
                Logger.logWarning("RevertReceiver: alarm " + intExtra + " not found");
            }
        }
        NotificationManagerCompat.from(applicationContext).cancel(intExtra2);
        finish();
    }
}
