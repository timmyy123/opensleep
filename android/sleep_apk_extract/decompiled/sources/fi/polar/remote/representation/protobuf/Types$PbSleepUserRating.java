package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbSleepUserRating implements Internal.EnumLite {
    PB_SLEPT_UNDEFINED(-1),
    PB_SLEPT_POORLY(0),
    PB_SLEPT_SOMEWHAT_POORLY(1),
    PB_SLEPT_NEITHER_POORLY_NOR_WELL(2),
    PB_SLEPT_SOMEWHAT_WELL(3),
    PB_SLEPT_WELL(4);

    private static final Internal.EnumLiteMap<Types$PbSleepUserRating> internalValueMap = new Internal.EnumLiteMap<Types$PbSleepUserRating>() { // from class: fi.polar.remote.representation.protobuf.Types$PbSleepUserRating.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbSleepUserRating findValueByNumber(int i) {
            return Types$PbSleepUserRating.forNumber(i);
        }
    };
    private final int value;

    public static final class PbSleepUserRatingVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbSleepUserRatingVerifier();

        private PbSleepUserRatingVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbSleepUserRating.forNumber(i) != null;
        }
    }

    Types$PbSleepUserRating(int i) {
        this.value = i;
    }

    public static Types$PbSleepUserRating forNumber(int i) {
        if (i == -1) {
            return PB_SLEPT_UNDEFINED;
        }
        if (i == 0) {
            return PB_SLEPT_POORLY;
        }
        if (i == 1) {
            return PB_SLEPT_SOMEWHAT_POORLY;
        }
        if (i == 2) {
            return PB_SLEPT_NEITHER_POORLY_NOR_WELL;
        }
        if (i == 3) {
            return PB_SLEPT_SOMEWHAT_WELL;
        }
        if (i != 4) {
            return null;
        }
        return PB_SLEPT_WELL;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbSleepUserRatingVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
