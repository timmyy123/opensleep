package com.urbandroid.sleep.notification;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.NotificationManagerCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import kotlin.Metadata;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000b\u001a\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\t\u001a%\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "createChannels", "(Landroid/content/Context;)V", "", "channelId", "", "isNotificationChannelEnabled", "(Landroid/content/Context;Ljava/lang/String;)Z", "showSettings", "(Landroid/content/Context;Ljava/lang/String;)V", "areNotificationsEnabled", "(Landroid/content/Context;)Z", "isNotificationEnabled", "", "id", "Landroid/app/Notification;", "notification", "notify", "(Landroid/content/Context;ILandroid/app/Notification;)V", "cancel", "(Landroid/content/Context;I)V", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class NotificationsKt {
    public static final boolean areNotificationsEnabled(Context context) {
        context.getClass();
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public static final void cancel(Context context, int i) {
        context.getClass();
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        notificationManagerCompatFrom.getClass();
        try {
            notificationManagerCompatFrom.cancel(i);
        } catch (SecurityException unused) {
            Logger.logSevere("Notification: cancel notify failed (missing permission) ID:" + i);
        }
    }

    public static final void createChannels(Context context) {
        context.getClass();
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        notificationManagerCompatFrom.getClass();
        NotificationChannel notificationChannel = new NotificationChannel("alarmChannel", FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(R.string.default_label), " (Pop up)"), 4);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound(null, null);
        String string = context.getString(R.string.default_label);
        string.getClass();
        NotificationChannel notificationChannel2 = new NotificationChannel("alarmNormalChannel", string, 2);
        notificationChannel2.enableLights(false);
        notificationChannel2.enableVibration(false);
        notificationChannel2.setSound(null, null);
        String string2 = context.getString(R.string.before_alarm_notification);
        string2.getClass();
        NotificationChannel notificationChannel3 = new NotificationChannel("beforeAlarmChannel", string2, 2);
        notificationChannel3.enableLights(false);
        notificationChannel3.enableVibration(false);
        notificationChannel3.setSound(null, null);
        String string3 = context.getString(R.string.rate_later);
        string3.getClass();
        NotificationChannel notificationChannel4 = new NotificationChannel("reteLateAlarmChannel", string3, 4);
        notificationChannel4.enableLights(true);
        notificationChannel4.enableVibration(true);
        String string4 = context.getString(R.string.settings_wake_up_check);
        string4.getClass();
        NotificationChannel notificationChannel5 = new NotificationChannel("wakeupCheckChannel2", string4, 4);
        notificationChannel5.enableLights(false);
        notificationChannel5.enableVibration(false);
        notificationChannel5.setImportance(4);
        notificationChannel5.setSound(null, null);
        notificationChannel5.setShowBadge(true);
        String string5 = context.getString(R.string.stop_snoring);
        string5.getClass();
        NotificationChannel notificationChannel6 = new NotificationChannel("antiSnoringChannel", string5, 4);
        notificationChannel6.enableLights(false);
        notificationChannel6.enableVibration(false);
        notificationChannel6.setSound(null, null);
        String string6 = context.getString(R.string.settings_category_track);
        string6.getClass();
        NotificationChannel notificationChannel7 = new NotificationChannel("sleepTrackingChannel", string6, 2);
        notificationChannel7.enableLights(false);
        notificationChannel7.enableVibration(false);
        notificationChannel7.setSound(null, null);
        String string7 = context.getString(R.string.time_to_bed_title);
        string7.getClass();
        NotificationChannel notificationChannel8 = new NotificationChannel("bedtimeChannel", string7, 4);
        notificationChannel8.enableLights(true);
        notificationChannel8.setLightColor(-14136);
        notificationChannel8.setVibrationPattern(new long[]{0, 1000, 1000, 1000, 1000, 1000});
        notificationChannel8.enableVibration(true);
        String string8 = context.getString(R.string.lullaby);
        string8.getClass();
        NotificationChannel notificationChannel9 = new NotificationChannel("lullabyChannel", string8, 2);
        notificationChannel9.enableLights(false);
        notificationChannel9.enableVibration(false);
        notificationChannel9.setSound(null, null);
        String string9 = context.getString(R.string.backup);
        string9.getClass();
        NotificationChannel notificationChannel10 = new NotificationChannel("backupChannel", string9, 2);
        notificationChannel10.enableLights(false);
        notificationChannel10.enableVibration(false);
        notificationChannel10.setSound(null, null);
        String string10 = context.getString(R.string.sleep_time_suggestion);
        string10.getClass();
        NotificationChannel notificationChannel11 = new NotificationChannel("sleepTimeSuggestionChannel", string10, 2);
        notificationChannel11.enableLights(false);
        notificationChannel11.enableVibration(false);
        notificationChannel11.setSound(null, null);
        String string11 = context.getString(R.string.category_services);
        string11.getClass();
        NotificationChannel notificationChannel12 = new NotificationChannel("servicesChannel", string11, 2);
        notificationChannel12.enableLights(false);
        notificationChannel12.enableVibration(false);
        notificationChannel12.setSound(null, null);
        NotificationChannel notificationChannel13 = new NotificationChannel("calendarChannel", FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(R.string.google_calendar), " - ", context.getString(R.string.calendar_event_preference_title)), 4);
        notificationChannel13.enableLights(false);
        notificationChannel13.enableVibration(false);
        notificationChannel13.setSound(null, null);
        String string12 = context.getString(R.string.notification_background_restricted_title);
        string12.getClass();
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
        audioAttributesBuild.getClass();
        NotificationChannel notificationChannel14 = new NotificationChannel("bkgRestrictedChannel", string12, 4);
        notificationChannel14.setDescription(context.getString(R.string.notification_background_restricted_description));
        notificationChannel14.enableLights(true);
        notificationChannel14.enableVibration(true);
        notificationChannel14.setSound(Uri.parse("android.resource://" + context.getPackageName() + "/2131886093"), audioAttributesBuild);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel2);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel3);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel4);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel5);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel6);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel7);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel8);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel9);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel10);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel11);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel12);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel13);
        notificationManagerCompatFrom.createNotificationChannel(notificationChannel14);
    }

    public static final boolean isNotificationChannelEnabled(Context context, String str) {
        context.getClass();
        if (!areNotificationsEnabled(context)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            Object systemService = context.getSystemService("notification");
            systemService.getClass();
            if (((NotificationManager) systemService).getNotificationChannel(str).getImportance() != 0) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isNotificationEnabled(Context context, String str) {
        context.getClass();
        str.getClass();
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
            notificationManagerCompatFrom.getClass();
            NotificationChannel notificationChannel = notificationManagerCompatFrom.getNotificationChannel(str);
            if (notificationChannel != null && notificationChannel.getImportance() != 4) {
                return false;
            }
        }
        return areNotificationsEnabled(context);
    }

    public static final void notify(Context context, int i, Notification notification) {
        context.getClass();
        notification.getClass();
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        notificationManagerCompatFrom.getClass();
        try {
            notificationManagerCompatFrom.notify(i, notification);
        } catch (SecurityException unused) {
            Logger.logSevere("Notification: notify failed (missing permission) ID:" + i + " Group:" + notification.getGroup() + " " + notification);
        }
    }

    public static final void showSettings(Context context, String str) {
        context.getClass();
        if (Build.VERSION.SDK_INT > 26) {
            Intent intent = new Intent(str == null ? "android.settings.APP_NOTIFICATION_SETTINGS" : "android.settings.CHANNEL_NOTIFICATION_SETTINGS");
            if (str != null) {
                intent.putExtra("android.provider.extra.CHANNEL_ID", str);
            }
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent2.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        intent2.addCategory("android.intent.category.DEFAULT");
        intent2.setData(Uri.parse("package:" + context.getPackageName()));
        intent2.setFlags(ClientDefaults.MAX_MSG_SIZE);
        context.startActivity(intent2);
    }
}
