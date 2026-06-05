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
public final class Types$PbDuration extends GeneratedMessageLite<Types$PbDuration, Builder> implements Types$PbDurationOrBuilder {
    private static final Types$PbDuration DEFAULT_INSTANCE;
    public static final int HOURS_FIELD_NUMBER = 1;
    public static final int MILLIS_FIELD_NUMBER = 4;
    public static final int MINUTES_FIELD_NUMBER = 2;
    private static volatile Parser<Types$PbDuration> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 3;
    private int bitField0_;
    private int hours_;
    private int millis_;
    private int minutes_;
    private int seconds_;

    static {
        Types$PbDuration types$PbDuration = new Types$PbDuration();
        DEFAULT_INSTANCE = types$PbDuration;
        GeneratedMessageLite.registerDefaultInstance(Types$PbDuration.class, types$PbDuration);
    }

    private Types$PbDuration() {
    }

    private void clearHours() {
        this.bitField0_ &= -2;
        this.hours_ = 0;
    }

    private void clearMillis() {
        this.bitField0_ &= -9;
        this.millis_ = 0;
    }

    private void clearMinutes() {
        this.bitField0_ &= -3;
        this.minutes_ = 0;
    }

    private void clearSeconds() {
        this.bitField0_ &= -5;
        this.seconds_ = 0;
    }

    public static Types$PbDuration getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbDuration parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbDuration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbDuration parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbDuration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbDuration> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHours(int i) {
        this.bitField0_ |= 1;
        this.hours_ = i;
    }

    private void setMillis(int i) {
        this.bitField0_ |= 8;
        this.millis_ = i;
    }

    private void setMinutes(int i) {
        this.bitField0_ |= 2;
        this.minutes_ = i;
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
                return new Types$PbDuration();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003ဋ\u0002\u0004ဋ\u0003", new Object[]{"bitField0_", "hours_", "minutes_", "seconds_", "millis_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbDuration> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbDuration.class) {
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

    public int getHours() {
        return this.hours_;
    }

    public int getMillis() {
        return this.millis_;
    }

    public int getMinutes() {
        return this.minutes_;
    }

    public int getSeconds() {
        return this.seconds_;
    }

    public boolean hasHours() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMillis() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasMinutes() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSeconds() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbDuration, Builder> implements Types$PbDurationOrBuilder {
        private Builder() {
            super(Types$PbDuration.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbDuration types$PbDuration) {
        return DEFAULT_INSTANCE.createBuilder(types$PbDuration);
    }

    public static Types$PbDuration parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDuration) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbDuration parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDuration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbDuration parseFrom(ByteString byteString) {
        return (Types$PbDuration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbDuration parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDuration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbDuration parseFrom(byte[] bArr) {
        return (Types$PbDuration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbDuration parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDuration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbDuration parseFrom(InputStream inputStream) {
        return (Types$PbDuration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbDuration parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDuration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbDuration parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbDuration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbDuration parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDuration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
