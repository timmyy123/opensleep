package androidx.health.connect.client.impl.platform.aggregate;

import android.os.ext.SdkExtensions;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0005\u001a+\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0016\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\u0007\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\"$\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "Lkotlin/Function1;", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "", "predicate", "withFilteredMetrics", "(Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;Lkotlin/jvm/functions/Function1;)Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "isPlatformSupportedMetric", "(Landroidx/health/connect/client/aggregate/AggregateMetric;)Z", "", "AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10", "Ljava/util/Set;", "getAGGREGATE_METRICS_ADDED_IN_SDK_EXT_10", "()Ljava/util/Set;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class AggregationExtensionsKt {
    private static final Set<AggregateMetric<?>> AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10 = SetsKt.setOf((Object[]) new AggregateMetric[]{BloodPressureRecord.DIASTOLIC_AVG, BloodPressureRecord.DIASTOLIC_MAX, BloodPressureRecord.DIASTOLIC_MIN, BloodPressureRecord.SYSTOLIC_AVG, BloodPressureRecord.SYSTOLIC_MAX, BloodPressureRecord.SYSTOLIC_MIN, CyclingPedalingCadenceRecord.RPM_AVG, CyclingPedalingCadenceRecord.RPM_MAX, CyclingPedalingCadenceRecord.RPM_MIN, NutritionRecord.TRANS_FAT_TOTAL, SpeedRecord.SPEED_AVG, SpeedRecord.SPEED_MAX, SpeedRecord.SPEED_MIN, StepsCadenceRecord.RATE_AVG, StepsCadenceRecord.RATE_MAX, StepsCadenceRecord.RATE_MIN});

    public static final boolean isPlatformSupportedMetric(AggregateMetric<?> aggregateMetric) {
        aggregateMetric.getClass();
        return SdkExtensions.getExtensionVersion(34) >= 10 || !AGGREGATE_METRICS_ADDED_IN_SDK_EXT_10.contains(aggregateMetric);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final AggregateGroupByDurationRequest withFilteredMetrics(AggregateGroupByDurationRequest aggregateGroupByDurationRequest, Function1<? super AggregateMetric<?>, Boolean> function1) {
        aggregateGroupByDurationRequest.getClass();
        function1.getClass();
        Set<AggregateMetric<?>> metrics$connect_client_release = aggregateGroupByDurationRequest.getMetrics$connect_client_release();
        ArrayList arrayList = new ArrayList();
        for (Object obj : metrics$connect_client_release) {
            if (function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return new AggregateGroupByDurationRequest(CollectionsKt.toSet(arrayList), aggregateGroupByDurationRequest.getTimeRangeFilter(), aggregateGroupByDurationRequest.getTimeRangeSlicer(), aggregateGroupByDurationRequest.getDataOriginFilter$connect_client_release());
    }
}
