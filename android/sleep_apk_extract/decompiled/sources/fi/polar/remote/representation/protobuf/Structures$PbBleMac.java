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
public final class Structures$PbBleMac extends GeneratedMessageLite<Structures$PbBleMac, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbBleMac DEFAULT_INSTANCE;
    public static final int MAC_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbBleMac> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private int type_;
    private byte memoizedIsInitialized = 2;
    private ByteString mac_ = ByteString.EMPTY;

    static {
        Structures$PbBleMac structures$PbBleMac = new Structures$PbBleMac();
        DEFAULT_INSTANCE = structures$PbBleMac;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbBleMac.class, structures$PbBleMac);
    }

    private Structures$PbBleMac() {
    }

    private void clearMac() {
        this.bitField0_ &= -2;
        this.mac_ = getDefaultInstance().getMac();
    }

    private void clearType() {
        this.bitField0_ &= -3;
        this.type_ = 0;
    }

    public static Structures$PbBleMac getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbBleMac parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbBleMac parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbBleMac> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMac(ByteString byteString) {
        byteString.getClass();
        this.bitField0_ |= 1;
        this.mac_ = byteString;
    }

    private void setType(Types$PbMacType types$PbMacType) {
        this.type_ = types$PbMacType.getNumber();
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbBleMac();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔊ\u0000\u0002ᔌ\u0001", new Object[]{"bitField0_", "mac_", "type_", Types$PbMacType.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbBleMac> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbBleMac.class) {
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

    public ByteString getMac() {
        return this.mac_;
    }

    public Types$PbMacType getType() {
        Types$PbMacType types$PbMacTypeForNumber = Types$PbMacType.forNumber(this.type_);
        return types$PbMacTypeForNumber == null ? Types$PbMacType.MAC_TYPE_PUBLIC : types$PbMacTypeForNumber;
    }

    public boolean hasMac() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbBleMac, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbBleMac.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbBleMac structures$PbBleMac) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbBleMac);
    }

    public static Structures$PbBleMac parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbBleMac parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbBleMac parseFrom(ByteString byteString) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbBleMac parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbBleMac parseFrom(byte[] bArr) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbBleMac parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbBleMac parseFrom(InputStream inputStream) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbBleMac parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbBleMac parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbBleMac parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleMac) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
