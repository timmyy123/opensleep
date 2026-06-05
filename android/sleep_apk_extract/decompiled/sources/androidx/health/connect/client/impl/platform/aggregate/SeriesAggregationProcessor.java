package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.impl.platform.TimeExtensionsKt;
import androidx.health.connect.client.records.SeriesRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\b\u0001\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B3\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R!\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0014R \u0010.\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030-0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00060"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/SeriesAggregationProcessor;", "Landroidx/health/connect/client/records/SeriesRecord;", "T", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "Lkotlin/reflect/KClass;", "recordType", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "metrics", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "timeRange", "<init>", "(Lkotlin/reflect/KClass;Ljava/util/Set;Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;)V", "record", "", "processRecord", "(Landroidx/health/connect/client/records/SeriesRecord;)V", "Landroidx/health/connect/client/aggregate/AggregationResult;", "getProcessedAggregationResult", "()Landroidx/health/connect/client/aggregate/AggregationResult;", "Ljava/util/Set;", "getMetrics", "()Ljava/util/Set;", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "getTimeRange", "()Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "avgData", "Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "getAvgData", "()Landroidx/health/connect/client/impl/platform/aggregate/AvgData;", "", "min", "Ljava/lang/Double;", "getMin", "()Ljava/lang/Double;", "setMin", "(Ljava/lang/Double;)V", "max", "getMax", "setMax", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "dataOrigins", "Landroidx/health/connect/client/impl/platform/aggregate/AggregateMetricsInfo;", "", "aggregateInfo", "Landroidx/health/connect/client/impl/platform/aggregate/AggregateMetricsInfo;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SeriesAggregationProcessor<T extends SeriesRecord<?>> implements AggregationProcessor<T> {
    private final AggregateMetricsInfo<? extends Comparable<?>> aggregateInfo;
    private final AvgData avgData;
    private final Set<DataOrigin> dataOrigins;
    private Double max;
    private final Set<AggregateMetric<?>> metrics;
    private Double min;
    private final TimeRange<?> timeRange;

    /* JADX WARN: Multi-variable type inference failed */
    public SeriesAggregationProcessor(KClass<T> kClass, Set<? extends AggregateMetric<?>> set, TimeRange<?> timeRange) {
        kClass.getClass();
        set.getClass();
        timeRange.getClass();
        this.metrics = set;
        this.timeRange = timeRange;
        this.avgData = new AvgData(0, 0.0d, 3, null);
        this.dataOrigins = new LinkedHashSet();
        AggregateMetricsInfo<? extends Comparable<?>> aggregateMetricsInfo = (AggregateMetricsInfo) SeriesRecordAggregationExtensionsKt.RECORDS_TO_AGGREGATE_METRICS_INFO_MAP.get(kClass);
        if (aggregateMetricsInfo == null) {
            Gson$$ExternalSyntheticBUOutline0.m("Non supported fallback series record ", kClass);
            throw null;
        }
        this.aggregateInfo = aggregateMetricsInfo;
        if (SetsKt.setOf((Object[]) new AggregateMetric[]{aggregateMetricsInfo.getAverageMetric(), aggregateMetricsInfo.getMinMetric(), aggregateMetricsInfo.getMaxMetric()}).containsAll(set)) {
            return;
        }
        StringBuilder sb = new StringBuilder("Invalid set of metrics ");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((AggregateMetric) it.next()).getMetricKey());
        }
        sb.append(arrayList);
        throw new IllegalStateException(sb.toString().toString());
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public AggregationResult getProcessedAggregationResult() {
        Map mapEmptyMap;
        double dDoubleValue;
        if (this.dataOrigins.isEmpty()) {
            mapEmptyMap = MapsKt.emptyMap();
        } else {
            Set<AggregateMetric<?>> set = this.metrics;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set, 10)), 16));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                AggregateMetric aggregateMetric = (AggregateMetric) it.next();
                String metricKey = aggregateMetric.getMetricKey();
                if (Intrinsics.areEqual(aggregateMetric, this.aggregateInfo.getAverageMetric())) {
                    dDoubleValue = this.avgData.average();
                } else if (Intrinsics.areEqual(aggregateMetric, this.aggregateInfo.getMaxMetric())) {
                    Double d = this.max;
                    d.getClass();
                    dDoubleValue = d.doubleValue();
                } else {
                    if (!Intrinsics.areEqual(aggregateMetric, this.aggregateInfo.getMinMetric())) {
                        FacebookSdk$$ExternalSyntheticLambda1.m$2("Invalid fallback aggregation metric ", aggregateMetric.getMetricKey());
                        return null;
                    }
                    Double d2 = this.min;
                    d2.getClass();
                    dDoubleValue = d2.doubleValue();
                }
                linkedHashMap.put(metricKey, Double.valueOf(dDoubleValue));
            }
            mapEmptyMap = linkedHashMap;
        }
        return new AggregationResult(MapsKt.emptyMap(), mapEmptyMap, this.dataOrigins);
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public void processRecord(T record) {
        record.getClass();
        List samples = record.getSamples();
        ArrayList arrayList = new ArrayList();
        for (Object obj : samples) {
            if (TimeExtensionsKt.isWithin(AggregatorUtils.INSTANCE.getTime$connect_client_release(obj), this.timeRange, record.getStartZoneOffset())) {
                arrayList.add(obj);
            }
        }
        for (Object obj2 : arrayList) {
            AvgData avgData = this.avgData;
            AggregatorUtils aggregatorUtils = AggregatorUtils.INSTANCE;
            avgData.plusAssign(aggregatorUtils.getValue$connect_client_release(obj2));
            Double d = this.min;
            this.min = Double.valueOf(Math.min(d != null ? d.doubleValue() : aggregatorUtils.getValue$connect_client_release(obj2), aggregatorUtils.getValue$connect_client_release(obj2)));
            Double d2 = this.max;
            this.max = Double.valueOf(Math.max(d2 != null ? d2.doubleValue() : aggregatorUtils.getValue$connect_client_release(obj2), aggregatorUtils.getValue$connect_client_release(obj2)));
        }
        this.dataOrigins.add(record.getMetadata().getDataOrigin());
    }
}
