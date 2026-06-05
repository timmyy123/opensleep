package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Length;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/health/connect/client/records/ExerciseLap;", "", "j$/time/Instant", "startTime", SDKConstants.PARAM_END_TIME, "Landroidx/health/connect/client/units/Length;", "length", "<init>", "(Lj$/time/Instant;Lj$/time/Instant;Landroidx/health/connect/client/units/Length;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "getEndTime", "Landroidx/health/connect/client/units/Length;", "getLength", "()Landroidx/health/connect/client/units/Length;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExerciseLap {
    private final Instant endTime;
    private final Length length;
    private final Instant startTime;

    public ExerciseLap(Instant instant, Instant instant2, Length length) {
        instant.getClass();
        instant2.getClass();
        this.startTime = instant;
        this.endTime = instant2;
        this.length = length;
        if (!instant.isBefore(instant2)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("startTime must be before endTime.");
            throw null;
        }
        if (length != null) {
            double meters = length.getMeters();
            if (0.0d > meters || meters > 1000000.0d) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("length valid range: 0-1000000.");
                throw null;
            }
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExerciseLap)) {
            return false;
        }
        ExerciseLap exerciseLap = (ExerciseLap) other;
        return Intrinsics.areEqual(this.startTime, exerciseLap.startTime) && Intrinsics.areEqual(this.endTime, exerciseLap.endTime) && Intrinsics.areEqual(this.length, exerciseLap.length);
    }

    public final Instant getEndTime() {
        return this.endTime;
    }

    public final Length getLength() {
        return this.length;
    }

    public final Instant getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        int iHashCode = (this.endTime.hashCode() + (this.startTime.hashCode() * 31)) * 31;
        Length length = this.length;
        return iHashCode + (length != null ? length.hashCode() : 0);
    }

    public String toString() {
        return "ExerciseLap(startTime=" + this.startTime + ", endTime=" + this.endTime + ", length=" + this.length + ')';
    }
}
