package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class Structures$PbSpeedZone extends GeneratedMessageLite<Structures$PbSpeedZone, Builder> implements Structures$PbSpeedZoneOrBuilder {
    private static final Structures$PbSpeedZone DEFAULT_INSTANCE;
    public static final int HIGHER_LIMIT_FIELD_NUMBER = 2;
    public static final int LOWER_LIMIT_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbSpeedZone> PARSER;
    private int bitField0_;
    private float higherLimit_;
    private float lowerLimit_;
    private byte memoizedIsInitialized = 2;

    static {
        Structures$PbSpeedZone structures$PbSpeedZone = new Structures$PbSpeedZone();
        DEFAULT_INSTANCE = structures$PbSpeedZone;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbSpeedZone.class, structures$PbSpeedZone);
    }

    private Structures$PbSpeedZone() {
    }

    private void clearHigherLimit() {
        this.bitField0_ &= -3;
        this.higherLimit_ = 0.0f;
    }

    private void clearLowerLimit() {
        this.bitField0_ &= -2;
        this.lowerLimit_ = 0.0f;
    }

    public static Structures$PbSpeedZone getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbSpeedZone parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbSpeedZone parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbSpeedZone> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHigherLimit(float f) {
        this.bitField0_ |= 2;
        this.higherLimit_ = f;
    }

    private void setLowerLimit(float f) {
        this.bitField0_ |= 1;
        this.lowerLimit_ = f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbSpeedZone();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔁ\u0000\u0002ᔁ\u0001", new Object[]{"bitField0_", "lowerLimit_", "higherLimit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbSpeedZone> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbSpeedZone.class) {
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

    public float getHigherLimit() {
        return this.higherLimit_;
    }

    public float getLowerLimit() {
        return this.lowerLimit_;
    }

    public boolean hasHigherLimit() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasLowerLimit() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbSpeedZone, Builder> implements Structures$PbSpeedZoneOrBuilder {
        private Builder() {
            super(Structures$PbSpeedZone.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbSpeedZone structures$PbSpeedZone) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbSpeedZone);
    }

    public static Structures$PbSpeedZone parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbSpeedZone parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbSpeedZone parseFrom(ByteString byteString) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbSpeedZone parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbSpeedZone parseFrom(byte[] bArr) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbSpeedZone parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbSpeedZone parseFrom(InputStream inputStream) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbSpeedZone parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbSpeedZone parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbSpeedZone parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSpeedZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
