package com.polar.services.datamodels.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class TemperatureMeasurement$TemperatureMeasurementSample extends GeneratedMessageLite<TemperatureMeasurement$TemperatureMeasurementSample, Builder> implements TemperatureMeasurement$TemperatureMeasurementSampleOrBuilder {
    private static final TemperatureMeasurement$TemperatureMeasurementSample DEFAULT_INSTANCE;
    private static volatile Parser<TemperatureMeasurement$TemperatureMeasurementSample> PARSER = null;
    public static final int RECORDING_TIME_DELTA_MILLISECONDS_FIELD_NUMBER = 1;
    public static final int TEMPERATURE_CELSIUS_FIELD_NUMBER = 2;
    private long recordingTimeDeltaMilliseconds_;
    private float temperatureCelsius_;

    static {
        TemperatureMeasurement$TemperatureMeasurementSample temperatureMeasurement$TemperatureMeasurementSample = new TemperatureMeasurement$TemperatureMeasurementSample();
        DEFAULT_INSTANCE = temperatureMeasurement$TemperatureMeasurementSample;
        GeneratedMessageLite.registerDefaultInstance(TemperatureMeasurement$TemperatureMeasurementSample.class, temperatureMeasurement$TemperatureMeasurementSample);
    }

    private TemperatureMeasurement$TemperatureMeasurementSample() {
    }

    private void clearRecordingTimeDeltaMilliseconds() {
        this.recordingTimeDeltaMilliseconds_ = 0L;
    }

    private void clearTemperatureCelsius() {
        this.temperatureCelsius_ = 0.0f;
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseDelimitedFrom(InputStream inputStream) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseFrom(ByteBuffer byteBuffer) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TemperatureMeasurement$TemperatureMeasurementSample> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRecordingTimeDeltaMilliseconds(long j) {
        this.recordingTimeDeltaMilliseconds_ = j;
    }

    private void setTemperatureCelsius(float f) {
        this.temperatureCelsius_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (TemperatureMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TemperatureMeasurement$TemperatureMeasurementSample();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0003\u0002\u0001", new Object[]{"recordingTimeDeltaMilliseconds_", "temperatureCelsius_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TemperatureMeasurement$TemperatureMeasurementSample> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TemperatureMeasurement$TemperatureMeasurementSample.class) {
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
                return (byte) 1;
            default:
                Home$$ExternalSyntheticBUOutline0.m$1();
            case 7:
                return null;
        }
    }

    public long getRecordingTimeDeltaMilliseconds() {
        return this.recordingTimeDeltaMilliseconds_;
    }

    public float getTemperatureCelsius() {
        return this.temperatureCelsius_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<TemperatureMeasurement$TemperatureMeasurementSample, Builder> implements TemperatureMeasurement$TemperatureMeasurementSampleOrBuilder {
        private Builder() {
            super(TemperatureMeasurement$TemperatureMeasurementSample.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(TemperatureMeasurement$TemperatureMeasurementSample temperatureMeasurement$TemperatureMeasurementSample) {
        return DEFAULT_INSTANCE.createBuilder(temperatureMeasurement$TemperatureMeasurementSample);
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseFrom(ByteString byteString) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseFrom(byte[] bArr) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseFrom(InputStream inputStream) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseFrom(CodedInputStream codedInputStream) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TemperatureMeasurement$TemperatureMeasurementSample parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementSample) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
