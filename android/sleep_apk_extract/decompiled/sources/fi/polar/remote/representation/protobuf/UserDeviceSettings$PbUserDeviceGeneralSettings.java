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
public final class UserDeviceSettings$PbUserDeviceGeneralSettings extends GeneratedMessageLite<UserDeviceSettings$PbUserDeviceGeneralSettings, Builder> implements MessageLiteOrBuilder {
    private static final UserDeviceSettings$PbUserDeviceGeneralSettings DEFAULT_INSTANCE;
    public static final int DEVICE_LOCATION_FIELD_NUMBER = 15;
    private static volatile Parser<UserDeviceSettings$PbUserDeviceGeneralSettings> PARSER;
    private int bitField0_;
    private int deviceLocation_;

    static {
        UserDeviceSettings$PbUserDeviceGeneralSettings userDeviceSettings$PbUserDeviceGeneralSettings = new UserDeviceSettings$PbUserDeviceGeneralSettings();
        DEFAULT_INSTANCE = userDeviceSettings$PbUserDeviceGeneralSettings;
        GeneratedMessageLite.registerDefaultInstance(UserDeviceSettings$PbUserDeviceGeneralSettings.class, userDeviceSettings$PbUserDeviceGeneralSettings);
    }

    private UserDeviceSettings$PbUserDeviceGeneralSettings() {
    }

    private void clearDeviceLocation() {
        this.bitField0_ &= -2;
        this.deviceLocation_ = 0;
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseDelimitedFrom(InputStream inputStream) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseFrom(ByteBuffer byteBuffer) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UserDeviceSettings$PbUserDeviceGeneralSettings> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setDeviceLocation(Types$PbDeviceLocation types$PbDeviceLocation) {
        this.deviceLocation_ = types$PbDeviceLocation.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (UserDeviceSettings$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new UserDeviceSettings$PbUserDeviceGeneralSettings();
            case 2:
                return new Builder(0);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u000f\u000f\u0001\u0000\u0000\u0000\u000fဌ\u0000", new Object[]{"bitField0_", "deviceLocation_", Types$PbDeviceLocation.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UserDeviceSettings$PbUserDeviceGeneralSettings> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UserDeviceSettings$PbUserDeviceGeneralSettings.class) {
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

    public Types$PbDeviceLocation getDeviceLocation() {
        Types$PbDeviceLocation types$PbDeviceLocationForNumber = Types$PbDeviceLocation.forNumber(this.deviceLocation_);
        return types$PbDeviceLocationForNumber == null ? Types$PbDeviceLocation.DEVICE_LOCATION_UNDEFINED : types$PbDeviceLocationForNumber;
    }

    public boolean hasDeviceLocation() {
        return (this.bitField0_ & 1) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<UserDeviceSettings$PbUserDeviceGeneralSettings, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(UserDeviceSettings$PbUserDeviceGeneralSettings.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(UserDeviceSettings$PbUserDeviceGeneralSettings userDeviceSettings$PbUserDeviceGeneralSettings) {
        return DEFAULT_INSTANCE.createBuilder(userDeviceSettings$PbUserDeviceGeneralSettings);
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseFrom(ByteString byteString) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseFrom(byte[] bArr) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseFrom(InputStream inputStream) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseFrom(CodedInputStream codedInputStream) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UserDeviceSettings$PbUserDeviceGeneralSettings parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceGeneralSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
