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
public final class Structures$PbSubcomponentInfo extends GeneratedMessageLite<Structures$PbSubcomponentInfo, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbSubcomponentInfo DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OBSOLETE_REQUIRED_VERSION_FIELD_NUMBER = 2;
    private static volatile Parser<Structures$PbSubcomponentInfo> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private Structures$PbVersion oBSOLETERequiredVersion_;
    private Structures$PbVersion version_;

    static {
        Structures$PbSubcomponentInfo structures$PbSubcomponentInfo = new Structures$PbSubcomponentInfo();
        DEFAULT_INSTANCE = structures$PbSubcomponentInfo;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbSubcomponentInfo.class, structures$PbSubcomponentInfo);
    }

    private Structures$PbSubcomponentInfo() {
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    private void clearOBSOLETERequiredVersion() {
        this.oBSOLETERequiredVersion_ = null;
        this.bitField0_ &= -3;
    }

    private void clearVersion() {
        this.version_ = null;
        this.bitField0_ &= -5;
    }

    public static Structures$PbSubcomponentInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeOBSOLETERequiredVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        Structures$PbVersion structures$PbVersion2 = this.oBSOLETERequiredVersion_;
        if (structures$PbVersion2 == null || structures$PbVersion2 == Structures$PbVersion.getDefaultInstance()) {
            this.oBSOLETERequiredVersion_ = structures$PbVersion;
        } else {
            this.oBSOLETERequiredVersion_ = Structures$PbVersion.newBuilder(this.oBSOLETERequiredVersion_).mergeFrom(structures$PbVersion).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    private void mergeVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        Structures$PbVersion structures$PbVersion2 = this.version_;
        if (structures$PbVersion2 == null || structures$PbVersion2 == Structures$PbVersion.getDefaultInstance()) {
            this.version_ = structures$PbVersion;
        } else {
            this.version_ = Structures$PbVersion.newBuilder(this.version_).mergeFrom(structures$PbVersion).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbSubcomponentInfo parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbSubcomponentInfo parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbSubcomponentInfo> parser() {
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

    private void setOBSOLETERequiredVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        this.oBSOLETERequiredVersion_ = structures$PbVersion;
        this.bitField0_ |= 2;
    }

    private void setVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        this.version_ = structures$PbVersion;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbSubcomponentInfo();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔈ\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "name_", "oBSOLETERequiredVersion_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbSubcomponentInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbSubcomponentInfo.class) {
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

    public Structures$PbVersion getOBSOLETERequiredVersion() {
        Structures$PbVersion structures$PbVersion = this.oBSOLETERequiredVersion_;
        return structures$PbVersion == null ? Structures$PbVersion.getDefaultInstance() : structures$PbVersion;
    }

    public Structures$PbVersion getVersion() {
        Structures$PbVersion structures$PbVersion = this.version_;
        return structures$PbVersion == null ? Structures$PbVersion.getDefaultInstance() : structures$PbVersion;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasOBSOLETERequiredVersion() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasVersion() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbSubcomponentInfo, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbSubcomponentInfo.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbSubcomponentInfo structures$PbSubcomponentInfo) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbSubcomponentInfo);
    }

    public static Structures$PbSubcomponentInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbSubcomponentInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbSubcomponentInfo parseFrom(ByteString byteString) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbSubcomponentInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbSubcomponentInfo parseFrom(byte[] bArr) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbSubcomponentInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbSubcomponentInfo parseFrom(InputStream inputStream) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbSubcomponentInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbSubcomponentInfo parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbSubcomponentInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSubcomponentInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
