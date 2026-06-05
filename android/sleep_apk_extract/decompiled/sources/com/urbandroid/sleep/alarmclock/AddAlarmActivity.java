package com.urbandroid.sleep.alarmclock;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class AddAlarmActivity extends BaseActivity {
    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ArrayList<Integer> integerArrayListExtra;
        String stringExtra;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && ("android.intent.action.SET_ALARM".equals(intent.getAction()) || "android.intent.action.SET_TIMER".equals(intent.getAction()))) {
            int intExtra = intent.getIntExtra("android.intent.extra.alarm.HOUR", -1);
            int intExtra2 = intent.getIntExtra("android.intent.extra.alarm.MINUTES", -1);
            if (Environment.isKitKatOrGreater() && intent.hasExtra("android.intent.extra.alarm.LENGTH") && intExtra == -1) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(13, intent.getIntExtra("android.intent.extra.alarm.LENGTH", 0));
                int i = calendar.get(11);
                intExtra2 = calendar.get(12);
                intExtra = i;
            }
            if (intExtra == -1) {
                finish();
                Logger.logInfo("AddAlarmActivity: time not set");
                return;
            }
            boolean booleanExtra = Environment.isHoneycombOrGreater() ? intent.getBooleanExtra("android.intent.extra.alarm.SKIP_UI", false) : true;
            Alarm alarmCreateDefaultAlarm = Alarm.createDefaultAlarm(intExtra, intExtra2);
            if (intent.hasExtra("android.intent.extra.alarm.MESSAGE")) {
                alarmCreateDefaultAlarm.label = intent.getStringExtra("android.intent.extra.alarm.MESSAGE");
            }
            if (Environment.isKitKatOrGreater() && intent.hasExtra("android.intent.extra.alarm.VIBRATE")) {
                alarmCreateDefaultAlarm.extendedConfig.setVibrationStart(intent.getBooleanExtra("android.intent.extra.alarm.VIBRATE", true) ? 0 : null);
            }
            if (Environment.isKitKatOrGreater() && intent.hasExtra("android.intent.extra.alarm.RINGTONE") && (stringExtra = intent.getStringExtra("android.intent.extra.alarm.RINGTONE")) != null) {
                if ("silent".equals(stringExtra)) {
                    alarmCreateDefaultAlarm.silent = true;
                } else {
                    try {
                        alarmCreateDefaultAlarm.alert = Uri.parse(stringExtra);
                    } catch (Exception e) {
                        Logger.logSevere(e);
                    }
                }
            }
            if (Environment.isKitKatOrGreater() && intent.hasExtra("android.intent.extra.alarm.DAYS") && (integerArrayListExtra = intent.getIntegerArrayListExtra("android.intent.extra.alarm.DAYS")) != null) {
                Iterator<Integer> it = integerArrayListExtra.iterator();
                while (it.hasNext()) {
                    alarmCreateDefaultAlarm.getDaysOfWeek().set((it.next().intValue() + 5) % 7, true);
                }
            }
            Alarms.addAlarm(this, alarmCreateDefaultAlarm);
            if (!booleanExtra) {
                Intent intent2 = new Intent(this, (Class<?>) SetAlarm.class);
                intent2.putExtra("alarm_id", alarmCreateDefaultAlarm.id);
                startActivity(intent2);
            }
        }
        finish();
    }
}
