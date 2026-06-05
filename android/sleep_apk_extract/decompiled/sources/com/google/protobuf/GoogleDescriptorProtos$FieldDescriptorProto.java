package com.google.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GoogleDescriptorProtos$FieldOptions;
import com.google.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleDescriptorProtos$FieldDescriptorProto extends GeneratedMessageLite<GoogleDescriptorProtos$FieldDescriptorProto, Builder> implements GoogleDescriptorProtos$FieldDescriptorProtoOrBuilder {
    private static final GoogleDescriptorProtos$FieldDescriptorProto DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
    public static final int EXTENDEE_FIELD_NUMBER = 2;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int LABEL_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 9;
    public static final int OPTIONS_FIELD_NUMBER = 8;
    private static volatile Parser<GoogleDescriptorProtos$FieldDescriptorProto> PARSER = null;
    public static final int PROTO3_OPTIONAL_FIELD_NUMBER = 17;
    public static final int TYPE_FIELD_NUMBER = 5;
    public static final int TYPE_NAME_FIELD_NUMBER = 6;
    private int bitField0_;
    private int number_;
    private int oneofIndex_;
    private GoogleDescriptorProtos$FieldOptions options_;
    private boolean proto3Optional_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private int label_ = 1;
    private int type_ = 1;
    private String typeName_ = "";
    private String extendee_ = "";
    private String defaultValue_ = "";
    private String jsonName_ = "";

    /* JADX INFO: loaded from: classes4.dex */
    public enum Label implements Internal.EnumLite {
        LABEL_OPTIONAL(1),
        LABEL_REQUIRED(2),
        LABEL_REPEATED(3);

        private static final Internal.EnumLiteMap<Label> internalValueMap = new Internal.EnumLiteMap<Label>() { // from class: com.google.protobuf.GoogleDescriptorProtos.FieldDescriptorProto.Label.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Label findValueByNumber(int i) {
                return Label.forNumber(i);
            }
        };
        private final int value;

        public static final class LabelVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new LabelVerifier();

            private LabelVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return Label.forNumber(i) != null;
            }
        }

        Label(int i) {
            this.value = i;
        }

        public static Label forNumber(int i) {
            if (i == 1) {
                return LABEL_OPTIONAL;
            }
            if (i == 2) {
                return LABEL_REQUIRED;
            }
            if (i != 3) {
                return null;
            }
            return LABEL_REPEATED;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return LabelVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public enum Type implements Internal.EnumLite {
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18);

        private static final Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.google.protobuf.GoogleDescriptorProtos.FieldDescriptorProto.Type.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Type findValueByNumber(int i) {
                return Type.forNumber(i);
            }
        };
        private final int value;

        public static final class TypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new TypeVerifier();

            private TypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return Type.forNumber(i) != null;
            }
        }

        Type(int i) {
            this.value = i;
        }

        public static Type forNumber(int i) {
            switch (i) {
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return TypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        GoogleDescriptorProtos$FieldDescriptorProto googleDescriptorProtos$FieldDescriptorProto = new GoogleDescriptorProtos$FieldDescriptorProto();
        DEFAULT_INSTANCE = googleDescriptorProtos$FieldDescriptorProto;
        GeneratedMessageLite.registerDefaultInstance(GoogleDescriptorProtos$FieldDescriptorProto.class, googleDescriptorProtos$FieldDescriptorProto);
    }

    private GoogleDescriptorProtos$FieldDescriptorProto() {
    }

    private void clearDefaultValue() {
        this.bitField0_ &= -65;
        this.defaultValue_ = getDefaultInstance().getDefaultValue();
    }

    private void clearExtendee() {
        this.bitField0_ &= -33;
        this.extendee_ = getDefaultInstance().getExtendee();
    }

    private void clearJsonName() {
        this.bitField0_ &= -257;
        this.jsonName_ = getDefaultInstance().getJsonName();
    }

    private void clearLabel() {
        this.bitField0_ &= -5;
        this.label_ = 1;
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    private void clearNumber() {
        this.bitField0_ &= -3;
        this.number_ = 0;
    }

    private void clearOneofIndex() {
        this.bitField0_ &= -129;
        this.oneofIndex_ = 0;
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -513;
    }

    private void clearProto3Optional() {
        this.bitField0_ &= -1025;
        this.proto3Optional_ = false;
    }

    private void clearType() {
        this.bitField0_ &= -9;
        this.type_ = 1;
    }

    private void clearTypeName() {
        this.bitField0_ &= -17;
        this.typeName_ = getDefaultInstance().getTypeName();
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOptions(GoogleDescriptorProtos$FieldOptions googleDescriptorProtos$FieldOptions) {
        googleDescriptorProtos$FieldOptions.getClass();
        GoogleDescriptorProtos$FieldOptions googleDescriptorProtos$FieldOptions2 = this.options_;
        if (googleDescriptorProtos$FieldOptions2 == null || googleDescriptorProtos$FieldOptions2 == GoogleDescriptorProtos$FieldOptions.getDefaultInstance()) {
            this.options_ = googleDescriptorProtos$FieldOptions;
        } else {
            this.options_ = ((GoogleDescriptorProtos$FieldOptions.Builder) GoogleDescriptorProtos$FieldOptions.newBuilder(this.options_).mergeFrom(googleDescriptorProtos$FieldOptions)).buildPartial();
        }
        this.bitField0_ |= 512;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDescriptorProtos$FieldDescriptorProto> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDefaultValue(String str) {
        str.getClass();
        this.bitField0_ |= 64;
        this.defaultValue_ = str;
    }

    private void setDefaultValueBytes(ByteString byteString) {
        this.defaultValue_ = byteString.toStringUtf8();
        this.bitField0_ |= 64;
    }

    private void setExtendee(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.extendee_ = str;
    }

    private void setExtendeeBytes(ByteString byteString) {
        this.extendee_ = byteString.toStringUtf8();
        this.bitField0_ |= 32;
    }

    private void setJsonName(String str) {
        str.getClass();
        this.bitField0_ |= 256;
        this.jsonName_ = str;
    }

    private void setJsonNameBytes(ByteString byteString) {
        this.jsonName_ = byteString.toStringUtf8();
        this.bitField0_ |= 256;
    }

    private void setLabel(Label label) {
        this.label_ = label.getNumber();
        this.bitField0_ |= 4;
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

    private void setOneofIndex(int i) {
        this.bitField0_ |= 128;
        this.oneofIndex_ = i;
    }

    private void setOptions(GoogleDescriptorProtos$FieldOptions googleDescriptorProtos$FieldOptions) {
        googleDescriptorProtos$FieldOptions.getClass();
        this.options_ = googleDescriptorProtos$FieldOptions;
        this.bitField0_ |= 512;
    }

    private void setProto3Optional(boolean z) {
        this.bitField0_ |= 1024;
        this.proto3Optional_ = z;
    }

    private void setType(Type type) {
        this.type_ = type.getNumber();
        this.bitField0_ |= 8;
    }

    private void setTypeName(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.typeName_ = str;
    }

    private void setTypeNameBytes(ByteString byteString) {
        this.typeName_ = byteString.toStringUtf8();
        this.bitField0_ |= 16;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (GoogleDescriptorProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GoogleDescriptorProtos$FieldDescriptorProto();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001\u0011\u000b\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0005\u0003င\u0001\u0004ဌ\u0002\u0005ဌ\u0003\u0006ဈ\u0004\u0007ဈ\u0006\bᐉ\t\tင\u0007\nဈ\b\u0011ဇ\n", new Object[]{"bitField0_", "name_", "extendee_", "number_", "label_", Label.internalGetVerifier(), "type_", Type.internalGetVerifier(), "typeName_", "defaultValue_", "options_", "oneofIndex_", "jsonName_", "proto3Optional_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDescriptorProtos$FieldDescriptorProto> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDescriptorProtos$FieldDescriptorProto.class) {
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

    public String getDefaultValue() {
        return this.defaultValue_;
    }

    public ByteString getDefaultValueBytes() {
        return ByteString.copyFromUtf8(this.defaultValue_);
    }

    public String getExtendee() {
        return this.extendee_;
    }

    public ByteString getExtendeeBytes() {
        return ByteString.copyFromUtf8(this.extendee_);
    }

    public String getJsonName() {
        return this.jsonName_;
    }

    public ByteString getJsonNameBytes() {
        return ByteString.copyFromUtf8(this.jsonName_);
    }

    public Label getLabel() {
        Label labelForNumber = Label.forNumber(this.label_);
        return labelForNumber == null ? Label.LABEL_OPTIONAL : labelForNumber;
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

    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    public GoogleDescriptorProtos$FieldOptions getOptions() {
        GoogleDescriptorProtos$FieldOptions googleDescriptorProtos$FieldOptions = this.options_;
        return googleDescriptorProtos$FieldOptions == null ? GoogleDescriptorProtos$FieldOptions.getDefaultInstance() : googleDescriptorProtos$FieldOptions;
    }

    public boolean getProto3Optional() {
        return this.proto3Optional_;
    }

    public Type getType() {
        Type typeForNumber = Type.forNumber(this.type_);
        return typeForNumber == null ? Type.TYPE_DOUBLE : typeForNumber;
    }

    public String getTypeName() {
        return this.typeName_;
    }

    public ByteString getTypeNameBytes() {
        return ByteString.copyFromUtf8(this.typeName_);
    }

    public boolean hasDefaultValue() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasExtendee() {
        return (this.bitField0_ & 32) != 0;
    }

    public boolean hasJsonName() {
        return (this.bitField0_ & 256) != 0;
    }

    public boolean hasLabel() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasNumber() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasOneofIndex() {
        return (this.bitField0_ & 128) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 512) != 0;
    }

    public boolean hasProto3Optional() {
        return (this.bitField0_ & 1024) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasTypeName() {
        return (this.bitField0_ & 16) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<GoogleDescriptorProtos$FieldDescriptorProto, Builder> implements GoogleDescriptorProtos$FieldDescriptorProtoOrBuilder {
        private Builder() {
            super(GoogleDescriptorProtos$FieldDescriptorProto.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(GoogleDescriptorProtos$FieldDescriptorProto googleDescriptorProtos$FieldDescriptorProto) {
        return DEFAULT_INSTANCE.createBuilder(googleDescriptorProtos$FieldDescriptorProto);
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseFrom(ByteString byteString) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseFrom(byte[] bArr) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDescriptorProtos$FieldDescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FieldDescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
