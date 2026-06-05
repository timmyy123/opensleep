package com.urbandroid.sleep.service.google.healthconnect;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.google.healthconnect.api.HealthConnectApi;
import com.urbandroid.sleep.service.google.healthconnect.session.HealthConnectSession;
import com.urbandroid.sleep.service.health.AbstractHealthSynchronization;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.api.HealthApi;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014R\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/urbandroid/sleep/service/google/healthconnect/HealthConnectSynchronization;", "Lcom/urbandroid/sleep/service/health/AbstractHealthSynchronization;", "Lcom/urbandroid/sleep/service/google/healthconnect/session/HealthConnectSession;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "healthApi", "Lcom/urbandroid/sleep/service/health/api/HealthApi;", "sleepRecordRepository", "Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/service/health/api/HealthApi;Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;)V", "tag", "", "getTag", "()Ljava/lang/String;", "serviceProvider", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "getServiceProvider", "hasDeleteAllSleepHealthRecords", "", "isImportHeartRatesEnabled", "isExportHeartRatesSupported", "isImportSPO2sSupported", "isExportSPO2sSupported", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class HealthConnectSynchronization extends AbstractHealthSynchronization<HealthConnectSession> implements FeatureLogger {
    private final HealthServiceProvider serviceProvider;
    private final String tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthConnectSynchronization(Context context, HealthApi<HealthConnectSession> healthApi, ISleepRecordRepository iSleepRecordRepository) {
        super(context, healthApi, iSleepRecordRepository);
        context.getClass();
        healthApi.getClass();
        iSleepRecordRepository.getClass();
        this.tag = "sync:health-connect";
        this.serviceProvider = HealthServiceProvider.HealthConnect.INSTANCE;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public HealthServiceProvider getServiceProvider() {
        return this.serviceProvider;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean hasDeleteAllSleepHealthRecords() {
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean isExportHeartRatesSupported() {
        return isImportHeartRatesEnabled();
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean isExportSPO2sSupported() {
        return isImportSPO2sSupported();
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean isImportHeartRatesEnabled() {
        if (!Environment.isMOrGreater()) {
            return false;
        }
        Object obj = this.healthApi;
        obj.getClass();
        return ((HealthConnectApi) obj).hasHrPermissions();
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean isImportSPO2sSupported() {
        if (!Environment.isMOrGreater()) {
            return false;
        }
        Object obj = this.healthApi;
        obj.getClass();
        return ((HealthConnectApi) obj).hasSpo2Permissions();
    }
}
