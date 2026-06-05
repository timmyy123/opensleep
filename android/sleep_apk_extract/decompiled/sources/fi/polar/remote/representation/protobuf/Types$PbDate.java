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
public final class Types$PbDate extends GeneratedMessageLite<Types$PbDate, Builder> implements MessageLiteOrBuilder {
    public static final int DAY_FIELD_NUMBER = 3;
    private static final Types$PbDate DEFAULT_INSTANCE;
    public static final int MONTH_FIELD_NUMBER = 2;
    private static volatile Parser<Types$PbDate> PARSER = null;
    public static final int YEAR_FIELD_NUMBER = 1;
    private int bitField0_;
    private int day_;
    private byte memoizedIsInitialized = 2;
    private int month_;
    private int year_;

    static {
        Types$PbDate types$PbDate = new Types$PbDate();
        DEFAULT_INSTANCE = types$PbDate;
        GeneratedMessageLite.registerDefaultInstance(Types$PbDate.class, types$PbDate);
    }

    private Types$PbDate() {
    }

    private void clearDay() {
        this.bitField0_ &= -5;
        this.day_ = 0;
    }

    private void clearMonth() {
        this.bitField0_ &= -3;
        this.month_ = 0;
    }

    private void clearYear() {
        this.bitField0_ &= -2;
        this.year_ = 0;
    }

    public static Types$PbDate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbDate parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbDate parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbDate> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDay(int i) {
        this.bitField0_ |= 4;
        this.day_ = i;
    }

    private void setMonth(int i) {
        this.bitField0_ |= 2;
        this.month_ = i;
    }

    private void setYear(int i) {
        this.bitField0_ |= 1;
        this.year_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbDate();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔋ\u0000\u0002ᔋ\u0001\u0003ᔋ\u0002", new Object[]{"bitField0_", "year_", "month_", "day_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbDate> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbDate.class) {
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

    public int getDay() {
        return this.day_;
    }

    public int getMonth() {
        return this.month_;
    }

    public int getYear() {
        return this.year_;
    }

    public boolean hasDay() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasMonth() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasYear() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbDate, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbDate.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbDate types$PbDate) {
        return DEFAULT_INSTANCE.createBuilder(types$PbDate);
    }

    public static Types$PbDate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbDate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbDate parseFrom(ByteString byteString) {
        return (Types$PbDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbDate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbDate parseFrom(byte[] bArr) {
        return (Types$PbDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbDate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbDate parseFrom(InputStream inputStream) {
        return (Types$PbDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbDate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbDate parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbDate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbDate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
