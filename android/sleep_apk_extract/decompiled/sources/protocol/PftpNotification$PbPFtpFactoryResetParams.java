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
public final class PftpNotification$PbPFtpFactoryResetParams extends GeneratedMessageLite<PftpNotification$PbPFtpFactoryResetParams, Builder> implements MessageLiteOrBuilder {
    private static final PftpNotification$PbPFtpFactoryResetParams DEFAULT_INSTANCE;
    public static final int DO_FACTORY_DEFAULTS_FIELD_NUMBER = 2;
    public static final int OTA_FWUPDATE_FIELD_NUMBER = 3;
    private static volatile Parser<PftpNotification$PbPFtpFactoryResetParams> PARSER = null;
    public static final int SLEEP_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean otaFwupdate_;
    private boolean sleep_;
    private byte memoizedIsInitialized = 2;
    private boolean doFactoryDefaults_ = true;

    static {
        PftpNotification$PbPFtpFactoryResetParams pftpNotification$PbPFtpFactoryResetParams = new PftpNotification$PbPFtpFactoryResetParams();
        DEFAULT_INSTANCE = pftpNotification$PbPFtpFactoryResetParams;
        GeneratedMessageLite.registerDefaultInstance(PftpNotification$PbPFtpFactoryResetParams.class, pftpNotification$PbPFtpFactoryResetParams);
    }

    private PftpNotification$PbPFtpFactoryResetParams() {
    }

    private void clearDoFactoryDefaults() {
        this.bitField0_ &= -3;
        this.doFactoryDefaults_ = true;
    }

    private void clearOtaFwupdate() {
        this.bitField0_ &= -5;
        this.otaFwupdate_ = false;
    }

    private void clearSleep() {
        this.bitField0_ &= -2;
        this.sleep_ = false;
    }

    public static PftpNotification$PbPFtpFactoryResetParams getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseDelimitedFrom(InputStream inputStream) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseFrom(ByteBuffer byteBuffer) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<PftpNotification$PbPFtpFactoryResetParams> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDoFactoryDefaults(boolean z) {
        this.bitField0_ |= 2;
        this.doFactoryDefaults_ = z;
    }

    private void setOtaFwupdate(boolean z) {
        this.bitField0_ |= 4;
        this.otaFwupdate_ = z;
    }

    private void setSleep(boolean z) {
        this.bitField0_ |= 1;
        this.sleep_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (PftpNotification$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new PftpNotification$PbPFtpFactoryResetParams();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᔇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002", new Object[]{"bitField0_", "sleep_", "doFactoryDefaults_", "otaFwupdate_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PftpNotification$PbPFtpFactoryResetParams> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (PftpNotification$PbPFtpFactoryResetParams.class) {
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

    public boolean getDoFactoryDefaults() {
        return this.doFactoryDefaults_;
    }

    public boolean getOtaFwupdate() {
        return this.otaFwupdate_;
    }

    public boolean getSleep() {
        return this.sleep_;
    }

    public boolean hasDoFactoryDefaults() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOtaFwupdate() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasSleep() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<PftpNotification$PbPFtpFactoryResetParams, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(PftpNotification$PbPFtpFactoryResetParams.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(PftpNotification$PbPFtpFactoryResetParams pftpNotification$PbPFtpFactoryResetParams) {
        return DEFAULT_INSTANCE.createBuilder(pftpNotification$PbPFtpFactoryResetParams);
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseFrom(ByteString byteString) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseFrom(byte[] bArr) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseFrom(InputStream inputStream) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseFrom(CodedInputStream codedInputStream) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PftpNotification$PbPFtpFactoryResetParams parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (PftpNotification$PbPFtpFactoryResetParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
