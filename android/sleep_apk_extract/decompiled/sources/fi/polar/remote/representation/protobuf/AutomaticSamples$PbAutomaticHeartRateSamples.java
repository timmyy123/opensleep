package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class AutomaticSamples$PbAutomaticHeartRateSamples extends GeneratedMessageLite<AutomaticSamples$PbAutomaticHeartRateSamples, Builder> implements AutomaticSamples$PbAutomaticHeartRateSamplesOrBuilder {
    private static final AutomaticSamples$PbAutomaticHeartRateSamples DEFAULT_INSTANCE;
    public static final int HEART_RATE_FIELD_NUMBER = 3;
    private static volatile Parser<AutomaticSamples$PbAutomaticHeartRateSamples> PARSER = null;
    public static final int TIME_FIELD_NUMBER = 2;
    public static final int TRIGGER_TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbTime time_;
    private int heartRateMemoizedSerializedSize = -1;
    private byte memoizedIsInitialized = 2;
    private int triggerType_ = 1;
    private Internal.IntList heartRate_ = GeneratedMessageLite.emptyIntList();

    static {
        AutomaticSamples$PbAutomaticHeartRateSamples automaticSamples$PbAutomaticHeartRateSamples = new AutomaticSamples$PbAutomaticHeartRateSamples();
        DEFAULT_INSTANCE = automaticSamples$PbAutomaticHeartRateSamples;
        GeneratedMessageLite.registerDefaultInstance(AutomaticSamples$PbAutomaticHeartRateSamples.class, automaticSamples$PbAutomaticHeartRateSamples);
    }

    private AutomaticSamples$PbAutomaticHeartRateSamples() {
    }

    private void addAllHeartRate(Iterable<? extends Integer> iterable) {
        ensureHeartRateIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.heartRate_);
    }

    private void addHeartRate(int i) {
        ensureHeartRateIsMutable();
        this.heartRate_.addInt(i);
    }

    private void clearHeartRate() {
        this.heartRate_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearTime() {
        this.time_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTriggerType() {
        this.bitField0_ &= -2;
        this.triggerType_ = 1;
    }

    private void ensureHeartRateIsMutable() {
        Internal.IntList intList = this.heartRate_;
        if (intList.isModifiable()) {
            return;
        }
        this.heartRate_ = GeneratedMessageLite.mutableCopy(intList);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeTime(Types$PbTime types$PbTime) {
        types$PbTime.getClass();
        Types$PbTime types$PbTime2 = this.time_;
        if (types$PbTime2 == null || types$PbTime2 == Types$PbTime.getDefaultInstance()) {
            this.time_ = types$PbTime;
        } else {
            this.time_ = Types$PbTime.newBuilder(this.time_).mergeFrom(types$PbTime).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseDelimitedFrom(InputStream inputStream) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseFrom(ByteBuffer byteBuffer) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AutomaticSamples$PbAutomaticHeartRateSamples> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHeartRate(int i, int i2) {
        ensureHeartRateIsMutable();
        this.heartRate_.setInt(i, i2);
    }

    private void setTime(Types$PbTime types$PbTime) {
        types$PbTime.getClass();
        this.time_ = types$PbTime;
        this.bitField0_ |= 2;
    }

    private void setTriggerType(AutomaticSamples$PbMeasTriggerType automaticSamples$PbMeasTriggerType) {
        this.triggerType_ = automaticSamples$PbMeasTriggerType.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (AutomaticSamples$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AutomaticSamples$PbAutomaticHeartRateSamples();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001ᔌ\u0000\u0002ᔉ\u0001\u0003+", new Object[]{"bitField0_", "triggerType_", AutomaticSamples$PbMeasTriggerType.internalGetVerifier(), "time_", "heartRate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AutomaticSamples$PbAutomaticHeartRateSamples> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (AutomaticSamples$PbAutomaticHeartRateSamples.class) {
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

    public int getHeartRate(int i) {
        return this.heartRate_.getInt(i);
    }

    public int getHeartRateCount() {
        return this.heartRate_.size();
    }

    public List<Integer> getHeartRateList() {
        return this.heartRate_;
    }

    public Types$PbTime getTime() {
        Types$PbTime types$PbTime = this.time_;
        return types$PbTime == null ? Types$PbTime.getDefaultInstance() : types$PbTime;
    }

    public AutomaticSamples$PbMeasTriggerType getTriggerType() {
        AutomaticSamples$PbMeasTriggerType automaticSamples$PbMeasTriggerTypeForNumber = AutomaticSamples$PbMeasTriggerType.forNumber(this.triggerType_);
        return automaticSamples$PbMeasTriggerTypeForNumber == null ? AutomaticSamples$PbMeasTriggerType.TRIGGER_TYPE_HIGH_ACTIVITY : automaticSamples$PbMeasTriggerTypeForNumber;
    }

    public boolean hasTime() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTriggerType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<AutomaticSamples$PbAutomaticHeartRateSamples, Builder> implements AutomaticSamples$PbAutomaticHeartRateSamplesOrBuilder {
        private Builder() {
            super(AutomaticSamples$PbAutomaticHeartRateSamples.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(AutomaticSamples$PbAutomaticHeartRateSamples automaticSamples$PbAutomaticHeartRateSamples) {
        return DEFAULT_INSTANCE.createBuilder(automaticSamples$PbAutomaticHeartRateSamples);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseFrom(ByteString byteString) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseFrom(byte[] bArr) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseFrom(InputStream inputStream) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseFrom(CodedInputStream codedInputStream) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AutomaticSamples$PbAutomaticHeartRateSamples parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AutomaticSamples$PbAutomaticHeartRateSamples) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
