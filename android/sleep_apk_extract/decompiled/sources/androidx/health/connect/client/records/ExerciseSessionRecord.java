package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseRouteResult;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\u0018\u0000 <2\u00020\u0001:\u0001<B\u008b\u0001\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010!R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b(\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b)\u0010'R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b+\u0010,R\u001d\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\u0012\n\u0004\b\u000b\u0010-\u0012\u0004\b/\u00100\u001a\u0004\b.\u0010\u001fR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b2\u0010!R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u000e\u00101\u001a\u0004\b3\u0010!R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u00104\u001a\u0004\b5\u00106R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f8\u0006¢\u0006\f\n\u0004\b\u0013\u00104\u001a\u0004\b7\u00106R\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u00108\u001a\u0004\b9\u0010:R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0016\u00101\u001a\u0004\b;\u0010!¨\u0006="}, d2 = {"Landroidx/health/connect/client/records/ExerciseSessionRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "j$/time/Instant", "startTime", "j$/time/ZoneOffset", "startZoneOffset", SDKConstants.PARAM_END_TIME, "endZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "", "exerciseType", "", "title", "notes", "", "Landroidx/health/connect/client/records/ExerciseSegment;", "segments", "Landroidx/health/connect/client/records/ExerciseLap;", "laps", "Landroidx/health/connect/client/records/ExerciseRouteResult;", "exerciseRouteResult", "plannedExerciseSessionId", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Landroidx/health/connect/client/records/ExerciseRouteResult;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getStartZoneOffset", "()Lj$/time/ZoneOffset;", "getEndTime", "getEndZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "I", "getExerciseType", "getExerciseType$annotations", "()V", "Ljava/lang/String;", "getTitle", "getNotes", "Ljava/util/List;", "getSegments", "()Ljava/util/List;", "getLaps", "Landroidx/health/connect/client/records/ExerciseRouteResult;", "getExerciseRouteResult", "()Landroidx/health/connect/client/records/ExerciseRouteResult;", "getPlannedExerciseSessionId", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExerciseSessionRecord implements IntervalRecord {
    public static final AggregateMetric<Duration> EXERCISE_DURATION_TOTAL = AggregateMetric.INSTANCE.durationMetric$connect_client_release("ActiveTime", AggregateMetric.AggregationType.TOTAL, "time");
    public static final Map<Integer, String> EXERCISE_TYPE_INT_TO_STRING_MAP;
    public static final Map<String, Integer> EXERCISE_TYPE_STRING_TO_INT_MAP;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final ExerciseRouteResult exerciseRouteResult;
    private final int exerciseType;
    private final List<ExerciseLap> laps;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final String notes;
    private final String plannedExerciseSessionId;
    private final List<ExerciseSegment> segments;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private final String title;

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("back_extension", 13), TuplesKt.to("badminton", 2), TuplesKt.to("barbell_shoulder_press", 70), TuplesKt.to("baseball", 4), TuplesKt.to("basketball", 5), TuplesKt.to("bench_press", 70), TuplesKt.to("bench_sit_up", 13), TuplesKt.to("biking", 8), TuplesKt.to("biking_stationary", 9), TuplesKt.to("boot_camp", 10), TuplesKt.to("boxing", 11), TuplesKt.to("burpee", 13), TuplesKt.to("cricket", 14), TuplesKt.to("crunch", 13), TuplesKt.to("dancing", 16), TuplesKt.to("deadlift", 70), TuplesKt.to("dumbbell_curl_left_arm", 70), TuplesKt.to("dumbbell_curl_right_arm", 70), TuplesKt.to("dumbbell_front_raise", 70), TuplesKt.to("dumbbell_lateral_raise", 70), TuplesKt.to("dumbbell_triceps_extension_left_arm", 70), TuplesKt.to("dumbbell_triceps_extension_right_arm", 70), TuplesKt.to("dumbbell_triceps_extension_two_arm", 70), TuplesKt.to("elliptical", 25), TuplesKt.to("exercise_class", 26), TuplesKt.to("fencing", 27), TuplesKt.to("football_american", 28), TuplesKt.to("football_australian", 29), TuplesKt.to("forward_twist", 13), TuplesKt.to("frisbee_disc", 31), TuplesKt.to("golf", 32), TuplesKt.to("guided_breathing", 33), TuplesKt.to("gymnastics", 34), TuplesKt.to("handball", 35), TuplesKt.to("hiking", 37), TuplesKt.to("ice_hockey", 38), TuplesKt.to("ice_skating", 39), TuplesKt.to("jumping_jack", 36), TuplesKt.to("jump_rope", 36), TuplesKt.to("lat_pull_down", 70), TuplesKt.to("lunge", 13), TuplesKt.to("martial_arts", 44), TuplesKt.to("paddling", 46), TuplesKt.to("para_gliding", 47), TuplesKt.to("pilates", 48), TuplesKt.to("plank", 13), TuplesKt.to("racquetball", 50), TuplesKt.to("rock_climbing", 51), TuplesKt.to("roller_hockey", 52), TuplesKt.to("rowing", 53), TuplesKt.to("rowing_machine", 54), TuplesKt.to("rugby", 55), TuplesKt.to("running", 56), TuplesKt.to("running_treadmill", 57), TuplesKt.to("sailing", 58), TuplesKt.to("scuba_diving", 59), TuplesKt.to("skating", 60), TuplesKt.to("skiing", 61), TuplesKt.to("snowboarding", 62), TuplesKt.to("snowshoeing", 63), TuplesKt.to("soccer", 64), TuplesKt.to("softball", 65), TuplesKt.to("squash", 66), TuplesKt.to("squat", 13), TuplesKt.to("stair_climbing", 68), TuplesKt.to("stair_climbing_machine", 69), TuplesKt.to("stretching", 71), TuplesKt.to("surfing", 72), TuplesKt.to("swimming_open_water", 73), TuplesKt.to("swimming_pool", 74), TuplesKt.to("table_tennis", 75), TuplesKt.to("tennis", 76), TuplesKt.to("upper_twist", 13), TuplesKt.to("volleyball", 78), TuplesKt.to("walking", 79), TuplesKt.to("water_polo", 80), TuplesKt.to("weightlifting", 81), TuplesKt.to("wheelchair", 82), TuplesKt.to("workout", 0), TuplesKt.to("yoga", 83), TuplesKt.to("calisthenics", 13), TuplesKt.to("high_intensity_interval_training", 36), TuplesKt.to("strength_training", 70));
        EXERCISE_TYPE_STRING_TO_INT_MAP = mapMapOf;
        Set<Map.Entry<String, Integer>> setEntrySet = mapMapOf.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Integer.valueOf(((Number) entry.getValue()).intValue()), (String) entry.getKey());
        }
        EXERCISE_TYPE_INT_TO_STRING_MAP = linkedHashMap;
    }

    public ExerciseSessionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, int i, String str, String str2, List<ExerciseSegment> list, List<ExerciseLap> list2, ExerciseRouteResult exerciseRouteResult, String str3) {
        instant.getClass();
        instant2.getClass();
        metadata.getClass();
        list.getClass();
        list2.getClass();
        exerciseRouteResult.getClass();
        this.startTime = instant;
        this.startZoneOffset = zoneOffset;
        this.endTime = instant2;
        this.endZoneOffset = zoneOffset2;
        this.metadata = metadata;
        this.exerciseType = i;
        this.title = str;
        this.notes = str2;
        this.segments = list;
        this.laps = list2;
        this.exerciseRouteResult = exerciseRouteResult;
        this.plannedExerciseSessionId = str3;
        if (!getStartTime().isBefore(getEndTime())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("startTime must be before endTime.");
            throw null;
        }
        int i2 = 0;
        if (!list.isEmpty()) {
            List listSortedWith = CollectionsKt.sortedWith(list, new SleepSessionRecord$$ExternalSyntheticLambda0(new Function2<ExerciseSegment, ExerciseSegment, Integer>() { // from class: androidx.health.connect.client.records.ExerciseSessionRecord$sortedSegments$1
                @Override // kotlin.jvm.functions.Function2
                public final Integer invoke(ExerciseSegment exerciseSegment, ExerciseSegment exerciseSegment2) {
                    return Integer.valueOf(exerciseSegment.getStartTime().compareTo(exerciseSegment2.getStartTime()));
                }
            }, 1));
            int lastIndex = CollectionsKt.getLastIndex(listSortedWith);
            int i3 = 0;
            while (i3 < lastIndex) {
                Instant endTime = ((ExerciseSegment) listSortedWith.get(i3)).getEndTime();
                i3++;
                if (endTime.isAfter(((ExerciseSegment) listSortedWith.get(i3)).getStartTime())) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("segments can not overlap.");
                    throw null;
                }
            }
            if (((ExerciseSegment) CollectionsKt.first(listSortedWith)).getStartTime().isBefore(getStartTime())) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("segments can not be out of parent time range.");
                throw null;
            }
            if (((ExerciseSegment) CollectionsKt.last(listSortedWith)).getEndTime().isAfter(getEndTime())) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("segments can not be out of parent time range.");
                throw null;
            }
            Iterator it = listSortedWith.iterator();
            while (it.hasNext()) {
                if (!((ExerciseSegment) it.next()).isCompatibleWith$connect_client_release(this.exerciseType)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("segmentType and sessionType is not compatible.");
                    throw null;
                }
            }
        }
        if (!this.laps.isEmpty()) {
            List listSortedWith2 = CollectionsKt.sortedWith(this.laps, new SleepSessionRecord$$ExternalSyntheticLambda0(new Function2<ExerciseLap, ExerciseLap, Integer>() { // from class: androidx.health.connect.client.records.ExerciseSessionRecord$sortedLaps$1
                @Override // kotlin.jvm.functions.Function2
                public final Integer invoke(ExerciseLap exerciseLap, ExerciseLap exerciseLap2) {
                    return Integer.valueOf(exerciseLap.getStartTime().compareTo(exerciseLap2.getStartTime()));
                }
            }, 2));
            int lastIndex2 = CollectionsKt.getLastIndex(listSortedWith2);
            while (i2 < lastIndex2) {
                Instant endTime2 = ((ExerciseLap) listSortedWith2.get(i2)).getEndTime();
                i2++;
                if (endTime2.isAfter(((ExerciseLap) listSortedWith2.get(i2)).getStartTime())) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("laps can not overlap.");
                    throw null;
                }
            }
            if (((ExerciseLap) CollectionsKt.first(listSortedWith2)).getStartTime().isBefore(getStartTime())) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("laps can not be out of parent time range.");
                throw null;
            }
            if (((ExerciseLap) CollectionsKt.last(listSortedWith2)).getEndTime().isAfter(getEndTime())) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("laps can not be out of parent time range.");
                throw null;
            }
        }
        ExerciseRouteResult exerciseRouteResult2 = this.exerciseRouteResult;
        if (!(exerciseRouteResult2 instanceof ExerciseRouteResult.Data) || ((ExerciseRouteResult.Data) exerciseRouteResult2).getExerciseRoute().getRoute().isEmpty()) {
            return;
        }
        List<ExerciseRoute.Location> route = ((ExerciseRouteResult.Data) this.exerciseRouteResult).getExerciseRoute().getRoute();
        Iterator<T> it2 = route.iterator();
        if (!it2.hasNext()) {
            Types$$ExternalSyntheticBUOutline0.m();
            throw null;
        }
        Object next = it2.next();
        if (it2.hasNext()) {
            Instant time = ((ExerciseRoute.Location) next).getTime();
            do {
                Object next2 = it2.next();
                Instant time2 = ((ExerciseRoute.Location) next2).getTime();
                if (time.compareTo(time2) > 0) {
                    next = next2;
                    time = time2;
                }
            } while (it2.hasNext());
        }
        Instant time3 = ((ExerciseRoute.Location) next).getTime();
        Iterator<T> it3 = route.iterator();
        if (!it3.hasNext()) {
            Types$$ExternalSyntheticBUOutline0.m();
            throw null;
        }
        Object next3 = it3.next();
        if (it3.hasNext()) {
            Instant time4 = ((ExerciseRoute.Location) next3).getTime();
            do {
                Object next4 = it3.next();
                Instant time5 = ((ExerciseRoute.Location) next4).getTime();
                if (time4.compareTo(time5) < 0) {
                    next3 = next4;
                    time4 = time5;
                }
            } while (it3.hasNext());
        }
        Instant time6 = ((ExerciseRoute.Location) next3).getTime();
        if (time3.isBefore(getStartTime()) || !time6.isBefore(getEndTime())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("route can not be out of parent time range.");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _init_$lambda$2(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _init_$lambda$7(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExerciseSessionRecord)) {
            return false;
        }
        ExerciseSessionRecord exerciseSessionRecord = (ExerciseSessionRecord) other;
        return this.exerciseType == exerciseSessionRecord.exerciseType && Intrinsics.areEqual(this.title, exerciseSessionRecord.title) && Intrinsics.areEqual(this.notes, exerciseSessionRecord.notes) && Intrinsics.areEqual(getStartTime(), exerciseSessionRecord.getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), exerciseSessionRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), exerciseSessionRecord.getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), exerciseSessionRecord.getEndZoneOffset()) && Intrinsics.areEqual(getMetadata(), exerciseSessionRecord.getMetadata()) && Intrinsics.areEqual(this.segments, exerciseSessionRecord.segments) && Intrinsics.areEqual(this.laps, exerciseSessionRecord.laps) && Intrinsics.areEqual(this.exerciseRouteResult, exerciseSessionRecord.exerciseRouteResult);
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getEndTime() {
        return this.endTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getEndZoneOffset() {
        return this.endZoneOffset;
    }

    public final ExerciseRouteResult getExerciseRouteResult() {
        return this.exerciseRouteResult;
    }

    public final int getExerciseType() {
        return this.exerciseType;
    }

    public final List<ExerciseLap> getLaps() {
        return this.laps;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final String getPlannedExerciseSessionId() {
        return this.plannedExerciseSessionId;
    }

    public final List<ExerciseSegment> getSegments() {
        return this.segments;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getStartTime() {
        return this.startTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getStartZoneOffset() {
        return this.startZoneOffset;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.exerciseType) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.notes;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode4 = (getEndTime().hashCode() + ((iHashCode3 + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31)) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        int iHashCode5 = endZoneOffset != null ? endZoneOffset.hashCode() : 0;
        return this.exerciseRouteResult.hashCode() + ((getMetadata().hashCode() + ((iHashCode4 + iHashCode5) * 31)) * 31);
    }

    public String toString() {
        return "ExerciseSessionRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", exerciseType=" + this.exerciseType + ", title=" + this.title + ", notes=" + this.notes + ", metadata=" + getMetadata() + ", segments=" + this.segments + ", laps=" + this.laps + ", exerciseRouteResult=" + this.exerciseRouteResult + ')';
    }

    public /* synthetic */ ExerciseSessionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, int i, String str, String str2, List list, List list2, ExerciseRouteResult exerciseRouteResult, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, zoneOffset, instant2, zoneOffset2, metadata, i, (i2 & 64) != 0 ? null : str, (i2 & 128) != 0 ? null : str2, (i2 & 256) != 0 ? CollectionsKt.emptyList() : list, (i2 & 512) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 1024) != 0 ? new ExerciseRouteResult.NoData() : exerciseRouteResult, (i2 & 2048) != 0 ? null : str3);
    }
}
