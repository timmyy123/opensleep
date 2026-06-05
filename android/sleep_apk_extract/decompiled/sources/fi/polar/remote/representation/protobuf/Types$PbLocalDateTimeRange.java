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
public final class Types$PbLocalDateTimeRange extends GeneratedMessageLite<Types$PbLocalDateTimeRange, Builder> implements MessageLiteOrBuilder {
    private static final Types$PbLocalDateTimeRange DEFAULT_INSTANCE;
    public static final int END_TIME_FIELD_NUMBER = 2;
    private static volatile Parser<Types$PbLocalDateTimeRange> PARSER = null;
    public static final int START_TIME_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbLocalDateTime endTime_;
    private byte memoizedIsInitialized = 2;
    private Types$PbLocalDateTime startTime_;

    static {
        Types$PbLocalDateTimeRange types$PbLocalDateTimeRange = new Types$PbLocalDateTimeRange();
        DEFAULT_INSTANCE = types$PbLocalDateTimeRange;
        GeneratedMessageLite.registerDefaultInstance(Types$PbLocalDateTimeRange.class, types$PbLocalDateTimeRange);
    }

    private Types$PbLocalDateTimeRange() {
    }

    private void clearEndTime() {
        this.endTime_ = null;
        this.bitField0_ &= -3;
    }

    private void clearStartTime() {
        this.startTime_ = null;
        this.bitField0_ &= -2;
    }

    public static Types$PbLocalDateTimeRange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeEndTime(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        Types$PbLocalDateTime types$PbLocalDateTime2 = this.endTime_;
        if (types$PbLocalDateTime2 == null || types$PbLocalDateTime2 == Types$PbLocalDateTime.getDefaultInstance()) {
            this.endTime_ = types$PbLocalDateTime;
        } else {
            this.endTime_ = Types$PbLocalDateTime.newBuilder(this.endTime_).mergeFrom(types$PbLocalDateTime).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    private void mergeStartTime(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        Types$PbLocalDateTime types$PbLocalDateTime2 = this.startTime_;
        if (types$PbLocalDateTime2 == null || types$PbLocalDateTime2 == Types$PbLocalDateTime.getDefaultInstance()) {
            this.startTime_ = types$PbLocalDateTime;
        } else {
            this.startTime_ = Types$PbLocalDateTime.newBuilder(this.startTime_).mergeFrom(types$PbLocalDateTime).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbLocalDateTimeRange parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbLocalDateTimeRange parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbLocalDateTimeRange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setEndTime(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        this.endTime_ = types$PbLocalDateTime;
        this.bitField0_ |= 2;
    }

    private void setStartTime(Types$PbLocalDateTime types$PbLocalDateTime) {
        types$PbLocalDateTime.getClass();
        this.startTime_ = types$PbLocalDateTime;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbLocalDateTimeRange();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᐉ\u0000\u0002ᐉ\u0001", new Object[]{"bitField0_", "startTime_", "endTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbLocalDateTimeRange> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbLocalDateTimeRange.class) {
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

    public Types$PbLocalDateTime getEndTime() {
        Types$PbLocalDateTime types$PbLocalDateTime = this.endTime_;
        return types$PbLocalDateTime == null ? Types$PbLocalDateTime.getDefaultInstance() : types$PbLocalDateTime;
    }

    public Types$PbLocalDateTime getStartTime() {
        Types$PbLocalDateTime types$PbLocalDateTime = this.startTime_;
        return types$PbLocalDateTime == null ? Types$PbLocalDateTime.getDefaultInstance() : types$PbLocalDateTime;
    }

    public boolean hasEndTime() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStartTime() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbLocalDateTimeRange, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbLocalDateTimeRange.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbLocalDateTimeRange types$PbLocalDateTimeRange) {
        return DEFAULT_INSTANCE.createBuilder(types$PbLocalDateTimeRange);
    }

    public static Types$PbLocalDateTimeRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbLocalDateTimeRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbLocalDateTimeRange parseFrom(ByteString byteString) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbLocalDateTimeRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbLocalDateTimeRange parseFrom(byte[] bArr) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbLocalDateTimeRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbLocalDateTimeRange parseFrom(InputStream inputStream) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbLocalDateTimeRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbLocalDateTimeRange parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbLocalDateTimeRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTimeRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
