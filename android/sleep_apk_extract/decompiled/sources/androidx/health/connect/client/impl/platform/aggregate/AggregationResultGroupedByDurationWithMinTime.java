package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/AggregationResultGroupedByDurationWithMinTime;", "", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "aggregationResultGroupedByDuration", "j$/time/Instant", "minTime", "<init>", "(Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;Lj$/time/Instant;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "getAggregationResultGroupedByDuration", "()Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "Lj$/time/Instant;", "getMinTime", "()Lj$/time/Instant;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class AggregationResultGroupedByDurationWithMinTime {
    private final AggregationResultGroupedByDuration aggregationResultGroupedByDuration;
    private final Instant minTime;

    public AggregationResultGroupedByDurationWithMinTime(AggregationResultGroupedByDuration aggregationResultGroupedByDuration, Instant instant) {
        aggregationResultGroupedByDuration.getClass();
        instant.getClass();
        this.aggregationResultGroupedByDuration = aggregationResultGroupedByDuration;
        this.minTime = instant;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AggregationResultGroupedByDurationWithMinTime)) {
            return false;
        }
        AggregationResultGroupedByDurationWithMinTime aggregationResultGroupedByDurationWithMinTime = (AggregationResultGroupedByDurationWithMinTime) other;
        return Intrinsics.areEqual(this.aggregationResultGroupedByDuration, aggregationResultGroupedByDurationWithMinTime.aggregationResultGroupedByDuration) && Intrinsics.areEqual(this.minTime, aggregationResultGroupedByDurationWithMinTime.minTime);
    }

    public final AggregationResultGroupedByDuration getAggregationResultGroupedByDuration() {
        return this.aggregationResultGroupedByDuration;
    }

    public final Instant getMinTime() {
        return this.minTime;
    }

    public int hashCode() {
        return this.minTime.hashCode() + (this.aggregationResultGroupedByDuration.hashCode() * 31);
    }

    public String toString() {
        return "AggregationResultGroupedByDurationWithMinTime(aggregationResultGroupedByDuration=" + this.aggregationResultGroupedByDuration + ", minTime=" + this.minTime + ')';
    }
}
