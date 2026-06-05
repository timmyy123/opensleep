package com.urbandroid.sleep.share;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.settings.SocialSettingsActivity;
import com.urbandroid.sleep.service.NotificationService;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes5.dex */
public abstract class NotificationHandler<T> implements IHandler {
    private Context context;
    private NotificationService notificationService;
    private boolean reportSuccess;
    private T resubmitObject;

    public NotificationHandler(Context context, boolean z) {
        this.reportSuccess = false;
        this.notificationService = new NotificationService(context);
        this.context = context;
        this.reportSuccess = z;
    }

    @Override // com.urbandroid.sleep.share.IHandler
    public void onError(Exception exc) {
        Intent intent = new Intent(this.context, (Class<?>) SocialSettingsActivity.class);
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        PendingIntent activity = PendingIntentBuilder.get(this.context, 123, intent, 0).getActivity();
        Logger.logSevere("Sharing failed ", exc);
        this.notificationService.notification(R.string.share_service, this.context.getResources().getString(R.string.share_service_failed) + " " + exc.getMessage(), 23324565, activity);
    }

    @Override // com.urbandroid.sleep.share.IHandler
    public void onNotAuthenticated() {
        Logger.logSevere("Authentication failed ");
        if (this.resubmitObject != null) {
            new Intent(this.context, (Class<?>) SocialSettingsActivity.class).setFlags(ClientDefaults.MAX_MSG_SIZE);
            return;
        }
        Intent intent = new Intent(this.context, (Class<?>) SocialSettingsActivity.class);
        intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
        this.notificationService.notification(R.string.share_service, this.context.getResources().getString(R.string.share_service_failed), 23324565, PendingIntentBuilder.get(this.context, 123, intent, 0).getActivity());
    }

    @Override // com.urbandroid.sleep.share.IHandler
    public void onSuccess() {
        Logger.logInfo("Sharing successful");
        if (this.reportSuccess) {
            this.notificationService.notification(R.string.share_service, this.context.getResources().getString(R.string.share_service_success), 233245651);
        }
    }

    public NotificationHandler(Context context) {
        this(context, false);
    }
}
