package com.polar.services.datamodels.protobuf;

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

/* JADX INFO: loaded from: classes4.dex */
public final class TemperatureMeasurement$TemperatureMeasurementPeriod extends GeneratedMessageLite<TemperatureMeasurement$TemperatureMeasurementPeriod, Builder> implements MessageLiteOrBuilder {
    private static final TemperatureMeasurement$TemperatureMeasurementPeriod DEFAULT_INSTANCE;
    public static final int MEASUREMENT_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<TemperatureMeasurement$TemperatureMeasurementPeriod> PARSER = null;
    public static final int SENSOR_LOCATION_FIELD_NUMBER = 3;
    public static final int SOURCE_DEVICE_ID_FIELD_NUMBER = 2;
    public static final int TEMPERATURE_MEASUREMENT_SAMPLES_FIELD_NUMBER = 4;
    private int measurementType_;
    private int sensorLocation_;
    private String sourceDeviceId_ = "";
    private Internal.ProtobufList<TemperatureMeasurement$TemperatureMeasurementSample> temperatureMeasurementSamples_ = GeneratedMessageLite.emptyProtobufList();

    static {
        TemperatureMeasurement$TemperatureMeasurementPeriod temperatureMeasurement$TemperatureMeasurementPeriod = new TemperatureMeasurement$TemperatureMeasurementPeriod();
        DEFAULT_INSTANCE = temperatureMeasurement$TemperatureMeasurementPeriod;
        GeneratedMessageLite.registerDefaultInstance(TemperatureMeasurement$TemperatureMeasurementPeriod.class, temperatureMeasurement$TemperatureMeasurementPeriod);
    }

    private TemperatureMeasurement$TemperatureMeasurementPeriod() {
    }

