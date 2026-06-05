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
public final class Structures$PbPowerZone extends GeneratedMessageLite<Structures$PbPowerZone, Builder> implements Structures$PbPowerZoneOrBuilder {
    private static final Structures$PbPowerZone DEFAULT_INSTANCE;
    public static final int HIGHER_LIMIT_FIELD_NUMBER = 2;
    public static final int LOWER_LIMIT_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbPowerZone> PARSER;
    private int bitField0_;
    private int higherLimit_;
    private int lowerLimit_;
    private byte memoizedIsInitialized = 2;

    static {
        Structures$PbPowerZone structures$PbPowerZone = new Structures$PbPowerZone();
        DEFAULT_INSTANCE = structures$PbPowerZone;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbPowerZone.class, structures$PbPowerZone);
    }

    private Structures$PbPowerZone() {
    }

    private void clearHigherLimit() {
        this.bitField0_ &= -3;
        this.higherLimit_ = 0;
    }

    private void clearLowerLimit() {
        this.bitField0_ &= -2;
        this.lowerLimit_ = 0;
    }

    public static Structures$PbPowerZone getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbPowerZone parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbPowerZone parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbPowerZone> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHigherLimit(int i) {
        this.bitField0_ |= 2;
        this.higherLimit_ = i;
    }

    private void setLowerLimit(int i) {
        this.bitField0_ |= 1;
        this.lowerLimit_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbPowerZone();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔋ\u0000\u0002ᔋ\u0001", new Object[]{"bitField0_", "lowerLimit_", "higherLimit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbPowerZone> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbPowerZone.class) {
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

    public int getHigherLimit() {
        return this.higherLimit_;
    }

    public int getLowerLimit() {
        return this.lowerLimit_;
    }

    public boolean hasHigherLimit() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasLowerLimit() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbPowerZone, Builder> implements Structures$PbPowerZoneOrBuilder {
        private Builder() {
            super(Structures$PbPowerZone.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbPowerZone structures$PbPowerZone) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbPowerZone);
    }

    public static Structures$PbPowerZone parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbPowerZone parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbPowerZone parseFrom(ByteString byteString) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbPowerZone parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbPowerZone parseFrom(byte[] bArr) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbPowerZone parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbPowerZone parseFrom(InputStream inputStream) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbPowerZone parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbPowerZone parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbPowerZone parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbPowerZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
