package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Mass;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class NutritionRecord$Companion$TOTAL_FAT_TOTAL$1 extends FunctionReferenceImpl implements Function1<Double, Mass> {
    public NutritionRecord$Companion$TOTAL_FAT_TOTAL$1(Object obj) {
        super(1, obj, Mass.Companion.class, "grams", "grams(D)Landroidx/health/connect/client/units/Mass;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Mass invoke(Double d) {
        return invoke(d.doubleValue());
    }

    public final Mass invoke(double d) {
        return ((Mass.Companion) this.receiver).grams(d);
    }
}
