package com.urbandroid.sleep.service.google.healthconnect;

import android.content.Context;
import android.os.PersistableBundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSyncJobService;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0015J\b\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/service/google/healthconnect/HealthConnectSyncJobService;", "Lcom/urbandroid/sleep/service/health/HealthSyncJobService;", "<init>", "()V", "prepareSynchronization", "Lcom/urbandroid/sleep/service/health/HealthSynchronization;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "dbSleepRecordRepository", "Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;", "manual", "", "importMode", "syncFinished", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class HealthConnectSyncJobService extends HealthSyncJobService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HealthServiceProvider serviceProvider = HealthServiceProvider.HealthConnect.INSTANCE;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/service/google/healthconnect/HealthConnectSyncJobService$Companion;", "", "<init>", "()V", "serviceProvider", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "importMode", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.start(context, z);
        }

        public final void start(Context context, boolean importMode) {
            context.getClass();
            boolean zIsHealthConnect = ContextExtKt.getSettings(context).isHealthConnect();
            Logger.logDebug("Health Connect Service starting ... " + zIsHealthConnect, null);
            if (zIsHealthConnect) {
                HealthSyncJobService.Companion companion = HealthSyncJobService.INSTANCE;
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putBoolean("importMode", importMode);
                Unit unit = Unit.INSTANCE;
                companion.schedule(context, HealthConnectSyncJobService.class, 1021, persistableBundle);
                Logger.logInfo("HealthConnectSyncJobService scheduled", null);
            }
        }

        private Companion() {
        }
    }

    public HealthConnectSyncJobService() {
        super(serviceProvider);
    }

    @Override // com.urbandroid.sleep.service.health.HealthSyncJobService
    public HealthSynchronization<?> prepareSynchronization(Context context, ISleepRecordRepository dbSleepRecordRepository, boolean manual, boolean importMode) {
        context.getClass();
        dbSleepRecordRepository.getClass();
        HealthConnectApi healthConnectApi = new HealthConnectApi(context);
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        HealthConnectSynchronization healthConnectSynchronization = new HealthConnectSynchronization(applicationContext, healthConnectApi, dbSleepRecordRepository);
        healthConnectSynchronization.setManual(manual);
        healthConnectSynchronization.setImportMode(importMode);
        return healthConnectSynchronization;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSyncJobService
    public void syncFinished() {
        Logger.logInfo(Logger.defaultTag, getTag() + ": sync finished", null);
    }
}
