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
public final class Types$PbStrideSensorCalibSettings extends GeneratedMessageLite<Types$PbStrideSensorCalibSettings, Builder> implements MessageLiteOrBuilder {
    public static final int CALIB_TYPE_FIELD_NUMBER = 2;
    private static final Types$PbStrideSensorCalibSettings DEFAULT_INSTANCE;
    private static volatile Parser<Types$PbStrideSensorCalibSettings> PARSER = null;
    public static final int RUNNING_FACTOR_FIELD_NUMBER = 1;
    public static final int RUNNING_FACTOR_SOURCE_FIELD_NUMBER = 3;
    private int bitField0_;
    private int calibType_;
    private byte memoizedIsInitialized = 2;
    private int runningFactorSource_;
    private float runningFactor_;

    public enum PbRunningFactorSource implements Internal.EnumLite {
        RUNNING_FACTOR_SOURCE_DEFAULT(0),
        RUNNING_FACTOR_SOURCE_AUTO_CALIBRATION(1),
        RUNNING_FACTOR_SOURCE_MANUAL_CALIBRATION(2);

        private static final Internal.EnumLiteMap<PbRunningFactorSource> internalValueMap = new Internal.EnumLiteMap<PbRunningFactorSource>() { // from class: fi.polar.remote.representation.protobuf.Types.PbStrideSensorCalibSettings.PbRunningFactorSource.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbRunningFactorSource findValueByNumber(int i) {
                return PbRunningFactorSource.forNumber(i);
            }
        };
        private final int value;

        public static final class PbRunningFactorSourceVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbRunningFactorSourceVerifier();

            private PbRunningFactorSourceVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbRunningFactorSource.forNumber(i) != null;
            }
        }

        PbRunningFactorSource(int i) {
            this.value = i;
        }

        public static PbRunningFactorSource forNumber(int i) {
            if (i == 0) {
                return RUNNING_FACTOR_SOURCE_DEFAULT;
            }
            if (i == 1) {
                return RUNNING_FACTOR_SOURCE_AUTO_CALIBRATION;
            }
            if (i != 2) {
                return null;
            }
            return RUNNING_FACTOR_SOURCE_MANUAL_CALIBRATION;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbRunningFactorSourceVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    public enum PbStrideCalibType implements Internal.EnumLite {
        STRIDE_CALIB_MANUAL(0),
        STRIDE_CALIB_AUTO(1);

        private static final Internal.EnumLiteMap<PbStrideCalibType> internalValueMap = new Internal.EnumLiteMap<PbStrideCalibType>() { // from class: fi.polar.remote.representation.protobuf.Types.PbStrideSensorCalibSettings.PbStrideCalibType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbStrideCalibType findValueByNumber(int i) {
                return PbStrideCalibType.forNumber(i);
            }
        };
        private final int value;

        public static final class PbStrideCalibTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbStrideCalibTypeVerifier();

            private PbStrideCalibTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbStrideCalibType.forNumber(i) != null;
            }
        }

        PbStrideCalibType(int i) {
            this.value = i;
        }

        public static PbStrideCalibType forNumber(int i) {
            if (i == 0) {
                return STRIDE_CALIB_MANUAL;
            }
            if (i != 1) {
                return null;
            }
            return STRIDE_CALIB_AUTO;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbStrideCalibTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        Types$PbStrideSensorCalibSettings types$PbStrideSensorCalibSettings = new Types$PbStrideSensorCalibSettings();
        DEFAULT_INSTANCE = types$PbStrideSensorCalibSettings;
        GeneratedMessageLite.registerDefaultInstance(Types$PbStrideSensorCalibSettings.class, types$PbStrideSensorCalibSettings);
    }

    private Types$PbStrideSensorCalibSettings() {
    }

    private void clearCalibType() {
        this.bitField0_ &= -3;
        this.calibType_ = 0;
    }

    private void clearRunningFactor() {
        this.bitField0_ &= -2;
        this.runningFactor_ = 0.0f;
    }

    private void clearRunningFactorSource() {
        this.bitField0_ &= -5;
        this.runningFactorSource_ = 0;
    }

    public static Types$PbStrideSensorCalibSettings getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbStrideSensorCalibSettings parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbStrideSensorCalibSettings parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbStrideSensorCalibSettings> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCalibType(PbStrideCalibType pbStrideCalibType) {
        this.calibType_ = pbStrideCalibType.getNumber();
        this.bitField0_ |= 2;
    }

    private void setRunningFactor(float f) {
        this.bitField0_ |= 1;
        this.runningFactor_ = f;
    }

    private void setRunningFactorSource(PbRunningFactorSource pbRunningFactorSource) {
        this.runningFactorSource_ = pbRunningFactorSource.getNumber();
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbStrideSensorCalibSettings();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001ᔁ\u0000\u0002ᔌ\u0001\u0003ဌ\u0002", new Object[]{"bitField0_", "runningFactor_", "calibType_", PbStrideCalibType.internalGetVerifier(), "runningFactorSource_", PbRunningFactorSource.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbStrideSensorCalibSettings> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbStrideSensorCalibSettings.class) {
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

    public PbStrideCalibType getCalibType() {
        PbStrideCalibType pbStrideCalibTypeForNumber = PbStrideCalibType.forNumber(this.calibType_);
        return pbStrideCalibTypeForNumber == null ? PbStrideCalibType.STRIDE_CALIB_MANUAL : pbStrideCalibTypeForNumber;
    }

    public float getRunningFactor() {
        return this.runningFactor_;
    }

    public PbRunningFactorSource getRunningFactorSource() {
        PbRunningFactorSource pbRunningFactorSourceForNumber = PbRunningFactorSource.forNumber(this.runningFactorSource_);
        return pbRunningFactorSourceForNumber == null ? PbRunningFactorSource.RUNNING_FACTOR_SOURCE_DEFAULT : pbRunningFactorSourceForNumber;
    }

    public boolean hasCalibType() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRunningFactor() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRunningFactorSource() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbStrideSensorCalibSettings, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbStrideSensorCalibSettings.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbStrideSensorCalibSettings types$PbStrideSensorCalibSettings) {
        return DEFAULT_INSTANCE.createBuilder(types$PbStrideSensorCalibSettings);
    }

    public static Types$PbStrideSensorCalibSettings parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbStrideSensorCalibSettings parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbStrideSensorCalibSettings parseFrom(ByteString byteString) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbStrideSensorCalibSettings parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbStrideSensorCalibSettings parseFrom(byte[] bArr) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbStrideSensorCalibSettings parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbStrideSensorCalibSettings parseFrom(InputStream inputStream) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbStrideSensorCalibSettings parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbStrideSensorCalibSettings parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbStrideSensorCalibSettings parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbStrideSensorCalibSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
