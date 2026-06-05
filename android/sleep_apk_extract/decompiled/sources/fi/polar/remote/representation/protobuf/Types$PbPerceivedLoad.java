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
public final class Types$PbPerceivedLoad extends GeneratedMessageLite<Types$PbPerceivedLoad, Builder> implements MessageLiteOrBuilder {
    private static final Types$PbPerceivedLoad DEFAULT_INSTANCE;
    public static final int DURATION_FIELD_NUMBER = 2;
    private static volatile Parser<Types$PbPerceivedLoad> PARSER = null;
    public static final int SESSION_RPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private int duration_;
    private byte memoizedIsInitialized = 2;
    private int sessionRpe_ = 6;

    static {
        Types$PbPerceivedLoad types$PbPerceivedLoad = new Types$PbPerceivedLoad();
        DEFAULT_INSTANCE = types$PbPerceivedLoad;
        GeneratedMessageLite.registerDefaultInstance(Types$PbPerceivedLoad.class, types$PbPerceivedLoad);
    }

    private Types$PbPerceivedLoad() {
    }

    private void clearDuration() {
        this.bitField0_ &= -3;
        this.duration_ = 0;
    }

    private void clearSessionRpe() {
        this.bitField0_ &= -2;
        this.sessionRpe_ = 6;
    }

    public static Types$PbPerceivedLoad getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Types$PbPerceivedLoad parseDelimitedFrom(InputStream inputStream) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbPerceivedLoad parseFrom(ByteBuffer byteBuffer) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Types$PbPerceivedLoad> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDuration(int i) {
        this.bitField0_ |= 2;
        this.duration_ = i;
    }

    private void setSessionRpe(Types$PbSessionRPE types$PbSessionRPE) {
        this.sessionRpe_ = types$PbSessionRPE.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Types$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Types$PbPerceivedLoad();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔌ\u0000\u0002ᔋ\u0001", new Object[]{"bitField0_", "sessionRpe_", Types$PbSessionRPE.internalGetVerifier(), "duration_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Types$PbPerceivedLoad> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Types$PbPerceivedLoad.class) {
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

    public int getDuration() {
        return this.duration_;
    }

    public Types$PbSessionRPE getSessionRpe() {
        Types$PbSessionRPE types$PbSessionRPEForNumber = Types$PbSessionRPE.forNumber(this.sessionRpe_);
        return types$PbSessionRPEForNumber == null ? Types$PbSessionRPE.RPE_MODERATE : types$PbSessionRPEForNumber;
    }

    public boolean hasDuration() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasSessionRpe() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Types$PbPerceivedLoad, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Types$PbPerceivedLoad.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Types$PbPerceivedLoad types$PbPerceivedLoad) {
        return DEFAULT_INSTANCE.createBuilder(types$PbPerceivedLoad);
    }

    public static Types$PbPerceivedLoad parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbPerceivedLoad parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Types$PbPerceivedLoad parseFrom(ByteString byteString) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Types$PbPerceivedLoad parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Types$PbPerceivedLoad parseFrom(byte[] bArr) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Types$PbPerceivedLoad parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Types$PbPerceivedLoad parseFrom(InputStream inputStream) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Types$PbPerceivedLoad parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Types$PbPerceivedLoad parseFrom(CodedInputStream codedInputStream) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Types$PbPerceivedLoad parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Types$PbPerceivedLoad) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
