package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class SleepanalysisResult$PbSleepWakePhase extends GeneratedMessageLite<SleepanalysisResult$PbSleepWakePhase, Builder> implements SleepanalysisResult$PbSleepWakePhaseOrBuilder {
    private static final SleepanalysisResult$PbSleepWakePhase DEFAULT_INSTANCE;
    private static volatile Parser<SleepanalysisResult$PbSleepWakePhase> PARSER = null;
    public static final int SECONDS_FROM_SLEEP_START_FIELD_NUMBER = 1;
    public static final int SLEEPWAKE_STATE_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int secondsFromSleepStart_;
    private int sleepwakeState_;

    static {
        SleepanalysisResult$PbSleepWakePhase sleepanalysisResult$PbSleepWakePhase = new SleepanalysisResult$PbSleepWakePhase();
        DEFAULT_INSTANCE = sleepanalysisResult$PbSleepWakePhase;
        GeneratedMessageLite.registerDefaultInstance(SleepanalysisResult$PbSleepWakePhase.class, sleepanalysisResult$PbSleepWakePhase);
    }

    private SleepanalysisResult$PbSleepWakePhase() {
    }

    private void clearSecondsFromSleepStart() {
        this.bitField0_ &= -2;
        this.secondsFromSleepStart_ = 0;
    }

    private void clearSleepwakeState() {
        this.bitField0_ &= -3;
        this.sleepwakeState_ = 0;
    }

    public static SleepanalysisResult$PbSleepWakePhase getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static SleepanalysisResult$PbSleepWakePhase parseDelimitedFrom(InputStream inputStream) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SleepanalysisResult$PbSleepWakePhase parseFrom(ByteBuffer byteBuffer) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<SleepanalysisResult$PbSleepWakePhase> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSecondsFromSleepStart(int i) {
        this.bitField0_ |= 1;
        this.secondsFromSleepStart_ = i;
    }

    private void setSleepwakeState(SleepanalysisResult$PbSleepWakeState sleepanalysisResult$PbSleepWakeState) {
        this.sleepwakeState_ = sleepanalysisResult$PbSleepWakeState.getNumber();
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (SleepanalysisResult$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new SleepanalysisResult$PbSleepWakePhase();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔋ\u0000\u0002ᔌ\u0001", new Object[]{"bitField0_", "secondsFromSleepStart_", "sleepwakeState_", SleepanalysisResult$PbSleepWakeState.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SleepanalysisResult$PbSleepWakePhase> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (SleepanalysisResult$PbSleepWakePhase.class) {
                    try {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                this.memoizedIsInitialized = (byte) (obj != null ? 1 : 0);
                return null;
            default:
                Home$$ExternalSyntheticBUOutline0.m$1();
                return null;
        }
    }

    public int getSecondsFromSleepStart() {
        return this.secondsFromSleepStart_;
    }

    public SleepanalysisResult$PbSleepWakeState getSleepwakeState() {
        SleepanalysisResult$PbSleepWakeState sleepanalysisResult$PbSleepWakeStateForNumber = SleepanalysisResult$PbSleepWakeState.forNumber(this.sleepwakeState_);
        return sleepanalysisResult$PbSleepWakeStateForNumber == null ? SleepanalysisResult$PbSleepWakeState.PB_UNKNOWN : sleepanalysisResult$PbSleepWakeStateForNumber;
    }

    public boolean hasSecondsFromSleepStart() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSleepwakeState() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<SleepanalysisResult$PbSleepWakePhase, Builder> implements SleepanalysisResult$PbSleepWakePhaseOrBuilder {
        private Builder() {
            super(SleepanalysisResult$PbSleepWakePhase.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(SleepanalysisResult$PbSleepWakePhase sleepanalysisResult$PbSleepWakePhase) {
        return DEFAULT_INSTANCE.createBuilder(sleepanalysisResult$PbSleepWakePhase);
    }

    public static SleepanalysisResult$PbSleepWakePhase parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepWakePhase parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepWakePhase parseFrom(ByteString byteString) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SleepanalysisResult$PbSleepWakePhase parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepWakePhase parseFrom(byte[] bArr) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SleepanalysisResult$PbSleepWakePhase parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepWakePhase parseFrom(InputStream inputStream) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SleepanalysisResult$PbSleepWakePhase parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SleepanalysisResult$PbSleepWakePhase parseFrom(CodedInputStream codedInputStream) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SleepanalysisResult$PbSleepWakePhase parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (SleepanalysisResult$PbSleepWakePhase) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
