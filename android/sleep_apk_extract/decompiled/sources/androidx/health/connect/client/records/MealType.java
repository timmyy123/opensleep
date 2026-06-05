package androidx.health.connect.client.records;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/records/MealType;", "", "<init>", "()V", "", "", "", "MEAL_TYPE_STRING_TO_INT_MAP", "Ljava/util/Map;", "MEAL_TYPE_INT_TO_STRING_MAP", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MealType {
    public static final MealType INSTANCE = new MealType();
    public static final Map<Integer, String> MEAL_TYPE_INT_TO_STRING_MAP;
    public static final Map<String, Integer> MEAL_TYPE_STRING_TO_INT_MAP;

    static {
        Map<String, Integer> mapMapOf = MapsKt.mapOf(TuplesKt.to("unknown", 0), TuplesKt.to("breakfast", 1), TuplesKt.to("lunch", 2), TuplesKt.to("dinner", 3), TuplesKt.to("snack", 4));
        MEAL_TYPE_STRING_TO_INT_MAP = mapMapOf;
        MEAL_TYPE_INT_TO_STRING_MAP = UtilsKt.reverse(mapMapOf);
    }

    private MealType() {
    }
}
