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
public final class Structures$PbFontInfo extends GeneratedMessageLite<Structures$PbFontInfo, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbFontInfo DEFAULT_INSTANCE;
    public static final int FILE_NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbFontInfo> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private int bitField0_;
    private String fileName_ = "";
    private int version_;

    static {
        Structures$PbFontInfo structures$PbFontInfo = new Structures$PbFontInfo();
        DEFAULT_INSTANCE = structures$PbFontInfo;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbFontInfo.class, structures$PbFontInfo);
    }

    private Structures$PbFontInfo() {
    }

    private void clearFileName() {
        this.bitField0_ &= -2;
        this.fileName_ = getDefaultInstance().getFileName();
    }

    private void clearVersion() {
        this.bitField0_ &= -3;
        this.version_ = 0;
    }

    public static Structures$PbFontInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbFontInfo parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbFontInfo parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbFontInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setFileName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.fileName_ = str;
    }

    private void setFileNameBytes(ByteString byteString) {
        this.fileName_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    private void setVersion(int i) {
        this.bitField0_ |= 2;
        this.version_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbFontInfo();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဋ\u0001", new Object[]{"bitField0_", "fileName_", "version_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbFontInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbFontInfo.class) {
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

    public String getFileName() {
        return this.fileName_;
    }

    public ByteString getFileNameBytes() {
        return ByteString.copyFromUtf8(this.fileName_);
    }

    public int getVersion() {
        return this.version_;
    }

    public boolean hasFileName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasVersion() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbFontInfo, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbFontInfo.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbFontInfo structures$PbFontInfo) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbFontInfo);
    }

    public static Structures$PbFontInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbFontInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbFontInfo parseFrom(ByteString byteString) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbFontInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbFontInfo parseFrom(byte[] bArr) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbFontInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbFontInfo parseFrom(InputStream inputStream) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbFontInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbFontInfo parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbFontInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbFontInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
