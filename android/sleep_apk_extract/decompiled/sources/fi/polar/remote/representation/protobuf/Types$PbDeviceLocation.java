package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbDeviceLocation implements Internal.EnumLite {
    DEVICE_LOCATION_UNDEFINED(0),
    DEVICE_LOCATION_OTHER(1),
    DEVICE_LOCATION_WRIST_LEFT(2),
    DEVICE_LOCATION_WRIST_RIGHT(3),
    DEVICE_LOCATION_NECKLACE(4),
    DEVICE_LOCATION_CHEST(5),
    DEVICE_LOCATION_UPPER_BACK(6),
    DEVICE_LOCATION_FOOT_LEFT(7),
    DEVICE_LOCATION_FOOT_RIGHT(8),
    DEVICE_LOCATION_LOWER_ARM_LEFT(9),
    DEVICE_LOCATION_LOWER_ARM_RIGHT(10),
    DEVICE_LOCATION_UPPER_ARM_LEFT(11),
    DEVICE_LOCATION_UPPER_ARM_RIGHT(12),
    DEVICE_LOCATION_BIKE_MOUNT(13);

    private static final Internal.EnumLiteMap<Types$PbDeviceLocation> internalValueMap = new Internal.EnumLiteMap<Types$PbDeviceLocation>() { // from class: fi.polar.remote.representation.protobuf.Types$PbDeviceLocation.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbDeviceLocation findValueByNumber(int i) {
            return Types$PbDeviceLocation.forNumber(i);
        }
    };
    private final int value;

    public static final class PbDeviceLocationVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbDeviceLocationVerifier();

        private PbDeviceLocationVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbDeviceLocation.forNumber(i) != null;
        }
    }

    Types$PbDeviceLocation(int i) {
        this.value = i;
    }

    public static Types$PbDeviceLocation forNumber(int i) {
        switch (i) {
            case 0:
                return DEVICE_LOCATION_UNDEFINED;
            case 1:
                return DEVICE_LOCATION_OTHER;
            case 2:
                return DEVICE_LOCATION_WRIST_LEFT;
            case 3:
                return DEVICE_LOCATION_WRIST_RIGHT;
            case 4:
                return DEVICE_LOCATION_NECKLACE;
            case 5:
                return DEVICE_LOCATION_CHEST;
            case 6:
                return DEVICE_LOCATION_UPPER_BACK;
            case 7:
                return DEVICE_LOCATION_FOOT_LEFT;
            case 8:
                return DEVICE_LOCATION_FOOT_RIGHT;
            case 9:
                return DEVICE_LOCATION_LOWER_ARM_LEFT;
            case 10:
                return DEVICE_LOCATION_LOWER_ARM_RIGHT;
            case 11:
                return DEVICE_LOCATION_UPPER_ARM_LEFT;
            case 12:
                return DEVICE_LOCATION_UPPER_ARM_RIGHT;
            case 13:
                return DEVICE_LOCATION_BIKE_MOUNT;
            default:
                return null;
        }
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbDeviceLocationVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
