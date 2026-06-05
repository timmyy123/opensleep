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
public final class Structures$PbApplicationId extends GeneratedMessageLite<Structures$PbApplicationId, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbApplicationId DEFAULT_INSTANCE;
    private static volatile Parser<Structures$PbApplicationId> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private long value_;

    static {
        Structures$PbApplicationId structures$PbApplicationId = new Structures$PbApplicationId();
        DEFAULT_INSTANCE = structures$PbApplicationId;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbApplicationId.class, structures$PbApplicationId);
    }

    private Structures$PbApplicationId() {
    }

    private void clearValue() {
        this.bitField0_ &= -2;
        this.value_ = 0L;
    }

    public static Structures$PbApplicationId getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbApplicationId parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbApplicationId parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbApplicationId> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setValue(long j) {
        this.bitField0_ |= 1;
        this.value_ = j;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbApplicationId();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᔃ\u0000", new Object[]{"bitField0_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbApplicationId> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbApplicationId.class) {
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

    public long getValue() {
        return this.value_;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbApplicationId, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbApplicationId.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbApplicationId structures$PbApplicationId) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbApplicationId);
    }

    public static Structures$PbApplicationId parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbApplicationId parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbApplicationId parseFrom(ByteString byteString) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbApplicationId parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbApplicationId parseFrom(byte[] bArr) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbApplicationId parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbApplicationId parseFrom(InputStream inputStream) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbApplicationId parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbApplicationId parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbApplicationId parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbApplicationId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
