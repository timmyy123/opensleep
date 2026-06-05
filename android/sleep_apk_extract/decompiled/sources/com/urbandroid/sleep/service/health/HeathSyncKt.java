package com.urbandroid.sleep.service.health;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Build;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.activityrecognition.ActivityBootReceiver$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.persistence.ISleepRecordRepository;
import com.urbandroid.sleep.service.health.session.HealthSession;
import com.urbandroid.sleep.service.health.session.HealthSessionSegment;
import com.urbandroid.sleep.service.health.session.SleepRecordHealthSession;
import com.urbandroid.sleep.service.health.session.SleepSegmentType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u0002\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\b\u001a\u00020\t\u001a(\u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\b\u0012\u0004\u0012\u00020\u00130\u0005\u001a\u0010\u0010\u0014\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00130\u0005\u001a\n\u0010\u0014\u001a\u00020\u0002*\u00020\u0013\u001a\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\b\u0012\u0004\u0012\u00020\u00130\u0005\u001a\u0010\u0010\u0016\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00130\u0005\u001a\u0010\u0010\u0017\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00130\u0005\u001a\n\u0010\u0000\u001a\u00020\u0002*\u00020\u0004\u001a\n\u0010\u0018\u001a\u00020\u0002*\u00020\u0004\u001a \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t\u001a\u0016\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f\u001a\u0016\u0010&\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000f\u001a\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0001\u001a\u001a\u0010*\u001a\u00020+\"\b\b\u0000\u0010\u0003*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005\u001a\u0019\u0010,\u001a\u00020\u000b\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u0003¢\u0006\u0002\u0010-\"\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0015\u0010\u001c\u001a\u00020\u0002*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b\"\u0015\u0010(\u001a\u00020\u0002*\u00020\t8F¢\u0006\u0006\u001a\u0004\b)\u0010\u001b¨\u0006."}, d2 = {"stringify", "", "", "S", "Lcom/urbandroid/sleep/service/health/session/HealthSession;", "", "firstAndLast", "filterAfter", "afterTime", "", "addIfMissing", "", "", "block", "add", "Ljava/util/Date;", "hours", "", "ordered", "Lcom/urbandroid/sleep/service/health/session/HealthSessionSegment;", "pretty", "nonNull", "isManual", "hasBrokenSegments", "stringifyShort", "prettyTime", "getPrettyTime", "(J)Ljava/lang/String;", "prettyDateTime", "getPrettyDateTime", "readSyncRecords", "Lcom/urbandroid/sleep/domain/SleepRecord;", "Lcom/urbandroid/sleep/persistence/ISleepRecordRepository;", "from", "to", "min", "date1", "date2", "max", "toSleepRecords", "prettyMillis", "getPrettyMillis", "markDuplicatesAsBroken", "", "isConsistent", "(Lcom/urbandroid/sleep/service/health/session/HealthSession;)Z", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class HeathSyncKt {
    public static final Date add(Date date, int i) {
        date.getClass();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        calendar.set(11, i);
        Date time = calendar.getTime();
        time.getClass();
        return time;
    }

    public static final <S extends HealthSession> boolean addIfMissing(List<S> list, Collection<? extends S> collection) {
        list.getClass();
        collection.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (!list.contains((HealthSession) obj)) {
                arrayList.add(obj);
            }
        }
        return list.addAll(arrayList);
    }

    public static final <S extends HealthSession> Collection<S> filterAfter(Collection<? extends S> collection, long j) {
        collection.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (((HealthSession) obj).getFromInMillis() >= j) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <S extends HealthSession> String firstAndLast(Collection<? extends S> collection) {
        String strM;
        collection.getClass();
        int size = collection.size();
        if (collection.isEmpty()) {
            strM = "[]";
        } else if (collection.size() == 1) {
            strM = FileInsert$$ExternalSyntheticOutline0.m("first: ", stringifyShort((HealthSession) CollectionsKt.first(collection)));
        } else {
            Collection<? extends S> collection2 = collection;
            strM = Fragment$$ExternalSyntheticOutline1.m("first: ", stringifyShort((HealthSession) CollectionsKt.first(collection2)), ", last: ", stringifyShort((HealthSession) CollectionsKt.last(collection2)));
        }
        return "size: " + size + " " + strM;
    }

    public static final String getPrettyDateTime(long j) {
        return Utils.format(Utils.getCalendar(j), "MM-dd HH:mm:ss.SSS");
    }

    public static final String getPrettyMillis(long j) {
        return Utils.format(Utils.getCalendar(j), "yyyy-MM-dd HH:mm:ss.SSS");
    }

    public static final String getPrettyTime(long j) {
        return Utils.format(Utils.getCalendar(j), "HH:mm:ss.SSS");
    }

    public static final boolean hasBrokenSegments(Collection<? extends HealthSessionSegment> collection) {
        collection.getClass();
        if (isManual(collection)) {
            return false;
        }
        Iterable<IndexedValue> iterableWithIndex = CollectionsKt.withIndex(ordered(collection));
        if ((iterableWithIndex instanceof Collection) && ((Collection) iterableWithIndex).isEmpty()) {
            return false;
        }
        for (IndexedValue indexedValue : iterableWithIndex) {
            int index = indexedValue.getIndex();
            HealthSessionSegment healthSessionSegment = (HealthSessionSegment) indexedValue.component2();
            if (index >= 1 && healthSessionSegment.getSleepSegmentType() == null) {
                return true;
            }
        }
        return false;
    }

    public static final <S extends HealthSession> boolean isConsistent(S s) {
        s.getClass();
        final String str = "sync:consistency";
        final boolean z = false;
        FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.sleep.service.health.HeathSyncKt$isConsistent$$inlined$featureLog$default$1
            @Override // com.urbandroid.common.FeatureLogger
            public String getTag() {
                String str2 = str;
                boolean z2 = z;
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str2);
                String strConcat = "";
                if (z2) {
                    String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
                    if (strM == null) {
                        strConcat = null;
                    } else if (!StringsKt.isBlank(strM)) {
                        strConcat = ":".concat(strM);
                    }
                }
                sbM.append(strConcat);
                return sbM.toString();
            }
        };
        if (s.getSegments().isEmpty()) {
            return true;
        }
        List<HealthSessionSegment> listOrdered = ordered(s.getSegments());
        long fromInMillis = ((HealthSessionSegment) CollectionsKt.first((List) listOrdered)).getFromInMillis();
        if (s.getFromInMillis() != fromInMillis) {
            String id = s.getId();
            String prettyDateTime = getPrettyDateTime(s.getFromInMillis());
            String prettyDateTime2 = getPrettyDateTime(fromInMillis);
            StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("session ", id, " is not consistent - first segment time ", prettyDateTime, " != from session start ");
            sbM6m.append(prettyDateTime2);
            String string = sbM6m.toString();
            Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + ": " + string, null);
            return false;
        }
        long toInMillis = ((HealthSessionSegment) CollectionsKt.last((List) listOrdered)).getToInMillis();
        if (s.getToInMillis() != toInMillis) {
            String id2 = s.getId();
            String prettyDateTime3 = getPrettyDateTime(s.getToInMillis());
            String prettyDateTime4 = getPrettyDateTime(toInMillis);
            StringBuilder sbM6m2 = FileInsert$$ExternalSyntheticOutline0.m6m("session ", id2, " is not consistent - last segment time ", prettyDateTime3, " != from session end ");
            sbM6m2.append(prettyDateTime4);
            String string2 = sbM6m2.toString();
            Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + ": " + string2, null);
            return false;
        }
        int i = 0;
        for (Object obj : listOrdered) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            HealthSessionSegment healthSessionSegment = (HealthSessionSegment) obj;
            if (i != 0) {
                HealthSessionSegment healthSessionSegment2 = listOrdered.get(i - 1);
                if (healthSessionSegment2.getToInMillis() != healthSessionSegment.getFromInMillis()) {
                    String id3 = s.getId();
                    String strPretty = pretty(healthSessionSegment2);
                    String strPretty2 = pretty(healthSessionSegment);
                    StringBuilder sbM6m3 = FileInsert$$ExternalSyntheticOutline0.m6m("session ", id3, " has not joined segments: ", strPretty, "\t");
                    sbM6m3.append(strPretty2);
                    String string3 = sbM6m3.toString();
                    Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + ": " + string3, null);
                    z = true;
                }
            }
            i = i2;
        }
        return !z;
    }

    public static final boolean isManual(Collection<? extends HealthSessionSegment> collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return true;
        }
        Collection<? extends HealthSessionSegment> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (HealthSessionSegment healthSessionSegment : collection2) {
            if (healthSessionSegment.getSleepSegmentType() != null && !CollectionsKt.contains(SetsKt.setOf(SleepSegmentType.AWAKE_PAUSED), healthSessionSegment.getSleepSegmentType())) {
                return false;
            }
        }
        return true;
    }

    public static final <S extends HealthSession> void markDuplicatesAsBroken(Collection<? extends S> collection) {
        collection.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : collection) {
            HealthSession healthSession = (HealthSession) obj;
            Pair pair = TuplesKt.to(Long.valueOf(healthSession.getFromInMillis()), Long.valueOf(healthSession.getToInMillis()));
            Object arrayList = linkedHashMap.get(pair);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(pair, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((List) entry.getValue()).size() > 1) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Logger.logInfo("Duplicate sessions marking as Broken: " + entry2.getValue(), null);
            Iterator it = CollectionsKt.drop((Iterable) entry2.getValue(), 1).iterator();
            while (it.hasNext()) {
                ((HealthSession) it.next()).markAsDuplicate();
            }
        }
    }

    public static final Date max(Date date, Date date2) {
        date.getClass();
        date2.getClass();
        return (date.getTime() == date2.getTime() || date.after(date2)) ? date : date2;
    }

    public static final Date min(Date date, Date date2) {
        date.getClass();
        date2.getClass();
        return (date.getTime() == date2.getTime() || date.before(date2)) ? date : date2;
    }

    public static final List<HealthSessionSegment> nonNull(Collection<? extends HealthSessionSegment> collection) {
        collection.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (((HealthSessionSegment) obj).getSleepSegmentType() != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final List<HealthSessionSegment> ordered(Collection<? extends HealthSessionSegment> collection) {
        collection.getClass();
        return CollectionsKt.sortedWith(collection, new Comparator() { // from class: com.urbandroid.sleep.service.health.HeathSyncKt$ordered$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((HealthSessionSegment) t).getFromInMillis()), Long.valueOf(((HealthSessionSegment) t2).getFromInMillis()));
            }
        });
    }

    public static final String pretty(HealthSessionSegment healthSessionSegment) {
        healthSessionSegment.getClass();
        return Fragment$$ExternalSyntheticOutline1.m(healthSessionSegment.mo2047short(), " ", getPrettyTime(healthSessionSegment.getFromInMillis()), "-", getPrettyTime(healthSessionSegment.getToInMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence pretty$lambda$0(HealthSessionSegment healthSessionSegment) {
        healthSessionSegment.getClass();
        return pretty(healthSessionSegment);
    }

    public static final List<SleepRecord> readSyncRecords(ISleepRecordRepository iSleepRecordRepository, long j, long j2) {
        iSleepRecordRepository.getClass();
        List<SleepRecord> sleepRecords = iSleepRecordRepository.getSleepRecords(j, j2, false);
        sleepRecords.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : sleepRecords) {
            if (((SleepRecord) obj).getFromTime() >= j) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final String stringify(HealthSession healthSession) {
        healthSession.getClass();
        String id = healthSession.getId();
        boolean zIsConsistent = isConsistent(healthSession);
        long time = healthSession.getFrom().getTime();
        Date to = healthSession.getTo();
        Long lValueOf = to != null ? Long.valueOf(to.getTime()) : null;
        String prettyDateTime = getPrettyDateTime(healthSession.getFrom().getTime());
        Date to2 = healthSession.getTo();
        String prettyDateTime2 = to2 != null ? getPrettyDateTime(to2.getTime()) : null;
        String strPretty = pretty(healthSession.getSegments());
        StringBuilder sb = new StringBuilder("[");
        sb.append(id);
        sb.append(" consistent=");
        sb.append(zIsConsistent);
        sb.append(" <");
        sb.append(time);
        sb.append(", ");
        sb.append(lValueOf);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "> ", prettyDateTime, ",", prettyDateTime2);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ", ", strPretty, "]");
    }

    public static final String stringifyShort(HealthSession healthSession) {
        healthSession.getClass();
        String id = healthSession.getId();
        long time = healthSession.getFrom().getTime();
        Date to = healthSession.getTo();
        Long lValueOf = to != null ? Long.valueOf(to.getTime()) : null;
        String prettyDate = Utils.getPrettyDate(healthSession.getFrom().getTime());
        Date to2 = healthSession.getTo();
        String prettyDate2 = to2 != null ? Utils.getPrettyDate(to2.getTime()) : null;
        StringBuilder sb = new StringBuilder("[");
        sb.append(id);
        sb.append(" <");
        sb.append(time);
        sb.append(", ");
        sb.append(lValueOf);
        sb.append("> ");
        sb.append(prettyDate);
        return Fragment$$ExternalSyntheticOutline1.m(sb, ",", prettyDate2, "]");
    }

    public static final List<SleepRecord> toSleepRecords(List<? extends HealthSession> list) {
        list.getClass();
        ArrayList arrayList = new ArrayList();
        for (HealthSession healthSession : list) {
            SleepRecordHealthSession sleepRecordHealthSession = healthSession instanceof SleepRecordHealthSession ? (SleepRecordHealthSession) healthSession : null;
            SleepRecord sleepRecord = sleepRecordHealthSession != null ? sleepRecordHealthSession.getSleepRecord() : null;
            if (sleepRecord != null) {
                arrayList.add(sleepRecord);
            }
        }
        return arrayList;
    }

    public static final String pretty(Collection<? extends HealthSessionSegment> collection) {
        collection.getClass();
        return CollectionsKt.joinToString$default(collection, ",", "[", "]", new AiPrompt$$ExternalSyntheticLambda0(29), 24);
    }

    public static final <S extends HealthSession> List<String> stringify(Collection<? extends S> collection) {
        collection.getClass();
        Collection<? extends S> collection2 = collection;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(stringify((HealthSession) it.next()));
        }
        return arrayList;
    }
}
