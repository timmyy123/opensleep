package protocol;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import fi.polar.remote.representation.protobuf.Types$PbDuration;
import fi.polar.remote.representation.protobuf.Types$PbSampleType;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class PftpRequest$PbPFtpRequestStartRecordingParams extends GeneratedMessageLite<PftpRequest$PbPFtpRequestStartRecordingParams, Builder> implements MessageLiteOrBuilder {
    private static final PftpRequest$PbPFtpRequestStartRecordingParams DEFAULT_INSTANCE;
    private static volatile Parser<PftpRequest$PbPFtpRequestStartRecordingParams> PARSER = null;
    public static final int RECORDING_INTERVAL_FIELD_NUMBER = 2;
    public static final int SAMPLE_DATA_IDENTIFIER_FIELD_NUMBER = 3;
    public static final int SAMPLE_TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbDuration recordingInterval_;
    private int sampleType_;
    private byte memoizedIsInitialized = 2;
    private String sampleDataIdentifier_ = "";

    static {
        PftpRequest$PbPFtpRequestStartRecordingParams pftpRequest$PbPFtpRequestStartRecordingParams = new PftpRequest$PbPFtpRequestStartRecordingParams();
        DEFAULT_INSTANCE = pftpRequest$PbPFtpRequestStartRecordingParams;
        GeneratedMessageLite.registerDefaultInstance(PftpRequest$PbPFtpRequestStartRecordingParams.class, pftpRequest$PbPFtpRequestStartRecordingParams);
    }

    private PftpRequest$PbPFtpRequestStartRecordingParams() {
    }

    private void clearRecordingInterval() {
        this.recordingInterval_ = null;
        this.bitField0_ &= -3;
    }

    private void clearSampleDataIdentifier() {
        this.bitField0_ &= -5;
        this.sampleDataIdentifier_ = getDefaultInstance().getSampleDataIdentifier();
    }

    private void clearSampleType() {
        this.bitField0_ &= -2;
        this.sampleType_ = 0;
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeRecordingInterval(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        Types$PbDuration types$PbDuration2 = this.recordingInterval_;
        if (types$PbDuration2 == null || types$PbDuration2 == Types$PbDuration.getDefaultInstance()) {
            this.recordingInterval_ = types$PbDuration;
        } else {
            this.recordingInterval_ = Types$PbDuration.newBuilder(this.recordingInterval_).mergeFrom(types$PbDuration).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseDelimitedFrom(InputStream inputStream) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseFrom(ByteBuffer byteBuffer) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PftpRequest$PbPFtpRequestStartRecordingParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRecordingInterval(Types$PbDuration types$PbDuration) {
        types$PbDuration.getClass();
        this.recordingInterval_ = types$PbDuration;
        this.bitField0_ |= 2;
    }

    private void setSampleDataIdentifier(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.sampleDataIdentifier_ = str;
    }

    private void setSampleDataIdentifierBytes(ByteString byteString) {
        this.sampleDataIdentifier_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    private void setSampleType(Types$PbSampleType types$PbSampleType) {
        this.sampleType_ = types$PbSampleType.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PftpRequest$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PftpRequest$PbPFtpRequestStartRecordingParams();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001ᔌ\u0000\u0002ᔉ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "sampleType_", Types$PbSampleType.internalGetVerifier(), "recordingInterval_", "sampleDataIdentifier_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PftpRequest$PbPFtpRequestStartRecordingParams> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PftpRequest$PbPFtpRequestStartRecordingParams.class) {
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

    public Types$PbDuration getRecordingInterval() {
        Types$PbDuration types$PbDuration = this.recordingInterval_;
        return types$PbDuration == null ? Types$PbDuration.getDefaultInstance() : types$PbDuration;
    }

    public String getSampleDataIdentifier() {
        return this.sampleDataIdentifier_;
    }

    public ByteString getSampleDataIdentifierBytes() {
        return ByteString.copyFromUtf8(this.sampleDataIdentifier_);
    }

    public Types$PbSampleType getSampleType() {
        Types$PbSampleType types$PbSampleTypeForNumber = Types$PbSampleType.forNumber(this.sampleType_);
        return types$PbSampleTypeForNumber == null ? Types$PbSampleType.SAMPLE_TYPE_UNDEFINED : types$PbSampleTypeForNumber;
    }

    public boolean hasRecordingInterval() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSampleDataIdentifier() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasSampleType() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PftpRequest$PbPFtpRequestStartRecordingParams, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PftpRequest$PbPFtpRequestStartRecordingParams.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PftpRequest$PbPFtpRequestStartRecordingParams pftpRequest$PbPFtpRequestStartRecordingParams) {
        return DEFAULT_INSTANCE.createBuilder(pftpRequest$PbPFtpRequestStartRecordingParams);
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseFrom(ByteString byteString) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseFrom(byte[] bArr) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseFrom(InputStream inputStream) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseFrom(CodedInputStream codedInputStream) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PftpRequest$PbPFtpRequestStartRecordingParams parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpRequest$PbPFtpRequestStartRecordingParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
