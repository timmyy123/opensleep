package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class PhysData$PbUserTrainingBackground extends GeneratedMessageLite<PhysData$PbUserTrainingBackground, Builder> implements MessageLiteOrBuilder {
    private static final PhysData$PbUserTrainingBackground DEFAULT_INSTANCE;
    public static final int LAST_MODIFIED_FIELD_NUMBER = 2;
    private static volatile Parser<PhysData$PbUserTrainingBackground> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbSystemDateTime lastModified_;
    private byte memoizedIsInitialized = 2;
    private int value_ = 10;

    public enum TrainingBackground implements Internal.EnumLite {
        OCCASIONAL(10),
        REGULAR(20),
        FREQUENT(30),
        HEAVY(40),
        SEMI_PRO(50),
        PRO(60);

        private static final Internal.EnumLiteMap<TrainingBackground> internalValueMap = new Internal.EnumLiteMap<TrainingBackground>() { // from class: fi.polar.remote.representation.protobuf.PhysData.PbUserTrainingBackground.TrainingBackground.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public TrainingBackground findValueByNumber(int i) {
                return TrainingBackground.forNumber(i);
            }
        };
        private final int value;

        public static final class TrainingBackgroundVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new TrainingBackgroundVerifier();

            private TrainingBackgroundVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return TrainingBackground.forNumber(i) != null;
            }
        }

        TrainingBackground(int i) {
            this.value = i;
        }

        public static TrainingBackground forNumber(int i) {
            if (i == 10) {
                return OCCASIONAL;
            }
            if (i == 20) {
                return REGULAR;
            }
            if (i == 30) {
                return FREQUENT;
            }
            if (i == 40) {
                return HEAVY;
            }
            if (i == 50) {
                return SEMI_PRO;
            }
            if (i != 60) {
                return null;
            }
            return PRO;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return TrainingBackgroundVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        PhysData$PbUserTrainingBackground physData$PbUserTrainingBackground = new PhysData$PbUserTrainingBackground();
        DEFAULT_INSTANCE = physData$PbUserTrainingBackground;
        GeneratedMessageLite.registerDefaultInstance(PhysData$PbUserTrainingBackground.class, physData$PbUserTrainingBackground);
    }

    private PhysData$PbUserTrainingBackground() {
    }

    private void clearLastModified() {
        this.lastModified_ = null;
        this.bitField0_ &= -3;
    }

    private void clearValue() {
        this.bitField0_ &= -2;
        this.value_ = 10;
    }

    public static PhysData$PbUserTrainingBackground getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.lastModified_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.lastModified_ = types$PbSystemDateTime;
        } else {
            this.lastModified_ = Types$PbSystemDateTime.newBuilder(this.lastModified_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PhysData$PbUserTrainingBackground parseDelimitedFrom(InputStream inputStream) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserTrainingBackground parseFrom(ByteBuffer byteBuffer) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PhysData$PbUserTrainingBackground> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.lastModified_ = types$PbSystemDateTime;
        this.bitField0_ |= 2;
    }

    private void setValue(TrainingBackground trainingBackground) {
        this.value_ = trainingBackground.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PhysData$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PhysData$PbUserTrainingBackground();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔌ\u0000\u0002ᔉ\u0001", new Object[]{"bitField0_", "value_", TrainingBackground.internalGetVerifier(), "lastModified_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PhysData$PbUserTrainingBackground> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PhysData$PbUserTrainingBackground.class) {
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

    public Types$PbSystemDateTime getLastModified() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.lastModified_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public TrainingBackground getValue() {
        TrainingBackground trainingBackgroundForNumber = TrainingBackground.forNumber(this.value_);
        return trainingBackgroundForNumber == null ? TrainingBackground.OCCASIONAL : trainingBackgroundForNumber;
    }

    public boolean hasLastModified() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PhysData$PbUserTrainingBackground, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PhysData$PbUserTrainingBackground.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PhysData$PbUserTrainingBackground physData$PbUserTrainingBackground) {
        return DEFAULT_INSTANCE.createBuilder(physData$PbUserTrainingBackground);
    }

    public static PhysData$PbUserTrainingBackground parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserTrainingBackground parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PhysData$PbUserTrainingBackground parseFrom(ByteString byteString) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PhysData$PbUserTrainingBackground parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PhysData$PbUserTrainingBackground parseFrom(byte[] bArr) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PhysData$PbUserTrainingBackground parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PhysData$PbUserTrainingBackground parseFrom(InputStream inputStream) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PhysData$PbUserTrainingBackground parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PhysData$PbUserTrainingBackground parseFrom(CodedInputStream codedInputStream) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PhysData$PbUserTrainingBackground parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PhysData$PbUserTrainingBackground) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
