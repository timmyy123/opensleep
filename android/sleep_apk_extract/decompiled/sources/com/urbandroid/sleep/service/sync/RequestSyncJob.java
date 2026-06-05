package com.urbandroid.sleep.service.sync;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.persistence.SilentExportService;
import com.urbandroid.sleep.service.google.calendar.GoogleCalendarSyncJobService;
import com.urbandroid.sleep.service.google.fit.GoogleFitSyncJobService;
import com.urbandroid.sleep.service.google.healthconnect.HealthConnectSyncJobService;
import com.urbandroid.sleep.service.samsung.shealth.SamsungSHealthSyncJobService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/service/sync/RequestSyncJob;", "Landroid/app/job/JobService;", "<init>", "()V", "onStartJob", "", "p0", "Landroid/app/job/JobParameters;", "onStopJob", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RequestSyncJob extends JobService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/service/sync/RequestSyncJob$Companion;", "", "<init>", "()V", "EXTRA_NOISE_ID", "", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(Context context) {
            context.getClass();
            Logger.logInfo("SYNC start job ", null);
            JobInfo.Builder builder = new JobInfo.Builder(1019, new ComponentName(context, (Class<?>) RequestSyncJob.class));
            builder.setRequiredNetworkType(1);
            Object systemService = context.getSystemService("jobscheduler");
            systemService.getClass();
            JobScheduler jobScheduler = (JobScheduler) systemService;
            jobScheduler.cancel(1019);
            jobScheduler.schedule(builder.build());
        }

        private Companion() {
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters p0) {
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        GlobalInitializator.initializeIfRequired(applicationContext);
        Logger.logInfo("SYNC doWork()");
        SilentExportService.start(getApplicationContext());
        GoogleFitSyncJobService.Companion companion = GoogleFitSyncJobService.INSTANCE;
        Context applicationContext2 = getApplicationContext().getApplicationContext();
        applicationContext2.getClass();
        GoogleFitSyncJobService.Companion.start$default(companion, applicationContext2, false, false, 4, null);
        GoogleCalendarSyncJobService.Companion companion2 = GoogleCalendarSyncJobService.INSTANCE;
        Context applicationContext3 = getApplicationContext().getApplicationContext();
        applicationContext3.getClass();
        companion2.start(applicationContext3);
        SamsungSHealthSyncJobService.Companion companion3 = SamsungSHealthSyncJobService.INSTANCE;
        Context applicationContext4 = getApplicationContext().getApplicationContext();
        applicationContext4.getClass();
        SamsungSHealthSyncJobService.Companion.start$default(companion3, applicationContext4, false, 2, null);
        HealthConnectSyncJobService.Companion companion4 = HealthConnectSyncJobService.INSTANCE;
        Context applicationContext5 = getApplicationContext().getApplicationContext();
        applicationContext5.getClass();
        HealthConnectSyncJobService.Companion.start$default(companion4, applicationContext5, false, 2, null);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters p0) {
        return false;
    }
}
