package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbSessionRPE implements Internal.EnumLite {
    RPE_NONE(1),
    RPE_EASY(2),
    RPE_LIGHT(3),
    RPE_FAIRLY_BRISK(4),
    RPE_BRISK(5),
    RPE_MODERATE(6),
    RPE_FAIRLY_HARD(7),
    RPE_HARD(8),
    RPE_EXHAUSTING(9),
    RPE_EXTREME(10);

    private static final Internal.EnumLiteMap<Types$PbSessionRPE> internalValueMap = new Internal.EnumLiteMap<Types$PbSessionRPE>() { // from class: fi.polar.remote.representation.protobuf.Types$PbSessionRPE.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbSessionRPE findValueByNumber(int i) {
            return Types$PbSessionRPE.forNumber(i);
        }
    };
    private final int value;

    public static final class PbSessionRPEVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbSessionRPEVerifier();

        private PbSessionRPEVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbSessionRPE.forNumber(i) != null;
        }
    }

    Types$PbSessionRPE(int i) {
        this.value = i;
    }

    public static Types$PbSessionRPE forNumber(int i) {
        switch (i) {
            case 1:
                return RPE_NONE;
            case 2:
                return RPE_EASY;
            case 3:
                return RPE_LIGHT;
            case 4:
                return RPE_FAIRLY_BRISK;
            case 5:
                return RPE_BRISK;
            case 6:
                return RPE_MODERATE;
            case 7:
                return RPE_FAIRLY_HARD;
            case 8:
                return RPE_HARD;
            case 9:
                return RPE_EXHAUSTING;
            case 10:
                return RPE_EXTREME;
            default:
                return null;
        }
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbSessionRPEVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
