package fi.polar.remote.representation.protobuf;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class UserDeviceSettings$PbUsbConnectionSettings extends GeneratedMessageLite<UserDeviceSettings$PbUsbConnectionSettings, Builder> implements MessageLiteOrBuilder {
    private static final UserDeviceSettings$PbUsbConnectionSettings DEFAULT_INSTANCE;
    public static final int MODE_FIELD_NUMBER = 1;
    private static volatile Parser<UserDeviceSettings$PbUsbConnectionSettings> PARSER;
    private int bitField0_;
    private int mode_;

    public enum PbUsbConnectionMode implements Internal.EnumLite {
        UNKNOWN(0),
        OFF(1),
        ON(2);

        private static final Internal.EnumLiteMap<PbUsbConnectionMode> internalValueMap = new Internal.EnumLiteMap<PbUsbConnectionMode>() { // from class: fi.polar.remote.representation.protobuf.UserDeviceSettings.PbUsbConnectionSettings.PbUsbConnectionMode.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PbUsbConnectionMode findValueByNumber(int i) {
                return PbUsbConnectionMode.forNumber(i);
            }
        };
        private final int value;

        public static final class PbUsbConnectionModeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PbUsbConnectionModeVerifier();

            private PbUsbConnectionModeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return PbUsbConnectionMode.forNumber(i) != null;
            }
        }

        PbUsbConnectionMode(int i) {
            this.value = i;
        }

        public static PbUsbConnectionMode forNumber(int i) {
            if (i == 0) {
                return UNKNOWN;
            }
            if (i == 1) {
                return OFF;
            }
            if (i != 2) {
                return null;
            }
            return ON;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PbUsbConnectionModeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        UserDeviceSettings$PbUsbConnectionSettings userDeviceSettings$PbUsbConnectionSettings = new UserDeviceSettings$PbUsbConnectionSettings();
        DEFAULT_INSTANCE = userDeviceSettings$PbUsbConnectionSettings;
        GeneratedMessageLite.registerDefaultInstance(UserDeviceSettings$PbUsbConnectionSettings.class, userDeviceSettings$PbUsbConnectionSettings);
    }

    private UserDeviceSettings$PbUsbConnectionSettings() {
    }

    private void clearMode() {
        this.bitField0_ &= -2;
        this.mode_ = 0;
    }

    public static UserDeviceSettings$PbUsbConnectionSettings getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseDelimitedFrom(InputStream inputStream) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseFrom(ByteBuffer byteBuffer) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UserDeviceSettings$PbUsbConnectionSettings> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setMode(PbUsbConnectionMode pbUsbConnectionMode) {
        this.mode_ = pbUsbConnectionMode.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (UserDeviceSettings$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new UserDeviceSettings$PbUsbConnectionSettings();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"bitField0_", "mode_", PbUsbConnectionMode.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UserDeviceSettings$PbUsbConnectionSettings> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UserDeviceSettings$PbUsbConnectionSettings.class) {
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
                return (byte) 1;
            default:
                Home$$ExternalSyntheticBUOutline0.m$1();
            case 7:
                return null;
        }
    }

    public PbUsbConnectionMode getMode() {
        PbUsbConnectionMode pbUsbConnectionModeForNumber = PbUsbConnectionMode.forNumber(this.mode_);
        return pbUsbConnectionModeForNumber == null ? PbUsbConnectionMode.UNKNOWN : pbUsbConnectionModeForNumber;
    }

    public boolean hasMode() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<UserDeviceSettings$PbUsbConnectionSettings, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(UserDeviceSettings$PbUsbConnectionSettings.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(UserDeviceSettings$PbUsbConnectionSettings userDeviceSettings$PbUsbConnectionSettings) {
        return DEFAULT_INSTANCE.createBuilder(userDeviceSettings$PbUsbConnectionSettings);
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseFrom(ByteString byteString) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseFrom(byte[] bArr) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseFrom(InputStream inputStream) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseFrom(CodedInputStream codedInputStream) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UserDeviceSettings$PbUsbConnectionSettings parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUsbConnectionSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
