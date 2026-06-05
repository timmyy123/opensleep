package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.SeriesRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\":\u0010\u0006\u001a(\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u00040\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/SeriesRecord;", "", "Landroidx/health/connect/client/impl/platform/aggregate/AggregateMetricsInfo;", "", "RECORDS_TO_AGGREGATE_METRICS_INFO_MAP", "Ljava/util/Map;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class SeriesRecordAggregationExtensionsKt {
    private static final Map<KClass<? extends SeriesRecord<Object>>, AggregateMetricsInfo<? extends Comparable<?>>> RECORDS_TO_AGGREGATE_METRICS_INFO_MAP = MapsKt.mapOf(TuplesKt.to(Reflection.getOrCreateKotlinClass(CyclingPedalingCadenceRecord.class), new AggregateMetricsInfo(CyclingPedalingCadenceRecord.RPM_AVG, CyclingPedalingCadenceRecord.RPM_MIN, CyclingPedalingCadenceRecord.RPM_MAX)), TuplesKt.to(Reflection.getOrCreateKotlinClass(SpeedRecord.class), new AggregateMetricsInfo(SpeedRecord.SPEED_AVG, SpeedRecord.SPEED_MIN, SpeedRecord.SPEED_MAX)), TuplesKt.to(Reflection.getOrCreateKotlinClass(StepsCadenceRecord.class), new AggregateMetricsInfo(StepsCadenceRecord.RATE_AVG, StepsCadenceRecord.RATE_MIN, StepsCadenceRecord.RATE_MAX)));
}