    private void addAllTemperatureMeasurementSamples(Iterable<? extends TemperatureMeasurement$TemperatureMeasurementSample> iterable) {
        ensureTemperatureMeasurementSamplesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.temperatureMeasurementSamples_);
    }

    private void addTemperatureMeasurementSamples(TemperatureMeasurement$TemperatureMeasurementSample temperatureMeasurement$TemperatureMeasurementSample) {
        temperatureMeasurement$TemperatureMeasurementSample.getClass();
        ensureTemperatureMeasurementSamplesIsMutable();
        this.temperatureMeasurementSamples_.add(temperatureMeasurement$TemperatureMeasurementSample);
    }

    private void clearMeasurementType() {
        this.measurementType_ = 0;
    }

    private void clearSensorLocation() {
        this.sensorLocation_ = 0;
    }

    private void clearSourceDeviceId() {
        this.sourceDeviceId_ = getDefaultInstance().getSourceDeviceId();
    }

    private void clearTemperatureMeasurementSamples() {
        this.temperatureMeasurementSamples_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureTemperatureMeasurementSamplesIsMutable() {
        Internal.ProtobufList<TemperatureMeasurement$TemperatureMeasurementSample> protobufList = this.temperatureMeasurementSamples_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.temperatureMeasurementSamples_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseDelimitedFrom(InputStream inputStream) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseFrom(ByteBuffer byteBuffer) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TemperatureMeasurement$TemperatureMeasurementPeriod> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeTemperatureMeasurementSamples(int i) {
        ensureTemperatureMeasurementSamplesIsMutable();
        this.temperatureMeasurementSamples_.remove(i);
    }

    private void setMeasurementType(Types$TemperatureMeasurementType types$TemperatureMeasurementType) {
        this.measurementType_ = types$TemperatureMeasurementType.getNumber();
    }

    private void setMeasurementTypeValue(int i) {
        this.measurementType_ = i;
    }

    private void setSensorLocation(Types$SensorLocation types$SensorLocation) {
        this.sensorLocation_ = types$SensorLocation.getNumber();
    }

    private void setSensorLocationValue(int i) {
        this.sensorLocation_ = i;
    }

    private void setSourceDeviceId(String str) {
        str.getClass();
        this.sourceDeviceId_ = str;
    }

    private void setSourceDeviceIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.sourceDeviceId_ = byteString.toStringUtf8();
    }

    private void setTemperatureMeasurementSamples(int i, TemperatureMeasurement$TemperatureMeasurementSample temperatureMeasurement$TemperatureMeasurementSample) {
        temperatureMeasurement$TemperatureMeasurementSample.getClass();
        ensureTemperatureMeasurementSamplesIsMutable();
        this.temperatureMeasurementSamples_.set(i, temperatureMeasurement$TemperatureMeasurementSample);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (TemperatureMeasurement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TemperatureMeasurement$TemperatureMeasurementPeriod();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001\f\u0002Ȉ\u0003\f\u0004\u001b", new Object[]{"measurementType_", "sourceDeviceId_", "sensorLocation_", "temperatureMeasurementSamples_", TemperatureMeasurement$TemperatureMeasurementSample.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TemperatureMeasurement$TemperatureMeasurementPeriod> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TemperatureMeasurement$TemperatureMeasurementPeriod.class) {
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

    public Types$TemperatureMeasurementType getMeasurementType() {
        Types$TemperatureMeasurementType types$TemperatureMeasurementTypeForNumber = Types$TemperatureMeasurementType.forNumber(this.measurementType_);
        return types$TemperatureMeasurementTypeForNumber == null ? Types$TemperatureMeasurementType.UNRECOGNIZED : types$TemperatureMeasurementTypeForNumber;
    }

    public int getMeasurementTypeValue() {
        return this.measurementType_;
    }

    public Types$SensorLocation getSensorLocation() {
        Types$SensorLocation types$SensorLocationForNumber = Types$SensorLocation.forNumber(this.sensorLocation_);
        return types$SensorLocationForNumber == null ? Types$SensorLocation.UNRECOGNIZED : types$SensorLocationForNumber;
    }

    public int getSensorLocationValue() {
        return this.sensorLocation_;
    }

    public String getSourceDeviceId() {
        return this.sourceDeviceId_;
    }

    public ByteString getSourceDeviceIdBytes() {
        return ByteString.copyFromUtf8(this.sourceDeviceId_);
    }

    public TemperatureMeasurement$TemperatureMeasurementSample getTemperatureMeasurementSamples(int i) {
        return this.temperatureMeasurementSamples_.get(i);
    }

    public int getTemperatureMeasurementSamplesCount() {
        return this.temperatureMeasurementSamples_.size();
    }

    public List<TemperatureMeasurement$TemperatureMeasurementSample> getTemperatureMeasurementSamplesList() {
        return this.temperatureMeasurementSamples_;
    }

    public TemperatureMeasurement$TemperatureMeasurementSampleOrBuilder getTemperatureMeasurementSamplesOrBuilder(int i) {
        return this.temperatureMeasurementSamples_.get(i);
    }

    public List<? extends TemperatureMeasurement$TemperatureMeasurementSampleOrBuilder> getTemperatureMeasurementSamplesOrBuilderList() {
        return this.temperatureMeasurementSamples_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<TemperatureMeasurement$TemperatureMeasurementPeriod, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(TemperatureMeasurement$TemperatureMeasurementPeriod.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(TemperatureMeasurement$TemperatureMeasurementPeriod temperatureMeasurement$TemperatureMeasurementPeriod) {
        return DEFAULT_INSTANCE.createBuilder(temperatureMeasurement$TemperatureMeasurementPeriod);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseFrom(ByteString byteString) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addTemperatureMeasurementSamples(int i, TemperatureMeasurement$TemperatureMeasurementSample temperatureMeasurement$TemperatureMeasurementSample) {
        temperatureMeasurement$TemperatureMeasurementSample.getClass();
        ensureTemperatureMeasurementSamplesIsMutable();
        this.temperatureMeasurementSamples_.add(i, temperatureMeasurement$TemperatureMeasurementSample);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseFrom(byte[] bArr) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseFrom(InputStream inputStream) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseFrom(CodedInputStream codedInputStream) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TemperatureMeasurement$TemperatureMeasurementPeriod parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TemperatureMeasurement$TemperatureMeasurementPeriod) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
