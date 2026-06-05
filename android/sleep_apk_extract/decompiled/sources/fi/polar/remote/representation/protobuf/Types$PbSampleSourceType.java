package fi.polar.remote.representation.protobuf;

import com.google.protobuf.Internal;

/* JADX INFO: loaded from: classes5.dex */
public enum Types$PbSampleSourceType implements Internal.EnumLite {
    SAMPLE_SOURCE_TYPE_UNDEFINED(0),
    SAMPLE_SOURCE_TYPE_OFFLINE(1),
    SAMPLE_SOURCE_TYPE_HEART_RATE(2),
    SAMPLE_SOURCE_TYPE_HEART_RATE_BLE(3),
    SAMPLE_SOURCE_TYPE_HEART_RATE_5_KHZ(4),
    SAMPLE_SOURCE_TYPE_HEART_RATE_OPTICAL(5),
    SAMPLE_SOURCE_TYPE_GPS(6),
    SAMPLE_SOURCE_TYPE_STRIDE(7),
    SAMPLE_SOURCE_TYPE_WRIST_METRICS(8),
    SAMPLE_SOURCE_TYPE_CHEST_METRICS(9),
    SAMPLE_SOURCE_TYPE_BIKE_PEDAL(10),
    SAMPLE_SOURCE_TYPE_BIKE_WHEEL(11),
    SAMPLE_SOURCE_TYPE_BIKE_CRANK(12),
    SAMPLE_SOURCE_TYPE_COMBINED_CHEST_METRICS_AND_GPS(13),
    SAMPLE_SOURCE_TYPE_UPPER_BACK_METRICS(14),
    SAMPLE_SOURCE_TYPE_COMBINED_UPPER_BACK_METRICS_AND_GPS(15);

    private static final Internal.EnumLiteMap<Types$PbSampleSourceType> internalValueMap = new Internal.EnumLiteMap<Types$PbSampleSourceType>() { // from class: fi.polar.remote.representation.protobuf.Types$PbSampleSourceType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$PbSampleSourceType findValueByNumber(int i) {
            return Types$PbSampleSourceType.forNumber(i);
        }
    };
    private final int value;

    public static final class PbSampleSourceTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new PbSampleSourceTypeVerifier();

        private PbSampleSourceTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return Types$PbSampleSourceType.forNumber(i) != null;
        }
    }

    Types$PbSampleSourceType(int i) {
        this.value = i;
    }

    public static Types$PbSampleSourceType forNumber(int i) {
        switch (i) {
            case 0:
                return SAMPLE_SOURCE_TYPE_UNDEFINED;
            case 1:
                return SAMPLE_SOURCE_TYPE_OFFLINE;
            case 2:
                return SAMPLE_SOURCE_TYPE_HEART_RATE;
            case 3:
                return SAMPLE_SOURCE_TYPE_HEART_RATE_BLE;
            case 4:
                return SAMPLE_SOURCE_TYPE_HEART_RATE_5_KHZ;
            case 5:
                return SAMPLE_SOURCE_TYPE_HEART_RATE_OPTICAL;
            case 6:
                return SAMPLE_SOURCE_TYPE_GPS;
            case 7:
                return SAMPLE_SOURCE_TYPE_STRIDE;
            case 8:
                return SAMPLE_SOURCE_TYPE_WRIST_METRICS;
            case 9:
                return SAMPLE_SOURCE_TYPE_CHEST_METRICS;
            case 10:
                return SAMPLE_SOURCE_TYPE_BIKE_PEDAL;
            case 11:
                return SAMPLE_SOURCE_TYPE_BIKE_WHEEL;
            case 12:
                return SAMPLE_SOURCE_TYPE_BIKE_CRANK;
            case 13:
                return SAMPLE_SOURCE_TYPE_COMBINED_CHEST_METRICS_AND_GPS;
            case 14:
                return SAMPLE_SOURCE_TYPE_UPPER_BACK_METRICS;
            case 15:
                return SAMPLE_SOURCE_TYPE_COMBINED_UPPER_BACK_METRICS_AND_GPS;
            default:
                return null;
        }
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return PbSampleSourceTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }
}
