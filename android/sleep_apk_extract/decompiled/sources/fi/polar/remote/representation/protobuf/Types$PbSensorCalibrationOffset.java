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
public final class Types$PbSensorCalibrationOffset extends GeneratedMessageLite<Types$PbSensorCalibrationOffset, Builder> implements Types$PbSensorCalibrationOffsetOrBuilder {
    private static final Types$PbSensorCalibrationOffset DEFAULT_INSTANCE;
    private static volatile Parser<Types$PbSensorCalibrationOffset> PARSER = null;
    public static final int SAMPLE_SOURCE_TYPE_FIELD_NUMBER = 1;
    public static final int SPEED_CAL_OFFSET_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private int sampleSourceType_;
    private float speedCalOffset_;

    static {
        Types$PbSensorCalibrationOffset types$PbSensorCalibrationOffset = new Types$PbSensorCalibrationOffset();
        DEFAULT_INSTANCE = types$PbSensorCalibrationOffset;
        GeneratedMessageLite.registerDefaultInstance(Types$PbSensorCalibrationOffset.class, types$PbSensorCalibrationOffset);
    }

    private Types$PbSensorCalibrationOffset() {
    }

    private void clearSampleSourceType() {
        this.bitField0_ &= -2;
        this.sampleSourceType_ = 0;
    }

    private void clearSpeedCalOffset() {
        this.bitField0_ &= -3;
        this.speedCalOffset_ = 0.0f;
    }

    public static Types$PbSensorCalibrationOffset getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbSensorCalibrationOffset parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbSensorCalibrationOffset parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbSensorCalibrationOffset> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSampleSourceType(Types$PbSampleSourceType types$PbSampleSourceType) {
        this.sampleSourceType_ = types$PbSampleSourceType.getNumber();
        this.bitField0_ |= 1;
    }

    private void setSpeedCalOffset(float f) {
        this.bitField0_ |= 2;
        this.speedCalOffset_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbSensorCalibrationOffset();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ခ\u0001", new Object[]{"bitField0_", "sampleSourceType_", Types$PbSampleSourceType.internalGetVerifier(), "speedCalOffset_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbSensorCalibrationOffset> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbSensorCalibrationOffset.class) {
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

    public Types$PbSampleSourceType getSampleSourceType() {
        Types$PbSampleSourceType types$PbSampleSourceTypeForNumber = Types$PbSampleSourceType.forNumber(this.sampleSourceType_);
        return types$PbSampleSourceTypeForNumber == null ? Types$PbSampleSourceType.SAMPLE_SOURCE_TYPE_UNDEFINED : types$PbSampleSourceTypeForNumber;
    }

    public float getSpeedCalOffset() {
        return this.speedCalOffset_;
    }

    public boolean hasSampleSourceType() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSpeedCalOffset() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbSensorCalibrationOffset, Builder> implements Types$PbSensorCalibrationOffsetOrBuilder {
        private Builder() {
            super(Types$PbSensorCalibrationOffset.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbSensorCalibrationOffset types$PbSensorCalibrationOffset) {
        return DEFAULT_INSTANCE.createBuilder(types$PbSensorCalibrationOffset);
    }

    public static Types$PbSensorCalibrationOffset parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbSensorCalibrationOffset parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbSensorCalibrationOffset parseFrom(ByteString byteString) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbSensorCalibrationOffset parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbSensorCalibrationOffset parseFrom(byte[] bArr) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbSensorCalibrationOffset parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbSensorCalibrationOffset parseFrom(InputStream inputStream) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbSensorCalibrationOffset parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbSensorCalibrationOffset parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbSensorCalibrationOffset parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbSensorCalibrationOffset) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
