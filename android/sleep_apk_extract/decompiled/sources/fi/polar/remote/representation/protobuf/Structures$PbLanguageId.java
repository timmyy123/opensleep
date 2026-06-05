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
public final class Structures$PbLanguageId extends GeneratedMessageLite<Structures$PbLanguageId, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbLanguageId DEFAULT_INSTANCE;
    public static final int LANGUAGE_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbLanguageId> PARSER = null;
    public static final int REGION_FIELD_NUMBER = 2;
    public static final int SCRIPT_FIELD_NUMBER = 3;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private String language_ = "";
    private String region_ = "";
    private String script_ = "";

    static {
        Structures$PbLanguageId structures$PbLanguageId = new Structures$PbLanguageId();
        DEFAULT_INSTANCE = structures$PbLanguageId;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbLanguageId.class, structures$PbLanguageId);
    }

    private Structures$PbLanguageId() {
    }

    private void clearLanguage() {
        this.bitField0_ &= -2;
        this.language_ = getDefaultInstance().getLanguage();
    }

    private void clearRegion() {
        this.bitField0_ &= -3;
        this.region_ = getDefaultInstance().getRegion();
    }

    private void clearScript() {
        this.bitField0_ &= -5;
        this.script_ = getDefaultInstance().getScript();
    }

    public static Structures$PbLanguageId getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbLanguageId parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbLanguageId parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbLanguageId> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setLanguage(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.language_ = str;
    }

    private void setLanguageBytes(ByteString byteString) {
        this.language_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    private void setRegion(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.region_ = str;
    }

    private void setRegionBytes(ByteString byteString) {
        this.region_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    private void setScript(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.script_ = str;
    }

    private void setScriptBytes(ByteString byteString) {
        this.script_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbLanguageId();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᔈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "language_", "region_", "script_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbLanguageId> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbLanguageId.class) {
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

    public String getLanguage() {
        return this.language_;
    }

    public ByteString getLanguageBytes() {
        return ByteString.copyFromUtf8(this.language_);
    }

    public String getRegion() {
        return this.region_;
    }

    public ByteString getRegionBytes() {
        return ByteString.copyFromUtf8(this.region_);
    }

    public String getScript() {
        return this.script_;
    }

    public ByteString getScriptBytes() {
        return ByteString.copyFromUtf8(this.script_);
    }

    public boolean hasLanguage() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasRegion() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasScript() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbLanguageId, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbLanguageId.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbLanguageId structures$PbLanguageId) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbLanguageId);
    }

    public static Structures$PbLanguageId parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbLanguageId parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbLanguageId parseFrom(ByteString byteString) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbLanguageId parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbLanguageId parseFrom(byte[] bArr) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbLanguageId parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbLanguageId parseFrom(InputStream inputStream) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbLanguageId parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbLanguageId parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbLanguageId parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbLanguageId) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
