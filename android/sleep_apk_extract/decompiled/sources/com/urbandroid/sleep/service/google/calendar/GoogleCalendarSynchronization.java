package com.urbandroid.sleep.service.google.calendar;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarNotifierKt;
import com.urbandroid.sleep.service.google.calendar.api.GoogleCalendarApi;
import com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendarKt;
import com.urbandroid.sleep.service.google.calendar.session.GoogleCalendarSession;
import com.urbandroid.sleep.service.health.AbstractHealthSynchronization;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.sleep.service.health.HealthSynchronizationDataContext;
import com.urbandroid.sleep.service.health.api.HealthApi;
import com.urbandroid.sleep.service.health.session.HealthSession;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0014J\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J\u0016\u0010!\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0014J\b\u0010#\u001a\u00020\u0019H\u0014J\b\u0010$\u001a\u00020\u001eH\u0014J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001bH\u0014J\b\u0010'\u001a\u00020\u0019H\u0014R\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006("}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/GoogleCalendarSynchronization;", "Lcom/urbandroid/sleep/service/health/AbstractHealthSynchronization;", "Lcom/urbandroid/sleep/service/google/calendar/session/GoogleCalendarSession;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "healthApi", "Lcom/urbandroid/sleep/service/health/api/HealthApi;", "sleepRecordRepository", "Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/service/health/api/HealthApi;Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;)V", "tag", "", "getTag", "()Ljava/lang/String;", "synchronize", "", "from", "Ljava/util/Date;", "listener", "Lcom/urbandroid/sleep/service/health/HealthSynchronization$ProgressListener;", "getServiceProvider", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider$GoogleCalendar;", "isSessionChanged", "", "dbSession", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "session", "synchronizeSportTags", "", "dataContext", "Lcom/urbandroid/sleep/service/health/HealthSynchronizationDataContext;", "synchronizeAwakePhases", "isImportHeartRatesEnabled", "hasDeleteAllSleepHealthRecords", "getMaxEmptyBlockRead", "allowExport", "record", "shouldCleanDuplicates", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleCalendarSynchronization extends AbstractHealthSynchronization<GoogleCalendarSession> implements FeatureLogger {
    private final String tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleCalendarSynchronization(Context context, HealthApi<GoogleCalendarSession> healthApi, ISleepRecordRepository iSleepRecordRepository) {
        super(context, healthApi, iSleepRecordRepository);
        context.getClass();
        healthApi.getClass();
        iSleepRecordRepository.getClass();
        this.tag = "calendar:sync";
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean allowExport(HealthSession record) {
        record.getClass();
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public int getMaxEmptyBlockRead() {
        return 12;
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
    public boolean isImportHeartRatesEnabled() {
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean isSessionChanged(HealthSession dbSession, GoogleCalendarSession session) {
        return (dbSession == null || !Intrinsics.areEqual(dbSession, session) || MathKt.roundToInt(dbSession.getSleepRecord().getRating()) == GoogleCalendarKt.getRating(session.getEvent())) ? false : true;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public boolean shouldCleanDuplicates() {
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization, com.urbandroid.sleep.service.health.HealthSynchronization
    public void synchronize(Date from, HealthSynchronization.ProgressListener listener) {
        from.getClass();
        Object obj = this.healthApi;
        obj.getClass();
        GoogleCalendarApi googleCalendarApi = (GoogleCalendarApi) obj;
        Context context = this.context;
        context.getClass();
        Context context2 = this.context;
        context2.getClass();
        CachedCalendarProviderApi cachedCalendarProviderApi = new CachedCalendarProviderApi(context, new CalendarProviderApi(context2, googleCalendarApi.getAccountName()));
        Context context3 = this.context;
        context3.getClass();
        if (!ContextExtKt.hasConnectivity(context3)) {
            if (listener != null) {
                listener.end(getServiceProvider());
            }
            Logger.logWarning(Logger.defaultTag, getTag() + ": calendar - no network", null);
            return;
        }
        try {
            GoogleCalendar googleCalendarResolveSleepCalendar = JavahelpersKt.resolveSleepCalendar(cachedCalendarProviderApi);
            if (googleCalendarResolveSleepCalendar == null) {
                Logger.logInfo(Logger.defaultTag, getTag() + ": Not able to get or create Sleep as Android calendar", null);
                return;
            }
            String strM = FileInsert$$ExternalSyntheticOutline0.m("Sync started for calendar: ", googleCalendarResolveSleepCalendar.getDisplayName());
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
            googleCalendarApi.setSleepCalendar(googleCalendarResolveSleepCalendar);
            super.synchronize(from, listener);
        } catch (UserRecoverableAuthException e) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": synchronize failure - findSleepCalendars", e);
            Context context4 = this.context;
            context4.getClass();
            GoogleCalendarNotifierKt.calendarPermissionMissingNotification(context4, e);
        }
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public int synchronizeAwakePhases(HealthSynchronizationDataContext<GoogleCalendarSession> dataContext) {
        dataContext.getClass();
        return 0;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public int synchronizeSportTags(HealthSynchronizationDataContext<GoogleCalendarSession> dataContext) {
        dataContext.getClass();
        return 0;
    }

    @Override // com.urbandroid.sleep.service.health.AbstractHealthSynchronization
    public HealthServiceProvider.GoogleCalendar getServiceProvider() {
        return HealthServiceProvider.GoogleCalendar.INSTANCE;
    }
}
