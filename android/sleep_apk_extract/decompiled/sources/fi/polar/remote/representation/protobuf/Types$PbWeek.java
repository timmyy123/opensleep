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
public final class Types$PbWeek extends GeneratedMessageLite<Types$PbWeek, Builder> implements MessageLiteOrBuilder {
    private static final Types$PbWeek DEFAULT_INSTANCE;
    private static volatile Parser<Types$PbWeek> PARSER = null;
    public static final int TIME_ZONE_OFFSET_FIELD_NUMBER = 3;
    public static final int WEEK_NUMBER_ISO8601_FIELD_NUMBER = 1;
    public static final int WEEK_START_DAY_FIELD_NUMBER = 4;
    public static final int YEAR_FIELD_NUMBER = 2;
    private int bitField0_;
    private int timeZoneOffset_;
    private int weekNumberISO8601_;
    private int year_;
    private byte memoizedIsInitialized = 2;
    private int weekStartDay_ = 1;

    static {
        Types$PbWeek types$PbWeek = new Types$PbWeek();
        DEFAULT_INSTANCE = types$PbWeek;
        GeneratedMessageLite.registerDefaultInstance(Types$PbWeek.class, types$PbWeek);
    }

    private Types$PbWeek() {
    }

    private void clearTimeZoneOffset() {
        this.bitField0_ &= -5;
        this.timeZoneOffset_ = 0;
    }

    private void clearWeekNumberISO8601() {
        this.bitField0_ &= -2;
        this.weekNumberISO8601_ = 0;
    }

    private void clearWeekStartDay() {
        this.bitField0_ &= -9;
        this.weekStartDay_ = 1;
    }

    private void clearYear() {
        this.bitField0_ &= -3;
        this.year_ = 0;
    }

    public static Types$PbWeek getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbWeek parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbWeek) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbWeek parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbWeek) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbWeek> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setTimeZoneOffset(int i) {
        this.bitField0_ |= 4;
        this.timeZoneOffset_ = i;
    }

    private void setWeekNumberISO8601(int i) {
        this.bitField0_ |= 1;
        this.weekNumberISO8601_ = i;
    }

    private void setWeekStartDay(Types$PbStartDayOfWeek types$PbStartDayOfWeek) {
        this.weekStartDay_ = types$PbStartDayOfWeek.getNumber();
        this.bitField0_ |= 8;
    }

    private void setYear(int i) {
        this.bitField0_ |= 2;
        this.year_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbWeek();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0004\u0001ᔋ\u0000\u0002ᔋ\u0001\u0003ᔄ\u0002\u0004ᔌ\u0003", new Object[]{"bitField0_", "weekNumberISO8601_", "year_", "timeZoneOffset_", "weekStartDay_", Types$PbStartDayOfWeek.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbWeek> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbWeek.class) {
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

    public int getTimeZoneOffset() {
        return this.timeZoneOffset_;
    }

    public int getWeekNumberISO8601() {
        return this.weekNumberISO8601_;
    }

    public Types$PbStartDayOfWeek getWeekStartDay() {
        Types$PbStartDayOfWeek types$PbStartDayOfWeekForNumber = Types$PbStartDayOfWeek.forNumber(this.weekStartDay_);
        return types$PbStartDayOfWeekForNumber == null ? Types$PbStartDayOfWeek.MONDAY : types$PbStartDayOfWeekForNumber;
    }

    public int getYear() {
        return this.year_;
    }

    public boolean hasTimeZoneOffset() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasWeekNumberISO8601() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasWeekStartDay() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasYear() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbWeek, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbWeek.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbWeek types$PbWeek) {
        return DEFAULT_INSTANCE.createBuilder(types$PbWeek);
    }

    public static Types$PbWeek parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbWeek) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbWeek parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbWeek) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbWeek parseFrom(ByteString byteString) {
        return (Types$PbWeek) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbWeek parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbWeek) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbWeek parseFrom(byte[] bArr) {
        return (Types$PbWeek) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbWeek parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbWeek) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbWeek parseFrom(InputStream inputStream) {
        return (Types$PbWeek) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbWeek parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbWeek) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbWeek parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbWeek) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbWeek parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbWeek) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
