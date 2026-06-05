package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class Types$PbAccelerationMetrics extends GeneratedMessageLite<Types$PbAccelerationMetrics, Builder> implements MessageLiteOrBuilder {
    public static final int CALIBRATION_SETTINGS_FIELD_NUMBER = 2;
    private static final Types$PbAccelerationMetrics DEFAULT_INSTANCE;
    private static volatile Parser<Types$PbAccelerationMetrics> PARSER = null;
    public static final int SAMPLE_SOURCE_TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private int sampleSourceType_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Types$PbCalibrationSettings> calibrationSettings_ = GeneratedMessageLite.emptyProtobufList();

    static {
        Types$PbAccelerationMetrics types$PbAccelerationMetrics = new Types$PbAccelerationMetrics();
        DEFAULT_INSTANCE = types$PbAccelerationMetrics;
        GeneratedMessageLite.registerDefaultInstance(Types$PbAccelerationMetrics.class, types$PbAccelerationMetrics);
    }

    private Types$PbAccelerationMetrics() {
    }

    private void addAllCalibrationSettings(Iterable<? extends Types$PbCalibrationSettings> iterable) {
        ensureCalibrationSettingsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.calibrationSettings_);
    }

    private void addCalibrationSettings(Types$PbCalibrationSettings types$PbCalibrationSettings) {
        types$PbCalibrationSettings.getClass();
        ensureCalibrationSettingsIsMutable();
        this.calibrationSettings_.add(types$PbCalibrationSettings);
    }

    private void clearCalibrationSettings() {
        this.calibrationSettings_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSampleSourceType() {
        this.bitField0_ &= -2;
        this.sampleSourceType_ = 0;
    }

    private void ensureCalibrationSettingsIsMutable() {
        Internal.ProtobufList<Types$PbCalibrationSettings> protobufList = this.calibrationSettings_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.calibrationSettings_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static Types$PbAccelerationMetrics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbAccelerationMetrics parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbAccelerationMetrics parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbAccelerationMetrics> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCalibrationSettings(int i) {
        ensureCalibrationSettingsIsMutable();
        this.calibrationSettings_.remove(i);
    }

    private void setCalibrationSettings(int i, Types$PbCalibrationSettings types$PbCalibrationSettings) {
        types$PbCalibrationSettings.getClass();
        ensureCalibrationSettingsIsMutable();
        this.calibrationSettings_.set(i, types$PbCalibrationSettings);
    }

    private void setSampleSourceType(Types$PbSampleSourceType types$PbSampleSourceType) {
        this.sampleSourceType_ = types$PbSampleSourceType.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbAccelerationMetrics();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0002\u0001ᔌ\u0000\u0002Л", new Object[]{"bitField0_", "sampleSourceType_", Types$PbSampleSourceType.internalGetVerifier(), "calibrationSettings_", Types$PbCalibrationSettings.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbAccelerationMetrics> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbAccelerationMetrics.class) {
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

    public Types$PbCalibrationSettings getCalibrationSettings(int i) {
        return this.calibrationSettings_.get(i);
    }

    public int getCalibrationSettingsCount() {
        return this.calibrationSettings_.size();
    }

    public List<Types$PbCalibrationSettings> getCalibrationSettingsList() {
        return this.calibrationSettings_;
    }

    public Types$PbCalibrationSettingsOrBuilder getCalibrationSettingsOrBuilder(int i) {
        return this.calibrationSettings_.get(i);
    }

    public List<? extends Types$PbCalibrationSettingsOrBuilder> getCalibrationSettingsOrBuilderList() {
        return this.calibrationSettings_;
    }

    public Types$PbSampleSourceType getSampleSourceType() {
        Types$PbSampleSourceType types$PbSampleSourceTypeForNumber = Types$PbSampleSourceType.forNumber(this.sampleSourceType_);
        return types$PbSampleSourceTypeForNumber == null ? Types$PbSampleSourceType.SAMPLE_SOURCE_TYPE_UNDEFINED : types$PbSampleSourceTypeForNumber;
    }

    public boolean hasSampleSourceType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbAccelerationMetrics, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbAccelerationMetrics.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbAccelerationMetrics types$PbAccelerationMetrics) {
        return DEFAULT_INSTANCE.createBuilder(types$PbAccelerationMetrics);
    }

    public static Types$PbAccelerationMetrics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbAccelerationMetrics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbAccelerationMetrics parseFrom(ByteString byteString) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbAccelerationMetrics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addCalibrationSettings(int i, Types$PbCalibrationSettings types$PbCalibrationSettings) {
        types$PbCalibrationSettings.getClass();
        ensureCalibrationSettingsIsMutable();
        this.calibrationSettings_.add(i, types$PbCalibrationSettings);
    }

    public static Types$PbAccelerationMetrics parseFrom(byte[] bArr) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbAccelerationMetrics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbAccelerationMetrics parseFrom(InputStream inputStream) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbAccelerationMetrics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbAccelerationMetrics parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbAccelerationMetrics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbAccelerationMetrics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
