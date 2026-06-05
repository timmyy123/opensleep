package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0081\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B1\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/AggregateMetricsInfo;", "", "T", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "averageMetric", "minMetric", "maxMetric", "<init>", "(Landroidx/health/connect/client/aggregate/AggregateMetric;Landroidx/health/connect/client/aggregate/AggregateMetric;Landroidx/health/connect/client/aggregate/AggregateMetric;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "getAverageMetric", "()Landroidx/health/connect/client/aggregate/AggregateMetric;", "getMinMetric", "getMaxMetric", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class AggregateMetricsInfo<T> {
    private final AggregateMetric<T> averageMetric;
    private final AggregateMetric<T> maxMetric;
    private final AggregateMetric<T> minMetric;

    /* JADX WARN: Multi-variable type inference failed */
    public AggregateMetricsInfo(AggregateMetric<? extends T> aggregateMetric, AggregateMetric<? extends T> aggregateMetric2, AggregateMetric<? extends T> aggregateMetric3) {
        aggregateMetric.getClass();
        aggregateMetric2.getClass();
        aggregateMetric3.getClass();
        this.averageMetric = aggregateMetric;
        this.minMetric = aggregateMetric2;
        this.maxMetric = aggregateMetric3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AggregateMetricsInfo)) {
            return false;
        }
        AggregateMetricsInfo aggregateMetricsInfo = (AggregateMetricsInfo) other;
        return Intrinsics.areEqual(this.averageMetric, aggregateMetricsInfo.averageMetric) && Intrinsics.areEqual(this.minMetric, aggregateMetricsInfo.minMetric) && Intrinsics.areEqual(this.maxMetric, aggregateMetricsInfo.maxMetric);
    }

    public final AggregateMetric<T> getAverageMetric() {
        return this.averageMetric;
    }

    public final AggregateMetric<T> getMaxMetric() {
        return this.maxMetric;
    }

    public final AggregateMetric<T> getMinMetric() {
        return this.minMetric;
    }

    public int hashCode() {
        return this.maxMetric.hashCode() + ((this.minMetric.hashCode() + (this.averageMetric.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "AggregateMetricsInfo(averageMetric=" + this.averageMetric + ", minMetric=" + this.minMetric + ", maxMetric=" + this.maxMetric + ')';
    }
}
