package androidx.health.connect.client.records;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b!\u0018\u0000 72\u00020\u0001:\u00017Bu\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b%\u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b&\u0010$R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u000b\u001a\u00020\n8G¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b\u000b\u0010+R\u001d\u0010\r\u001a\u00020\f8\u0006¢\u0006\u0012\n\u0004\b\r\u0010,\u0012\u0004\b.\u0010/\u001a\u0004\b-\u0010\u001cR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00100\u001a\u0004\b1\u0010\u001eR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u00102\u001a\u0004\b3\u00104R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0013\u00100\u001a\u0004\b5\u0010\u001eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u00100\u001a\u0004\b6\u0010\u001e¨\u00068"}, d2 = {"Landroidx/health/connect/client/records/PlannedExerciseSessionRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "j$/time/Instant", "startTime", "j$/time/ZoneOffset", "startZoneOffset", SDKConstants.PARAM_END_TIME, "endZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "", "hasExplicitTime", "", "exerciseType", "", "completedExerciseSessionId", "", "Landroidx/health/connect/client/records/PlannedExerciseBlock;", "blocks", "title", "notes", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;ZILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getStartZoneOffset", "()Lj$/time/ZoneOffset;", "getEndTime", "getEndZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "Z", "()Z", "I", "getExerciseType", "getExerciseType$annotations", "()V", "Ljava/lang/String;", "getCompletedExerciseSessionId", "Ljava/util/List;", "getBlocks", "()Ljava/util/List;", "getTitle", "getNotes", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlannedExerciseSessionRecord implements IntervalRecord {
    private final List<PlannedExerciseBlock> blocks;
    private final String completedExerciseSessionId;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final int exerciseType;
    private final boolean hasExplicitTime;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final String notes;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private final String title;

    public PlannedExerciseSessionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, boolean z, int i, String str, List<PlannedExerciseBlock> list, String str2, String str3) {
        instant.getClass();
        instant2.getClass();
        metadata.getClass();
        list.getClass();
        this.startTime = instant;
        this.startZoneOffset = zoneOffset;
        this.endTime = instant2;
        this.endZoneOffset = zoneOffset2;
        this.metadata = metadata;
        this.hasExplicitTime = z;
        this.exerciseType = i;
        this.completedExerciseSessionId = str;
        this.blocks = list;
        this.title = str2;
        this.notes = str3;
        if (getStartTime().isBefore(getEndTime())) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Failed requirement.");
        throw null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlannedExerciseSessionRecord)) {
            return false;
        }
        PlannedExerciseSessionRecord plannedExerciseSessionRecord = (PlannedExerciseSessionRecord) other;
        return Intrinsics.areEqual(getStartTime(), plannedExerciseSessionRecord.getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), plannedExerciseSessionRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), plannedExerciseSessionRecord.getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), plannedExerciseSessionRecord.getEndZoneOffset()) && this.hasExplicitTime == plannedExerciseSessionRecord.hasExplicitTime && Intrinsics.areEqual(this.blocks, plannedExerciseSessionRecord.blocks) && Intrinsics.areEqual(this.title, plannedExerciseSessionRecord.title) && Intrinsics.areEqual(this.notes, plannedExerciseSessionRecord.notes) && this.exerciseType == plannedExerciseSessionRecord.exerciseType && Intrinsics.areEqual(getMetadata(), plannedExerciseSessionRecord.getMetadata());
    }

    public final List<PlannedExerciseBlock> getBlocks() {
        return this.blocks;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getEndTime() {
        return this.endTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getEndZoneOffset() {
        return this.endZoneOffset;
    }

    public final int getExerciseType() {
        return this.exerciseType;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
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

    /* JADX INFO: renamed from: hasExplicitTime, reason: from getter */
    public final boolean getHasExplicitTime() {
        return this.hasExplicitTime;
    }

    public int hashCode() {
        int iHashCode = getStartTime().hashCode() * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode2 = (getEndTime().hashCode() + ((iHashCode + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31)) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        int iM = FileInsert$$ExternalSyntheticOutline0.m((List) this.blocks, FileInsert$$ExternalSyntheticOutline0.m(this.hasExplicitTime, (iHashCode2 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31, 31), 31);
        String str = this.title;
        int iHashCode3 = (iM + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.notes;
        int iHashCode4 = (((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.exerciseType) * 31;
        String str3 = this.completedExerciseSessionId;
        return getMetadata().hashCode() + ((iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlannedExerciseSessionRecord(startTime=");
        sb.append(getStartTime());
        sb.append(", startZoneOffset=");
        sb.append(getStartZoneOffset());
        sb.append(", endTime=");
        sb.append(getEndTime());
        sb.append(", endZoneOffset=");
        sb.append(getEndZoneOffset());
        sb.append(", hasExplicitTime=");
        sb.append(this.hasExplicitTime);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", notes=");
        sb.append(this.notes);
        sb.append(", exerciseType=");
        sb.append(this.exerciseType);
        sb.append(", completedExerciseSessionId=");
        sb.append(this.completedExerciseSessionId);
        sb.append(", metadata=");
        sb.append(getMetadata());
        sb.append(", blocks=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.blocks, ')');
    }
}
