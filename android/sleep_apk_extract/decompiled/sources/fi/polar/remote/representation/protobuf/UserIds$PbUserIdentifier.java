package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class UserIds$PbUserIdentifier extends GeneratedMessageLite<UserIds$PbUserIdentifier, Builder> implements MessageLiteOrBuilder {
    private static final UserIds$PbUserIdentifier DEFAULT_INSTANCE;
    public static final int MASTER_IDENTIFIER_FIELD_NUMBER = 1;
    private static volatile Parser<UserIds$PbUserIdentifier> PARSER = null;
    public static final int USER_ID_LAST_MODIFIED_FIELD_NUMBER = 100;
    private int bitField0_;
    private long masterIdentifier_;
    private byte memoizedIsInitialized = 2;
    private Types$PbSystemDateTime userIdLastModified_;

    static {
        UserIds$PbUserIdentifier userIds$PbUserIdentifier = new UserIds$PbUserIdentifier();
        DEFAULT_INSTANCE = userIds$PbUserIdentifier;
        GeneratedMessageLite.registerDefaultInstance(UserIds$PbUserIdentifier.class, userIds$PbUserIdentifier);
    }

    private UserIds$PbUserIdentifier() {
    }

    private void clearMasterIdentifier() {
        this.bitField0_ &= -2;
        this.masterIdentifier_ = 0L;
    }

    private void clearUserIdLastModified() {
        this.userIdLastModified_ = null;
        this.bitField0_ &= -3;
    }

    public static UserIds$PbUserIdentifier getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeUserIdLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.userIdLastModified_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.userIdLastModified_ = types$PbSystemDateTime;
        } else {
            this.userIdLastModified_ = Types$PbSystemDateTime.newBuilder(this.userIdLastModified_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static UserIds$PbUserIdentifier parseDelimitedFrom(InputStream inputStream) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserIds$PbUserIdentifier parseFrom(ByteBuffer byteBuffer) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UserIds$PbUserIdentifier> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMasterIdentifier(long j) {
        this.bitField0_ |= 1;
        this.masterIdentifier_ = j;
    }

    private void setUserIdLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.userIdLastModified_ = types$PbSystemDateTime;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (UserIds$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new UserIds$PbUserIdentifier();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001d\u0002\u0000\u0000\u0001\u0001ဃ\u0000dᐉ\u0001", new Object[]{"bitField0_", "masterIdentifier_", "userIdLastModified_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UserIds$PbUserIdentifier> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UserIds$PbUserIdentifier.class) {
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

    public long getMasterIdentifier() {
        return this.masterIdentifier_;
    }

    public Types$PbSystemDateTime getUserIdLastModified() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.userIdLastModified_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public boolean hasMasterIdentifier() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasUserIdLastModified() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<UserIds$PbUserIdentifier, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(UserIds$PbUserIdentifier.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(UserIds$PbUserIdentifier userIds$PbUserIdentifier) {
        return DEFAULT_INSTANCE.createBuilder(userIds$PbUserIdentifier);
    }

    public static UserIds$PbUserIdentifier parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserIds$PbUserIdentifier parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UserIds$PbUserIdentifier parseFrom(ByteString byteString) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UserIds$PbUserIdentifier parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static UserIds$PbUserIdentifier parseFrom(byte[] bArr) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UserIds$PbUserIdentifier parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UserIds$PbUserIdentifier parseFrom(InputStream inputStream) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserIds$PbUserIdentifier parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserIds$PbUserIdentifier parseFrom(CodedInputStream codedInputStream) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UserIds$PbUserIdentifier parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserIds$PbUserIdentifier) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
