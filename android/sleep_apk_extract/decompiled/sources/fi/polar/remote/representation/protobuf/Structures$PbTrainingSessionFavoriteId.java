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
public final class Structures$PbTrainingSessionFavoriteId extends GeneratedMessageLite<Structures$PbTrainingSessionFavoriteId, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbTrainingSessionFavoriteId DEFAULT_INSTANCE;
    public static final int LAST_MODIFIED_FIELD_NUMBER = 2;
    private static volatile Parser<Structures$PbTrainingSessionFavoriteId> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Types$PbSystemDateTime lastModified_;
    private byte memoizedIsInitialized = 2;
    private long value_;

    static {
        Structures$PbTrainingSessionFavoriteId structures$PbTrainingSessionFavoriteId = new Structures$PbTrainingSessionFavoriteId();
        DEFAULT_INSTANCE = structures$PbTrainingSessionFavoriteId;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbTrainingSessionFavoriteId.class, structures$PbTrainingSessionFavoriteId);
    }

    private Structures$PbTrainingSessionFavoriteId() {
    }

    private void clearLastModified() {
        this.lastModified_ = null;
        this.bitField0_ &= -3;
    }

    private void clearValue() {
        this.bitField0_ &= -2;
        this.value_ = 0L;
    }

    public static Structures$PbTrainingSessionFavoriteId getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.lastModified_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.lastModified_ = types$PbSystemDateTime;
        } else {
            this.lastModified_ = Types$PbSystemDateTime.newBuilder(this.lastModified_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbTrainingSessionFavoriteId parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbTrainingSessionFavoriteId parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbTrainingSessionFavoriteId> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.lastModified_ = types$PbSystemDateTime;
        this.bitField0_ |= 2;
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
                return new Structures$PbTrainingSessionFavoriteId();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔃ\u0000\u0002ᐉ\u0001", new Object[]{"bitField0_", "value_", "lastModified_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbTrainingSessionFavoriteId> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbTrainingSessionFavoriteId.class) {
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

    public Types$PbSystemDateTime getLastModified() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.lastModified_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public long getValue() {
        return this.value_;
    }

    public boolean hasLastModified() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasValue() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbTrainingSessionFavoriteId, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbTrainingSessionFavoriteId.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbTrainingSessionFavoriteId structures$PbTrainingSessionFavoriteId) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbTrainingSessionFavoriteId);
    }

    public static Structures$PbTrainingSessionFavoriteId parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbTrainingSessionFavoriteId parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbTrainingSessionFavoriteId parseFrom(ByteString byteString) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbTrainingSessionFavoriteId parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbTrainingSessionFavoriteId parseFrom(byte[] bArr) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbTrainingSessionFavoriteId parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbTrainingSessionFavoriteId parseFrom(InputStream inputStream) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbTrainingSessionFavoriteId parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbTrainingSessionFavoriteId parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbTrainingSessionFavoriteId parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbTrainingSessionFavoriteId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
