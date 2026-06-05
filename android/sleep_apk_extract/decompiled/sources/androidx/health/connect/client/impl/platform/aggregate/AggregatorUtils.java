package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.impl.converters.datatype.RecordsTypeNameMapKt;
import androidx.health.connect.client.impl.platform.TimeExtensionsKt;
import androidx.health.connect.client.records.BloodPressureRecord;
import androidx.health.connect.client.records.CyclingPedalingCadenceRecord;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.NutritionRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.SeriesRecord;
import androidx.health.connect.client.records.SpeedRecord;
import androidx.health.connect.client.records.StepsCadenceRecord;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import j$.time.Instant;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.jvm.internal.Reflection;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ#\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u00020\u0011*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u00020\r*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/AggregatorUtils;", "", "<init>", "()V", "Landroidx/health/connect/client/records/Record;", "record", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "timeRange", "", "contributesToAggregation$connect_client_release", "(Landroidx/health/connect/client/records/Record;Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;)Z", "contributesToAggregation", "Landroidx/health/connect/client/records/IntervalRecord;", "", "sliceFactor$connect_client_release", "(Landroidx/health/connect/client/records/IntervalRecord;Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;)D", "sliceFactor", "j$/time/Instant", "getTime$connect_client_release", "(Ljava/lang/Object;)Lj$/time/Instant;", "time", "getValue$connect_client_release", "(Ljava/lang/Object;)D", SDKConstants.PARAM_VALUE, "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AggregatorUtils {
    public static final AggregatorUtils INSTANCE = new AggregatorUtils();

    private AggregatorUtils() {
    }

    public final boolean contributesToAggregation$connect_client_release(Record record, TimeRange<?> timeRange) {
        record.getClass();
        timeRange.getClass();
        if (record instanceof BloodPressureRecord) {
            BloodPressureRecord bloodPressureRecord = (BloodPressureRecord) record;
            return TimeExtensionsKt.isWithin(bloodPressureRecord.getTime(), timeRange, bloodPressureRecord.getZoneOffset());
        }
        if (record instanceof NutritionRecord) {
            return ((NutritionRecord) record).getTransFat() != null && sliceFactor$connect_client_release((IntervalRecord) record, timeRange) > 0.0d;
        }
        if (!(record instanceof SeriesRecord)) {
            FacebookSdk$$ExternalSyntheticLambda1.m$2("Unsupported record type for aggregation fallback: ", RecordsTypeNameMapKt.getRECORDS_CLASS_NAME_MAP().get(Reflection.getOrCreateKotlinClass(record.getClass())));
            return false;
        }
        SeriesRecord seriesRecord = (SeriesRecord) record;
        List samples = seriesRecord.getSamples();
        if ((samples instanceof Collection) && samples.isEmpty()) {
            return false;
        }
        Iterator it = samples.iterator();
        while (it.hasNext()) {
            if (TimeExtensionsKt.isWithin(INSTANCE.getTime$connect_client_release(it.next()), timeRange, seriesRecord.getStartZoneOffset())) {
                return true;
            }
        }
        return false;
    }

    public final Instant getTime$connect_client_release(Object obj) {
        obj.getClass();
        if (obj instanceof CyclingPedalingCadenceRecord.Sample) {
            return ((CyclingPedalingCadenceRecord.Sample) obj).getTime();
        }
        if (obj instanceof SpeedRecord.Sample) {
            return ((SpeedRecord.Sample) obj).getTime();
        }
        if (obj instanceof StepsCadenceRecord.Sample) {
            return ((StepsCadenceRecord.Sample) obj).getTime();
        }
        Utf8$$ExternalSyntheticBUOutline0.m("Unsupported type for time: ", obj);
        return null;
    }

    public final double getValue$connect_client_release(Object obj) {
        obj.getClass();
        if (obj instanceof CyclingPedalingCadenceRecord.Sample) {
            return ((CyclingPedalingCadenceRecord.Sample) obj).getRevolutionsPerMinute();
        }
        if (obj instanceof SpeedRecord.Sample) {
            return ((SpeedRecord.Sample) obj).getSpeed().getMetersPerSecond();
        }
        if (obj instanceof StepsCadenceRecord.Sample) {
            return ((StepsCadenceRecord.Sample) obj).getRate();
        }
        Utf8$$ExternalSyntheticBUOutline0.m("Unsupported type for value: ", obj);
        return 0.0d;
    }

    public final double sliceFactor$connect_client_release(IntervalRecord record, TimeRange<?> timeRange) {
        Instant instantWithDefaultZoneFallback;
        Instant instantWithDefaultZoneFallback2;
        record.getClass();
        timeRange.getClass();
        boolean z = timeRange instanceof InstantTimeRange;
        if (z) {
            instantWithDefaultZoneFallback = ((InstantTimeRange) timeRange).getStartTime();
        } else {
            if (!(timeRange instanceof LocalTimeRange)) {
                Home$$ExternalSyntheticBUOutline0.m();
                return 0.0d;
            }
            instantWithDefaultZoneFallback = TimeExtensionsKt.toInstantWithDefaultZoneFallback(((LocalTimeRange) timeRange).getStartTime(), record.getStartZoneOffset());
        }
        if (z) {
            instantWithDefaultZoneFallback2 = ((InstantTimeRange) timeRange).getEndTime();
        } else {
            if (!(timeRange instanceof LocalTimeRange)) {
                Home$$ExternalSyntheticBUOutline0.m();
                return 0.0d;
            }
            instantWithDefaultZoneFallback2 = TimeExtensionsKt.toInstantWithDefaultZoneFallback(((LocalTimeRange) timeRange).getEndTime(), record.getEndZoneOffset());
        }
        return Math.max(0.0d, TimeExtensionsKt.div(TimeExtensionsKt.minus((Instant) ComparisonsKt___ComparisonsJvmKt.minOf(record.getEndTime(), instantWithDefaultZoneFallback2), (Instant) ComparisonsKt___ComparisonsJvmKt.maxOf(record.getStartTime(), instantWithDefaultZoneFallback)), TimeExtensionsKt.getDuration(record)));
    }
}
