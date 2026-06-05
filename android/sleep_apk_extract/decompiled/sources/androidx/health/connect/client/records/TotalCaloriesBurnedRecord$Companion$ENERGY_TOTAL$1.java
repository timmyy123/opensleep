package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Energy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class TotalCaloriesBurnedRecord$Companion$ENERGY_TOTAL$1 extends FunctionReferenceImpl implements Function1<Double, Energy> {
    public TotalCaloriesBurnedRecord$Companion$ENERGY_TOTAL$1(Object obj) {
        super(1, obj, Energy.Companion.class, "kilocalories", "kilocalories(D)Landroidx/health/connect/client/units/Energy;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Energy invoke(Double d) {
        return invoke(d.doubleValue());
    }

    public final Energy invoke(double d) {
        return ((Energy.Companion) this.receiver).kilocalories(d);
    }
}
