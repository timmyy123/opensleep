package com.google.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GoogleDescriptorProtos$MethodOptions;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleDescriptorProtos$MethodDescriptorProto extends GeneratedMessageLite<GoogleDescriptorProtos$MethodDescriptorProto, Builder> implements GoogleDescriptorProtos$MethodDescriptorProtoOrBuilder {
    public static final int CLIENT_STREAMING_FIELD_NUMBER = 5;
    private static final GoogleDescriptorProtos$MethodDescriptorProto DEFAULT_INSTANCE;
    public static final int INPUT_TYPE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 4;
    public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<GoogleDescriptorProtos$MethodDescriptorProto> PARSER = null;
    public static final int SERVER_STREAMING_FIELD_NUMBER = 6;
    private int bitField0_;
    private boolean clientStreaming_;
    private GoogleDescriptorProtos$MethodOptions options_;
    private boolean serverStreaming_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private String inputType_ = "";
    private String outputType_ = "";

    static {
        GoogleDescriptorProtos$MethodDescriptorProto googleDescriptorProtos$MethodDescriptorProto = new GoogleDescriptorProtos$MethodDescriptorProto();
        DEFAULT_INSTANCE = googleDescriptorProtos$MethodDescriptorProto;
        GeneratedMessageLite.registerDefaultInstance(GoogleDescriptorProtos$MethodDescriptorProto.class, googleDescriptorProtos$MethodDescriptorProto);
    }

    private GoogleDescriptorProtos$MethodDescriptorProto() {
    }

    private void clearClientStreaming() {
        this.bitField0_ &= -17;
        this.clientStreaming_ = false;
    }

    private void clearInputType() {
        this.bitField0_ &= -3;
        this.inputType_ = getDefaultInstance().getInputType();
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -9;
    }

    private void clearOutputType() {
        this.bitField0_ &= -5;
        this.outputType_ = getDefaultInstance().getOutputType();
    }

    private void clearServerStreaming() {
        this.bitField0_ &= -33;
        this.serverStreaming_ = false;
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOptions(GoogleDescriptorProtos$MethodOptions googleDescriptorProtos$MethodOptions) {
        googleDescriptorProtos$MethodOptions.getClass();
        GoogleDescriptorProtos$MethodOptions googleDescriptorProtos$MethodOptions2 = this.options_;
        if (googleDescriptorProtos$MethodOptions2 == null || googleDescriptorProtos$MethodOptions2 == GoogleDescriptorProtos$MethodOptions.getDefaultInstance()) {
            this.options_ = googleDescriptorProtos$MethodOptions;
        } else {
            this.options_ = ((GoogleDescriptorProtos$MethodOptions.Builder) GoogleDescriptorProtos$MethodOptions.newBuilder(this.options_).mergeFrom(googleDescriptorProtos$MethodOptions)).buildPartial();
        }
        this.bitField0_ |= 8;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDescriptorProtos$MethodDescriptorProto> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setClientStreaming(boolean z) {
        this.bitField0_ |= 16;
        this.clientStreaming_ = z;
    }

    private void setInputType(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.inputType_ = str;
    }

    private void setInputTypeBytes(ByteString byteString) {
        this.inputType_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
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

    private void setOptions(GoogleDescriptorProtos$MethodOptions googleDescriptorProtos$MethodOptions) {
        googleDescriptorProtos$MethodOptions.getClass();
        this.options_ = googleDescriptorProtos$MethodOptions;
        this.bitField0_ |= 8;
    }

    private void setOutputType(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.outputType_ = str;
    }

    private void setOutputTypeBytes(ByteString byteString) {
        this.outputType_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    private void setServerStreaming(boolean z) {
        this.bitField0_ |= 32;
        this.serverStreaming_ = z;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (GoogleDescriptorProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GoogleDescriptorProtos$MethodDescriptorProto();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ᐉ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"bitField0_", "name_", "inputType_", "outputType_", "options_", "clientStreaming_", "serverStreaming_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDescriptorProtos$MethodDescriptorProto> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDescriptorProtos$MethodDescriptorProto.class) {
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

    public boolean getClientStreaming() {
        return this.clientStreaming_;
    }

    public String getInputType() {
        return this.inputType_;
    }

    public ByteString getInputTypeBytes() {
        return ByteString.copyFromUtf8(this.inputType_);
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public GoogleDescriptorProtos$MethodOptions getOptions() {
        GoogleDescriptorProtos$MethodOptions googleDescriptorProtos$MethodOptions = this.options_;
        return googleDescriptorProtos$MethodOptions == null ? GoogleDescriptorProtos$MethodOptions.getDefaultInstance() : googleDescriptorProtos$MethodOptions;
    }

    public String getOutputType() {
        return this.outputType_;
    }

    public ByteString getOutputTypeBytes() {
        return ByteString.copyFromUtf8(this.outputType_);
    }

    public boolean getServerStreaming() {
        return this.serverStreaming_;
    }

    public boolean hasClientStreaming() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasInputType() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasOutputType() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasServerStreaming() {
        return (this.bitField0_ & 32) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<GoogleDescriptorProtos$MethodDescriptorProto, Builder> implements GoogleDescriptorProtos$MethodDescriptorProtoOrBuilder {
        private Builder() {
            super(GoogleDescriptorProtos$MethodDescriptorProto.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(GoogleDescriptorProtos$MethodDescriptorProto googleDescriptorProtos$MethodDescriptorProto) {
        return DEFAULT_INSTANCE.createBuilder(googleDescriptorProtos$MethodDescriptorProto);
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseFrom(ByteString byteString) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseFrom(byte[] bArr) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDescriptorProtos$MethodDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$MethodDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
