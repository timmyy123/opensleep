package androidx.health.connect.client.impl.platform.records;

import android.health.connect.datatypes.Metadata;
import android.health.connect.datatypes.units.BloodGlucose;
import android.health.connect.datatypes.units.Energy;
import android.health.connect.datatypes.units.Length;
import android.health.connect.datatypes.units.Pressure;
import android.health.connect.datatypes.units.Temperature;
import android.health.connect.datatypes.units.Volume;
import j$.time.Instant;
import j$.time.TimeConversions;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RecordConvertersKt$$ExternalSyntheticAPIConversion8 {
    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, int i, BloodGlucose bloodGlucose, int i2, int i3) {
        return new Object[]{metadata, TimeConversions.convert(instant), Integer.valueOf(i), bloodGlucose, Integer.valueOf(i2), Integer.valueOf(i3)};
    }

    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, int i, double d) {
        return new Object[]{metadata, TimeConversions.convert(instant), Integer.valueOf(i), Double.valueOf(d)};
    }

    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, int i, int i2) {
        return new Object[]{metadata, TimeConversions.convert(instant), Integer.valueOf(i), Integer.valueOf(i2)};
    }

    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, int i, Pressure pressure, Pressure pressure2, int i2) {
        return new Object[]{metadata, TimeConversions.convert(instant), Integer.valueOf(i), pressure, pressure2, Integer.valueOf(i2)};
    }

    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, int i, Temperature temperature) {
        return new Object[]{metadata, TimeConversions.convert(instant), Integer.valueOf(i), temperature};
    }

    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, Instant instant2, double d) {
        return new Object[]{metadata, TimeConversions.convert(instant), TimeConversions.convert(instant2), Double.valueOf(d)};
    }

    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, Instant instant2, int i) {
        return new Object[]{metadata, TimeConversions.convert(instant), TimeConversions.convert(instant2), Integer.valueOf(i)};
    }

    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, Instant instant2, long j) {
        return new Object[]{metadata, TimeConversions.convert(instant), TimeConversions.convert(instant2), Long.valueOf(j)};
    }

    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, Instant instant2, Energy energy) {
        return new Object[]{metadata, TimeConversions.convert(instant), TimeConversions.convert(instant2), energy};
    }

    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, Instant instant2, Length length) {
        return new Object[]{metadata, TimeConversions.convert(instant), TimeConversions.convert(instant2), length};
    }

    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, Instant instant2, Volume volume) {
        return new Object[]{metadata, TimeConversions.convert(instant), TimeConversions.convert(instant2), volume};
    }

    public static /* synthetic */ Object[] m(Metadata metadata, Instant instant, Instant instant2, List list) {
        return new Object[]{metadata, TimeConversions.convert(instant), TimeConversions.convert(instant2), list};
    }

    public static /* synthetic */ Object[] m(Instant instant, double d, double d2) {
        return new Object[]{TimeConversions.convert(instant), Double.valueOf(d), Double.valueOf(d2)};
    }

    public static /* synthetic */ Object[] m(Instant instant, Instant instant2, int i) {
        return new Object[]{TimeConversions.convert(instant), TimeConversions.convert(instant2), Integer.valueOf(i)};
    }
}
