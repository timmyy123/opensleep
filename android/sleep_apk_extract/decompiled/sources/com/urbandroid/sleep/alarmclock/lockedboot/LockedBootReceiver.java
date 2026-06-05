package com.urbandroid.sleep.alarmclock.lockedboot;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.urbandroid.common.util.InputStreamUtil;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import java.io.FileNotFoundException;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class LockedBootReceiver extends BroadcastReceiver {
    public static void cancelBackupAlarm(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(getBackupAlarmIntent(context));
    }

    public static PendingIntent getBackupAlarmIntent(Context context, long j) {
        Intent intent = new Intent(context, (Class<?>) BackupAlarmService.class);
        if (j != -1) {
            intent.putExtra("next_alarm", j);
        }
        intent.setPackage(context.getPackageName());
        return PendingIntentBuilder.get(context, 666, intent, 134217728).getForegroundService();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        String str;
        boolean z;
        long j;
        Log.i("SleepAsAndroidDB", "DB: Locked boot receiver " + intent.getAction());
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        Log.i("SleepAsAndroidDB", "DB: Direct boot intent");
        if (contextCreateDeviceProtectedStorageContext.isDeviceProtectedStorage()) {
            Log.i("SleepAsAndroidDB", "DB: is device protected");
            if ("android.intent.action.LOCKED_BOOT_COMPLETED".equals(intent.getAction())) {
                try {
                    String strValueOf = InputStreamUtil.read(contextCreateDeviceProtectedStorageContext.openFileInput("next_alarm"));
                    try {
                        str = InputStreamUtil.read(contextCreateDeviceProtectedStorageContext.openFileInput("running_alarm"));
                    } catch (FileNotFoundException unused) {
                        Log.e("SleepAsAndroidDB", "DB: no active alarm file ");
                        str = null;
                    }
                    long j2 = -1;
                    if (str == null || "".equals(str)) {
                        z = false;
                    } else {
                        try {
                            j = Long.parseLong(str);
                        } catch (NumberFormatException unused2) {
                            Log.e("SleepAsAndroidDB", "DB: cannot parse active alarm ".concat(str));
                            j = -1;
                        }
                        if (System.currentTimeMillis() - j < 300000) {
                            Log.i("SleepAsAndroidDB", "DB: Has active alarm, resuming, next alarm is NOW..");
                            strValueOf = String.valueOf(System.currentTimeMillis());
                            z = true;
                        }
                    }
                    if (strValueOf != null && !"".equals(strValueOf)) {
                        Log.i("SleepAsAndroidDB", "DB: Direct boot next alarm ".concat(strValueOf));
                        long jCurrentTimeMillis = Long.parseLong(strValueOf);
                        Date date = new Date(jCurrentTimeMillis);
                        if (System.currentTimeMillis() - jCurrentTimeMillis < 180000) {
                            jCurrentTimeMillis = System.currentTimeMillis() + 30000;
                        }
                        if (System.currentTimeMillis() < jCurrentTimeMillis) {
                            long time = date.getTime();
                            Log.i("SleepAsAndroidDB", "DB: Direct boot setting alarm " + new Date(time));
                            AlarmManager alarmManager = (AlarmManager) contextCreateDeviceProtectedStorageContext.getSystemService("alarm");
                            PendingIntent activity = PendingIntentBuilder.get(contextCreateDeviceProtectedStorageContext, 666, new Intent(contextCreateDeviceProtectedStorageContext, (Class<?>) AlarmClock.class), 134217728).getActivity();
                            if (Build.VERSION.SDK_INT >= 31 && !alarmManager.canScheduleExactAlarms()) {
                                Log.e("SleepAsAndroidDB", "Cannot set EXACT alarms");
                                alarmManager.setAndAllowWhileIdle(0, time, activity);
                                return;
                            } else {
                                AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(time, activity);
                                if (!z) {
                                    j2 = jCurrentTimeMillis;
                                }
                                alarmManager.setAlarmClock(alarmClockInfo, getBackupAlarmIntent(contextCreateDeviceProtectedStorageContext, j2));
                                return;
                            }
                        }
                        return;
                    }
                    Log.i("SleepAsAndroidDB", "DB: No next alarm");
                } catch (Exception e) {
                    Log.e("SleepAsAndroidDB", "DB: Failed to read next_alarm", e);
                }
            }
        }
    }

    public static PendingIntent getBackupAlarmIntent(Context context) {
        return getBackupAlarmIntent(context, -1L);
    }
}
