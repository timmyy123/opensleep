package androidx.health.connect.client.impl.platform.response;

import android.health.connect.AggregateRecordsGroupedByDurationResponse;
import android.health.connect.datatypes.AggregationType;
import android.health.connect.datatypes.DataOrigin;
import android.health.connect.datatypes.units.Length;
import android.health.connect.datatypes.units.Power;
import android.health.connect.datatypes.units.Pressure;
import android.health.connect.datatypes.units.TemperatureDelta;
import android.health.connect.datatypes.units.Velocity;
import android.health.connect.datatypes.units.Volume;
import android.os.ext.SdkExtensions;
import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.impl.platform.aggregate.AggregationMappingsKt;
import androidx.health.connect.client.impl.platform.records.MetadataConvertersKt;
import androidx.health.connect.client.impl.platform.records.RecordMappingsKt$$ExternalSyntheticApiModelOutline2;
import androidx.health.connect.client.impl.platform.request.RequestConvertersKt;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.Mass;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import j$.time.Instant;
import j$.time.TimeConversions;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a+\u0010\u0006\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001ac\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\u00022\u001a\u0010\n\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\"\u0010\r\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\u00020\bH\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a5\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00112\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0011H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a5\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00170\u00112\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0011H\u0001¢\u0006\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroid/health/connect/AggregateRecordsGroupedByDurationResponse;", "", "", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "metrics", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "toSdkResponse", "(Landroid/health/connect/AggregateRecordsGroupedByDurationResponse;Ljava/util/Set;)Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "Lkotlin/Function1;", "Landroid/health/connect/datatypes/AggregationType;", "aggregationValueGetter", "Landroid/health/connect/datatypes/DataOrigin;", "Landroidx/health/connect/client/impl/platform/records/PlatformDataOrigin;", "platformDataOriginsGetter", "Landroidx/health/connect/client/aggregate/AggregationResult;", "buildAggregationResult", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/health/connect/client/aggregate/AggregationResult;", "", "metricValueMap", "", "", "getLongMetricValues", "(Ljava/util/Map;)Ljava/util/Map;", "", "getDoubleMetricValues", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ResponseConvertersKt {
    public static final AggregationResult buildAggregationResult(Set<? extends AggregateMetric<? extends Object>> set, Function1<? super AggregationType<Object>, ? extends Object> function1, Function1<? super AggregationType<Object>, ? extends Set<DataOrigin>> function12) {
        set.getClass();
        function1.getClass();
        function12.getClass();
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            AggregateMetric aggregateMetric = (AggregateMetric) it.next();
            Object objInvoke = function1.invoke(RequestConvertersKt.toAggregationType(aggregateMetric));
            if (objInvoke != null) {
                mapCreateMapBuilder.put(aggregateMetric, objInvoke);
            }
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        Map<String, Long> longMetricValues = getLongMetricValues(mapBuild);
        Map<String, Double> doubleMetricValues = getDoubleMetricValues(mapBuild);
        HashSet hashSet = new HashSet();
        Iterator<T> it2 = set.iterator();
        while (it2.hasNext()) {
            Set<DataOrigin> setInvoke = function12.invoke(RequestConvertersKt.toAggregationType((AggregateMetric) it2.next()));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setInvoke, 10));
            Iterator<T> it3 = setInvoke.iterator();
            while (it3.hasNext()) {
                arrayList.add(MetadataConvertersKt.toSdkDataOrigin((DataOrigin) it3.next()));
            }
            CollectionsKt__MutableCollectionsKt.addAll(hashSet, arrayList);
        }
        return new AggregationResult(longMetricValues, doubleMetricValues, hashSet);
    }

    public static final Map<String, Double> getDoubleMetricValues(Map<AggregateMetric<Object>, ? extends Object> map) {
        map.getClass();
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (Map.Entry<AggregateMetric<Object>, ? extends Object> entry : map.entrySet()) {
            AggregateMetric<Object> key = entry.getKey();
            Object value = entry.getValue();
            if (AggregationMappingsKt.getDOUBLE_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey = key.getMetricKey();
                value.getClass();
                mapCreateMapBuilder.put(metricKey, (Double) value);
            } else if (AggregationMappingsKt.getENERGY_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey2 = key.getMetricKey();
                Energy.Companion companion = Energy.INSTANCE;
                value.getClass();
                mapCreateMapBuilder.put(metricKey2, Double.valueOf(companion.calories(((android.health.connect.datatypes.units.Energy) value).getInCalories()).getKilocalories()));
            } else if (AggregationMappingsKt.getGRAMS_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey3 = key.getMetricKey();
                value.getClass();
                mapCreateMapBuilder.put(metricKey3, Double.valueOf(FacebookSdk$$ExternalSyntheticLambda1.m264m(value).getInGrams()));
            } else if (AggregationMappingsKt.getLENGTH_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey4 = key.getMetricKey();
                value.getClass();
                mapCreateMapBuilder.put(metricKey4, Double.valueOf(((Length) value).getInMeters()));
            } else if (AggregationMappingsKt.getKILOGRAMS_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey5 = key.getMetricKey();
                Mass.Companion companion2 = Mass.INSTANCE;
                value.getClass();
                mapCreateMapBuilder.put(metricKey5, Double.valueOf(companion2.grams(FacebookSdk$$ExternalSyntheticLambda1.m264m(value).getInGrams()).getKilograms()));
            } else if (AggregationMappingsKt.getPRESSURE_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey6 = key.getMetricKey();
                value.getClass();
                mapCreateMapBuilder.put(metricKey6, Double.valueOf(((Pressure) value).getInMillimetersOfMercury()));
            } else if (AggregationMappingsKt.getPOWER_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey7 = key.getMetricKey();
                value.getClass();
                mapCreateMapBuilder.put(metricKey7, Double.valueOf(((Power) value).getInWatts()));
            } else if (AggregationMappingsKt.getTEMPERATURE_DELTA_METRIC_TYPE_MAP().containsKey(key)) {
                if (SdkExtensions.getExtensionVersion(34) < 13) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Failed requirement.");
                    return null;
                }
                String metricKey8 = key.getMetricKey();
                value.getClass();
                mapCreateMapBuilder.put(metricKey8, Double.valueOf(((TemperatureDelta) value).getInCelsius()));
            } else if (AggregationMappingsKt.getVELOCITY_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey9 = key.getMetricKey();
                value.getClass();
                mapCreateMapBuilder.put(metricKey9, Double.valueOf(((Velocity) value).getInMetersPerSecond()));
            } else if (AggregationMappingsKt.getVOLUME_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey10 = key.getMetricKey();
                value.getClass();
                mapCreateMapBuilder.put(metricKey10, Double.valueOf(((Volume) value).getInLiters()));
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public static final Map<String, Long> getLongMetricValues(Map<AggregateMetric<Object>, ? extends Object> map) {
        map.getClass();
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (Map.Entry<AggregateMetric<Object>, ? extends Object> entry : map.entrySet()) {
            AggregateMetric<Object> key = entry.getKey();
            Object value = entry.getValue();
            if (AggregationMappingsKt.getDURATION_AGGREGATION_METRIC_TYPE_MAP().containsKey(key) || AggregationMappingsKt.getLONG_AGGREGATION_METRIC_TYPE_MAP().containsKey(key)) {
                String metricKey = key.getMetricKey();
                value.getClass();
                mapCreateMapBuilder.put(metricKey, (Long) value);
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public static final AggregationResultGroupedByDuration toSdkResponse(AggregateRecordsGroupedByDurationResponse<Object> aggregateRecordsGroupedByDurationResponse, Set<? extends AggregateMetric<? extends Object>> set) {
        ZoneOffset offset;
        aggregateRecordsGroupedByDurationResponse.getClass();
        set.getClass();
        AggregationResult aggregationResultBuildAggregationResult = buildAggregationResult(set, new AnonymousClass3(aggregateRecordsGroupedByDurationResponse), SdkExtensions.getExtensionVersion(34) >= 10 ? new ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$1(aggregateRecordsGroupedByDurationResponse) : new Function1<AggregationType<Object>, Set<? extends DataOrigin>>() { // from class: androidx.health.connect.client.impl.platform.response.ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Set<? extends DataOrigin> invoke(AggregationType<Object> aggregationType) {
                return invoke2(RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) aggregationType));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Set<DataOrigin> invoke2(AggregationType<Object> aggregationType) {
                aggregationType.getClass();
                return SetsKt.emptySet();
            }
        });
        Instant instantConvert = TimeConversions.convert(aggregateRecordsGroupedByDurationResponse.getStartTime());
        instantConvert.getClass();
        Instant instantConvert2 = TimeConversions.convert(aggregateRecordsGroupedByDurationResponse.getEndTime());
        instantConvert2.getClass();
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                offset = null;
                break;
            }
            offset = TimeConversions.convert(aggregateRecordsGroupedByDurationResponse.getZoneOffset(RequestConvertersKt.toAggregationType((AggregateMetric) it.next())));
            if (offset != null) {
                break;
            }
        }
        if (offset == null) {
            offset = ZoneId.systemDefault().getRules().getOffset(TimeConversions.convert(aggregateRecordsGroupedByDurationResponse.getStartTime()));
        }
        ZoneOffset zoneOffset = offset;
        zoneOffset.getClass();
        return new AggregationResultGroupedByDuration(aggregationResultBuildAggregationResult, instantConvert, instantConvert2, zoneOffset, true);
    }

    /* JADX INFO: renamed from: androidx.health.connect.client.impl.platform.response.ResponseConvertersKt$toSdkResponse$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<AggregationType<Object>, Object> {
        public AnonymousClass3(Object obj) {
            super(1, obj, FacebookSdk$$ExternalSyntheticLambda1.m(), "get", "get(Landroid/health/connect/datatypes/AggregationType;)Ljava/lang/Object;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(AggregationType<Object> aggregationType) {
            aggregationType.getClass();
            return Fragment$$ExternalSyntheticBUOutline0.m(this.receiver).get(aggregationType);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(AggregationType<Object> aggregationType) {
            return invoke2(RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) aggregationType));
        }
    }
}
