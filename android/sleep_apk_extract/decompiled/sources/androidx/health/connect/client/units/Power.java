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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0019\u001aB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\r\u0010\u000e\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u000fJ\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u001b"}, d2 = {"Landroidx/health/connect/client/units/Power;", "", SDKConstants.PARAM_VALUE, "", "type", "Landroidx/health/connect/client/units/Power$Type;", "<init>", "(DLandroidx/health/connect/client/units/Power$Type;)V", "inWatts", "getWatts", "()D", "inKilocaloriesPerDay", "getKilocaloriesPerDay", "get", "zero", "zero$connect_client_release", "compareTo", "", "other", "equals", "", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "Type", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Power implements Comparable<Power> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Type, Power> ZEROS;
    private final Type type;
    private final double value;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/health/connect/client/units/Power$Companion;", "", "<init>", "()V", "ZEROS", "", "Landroidx/health/connect/client/units/Power$Type;", "Landroidx/health/connect/client/units/Power;", "watts", SDKConstants.PARAM_VALUE, "", "kilocaloriesPerDay", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Power kilocaloriesPerDay(double value) {
            return new Power(value, Type.KILOCALORIES_PER_DAY, null);
        }

        public final Power watts(double value) {
            return new Power(value, Type.WATTS, null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\u0004j\u0002\b\u0005¨\u0006\u000e"}, d2 = {"Landroidx/health/connect/client/units/Power$Type;", "", "<init>", "(Ljava/lang/String;I)V", "WATTS", "KILOCALORIES_PER_DAY", "wattsPerUnit", "", "getWattsPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type WATTS = new WATTS("WATTS", 0);
        public static final Type KILOCALORIES_PER_DAY = new KILOCALORIES_PER_DAY("KILOCALORIES_PER_DAY", 1);

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/health/connect/client/units/Power.Type.KILOCALORIES_PER_DAY", "Landroidx/health/connect/client/units/Power$Type;", "wattsPerUnit", "", "getWattsPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class KILOCALORIES_PER_DAY extends Type {
            private final String title;
            private final double wattsPerUnit;

            public KILOCALORIES_PER_DAY(String str, int i) {
                super(str, i, null);
                this.wattsPerUnit = 0.0484259259d;
                this.title = "kcal/day";
            }

            @Override // androidx.health.connect.client.units.Power.Type
            public String getTitle() {
                return this.title;
            }

            @Override // androidx.health.connect.client.units.Power.Type
            public double getWattsPerUnit() {
                return this.wattsPerUnit;
            }
        }

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/health/connect/client/units/Power.Type.WATTS", "Landroidx/health/connect/client/units/Power$Type;", "wattsPerUnit", "", "getWattsPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class WATTS extends Type {
            private final String title;
            private final double wattsPerUnit;

            public WATTS(String str, int i) {
                super(str, i, null);
                this.wattsPerUnit = 1.0d;
                this.title = "Watts";
            }

            @Override // androidx.health.connect.client.units.Power.Type
            public String getTitle() {
                return this.title;
            }

            @Override // androidx.health.connect.client.units.Power.Type
            public double getWattsPerUnit() {
                return this.wattsPerUnit;
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{WATTS, KILOCALORIES_PER_DAY};
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

        public abstract String getTitle();

        public abstract double getWattsPerUnit();

        private Type(String str, int i) {
        }
    }

    static {
        Type[] typeArrValues = Type.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(typeArrValues.length), 16));
        for (Type type : typeArrValues) {
            linkedHashMap.put(type, new Power(0.0d, type));
        }
        ZEROS = linkedHashMap;
    }

    private Power(double d, Type type) {
        this.value = d;
        this.type = type;
    }

    private final double get(Type type) {
        return this.type == type ? this.value : getWatts() / type.getWattsPerUnit();
    }

    @Override // java.lang.Comparable
    public int compareTo(Power other) {
        other.getClass();
        return this.type == other.type ? Double.compare(this.value, other.value) : Double.compare(getWatts(), other.getWatts());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Power)) {
            return false;
        }
        Power power = (Power) other;
        return this.type == power.type ? this.value == power.value : getWatts() == power.getWatts();
    }

    public final double getKilocaloriesPerDay() {
        return get(Type.KILOCALORIES_PER_DAY);
    }

    public final double getWatts() {
        return this.value * this.type.getWattsPerUnit();
    }

    public int hashCode() {
        return Double.hashCode(getWatts());
    }

    public String toString() {
        return this.value + ' ' + this.type.getTitle();
    }

    public final Power zero$connect_client_release() {
        return (Power) MapsKt.getValue(ZEROS, this.type);
    }

    public /* synthetic */ Power(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }
}
