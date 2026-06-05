package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Pressure;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class BloodPressureRecord$Companion$DIASTOLIC_MAX$1 extends FunctionReferenceImpl implements Function1<Double, Pressure> {
    public BloodPressureRecord$Companion$DIASTOLIC_MAX$1(Object obj) {
        super(1, obj, Pressure.Companion.class, "millimetersOfMercury", "millimetersOfMercury(D)Landroidx/health/connect/client/units/Pressure;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Pressure invoke(Double d) {
        return invoke(d.doubleValue());
    }

    public final Pressure invoke(double d) {
        return ((Pressure.Companion) this.receiver).millimetersOfMercury(d);
    }
}
