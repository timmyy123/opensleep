package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/health/connect/client/HealthConnectClient;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "aggregateRequest", "", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationResultGroupedByDurationWithMinTime;", "aggregateNutritionTransFatTotal", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class NutritionAggregationExtensionsKt {
    public static final Object aggregateNutritionTransFatTotal(HealthConnectClient healthConnectClient, AggregateGroupByDurationRequest aggregateGroupByDurationRequest, Continuation<? super List<AggregationResultGroupedByDurationWithMinTime>> continuation) {
        return HealthConnectClientAggregationExtensionsKt.aggregate(healthConnectClient, new ReadRecordsRequest(Reflection.getOrCreateKotlinClass(NutritionRecord.class), TimeRangeFilterUtilsKt.withBufferedStart(aggregateGroupByDurationRequest.getTimeRangeFilter()), aggregateGroupByDurationRequest.getDataOriginFilter$connect_client_release(), false, 0, null, 56, null), new ResultGroupedByDurationAggregator(TimeRangeFilterUtilsKt.createTimeRange(aggregateGroupByDurationRequest.getTimeRangeFilter()), aggregateGroupByDurationRequest.getTimeRangeSlicer(), new Function1<InstantTimeRange, AggregationProcessor<NutritionRecord>>() { // from class: androidx.health.connect.client.impl.platform.aggregate.NutritionAggregationExtensionsKt.aggregateNutritionTransFatTotal.5
            @Override // kotlin.jvm.functions.Function1
            public final AggregationProcessor<NutritionRecord> invoke(InstantTimeRange instantTimeRange) {
                instantTimeRange.getClass();
                return new TransFatTotalAggregationProcessor(instantTimeRange);
            }
        }), continuation);
    }
}
