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
public final class Structures$PbVersion extends GeneratedMessageLite<Structures$PbVersion, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbVersion DEFAULT_INSTANCE;
    public static final int MAJOR_FIELD_NUMBER = 1;
    public static final int MINOR_FIELD_NUMBER = 2;
    private static volatile Parser<Structures$PbVersion> PARSER = null;
    public static final int PATCH_FIELD_NUMBER = 3;
    public static final int SPECIFIER_FIELD_NUMBER = 4;
    private int bitField0_;
    private int major_;
    private int minor_;
    private int patch_;
    private byte memoizedIsInitialized = 2;
    private String specifier_ = "";

    static {
        Structures$PbVersion structures$PbVersion = new Structures$PbVersion();
        DEFAULT_INSTANCE = structures$PbVersion;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbVersion.class, structures$PbVersion);
    }

    private Structures$PbVersion() {
    }

    private void clearMajor() {
        this.bitField0_ &= -2;
        this.major_ = 0;
    }

    private void clearMinor() {
        this.bitField0_ &= -3;
        this.minor_ = 0;
    }

    private void clearPatch() {
        this.bitField0_ &= -5;
        this.patch_ = 0;
    }

    private void clearSpecifier() {
        this.bitField0_ &= -9;
        this.specifier_ = getDefaultInstance().getSpecifier();
    }

    public static Structures$PbVersion getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbVersion parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbVersion) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbVersion parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbVersion> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMajor(int i) {
        this.bitField0_ |= 1;
        this.major_ = i;
    }

    private void setMinor(int i) {
        this.bitField0_ |= 2;
        this.minor_ = i;
    }

    private void setPatch(int i) {
        this.bitField0_ |= 4;
        this.patch_ = i;
    }

    private void setSpecifier(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.specifier_ = str;
    }

    private void setSpecifierBytes(ByteString byteString) {
        this.specifier_ = byteString.toStringUtf8();
        this.bitField0_ |= 8;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbVersion();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0003\u0001ᔋ\u0000\u0002ᔋ\u0001\u0003ᔋ\u0002\u0004ဈ\u0003", new Object[]{"bitField0_", "major_", "minor_", "patch_", "specifier_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbVersion> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbVersion.class) {
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

    public int getMajor() {
        return this.major_;
    }

    public int getMinor() {
        return this.minor_;
    }

    public int getPatch() {
        return this.patch_;
    }

    public String getSpecifier() {
        return this.specifier_;
    }

    public ByteString getSpecifierBytes() {
        return ByteString.copyFromUtf8(this.specifier_);
    }

    public boolean hasMajor() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasMinor() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPatch() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasSpecifier() {
        return (this.bitField0_ & 8) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbVersion, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbVersion.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbVersion structures$PbVersion) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbVersion);
    }

    public static Structures$PbVersion parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVersion) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbVersion parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbVersion parseFrom(ByteString byteString) {
        return (Structures$PbVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbVersion parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbVersion parseFrom(byte[] bArr) {
        return (Structures$PbVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbVersion parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbVersion parseFrom(InputStream inputStream) {
        return (Structures$PbVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbVersion parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbVersion parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbVersion parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbVersion) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
