package protocol;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import fi.polar.remote.representation.protobuf.Types$PbDate;
import fi.polar.remote.representation.protobuf.Types$PbTime;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class PftpRequest$PbPFtpSetLocalTimeParams extends GeneratedMessageLite<PftpRequest$PbPFtpSetLocalTimeParams, Builder> implements MessageLiteOrBuilder {
    public static final int DATE_FIELD_NUMBER = 1;
    private static final PftpRequest$PbPFtpSetLocalTimeParams DEFAULT_INSTANCE;
    private static volatile Parser<PftpRequest$PbPFtpSetLocalTimeParams> PARSER = null;
    public static final int TIME_FIELD_NUMBER = 2;
    public static final int TZ_OFFSET_FIELD_NUMBER = 3;
    private int bitField0_;
    private Types$PbDate date_;
    private byte memoizedIsInitialized = 2;
    private Types$PbTime time_;
    private int tzOffset_;

    static {
        PftpRequest$PbPFtpSetLocalTimeParams pftpRequest$PbPFtpSetLocalTimeParams = new PftpRequest$PbPFtpSetLocalTimeParams();
        DEFAULT_INSTANCE = pftpRequest$PbPFtpSetLocalTimeParams;
        GeneratedMessageLite.registerDefaultInstance(PftpRequest$PbPFtpSetLocalTimeParams.class, pftpRequest$PbPFtpSetLocalTimeParams);
    }

    private PftpRequest$PbPFtpSetLocalTimeParams() {
    }

    private void clearDate() {
        this.date_ = null;
        this.bitField0_ &= -2;
    }

    private void clearTime() {
        this.time_ = null;
        this.bitField0_ &= -3;
    }

    private void clearTzOffset() {
        this.bitField0_ &= -5;
        this.tzOffset_ = 0;
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams getDefaultInstance() {
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

    public static PftpRequest$PbPFtpSetLocalTimeParams parseDelimitedFrom(InputStream inputStream) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams parseFrom(ByteBuffer byteBuffer) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PftpRequest$PbPFtpSetLocalTimeParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDate(Types$PbDate types$PbDate) {
        types$PbDate.getClass();
        this.date_ = types$PbDate;
        this.bitField0_ |= 1;
    }

    private void setTime(Types$PbTime types$PbTime) {
        types$PbTime.getClass();
        this.time_ = types$PbTime;
        this.bitField0_ |= 2;
    }

    private void setTzOffset(int i) {
        this.bitField0_ |= 4;
        this.tzOffset_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PftpRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PftpRequest$PbPFtpSetLocalTimeParams();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001ᔉ\u0000\u0002ᔉ\u0001\u0003င\u0002", new Object[]{"bitField0_", "date_", "time_", "tzOffset_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PftpRequest$PbPFtpSetLocalTimeParams> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PftpRequest$PbPFtpSetLocalTimeParams.class) {
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

    public Types$PbTime getTime() {
        Types$PbTime types$PbTime = this.time_;
        return types$PbTime == null ? Types$PbTime.getDefaultInstance() : types$PbTime;
    }

    public int getTzOffset() {
        return this.tzOffset_;
    }

    public boolean hasDate() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTime() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasTzOffset() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PftpRequest$PbPFtpSetLocalTimeParams, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PftpRequest$PbPFtpSetLocalTimeParams.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PftpRequest$PbPFtpSetLocalTimeParams pftpRequest$PbPFtpSetLocalTimeParams) {
        return DEFAULT_INSTANCE.createBuilder(pftpRequest$PbPFtpSetLocalTimeParams);
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams parseFrom(ByteString byteString) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams parseFrom(byte[] bArr) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams parseFrom(InputStream inputStream) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams parseFrom(CodedInputStream codedInputStream) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PftpRequest$PbPFtpSetLocalTimeParams parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpSetLocalTimeParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
