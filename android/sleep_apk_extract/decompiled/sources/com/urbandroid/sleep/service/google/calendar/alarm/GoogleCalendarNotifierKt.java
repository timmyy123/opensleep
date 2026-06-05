package com.urbandroid.sleep.service.google.calendar.alarm;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.util.ColorUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/google/android/gms/auth/UserRecoverableAuthException;", "ex", "", "calendarPermissionMissingNotification", "(Landroid/content/Context;Lcom/google/android/gms/auth/UserRecoverableAuthException;)V", "", "calendarPermissionMissingNotificationCalled", "Z", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class GoogleCalendarNotifierKt {
    private static boolean calendarPermissionMissingNotificationCalled;

    public static final void calendarPermissionMissingNotification(Context context, UserRecoverableAuthException userRecoverableAuthException) {
        Intent intent;
        context.getClass();
        if (calendarPermissionMissingNotificationCalled) {
            return;
        }
        Logger.logInfo("calendar:notify: calendarPermissionMissingNotification called " + (userRecoverableAuthException != null ? userRecoverableAuthException.getIntent() : null), null);
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(context, "calendarChannel").setColor(ColorUtil.i(context, R.color.tint_notification)).setAutoCancel(true).setContentTitle(context.getString(R.string.share_disconnected, context.getString(R.string.google_calendar))).setContentText(context.getString(R.string.tap_to_connect)).setSmallIcon(R.drawable.ic_action_track_white);
        smallIcon.getClass();
        if (userRecoverableAuthException != null && (intent = userRecoverableAuthException.getIntent()) != null) {
            PendingIntent activity = PendingIntentBuilder.INSTANCE.get(context, 3443, intent, 134217728).getActivity();
            smallIcon.setContentIntent(activity);
            smallIcon.addAction(0, context.getString(R.string.connect), activity);
        }
        Notification notificationBuild = smallIcon.build();
        notificationBuild.getClass();
        NotificationsKt.notify(context, 3443, notificationBuild);
        calendarPermissionMissingNotificationCalled = true;
    }
}
