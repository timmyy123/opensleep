package com.urbandroid.sleep.smartwatch.garmin;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.urbandroid.sleep.R;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Notifications {
    public static int getPendingIntentFlags() {
        return Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728;
    }

    public static void showUnrestrictedBatteryNeededNotification(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        NotificationManagerCompat.from(context).notify(1389, new NotificationCompat.Builder(context, "sleepTrackingChannel").setSmallIcon(R.drawable.ic_action_watch).setStyle(new NotificationCompat.BigTextStyle().bigText(context.getString(R.string.unrestricted_battery_needed))).setContentText(context.getString(R.string.unrestricted_battery_needed)).setColor(context.getResources().getColor(R.color.tint_dark)).setPriority(1).setContentIntent(PendingIntent.getActivity(context, 0, intent, getPendingIntentFlags())).setOnlyAlertOnce(true).setAutoCancel(true).build());
    }
}
