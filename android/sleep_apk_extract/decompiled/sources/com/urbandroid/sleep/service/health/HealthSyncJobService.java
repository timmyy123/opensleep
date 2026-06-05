package com.urbandroid.sleep.service.health;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.google.calendar.api.SleepCalendarNotFoundException;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \"2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\"B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0014H$J.\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH$J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u000fH\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/urbandroid/sleep/service/health/HealthSyncJobService;", "Landroid/app/job/JobService;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "serviceProvider", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "<init>", "(Lcom/urbandroid/sleep/service/health/HealthServiceProvider;)V", "tag", "", "getTag", "()Ljava/lang/String;", "synchronization", "Lcom/urbandroid/sleep/service/health/HealthSynchronization;", "onStartJob", "", "jobParameters", "Landroid/app/job/JobParameters;", "onStopJob", "syncFinished", "", "prepareSynchronization", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "dbSleepRecordRepository", "Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;", "manual", "importMode", "getSynchronizeFromDate", "Ljava/util/Date;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class HealthSyncJobService extends JobService implements CoroutineScope, FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private HealthSynchronization<?> synchronization;
    private final String tag;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/service/health/HealthSyncJobService$Companion;", "", "<init>", "()V", "PARAMETER_IMPORT_MODE", "", "PARAMETER_MANUAL", "SYNC_NOW_IN_DAYS", "", "schedule", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "jobClass", "Ljava/lang/Class;", "Lcom/urbandroid/sleep/service/health/HealthSyncJobService;", "jobId", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "Landroid/os/PersistableBundle;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void schedule$default(Companion companion, Context context, Class cls, int i, PersistableBundle persistableBundle, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                persistableBundle = null;
            }
            companion.schedule(context, cls, i, persistableBundle);
        }

        public final void schedule(Context context, Class<? extends HealthSyncJobService> jobClass, int jobId, PersistableBundle parameters) {
            context.getClass();
            jobClass.getClass();
            JobInfo.Builder builder = new JobInfo.Builder(jobId, new ComponentName(context, jobClass));
            builder.setRequiredNetworkType(1);
            builder.setRequiresCharging(false);
            builder.setBackoffCriteria(Utils.getHoursInMillis(1), 1);
            builder.setOverrideDeadline(Utils.getHoursInMillis(72));
            if (parameters != null) {
                builder.setExtras(parameters);
            }
            JobInfo jobInfoBuild = builder.build();
            JobScheduler jobScheduler = ContextExtKt.getJobScheduler(context);
            jobScheduler.cancel(jobId);
            jobScheduler.schedule(jobInfoBuild);
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.health.HealthSyncJobService$onStartJob$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.health.HealthSyncJobService$onStartJob$1", f = "HealthSyncJobService.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $importMode;
        final /* synthetic */ JobParameters $jobParameters;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, JobParameters jobParameters, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$importMode = z;
            this.$jobParameters = jobParameters;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HealthSyncJobService.this.new AnonymousClass1(this.$importMode, this.$jobParameters, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.Object, kotlin.Unit] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            try {
                try {
                    try {
                        try {
                            Date synchronizeFromDate = HealthSyncJobService.this.getSynchronizeFromDate(this.$importMode);
                            HealthSyncJobService healthSyncJobService = HealthSyncJobService.this;
                            String str = Logger.defaultTag;
                            Logger.logInfo(str, healthSyncJobService.getTag() + ": " + ("fromDate: " + synchronizeFromDate), null);
                            HealthSynchronization healthSynchronization = HealthSyncJobService.this.synchronization;
                            if (healthSynchronization != null) {
                                healthSynchronization.synchronize(synchronizeFromDate, null);
                                Unit unit = Unit.INSTANCE;
                            }
                        } catch (HealthSystemProviderNotAvailableException e) {
                            HealthSyncJobService healthSyncJobService2 = HealthSyncJobService.this;
                            Logger.logSevere(Logger.defaultTag, healthSyncJobService2.getTag() + ": can not be reached - sync failure", e);
                            HealthSyncJobService.this.jobFinished(this.$jobParameters, false);
                            Unit unit2 = Unit.INSTANCE;
                        }
                    } catch (SecurityException e2) {
                        HealthSyncJobService healthSyncJobService3 = HealthSyncJobService.this;
                        Logger.logSevere(Logger.defaultTag, healthSyncJobService3.getTag() + ": security issue.", e2);
                        HealthSyncJobService.this.jobFinished(this.$jobParameters, false);
                        Unit unit3 = Unit.INSTANCE;
                    }
                } catch (SleepCalendarNotFoundException e3) {
                    HealthSyncJobService healthSyncJobService4 = HealthSyncJobService.this;
                    Logger.logSevere(Logger.defaultTag, healthSyncJobService4.getTag() + ": failure - calendar not found (probably account is changed or missing - try disable/enable calendar integration option)", e3);
                    HealthSyncJobService.this.jobFinished(this.$jobParameters, false);
                    Unit unit4 = Unit.INSTANCE;
                } catch (HealthSynchronizationInterruptedException unused) {
                    HealthSyncJobService healthSyncJobService5 = HealthSyncJobService.this;
                    Logger.logInfo(Logger.defaultTag, healthSyncJobService5.getTag() + ": sync was interrupted", null);
                    HealthSyncJobService.this.jobFinished(this.$jobParameters, true);
                    Unit unit5 = Unit.INSTANCE;
                }
                HealthSyncJobService.this.synchronization = null;
                HealthSyncJobService.this.syncFinished();
                HealthSyncJobService healthSyncJobService6 = HealthSyncJobService.this;
                Logger.logInfo(Logger.defaultTag, healthSyncJobService6.getTag() + ": finished", null);
                this = Unit.INSTANCE;
                return this;
            } catch (Throwable th) {
                HealthSyncJobService.this.synchronization = null;
                HealthSyncJobService.this.syncFinished();
                HealthSyncJobService healthSyncJobService7 = HealthSyncJobService.this;
                Logger.logInfo(Logger.defaultTag, healthSyncJobService7.getTag() + ": finished", null);
                throw th;
            }
        }
    }

    public HealthSyncJobService(HealthServiceProvider healthServiceProvider) {
        healthServiceProvider.getClass();
        this.$$delegate_0 = CoroutineScopeKt.MainScope();
        this.tag = FileInsert$$ExternalSyntheticOutline0.m("HealthSyncJob:", healthServiceProvider.getName());
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public Date getSynchronizeFromDate(boolean importMode) {
        Calendar calendar = Calendar.getInstance();
        if (importMode) {
            calendar.add(1, -3);
        } else {
            calendar.add(6, -14);
        }
        Date time = calendar.getTime();
        time.getClass();
        return time;
    }

    public String getTag() {
        return this.tag;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        jobParameters.getClass();
        Logger.logInfo(Logger.defaultTag, getTag() + ": started ...", null);
        GlobalInitializator.initializeIfRequired(this);
        boolean zContainsKey = jobParameters.getExtras().containsKey("manual");
        boolean zContainsKey2 = jobParameters.getExtras().containsKey("importMode");
        boolean z = jobParameters.getExtras().getBoolean("manual", false);
        boolean z2 = jobParameters.getExtras().getBoolean("importMode", false);
        String str = "launched SYNC (manual:" + z + MqttTopic.TOPIC_LEVEL_SEPARATOR + zContainsKey + ") (importMode:" + z2 + MqttTopic.TOPIC_LEVEL_SEPARATOR + zContainsKey2 + ")";
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
        DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        sleepRecordRepository.getClass();
        this.synchronization = prepareSynchronization(applicationContext, sleepRecordRepository, z, z2);
        Logger.logInfo(Logger.defaultTag, getTag() + ": synchronization prepared", null);
        BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), null, new AnonymousClass1(z2, jobParameters, null), 2, null);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        jobParameters.getClass();
        HealthSynchronization<?> healthSynchronization = this.synchronization;
        if (healthSynchronization != null) {
            healthSynchronization.interrupt();
        }
        return this.synchronization != null;
    }

    public abstract HealthSynchronization<?> prepareSynchronization(Context context, ISleepRecordRepository dbSleepRecordRepository, boolean manual, boolean importMode);

    public abstract void syncFinished();
}
