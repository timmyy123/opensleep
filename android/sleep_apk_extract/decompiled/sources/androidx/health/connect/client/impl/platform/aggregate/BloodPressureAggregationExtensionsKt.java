package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.units.Pressure;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006\" \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/health/connect/client/HealthConnectClient;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "aggregateRequest", "", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationResultGroupedByDurationWithMinTime;", "aggregateBloodPressure", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "Landroidx/health/connect/client/units/Pressure;", "BLOOD_PRESSURE_METRICS", "Ljava/util/Set;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class BloodPressureAggregationExtensionsKt {
    private static final Set<AggregateMetric<Pressure>> BLOOD_PRESSURE_METRICS = SetsKt.setOf((Object[]) new AggregateMetric[]{BloodPressureRecord.DIASTOLIC_AVG, BloodPressureRecord.DIASTOLIC_MAX, BloodPressureRecord.DIASTOLIC_MIN, BloodPressureRecord.SYSTOLIC_AVG, BloodPressureRecord.SYSTOLIC_MAX, BloodPressureRecord.SYSTOLIC_MIN});

    public static final Object aggregateBloodPressure(HealthConnectClient healthConnectClient, final AggregateGroupByDurationRequest aggregateGroupByDurationRequest, Continuation<? super List<AggregationResultGroupedByDurationWithMinTime>> continuation) {
        return HealthConnectClientAggregationExtensionsKt.aggregate(healthConnectClient, new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(BloodPressureRecord.class), aggregateGroupByDurationRequest.getTimeRangeFilter(), aggregateGroupByDurationRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null), new ResultGroupedByDurationAggregator(TimeRangeFilterUtilsKt.createTimeRange(aggregateGroupByDurationRequest.getTimeRangeFilter()), aggregateGroupByDurationRequest.getTimeRangeSlicer(), new Function1<InstantTimeRange, AggregationProcessor<BloodPressureRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.BloodPressureAggregationExtensionsKt.aggregateBloodPressure.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AggregationProcessor<BloodPressureRecord> invoke(InstantTimeRange instantTimeRange) {
                instantTimeRange.getClass();
                return new BloodPressureAggregationProcessor(aggregateGroupByDurationRequest.getMetrics$connect_client_release());
            }
        }), continuation);
    }
}
