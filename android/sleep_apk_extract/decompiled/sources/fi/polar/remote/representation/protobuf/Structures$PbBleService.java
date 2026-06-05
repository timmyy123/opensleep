package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class Structures$PbBleService extends GeneratedMessageLite<Structures$PbBleService, Builder> implements MessageLiteOrBuilder {
    public static final int CHARACTERISTICS_FIELD_NUMBER = 2;
    private static final Structures$PbBleService DEFAULT_INSTANCE;
    private static volatile Parser<Structures$PbBleService> PARSER = null;
    public static final int SERVICEUUID_FIELD_NUMBER = 1;
    private int bitField0_;
    private Structures$PbBleUuid serviceUuid_;
    private byte memoizedIsInitialized = 2;
    private Internal.ProtobufList<Structures$PbBleCharacteristic> characteristics_ = GeneratedMessageLite.emptyProtobufList();

    static {
        Structures$PbBleService structures$PbBleService = new Structures$PbBleService();
        DEFAULT_INSTANCE = structures$PbBleService;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbBleService.class, structures$PbBleService);
    }

    private Structures$PbBleService() {
    }

    private void addAllCharacteristics(Iterable<? extends Structures$PbBleCharacteristic> iterable) {
        ensureCharacteristicsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.characteristics_);
    }

    private void addCharacteristics(Structures$PbBleCharacteristic structures$PbBleCharacteristic) {
        structures$PbBleCharacteristic.getClass();
        ensureCharacteristicsIsMutable();
        this.characteristics_.add(structures$PbBleCharacteristic);
    }

    private void clearCharacteristics() {
        this.characteristics_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearServiceUuid() {
        this.serviceUuid_ = null;
        this.bitField0_ &= -2;
    }

    private void ensureCharacteristicsIsMutable() {
        Internal.ProtobufList<Structures$PbBleCharacteristic> protobufList = this.characteristics_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.characteristics_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static Structures$PbBleService getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeServiceUuid(Structures$PbBleUuid structures$PbBleUuid) {
        structures$PbBleUuid.getClass();
        Structures$PbBleUuid structures$PbBleUuid2 = this.serviceUuid_;
        if (structures$PbBleUuid2 == null || structures$PbBleUuid2 == Structures$PbBleUuid.getDefaultInstance()) {
            this.serviceUuid_ = structures$PbBleUuid;
        } else {
            this.serviceUuid_ = Structures$PbBleUuid.newBuilder(this.serviceUuid_).mergeFrom(structures$PbBleUuid).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbBleService parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbBleService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbBleService parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbBleService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbBleService> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCharacteristics(int i) {
        ensureCharacteristicsIsMutable();
        this.characteristics_.remove(i);
    }

    private void setCharacteristics(int i, Structures$PbBleCharacteristic structures$PbBleCharacteristic) {
        structures$PbBleCharacteristic.getClass();
        ensureCharacteristicsIsMutable();
        this.characteristics_.set(i, structures$PbBleCharacteristic);
    }

    private void setServiceUuid(Structures$PbBleUuid structures$PbBleUuid) {
        structures$PbBleUuid.getClass();
        this.serviceUuid_ = structures$PbBleUuid;
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbBleService();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0002\u0001ᔉ\u0000\u0002Л", new Object[]{"bitField0_", "serviceUuid_", "characteristics_", Structures$PbBleCharacteristic.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbBleService> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbBleService.class) {
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

    public Structures$PbBleCharacteristic getCharacteristics(int i) {
        return this.characteristics_.get(i);
    }

    public int getCharacteristicsCount() {
        return this.characteristics_.size();
    }

    public List<Structures$PbBleCharacteristic> getCharacteristicsList() {
        return this.characteristics_;
    }

    public Structures$PbBleCharacteristicOrBuilder getCharacteristicsOrBuilder(int i) {
        return this.characteristics_.get(i);
    }

    public List<? extends Structures$PbBleCharacteristicOrBuilder> getCharacteristicsOrBuilderList() {
        return this.characteristics_;
    }

    public Structures$PbBleUuid getServiceUuid() {
        Structures$PbBleUuid structures$PbBleUuid = this.serviceUuid_;
        return structures$PbBleUuid == null ? Structures$PbBleUuid.getDefaultInstance() : structures$PbBleUuid;
    }

    public boolean hasServiceUuid() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbBleService, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Structures$PbBleService.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbBleService structures$PbBleService) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbBleService);
    }

    public static Structures$PbBleService parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleService) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbBleService parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbBleService parseFrom(ByteString byteString) {
        return (Structures$PbBleService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbBleService parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addCharacteristics(int i, Structures$PbBleCharacteristic structures$PbBleCharacteristic) {
        structures$PbBleCharacteristic.getClass();
        ensureCharacteristicsIsMutable();
        this.characteristics_.add(i, structures$PbBleCharacteristic);
    }

    public static Structures$PbBleService parseFrom(byte[] bArr) {
        return (Structures$PbBleService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbBleService parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbBleService parseFrom(InputStream inputStream) {
        return (Structures$PbBleService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbBleService parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbBleService parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbBleService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbBleService parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbBleService) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
