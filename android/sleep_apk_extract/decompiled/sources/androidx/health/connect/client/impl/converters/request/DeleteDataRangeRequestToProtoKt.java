package androidx.health.connect.client.impl.converters.request;

import androidx.health.connect.client.impl.converters.datatype.DataTypeConverterKt;
import androidx.health.connect.client.impl.converters.time.TimeRangeFilterConverterKt;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.time.TimeRangeFilter;
import androidx.health.platform.client.proto.RequestProto;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"toDeleteDataRangeRequestProto", "Landroidx/health/platform/client/proto/RequestProto$DeleteDataRangeRequest;", "dataTypeKC", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class DeleteDataRangeRequestToProtoKt {
    public static final RequestProto.DeleteDataRangeRequest toDeleteDataRangeRequestProto(KClass<? extends Record> kClass, TimeRangeFilter timeRangeFilter) {
        kClass.getClass();
        timeRangeFilter.getClass();
        RequestProto.DeleteDataRangeRequest deleteDataRangeRequestBuild = RequestProto.DeleteDataRangeRequest.newBuilder().addDataType(DataTypeConverterKt.toDataType(kClass)).setTimeSpec(TimeRangeFilterConverterKt.toProto(timeRangeFilter)).build();
        deleteDataRangeRequestBuild.getClass();
        return deleteDataRangeRequestBuild;
    }
}
