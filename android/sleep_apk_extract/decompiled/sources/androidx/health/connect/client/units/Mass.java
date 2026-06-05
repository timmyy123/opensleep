package androidx.health.connect.client.units;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002!\"B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010 \u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006#"}, d2 = {"Landroidx/health/connect/client/units/Mass;", "", "", SDKConstants.PARAM_VALUE, "Landroidx/health/connect/client/units/Mass$Type;", "type", "<init>", "(DLandroidx/health/connect/client/units/Mass$Type;)V", "get", "(Landroidx/health/connect/client/units/Mass$Type;)D", "zero$connect_client_release", "()Landroidx/health/connect/client/units/Mass;", "zero", "other", "", "compareTo", "(Landroidx/health/connect/client/units/Mass;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "D", "Landroidx/health/connect/client/units/Mass$Type;", "getGrams", "()D", "inGrams", "getKilograms", "inKilograms", "Companion", "Type", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Mass implements Comparable<Mass> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Type, Mass> ZEROS;
    private final Type type;
    private final double value;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/health/connect/client/units/Mass$Companion;", "", "<init>", "()V", "", SDKConstants.PARAM_VALUE, "Landroidx/health/connect/client/units/Mass;", "grams", "(D)Landroidx/health/connect/client/units/Mass;", "kilograms", "", "Landroidx/health/connect/client/units/Mass$Type;", "ZEROS", "Ljava/util/Map;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Mass grams(double value) {
            return new Mass(value, Type.GRAMS, null);
        }

        public final Mass kilograms(double value) {
            return new Mass(value, Type.KILOGRAMS, null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000e"}, d2 = {"Landroidx/health/connect/client/units/Mass$Type;", "", "<init>", "(Ljava/lang/String;I)V", "GRAMS", "KILOGRAMS", "MILLIGRAMS", "MICROGRAMS", "OUNCES", "POUNDS", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type GRAMS = new GRAMS("GRAMS", 0);
        public static final Type KILOGRAMS = new KILOGRAMS("KILOGRAMS", 1);
        public static final Type MILLIGRAMS = new MILLIGRAMS("MILLIGRAMS", 2);
        public static final Type MICROGRAMS = new MICROGRAMS("MICROGRAMS", 3);
        public static final Type OUNCES = new OUNCES("OUNCES", 4);
        public static final Type POUNDS = new POUNDS("POUNDS", 5);

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/health/connect/client/units/Mass.Type.GRAMS", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class GRAMS extends Type {
            private final double gramsPerUnit;

            public GRAMS(String str, int i) {
                super(str, i, null);
                this.gramsPerUnit = 1.0d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/health/connect/client/units/Mass.Type.KILOGRAMS", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class KILOGRAMS extends Type {
            private final double gramsPerUnit;

            public KILOGRAMS(String str, int i) {
                super(str, i, null);
                this.gramsPerUnit = 1000.0d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/health/connect/client/units/Mass.Type.MICROGRAMS", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MICROGRAMS extends Type {
            private final double gramsPerUnit;

            public MICROGRAMS(String str, int i) {
                super(str, i, null);
                this.gramsPerUnit = 1.0E-6d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/health/connect/client/units/Mass.Type.MILLIGRAMS", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MILLIGRAMS extends Type {
            private final double gramsPerUnit;

            public MILLIGRAMS(String str, int i) {
                super(str, i, null);
                this.gramsPerUnit = 0.001d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/health/connect/client/units/Mass.Type.OUNCES", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class OUNCES extends Type {
            private final double gramsPerUnit;

            public OUNCES(String str, int i) {
                super(str, i, null);
                this.gramsPerUnit = 28.34952d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/health/connect/client/units/Mass.Type.POUNDS", "Landroidx/health/connect/client/units/Mass$Type;", "gramsPerUnit", "", "getGramsPerUnit", "()D", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class POUNDS extends Type {
            private final double gramsPerUnit;

            public POUNDS(String str, int i) {
                super(str, i, null);
                this.gramsPerUnit = 453.59237d;
            }

            @Override // androidx.health.connect.client.units.Mass.Type
            public double getGramsPerUnit() {
                return this.gramsPerUnit;
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{GRAMS, KILOGRAMS, MILLIGRAMS, MICROGRAMS, OUNCES, POUNDS};
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

        public abstract double getGramsPerUnit();

        private Type(String str, int i) {
        }
    }

    static {
        Type[] typeArrValues = Type.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(typeArrValues.length), 16));
        for (Type type : typeArrValues) {
            linkedHashMap.put(type, new Mass(0.0d, type));
        }
        ZEROS = linkedHashMap;
    }

    private Mass(double d, Type type) {
        this.value = d;
        this.type = type;
    }

    private final double get(Type type) {
        return this.type == type ? this.value : getGrams() / type.getGramsPerUnit();
    }

    @Override // java.lang.Comparable
    public int compareTo(Mass other) {
        other.getClass();
        return this.type == other.type ? Double.compare(this.value, other.value) : Double.compare(getGrams(), other.getGrams());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Mass)) {
            return false;
        }
        Mass mass = (Mass) other;
        return this.type == mass.type ? this.value == mass.value : getGrams() == mass.getGrams();
    }

    public final double getGrams() {
        return this.value * this.type.getGramsPerUnit();
    }

    public final double getKilograms() {
        return get(Type.KILOGRAMS);
    }

    public int hashCode() {
        return Double.hashCode(getGrams());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.value);
        sb.append(' ');
        String lowerCase = this.type.name().toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        sb.append(lowerCase);
        return sb.toString();
    }

    public final Mass zero$connect_client_release() {
        return (Mass) MapsKt.getValue(ZEROS, this.type);
    }

    public /* synthetic */ Mass(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }
}
