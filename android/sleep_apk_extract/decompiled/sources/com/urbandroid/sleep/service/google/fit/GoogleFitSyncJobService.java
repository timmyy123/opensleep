package com.urbandroid.sleep.service.google.fit;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.fitness.FitnessOptions;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.PendingIntentBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionPermission;
import com.urbandroid.sleep.notification.NotificationsKt;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitApiFactory;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitExtKt;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSyncJobService;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.util.ColorUtil;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J.\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/service/google/fit/GoogleFitSyncJobService;", "Lcom/urbandroid/sleep/service/health/HealthSyncJobService;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "fitApiFactory", "Lcom/urbandroid/sleep/service/google/fit/api/GoogleFitApiFactory;", "prepareSynchronization", "Lcom/urbandroid/sleep/service/health/HealthSynchronization;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "dbSleepRecordRepository", "Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;", "manual", "", "importMode", "getSynchronizeFromDate", "Ljava/util/Date;", "syncFinished", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleFitSyncJobService extends HealthSyncJobService implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GoogleFitApiFactory fitApiFactory;
    private final String tag;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/service/google/fit/GoogleFitSyncJobService$Companion;", "", "<init>", "()V", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "manual", "", "importMode", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, boolean z, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            companion.start(context, z, z2);
        }

        public final void start(Context context, boolean manual, boolean importMode) {
            context.getClass();
            if (ContextExtKt.getSettings(context).isGoogleFit()) {
                HealthSyncJobService.Companion companion = HealthSyncJobService.INSTANCE;
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putBoolean("manual", manual);
                persistableBundle.putBoolean("importMode", importMode);
                Unit unit = Unit.INSTANCE;
                companion.schedule(context, GoogleFitSyncJobService.class, 1012, persistableBundle);
                Logger.logInfo("GoogleFitSyncJobService scheduled", null);
            }
        }

        private Companion() {
        }

        public final void start(Context context, boolean z) {
            context.getClass();
            start$default(this, context, z, false, 4, null);
        }
    }

    public GoogleFitSyncJobService() {
        super(HealthServiceProvider.GoogleFit.INSTANCE);
        this.tag = "fit:service";
        this.fitApiFactory = new GoogleFitApiFactory();
    }

    public static final void start(Context context, boolean z) {
        INSTANCE.start(context, z);
    }

    @Override // com.urbandroid.sleep.service.health.HealthSyncJobService
    public Date getSynchronizeFromDate(boolean importMode) {
        if (importMode) {
            return super.getSynchronizeFromDate(importMode);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, -SharedApplicationContext.getSettings().getGoogleFitSyncServiceDays(14));
        Date time = calendar.getTime();
        time.getClass();
        return time;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSyncJobService, com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSyncJobService
    public HealthSynchronization<?> prepareSynchronization(Context context, ISleepRecordRepository dbSleepRecordRepository, boolean manual, boolean importMode) {
        context.getClass();
        dbSleepRecordRepository.getClass();
        if (!ContextExtKt.hasConnectivity(context)) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": no internet connectivity - sync terminated", null);
            return null;
        }
        FitnessOptions fitnessOptions = GoogleFitConstantsKt.fitnessOptions(true);
        GoogleSignInAccount accountForExtension = GoogleSignIn.getAccountForExtension(getApplicationContext(), fitnessOptions);
        accountForExtension.getClass();
        if (ActivityRecognitionPermission.INSTANCE.isGranted(context) && GoogleFitExtKt.hasPermissions(accountForExtension, fitnessOptions)) {
            HealthSynchronization<?> healthSynchronizationCreate = GoogleFitSynchronizationFactory.getInstance().create(context, this.fitApiFactory.create(context, accountForExtension), dbSleepRecordRepository);
            healthSynchronizationCreate.setManual(manual);
            healthSynchronizationCreate.setImportMode(importMode);
            return healthSynchronizationCreate;
        }
        Logger.logWarning(Logger.defaultTag, getTag() + ": missing permissions - notification will be displayed", null);
        Intent intent = new Intent(context, (Class<?>) GoogleFitAuthorizationActivity.class);
        intent.setFlags(268566528);
        PendingIntent activity = PendingIntentBuilder.INSTANCE.get(context, 0, intent, 0).getActivity();
        NotificationManagerCompat.from(context).getClass();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "servicesChannel");
        builder.setContentIntent(activity);
        builder.setColor(ColorUtil.i(context, R.color.tint_notification));
        builder.setAutoCancel(true);
        builder.setContentText(context.getString(R.string.share_disconnected, "Google Fit") + "-" + context.getString(R.string.no_permission));
        builder.setContentTitle(context.getString(R.string.google_fit));
        builder.setSmallIcon(R.drawable.ic_cloud_upload_white);
        Notification notificationBuild = builder.build();
        notificationBuild.getClass();
        NotificationsKt.notify(context, -31415926, notificationBuild);
        Logger.logWarning(Logger.defaultTag, getTag() + ": sync terminated", null);
        return null;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSyncJobService
    public void syncFinished() {
        new Settings(getApplicationContext()).setGoogleFitSyncLastTimestamp(System.currentTimeMillis());
    }
}
