package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbExerciseFeedback implements Internal.EnumLite {
    FEEDBACK_NONE(1),
    FEEDBACK_1(2),
    FEEDBACK_2(3),
    FEEDBACK_3(4),
    FEEDBACK_4(5),
    FEEDBACK_5(6),
    FEEDBACK_6(7),
    FEEDBACK_7(8),
    FEEDBACK_8(9),
    FEEDBACK_9(10),
    FEEDBACK_10(11),
    FEEDBACK_11(12),
    FEEDBACK_12(13),
    FEEDBACK_13(14),
    FEEDBACK_14(15),
    FEEDBACK_15(16),
    FEEDBACK_16(17),
    FEEDBACK_17(18);

    private static final Internal.EnumLiteMap<Types$PbExerciseFeedback> internalValueMap = new Internal.EnumLiteMap<Types$PbExerciseFeedback>() { // from class: fi.polar.remote.representation.protobuf.Types$PbExerciseFeedback.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbExerciseFeedback findValueByNumber(int i) {
            return Types$PbExerciseFeedback.forNumber(i);
        }
    };
    private final int value;

    public static final class PbExerciseFeedbackVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbExerciseFeedbackVerifier();

        private PbExerciseFeedbackVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbExerciseFeedback.forNumber(i) != null;
        }
    }

    Types$PbExerciseFeedback(int i) {
        this.value = i;
    }

    public static Types$PbExerciseFeedback forNumber(int i) {
        switch (i) {
            case 1:
                return FEEDBACK_NONE;
            case 2:
                return FEEDBACK_1;
            case 3:
                return FEEDBACK_2;
            case 4:
                return FEEDBACK_3;
            case 5:
                return FEEDBACK_4;
            case 6:
                return FEEDBACK_5;
            case 7:
                return FEEDBACK_6;
            case 8:
                return FEEDBACK_7;
            case 9:
                return FEEDBACK_8;
            case 10:
                return FEEDBACK_9;
            case 11:
                return FEEDBACK_10;
            case 12:
                return FEEDBACK_11;
            case 13:
                return FEEDBACK_12;
            case 14:
                return FEEDBACK_13;
            case 15:
                return FEEDBACK_14;
            case 16:
                return FEEDBACK_15;
            case 17:
                return FEEDBACK_16;
            case 18:
                return FEEDBACK_17;
            default:
                return null;
        }
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbExerciseFeedbackVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
