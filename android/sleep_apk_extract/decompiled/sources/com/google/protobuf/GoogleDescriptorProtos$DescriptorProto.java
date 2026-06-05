package com.google.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GoogleDescriptorProtos$ExtensionRangeOptions;
import com.google.protobuf.GoogleDescriptorProtos$MessageOptions;
import com.google.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleDescriptorProtos$DescriptorProto extends GeneratedMessageLite<GoogleDescriptorProtos$DescriptorProto, Builder> implements GoogleDescriptorProtos$DescriptorProtoOrBuilder {
    private static final GoogleDescriptorProtos$DescriptorProto DEFAULT_INSTANCE;
    public static final int ENUM_TYPE_FIELD_NUMBER = 4;
    public static final int EXTENSION_FIELD_NUMBER = 6;
    public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
    public static final int FIELD_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NESTED_TYPE_FIELD_NUMBER = 3;
    public static final int ONEOF_DECL_FIELD_NUMBER = 8;
    public static final int OPTIONS_FIELD_NUMBER = 7;
    private static volatile Parser<GoogleDescriptorProtos$DescriptorProto> PARSER = null;
    public static final int RESERVED_NAME_FIELD_NUMBER = 10;
    public static final int RESERVED_RANGE_FIELD_NUMBER = 9;
    private int bitField0_;
    private GoogleDescriptorProtos$MessageOptions options_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private Internal.ProtobufList<GoogleDescriptorProtos$FieldDescriptorProto> field_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<GoogleDescriptorProtos$FieldDescriptorProto> extension_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<GoogleDescriptorProtos$DescriptorProto> nestedType_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<GoogleDescriptorProtos$EnumDescriptorProto> enumType_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<ExtensionRange> extensionRange_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<GoogleDescriptorProtos$OneofDescriptorProto> oneofDecl_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<ReservedRange> reservedRange_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> reservedName_ = GeneratedMessageLite.emptyProtobufList();

    public interface ExtensionRangeOrBuilder extends MessageLiteOrBuilder {
    }

    public interface ReservedRangeOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        GoogleDescriptorProtos$DescriptorProto googleDescriptorProtos$DescriptorProto = new GoogleDescriptorProtos$DescriptorProto();
        DEFAULT_INSTANCE = googleDescriptorProtos$DescriptorProto;
        GeneratedMessageLite.registerDefaultInstance(GoogleDescriptorProtos$DescriptorProto.class, googleDescriptorProtos$DescriptorProto);
    }

    private GoogleDescriptorProtos$DescriptorProto() {
    }

    private void addAllEnumType(Iterable<? extends GoogleDescriptorProtos$EnumDescriptorProto> iterable) {
        ensureEnumTypeIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.enumType_);
    }

    private void addAllExtension(Iterable<? extends GoogleDescriptorProtos$FieldDescriptorProto> iterable) {
        ensureExtensionIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.extension_);
    }

    private void addAllExtensionRange(Iterable<? extends ExtensionRange> iterable) {
        ensureExtensionRangeIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.extensionRange_);
    }

    private void addAllField(Iterable<? extends GoogleDescriptorProtos$FieldDescriptorProto> iterable) {
        ensureFieldIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.field_);
    }

    private void addAllNestedType(Iterable<? extends GoogleDescriptorProtos$DescriptorProto> iterable) {
        ensureNestedTypeIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.nestedType_);
    }

    private void addAllOneofDecl(Iterable<? extends GoogleDescriptorProtos$OneofDescriptorProto> iterable) {
        ensureOneofDeclIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.oneofDecl_);
    }

    private void addAllReservedName(Iterable<String> iterable) {
        ensureReservedNameIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.reservedName_);
    }

    private void addAllReservedRange(Iterable<? extends ReservedRange> iterable) {
        ensureReservedRangeIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.reservedRange_);
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

    private void addExtensionRange(ExtensionRange extensionRange) {
        extensionRange.getClass();
        ensureExtensionRangeIsMutable();
        this.extensionRange_.add(extensionRange);
    }

    private void addField(GoogleDescriptorProtos$FieldDescriptorProto googleDescriptorProtos$FieldDescriptorProto) {
        googleDescriptorProtos$FieldDescriptorProto.getClass();
        ensureFieldIsMutable();
        this.field_.add(googleDescriptorProtos$FieldDescriptorProto);
    }

    private void addNestedType(GoogleDescriptorProtos$DescriptorProto googleDescriptorProtos$DescriptorProto) {
        googleDescriptorProtos$DescriptorProto.getClass();
        ensureNestedTypeIsMutable();
        this.nestedType_.add(googleDescriptorProtos$DescriptorProto);
    }

    private void addOneofDecl(GoogleDescriptorProtos$OneofDescriptorProto googleDescriptorProtos$OneofDescriptorProto) {
        googleDescriptorProtos$OneofDescriptorProto.getClass();
        ensureOneofDeclIsMutable();
        this.oneofDecl_.add(googleDescriptorProtos$OneofDescriptorProto);
    }

    private void addReservedName(String str) {
        str.getClass();
        ensureReservedNameIsMutable();
        this.reservedName_.add(str);
    }

    private void addReservedNameBytes(ByteString byteString) {
        ensureReservedNameIsMutable();
        this.reservedName_.add(byteString.toStringUtf8());
    }

    private void addReservedRange(ReservedRange reservedRange) {
        reservedRange.getClass();
        ensureReservedRangeIsMutable();
        this.reservedRange_.add(reservedRange);
    }

    private void clearEnumType() {
        this.enumType_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearExtension() {
        this.extension_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearExtensionRange() {
        this.extensionRange_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearField() {
        this.field_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    private void clearNestedType() {
        this.nestedType_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearOneofDecl() {
        this.oneofDecl_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearOptions() {
        this.options_ = null;
        this.bitField0_ &= -3;
    }

    private void clearReservedName() {
        this.reservedName_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearReservedRange() {
        this.reservedRange_ = GeneratedMessageLite.emptyProtobufList();
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

    private void ensureExtensionRangeIsMutable() {
        Internal.ProtobufList<ExtensionRange> protobufList = this.extensionRange_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.extensionRange_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureFieldIsMutable() {
        Internal.ProtobufList<GoogleDescriptorProtos$FieldDescriptorProto> protobufList = this.field_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.field_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureNestedTypeIsMutable() {
        Internal.ProtobufList<GoogleDescriptorProtos$DescriptorProto> protobufList = this.nestedType_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.nestedType_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureOneofDeclIsMutable() {
        Internal.ProtobufList<GoogleDescriptorProtos$OneofDescriptorProto> protobufList = this.oneofDecl_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.oneofDecl_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureReservedNameIsMutable() {
        Internal.ProtobufList<String> protobufList = this.reservedName_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.reservedName_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureReservedRangeIsMutable() {
        Internal.ProtobufList<ReservedRange> protobufList = this.reservedRange_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.reservedRange_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static GoogleDescriptorProtos$DescriptorProto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOptions(GoogleDescriptorProtos$MessageOptions googleDescriptorProtos$MessageOptions) {
        googleDescriptorProtos$MessageOptions.getClass();
        GoogleDescriptorProtos$MessageOptions googleDescriptorProtos$MessageOptions2 = this.options_;
        if (googleDescriptorProtos$MessageOptions2 == null || googleDescriptorProtos$MessageOptions2 == GoogleDescriptorProtos$MessageOptions.getDefaultInstance()) {
            this.options_ = googleDescriptorProtos$MessageOptions;
        } else {
            this.options_ = ((GoogleDescriptorProtos$MessageOptions.Builder) GoogleDescriptorProtos$MessageOptions.newBuilder(this.options_).mergeFrom(googleDescriptorProtos$MessageOptions)).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDescriptorProtos$DescriptorProto parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$DescriptorProto parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDescriptorProtos$DescriptorProto> parser() {
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

    private void removeExtensionRange(int i) {
        ensureExtensionRangeIsMutable();
        this.extensionRange_.remove(i);
    }

    private void removeField(int i) {
        ensureFieldIsMutable();
        this.field_.remove(i);
    }

    private void removeNestedType(int i) {
        ensureNestedTypeIsMutable();
        this.nestedType_.remove(i);
    }

    private void removeOneofDecl(int i) {
        ensureOneofDeclIsMutable();
        this.oneofDecl_.remove(i);
    }

    private void removeReservedRange(int i) {
        ensureReservedRangeIsMutable();
        this.reservedRange_.remove(i);
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

    private void setExtensionRange(int i, ExtensionRange extensionRange) {
        extensionRange.getClass();
        ensureExtensionRangeIsMutable();
        this.extensionRange_.set(i, extensionRange);
    }

    private void setField(int i, GoogleDescriptorProtos$FieldDescriptorProto googleDescriptorProtos$FieldDescriptorProto) {
        googleDescriptorProtos$FieldDescriptorProto.getClass();
        ensureFieldIsMutable();
        this.field_.set(i, googleDescriptorProtos$FieldDescriptorProto);
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

    private void setNestedType(int i, GoogleDescriptorProtos$DescriptorProto googleDescriptorProtos$DescriptorProto) {
        googleDescriptorProtos$DescriptorProto.getClass();
        ensureNestedTypeIsMutable();
        this.nestedType_.set(i, googleDescriptorProtos$DescriptorProto);
    }

    private void setOneofDecl(int i, GoogleDescriptorProtos$OneofDescriptorProto googleDescriptorProtos$OneofDescriptorProto) {
        googleDescriptorProtos$OneofDescriptorProto.getClass();
        ensureOneofDeclIsMutable();
        this.oneofDecl_.set(i, googleDescriptorProtos$OneofDescriptorProto);
    }

    private void setOptions(GoogleDescriptorProtos$MessageOptions googleDescriptorProtos$MessageOptions) {
        googleDescriptorProtos$MessageOptions.getClass();
        this.options_ = googleDescriptorProtos$MessageOptions;
        this.bitField0_ |= 2;
    }

    private void setReservedName(int i, String str) {
        str.getClass();
        ensureReservedNameIsMutable();
        this.reservedName_.set(i, str);
    }

    private void setReservedRange(int i, ReservedRange reservedRange) {
        reservedRange.getClass();
        ensureReservedRangeIsMutable();
        this.reservedRange_.set(i, reservedRange);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (GoogleDescriptorProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GoogleDescriptorProtos$DescriptorProto();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\b\u0007\u0001ဈ\u0000\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007ᐉ\u0001\bЛ\t\u001b\n\u001a", new Object[]{"bitField0_", "name_", "field_", GoogleDescriptorProtos$FieldDescriptorProto.class, "nestedType_", GoogleDescriptorProtos$DescriptorProto.class, "enumType_", GoogleDescriptorProtos$EnumDescriptorProto.class, "extensionRange_", ExtensionRange.class, "extension_", GoogleDescriptorProtos$FieldDescriptorProto.class, "options_", "oneofDecl_", GoogleDescriptorProtos$OneofDescriptorProto.class, "reservedRange_", ReservedRange.class, "reservedName_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDescriptorProtos$DescriptorProto> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDescriptorProtos$DescriptorProto.class) {
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

    public ExtensionRange getExtensionRange(int i) {
        return this.extensionRange_.get(i);
    }

    public int getExtensionRangeCount() {
        return this.extensionRange_.size();
    }

    public List<ExtensionRange> getExtensionRangeList() {
        return this.extensionRange_;
    }

    public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int i) {
        return this.extensionRange_.get(i);
    }

    public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList() {
        return this.extensionRange_;
    }

    public GoogleDescriptorProtos$FieldDescriptorProto getField(int i) {
        return this.field_.get(i);
    }

    public int getFieldCount() {
        return this.field_.size();
    }

    public List<GoogleDescriptorProtos$FieldDescriptorProto> getFieldList() {
        return this.field_;
    }

    public GoogleDescriptorProtos$FieldDescriptorProtoOrBuilder getFieldOrBuilder(int i) {
        return this.field_.get(i);
    }

    public List<? extends GoogleDescriptorProtos$FieldDescriptorProtoOrBuilder> getFieldOrBuilderList() {
        return this.field_;
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public GoogleDescriptorProtos$DescriptorProto getNestedType(int i) {
        return this.nestedType_.get(i);
    }

    public int getNestedTypeCount() {
        return this.nestedType_.size();
    }

    public List<GoogleDescriptorProtos$DescriptorProto> getNestedTypeList() {
        return this.nestedType_;
    }

    public GoogleDescriptorProtos$DescriptorProtoOrBuilder getNestedTypeOrBuilder(int i) {
        return this.nestedType_.get(i);
    }

    public List<? extends GoogleDescriptorProtos$DescriptorProtoOrBuilder> getNestedTypeOrBuilderList() {
        return this.nestedType_;
    }

    public GoogleDescriptorProtos$OneofDescriptorProto getOneofDecl(int i) {
        return this.oneofDecl_.get(i);
    }

    public int getOneofDeclCount() {
        return this.oneofDecl_.size();
    }

    public List<GoogleDescriptorProtos$OneofDescriptorProto> getOneofDeclList() {
        return this.oneofDecl_;
    }

    public GoogleDescriptorProtos$OneofDescriptorProtoOrBuilder getOneofDeclOrBuilder(int i) {
        return this.oneofDecl_.get(i);
    }

    public List<? extends GoogleDescriptorProtos$OneofDescriptorProtoOrBuilder> getOneofDeclOrBuilderList() {
        return this.oneofDecl_;
    }

    public GoogleDescriptorProtos$MessageOptions getOptions() {
        GoogleDescriptorProtos$MessageOptions googleDescriptorProtos$MessageOptions = this.options_;
        return googleDescriptorProtos$MessageOptions == null ? GoogleDescriptorProtos$MessageOptions.getDefaultInstance() : googleDescriptorProtos$MessageOptions;
    }

    public String getReservedName(int i) {
        return this.reservedName_.get(i);
    }

    public ByteString getReservedNameBytes(int i) {
        return ByteString.copyFromUtf8(this.reservedName_.get(i));
    }

    public int getReservedNameCount() {
        return this.reservedName_.size();
    }

    public List<String> getReservedNameList() {
        return this.reservedName_;
    }

    public ReservedRange getReservedRange(int i) {
        return this.reservedRange_.get(i);
    }

    public int getReservedRangeCount() {
        return this.reservedRange_.size();
    }

    public List<ReservedRange> getReservedRangeList() {
        return this.reservedRange_;
    }

    public ReservedRangeOrBuilder getReservedRangeOrBuilder(int i) {
        return this.reservedRange_.get(i);
    }

    public List<? extends ReservedRangeOrBuilder> getReservedRangeOrBuilderList() {
        return this.reservedRange_;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOptions() {
        return (this.bitField0_ & 2) != 0;
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class ExtensionRange extends GeneratedMessageLite<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
        private static final ExtensionRange DEFAULT_INSTANCE;
        public static final int END_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<ExtensionRange> PARSER = null;
        public static final int START_FIELD_NUMBER = 1;
        private int bitField0_;
        private int end_;
        private byte memoizedIsInitialized = 2;
        private GoogleDescriptorProtos$ExtensionRangeOptions options_;
        private int start_;

        static {
            ExtensionRange extensionRange = new ExtensionRange();
            DEFAULT_INSTANCE = extensionRange;
            GeneratedMessageLite.registerDefaultInstance(ExtensionRange.class, extensionRange);
        }

        private ExtensionRange() {
        }

        private void clearEnd() {
            this.bitField0_ &= -3;
            this.end_ = 0;
        }

        private void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -5;
        }

        private void clearStart() {
            this.bitField0_ &= -2;
            this.start_ = 0;
        }

        public static ExtensionRange getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void mergeOptions(GoogleDescriptorProtos$ExtensionRangeOptions googleDescriptorProtos$ExtensionRangeOptions) {
            googleDescriptorProtos$ExtensionRangeOptions.getClass();
            GoogleDescriptorProtos$ExtensionRangeOptions googleDescriptorProtos$ExtensionRangeOptions2 = this.options_;
            if (googleDescriptorProtos$ExtensionRangeOptions2 == null || googleDescriptorProtos$ExtensionRangeOptions2 == GoogleDescriptorProtos$ExtensionRangeOptions.getDefaultInstance()) {
                this.options_ = googleDescriptorProtos$ExtensionRangeOptions;
            } else {
                this.options_ = ((GoogleDescriptorProtos$ExtensionRangeOptions.Builder) GoogleDescriptorProtos$ExtensionRangeOptions.newBuilder(this.options_).mergeFrom(googleDescriptorProtos$ExtensionRangeOptions)).buildPartial();
            }
            this.bitField0_ |= 4;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ExtensionRange parseDelimitedFrom(InputStream inputStream) {
            return (ExtensionRange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExtensionRange parseFrom(ByteBuffer byteBuffer) {
            return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ExtensionRange> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        private void setEnd(int i) {
            this.bitField0_ |= 2;
            this.end_ = i;
        }

        private void setOptions(GoogleDescriptorProtos$ExtensionRangeOptions googleDescriptorProtos$ExtensionRangeOptions) {
            googleDescriptorProtos$ExtensionRangeOptions.getClass();
            this.options_ = googleDescriptorProtos$ExtensionRangeOptions;
            this.bitField0_ |= 4;
        }

        private void setStart(int i) {
            this.bitField0_ |= 1;
            this.start_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (GoogleDescriptorProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ExtensionRange();
                case 2:
                    return new Builder(i);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "start_", "end_", "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExtensionRange> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ExtensionRange.class) {
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

        public int getEnd() {
            return this.end_;
        }

        public GoogleDescriptorProtos$ExtensionRangeOptions getOptions() {
            GoogleDescriptorProtos$ExtensionRangeOptions googleDescriptorProtos$ExtensionRangeOptions = this.options_;
            return googleDescriptorProtos$ExtensionRangeOptions == null ? GoogleDescriptorProtos$ExtensionRangeOptions.getDefaultInstance() : googleDescriptorProtos$ExtensionRangeOptions;
        }

        public int getStart() {
            return this.start_;
        }

        public boolean hasEnd() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasOptions() {
            return (this.bitField0_ & 4) != 0;
        }

        public boolean hasStart() {
            return (this.bitField0_ & 1) != 0;
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ExtensionRange, Builder> implements ExtensionRangeOrBuilder {
            private Builder() {
                super(ExtensionRange.DEFAULT_INSTANCE);
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(ExtensionRange extensionRange) {
            return DEFAULT_INSTANCE.createBuilder(extensionRange);
        }

        public static ExtensionRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExtensionRange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExtensionRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExtensionRange parseFrom(ByteString byteString) {
            return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ExtensionRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExtensionRange parseFrom(byte[] bArr) {
            return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExtensionRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExtensionRange parseFrom(InputStream inputStream) {
            return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExtensionRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExtensionRange parseFrom(CodedInputStream codedInputStream) {
            return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExtensionRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ExtensionRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class ReservedRange extends GeneratedMessageLite<ReservedRange, Builder> implements ReservedRangeOrBuilder {
        private static final ReservedRange DEFAULT_INSTANCE;
        public static final int END_FIELD_NUMBER = 2;
        private static volatile Parser<ReservedRange> PARSER = null;
        public static final int START_FIELD_NUMBER = 1;
        private int bitField0_;
        private int end_;
        private int start_;

        static {
            ReservedRange reservedRange = new ReservedRange();
            DEFAULT_INSTANCE = reservedRange;
            GeneratedMessageLite.registerDefaultInstance(ReservedRange.class, reservedRange);
        }

        private ReservedRange() {
        }

        private void clearEnd() {
            this.bitField0_ &= -3;
            this.end_ = 0;
        }

        private void clearStart() {
            this.bitField0_ &= -2;
            this.start_ = 0;
        }

        public static ReservedRange getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ReservedRange parseDelimitedFrom(InputStream inputStream) {
            return (ReservedRange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReservedRange parseFrom(ByteBuffer byteBuffer) {
            return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ReservedRange> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        private void setEnd(int i) {
            this.bitField0_ |= 2;
            this.end_ = i;
        }

        private void setStart(int i) {
            this.bitField0_ |= 1;
            this.start_ = i;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            switch (GoogleDescriptorProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ReservedRange();
                case 2:
                    return new Builder(0);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"bitField0_", "start_", "end_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ReservedRange> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ReservedRange.class) {
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

        public int getEnd() {
            return this.end_;
        }

        public int getStart() {
            return this.start_;
        }

        public boolean hasEnd() {
            return (this.bitField0_ & 2) != 0;
        }

        public boolean hasStart() {
            return (this.bitField0_ & 1) != 0;
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReservedRange, Builder> implements ReservedRangeOrBuilder {
            private Builder() {
                super(ReservedRange.DEFAULT_INSTANCE);
            }

            public /* synthetic */ Builder(int i) {
                this();
            }
        }

        public static Builder newBuilder(ReservedRange reservedRange) {
            return DEFAULT_INSTANCE.createBuilder(reservedRange);
        }

        public static ReservedRange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReservedRange) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReservedRange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ReservedRange parseFrom(ByteString byteString) {
            return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ReservedRange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ReservedRange parseFrom(byte[] bArr) {
            return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ReservedRange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ReservedRange parseFrom(InputStream inputStream) {
            return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ReservedRange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ReservedRange parseFrom(CodedInputStream codedInputStream) {
            return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ReservedRange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ReservedRange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public static final class Builder extends GeneratedMessageLite.Builder<GoogleDescriptorProtos$DescriptorProto, Builder> implements GoogleDescriptorProtos$DescriptorProtoOrBuilder {
        private Builder() {
            super(GoogleDescriptorProtos$DescriptorProto.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(GoogleDescriptorProtos$DescriptorProto googleDescriptorProtos$DescriptorProto) {
        return DEFAULT_INSTANCE.createBuilder(googleDescriptorProtos$DescriptorProto);
    }

    public static GoogleDescriptorProtos$DescriptorProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$DescriptorProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$DescriptorProto parseFrom(ByteString byteString) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDescriptorProtos$DescriptorProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
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

    private void addExtensionRange(int i, ExtensionRange extensionRange) {
        extensionRange.getClass();
        ensureExtensionRangeIsMutable();
        this.extensionRange_.add(i, extensionRange);
    }

    private void addField(int i, GoogleDescriptorProtos$FieldDescriptorProto googleDescriptorProtos$FieldDescriptorProto) {
        googleDescriptorProtos$FieldDescriptorProto.getClass();
        ensureFieldIsMutable();
        this.field_.add(i, googleDescriptorProtos$FieldDescriptorProto);
    }

    private void addNestedType(int i, GoogleDescriptorProtos$DescriptorProto googleDescriptorProtos$DescriptorProto) {
        googleDescriptorProtos$DescriptorProto.getClass();
        ensureNestedTypeIsMutable();
        this.nestedType_.add(i, googleDescriptorProtos$DescriptorProto);
    }

    private void addOneofDecl(int i, GoogleDescriptorProtos$OneofDescriptorProto googleDescriptorProtos$OneofDescriptorProto) {
        googleDescriptorProtos$OneofDescriptorProto.getClass();
        ensureOneofDeclIsMutable();
        this.oneofDecl_.add(i, googleDescriptorProtos$OneofDescriptorProto);
    }

    private void addReservedRange(int i, ReservedRange reservedRange) {
        reservedRange.getClass();
        ensureReservedRangeIsMutable();
        this.reservedRange_.add(i, reservedRange);
    }

    public static GoogleDescriptorProtos$DescriptorProto parseFrom(byte[] bArr) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDescriptorProtos$DescriptorProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$DescriptorProto parseFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$DescriptorProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$DescriptorProto parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDescriptorProtos$DescriptorProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$DescriptorProto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
