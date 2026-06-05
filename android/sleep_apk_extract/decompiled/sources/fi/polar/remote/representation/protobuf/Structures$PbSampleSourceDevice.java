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
public final class Structures$PbSampleSourceDevice extends GeneratedMessageLite<Structures$PbSampleSourceDevice, Builder> implements Structures$PbSampleSourceDeviceOrBuilder {
    private static final Structures$PbSampleSourceDevice DEFAULT_INSTANCE;
    private static volatile Parser<Structures$PbSampleSourceDevice> PARSER = null;
    public static final int SOURCE_DEVICE_FIELD_NUMBER = 2;
    public static final int START_INDEX_FIELD_NUMBER = 1;
    private int bitField0_;
    private byte memoizedIsInitialized = 2;
    private Structures$PbSourceDevice sourceDevice_;
    private int startIndex_;

    static {
        Structures$PbSampleSourceDevice structures$PbSampleSourceDevice = new Structures$PbSampleSourceDevice();
        DEFAULT_INSTANCE = structures$PbSampleSourceDevice;
        GeneratedMessageLite.registerDefaultInstance(Structures$PbSampleSourceDevice.class, structures$PbSampleSourceDevice);
    }

    private Structures$PbSampleSourceDevice() {
    }

    private void clearSourceDevice() {
        this.sourceDevice_ = null;
        this.bitField0_ &= -3;
    }

    private void clearStartIndex() {
        this.bitField0_ &= -2;
        this.startIndex_ = 0;
    }

    public static Structures$PbSampleSourceDevice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeSourceDevice(Structures$PbSourceDevice structures$PbSourceDevice) {
        structures$PbSourceDevice.getClass();
        Structures$PbSourceDevice structures$PbSourceDevice2 = this.sourceDevice_;
        if (structures$PbSourceDevice2 == null || structures$PbSourceDevice2 == Structures$PbSourceDevice.getDefaultInstance()) {
            this.sourceDevice_ = structures$PbSourceDevice;
        } else {
            this.sourceDevice_ = Structures$PbSourceDevice.newBuilder(this.sourceDevice_).mergeFrom(structures$PbSourceDevice).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Structures$PbSampleSourceDevice parseDelimitedFrom(InputStream inputStream) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbSampleSourceDevice parseFrom(ByteBuffer byteBuffer) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Structures$PbSampleSourceDevice> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setSourceDevice(Structures$PbSourceDevice structures$PbSourceDevice) {
        structures$PbSourceDevice.getClass();
        this.sourceDevice_ = structures$PbSourceDevice;
        this.bitField0_ |= 2;
    }

    private void setStartIndex(int i) {
        this.bitField0_ |= 1;
        this.startIndex_ = i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (Structures$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Structures$PbSampleSourceDevice();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔋ\u0000\u0002ᔉ\u0001", new Object[]{"bitField0_", "startIndex_", "sourceDevice_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Structures$PbSampleSourceDevice> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (Structures$PbSampleSourceDevice.class) {
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

    public Structures$PbSourceDevice getSourceDevice() {
        Structures$PbSourceDevice structures$PbSourceDevice = this.sourceDevice_;
        return structures$PbSourceDevice == null ? Structures$PbSourceDevice.getDefaultInstance() : structures$PbSourceDevice;
    }

    public int getStartIndex() {
        return this.startIndex_;
    }

    public boolean hasSourceDevice() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStartIndex() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<Structures$PbSampleSourceDevice, Builder> implements Structures$PbSampleSourceDeviceOrBuilder {
        private Builder() {
            super(Structures$PbSampleSourceDevice.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(Structures$PbSampleSourceDevice structures$PbSampleSourceDevice) {
        return DEFAULT_INSTANCE.createBuilder(structures$PbSampleSourceDevice);
    }

    public static Structures$PbSampleSourceDevice parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbSampleSourceDevice parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Structures$PbSampleSourceDevice parseFrom(ByteString byteString) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Structures$PbSampleSourceDevice parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Structures$PbSampleSourceDevice parseFrom(byte[] bArr) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Structures$PbSampleSourceDevice parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Structures$PbSampleSourceDevice parseFrom(InputStream inputStream) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Structures$PbSampleSourceDevice parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Structures$PbSampleSourceDevice parseFrom(CodedInputStream codedInputStream) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Structures$PbSampleSourceDevice parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Structures$PbSampleSourceDevice) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
