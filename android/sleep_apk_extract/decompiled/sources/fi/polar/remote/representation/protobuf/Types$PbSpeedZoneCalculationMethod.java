package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbSpeedZoneCalculationMethod implements Internal.EnumLite {
    SPEED_ZONE_CALCULATION_METHOD_UNKNOWN(0),
    SPEED_ZONE_CALCULATION_METHOD_SPORT_SPECIFIC_PREDEFINED(1),
    SPEED_ZONE_CALCULATION_METHOD_MAS_BASED(2);

    private static final Internal.EnumLiteMap<Types$PbSpeedZoneCalculationMethod> internalValueMap = new Internal.EnumLiteMap<Types$PbSpeedZoneCalculationMethod>() { // from class: fi.polar.remote.representation.protobuf.Types$PbSpeedZoneCalculationMethod.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbSpeedZoneCalculationMethod findValueByNumber(int i) {
            return Types$PbSpeedZoneCalculationMethod.forNumber(i);
        }
    };
    private final int value;

    public static final class PbSpeedZoneCalculationMethodVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbSpeedZoneCalculationMethodVerifier();

        private PbSpeedZoneCalculationMethodVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbSpeedZoneCalculationMethod.forNumber(i) != null;
        }
    }

    Types$PbSpeedZoneCalculationMethod(int i) {
        this.value = i;
    }

    public static Types$PbSpeedZoneCalculationMethod forNumber(int i) {
        if (i == 0) {
            return SPEED_ZONE_CALCULATION_METHOD_UNKNOWN;
        }
        if (i == 1) {
            return SPEED_ZONE_CALCULATION_METHOD_SPORT_SPECIFIC_PREDEFINED;
        }
        if (i != 2) {
            return null;
        }
        return SPEED_ZONE_CALCULATION_METHOD_MAS_BASED;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbSpeedZoneCalculationMethodVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
