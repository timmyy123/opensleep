package com.google.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class GoogleDescriptorProtos$MethodOptions extends GeneratedMessageLite.ExtendableMessage<GoogleDescriptorProtos$MethodOptions, Builder> implements MessageLiteOrBuilder {
    private static final GoogleDescriptorProtos$MethodOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 33;
    public static final int IDEMPOTENCY_LEVEL_FIELD_NUMBER = 34;
    private static volatile Parser<GoogleDescriptorProtos$MethodOptions> PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean deprecated_;
    private int idempotencyLevel_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<GoogleDescriptorProtos$UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.emptyProtobufList();

    public enum IdempotencyLevel implements Internal.EnumLite {
        IDEMPOTENCY_UNKNOWN(0),
        NO_SIDE_EFFECTS(1),
        IDEMPOTENT(2);

        private static final Internal.EnumLiteMap<IdempotencyLevel> internalValueMap = new Internal.EnumLiteMap<IdempotencyLevel>() { // from class: com.google.protobuf.GoogleDescriptorProtos.MethodOptions.IdempotencyLevel.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public IdempotencyLevel findValueByNumber(int i) {
                return IdempotencyLevel.forNumber(i);
            }
        };
        private final int value;

        public static final class IdempotencyLevelVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new IdempotencyLevelVerifier();

            private IdempotencyLevelVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return IdempotencyLevel.forNumber(i) != null;
            }
        }

        IdempotencyLevel(int i) {
            this.value = i;
        }

        public static IdempotencyLevel forNumber(int i) {
            if (i == 0) {
                return IDEMPOTENCY_UNKNOWN;
            }
            if (i == 1) {
                return NO_SIDE_EFFECTS;
            }
            if (i != 2) {
                return null;
            }
            return IDEMPOTENT;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return IdempotencyLevelVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        GoogleDescriptorProtos$MethodOptions googleDescriptorProtos$MethodOptions = new GoogleDescriptorProtos$MethodOptions();
        DEFAULT_INSTANCE = googleDescriptorProtos$MethodOptions;
        GeneratedMessageLite.registerDefaultInstance(GoogleDescriptorProtos$MethodOptions.class, googleDescriptorProtos$MethodOptions);
    }

    private GoogleDescriptorProtos$MethodOptions() {
    }

    private void addAllUninterpretedOption(Iterable<? extends GoogleDescriptorProtos$UninterpretedOption> iterable) {
        ensureUninterpretedOptionIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.uninterpretedOption_);
    }

    private void addUninterpretedOption(GoogleDescriptorProtos$UninterpretedOption googleDescriptorProtos$UninterpretedOption) {
        googleDescriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(googleDescriptorProtos$UninterpretedOption);
    }

    private void clearDeprecated() {
        this.bitField0_ &= -2;
        this.deprecated_ = false;
    }

    private void clearIdempotencyLevel() {
        this.bitField0_ &= -3;
        this.idempotencyLevel_ = 0;
    }

    private void clearUninterpretedOption() {
        this.uninterpretedOption_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureUninterpretedOptionIsMutable() {
        Internal.ProtobufList<GoogleDescriptorProtos$UninterpretedOption> protobufList = this.uninterpretedOption_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static GoogleDescriptorProtos$MethodOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDescriptorProtos$MethodOptions parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$MethodOptions parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDescriptorProtos$MethodOptions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUninterpretedOption(int i) {
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(i);
    }

    private void setDeprecated(boolean z) {
        this.bitField0_ |= 1;
        this.deprecated_ = z;
    }

    private void setIdempotencyLevel(IdempotencyLevel idempotencyLevel) {
        this.idempotencyLevel_ = idempotencyLevel.getNumber();
        this.bitField0_ |= 2;
    }

    private void setUninterpretedOption(int i, GoogleDescriptorProtos$UninterpretedOption googleDescriptorProtos$UninterpretedOption) {
        googleDescriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(i, googleDescriptorProtos$UninterpretedOption);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (GoogleDescriptorProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GoogleDescriptorProtos$MethodOptions();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001!ϧ\u0003\u0000\u0001\u0001!ဇ\u0000\"ဌ\u0001ϧЛ", new Object[]{"bitField0_", "deprecated_", "idempotencyLevel_", IdempotencyLevel.internalGetVerifier(), "uninterpretedOption_", GoogleDescriptorProtos$UninterpretedOption.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDescriptorProtos$MethodOptions> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDescriptorProtos$MethodOptions.class) {
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

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public IdempotencyLevel getIdempotencyLevel() {
        IdempotencyLevel idempotencyLevelForNumber = IdempotencyLevel.forNumber(this.idempotencyLevel_);
        return idempotencyLevelForNumber == null ? IdempotencyLevel.IDEMPOTENCY_UNKNOWN : idempotencyLevelForNumber;
    }

    public GoogleDescriptorProtos$UninterpretedOption getUninterpretedOption(int i) {
        return this.uninterpretedOption_.get(i);
    }

    public int getUninterpretedOptionCount() {
        return this.uninterpretedOption_.size();
    }

    public List<GoogleDescriptorProtos$UninterpretedOption> getUninterpretedOptionList() {
        return this.uninterpretedOption_;
    }

    public GoogleDescriptorProtos$UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i) {
        return this.uninterpretedOption_.get(i);
    }

    public List<? extends GoogleDescriptorProtos$UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
        return this.uninterpretedOption_;
    }

    public boolean hasDeprecated() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasIdempotencyLevel() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<GoogleDescriptorProtos$MethodOptions, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(GoogleDescriptorProtos$MethodOptions.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GoogleDescriptorProtos$MethodOptions googleDescriptorProtos$MethodOptions) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(googleDescriptorProtos$MethodOptions);
    }

    public static GoogleDescriptorProtos$MethodOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$MethodOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$MethodOptions parseFrom(ByteString byteString) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDescriptorProtos$MethodOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addUninterpretedOption(int i, GoogleDescriptorProtos$UninterpretedOption googleDescriptorProtos$UninterpretedOption) {
        googleDescriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(i, googleDescriptorProtos$UninterpretedOption);
    }

    public static GoogleDescriptorProtos$MethodOptions parseFrom(byte[] bArr) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDescriptorProtos$MethodOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$MethodOptions parseFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$MethodOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$MethodOptions parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDescriptorProtos$MethodOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
