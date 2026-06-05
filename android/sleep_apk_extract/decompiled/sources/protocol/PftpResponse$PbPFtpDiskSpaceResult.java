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
public final class PftpResponse$PbPFtpDiskSpaceResult extends GeneratedMessageLite<PftpResponse$PbPFtpDiskSpaceResult, Builder> implements MessageLiteOrBuilder {
    private static final PftpResponse$PbPFtpDiskSpaceResult DEFAULT_INSTANCE;
    public static final int FRAGMENT_SIZE_FIELD_NUMBER = 1;
    public static final int FREE_FRAGMENTS_FIELD_NUMBER = 3;
    private static volatile Parser<PftpResponse$PbPFtpDiskSpaceResult> PARSER = null;
    public static final int TOTAL_FRAGMENTS_FIELD_NUMBER = 2;
    private int bitField0_;
    private int fragmentSize_;
    private long freeFragments_;
    private byte memoizedIsInitialized = 2;
    private long totalFragments_;

    static {
        PftpResponse$PbPFtpDiskSpaceResult pftpResponse$PbPFtpDiskSpaceResult = new PftpResponse$PbPFtpDiskSpaceResult();
        DEFAULT_INSTANCE = pftpResponse$PbPFtpDiskSpaceResult;
        GeneratedMessageLite.registerDefaultInstance(PftpResponse$PbPFtpDiskSpaceResult.class, pftpResponse$PbPFtpDiskSpaceResult);
    }

    private PftpResponse$PbPFtpDiskSpaceResult() {
    }

    private void clearFragmentSize() {
        this.bitField0_ &= -2;
        this.fragmentSize_ = 0;
    }

    private void clearFreeFragments() {
        this.bitField0_ &= -5;
        this.freeFragments_ = 0L;
    }

    private void clearTotalFragments() {
        this.bitField0_ &= -3;
        this.totalFragments_ = 0L;
    }

    public static PftpResponse$PbPFtpDiskSpaceResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseDelimitedFrom(InputStream inputStream) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseFrom(ByteBuffer byteBuffer) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PftpResponse$PbPFtpDiskSpaceResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFragmentSize(int i) {
        this.bitField0_ |= 1;
        this.fragmentSize_ = i;
    }

    private void setFreeFragments(long j) {
        this.bitField0_ |= 4;
        this.freeFragments_ = j;
    }

    private void setTotalFragments(long j) {
        this.bitField0_ |= 2;
        this.totalFragments_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PftpResponse$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PftpResponse$PbPFtpDiskSpaceResult();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔋ\u0000\u0002ᔃ\u0001\u0003ᔃ\u0002", new Object[]{"bitField0_", "fragmentSize_", "totalFragments_", "freeFragments_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PftpResponse$PbPFtpDiskSpaceResult> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PftpResponse$PbPFtpDiskSpaceResult.class) {
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

    public int getFragmentSize() {
        return this.fragmentSize_;
    }

    public long getFreeFragments() {
        return this.freeFragments_;
    }

    public long getTotalFragments() {
        return this.totalFragments_;
    }

    public boolean hasFragmentSize() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasFreeFragments() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasTotalFragments() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PftpResponse$PbPFtpDiskSpaceResult, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PftpResponse$PbPFtpDiskSpaceResult.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PftpResponse$PbPFtpDiskSpaceResult pftpResponse$PbPFtpDiskSpaceResult) {
        return DEFAULT_INSTANCE.createBuilder(pftpResponse$PbPFtpDiskSpaceResult);
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseFrom(ByteString byteString) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseFrom(byte[] bArr) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseFrom(InputStream inputStream) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseFrom(CodedInputStream codedInputStream) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PftpResponse$PbPFtpDiskSpaceResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpResponse$PbPFtpDiskSpaceResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
