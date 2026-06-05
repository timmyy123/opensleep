package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;

/* JADX INFO: loaded from: classes.dex */
abstract class NotificationCompat$Api34Impl {
    public static Notification.MediaStyle setRemotePlaybackInfo(Notification.MediaStyle mediaStyle, CharSequence charSequence, int i, PendingIntent pendingIntent, Boolean bool) {
        if (bool.booleanValue()) {
            mediaStyle.setRemotePlaybackInfo(charSequence, i, pendingIntent);
        }
        return mediaStyle;
    }
}
