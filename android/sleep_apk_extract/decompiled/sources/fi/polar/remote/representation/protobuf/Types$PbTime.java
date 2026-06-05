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
public final class Types$PbTime extends GeneratedMessageLite<Types$PbTime, Builder> implements MessageLiteOrBuilder {
    private static final Types$PbTime DEFAULT_INSTANCE;
    public static final int HOUR_FIELD_NUMBER = 1;
    public static final int MILLIS_FIELD_NUMBER = 4;
    public static final int MINUTE_FIELD_NUMBER = 2;
    private static volatile Parser<Types$PbTime> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 3;
    private int bitField0_;
    private int hour_;
    private byte memoizedIsInitialized = 2;
    private int millis_;
    private int minute_;
    private int seconds_;

    static {
        Types$PbTime types$PbTime = new Types$PbTime();
        DEFAULT_INSTANCE = types$PbTime;
        GeneratedMessageLite.registerDefaultInstance(Types$PbTime.class, types$PbTime);
    }

    private Types$PbTime() {
    }

    private void clearHour() {
        this.bitField0_ &= -2;
        this.hour_ = 0;
    }

    private void clearMillis() {
        this.bitField0_ &= -9;
        this.millis_ = 0;
    }

    private void clearMinute() {
        this.bitField0_ &= -3;
        this.minute_ = 0;
    }

    private void clearSeconds() {
        this.bitField0_ &= -5;
        this.seconds_ = 0;
    }

    public static Types$PbTime getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbTime parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbTime parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbTime> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHour(int i) {
        this.bitField0_ |= 1;
        this.hour_ = i;
    }

    private void setMillis(int i) {
        this.bitField0_ |= 8;
        this.millis_ = i;
    }

    private void setMinute(int i) {
        this.bitField0_ |= 2;
        this.minute_ = i;
    }

    private void setSeconds(int i) {
        this.bitField0_ |= 4;
        this.seconds_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbTime();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0003\u0001ᔋ\u0000\u0002ᔋ\u0001\u0003ᔋ\u0002\u0004ဋ\u0003", new Object[]{"bitField0_", "hour_", "minute_", "seconds_", "millis_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbTime> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbTime.class) {
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

    public int getHour() {
        return this.hour_;
    }

    public int getMillis() {
        return this.millis_;
    }

    public int getMinute() {
        return this.minute_;
    }

    public int getSeconds() {
        return this.seconds_;
    }

    public boolean hasHour() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMillis() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMinute() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSeconds() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbTime, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbTime.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbTime types$PbTime) {
        return DEFAULT_INSTANCE.createBuilder(types$PbTime);
    }

    public static Types$PbTime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbTime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbTime parseFrom(ByteString byteString) {
        return (Types$PbTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbTime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbTime parseFrom(byte[] bArr) {
        return (Types$PbTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbTime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbTime parseFrom(InputStream inputStream) {
        return (Types$PbTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbTime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbTime parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbTime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
