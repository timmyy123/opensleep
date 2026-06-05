package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbStartDayOfWeek implements Internal.EnumLite {
    MONDAY(1),
    SATURDAY(2),
    SUNDAY(3);

    private static final Internal.EnumLiteMap<Types$PbStartDayOfWeek> internalValueMap = new Internal.EnumLiteMap<Types$PbStartDayOfWeek>() { // from class: fi.polar.remote.representation.protobuf.Types$PbStartDayOfWeek.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbStartDayOfWeek findValueByNumber(int i) {
            return Types$PbStartDayOfWeek.forNumber(i);
        }
    };
    private final int value;

    public static final class PbStartDayOfWeekVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbStartDayOfWeekVerifier();

        private PbStartDayOfWeekVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbStartDayOfWeek.forNumber(i) != null;
        }
    }

    Types$PbStartDayOfWeek(int i) {
        this.value = i;
    }

    public static Types$PbStartDayOfWeek forNumber(int i) {
        if (i == 1) {
            return MONDAY;
        }
        if (i == 2) {
            return SATURDAY;
        }
        if (i != 3) {
            return null;
        }
        return SUNDAY;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbStartDayOfWeekVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
