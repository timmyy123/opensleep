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
public final class Types$PbLocalDateTime extends GeneratedMessageLite<Types$PbLocalDateTime, Builder> implements Types$PbLocalDateTimeOrBuilder {
    public static final int DATE_FIELD_NUMBER = 1;
    private static final Types$PbLocalDateTime DEFAULT_INSTANCE;
    public static final int OBSOLETE_TRUSTED_FIELD_NUMBER = 3;
    private static volatile Parser<Types$PbLocalDateTime> PARSER = null;
    public static final int TIME_FIELD_NUMBER = 2;
    public static final int TIME_ZONE_OFFSET_FIELD_NUMBER = 4;
    private int bitField0_;
    private Types$PbDate date_;
    private byte memoizedIsInitialized = 2;
    private boolean oBSOLETETrusted_;
    private int timeZoneOffset_;
    private Types$PbTime time_;

    static {
        Types$PbLocalDateTime types$PbLocalDateTime = new Types$PbLocalDateTime();
        DEFAULT_INSTANCE = types$PbLocalDateTime;
        GeneratedMessageLite.registerDefaultInstance(Types$PbLocalDateTime.class, types$PbLocalDateTime);
    }

    private Types$PbLocalDateTime() {
    }

    private void clearDate() {
        this.date_ = null;
        this.bitField0_ &= -2;
    }

    private void clearOBSOLETETrusted() {
        this.bitField0_ &= -5;
        this.oBSOLETETrusted_ = false;
    }

    private void clearTime() {
        this.time_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTimeZoneOffset() {
        this.bitField0_ &= -9;
        this.timeZoneOffset_ = 0;
    }

    public static Types$PbLocalDateTime getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDate(Types$PbDate types$PbDate) {
        types$PbDate.getClass();
        Types$PbDate types$PbDate2 = this.date_;
        if (types$PbDate2 == null || types$PbDate2 == Types$PbDate.getDefaultInstance()) {
            this.date_ = types$PbDate;
        } else {
            this.date_ = Types$PbDate.newBuilder(this.date_).mergeFrom(types$PbDate).buildPartial();
        }
        this.bitField0_ |= 1;
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

    public static Types$PbLocalDateTime parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbLocalDateTime parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbLocalDateTime> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(Types$PbDate types$PbDate) {
        types$PbDate.getClass();
        this.date_ = types$PbDate;
        this.bitField0_ |= 1;
    }

    private void setOBSOLETETrusted(boolean z) {
        this.bitField0_ |= 4;
        this.oBSOLETETrusted_ = z;
    }

    private void setTime(Types$PbTime types$PbTime) {
        types$PbTime.getClass();
        this.time_ = types$PbTime;
        this.bitField0_ |= 2;
    }

    private void setTimeZoneOffset(int i) {
        this.bitField0_ |= 8;
        this.timeZoneOffset_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbLocalDateTime();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0003\u0001ᔉ\u0000\u0002ᔉ\u0001\u0003ᔇ\u0002\u0004င\u0003", new Object[]{"bitField0_", "date_", "time_", "oBSOLETETrusted_", "timeZoneOffset_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbLocalDateTime> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbLocalDateTime.class) {
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

    public Types$PbDate getDate() {
        Types$PbDate types$PbDate = this.date_;
        return types$PbDate == null ? Types$PbDate.getDefaultInstance() : types$PbDate;
    }

    public boolean getOBSOLETETrusted() {
        return this.oBSOLETETrusted_;
    }

    public Types$PbTime getTime() {
        Types$PbTime types$PbTime = this.time_;
        return types$PbTime == null ? Types$PbTime.getDefaultInstance() : types$PbTime;
    }

    public int getTimeZoneOffset() {
        return this.timeZoneOffset_;
    }

    public boolean hasDate() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOBSOLETETrusted() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasTime() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTimeZoneOffset() {
        return (this.bitField0_ & 8) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbLocalDateTime, Builder> implements Types$PbLocalDateTimeOrBuilder {
        private Builder() {
            super(Types$PbLocalDateTime.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbLocalDateTime types$PbLocalDateTime) {
        return DEFAULT_INSTANCE.createBuilder(types$PbLocalDateTime);
    }

    public static Types$PbLocalDateTime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbLocalDateTime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbLocalDateTime parseFrom(ByteString byteString) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbLocalDateTime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbLocalDateTime parseFrom(byte[] bArr) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbLocalDateTime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbLocalDateTime parseFrom(InputStream inputStream) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbLocalDateTime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbLocalDateTime parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbLocalDateTime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbLocalDateTime) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
