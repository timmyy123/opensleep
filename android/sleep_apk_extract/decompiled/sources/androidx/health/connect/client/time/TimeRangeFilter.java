package androidx.health.connect.client.time;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.Instant;
import j$.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB9\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028G¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028G¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058G¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058G¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001d"}, d2 = {"Landroidx/health/connect/client/time/TimeRangeFilter;", "", "j$/time/Instant", "startTime", SDKConstants.PARAM_END_TIME, "j$/time/LocalDateTime", "localStartTime", "localEndTime", "<init>", "(Lj$/time/Instant;Lj$/time/Instant;Lj$/time/LocalDateTime;Lj$/time/LocalDateTime;)V", "", "isBasedOnLocalTime$connect_client_release", "()Z", "isBasedOnLocalTime", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "getEndTime", "Lj$/time/LocalDateTime;", "getLocalStartTime", "()Lj$/time/LocalDateTime;", "getLocalEndTime", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TimeRangeFilter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Instant endTime;
    private final LocalDateTime localEndTime;
    private final LocalDateTime localStartTime;
    private final Instant startTime;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/time/TimeRangeFilter$Companion;", "", "<init>", "()V", "j$/time/Instant", "startTime", SDKConstants.PARAM_END_TIME, "Landroidx/health/connect/client/time/TimeRangeFilter;", "between", "(Lj$/time/Instant;Lj$/time/Instant;)Landroidx/health/connect/client/time/TimeRangeFilter;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TimeRangeFilter between(Instant startTime, Instant endTime) {
            startTime.getClass();
            endTime.getClass();
            if (!startTime.isBefore(endTime)) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("end time needs be after start time");
                return null;
            }
            return new TimeRangeFilter(startTime, endTime, null, null, 12, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ TimeRangeFilter(Instant instant, Instant instant2, LocalDateTime localDateTime, LocalDateTime localDateTime2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : instant, (i & 2) != 0 ? null : instant2, (i & 4) != 0 ? null : localDateTime, (i & 8) != 0 ? null : localDateTime2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimeRangeFilter)) {
            return false;
        }
        TimeRangeFilter timeRangeFilter = (TimeRangeFilter) other;
        return Intrinsics.areEqual(this.startTime, timeRangeFilter.startTime) && Intrinsics.areEqual(this.endTime, timeRangeFilter.endTime) && Intrinsics.areEqual(this.localStartTime, timeRangeFilter.localStartTime) && Intrinsics.areEqual(this.localEndTime, timeRangeFilter.localEndTime);
    }

    public final Instant getEndTime() {
        return this.endTime;
    }

    public final LocalDateTime getLocalEndTime() {
        return this.localEndTime;
    }

    public final LocalDateTime getLocalStartTime() {
        return this.localStartTime;
    }

    public final Instant getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        Instant instant = this.startTime;
        int iHashCode = (instant != null ? instant.hashCode() : 0) * 31;
        Instant instant2 = this.endTime;
        int iHashCode2 = (iHashCode + (instant2 != null ? instant2.hashCode() : 0)) * 31;
        LocalDateTime localDateTime = this.localStartTime;
        int iHashCode3 = (iHashCode2 + (localDateTime != null ? localDateTime.hashCode() : 0)) * 31;
        LocalDateTime localDateTime2 = this.localEndTime;
        return iHashCode3 + (localDateTime2 != null ? localDateTime2.hashCode() : 0);
    }

    public final boolean isBasedOnLocalTime$connect_client_release() {
        return (this.localStartTime == null && this.localEndTime == null) ? false : true;
    }

    public TimeRangeFilter(Instant instant, Instant instant2, LocalDateTime localDateTime, LocalDateTime localDateTime2) {
        this.startTime = instant;
        this.endTime = instant2;
        this.localStartTime = localDateTime;
        this.localEndTime = localDateTime2;
    }
}
