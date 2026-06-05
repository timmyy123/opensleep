package com.urbandroid.sleep.alarmclock;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.util.ColorUtil;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AlarmBackgroundRestrictionChecker {
    static int NOTIFICATION_ID = 394720902;

    private static void showNotification(Context context) {
        Intent intent = new Intent(context, (Class<?>) AlarmClock.class);
        intent.setFlags(268566528);
        PendingIntent activity = PendingIntentBuilder.get(context, 0, intent, 0).getActivity();
        String string = context.getString(R.string.background_restricted_alarm_notification_text);
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, "bkgRestrictedChannel").setContentIntent(activity).setColor(ColorUtil.i(context, R.color.tint_notification)).setContentTitle(context.getString(R.string.background_restrictions)).setStyle(new NotificationCompat.BigTextStyle().bigText(string)).setContentText(string);
        contentText.setSmallIcon(R.drawable.ic_alarm_white);
        Logger.logInfo("Alarms: Showing background restriction notification");
        NotificationsKt.notify(context, NOTIFICATION_ID, contentText.build());
    }

    public static void showNotificationIfBackgroundRestricted(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (Build.VERSION.SDK_INT >= 28) {
            boolean zIsBackgroundRestricted = activityManager.isBackgroundRestricted();
            Logger.logDebug("Background restricted: " + zIsBackgroundRestricted);
            if (zIsBackgroundRestricted) {
                showNotification(context);
            }
        }
    }
}
