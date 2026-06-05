package com.urbandroid.sleep.service.google.calendar;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.google.calendar.api.GoogleCalendarApi;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSyncJobService;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/GoogleCalendarSyncJobService;", "Lcom/urbandroid/sleep/service/health/HealthSyncJobService;", "<init>", "()V", "prepareSynchronization", "Lcom/urbandroid/sleep/service/health/HealthSynchronization;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "dbSleepRecordRepository", "Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;", "manual", "", "importMode", "syncFinished", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleCalendarSyncJobService extends HealthSyncJobService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HealthServiceProvider serviceProvider = HealthServiceProvider.GoogleCalendar.INSTANCE;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/GoogleCalendarSyncJobService$Companion;", "", "<init>", "()V", "serviceProvider", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(Context context) {
            context.getClass();
            Settings settings = SharedApplicationContext.getSettings();
            if (settings.isGoogleCalendar() && settings.isGoogleCalendarSync()) {
                if (!TrialFilter.getInstance().isGoogleCalendar()) {
                    Logger.logWarning("Google Calendar not installed - synchronization skipped", null);
                } else {
                    HealthSyncJobService.Companion.schedule$default(HealthSyncJobService.INSTANCE, context, GoogleCalendarSyncJobService.class, 1014, null, 8, null);
                    Logger.logInfo("GoogleCalendarSyncJobService scheduled", null);
                }
            }
        }

        private Companion() {
        }
    }

    public GoogleCalendarSyncJobService() {
        super(serviceProvider);
    }

    @Override // com.urbandroid.sleep.service.health.HealthSyncJobService
    public HealthSynchronization<?> prepareSynchronization(Context context, ISleepRecordRepository dbSleepRecordRepository, boolean manual, boolean importMode) {
        context.getClass();
        dbSleepRecordRepository.getClass();
        String googleCalendarAccount = SharedApplicationContext.getSettings().getGoogleCalendarAccount();
        if (googleCalendarAccount != null) {
            GoogleCalendarSynchronization googleCalendarSynchronization = new GoogleCalendarSynchronization(context, new GoogleCalendarApi(context, googleCalendarAccount), dbSleepRecordRepository);
            googleCalendarSynchronization.setManual(manual);
            googleCalendarSynchronization.setImportMode(importMode);
            return googleCalendarSynchronization;
        }
        Logger.logWarning(Logger.defaultTag, getTag() + ": account not found at preferences", null);
        return null;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSyncJobService
    public void syncFinished() {
    }
}
