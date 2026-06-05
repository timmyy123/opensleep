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
public final class Structures$PbBleUuid extends GeneratedMessageLite<Structures$PbBleUuid, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbBleUuid DEFAULT_INSTANCE;
    private static volatile Parser<Structures$PbBleUuid> PARSER = null;
    public static final int UUID_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private ByteString uuid_ = ByteString.EMPTY;

    static {
        Structures$PbBleUuid structures$PbBleUuid = new Structures$PbBleUuid();
        DEFAULT_INSTANCE = structures$PbBleUuid;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbBleUuid.class, structures$PbBleUuid);
    }

    private Structures$PbBleUuid() {
    }

    private void clearUuid() {
        this.bitField0_ &= -2;
        this.uuid_ = getDefaultInstance().getUuid();
    }

    public static Structures$PbBleUuid getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbBleUuid parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbBleUuid parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbBleUuid> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setUuid(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.uuid_ = byteString;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbBleUuid();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᔊ\u0000", new Object[]{"bitField0_", "uuid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbBleUuid> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbBleUuid.class) {
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

    public ByteString getUuid() {
        return this.uuid_;
    }

    public boolean hasUuid() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbBleUuid, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbBleUuid.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbBleUuid structures$PbBleUuid) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbBleUuid);
    }

    public static Structures$PbBleUuid parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbBleUuid parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbBleUuid parseFrom(ByteString byteString) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbBleUuid parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbBleUuid parseFrom(byte[] bArr) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbBleUuid parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbBleUuid parseFrom(InputStream inputStream) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbBleUuid parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbBleUuid parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbBleUuid parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleUuid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
