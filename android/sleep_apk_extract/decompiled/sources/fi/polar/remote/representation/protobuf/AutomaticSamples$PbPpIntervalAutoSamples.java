package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class AutomaticSamples$PbPpIntervalAutoSamples extends GeneratedMessageLite<AutomaticSamples$PbPpIntervalAutoSamples, Builder> implements AutomaticSamples$PbPpIntervalAutoSamplesOrBuilder {
    private static final AutomaticSamples$PbPpIntervalAutoSamples DEFAULT_INSTANCE;
    private static volatile Parser<AutomaticSamples$PbPpIntervalAutoSamples> PARSER = null;
    public static final int PPI_FIELD_NUMBER = 3;
    public static final int RECORDING_TIME_FIELD_NUMBER = 2;
    public static final int TRIGGER_TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private PpIntervals$PbPpIntervalSamples ppi_;
    private Types$PbTime recordingTime_;
    private int triggerType_;

    public enum PbPpIntervalRecordingTriggerType implements Internal.EnumLite {
        PPI_TRIGGER_TYPE_UNDEFINED(0),
        PPI_TRIGGER_TYPE_AUTOMATIC(1),
        PPI_TRIGGER_TYPE_MANUAL(2);

        private static final Internal.EnumLiteMap<PbPpIntervalRecordingTriggerType> internalValueMap = new Internal.EnumLiteMap<PbPpIntervalRecordingTriggerType>() { // from class: fi.polar.remote.representation.protobuf.AutomaticSamples.PbPpIntervalAutoSamples.PbPpIntervalRecordingTriggerType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbPpIntervalRecordingTriggerType findValueByNumber(int i) {
                return PbPpIntervalRecordingTriggerType.forNumber(i);
            }
        };
        private final int value;

        public static final class PbPpIntervalRecordingTriggerTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbPpIntervalRecordingTriggerTypeVerifier();

            private PbPpIntervalRecordingTriggerTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbPpIntervalRecordingTriggerType.forNumber(i) != null;
            }
        }

        PbPpIntervalRecordingTriggerType(int i) {
            this.value = i;
        }

        public static PbPpIntervalRecordingTriggerType forNumber(int i) {
            if (i == 0) {
                return PPI_TRIGGER_TYPE_UNDEFINED;
            }
            if (i == 1) {
                return PPI_TRIGGER_TYPE_AUTOMATIC;
            }
            if (i != 2) {
                return null;
            }
            return PPI_TRIGGER_TYPE_MANUAL;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbPpIntervalRecordingTriggerTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        AutomaticSamples$PbPpIntervalAutoSamples automaticSamples$PbPpIntervalAutoSamples = new AutomaticSamples$PbPpIntervalAutoSamples();
        DEFAULT_INSTANCE = automaticSamples$PbPpIntervalAutoSamples;
        GeneratedMessageLite.registerDefaultInstance(AutomaticSamples$PbPpIntervalAutoSamples.class, automaticSamples$PbPpIntervalAutoSamples);
    }

    private AutomaticSamples$PbPpIntervalAutoSamples() {
    }

    private void clearPpi() {
        this.ppi_ = null;
        this.bitField0_ &= -5;
    }

    private void clearRecordingTime() {
        this.recordingTime_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTriggerType() {
        this.bitField0_ &= -2;
        this.triggerType_ = 0;
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePpi(PpIntervals$PbPpIntervalSamples ppIntervals$PbPpIntervalSamples) {
        ppIntervals$PbPpIntervalSamples.getClass();
        PpIntervals$PbPpIntervalSamples ppIntervals$PbPpIntervalSamples2 = this.ppi_;
        if (ppIntervals$PbPpIntervalSamples2 == null || ppIntervals$PbPpIntervalSamples2 == PpIntervals$PbPpIntervalSamples.getDefaultInstance()) {
            this.ppi_ = ppIntervals$PbPpIntervalSamples;
        } else {
            this.ppi_ = PpIntervals$PbPpIntervalSamples.newBuilder(this.ppi_).mergeFrom(ppIntervals$PbPpIntervalSamples).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    private void mergeRecordingTime(Types$PbTime types$PbTime) {
        types$PbTime.getClass();
        Types$PbTime types$PbTime2 = this.recordingTime_;
        if (types$PbTime2 == null || types$PbTime2 == Types$PbTime.getDefaultInstance()) {
            this.recordingTime_ = types$PbTime;
        } else {
            this.recordingTime_ = Types$PbTime.newBuilder(this.recordingTime_).mergeFrom(types$PbTime).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseDelimitedFrom(InputStream inputStream) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseFrom(ByteBuffer byteBuffer) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AutomaticSamples$PbPpIntervalAutoSamples> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPpi(PpIntervals$PbPpIntervalSamples ppIntervals$PbPpIntervalSamples) {
        ppIntervals$PbPpIntervalSamples.getClass();
        this.ppi_ = ppIntervals$PbPpIntervalSamples;
        this.bitField0_ |= 4;
    }

    private void setRecordingTime(Types$PbTime types$PbTime) {
        types$PbTime.getClass();
        this.recordingTime_ = types$PbTime;
        this.bitField0_ |= 2;
    }

    private void setTriggerType(PbPpIntervalRecordingTriggerType pbPpIntervalRecordingTriggerType) {
        this.triggerType_ = pbPpIntervalRecordingTriggerType.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (AutomaticSamples$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AutomaticSamples$PbPpIntervalAutoSamples();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဌ\u0000\u0002ᐉ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "triggerType_", PbPpIntervalRecordingTriggerType.internalGetVerifier(), "recordingTime_", "ppi_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AutomaticSamples$PbPpIntervalAutoSamples> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AutomaticSamples$PbPpIntervalAutoSamples.class) {
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

    public PpIntervals$PbPpIntervalSamples getPpi() {
        PpIntervals$PbPpIntervalSamples ppIntervals$PbPpIntervalSamples = this.ppi_;
        return ppIntervals$PbPpIntervalSamples == null ? PpIntervals$PbPpIntervalSamples.getDefaultInstance() : ppIntervals$PbPpIntervalSamples;
    }

    public Types$PbTime getRecordingTime() {
        Types$PbTime types$PbTime = this.recordingTime_;
        return types$PbTime == null ? Types$PbTime.getDefaultInstance() : types$PbTime;
    }

    public PbPpIntervalRecordingTriggerType getTriggerType() {
        PbPpIntervalRecordingTriggerType pbPpIntervalRecordingTriggerTypeForNumber = PbPpIntervalRecordingTriggerType.forNumber(this.triggerType_);
        return pbPpIntervalRecordingTriggerTypeForNumber == null ? PbPpIntervalRecordingTriggerType.PPI_TRIGGER_TYPE_UNDEFINED : pbPpIntervalRecordingTriggerTypeForNumber;
    }

    public boolean hasPpi() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasRecordingTime() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTriggerType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AutomaticSamples$PbPpIntervalAutoSamples, Builder> implements AutomaticSamples$PbPpIntervalAutoSamplesOrBuilder {
        private Builder() {
            super(AutomaticSamples$PbPpIntervalAutoSamples.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(AutomaticSamples$PbPpIntervalAutoSamples automaticSamples$PbPpIntervalAutoSamples) {
        return DEFAULT_INSTANCE.createBuilder(automaticSamples$PbPpIntervalAutoSamples);
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseFrom(ByteString byteString) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseFrom(byte[] bArr) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseFrom(InputStream inputStream) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseFrom(CodedInputStream codedInputStream) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AutomaticSamples$PbPpIntervalAutoSamples parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbPpIntervalAutoSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
