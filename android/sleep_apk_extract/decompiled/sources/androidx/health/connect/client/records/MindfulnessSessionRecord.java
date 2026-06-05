package androidx.health.connect.client.records;

import androidx.health.connect.client.aggregate.AggregateMetric;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,BS\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b \u0010\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\u0012\n\u0004\b\u000b\u0010%\u0012\u0004\b'\u0010(\u001a\u0004\b&\u0010\u0017R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010\u0019R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b+\u0010\u0019¨\u0006-"}, d2 = {"Landroidx/health/connect/client/records/MindfulnessSessionRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "j$/time/Instant", "startTime", "j$/time/ZoneOffset", "startZoneOffset", SDKConstants.PARAM_END_TIME, "endZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "", "mindfulnessSessionType", "", "title", "notes", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;ILjava/lang/String;Ljava/lang/String;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getStartZoneOffset", "()Lj$/time/ZoneOffset;", "getEndTime", "getEndZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "I", "getMindfulnessSessionType", "getMindfulnessSessionType$annotations", "()V", "Ljava/lang/String;", "getTitle", "getNotes", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MindfulnessSessionRecord implements IntervalRecord {
    public static final AggregateMetric<Duration> MINDFULNESS_DURATION_TOTAL = AggregateMetric.INSTANCE.durationMetric$connect_client_release("MindfulnessSession");
    public static final Map<Integer, String> MINDFULNESS_SESSION_TYPE_INT_TO_STRING_MAP;
    public static final Map<String, Integer> MINDFULNESS_SESSION_TYPE_STRING_TO_INT_MAP;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final int mindfulnessSessionType;
    private final String notes;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private final String title;

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("breathing", 2), TuplesKt.to("meditation", 1), TuplesKt.to("movement", 4), TuplesKt.to("music", 3), TuplesKt.to("unguided", 5), TuplesKt.to("unknown", 0));
        MINDFULNESS_SESSION_TYPE_STRING_TO_INT_MAP = mapMapOf;
        MINDFULNESS_SESSION_TYPE_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf);
    }

    public MindfulnessSessionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, int i, String str, String str2) {
        instant.getClass();
        instant2.getClass();
        metadata.getClass();
        this.startTime = instant;
        this.startZoneOffset = zoneOffset;
        this.endTime = instant2;
        this.endZoneOffset = zoneOffset2;
        this.metadata = metadata;
        this.mindfulnessSessionType = i;
        this.title = str;
        this.notes = str2;
        if (getStartTime().isBefore(getEndTime())) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("startTime must be before endTime.");
        throw null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MindfulnessSessionRecord)) {
            return false;
        }
        MindfulnessSessionRecord mindfulnessSessionRecord = (MindfulnessSessionRecord) other;
        return this.mindfulnessSessionType == mindfulnessSessionRecord.mindfulnessSessionType && Intrinsics.areEqual(this.title, mindfulnessSessionRecord.title) && Intrinsics.areEqual(this.notes, mindfulnessSessionRecord.notes) && Intrinsics.areEqual(getStartTime(), mindfulnessSessionRecord.getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), mindfulnessSessionRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), mindfulnessSessionRecord.getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), mindfulnessSessionRecord.getEndZoneOffset()) && Intrinsics.areEqual(getMetadata(), mindfulnessSessionRecord.getMetadata());
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

    public final int getMindfulnessSessionType() {
        return this.mindfulnessSessionType;
    }

    public final String getNotes() {
        return this.notes;
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
        int iHashCode = Integer.hashCode(this.mindfulnessSessionType) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.notes;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode4 = (getEndTime().hashCode() + ((iHashCode3 + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31)) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return getMetadata().hashCode() + ((iHashCode4 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "MindfulnessSessionRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", mindfulnessSessionType=" + this.mindfulnessSessionType + ", title=" + this.title + ", notes=" + this.notes + ", metadata=" + getMetadata() + ')';
    }
}
