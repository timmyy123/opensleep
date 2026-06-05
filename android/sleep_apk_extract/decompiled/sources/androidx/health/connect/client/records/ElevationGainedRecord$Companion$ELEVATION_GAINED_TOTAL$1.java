package androidx.health.connect.client.records;

import androidx.health.connect.client.units.Length;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class ElevationGainedRecord$Companion$ELEVATION_GAINED_TOTAL$1 extends FunctionReferenceImpl implements Function1<Double, Length> {
    public ElevationGainedRecord$Companion$ELEVATION_GAINED_TOTAL$1(Object obj) {
        super(1, obj, Length.Companion.class, "meters", "meters(D)Landroidx/health/connect/client/units/Length;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Length invoke(Double d) {
        return invoke(d.doubleValue());
    }

    public final Length invoke(double d) {
        return ((Length.Companion) this.receiver).meters(d);
    }
}
