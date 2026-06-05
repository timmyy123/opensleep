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
public final class Types$PbCalibrationSettings extends GeneratedMessageLite<Types$PbCalibrationSettings, Builder> implements Types$PbCalibrationSettingsOrBuilder {
    public static final int CALIBRATION_CALCULATION_ENABLED_FIELD_NUMBER = 3;
    public static final int CALIBRATION_ENABLED_FIELD_NUMBER = 2;
    private static final Types$PbCalibrationSettings DEFAULT_INSTANCE;
    private static volatile Parser<Types$PbCalibrationSettings> PARSER = null;
    public static final int SAMPLE_TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean calibrationCalculationEnabled_;
    private boolean calibrationEnabled_;
    private byte memoizedIsInitialized = 2;
    private int sampleType_;

    static {
        Types$PbCalibrationSettings types$PbCalibrationSettings = new Types$PbCalibrationSettings();
        DEFAULT_INSTANCE = types$PbCalibrationSettings;
        GeneratedMessageLite.registerDefaultInstance(Types$PbCalibrationSettings.class, types$PbCalibrationSettings);
    }

    private Types$PbCalibrationSettings() {
    }

    private void clearCalibrationCalculationEnabled() {
        this.bitField0_ &= -5;
        this.calibrationCalculationEnabled_ = false;
    }

    private void clearCalibrationEnabled() {
        this.bitField0_ &= -3;
        this.calibrationEnabled_ = false;
    }

    private void clearSampleType() {
        this.bitField0_ &= -2;
        this.sampleType_ = 0;
    }

    public static Types$PbCalibrationSettings getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbCalibrationSettings parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbCalibrationSettings parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbCalibrationSettings> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCalibrationCalculationEnabled(boolean z) {
        this.bitField0_ |= 4;
        this.calibrationCalculationEnabled_ = z;
    }

    private void setCalibrationEnabled(boolean z) {
        this.bitField0_ |= 2;
        this.calibrationEnabled_ = z;
    }

    private void setSampleType(Types$PbSampleType types$PbSampleType) {
        this.sampleType_ = types$PbSampleType.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbCalibrationSettings();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002", new Object[]{"bitField0_", "sampleType_", Types$PbSampleType.internalGetVerifier(), "calibrationEnabled_", "calibrationCalculationEnabled_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbCalibrationSettings> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbCalibrationSettings.class) {
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

    public boolean getCalibrationCalculationEnabled() {
        return this.calibrationCalculationEnabled_;
    }

    public boolean getCalibrationEnabled() {
        return this.calibrationEnabled_;
    }

    public Types$PbSampleType getSampleType() {
        Types$PbSampleType types$PbSampleTypeForNumber = Types$PbSampleType.forNumber(this.sampleType_);
        return types$PbSampleTypeForNumber == null ? Types$PbSampleType.SAMPLE_TYPE_UNDEFINED : types$PbSampleTypeForNumber;
    }

    public boolean hasCalibrationCalculationEnabled() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasCalibrationEnabled() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSampleType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbCalibrationSettings, Builder> implements Types$PbCalibrationSettingsOrBuilder {
        private Builder() {
            super(Types$PbCalibrationSettings.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbCalibrationSettings types$PbCalibrationSettings) {
        return DEFAULT_INSTANCE.createBuilder(types$PbCalibrationSettings);
    }

    public static Types$PbCalibrationSettings parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbCalibrationSettings parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbCalibrationSettings parseFrom(ByteString byteString) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbCalibrationSettings parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbCalibrationSettings parseFrom(byte[] bArr) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbCalibrationSettings parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbCalibrationSettings parseFrom(InputStream inputStream) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbCalibrationSettings parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbCalibrationSettings parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbCalibrationSettings parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbCalibrationSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
