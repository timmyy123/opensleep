package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum AutomaticSamples$PbMeasTriggerType implements Internal.EnumLite {
    TRIGGER_TYPE_HIGH_ACTIVITY(1),
    TRIGGER_TYPE_LOW_ACTIVITY(2),
    TRIGGER_TYPE_TIMED(3),
    TRIGGER_TYPE_MANUAL(4);

    private static final Internal.EnumLiteMap<AutomaticSamples$PbMeasTriggerType> internalValueMap = new Internal.EnumLiteMap<AutomaticSamples$PbMeasTriggerType>() { // from class: fi.polar.remote.representation.protobuf.AutomaticSamples$PbMeasTriggerType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public AutomaticSamples$PbMeasTriggerType findValueByNumber(int i) {
            return AutomaticSamples$PbMeasTriggerType.forNumber(i);
        }
    };
    private final int value;

    public static final class PbMeasTriggerTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbMeasTriggerTypeVerifier();

        private PbMeasTriggerTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return AutomaticSamples$PbMeasTriggerType.forNumber(i) != null;
        }
    }

    AutomaticSamples$PbMeasTriggerType(int i) {
        this.value = i;
    }

    public static AutomaticSamples$PbMeasTriggerType forNumber(int i) {
        if (i == 1) {
            return TRIGGER_TYPE_HIGH_ACTIVITY;
        }
        if (i == 2) {
            return TRIGGER_TYPE_LOW_ACTIVITY;
        }
        if (i == 3) {
            return TRIGGER_TYPE_TIMED;
        }
        if (i != 4) {
            return null;
        }
        return TRIGGER_TYPE_MANUAL;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbMeasTriggerTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
