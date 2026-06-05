package androidx.health.connect.client.units;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u001a\u001bB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Landroidx/health/connect/client/units/TemperatureDelta;", "", "", SDKConstants.PARAM_VALUE, "Landroidx/health/connect/client/units/TemperatureDelta$TemperatureUnit;", "temperatureUnit", "<init>", "(DLandroidx/health/connect/client/units/TemperatureDelta$TemperatureUnit;)V", "other", "", "compareTo", "(Landroidx/health/connect/client/units/TemperatureDelta;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "D", "Landroidx/health/connect/client/units/TemperatureDelta$TemperatureUnit;", "getCelsius", "()D", "inCelsius", "Companion", "TemperatureUnit", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TemperatureDelta implements Comparable<TemperatureDelta> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TemperatureUnit temperatureUnit;
    private final double value;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/health/connect/client/units/TemperatureDelta$Companion;", "", "<init>", "()V", "", SDKConstants.PARAM_VALUE, "Landroidx/health/connect/client/units/TemperatureDelta;", "celsius", "(D)Landroidx/health/connect/client/units/TemperatureDelta;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TemperatureDelta celsius(double value) {
            return new TemperatureDelta(value, TemperatureUnit.CELSIUS, null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\n"}, d2 = {"Landroidx/health/connect/client/units/TemperatureDelta$TemperatureUnit;", "", "<init>", "(Ljava/lang/String;I)V", "CELSIUS", "FAHRENHEIT", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TemperatureUnit {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TemperatureUnit[] $VALUES;
        public static final TemperatureUnit CELSIUS = new CELSIUS("CELSIUS", 0);
        public static final TemperatureUnit FAHRENHEIT = new FAHRENHEIT("FAHRENHEIT", 1);

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/health/connect/client/units/TemperatureDelta.TemperatureUnit.CELSIUS", "Landroidx/health/connect/client/units/TemperatureDelta$TemperatureUnit;", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class CELSIUS extends TemperatureUnit {
            private final String title;

            public CELSIUS(String str, int i) {
                super(str, i, null);
                this.title = "Celsius";
            }

            @Override // androidx.health.connect.client.units.TemperatureDelta.TemperatureUnit
            public String getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/health/connect/client/units/TemperatureDelta.TemperatureUnit.FAHRENHEIT", "Landroidx/health/connect/client/units/TemperatureDelta$TemperatureUnit;", "title", "", "getTitle", "()Ljava/lang/String;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class FAHRENHEIT extends TemperatureUnit {
            private final String title;

            public FAHRENHEIT(String str, int i) {
                super(str, i, null);
                this.title = "Fahrenheit";
            }

            @Override // androidx.health.connect.client.units.TemperatureDelta.TemperatureUnit
            public String getTitle() {
                return this.title;
            }
        }

        private static final /* synthetic */ TemperatureUnit[] $values() {
            return new TemperatureUnit[]{CELSIUS, FAHRENHEIT};
        }

        static {
            TemperatureUnit[] temperatureUnitArr$values = $values();
            $VALUES = temperatureUnitArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(temperatureUnitArr$values);
        }

        public /* synthetic */ TemperatureUnit(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static TemperatureUnit valueOf(String str) {
            return (TemperatureUnit) Enum.valueOf(TemperatureUnit.class, str);
        }

        public static TemperatureUnit[] values() {
            return (TemperatureUnit[]) $VALUES.clone();
        }

        public abstract String getTitle();

        private TemperatureUnit(String str, int i) {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TemperatureUnit.values().length];
            try {
                iArr[TemperatureUnit.CELSIUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TemperatureUnit.FAHRENHEIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TemperatureDelta(double d, TemperatureUnit temperatureUnit) {
        this.value = d;
        this.temperatureUnit = temperatureUnit;
    }

    @Override // java.lang.Comparable
    public int compareTo(TemperatureDelta other) {
        other.getClass();
        return this.temperatureUnit == other.temperatureUnit ? Double.compare(this.value, other.value) : Double.compare(getCelsius(), other.getCelsius());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemperatureDelta)) {
            return false;
        }
        TemperatureDelta temperatureDelta = (TemperatureDelta) other;
        return this.temperatureUnit == temperatureDelta.temperatureUnit ? this.value == temperatureDelta.value : getCelsius() == temperatureDelta.getCelsius();
    }

    public final double getCelsius() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.temperatureUnit.ordinal()];
        if (i == 1) {
            return this.value;
        }
        if (i == 2) {
            return this.value / 1.8d;
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return 0.0d;
    }

    public int hashCode() {
        return Double.hashCode(getCelsius());
    }

    public String toString() {
        return this.value + ' ' + this.temperatureUnit.getTitle();
    }

    public /* synthetic */ TemperatureDelta(double d, TemperatureUnit temperatureUnit, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, temperatureUnit);
    }
}
