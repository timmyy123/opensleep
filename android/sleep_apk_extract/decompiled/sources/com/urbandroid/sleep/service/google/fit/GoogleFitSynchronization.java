package com.urbandroid.sleep.service.google.fit;

import android.app.Activity;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitApi;
import com.urbandroid.sleep.service.google.fit.session.GoogleFitSession;
import com.urbandroid.sleep.service.health.AbstractHealthSynchronization;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSynchronizationDataContext;
import com.urbandroid.sleep.service.health.HealthSynchronizationDataContextWrapper;
import com.urbandroid.sleep.service.health.HeathSyncKt;
import com.urbandroid.sleep.service.health.api.HealthApi;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.HealthSessionSegment;
import com.urbandroid.util.SleepPermissionCompat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB'\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0017\u0010\u0014J\u001d\u0010\u001b\u001a\u00020\u001a2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\u00020\u001d2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0012H\u0014¢\u0006\u0004\b \u0010\u0014J\u001f\u0010$\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0002H\u0014¢\u0006\u0004\b$\u0010%R\u001a\u0010'\u001a\u00020&8\u0016X\u0096D¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0011\u00103\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/urbandroid/sleep/service/google/fit/GoogleFitSynchronization;", "Lcom/urbandroid/sleep/service/health/AbstractHealthSynchronization;", "Lcom/urbandroid/sleep/service/google/fit/session/GoogleFitSession;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/service/health/api/HealthApi;", "healthApi", "Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;", "sleepRecordRepository", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/service/health/api/HealthApi;Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;)V", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;Lcom/urbandroid/sleep/service/health/api/HealthApi;Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;)V", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "getServiceProvider", "()Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "", "hasDeleteAllSleepHealthRecords", "()Z", "isImportHeartRatesEnabled", "isExportSPO2sSupported", "isExportHeartRatesSupported", "Lcom/urbandroid/sleep/service/health/HealthSynchronizationDataContext;", "dataContext", "", "synchronizeSportTags", "(Lcom/urbandroid/sleep/service/health/HealthSynchronizationDataContext;)I", "", "synchronizeHeartRates", "(Lcom/urbandroid/sleep/service/health/HealthSynchronizationDataContext;)V", "cleanUpOverlapsWithCloudTag", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "dbSession", "session", "isSessionChanged", "(Lcom/urbandroid/sleep/service/health/session/HealthSession;Lcom/urbandroid/sleep/service/google/fit/session/GoogleFitSession;)Z", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "serviceProvider", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "Lcom/urbandroid/sleep/service/google/fit/api/GoogleFitApi;", "api", "Lcom/urbandroid/sleep/service/google/fit/api/GoogleFitApi;", "Ljava/util/Calendar;", "getCurrentDate", "()Ljava/util/Calendar;", "currentDate", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class GoogleFitSynchronization extends AbstractHealthSynchronization<GoogleFitSession> implements FeatureLogger {
    private final GoogleFitApi api;
    private final HealthServiceProvider serviceProvider;
    private final String tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitSynchronization(Context context, HealthApi<GoogleFitSession> healthApi, ISleepRecordRepository iSleepRecordRepository) {
        super(context, healthApi, iSleepRecordRepository);
        context.getClass();
        healthApi.getClass();
        iSleepRecordRepository.getClass();
        this.tag = "sync:fit";
        this.serviceProvider = HealthServiceProvider.GoogleFit.INSTANCE;
        Object obj = this.healthApi;
        obj.getClass();
        this.api = (GoogleFitApi) obj;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean cleanUpOverlapsWithCloudTag() {
        return true;
    }

    public final Calendar getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.getClass();
        return calendar;
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
        return Environment.isMOrGreater();
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean isExportSPO2sSupported() {
        return isImportHeartRatesEnabled();
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean isImportHeartRatesEnabled() {
        return Environment.isMOrGreater();
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean isSessionChanged(HealthSession dbSession, GoogleFitSession session) {
        dbSession.getClass();
        session.getClass();
        int size = dbSession.getSegments().size();
        int size2 = HeathSyncKt.nonNull(session.getSegments()).size();
        if (size2 != size) {
            String str = session.getId() + " diff seg size: " + size + " / " + size2;
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + str, null);
        }
        Iterable indices = CollectionsKt.getIndices(dbSession.getSegments());
        if ((indices instanceof Collection) && ((Collection) indices).isEmpty()) {
            return false;
        }
        Iterator it = indices.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            HealthSessionSegment healthSessionSegment = dbSession.getSegments().get(iNextInt);
            HealthSessionSegment healthSessionSegment2 = (HealthSessionSegment) CollectionsKt.getOrNull(session.getSegments(), iNextInt);
            if (healthSessionSegment2 == null || healthSessionSegment.getSleepSegmentType() != healthSessionSegment2.getSleepSegmentType() || healthSessionSegment.getFromInMillis() != healthSessionSegment2.getFromInMillis() || healthSessionSegment.getToInMillis() != healthSessionSegment2.getToInMillis()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public void synchronizeHeartRates(HealthSynchronizationDataContext<GoogleFitSession> context) {
        context.getClass();
        SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
        Context context2 = this.context;
        context2.getClass();
        boolean zIsPermissionGranted = sleepPermissionCompat.isPermissionGranted(context2, "android.permission.BODY_SENSORS");
        String str = "isImportHeartRatesEnabled: " + isImportHeartRatesEnabled();
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + str, null);
        boolean zIsExportHeartRatesSupported = isExportHeartRatesSupported();
        StringBuilder sb = new StringBuilder("isExportHeartRatesSupported: ");
        sb.append(zIsExportHeartRatesSupported);
        String string = sb.toString();
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + string, null);
        StringBuilder sb2 = new StringBuilder("bodySensorsPermissionGranted: ");
        sb2.append(zIsPermissionGranted);
        String string2 = sb2.toString();
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + string2, null);
        if (isImportHeartRatesEnabled() || isExportHeartRatesSupported()) {
            if (!Environment.isMOrGreater() || zIsPermissionGranted) {
                super.synchronizeHeartRates(new HealthSynchronizationDataContextWrapper<GoogleFitSession>(context) { // from class: com.urbandroid.sleep.service.google.fit.GoogleFitSynchronization.synchronizeHeartRates.1
                    @Override // com.urbandroid.sleep.service.health.HealthSynchronizationDataContextWrapper, com.urbandroid.sleep.service.health.HealthSynchronizationDataContext
                    public Date getFrom() {
                        Date from = super.getFrom();
                        Calendar currentDate = this.getCurrentDate();
                        currentDate.add(6, -3);
                        if (!from.before(currentDate.getTime())) {
                            return from;
                        }
                        Date time = currentDate.getTime();
                        time.getClass();
                        return time;
                    }
                });
            }
        }
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public int synchronizeSportTags(HealthSynchronizationDataContext<GoogleFitSession> dataContext) {
        dataContext.getClass();
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitSynchronization(Activity activity, HealthApi<GoogleFitSession> healthApi, ISleepRecordRepository iSleepRecordRepository) {
        super(activity, (HealthApi) healthApi, iSleepRecordRepository);
        activity.getClass();
        healthApi.getClass();
        iSleepRecordRepository.getClass();
        this.tag = "sync:fit";
        this.serviceProvider = HealthServiceProvider.GoogleFit.INSTANCE;
        Object obj = this.healthApi;
        obj.getClass();
        this.api = (GoogleFitApi) obj;
    }
}
