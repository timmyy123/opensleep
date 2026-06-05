package androidx.health.connect.client.impl.converters.aggregate;

import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.platform.client.proto.RequestProto;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002¨\u0006\u0003"}, d2 = {"toProto", "Landroidx/health/platform/client/proto/RequestProto$AggregateMetricSpec;", "Landroidx/health/connect/client/aggregate/AggregateMetric;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class AggregateMetricToProtoKt {
    public static final RequestProto.AggregateMetricSpec toProto(AggregateMetric<?> aggregateMetric) {
        aggregateMetric.getClass();
        RequestProto.AggregateMetricSpec.Builder aggregationType = RequestProto.AggregateMetricSpec.newBuilder().setDataTypeName(aggregateMetric.getDataTypeName()).setAggregationType(aggregateMetric.getAggregationType().getAggregationTypeString());
        String aggregationField = aggregateMetric.getAggregationField();
        if (aggregationField != null) {
            aggregationType.setFieldName(aggregationField);
        }
        RequestProto.AggregateMetricSpec aggregateMetricSpecBuild = aggregationType.build();
        aggregateMetricSpecBuild.getClass();
        return aggregateMetricSpecBuild;
    }
}
