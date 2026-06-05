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
public final class PftpNotification$PbPFtpStopSyncParams extends GeneratedMessageLite<PftpNotification$PbPFtpStopSyncParams, Builder> implements MessageLiteOrBuilder {
    public static final int COMPLETED_FIELD_NUMBER = 1;
    private static final PftpNotification$PbPFtpStopSyncParams DEFAULT_INSTANCE;
    private static volatile Parser<PftpNotification$PbPFtpStopSyncParams> PARSER;
    private int bitField0_;
    private boolean completed_;
    private byte memoizedIsInitialized = 2;

    static {
        PftpNotification$PbPFtpStopSyncParams pftpNotification$PbPFtpStopSyncParams = new PftpNotification$PbPFtpStopSyncParams();
        DEFAULT_INSTANCE = pftpNotification$PbPFtpStopSyncParams;
        GeneratedMessageLite.registerDefaultInstance(PftpNotification$PbPFtpStopSyncParams.class, pftpNotification$PbPFtpStopSyncParams);
    }

    private PftpNotification$PbPFtpStopSyncParams() {
    }

    private void clearCompleted() {
        this.bitField0_ &= -2;
        this.completed_ = false;
    }

    public static PftpNotification$PbPFtpStopSyncParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PftpNotification$PbPFtpStopSyncParams parseDelimitedFrom(InputStream inputStream) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpNotification$PbPFtpStopSyncParams parseFrom(ByteBuffer byteBuffer) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PftpNotification$PbPFtpStopSyncParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setCompleted(boolean z) {
        this.bitField0_ |= 1;
        this.completed_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PftpNotification$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PftpNotification$PbPFtpStopSyncParams();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᔇ\u0000", new Object[]{"bitField0_", "completed_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PftpNotification$PbPFtpStopSyncParams> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PftpNotification$PbPFtpStopSyncParams.class) {
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

    public boolean getCompleted() {
        return this.completed_;
    }

    public boolean hasCompleted() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PftpNotification$PbPFtpStopSyncParams, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PftpNotification$PbPFtpStopSyncParams.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PftpNotification$PbPFtpStopSyncParams pftpNotification$PbPFtpStopSyncParams) {
        return DEFAULT_INSTANCE.createBuilder(pftpNotification$PbPFtpStopSyncParams);
    }

    public static PftpNotification$PbPFtpStopSyncParams parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpNotification$PbPFtpStopSyncParams parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PftpNotification$PbPFtpStopSyncParams parseFrom(ByteString byteString) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PftpNotification$PbPFtpStopSyncParams parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PftpNotification$PbPFtpStopSyncParams parseFrom(byte[] bArr) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PftpNotification$PbPFtpStopSyncParams parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PftpNotification$PbPFtpStopSyncParams parseFrom(InputStream inputStream) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpNotification$PbPFtpStopSyncParams parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpNotification$PbPFtpStopSyncParams parseFrom(CodedInputStream codedInputStream) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PftpNotification$PbPFtpStopSyncParams parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpStopSyncParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
