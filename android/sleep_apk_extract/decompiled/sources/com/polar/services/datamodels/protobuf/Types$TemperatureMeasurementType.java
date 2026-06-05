package com.polar.services.datamodels.protobuf;

import com.google.protobuf.Internal;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public enum Types$TemperatureMeasurementType implements Internal.EnumLite {
    TM_UNKNOWN(0),
    TM_SKIN_TEMPERATURE(1),
    TM_CORE_TEMPERATURE(2),
    UNRECOGNIZED(-1);

    private static final Internal.EnumLiteMap<Types$TemperatureMeasurementType> internalValueMap = new Internal.EnumLiteMap<Types$TemperatureMeasurementType>() { // from class: com.polar.services.datamodels.protobuf.Types$TemperatureMeasurementType.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$TemperatureMeasurementType findValueByNumber(int i) {
            return Types$TemperatureMeasurementType.forNumber(i);
        }
    };
    private final int value;

    Types$TemperatureMeasurementType(int i) {
        this.value = i;
    }

    public static Types$TemperatureMeasurementType forNumber(int i) {
        if (i == 0) {
            return TM_UNKNOWN;
        }
        if (i == 1) {
            return TM_SKIN_TEMPERATURE;
        }
        if (i != 2) {
            return null;
        }
        return TM_CORE_TEMPERATURE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Can't get the number of an unknown enum value.");
        return 0;
    }
}
