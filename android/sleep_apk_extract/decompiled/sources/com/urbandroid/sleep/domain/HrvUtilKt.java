package com.urbandroid.sleep.domain;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.Hours;
import com.urbandroid.common.TimeType;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.snoring.feature.FloatFunction;
import com.urbandroid.sleep.snoring.feature.Moving;
import com.urbandroid.util.Percentile;
import com.urbandroid.util.ScienceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a?\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003*\u00020\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a%\u0010\u0013\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003*\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u000e\u001a%\u0010\u0016\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0014\u001a-\u0010\u0019\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a%\u0010\u001d\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a%\u0010\u001f\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001f\u0010\u001e\u001a\u0013\u0010 \u001a\u0004\u0018\u00010\u0003*\u00020\u0000¢\u0006\u0004\b \u0010\u000e\u001a\u0013\u0010!\u001a\u0004\u0018\u00010\u0003*\u00020\u0000¢\u0006\u0004\b!\u0010\u000e\u001a\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003*\u00020\u0000¢\u0006\u0004\b\"\u0010\u000e\u001a\u0011\u0010$\u001a\u00020#*\u00020\u0000¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/urbandroid/sleep/domain/SleepRecord;", "", "", "", "getSmoothHrvSeries", "(Lcom/urbandroid/sleep/domain/SleepRecord;)Ljava/util/Map;", "", "Lcom/urbandroid/sleep/domain/IEvent;", "events", "windowMillis", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/util/List;J)Ljava/util/HashMap;", "getRestingHrvAtEndOfSleep", "(Lcom/urbandroid/sleep/domain/SleepRecord;)Ljava/lang/Float;", "Lcom/urbandroid/common/TimeType;", "window", "", "percentile", "getRestingHrvAtEndOfSleep_percentile", "(Lcom/urbandroid/sleep/domain/SleepRecord;Lcom/urbandroid/common/TimeType;I)Ljava/lang/Float;", "getRestingHrvAtStartOfSleep", "getRestingHrvAtStartOfSleep_percentile", "startTime", SDKConstants.PARAM_END_TIME, "getRestingHrv_percentile", "(Lcom/urbandroid/sleep/domain/SleepRecord;JJI)Ljava/lang/Float;", "smoothingPeriod", "localMinPeriod", "getRestingHrvAtEndOfSleep_local_min", "(Lcom/urbandroid/sleep/domain/SleepRecord;II)Ljava/lang/Float;", "getRestingHrvAtStartOfSleep_local_min", "getSDNNI", "getSDANN", "getWholeNightHRV", "", "logHrvStatistics", "(Lcom/urbandroid/sleep/domain/SleepRecord;)V", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class HrvUtilKt {
    public static final Float getRestingHrvAtEndOfSleep(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        return getRestingHrvAtEndOfSleep_percentile(sleepRecord, Hours.m964boximpl(Utils.getHours(2)), 10);
    }

    private static final Float getRestingHrvAtEndOfSleep_local_min(SleepRecord sleepRecord, int i, int i2) {
        sleepRecord.getToTime();
        if (sleepRecord.getToTime() - sleepRecord.getFromTime() < Utils.getHoursInMillis(3)) {
            return null;
        }
        List<IEvent> events = EventsUtil.getEvents(sleepRecord.getEvents().getCopiedEvents(), EventLabel.SDNN);
        events.getClass();
        FloatFunction floatFunctionAvg = Moving.avg(i);
        List<IEvent> list = events;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(floatFunctionAvg.apply(((IEvent) it.next()).getValue())));
        }
        int size = (arrayList.size() - i2) - 1;
        if (i2 > size) {
            return null;
        }
        while (sleepRecord.getToTime() - events.get(size).getTimestamp() <= Utils.getHoursInMillis(2)) {
            Object objMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Object>) arrayList.subList(size - i2, size + i2 + 1));
            if (objMinOrNull == null) {
                objMinOrNull = 0;
            }
            if (Intrinsics.areEqual(arrayList.get(size), objMinOrNull)) {
                return Float.valueOf((float) Math.rint(((Number) arrayList.get(size)).floatValue()));
            }
            if (size == i2) {
                return null;
            }
            size--;
        }
        return null;
    }

    private static final Float getRestingHrvAtEndOfSleep_percentile(SleepRecord sleepRecord, TimeType timeType, int i) {
        sleepRecord.getToTime();
        if (sleepRecord.getToTime() - sleepRecord.getFromTime() < Utils.getHoursInMillis(3)) {
            return null;
        }
        return getRestingHrv_percentile(sleepRecord, sleepRecord.getToTime() - timeType.getMillis(), sleepRecord.getToTime(), i);
    }

    public static final Float getRestingHrvAtStartOfSleep(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        return getRestingHrvAtStartOfSleep_percentile(sleepRecord, Hours.m964boximpl(Utils.getHours(2)), 10);
    }

    private static final Float getRestingHrvAtStartOfSleep_local_min(SleepRecord sleepRecord, int i, int i2) {
        sleepRecord.getToTime();
        if (sleepRecord.getToTime() - sleepRecord.getFromTime() < Utils.getHoursInMillis(3)) {
            return null;
        }
        List<IEvent> events = EventsUtil.getEvents(sleepRecord.getEvents().getCopiedEvents(), EventLabel.SDNN);
        events.getClass();
        FloatFunction floatFunctionAvg = Moving.avg(i);
        List<IEvent> list = events;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(floatFunctionAvg.apply(((IEvent) it.next()).getValue())));
        }
        int size = (arrayList.size() - i2) - 1;
        for (int i3 = i2; i3 < size && events.get(i3).getTimestamp() - sleepRecord.getFromTime() <= Utils.getHoursInMillis(2); i3++) {
            Object objMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Object>) arrayList.subList(i3 - i2, i3 + i2 + 1));
            if (objMinOrNull == null) {
                objMinOrNull = 0;
            }
            if (Intrinsics.areEqual(arrayList.get(i3), objMinOrNull)) {
                return Float.valueOf((float) Math.rint(((Number) arrayList.get(i3)).floatValue()));
            }
        }
        return null;
    }

    private static final Float getRestingHrvAtStartOfSleep_percentile(SleepRecord sleepRecord, TimeType timeType, int i) {
        sleepRecord.getToTime();
        if (sleepRecord.getToTime() - sleepRecord.getFromTime() < Utils.getHoursInMillis(3)) {
            return null;
        }
        return getRestingHrv_percentile(sleepRecord, sleepRecord.getFromTime(), sleepRecord.getFromTime() + timeType.getMillis(), i);
    }

    private static final Float getRestingHrv_percentile(SleepRecord sleepRecord, long j, long j2, int i) {
        List<IEvent> events = EventsUtil.getEvents(sleepRecord.getEvents().getCopiedEvents(), j, j2, EventLabel.SDNN);
        if (events.size() < ((int) Math.rint(((j2 - j) / Utils.getMinutesInMillis(5)) * 0.42d))) {
            return null;
        }
        List<IEvent> list = events;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((IEvent) it.next()).getValue()));
        }
        return Float.valueOf((float) Math.rint(new Percentile().evaluate(arrayList, i)));
    }

    public static final Float getSDANN(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        List<IEvent> events = EventsUtil.getEvents(sleepRecord.getEvents().getCopiedEvents(), EventLabel.SDANN);
        events.getClass();
        IEvent iEvent = (IEvent) CollectionsKt.firstOrNull((List) events);
        if (iEvent != null) {
            return Float.valueOf(iEvent.getValue());
        }
        return null;
    }

    public static final Float getSDNNI(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        sleepRecord.getToTime();
        if (sleepRecord.getToTime() - sleepRecord.getFromTime() < Utils.getHoursInMillis(3)) {
            return null;
        }
        List<IEvent> events = EventsUtil.getEvents(sleepRecord.getEvents().getCopiedEvents(), EventLabel.SDNN);
        events.getClass();
        if (events.size() < ((int) Math.rint(((sleepRecord.getToTime() - sleepRecord.getFromTime()) / Utils.getMinutesInMillis(5)) * 0.42d))) {
            return null;
        }
        List<IEvent> list = events;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(((IEvent) it.next()).getValue()));
        }
        return Float.valueOf(ScienceUtil.avg(CollectionsKt.toFloatArray(arrayList)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final HashMap<Long, Float> getSmoothHrvSeries(List<? extends IEvent> list, long j) {
        list.getClass();
        HashMap<Long, Float> map = new HashMap<>();
        if (!list.isEmpty()) {
            List<? extends IEvent> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((IEvent) it.next()).getTimestamp()));
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Float.valueOf(((IEvent) it2.next()).getValue()));
            }
            int size = list.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                while (i2 < i && ((Number) arrayList.get(i)).longValue() - ((Number) arrayList.get(i2)).longValue() > j) {
                    i2++;
                }
                Object obj = arrayList.get(i);
                i++;
                Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) arrayList2.subList(i2, i));
                map.put(obj, Float.valueOf(fMinOrNull != null ? fMinOrNull.floatValue() : 0.0f));
            }
        }
        return map;
    }

    public static final Float getWholeNightHRV(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        Float sdann = getSDANN(sleepRecord);
        return sdann == null ? getSDNNI(sleepRecord) : sdann;
    }

    public static final void logHrvStatistics(SleepRecord sleepRecord) {
        sleepRecord.getClass();
        Logger.logInfo("HRV Statistics: \nrestingHrv_percntl(2h, 10): " + getRestingHrvAtStartOfSleep_percentile(sleepRecord, Hours.m964boximpl(Utils.getHours(2)), 10) + " " + getRestingHrvAtEndOfSleep_percentile(sleepRecord, Hours.m964boximpl(Utils.getHours(2)), 10) + "\nrestingHrv_local_min(1, 5): " + getRestingHrvAtStartOfSleep_local_min(sleepRecord, 1, 5) + " " + getRestingHrvAtEndOfSleep_local_min(sleepRecord, 1, 5) + "\nSDNNI: " + getSDNNI(sleepRecord) + "\nSDANN: " + getSDANN(sleepRecord));
    }

    public static final Map<Long, Float> getSmoothHrvSeries(SleepRecord sleepRecord) {
        long minutesInMillis;
        sleepRecord.getClass();
        List<IEvent> events = EventsUtil.getEvents(sleepRecord.getEvents().getCopiedEvents(), EventLabel.SDNN);
        events.getClass();
        if (events.isEmpty()) {
            return new HashMap();
        }
        long timestamp = ((IEvent) CollectionsKt.last((List) events)).getTimestamp() - ((IEvent) CollectionsKt.first((List) events)).getTimestamp();
        if (timestamp < Utils.getMinutesInMillis(60)) {
            minutesInMillis = Utils.getMinutesInMillis(1);
        } else {
            minutesInMillis = timestamp < Utils.getMinutesInMillis(120) ? Utils.getMinutesInMillis(7) : Utils.getMinutesInMillis(13);
        }
        return getSmoothHrvSeries(events, minutesInMillis);
    }
}
