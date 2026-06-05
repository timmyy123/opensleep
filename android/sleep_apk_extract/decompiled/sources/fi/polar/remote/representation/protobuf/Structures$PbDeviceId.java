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
public final class Structures$PbDeviceId extends GeneratedMessageLite<Structures$PbDeviceId, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbDeviceId DEFAULT_INSTANCE;
    public static final int DEVICE_ID_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbDeviceId> PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String deviceId_ = "";

    static {
        Structures$PbDeviceId structures$PbDeviceId = new Structures$PbDeviceId();
        DEFAULT_INSTANCE = structures$PbDeviceId;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbDeviceId.class, structures$PbDeviceId);
    }

    private Structures$PbDeviceId() {
    }

    private void clearDeviceId() {
        this.bitField0_ &= -2;
        this.deviceId_ = getDefaultInstance().getDeviceId();
    }

    public static Structures$PbDeviceId getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbDeviceId parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbDeviceId parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbDeviceId> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDeviceId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.deviceId_ = str;
    }

    private void setDeviceIdBytes(ByteString byteString) {
        this.deviceId_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbDeviceId();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᔈ\u0000", new Object[]{"bitField0_", "deviceId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbDeviceId> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbDeviceId.class) {
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

    public String getDeviceId() {
        return this.deviceId_;
    }

    public ByteString getDeviceIdBytes() {
        return ByteString.copyFromUtf8(this.deviceId_);
    }

    public boolean hasDeviceId() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbDeviceId, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbDeviceId.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbDeviceId structures$PbDeviceId) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbDeviceId);
    }

    public static Structures$PbDeviceId parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbDeviceId parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbDeviceId parseFrom(ByteString byteString) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbDeviceId parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbDeviceId parseFrom(byte[] bArr) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbDeviceId parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbDeviceId parseFrom(InputStream inputStream) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbDeviceId parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbDeviceId parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbDeviceId parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbDeviceId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
