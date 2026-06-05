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
public final class Nanopb$NanoPBOptions extends GeneratedMessageLite<Nanopb$NanoPBOptions, Builder> implements MessageLiteOrBuilder {
    private static final Nanopb$NanoPBOptions DEFAULT_INSTANCE;
    public static final int MAX_COUNT_FIELD_NUMBER = 2;
    public static final int MAX_SIZE_FIELD_NUMBER = 1;
    private static volatile Parser<Nanopb$NanoPBOptions> PARSER;
    private int bitField0_;
    private int maxCount_;
    private int maxSize_;

    static {
        Nanopb$NanoPBOptions nanopb$NanoPBOptions = new Nanopb$NanoPBOptions();
        DEFAULT_INSTANCE = nanopb$NanoPBOptions;
        GeneratedMessageLite.registerDefaultInstance(Nanopb$NanoPBOptions.class, nanopb$NanoPBOptions);
    }

    private Nanopb$NanoPBOptions() {
    }

    private void clearMaxCount() {
        this.bitField0_ &= -3;
        this.maxCount_ = 0;
    }

    private void clearMaxSize() {
        this.bitField0_ &= -2;
        this.maxSize_ = 0;
    }

    public static Nanopb$NanoPBOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Nanopb$NanoPBOptions parseDelimitedFrom(InputStream inputStream) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Nanopb$NanoPBOptions parseFrom(ByteBuffer byteBuffer) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Nanopb$NanoPBOptions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMaxCount(int i) {
        this.bitField0_ |= 2;
        this.maxCount_ = i;
    }

    private void setMaxSize(int i) {
        this.bitField0_ |= 1;
        this.maxSize_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Nanopb$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Nanopb$NanoPBOptions();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "maxSize_", "maxCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Nanopb$NanoPBOptions> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Nanopb$NanoPBOptions.class) {
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
                return (byte) 1;
            default:
                Home$$ExternalSyntheticBUOutline0.m$1();
            case 7:
                return null;
        }
    }

    public int getMaxCount() {
        return this.maxCount_;
    }

    public int getMaxSize() {
        return this.maxSize_;
    }

    public boolean hasMaxCount() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasMaxSize() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Nanopb$NanoPBOptions, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Nanopb$NanoPBOptions.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Nanopb$NanoPBOptions nanopb$NanoPBOptions) {
        return DEFAULT_INSTANCE.createBuilder(nanopb$NanoPBOptions);
    }

    public static Nanopb$NanoPBOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Nanopb$NanoPBOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Nanopb$NanoPBOptions parseFrom(ByteString byteString) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Nanopb$NanoPBOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Nanopb$NanoPBOptions parseFrom(byte[] bArr) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Nanopb$NanoPBOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Nanopb$NanoPBOptions parseFrom(InputStream inputStream) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Nanopb$NanoPBOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Nanopb$NanoPBOptions parseFrom(CodedInputStream codedInputStream) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Nanopb$NanoPBOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Nanopb$NanoPBOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
