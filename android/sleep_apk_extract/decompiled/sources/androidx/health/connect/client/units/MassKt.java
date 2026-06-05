package androidx.health.connect.client.units;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006¨\u0006\t"}, d2 = {"", "Landroidx/health/connect/client/units/Mass;", "getGrams", "(D)Landroidx/health/connect/client/units/Mass;", "grams", "", "(I)Landroidx/health/connect/client/units/Mass;", "getKilograms", "kilograms", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class MassKt {
    public static final /* synthetic */ Mass getGrams(double d) {
        return Mass.INSTANCE.grams(d);
    }

    public static final /* synthetic */ Mass getKilograms(double d) {
        return Mass.INSTANCE.kilograms(d);
    }
}
