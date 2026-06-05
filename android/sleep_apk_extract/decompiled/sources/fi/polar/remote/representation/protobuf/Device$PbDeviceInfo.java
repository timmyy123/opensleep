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
public final class Device$PbDeviceInfo extends GeneratedMessageLite<Device$PbDeviceInfo, Builder> implements MessageLiteOrBuilder {
    private static final Device$PbDeviceInfo DEFAULT_INSTANCE;
    public static final int DEVICE_VERSION_FIELD_NUMBER = 3;
    public static final int HARDWARE_CODE_FIELD_NUMBER = 8;
    public static final int MODEL_NAME_FIELD_NUMBER = 7;
    private static volatile Parser<Device$PbDeviceInfo> PARSER;
    private int bitField0_;
    private Structures$PbVersion deviceVersion_;
    private byte memoizedIsInitialized = 2;
    private String modelName_ = "";
    private String hardwareCode_ = "";

    static {
        Device$PbDeviceInfo device$PbDeviceInfo = new Device$PbDeviceInfo();
        DEFAULT_INSTANCE = device$PbDeviceInfo;
        GeneratedMessageLite.registerDefaultInstance(Device$PbDeviceInfo.class, device$PbDeviceInfo);
    }

    private Device$PbDeviceInfo() {
    }

    private void clearDeviceVersion() {
        this.deviceVersion_ = null;
        this.bitField0_ &= -2;
    }

    private void clearHardwareCode() {
        this.bitField0_ &= -5;
        this.hardwareCode_ = getDefaultInstance().getHardwareCode();
    }

    private void clearModelName() {
        this.bitField0_ &= -3;
        this.modelName_ = getDefaultInstance().getModelName();
    }

    public static Device$PbDeviceInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeDeviceVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        Structures$PbVersion structures$PbVersion2 = this.deviceVersion_;
        if (structures$PbVersion2 == null || structures$PbVersion2 == Structures$PbVersion.getDefaultInstance()) {
            this.deviceVersion_ = structures$PbVersion;
        } else {
            this.deviceVersion_ = Structures$PbVersion.newBuilder(this.deviceVersion_).mergeFrom(structures$PbVersion).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Device$PbDeviceInfo parseDelimitedFrom(InputStream inputStream) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Device$PbDeviceInfo parseFrom(ByteBuffer byteBuffer) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Device$PbDeviceInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDeviceVersion(Structures$PbVersion structures$PbVersion) {
        structures$PbVersion.getClass();
        this.deviceVersion_ = structures$PbVersion;
        this.bitField0_ |= 1;
    }

    private void setHardwareCode(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.hardwareCode_ = str;
    }

    private void setHardwareCodeBytes(ByteString byteString) {
        this.hardwareCode_ = byteString.toStringUtf8();
        this.bitField0_ |= 4;
    }

    private void setModelName(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.modelName_ = str;
    }

    private void setModelNameBytes(ByteString byteString) {
        this.modelName_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Device$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Device$PbDeviceInfo();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0003\b\u0003\u0000\u0000\u0001\u0003ᐉ\u0000\u0007ဈ\u0001\bဈ\u0002", new Object[]{"bitField0_", "deviceVersion_", "modelName_", "hardwareCode_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Device$PbDeviceInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Device$PbDeviceInfo.class) {
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

    public Structures$PbVersion getDeviceVersion() {
        Structures$PbVersion structures$PbVersion = this.deviceVersion_;
        return structures$PbVersion == null ? Structures$PbVersion.getDefaultInstance() : structures$PbVersion;
    }

    public String getHardwareCode() {
        return this.hardwareCode_;
    }

    public ByteString getHardwareCodeBytes() {
        return ByteString.copyFromUtf8(this.hardwareCode_);
    }

    public String getModelName() {
        return this.modelName_;
    }

    public ByteString getModelNameBytes() {
        return ByteString.copyFromUtf8(this.modelName_);
    }

    public boolean hasDeviceVersion() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasHardwareCode() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasModelName() {
        return (this.bitField0_ & 2) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Device$PbDeviceInfo, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(Device$PbDeviceInfo.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Device$PbDeviceInfo device$PbDeviceInfo) {
        return DEFAULT_INSTANCE.createBuilder(device$PbDeviceInfo);
    }

    public static Device$PbDeviceInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Device$PbDeviceInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Device$PbDeviceInfo parseFrom(ByteString byteString) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Device$PbDeviceInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Device$PbDeviceInfo parseFrom(byte[] bArr) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Device$PbDeviceInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Device$PbDeviceInfo parseFrom(InputStream inputStream) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Device$PbDeviceInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Device$PbDeviceInfo parseFrom(CodedInputStream codedInputStream) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Device$PbDeviceInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Device$PbDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
