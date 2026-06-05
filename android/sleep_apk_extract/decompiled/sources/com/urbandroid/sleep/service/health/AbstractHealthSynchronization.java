package com.urbandroid.sleep.service.health;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import com.facebook.AuthenticationTokenClaims;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.string.Joiner;
import com.urbandroid.sleep.SleeprecordExtKt;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.Events;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.EventInterval;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.service.google.calendar.CalendarKt;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitSessionPostMerger;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.sleep.service.health.SensorSynchronization;
import com.urbandroid.sleep.service.health.api.HealthApi;
import com.urbandroid.sleep.service.health.api.HealthUserProfile;
import com.urbandroid.sleep.service.health.session.HealthIntervalKt;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.HealthSessionMapper;
import com.urbandroid.sleep.service.health.session.HealthSessionTransformer;
import com.urbandroid.sleep.service.health.session.HealthSessionUtil;
import com.urbandroid.sleep.service.health.session.SleepRecordHealthSession;
import com.urbandroid.sleep.service.health.session.WalkingSensorSession;
import com.urbandroid.sleep.service.health.session.WalkingSensorSessionContainer;
import com.urbandroid.sleep.service.health.session.filter.ActivityTypeFilter;
import com.urbandroid.sleep.service.health.session.filter.HealthSessionDurationFilter;
import com.urbandroid.sleep.service.health.session.filter.HealthSessionFilter;
import com.urbandroid.sleep.service.health.session.filter.HealthSessionPackageFilter;
import com.urbandroid.sleep.service.health.session.filter.HealthSessionRangeFilter;
import com.urbandroid.sleep.service.health.session.filter.NotFilter;
import com.urbandroid.util.DateUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.achartengine.chart.TimeChart;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractHealthSynchronization<S extends HealthSession> implements HealthSynchronization<S> {
    private static final long HOURS16_IN_MILLIS = 57600000;
    protected final Activity activity;
    protected final Context context;
    private final SimpleDateFormat format;
    protected final HealthApi<S> healthApi;
    protected boolean importMode;
    private final AtomicBoolean isInterrupted;
    private final AtomicBoolean isRunning;
    protected boolean manual;
    private final HealthSessionFilter notOurPackageFilter;
    private final HealthSessionFilter ourPackageFilter;
    protected final ISleepRecordRepository sleepRecordRepository;

    public static class NullProgressListener implements HealthSynchronization.ProgressListener {
        public /* synthetic */ NullProgressListener(int i) {
            this();
        }

        @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
        public void end(HealthServiceProvider healthServiceProvider, HealthSynchronization.ProgressListener.Event event) {
            Logger.logDebug(healthServiceProvider.getName() + " END: " + event.name());
        }

        @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
        public void progress(HealthServiceProvider healthServiceProvider, int i, int i2) {
            Logger.logDebug(healthServiceProvider.getName() + " PROGRESS: " + i + MqttTopic.TOPIC_LEVEL_SEPARATOR + i2);
        }

        @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
        public void start(HealthServiceProvider healthServiceProvider, HealthSynchronization.ProgressListener.Event event, int i) {
            Logger.logDebug(healthServiceProvider.getName() + " START: " + event.name() + "[" + i + "]");
        }

        private NullProgressListener() {
        }

        @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
        public void end(HealthServiceProvider healthServiceProvider) {
        }

        @Override // com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener
        public void start(HealthServiceProvider healthServiceProvider) {
        }
    }

    public AbstractHealthSynchronization(Activity activity, HealthApi<S> healthApi, ISleepRecordRepository iSleepRecordRepository) {
        this.format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.isInterrupted = new AtomicBoolean(false);
        this.isRunning = new AtomicBoolean(false);
        this.manual = false;
        this.importMode = false;
        this.activity = activity;
        this.context = activity.getApplicationContext();
        this.healthApi = healthApi;
        this.sleepRecordRepository = iSleepRecordRepository;
        HealthSessionPackageFilter healthSessionPackageFilter = new HealthSessionPackageFilter(activity.getApplicationContext().getPackageName());
        this.ourPackageFilter = healthSessionPackageFilter;
        this.notOurPackageFilter = new NotFilter(healthSessionPackageFilter);
    }

    private boolean addSportTag(HealthSession healthSession, HealthSession healthSession2, Collection<S> collection) {
        long fromInMillis = healthSession2.getFromInMillis() - HOURS16_IN_MILLIS;
        if (healthSession != null) {
            fromInMillis = Math.max(fromInMillis, healthSession.getToInMillis());
        }
        final Interval interval = new Interval(fromInMillis, healthSession2.getToInMillis());
        final AtomicLong atomicLong = new AtomicLong(0L);
        new HealthSessionTransformer(collection).filter(new HealthSessionRangeFilter(interval, true)).filter(new HealthSessionDurationFilter(Long.valueOf(AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED), null)).map(new HealthSessionMapper() { // from class: com.urbandroid.sleep.service.health.AbstractHealthSynchronization.8
            @Override // com.urbandroid.sleep.service.health.session.HealthSessionMapper
            public HealthSession map(HealthSession healthSession3) {
                return healthSession3.toCutSession(interval);
            }
        }).subscribe(new HealthSessionTransformer.Action() { // from class: com.urbandroid.sleep.service.health.AbstractHealthSynchronization.7
            @Override // com.urbandroid.sleep.service.health.session.HealthSessionTransformer.Action
            public void next(HealthSession healthSession3) {
                atomicLong.getAndAdd(HealthIntervalKt.getDuration(healthSession3));
            }
        });
        long j = atomicLong.get() / 3600000;
        if (j <= 0) {
            return false;
        }
        Logger.logInfo(getServiceProvider().getName() + ": " + interval + " TOTAL SPORT MILLIS: " + atomicLong.get());
        SleepRecord sleepRecordLoadFullRecord = this.sleepRecordRepository.loadFullRecord(healthSession2.getSleepRecord().getFrom().getTime());
        if (sleepRecordLoadFullRecord == null) {
            return false;
        }
        sleepRecordLoadFullRecord.addTag(Tag.SPORT, (int) j);
        this.sleepRecordRepository.addNewSleepRecord(sleepRecordLoadFullRecord);
        return true;
    }

    private String format(Interval interval) {
        return "[" + this.format.format(new Date(interval.getFrom())) + " - " + this.format.format(new Date(interval.getTo())) + "]";
    }

    private boolean hasOverlap(Interval interval) {
        for (SleepRecord sleepRecord : this.sleepRecordRepository.getSleepRecords(interval.getFrom() - 14400000, 14400000 + interval.getTo(), false)) {
            if (!sleepRecord.hasTag(Tag.CLOUD) && (sleepRecord.getFromTime() != interval.getFrom() || sleepRecord.getToTime() != interval.getTo())) {
                if (interval.hasIntersection(new Interval(sleepRecord.getFrom(), sleepRecord.getTo()))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean insertSensorWalkingSession(HealthSession healthSession, SleepRecord sleepRecord) {
        if (sleepRecord == null || !insertWalkingEvent(sleepRecord, healthSession)) {
            return false;
        }
        int steps = healthSession instanceof WalkingSensorSession ? ((WalkingSensorSession) healthSession).getSteps() : -1;
        StringBuilder sb = new StringBuilder("Walking events added: ");
        sb.append(format(healthSession.toWalkingEventInterval().toInterval()));
        sb.append(steps != -1 ? FileInsert$$ExternalSyntheticOutline0.m(steps, " steps: ") : "");
        sb.append(" into sleep record:");
        sb.append(this.format.format(sleepRecord.getFrom()));
        Logger.logInfo(sb.toString());
        return true;
    }

    private boolean insertWalkingEvent(SleepRecord sleepRecord, HealthSession healthSession) {
        Events events = sleepRecord.getEvents();
        EventInterval walkingEventInterval = healthSession.toWalkingEventInterval();
        Event from = walkingEventInterval.getFrom();
        Event to = walkingEventInterval.getTo();
        if (events.hasLabel(from.getTimestamp(), to.getTimestamp(), EventLabel.WALKING_START, EventLabel.WALKING_END)) {
            return false;
        }
        events.addEvent(from);
        events.addEvent(to);
        return true;
    }

    private boolean insertWalkingSession(HealthSession healthSession, SleepRecord sleepRecord) {
        SleepRecord sleepRecordLoadFullRecord;
        if (sleepRecord == null || (sleepRecordLoadFullRecord = this.sleepRecordRepository.loadFullRecord(sleepRecord.getFrom().getTime())) == null || !insertWalkingEvent(sleepRecordLoadFullRecord, healthSession)) {
            return false;
        }
        sleepRecordLoadFullRecord.computeLenAdjust();
        this.sleepRecordRepository.addNewSleepRecord(sleepRecordLoadFullRecord);
        Logger.logDebug("Walking events added: " + format(healthSession.toWalkingEventInterval().toInterval()) + " into sleep record:" + this.format.format(sleepRecordLoadFullRecord.getFrom()) + " " + this.format.format(sleepRecordLoadFullRecord.getTo()));
        return true;
    }

    private void postSynchronizeSteps(HealthSession healthSession) {
        WalkingSensorSessionContainer<?> stepsData = this.healthApi.readStepsData(healthSession);
        if (stepsData == null) {
            return;
        }
        processWalkingSensorSessions(healthSession, stepsData.getWalkingSessions());
    }

    private int processWalkingSensorSessions(HealthSession healthSession, Collection<WalkingSensorSession> collection) {
        int i = 0;
        if (collection != null && !collection.isEmpty()) {
            SleepRecord sleepRecordLoadFullRecord = this.sleepRecordRepository.loadFullRecord(healthSession.getSleepRecord().getFrom().getTime());
            for (WalkingSensorSession walkingSensorSession : collection) {
                if (walkingSensorSession.getSteps() < 5) {
                    Logger.logDebug("Ignored (steps<5): " + walkingSensorSession);
                } else if (insertSensorWalkingSession(walkingSensorSession, sleepRecordLoadFullRecord)) {
                    i++;
                }
            }
            if (i > 0) {
                sleepRecordLoadFullRecord.computeLenAdjust();
                this.sleepRecordRepository.addNewSleepRecord(sleepRecordLoadFullRecord);
            }
        }
        return i;
    }

    public boolean allowExport(HealthSession healthSession) {
        return !healthSession.getSleepRecord().hasTag(Tag.CLOUD);
    }

    public void applyLatestInsertedTimestamp(long j) {
    }

    public boolean cleanUpOverlapsWithCloudTag() {
        return false;
    }

    public long differenceInDays(Calendar calendar, Calendar calendar2) {
        return (calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / TimeChart.DAY;
    }

    public int getMaxEmptyBlockRead() {
        return 12;
    }

    public abstract HealthServiceProvider getServiceProvider();

    public abstract boolean hasDeleteAllSleepHealthRecords();

    @Override // com.urbandroid.sleep.service.health.HealthSynchronization
    @Deprecated
    public void interrupt() {
        if (!this.isRunning.get() || this.isInterrupted.get()) {
            Logger.logInfo(getClass().getSimpleName().concat(" was not interrupted since it is already interrupted or sync is not running at all"));
        } else {
            Logger.logInfo(getClass().getSimpleName().concat(" will be soon interrupted"));
            this.isInterrupted.set(true);
        }
    }

    public boolean isExportHeartRatesSupported() {
        return false;
    }

    public boolean isExportSPO2sSupported() {
        return false;
    }

    public abstract boolean isImportHeartRatesEnabled();

    public boolean isImportSPO2sSupported() {
        return false;
    }

    public boolean isImportWalkingStepsEnabled() {
        return false;
    }

    public boolean isInterrupted() {
        return this.isInterrupted.get();
    }

    public boolean isSessionChanged(HealthSession healthSession, S s) {
        return false;
    }

    public HealthSynchronizationDataContext<S> prepareDataContext(Activity activity, Date date, List<HealthSession> list, final HealthSynchronization.ProgressListener progressListener) {
        Collection<S> healthSessions = readHealthSessions(date, progressListener);
        int size = healthSessions.size();
        if (isInterrupted()) {
            throw new HealthSynchronizationInterruptedException();
        }
        List listFilter = HealthSessionUtil.filter(healthSessions, this.notOurPackageFilter);
        Collection<S> collectionFilter = HealthSessionUtil.filter(healthSessions, this.ourPackageFilter);
        boolean zHasDeleteAllSleepHealthRecords = hasDeleteAllSleepHealthRecords();
        Logger.logInfo(getServiceProvider().getName() + ": Delete All Sleep Health Records: " + zHasDeleteAllSleepHealthRecords);
        final int size2 = collectionFilter.size();
        if (zHasDeleteAllSleepHealthRecords && size2 > 0) {
            HealthServiceProvider serviceProvider = getServiceProvider();
            HealthSynchronization.ProgressListener.Event event = HealthSynchronization.ProgressListener.Event.HEALTH_DELETE;
            progressListener.start(serviceProvider, event, size2);
            this.healthApi.delete(collectionFilter, new HealthApi.Listener() { // from class: com.urbandroid.sleep.service.health.AbstractHealthSynchronization.1
                @Override // com.urbandroid.sleep.service.health.api.HealthApi.Listener
                public void deleted(int i) {
                    progressListener.progress(AbstractHealthSynchronization.this.getServiceProvider(), i, size2);
                }
            });
            progressListener.end(getServiceProvider(), event);
            if (isInterrupted()) {
                throw new HealthSynchronizationInterruptedException();
            }
            size -= size2;
            collectionFilter = new ArrayList<>();
        }
        Collection<S> collection = collectionFilter;
        Logger.logInfo(getServiceProvider().getName() + " sessions found: total=" + size + " ours=" + collection.size() + " others=" + listFilter.size());
        return new BaseHealthSynchronizationDataContext(activity, progressListener, date, list, collection, listFilter);
    }

    public Collection<S> readHealthSessions(Date date, HealthSynchronization.ProgressListener progressListener) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = 0;
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(14, 0);
        Logger.logDebug(getServiceProvider().getName() + " start: " + CalendarKt.prettyDate(calendar.getTimeInMillis()) + " end: " + CalendarKt.prettyDate(calendar2.getTimeInMillis()));
        long jDifferenceInDays = differenceInDays(calendar, calendar2);
        ArrayList arrayList = new ArrayList();
        int i2 = (int) (jDifferenceInDays / 14);
        progressListener.start(getServiceProvider(), HealthSynchronization.ProgressListener.Event.HEALTH_READ, i2);
        Calendar calendar3 = (Calendar) calendar2.clone();
        Calendar calendar4 = (Calendar) calendar2.clone();
        calendar4.add(6, -14);
        if (calendar4.before(calendar)) {
            calendar4 = (Calendar) calendar.clone();
        }
        int i3 = i2;
        do {
            Collection<S> collectionFind = this.healthApi.find(HeathSyncKt.add(calendar4.getTime(), -24), HeathSyncKt.add(calendar3.getTime(), 24));
            Collection collectionFilterAfter = HeathSyncKt.filterAfter(collectionFind, calendar.getTimeInMillis());
            Logger.logDebug(getServiceProvider().getName() + " Session Block read: " + this.format.format(calendar4.getTime()) + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.format.format(calendar3.getTime()) + " found:" + collectionFilterAfter.size() + MqttTopic.TOPIC_LEVEL_SEPARATOR + collectionFind.size());
            HeathSyncKt.addIfMissing(arrayList, collectionFilterAfter);
            i3 += -1;
            progressListener.progress(getServiceProvider(), i2 - i3, i2);
            if (!collectionFilterAfter.isEmpty() || (i = i + 1) != getMaxEmptyBlockRead()) {
                calendar3 = (Calendar) calendar4.clone();
                calendar4.add(6, -14);
                if (calendar3.getTimeInMillis() <= calendar.getTimeInMillis()) {
                    break;
                }
            } else {
                break;
            }
        } while (!isInterrupted());
        progressListener.end(getServiceProvider(), HealthSynchronization.ProgressListener.Event.HEALTH_READ);
        if (isInterrupted()) {
            throw new HealthSynchronizationInterruptedException();
        }
        Collections.sort(arrayList, new Comparator<S>() { // from class: com.urbandroid.sleep.service.health.AbstractHealthSynchronization.2
            @Override // java.util.Comparator
            public int compare(S s, S s2) {
                if (s.equals(s2)) {
                    return 0;
                }
                return Long.valueOf(s.getFromInMillis()).compareTo(Long.valueOf(s2.getFromInMillis()));
            }
        });
        return arrayList;
    }

    public List<HealthSession> readSleepRecords(Date date, HealthSynchronization.ProgressListener progressListener, Date date2) {
        ArrayList arrayList = new ArrayList();
        List<SleepRecord> syncRecords = HeathSyncKt.readSyncRecords(this.sleepRecordRepository, date.getTime(), date2.getTime() + 7200000);
        progressListener.start(getServiceProvider(), HealthSynchronization.ProgressListener.Event.LOCAL_DB_READ, syncRecords.size());
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (SleepRecord sleepRecord : syncRecords) {
            if (!sleepRecord.isFinished()) {
                if (sleepRecord.getFromTime() >= jCurrentTimeMillis - TimeChart.DAY) {
                    Logger.logWarning(getServiceProvider().getName() + ": record not finished " + sleepRecord.toString());
                } else {
                    sleepRecord.finish(sleepRecord.getTo());
                    this.sleepRecordRepository.addNewSleepRecord(sleepRecord);
                }
            }
            arrayList.add(new SleepRecordHealthSession(sleepRecord, this.healthApi.getIdResolver()));
            if (isInterrupted()) {
                throw new HealthSynchronizationInterruptedException();
            }
            progressListener.progress(getServiceProvider(), i, syncRecords.size());
            i++;
        }
        progressListener.end(getServiceProvider(), HealthSynchronization.ProgressListener.Event.LOCAL_DB_READ);
        return arrayList;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronization
    public void setImportMode(boolean z) {
        this.importMode = z;
    }

    @Override // com.urbandroid.sleep.service.health.HealthSynchronization
    public void setManual(boolean z) {
        this.manual = z;
    }

    public boolean shouldCleanDuplicates() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.sleep.service.health.HealthSynchronization
    public void synchronize(Date date, HealthSynchronization.ProgressListener progressListener) {
        HealthSynchronization.ProgressListener.Event event;
        boolean z = false;
        Object[] objArr = 0;
        boolean z2 = false;
        boolean z3 = false;
        if (progressListener == null) {
            progressListener = new NullProgressListener(objArr == true ? 1 : 0);
        }
        SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSyncStarted(getServiceProvider().toIntegration());
        progressListener.start(getServiceProvider());
        try {
            Logger.logDebug("Starting " + getServiceProvider() + " synchronization from:" + this.format.format(date) + " importMode: " + this.importMode);
            this.isRunning.set(true);
            List<HealthSession> sleepRecords = readSleepRecords(date, progressListener, Calendar.getInstance().getTime());
            Logger.logInfo(getServiceProvider().getName() + ": sleep records found: " + sleepRecords.size());
            if (sleepRecords.size() == 0) {
                getServiceProvider().setCachedRecordCount(0);
            }
            if (isInterrupted()) {
                throw new HealthSynchronizationInterruptedException();
            }
            HealthServiceProvider serviceProvider = getServiceProvider();
            HealthSynchronization.ProgressListener.Event event2 = HealthSynchronization.ProgressListener.Event.HEALTH_CONNECT;
            progressListener.start(serviceProvider, event2, 0);
            if (this.healthApi.connect()) {
                progressListener.end(getServiceProvider(), event2);
                HealthSynchronizationDataContext<S> healthSynchronizationDataContextPrepareDataContext = prepareDataContext(this.activity, date, sleepRecords, progressListener);
                if (isInterrupted()) {
                    throw new HealthSynchronizationInterruptedException();
                }
                synchronizeSessions(healthSynchronizationDataContextPrepareDataContext);
                Logger.logInfo(getServiceProvider().getName() + ": Sessions synchronized");
                if (new Settings(this.context).isImplicitTagsEnabled()) {
                    Logger.logInfo(getServiceProvider().getName() + ": " + synchronizeSportTags(healthSynchronizationDataContextPrepareDataContext) + " Sport tags synchronized");
                }
                Logger.logInfo(getServiceProvider().getName() + ": ImportWalkingStepsEnabled:" + isImportWalkingStepsEnabled());
                synchronizeAwakePhases(healthSynchronizationDataContextPrepareDataContext);
                synchronizeHeartRates(healthSynchronizationDataContextPrepareDataContext);
                synchronizeSPO2(healthSynchronizationDataContextPrepareDataContext);
                synchronizeUserProfile(healthSynchronizationDataContextPrepareDataContext);
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSyncFinishedSuccessfully(getServiceProvider().toIntegration());
                try {
                    HealthServiceProvider serviceProvider2 = getServiceProvider();
                    event = HealthSynchronization.ProgressListener.Event.HEALTH_DISCONNECT;
                    progressListener.start(serviceProvider2, event, 0);
                    this.healthApi.disconnect();
                } finally {
                }
            } else {
                try {
                    HealthServiceProvider serviceProvider3 = getServiceProvider();
                    event = HealthSynchronization.ProgressListener.Event.HEALTH_DISCONNECT;
                    progressListener.start(serviceProvider3, event, 0);
                    this.healthApi.disconnect();
                } finally {
                }
            }
            this.isRunning.set(false);
            progressListener.end(getServiceProvider(), event);
            progressListener.end(getServiceProvider());
            zza$$ExternalSyntheticOutline0.m(this.context, "com.urbandroid.sleep.ACTION_GRAPH_CHANGED");
        } catch (Throwable th) {
            try {
                HealthServiceProvider serviceProvider4 = getServiceProvider();
                HealthSynchronization.ProgressListener.Event event3 = HealthSynchronization.ProgressListener.Event.HEALTH_DISCONNECT;
                progressListener.start(serviceProvider4, event3, 0);
                this.healthApi.disconnect();
                this.isRunning.set(false);
                progressListener.end(getServiceProvider(), event3);
                progressListener.end(getServiceProvider());
                zza$$ExternalSyntheticOutline0.m(this.context, "com.urbandroid.sleep.ACTION_GRAPH_CHANGED");
                throw th;
            } finally {
            }
        }
    }

    public int synchronizeAwakePhases(HealthSynchronizationDataContext<S> healthSynchronizationDataContext) {
        HealthSynchronization.ProgressListener listener = healthSynchronizationDataContext.getListener();
        List<HealthSession> sleepRecords = healthSynchronizationDataContext.getSleepRecords();
        HealthServiceProvider serviceProvider = getServiceProvider();
        HealthSynchronization.ProgressListener.Event event = HealthSynchronization.ProgressListener.Event.WALKING_AWAKE_PHASE_INSERT;
        listener.start(serviceProvider, event, sleepRecords.size());
        try {
            int i = 0;
            if (!isImportWalkingStepsEnabled()) {
                listener.end(getServiceProvider(), event);
                return 0;
            }
            List<HealthSession> listFilter = HealthSessionUtil.filter(healthSynchronizationDataContext.getOtherAppsHealthSessions(), ActivityTypeFilter.WALKING);
            if (listFilter != null && !listFilter.isEmpty()) {
                Logger.logInfo("Walking sessions found: " + listFilter);
                int i2 = 0;
                for (HealthSession healthSession : sleepRecords) {
                    for (HealthSession healthSession2 : listFilter) {
                        long length = HealthIntervalKt.toInterval(healthSession2).getLength();
                        if (length > 60000 && length < 3600000 && HealthIntervalKt.hasIntersection(healthSession2, healthSession) && insertWalkingSession(healthSession2, healthSession.getSleepRecord())) {
                            i++;
                        }
                    }
                    listener.progress(getServiceProvider(), i2, sleepRecords.size());
                    i2++;
                }
            }
            Logger.logInfo(getServiceProvider().getName() + ": " + i + " awake phases synchronized");
            listener.end(getServiceProvider(), HealthSynchronization.ProgressListener.Event.WALKING_AWAKE_PHASE_INSERT);
            return i;
        } catch (Throwable th) {
            listener.end(getServiceProvider(), HealthSynchronization.ProgressListener.Event.WALKING_AWAKE_PHASE_INSERT);
            throw th;
        }
    }

    public void synchronizeHeartRates(HealthSynchronizationDataContext<S> healthSynchronizationDataContext) {
        new SensorSynchronization(getServiceProvider(), this.healthApi, this.sleepRecordRepository).sync(healthSynchronizationDataContext, SensorSynchronization.Type.HR, isImportHeartRatesEnabled(), isExportHeartRatesSupported());
    }

    public void synchronizeSPO2(HealthSynchronizationDataContext<S> healthSynchronizationDataContext) {
        new SensorSynchronization(getServiceProvider(), this.healthApi, this.sleepRecordRepository).sync(healthSynchronizationDataContext, SensorSynchronization.Type.SPO2, isImportSPO2sSupported(), isExportSPO2sSupported());
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x028b, code lost:
    
        if (r14 == r20) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x028d, code lost:
    
        applyLatestInsertedTimestamp(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0292, code lost:
    
        if ((r13 % 50) == 0) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0294, code lost:
    
        com.urbandroid.common.logging.Logger.logDebug(getServiceProvider().getName() + " Total " + r13 + " session inserted");
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02b6, code lost:
    
        r2.end(getServiceProvider(), com.urbandroid.sleep.service.health.HealthSynchronization.ProgressListener.Event.HEALTH_INSERT);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02bf, code lost:
    
        if (r13 > 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02c1, code lost:
    
        if (r5 <= 0) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02c4, code lost:
    
        r5 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02c7, code lost:
    
        r6 = new java.lang.StringBuilder();
        r6.append(getServiceProvider().getName());
        r6.append(": Sleep records stored into ");
        r6.append(getServiceProvider().getName());
        r6.append(" (success = ");
        r6.append(r13);
        r6.append(" / failure = ");
        r6.append(r5);
        r5 = r22;
        r6.append(r5);
        com.urbandroid.common.logging.Logger.logInfo(r6.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0271, code lost:
    
        r5 = r16;
     */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0271 A[EDGE_INSN: B:193:0x0271->B:97:0x0271 BREAK  A[LOOP:1: B:57:0x01a8->B:195:0x01a8], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0274  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void synchronizeSessions(HealthSynchronizationDataContext<S> healthSynchronizationDataContext) {
        String str;
        String str2;
        long j;
        int i;
        final HealthSynchronization.ProgressListener listener = healthSynchronizationDataContext.getListener();
        Collection<S> otherAppsHealthSessions = healthSynchronizationDataContext.getOtherAppsHealthSessions();
        Collection<S> ourAppHealthSessions = healthSynchronizationDataContext.getOurAppHealthSessions();
        List<HealthSession> sleepRecords = healthSynchronizationDataContext.getSleepRecords();
        if (shouldCleanDuplicates()) {
            Logger.logDebug(getServiceProvider().getName() + ": marking duplicate ...");
            HeathSyncKt.markDuplicatesAsBroken(ourAppHealthSessions);
        }
        listener.start(getServiceProvider(), HealthSynchronization.ProgressListener.Event.HEALTH_DELETE, ourAppHealthSessions.size());
        final HashSet hashSet = new HashSet();
        if (!this.importMode) {
            try {
                if (this.manual) {
                    Logger.logDebug("sleepRecords: " + HeathSyncKt.stringify(sleepRecords));
                } else {
                    Logger.logDebug("sleepRecords: " + HeathSyncKt.firstAndLast(sleepRecords));
                }
                for (S s : ourAppHealthSessions) {
                    if (this.manual) {
                        Logger.logDebug("ext session: " + SleeprecordExtKt.toAsciiHypnogram(s.getSleepRecord(), 15, null) + "\n" + HeathSyncKt.stringify(s));
                    }
                    if (isInterrupted()) {
                        throw new HealthSynchronizationInterruptedException();
                    }
                    HealthSession healthSessionFindSame = CalendarKt.findSame(sleepRecords, s);
                    if (healthSessionFindSame == null || s.getIsBroken() || s.getIsDuplicate() || isSessionChanged(healthSessionFindSame, s)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("\tRecord not found in SaA - will be deleted - isBroken: ");
                        sb.append(s.getIsBroken());
                        sb.append("  isDuplicate: ");
                        sb.append(s.getIsDuplicate());
                        sb.append("  isChanged: ");
                        sb.append(healthSessionFindSame != null ? Boolean.valueOf(isSessionChanged(healthSessionFindSame, s)) : "null");
                        sb.append(" ");
                        sb.append(HeathSyncKt.stringify(s));
                        Logger.logDebug(sb.toString());
                        hashSet.add(s);
                    }
                }
                if (!hashSet.isEmpty()) {
                    Logger.logDebug("Need to be deleted: " + hashSet.size());
                    this.healthApi.delete(hashSet, new HealthApi.Listener() { // from class: com.urbandroid.sleep.service.health.AbstractHealthSynchronization.3
                        @Override // com.urbandroid.sleep.service.health.api.HealthApi.Listener
                        public void deleted(int i2) {
                            listener.progress(AbstractHealthSynchronization.this.getServiceProvider(), i2, hashSet.size());
                        }
                    });
                }
                listener.end(getServiceProvider(), HealthSynchronization.ProgressListener.Event.HEALTH_DELETE);
            } finally {
                listener.end(getServiceProvider(), HealthSynchronization.ProgressListener.Event.HEALTH_DELETE);
            }
        }
        if (!this.importMode) {
            Iterator<S> it = ourAppHealthSessions.iterator();
            while (it.hasNext()) {
                S next = it.next();
                if (next.getIsBroken() || next.getIsDuplicate()) {
                    it.remove();
                }
            }
        }
        int size = sleepRecords.size();
        String str3 = ")";
        if (this.importMode) {
            str = ")";
        } else {
            listener.start(getServiceProvider(), HealthSynchronization.ProgressListener.Event.HEALTH_INSERT, size);
            try {
                Iterator<HealthSession> it2 = sleepRecords.iterator();
                int i2 = 0;
                long j2 = -1;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        str2 = str3;
                        j = -1;
                        i = i4;
                        break;
                    }
                    j = -1;
                    HealthSession next2 = it2.next();
                    if (isInterrupted()) {
                        throw new HealthSynchronizationInterruptedException();
                    }
                    if (next2 != null) {
                        HealthSession healthSessionFindSame2 = CalendarKt.findSame(ourAppHealthSessions, next2);
                        boolean zContains = ourAppHealthSessions.contains(next2);
                        boolean z = healthSessionFindSame2 != null && isSessionChanged(next2, healthSessionFindSame2);
                        boolean zAllowExport = allowExport(next2);
                        if (!zContains || z) {
                            if (zAllowExport) {
                                ResultStatus resultStatusInsert = this.healthApi.insert(next2);
                                str2 = str3;
                                long jMax = Math.max(j2, next2.getFromInMillis());
                                if (resultStatusInsert == null || !resultStatusInsert.isSuccess()) {
                                    Logger.logSevere(getServiceProvider().getName() + " insert session failure: " + resultStatusInsert);
                                    i3++;
                                    j2 = jMax;
                                } else {
                                    i = i4 + 1;
                                    if (!this.manual || (i >= 50 && i % 50 == 0)) {
                                        Logger.logDebug(getServiceProvider().getName() + " " + i + " session inserted");
                                    }
                                    if (isImportWalkingStepsEnabled()) {
                                        postSynchronizeSteps(next2);
                                    }
                                    j2 = jMax;
                                    int i5 = i2 + 1;
                                    listener.progress(getServiceProvider(), i2, size);
                                    if (i <= this.healthApi.getMaxRecordSyncCount()) {
                                        break;
                                    }
                                    i2 = i5;
                                    i4 = i;
                                    str3 = str2;
                                }
                            } else {
                                str2 = str3;
                            }
                            i = i4;
                            int i52 = i2 + 1;
                            listener.progress(getServiceProvider(), i2, size);
                            if (i <= this.healthApi.getMaxRecordSyncCount()) {
                            }
                        }
                    }
                }
            } finally {
                listener.end(getServiceProvider(), HealthSynchronization.ProgressListener.Event.HEALTH_INSERT);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (this.importMode) {
            arrayList.addAll(ourAppHealthSessions);
        }
        for (S s2 : otherAppsHealthSessions) {
            if (!HealthSessionUtil.isOverlap(s2, arrayList)) {
                arrayList.add(s2);
            }
        }
        List<? extends HealthSession> listFilter = HealthSessionUtil.filter(arrayList, new HealthSessionFilter() { // from class: com.urbandroid.sleep.service.health.AbstractHealthSynchronization.4
            @Override // com.urbandroid.sleep.service.health.session.filter.HealthSessionFilter
            public boolean accept(HealthSession healthSession) {
                return healthSession.isSleepActivity();
            }
        });
        int size2 = listFilter.size();
        listener.start(getServiceProvider(), HealthSynchronization.ProgressListener.Event.LOCAL_DB_INSERT, size2);
        try {
            String strJoin = Joiner.on("").map(new Joiner.ItemMapper<HealthSession>() { // from class: com.urbandroid.sleep.service.health.AbstractHealthSynchronization.5
                @Override // com.urbandroid.common.util.string.Joiner.ItemMapper
                public CharSequence map(HealthSession healthSession) {
                    return "[" + DateUtils.toReadableDate(healthSession.getFrom()) + "," + DateUtils.toReadableDate(healthSession.getTo()) + ", " + healthSession.getIsFinished() + "]";
                }
            }).join(sleepRecords);
            List<? extends HealthSession> listMerge = getServiceProvider().isGoogleFit() ? new GoogleFitSessionPostMerger(!this.manual).merge(listFilter) : listFilter;
            Logger.logInfo("otherSleepAppSessions: " + listFilter.size() + " mergedOtherSleepAppSessions: " + listMerge.size());
            if (!this.importMode) {
                Logger.logInfo("SaA records: " + strJoin.length());
            }
            int i6 = 0;
            for (HealthSession healthSession : listMerge) {
                if (isInterrupted()) {
                    throw new HealthSynchronizationInterruptedException();
                }
                if (HealthSessionUtil.isOverlap(healthSession, sleepRecords) || hasOverlap(HealthIntervalKt.toInterval(healthSession))) {
                    Logger.logInfo(getServiceProvider().getName() + ": Record overlapping: " + healthSession);
                } else {
                    SleepRecord sleepRecord = healthSession.getSleepRecord();
                    if (this.sleepRecordRepository.load(sleepRecord.getFrom().getTime()) == null) {
                        if (!this.importMode) {
                            sleepRecord.addTag(Tag.CLOUD);
                        }
                        try {
                            sleepRecord.finish(sleepRecord.getTo());
                        } catch (Exception e) {
                            Logger.logSevere(e);
                        }
                        this.sleepRecordRepository.addNewSleepRecord(sleepRecord);
                        Logger.logInfo(getServiceProvider().getName() + ": Importing sleep record from " + healthSession);
                    }
                }
                listener.progress(getServiceProvider(), i6, size2);
                i6++;
            }
            if (cleanUpOverlapsWithCloudTag() && !this.importMode) {
                List<SleepRecord> sleepRecords2 = this.sleepRecordRepository.getSleepRecords(healthSynchronizationDataContext.getFrom().getTime(), 7200000 + Calendar.getInstance().getTime().getTime(), false);
                Logger.logInfo(getServiceProvider().getName() + ": Cleaning duplicates (" + sleepRecords2.size() + str);
                for (SleepRecord sleepRecord2 : sleepRecords2) {
                    if (sleepRecord2.hasTag(Tag.CLOUD) && hasOverlap(new Interval(sleepRecord2.getFromTime(), sleepRecord2.getToTime()))) {
                        Logger.logInfo(getServiceProvider().getName() + ":Deleting duplicate cloud record ... " + sleepRecord2.toString());
                        this.sleepRecordRepository.deleteRecord(sleepRecord2, null);
                    }
                }
            }
            listener.end(getServiceProvider(), HealthSynchronization.ProgressListener.Event.LOCAL_DB_INSERT);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Logger.logInfo(getServiceProvider().getName() + " starting record count");
            int iCount = this.healthApi.count();
            getServiceProvider().setCachedRecordCount(iCount);
            if (iCount != -1) {
                Logger.logInfo(getServiceProvider().getName() + ":Count records ... " + iCount + " records took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
            }
        } catch (Throwable th) {
            listener.end(getServiceProvider(), HealthSynchronization.ProgressListener.Event.LOCAL_DB_INSERT);
            throw th;
        }
    }

    public int synchronizeSportTags(HealthSynchronizationDataContext<S> healthSynchronizationDataContext) {
        List<HealthSession> sleepRecords = healthSynchronizationDataContext.getSleepRecords();
        HealthSynchronization.ProgressListener listener = healthSynchronizationDataContext.getListener();
        listener.start(getServiceProvider(), HealthSynchronization.ProgressListener.Event.SPORT_TAG_INSERT, sleepRecords.size());
        try {
            List listFilter = HealthSessionUtil.filter(healthSynchronizationDataContext.getOtherAppsHealthSessions(), ActivityTypeFilter.SPORT);
            ArrayList<HealthSession> arrayList = new ArrayList(sleepRecords);
            Collections.sort(arrayList, new Comparator<HealthSession>() { // from class: com.urbandroid.sleep.service.health.AbstractHealthSynchronization.6
                @Override // java.util.Comparator
                public int compare(HealthSession healthSession, HealthSession healthSession2) {
                    return healthSession.getFrom().compareTo(healthSession2.getFrom());
                }
            });
            int i = 0;
            HealthSession healthSession = null;
            for (HealthSession healthSession2 : arrayList) {
                if (!Tag.hasTag(healthSession2.getSleepRecord().getComment(), Tag.SPORT)) {
                    if (addSportTag(healthSession, healthSession2, listFilter)) {
                        i++;
                    }
                    healthSession = healthSession2;
                }
            }
            return i;
        } finally {
            listener.end(getServiceProvider(), HealthSynchronization.ProgressListener.Event.SPORT_TAG_INSERT);
        }
    }

    public void synchronizeUserProfile(HealthSynchronizationDataContext<S> healthSynchronizationDataContext) {
        Logger.logInfo(getServiceProvider().getName() + ": User Profile import starting  ... " + this.format.format(healthSynchronizationDataContext.getFrom()));
        if (!this.healthApi.getIsConnected()) {
            Logger.logInfo(getServiceProvider().getName() + " not connected");
            this.healthApi.connect();
        }
        HealthSynchronization.ProgressListener listener = healthSynchronizationDataContext.getListener();
        HealthServiceProvider serviceProvider = getServiceProvider();
        HealthSynchronization.ProgressListener.Event event = HealthSynchronization.ProgressListener.Event.HEALTH_USER_PROFILE;
        listener.start(serviceProvider, event, 0);
        HealthUserProfile userProfile = this.healthApi.getUserProfile();
        if (userProfile != null) {
            Logger.logInfo(getServiceProvider().getName() + ": User Profile: " + userProfile.toString());
            SharedApplicationContext.getSettings().updateUserProfile(userProfile);
        }
        listener.end(getServiceProvider(), event);
    }

    public AbstractHealthSynchronization(Context context, HealthApi<S> healthApi, ISleepRecordRepository iSleepRecordRepository) {
        this.format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.isInterrupted = new AtomicBoolean(false);
        this.isRunning = new AtomicBoolean(false);
        this.manual = false;
        this.importMode = false;
        this.activity = null;
        this.context = context;
        this.healthApi = healthApi;
        this.sleepRecordRepository = iSleepRecordRepository;
        HealthSessionPackageFilter healthSessionPackageFilter = new HealthSessionPackageFilter(context.getPackageName());
        this.ourPackageFilter = healthSessionPackageFilter;
        this.notOurPackageFilter = new NotFilter(healthSessionPackageFilter);
    }
}
