package androidx.health.connect.client.records;

import android.os.Build;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u0000 (2\u00020\u0001:\u0001(B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\u0012\n\u0004\b\u000b\u0010$\u0012\u0004\b&\u0010'\u001a\u0004\b%\u0010\u0014¨\u0006)"}, d2 = {"Landroidx/health/connect/client/records/Vo2MaxRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "j$/time/Instant", "time", "j$/time/ZoneOffset", "zoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "", "vo2MillilitersPerMinuteKilogram", "", "measurementMethod", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;DI)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getZoneOffset", "()Lj$/time/ZoneOffset;", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "D", "getVo2MillilitersPerMinuteKilogram", "()D", "I", "getMeasurementMethod", "getMeasurementMethod$annotations", "()V", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Vo2MaxRecord implements InstantaneousRecord {
    public static final Map<Integer, String> MEASUREMENT_METHOD_INT_TO_STRING_MAP;
    public static final Map<String, Integer> MEASUREMENT_METHOD_STRING_TO_INT_MAP;
    private final int measurementMethod;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant time;
    private final double vo2MillilitersPerMinuteKilogram;
    private final ZoneOffset zoneOffset;

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("other", 0), TuplesKt.to("metabolic_cart", 1), TuplesKt.to("heart_rate_ratio", 2), TuplesKt.to("cooper_test", 3), TuplesKt.to("multistage_fitness_test", 4), TuplesKt.to("rockport_fitness_test", 5));
        MEASUREMENT_METHOD_STRING_TO_INT_MAP = mapMapOf;
        MEASUREMENT_METHOD_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf);
    }

    public Vo2MaxRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, double d, int i) {
        instant.getClass();
        metadata.getClass();
        this.time = instant;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.vo2MillilitersPerMinuteKilogram = d;
        this.measurementMethod = i;
        if (Build.VERSION.SDK_INT >= 34) {
            RecordConvertersKt.toPlatformRecord(this);
        } else {
            UtilsKt.requireNonNegative(d, "vo2MillilitersPerMinuteKilogram");
            UtilsKt.requireNotMore(Double.valueOf(d), Double.valueOf(100.0d), "vo2MillilitersPerMinuteKilogram");
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vo2MaxRecord)) {
            return false;
        }
        Vo2MaxRecord vo2MaxRecord = (Vo2MaxRecord) other;
        return this.vo2MillilitersPerMinuteKilogram == vo2MaxRecord.vo2MillilitersPerMinuteKilogram && this.measurementMethod == vo2MaxRecord.measurementMethod && Intrinsics.areEqual(getTime(), vo2MaxRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), vo2MaxRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), vo2MaxRecord.getMetadata());
    }

    public final int getMeasurementMethod() {
        return this.measurementMethod;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public Instant getTime() {
        return this.time;
    }

    public final double getVo2MillilitersPerMinuteKilogram() {
        return this.vo2MillilitersPerMinuteKilogram;
    }

    @Override // androidx.health.connect.client.records.InstantaneousRecord
    public ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public int hashCode() {
        int iHashCode = (getTime().hashCode() + (((Double.hashCode(this.vo2MillilitersPerMinuteKilogram) * 31) + this.measurementMethod) * 31)) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return getMetadata().hashCode() + ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "Vo2MaxRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", vo2MillilitersPerMinuteKilogram=" + this.vo2MillilitersPerMinuteKilogram + ", measurementMethod=" + this.measurementMethod + ", metadata=" + getMetadata() + ')';
    }
}
