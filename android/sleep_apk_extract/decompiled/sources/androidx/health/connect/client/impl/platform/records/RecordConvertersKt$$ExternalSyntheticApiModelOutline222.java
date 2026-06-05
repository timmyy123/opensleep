package androidx.health.connect.client.impl.platform.records;

import android.health.connect.datatypes.SkinTemperatureRecord;
import android.health.connect.datatypes.units.TemperatureDelta;
import j$.time.Instant;
import j$.time.TimeConversions;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class RecordConvertersKt$$ExternalSyntheticApiModelOutline222 {
    public static /* synthetic */ SkinTemperatureRecord.Delta m(TemperatureDelta temperatureDelta, Instant instant) {
        return new SkinTemperatureRecord.Delta(temperatureDelta, TimeConversions.convert(instant));
    }

    public static /* synthetic */ void m() {
    }
}
