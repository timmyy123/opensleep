package androidx.health.connect.client.impl.converters.aggregate;

import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.platform.client.proto.DataProto;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/health/platform/client/proto/DataProto$AggregateDataRow;", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "toAggregateDataRowGroupByDuration", "(Landroidx/health/platform/client/proto/DataProto$AggregateDataRow;)Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "Landroidx/health/connect/client/aggregate/AggregationResult;", "retrieveAggregateDataRow", "(Landroidx/health/platform/client/proto/DataProto$AggregateDataRow;)Landroidx/health/connect/client/aggregate/AggregationResult;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ProtoToAggregateDataRowKt {
    public static final AggregationResult retrieveAggregateDataRow(DataProto.AggregateDataRow aggregateDataRow) {
        aggregateDataRow.getClass();
        Map<String, Long> longValuesMap = aggregateDataRow.getLongValuesMap();
        longValuesMap.getClass();
        Map<String, Double> doubleValuesMap = aggregateDataRow.getDoubleValuesMap();
        doubleValuesMap.getClass();
        List<DataProto.DataOrigin> dataOriginsList = aggregateDataRow.getDataOriginsList();
        dataOriginsList.getClass();
        HashSet hashSet = new HashSet();
        Iterator<T> it = dataOriginsList.iterator();
        while (it.hasNext()) {
            String applicationId = ((DataProto.DataOrigin) it.next()).getApplicationId();
            applicationId.getClass();
            hashSet.add(new DataOrigin(applicationId));
        }
        return new AggregationResult(longValuesMap, doubleValuesMap, hashSet);
    }

    public static final AggregationResultGroupedByDuration toAggregateDataRowGroupByDuration(DataProto.AggregateDataRow aggregateDataRow) {
        aggregateDataRow.getClass();
        if (!aggregateDataRow.hasStartTimeEpochMs()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("start time must be set");
            return null;
        }
        if (!aggregateDataRow.hasEndTimeEpochMs()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("end time must be set");
            return null;
        }
        AggregationResult aggregationResultRetrieveAggregateDataRow = retrieveAggregateDataRow(aggregateDataRow);
        Instant instantOfEpochMilli = Instant.ofEpochMilli(aggregateDataRow.getStartTimeEpochMs());
        instantOfEpochMilli.getClass();
        Instant instantOfEpochMilli2 = Instant.ofEpochMilli(aggregateDataRow.getEndTimeEpochMs());
        instantOfEpochMilli2.getClass();
        ZoneOffset zoneOffsetOfTotalSeconds = ZoneOffset.ofTotalSeconds(aggregateDataRow.getZoneOffsetSeconds());
        zoneOffsetOfTotalSeconds.getClass();
        return new AggregationResultGroupedByDuration(aggregationResultRetrieveAggregateDataRow, instantOfEpochMilli, instantOfEpochMilli2, zoneOffsetOfTotalSeconds, false, 16, null);
    }
}
