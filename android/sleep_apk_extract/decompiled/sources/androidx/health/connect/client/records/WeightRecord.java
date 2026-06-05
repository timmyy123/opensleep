package androidx.health.connect.client.records;

import android.os.Build;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.units.Mass;
import androidx.health.connect.client.units.MassKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 #2\u00020\u0001:\u0001#B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Landroidx/health/connect/client/records/WeightRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "j$/time/Instant", "time", "j$/time/ZoneOffset", "zoneOffset", "Landroidx/health/connect/client/units/Mass;", "weight", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/records/metadata/Metadata;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getZoneOffset", "()Lj$/time/ZoneOffset;", "Landroidx/health/connect/client/units/Mass;", "getWeight", "()Landroidx/health/connect/client/units/Mass;", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WeightRecord implements InstantaneousRecord {
    private static final Mass MAX_WEIGHT = MassKt.getKilograms(4.94E-321d);
    public static final AggregateMetric<Mass> WEIGHT_AVG;
    public static final AggregateMetric<Mass> WEIGHT_MAX;
    public static final AggregateMetric<Mass> WEIGHT_MIN;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final Mass weight;
    private final ZoneOffset zoneOffset;

    static {
        AggregateMetric.Companion companion = AggregateMetric.INSTANCE;
        AggregateMetric.AggregationType aggregationType = AggregateMetric.AggregationType.AVERAGE;
        Mass.Companion companion2 = Mass.INSTANCE;
        WEIGHT_AVG = companion.doubleMetric$connect_client_release("Weight", aggregationType, "weight", new WeightRecord$Companion$WEIGHT_AVG$1(companion2));
        WEIGHT_MIN = companion.doubleMetric$connect_client_release("Weight", AggregateMetric.AggregationType.MINIMUM, "weight", new WeightRecord$Companion$WEIGHT_MIN$1(companion2));
        WEIGHT_MAX = companion.doubleMetric$connect_client_release("Weight", AggregateMetric.AggregationType.MAXIMUM, "weight", new WeightRecord$Companion$WEIGHT_MAX$1(companion2));
    }

    public WeightRecord(Instant instant, ZoneOffset zoneOffset, Mass mass, androidx.health.connect.client.records.metadata.Metadata metadata) {
        instant.getClass();
        mass.getClass();
        metadata.getClass();
        this.time = instant;
        this.zoneOffset = zoneOffset;
        this.weight = mass;
        this.metadata = metadata;
        if (Build.VERSION.SDK_INT >= 34) {
            RecordConvertersKt.toPlatformRecord(this);
        } else {
            UtilsKt.requireNotLess(mass, mass.zero$connect_client_release(), "weight");
            UtilsKt.requireNotMore(mass, MAX_WEIGHT, "weight");
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WeightRecord)) {
            return false;
        }
        WeightRecord weightRecord = (WeightRecord) other;
        return Intrinsics.areEqual(this.weight, weightRecord.weight) && Intrinsics.areEqual(getTime(), weightRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), weightRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), weightRecord.getMetadata());
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    public final Mass getWeight() {
        return this.weight;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public int hashCode() {
        int iHashCode = (getTime().hashCode() + (this.weight.hashCode() * 31)) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return getMetadata().hashCode() + ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "WeightRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", weight=" + this.weight + ", metadata=" + getMetadata() + ')';
    }
}
