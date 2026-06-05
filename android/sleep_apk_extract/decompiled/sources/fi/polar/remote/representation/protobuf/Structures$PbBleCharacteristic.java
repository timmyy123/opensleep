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
public final class Structures$PbBleCharacteristic extends GeneratedMessageLite<Structures$PbBleCharacteristic, Builder> implements Structures$PbBleCharacteristicOrBuilder {
    private static final Structures$PbBleCharacteristic DEFAULT_INSTANCE;
    public static final int HANDLE_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbBleCharacteristic> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private int handle_;
    private byte memoizedIsInitialized = 2;
    private Structures$PbBleUuid type_;

    static {
        Structures$PbBleCharacteristic structures$PbBleCharacteristic = new Structures$PbBleCharacteristic();
        DEFAULT_INSTANCE = structures$PbBleCharacteristic;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbBleCharacteristic.class, structures$PbBleCharacteristic);
    }

    private Structures$PbBleCharacteristic() {
    }

    private void clearHandle() {
        this.bitField0_ &= -2;
        this.handle_ = 0;
    }

    private void clearType() {
        this.type_ = null;
        this.bitField0_ &= -3;
    }

    public static Structures$PbBleCharacteristic getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeType(Structures$PbBleUuid structures$PbBleUuid) {
        structures$PbBleUuid.getClass();
        Structures$PbBleUuid structures$PbBleUuid2 = this.type_;
        if (structures$PbBleUuid2 == null || structures$PbBleUuid2 == Structures$PbBleUuid.getDefaultInstance()) {
            this.type_ = structures$PbBleUuid;
        } else {
            this.type_ = Structures$PbBleUuid.newBuilder(this.type_).mergeFrom(structures$PbBleUuid).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbBleCharacteristic parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbBleCharacteristic parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbBleCharacteristic> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setHandle(int i) {
        this.bitField0_ |= 1;
        this.handle_ = i;
    }

    private void setType(Structures$PbBleUuid structures$PbBleUuid) {
        structures$PbBleUuid.getClass();
        this.type_ = structures$PbBleUuid;
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbBleCharacteristic();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔋ\u0000\u0002ᔉ\u0001", new Object[]{"bitField0_", "handle_", "type_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbBleCharacteristic> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbBleCharacteristic.class) {
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

    public int getHandle() {
        return this.handle_;
    }

    public Structures$PbBleUuid getType() {
        Structures$PbBleUuid structures$PbBleUuid = this.type_;
        return structures$PbBleUuid == null ? Structures$PbBleUuid.getDefaultInstance() : structures$PbBleUuid;
    }

    public boolean hasHandle() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasType() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbBleCharacteristic, Builder> implements Structures$PbBleCharacteristicOrBuilder {
        private Builder() {
            super(Structures$PbBleCharacteristic.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbBleCharacteristic structures$PbBleCharacteristic) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbBleCharacteristic);
    }

    public static Structures$PbBleCharacteristic parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbBleCharacteristic parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbBleCharacteristic parseFrom(ByteString byteString) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbBleCharacteristic parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbBleCharacteristic parseFrom(byte[] bArr) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbBleCharacteristic parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbBleCharacteristic parseFrom(InputStream inputStream) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbBleCharacteristic parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbBleCharacteristic parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbBleCharacteristic parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleCharacteristic) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
