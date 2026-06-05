package androidx.health.connect.client.impl.converters.request;

import androidx.health.connect.client.impl.converters.datatype.DataTypeConverterKt;
import androidx.health.connect.client.impl.converters.time.TimeRangeFilterConverterKt;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.request.ReadRecordsRequest;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.RequestProto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¨\u0006\u0006"}, d2 = {"toReadDataRangeRequestProto", "Landroidx/health/platform/client/proto/RequestProto$ReadDataRangeRequest;", "T", "Landroidx/health/connect/client/records/Record;", "request", "Landroidx/health/connect/client/request/ReadRecordsRequest;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ReadDataRangeRequestToProtoKt {
    public static final <T extends Record> RequestProto.ReadDataRangeRequest toReadDataRangeRequestProto(ReadRecordsRequest<T> readRecordsRequest) {
        readRecordsRequest.getClass();
        RequestProto.ReadDataRangeRequest.Builder dataType = RequestProto.ReadDataRangeRequest.newBuilder().setDataType(DataTypeConverterKt.toDataType(readRecordsRequest.getRecordType()));
        dataType.setTimeSpec(TimeRangeFilterConverterKt.toProto(readRecordsRequest.getTimeRangeFilter()));
        Set<DataOrigin> dataOriginFilter = readRecordsRequest.getDataOriginFilter();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(dataOriginFilter, 10));
        Iterator<T> it = dataOriginFilter.iterator();
        while (it.hasNext()) {
            arrayList.add(DataProto.DataOrigin.newBuilder().setApplicationId(((DataOrigin) it.next()).getPackageName()).build());
        }
        dataType.addAllDataOriginFilters(arrayList);
        dataType.setAscOrdering(readRecordsRequest.getAscendingOrder());
        dataType.setPageSize(readRecordsRequest.getPageSize());
        String pageToken = readRecordsRequest.getPageToken();
        if (pageToken != null) {
            dataType.setPageToken(pageToken);
        }
        GeneratedMessageLite generatedMessageLiteBuild = dataType.build();
        generatedMessageLiteBuild.getClass();
        return (RequestProto.ReadDataRangeRequest) generatedMessageLiteBuild;
    }
}
