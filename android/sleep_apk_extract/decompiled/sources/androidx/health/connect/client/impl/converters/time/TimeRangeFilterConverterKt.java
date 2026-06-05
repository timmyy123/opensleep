package androidx.health.connect.client.impl.converters.time;

import androidx.health.connect.client.time.TimeRangeFilter;
import androidx.health.platform.client.proto.TimeProto;
import j$.time.Instant;
import j$.time.LocalDateTime;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toProto", "Landroidx/health/platform/client/proto/TimeProto$TimeSpec;", "Landroidx/health/connect/client/time/TimeRangeFilter;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class TimeRangeFilterConverterKt {
    public static final TimeProto.TimeSpec toProto(TimeRangeFilter timeRangeFilter) {
        timeRangeFilter.getClass();
        TimeProto.TimeSpec.Builder builderNewBuilder = TimeProto.TimeSpec.newBuilder();
        Instant startTime = timeRangeFilter.getStartTime();
        if (startTime != null) {
            builderNewBuilder.setStartTimeEpochMs(startTime.toEpochMilli());
        }
        Instant endTime = timeRangeFilter.getEndTime();
        if (endTime != null) {
            builderNewBuilder.setEndTimeEpochMs(endTime.toEpochMilli());
        }
        LocalDateTime localStartTime = timeRangeFilter.getLocalStartTime();
        if (localStartTime != null) {
            builderNewBuilder.setStartLocalDateTime(localStartTime.toString());
        }
        LocalDateTime localEndTime = timeRangeFilter.getLocalEndTime();
        if (localEndTime != null) {
            builderNewBuilder.setEndLocalDateTime(localEndTime.toString());
        }
        TimeProto.TimeSpec timeSpecBuild = builderNewBuilder.build();
        timeSpecBuild.getClass();
        return timeSpecBuild;
    }
}
