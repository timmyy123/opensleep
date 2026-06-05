package androidx.health.connect.client.records;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.SleepSessionRecord;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u0000 -2\u00020\u0001:\u0002-.B[\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b#\u0010!R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010'\u001a\u0004\b(\u0010\u001bR\u0019\u0010\f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b)\u0010\u001bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b+\u0010,¨\u0006/"}, d2 = {"Landroidx/health/connect/client/records/SleepSessionRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "j$/time/Instant", "startTime", "j$/time/ZoneOffset", "startZoneOffset", SDKConstants.PARAM_END_TIME, "endZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "", "title", "notes", "", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "stages", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getStartZoneOffset", "()Lj$/time/ZoneOffset;", "getEndTime", "getEndZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "Ljava/lang/String;", "getTitle", "getNotes", "Ljava/util/List;", "getStages", "()Ljava/util/List;", "Companion", "Stage", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SleepSessionRecord implements IntervalRecord {
    public static final AggregateMetric<Duration> SLEEP_DURATION_TOTAL = AggregateMetric.INSTANCE.durationMetric$connect_client_release("SleepSession");
    public static final Map<Integer, String> STAGE_TYPE_INT_TO_STRING_MAP;
    public static final Map<String, Integer> STAGE_TYPE_STRING_TO_INT_MAP;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final String notes;
    private final List<Stage> stages;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private final String title;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001d\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\u0012\n\u0004\b\u0006\u0010\u0016\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0017\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "", "j$/time/Instant", "startTime", SDKConstants.PARAM_END_TIME, "", "stage", "<init>", "(Lj$/time/Instant;Lj$/time/Instant;I)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "getEndTime", "I", "getStage", "getStage$annotations", "()V", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Stage {
        private final Instant endTime;
        private final int stage;
        private final Instant startTime;

        public Stage(Instant instant, Instant instant2, int i) {
            instant.getClass();
            instant2.getClass();
            this.startTime = instant;
            this.endTime = instant2;
            this.stage = i;
            if (instant.isBefore(instant2)) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("startTime must be before endTime.");
            throw null;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stage)) {
                return false;
            }
            Stage stage = (Stage) other;
            return this.stage == stage.stage && Intrinsics.areEqual(this.startTime, stage.startTime) && Intrinsics.areEqual(this.endTime, stage.endTime);
        }

        public final Instant getEndTime() {
            return this.endTime;
        }

        public final int getStage() {
            return this.stage;
        }

        public final Instant getStartTime() {
            return this.startTime;
        }

        public int hashCode() {
            return this.endTime.hashCode() + ((this.startTime.hashCode() + (Integer.hashCode(this.stage) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Stage(startTime=");
            sb.append(this.startTime);
            sb.append(", endTime=");
            sb.append(this.endTime);
            sb.append(", stage=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.stage, ')');
        }
    }

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("awake", 1), TuplesKt.to("sleeping", 2), TuplesKt.to("out_of_bed", 3), TuplesKt.to("light", 4), TuplesKt.to("deep", 5), TuplesKt.to("rem", 6), TuplesKt.to("awake_in_bed", 7), TuplesKt.to("unknown", 0));
        STAGE_TYPE_STRING_TO_INT_MAP = mapMapOf;
        Set<Map.Entry<String, Integer>> setEntrySet = mapMapOf.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(Integer.valueOf(((Number) entry.getValue()).intValue()), (String) entry.getKey());
        }
        STAGE_TYPE_INT_TO_STRING_MAP = linkedHashMap;
    }

    public SleepSessionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, String str, String str2, List<Stage> list) {
        instant.getClass();
        instant2.getClass();
        metadata.getClass();
        list.getClass();
        this.startTime = instant;
        this.startZoneOffset = zoneOffset;
        this.endTime = instant2;
        this.endZoneOffset = zoneOffset2;
        this.metadata = metadata;
        this.title = str;
        this.notes = str2;
        this.stages = list;
        if (!getStartTime().isBefore(getEndTime())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("startTime must be before endTime.");
            throw null;
        }
        if (list.isEmpty()) {
            return;
        }
        int i = 0;
        List listSortedWith = CollectionsKt.sortedWith(list, new SleepSessionRecord$$ExternalSyntheticLambda0(new Function2<Stage, Stage, Integer>() { // from class: androidx.health.connect.client.records.SleepSessionRecord$sortedStages$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(SleepSessionRecord.Stage stage, SleepSessionRecord.Stage stage2) {
                return Integer.valueOf(stage.getStartTime().compareTo(stage2.getStartTime()));
            }
        }, i));
        int lastIndex = CollectionsKt.getLastIndex(listSortedWith);
        while (i < lastIndex) {
            Instant endTime = ((Stage) listSortedWith.get(i)).getEndTime();
            i++;
            if (endTime.isAfter(((Stage) listSortedWith.get(i)).getStartTime())) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Failed requirement.");
                throw null;
            }
        }
        if (((Stage) CollectionsKt.first(listSortedWith)).getStartTime().isBefore(getStartTime())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Failed requirement.");
            throw null;
        }
        if (((Stage) CollectionsKt.last(listSortedWith)).getEndTime().isAfter(getEndTime())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Failed requirement.");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int _init_$lambda$1(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SleepSessionRecord)) {
            return false;
        }
        SleepSessionRecord sleepSessionRecord = (SleepSessionRecord) other;
        return Intrinsics.areEqual(this.title, sleepSessionRecord.title) && Intrinsics.areEqual(this.notes, sleepSessionRecord.notes) && Intrinsics.areEqual(this.stages, sleepSessionRecord.stages) && Intrinsics.areEqual(getStartTime(), sleepSessionRecord.getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), sleepSessionRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), sleepSessionRecord.getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), sleepSessionRecord.getEndZoneOffset()) && Intrinsics.areEqual(getMetadata(), sleepSessionRecord.getMetadata());
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getEndTime() {
        return this.endTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getEndZoneOffset() {
        return this.endZoneOffset;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final List<Stage> getStages() {
        return this.stages;
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
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.notes;
        int iM = FileInsert$$ExternalSyntheticOutline0.m((List) this.stages, (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31, 31);
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode2 = (getEndTime().hashCode() + ((iM + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31)) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return getMetadata().hashCode() + ((iHashCode2 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "SleepSessionRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", title=" + this.title + ", notes=" + this.notes + ", stages=" + this.stages + ", metadata=" + getMetadata() + ')';
    }
}
