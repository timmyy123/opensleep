package androidx.health.connect.client.units;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002!\"B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010 \u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006#"}, d2 = {"Landroidx/health/connect/client/units/Energy;", "", "", SDKConstants.PARAM_VALUE, "Landroidx/health/connect/client/units/Energy$Type;", "type", "<init>", "(DLandroidx/health/connect/client/units/Energy$Type;)V", "get", "(Landroidx/health/connect/client/units/Energy$Type;)D", "zero$connect_client_release", "()Landroidx/health/connect/client/units/Energy;", "zero", "other", "", "compareTo", "(Landroidx/health/connect/client/units/Energy;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "D", "Landroidx/health/connect/client/units/Energy$Type;", "getCalories", "()D", "inCalories", "getKilocalories", "inKilocalories", "Companion", "Type", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Energy implements Comparable<Energy> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Type, Energy> ZEROS;
    private final Type type;
    private final double value;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/health/connect/client/units/Energy$Companion;", "", "<init>", "()V", "", SDKConstants.PARAM_VALUE, "Landroidx/health/connect/client/units/Energy;", "calories", "(D)Landroidx/health/connect/client/units/Energy;", "kilocalories", "", "Landroidx/health/connect/client/units/Energy$Type;", "ZEROS", "Ljava/util/Map;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Energy calories(double value) {
            return new Energy(value, Type.CALORIES, null);
        }

        public final Energy kilocalories(double value) {
            return new Energy(value, Type.KILOCALORIES, null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u0010"}, d2 = {"Landroidx/health/connect/client/units/Energy$Type;", "", "<init>", "(Ljava/lang/String;I)V", "CALORIES", "KILOCALORIES", "JOULES", "KILOJOULES", "caloriesPerUnit", "", "getCaloriesPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type CALORIES = new CALORIES("CALORIES", 0);
        public static final Type KILOCALORIES = new KILOCALORIES("KILOCALORIES", 1);
        public static final Type JOULES = new JOULES("JOULES", 2);
        public static final Type KILOJOULES = new KILOJOULES("KILOJOULES", 3);

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/health/connect/client/units/Energy.Type.CALORIES", "Landroidx/health/connect/client/units/Energy$Type;", "caloriesPerUnit", "", "getCaloriesPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class CALORIES extends Type {
            private final double caloriesPerUnit;
            private final String title;

            public CALORIES(String str, int i) {
                super(str, i, null);
                this.caloriesPerUnit = 1.0d;
                this.title = "cal";
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public double getCaloriesPerUnit() {
                return this.caloriesPerUnit;
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public String getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/health/connect/client/units/Energy.Type.JOULES", "Landroidx/health/connect/client/units/Energy$Type;", "caloriesPerUnit", "", "getCaloriesPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class JOULES extends Type {
            private final double caloriesPerUnit;
            private final String title;

            public JOULES(String str, int i) {
                super(str, i, null);
                this.caloriesPerUnit = 0.2390057361d;
                this.title = "J";
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public double getCaloriesPerUnit() {
                return this.caloriesPerUnit;
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public String getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/health/connect/client/units/Energy.Type.KILOCALORIES", "Landroidx/health/connect/client/units/Energy$Type;", "caloriesPerUnit", "", "getCaloriesPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class KILOCALORIES extends Type {
            private final double caloriesPerUnit;
            private final String title;

            public KILOCALORIES(String str, int i) {
                super(str, i, null);
                this.caloriesPerUnit = 1000.0d;
                this.title = "kcal";
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public double getCaloriesPerUnit() {
                return this.caloriesPerUnit;
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public String getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/health/connect/client/units/Energy.Type.KILOJOULES", "Landroidx/health/connect/client/units/Energy$Type;", "caloriesPerUnit", "", "getCaloriesPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class KILOJOULES extends Type {
            private final double caloriesPerUnit;
            private final String title;

            public KILOJOULES(String str, int i) {
                super(str, i, null);
                this.caloriesPerUnit = 239.0057361d;
                this.title = "kJ";
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public double getCaloriesPerUnit() {
                return this.caloriesPerUnit;
            }

            @Override // androidx.health.connect.client.units.Energy.Type
            public String getTitle() {
                return this.title;
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{CALORIES, KILOCALORIES, JOULES, KILOJOULES};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        public /* synthetic */ Type(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public abstract double getCaloriesPerUnit();

        public abstract String getTitle();

        private Type(String str, int i) {
        }
    }

    static {
        Type[] typeArrValues = Type.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(typeArrValues.length), 16));
        for (Type type : typeArrValues) {
            linkedHashMap.put(type, new Energy(0.0d, type));
        }
        ZEROS = linkedHashMap;
    }

    private Energy(double d, Type type) {
        this.value = d;
        this.type = type;
    }

    private final double get(Type type) {
        return this.type == type ? this.value : getCalories() / type.getCaloriesPerUnit();
    }

    @Override // java.lang.Comparable
    public int compareTo(Energy other) {
        other.getClass();
        return this.type == other.type ? Double.compare(this.value, other.value) : Double.compare(getCalories(), other.getCalories());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Energy)) {
            return false;
        }
        Energy energy = (Energy) other;
        return this.type == energy.type ? this.value == energy.value : getCalories() == energy.getCalories();
    }

    public final double getCalories() {
        return this.value * this.type.getCaloriesPerUnit();
    }

    public final double getKilocalories() {
        return get(Type.KILOCALORIES);
    }

    public int hashCode() {
        return Double.hashCode(getCalories());
    }

    public String toString() {
        return this.value + ' ' + this.type.getTitle();
    }

    public final Energy zero$connect_client_release() {
        return (Energy) MapsKt.getValue(ZEROS, this.type);
    }

    public /* synthetic */ Energy(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }
}
