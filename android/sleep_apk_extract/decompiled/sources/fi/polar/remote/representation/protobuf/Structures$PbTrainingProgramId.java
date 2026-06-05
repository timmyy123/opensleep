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
public final class Structures$PbTrainingProgramId extends GeneratedMessageLite<Structures$PbTrainingProgramId, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbTrainingProgramId DEFAULT_INSTANCE;
    private static volatile Parser<Structures$PbTrainingProgramId> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private long value_;

    static {
        Structures$PbTrainingProgramId structures$PbTrainingProgramId = new Structures$PbTrainingProgramId();
        DEFAULT_INSTANCE = structures$PbTrainingProgramId;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbTrainingProgramId.class, structures$PbTrainingProgramId);
    }

    private Structures$PbTrainingProgramId() {
    }

    private void clearValue() {
        this.bitField0_ &= -2;
        this.value_ = 0L;
    }

    public static Structures$PbTrainingProgramId getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbTrainingProgramId parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbTrainingProgramId parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbTrainingProgramId> parser() {
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
                return new Structures$PbTrainingProgramId();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᔃ\u0000", new Object[]{"bitField0_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbTrainingProgramId> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbTrainingProgramId.class) {
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

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbTrainingProgramId, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbTrainingProgramId.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbTrainingProgramId structures$PbTrainingProgramId) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbTrainingProgramId);
    }

    public static Structures$PbTrainingProgramId parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbTrainingProgramId parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbTrainingProgramId parseFrom(ByteString byteString) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbTrainingProgramId parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbTrainingProgramId parseFrom(byte[] bArr) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbTrainingProgramId parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbTrainingProgramId parseFrom(InputStream inputStream) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbTrainingProgramId parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbTrainingProgramId parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbTrainingProgramId parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingProgramId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
