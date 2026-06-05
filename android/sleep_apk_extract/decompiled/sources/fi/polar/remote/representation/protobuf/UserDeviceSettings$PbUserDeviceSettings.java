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
public final class UserDeviceSettings$PbUserDeviceSettings extends GeneratedMessageLite<UserDeviceSettings$PbUserDeviceSettings, Builder> implements MessageLiteOrBuilder {
    private static final UserDeviceSettings$PbUserDeviceSettings DEFAULT_INSTANCE;
    public static final int GENERAL_SETTINGS_FIELD_NUMBER = 1;
    public static final int LAST_MODIFIED_FIELD_NUMBER = 101;
    private static volatile Parser<UserDeviceSettings$PbUserDeviceSettings> PARSER = null;
    public static final int USB_CONNECTION_SETTINGS_FIELD_NUMBER = 27;
    private int bitField0_;
    private UserDeviceSettings$PbUserDeviceGeneralSettings generalSettings_;
    private Types$PbSystemDateTime lastModified_;
    private byte memoizedIsInitialized = 2;
    private UserDeviceSettings$PbUsbConnectionSettings usbConnectionSettings_;

    static {
        UserDeviceSettings$PbUserDeviceSettings userDeviceSettings$PbUserDeviceSettings = new UserDeviceSettings$PbUserDeviceSettings();
        DEFAULT_INSTANCE = userDeviceSettings$PbUserDeviceSettings;
        GeneratedMessageLite.registerDefaultInstance(UserDeviceSettings$PbUserDeviceSettings.class, userDeviceSettings$PbUserDeviceSettings);
    }

    private UserDeviceSettings$PbUserDeviceSettings() {
    }

    private void clearGeneralSettings() {
        this.generalSettings_ = null;
        this.bitField0_ &= -2;
    }

    private void clearLastModified() {
        this.lastModified_ = null;
        this.bitField0_ &= -3;
    }

    private void clearUsbConnectionSettings() {
        this.usbConnectionSettings_ = null;
        this.bitField0_ &= -5;
    }

    public static UserDeviceSettings$PbUserDeviceSettings getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private void mergeGeneralSettings(UserDeviceSettings$PbUserDeviceGeneralSettings userDeviceSettings$PbUserDeviceGeneralSettings) {
        userDeviceSettings$PbUserDeviceGeneralSettings.getClass();
        UserDeviceSettings$PbUserDeviceGeneralSettings userDeviceSettings$PbUserDeviceGeneralSettings2 = this.generalSettings_;
        if (userDeviceSettings$PbUserDeviceGeneralSettings2 == null || userDeviceSettings$PbUserDeviceGeneralSettings2 == UserDeviceSettings$PbUserDeviceGeneralSettings.getDefaultInstance()) {
            this.generalSettings_ = userDeviceSettings$PbUserDeviceGeneralSettings;
        } else {
            this.generalSettings_ = UserDeviceSettings$PbUserDeviceGeneralSettings.newBuilder(this.generalSettings_).mergeFrom(userDeviceSettings$PbUserDeviceGeneralSettings).buildPartial();
        }
        this.bitField0_ |= 1;
    }

