package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class TrainingSession$PbSessionHeartRateStatistics extends GeneratedMessageLite<TrainingSession$PbSessionHeartRateStatistics, Builder> implements MessageLiteOrBuilder {
    public static final int AVERAGE_FIELD_NUMBER = 1;
    private static final TrainingSession$PbSessionHeartRateStatistics DEFAULT_INSTANCE;
    public static final int MAXIMUM_FIELD_NUMBER = 2;
    private static volatile Parser<TrainingSession$PbSessionHeartRateStatistics> PARSER;
    private int average_;
    private int bitField0_;
    private int maximum_;

    static {
        TrainingSession$PbSessionHeartRateStatistics trainingSession$PbSessionHeartRateStatistics = new TrainingSession$PbSessionHeartRateStatistics();
        DEFAULT_INSTANCE = trainingSession$PbSessionHeartRateStatistics;
        GeneratedMessageLite.registerDefaultInstance(TrainingSession$PbSessionHeartRateStatistics.class, trainingSession$PbSessionHeartRateStatistics);
    }

    private TrainingSession$PbSessionHeartRateStatistics() {
    }

    private void clearAverage() {
        this.bitField0_ &= -2;
        this.average_ = 0;
    }

    private void clearMaximum() {
        this.bitField0_ &= -3;
        this.maximum_ = 0;
    }

    public static TrainingSession$PbSessionHeartRateStatistics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseDelimitedFrom(InputStream inputStream) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseFrom(ByteBuffer byteBuffer) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<TrainingSession$PbSessionHeartRateStatistics> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setAverage(int i) {
        this.bitField0_ |= 1;
        this.average_ = i;
    }

    private void setMaximum(int i) {
        this.bitField0_ |= 2;
        this.maximum_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (TrainingSession$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TrainingSession$PbSessionHeartRateStatistics();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001", new Object[]{"bitField0_", "average_", "maximum_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TrainingSession$PbSessionHeartRateStatistics> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (TrainingSession$PbSessionHeartRateStatistics.class) {
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

    public int getAverage() {
        return this.average_;
    }

    public int getMaximum() {
        return this.maximum_;
    }

    public boolean hasAverage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMaximum() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<TrainingSession$PbSessionHeartRateStatistics, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(TrainingSession$PbSessionHeartRateStatistics.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(TrainingSession$PbSessionHeartRateStatistics trainingSession$PbSessionHeartRateStatistics) {
        return DEFAULT_INSTANCE.createBuilder(trainingSession$PbSessionHeartRateStatistics);
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseFrom(ByteString byteString) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseFrom(byte[] bArr) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseFrom(InputStream inputStream) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseFrom(CodedInputStream codedInputStream) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TrainingSession$PbSessionHeartRateStatistics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (TrainingSession$PbSessionHeartRateStatistics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
