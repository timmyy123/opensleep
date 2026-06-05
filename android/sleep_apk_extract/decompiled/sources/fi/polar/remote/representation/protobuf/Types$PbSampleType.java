package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbSampleType implements Internal.EnumLite {
    SAMPLE_TYPE_UNDEFINED(0),
    SAMPLE_TYPE_HEART_RATE(1),
    SAMPLE_TYPE_CADENCE(2),
    SAMPLE_TYPE_ALTITUDE(3),
    SAMPLE_TYPE_ALTITUDE_CALIBRATION(4),
    SAMPLE_TYPE_TEMPERATURE(5),
    SAMPLE_TYPE_SPEED(6),
    SAMPLE_TYPE_DISTANCE(7),
    SAMPLE_TYPE_STRIDE_LENGTH(8),
    SAMPLE_TYPE_STRIDE_CALIBRATION(9),
    SAMPLE_TYPE_FORWARD_ACCELERATION(10),
    SAMPLE_TYPE_MOVING_TYPE(11),
    SAMPLE_TYPE_LEFT_PEDAL_POWER(12),
    SAMPLE_TYPE_RIGHT_PEDAL_POWER(13),
    SAMPLE_TYPE_LEFT_PEDAL_POWER_CALIBRATION(14),
    SAMPLE_TYPE_RIGHT_PEDAL_POWER_CALIBRATION(15),
    SAMPLE_TYPE_RR_INTERVAL(16),
    SAMPLE_TYPE_ACCELERATION_MAD(17);

    private static final Internal.EnumLiteMap<Types$PbSampleType> internalValueMap = new Internal.EnumLiteMap<Types$PbSampleType>() { // from class: fi.polar.remote.representation.protobuf.Types$PbSampleType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbSampleType findValueByNumber(int i) {
            return Types$PbSampleType.forNumber(i);
        }
    };
    private final int value;

    public static final class PbSampleTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbSampleTypeVerifier();

        private PbSampleTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbSampleType.forNumber(i) != null;
        }
    }

    Types$PbSampleType(int i) {
        this.value = i;
    }

    public static Types$PbSampleType forNumber(int i) {
        switch (i) {
            case 0:
                return SAMPLE_TYPE_UNDEFINED;
            case 1:
                return SAMPLE_TYPE_HEART_RATE;
            case 2:
                return SAMPLE_TYPE_CADENCE;
            case 3:
                return SAMPLE_TYPE_ALTITUDE;
            case 4:
                return SAMPLE_TYPE_ALTITUDE_CALIBRATION;
            case 5:
                return SAMPLE_TYPE_TEMPERATURE;
            case 6:
                return SAMPLE_TYPE_SPEED;
            case 7:
                return SAMPLE_TYPE_DISTANCE;
            case 8:
                return SAMPLE_TYPE_STRIDE_LENGTH;
            case 9:
                return SAMPLE_TYPE_STRIDE_CALIBRATION;
            case 10:
                return SAMPLE_TYPE_FORWARD_ACCELERATION;
            case 11:
                return SAMPLE_TYPE_MOVING_TYPE;
            case 12:
                return SAMPLE_TYPE_LEFT_PEDAL_POWER;
            case 13:
                return SAMPLE_TYPE_RIGHT_PEDAL_POWER;
            case 14:
                return SAMPLE_TYPE_LEFT_PEDAL_POWER_CALIBRATION;
            case 15:
                return SAMPLE_TYPE_RIGHT_PEDAL_POWER_CALIBRATION;
            case 16:
                return SAMPLE_TYPE_RR_INTERVAL;
            case 17:
                return SAMPLE_TYPE_ACCELERATION_MAD;
            default:
                return null;
        }
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbSampleTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
