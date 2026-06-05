package androidx.health.connect.client.aggregate;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "", "Landroidx/health/connect/client/aggregate/AggregationResult;", "result", "j$/time/Instant", "startTime", SDKConstants.PARAM_END_TIME, "j$/time/ZoneOffset", "zoneOffset", "", "shouldSkipValidation", "<init>", "(Landroidx/health/connect/client/aggregate/AggregationResult;Lj$/time/Instant;Lj$/time/Instant;Lj$/time/ZoneOffset;Z)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Landroidx/health/connect/client/aggregate/AggregationResult;", "getResult", "()Landroidx/health/connect/client/aggregate/AggregationResult;", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "getEndTime", "Lj$/time/ZoneOffset;", "getZoneOffset", "()Lj$/time/ZoneOffset;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AggregationResultGroupedByDuration {
    private final Instant endTime;
    private final AggregationResult result;
    private final Instant startTime;
    private final ZoneOffset zoneOffset;

    public AggregationResultGroupedByDuration(AggregationResult aggregationResult, Instant instant, Instant instant2, ZoneOffset zoneOffset, boolean z) {
        aggregationResult.getClass();
        instant.getClass();
        instant2.getClass();
        zoneOffset.getClass();
        this.result = aggregationResult;
        this.startTime = instant;
        this.endTime = instant2;
        this.zoneOffset = zoneOffset;
        if (z || instant.isBefore(instant2)) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("start time must be before end time");
        throw null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AggregationResultGroupedByDuration.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        AggregationResultGroupedByDuration aggregationResultGroupedByDuration = (AggregationResultGroupedByDuration) other;
        return Intrinsics.areEqual(this.result, aggregationResultGroupedByDuration.result) && Intrinsics.areEqual(this.startTime, aggregationResultGroupedByDuration.startTime) && Intrinsics.areEqual(this.endTime, aggregationResultGroupedByDuration.endTime) && Intrinsics.areEqual(this.zoneOffset, aggregationResultGroupedByDuration.zoneOffset);
    }

    public final Instant getEndTime() {
        return this.endTime;
    }

    public final AggregationResult getResult() {
        return this.result;
    }

    public final Instant getStartTime() {
        return this.startTime;
    }

    public final ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public int hashCode() {
        return this.zoneOffset.hashCode() + ((this.endTime.hashCode() + ((this.startTime.hashCode() + (this.result.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        return "AggregationResultGroupedByDuration(result=" + this.result + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", zoneOffset=" + this.zoneOffset + ')';
    }

    public /* synthetic */ AggregationResultGroupedByDuration(AggregationResult aggregationResult, Instant instant, Instant instant2, ZoneOffset zoneOffset, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aggregationResult, instant, instant2, zoneOffset, (i & 16) != 0 ? false : z);
    }
}
