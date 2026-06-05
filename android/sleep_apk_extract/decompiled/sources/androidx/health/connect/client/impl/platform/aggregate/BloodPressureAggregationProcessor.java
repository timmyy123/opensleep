package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.units.Pressure;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR!\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0004\u0012\u0004\u0012\u00020\u00140\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R(\u0010\u0018\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u000f¨\u0006\u001c"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/BloodPressureAggregationProcessor;", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "Landroidx/health/connect/client/records/BloodPressureRecord;", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "metrics", "<init>", "(Ljava/util/Set;)V", "record", "", "processRecord", "(Landroidx/health/connect/client/records/BloodPressureRecord;)V", "Landroidx/health/connect/client/aggregate/AggregationResult;", "getProcessedAggregationResult", "()Landroidx/health/connect/client/aggregate/AggregationResult;", "Ljava/util/Set;", "getMetrics", "()Ljava/util/Set;", "", "Landroidx/health/connect/client/units/Pressure;", "Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "avgDataMap", "Ljava/util/Map;", "", "minMaxMap", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "dataOrigins", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BloodPressureAggregationProcessor implements AggregationProcessor<BloodPressureRecord> {
    private final Map<AggregateMetric<Pressure>, AvgData> avgDataMap;
    private final Set<DataOrigin> dataOrigins;
    private final Set<AggregateMetric<?>> metrics;
    private final Map<AggregateMetric<Pressure>, Double> minMaxMap;

    /* JADX WARN: Multi-variable type inference failed */
    public BloodPressureAggregationProcessor(Set<? extends AggregateMetric<?>> set) {
        set.getClass();
        this.metrics = set;
        this.avgDataMap = new LinkedHashMap();
        this.minMaxMap = new LinkedHashMap();
        this.dataOrigins = new LinkedHashSet();
        if (!BloodPressureAggregationExtensionsKt.BLOOD_PRESSURE_METRICS.containsAll(set)) {
            StringBuilder sb = new StringBuilder("Invalid set of blood pressure fallback aggregation metrics ");
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator it = set.iterator();
            while (it.hasNext()) {
                arrayList.add(((AggregateMetric) it.next()).getMetricKey());
            }
            sb.append(arrayList);
            throw new IllegalStateException(sb.toString().toString());
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            AggregateMetric<Pressure> aggregateMetric = (AggregateMetric) it2.next();
            if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_AVG) || Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_AVG)) {
                this.avgDataMap.put(aggregateMetric, new AvgData(0, 0.0d, 3, null));
            } else {
                if (!Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MAX) && !Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MIN) && !Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MAX) && !Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MIN)) {
                    FacebookSdk$$ExternalSyntheticLambda1.m$2("Invalid blood pressure fallback aggregation metric ", aggregateMetric.getMetricKey());
                    throw null;
                }
                this.minMaxMap.put(aggregateMetric, null);
            }
        }
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public AggregationResult getProcessedAggregationResult() {
        Map mapEmptyMap;
        double dAverage;
        if (this.dataOrigins.isEmpty()) {
            mapEmptyMap = MapsKt.emptyMap();
        } else {
            Set<AggregateMetric<?>> set = this.metrics;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set, 10)), 16));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                AggregateMetric aggregateMetric = (AggregateMetric) it.next();
                String metricKey = aggregateMetric.getMetricKey();
                if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_AVG) || Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_AVG)) {
                    AvgData avgData = this.avgDataMap.get(aggregateMetric);
                    avgData.getClass();
                    dAverage = avgData.average();
                } else {
                    if (!Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MAX) && !Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MIN) && !Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MAX) && !Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MIN)) {
                        FacebookSdk$$ExternalSyntheticLambda1.m$2("Invalid blood pressure fallback aggregation type ", aggregateMetric.getMetricKey());
                        return null;
                    }
                    Double d = this.minMaxMap.get(aggregateMetric);
                    d.getClass();
                    dAverage = d.doubleValue();
                }
                linkedHashMap.put(metricKey, Double.valueOf(dAverage));
            }
            mapEmptyMap = linkedHashMap;
        }
        return new AggregationResult(MapsKt.emptyMap(), mapEmptyMap, this.dataOrigins);
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public void processRecord(BloodPressureRecord record) {
        record.getClass();
        double value = record.getDiastolic().getValue();
        double value2 = record.getSystolic().getValue();
        for (AggregateMetric<?> aggregateMetric : this.metrics) {
            if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_AVG)) {
                AvgData avgData = this.avgDataMap.get(aggregateMetric);
                avgData.getClass();
                avgData.plusAssign(value);
            } else if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MAX)) {
                Map<AggregateMetric<Pressure>, Double> map = this.minMaxMap;
                Double d = map.get(aggregateMetric);
                map.put((AggregateMetric<Pressure>) aggregateMetric, Double.valueOf(Math.max(d != null ? d.doubleValue() : value, value)));
            } else if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.DIASTOLIC_MIN)) {
                Map<AggregateMetric<Pressure>, Double> map2 = this.minMaxMap;
                Double d2 = map2.get(aggregateMetric);
                map2.put((AggregateMetric<Pressure>) aggregateMetric, Double.valueOf(Math.min(d2 != null ? d2.doubleValue() : value, value)));
            } else if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_AVG)) {
                AvgData avgData2 = this.avgDataMap.get(aggregateMetric);
                avgData2.getClass();
                avgData2.plusAssign(value2);
            } else if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MAX)) {
                Map<AggregateMetric<Pressure>, Double> map3 = this.minMaxMap;
                Double d3 = map3.get(aggregateMetric);
                map3.put((AggregateMetric<Pressure>) aggregateMetric, Double.valueOf(Math.max(d3 != null ? d3.doubleValue() : value2, value2)));
            } else if (Intrinsics.areEqual(aggregateMetric, BloodPressureRecord.SYSTOLIC_MIN)) {
                Map<AggregateMetric<Pressure>, Double> map4 = this.minMaxMap;
                Double d4 = map4.get(aggregateMetric);
                map4.put((AggregateMetric<Pressure>) aggregateMetric, Double.valueOf(Math.min(d4 != null ? d4.doubleValue() : value2, value2)));
            }
            this.dataOrigins.add(record.getMetadata().getDataOrigin());
        }
    }
}
