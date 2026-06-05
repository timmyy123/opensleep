package androidx.health.connect.client.impl.platform;

import androidx.health.connect.client.impl.platform.aggregate.InstantTimeRange;
import androidx.health.connect.client.impl.platform.aggregate.LocalTimeRange;
import androidx.health.connect.client.impl.platform.aggregate.TimeRange;
import androidx.health.connect.client.records.IntervalRecord;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\b\u0004\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0080\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0007\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0080\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\f\u001a\u00020\u0005*\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001a+\u0010\u0011\u001a\u00020\u0010*\u00020\u00052\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0016\u001a\u00020\u0000*\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"j$/time/Duration", "divisor", "", "div", "(Lj$/time/Duration;Lj$/time/Duration;)D", "j$/time/Instant", "other", "minus", "(Lj$/time/Instant;Lj$/time/Instant;)Lj$/time/Duration;", "j$/time/LocalDateTime", "j$/time/ZoneOffset", "zoneOffset", "toInstantWithDefaultZoneFallback", "(Lj$/time/LocalDateTime;Lj$/time/ZoneOffset;)Lj$/time/Instant;", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "timeRange", "", "isWithin", "(Lj$/time/Instant;Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;Lj$/time/ZoneOffset;)Z", "Landroidx/health/connect/client/records/IntervalRecord;", "getDuration", "(Landroidx/health/connect/client/records/IntervalRecord;)Lj$/time/Duration;", "duration", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class TimeExtensionsKt {
    public static final double div(Duration duration, Duration duration2) {
        duration.getClass();
        duration2.getClass();
        return duration.toMillis() / duration2.toMillis();
    }

    public static final Duration getDuration(IntervalRecord intervalRecord) {
        intervalRecord.getClass();
        return minus(intervalRecord.getEndTime(), intervalRecord.getStartTime());
    }

    public static final boolean isWithin(Instant instant, TimeRange<?> timeRange, ZoneOffset zoneOffset) {
        instant.getClass();
        timeRange.getClass();
        if (timeRange instanceof InstantTimeRange) {
            InstantTimeRange instantTimeRange = (InstantTimeRange) timeRange;
            return !instant.isBefore(instantTimeRange.getStartTime()) && instant.isBefore(instantTimeRange.getEndTime());
        }
        if (timeRange instanceof LocalTimeRange) {
            LocalTimeRange localTimeRange = (LocalTimeRange) timeRange;
            return !instant.isBefore(toInstantWithDefaultZoneFallback(localTimeRange.getStartTime(), zoneOffset)) && instant.isBefore(toInstantWithDefaultZoneFallback(localTimeRange.getEndTime(), zoneOffset));
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return false;
    }

    public static final Duration minus(Instant instant, Instant instant2) {
        instant.getClass();
        instant2.getClass();
        Duration durationBetween = Duration.between(instant2, instant);
        durationBetween.getClass();
        return durationBetween;
    }

    public static final Instant toInstantWithDefaultZoneFallback(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        localDateTime.getClass();
        ZoneId zoneIdSystemDefault = zoneOffset;
        if (zoneOffset == null) {
            zoneIdSystemDefault = ZoneId.systemDefault();
        }
        Instant instant = localDateTime.w(zoneIdSystemDefault).toInstant();
        instant.getClass();
        return instant;
    }
}
