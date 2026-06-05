package com.urbandroid.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AlarmManagerCompat {
    public static void setExactAndAllowWhileIdle(AlarmManager alarmManager, int i, long j, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
            alarmManager.setExactAndAllowWhileIdle(i, j, pendingIntent);
        } else {
            Logger.logSevere("Cannot set EXACT alarms");
            alarmManager.setAndAllowWhileIdle(i, j, pendingIntent);
        }
    }
}
