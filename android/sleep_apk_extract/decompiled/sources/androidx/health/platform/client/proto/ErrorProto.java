package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import androidx.health.platform.client.proto.PermissionProto;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ErrorProto {

    /* JADX INFO: renamed from: androidx.health.platform.client.proto.ErrorProto$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public interface ErrorStatusOrBuilder extends MessageLiteOrBuilder {
        int getCode();

        String getMessage();

        ByteString getMessageBytes();

        PermissionProto.Permission getPermission(int i);

        int getPermissionCount();

        List<PermissionProto.Permission> getPermissionList();

        boolean hasCode();

        boolean hasMessage();
    }

    private ErrorProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    public static final class ErrorStatus extends GeneratedMessageLite<ErrorStatus, Builder> implements ErrorStatusOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final ErrorStatus DEFAULT_INSTANCE;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        private static volatile Parser<ErrorStatus> PARSER = null;
        public static final int PERMISSION_FIELD_NUMBER = 3;
        private int bitField0_;
        private int code_;
        private String message_ = "";
        private Internal.ProtobufList<PermissionProto.Permission> permission_ = GeneratedMessageLite.emptyProtobufList();

        static {
            ErrorStatus errorStatus = new ErrorStatus();
            DEFAULT_INSTANCE = errorStatus;
            GeneratedMessageLite.registerDefaultInstance(ErrorStatus.class, errorStatus);
        }

        private ErrorStatus() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPermission(Iterable<? extends PermissionProto.Permission> iterable) {
            ensurePermissionIsMutable();
            AbstractMessageLite.addAll(iterable, this.permission_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPermission(PermissionProto.Permission permission) {
            permission.getClass();
            ensurePermissionIsMutable();
            this.permission_.add(permission);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.bitField0_ &= -2;
            this.code_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessage() {
            this.bitField0_ &= -3;
            this.message_ = getDefaultInstance().getMessage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPermission() {
            this.permission_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensurePermissionIsMutable() {
            Internal.ProtobufList<PermissionProto.Permission> protobufList = this.permission_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.permission_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        public static ErrorStatus getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ErrorStatus parseDelimitedFrom(InputStream inputStream) {
            return (ErrorStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ErrorStatus parseFrom(ByteBuffer byteBuffer) {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<ErrorStatus> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePermission(int i) {
            ensurePermissionIsMutable();
            this.permission_.remove(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(int i) {
            this.bitField0_ |= 1;
            this.code_ = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessage(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.message_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessageBytes(ByteString byteString) {
            this.message_ = byteString.toStringUtf8();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPermission(int i, PermissionProto.Permission permission) {
            permission.getClass();
            ensurePermissionIsMutable();
            this.permission_.set(i, permission);
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new ErrorStatus();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b", new Object[]{"bitField0_", "code_", "message_", "permission_", PermissionProto.Permission.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ErrorStatus> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ErrorStatus.class) {
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

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public String getMessage() {
            return this.message_;
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public ByteString getMessageBytes() {
            return ByteString.copyFromUtf8(this.message_);
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public PermissionProto.Permission getPermission(int i) {
            return this.permission_.get(i);
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public int getPermissionCount() {
            return this.permission_.size();
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public List<PermissionProto.Permission> getPermissionList() {
            return this.permission_;
        }

        public PermissionProto.PermissionOrBuilder getPermissionOrBuilder(int i) {
            return this.permission_.get(i);
        }

        public List<? extends PermissionProto.PermissionOrBuilder> getPermissionOrBuilderList() {
            return this.permission_;
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public boolean hasCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public boolean hasMessage() {
            return (this.bitField0_ & 2) != 0;
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ErrorStatus, Builder> implements ErrorStatusOrBuilder {
            private Builder() {
                super(ErrorStatus.DEFAULT_INSTANCE);
            }

            public Builder addAllPermission(Iterable<? extends PermissionProto.Permission> iterable) {
                copyOnWrite();
                ((ErrorStatus) this.instance).addAllPermission(iterable);
                return this;
            }

            public Builder addPermission(PermissionProto.Permission.Builder builder) {
                copyOnWrite();
                ((ErrorStatus) this.instance).addPermission(builder.build());
                return this;
            }

            public Builder clearCode() {
                copyOnWrite();
                ((ErrorStatus) this.instance).clearCode();
                return this;
            }

            public Builder clearMessage() {
                copyOnWrite();
                ((ErrorStatus) this.instance).clearMessage();
                return this;
            }

            public Builder clearPermission() {
                copyOnWrite();
                ((ErrorStatus) this.instance).clearPermission();
                return this;
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public int getCode() {
                return ((ErrorStatus) this.instance).getCode();
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public String getMessage() {
                return ((ErrorStatus) this.instance).getMessage();
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public ByteString getMessageBytes() {
                return ((ErrorStatus) this.instance).getMessageBytes();
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public PermissionProto.Permission getPermission(int i) {
                return ((ErrorStatus) this.instance).getPermission(i);
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public int getPermissionCount() {
                return ((ErrorStatus) this.instance).getPermissionCount();
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public List<PermissionProto.Permission> getPermissionList() {
                return Collections.unmodifiableList(((ErrorStatus) this.instance).getPermissionList());
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public boolean hasCode() {
                return ((ErrorStatus) this.instance).hasCode();
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public boolean hasMessage() {
                return ((ErrorStatus) this.instance).hasMessage();
            }

            public Builder removePermission(int i) {
                copyOnWrite();
                ((ErrorStatus) this.instance).removePermission(i);
                return this;
            }

            public Builder setCode(int i) {
                copyOnWrite();
                ((ErrorStatus) this.instance).setCode(i);
                return this;
            }

            public Builder setMessage(String str) {
                copyOnWrite();
                ((ErrorStatus) this.instance).setMessage(str);
                return this;
            }

            public Builder setMessageBytes(ByteString byteString) {
                copyOnWrite();
                ((ErrorStatus) this.instance).setMessageBytes(byteString);
                return this;
            }

            public Builder setPermission(int i, PermissionProto.Permission.Builder builder) {
                copyOnWrite();
                ((ErrorStatus) this.instance).setPermission(i, builder.build());
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addPermission(int i, PermissionProto.Permission permission) {
                copyOnWrite();
                ((ErrorStatus) this.instance).addPermission(i, permission);
                return this;
            }

            public Builder setPermission(int i, PermissionProto.Permission permission) {
                copyOnWrite();
                ((ErrorStatus) this.instance).setPermission(i, permission);
                return this;
            }

            public Builder addPermission(PermissionProto.Permission permission) {
                copyOnWrite();
                ((ErrorStatus) this.instance).addPermission(permission);
                return this;
            }

            public Builder addPermission(int i, PermissionProto.Permission.Builder builder) {
                copyOnWrite();
                ((ErrorStatus) this.instance).addPermission(i, builder.build());
                return this;
            }
        }

        public static Builder newBuilder(ErrorStatus errorStatus) {
            return DEFAULT_INSTANCE.createBuilder(errorStatus);
        }

        public static ErrorStatus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorStatus) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ErrorStatus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ErrorStatus parseFrom(ByteString byteString) {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ErrorStatus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPermission(int i, PermissionProto.Permission permission) {
            permission.getClass();
            ensurePermissionIsMutable();
            this.permission_.add(i, permission);
        }

        public static ErrorStatus parseFrom(byte[] bArr) {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ErrorStatus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ErrorStatus parseFrom(InputStream inputStream) {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ErrorStatus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ErrorStatus parseFrom(CodedInputStream codedInputStream) {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ErrorStatus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }
}
