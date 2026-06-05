package com.google.protobuf;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleDescriptorProtos$FileOptions extends GeneratedMessageLite.ExtendableMessage<GoogleDescriptorProtos$FileOptions, Builder> implements MessageLiteOrBuilder {
    public static final int CC_ENABLE_ARENAS_FIELD_NUMBER = 31;
    public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
    public static final int CSHARP_NAMESPACE_FIELD_NUMBER = 37;
    private static final GoogleDescriptorProtos$FileOptions DEFAULT_INSTANCE;
    public static final int DEPRECATED_FIELD_NUMBER = 23;
    public static final int GO_PACKAGE_FIELD_NUMBER = 11;
    public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
    public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
    public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
    public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
    public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
    public static final int JAVA_STRING_CHECK_UTF8_FIELD_NUMBER = 27;
    public static final int OBJC_CLASS_PREFIX_FIELD_NUMBER = 36;
    public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
    private static volatile Parser<GoogleDescriptorProtos$FileOptions> PARSER = null;
    public static final int PHP_CLASS_PREFIX_FIELD_NUMBER = 40;
    public static final int PHP_GENERIC_SERVICES_FIELD_NUMBER = 42;
    public static final int PHP_METADATA_NAMESPACE_FIELD_NUMBER = 44;
    public static final int PHP_NAMESPACE_FIELD_NUMBER = 41;
    public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
    public static final int RUBY_PACKAGE_FIELD_NUMBER = 45;
    public static final int SWIFT_PREFIX_FIELD_NUMBER = 39;
    public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
    private int bitField0_;
    private boolean ccGenericServices_;
    private boolean deprecated_;
    private boolean javaGenerateEqualsAndHash_;
    private boolean javaGenericServices_;
    private boolean javaMultipleFiles_;
    private boolean javaStringCheckUtf8_;
    private boolean phpGenericServices_;
    private boolean pyGenericServices_;
    private byte memoizedIsInitialized = 2;
    private String javaPackage_ = "";
    private String javaOuterClassname_ = "";
    private int optimizeFor_ = 1;
    private String goPackage_ = "";
    private boolean ccEnableArenas_ = true;
    private String objcClassPrefix_ = "";
    private String csharpNamespace_ = "";
    private String swiftPrefix_ = "";
    private String phpClassPrefix_ = "";
    private String phpNamespace_ = "";
    private String phpMetadataNamespace_ = "";
    private String rubyPackage_ = "";
    private Internal.ProtobufList<GoogleDescriptorProtos$UninterpretedOption> uninterpretedOption_ = GeneratedMessageLite.emptyProtobufList();

    /* JADX INFO: loaded from: classes4.dex */
    public enum OptimizeMode implements Internal.EnumLite {
        SPEED(1),
        CODE_SIZE(2),
        LITE_RUNTIME(3);

        private static final Internal.EnumLiteMap<OptimizeMode> internalValueMap = new Internal.EnumLiteMap<OptimizeMode>() { // from class: com.google.protobuf.GoogleDescriptorProtos.FileOptions.OptimizeMode.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public OptimizeMode findValueByNumber(int i) {
                return OptimizeMode.forNumber(i);
            }
        };
        private final int value;

        public static final class OptimizeModeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new OptimizeModeVerifier();

            private OptimizeModeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return OptimizeMode.forNumber(i) != null;
            }
        }

        OptimizeMode(int i) {
            this.value = i;
        }

        public static OptimizeMode forNumber(int i) {
            if (i == 1) {
                return SPEED;
            }
            if (i == 2) {
                return CODE_SIZE;
            }
            if (i != 3) {
                return null;
            }
            return LITE_RUNTIME;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return OptimizeModeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        GoogleDescriptorProtos$FileOptions googleDescriptorProtos$FileOptions = new GoogleDescriptorProtos$FileOptions();
        DEFAULT_INSTANCE = googleDescriptorProtos$FileOptions;
        GeneratedMessageLite.registerDefaultInstance(GoogleDescriptorProtos$FileOptions.class, googleDescriptorProtos$FileOptions);
    }

    private GoogleDescriptorProtos$FileOptions() {
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

    private void clearCcEnableArenas() {
        this.bitField0_ &= -4097;
        this.ccEnableArenas_ = true;
    }

    private void clearCcGenericServices() {
        this.bitField0_ &= -129;
        this.ccGenericServices_ = false;
    }

    private void clearCsharpNamespace() {
        this.bitField0_ &= -16385;
        this.csharpNamespace_ = getDefaultInstance().getCsharpNamespace();
    }

    private void clearDeprecated() {
        this.bitField0_ &= -2049;
        this.deprecated_ = false;
    }

    private void clearGoPackage() {
        this.bitField0_ &= -65;
        this.goPackage_ = getDefaultInstance().getGoPackage();
    }

    private void clearJavaGenerateEqualsAndHash() {
        this.bitField0_ &= -9;
        this.javaGenerateEqualsAndHash_ = false;
    }

    private void clearJavaGenericServices() {
        this.bitField0_ &= -257;
        this.javaGenericServices_ = false;
    }

    private void clearJavaMultipleFiles() {
        this.bitField0_ &= -5;
        this.javaMultipleFiles_ = false;
    }

    private void clearJavaOuterClassname() {
        this.bitField0_ &= -3;
        this.javaOuterClassname_ = getDefaultInstance().getJavaOuterClassname();
    }

    private void clearJavaPackage() {
        this.bitField0_ &= -2;
        this.javaPackage_ = getDefaultInstance().getJavaPackage();
    }

    private void clearJavaStringCheckUtf8() {
        this.bitField0_ &= -17;
        this.javaStringCheckUtf8_ = false;
    }

    private void clearObjcClassPrefix() {
        this.bitField0_ &= -8193;
        this.objcClassPrefix_ = getDefaultInstance().getObjcClassPrefix();
    }

    private void clearOptimizeFor() {
        this.bitField0_ &= -33;
        this.optimizeFor_ = 1;
    }

    private void clearPhpClassPrefix() {
        this.bitField0_ &= -65537;
        this.phpClassPrefix_ = getDefaultInstance().getPhpClassPrefix();
    }

    private void clearPhpGenericServices() {
        this.bitField0_ &= -1025;
        this.phpGenericServices_ = false;
    }

    private void clearPhpMetadataNamespace() {
        this.bitField0_ &= -262145;
        this.phpMetadataNamespace_ = getDefaultInstance().getPhpMetadataNamespace();
    }

    private void clearPhpNamespace() {
        this.bitField0_ &= -131073;
        this.phpNamespace_ = getDefaultInstance().getPhpNamespace();
    }

    private void clearPyGenericServices() {
        this.bitField0_ &= -513;
        this.pyGenericServices_ = false;
    }

    private void clearRubyPackage() {
        this.bitField0_ &= -524289;
        this.rubyPackage_ = getDefaultInstance().getRubyPackage();
    }

    private void clearSwiftPrefix() {
        this.bitField0_ &= -32769;
        this.swiftPrefix_ = getDefaultInstance().getSwiftPrefix();
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

    public static GoogleDescriptorProtos$FileOptions getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDescriptorProtos$FileOptions parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$FileOptions parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDescriptorProtos$FileOptions> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeUninterpretedOption(int i) {
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.remove(i);
    }

    private void setCcEnableArenas(boolean z) {
        this.bitField0_ |= 4096;
        this.ccEnableArenas_ = z;
    }

    private void setCcGenericServices(boolean z) {
        this.bitField0_ |= 128;
        this.ccGenericServices_ = z;
    }

    private void setCsharpNamespace(String str) {
        str.getClass();
        this.bitField0_ |= 16384;
        this.csharpNamespace_ = str;
    }

    private void setCsharpNamespaceBytes(ByteString byteString) {
        this.csharpNamespace_ = byteString.toStringUtf8();
        this.bitField0_ |= 16384;
    }

    private void setDeprecated(boolean z) {
        this.bitField0_ |= 2048;
        this.deprecated_ = z;
    }

    private void setGoPackage(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.goPackage_ = str;
    }

    private void setGoPackageBytes(ByteString byteString) {
        this.goPackage_ = byteString.toStringUtf8();
        this.bitField0_ |= 64;
    }

    private void setJavaGenerateEqualsAndHash(boolean z) {
        this.bitField0_ |= 8;
        this.javaGenerateEqualsAndHash_ = z;
    }

    private void setJavaGenericServices(boolean z) {
        this.bitField0_ |= 256;
        this.javaGenericServices_ = z;
    }

    private void setJavaMultipleFiles(boolean z) {
        this.bitField0_ |= 4;
        this.javaMultipleFiles_ = z;
    }

    private void setJavaOuterClassname(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.javaOuterClassname_ = str;
    }

    private void setJavaOuterClassnameBytes(ByteString byteString) {
        this.javaOuterClassname_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    private void setJavaPackage(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.javaPackage_ = str;
    }

    private void setJavaPackageBytes(ByteString byteString) {
        this.javaPackage_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    private void setJavaStringCheckUtf8(boolean z) {
        this.bitField0_ |= 16;
        this.javaStringCheckUtf8_ = z;
    }

    private void setObjcClassPrefix(String str) {
        str.getClass();
        this.bitField0_ |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.objcClassPrefix_ = str;
    }

    private void setObjcClassPrefixBytes(ByteString byteString) {
        this.objcClassPrefix_ = byteString.toStringUtf8();
        this.bitField0_ |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
    }

    private void setOptimizeFor(OptimizeMode optimizeMode) {
        this.optimizeFor_ = optimizeMode.getNumber();
        this.bitField0_ |= 32;
    }

    private void setPhpClassPrefix(String str) {
        str.getClass();
        this.bitField0_ |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        this.phpClassPrefix_ = str;
    }

    private void setPhpClassPrefixBytes(ByteString byteString) {
        this.phpClassPrefix_ = byteString.toStringUtf8();
        this.bitField0_ |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    }

    private void setPhpGenericServices(boolean z) {
        this.bitField0_ |= 1024;
        this.phpGenericServices_ = z;
    }

    private void setPhpMetadataNamespace(String str) {
        str.getClass();
        this.bitField0_ |= 262144;
        this.phpMetadataNamespace_ = str;
    }

    private void setPhpMetadataNamespaceBytes(ByteString byteString) {
        this.phpMetadataNamespace_ = byteString.toStringUtf8();
        this.bitField0_ |= 262144;
    }

    private void setPhpNamespace(String str) {
        str.getClass();
        this.bitField0_ |= 131072;
        this.phpNamespace_ = str;
    }

    private void setPhpNamespaceBytes(ByteString byteString) {
        this.phpNamespace_ = byteString.toStringUtf8();
        this.bitField0_ |= 131072;
    }

    private void setPyGenericServices(boolean z) {
        this.bitField0_ |= 512;
        this.pyGenericServices_ = z;
    }

    private void setRubyPackage(String str) {
        str.getClass();
        this.bitField0_ |= 524288;
        this.rubyPackage_ = str;
    }

    private void setRubyPackageBytes(ByteString byteString) {
        this.rubyPackage_ = byteString.toStringUtf8();
        this.bitField0_ |= 524288;
    }

    private void setSwiftPrefix(String str) {
        str.getClass();
        this.bitField0_ |= 32768;
        this.swiftPrefix_ = str;
    }

    private void setSwiftPrefixBytes(ByteString byteString) {
        this.swiftPrefix_ = byteString.toStringUtf8();
        this.bitField0_ |= 32768;
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
                return new GoogleDescriptorProtos$FileOptions();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0015\u0000\u0001\u0001ϧ\u0015\u0000\u0001\u0001\u0001ဈ\u0000\bဈ\u0001\tဌ\u0005\nဇ\u0002\u000bဈ\u0006\u0010ဇ\u0007\u0011ဇ\b\u0012ဇ\t\u0014ဇ\u0003\u0017ဇ\u000b\u001bဇ\u0004\u001fဇ\f$ဈ\r%ဈ\u000e'ဈ\u000f(ဈ\u0010)ဈ\u0011*ဇ\n,ဈ\u0012-ဈ\u0013ϧЛ", new Object[]{"bitField0_", "javaPackage_", "javaOuterClassname_", "optimizeFor_", OptimizeMode.internalGetVerifier(), "javaMultipleFiles_", "goPackage_", "ccGenericServices_", "javaGenericServices_", "pyGenericServices_", "javaGenerateEqualsAndHash_", "deprecated_", "javaStringCheckUtf8_", "ccEnableArenas_", "objcClassPrefix_", "csharpNamespace_", "swiftPrefix_", "phpClassPrefix_", "phpNamespace_", "phpGenericServices_", "phpMetadataNamespace_", "rubyPackage_", "uninterpretedOption_", GoogleDescriptorProtos$UninterpretedOption.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDescriptorProtos$FileOptions> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDescriptorProtos$FileOptions.class) {
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

    public boolean getCcEnableArenas() {
        return this.ccEnableArenas_;
    }

    public boolean getCcGenericServices() {
        return this.ccGenericServices_;
    }

    public String getCsharpNamespace() {
        return this.csharpNamespace_;
    }

    public ByteString getCsharpNamespaceBytes() {
        return ByteString.copyFromUtf8(this.csharpNamespace_);
    }

    public boolean getDeprecated() {
        return this.deprecated_;
    }

    public String getGoPackage() {
        return this.goPackage_;
    }

    public ByteString getGoPackageBytes() {
        return ByteString.copyFromUtf8(this.goPackage_);
    }

    @Deprecated
    public boolean getJavaGenerateEqualsAndHash() {
        return this.javaGenerateEqualsAndHash_;
    }

    public boolean getJavaGenericServices() {
        return this.javaGenericServices_;
    }

    public boolean getJavaMultipleFiles() {
        return this.javaMultipleFiles_;
    }

    public String getJavaOuterClassname() {
        return this.javaOuterClassname_;
    }

    public ByteString getJavaOuterClassnameBytes() {
        return ByteString.copyFromUtf8(this.javaOuterClassname_);
    }

    public String getJavaPackage() {
        return this.javaPackage_;
    }

    public ByteString getJavaPackageBytes() {
        return ByteString.copyFromUtf8(this.javaPackage_);
    }

    public boolean getJavaStringCheckUtf8() {
        return this.javaStringCheckUtf8_;
    }

    public String getObjcClassPrefix() {
        return this.objcClassPrefix_;
    }

    public ByteString getObjcClassPrefixBytes() {
        return ByteString.copyFromUtf8(this.objcClassPrefix_);
    }

    public OptimizeMode getOptimizeFor() {
        OptimizeMode optimizeModeForNumber = OptimizeMode.forNumber(this.optimizeFor_);
        return optimizeModeForNumber == null ? OptimizeMode.SPEED : optimizeModeForNumber;
    }

    public String getPhpClassPrefix() {
        return this.phpClassPrefix_;
    }

    public ByteString getPhpClassPrefixBytes() {
        return ByteString.copyFromUtf8(this.phpClassPrefix_);
    }

    public boolean getPhpGenericServices() {
        return this.phpGenericServices_;
    }

    public String getPhpMetadataNamespace() {
        return this.phpMetadataNamespace_;
    }

    public ByteString getPhpMetadataNamespaceBytes() {
        return ByteString.copyFromUtf8(this.phpMetadataNamespace_);
    }

    public String getPhpNamespace() {
        return this.phpNamespace_;
    }

    public ByteString getPhpNamespaceBytes() {
        return ByteString.copyFromUtf8(this.phpNamespace_);
    }

    public boolean getPyGenericServices() {
        return this.pyGenericServices_;
    }

    public String getRubyPackage() {
        return this.rubyPackage_;
    }

    public ByteString getRubyPackageBytes() {
        return ByteString.copyFromUtf8(this.rubyPackage_);
    }

    public String getSwiftPrefix() {
        return this.swiftPrefix_;
    }

    public ByteString getSwiftPrefixBytes() {
        return ByteString.copyFromUtf8(this.swiftPrefix_);
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

    public boolean hasCcEnableArenas() {
        return (this.bitField0_ & 4096) != 0;
    }

    public boolean hasCcGenericServices() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasCsharpNamespace() {
        return (this.bitField0_ & 16384) != 0;
    }

    public boolean hasDeprecated() {
        return (this.bitField0_ & 2048) != 0;
    }

    public boolean hasGoPackage() {
        return (this.bitField0_ & 64) != 0;
    }

    @Deprecated
    public boolean hasJavaGenerateEqualsAndHash() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasJavaGenericServices() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasJavaMultipleFiles() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasJavaOuterClassname() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasJavaPackage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasJavaStringCheckUtf8() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasObjcClassPrefix() {
        return (this.bitField0_ & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
    }

    public boolean hasOptimizeFor() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasPhpClassPrefix() {
        return (this.bitField0_ & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0;
    }

    public boolean hasPhpGenericServices() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasPhpMetadataNamespace() {
        return (this.bitField0_ & 262144) != 0;
    }

    public boolean hasPhpNamespace() {
        return (this.bitField0_ & 131072) != 0;
    }

    public boolean hasPyGenericServices() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasRubyPackage() {
        return (this.bitField0_ & 524288) != 0;
    }

    public boolean hasSwiftPrefix() {
        return (this.bitField0_ & 32768) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<GoogleDescriptorProtos$FileOptions, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(GoogleDescriptorProtos$FileOptions.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder newBuilder(GoogleDescriptorProtos$FileOptions googleDescriptorProtos$FileOptions) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(googleDescriptorProtos$FileOptions);
    }

    public static GoogleDescriptorProtos$FileOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileOptions parseFrom(ByteString byteString) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDescriptorProtos$FileOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addUninterpretedOption(int i, GoogleDescriptorProtos$UninterpretedOption googleDescriptorProtos$UninterpretedOption) {
        googleDescriptorProtos$UninterpretedOption.getClass();
        ensureUninterpretedOptionIsMutable();
        this.uninterpretedOption_.add(i, googleDescriptorProtos$UninterpretedOption);
    }

    public static GoogleDescriptorProtos$FileOptions parseFrom(byte[] bArr) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDescriptorProtos$FileOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileOptions parseFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$FileOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileOptions parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDescriptorProtos$FileOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
