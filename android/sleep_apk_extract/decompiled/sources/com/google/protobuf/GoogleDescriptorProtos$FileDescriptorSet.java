package com.google.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleDescriptorProtos$FileDescriptorSet extends GeneratedMessageLite<GoogleDescriptorProtos$FileDescriptorSet, Builder> implements MessageLiteOrBuilder {
    private static final GoogleDescriptorProtos$FileDescriptorSet DEFAULT_INSTANCE;
    public static final int FILE_FIELD_NUMBER = 1;
    private static volatile Parser<GoogleDescriptorProtos$FileDescriptorSet> PARSER;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<GoogleDescriptorProtos$FileDescriptorProto> file_ = GeneratedMessageLite.emptyProtobufList();

    static {
        GoogleDescriptorProtos$FileDescriptorSet googleDescriptorProtos$FileDescriptorSet = new GoogleDescriptorProtos$FileDescriptorSet();
        DEFAULT_INSTANCE = googleDescriptorProtos$FileDescriptorSet;
        GeneratedMessageLite.registerDefaultInstance(GoogleDescriptorProtos$FileDescriptorSet.class, googleDescriptorProtos$FileDescriptorSet);
    }

    private GoogleDescriptorProtos$FileDescriptorSet() {
    }

    private void addAllFile(Iterable<? extends GoogleDescriptorProtos$FileDescriptorProto> iterable) {
        ensureFileIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.file_);
    }

    private void addFile(GoogleDescriptorProtos$FileDescriptorProto googleDescriptorProtos$FileDescriptorProto) {
        googleDescriptorProtos$FileDescriptorProto.getClass();
        ensureFileIsMutable();
        this.file_.add(googleDescriptorProtos$FileDescriptorProto);
    }

    private void clearFile() {
        this.file_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureFileIsMutable() {
        Internal.ProtobufList<GoogleDescriptorProtos$FileDescriptorProto> protobufList = this.file_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.file_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseDelimitedFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseFrom(ByteBuffer byteBuffer) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GoogleDescriptorProtos$FileDescriptorSet> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeFile(int i) {
        ensureFileIsMutable();
        this.file_.remove(i);
    }

    private void setFile(int i, GoogleDescriptorProtos$FileDescriptorProto googleDescriptorProtos$FileDescriptorProto) {
        googleDescriptorProtos$FileDescriptorProto.getClass();
        ensureFileIsMutable();
        this.file_.set(i, googleDescriptorProtos$FileDescriptorProto);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (GoogleDescriptorProtos$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new GoogleDescriptorProtos$FileDescriptorSet();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"file_", GoogleDescriptorProtos$FileDescriptorProto.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GoogleDescriptorProtos$FileDescriptorSet> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (GoogleDescriptorProtos$FileDescriptorSet.class) {
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

    public GoogleDescriptorProtos$FileDescriptorProto getFile(int i) {
        return this.file_.get(i);
    }

    public int getFileCount() {
        return this.file_.size();
    }

    public List<GoogleDescriptorProtos$FileDescriptorProto> getFileList() {
        return this.file_;
    }

    public GoogleDescriptorProtos$FileDescriptorProtoOrBuilder getFileOrBuilder(int i) {
        return this.file_.get(i);
    }

    public List<? extends GoogleDescriptorProtos$FileDescriptorProtoOrBuilder> getFileOrBuilderList() {
        return this.file_;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<GoogleDescriptorProtos$FileDescriptorSet, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(GoogleDescriptorProtos$FileDescriptorSet.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(GoogleDescriptorProtos$FileDescriptorSet googleDescriptorProtos$FileDescriptorSet) {
        return DEFAULT_INSTANCE.createBuilder(googleDescriptorProtos$FileDescriptorSet);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseFrom(ByteString byteString) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addFile(int i, GoogleDescriptorProtos$FileDescriptorProto googleDescriptorProtos$FileDescriptorProto) {
        googleDescriptorProtos$FileDescriptorProto.getClass();
        ensureFileIsMutable();
        this.file_.add(i, googleDescriptorProtos$FileDescriptorProto);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseFrom(byte[] bArr) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseFrom(InputStream inputStream) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseFrom(CodedInputStream codedInputStream) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GoogleDescriptorProtos$FileDescriptorSet parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (GoogleDescriptorProtos$FileDescriptorSet) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
