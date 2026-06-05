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
public final class Structures$PbHeartRateZone extends GeneratedMessageLite<Structures$PbHeartRateZone, Builder> implements Structures$PbHeartRateZoneOrBuilder {
    private static final Structures$PbHeartRateZone DEFAULT_INSTANCE;
    public static final int HIGHER_LIMIT_FIELD_NUMBER = 2;
    public static final int LOWER_LIMIT_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbHeartRateZone> PARSER;
    private int bitField0_;
    private int higherLimit_;
    private int lowerLimit_;
    private byte memoizedIsInitialized = 2;

    static {
        Structures$PbHeartRateZone structures$PbHeartRateZone = new Structures$PbHeartRateZone();
        DEFAULT_INSTANCE = structures$PbHeartRateZone;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbHeartRateZone.class, structures$PbHeartRateZone);
    }

    private Structures$PbHeartRateZone() {
    }

    private void clearHigherLimit() {
        this.bitField0_ &= -3;
        this.higherLimit_ = 0;
    }

    private void clearLowerLimit() {
        this.bitField0_ &= -2;
        this.lowerLimit_ = 0;
    }

    public static Structures$PbHeartRateZone getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbHeartRateZone parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbHeartRateZone parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbHeartRateZone> parser() {
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
                return new Structures$PbHeartRateZone();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔋ\u0000\u0002ᔋ\u0001", new Object[]{"bitField0_", "lowerLimit_", "higherLimit_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbHeartRateZone> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbHeartRateZone.class) {
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

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbHeartRateZone, Builder> implements Structures$PbHeartRateZoneOrBuilder {
        private Builder() {
            super(Structures$PbHeartRateZone.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbHeartRateZone structures$PbHeartRateZone) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbHeartRateZone);
    }

    public static Structures$PbHeartRateZone parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbHeartRateZone parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbHeartRateZone parseFrom(ByteString byteString) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbHeartRateZone parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbHeartRateZone parseFrom(byte[] bArr) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbHeartRateZone parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbHeartRateZone parseFrom(InputStream inputStream) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbHeartRateZone parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbHeartRateZone parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbHeartRateZone parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbHeartRateZone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
