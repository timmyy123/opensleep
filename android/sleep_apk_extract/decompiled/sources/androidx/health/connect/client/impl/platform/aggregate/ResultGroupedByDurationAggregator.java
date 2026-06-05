package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.records.InstantaneousRecord;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.Record;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.zone.ZoneRules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.jvm.functions.Function1;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003B5\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001eR&\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0014\u0010 \u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R&\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/ResultGroupedByDurationAggregator;", "Landroidx/health/connect/client/records/Record;", "T", "Landroidx/health/connect/client/impl/platform/aggregate/Aggregator;", "", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationResultGroupedByDurationWithMinTime;", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "timeRange", "j$/time/Duration", "bucketDuration", "Lkotlin/Function1;", "Landroidx/health/connect/client/impl/platform/aggregate/InstantTimeRange;", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "initProcessor", "<init>", "(Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;Lj$/time/Duration;Lkotlin/jvm/functions/Function1;)V", "j$/time/Instant", "time", "getBucketStartTime", "(Lj$/time/Instant;)Lj$/time/Instant;", "bucketStartTime", "getBucketTimeRange", "(Lj$/time/Instant;)Landroidx/health/connect/client/impl/platform/aggregate/InstantTimeRange;", "record", "", "filterAndAggregate", "(Landroidx/health/connect/client/records/Record;)V", "getResult", "()Ljava/util/List;", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "Lj$/time/Duration;", "Lkotlin/jvm/functions/Function1;", "instantTimeRange", "Landroidx/health/connect/client/impl/platform/aggregate/InstantTimeRange;", "", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessorWithZoneOffset;", "bucketProcessors", "Ljava/util/Map;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ResultGroupedByDurationAggregator<T extends Record> implements Aggregator<T, List<? extends AggregationResultGroupedByDurationWithMinTime>> {
    private final Duration bucketDuration;
    private final Map<Instant, AggregationProcessorWithZoneOffset<T>> bucketProcessors;
    private final Function1<InstantTimeRange, AggregationProcessor<T>> initProcessor;
    private final InstantTimeRange instantTimeRange;
    private final TimeRange<?> timeRange;

    /* JADX WARN: Multi-variable type inference failed */
    public ResultGroupedByDurationAggregator(TimeRange<?> timeRange, Duration duration, Function1<? super InstantTimeRange, ? extends AggregationProcessor<T>> function1) {
        InstantTimeRange instantTimeRange;
        timeRange.getClass();
        duration.getClass();
        function1.getClass();
        this.timeRange = timeRange;
        this.bucketDuration = duration;
        this.initProcessor = function1;
        if (timeRange instanceof InstantTimeRange) {
            instantTimeRange = (InstantTimeRange) timeRange;
        } else {
            if (!(timeRange instanceof LocalTimeRange)) {
                Home$$ExternalSyntheticBUOutline0.m();
                throw null;
            }
            Instant instant = ((LocalTimeRange) timeRange).getStartTime().toInstant(ZoneOffset.MAX);
            instant.getClass();
            Instant instant2 = ((LocalTimeRange) timeRange).getEndTime().toInstant(ZoneOffset.MIN);
            instant2.getClass();
            instantTimeRange = new InstantTimeRange(instant, instant2);
        }
        this.instantTimeRange = instantTimeRange;
        this.bucketProcessors = new LinkedHashMap();
    }

    private final Instant getBucketStartTime(Instant time) {
        Instant instantPlus = this.instantTimeRange.getStartTime().plus(this.bucketDuration.multipliedBy(Duration.between(this.instantTimeRange.getStartTime(), time).dividedBy(this.bucketDuration)));
        instantPlus.getClass();
        return instantPlus;
    }

    private final InstantTimeRange getBucketTimeRange(Instant bucketStartTime) {
        Instant instantPlus = bucketStartTime.plus(this.bucketDuration);
        instantPlus.getClass();
        Instant instant = (Instant) ComparisonsKt___ComparisonsJvmKt.minOf(instantPlus, this.instantTimeRange.getEndTime());
        instant.getClass();
        return new InstantTimeRange(bucketStartTime, instant);
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public void filterAndAggregate(T record) {
        Instant bucketStartTime;
        Instant bucketStartTime2;
        record.getClass();
        if (!AggregatorUtils.INSTANCE.contributesToAggregation$connect_client_release(record, this.timeRange)) {
            return;
        }
        Instant startTime = this.instantTimeRange.getStartTime();
        boolean z = record instanceof InstantaneousRecord;
        if (z) {
            bucketStartTime = getBucketStartTime(((InstantaneousRecord) record).getTime());
        } else {
            if (!(record instanceof IntervalRecord)) {
                Utf8$$ExternalSyntheticBUOutline0.m("Unsupported value for aggregation: ", record);
                return;
            }
            bucketStartTime = getBucketStartTime(((IntervalRecord) record).getStartTime());
        }
        Object objMaxOf = ComparisonsKt___ComparisonsJvmKt.maxOf(startTime, bucketStartTime);
        if (z) {
            bucketStartTime2 = (Instant) objMaxOf;
        } else {
            if (!(record instanceof IntervalRecord)) {
                Utf8$$ExternalSyntheticBUOutline0.m("Unsupported value for aggregation: ", record);
                return;
            }
            bucketStartTime2 = getBucketStartTime(((IntervalRecord) record).getEndTime());
        }
        while (true) {
            Instant instant = (Instant) objMaxOf;
            if (instant.compareTo(bucketStartTime2) > 0 || instant.compareTo(this.instantTimeRange.getEndTime()) >= 0) {
                return;
            }
            InstantTimeRange bucketTimeRange = getBucketTimeRange(instant);
            if (AggregatorUtils.INSTANCE.contributesToAggregation$connect_client_release(record, bucketTimeRange)) {
                Map<Instant, AggregationProcessorWithZoneOffset<T>> map = this.bucketProcessors;
                AggregationProcessorWithZoneOffset<T> aggregationProcessorWithZoneOffset = map.get(objMaxOf);
                if (aggregationProcessorWithZoneOffset == null) {
                    aggregationProcessorWithZoneOffset = new AggregationProcessorWithZoneOffset<>(this.initProcessor.invoke(bucketTimeRange), instant);
                    map.put((Instant) objMaxOf, aggregationProcessorWithZoneOffset);
                }
                aggregationProcessorWithZoneOffset.processRecord(record);
            }
            objMaxOf = instant.plus(this.bucketDuration);
            objMaxOf.getClass();
        }
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.Aggregator
    public List<? extends AggregationResultGroupedByDurationWithMinTime> getResult() {
        Collection<AggregationProcessorWithZoneOffset<T>> collectionValues = this.bucketProcessors.values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            AggregationProcessorWithZoneOffset aggregationProcessorWithZoneOffset = (AggregationProcessorWithZoneOffset) it.next();
            InstantTimeRange bucketTimeRange = getBucketTimeRange(aggregationProcessorWithZoneOffset.getBucketStartTime());
            ZoneOffset zoneOffset = aggregationProcessorWithZoneOffset.getZoneOffset();
            if (zoneOffset == null) {
                ZoneRules rules = ZoneId.systemDefault().getRules();
                Instant minTime = aggregationProcessorWithZoneOffset.getMinTime();
                if (minTime == null) {
                    minTime = Instant.now();
                }
                zoneOffset = rules.getOffset(minTime);
            }
            ZoneOffset zoneOffset2 = zoneOffset;
            AggregationResult processedAggregationResult = aggregationProcessorWithZoneOffset.getProcessedAggregationResult();
            Instant startTime = bucketTimeRange.getStartTime();
            Instant endTime = bucketTimeRange.getEndTime();
            zoneOffset2.getClass();
            AggregationResultGroupedByDuration aggregationResultGroupedByDuration = new AggregationResultGroupedByDuration(processedAggregationResult, startTime, endTime, zoneOffset2, false, 16, null);
            Instant minTime2 = aggregationProcessorWithZoneOffset.getMinTime();
            if (minTime2 == null) {
                minTime2 = Instant.MAX;
            }
            minTime2.getClass();
            arrayList.add(new AggregationResultGroupedByDurationWithMinTime(aggregationResultGroupedByDuration, minTime2));
        }
        return arrayList;
    }
}
