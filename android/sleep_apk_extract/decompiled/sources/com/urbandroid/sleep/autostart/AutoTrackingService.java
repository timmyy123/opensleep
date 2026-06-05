package com.urbandroid.sleep.autostart;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.ForegroundService;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.activityrecognition.ActivitityrecognitionKt;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.util.ColorUtil;
import io.ktor.http.Url$$ExternalSyntheticLambda1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingService;", "Lcom/urbandroid/common/ForegroundService;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "tag$1", "onStartCommand", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "flags", "startId", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AutoTrackingService extends ForegroundService implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String tag = "AutoTracking:Service";

    /* JADX INFO: renamed from: tag$1, reason: from kotlin metadata */
    private final String tag;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/autostart/AutoTrackingService$Companion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "range", "Lcom/urbandroid/sleep/autostart/ExpectedTrackingRange;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion implements FeatureLogger {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return AutoTrackingService.tag;
        }

        public final boolean start(Context context, ExpectedTrackingRange range) {
            context.getClass();
            range.getClass();
            try {
                Intent intent = new Intent(context, (Class<?>) AutoTrackingService.class);
                range.putInto(intent);
                ContextCompat.startForegroundService(context, intent);
                return true;
            } catch (Exception e) {
                Logger.logSevere(e);
                return false;
            }
        }

        private Companion() {
        }
    }

    public AutoTrackingService() {
        super("sleepTrackingChannel", 77677, R.drawable.ic_action_track_white);
        this.tag = tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStartCommand$lambda$2(AutoTrackingService autoTrackingService, PowerManager.WakeLock wakeLock) {
        autoTrackingService.stopForegroundSelf();
        ContextExtKt.lockRelease(autoTrackingService, wakeLock);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStartCommand$lambda$3(AutoTrackingService autoTrackingService, Ref$BooleanRef ref$BooleanRef) {
        if (ContextExtKt.getSettings(autoTrackingService).getAutoStartMode() == 1) {
            ActivityRecognitionInitializer.INSTANCE.updates(autoTrackingService).initialize(30);
            ref$BooleanRef.element = true;
        }
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.common.LoggingService, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        GlobalInitializator.initializeIfRequired(applicationContext);
        Logger.logInfo(Logger.defaultTag, getTag() + ": start called", null);
        PowerManager.WakeLock wakeLockLockAcquire$default = ContextExtKt.lockAcquire$default(this, getTag(), 20000L, 0, 4, null);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "sleepTrackingChannel");
        PendingIntentBuilder.Companion companion = PendingIntentBuilder.INSTANCE;
        Context applicationContext2 = getApplicationContext();
        applicationContext2.getClass();
        builder.setContentIntent(companion.get(applicationContext2, 0, new Intent(), ClientDefaults.MAX_MSG_SIZE).getActivity());
        builder.setColor(ColorUtil.i(this, R.color.tint_notification));
        builder.setContentText(getResources().getString(R.string.automatic_sleep_tracking));
        builder.setSmallIcon(R.drawable.ic_action_track_white);
        Notification notificationBuild = builder.build();
        notificationBuild.getClass();
        startForegroundOnce(notificationBuild, true);
        Context applicationContext3 = getApplicationContext();
        applicationContext3.getClass();
        boolean z = ContextExtKt.getSettings(applicationContext3).getAutoStartMode() == 1;
        ExpectedTrackingRange expectedTrackingRangeFrom = intent != null ? ExpectedTrackingRange.INSTANCE.from(intent) : null;
        String str = "onStartCommand() enabled: " + z + " expectedRange: " + (expectedTrackingRangeFrom != null ? expectedTrackingRangeFrom.pretty() : null);
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + str, null);
        Url$$ExternalSyntheticLambda1 url$$ExternalSyntheticLambda1 = new Url$$ExternalSyntheticLambda1(this, wakeLockLockAcquire$default, 6);
        if (expectedTrackingRangeFrom == null || !z) {
            url$$ExternalSyntheticLambda1.invoke();
            return 2;
        }
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ActivitityrecognitionKt.whenActivityRecognitionNeeded(this, new Url$$ExternalSyntheticLambda1(this, ref$BooleanRef, 7));
        if (!ref$BooleanRef.element) {
            url$$ExternalSyntheticLambda1.invoke();
            return 2;
        }
        AutoTrackingProcessor autoTrackingProcessor = AutoTrackingProcessor.INSTANCE;
        Context applicationContext4 = getApplicationContext();
        applicationContext4.getClass();
        autoTrackingProcessor.processStages(applicationContext4, expectedTrackingRangeFrom, url$$ExternalSyntheticLambda1);
        return 2;
    }
}
