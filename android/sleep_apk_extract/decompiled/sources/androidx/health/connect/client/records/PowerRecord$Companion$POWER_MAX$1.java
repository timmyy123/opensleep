package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Power;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class PowerRecord$Companion$POWER_MAX$1 extends FunctionReferenceImpl implements Function1<Double, Power> {
    public PowerRecord$Companion$POWER_MAX$1(Object obj) {
        super(1, obj, Power.Companion.class, "watts", "watts(D)Landroidx/health/connect/client/units/Power;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Power invoke(Double d) {
        return invoke(d.doubleValue());
    }

    public final Power invoke(double d) {
        return ((Power.Companion) this.receiver).watts(d);
    }
}
