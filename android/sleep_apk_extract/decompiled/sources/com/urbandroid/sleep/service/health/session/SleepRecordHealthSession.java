package com.urbandroid.sleep.service.health.session;

import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.domain.Event;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.service.google.fit.session.GoogleFitSessionSegment;
import com.urbandroid.sleep.service.health.HealthDataSourceProvider;
import com.urbandroid.sleep.service.health.HeathSyncKt;
import com.urbandroid.sleep.service.health.session.idresolver.IdResolver;
import com.urbandroid.sleep.service.samsung.shealth.session.SamsungSHealthSessionSegment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b*\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0016¨\u0006 "}, d2 = {"Lcom/urbandroid/sleep/service/health/session/SleepRecordHealthSession;", "Lcom/urbandroid/sleep/service/health/session/AbstractHealthSession;", "Lcom/urbandroid/sleep/domain/SleepRecord;", "sleepRecord", "Lcom/urbandroid/sleep/service/health/session/idresolver/IdResolver;", "idResolver", "<init>", "(Lcom/urbandroid/sleep/domain/SleepRecord;Lcom/urbandroid/sleep/service/health/session/idresolver/IdResolver;)V", "", "Lcom/urbandroid/sleep/domain/Event;", "Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;", "type", "Lcom/urbandroid/sleep/service/health/session/BaseHealthSessionSegment;", "toSegments", "(Ljava/util/List;Lcom/urbandroid/sleep/service/health/session/SleepSegmentType;)Ljava/util/List;", "toSegmentedSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "toSleepRecord", "Lcom/urbandroid/sleep/domain/SleepRecord;", "", "isFinished", "Z", "()Z", "setFinished", "(Z)V", "", "getActivity", "()Ljava/lang/String;", "activity", "isSportActivity", "isWalkingActivity", "isSleepActivity", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepRecordHealthSession extends AbstractHealthSession {
    private boolean isFinished;
    private final SleepRecord sleepRecord;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:132:0x042a A[LOOP:45: B:130:0x0424->B:132:0x042a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x050a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0715 A[LOOP:6: B:244:0x070f->B:246:0x0715, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x07c2  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x09f8 A[LOOP:14: B:357:0x09f2->B:359:0x09f8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0aa5  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x0ad6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0ee8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:543:0x0f1e  */
    /* JADX WARN: Removed duplicated region for block: B:561:0x0fb2  */
    /* JADX WARN: Removed duplicated region for block: B:579:0x1044  */
    /* JADX WARN: Removed duplicated region for block: B:583:0x106f  */
    /* JADX WARN: Removed duplicated region for block: B:656:0x12af  */
    /* JADX WARN: Removed duplicated region for block: B:665:0x12e2  */
    /* JADX WARN: Removed duplicated region for block: B:683:0x1375  */
    /* JADX WARN: Removed duplicated region for block: B:701:0x1407  */
    /* JADX WARN: Removed duplicated region for block: B:705:0x1432  */
    /* JADX WARN: Removed duplicated region for block: B:779:0x1671  */
    /* JADX WARN: Removed duplicated region for block: B:788:0x16a3  */
    /* JADX WARN: Removed duplicated region for block: B:824:0x17c8  */
    /* JADX WARN: Removed duplicated region for block: B:828:0x17f4  */
    /* JADX WARN: Removed duplicated region for block: B:883:0x1996  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SleepRecordHealthSession(SleepRecord sleepRecord, IdResolver idResolver) {
        int i;
        String str;
        String str2;
        Iterator it;
        Iterator it2;
        String str3;
        Class<SamsungSHealthSessionSegment> cls;
        List listPlus;
        BaseHealthSessionSegment baseHealthSessionSegment;
        List listListOf;
        Iterator it3;
        List list;
        HealthSessionSegment healthSessionSegment;
        BaseHealthSessionSegment baseHealthSessionSegment2;
        long j;
        long j2;
        HealthSessionSegment baseHealthSessionSegment3;
        Iterator it4;
        long j3;
        List listSortedWith;
        Iterator it5;
        long j4;
        List listEmptyList;
        BaseHealthSessionSegment baseHealthSessionSegment4;
        BaseHealthSessionSegment baseHealthSessionSegment5;
        BaseHealthSessionSegment baseHealthSessionSegment6;
        BaseHealthSessionSegment baseHealthSessionSegment7;
        Iterator it6;
        List<HealthSessionSegment> list2;
        List listSortedWith2;
        Iterator it7;
        List<HealthSessionSegment> list3;
        Iterator it8;
        List listEmptyList2;
        BaseHealthSessionSegment baseHealthSessionSegment8;
        BaseHealthSessionSegment baseHealthSessionSegment9;
        BaseHealthSessionSegment baseHealthSessionSegment10;
        BaseHealthSessionSegment baseHealthSessionSegment11;
        Iterator it9;
        long j5;
        List listSortedWith3;
        Iterator it10;
        long j6;
        Iterator it11;
        List listEmptyList3;
        BaseHealthSessionSegment baseHealthSessionSegment12;
        BaseHealthSessionSegment baseHealthSessionSegment13;
        BaseHealthSessionSegment baseHealthSessionSegment14;
        BaseHealthSessionSegment baseHealthSessionSegment15;
        Iterator it12;
        Iterator it13;
        List list4;
        Iterator it14;
        BaseHealthSessionSegment baseHealthSessionSegment16;
        List list5;
        Iterator it15;
        Iterator it16;
        List listPlus2;
        Iterator it17;
        BaseHealthSessionSegment baseHealthSessionSegment17;
        List list6;
        Iterator it18;
        Iterator it19;
        Iterator it20;
        List list7;
        List listPlus3;
        Iterator it21;
        BaseHealthSessionSegment baseHealthSessionSegment18;
        Iterator it22;
        BaseHealthSessionSegment baseHealthSessionSegment19;
        sleepRecord.getClass();
        idResolver.getClass();
        String strResolveId = idResolver.resolveId(sleepRecord);
        strResolveId.getClass();
        HealthDataSourceProvider healthDataSourceProvider = HealthDataSourceProvider.SLEEP;
        Date from = sleepRecord.getFrom();
        from.getClass();
        Date to = sleepRecord.getTo();
        String str4 = "Required value was null.";
        if (to == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        super(strResolveId, healthDataSourceProvider, from, to, null, 16, null);
        this.sleepRecord = sleepRecord;
        sleepRecord.getEvents();
        List<Event> copiedEvents = sleepRecord.getEvents().getCopiedEvents();
        List<HealthSessionSegment> segments = getSegments();
        copiedEvents.getClass();
        List listPlus4 = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) toSegments(copiedEvents, SleepSegmentType.AWAKE_PAUSED), (Iterable) toSegments(copiedEvents, SleepSegmentType.AWAKE)), (Iterable) toSegments(copiedEvents, SleepSegmentType.AWAKE_WALKING)), (Iterable) toSegments(copiedEvents, SleepSegmentType.REM)), (Iterable) toSegments(copiedEvents, SleepSegmentType.LIGHT)), (Iterable) toSegments(copiedEvents, SleepSegmentType.DEEP));
        long time = sleepRecord.getFrom().getTime();
        Date to2 = sleepRecord.getTo();
        if (to2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
            throw null;
        }
        long time2 = to2.getTime();
        List list8 = listPlus4;
        ArrayList arrayList = new ArrayList();
        Iterator it23 = list8.iterator();
        while (true) {
            i = 1;
            if (!it23.hasNext()) {
                break;
            }
            Object next = it23.next();
            SleepSegmentType sleepSegmentType = ((HealthSessionSegment) next).getSleepSegmentType();
            if (sleepSegmentType != null && sleepSegmentType.isAwake()) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it24 = arrayList.iterator();
        while (true) {
            String str5 = "no copy implementation for BaseHealthSessionSegment class";
            Class<SamsungSHealthSessionSegment> cls2 = SamsungSHealthSessionSegment.class;
            if (it24.hasNext()) {
                HealthSessionSegment healthSessionSegment2 = (HealthSessionSegment) it24.next();
                int i2 = i;
                SleepSegmentType sleepSegmentType2 = SleepSegmentType.AWAKE_PAUSED;
                String str6 = str4;
                long fromInMillis = healthSessionSegment2.getFromInMillis();
                long toInMillis = healthSessionSegment2.getToInMillis();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                List list9 = list8;
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                    baseHealthSessionSegment19 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType2, new Date(fromInMillis), new Date(toInMillis));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls2))) {
                    baseHealthSessionSegment19 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType2, new Date(fromInMillis), new Date(toInMillis));
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("no copy implementation for BaseHealthSessionSegment class");
                        throw null;
                    }
                    baseHealthSessionSegment19 = new BaseHealthSessionSegment(sleepSegmentType2, new Date(fromInMillis), new Date(toInMillis));
                }
                arrayList2.add(baseHealthSessionSegment19);
                i = i2;
                str4 = str6;
                list8 = list9;
            } else {
                List list10 = list8;
                String str7 = str4;
                int i3 = i;
                String str8 = "no merge implementation for BaseHealthSessionSegment class";
                String str9 = "Empty collection can't be reduced.";
                if (arrayList2.isEmpty()) {
                    str = "no merge implementation for BaseHealthSessionSegment class";
                    str2 = "Empty collection can't be reduced.";
                    list = arrayList2;
                } else if (arrayList2.isEmpty()) {
                    str = str8;
                    str2 = str9;
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : arrayList2) {
                        HealthSessionSegment healthSessionSegment3 = (HealthSessionSegment) obj;
                        if (healthSessionSegment3.getFromInMillis() != healthSessionSegment3.getToInMillis()) {
                            arrayList3.add(obj);
                        }
                    }
                    List listSortedWith4 = CollectionsKt.sortedWith(arrayList3, new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                    List listEmptyList4 = CollectionsKt.emptyList();
                    it = listSortedWith4.iterator();
                    List list11 = listEmptyList4;
                    while (it.hasNext()) {
                        HealthSessionSegment healthSessionSegment4 = (HealthSessionSegment) it.next();
                        if (list11.isEmpty()) {
                            listListOf = CollectionsKt.listOf(healthSessionSegment4);
                            it2 = it;
                            str3 = str5;
                            cls = cls2;
                        } else {
                            it2 = it;
                            List list12 = list11;
                            List list13 = list11;
                            if ((list12 instanceof Collection) && list12.isEmpty()) {
                                str3 = str5;
                                cls = cls2;
                                String strMo2047short = healthSessionSegment4.mo2047short();
                                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list12, 10));
                                it3 = list12.iterator();
                                while (it3.hasNext()) {
                                }
                                Logger.logWarning("plusMerge failure: not the same types: " + strMo2047short + " " + arrayList4, null);
                                listPlus = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list13, healthSessionSegment4);
                                listListOf = listPlus;
                            } else {
                                Iterator it25 = list12.iterator();
                                while (it25.hasNext()) {
                                    Iterator it26 = it25;
                                    str3 = str5;
                                    if (((HealthSessionSegment) it25.next()).getSleepSegmentType() != healthSessionSegment4.getSleepSegmentType()) {
                                        str5 = str3;
                                        it25 = it26;
                                    } else {
                                        ArrayList arrayList5 = new ArrayList();
                                        ArrayList arrayList6 = new ArrayList();
                                        Iterator it27 = list12.iterator();
                                        while (it27.hasNext()) {
                                            Iterator it28 = it27;
                                            Object next2 = it28.next();
                                            Class<SamsungSHealthSessionSegment> cls3 = cls2;
                                            if (HealthIntervalKt.hasIntersection((HealthSessionSegment) next2, healthSessionSegment4)) {
                                                arrayList5.add(next2);
                                            } else {
                                                arrayList6.add(next2);
                                            }
                                            it27 = it28;
                                            cls2 = cls3;
                                        }
                                        cls = cls2;
                                        Pair pair = new Pair(arrayList5, arrayList6);
                                        List list14 = (List) pair.component1();
                                        List list15 = (List) pair.component2();
                                        Iterator it29 = CollectionsKt.sortedWith(CollectionsKt.distinct(CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list14, healthSessionSegment4)), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1()).iterator();
                                        if (!it29.hasNext()) {
                                            Utf8$$ExternalSyntheticBUOutline0.m(str2);
                                            throw null;
                                        }
                                        Object next3 = it29.next();
                                        while (it29.hasNext()) {
                                            HealthSessionSegment healthSessionSegment5 = (HealthSessionSegment) it29.next();
                                            HealthSessionSegment healthSessionSegment6 = (HealthSessionSegment) next3;
                                            Iterator it30 = it29;
                                            if (healthSessionSegment6.getSleepSegmentType() != healthSessionSegment5.getSleepSegmentType()) {
                                                Logger.logWarning("no same types: " + HeathSyncKt.pretty(healthSessionSegment6) + " " + HeathSyncKt.pretty(healthSessionSegment5), null);
                                            }
                                            if (!HealthIntervalKt.hasIntersection(healthSessionSegment6, healthSessionSegment5) && !SegmentNormalizationKt.isDirectNeighbor(healthSessionSegment6, healthSessionSegment5)) {
                                                Logger.logWarning("segments with no intersection: " + HeathSyncKt.pretty(healthSessionSegment6) + " " + HeathSyncKt.pretty(healthSessionSegment5), null);
                                            }
                                            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                SleepSegmentType sleepSegmentType3 = healthSessionSegment6.getSleepSegmentType();
                                                Date dateMin = HeathSyncKt.min(healthSessionSegment6.getFrom(), healthSessionSegment5.getFrom());
                                                Date to3 = healthSessionSegment6.getTo();
                                                if (to3 == null) {
                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                    throw null;
                                                }
                                                Date to4 = healthSessionSegment5.getTo();
                                                if (to4 == null) {
                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                    throw null;
                                                }
                                                baseHealthSessionSegment = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType3, dateMin, HeathSyncKt.max(to3, to4));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                                                SleepSegmentType sleepSegmentType4 = healthSessionSegment6.getSleepSegmentType();
                                                Date dateMin2 = HeathSyncKt.min(healthSessionSegment6.getFrom(), healthSessionSegment5.getFrom());
                                                Date to5 = healthSessionSegment6.getTo();
                                                if (to5 == null) {
                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                    throw null;
                                                }
                                                Date to6 = healthSessionSegment5.getTo();
                                                if (to6 == null) {
                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                    throw null;
                                                }
                                                baseHealthSessionSegment = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType4, dateMin2, HeathSyncKt.max(to5, to6));
                                            } else {
                                                if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str);
                                                    throw null;
                                                }
                                                SleepSegmentType sleepSegmentType5 = healthSessionSegment6.getSleepSegmentType();
                                                Date dateMin3 = HeathSyncKt.min(healthSessionSegment6.getFrom(), healthSessionSegment5.getFrom());
                                                Date to7 = healthSessionSegment6.getTo();
                                                if (to7 == null) {
                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                    throw null;
                                                }
                                                Date to8 = healthSessionSegment5.getTo();
                                                if (to8 == null) {
                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                    throw null;
                                                }
                                                baseHealthSessionSegment = new BaseHealthSessionSegment(sleepSegmentType5, dateMin3, HeathSyncKt.max(to7, to8));
                                            }
                                            next3 = baseHealthSessionSegment;
                                            it29 = it30;
                                        }
                                        listPlus = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list15, (HealthSessionSegment) next3);
                                        listListOf = listPlus;
                                    }
                                }
                                str3 = str5;
                                cls = cls2;
                                String strMo2047short2 = healthSessionSegment4.mo2047short();
                                ArrayList arrayList42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list12, 10));
                                it3 = list12.iterator();
                                while (it3.hasNext()) {
                                    arrayList42.add(((HealthSessionSegment) it3.next()).mo2047short());
                                }
                                Logger.logWarning("plusMerge failure: not the same types: " + strMo2047short2 + " " + arrayList42, null);
                                listPlus = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list13, healthSessionSegment4);
                                listListOf = listPlus;
                            }
                        }
                        it = it2;
                        str5 = str3;
                        cls2 = cls;
                        list11 = listListOf;
                    }
                    list = list11;
                } else {
                    Iterator it31 = arrayList2.iterator();
                    while (it31.hasNext()) {
                        str = str8;
                        str2 = str9;
                        if (((HealthSessionSegment) it31.next()).getSleepSegmentType() != ((HealthSessionSegment) CollectionsKt.first((List) arrayList2)).getSleepSegmentType()) {
                            Logger.logWarning("merge failure - segments not having same types " + arrayList2, null);
                            list = arrayList2;
                            break;
                        }
                        str8 = str;
                        str9 = str2;
                    }
                    str = str8;
                    str2 = str9;
                    ArrayList arrayList32 = new ArrayList();
                    while (r8.hasNext()) {
                    }
                    List listSortedWith42 = CollectionsKt.sortedWith(arrayList32, new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                    List listEmptyList42 = CollectionsKt.emptyList();
                    it = listSortedWith42.iterator();
                    List list112 = listEmptyList42;
                    while (it.hasNext()) {
                    }
                    list = list112;
                }
                String str10 = str5;
                Class<SamsungSHealthSessionSegment> cls4 = cls2;
                ArrayList arrayList7 = new ArrayList();
                for (Object obj2 : list10) {
                    if (((HealthSessionSegment) obj2).getSleepSegmentType() == SleepSegmentType.REM) {
                        arrayList7.add(obj2);
                    }
                }
                boolean zIsEmpty = arrayList7.isEmpty();
                List list16 = arrayList7;
                List list17 = list;
                if (!zIsEmpty) {
                    if (arrayList7.isEmpty()) {
                        ArrayList arrayList8 = new ArrayList();
                        for (Object obj3 : arrayList7) {
                            HealthSessionSegment healthSessionSegment7 = (HealthSessionSegment) obj3;
                            if (healthSessionSegment7.getFromInMillis() != healthSessionSegment7.getToInMillis()) {
                                arrayList8.add(obj3);
                            }
                        }
                        List listSortedWith5 = CollectionsKt.sortedWith(arrayList8, new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                        List listEmptyList5 = CollectionsKt.emptyList();
                        it19 = listSortedWith5.iterator();
                        List list18 = list;
                        while (it19.hasNext()) {
                            HealthSessionSegment healthSessionSegment8 = (HealthSessionSegment) it19.next();
                            if (listEmptyList5.isEmpty()) {
                                listEmptyList5 = CollectionsKt.listOf(healthSessionSegment8);
                                it20 = it19;
                                list7 = list18;
                            } else {
                                List list19 = listEmptyList5;
                                if ((list19 instanceof Collection) && list19.isEmpty()) {
                                    it20 = it19;
                                    List list20 = listEmptyList5;
                                    list7 = list18;
                                    String strMo2047short3 = healthSessionSegment8.mo2047short();
                                    ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list19, 10));
                                    it22 = list19.iterator();
                                    while (it22.hasNext()) {
                                    }
                                    Logger.logWarning("plusMerge failure: not the same types: " + strMo2047short3 + " " + arrayList9, null);
                                    listPlus3 = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list20, healthSessionSegment8);
                                    listEmptyList5 = listPlus3;
                                } else {
                                    Iterator it32 = list19.iterator();
                                    while (it32.hasNext()) {
                                        it20 = it19;
                                        List list21 = listEmptyList5;
                                        if (((HealthSessionSegment) it32.next()).getSleepSegmentType() != healthSessionSegment8.getSleepSegmentType()) {
                                            listEmptyList5 = list21;
                                            it19 = it20;
                                        } else {
                                            ArrayList arrayList10 = new ArrayList();
                                            ArrayList arrayList11 = new ArrayList();
                                            List list22 = list18;
                                            for (Object obj4 : list19) {
                                                List list23 = list22;
                                                if (HealthIntervalKt.hasIntersection((HealthSessionSegment) obj4, healthSessionSegment8)) {
                                                    arrayList10.add(obj4);
                                                } else {
                                                    arrayList11.add(obj4);
                                                }
                                                list22 = list23;
                                            }
                                            list7 = list22;
                                            Pair pair2 = new Pair(arrayList10, arrayList11);
                                            List list24 = (List) pair2.component1();
                                            List list25 = (List) pair2.component2();
                                            Iterator it33 = CollectionsKt.sortedWith(CollectionsKt.distinct(CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list24, healthSessionSegment8)), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1()).iterator();
                                            if (!it33.hasNext()) {
                                                Utf8$$ExternalSyntheticBUOutline0.m(str2);
                                                throw null;
                                            }
                                            Object next4 = it33.next();
                                            while (it33.hasNext()) {
                                                HealthSessionSegment healthSessionSegment9 = (HealthSessionSegment) it33.next();
                                                HealthSessionSegment healthSessionSegment10 = (HealthSessionSegment) next4;
                                                if (healthSessionSegment10.getSleepSegmentType() != healthSessionSegment9.getSleepSegmentType()) {
                                                    it21 = it33;
                                                    Logger.logWarning("no same types: " + HeathSyncKt.pretty(healthSessionSegment10) + " " + HeathSyncKt.pretty(healthSessionSegment9), null);
                                                } else {
                                                    it21 = it33;
                                                }
                                                if (!HealthIntervalKt.hasIntersection(healthSessionSegment10, healthSessionSegment9) && !SegmentNormalizationKt.isDirectNeighbor(healthSessionSegment10, healthSessionSegment9)) {
                                                    Logger.logWarning("segments with no intersection: " + HeathSyncKt.pretty(healthSessionSegment10) + " " + HeathSyncKt.pretty(healthSessionSegment9), null);
                                                }
                                                KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                    SleepSegmentType sleepSegmentType6 = healthSessionSegment10.getSleepSegmentType();
                                                    Date dateMin4 = HeathSyncKt.min(healthSessionSegment10.getFrom(), healthSessionSegment9.getFrom());
                                                    Date to9 = healthSessionSegment10.getTo();
                                                    if (to9 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    Date to10 = healthSessionSegment9.getTo();
                                                    if (to10 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    baseHealthSessionSegment18 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType6, dateMin4, HeathSyncKt.max(to9, to10));
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls4))) {
                                                    SleepSegmentType sleepSegmentType7 = healthSessionSegment10.getSleepSegmentType();
                                                    Date dateMin5 = HeathSyncKt.min(healthSessionSegment10.getFrom(), healthSessionSegment9.getFrom());
                                                    Date to11 = healthSessionSegment10.getTo();
                                                    if (to11 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    Date to12 = healthSessionSegment9.getTo();
                                                    if (to12 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    baseHealthSessionSegment18 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType7, dateMin5, HeathSyncKt.max(to11, to12));
                                                } else {
                                                    if (!Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str);
                                                        throw null;
                                                    }
                                                    SleepSegmentType sleepSegmentType8 = healthSessionSegment10.getSleepSegmentType();
                                                    Date dateMin6 = HeathSyncKt.min(healthSessionSegment10.getFrom(), healthSessionSegment9.getFrom());
                                                    Date to13 = healthSessionSegment10.getTo();
                                                    if (to13 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    Date to14 = healthSessionSegment9.getTo();
                                                    if (to14 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    baseHealthSessionSegment18 = new BaseHealthSessionSegment(sleepSegmentType8, dateMin6, HeathSyncKt.max(to13, to14));
                                                }
                                                next4 = baseHealthSessionSegment18;
                                                it33 = it21;
                                            }
                                            listPlus3 = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list25, (HealthSessionSegment) next4);
                                            listEmptyList5 = listPlus3;
                                        }
                                    }
                                    it20 = it19;
                                    List list202 = listEmptyList5;
                                    list7 = list18;
                                    String strMo2047short32 = healthSessionSegment8.mo2047short();
                                    ArrayList arrayList92 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list19, 10));
                                    it22 = list19.iterator();
                                    while (it22.hasNext()) {
                                        arrayList92.add(((HealthSessionSegment) it22.next()).mo2047short());
                                    }
                                    Logger.logWarning("plusMerge failure: not the same types: " + strMo2047short32 + " " + arrayList92, null);
                                    listPlus3 = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list202, healthSessionSegment8);
                                    listEmptyList5 = listPlus3;
                                }
                            }
                            it19 = it20;
                            list18 = list7;
                        }
                        list16 = listEmptyList5;
                        list17 = list18;
                    } else {
                        Iterator it34 = arrayList7.iterator();
                        while (it34.hasNext()) {
                            if (((HealthSessionSegment) it34.next()).getSleepSegmentType() != ((HealthSessionSegment) CollectionsKt.first((List) arrayList7)).getSleepSegmentType()) {
                                Logger.logWarning("merge failure - segments not having same types " + arrayList7, null);
                                list16 = arrayList7;
                                list17 = list;
                                break;
                            }
                        }
                        ArrayList arrayList82 = new ArrayList();
                        while (r0.hasNext()) {
                        }
                        List listSortedWith52 = CollectionsKt.sortedWith(arrayList82, new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                        List listEmptyList52 = CollectionsKt.emptyList();
                        it19 = listSortedWith52.iterator();
                        List list182 = list;
                        while (it19.hasNext()) {
                        }
                        list16 = listEmptyList52;
                        list17 = list182;
                    }
                }
                List list26 = list17;
                ArrayList arrayList12 = new ArrayList();
                for (Object obj5 : list10) {
                    if (((HealthSessionSegment) obj5).getSleepSegmentType() == SleepSegmentType.LIGHT) {
                        arrayList12.add(obj5);
                    }
                }
                boolean zIsEmpty2 = arrayList12.isEmpty();
                List list27 = list16;
                List list28 = arrayList12;
                if (!zIsEmpty2) {
                    if (arrayList12.isEmpty()) {
                        ArrayList arrayList13 = new ArrayList();
                        for (Object obj6 : arrayList12) {
                            HealthSessionSegment healthSessionSegment11 = (HealthSessionSegment) obj6;
                            if (healthSessionSegment11.getFromInMillis() != healthSessionSegment11.getToInMillis()) {
                                arrayList13.add(obj6);
                            }
                        }
                        List listSortedWith6 = CollectionsKt.sortedWith(arrayList13, new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                        List listEmptyList6 = CollectionsKt.emptyList();
                        it15 = listSortedWith6.iterator();
                        List list29 = list16;
                        while (it15.hasNext()) {
                            HealthSessionSegment healthSessionSegment12 = (HealthSessionSegment) it15.next();
                            if (listEmptyList6.isEmpty()) {
                                listEmptyList6 = CollectionsKt.listOf(healthSessionSegment12);
                                list6 = list29;
                                it16 = it15;
                            } else {
                                List list30 = listEmptyList6;
                                if ((list30 instanceof Collection) && list30.isEmpty()) {
                                    list6 = list29;
                                    it16 = it15;
                                    String strMo2047short4 = healthSessionSegment12.mo2047short();
                                    List list31 = listEmptyList6;
                                    ArrayList arrayList14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list30, 10));
                                    it18 = list30.iterator();
                                    while (it18.hasNext()) {
                                    }
                                    Logger.logWarning("plusMerge failure: not the same types: " + strMo2047short4 + " " + arrayList14, null);
                                    listPlus2 = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list31, healthSessionSegment12);
                                    listEmptyList6 = listPlus2;
                                } else {
                                    Iterator it35 = list30.iterator();
                                    list29 = list29;
                                    while (it35.hasNext()) {
                                        List list32 = list29;
                                        it16 = it15;
                                        if (((HealthSessionSegment) it35.next()).getSleepSegmentType() != healthSessionSegment12.getSleepSegmentType()) {
                                            it15 = it16;
                                            list29 = list32;
                                        } else {
                                            ArrayList arrayList15 = new ArrayList();
                                            ArrayList arrayList16 = new ArrayList();
                                            for (Object obj7 : list30) {
                                                if (HealthIntervalKt.hasIntersection((HealthSessionSegment) obj7, healthSessionSegment12)) {
                                                    arrayList15.add(obj7);
                                                } else {
                                                    arrayList16.add(obj7);
                                                }
                                            }
                                            Pair pair3 = new Pair(arrayList15, arrayList16);
                                            List list33 = (List) pair3.component1();
                                            List list34 = (List) pair3.component2();
                                            Iterator it36 = CollectionsKt.sortedWith(CollectionsKt.distinct(CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list33, healthSessionSegment12)), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1()).iterator();
                                            if (!it36.hasNext()) {
                                                Utf8$$ExternalSyntheticBUOutline0.m(str2);
                                                throw null;
                                            }
                                            Object next5 = it36.next();
                                            while (it36.hasNext()) {
                                                HealthSessionSegment healthSessionSegment13 = (HealthSessionSegment) it36.next();
                                                HealthSessionSegment healthSessionSegment14 = (HealthSessionSegment) next5;
                                                if (healthSessionSegment14.getSleepSegmentType() != healthSessionSegment13.getSleepSegmentType()) {
                                                    it17 = it36;
                                                    Logger.logWarning("no same types: " + HeathSyncKt.pretty(healthSessionSegment14) + " " + HeathSyncKt.pretty(healthSessionSegment13), null);
                                                } else {
                                                    it17 = it36;
                                                }
                                                if (!HealthIntervalKt.hasIntersection(healthSessionSegment14, healthSessionSegment13) && !SegmentNormalizationKt.isDirectNeighbor(healthSessionSegment14, healthSessionSegment13)) {
                                                    Logger.logWarning("segments with no intersection: " + HeathSyncKt.pretty(healthSessionSegment14) + " " + HeathSyncKt.pretty(healthSessionSegment13), null);
                                                }
                                                KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                    SleepSegmentType sleepSegmentType9 = healthSessionSegment14.getSleepSegmentType();
                                                    Date dateMin7 = HeathSyncKt.min(healthSessionSegment14.getFrom(), healthSessionSegment13.getFrom());
                                                    Date to15 = healthSessionSegment14.getTo();
                                                    if (to15 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    Date to16 = healthSessionSegment13.getTo();
                                                    if (to16 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    baseHealthSessionSegment17 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType9, dateMin7, HeathSyncKt.max(to15, to16));
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls4))) {
                                                    SleepSegmentType sleepSegmentType10 = healthSessionSegment14.getSleepSegmentType();
                                                    Date dateMin8 = HeathSyncKt.min(healthSessionSegment14.getFrom(), healthSessionSegment13.getFrom());
                                                    Date to17 = healthSessionSegment14.getTo();
                                                    if (to17 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    Date to18 = healthSessionSegment13.getTo();
                                                    if (to18 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    baseHealthSessionSegment17 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType10, dateMin8, HeathSyncKt.max(to17, to18));
                                                } else {
                                                    if (!Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str);
                                                        throw null;
                                                    }
                                                    SleepSegmentType sleepSegmentType11 = healthSessionSegment14.getSleepSegmentType();
                                                    Date dateMin9 = HeathSyncKt.min(healthSessionSegment14.getFrom(), healthSessionSegment13.getFrom());
                                                    Date to19 = healthSessionSegment14.getTo();
                                                    if (to19 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    Date to20 = healthSessionSegment13.getTo();
                                                    if (to20 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    baseHealthSessionSegment17 = new BaseHealthSessionSegment(sleepSegmentType11, dateMin9, HeathSyncKt.max(to19, to20));
                                                }
                                                next5 = baseHealthSessionSegment17;
                                                it36 = it17;
                                            }
                                            listPlus2 = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list34, (HealthSessionSegment) next5);
                                            list6 = list32;
                                            listEmptyList6 = listPlus2;
                                        }
                                    }
                                    list6 = list29;
                                    it16 = it15;
                                    String strMo2047short42 = healthSessionSegment12.mo2047short();
                                    List list312 = listEmptyList6;
                                    ArrayList arrayList142 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list30, 10));
                                    it18 = list30.iterator();
                                    while (it18.hasNext()) {
                                        arrayList142.add(((HealthSessionSegment) it18.next()).mo2047short());
                                    }
                                    Logger.logWarning("plusMerge failure: not the same types: " + strMo2047short42 + " " + arrayList142, null);
                                    listPlus2 = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list312, healthSessionSegment12);
                                    listEmptyList6 = listPlus2;
                                }
                            }
                            it15 = it16;
                            list29 = list6;
                        }
                        list28 = listEmptyList6;
                        list27 = list29;
                    } else {
                        Iterator it37 = arrayList12.iterator();
                        while (it37.hasNext()) {
                            if (((HealthSessionSegment) it37.next()).getSleepSegmentType() != ((HealthSessionSegment) CollectionsKt.first((List) arrayList12)).getSleepSegmentType()) {
                                Logger.logWarning("merge failure - segments not having same types " + arrayList12, null);
                                list27 = list16;
                                list28 = arrayList12;
                                break;
                            }
                        }
                        ArrayList arrayList132 = new ArrayList();
                        while (r7.hasNext()) {
                        }
                        List listSortedWith62 = CollectionsKt.sortedWith(arrayList132, new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                        List listEmptyList62 = CollectionsKt.emptyList();
                        it15 = listSortedWith62.iterator();
                        List list292 = list16;
                        while (it15.hasNext()) {
                        }
                        list28 = listEmptyList62;
                        list27 = list292;
                    }
                }
                List list35 = list27;
                ArrayList arrayList17 = new ArrayList();
                for (Object obj8 : list10) {
                    if (((HealthSessionSegment) obj8).getSleepSegmentType() == SleepSegmentType.DEEP) {
                        arrayList17.add(obj8);
                    }
                }
                boolean zIsEmpty3 = arrayList17.isEmpty();
                List list36 = arrayList17;
                List list37 = list28;
                if (!zIsEmpty3) {
                    if (arrayList17.isEmpty()) {
                        ArrayList arrayList18 = new ArrayList();
                        for (Object obj9 : arrayList17) {
                            HealthSessionSegment healthSessionSegment15 = (HealthSessionSegment) obj9;
                            if (healthSessionSegment15.getFromInMillis() != healthSessionSegment15.getToInMillis()) {
                                arrayList18.add(obj9);
                            }
                        }
                        List listSortedWith7 = CollectionsKt.sortedWith(arrayList18, new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                        List listEmptyList7 = CollectionsKt.emptyList();
                        it12 = listSortedWith7.iterator();
                        List list38 = list28;
                        while (it12.hasNext()) {
                            HealthSessionSegment healthSessionSegment16 = (HealthSessionSegment) it12.next();
                            if (listEmptyList7.isEmpty()) {
                                listEmptyList7 = CollectionsKt.listOf(healthSessionSegment16);
                                it13 = it12;
                                list4 = list38;
                            } else {
                                List list39 = listEmptyList7;
                                if (!(list39 instanceof Collection) || !list39.isEmpty()) {
                                    Iterator it38 = list39.iterator();
                                    while (it38.hasNext()) {
                                        it13 = it12;
                                        if (((HealthSessionSegment) it38.next()).getSleepSegmentType() != healthSessionSegment16.getSleepSegmentType()) {
                                            it12 = it13;
                                        } else {
                                            ArrayList arrayList19 = new ArrayList();
                                            ArrayList arrayList20 = new ArrayList();
                                            for (Object obj10 : list39) {
                                                if (HealthIntervalKt.hasIntersection((HealthSessionSegment) obj10, healthSessionSegment16)) {
                                                    arrayList19.add(obj10);
                                                } else {
                                                    arrayList20.add(obj10);
                                                }
                                            }
                                            Pair pair4 = new Pair(arrayList19, arrayList20);
                                            List list40 = (List) pair4.component1();
                                            List list41 = (List) pair4.component2();
                                            Iterator it39 = CollectionsKt.sortedWith(CollectionsKt.distinct(CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list40, healthSessionSegment16)), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1()).iterator();
                                            if (!it39.hasNext()) {
                                                Utf8$$ExternalSyntheticBUOutline0.m(str2);
                                                throw null;
                                            }
                                            Object next6 = it39.next();
                                            List list42 = list38;
                                            while (it39.hasNext()) {
                                                HealthSessionSegment healthSessionSegment17 = (HealthSessionSegment) it39.next();
                                                HealthSessionSegment healthSessionSegment18 = (HealthSessionSegment) next6;
                                                if (healthSessionSegment18.getSleepSegmentType() != healthSessionSegment17.getSleepSegmentType()) {
                                                    it14 = it39;
                                                    Logger.logWarning("no same types: " + HeathSyncKt.pretty(healthSessionSegment18) + " " + HeathSyncKt.pretty(healthSessionSegment17), null);
                                                } else {
                                                    it14 = it39;
                                                }
                                                if (!HealthIntervalKt.hasIntersection(healthSessionSegment18, healthSessionSegment17) && !SegmentNormalizationKt.isDirectNeighbor(healthSessionSegment18, healthSessionSegment17)) {
                                                    Logger.logWarning("segments with no intersection: " + HeathSyncKt.pretty(healthSessionSegment18) + " " + HeathSyncKt.pretty(healthSessionSegment17), null);
                                                }
                                                KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                    SleepSegmentType sleepSegmentType12 = healthSessionSegment18.getSleepSegmentType();
                                                    list5 = list42;
                                                    Date dateMin10 = HeathSyncKt.min(healthSessionSegment18.getFrom(), healthSessionSegment17.getFrom());
                                                    Date to21 = healthSessionSegment18.getTo();
                                                    if (to21 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    Date to22 = healthSessionSegment17.getTo();
                                                    if (to22 == null) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                        throw null;
                                                    }
                                                    baseHealthSessionSegment16 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType12, dateMin10, HeathSyncKt.max(to21, to22));
                                                } else {
                                                    List list43 = list42;
                                                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls4))) {
                                                        SleepSegmentType sleepSegmentType13 = healthSessionSegment18.getSleepSegmentType();
                                                        Date dateMin11 = HeathSyncKt.min(healthSessionSegment18.getFrom(), healthSessionSegment17.getFrom());
                                                        Date to23 = healthSessionSegment18.getTo();
                                                        if (to23 == null) {
                                                            Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                            throw null;
                                                        }
                                                        Date to24 = healthSessionSegment17.getTo();
                                                        if (to24 == null) {
                                                            Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                            throw null;
                                                        }
                                                        baseHealthSessionSegment16 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType13, dateMin11, HeathSyncKt.max(to23, to24));
                                                        list5 = list43;
                                                    } else {
                                                        if (!Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                            Utf8$$ExternalSyntheticBUOutline0.m$3(str);
                                                            throw null;
                                                        }
                                                        SleepSegmentType sleepSegmentType14 = healthSessionSegment18.getSleepSegmentType();
                                                        Date dateMin12 = HeathSyncKt.min(healthSessionSegment18.getFrom(), healthSessionSegment17.getFrom());
                                                        Date to25 = healthSessionSegment18.getTo();
                                                        if (to25 == null) {
                                                            Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                            throw null;
                                                        }
                                                        Date to26 = healthSessionSegment17.getTo();
                                                        if (to26 == null) {
                                                            Utf8$$ExternalSyntheticBUOutline0.m$3(str7);
                                                            throw null;
                                                        }
                                                        baseHealthSessionSegment16 = new BaseHealthSessionSegment(sleepSegmentType14, dateMin12, HeathSyncKt.max(to25, to26));
                                                        list5 = list43;
                                                    }
                                                }
                                                next6 = baseHealthSessionSegment16;
                                                it39 = it14;
                                                list42 = list5;
                                            }
                                            list4 = list42;
                                            listEmptyList7 = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list41, (HealthSessionSegment) next6);
                                        }
                                    }
                                }
                                it13 = it12;
                                list4 = list38;
                                String strMo2047short5 = healthSessionSegment16.mo2047short();
                                ArrayList arrayList21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list39, 10));
                                Iterator it40 = list39.iterator();
                                while (it40.hasNext()) {
                                    arrayList21.add(((HealthSessionSegment) it40.next()).mo2047short());
                                }
                                Logger.logWarning("plusMerge failure: not the same types: " + strMo2047short5 + " " + arrayList21, null);
                                listEmptyList7 = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) listEmptyList7, healthSessionSegment16);
                                it12 = it13;
                                list38 = list4;
                            }
                            it12 = it13;
                            list38 = list4;
                        }
                        list36 = listEmptyList7;
                        list37 = list38;
                    } else {
                        Iterator it41 = arrayList17.iterator();
                        while (it41.hasNext()) {
                            if (((HealthSessionSegment) it41.next()).getSleepSegmentType() != ((HealthSessionSegment) CollectionsKt.first((List) arrayList17)).getSleepSegmentType()) {
                                Logger.logWarning("merge failure - segments not having same types " + arrayList17, null);
                                list36 = arrayList17;
                                list37 = list28;
                                break;
                            }
                        }
                        ArrayList arrayList182 = new ArrayList();
                        while (r0.hasNext()) {
                        }
                        List listSortedWith72 = CollectionsKt.sortedWith(arrayList182, new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                        List listEmptyList72 = CollectionsKt.emptyList();
                        it12 = listSortedWith72.iterator();
                        List list382 = list28;
                        while (it12.hasNext()) {
                        }
                        list36 = listEmptyList72;
                        list37 = list382;
                    }
                }
                Iterator it42 = list37.iterator();
                List list44 = list36;
                while (true) {
                    int i4 = 3;
                    int i5 = 2;
                    if (!it42.hasNext()) {
                        long j7 = time2;
                        Iterator it43 = list35.iterator();
                        List list45 = list44;
                        while (it43.hasNext()) {
                            HealthSessionSegment healthSessionSegment19 = (HealthSessionSegment) it43.next();
                            if (list45.isEmpty()) {
                                listSortedWith2 = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list45, healthSessionSegment19);
                            } else {
                                ArrayList arrayList22 = new ArrayList();
                                ArrayList arrayList23 = new ArrayList();
                                for (Object obj11 : list45) {
                                    if (HealthIntervalKt.hasIntersection((HealthSessionSegment) obj11, healthSessionSegment19)) {
                                        arrayList22.add(obj11);
                                    } else {
                                        arrayList23.add(obj11);
                                    }
                                }
                                Pair pair5 = new Pair(arrayList22, arrayList23);
                                List list46 = (List) pair5.component1();
                                List list47 = (List) pair5.component2();
                                if (list46.isEmpty()) {
                                    listSortedWith2 = CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list47, healthSessionSegment19), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                                } else {
                                    List list48 = list47;
                                    List listEmptyList8 = CollectionsKt.emptyList();
                                    Iterator it44 = list46.iterator();
                                    while (it44.hasNext()) {
                                        HealthSessionSegment healthSessionSegment20 = (HealthSessionSegment) it44.next();
                                        List list49 = listEmptyList8;
                                        if (Intrinsics.areEqual(healthSessionSegment19, healthSessionSegment20)) {
                                            listEmptyList2 = CollectionsKt.listOf(healthSessionSegment19);
                                        } else if (HealthIntervalKt.hasIntersection(healthSessionSegment19, healthSessionSegment20)) {
                                            long fromInMillis2 = healthSessionSegment20.getFromInMillis();
                                            long toInMillis2 = healthSessionSegment20.getToInMillis();
                                            long fromInMillis3 = healthSessionSegment19.getFromInMillis();
                                            if (fromInMillis2 > fromInMillis3 || fromInMillis3 > toInMillis2) {
                                                it7 = it43;
                                                list3 = segments;
                                                it8 = it44;
                                                long fromInMillis4 = healthSessionSegment19.getFromInMillis();
                                                long toInMillis3 = healthSessionSegment19.getToInMillis();
                                                long fromInMillis5 = healthSessionSegment20.getFromInMillis();
                                                if (fromInMillis4 <= fromInMillis5 && fromInMillis5 <= toInMillis3) {
                                                    long fromInMillis6 = healthSessionSegment19.getFromInMillis();
                                                    long toInMillis4 = healthSessionSegment19.getToInMillis();
                                                    long toInMillis5 = healthSessionSegment20.getToInMillis();
                                                    if (fromInMillis6 <= toInMillis5 && toInMillis5 <= toInMillis4) {
                                                        listEmptyList2 = CollectionsKt.listOf(healthSessionSegment19);
                                                    }
                                                } else if (healthSessionSegment19.getFromInMillis() < healthSessionSegment20.getFromInMillis()) {
                                                    long fromInMillis7 = healthSessionSegment20.getFromInMillis();
                                                    long toInMillis6 = healthSessionSegment20.getToInMillis();
                                                    long toInMillis7 = healthSessionSegment19.getToInMillis();
                                                    if (fromInMillis7 <= toInMillis7 && toInMillis7 <= toInMillis6) {
                                                        BaseHealthSessionSegment[] baseHealthSessionSegmentArr = new BaseHealthSessionSegment[2];
                                                        baseHealthSessionSegmentArr[0] = healthSessionSegment19;
                                                        long toInMillis8 = healthSessionSegment19.getToInMillis();
                                                        SleepSegmentType sleepSegmentType15 = healthSessionSegment20.getSleepSegmentType();
                                                        long toInMillis9 = healthSessionSegment20.getToInMillis();
                                                        KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                            baseHealthSessionSegment9 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType15, new Date(toInMillis8), new Date(toInMillis9));
                                                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls4))) {
                                                            baseHealthSessionSegment9 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType15, new Date(toInMillis8), new Date(toInMillis9));
                                                        } else {
                                                            if (!Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                                Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                                throw null;
                                                            }
                                                            baseHealthSessionSegment9 = new BaseHealthSessionSegment(sleepSegmentType15, new Date(toInMillis8), new Date(toInMillis9));
                                                        }
                                                        baseHealthSessionSegmentArr[i3] = baseHealthSessionSegment9;
                                                        listEmptyList2 = CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr);
                                                    } else if (healthSessionSegment19.getToInMillis() > healthSessionSegment20.getToInMillis()) {
                                                        long fromInMillis8 = healthSessionSegment20.getFromInMillis();
                                                        long toInMillis10 = healthSessionSegment20.getToInMillis();
                                                        long fromInMillis9 = healthSessionSegment19.getFromInMillis();
                                                        if (fromInMillis8 > fromInMillis9 || fromInMillis9 > toInMillis10) {
                                                            Logger.logWarning("Unable to minus segment " + healthSessionSegment20 + " from " + healthSessionSegment19, null);
                                                            listEmptyList2 = CollectionsKt.emptyList();
                                                        } else {
                                                            BaseHealthSessionSegment[] baseHealthSessionSegmentArr2 = new BaseHealthSessionSegment[2];
                                                            long fromInMillis10 = healthSessionSegment19.getFromInMillis();
                                                            SleepSegmentType sleepSegmentType16 = healthSessionSegment20.getSleepSegmentType();
                                                            long fromInMillis11 = healthSessionSegment20.getFromInMillis();
                                                            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                            if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                                baseHealthSessionSegment8 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType16, new Date(fromInMillis11), new Date(fromInMillis10));
                                                            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls4))) {
                                                                baseHealthSessionSegment8 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType16, new Date(fromInMillis11), new Date(fromInMillis10));
                                                            } else {
                                                                if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                                    throw null;
                                                                }
                                                                baseHealthSessionSegment8 = new BaseHealthSessionSegment(sleepSegmentType16, new Date(fromInMillis11), new Date(fromInMillis10));
                                                            }
                                                            baseHealthSessionSegmentArr2[0] = baseHealthSessionSegment8;
                                                            baseHealthSessionSegmentArr2[i3] = healthSessionSegment19;
                                                            listEmptyList2 = CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr2);
                                                        }
                                                    }
                                                }
                                            } else {
                                                long fromInMillis12 = healthSessionSegment20.getFromInMillis();
                                                long toInMillis11 = healthSessionSegment20.getToInMillis();
                                                long toInMillis12 = healthSessionSegment19.getToInMillis();
                                                if (fromInMillis12 <= toInMillis12 && toInMillis12 <= toInMillis11) {
                                                    BaseHealthSessionSegment[] baseHealthSessionSegmentArr3 = new BaseHealthSessionSegment[3];
                                                    long fromInMillis13 = healthSessionSegment19.getFromInMillis();
                                                    SleepSegmentType sleepSegmentType17 = healthSessionSegment20.getSleepSegmentType();
                                                    it7 = it43;
                                                    list3 = segments;
                                                    long fromInMillis14 = healthSessionSegment20.getFromInMillis();
                                                    it8 = it44;
                                                    KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                    if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                        baseHealthSessionSegment10 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType17, new Date(fromInMillis14), new Date(fromInMillis13));
                                                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls4))) {
                                                        baseHealthSessionSegment10 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType17, new Date(fromInMillis14), new Date(fromInMillis13));
                                                    } else {
                                                        if (!Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                            Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                            throw null;
                                                        }
                                                        baseHealthSessionSegment10 = new BaseHealthSessionSegment(sleepSegmentType17, new Date(fromInMillis14), new Date(fromInMillis13));
                                                    }
                                                    baseHealthSessionSegmentArr3[0] = baseHealthSessionSegment10;
                                                    baseHealthSessionSegmentArr3[i3] = healthSessionSegment19;
                                                    long toInMillis13 = healthSessionSegment19.getToInMillis();
                                                    SleepSegmentType sleepSegmentType18 = healthSessionSegment20.getSleepSegmentType();
                                                    long toInMillis14 = healthSessionSegment20.getToInMillis();
                                                    KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                    if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                        baseHealthSessionSegment11 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType18, new Date(toInMillis13), new Date(toInMillis14));
                                                    } else if (Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(cls4))) {
                                                        baseHealthSessionSegment11 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType18, new Date(toInMillis13), new Date(toInMillis14));
                                                    } else {
                                                        if (!Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                            Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                            throw null;
                                                        }
                                                        baseHealthSessionSegment11 = new BaseHealthSessionSegment(sleepSegmentType18, new Date(toInMillis13), new Date(toInMillis14));
                                                    }
                                                    baseHealthSessionSegmentArr3[2] = baseHealthSessionSegment11;
                                                    listEmptyList2 = CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr3);
                                                }
                                            }
                                            ArrayList arrayList24 = new ArrayList();
                                            for (Object obj12 : listEmptyList2) {
                                                HealthSessionSegment healthSessionSegment21 = (HealthSessionSegment) obj12;
                                                if (healthSessionSegment21.getFromInMillis() != healthSessionSegment21.getToInMillis()) {
                                                    arrayList24.add(obj12);
                                                }
                                            }
                                            listEmptyList8 = CollectionsKt.plus((Collection) list49, (Iterable) arrayList24);
                                            segments = list3;
                                            it43 = it7;
                                            it44 = it8;
                                        } else {
                                            BaseHealthSessionSegment[] baseHealthSessionSegmentArr4 = new BaseHealthSessionSegment[2];
                                            baseHealthSessionSegmentArr4[0] = healthSessionSegment19;
                                            baseHealthSessionSegmentArr4[i3] = healthSessionSegment20;
                                            listEmptyList2 = CollectionsKt.sortedWith(CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr4), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                                        }
                                        it7 = it43;
                                        list3 = segments;
                                        it8 = it44;
                                        ArrayList arrayList242 = new ArrayList();
                                        while (r2.hasNext()) {
                                        }
                                        listEmptyList8 = CollectionsKt.plus((Collection) list49, (Iterable) arrayList242);
                                        segments = list3;
                                        it43 = it7;
                                        it44 = it8;
                                    }
                                    it6 = it43;
                                    list2 = segments;
                                    List listDistinct = CollectionsKt.distinct(CollectionsKt.plus((Collection) list48, (Iterable) listEmptyList8));
                                    ArrayList arrayList25 = new ArrayList();
                                    for (Object obj13 : listDistinct) {
                                        HealthSessionSegment healthSessionSegment22 = (HealthSessionSegment) obj13;
                                        if (healthSessionSegment22.getFromInMillis() != healthSessionSegment22.getToInMillis()) {
                                            arrayList25.add(obj13);
                                        }
                                    }
                                    listSortedWith2 = CollectionsKt.sortedWith(arrayList25, new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                                    segments = list2;
                                    it43 = it6;
                                    list45 = listSortedWith2;
                                }
                            }
                            it6 = it43;
                            list2 = segments;
                            segments = list2;
                            it43 = it6;
                            list45 = listSortedWith2;
                        }
                        List<HealthSessionSegment> list50 = segments;
                        Iterator it45 = list26.iterator();
                        List list51 = list45;
                        while (it45.hasNext()) {
                            HealthSessionSegment healthSessionSegment23 = (HealthSessionSegment) it45.next();
                            if (list51.isEmpty()) {
                                listSortedWith = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list51, healthSessionSegment23);
                            } else {
                                ArrayList arrayList26 = new ArrayList();
                                ArrayList arrayList27 = new ArrayList();
                                for (Object obj14 : list51) {
                                    if (HealthIntervalKt.hasIntersection((HealthSessionSegment) obj14, healthSessionSegment23)) {
                                        arrayList26.add(obj14);
                                    } else {
                                        arrayList27.add(obj14);
                                    }
                                }
                                Pair pair6 = new Pair(arrayList26, arrayList27);
                                List<HealthSessionSegment> list52 = (List) pair6.component1();
                                List list53 = (List) pair6.component2();
                                if (list52.isEmpty()) {
                                    listSortedWith = CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list53, healthSessionSegment23), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                                } else {
                                    List list54 = list53;
                                    List listEmptyList9 = CollectionsKt.emptyList();
                                    for (HealthSessionSegment healthSessionSegment24 : list52) {
                                        List list55 = listEmptyList9;
                                        if (Intrinsics.areEqual(healthSessionSegment23, healthSessionSegment24)) {
                                            listEmptyList = CollectionsKt.listOf(healthSessionSegment23);
                                        } else if (HealthIntervalKt.hasIntersection(healthSessionSegment23, healthSessionSegment24)) {
                                            long fromInMillis15 = healthSessionSegment24.getFromInMillis();
                                            long toInMillis15 = healthSessionSegment24.getToInMillis();
                                            long fromInMillis16 = healthSessionSegment23.getFromInMillis();
                                            if (fromInMillis15 > fromInMillis16 || fromInMillis16 > toInMillis15) {
                                                it5 = it45;
                                                j4 = time;
                                                long fromInMillis17 = healthSessionSegment23.getFromInMillis();
                                                long toInMillis16 = healthSessionSegment23.getToInMillis();
                                                long fromInMillis18 = healthSessionSegment24.getFromInMillis();
                                                if (fromInMillis17 > fromInMillis18 || fromInMillis18 > toInMillis16) {
                                                    if (healthSessionSegment23.getFromInMillis() < healthSessionSegment24.getFromInMillis()) {
                                                        long fromInMillis19 = healthSessionSegment24.getFromInMillis();
                                                        long toInMillis17 = healthSessionSegment24.getToInMillis();
                                                        long toInMillis18 = healthSessionSegment23.getToInMillis();
                                                        if (fromInMillis19 <= toInMillis18 && toInMillis18 <= toInMillis17) {
                                                            BaseHealthSessionSegment[] baseHealthSessionSegmentArr5 = new BaseHealthSessionSegment[2];
                                                            baseHealthSessionSegmentArr5[0] = healthSessionSegment23;
                                                            long toInMillis19 = healthSessionSegment23.getToInMillis();
                                                            SleepSegmentType sleepSegmentType19 = healthSessionSegment24.getSleepSegmentType();
                                                            long toInMillis20 = healthSessionSegment24.getToInMillis();
                                                            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                            if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                                baseHealthSessionSegment5 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType19, new Date(toInMillis19), new Date(toInMillis20));
                                                            } else if (Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(cls4))) {
                                                                baseHealthSessionSegment5 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType19, new Date(toInMillis19), new Date(toInMillis20));
                                                            } else {
                                                                if (!Intrinsics.areEqual(orCreateKotlinClass10, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                                    throw null;
                                                                }
                                                                baseHealthSessionSegment5 = new BaseHealthSessionSegment(sleepSegmentType19, new Date(toInMillis19), new Date(toInMillis20));
                                                            }
                                                            baseHealthSessionSegmentArr5[i3] = baseHealthSessionSegment5;
                                                            listEmptyList = CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr5);
                                                        }
                                                    }
                                                    if (healthSessionSegment23.getToInMillis() > healthSessionSegment24.getToInMillis()) {
                                                        long fromInMillis20 = healthSessionSegment24.getFromInMillis();
                                                        long toInMillis21 = healthSessionSegment24.getToInMillis();
                                                        long fromInMillis21 = healthSessionSegment23.getFromInMillis();
                                                        if (fromInMillis20 > fromInMillis21 || fromInMillis21 > toInMillis21) {
                                                            Logger.logWarning("Unable to minus segment " + healthSessionSegment24 + " from " + healthSessionSegment23, null);
                                                            listEmptyList = CollectionsKt.emptyList();
                                                        } else {
                                                            BaseHealthSessionSegment[] baseHealthSessionSegmentArr6 = new BaseHealthSessionSegment[2];
                                                            long fromInMillis22 = healthSessionSegment23.getFromInMillis();
                                                            SleepSegmentType sleepSegmentType20 = healthSessionSegment24.getSleepSegmentType();
                                                            long fromInMillis23 = healthSessionSegment24.getFromInMillis();
                                                            KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                            if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                                baseHealthSessionSegment4 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType20, new Date(fromInMillis23), new Date(fromInMillis22));
                                                            } else if (Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(cls4))) {
                                                                baseHealthSessionSegment4 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType20, new Date(fromInMillis23), new Date(fromInMillis22));
                                                            } else {
                                                                if (!Intrinsics.areEqual(orCreateKotlinClass11, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                                    throw null;
                                                                }
                                                                baseHealthSessionSegment4 = new BaseHealthSessionSegment(sleepSegmentType20, new Date(fromInMillis23), new Date(fromInMillis22));
                                                            }
                                                            baseHealthSessionSegmentArr6[0] = baseHealthSessionSegment4;
                                                            baseHealthSessionSegmentArr6[i3] = healthSessionSegment23;
                                                            listEmptyList = CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr6);
                                                        }
                                                    }
                                                } else {
                                                    long fromInMillis24 = healthSessionSegment23.getFromInMillis();
                                                    long toInMillis22 = healthSessionSegment23.getToInMillis();
                                                    long toInMillis23 = healthSessionSegment24.getToInMillis();
                                                    if (fromInMillis24 <= toInMillis23 && toInMillis23 <= toInMillis22) {
                                                        listEmptyList = CollectionsKt.listOf(healthSessionSegment23);
                                                    }
                                                }
                                            } else {
                                                long fromInMillis25 = healthSessionSegment24.getFromInMillis();
                                                long toInMillis24 = healthSessionSegment24.getToInMillis();
                                                long toInMillis25 = healthSessionSegment23.getToInMillis();
                                                if (fromInMillis25 <= toInMillis25 && toInMillis25 <= toInMillis24) {
                                                    BaseHealthSessionSegment[] baseHealthSessionSegmentArr7 = new BaseHealthSessionSegment[3];
                                                    long fromInMillis26 = healthSessionSegment23.getFromInMillis();
                                                    SleepSegmentType sleepSegmentType21 = healthSessionSegment24.getSleepSegmentType();
                                                    long fromInMillis27 = healthSessionSegment24.getFromInMillis();
                                                    KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                    it5 = it45;
                                                    if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                        j4 = time;
                                                        baseHealthSessionSegment6 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType21, new Date(fromInMillis27), new Date(fromInMillis26));
                                                    } else {
                                                        j4 = time;
                                                        if (Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(cls4))) {
                                                            baseHealthSessionSegment6 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType21, new Date(fromInMillis27), new Date(fromInMillis26));
                                                        } else {
                                                            if (!Intrinsics.areEqual(orCreateKotlinClass12, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                                Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                                throw null;
                                                            }
                                                            baseHealthSessionSegment6 = new BaseHealthSessionSegment(sleepSegmentType21, new Date(fromInMillis27), new Date(fromInMillis26));
                                                        }
                                                    }
                                                    baseHealthSessionSegmentArr7[0] = baseHealthSessionSegment6;
                                                    baseHealthSessionSegmentArr7[i3] = healthSessionSegment23;
                                                    long toInMillis26 = healthSessionSegment23.getToInMillis();
                                                    SleepSegmentType sleepSegmentType22 = healthSessionSegment24.getSleepSegmentType();
                                                    long toInMillis27 = healthSessionSegment24.getToInMillis();
                                                    KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                    if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                        baseHealthSessionSegment7 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType22, new Date(toInMillis26), new Date(toInMillis27));
                                                    } else if (Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(cls4))) {
                                                        baseHealthSessionSegment7 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType22, new Date(toInMillis26), new Date(toInMillis27));
                                                    } else {
                                                        if (!Intrinsics.areEqual(orCreateKotlinClass13, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                            Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                            throw null;
                                                        }
                                                        baseHealthSessionSegment7 = new BaseHealthSessionSegment(sleepSegmentType22, new Date(toInMillis26), new Date(toInMillis27));
                                                    }
                                                    baseHealthSessionSegmentArr7[2] = baseHealthSessionSegment7;
                                                    listEmptyList = CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr7);
                                                }
                                            }
                                            ArrayList arrayList28 = new ArrayList();
                                            for (Object obj15 : listEmptyList) {
                                                HealthSessionSegment healthSessionSegment25 = (HealthSessionSegment) obj15;
                                                if (healthSessionSegment25.getFromInMillis() != healthSessionSegment25.getToInMillis()) {
                                                    arrayList28.add(obj15);
                                                }
                                            }
                                            listEmptyList9 = CollectionsKt.plus((Collection) list55, (Iterable) arrayList28);
                                            it45 = it5;
                                            time = j4;
                                        } else {
                                            BaseHealthSessionSegment[] baseHealthSessionSegmentArr8 = new BaseHealthSessionSegment[2];
                                            baseHealthSessionSegmentArr8[0] = healthSessionSegment23;
                                            baseHealthSessionSegmentArr8[i3] = healthSessionSegment24;
                                            listEmptyList = CollectionsKt.sortedWith(CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr8), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                                        }
                                        it5 = it45;
                                        j4 = time;
                                        ArrayList arrayList282 = new ArrayList();
                                        while (r4.hasNext()) {
                                        }
                                        listEmptyList9 = CollectionsKt.plus((Collection) list55, (Iterable) arrayList282);
                                        it45 = it5;
                                        time = j4;
                                    }
                                    it4 = it45;
                                    j3 = time;
                                    List listDistinct2 = CollectionsKt.distinct(CollectionsKt.plus((Collection) list54, (Iterable) listEmptyList9));
                                    ArrayList arrayList29 = new ArrayList();
                                    for (Object obj16 : listDistinct2) {
                                        HealthSessionSegment healthSessionSegment26 = (HealthSessionSegment) obj16;
                                        if (healthSessionSegment26.getFromInMillis() != healthSessionSegment26.getToInMillis()) {
                                            arrayList29.add(obj16);
                                        }
                                    }
                                    listSortedWith = CollectionsKt.sortedWith(arrayList29, new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                                    it45 = it4;
                                    time = j3;
                                    list51 = listSortedWith;
                                }
                            }
                            it4 = it45;
                            j3 = time;
                            it45 = it4;
                            time = j3;
                            list51 = listSortedWith;
                        }
                        long j8 = time;
                        List<HealthSessionSegment> listSortedWith8 = CollectionsKt.sortedWith(CollectionsKt.distinct(list51), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                        ArrayList arrayList30 = new ArrayList();
                        for (HealthSessionSegment baseHealthSessionSegment20 : listSortedWith8) {
                            if (baseHealthSessionSegment20.getToInMillis() <= j8 || baseHealthSessionSegment20.getFromInMillis() >= j7) {
                                j = j7;
                                j2 = j8;
                                baseHealthSessionSegment20 = null;
                            } else if (baseHealthSessionSegment20.getFromInMillis() > j8 || baseHealthSessionSegment20.getToInMillis() < j7) {
                                j = j7;
                                j2 = j8;
                                if (baseHealthSessionSegment20.getFromInMillis() < j2) {
                                    long toInMillis28 = baseHealthSessionSegment20.getToInMillis();
                                    if (j2 <= toInMillis28 && toInMillis28 <= j) {
                                        SleepSegmentType sleepSegmentType23 = baseHealthSessionSegment20.getSleepSegmentType();
                                        long toInMillis29 = baseHealthSessionSegment20.getToInMillis();
                                        KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                        if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                            baseHealthSessionSegment20 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType23, new Date(j2), new Date(toInMillis29));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(cls4))) {
                                            baseHealthSessionSegment20 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType23, new Date(j2), new Date(toInMillis29));
                                        } else {
                                            if (!Intrinsics.areEqual(orCreateKotlinClass14, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                throw null;
                                            }
                                            baseHealthSessionSegment20 = new BaseHealthSessionSegment(sleepSegmentType23, new Date(j2), new Date(toInMillis29));
                                        }
                                    } else if (baseHealthSessionSegment20.getToInMillis() > j) {
                                        long fromInMillis28 = baseHealthSessionSegment20.getFromInMillis();
                                        if (j2 <= fromInMillis28 && fromInMillis28 <= j) {
                                            SleepSegmentType sleepSegmentType24 = baseHealthSessionSegment20.getSleepSegmentType();
                                            long fromInMillis29 = baseHealthSessionSegment20.getFromInMillis();
                                            KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                            if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                baseHealthSessionSegment20 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType24, new Date(fromInMillis29), new Date(j));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(cls4))) {
                                                baseHealthSessionSegment20 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType24, new Date(fromInMillis29), new Date(j));
                                            } else {
                                                if (!Intrinsics.areEqual(orCreateKotlinClass15, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                    throw null;
                                                }
                                                baseHealthSessionSegment20 = new BaseHealthSessionSegment(sleepSegmentType24, new Date(fromInMillis29), new Date(j));
                                            }
                                        }
                                    }
                                }
                            } else {
                                SleepSegmentType sleepSegmentType25 = baseHealthSessionSegment20.getSleepSegmentType();
                                KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                    j2 = j8;
                                    j = j7;
                                    baseHealthSessionSegment3 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType25, new Date(j2), new Date(j));
                                } else {
                                    j = j7;
                                    j2 = j8;
                                    if (Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(cls4))) {
                                        baseHealthSessionSegment3 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType25, new Date(j2), new Date(j));
                                    } else {
                                        if (!Intrinsics.areEqual(orCreateKotlinClass16, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                            Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                            throw null;
                                        }
                                        baseHealthSessionSegment3 = new BaseHealthSessionSegment(sleepSegmentType25, new Date(j2), new Date(j));
                                    }
                                }
                                baseHealthSessionSegment20 = baseHealthSessionSegment3;
                            }
                            if (baseHealthSessionSegment20 != null) {
                                arrayList30.add(baseHealthSessionSegment20);
                            }
                            j8 = j2;
                            j7 = j;
                        }
                        boolean zIsEmpty4 = arrayList30.isEmpty();
                        List listPlus5 = arrayList30;
                        if (!zIsEmpty4) {
                            int size = arrayList30.size();
                            listPlus5 = arrayList30;
                            if (size != i3) {
                                ArrayList arrayList31 = new ArrayList();
                                int i6 = 0;
                                for (Object obj17 : arrayList30) {
                                    int i7 = i6 + 1;
                                    if (i6 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    HealthSessionSegment healthSessionSegment27 = (HealthSessionSegment) obj17;
                                    if (i6 == 0) {
                                        healthSessionSegment = null;
                                    } else {
                                        healthSessionSegment = (HealthSessionSegment) arrayList30.get(i6 - 1);
                                        long fromInMillis30 = healthSessionSegment27.getFromInMillis() - healthSessionSegment.getToInMillis();
                                        if (fromInMillis30 != 0 && fromInMillis30 <= Utils.getMinutesInMillis(30)) {
                                            Logger.logDebug("gap found - expanding left segment: " + HeathSyncKt.pretty(healthSessionSegment) + "\t" + HeathSyncKt.pretty(healthSessionSegment27), null);
                                            long fromInMillis31 = healthSessionSegment27.getFromInMillis();
                                            SleepSegmentType sleepSegmentType26 = healthSessionSegment.getSleepSegmentType();
                                            long fromInMillis32 = healthSessionSegment.getFromInMillis();
                                            KClass orCreateKotlinClass17 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                            if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                baseHealthSessionSegment2 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType26, new Date(fromInMillis32), new Date(fromInMillis31));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(cls4))) {
                                                baseHealthSessionSegment2 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType26, new Date(fromInMillis32), new Date(fromInMillis31));
                                            } else {
                                                if (!Intrinsics.areEqual(orCreateKotlinClass17, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                    throw null;
                                                }
                                                baseHealthSessionSegment2 = new BaseHealthSessionSegment(sleepSegmentType26, new Date(fromInMillis32), new Date(fromInMillis31));
                                            }
                                            healthSessionSegment = baseHealthSessionSegment2;
                                        }
                                    }
                                    if (healthSessionSegment != null) {
                                        arrayList31.add(healthSessionSegment);
                                    }
                                    i6 = i7;
                                }
                                listPlus5 = CollectionsKt.plus((Collection<? extends Object>) arrayList31, CollectionsKt.last((List) arrayList30));
                            }
                        }
                        list50.addAll(listPlus5);
                        this.isFinished = this.sleepRecord.isFinished();
                        return;
                    }
                    HealthSessionSegment healthSessionSegment28 = (HealthSessionSegment) it42.next();
                    if (list44.isEmpty()) {
                        listSortedWith3 = CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list44, healthSessionSegment28);
                    } else {
                        ArrayList arrayList33 = new ArrayList();
                        ArrayList arrayList34 = new ArrayList();
                        for (Object obj18 : list44) {
                            if (HealthIntervalKt.hasIntersection((HealthSessionSegment) obj18, healthSessionSegment28)) {
                                arrayList33.add(obj18);
                            } else {
                                arrayList34.add(obj18);
                            }
                        }
                        Pair pair7 = new Pair(arrayList33, arrayList34);
                        List list56 = (List) pair7.component1();
                        List list57 = (List) pair7.component2();
                        if (list56.isEmpty()) {
                            listSortedWith3 = CollectionsKt.sortedWith(CollectionsKt.plus((Collection<? extends HealthSessionSegment>) list57, healthSessionSegment28), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                        } else {
                            List list58 = list57;
                            List listEmptyList10 = CollectionsKt.emptyList();
                            Iterator it46 = list56.iterator();
                            while (it46.hasNext()) {
                                HealthSessionSegment healthSessionSegment29 = (HealthSessionSegment) it46.next();
                                List list59 = listEmptyList10;
                                if (Intrinsics.areEqual(healthSessionSegment28, healthSessionSegment29)) {
                                    listEmptyList3 = CollectionsKt.listOf(healthSessionSegment28);
                                } else if (HealthIntervalKt.hasIntersection(healthSessionSegment28, healthSessionSegment29)) {
                                    long fromInMillis33 = healthSessionSegment29.getFromInMillis();
                                    long toInMillis30 = healthSessionSegment29.getToInMillis();
                                    long fromInMillis34 = healthSessionSegment28.getFromInMillis();
                                    if (fromInMillis33 > fromInMillis34 || fromInMillis34 > toInMillis30) {
                                        it10 = it42;
                                        j6 = time2;
                                        int i8 = i5;
                                        it11 = it46;
                                        long fromInMillis35 = healthSessionSegment28.getFromInMillis();
                                        long toInMillis31 = healthSessionSegment28.getToInMillis();
                                        long fromInMillis36 = healthSessionSegment29.getFromInMillis();
                                        if (fromInMillis35 <= fromInMillis36 && fromInMillis36 <= toInMillis31) {
                                            long fromInMillis37 = healthSessionSegment28.getFromInMillis();
                                            long toInMillis32 = healthSessionSegment28.getToInMillis();
                                            long toInMillis33 = healthSessionSegment29.getToInMillis();
                                            if (fromInMillis37 <= toInMillis33 && toInMillis33 <= toInMillis32) {
                                                listEmptyList3 = CollectionsKt.listOf(healthSessionSegment28);
                                            }
                                        } else if (healthSessionSegment28.getFromInMillis() < healthSessionSegment29.getFromInMillis()) {
                                            long fromInMillis38 = healthSessionSegment29.getFromInMillis();
                                            long toInMillis34 = healthSessionSegment29.getToInMillis();
                                            long toInMillis35 = healthSessionSegment28.getToInMillis();
                                            if (fromInMillis38 <= toInMillis35 && toInMillis35 <= toInMillis34) {
                                                BaseHealthSessionSegment[] baseHealthSessionSegmentArr9 = new BaseHealthSessionSegment[i8];
                                                baseHealthSessionSegmentArr9[0] = healthSessionSegment28;
                                                long toInMillis36 = healthSessionSegment28.getToInMillis();
                                                SleepSegmentType sleepSegmentType27 = healthSessionSegment29.getSleepSegmentType();
                                                long toInMillis37 = healthSessionSegment29.getToInMillis();
                                                KClass orCreateKotlinClass18 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                    baseHealthSessionSegment13 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType27, new Date(toInMillis36), new Date(toInMillis37));
                                                } else if (Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(cls4))) {
                                                    baseHealthSessionSegment13 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType27, new Date(toInMillis36), new Date(toInMillis37));
                                                } else {
                                                    if (!Intrinsics.areEqual(orCreateKotlinClass18, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                        Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                        throw null;
                                                    }
                                                    baseHealthSessionSegment13 = new BaseHealthSessionSegment(sleepSegmentType27, new Date(toInMillis36), new Date(toInMillis37));
                                                }
                                                baseHealthSessionSegmentArr9[i3] = baseHealthSessionSegment13;
                                                listEmptyList3 = CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr9);
                                            } else if (healthSessionSegment28.getToInMillis() > healthSessionSegment29.getToInMillis()) {
                                                long fromInMillis39 = healthSessionSegment29.getFromInMillis();
                                                long toInMillis38 = healthSessionSegment29.getToInMillis();
                                                long fromInMillis40 = healthSessionSegment28.getFromInMillis();
                                                if (fromInMillis39 > fromInMillis40 || fromInMillis40 > toInMillis38) {
                                                    Logger.logWarning("Unable to minus segment " + healthSessionSegment29 + " from " + healthSessionSegment28, null);
                                                    listEmptyList3 = CollectionsKt.emptyList();
                                                } else {
                                                    BaseHealthSessionSegment[] baseHealthSessionSegmentArr10 = new BaseHealthSessionSegment[2];
                                                    long fromInMillis41 = healthSessionSegment28.getFromInMillis();
                                                    SleepSegmentType sleepSegmentType28 = healthSessionSegment29.getSleepSegmentType();
                                                    long fromInMillis42 = healthSessionSegment29.getFromInMillis();
                                                    KClass orCreateKotlinClass19 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                                    if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                        baseHealthSessionSegment12 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType28, new Date(fromInMillis42), new Date(fromInMillis41));
                                                    } else if (Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(cls4))) {
                                                        baseHealthSessionSegment12 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType28, new Date(fromInMillis42), new Date(fromInMillis41));
                                                    } else {
                                                        if (!Intrinsics.areEqual(orCreateKotlinClass19, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                            Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                            throw null;
                                                        }
                                                        baseHealthSessionSegment12 = new BaseHealthSessionSegment(sleepSegmentType28, new Date(fromInMillis42), new Date(fromInMillis41));
                                                    }
                                                    baseHealthSessionSegmentArr10[0] = baseHealthSessionSegment12;
                                                    baseHealthSessionSegmentArr10[i3] = healthSessionSegment28;
                                                    listEmptyList3 = CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr10);
                                                }
                                            }
                                        }
                                    } else {
                                        long fromInMillis43 = healthSessionSegment29.getFromInMillis();
                                        long toInMillis39 = healthSessionSegment29.getToInMillis();
                                        long toInMillis40 = healthSessionSegment28.getToInMillis();
                                        if (fromInMillis43 <= toInMillis40 && toInMillis40 <= toInMillis39) {
                                            BaseHealthSessionSegment[] baseHealthSessionSegmentArr11 = new BaseHealthSessionSegment[i4];
                                            int i9 = i5;
                                            long fromInMillis44 = healthSessionSegment28.getFromInMillis();
                                            it10 = it42;
                                            SleepSegmentType sleepSegmentType29 = healthSessionSegment29.getSleepSegmentType();
                                            j6 = time2;
                                            long fromInMillis45 = healthSessionSegment29.getFromInMillis();
                                            it11 = it46;
                                            KClass orCreateKotlinClass20 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                            if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                baseHealthSessionSegment14 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType29, new Date(fromInMillis45), new Date(fromInMillis44));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(cls4))) {
                                                baseHealthSessionSegment14 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType29, new Date(fromInMillis45), new Date(fromInMillis44));
                                            } else {
                                                if (!Intrinsics.areEqual(orCreateKotlinClass20, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                    throw null;
                                                }
                                                baseHealthSessionSegment14 = new BaseHealthSessionSegment(sleepSegmentType29, new Date(fromInMillis45), new Date(fromInMillis44));
                                            }
                                            baseHealthSessionSegmentArr11[0] = baseHealthSessionSegment14;
                                            baseHealthSessionSegmentArr11[i3] = healthSessionSegment28;
                                            long toInMillis41 = healthSessionSegment28.getToInMillis();
                                            SleepSegmentType sleepSegmentType30 = healthSessionSegment29.getSleepSegmentType();
                                            long toInMillis42 = healthSessionSegment29.getToInMillis();
                                            KClass orCreateKotlinClass21 = Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class);
                                            if (Intrinsics.areEqual(orCreateKotlinClass21, Reflection.getOrCreateKotlinClass(GoogleFitSessionSegment.class))) {
                                                baseHealthSessionSegment15 = (BaseHealthSessionSegment) new GoogleFitSessionSegment(sleepSegmentType30, new Date(toInMillis41), new Date(toInMillis42));
                                            } else if (Intrinsics.areEqual(orCreateKotlinClass21, Reflection.getOrCreateKotlinClass(cls4))) {
                                                baseHealthSessionSegment15 = (BaseHealthSessionSegment) new SamsungSHealthSessionSegment(sleepSegmentType30, new Date(toInMillis41), new Date(toInMillis42));
                                            } else {
                                                if (!Intrinsics.areEqual(orCreateKotlinClass21, Reflection.getOrCreateKotlinClass(BaseHealthSessionSegment.class))) {
                                                    Utf8$$ExternalSyntheticBUOutline0.m$3(str10);
                                                    throw null;
                                                }
                                                baseHealthSessionSegment15 = new BaseHealthSessionSegment(sleepSegmentType30, new Date(toInMillis41), new Date(toInMillis42));
                                            }
                                            baseHealthSessionSegmentArr11[i9] = baseHealthSessionSegment15;
                                            listEmptyList3 = CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr11);
                                        }
                                    }
                                    ArrayList arrayList35 = new ArrayList();
                                    for (Object obj19 : listEmptyList3) {
                                        HealthSessionSegment healthSessionSegment30 = (HealthSessionSegment) obj19;
                                        if (healthSessionSegment30.getFromInMillis() != healthSessionSegment30.getToInMillis()) {
                                            arrayList35.add(obj19);
                                        }
                                    }
                                    listEmptyList10 = CollectionsKt.plus((Collection) list59, (Iterable) arrayList35);
                                    it42 = it10;
                                    time2 = j6;
                                    it46 = it11;
                                    i4 = 3;
                                    i5 = 2;
                                } else {
                                    BaseHealthSessionSegment[] baseHealthSessionSegmentArr12 = new BaseHealthSessionSegment[i5];
                                    baseHealthSessionSegmentArr12[0] = healthSessionSegment28;
                                    baseHealthSessionSegmentArr12[i3] = healthSessionSegment29;
                                    listEmptyList3 = CollectionsKt.sortedWith(CollectionsKt.listOf((Object[]) baseHealthSessionSegmentArr12), new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                                }
                                it10 = it42;
                                j6 = time2;
                                it11 = it46;
                                ArrayList arrayList352 = new ArrayList();
                                while (r5.hasNext()) {
                                }
                                listEmptyList10 = CollectionsKt.plus((Collection) list59, (Iterable) arrayList352);
                                it42 = it10;
                                time2 = j6;
                                it46 = it11;
                                i4 = 3;
                                i5 = 2;
                            }
                            it9 = it42;
                            j5 = time2;
                            List listDistinct3 = CollectionsKt.distinct(CollectionsKt.plus((Collection) list58, (Iterable) listEmptyList10));
                            ArrayList arrayList36 = new ArrayList();
                            for (Object obj20 : listDistinct3) {
                                HealthSessionSegment healthSessionSegment31 = (HealthSessionSegment) obj20;
                                if (healthSessionSegment31.getFromInMillis() != healthSessionSegment31.getToInMillis()) {
                                    arrayList36.add(obj20);
                                }
                            }
                            listSortedWith3 = CollectionsKt.sortedWith(arrayList36, new SegmentNormalizationKt$ordered$$inlined$sortedBy$1());
                            it42 = it9;
                            time2 = j5;
                            list44 = listSortedWith3;
                        }
                    }
                    it9 = it42;
                    j5 = time2;
                    it42 = it9;
                    time2 = j5;
                    list44 = listSortedWith3;
                }
            }
        }
    }

    private final List<BaseHealthSessionSegment> toSegments(List<? extends Event> list, SleepSegmentType sleepSegmentType) {
        List<Interval> intervals = EventsUtil.getIntervals(list, sleepSegmentType.getStartLabel(), sleepSegmentType.getEndLabel());
        intervals.getClass();
        List<Interval> list2 = intervals;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Interval interval : list2) {
            arrayList.add(new BaseHealthSessionSegment(sleepSegmentType, new Date(interval.getFrom()), new Date(interval.getTo())));
        }
        return arrayList;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthInterval
    public String getActivity() {
        return "sleep";
    }

    @Override // com.urbandroid.sleep.service.health.session.AbstractHealthSession, com.urbandroid.sleep.service.health.session.HealthSession
    /* JADX INFO: renamed from: isFinished, reason: from getter */
    public boolean getIsFinished() {
        return this.isFinished;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSleepActivity() {
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isSportActivity() {
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    public boolean isWalkingActivity() {
        return false;
    }

    public final SleepRecord toSegmentedSleepRecord() {
        SleepRecord sleepRecord = new SleepRecord(this.sleepRecord, true);
        sleepRecord.getEvents().clearLabels(EventLabel.LIGHT_START, EventLabel.LIGHT_END, EventLabel.AWAKE_START, EventLabel.AWAKE_END, EventLabel.REM_START, EventLabel.REM_END, EventLabel.DEEP_START, EventLabel.DEEP_END);
        for (HealthSessionSegment healthSessionSegment : getSegments()) {
            SleepSegmentType sleepSegmentType = healthSessionSegment.getSleepSegmentType();
            if (sleepSegmentType != null) {
                sleepRecord.getEvents().addEvent(healthSessionSegment.getFromInMillis(), sleepSegmentType.getStartLabel());
                sleepRecord.getEvents().addEvent(healthSessionSegment.getToInMillis(), sleepSegmentType.getEndLabel());
            }
        }
        return sleepRecord;
    }

    @Override // com.urbandroid.sleep.service.health.session.HealthSession
    /* JADX INFO: renamed from: toSleepRecord, reason: from getter */
    public SleepRecord getSleepRecord() {
        return this.sleepRecord;
    }
}
