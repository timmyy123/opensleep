package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbFeatureType implements Internal.EnumLite {
    FEATURE_TYPE_HEART_RATE(1),
    FEATURE_TYPE_RR_INTERVAL(2),
    FEATURE_TYPE_SPEED(3),
    FEATURE_TYPE_DISTANCE(4),
    FEATURE_TYPE_BIKE_CADENCE(5),
    FEATURE_TYPE_BIKE_POWER(6),
    FEATURE_TYPE_GPS_LOCATION(7),
    FEATURE_TYPE_RUNNING_CADENCE(8),
    FEATURE_TYPE_PRESS_TEMPERATURE(9),
    FEATURE_TYPE_ALTITUDE(10),
    FEATURE_TYPE_STEPS(11),
    FEATURE_TYPE_ACTIVITY(12),
    FEATURE_TYPE_STRIDE_LENGTH(13),
    FEATURE_TYPE_RSC_MOVING_TYPE(14),
    FEATURE_TYPE_JUMP_HEIGTH(15),
    FEATURE_TYPE_COMPASS_HEADING(16),
    FEATURE_TYPE_GPS_SPEED(17),
    FEATURE_TYPE_GPS_DISTANCE(18),
    FEATURE_TYPE_GPS_ALTITUDE(19),
    FEATURE_TYPE_BIKE_WHEEL_REVOLUTION(20),
    FEATURE_TYPE_BIKE_CRANK_REVOLUTION(21),
    FEATURE_TYPE_AS_SPEED(22),
    FEATURE_TYPE_AS_CADENCE(23),
    FEATURE_TYPE_AS_DISTANCE(24),
    FEATURE_TYPE_AS_SWR_STATE(25),
    FEATURE_TYPE_BATTERY_LEVEL(26),
    FEATURE_TYPE_FILE_TRANSFER(27),
    FEATURE_TYPE_PUSH_NOTIFICATIONS(28),
    FEATURE_TYPE_WEIGHT_SCALE(29),
    FEATURE_TYPE_REMOTE_BUTTONS(30),
    FEATURE_TYPE_GOPRO(31),
    FEATURE_TYPE_PP_INTERVAL(32),
    FEATURE_TYPE_MEDIA_CONTROL(33),
    FEATURE_TYPE_MOBILE_GPS(34),
    FEATURE_TYPE_RUNNING_POWER(35),
    FEATURE_TYPE_POLAR_SDK(36),
    FEATURE_TYPE_HEALTH_THERMOMETER_TEMPERATURE(37);

    private static final Internal.EnumLiteMap<Types$PbFeatureType> internalValueMap = new Internal.EnumLiteMap<Types$PbFeatureType>() { // from class: fi.polar.remote.representation.protobuf.Types$PbFeatureType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbFeatureType findValueByNumber(int i) {
            return Types$PbFeatureType.forNumber(i);
        }
    };
    private final int value;

    public static final class PbFeatureTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbFeatureTypeVerifier();

        private PbFeatureTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbFeatureType.forNumber(i) != null;
        }
    }

    Types$PbFeatureType(int i) {
        this.value = i;
    }

    public static Types$PbFeatureType forNumber(int i) {
        switch (i) {
            case 1:
                return FEATURE_TYPE_HEART_RATE;
            case 2:
                return FEATURE_TYPE_RR_INTERVAL;
            case 3:
                return FEATURE_TYPE_SPEED;
            case 4:
                return FEATURE_TYPE_DISTANCE;
            case 5:
                return FEATURE_TYPE_BIKE_CADENCE;
            case 6:
                return FEATURE_TYPE_BIKE_POWER;
            case 7:
                return FEATURE_TYPE_GPS_LOCATION;
            case 8:
                return FEATURE_TYPE_RUNNING_CADENCE;
            case 9:
                return FEATURE_TYPE_PRESS_TEMPERATURE;
            case 10:
                return FEATURE_TYPE_ALTITUDE;
            case 11:
                return FEATURE_TYPE_STEPS;
            case 12:
                return FEATURE_TYPE_ACTIVITY;
            case 13:
                return FEATURE_TYPE_STRIDE_LENGTH;
            case 14:
                return FEATURE_TYPE_RSC_MOVING_TYPE;
            case 15:
                return FEATURE_TYPE_JUMP_HEIGTH;
            case 16:
                return FEATURE_TYPE_COMPASS_HEADING;
            case 17:
                return FEATURE_TYPE_GPS_SPEED;
            case 18:
                return FEATURE_TYPE_GPS_DISTANCE;
            case 19:
                return FEATURE_TYPE_GPS_ALTITUDE;
            case 20:
                return FEATURE_TYPE_BIKE_WHEEL_REVOLUTION;
            case 21:
                return FEATURE_TYPE_BIKE_CRANK_REVOLUTION;
            case 22:
                return FEATURE_TYPE_AS_SPEED;
            case 23:
                return FEATURE_TYPE_AS_CADENCE;
            case 24:
                return FEATURE_TYPE_AS_DISTANCE;
            case 25:
                return FEATURE_TYPE_AS_SWR_STATE;
            case 26:
                return FEATURE_TYPE_BATTERY_LEVEL;
            case 27:
                return FEATURE_TYPE_FILE_TRANSFER;
            case 28:
                return FEATURE_TYPE_PUSH_NOTIFICATIONS;
            case 29:
                return FEATURE_TYPE_WEIGHT_SCALE;
            case 30:
                return FEATURE_TYPE_REMOTE_BUTTONS;
            case 31:
                return FEATURE_TYPE_GOPRO;
            case 32:
                return FEATURE_TYPE_PP_INTERVAL;
            case 33:
                return FEATURE_TYPE_MEDIA_CONTROL;
            case 34:
                return FEATURE_TYPE_MOBILE_GPS;
            case 35:
                return FEATURE_TYPE_RUNNING_POWER;
            case 36:
                return FEATURE_TYPE_POLAR_SDK;
            case 37:
                return FEATURE_TYPE_HEALTH_THERMOMETER_TEMPERATURE;
            default:
                return null;
        }
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbFeatureTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
