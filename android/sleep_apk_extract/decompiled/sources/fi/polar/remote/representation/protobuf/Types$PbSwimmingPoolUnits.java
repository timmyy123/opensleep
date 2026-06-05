package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbSwimmingPoolUnits implements Internal.EnumLite {
    SWIMMING_POOL_METERS(0),
    SWIMMING_POOL_YARDS(1);

    private static final Internal.EnumLiteMap<Types$PbSwimmingPoolUnits> internalValueMap = new Internal.EnumLiteMap<Types$PbSwimmingPoolUnits>() { // from class: fi.polar.remote.representation.protobuf.Types$PbSwimmingPoolUnits.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbSwimmingPoolUnits findValueByNumber(int i) {
            return Types$PbSwimmingPoolUnits.forNumber(i);
        }
    };
    private final int value;

    public static final class PbSwimmingPoolUnitsVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbSwimmingPoolUnitsVerifier();

        private PbSwimmingPoolUnitsVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbSwimmingPoolUnits.forNumber(i) != null;
        }
    }

    Types$PbSwimmingPoolUnits(int i) {
        this.value = i;
    }

    public static Types$PbSwimmingPoolUnits forNumber(int i) {
        if (i == 0) {
            return SWIMMING_POOL_METERS;
        }
        if (i != 1) {
            return null;
        }
        return SWIMMING_POOL_YARDS;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbSwimmingPoolUnitsVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
