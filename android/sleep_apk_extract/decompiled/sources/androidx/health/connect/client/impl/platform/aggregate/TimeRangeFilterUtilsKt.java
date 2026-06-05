package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.time.TimeRangeFilter;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\u000b\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/health/connect/client/time/TimeRangeFilter;", "timeRangeFilter", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "createTimeRange", "(Landroidx/health/connect/client/time/TimeRangeFilter;)Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "Landroidx/health/connect/client/impl/platform/aggregate/InstantTimeRange;", "createInstantTimeRange", "(Landroidx/health/connect/client/time/TimeRangeFilter;)Landroidx/health/connect/client/impl/platform/aggregate/InstantTimeRange;", "Landroidx/health/connect/client/impl/platform/aggregate/LocalTimeRange;", "createLocalTimeRange", "(Landroidx/health/connect/client/time/TimeRangeFilter;)Landroidx/health/connect/client/impl/platform/aggregate/LocalTimeRange;", "withBufferedStart", "(Landroidx/health/connect/client/time/TimeRangeFilter;)Landroidx/health/connect/client/time/TimeRangeFilter;", "j$/time/Duration", "RECORD_START_TIME_BUFFER", "Lj$/time/Duration;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class TimeRangeFilterUtilsKt {
    private static final Duration RECORD_START_TIME_BUFFER;

    static {
        Duration durationOfDays = Duration.ofDays(1L);
        durationOfDays.getClass();
        RECORD_START_TIME_BUFFER = durationOfDays;
    }

    public static final InstantTimeRange createInstantTimeRange(TimeRangeFilter timeRangeFilter) {
        timeRangeFilter.getClass();
        if (timeRangeFilter.isBasedOnLocalTime$connect_client_release()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("TimeRangeFilter should be based on instant time");
            return null;
        }
        Instant startTime = timeRangeFilter.getStartTime();
        if (startTime == null) {
            startTime = Instant.EPOCH;
        }
        Instant endTime = timeRangeFilter.getEndTime();
        if (endTime == null) {
            endTime = Instant.now();
        }
        startTime.getClass();
        endTime.getClass();
        return new InstantTimeRange(startTime, endTime);
    }

    public static final LocalTimeRange createLocalTimeRange(TimeRangeFilter timeRangeFilter) {
        timeRangeFilter.getClass();
        if (!timeRangeFilter.isBasedOnLocalTime$connect_client_release()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("TimeRangeFilter should be based on local time");
            return null;
        }
        LocalDateTime localStartTime = timeRangeFilter.getLocalStartTime();
        if (localStartTime == null) {
            localStartTime = LocalDateTime.ofInstant(Instant.EPOCH, ZoneOffset.MIN);
        }
        LocalDateTime localEndTime = timeRangeFilter.getLocalEndTime();
        if (localEndTime == null) {
            localEndTime = LocalDateTime.ofInstant(Instant.now().plus(Duration.ofDays(1L)), ZoneOffset.MAX);
        }
        localStartTime.getClass();
        localEndTime.getClass();
        return new LocalTimeRange(localStartTime, localEndTime);
    }

    public static final TimeRange<?> createTimeRange(TimeRangeFilter timeRangeFilter) {
        timeRangeFilter.getClass();
        return timeRangeFilter.isBasedOnLocalTime$connect_client_release() ? createLocalTimeRange(timeRangeFilter) : createInstantTimeRange(timeRangeFilter);
    }

    public static final TimeRangeFilter withBufferedStart(TimeRangeFilter timeRangeFilter) {
        timeRangeFilter.getClass();
        Instant startTime = timeRangeFilter.getStartTime();
        Instant instantMinus = startTime != null ? startTime.minus(RECORD_START_TIME_BUFFER) : null;
        Instant endTime = timeRangeFilter.getEndTime();
        LocalDateTime localStartTime = timeRangeFilter.getLocalStartTime();
        return new TimeRangeFilter(instantMinus, endTime, localStartTime != null ? localStartTime.minus(RECORD_START_TIME_BUFFER) : null, timeRangeFilter.getLocalEndTime());
    }
}
