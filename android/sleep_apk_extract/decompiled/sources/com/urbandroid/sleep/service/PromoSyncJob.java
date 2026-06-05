package com.urbandroid.sleep.service;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.promo.PromoEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/service/PromoSyncJob;", "Landroid/app/job/JobService;", "<init>", "()V", "onStartJob", "", "p0", "Landroid/app/job/JobParameters;", "onStopJob", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PromoSyncJob extends JobService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/service/PromoSyncJob$Companion;", "", "<init>", "()V", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(Context context) {
            context.getClass();
            PromoEvent nextPromo = new Settings(context).getNextPromo();
            if (nextPromo == null || nextPromo.getUpdated() == -1 || nextPromo.getUpdated() + 259200000 < System.currentTimeMillis()) {
                JobInfo.Builder builder = new JobInfo.Builder(1020, new ComponentName(context, (Class<?>) PromoSyncJob.class));
                builder.setRequiredNetworkType(1);
                Object systemService = context.getSystemService("jobscheduler");
                systemService.getClass();
                JobScheduler jobScheduler = (JobScheduler) systemService;
                jobScheduler.cancel(1020);
                jobScheduler.schedule(builder.build());
            }
        }

        private Companion() {
        }
    }

    public static final void start(Context context) {
        INSTANCE.start(context);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters p0) {
        Logger.logInfo("PromoSync doWork()");
        PromoEvent.update(this);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters p0) {
        return false;
    }
}
