package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Temperature;
import androidx.health.connect.client.units.TemperatureKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u0000 (2\u00020\u0001:\u0001(B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\u0012\n\u0004\b\u000b\u0010$\u0012\u0004\b&\u0010'\u001a\u0004\b%\u0010\u0014¨\u0006)"}, d2 = {"Landroidx/health/connect/client/records/BasalBodyTemperatureRecord;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "j$/time/Instant", "time", "j$/time/ZoneOffset", "zoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "Landroidx/health/connect/client/units/Temperature;", "temperature", "", "measurementLocation", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Landroidx/health/connect/client/units/Temperature;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getZoneOffset", "()Lj$/time/ZoneOffset;", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "Landroidx/health/connect/client/units/Temperature;", "getTemperature", "()Landroidx/health/connect/client/units/Temperature;", "I", "getMeasurementLocation", "getMeasurementLocation$annotations", "()V", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BasalBodyTemperatureRecord implements InstantaneousRecord {
    private final int measurementLocation;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Temperature temperature;
    private final Instant time;
    private final ZoneOffset zoneOffset;
    private static final Companion Companion = new Companion(null);
    private static final Temperature MIN_TEMPERATURE = TemperatureKt.getCelsius(0.0d);
    private static final Temperature MAX_TEMPERATURE = TemperatureKt.getCelsius(4.94E-322d);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/health/connect/client/records/BasalBodyTemperatureRecord$Companion;", "", "<init>", "()V", "MIN_TEMPERATURE", "Landroidx/health/connect/client/units/Temperature;", "MAX_TEMPERATURE", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BasalBodyTemperatureRecord(Instant instant, ZoneOffset zoneOffset, androidx.health.connect.client.records.metadata.Metadata metadata, Temperature temperature, int i) {
        instant.getClass();
        metadata.getClass();
        temperature.getClass();
        this.time = instant;
        this.zoneOffset = zoneOffset;
        this.metadata = metadata;
        this.temperature = temperature;
        this.measurementLocation = i;
        UtilsKt.requireNotLess(temperature, MIN_TEMPERATURE, "temperature");
        UtilsKt.requireNotMore(temperature, MAX_TEMPERATURE, "temperature");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BasalBodyTemperatureRecord)) {
            return false;
        }
        BasalBodyTemperatureRecord basalBodyTemperatureRecord = (BasalBodyTemperatureRecord) other;
        return Intrinsics.areEqual(this.temperature, basalBodyTemperatureRecord.temperature) && this.measurementLocation == basalBodyTemperatureRecord.measurementLocation && Intrinsics.areEqual(getTime(), basalBodyTemperatureRecord.getTime()) && Intrinsics.areEqual(getZoneOffset(), basalBodyTemperatureRecord.getZoneOffset()) && Intrinsics.areEqual(getMetadata(), basalBodyTemperatureRecord.getMetadata());
    }

    public final int getMeasurementLocation() {
        return this.measurementLocation;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public final Temperature getTemperature() {
        return this.temperature;
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
        int iHashCode = (getTime().hashCode() + (((this.temperature.hashCode() * 31) + this.measurementLocation) * 31)) * 31;
        ZoneOffset zoneOffset = getZoneOffset();
        return getMetadata().hashCode() + ((iHashCode + (zoneOffset != null ? zoneOffset.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "BasalBodyTemperatureRecord(time=" + getTime() + ", zoneOffset=" + getZoneOffset() + ", temperature=" + this.temperature + ", measurementLocation=" + this.measurementLocation + ", metadata=" + getMetadata() + ')';
    }
}
