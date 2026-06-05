package protocol;

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
public final class PftpResponse$PbRequestRecordingStatusResult extends GeneratedMessageLite<PftpResponse$PbRequestRecordingStatusResult, Builder> implements MessageLiteOrBuilder {
    private static final PftpResponse$PbRequestRecordingStatusResult DEFAULT_INSTANCE;
    private static volatile Parser<PftpResponse$PbRequestRecordingStatusResult> PARSER = null;
    public static final int RECORDING_ON_FIELD_NUMBER = 1;
    public static final int SAMPLE_DATA_IDENTIFIER_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean recordingOn_;
    private byte memoizedIsInitialized = 2;
    private String sampleDataIdentifier_ = "";

    static {
        PftpResponse$PbRequestRecordingStatusResult pftpResponse$PbRequestRecordingStatusResult = new PftpResponse$PbRequestRecordingStatusResult();
        DEFAULT_INSTANCE = pftpResponse$PbRequestRecordingStatusResult;
        GeneratedMessageLite.registerDefaultInstance(PftpResponse$PbRequestRecordingStatusResult.class, pftpResponse$PbRequestRecordingStatusResult);
    }

    private PftpResponse$PbRequestRecordingStatusResult() {
    }

    private void clearRecordingOn() {
        this.bitField0_ &= -2;
        this.recordingOn_ = false;
    }

    private void clearSampleDataIdentifier() {
        this.bitField0_ &= -3;
        this.sampleDataIdentifier_ = getDefaultInstance().getSampleDataIdentifier();
    }

    public static PftpResponse$PbRequestRecordingStatusResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseDelimitedFrom(InputStream inputStream) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseFrom(ByteBuffer byteBuffer) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PftpResponse$PbRequestRecordingStatusResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setRecordingOn(boolean z) {
        this.bitField0_ |= 1;
        this.recordingOn_ = z;
    }

    private void setSampleDataIdentifier(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.sampleDataIdentifier_ = str;
    }

    private void setSampleDataIdentifierBytes(ByteString byteString) {
        this.sampleDataIdentifier_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PftpResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PftpResponse$PbRequestRecordingStatusResult();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔇ\u0000\u0002ဈ\u0001", new Object[]{"bitField0_", "recordingOn_", "sampleDataIdentifier_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PftpResponse$PbRequestRecordingStatusResult> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PftpResponse$PbRequestRecordingStatusResult.class) {
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

    public boolean getRecordingOn() {
        return this.recordingOn_;
    }

    public String getSampleDataIdentifier() {
        return this.sampleDataIdentifier_;
    }

    public ByteString getSampleDataIdentifierBytes() {
        return ByteString.copyFromUtf8(this.sampleDataIdentifier_);
    }

    public boolean hasRecordingOn() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSampleDataIdentifier() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PftpResponse$PbRequestRecordingStatusResult, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PftpResponse$PbRequestRecordingStatusResult.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PftpResponse$PbRequestRecordingStatusResult pftpResponse$PbRequestRecordingStatusResult) {
        return DEFAULT_INSTANCE.createBuilder(pftpResponse$PbRequestRecordingStatusResult);
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseFrom(ByteString byteString) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseFrom(byte[] bArr) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseFrom(InputStream inputStream) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseFrom(CodedInputStream codedInputStream) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PftpResponse$PbRequestRecordingStatusResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbRequestRecordingStatusResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
