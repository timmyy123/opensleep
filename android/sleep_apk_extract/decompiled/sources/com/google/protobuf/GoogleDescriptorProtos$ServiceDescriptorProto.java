package com.google.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GoogleDescriptorProtos$ServiceOptions;
import com.google.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleDescriptorProtos$ServiceDescriptorProto extends GeneratedMessageLite<GoogleDescriptorProtos$ServiceDescriptorProto, Builder> implements GoogleDescriptorProtos$ServiceDescriptorProtoOrBuilder {
    private static final GoogleDescriptorProtos$ServiceDescriptorProto DEFAULT_INSTANCE;
    public static final int METHOD_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<GoogleDescriptorProtos$ServiceDescriptorProto> PARSER;
    private int bitField0_;
    private GoogleDescriptorProtos$ServiceOptions options_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private Internal.ProtobufList<GoogleDescriptorProtos$MethodDescriptorProto> method_ = GeneratedMessageLite.emptyProtobufList();

    static {
        GoogleDescriptorProtos$ServiceDescriptorProto googleDescriptorProtos$ServiceDescriptorProto = new GoogleDescriptorProtos$ServiceDescriptorProto();
        DEFAULT_INSTANCE = googleDescriptorProtos$ServiceDescriptorProto;
        GeneratedMessageLite.registerDefaultInstance(GoogleDescriptorProtos$ServiceDescriptorProto.class, googleDescriptorProtos$ServiceDescriptorProto);
    }

    private GoogleDescriptorProtos$ServiceDescriptorProto() {
    }

    private void addAllMethod(Iterable<? extends GoogleDescriptorProtos$MethodDescriptorProto> iterable) {
        ensureMethodIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.method_);
    }

    private void addMethod(GoogleDescriptorProtos$MethodDescriptorProto googleDescriptorProtos$MethodDescriptorProto) {
        googleDescriptorProtos$MethodDescriptorProto.getClass();
        ensureMethodIsMutable();
        this.method_.add(googleDescriptorProtos$MethodDescriptorProto);
    }

    private void clearMethod() {
        this.method_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -3;
    }

    private void ensureMethodIsMutable() {
        Internal.ProtobufList<GoogleDescriptorProtos$MethodDescriptorProto> protobufList = this.method_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.method_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOptions(GoogleDescriptorProtos$ServiceOptions googleDescriptorProtos$ServiceOptions) {
        googleDescriptorProtos$ServiceOptions.getClass();
        GoogleDescriptorProtos$ServiceOptions googleDescriptorProtos$ServiceOptions2 = this.options_;
        if (googleDescriptorProtos$ServiceOptions2 == null || googleDescriptorProtos$ServiceOptions2 == GoogleDescriptorProtos$ServiceOptions.getDefaultInstance()) {
            this.options_ = googleDescriptorProtos$ServiceOptions;
        } else {
            this.options_ = ((GoogleDescriptorProtos$ServiceOptions.Builder) GoogleDescriptorProtos$ServiceOptions.newBuilder(this.options_).mergeFrom(googleDescriptorProtos$ServiceOptions)).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDescriptorProtos$ServiceDescriptorProto> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeMethod(int i) {
        ensureMethodIsMutable();
        this.method_.remove(i);
    }

    private void setMethod(int i, GoogleDescriptorProtos$MethodDescriptorProto googleDescriptorProtos$MethodDescriptorProto) {
        googleDescriptorProtos$MethodDescriptorProto.getClass();
        ensureMethodIsMutable();
        this.method_.set(i, googleDescriptorProtos$MethodDescriptorProto);
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

    private void setOptions(GoogleDescriptorProtos$ServiceOptions googleDescriptorProtos$ServiceOptions) {
        googleDescriptorProtos$ServiceOptions.getClass();
        this.options_ = googleDescriptorProtos$ServiceOptions;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (GoogleDescriptorProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GoogleDescriptorProtos$ServiceDescriptorProto();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001ဈ\u0000\u0002Л\u0003ᐉ\u0001", new Object[]{"bitField0_", "name_", "method_", GoogleDescriptorProtos$MethodDescriptorProto.class, "options_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDescriptorProtos$ServiceDescriptorProto> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDescriptorProtos$ServiceDescriptorProto.class) {
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

    public GoogleDescriptorProtos$MethodDescriptorProto getMethod(int i) {
        return this.method_.get(i);
    }

    public int getMethodCount() {
        return this.method_.size();
    }

    public List<GoogleDescriptorProtos$MethodDescriptorProto> getMethodList() {
        return this.method_;
    }

    public GoogleDescriptorProtos$MethodDescriptorProtoOrBuilder getMethodOrBuilder(int i) {
        return this.method_.get(i);
    }

    public List<? extends GoogleDescriptorProtos$MethodDescriptorProtoOrBuilder> getMethodOrBuilderList() {
        return this.method_;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public GoogleDescriptorProtos$ServiceOptions getOptions() {
        GoogleDescriptorProtos$ServiceOptions googleDescriptorProtos$ServiceOptions = this.options_;
        return googleDescriptorProtos$ServiceOptions == null ? GoogleDescriptorProtos$ServiceOptions.getDefaultInstance() : googleDescriptorProtos$ServiceOptions;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<GoogleDescriptorProtos$ServiceDescriptorProto, Builder> implements GoogleDescriptorProtos$ServiceDescriptorProtoOrBuilder {
        private Builder() {
            super(GoogleDescriptorProtos$ServiceDescriptorProto.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(GoogleDescriptorProtos$ServiceDescriptorProto googleDescriptorProtos$ServiceDescriptorProto) {
        return DEFAULT_INSTANCE.createBuilder(googleDescriptorProtos$ServiceDescriptorProto);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseFrom(ByteString byteString) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addMethod(int i, GoogleDescriptorProtos$MethodDescriptorProto googleDescriptorProtos$MethodDescriptorProto) {
        googleDescriptorProtos$MethodDescriptorProto.getClass();
        ensureMethodIsMutable();
        this.method_.add(i, googleDescriptorProtos$MethodDescriptorProto);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseFrom(byte[] bArr) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDescriptorProtos$ServiceDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$ServiceDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
