package com.urbandroid.sleep.service.samsung.shealth;

import android.content.Context;
import android.os.Handler;
import android.os.PersistableBundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSyncJobService;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.sleep.service.samsung.shealth.api.SamsungSHealthApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/service/samsung/shealth/SamsungSHealthSyncJobService;", "Lcom/urbandroid/sleep/service/health/HealthSyncJobService;", "<init>", "()V", "handler", "Landroid/os/Handler;", "prepareSynchronization", "Lcom/urbandroid/sleep/service/health/HealthSynchronization;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "dbSleepRecordRepository", "Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;", "manual", "", "importMode", "syncFinished", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SamsungSHealthSyncJobService extends HealthSyncJobService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HealthServiceProvider serviceProvider = HealthServiceProvider.SamsungSHealth.INSTANCE;
    private final Handler handler;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/service/samsung/shealth/SamsungSHealthSyncJobService$Companion;", "", "<init>", "()V", "serviceProvider", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "importMode", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
            boolean z = TrialFilter.getInstance().isSamsungSHealth() && ContextExtKt.getSettings(context).isSamsungSHealth();
            Logger.logDebug("Samsung S Health Service starting ... " + z, null);
            if (z) {
                HealthSyncJobService.Companion companion = HealthSyncJobService.INSTANCE;
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putBoolean("importMode", importMode);
                Unit unit = Unit.INSTANCE;
                companion.schedule(context, SamsungSHealthSyncJobService.class, 1013, persistableBundle);
                Logger.logInfo("SamsungSHealthSyncJobService scheduled", null);
            }
        }

        private Companion() {
        }

        public final void start(Context context) {
            context.getClass();
            start$default(this, context, false, 2, null);
        }
    }

    public SamsungSHealthSyncJobService() {
        super(serviceProvider);
        this.handler = new Handler();
    }

    public static final void start(Context context) {
        INSTANCE.start(context);
    }

    @Override // com.urbandroid.sleep.service.health.HealthSyncJobService
    public HealthSynchronization<?> prepareSynchronization(Context context, ISleepRecordRepository dbSleepRecordRepository, boolean manual, boolean importMode) {
        context.getClass();
        dbSleepRecordRepository.getClass();
        SamsungSHealthSynchronization samsungSHealthSynchronization = new SamsungSHealthSynchronization(getApplicationContext(), new SamsungSHealthApi(context, this.handler, new NotifySHealthConnectionCallback(context), false), dbSleepRecordRepository);
        samsungSHealthSynchronization.setManual(manual);
        samsungSHealthSynchronization.setImportMode(importMode);
        return samsungSHealthSynchronization;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSyncJobService
    public void syncFinished() {
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        ContextExtKt.getSettings(applicationContext).setSamsungSHealthSyncLastTimestamp(System.currentTimeMillis());
    }
}
