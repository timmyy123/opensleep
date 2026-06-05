package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class Structures$PbSourceDevice extends GeneratedMessageLite<Structures$PbSourceDevice, Builder> implements Structures$PbSourceDeviceOrBuilder {
    public static final int COLLECTOR_FIELD_NUMBER = 8;
    private static final Structures$PbSourceDevice DEFAULT_INSTANCE;
    public static final int HARDWARE_CODE_FIELD_NUMBER = 4;
    public static final int MANUFACTURER_FIELD_NUMBER = 2;
    public static final int MODEL_NUMBER_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Structures$PbSourceDevice> PARSER = null;
    public static final int PLATFORM_VERSION_FIELD_NUMBER = 5;
    public static final int POLARMATHSMART_VERSION_FIELD_NUMBER = 7;
    public static final int SOFTWARE_VERSION_FIELD_NUMBER = 6;
    private int bitField0_;
    private Structures$PbVersion platformVersion_;
    private Structures$PbVersion polarmathsmartVersion_;
    private Structures$PbVersion softwareVersion_;
    private byte memoizedIsInitialized = 2;
    private String name_ = "";
    private String manufacturer_ = "";
    private String modelNumber_ = "";
    private String hardwareCode_ = "";
    private Internal.ProtobufList<Structures$PbSourceDevice> collector_ = GeneratedMessageLite.emptyProtobufList();

    static {
        Structures$PbSourceDevice structures$PbSourceDevice = new Structures$PbSourceDevice();
        DEFAULT_INSTANCE = structures$PbSourceDevice;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbSourceDevice.class, structures$PbSourceDevice);
    }

    private Structures$PbSourceDevice() {
    }

    private void addAllCollector(Iterable<? extends Structures$PbSourceDevice> iterable) {
        ensureCollectorIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.collector_);
    }

    private void addCollector(Structures$PbSourceDevice structures$PbSourceDevice) {
        structures$PbSourceDevice.getClass();
        ensureCollectorIsMutable();
        this.collector_.add(structures$PbSourceDevice);
    }

    private void clearCollector() {
        this.collector_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void clearHardwareCode() {
        this.bitField0_ &= -9;
        this.hardwareCode_ = getDefaultInstance().getHardwareCode();
    }

    private void clearManufacturer() {
        this.bitField0_ &= -3;
        this.manufacturer_ = getDefaultInstance().getManufacturer();
    }

    private void clearModelNumber() {
        this.bitField0_ &= -5;
        this.modelNumber_ = getDefaultInstance().getModelNumber();
    }

    private void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    private void clearPlatformVersion() {
        this.platformVersion_ = null;
        this.bitField0_ &= -17;
    }

    private void clearPolarmathsmartVersion() {
        this.polarmathsmartVersion_ = null;
        this.bitField0_ &= -65;
    }

    private void clearSoftwareVersion() {
        this.softwareVersion_ = null;
        this.bitField0_ &= -33;
    }

    private void ensureCollectorIsMutable() {
        Internal.ProtobufList<Structures$PbSourceDevice> protobufList = this.collector_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.collector_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static Structures$PbSourceDevice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergePlatformVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        Structures$PbVersion structures$PbVersion2 = this.platformVersion_;
        if (structures$PbVersion2 == null || structures$PbVersion2 == Structures$PbVersion.getDefaultInstance()) {
            this.platformVersion_ = structures$PbVersion;
        } else {
            this.platformVersion_ = Structures$PbVersion.newBuilder(this.platformVersion_).mergeFrom(structures$PbVersion).buildPartial();
        }
        this.bitField0_ |= 16;
    }

    private void mergePolarmathsmartVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        Structures$PbVersion structures$PbVersion2 = this.polarmathsmartVersion_;
        if (structures$PbVersion2 == null || structures$PbVersion2 == Structures$PbVersion.getDefaultInstance()) {
            this.polarmathsmartVersion_ = structures$PbVersion;
        } else {
            this.polarmathsmartVersion_ = Structures$PbVersion.newBuilder(this.polarmathsmartVersion_).mergeFrom(structures$PbVersion).buildPartial();
        }
        this.bitField0_ |= 64;
    }

    private void mergeSoftwareVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        Structures$PbVersion structures$PbVersion2 = this.softwareVersion_;
        if (structures$PbVersion2 == null || structures$PbVersion2 == Structures$PbVersion.getDefaultInstance()) {
            this.softwareVersion_ = structures$PbVersion;
        } else {
            this.softwareVersion_ = Structures$PbVersion.newBuilder(this.softwareVersion_).mergeFrom(structures$PbVersion).buildPartial();
        }
        this.bitField0_ |= 32;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbSourceDevice parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbSourceDevice parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbSourceDevice> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void removeCollector(int i) {
        ensureCollectorIsMutable();
        this.collector_.remove(i);
    }

    private void setCollector(int i, Structures$PbSourceDevice structures$PbSourceDevice) {
        structures$PbSourceDevice.getClass();
        ensureCollectorIsMutable();
        this.collector_.set(i, structures$PbSourceDevice);
    }

    private void setHardwareCode(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.hardwareCode_ = str;
    }

    private void setHardwareCodeBytes(ByteString byteString) {
        this.hardwareCode_ = byteString.toStringUtf8();
        this.bitField0_ |= 8;
    }

    private void setManufacturer(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.manufacturer_ = str;
    }

    private void setManufacturerBytes(ByteString byteString) {
        this.manufacturer_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    private void setModelNumber(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.modelNumber_ = str;
    }

    private void setModelNumberBytes(ByteString byteString) {
        this.modelNumber_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    private void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    private void setNameBytes(ByteString byteString) {
        this.name_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    private void setPlatformVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        this.platformVersion_ = structures$PbVersion;
        this.bitField0_ |= 16;
    }

    private void setPolarmathsmartVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        this.polarmathsmartVersion_ = structures$PbVersion;
        this.bitField0_ |= 64;
    }

    private void setSoftwareVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        this.softwareVersion_ = structures$PbVersion;
        this.bitField0_ |= 32;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbSourceDevice();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0005\u0001ᔈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ᐉ\u0004\u0006ᐉ\u0005\u0007ᐉ\u0006\bЛ", new Object[]{"bitField0_", "name_", "manufacturer_", "modelNumber_", "hardwareCode_", "platformVersion_", "softwareVersion_", "polarmathsmartVersion_", "collector_", Structures$PbSourceDevice.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbSourceDevice> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbSourceDevice.class) {
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

    public Structures$PbSourceDevice getCollector(int i) {
        return this.collector_.get(i);
    }

    public int getCollectorCount() {
        return this.collector_.size();
    }

    public List<Structures$PbSourceDevice> getCollectorList() {
        return this.collector_;
    }

    public Structures$PbSourceDeviceOrBuilder getCollectorOrBuilder(int i) {
        return this.collector_.get(i);
    }

    public List<? extends Structures$PbSourceDeviceOrBuilder> getCollectorOrBuilderList() {
        return this.collector_;
    }

    public String getHardwareCode() {
        return this.hardwareCode_;
    }

    public ByteString getHardwareCodeBytes() {
        return ByteString.copyFromUtf8(this.hardwareCode_);
    }

    public String getManufacturer() {
        return this.manufacturer_;
    }

    public ByteString getManufacturerBytes() {
        return ByteString.copyFromUtf8(this.manufacturer_);
    }

    public String getModelNumber() {
        return this.modelNumber_;
    }

    public ByteString getModelNumberBytes() {
        return ByteString.copyFromUtf8(this.modelNumber_);
    }

    public String getName() {
        return this.name_;
    }

    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    public Structures$PbVersion getPlatformVersion() {
        Structures$PbVersion structures$PbVersion = this.platformVersion_;
        return structures$PbVersion == null ? Structures$PbVersion.getDefaultInstance() : structures$PbVersion;
    }

    public Structures$PbVersion getPolarmathsmartVersion() {
        Structures$PbVersion structures$PbVersion = this.polarmathsmartVersion_;
        return structures$PbVersion == null ? Structures$PbVersion.getDefaultInstance() : structures$PbVersion;
    }

    public Structures$PbVersion getSoftwareVersion() {
        Structures$PbVersion structures$PbVersion = this.softwareVersion_;
        return structures$PbVersion == null ? Structures$PbVersion.getDefaultInstance() : structures$PbVersion;
    }

    public boolean hasHardwareCode() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasManufacturer() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasModelNumber() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasPlatformVersion() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasPolarmathsmartVersion() {
        return (this.bitField0_ & 64) != 0;
    }

    public boolean hasSoftwareVersion() {
        return (this.bitField0_ & 32) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbSourceDevice, Builder> implements Structures$PbSourceDeviceOrBuilder {
        private Builder() {
            super(Structures$PbSourceDevice.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbSourceDevice structures$PbSourceDevice) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbSourceDevice);
    }

    public static Structures$PbSourceDevice parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbSourceDevice parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbSourceDevice parseFrom(ByteString byteString) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbSourceDevice parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    private void addCollector(int i, Structures$PbSourceDevice structures$PbSourceDevice) {
        structures$PbSourceDevice.getClass();
        ensureCollectorIsMutable();
        this.collector_.add(i, structures$PbSourceDevice);
    }

    public static Structures$PbSourceDevice parseFrom(byte[] bArr) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbSourceDevice parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbSourceDevice parseFrom(InputStream inputStream) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbSourceDevice parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbSourceDevice parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbSourceDevice parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
