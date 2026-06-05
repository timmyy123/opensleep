package androidx.health.connect.client.records;

import android.os.Build;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.units.Pressure;
import androidx.health.connect.client.units.PressureKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u0000 -2\u00020\u0001:\u0001-BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b&\u0010%R\u001d\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\u0012\n\u0004\b\f\u0010'\u0012\u0004\b)\u0010*\u001a\u0004\b(\u0010\u0016R\u001d\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\u0012\n\u0004\b\r\u0010'\u0012\u0004\b,\u0010*\u001a\u0004\b+\u0010\u0016¨\u0006."}, d2 = {"Landroidx/health/connect/client/records/BloodPressureRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "j$/time/Instant", "time", "j$/time/ZoneOffset", "zoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "Landroidx/health/connect/client/units/Pressure;", "systolic", "diastolic", "", "bodyPosition", "measurementLocation", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Landroidx/health/connect/client/units/Pressure;Landroidx/health/connect/client/units/Pressure;II)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getZoneOffset", "()Lj$/time/ZoneOffset;", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "Landroidx/health/connect/client/units/Pressure;", "getSystolic", "()Landroidx/health/connect/client/units/Pressure;", "getDiastolic", "I", "getBodyPosition", "getBodyPosition$annotations", "()V", "getMeasurementLocation", "getMeasurementLocation$annotations", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BloodPressureRecord implements InstantaneousRecord {
    public static final Map<Integer, String> BODY_POSITION_INT_TO_STRING_MAP;
    public static final Map<String, Integer> BODY_POSITION_STRING_TO_INT_MAP;
    public static final AggregateMetric<Pressure> DIASTOLIC_AVG;
    public static final AggregateMetric<Pressure> DIASTOLIC_MAX;
    public static final AggregateMetric<Pressure> DIASTOLIC_MIN;
    private static final Pressure MAX_DIASTOLIC;
    private static final Pressure MAX_SYSTOLIC;
    public static final Map<Integer, String> MEASUREMENT_LOCATION_INT_TO_STRING_MAP;
    public static final Map<String, Integer> MEASUREMENT_LOCATION_STRING_TO_INT_MAP;
    private static final Pressure MIN_DIASTOLIC;
    private static final Pressure MIN_SYSTOLIC;
    public static final AggregateMetric<Pressure> SYSTOLIC_AVG;
    public static final AggregateMetric<Pressure> SYSTOLIC_MAX;
    public static final AggregateMetric<Pressure> SYSTOLIC_MIN;
    private final int bodyPosition;
    private final Pressure diastolic;
    private final int measurementLocation;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Pressure systolic;
    private final Instant time;
    private final ZoneOffset zoneOffset;

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("left_upper_arm", 3), TuplesKt.to("left_wrist", 1), TuplesKt.to("right_upper_arm", 4), TuplesKt.to("right_wrist", 2));
        MEASUREMENT_LOCATION_STRING_TO_INT_MAP = mapMapOf;
        MEASUREMENT_LOCATION_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf);
        Map<String, Integer> mapMapOf2 = MapsKt.mapOf(TuplesKt.to("lying_down", 3), TuplesKt.to("reclining", 4), TuplesKt.to("sitting_down", 2), TuplesKt.to("standing_up", 1));
        BODY_POSITION_STRING_TO_INT_MAP = mapMapOf2;
        BODY_POSITION_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf2);
        MIN_SYSTOLIC = PressureKt.getMillimetersOfMercury(9.9E-323d);
        MAX_SYSTOLIC = PressureKt.getMillimetersOfMercury(9.9E-322d);
        MIN_DIASTOLIC = PressureKt.getMillimetersOfMercury(4.9E-323d);
        MAX_DIASTOLIC = PressureKt.getMillimetersOfMercury(8.9E-322d);
        AggregateMetric.Companion companion = AggregateMetric.INSTANCE;
        AggregateMetric.AggregationType aggregationType = AggregateMetric.AggregationType.AVERAGE;
        Pressure.Companion companion2 = Pressure.INSTANCE;
        SYSTOLIC_AVG = companion.doubleMetric$connect_client_release("BloodPressure", aggregationType, "systolic", new BloodPressureRecord$Companion$SYSTOLIC_AVG$1(companion2));
        AggregateMetric.AggregationType aggregationType2 = AggregateMetric.AggregationType.MINIMUM;
        SYSTOLIC_MIN = companion.doubleMetric$connect_client_release("BloodPressure", aggregationType2, "systolic", new BloodPressureRecord$Companion$SYSTOLIC_MIN$1(companion2));
        AggregateMetric.AggregationType aggregationType3 = AggregateMetric.AggregationType.MAXIMUM;
        SYSTOLIC_MAX = companion.doubleMetric$connect_client_release("BloodPressure", aggregationType3, "systolic", new BloodPressureRecord$Companion$SYSTOLIC_MAX$1(companion2));
        DIASTOLIC_AVG = companion.doubleMetric$connect_client_release("BloodPressure", aggregationType, "diastolic", new BloodPressureRecord$Companion$DIASTOLIC_AVG$1(companion2));
        DIASTOLIC_MIN = companion.doubleMetric$connect_client_release("BloodPressure", aggregationType2, "diastolic", new BloodPressureRecord$Companion$DIASTOLIC_MIN$1(companion2));
        DIASTOLIC_MAX = companion.doubleMetric$connect_client_release("BloodPressure", aggregationType3, "diastolic", new BloodPressureRecord$Companion$DIASTOLIC_MAX$1(companion2));
    }

    public BloodPressureRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, Pressure pressure, Pressure pressure2, int i, int i2) {
        instant.getClass();
        metadata.getClass();
        pressure.getClass();
        pressure2.getClass();
        this.time = instant;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.systolic = pressure;
        this.diastolic = pressure2;
        this.bodyPosition = i;
        this.measurementLocation = i2;
        if (Build.VERSION.SDK_INT >= 34) {
            RecordConvertersKt.toPlatformRecord(this);
            return;
        }
        UtilsKt.requireNotLess(pressure, MIN_SYSTOLIC, "systolic");
        UtilsKt.requireNotMore(pressure, MAX_SYSTOLIC, "systolic");
        UtilsKt.requireNotLess(pressure2, MIN_DIASTOLIC, "diastolic");
        UtilsKt.requireNotMore(pressure2, MAX_DIASTOLIC, "diastolic");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BloodPressureRecord)) {
            return false;
        }
        BloodPressureRecord bloodPressureRecord = (BloodPressureRecord) other;
        return Intrinsics.areEqual(this.systolic, bloodPressureRecord.systolic) && Intrinsics.areEqual(this.diastolic, bloodPressureRecord.diastolic) && this.bodyPosition == bloodPressureRecord.bodyPosition && this.measurementLocation == bloodPressureRecord.measurementLocation && Intrinsics.areEqual(getTime(), bloodPressureRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), bloodPressureRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), bloodPressureRecord.getMetadata());
    }

    public final int getBodyPosition() {
        return this.bodyPosition;
    }

    public final Pressure getDiastolic() {
        return this.diastolic;
    }

    public final int getMeasurementLocation() {
        return this.measurementLocation;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public final Pressure getSystolic() {
        return this.systolic;
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
        int iHashCode = (getTime().hashCode() + ((((((this.diastolic.hashCode() + (this.systolic.hashCode() * 31)) * 31) + this.bodyPosition) * 31) + this.measurementLocation) * 31)) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return getMetadata().hashCode() + ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "BloodPressureRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", systolic=" + this.systolic + ", diastolic=" + this.diastolic + ", bodyPosition=" + this.bodyPosition + ", measurementLocation=" + this.measurementLocation + ", metadata=" + getMetadata() + ')';
    }
}
