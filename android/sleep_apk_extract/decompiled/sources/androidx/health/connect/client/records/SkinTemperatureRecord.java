package androidx.health.connect.client.records;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.units.Temperature;
import androidx.health.connect.client.units.TemperatureDelta;
import androidx.health.connect.client.units.TemperatureKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u0000 02\u00020\u0001:\u000201BW\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b$\u0010\"R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010.\u001a\u0004\b/\u0010\u0019¨\u00062"}, d2 = {"Landroidx/health/connect/client/records/SkinTemperatureRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "j$/time/Instant", "startTime", "j$/time/ZoneOffset", "startZoneOffset", SDKConstants.PARAM_END_TIME, "endZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "", "Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "deltas", "Landroidx/health/connect/client/units/Temperature;", "baseline", "", "measurementLocation", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Ljava/util/List;Landroidx/health/connect/client/units/Temperature;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getStartZoneOffset", "()Lj$/time/ZoneOffset;", "getEndTime", "getEndZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "Ljava/util/List;", "getDeltas", "()Ljava/util/List;", "Landroidx/health/connect/client/units/Temperature;", "getBaseline", "()Landroidx/health/connect/client/units/Temperature;", "I", "getMeasurementLocation", "Companion", "Delta", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SkinTemperatureRecord implements IntervalRecord {
    public static final Map<Integer, String> MEASUREMENT_LOCATION_INT_TO_STRING_MAP;
    public static final Map<String, Integer> MEASUREMENT_LOCATION_STRING_TO_INT_MAP;
    public static final AggregateMetric<TemperatureDelta> TEMPERATURE_DELTA_AVG;
    public static final AggregateMetric<TemperatureDelta> TEMPERATURE_DELTA_MAX;
    public static final AggregateMetric<TemperatureDelta> TEMPERATURE_DELTA_MIN;
    private final Temperature baseline;
    private final List<Delta> deltas;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final int measurementLocation;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private static final Temperature MIN_TEMPERATURE = TemperatureKt.getCelsius(0.0d);
    private static final Temperature MAX_TEMPERATURE = TemperatureKt.getCelsius(4.94E-322d);

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "", "j$/time/Instant", "time", "Landroidx/health/connect/client/units/TemperatureDelta;", "delta", "<init>", "(Lj$/time/Instant;Landroidx/health/connect/client/units/TemperatureDelta;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getTime", "()Lj$/time/Instant;", "Landroidx/health/connect/client/units/TemperatureDelta;", "getDelta", "()Landroidx/health/connect/client/units/TemperatureDelta;", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Delta {
        private static final Companion Companion = new Companion(null);
        private static final TemperatureDelta MAX_DELTA_TEMPERATURE;
        private static final TemperatureDelta MIN_DELTA_TEMPERATURE;
        private final TemperatureDelta delta;
        private final Instant time;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta$Companion;", "", "<init>", "()V", "MIN_DELTA_TEMPERATURE", "Landroidx/health/connect/client/units/TemperatureDelta;", "MAX_DELTA_TEMPERATURE", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        static {
            TemperatureDelta.Companion companion = TemperatureDelta.INSTANCE;
            MIN_DELTA_TEMPERATURE = companion.celsius(-30.0d);
            MAX_DELTA_TEMPERATURE = companion.celsius(30.0d);
        }

        public Delta(Instant instant, TemperatureDelta temperatureDelta) {
            instant.getClass();
            temperatureDelta.getClass();
            this.time = instant;
            this.delta = temperatureDelta;
            UtilsKt.requireNotLess(temperatureDelta, MIN_DELTA_TEMPERATURE, "delta");
            UtilsKt.requireNotMore(temperatureDelta, MAX_DELTA_TEMPERATURE, "delta");
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(Delta.class, other != null ? other.getClass() : null)) {
                return false;
            }
            other.getClass();
            Delta delta = (Delta) other;
            return Intrinsics.areEqual(this.time, delta.time) && Intrinsics.areEqual(this.delta, delta.delta);
        }

        public final TemperatureDelta getDelta() {
            return this.delta;
        }

        public final Instant getTime() {
            return this.time;
        }

        public int hashCode() {
            return this.delta.hashCode() + (this.time.hashCode() * 31);
        }

        public String toString() {
            return "Delta(time=" + this.time + ", delta=" + this.delta + ')';
        }
    }

    static {
        AggregateMetric.Companion companion = AggregateMetric.INSTANCE;
        AggregateMetric.AggregationType aggregationType = AggregateMetric.AggregationType.AVERAGE;
        TemperatureDelta.Companion companion2 = TemperatureDelta.INSTANCE;
        TEMPERATURE_DELTA_AVG = companion.doubleMetric$connect_client_release("SkinTemperature", aggregationType, "temperatureDelta", new SkinTemperatureRecord$Companion$TEMPERATURE_DELTA_AVG$1(companion2));
        TEMPERATURE_DELTA_MIN = companion.doubleMetric$connect_client_release("SkinTemperature", AggregateMetric.AggregationType.MINIMUM, "temperatureDelta", new SkinTemperatureRecord$Companion$TEMPERATURE_DELTA_MIN$1(companion2));
        TEMPERATURE_DELTA_MAX = companion.doubleMetric$connect_client_release("SkinTemperature", AggregateMetric.AggregationType.MAXIMUM, "temperatureDelta", new SkinTemperatureRecord$Companion$TEMPERATURE_DELTA_MAX$1(companion2));
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("finger", 1), TuplesKt.to("toe", 2), TuplesKt.to("wrist", 3));
        MEASUREMENT_LOCATION_STRING_TO_INT_MAP = mapMapOf;
        MEASUREMENT_LOCATION_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf);
    }

    public SkinTemperatureRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, List<Delta> list, Temperature temperature, int i) {
        instant.getClass();
        instant2.getClass();
        metadata.getClass();
        list.getClass();
        this.startTime = instant;
        this.startZoneOffset = zoneOffset;
        this.endTime = instant2;
        this.endZoneOffset = zoneOffset2;
        this.metadata = metadata;
        this.deltas = list;
        this.baseline = temperature;
        this.measurementLocation = i;
        if (!getStartTime().isBefore(getEndTime())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("startTime must be before endTime.");
            throw null;
        }
        if (temperature != null) {
            UtilsKt.requireNotLess(temperature, MIN_TEMPERATURE, "temperature");
            UtilsKt.requireNotMore(temperature, MAX_TEMPERATURE, "temperature");
        }
        if (list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        if (!it.hasNext()) {
            Types$$ExternalSyntheticBUOutline0.m();
            throw null;
        }
        Object next = it.next();
        if (it.hasNext()) {
            Instant time = ((Delta) next).getTime();
            do {
                Object next2 = it.next();
                Instant time2 = ((Delta) next2).getTime();
                if (time.compareTo(time2) > 0) {
                    next = next2;
                    time = time2;
                }
            } while (it.hasNext());
        }
        if (((Delta) next).getTime().isBefore(getStartTime())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("deltas can not be out of parent time range.");
            throw null;
        }
        Iterator<T> it2 = this.deltas.iterator();
        if (!it2.hasNext()) {
            Types$$ExternalSyntheticBUOutline0.m();
            throw null;
        }
        Object next3 = it2.next();
        if (it2.hasNext()) {
            Instant time3 = ((Delta) next3).getTime();
            do {
                Object next4 = it2.next();
                Instant time4 = ((Delta) next4).getTime();
                if (time3.compareTo(time4) < 0) {
                    next3 = next4;
                    time3 = time4;
                }
            } while (it2.hasNext());
        }
        if (((Delta) next3).getTime().isBefore(getEndTime())) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("deltas can not be out of parent time range.");
        throw null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkinTemperatureRecord)) {
            return false;
        }
        SkinTemperatureRecord skinTemperatureRecord = (SkinTemperatureRecord) other;
        return Intrinsics.areEqual(getStartTime(), skinTemperatureRecord.getStartTime()) && Intrinsics.areEqual(getEndTime(), skinTemperatureRecord.getEndTime()) && Intrinsics.areEqual(getStartZoneOffset(), skinTemperatureRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndZoneOffset(), skinTemperatureRecord.getEndZoneOffset()) && Intrinsics.areEqual(this.baseline, skinTemperatureRecord.baseline) && this.measurementLocation == skinTemperatureRecord.measurementLocation && Intrinsics.areEqual(this.deltas, skinTemperatureRecord.deltas) && Intrinsics.areEqual(getMetadata(), skinTemperatureRecord.getMetadata());
    }

    public final Temperature getBaseline() {
        return this.baseline;
    }

    public final List<Delta> getDeltas() {
        return this.deltas;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getEndTime() {
        return this.endTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getEndZoneOffset() {
        return this.endZoneOffset;
    }

    public final int getMeasurementLocation() {
        return this.measurementLocation;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getStartTime() {
        return this.startTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getStartZoneOffset() {
        return this.startZoneOffset;
    }

    public int hashCode() {
        int iHashCode = (getEndTime().hashCode() + (getStartTime().hashCode() * 31)) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode2 = (iHashCode + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        int iHashCode3 = (iHashCode2 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31;
        Temperature temperature = this.baseline;
        return getMetadata().hashCode() + FileInsert$$ExternalSyntheticOutline0.m((List) this.deltas, FileInsert$$ExternalSyntheticOutline0.m(this.measurementLocation, (iHashCode3 + (temperature != null ? temperature.hashCode() : 0)) * 31, 31), 31);
    }

    public String toString() {
        return "SkinTemperatureRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", deltas=" + this.deltas + ", baseline=" + this.baseline + ", measurementLocation=" + this.measurementLocation + ", metadata=" + getMetadata() + ')';
    }
}
