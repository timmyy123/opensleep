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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u001d\u001eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/health/connect/client/units/Volume;", "", "", SDKConstants.PARAM_VALUE, "Landroidx/health/connect/client/units/Volume$Type;", "type", "<init>", "(DLandroidx/health/connect/client/units/Volume$Type;)V", "zero$connect_client_release", "()Landroidx/health/connect/client/units/Volume;", "zero", "other", "", "compareTo", "(Landroidx/health/connect/client/units/Volume;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "D", "Landroidx/health/connect/client/units/Volume$Type;", "getLiters", "()D", "inLiters", "Companion", "Type", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Volume implements Comparable<Volume> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Type, Volume> ZEROS;
    private final Type type;
    private final double value;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/health/connect/client/units/Volume$Companion;", "", "<init>", "()V", "", SDKConstants.PARAM_VALUE, "Landroidx/health/connect/client/units/Volume;", "liters", "(D)Landroidx/health/connect/client/units/Volume;", "", "Landroidx/health/connect/client/units/Volume$Type;", "ZEROS", "Ljava/util/Map;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Volume liters(double value) {
            return new Volume(value, Type.LITERS, null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u000f"}, d2 = {"Landroidx/health/connect/client/units/Volume$Type;", "", "<init>", "(Ljava/lang/String;I)V", "LITERS", "MILLILITERS", "FLUID_OUNCES_US", "litersPerUnit", "", "getLitersPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type LITERS = new LITERS("LITERS", 0);
        public static final Type MILLILITERS = new MILLILITERS("MILLILITERS", 1);
        public static final Type FLUID_OUNCES_US = new FLUID_OUNCES_US("FLUID_OUNCES_US", 2);

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/health/connect/client/units/Volume.Type.FLUID_OUNCES_US", "Landroidx/health/connect/client/units/Volume$Type;", "litersPerUnit", "", "getLitersPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class FLUID_OUNCES_US extends Type {
            private final double litersPerUnit;
            private final String title;

            public FLUID_OUNCES_US(String str, int i) {
                super(str, i, null);
                this.litersPerUnit = 0.02957353d;
                this.title = "fl. oz (US)";
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public double getLitersPerUnit() {
                return this.litersPerUnit;
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public String getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/health/connect/client/units/Volume.Type.LITERS", "Landroidx/health/connect/client/units/Volume$Type;", "litersPerUnit", "", "getLitersPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class LITERS extends Type {
            private final double litersPerUnit;
            private final String title;

            public LITERS(String str, int i) {
                super(str, i, null);
                this.litersPerUnit = 1.0d;
                this.title = "L";
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public double getLitersPerUnit() {
                return this.litersPerUnit;
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public String getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/health/connect/client/units/Volume.Type.MILLILITERS", "Landroidx/health/connect/client/units/Volume$Type;", "litersPerUnit", "", "getLitersPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MILLILITERS extends Type {
            private final double litersPerUnit;
            private final String title;

            public MILLILITERS(String str, int i) {
                super(str, i, null);
                this.litersPerUnit = 0.001d;
                this.title = "mL";
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public double getLitersPerUnit() {
                return this.litersPerUnit;
            }

            @Override // androidx.health.connect.client.units.Volume.Type
            public String getTitle() {
                return this.title;
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{LITERS, MILLILITERS, FLUID_OUNCES_US};
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

        public abstract double getLitersPerUnit();

        public abstract String getTitle();

        private Type(String str, int i) {
        }
    }

    static {
        Type[] typeArrValues = Type.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(typeArrValues.length), 16));
        for (Type type : typeArrValues) {
            linkedHashMap.put(type, new Volume(0.0d, type));
        }
        ZEROS = linkedHashMap;
    }

    private Volume(double d, Type type) {
        this.value = d;
        this.type = type;
    }

    @Override // java.lang.Comparable
    public int compareTo(Volume other) {
        other.getClass();
        return this.type == other.type ? Double.compare(this.value, other.value) : Double.compare(getLiters(), other.getLiters());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Volume)) {
            return false;
        }
        Volume volume = (Volume) other;
        return this.type == volume.type ? this.value == volume.value : getLiters() == volume.getLiters();
    }

    public final double getLiters() {
        return this.value * this.type.getLitersPerUnit();
    }

    public int hashCode() {
        return Double.hashCode(getLiters());
    }

    public String toString() {
        return this.value + ' ' + this.type.getTitle();
    }

    public final Volume zero$connect_client_release() {
        return (Volume) MapsKt.getValue(ZEROS, this.type);
    }

    public /* synthetic */ Volume(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }
}