    private void mergeLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        Types$PbSystemDateTime types$PbSystemDateTime2 = this.lastModified_;
        if (types$PbSystemDateTime2 == null || types$PbSystemDateTime2 == Types$PbSystemDateTime.getDefaultInstance()) {
            this.lastModified_ = types$PbSystemDateTime;
        } else {
            this.lastModified_ = Types$PbSystemDateTime.newBuilder(this.lastModified_).mergeFrom(types$PbSystemDateTime).buildPartial();
        }
        this.bitField0_ |= 2;
    }

    private void mergeUsbConnectionSettings(UserDeviceSettings$PbUsbConnectionSettings userDeviceSettings$PbUsbConnectionSettings) {
        userDeviceSettings$PbUsbConnectionSettings.getClass();
        UserDeviceSettings$PbUsbConnectionSettings userDeviceSettings$PbUsbConnectionSettings2 = this.usbConnectionSettings_;
        if (userDeviceSettings$PbUsbConnectionSettings2 == null || userDeviceSettings$PbUsbConnectionSettings2 == UserDeviceSettings$PbUsbConnectionSettings.getDefaultInstance()) {
            this.usbConnectionSettings_ = userDeviceSettings$PbUsbConnectionSettings;
        } else {
            this.usbConnectionSettings_ = UserDeviceSettings$PbUsbConnectionSettings.newBuilder(this.usbConnectionSettings_).mergeFrom(userDeviceSettings$PbUsbConnectionSettings).buildPartial();
        }
        this.bitField0_ |= 4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseDelimitedFrom(InputStream inputStream) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseFrom(ByteBuffer byteBuffer) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UserDeviceSettings$PbUserDeviceSettings> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    private void setGeneralSettings(UserDeviceSettings$PbUserDeviceGeneralSettings userDeviceSettings$PbUserDeviceGeneralSettings) {
        userDeviceSettings$PbUserDeviceGeneralSettings.getClass();
        this.generalSettings_ = userDeviceSettings$PbUserDeviceGeneralSettings;
        this.bitField0_ |= 1;
    }

    private void setLastModified(Types$PbSystemDateTime types$PbSystemDateTime) {
        types$PbSystemDateTime.getClass();
        this.lastModified_ = types$PbSystemDateTime;
        this.bitField0_ |= 2;
    }

    private void setUsbConnectionSettings(UserDeviceSettings$PbUsbConnectionSettings userDeviceSettings$PbUsbConnectionSettings) {
        userDeviceSettings$PbUsbConnectionSettings.getClass();
        this.usbConnectionSettings_ = userDeviceSettings$PbUsbConnectionSettings;
        this.bitField0_ |= 4;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        switch (UserDeviceSettings$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new UserDeviceSettings$PbUserDeviceSettings();
            case 2:
                return new Builder(i);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001e\u0003\u0000\u0000\u0002\u0001ᔉ\u0000\u001bဉ\u0002eᔉ\u0001", new Object[]{"bitField0_", "generalSettings_", "usbConnectionSettings_", "lastModified_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UserDeviceSettings$PbUserDeviceSettings> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (UserDeviceSettings$PbUserDeviceSettings.class) {
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

    public UserDeviceSettings$PbUserDeviceGeneralSettings getGeneralSettings() {
        UserDeviceSettings$PbUserDeviceGeneralSettings userDeviceSettings$PbUserDeviceGeneralSettings = this.generalSettings_;
        return userDeviceSettings$PbUserDeviceGeneralSettings == null ? UserDeviceSettings$PbUserDeviceGeneralSettings.getDefaultInstance() : userDeviceSettings$PbUserDeviceGeneralSettings;
    }

    public Types$PbSystemDateTime getLastModified() {
        Types$PbSystemDateTime types$PbSystemDateTime = this.lastModified_;
        return types$PbSystemDateTime == null ? Types$PbSystemDateTime.getDefaultInstance() : types$PbSystemDateTime;
    }

    public UserDeviceSettings$PbUsbConnectionSettings getUsbConnectionSettings() {
        UserDeviceSettings$PbUsbConnectionSettings userDeviceSettings$PbUsbConnectionSettings = this.usbConnectionSettings_;
        return userDeviceSettings$PbUsbConnectionSettings == null ? UserDeviceSettings$PbUsbConnectionSettings.getDefaultInstance() : userDeviceSettings$PbUsbConnectionSettings;
    }

    public boolean hasGeneralSettings() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasLastModified() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasUsbConnectionSettings() {
        return (this.bitField0_ & 4) != 0;
    }

    public static final class Builder extends GeneratedMessageLite.Builder<UserDeviceSettings$PbUserDeviceSettings, Builder> implements MessageLiteOrBuilder {
        private Builder() {
            super(UserDeviceSettings$PbUserDeviceSettings.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    public static Builder newBuilder(UserDeviceSettings$PbUserDeviceSettings userDeviceSettings$PbUserDeviceSettings) {
        return DEFAULT_INSTANCE.createBuilder(userDeviceSettings$PbUserDeviceSettings);
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseFrom(ByteString byteString) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseFrom(byte[] bArr) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseFrom(InputStream inputStream) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseFrom(CodedInputStream codedInputStream) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UserDeviceSettings$PbUserDeviceSettings parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (UserDeviceSettings$PbUserDeviceSettings) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
