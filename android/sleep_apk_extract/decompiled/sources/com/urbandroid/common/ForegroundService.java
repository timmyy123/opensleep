package com.urbandroid.common;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.util.ColorUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0005J\b\u0010\u0014\u001a\u00020\rH\u0004J\b\u0010\u0015\u001a\u00020\rH\u0004J\b\u0010\u0016\u001a\u00020\rH\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/common/ForegroundService;", "Lcom/urbandroid/common/LoggingService;", "channelId", "", "notificationId", "", "smallIcon", "<init>", "(Ljava/lang/String;II)V", "startForegroundCalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getType", "onCreate", "", "onDestroy", "startForegroundOnce", "notification", "Landroid/app/Notification;", "force", "", "setDummyForegroundIfForegroundNotCalled", "stopForegroundSelf", "reset", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ForegroundService extends LoggingService {
    private final String channelId;
    private final int notificationId;
    private final int smallIcon;
    private final AtomicBoolean startForegroundCalled;

    public ForegroundService(String str, int i, int i2) {
        str.getClass();
        this.channelId = str;
        this.notificationId = i;
        this.smallIcon = i2;
        this.startForegroundCalled = new AtomicBoolean(false);
    }

    public static /* synthetic */ void startForegroundOnce$default(ForegroundService foregroundService, Notification notification, boolean z, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: startForegroundOnce");
            return;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        foregroundService.startForegroundOnce(notification, z);
    }

    public int getType() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0055 A[Catch: Exception -> 0x0053, TRY_LEAVE, TryCatch #0 {Exception -> 0x0053, blocks: (B:7:0x003f, B:9:0x0045, B:12:0x0055), top: B:17:0x003f }] */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            NotificationsKt.createChannels(this);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, this.channelId);
        builder.setContentText(getString(R.string.app_name));
        builder.setColor(ColorUtil.i(this, R.color.tint_notification));
        builder.setSmallIcon(R.drawable.empty);
        Logger.logInfo("Service: Start foreground: ".concat(getClass().getSimpleName()));
        if (i >= 29) {
            try {
                if (getType() != 0) {
                    super.startForeground(this.notificationId, builder.build(), getType());
                } else {
                    super.startForeground(this.notificationId, builder.build());
                }
            } catch (Exception e) {
                Logger.logSevere(e);
                stopSelf();
                return;
            }
        }
        GlobalInitializator.initializeIfRequired(this);
        reset();
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public void onDestroy() {
        reset();
        super.onDestroy();
    }

    public final void reset() {
        Logger.logDebug("ForegroundService[" + getClass().getSimpleName() + "@" + hashCode() + "]: reset called");
        this.startForegroundCalled.set(false);
    }

    public final synchronized void setDummyForegroundIfForegroundNotCalled() {
        if (!this.startForegroundCalled.get()) {
            String simpleName = getClass().getSimpleName();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, this.channelId);
            PendingIntentBuilder.Companion companion = PendingIntentBuilder.INSTANCE;
            Context applicationContext = getApplicationContext();
            applicationContext.getClass();
            builder.setContentIntent(companion.get(applicationContext, 0, new Intent(), 0).getActivity());
            builder.setColor(ColorUtil.i(this, R.color.tint_notification));
            builder.setContentTitle(simpleName);
            builder.setContentText("");
            builder.setSmallIcon(this.smallIcon);
            Notification notificationBuild = builder.build();
            notificationBuild.getClass();
            startForegroundOnce$default(this, notificationBuild, false, 2, null);
        }
    }

    public final synchronized void startForegroundOnce(Notification notification, boolean force) {
        try {
            notification.getClass();
            if (force || !this.startForegroundCalled.get()) {
                if (Build.VERSION.SDK_INT < 29 || getType() == 0) {
                    super.startForeground(this.notificationId, notification);
                } else {
                    super.startForeground(this.notificationId, notification, getType());
                }
                Logger.logDebug("ForegroundService[" + getClass().getSimpleName() + "@" + hashCode() + "]: startForegroundOnce called - alreadyCalled=" + this.startForegroundCalled + "\"");
                this.startForegroundCalled.set(true);
            } else {
                Logger.logWarning("ForegroundService[" + getClass().getSimpleName() + "@" + hashCode() + "]: startForegroundOnce already called - alreadyCalled=" + this.startForegroundCalled + "\"");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void stopForegroundSelf() {
        Logger.logDebug("ForegroundService[" + getClass().getSimpleName() + "@" + hashCode() + "]: stopForegroundSelf called - alreadyCalled=" + this.startForegroundCalled);
        setDummyForegroundIfForegroundNotCalled();
        Logger.logDebug("ForegroundService[" + getClass().getSimpleName() + "@" + hashCode() + "]: notification removed");
        stopSelf();
        reset();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ForegroundService(String str, int i) {
        this(str, i, 0, 4, null);
        str.getClass();
    }

    public /* synthetic */ ForegroundService(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i3 & 4) != 0 ? R.drawable.empty : i2);
    }

    public final void startForegroundOnce(Notification notification) {
        notification.getClass();
        startForegroundOnce$default(this, notification, false, 2, null);
    }
}
