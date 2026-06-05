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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u001d\u001eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Landroidx/health/connect/client/units/BloodGlucose;", "", "", SDKConstants.PARAM_VALUE, "Landroidx/health/connect/client/units/BloodGlucose$Type;", "type", "<init>", "(DLandroidx/health/connect/client/units/BloodGlucose$Type;)V", "zero$connect_client_release", "()Landroidx/health/connect/client/units/BloodGlucose;", "zero", "other", "", "compareTo", "(Landroidx/health/connect/client/units/BloodGlucose;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "D", "Landroidx/health/connect/client/units/BloodGlucose$Type;", "getMillimolesPerLiter", "()D", "inMillimolesPerLiter", "Companion", "Type", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BloodGlucose implements Comparable<BloodGlucose> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Type, BloodGlucose> ZEROS;
    private final Type type;
    private final double value;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/health/connect/client/units/BloodGlucose$Companion;", "", "<init>", "()V", "", SDKConstants.PARAM_VALUE, "Landroidx/health/connect/client/units/BloodGlucose;", "millimolesPerLiter", "(D)Landroidx/health/connect/client/units/BloodGlucose;", "", "Landroidx/health/connect/client/units/BloodGlucose$Type;", "ZEROS", "Ljava/util/Map;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BloodGlucose millimolesPerLiter(double value) {
            return new BloodGlucose(value, Type.MILLIMOLES_PER_LITER, null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\u0004j\u0002\b\u0005¨\u0006\u000e"}, d2 = {"Landroidx/health/connect/client/units/BloodGlucose$Type;", "", "<init>", "(Ljava/lang/String;I)V", "MILLIMOLES_PER_LITER", "MILLIGRAMS_PER_DECILITER", "millimolesPerLiterPerUnit", "", "getMillimolesPerLiterPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type MILLIMOLES_PER_LITER = new MILLIMOLES_PER_LITER("MILLIMOLES_PER_LITER", 0);
        public static final Type MILLIGRAMS_PER_DECILITER = new MILLIGRAMS_PER_DECILITER("MILLIGRAMS_PER_DECILITER", 1);

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/health/connect/client/units/BloodGlucose.Type.MILLIGRAMS_PER_DECILITER", "Landroidx/health/connect/client/units/BloodGlucose$Type;", "millimolesPerLiterPerUnit", "", "getMillimolesPerLiterPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MILLIGRAMS_PER_DECILITER extends Type {
            private final double millimolesPerLiterPerUnit;
            private final String title;

            public MILLIGRAMS_PER_DECILITER(String str, int i) {
                super(str, i, null);
                this.millimolesPerLiterPerUnit = 0.05555555555555555d;
                this.title = "mg/dL";
            }

            @Override // androidx.health.connect.client.units.BloodGlucose.Type
            public double getMillimolesPerLiterPerUnit() {
                return this.millimolesPerLiterPerUnit;
            }

            @Override // androidx.health.connect.client.units.BloodGlucose.Type
            public String getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/health/connect/client/units/BloodGlucose.Type.MILLIMOLES_PER_LITER", "Landroidx/health/connect/client/units/BloodGlucose$Type;", "millimolesPerLiterPerUnit", "", "getMillimolesPerLiterPerUnit", "()D", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class MILLIMOLES_PER_LITER extends Type {
            private final double millimolesPerLiterPerUnit;

            public MILLIMOLES_PER_LITER(String str, int i) {
                super(str, i, null);
                this.millimolesPerLiterPerUnit = 1.0d;
            }

            @Override // androidx.health.connect.client.units.BloodGlucose.Type
            public double getMillimolesPerLiterPerUnit() {
                return this.millimolesPerLiterPerUnit;
            }

            @Override // androidx.health.connect.client.units.BloodGlucose.Type
            public String getTitle() {
                return "mmol/L";
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{MILLIMOLES_PER_LITER, MILLIGRAMS_PER_DECILITER};
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

        public abstract double getMillimolesPerLiterPerUnit();

        public abstract String getTitle();

        private Type(String str, int i) {
        }
    }

    static {
        Type[] typeArrValues = Type.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(typeArrValues.length), 16));
        for (Type type : typeArrValues) {
            linkedHashMap.put(type, new BloodGlucose(0.0d, type));
        }
        ZEROS = linkedHashMap;
    }

    private BloodGlucose(double d, Type type) {
        this.value = d;
        this.type = type;
    }

    @Override // java.lang.Comparable
    public int compareTo(BloodGlucose other) {
        other.getClass();
        return this.type == other.type ? Double.compare(this.value, other.value) : Double.compare(getMillimolesPerLiter(), other.getMillimolesPerLiter());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BloodGlucose)) {
            return false;
        }
        BloodGlucose bloodGlucose = (BloodGlucose) other;
        return this.type == bloodGlucose.type ? this.value == bloodGlucose.value : getMillimolesPerLiter() == bloodGlucose.getMillimolesPerLiter();
    }

    public final double getMillimolesPerLiter() {
        return this.value * this.type.getMillimolesPerLiterPerUnit();
    }

    public int hashCode() {
        return Double.hashCode(getMillimolesPerLiter());
    }

    public String toString() {
        return this.value + ' ' + this.type.getTitle();
    }

    public final BloodGlucose zero$connect_client_release() {
        return (BloodGlucose) MapsKt.getValue(ZEROS, this.type);
    }

    public /* synthetic */ BloodGlucose(double d, Type type, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type);
    }
}
