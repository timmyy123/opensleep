package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum SleepanalysisResult$PbSleepWakeState implements Internal.EnumLite {
    PB_UNKNOWN(0),
    PB_WAKE(-2),
    PB_REM(-3),
    PB_NONREM12(-5),
    PB_NONREM3(-6);

    private static final Internal.EnumLiteMap<SleepanalysisResult$PbSleepWakeState> internalValueMap = new Internal.EnumLiteMap<SleepanalysisResult$PbSleepWakeState>() { // from class: fi.polar.remote.representation.protobuf.SleepanalysisResult$PbSleepWakeState.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public SleepanalysisResult$PbSleepWakeState findValueByNumber(int i) {
            return SleepanalysisResult$PbSleepWakeState.forNumber(i);
        }
    };
    private final int value;

    public static final class PbSleepWakeStateVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbSleepWakeStateVerifier();

        private PbSleepWakeStateVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return SleepanalysisResult$PbSleepWakeState.forNumber(i) != null;
        }
    }

    SleepanalysisResult$PbSleepWakeState(int i) {
        this.value = i;
    }

    public static SleepanalysisResult$PbSleepWakeState forNumber(int i) {
        if (i == -6) {
            return PB_NONREM3;
        }
        if (i == -5) {
            return PB_NONREM12;
        }
        if (i == -3) {
            return PB_REM;
        }
        if (i == -2) {
            return PB_WAKE;
        }
        if (i != 0) {
            return null;
        }
        return PB_UNKNOWN;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbSleepWakeStateVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
