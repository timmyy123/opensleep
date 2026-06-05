package androidx.health.connect.client.impl.platform.aggregate;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/LocalTimeRange;", "Landroidx/health/connect/client/impl/platform/aggregate/TimeRange;", "j$/time/LocalDateTime", "startTime", SDKConstants.PARAM_END_TIME, "<init>", "(Lj$/time/LocalDateTime;Lj$/time/LocalDateTime;)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lj$/time/LocalDateTime;", "getStartTime", "()Lj$/time/LocalDateTime;", "getEndTime", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class LocalTimeRange implements TimeRange<LocalDateTime> {
    private final LocalDateTime endTime;
    private final LocalDateTime startTime;

    public LocalTimeRange(LocalDateTime localDateTime, LocalDateTime localDateTime2) {
        localDateTime.getClass();
        localDateTime2.getClass();
        this.startTime = localDateTime;
        this.endTime = localDateTime2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LocalTimeRange)) {
            return false;
        }
        LocalTimeRange localTimeRange = (LocalTimeRange) other;
        return Intrinsics.areEqual(this.startTime, localTimeRange.startTime) && Intrinsics.areEqual(this.endTime, localTimeRange.endTime);
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        return this.endTime.hashCode() + (this.startTime.hashCode() * 31);
    }

    public String toString() {
        return "LocalTimeRange(startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }
}
