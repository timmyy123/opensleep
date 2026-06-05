package com.urbandroid.sleep.service.health;

import android.app.Activity;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.Events;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.sleep.service.health.api.HealthApi;
import com.urbandroid.sleep.service.health.api.SensorRecord;
import com.urbandroid.sleep.service.health.session.HealthSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.mp4parser.boxes.iso14496.part15.SyncSampleEntry;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0019B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/service/health/SensorSynchronization;", "S", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "Lcom/urbandroid/common/FeatureLogger;", "provider", "Lcom/urbandroid/sleep/service/health/HealthServiceProvider;", "healthApi", "Lcom/urbandroid/sleep/service/health/api/HealthApi;", "sleepRecordRepository", "Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;", "<init>", "(Lcom/urbandroid/sleep/service/health/HealthServiceProvider;Lcom/urbandroid/sleep/service/health/api/HealthApi;Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;)V", "tag", "", "getTag", "()Ljava/lang/String;", SyncSampleEntry.TYPE, "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/service/health/HealthSynchronizationDataContext;", "type", "Lcom/urbandroid/sleep/service/health/SensorSynchronization$Type;", "doImport", "", "doExport", "Type", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SensorSynchronization<S extends HealthSession> implements FeatureLogger {
    private final HealthApi<S> healthApi;
    private final HealthServiceProvider provider;
    private final ISleepRecordRepository sleepRecordRepository;
    private final String tag;

    public SensorSynchronization(HealthServiceProvider healthServiceProvider, HealthApi<S> healthApi, ISleepRecordRepository iSleepRecordRepository) {
        healthServiceProvider.getClass();
        healthApi.getClass();
        iSleepRecordRepository.getClass();
        this.provider = healthServiceProvider;
        this.healthApi = healthApi;
        this.sleepRecordRepository = iSleepRecordRepository;
        this.tag = "SensorSync";
    }

    private static final <S extends HealthSession, R> R sync$invoke(HealthSynchronization.ProgressListener.Event event, HealthSynchronization.ProgressListener progressListener, SensorSynchronization<S> sensorSynchronization, int i, Function0<? extends R> function0) {
        event.getClass();
        progressListener.start(((SensorSynchronization) sensorSynchronization).provider, event, i);
        try {
            return function0.invoke();
        } finally {
            progressListener.end(((SensorSynchronization) sensorSynchronization).provider, event);
        }
    }

    public static /* synthetic */ Object sync$invoke$default(HealthSynchronization.ProgressListener.Event event, HealthSynchronization.ProgressListener progressListener, SensorSynchronization sensorSynchronization, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return sync$invoke(event, progressListener, sensorSynchronization, i, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List sync$lambda$1(Type type, HealthSynchronizationDataContext healthSynchronizationDataContext, SensorSynchronization sensorSynchronization, long j, long j2) {
        return type.read(healthSynchronizationDataContext.getActivity(), sensorSynchronization.healthApi, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sync$lambda$3(boolean z, List list, List list2, LinkedHashMap linkedHashMap, SensorSynchronization sensorSynchronization, Type type, HealthSynchronization.ProgressListener progressListener, int i) {
        List list3;
        if (!z) {
            return Unit.INSTANCE;
        }
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            SleepRecord sleepRecord = (SleepRecord) it.next();
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                long fromTime = sleepRecord.getFromTime();
                long toTime = sleepRecord.getToTime();
                long from = ((SensorRecord) obj).getFrom();
                if (fromTime <= from && from <= toTime) {
                    arrayList.add(obj);
                }
            }
            ArrayList<SensorRecord> arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                sleepRecord.getClass();
                if (!SensorSynchronizationKt.has(sleepRecord, (SensorRecord) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList<Event> arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (SensorRecord sensorRecord : arrayList2) {
                arrayList3.add(new Event(sensorRecord.getFrom(), type.getEventLabel(), sensorRecord.getValue()));
            }
            if (!arrayList3.isEmpty()) {
                linkedHashMap.put(Long.valueOf(sleepRecord.getFromTime()), arrayList3);
                String str = sensorSynchronization.provider.getName() + ": Record " + sleepRecord.getFrom() + " " + type;
                Logger.logInfo(Logger.defaultTag, sensorSynchronization.getTag() + ": " + str, null);
                for (Event event : arrayList3) {
                    String str2 = sensorSynchronization.provider.getName() + ": Event " + event;
                    Logger.logInfo(Logger.defaultTag, sensorSynchronization.getTag() + ": " + str2, null);
                }
            }
            progressListener.progress(sensorSynchronization.provider, i2, i);
            i2 = i3;
        }
        for (Object obj3 : linkedHashMap.keySet()) {
            obj3.getClass();
            long jLongValue = ((Number) obj3).longValue();
            SleepRecord sleepRecordLoadFullRecord = sensorSynchronization.sleepRecordRepository.loadFullRecord(jLongValue);
            if (sleepRecordLoadFullRecord != null && (list3 = (List) linkedHashMap.get(Long.valueOf(jLongValue))) != null) {
                Iterator it2 = list3.iterator();
                while (it2.hasNext()) {
                    sleepRecordLoadFullRecord.getEvents().addEvent((Event) it2.next());
                }
                sleepRecordLoadFullRecord.computeAll();
                sleepRecordLoadFullRecord.computeLenAdjust();
                String str3 = sensorSynchronization.provider.getName() + ": " + Utils.getPrettyDate(sleepRecordLoadFullRecord.getFrom().getTime()) + " Record - added " + list3.size() + " " + type + " " + list3.size() + " events";
                Logger.logInfo(Logger.defaultTag, sensorSynchronization.getTag() + ": " + str3, null);
                sensorSynchronization.sleepRecordRepository.addNewSleepRecord(sleepRecordLoadFullRecord);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x000e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit sync$lambda$4(boolean z, HealthSynchronizationDataContext healthSynchronizationDataContext, LinkedHashMap linkedHashMap, Type type, SensorSynchronization sensorSynchronization, List list) {
        List<IEvent> events;
        if (!z) {
            return Unit.INSTANCE;
        }
        boolean z2 = false;
        for (SleepRecord sleepRecord : healthSynchronizationDataContext.getNativeSleepRecords()) {
            long fromTime = sleepRecord.getFromTime();
            if (fromTime >= healthSynchronizationDataContext.getFrom().getTime() && !linkedHashMap.containsKey(Long.valueOf(fromTime))) {
                Events events2 = sleepRecord.getEvents();
                if (events2 == null) {
                    events = null;
                    if (events == null) {
                        String str = sensorSynchronization.provider.getName() + ": " + Utils.getPrettyDate(sleepRecord.getFrom().getTime()) + " Record - no " + type + " events found";
                        Logger.logDebug(Logger.defaultTag, sensorSynchronization.getTag() + ": " + str, null);
                    }
                    if (events == null) {
                        List<? extends IEvent> arrayList = new ArrayList<>();
                        for (Object obj : events) {
                            IEvent iEvent = (IEvent) obj;
                            iEvent.getClass();
                            if (!SensorSynchronizationKt.contains(list, iEvent)) {
                                arrayList.add(obj);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            arrayList = null;
                        }
                        if (arrayList == null) {
                            String str2 = sensorSynchronization.provider.getName() + ": " + Utils.getPrettyDate(sleepRecord.getFrom().getTime()) + " Record - " + type + " events already exported";
                            Logger.logDebug(Logger.defaultTag, sensorSynchronization.getTag() + ": " + str2, null);
                        }
                        if (arrayList != null) {
                            type.write(sensorSynchronization.healthApi, sleepRecord.getFromTime(), arrayList);
                            z2 = true;
                        }
                    }
                } else {
                    if (events2.isEmpty()) {
                        events2 = null;
                    }
                    if (events2 == null || (events = EventsUtil.getEvents(events2.getCopiedEvents(), type.getEventLabel())) == null || events.isEmpty()) {
                    }
                    if (events == null) {
                    }
                    if (events == null) {
                    }
                }
            }
        }
        if (!z2) {
            String str3 = sensorSynchronization.provider.getName() + ": No data exported - No Sleep Records contains " + type + " events";
            Logger.logInfo(Logger.defaultTag, sensorSynchronization.getTag() + ": " + str3, null);
        }
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void sync(final HealthSynchronizationDataContext<S> context, final Type type, final boolean doImport, final boolean doExport) {
        context.getClass();
        type.getClass();
        final HealthSynchronization.ProgressListener listener = context.getListener();
        if (doExport || doImport) {
            final long time = context.getFrom().getTime();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long lValueOf = Long.valueOf(jCurrentTimeMillis);
            if (jCurrentTimeMillis <= time) {
                lValueOf = null;
            }
            if (lValueOf != null) {
                final long jLongValue = lValueOf.longValue();
                String str = this.provider.getName() + ": " + type + " sync starting  ... " + Utils.getPrettyDate(time);
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
                final List list = (List) sync$invoke$default(type.getReadEvent(), listener, this, 0, new Function0() { // from class: com.urbandroid.sleep.service.health.SensorSynchronization$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SensorSynchronization.sync$lambda$1(type, context, this, time, jLongValue);
                    }
                }, 4, null);
                String str2 = this.provider.getName() + ": " + list.size() + " " + type + " records found\t took " + (System.currentTimeMillis() - jLongValue) + " ms";
                Logger.logInfo(Logger.defaultTag, getTag() + ": " + str2, null);
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                List<SleepRecord> nativeSleepRecords = context.getNativeSleepRecords();
                nativeSleepRecords.getClass();
                final ArrayList arrayList = new ArrayList();
                for (Object obj : nativeSleepRecords) {
                    if (((SleepRecord) obj).getFromTime() >= time) {
                        arrayList.add(obj);
                    }
                }
                final int size = arrayList.size();
                sync$invoke(type.getInsertEvent(), listener, this, size, new Function0() { // from class: com.urbandroid.sleep.service.health.SensorSynchronization$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SensorSynchronization.sync$lambda$3(doImport, arrayList, list, linkedHashMap, this, type, listener, size);
                    }
                });
                sync$invoke$default(type.getExportEvent(), listener, this, 0, new Function0() { // from class: com.urbandroid.sleep.service.health.SensorSynchronization$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SensorSynchronization.sync$lambda$4(doExport, context, linkedHashMap, type, this, list);
                    }
                }, 4, null);
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ4\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH&J*\u0010\u001c\u001a\u00020\u001d2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rj\u0002\b\u0010j\u0002\b\u0011¨\u0006 "}, d2 = {"Lcom/urbandroid/sleep/service/health/SensorSynchronization$Type;", "", "eventLabel", "Lcom/urbandroid/sleep/domain/EventLabel;", "readEvent", "Lcom/urbandroid/sleep/service/health/HealthSynchronization$ProgressListener$Event;", "insertEvent", "exportEvent", "<init>", "(Ljava/lang/String;ILcom/urbandroid/sleep/domain/EventLabel;Lcom/urbandroid/sleep/service/health/HealthSynchronization$ProgressListener$Event;Lcom/urbandroid/sleep/service/health/HealthSynchronization$ProgressListener$Event;Lcom/urbandroid/sleep/service/health/HealthSynchronization$ProgressListener$Event;)V", "getEventLabel", "()Lcom/urbandroid/sleep/domain/EventLabel;", "getReadEvent", "()Lcom/urbandroid/sleep/service/health/HealthSynchronization$ProgressListener$Event;", "getInsertEvent", "getExportEvent", "HR", "SPO2", "read", "", "Lcom/urbandroid/sleep/service/health/api/SensorRecord;", "activity", "Landroid/app/Activity;", "healthApi", "Lcom/urbandroid/sleep/service/health/api/HealthApi;", "from", "", "to", "write", "", "events", "Lcom/urbandroid/sleep/domain/IEvent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static abstract class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type HR = new HR("HR", 0);
        public static final Type SPO2 = new SPO2("SPO2", 1);
        private final EventLabel eventLabel;
        private final HealthSynchronization.ProgressListener.Event exportEvent;
        private final HealthSynchronization.ProgressListener.Event insertEvent;
        private final HealthSynchronization.ProgressListener.Event readEvent;

        @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J*\u0010\f\u001a\u00020\r2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u0016¨\u0006\u0010"}, d2 = {"com/urbandroid/sleep/service/health/SensorSynchronization.Type.HR", "Lcom/urbandroid/sleep/service/health/SensorSynchronization$Type;", "read", "", "Lcom/urbandroid/sleep/service/health/api/SensorRecord;", "activity", "Landroid/app/Activity;", "healthApi", "Lcom/urbandroid/sleep/service/health/api/HealthApi;", "from", "", "to", "write", "", "events", "Lcom/urbandroid/sleep/domain/IEvent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class HR extends Type {
            public HR(String str, int i) {
                super(str, i, EventLabel.HR, HealthSynchronization.ProgressListener.Event.HEALTH_READ_HEART_RATE, HealthSynchronization.ProgressListener.Event.HEALTH_INSERT_HEART_RATE, HealthSynchronization.ProgressListener.Event.HEALTH_EXPORT_HEART_RATE, null);
            }

            @Override // com.urbandroid.sleep.service.health.SensorSynchronization.Type
            public List<SensorRecord> read(Activity activity, HealthApi<?> healthApi, long from, long to) {
                healthApi.getClass();
                List<SensorRecord.HeartRate> heartRateData = healthApi.readHeartRateData(activity, from, to);
                heartRateData.getClass();
                return heartRateData;
            }

            @Override // com.urbandroid.sleep.service.health.SensorSynchronization.Type
            public void write(HealthApi<?> healthApi, long from, List<? extends IEvent> events) {
                healthApi.getClass();
                events.getClass();
                healthApi.insertHeartRateData(from, events);
            }
        }

        @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J*\u0010\f\u001a\u00020\r2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003H\u0016¨\u0006\u0010"}, d2 = {"com/urbandroid/sleep/service/health/SensorSynchronization.Type.SPO2", "Lcom/urbandroid/sleep/service/health/SensorSynchronization$Type;", "read", "", "Lcom/urbandroid/sleep/service/health/api/SensorRecord;", "activity", "Landroid/app/Activity;", "healthApi", "Lcom/urbandroid/sleep/service/health/api/HealthApi;", "from", "", "to", "write", "", "events", "Lcom/urbandroid/sleep/domain/IEvent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class SPO2 extends Type {
            public SPO2(String str, int i) {
                super(str, i, EventLabel.SPO2, HealthSynchronization.ProgressListener.Event.HEALTH_READ_SPO2, HealthSynchronization.ProgressListener.Event.HEALTH_INSERT_SPO2, HealthSynchronization.ProgressListener.Event.HEALTH_EXPORT_SPO2, null);
            }

            @Override // com.urbandroid.sleep.service.health.SensorSynchronization.Type
            public List<SensorRecord> read(Activity activity, HealthApi<?> healthApi, long from, long to) {
                healthApi.getClass();
                List<SensorRecord.SPO2> sPO2Data = healthApi.readSPO2Data(activity, from, to);
                sPO2Data.getClass();
                return sPO2Data;
            }

            @Override // com.urbandroid.sleep.service.health.SensorSynchronization.Type
            public void write(HealthApi<?> healthApi, long from, List<? extends IEvent> events) {
                healthApi.getClass();
                events.getClass();
                healthApi.insertSPO2Data(from, events);
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{HR, SPO2};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i, EventLabel eventLabel, HealthSynchronization.ProgressListener.Event event, HealthSynchronization.ProgressListener.Event event2, HealthSynchronization.ProgressListener.Event event3) {
            this.eventLabel = eventLabel;
            this.readEvent = event;
            this.insertEvent = event2;
            this.exportEvent = event3;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final EventLabel getEventLabel() {
            return this.eventLabel;
        }

        public final HealthSynchronization.ProgressListener.Event getExportEvent() {
            return this.exportEvent;
        }

        public final HealthSynchronization.ProgressListener.Event getInsertEvent() {
            return this.insertEvent;
        }

        public final HealthSynchronization.ProgressListener.Event getReadEvent() {
            return this.readEvent;
        }

        public abstract List<SensorRecord> read(Activity activity, HealthApi<?> healthApi, long from, long to);

        public abstract void write(HealthApi<?> healthApi, long from, List<? extends IEvent> events);

        public /* synthetic */ Type(String str, int i, EventLabel eventLabel, HealthSynchronization.ProgressListener.Event event, HealthSynchronization.ProgressListener.Event event2, HealthSynchronization.ProgressListener.Event event3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, eventLabel, event, event2, event3);
        }
    }
}
