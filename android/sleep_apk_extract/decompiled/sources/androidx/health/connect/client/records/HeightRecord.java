package androidx.health.connect.client.records;

import android.os.Build;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.units.Length;
import androidx.health.connect.client.units.LengthKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 #2\u00020\u0001:\u0001#B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Landroidx/health/connect/client/records/HeightRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "j$/time/Instant", "time", "j$/time/ZoneOffset", "zoneOffset", "Landroidx/health/connect/client/units/Length;", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/units/Length;Landroidx/health/connect/client/records/metadata/Metadata;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getZoneOffset", "()Lj$/time/ZoneOffset;", "Landroidx/health/connect/client/units/Length;", "getHeight", "()Landroidx/health/connect/client/units/Length;", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HeightRecord implements InstantaneousRecord {
    public static final AggregateMetric<Length> HEIGHT_AVG;
    public static final AggregateMetric<Length> HEIGHT_MAX;
    public static final AggregateMetric<Length> HEIGHT_MIN;
    private final Length height;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final ZoneOffset zoneOffset;
    private static final Length MAX_HEIGHT = LengthKt.getMeters(1.5E-323d);

    static {
        AggregateMetric.Companion companion = AggregateMetric.INSTANCE;
        AggregateMetric.AggregationType aggregationType = AggregateMetric.AggregationType.AVERAGE;
        Length.Companion companion2 = Length.INSTANCE;
        HEIGHT_AVG = companion.doubleMetric$connect_client_release("Height", aggregationType, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, new HeightRecord$Companion$HEIGHT_AVG$1(companion2));
        HEIGHT_MIN = companion.doubleMetric$connect_client_release("Height", AggregateMetric.AggregationType.MINIMUM, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, new HeightRecord$Companion$HEIGHT_MIN$1(companion2));
        HEIGHT_MAX = companion.doubleMetric$connect_client_release("Height", AggregateMetric.AggregationType.MAXIMUM, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, new HeightRecord$Companion$HEIGHT_MAX$1(companion2));
    }

    public HeightRecord(Instant instant, ZoneOffset zoneOffset, Length length, androidx.health.connect.client.records.metadata.Metadata metadata) {
        instant.getClass();
        length.getClass();
        metadata.getClass();
        this.time = instant;
        this.zoneOffset = zoneOffset;
        this.height = length;
        this.metadata = metadata;
        if (Build.VERSION.SDK_INT >= 34) {
            RecordConvertersKt.toPlatformRecord(this);
        } else {
            UtilsKt.requireNotLess(length, length.zero$connect_client_release(), ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            UtilsKt.requireNotMore(length, MAX_HEIGHT, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeightRecord)) {
            return false;
        }
        HeightRecord heightRecord = (HeightRecord) other;
        return Intrinsics.areEqual(this.height, heightRecord.height) && Intrinsics.areEqual(getTime(), heightRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), heightRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), heightRecord.getMetadata());
    }

    public final Length getHeight() {
        return this.height;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public int hashCode() {
        int iHashCode = (getTime().hashCode() + (this.height.hashCode() * 31)) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return getMetadata().hashCode() + ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "HeightRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", height=" + this.height + ", metadata=" + getMetadata() + ')';
    }
}
