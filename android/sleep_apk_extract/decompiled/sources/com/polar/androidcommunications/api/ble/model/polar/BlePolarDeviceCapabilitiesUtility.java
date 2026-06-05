package com.polar.androidcommunications.api.ble.model.polar;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/polar/BlePolarDeviceCapabilitiesUtility;", "", "Companion", "FileSystemType", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BlePolarDeviceCapabilitiesUtility {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/polar/BlePolarDeviceCapabilitiesUtility$Companion;", "", "<init>", "()V", "", "deviceType", "", "isRecordingSupported", "(Ljava/lang/String;)Z", "isFirmwareUpdateSupported", "isActivityDataSupported", "DEVICE_TYPE_360", "Ljava/lang/String;", "DEVICE_TYPE_GRIT_X2_PRO", "DEVICE_TYPE_H10", "DEVICE_TYPE_IGNITE_3", "DEVICE_TYPE_INW5T", "DEVICE_TYPE_OH1", "DEVICE_TYPE_SENSE", "DEVICE_TYPE_VANTAGE_V3", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final boolean isActivityDataSupported(String deviceType) {
            deviceType.getClass();
            Locale locale = Locale.getDefault();
            locale.getClass();
            String lowerCase = deviceType.toLowerCase(locale);
            lowerCase.getClass();
            switch (lowerCase.hashCode()) {
                case -2062670225:
                    if (!lowerCase.equals("Vantage V3")) {
                    }
                    break;
                case -1450535619:
                    if (!lowerCase.equals("Ignite 3")) {
                    }
                    break;
                case 50733:
                    if (!lowerCase.equals("360")) {
                    }
                    break;
                case 738069553:
                    if (!lowerCase.equals("Grit X2 Pro")) {
                    }
                    break;
                case 800409104:
                    if (!lowerCase.equals("polar_inw5t")) {
                    }
                    break;
            }
            return true;
        }

        public final boolean isFirmwareUpdateSupported(String deviceType) {
            deviceType.getClass();
            Locale locale = Locale.getDefault();
            locale.getClass();
            deviceType.toLowerCase(locale).getClass();
            return !Intrinsics.areEqual(r0, "oh1");
        }

        public final boolean isRecordingSupported(String deviceType) {
            deviceType.getClass();
            Locale locale = Locale.getDefault();
            locale.getClass();
            String lowerCase = deviceType.toLowerCase(locale);
            lowerCase.getClass();
            return Intrinsics.areEqual(lowerCase, "h10");
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/polar/BlePolarDeviceCapabilitiesUtility$FileSystemType;", "", "(Ljava/lang/String;I)V", "UNKNOWN_FILE_SYSTEM", "H10_FILE_SYSTEM", "SAGRFC2_FILE_SYSTEM", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FileSystemType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FileSystemType[] $VALUES;
        public static final FileSystemType UNKNOWN_FILE_SYSTEM = new FileSystemType("UNKNOWN_FILE_SYSTEM", 0);
        public static final FileSystemType H10_FILE_SYSTEM = new FileSystemType("H10_FILE_SYSTEM", 1);
        public static final FileSystemType SAGRFC2_FILE_SYSTEM = new FileSystemType("SAGRFC2_FILE_SYSTEM", 2);

        private static final /* synthetic */ FileSystemType[] $values() {
            return new FileSystemType[]{UNKNOWN_FILE_SYSTEM, H10_FILE_SYSTEM, SAGRFC2_FILE_SYSTEM};
        }

        static {
            FileSystemType[] fileSystemTypeArr$values = $values();
            $VALUES = fileSystemTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(fileSystemTypeArr$values);
        }

        private FileSystemType(String str, int i) {
        }

        public static FileSystemType valueOf(String str) {
            return (FileSystemType) Enum.valueOf(FileSystemType.class, str);
        }

        public static FileSystemType[] values() {
            return (FileSystemType[]) $VALUES.clone();
        }
    }
}
