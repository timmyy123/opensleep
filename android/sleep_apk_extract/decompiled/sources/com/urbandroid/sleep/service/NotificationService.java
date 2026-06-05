package com.urbandroid.sleep.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.util.ColorUtil;

/* JADX INFO: loaded from: classes5.dex */
public class NotificationService {
    private final Context context;
    private final String notificationChannelId;

    public NotificationService(Context context, String str) {
        this.context = context;
        this.notificationChannelId = str;
    }

    public void notification(int i, String str, int i2, PendingIntent pendingIntent) {
        PendingIntent activity = PendingIntentBuilder.get(this.context, i2, new Intent(), 0).getActivity();
        String str2 = this.notificationChannelId;
        Context context = this.context;
        NotificationCompat.Builder builder = str2 != null ? new NotificationCompat.Builder(context, str2) : new NotificationCompat.Builder(context, "servicesChannel").setSmallIcon(R.drawable.ic_action_track_white).setColor(ColorUtil.i(this.context, R.color.tint_notification)).setContentIntent(activity).setContentTitle(this.context.getResources().getString(i)).setAutoCancel(true).setColor(this.context.getResources().getColor(R.color.tint_dark)).setOngoing(false).setContentText(str);
        if (pendingIntent != null) {
            builder.setContentIntent(pendingIntent);
        }
        NotificationsKt.notify(this.context, i2, builder.build());
    }

    @Deprecated
    public NotificationService(Context context) {
        this(context, null);
    }

    public void notification(int i, String str, int i2) {
        notification(i, str, i2, null);
    }
}
