package com.google.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GoogleDescriptorProtos$EnumValueOptions;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public final class GoogleDescriptorProtos$EnumValueDescriptorProto extends GeneratedMessageLite<GoogleDescriptorProtos$EnumValueDescriptorProto, Builder> implements GoogleDescriptorProtos$EnumValueDescriptorProtoOrBuilder {
    private static final GoogleDescriptorProtos$EnumValueDescriptorProto DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static volatile Parser<GoogleDescriptorProtos$EnumValueDescriptorProto> PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private int number_;
    private GoogleDescriptorProtos$EnumValueOptions options_;

    static {
        GoogleDescriptorProtos$EnumValueDescriptorProto googleDescriptorProtos$EnumValueDescriptorProto = new GoogleDescriptorProtos$EnumValueDescriptorProto();
        DEFAULT_INSTANCE = googleDescriptorProtos$EnumValueDescriptorProto;
        GeneratedMessageLite.registerDefaultInstance(GoogleDescriptorProtos$EnumValueDescriptorProto.class, googleDescriptorProtos$EnumValueDescriptorProto);
    }

    private GoogleDescriptorProtos$EnumValueDescriptorProto() {
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    private void clearNumber() {
        this.bitField0_ &= -3;
        this.number_ = 0;
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -5;
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOptions(GoogleDescriptorProtos$EnumValueOptions googleDescriptorProtos$EnumValueOptions) {
        googleDescriptorProtos$EnumValueOptions.getClass();
        GoogleDescriptorProtos$EnumValueOptions googleDescriptorProtos$EnumValueOptions2 = this.options_;
        if (googleDescriptorProtos$EnumValueOptions2 == null || googleDescriptorProtos$EnumValueOptions2 == GoogleDescriptorProtos$EnumValueOptions.getDefaultInstance()) {
            this.options_ = googleDescriptorProtos$EnumValueOptions;
        } else {
            this.options_ = ((GoogleDescriptorProtos$EnumValueOptions.Builder) GoogleDescriptorProtos$EnumValueOptions.newBuilder(this.options_).mergeFrom(googleDescriptorProtos$EnumValueOptions)).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDescriptorProtos$EnumValueDescriptorProto> parser() {
        return DEFAULT_INSTANCE.getParserForType();
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

    private void setNumber(int i) {
        this.bitField0_ |= 2;
        this.number_ = i;
    }

    private void setOptions(GoogleDescriptorProtos$EnumValueOptions googleDescriptorProtos$EnumValueOptions) {
        googleDescriptorProtos$EnumValueOptions.getClass();
        this.options_ = googleDescriptorProtos$EnumValueOptions;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (GoogleDescriptorProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GoogleDescriptorProtos$EnumValueDescriptorProto();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ဈ\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "name_", "number_", "options_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDescriptorProtos$EnumValueDescriptorProto> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDescriptorProtos$EnumValueDescriptorProto.class) {
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

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public int getNumber() {
        return this.number_;
    }

    public GoogleDescriptorProtos$EnumValueOptions getOptions() {
        GoogleDescriptorProtos$EnumValueOptions googleDescriptorProtos$EnumValueOptions = this.options_;
        return googleDescriptorProtos$EnumValueOptions == null ? GoogleDescriptorProtos$EnumValueOptions.getDefaultInstance() : googleDescriptorProtos$EnumValueOptions;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNumber() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<GoogleDescriptorProtos$EnumValueDescriptorProto, Builder> implements GoogleDescriptorProtos$EnumValueDescriptorProtoOrBuilder {
        private Builder() {
            super(GoogleDescriptorProtos$EnumValueDescriptorProto.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(GoogleDescriptorProtos$EnumValueDescriptorProto googleDescriptorProtos$EnumValueDescriptorProto) {
        return DEFAULT_INSTANCE.createBuilder(googleDescriptorProtos$EnumValueDescriptorProto);
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseFrom(ByteString byteString) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseFrom(byte[] bArr) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDescriptorProtos$EnumValueDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$EnumValueDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
