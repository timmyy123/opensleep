package com.polar.services.datamodels.protobuf;

import com.google.protobuf.Internal;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public enum Types$SensorLocation implements Internal.EnumLite {
    SL_UNKNOWN(0),
    SL_DISTAL(1),
    SL_PROXIMAL(2),
    UNRECOGNIZED(-1);

    private static final Internal.EnumLiteMap<Types$SensorLocation> internalValueMap = new Internal.EnumLiteMap<Types$SensorLocation>() { // from class: com.polar.services.datamodels.protobuf.Types$SensorLocation.1
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public Types$SensorLocation findValueByNumber(int i) {
            return Types$SensorLocation.forNumber(i);
        }
    };
    private final int value;

    Types$SensorLocation(int i) {
        this.value = i;
    }

    public static Types$SensorLocation forNumber(int i) {
        if (i == 0) {
            return SL_UNKNOWN;
        }
        if (i == 1) {
            return SL_DISTAL;
        }
        if (i != 2) {
            return null;
        }
        return SL_PROXIMAL;
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
