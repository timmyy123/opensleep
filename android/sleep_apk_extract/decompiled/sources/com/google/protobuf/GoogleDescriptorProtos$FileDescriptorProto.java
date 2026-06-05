package com.google.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GoogleDescriptorProtos$FileOptions;
import com.google.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleDescriptorProtos$FileDescriptorProto extends GeneratedMessageLite<GoogleDescriptorProtos$FileDescriptorProto, Builder> implements GoogleDescriptorProtos$FileDescriptorProtoOrBuilder {
    private static final GoogleDescriptorProtos$FileDescriptorProto DEFAULT_INSTANCE;
    public static final int DEPENDENCY_FIELD_NUMBER = 3;
    public static final int ENUM_TYPE_FIELD_NUMBER = 5;
    public static final int EXTENSION_FIELD_NUMBER = 7;
    public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    public static final int PACKAGE_FIELD_NUMBER = 2;
    private static volatile Parser<GoogleDescriptorProtos$FileDescriptorProto> PARSER = null;
    public static final int PUBLIC_DEPENDENCY_FIELD_NUMBER = 10;
    public static final int SERVICE_FIELD_NUMBER = 6;
    public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
    public static final int SYNTAX_FIELD_NUMBER = 12;
    public static final int WEAK_DEPENDENCY_FIELD_NUMBER = 11;
    private int bitField0_;
    private GoogleDescriptorProtos$FileOptions options_;
    private GoogleDescriptorProtos$SourceCodeInfo sourceCodeInfo_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private String package_ = "";
    private Internal.ProtobufList<String> dependency_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.IntList publicDependency_ = GeneratedMessageLite.emptyIntList();
    private Internal.IntList weakDependency_ = GeneratedMessageLite.emptyIntList();
    private Internal.ProtobufList<GoogleDescriptorProtos$DescriptorProto> messageType_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<GoogleDescriptorProtos$EnumDescriptorProto> enumType_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<GoogleDescriptorProtos$ServiceDescriptorProto> service_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<GoogleDescriptorProtos$FieldDescriptorProto> extension_ = GeneratedMessageLite.emptyProtobufList();
    private String syntax_ = "";

    static {
        GoogleDescriptorProtos$FileDescriptorProto googleDescriptorProtos$FileDescriptorProto = new GoogleDescriptorProtos$FileDescriptorProto();
        DEFAULT_INSTANCE = googleDescriptorProtos$FileDescriptorProto;
        GeneratedMessageLite.registerDefaultInstance(GoogleDescriptorProtos$FileDescriptorProto.class, googleDescriptorProtos$FileDescriptorProto);
    }

    private GoogleDescriptorProtos$FileDescriptorProto() {
    }

    private void addAllDependency(Iterable<String> iterable) {
        ensureDependencyIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.dependency_);
    }

    private void addAllEnumType(Iterable<? extends GoogleDescriptorProtos$EnumDescriptorProto> iterable) {
        ensureEnumTypeIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.enumType_);
    }

    private void addAllExtension(Iterable<? extends GoogleDescriptorProtos$FieldDescriptorProto> iterable) {
        ensureExtensionIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.extension_);
    }

    private void addAllMessageType(Iterable<? extends GoogleDescriptorProtos$DescriptorProto> iterable) {
        ensureMessageTypeIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.messageType_);
    }

    private void addAllPublicDependency(Iterable<? extends Integer> iterable) {
        ensurePublicDependencyIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.publicDependency_);
    }

    private void addAllService(Iterable<? extends GoogleDescriptorProtos$ServiceDescriptorProto> iterable) {
        ensureServiceIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.service_);
    }

    private void addAllWeakDependency(Iterable<? extends Integer> iterable) {
        ensureWeakDependencyIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.weakDependency_);
    }

    private void addDependency(String str) {
        str.getClass();
        ensureDependencyIsMutable();
        this.dependency_.add(str);
    }

    private void addDependencyBytes(ByteString byteString) {
        ensureDependencyIsMutable();
        this.dependency_.add(byteString.toStringUtf8());
    }

    private void addEnumType(GoogleDescriptorProtos$EnumDescriptorProto googleDescriptorProtos$EnumDescriptorProto) {
        googleDescriptorProtos$EnumDescriptorProto.getClass();
        ensureEnumTypeIsMutable();
        this.enumType_.add(googleDescriptorProtos$EnumDescriptorProto);
    }

    private void addExtension(GoogleDescriptorProtos$FieldDescriptorProto googleDescriptorProtos$FieldDescriptorProto) {
        googleDescriptorProtos$FieldDescriptorProto.getClass();
        ensureExtensionIsMutable();
        this.extension_.add(googleDescriptorProtos$FieldDescriptorProto);
    }

    private void addMessageType(GoogleDescriptorProtos$DescriptorProto googleDescriptorProtos$DescriptorProto) {
        googleDescriptorProtos$DescriptorProto.getClass();
        ensureMessageTypeIsMutable();
        this.messageType_.add(googleDescriptorProtos$DescriptorProto);
    }

    private void addPublicDependency(int i) {
        ensurePublicDependencyIsMutable();
        this.publicDependency_.addInt(i);
    }

    private void addService(GoogleDescriptorProtos$ServiceDescriptorProto googleDescriptorProtos$ServiceDescriptorProto) {
        googleDescriptorProtos$ServiceDescriptorProto.getClass();
        ensureServiceIsMutable();
        this.service_.add(googleDescriptorProtos$ServiceDescriptorProto);
    }

    private void addWeakDependency(int i) {
        ensureWeakDependencyIsMutable();
        this.weakDependency_.addInt(i);
    }

    private void clearDependency() {
        this.dependency_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearEnumType() {
        this.enumType_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearExtension() {
        this.extension_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearMessageType() {
        this.messageType_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -5;
    }

    private void clearPackage() {
        this.bitField0_ &= -3;
        this.package_ = getDefaultInstance().getPackage();
    }

    private void clearPublicDependency() {
        this.publicDependency_ = GeneratedMessageLite.emptyIntList();
    }

    private void clearService() {
        this.service_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearSourceCodeInfo() {
        this.sourceCodeInfo_ = null;
        this.bitField0_ &= -9;
    }

    private void clearSyntax() {
        this.bitField0_ &= -17;
        this.syntax_ = getDefaultInstance().getSyntax();
    }

    private void clearWeakDependency() {
        this.weakDependency_ = GeneratedMessageLite.emptyIntList();
    }

    private void ensureDependencyIsMutable() {
        Internal.ProtobufList<String> protobufList = this.dependency_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.dependency_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureEnumTypeIsMutable() {
        Internal.ProtobufList<GoogleDescriptorProtos$EnumDescriptorProto> protobufList = this.enumType_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.enumType_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureExtensionIsMutable() {
        Internal.ProtobufList<GoogleDescriptorProtos$FieldDescriptorProto> protobufList = this.extension_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.extension_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureMessageTypeIsMutable() {
        Internal.ProtobufList<GoogleDescriptorProtos$DescriptorProto> protobufList = this.messageType_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.messageType_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensurePublicDependencyIsMutable() {
        Internal.IntList intList = this.publicDependency_;
        if (intList.isModifiable()) {
            return;
        }
        this.publicDependency_ = GeneratedMessageLite.mutableCopy(intList);
    }

    private void ensureServiceIsMutable() {
        Internal.ProtobufList<GoogleDescriptorProtos$ServiceDescriptorProto> protobufList = this.service_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.service_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureWeakDependencyIsMutable() {
        Internal.IntList intList = this.weakDependency_;
        if (intList.isModifiable()) {
            return;
        }
        this.weakDependency_ = GeneratedMessageLite.mutableCopy(intList);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOptions(GoogleDescriptorProtos$FileOptions googleDescriptorProtos$FileOptions) {
        googleDescriptorProtos$FileOptions.getClass();
        GoogleDescriptorProtos$FileOptions googleDescriptorProtos$FileOptions2 = this.options_;
        if (googleDescriptorProtos$FileOptions2 == null || googleDescriptorProtos$FileOptions2 == GoogleDescriptorProtos$FileOptions.getDefaultInstance()) {
            this.options_ = googleDescriptorProtos$FileOptions;
        } else {
            this.options_ = ((GoogleDescriptorProtos$FileOptions.Builder) GoogleDescriptorProtos$FileOptions.newBuilder(this.options_).mergeFrom(googleDescriptorProtos$FileOptions)).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    private void mergeSourceCodeInfo(GoogleDescriptorProtos$SourceCodeInfo googleDescriptorProtos$SourceCodeInfo) {
        googleDescriptorProtos$SourceCodeInfo.getClass();
        GoogleDescriptorProtos$SourceCodeInfo googleDescriptorProtos$SourceCodeInfo2 = this.sourceCodeInfo_;
        if (googleDescriptorProtos$SourceCodeInfo2 == null || googleDescriptorProtos$SourceCodeInfo2 == GoogleDescriptorProtos$SourceCodeInfo.getDefaultInstance()) {
            this.sourceCodeInfo_ = googleDescriptorProtos$SourceCodeInfo;
        } else {
            this.sourceCodeInfo_ = GoogleDescriptorProtos$SourceCodeInfo.newBuilder(this.sourceCodeInfo_).mergeFrom(googleDescriptorProtos$SourceCodeInfo).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDescriptorProtos$FileDescriptorProto> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeEnumType(int i) {
        ensureEnumTypeIsMutable();
        this.enumType_.remove(i);
    }

    private void removeExtension(int i) {
        ensureExtensionIsMutable();
        this.extension_.remove(i);
    }

    private void removeMessageType(int i) {
        ensureMessageTypeIsMutable();
        this.messageType_.remove(i);
    }

    private void removeService(int i) {
        ensureServiceIsMutable();
        this.service_.remove(i);
    }

    private void setDependency(int i, String str) {
        str.getClass();
        ensureDependencyIsMutable();
        this.dependency_.set(i, str);
    }

    private void setEnumType(int i, GoogleDescriptorProtos$EnumDescriptorProto googleDescriptorProtos$EnumDescriptorProto) {
        googleDescriptorProtos$EnumDescriptorProto.getClass();
        ensureEnumTypeIsMutable();
        this.enumType_.set(i, googleDescriptorProtos$EnumDescriptorProto);
    }

    private void setExtension(int i, GoogleDescriptorProtos$FieldDescriptorProto googleDescriptorProtos$FieldDescriptorProto) {
        googleDescriptorProtos$FieldDescriptorProto.getClass();
        ensureExtensionIsMutable();
        this.extension_.set(i, googleDescriptorProtos$FieldDescriptorProto);
    }

    private void setMessageType(int i, GoogleDescriptorProtos$DescriptorProto googleDescriptorProtos$DescriptorProto) {
        googleDescriptorProtos$DescriptorProto.getClass();
        ensureMessageTypeIsMutable();
        this.messageType_.set(i, googleDescriptorProtos$DescriptorProto);
    }

    private void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    private void setNameBytes(ByteString byteString) {
        this.name_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    private void setOptions(GoogleDescriptorProtos$FileOptions googleDescriptorProtos$FileOptions) {
        googleDescriptorProtos$FileOptions.getClass();
        this.options_ = googleDescriptorProtos$FileOptions;
        this.bitField0_ |= 4;
    }

    private void setPackage(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.package_ = str;
    }

    private void setPackageBytes(ByteString byteString) {
        this.package_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    private void setPublicDependency(int i, int i2) {
        ensurePublicDependencyIsMutable();
        this.publicDependency_.setInt(i, i2);
    }

    private void setService(int i, GoogleDescriptorProtos$ServiceDescriptorProto googleDescriptorProtos$ServiceDescriptorProto) {
        googleDescriptorProtos$ServiceDescriptorProto.getClass();
        ensureServiceIsMutable();
        this.service_.set(i, googleDescriptorProtos$ServiceDescriptorProto);
    }

    private void setSourceCodeInfo(GoogleDescriptorProtos$SourceCodeInfo googleDescriptorProtos$SourceCodeInfo) {
        googleDescriptorProtos$SourceCodeInfo.getClass();
        this.sourceCodeInfo_ = googleDescriptorProtos$SourceCodeInfo;
        this.bitField0_ |= 8;
    }

    private void setSyntax(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.syntax_ = str;
    }

    private void setSyntaxBytes(ByteString byteString) {
        this.syntax_ = byteString.toStringUtf8();
        this.bitField0_ |= 16;
    }

    private void setWeakDependency(int i, int i2) {
        ensureWeakDependencyIsMutable();
        this.weakDependency_.setInt(i, i2);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (GoogleDescriptorProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GoogleDescriptorProtos$FileDescriptorProto();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0007\u0005\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004Л\u0005Л\u0006Л\u0007Л\bᐉ\u0002\tဉ\u0003\n\u0016\u000b\u0016\fဈ\u0004", new Object[]{"bitField0_", "name_", "package_", "dependency_", "messageType_", GoogleDescriptorProtos$DescriptorProto.class, "enumType_", GoogleDescriptorProtos$EnumDescriptorProto.class, "service_", GoogleDescriptorProtos$ServiceDescriptorProto.class, "extension_", GoogleDescriptorProtos$FieldDescriptorProto.class, "options_", "sourceCodeInfo_", "publicDependency_", "weakDependency_", "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDescriptorProtos$FileDescriptorProto> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDescriptorProtos$FileDescriptorProto.class) {
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

    public String getDependency(int i) {
        return this.dependency_.get(i);
    }

    public ByteString getDependencyBytes(int i) {
        return ByteString.copyFromUtf8(this.dependency_.get(i));
    }

    public int getDependencyCount() {
        return this.dependency_.size();
    }

    public List<String> getDependencyList() {
        return this.dependency_;
    }

    public GoogleDescriptorProtos$EnumDescriptorProto getEnumType(int i) {
        return this.enumType_.get(i);
    }

    public int getEnumTypeCount() {
        return this.enumType_.size();
    }

    public List<GoogleDescriptorProtos$EnumDescriptorProto> getEnumTypeList() {
        return this.enumType_;
    }

    public GoogleDescriptorProtos$EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i) {
        return this.enumType_.get(i);
    }

    public List<? extends GoogleDescriptorProtos$EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
        return this.enumType_;
    }

    public GoogleDescriptorProtos$FieldDescriptorProto getExtension(int i) {
        return this.extension_.get(i);
    }

    public int getExtensionCount() {
        return this.extension_.size();
    }

    public List<GoogleDescriptorProtos$FieldDescriptorProto> getExtensionList() {
        return this.extension_;
    }

    public GoogleDescriptorProtos$FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i) {
        return this.extension_.get(i);
    }

    public List<? extends GoogleDescriptorProtos$FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
        return this.extension_;
    }

    public GoogleDescriptorProtos$DescriptorProto getMessageType(int i) {
        return this.messageType_.get(i);
    }

    public int getMessageTypeCount() {
        return this.messageType_.size();
    }

    public List<GoogleDescriptorProtos$DescriptorProto> getMessageTypeList() {
        return this.messageType_;
    }

    public GoogleDescriptorProtos$DescriptorProtoOrBuilder getMessageTypeOrBuilder(int i) {
        return this.messageType_.get(i);
    }

    public List<? extends GoogleDescriptorProtos$DescriptorProtoOrBuilder> getMessageTypeOrBuilderList() {
        return this.messageType_;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public GoogleDescriptorProtos$FileOptions getOptions() {
        GoogleDescriptorProtos$FileOptions googleDescriptorProtos$FileOptions = this.options_;
        return googleDescriptorProtos$FileOptions == null ? GoogleDescriptorProtos$FileOptions.getDefaultInstance() : googleDescriptorProtos$FileOptions;
    }

    public String getPackage() {
        return this.package_;
    }

    public ByteString getPackageBytes() {
        return ByteString.copyFromUtf8(this.package_);
    }

    public int getPublicDependency(int i) {
        return this.publicDependency_.getInt(i);
    }

    public int getPublicDependencyCount() {
        return this.publicDependency_.size();
    }

    public List<Integer> getPublicDependencyList() {
        return this.publicDependency_;
    }

    public GoogleDescriptorProtos$ServiceDescriptorProto getService(int i) {
        return this.service_.get(i);
    }

    public int getServiceCount() {
        return this.service_.size();
    }

    public List<GoogleDescriptorProtos$ServiceDescriptorProto> getServiceList() {
        return this.service_;
    }

    public GoogleDescriptorProtos$ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int i) {
        return this.service_.get(i);
    }

    public List<? extends GoogleDescriptorProtos$ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList() {
        return this.service_;
    }

    public GoogleDescriptorProtos$SourceCodeInfo getSourceCodeInfo() {
        GoogleDescriptorProtos$SourceCodeInfo googleDescriptorProtos$SourceCodeInfo = this.sourceCodeInfo_;
        return googleDescriptorProtos$SourceCodeInfo == null ? GoogleDescriptorProtos$SourceCodeInfo.getDefaultInstance() : googleDescriptorProtos$SourceCodeInfo;
    }

    public String getSyntax() {
        return this.syntax_;
    }

    public ByteString getSyntaxBytes() {
        return ByteString.copyFromUtf8(this.syntax_);
    }

    public int getWeakDependency(int i) {
        return this.weakDependency_.getInt(i);
    }

    public int getWeakDependencyCount() {
        return this.weakDependency_.size();
    }

    public List<Integer> getWeakDependencyList() {
        return this.weakDependency_;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasPackage() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSourceCodeInfo() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasSyntax() {
        return (this.bitField0_ & 16) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<GoogleDescriptorProtos$FileDescriptorProto, Builder> implements GoogleDescriptorProtos$FileDescriptorProtoOrBuilder {
        private Builder() {
            super(GoogleDescriptorProtos$FileDescriptorProto.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(GoogleDescriptorProtos$FileDescriptorProto googleDescriptorProtos$FileDescriptorProto) {
        return DEFAULT_INSTANCE.createBuilder(googleDescriptorProtos$FileDescriptorProto);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseFrom(ByteString byteString) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addEnumType(int i, GoogleDescriptorProtos$EnumDescriptorProto googleDescriptorProtos$EnumDescriptorProto) {
        googleDescriptorProtos$EnumDescriptorProto.getClass();
        ensureEnumTypeIsMutable();
        this.enumType_.add(i, googleDescriptorProtos$EnumDescriptorProto);
    }

    private void addExtension(int i, GoogleDescriptorProtos$FieldDescriptorProto googleDescriptorProtos$FieldDescriptorProto) {
        googleDescriptorProtos$FieldDescriptorProto.getClass();
        ensureExtensionIsMutable();
        this.extension_.add(i, googleDescriptorProtos$FieldDescriptorProto);
    }

    private void addMessageType(int i, GoogleDescriptorProtos$DescriptorProto googleDescriptorProtos$DescriptorProto) {
        googleDescriptorProtos$DescriptorProto.getClass();
        ensureMessageTypeIsMutable();
        this.messageType_.add(i, googleDescriptorProtos$DescriptorProto);
    }

    private void addService(int i, GoogleDescriptorProtos$ServiceDescriptorProto googleDescriptorProtos$ServiceDescriptorProto) {
        googleDescriptorProtos$ServiceDescriptorProto.getClass();
        ensureServiceIsMutable();
        this.service_.add(i, googleDescriptorProtos$ServiceDescriptorProto);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseFrom(byte[] bArr) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDescriptorProtos$FileDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
