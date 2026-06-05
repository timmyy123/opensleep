package androidx.health.connect.client.impl.platform.request;

import android.health.connect.AggregateRecordsRequest;
import android.health.connect.LocalTimeRangeFilter;
import android.health.connect.ReadRecordsRequestUsingFilters;
import android.health.connect.TimeInstantRangeFilter;
import android.health.connect.datatypes.AggregationType;
import android.health.connect.datatypes.Record;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.impl.platform.aggregate.AggregationExtensionsKt;
import androidx.health.connect.client.impl.platform.aggregate.AggregationMappingsKt;
import androidx.health.connect.client.impl.platform.records.MetadataConvertersKt;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.impl.platform.records.RecordMappingsKt$$ExternalSyntheticApiModelOutline2;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.connect.client.time.TimeRangeFilter;
import j$.time.TimeConversions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\u0006¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\r¢\u0006\u0004\b\u0004\u0010\u0010\u001a\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012*\b\u0012\u0004\u0012\u00020\u000f0\u0011¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/health/connect/client/request/ReadRecordsRequest;", "Landroidx/health/connect/client/records/Record;", "Landroid/health/connect/ReadRecordsRequestUsingFilters;", "Landroid/health/connect/datatypes/Record;", "toPlatformRequest", "(Landroidx/health/connect/client/request/ReadRecordsRequest;)Landroid/health/connect/ReadRecordsRequestUsingFilters;", "Landroidx/health/connect/client/time/TimeRangeFilter;", "Landroid/health/connect/TimeRangeFilter;", "toPlatformTimeRangeFilter", "(Landroidx/health/connect/client/time/TimeRangeFilter;)Landroid/health/connect/TimeRangeFilter;", "Landroid/health/connect/LocalTimeRangeFilter;", "toPlatformLocalTimeRangeFilter", "(Landroidx/health/connect/client/time/TimeRangeFilter;)Landroid/health/connect/LocalTimeRangeFilter;", "Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "Landroid/health/connect/AggregateRecordsRequest;", "", "(Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;)Landroid/health/connect/AggregateRecordsRequest;", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "Landroid/health/connect/datatypes/AggregationType;", "toAggregationType", "(Landroidx/health/connect/client/aggregate/AggregateMetric;)Landroid/health/connect/datatypes/AggregationType;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class RequestConvertersKt {
    public static final AggregationType<Object> toAggregationType(AggregateMetric<? extends Object> aggregateMetric) {
        aggregateMetric.getClass();
        AggregationType<Object> aggregationTypeM152m = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getDOUBLE_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric));
        if (aggregationTypeM152m != null || (aggregationTypeM152m = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getDURATION_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric))) != null || (aggregationTypeM152m = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getENERGY_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric))) != null || (aggregationTypeM152m = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getGRAMS_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric))) != null || (aggregationTypeM152m = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getLENGTH_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric))) != null || (aggregationTypeM152m = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getLONG_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric))) != null || (aggregationTypeM152m = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getKILOGRAMS_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric))) != null || (aggregationTypeM152m = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getPOWER_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric))) != null || (aggregationTypeM152m = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getPRESSURE_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric))) != null || (aggregationTypeM152m = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getTEMPERATURE_DELTA_METRIC_TYPE_MAP().get(aggregateMetric))) != null || (aggregationTypeM152m = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getVELOCITY_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric))) != null) {
            return aggregationTypeM152m;
        }
        AggregationType<Object> aggregationTypeM152m2 = RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) AggregationMappingsKt.getVOLUME_AGGREGATION_METRIC_TYPE_MAP().get(aggregateMetric));
        if (aggregationTypeM152m2 != null) {
            return aggregationTypeM152m2;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Unsupported aggregation type ", aggregateMetric.getMetricKey());
        return null;
    }

    public static final LocalTimeRangeFilter toPlatformLocalTimeRangeFilter(TimeRangeFilter timeRangeFilter) {
        timeRangeFilter.getClass();
        LocalTimeRangeFilter localTimeRangeFilterBuild = new LocalTimeRangeFilter.Builder().setStartTime(TimeConversions.convert(timeRangeFilter.getLocalStartTime())).setEndTime(TimeConversions.convert(timeRangeFilter.getLocalEndTime())).build();
        localTimeRangeFilterBuild.getClass();
        return localTimeRangeFilterBuild;
    }

    public static final AggregateRecordsRequest<Object> toPlatformRequest(AggregateGroupByDurationRequest aggregateGroupByDurationRequest) {
        aggregateGroupByDurationRequest.getClass();
        AggregateRecordsRequest.Builder builder = new AggregateRecordsRequest.Builder(toPlatformTimeRangeFilter(aggregateGroupByDurationRequest.getTimeRangeFilter()));
        Iterator<T> it = aggregateGroupByDurationRequest.getDataOriginFilter$connect_client_release().iterator();
        while (it.hasNext()) {
            builder.addDataOriginsFilter(MetadataConvertersKt.toPlatformDataOrigin((DataOrigin) it.next()));
        }
        Set<AggregateMetric<?>> metrics$connect_client_release = aggregateGroupByDurationRequest.getMetrics$connect_client_release();
        ArrayList arrayList = new ArrayList();
        for (Object obj : metrics$connect_client_release) {
            if (AggregationExtensionsKt.isPlatformSupportedMetric((AggregateMetric) obj)) {
                arrayList.add(obj);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            builder.addAggregationType(toAggregationType((AggregateMetric) it2.next()));
        }
        AggregateRecordsRequest<Object> aggregateRecordsRequestBuild = builder.build();
        aggregateRecordsRequestBuild.getClass();
        return aggregateRecordsRequestBuild;
    }

    public static final android.health.connect.TimeRangeFilter toPlatformTimeRangeFilter(TimeRangeFilter timeRangeFilter) {
        Object objBuild;
        timeRangeFilter.getClass();
        if (timeRangeFilter.isBasedOnLocalTime$connect_client_release()) {
            objBuild = toPlatformLocalTimeRangeFilter(timeRangeFilter);
        } else {
            objBuild = new TimeInstantRangeFilter.Builder().setStartTime(TimeConversions.convert(timeRangeFilter.getStartTime())).setEndTime(TimeConversions.convert(timeRangeFilter.getEndTime())).build();
            objBuild.getClass();
        }
        return RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m(objBuild);
    }

    public static final ReadRecordsRequestUsingFilters<? extends Record> toPlatformRequest(ReadRecordsRequest<? extends androidx.health.connect.client.records.Record> readRecordsRequest) {
        readRecordsRequest.getClass();
        ReadRecordsRequestUsingFilters.Builder pageSize = new ReadRecordsRequestUsingFilters.Builder(RecordConvertersKt.toPlatformRecordClass(readRecordsRequest.getRecordType())).setTimeRangeFilter(toPlatformTimeRangeFilter(readRecordsRequest.getTimeRangeFilter())).setPageSize(readRecordsRequest.getPageSize());
        Iterator<T> it = readRecordsRequest.getDataOriginFilter().iterator();
        while (it.hasNext()) {
            pageSize.addDataOrigins(MetadataConvertersKt.toPlatformDataOrigin((DataOrigin) it.next()));
        }
        String pageToken = readRecordsRequest.getPageToken();
        if (pageToken != null) {
            pageSize.setPageToken(Long.parseLong(pageToken));
        }
        if (readRecordsRequest.getPageToken() == null) {
            pageSize.setAscending(readRecordsRequest.getAscendingOrder());
        }
        ReadRecordsRequestUsingFilters<? extends Record> readRecordsRequestUsingFiltersBuild = pageSize.build();
        readRecordsRequestUsingFiltersBuild.getClass();
        return readRecordsRequestUsingFiltersBuild;
    }
}
