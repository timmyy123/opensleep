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
public final class Structures$PbAlgorithmVersion extends GeneratedMessageLite<Structures$PbAlgorithmVersion, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbAlgorithmVersion DEFAULT_INSTANCE;
    public static final int OHR_VERSION_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbAlgorithmVersion> PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private Structures$PbVersion ohrVersion_;

    static {
        Structures$PbAlgorithmVersion structures$PbAlgorithmVersion = new Structures$PbAlgorithmVersion();
        DEFAULT_INSTANCE = structures$PbAlgorithmVersion;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbAlgorithmVersion.class, structures$PbAlgorithmVersion);
    }

    private Structures$PbAlgorithmVersion() {
    }

    private void clearOhrVersion() {
        this.ohrVersion_ = null;
        this.bitField0_ &= -2;
    }

    public static Structures$PbAlgorithmVersion getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOhrVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        Structures$PbVersion structures$PbVersion2 = this.ohrVersion_;
        if (structures$PbVersion2 == null || structures$PbVersion2 == Structures$PbVersion.getDefaultInstance()) {
            this.ohrVersion_ = structures$PbVersion;
        } else {
            this.ohrVersion_ = Structures$PbVersion.newBuilder(this.ohrVersion_).mergeFrom(structures$PbVersion).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbAlgorithmVersion parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbAlgorithmVersion parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbAlgorithmVersion> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setOhrVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        this.ohrVersion_ = structures$PbVersion;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbAlgorithmVersion();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᐉ\u0000", new Object[]{"bitField0_", "ohrVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbAlgorithmVersion> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbAlgorithmVersion.class) {
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

    public Structures$PbVersion getOhrVersion() {
        Structures$PbVersion structures$PbVersion = this.ohrVersion_;
        return structures$PbVersion == null ? Structures$PbVersion.getDefaultInstance() : structures$PbVersion;
    }

    public boolean hasOhrVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbAlgorithmVersion, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbAlgorithmVersion.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbAlgorithmVersion structures$PbAlgorithmVersion) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbAlgorithmVersion);
    }

    public static Structures$PbAlgorithmVersion parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbAlgorithmVersion parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbAlgorithmVersion parseFrom(ByteString byteString) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbAlgorithmVersion parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbAlgorithmVersion parseFrom(byte[] bArr) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbAlgorithmVersion parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbAlgorithmVersion parseFrom(InputStream inputStream) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbAlgorithmVersion parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbAlgorithmVersion parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbAlgorithmVersion parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbAlgorithmVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
