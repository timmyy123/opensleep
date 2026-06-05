package androidx.health.connect.client.records;

import androidx.health.connect.client.units.TemperatureDelta;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class SkinTemperatureRecord$Companion$TEMPERATURE_DELTA_MAX$1 extends FunctionReferenceImpl implements Function1<Double, TemperatureDelta> {
    public SkinTemperatureRecord$Companion$TEMPERATURE_DELTA_MAX$1(Object obj) {
        super(1, obj, TemperatureDelta.Companion.class, "celsius", "celsius(D)Landroidx/health/connect/client/units/TemperatureDelta;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TemperatureDelta invoke(Double d) {
        return invoke(d.doubleValue());
    }

    public final TemperatureDelta invoke(double d) {
        return ((TemperatureDelta.Companion) this.receiver).celsius(d);
    }
}
