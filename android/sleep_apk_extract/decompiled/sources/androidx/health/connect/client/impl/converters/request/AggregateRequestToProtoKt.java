package androidx.health.connect.client.impl.converters.request;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.impl.converters.aggregate.AggregateMetricToProtoKt;
import androidx.health.connect.client.impl.converters.time.TimeRangeFilterConverterKt;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.request.AggregateGroupByDurationRequest;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.RequestProto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006*\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;", "Landroidx/health/platform/client/proto/RequestProto$AggregateDataRequest;", "toProto", "(Landroidx/health/connect/client/request/AggregateGroupByDurationRequest;)Landroidx/health/platform/client/proto/RequestProto$AggregateDataRequest;", "", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "", "Landroidx/health/platform/client/proto/DataProto$DataOrigin;", "kotlin.jvm.PlatformType", "toProtoList", "(Ljava/util/Set;)Ljava/util/List;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class AggregateRequestToProtoKt {
    public static final RequestProto.AggregateDataRequest toProto(AggregateGroupByDurationRequest aggregateGroupByDurationRequest) {
        aggregateGroupByDurationRequest.getClass();
        RequestProto.AggregateDataRequest.Builder builderAddAllDataOrigin = RequestProto.AggregateDataRequest.newBuilder().setTimeSpec(TimeRangeFilterConverterKt.toProto(aggregateGroupByDurationRequest.getTimeRangeFilter())).addAllDataOrigin(toProtoList(aggregateGroupByDurationRequest.getDataOriginFilter$connect_client_release()));
        Set<AggregateMetric<?>> metrics$connect_client_release = aggregateGroupByDurationRequest.getMetrics$connect_client_release();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(metrics$connect_client_release, 10));
        Iterator<T> it = metrics$connect_client_release.iterator();
        while (it.hasNext()) {
            arrayList.add(AggregateMetricToProtoKt.toProto((AggregateMetric) it.next()));
        }
        RequestProto.AggregateDataRequest aggregateDataRequestBuild = builderAddAllDataOrigin.addAllMetricSpec(arrayList).setSliceDurationMillis(aggregateGroupByDurationRequest.getTimeRangeSlicer().toMillis()).build();
        aggregateDataRequestBuild.getClass();
        return aggregateDataRequestBuild;
    }

    private static final List<DataProto.DataOrigin> toProtoList(Set<DataOrigin> set) {
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(DataProto.DataOrigin.newBuilder().setApplicationId(((DataOrigin) it.next()).getPackageName()).build());
        }
        return arrayList;
    }
}
