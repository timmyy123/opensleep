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
public final class Structures$PbSwimmingPoolInfo extends GeneratedMessageLite<Structures$PbSwimmingPoolInfo, Builder> implements MessageLiteOrBuilder {
    private static final Structures$PbSwimmingPoolInfo DEFAULT_INSTANCE;
    private static volatile Parser<Structures$PbSwimmingPoolInfo> PARSER = null;
    public static final int POOL_LENGTH_FIELD_NUMBER = 1;
    public static final int SWIMMING_POOL_TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private float poolLength_;
    private int swimmingPoolType_;

    static {
        Structures$PbSwimmingPoolInfo structures$PbSwimmingPoolInfo = new Structures$PbSwimmingPoolInfo();
        DEFAULT_INSTANCE = structures$PbSwimmingPoolInfo;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbSwimmingPoolInfo.class, structures$PbSwimmingPoolInfo);
    }

    private Structures$PbSwimmingPoolInfo() {
    }

    private void clearPoolLength() {
        this.bitField0_ &= -2;
        this.poolLength_ = 0.0f;
    }

    private void clearSwimmingPoolType() {
        this.bitField0_ &= -3;
        this.swimmingPoolType_ = 0;
    }

    public static Structures$PbSwimmingPoolInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbSwimmingPoolInfo parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbSwimmingPoolInfo parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbSwimmingPoolInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setPoolLength(float f) {
        this.bitField0_ |= 1;
        this.poolLength_ = f;
    }

    private void setSwimmingPoolType(Types$PbSwimmingPoolUnits types$PbSwimmingPoolUnits) {
        this.swimmingPoolType_ = types$PbSwimmingPoolUnits.getNumber();
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbSwimmingPoolInfo();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ခ\u0000\u0002ᔌ\u0001", new Object[]{"bitField0_", "poolLength_", "swimmingPoolType_", Types$PbSwimmingPoolUnits.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbSwimmingPoolInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbSwimmingPoolInfo.class) {
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

    public float getPoolLength() {
        return this.poolLength_;
    }

    public Types$PbSwimmingPoolUnits getSwimmingPoolType() {
        Types$PbSwimmingPoolUnits types$PbSwimmingPoolUnitsForNumber = Types$PbSwimmingPoolUnits.forNumber(this.swimmingPoolType_);
        return types$PbSwimmingPoolUnitsForNumber == null ? Types$PbSwimmingPoolUnits.SWIMMING_POOL_METERS : types$PbSwimmingPoolUnitsForNumber;
    }

    public boolean hasPoolLength() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasSwimmingPoolType() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbSwimmingPoolInfo, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbSwimmingPoolInfo.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbSwimmingPoolInfo structures$PbSwimmingPoolInfo) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbSwimmingPoolInfo);
    }

    public static Structures$PbSwimmingPoolInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbSwimmingPoolInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbSwimmingPoolInfo parseFrom(ByteString byteString) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbSwimmingPoolInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbSwimmingPoolInfo parseFrom(byte[] bArr) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbSwimmingPoolInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbSwimmingPoolInfo parseFrom(InputStream inputStream) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbSwimmingPoolInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbSwimmingPoolInfo parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbSwimmingPoolInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSwimmingPoolInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
