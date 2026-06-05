package com.google.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleDescriptorProtos$FieldOptions extends GeneratedMessageLite.ExtendableMessage<GoogleDescriptorProtos$FieldOptions, Builder> implements MessageLiteOrBuilder {
    public static final int CTYPE_FIELD_NUMBER = 1;
    private static final GoogleDescriptorProtos$FieldOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 3;
    public static final int JSTYPE_FIELD_NUMBER = 6;
    public static final int LAZY_FIELD_NUMBER = 5;
    public static final int PACKED_FIELD_NUMBER = 2;
    private static volatile Parser<GoogleDescriptorProtos$FieldOptions> PARSER = null;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    public static final int UNVERIFIED_LAZY_FIELD_NUMBER = 15;
    public static final int WEAK_FIELD_NUMBER = 10;
    private int bitField0_;
    private int ctype_;
    private boolean deprecated_;
    private int jstype_;
    private boolean lazy_;
    private boolean packed_;
    private boolean unverifiedLazy_;
    private boolean weak_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<GoogleDescriptorProtos$UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: loaded from: classes4.dex */
    public enum CType implements Internal.EnumLite {
        STRING(0),
        CORD(1),
        STRING_PIECE(2);

        private static final Internal.EnumLiteMap<CType> internalValueMap = new Internal.EnumLiteMap<CType>() { // from class: com.google.protobuf.GoogleDescriptorProtos.FieldOptions.CType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public CType findValueByNumber(int i) {
                return CType.forNumber(i);
            }
        };
        private final int value;

        public static final class CTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new CTypeVerifier();

            private CTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return CType.forNumber(i) != null;
            }
        }

        CType(int i) {
            this.value = i;
        }

        public static CType forNumber(int i) {
            if (i == 0) {
                return STRING;
            }
            if (i == 1) {
                return CORD;
            }
            if (i != 2) {
                return null;
            }
            return STRING_PIECE;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return CTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public enum JSType implements Internal.EnumLite {
        JS_NORMAL(0),
        JS_STRING(1),
        JS_NUMBER(2);

        private static final Internal.EnumLiteMap<JSType> internalValueMap = new Internal.EnumLiteMap<JSType>() { // from class: com.google.protobuf.GoogleDescriptorProtos.FieldOptions.JSType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public JSType findValueByNumber(int i) {
                return JSType.forNumber(i);
            }
        };
        private final int value;

        public static final class JSTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new JSTypeVerifier();

            private JSTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return JSType.forNumber(i) != null;
            }
        }

        JSType(int i) {
            this.value = i;
        }

        public static JSType forNumber(int i) {
            if (i == 0) {
                return JS_NORMAL;
            }
            if (i == 1) {
                return JS_STRING;
            }
            if (i != 2) {
                return null;
            }
            return JS_NUMBER;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return JSTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        GoogleDescriptorProtos$FieldOptions googleDescriptorProtos$FieldOptions = new GoogleDescriptorProtos$FieldOptions();
        DEFAULT_INSTANCE = googleDescriptorProtos$FieldOptions;
        GeneratedMessageLite.registerDefaultInstance(GoogleDescriptorProtos$FieldOptions.class, googleDescriptorProtos$FieldOptions);
    }

    private GoogleDescriptorProtos$FieldOptions() {
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

    private void clearCtype() {
        this.bitField0_ &= -2;
        this.ctype_ = 0;
    }

    private void clearDeprecated() {
        this.bitField0_ &= -33;
        this.deprecated_ = false;
    }

    private void clearJstype() {
        this.bitField0_ &= -5;
        this.jstype_ = 0;
    }

    private void clearLazy() {
        this.bitField0_ &= -9;
        this.lazy_ = false;
    }

    private void clearPacked() {
        this.bitField0_ &= -3;
        this.packed_ = false;
    }

    private void clearUninterpretedOption() {
        this.uninterpretedOption_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearUnverifiedLazy() {
        this.bitField0_ &= -17;
        this.unverifiedLazy_ = false;
    }

    private void clearWeak() {
        this.bitField0_ &= -65;
        this.weak_ = false;
    }

    private void ensureUninterpretedOptionIsMutable() {
        Internal.ProtobufList<GoogleDescriptorProtos$UninterpretedOption> protobufList = this.uninterpretedOption_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.uninterpretedOption_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static GoogleDescriptorProtos$FieldOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDescriptorProtos$FieldOptions parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$FieldOptions parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDescriptorProtos$FieldOptions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUninterpretedOption(int i) {
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(i);
    }

    private void setCtype(CType cType) {
        this.ctype_ = cType.getNumber();
        this.bitField0_ |= 1;
    }

    private void setDeprecated(boolean z) {
        this.bitField0_ |= 32;
        this.deprecated_ = z;
    }

    private void setJstype(JSType jSType) {
        this.jstype_ = jSType.getNumber();
        this.bitField0_ |= 4;
    }

    private void setLazy(boolean z) {
        this.bitField0_ |= 8;
        this.lazy_ = z;
    }

    private void setPacked(boolean z) {
        this.bitField0_ |= 2;
        this.packed_ = z;
    }

    private void setUninterpretedOption(int i, GoogleDescriptorProtos$UninterpretedOption googleDescriptorProtos$UninterpretedOption) {
        googleDescriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.set(i, googleDescriptorProtos$UninterpretedOption);
    }

    private void setUnverifiedLazy(boolean z) {
        this.bitField0_ |= 16;
        this.unverifiedLazy_ = z;
    }

    private void setWeak(boolean z) {
        this.bitField0_ |= 64;
        this.weak_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (GoogleDescriptorProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GoogleDescriptorProtos$FieldOptions();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001ϧ\b\u0000\u0001\u0001\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0005\u0005ဇ\u0003\u0006ဌ\u0002\nဇ\u0006\u000fဇ\u0004ϧЛ", new Object[]{"bitField0_", "ctype_", CType.internalGetVerifier(), "packed_", "deprecated_", "lazy_", "jstype_", JSType.internalGetVerifier(), "weak_", "unverifiedLazy_", "uninterpretedOption_", GoogleDescriptorProtos$UninterpretedOption.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDescriptorProtos$FieldOptions> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDescriptorProtos$FieldOptions.class) {
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

    public CType getCtype() {
        CType cTypeForNumber = CType.forNumber(this.ctype_);
        return cTypeForNumber == null ? CType.STRING : cTypeForNumber;
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public JSType getJstype() {
        JSType jSTypeForNumber = JSType.forNumber(this.jstype_);
        return jSTypeForNumber == null ? JSType.JS_NORMAL : jSTypeForNumber;
    }

    public boolean getLazy() {
        return this.lazy_;
    }

    public boolean getPacked() {
        return this.packed_;
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

    public boolean getUnverifiedLazy() {
        return this.unverifiedLazy_;
    }

    public boolean getWeak() {
        return this.weak_;
    }

    public boolean hasCtype() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasDeprecated() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasJstype() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasLazy() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasPacked() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasUnverifiedLazy() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasWeak() {
        return (this.bitField0_ & 64) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<GoogleDescriptorProtos$FieldOptions, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(GoogleDescriptorProtos$FieldOptions.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GoogleDescriptorProtos$FieldOptions googleDescriptorProtos$FieldOptions) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(googleDescriptorProtos$FieldOptions);
    }

    public static GoogleDescriptorProtos$FieldOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FieldOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FieldOptions parseFrom(ByteString byteString) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDescriptorProtos$FieldOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addUninterpretedOption(int i, GoogleDescriptorProtos$UninterpretedOption googleDescriptorProtos$UninterpretedOption) {
        googleDescriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(i, googleDescriptorProtos$UninterpretedOption);
    }

    public static GoogleDescriptorProtos$FieldOptions parseFrom(byte[] bArr) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDescriptorProtos$FieldOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FieldOptions parseFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$FieldOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FieldOptions parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDescriptorProtos$FieldOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
