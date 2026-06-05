package androidx.health.connect.client.request;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.time.TimeRangeFilter;
import j$.time.Duration;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B9\u0012\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016¨\u0006\u001e"}, d2 = {"Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "metrics", "Landroidx/health/connect/client/time/TimeRangeFilter;", "timeRangeFilter", "j$/time/Duration", "timeRangeSlicer", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "dataOriginFilter", "<init>", "(Ljava/util/Set;Landroidx/health/connect/client/time/TimeRangeFilter;Lj$/time/Duration;Ljava/util/Set;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/util/Set;", "getMetrics$connect_client_release", "()Ljava/util/Set;", "Landroidx/health/connect/client/time/TimeRangeFilter;", "getTimeRangeFilter$connect_client_release", "()Landroidx/health/connect/client/time/TimeRangeFilter;", "Lj$/time/Duration;", "getTimeRangeSlicer$connect_client_release", "()Lj$/time/Duration;", "getDataOriginFilter$connect_client_release", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AggregateGroupByDurationRequest {
    private final Set<DataOrigin> dataOriginFilter;
    private final Set<AggregateMetric<?>> metrics;
    private final TimeRangeFilter timeRangeFilter;
    private final Duration timeRangeSlicer;

    /* JADX WARN: Multi-variable type inference failed */
    public AggregateGroupByDurationRequest(Set<? extends AggregateMetric<?>> set, TimeRangeFilter timeRangeFilter, Duration duration, Set<DataOrigin> set2) {
        set.getClass();
        timeRangeFilter.getClass();
        duration.getClass();
        set2.getClass();
        this.metrics = set;
        this.timeRangeFilter = timeRangeFilter;
        this.timeRangeSlicer = duration;
        this.dataOriginFilter = set2;
        if ((timeRangeFilter.getLocalStartTime() == null && timeRangeFilter.getLocalEndTime() == null) || Intrinsics.areEqual(duration, Duration.ofMinutes(duration.toMinutes()))) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Either set Duration with at least MINUTE units or use AggregateGroupByPeriodRequest");
        throw null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AggregateGroupByDurationRequest.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        AggregateGroupByDurationRequest aggregateGroupByDurationRequest = (AggregateGroupByDurationRequest) other;
        return Intrinsics.areEqual(this.metrics, aggregateGroupByDurationRequest.metrics) && Intrinsics.areEqual(this.timeRangeFilter, aggregateGroupByDurationRequest.timeRangeFilter) && Intrinsics.areEqual(this.timeRangeSlicer, aggregateGroupByDurationRequest.timeRangeSlicer) && Intrinsics.areEqual(this.dataOriginFilter, aggregateGroupByDurationRequest.dataOriginFilter);
    }

    public final Set<DataOrigin> getDataOriginFilter$connect_client_release() {
        return this.dataOriginFilter;
    }

    public final Set<AggregateMetric<?>> getMetrics$connect_client_release() {
        return this.metrics;
    }

    /* JADX INFO: renamed from: getTimeRangeFilter$connect_client_release, reason: from getter */
    public final TimeRangeFilter getTimeRangeFilter() {
        return this.timeRangeFilter;
    }

    /* JADX INFO: renamed from: getTimeRangeSlicer$connect_client_release, reason: from getter */
    public final Duration getTimeRangeSlicer() {
        return this.timeRangeSlicer;
    }

    public int hashCode() {
        return this.dataOriginFilter.hashCode() + ((this.timeRangeSlicer.hashCode() + ((this.timeRangeFilter.hashCode() + (this.metrics.hashCode() * 31)) * 31)) * 31);
    }

    public /* synthetic */ AggregateGroupByDurationRequest(Set set, TimeRangeFilter timeRangeFilter, Duration duration, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, timeRangeFilter, duration, (i & 8) != 0 ? SetsKt.emptySet() : set2);
    }
}
