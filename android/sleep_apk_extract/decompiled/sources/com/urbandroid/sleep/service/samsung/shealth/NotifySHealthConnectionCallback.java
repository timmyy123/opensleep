package com.urbandroid.sleep.service.samsung.shealth;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.samsung.android.sdk.healthdata.HealthConnectionErrorResult;
import com.urbandroid.common.error.AssertionType;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi;
import com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthConnectionListener;
import com.urbandroid.util.ColorUtil;

/* JADX INFO: loaded from: classes5.dex */
public class NotifySHealthConnectionCallback implements SamsungSHealthConnectionListener {
    private final Context context;

    public NotifySHealthConnectionCallback(Context context) {
        this.context = context;
    }

    @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthConnectionListener
    public void onConnected(SamsungSHealthApi samsungSHealthApi) {
        samsungSHealthApi.printPermissions();
        Settings settings = new Settings(this.context);
        if (!samsungSHealthApi.hasPermissions(SamsungSHealthApi.SLEEP_PERMISSIONS) || samsungSHealthApi.hasPermissions(SamsungSHealthApi.SLEEP_STAGE_PERMISSIONS) || settings.wereSamsungSHealthSleepStageRequested()) {
            return;
        }
        Intent intent = new Intent(this.context, (Class<?>) SamsungSHealthAuthorizationActivity.class);
        intent.setAction("com.urbandroid.sleep.samsung.shealth.sleep_stage_permission");
        intent.setFlags(268566528);
        PendingIntent activity = PendingIntentBuilder.get(this.context, 0, intent, 0).getActivity();
        NotificationManagerCompat.from(this.context);
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this.context, "servicesChannel").setContentIntent(activity).setColor(ColorUtil.i(this.context, R.color.tint_notification)).setAutoCancel(true).setContentText(this.context.getString(R.string.no_permission)).setContentTitle(this.context.getString(R.string.samsung_shealth));
        contentTitle.setSmallIcon(R.drawable.ic_action_track_white);
        NotificationsKt.notify(this.context, -31415927, contentTitle.build());
        settings.markSamsungSHealthSleepStageRequested();
    }

    @Override // com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthConnectionListener
    public void onConnectionFailed(HealthConnectionErrorResult healthConnectionErrorResult) {
        Logger.logDebug("S Health Connection Failed: errorCode: " + healthConnectionErrorResult.getErrorCode() + " hasResolution: " + healthConnectionErrorResult.hasResolution());
        if (!healthConnectionErrorResult.hasResolution()) {
            ErrorReporter.getInstance().generateAssertionError(AssertionType.GENERIC_ASSERTION_FAILURE, "S HEALTH CONNECT FAILURE: errorCode: " + healthConnectionErrorResult.getErrorCode() + " hasResolution: " + healthConnectionErrorResult.hasResolution());
        }
        Intent intent = new Intent(this.context, (Class<?>) SamsungSHealthAuthorizationActivity.class);
        intent.setFlags(268566528);
        PendingIntent activity = PendingIntentBuilder.get(this.context, 0, intent, 0).getActivity();
        NotificationManagerCompat.from(this.context);
        NotificationCompat.Builder contentTitle = new NotificationCompat.Builder(this.context, "servicesChannel").setContentIntent(activity).setColor(ColorUtil.i(this.context, R.color.tint_notification)).setAutoCancel(true).setContentText(this.context.getString(R.string.share_disconnected, "Samsung S Health")).setContentTitle(this.context.getString(R.string.samsung_shealth));
        contentTitle.setSmallIcon(R.drawable.ic_cloud_upload_white);
        NotificationsKt.notify(this.context, -31415927, contentTitle.build());
    }
}
