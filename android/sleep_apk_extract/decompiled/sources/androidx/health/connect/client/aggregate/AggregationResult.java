package androidx.health.connect.client.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.metadata.DataOrigin;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\r*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000H\u0080\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028G¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00028G¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b!\u0010 R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/health/connect/client/aggregate/AggregationResult;", "", "", "", "", "longValues", "", "doubleValues", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "dataOrigins", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;)V", "T", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "metric", "get", "(Landroidx/health/connect/client/aggregate/AggregateMetric;)Ljava/lang/Object;", "other", "plus$connect_client_release", "(Landroidx/health/connect/client/aggregate/AggregationResult;)Landroidx/health/connect/client/aggregate/AggregationResult;", "plus", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/util/Map;", "getLongValues", "()Ljava/util/Map;", "getDoubleValues", "Ljava/util/Set;", "getDataOrigins", "()Ljava/util/Set;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AggregationResult {
    private final Set<DataOrigin> dataOrigins;
    private final Map<String, Double> doubleValues;
    private final Map<String, Long> longValues;

    public AggregationResult(Map<String, Long> map, Map<String, Double> map2, Set<DataOrigin> set) {
        map.getClass();
        map2.getClass();
        set.getClass();
        this.longValues = map;
        this.doubleValues = map2;
        this.dataOrigins = set;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AggregationResult.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        AggregationResult aggregationResult = (AggregationResult) other;
        return Intrinsics.areEqual(this.longValues, aggregationResult.longValues) && Intrinsics.areEqual(this.doubleValues, aggregationResult.doubleValues) && Intrinsics.areEqual(this.dataOrigins, aggregationResult.dataOrigins);
    }

    public final <T> T get(AggregateMetric<? extends T> metric) {
        metric.getClass();
        AggregateMetric.Converter<?, ? extends T> converter$connect_client_release = metric.getConverter$connect_client_release();
        if (converter$connect_client_release instanceof AggregateMetric.Converter.FromLong) {
            Long l = this.longValues.get(metric.getMetricKey());
            if (l != null) {
                return metric.getConverter$connect_client_release().invoke(l);
            }
            return null;
        }
        if (!(converter$connect_client_release instanceof AggregateMetric.Converter.FromDouble)) {
            Home$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        Double d = this.doubleValues.get(metric.getMetricKey());
        if (d != null) {
            return metric.getConverter$connect_client_release().invoke(d);
        }
        return null;
    }

    public int hashCode() {
        return this.dataOrigins.hashCode() + ((this.doubleValues.hashCode() + (this.longValues.hashCode() * 31)) * 31);
    }

    public final AggregationResult plus$connect_client_release(AggregationResult other) {
        other.getClass();
        return new AggregationResult(MapsKt.plus(this.longValues, other.longValues), MapsKt.plus(this.doubleValues, other.doubleValues), SetsKt.plus((Set) this.dataOrigins, (Iterable) other.dataOrigins));
    }

    public String toString() {
        return "AggregationResult(longValues=" + this.longValues + ", doubleValues=" + this.doubleValues + ", dataOrigins=" + this.dataOrigins + ')';
    }
}
