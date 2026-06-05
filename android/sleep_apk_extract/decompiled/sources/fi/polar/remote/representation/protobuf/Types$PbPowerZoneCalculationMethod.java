package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbPowerZoneCalculationMethod implements Internal.EnumLite {
    POWER_ZONE_CALCULATION_METHOD_UNKNOWN(0),
    POWER_ZONE_CALCULATION_METHOD_FTP_BASED(1),
    POWER_ZONE_CALCULATION_METHOD_MAP_BASED(2);

    private static final Internal.EnumLiteMap<Types$PbPowerZoneCalculationMethod> internalValueMap = new Internal.EnumLiteMap<Types$PbPowerZoneCalculationMethod>() { // from class: fi.polar.remote.representation.protobuf.Types$PbPowerZoneCalculationMethod.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbPowerZoneCalculationMethod findValueByNumber(int i) {
            return Types$PbPowerZoneCalculationMethod.forNumber(i);
        }
    };
    private final int value;

    public static final class PbPowerZoneCalculationMethodVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbPowerZoneCalculationMethodVerifier();

        private PbPowerZoneCalculationMethodVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbPowerZoneCalculationMethod.forNumber(i) != null;
        }
    }

    Types$PbPowerZoneCalculationMethod(int i) {
        this.value = i;
    }

    public static Types$PbPowerZoneCalculationMethod forNumber(int i) {
        if (i == 0) {
            return POWER_ZONE_CALCULATION_METHOD_UNKNOWN;
        }
        if (i == 1) {
            return POWER_ZONE_CALCULATION_METHOD_FTP_BASED;
        }
        if (i != 2) {
            return null;
        }
        return POWER_ZONE_CALCULATION_METHOD_MAP_BASED;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbPowerZoneCalculationMethodVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
